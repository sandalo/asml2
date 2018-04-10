package persistencebuild.builder;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jdt.core.IAnnotation;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

public class PersitenceBuilder extends IncrementalProjectBuilder {

	class SampleDeltaVisitor implements IResourceDeltaVisitor {
		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * org.eclipse.core.resources.IResourceDeltaVisitor#visit(org.eclipse
		 * .core.resources.IResourceDelta)
		 */
		public boolean visit(IResourceDelta delta) throws CoreException {
			IResource resource = delta.getResource();
			if (resource instanceof IFile) {
				IFile file = (IFile) resource;
				if (file.getFileExtension().equals("java")) {
					switch (delta.getKind()) {
					case IResourceDelta.ADDED:
						// handle added resource
						update(resource);
						break;
					case IResourceDelta.REMOVED:
						update(resource);
						break;
					case IResourceDelta.CHANGED:
						// handle changed resource
						update(resource);
						break;
					}
				}
			}
			return true;
		}
	}

	class SampleResourceVisitor implements IResourceVisitor {
		public boolean visit(IResource resource) {
			checkXML(resource);
			// return true to continue visiting children.
			return true;
		}
	}

	class XMLErrorHandler extends DefaultHandler {

		private IFile file;

		public XMLErrorHandler(IFile file) {
			this.file = file;
		}

		private void addMarker(SAXParseException e, int severity) {
			PersitenceBuilder.this.addMarker(file, e.getMessage(), e.getLineNumber(), severity);
		}

		public void error(SAXParseException exception) throws SAXException {
			addMarker(exception, IMarker.SEVERITY_ERROR);
		}

		public void fatalError(SAXParseException exception) throws SAXException {
			addMarker(exception, IMarker.SEVERITY_ERROR);
		}

		public void warning(SAXParseException exception) throws SAXException {
			addMarker(exception, IMarker.SEVERITY_WARNING);
		}
	}

	public static final String BUILDER_ID = "persistence-build.persitenceBuilder";

	private static final String MARKER_TYPE = "persistence-build.xmlProblem";

	private SAXParserFactory parserFactory;

	private void addMarker(IFile file, String message, int lineNumber, int severity) {
		try {
			IMarker marker = file.createMarker(MARKER_TYPE);
			marker.setAttribute(IMarker.MESSAGE, message);
			marker.setAttribute(IMarker.SEVERITY, severity);
			if (lineNumber == -1) {
				lineNumber = 1;
			}
			marker.setAttribute(IMarker.LINE_NUMBER, lineNumber);
		} catch (CoreException e) {
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.internal.events.InternalBuilder#build(int,
	 * java.util.Map, org.eclipse.core.runtime.IProgressMonitor)
	 */
	protected IProject[] build(int kind, Map args, IProgressMonitor monitor) throws CoreException {
		if (kind == FULL_BUILD) {
			fullBuild(monitor);
		} else {
			IResourceDelta delta = getDelta(getProject());
			if (delta == null) {
				fullBuild(monitor);
			} else {
				incrementalBuild(delta, monitor);
			}
		}
		return null;
	}

	protected void clean(IProgressMonitor monitor) throws CoreException {
		// delete markers set and files created
		getProject().deleteMarkers(MARKER_TYPE, true, IResource.DEPTH_INFINITE);
	}

	void checkXML(IResource resource) {

	}

	private void deleteMarkers(IFile file) {
		try {
			file.deleteMarkers(MARKER_TYPE, false, IResource.DEPTH_ZERO);
		} catch (CoreException ce) {
		}
	}

	protected void fullBuild(final IProgressMonitor monitor) throws CoreException {
		try {
			getProject().accept(new SampleResourceVisitor());
		} catch (CoreException e) {
		}
	}

	private SAXParser getParser() throws ParserConfigurationException, SAXException {
		if (parserFactory == null) {
			parserFactory = SAXParserFactory.newInstance();
		}
		return parserFactory.newSAXParser();
	}

	protected void incrementalBuild(IResourceDelta delta, IProgressMonitor monitor) throws CoreException {
		// the visitor does the work.
		delta.accept(new SampleDeltaVisitor());
	}

	public static void update(IResource resource) {

		try {

			final IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
			final String backend_project = resource.getProject().getName().replaceAll("domain", "backend");
			final IProject project = root.getProject(backend_project);
			final IResource persistence = project.findMember("/src/main/resources/META-INF/persistence.xml");

			ICompilationUnit element = (ICompilationUnit) JavaCore.create(resource);
			final IType iType = element.getAllTypes()[0];

			final IAnnotation[] annotations = iType.getAnnotations();

			final String nomeClasse = iType.getFullyQualifiedName();
			if (annotations.length == 0)
				removeTagClass((IFile) persistence, new File(persistence.getLocation().toString()), nomeClasse);
			else
				addTagClass((IFile) persistence, new File(persistence.getLocation().toString()), nomeClasse);


		} catch (JavaModelException e) {
			e.printStackTrace();
		}
	}

	public static void removeTagClass(IFile ifile, File fileTemplate, String nomeClass) {
		BufferedReader buff = null;
		ByteArrayOutputStream bao = null;
		try {
			InputStream in = new FileInputStream(fileTemplate);
			buff = new BufferedReader(new InputStreamReader(in, "UTF-8"));
			bao = new ByteArrayOutputStream();
			String bytesRead = "";
			while ((bytesRead = buff.readLine()) != null) {
				if (bytesRead.contains(nomeClass)) {
					continue;
				}
				String quebra = "\n";
				bao.write(bytesRead.getBytes(Charset.forName("UTF-8")));
				bao.write(quebra.getBytes(Charset.forName("UTF-8")));
			}
			InputStream inputStream = new ByteArrayInputStream(bao.toByteArray());
			if (!ifile.exists()) {
				ifile.getParent().exists();
				ifile.create(inputStream, true, null);
			} else {
				ifile.setContents(inputStream, IResource.FORCE, null);
			}
			buff.close();
			bao.close();
			in.close();
		} catch (Exception e) {
			try {
				buff.close();
				bao.close();
			} catch (IOException e1) {
				throw new RuntimeException("Erro ao criar estutura do projeto ou pasta ", e1);
			}
		}
	}

	public static void addTagClass(IFile ifile, File fileTemplate, String nomeClass) {
		BufferedReader buff = null;
		BufferedReader buff2 = null;
		BufferedReader buff3 = null;
		ByteArrayOutputStream bao = null;
		try {
			InputStream in = new FileInputStream(fileTemplate);
			InputStream in2 = new FileInputStream(fileTemplate);
			InputStream in3 = new FileInputStream(fileTemplate);
			buff = new BufferedReader(new InputStreamReader(in, "UTF-8"));
			buff2 = new BufferedReader(new InputStreamReader(in2, "UTF-8"));
			buff3 = new BufferedReader(new InputStreamReader(in3, "UTF-8"));
			bao = new ByteArrayOutputStream();
			String bytesRead = "";
			boolean jaExiste = false;
			int contTag = 0;
			while ((bytesRead = buff.readLine()) != null) {
				if (bytesRead.contains(nomeClass)) {
					jaExiste = true;
				}
				if (bytesRead.contains("</class>")) {
					contTag++;
				}
			}
			if (jaExiste)
				return;
			
			
			if(contTag==0){
				while ((bytesRead = buff3.readLine()) != null) {
					contTag++;
					if (bytesRead.contains("</non-jta-data-source>")) {
						break;
					}
				}
			}

			int contTag2 = 0;
			String quebra = "\n";
			while ((bytesRead = buff2.readLine()) != null) {
				bao.write(bytesRead.getBytes(Charset.forName("UTF-8")));
				bao.write(quebra.getBytes(Charset.forName("UTF-8")));
				contTag2++;
				if (contTag2 == contTag) {
					String novaTag = "        <class>" + nomeClass + "</class>";
					bao.write(novaTag.getBytes(Charset.forName("UTF-8")));
					bao.write(quebra.getBytes(Charset.forName("UTF-8")));
				}

			}
			InputStream inputStream = new ByteArrayInputStream(bao.toByteArray());
			if (!ifile.exists()) {
				ifile.getParent().exists();
				ifile.create(inputStream, true, null);
			} else {
				ifile.setContents(inputStream, IResource.FORCE, null);
			}
			buff.close();
			buff2.close();
			buff3.close();
			bao.close();
			in.close();
			in2.close();
			in3.close();
		} catch (Exception e) {
			try {
				buff.close();
				buff2.close();
				buff3.close();
				bao.close();
			} catch (IOException e1) {
				throw new RuntimeException("Erro ao criar estutura do projeto ou pasta ", e1);
			}
		}
	}

}
