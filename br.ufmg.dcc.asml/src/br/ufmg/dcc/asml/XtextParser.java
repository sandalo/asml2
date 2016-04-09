package br.ufmg.dcc.asml;

import java.io.IOException;
import java.io.InputStream;

import javax.management.RuntimeErrorException;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.linking.lazy.LazyLinkingResource;
import org.eclipse.xtext.resource.XtextResource;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

public class XtextParser {

	@Inject
	private ASMLXtextResourceSet resourceSet;

	public XtextParser() {
		setupParser();
	}

	private void setupParser() {
		new org.eclipse.emf.mwe.utils.StandaloneSetup().setScanClassPath(true);
		Injector injector = Guice.createInjector(new ASMLModelRuntimeModule());
		injector.injectMembers(this);
		resourceSet.addLoadOption(XtextResource.OPTION_RESOLVE_ALL, Boolean.TRUE);
	}

	/**
	 * Parses an input stream and returns the resulting object tree root
	 * element.
	 * 
	 * @param in
	 *            Input Stream
	 * @return Root model object
	 * @throws IOException
	 *             When and I/O related parser error occurs
	 */
	public EObject parse(InputStream in) throws IOException {
		Resource resource = resourceSet.createResource(URI.createURI("dummy:/inmemory.ext"));
		resource.load(in, resourceSet.getLoadOptions());
		return resource.getContents().get(0);
	}

	/**
	 * Parses a resource specified by an URI and returns the resulting object
	 * tree root element.
	 * 
	 * @param uri
	 *            URI of resource to be parsed
	 * @return Root model object
	 * @throws IOException 
	 */
	public void addAllResourcesImported(Resource resource, String path ) {
		//path = "jar:file:/C:/Prodemge/maven/.m2/repository/br/ufmg/asml/vaccine-dominio/0.0.2-SNAPSHOT/vaccine-dominio-0.0.2-SNAPSHOT.jar!/vaccine.asml";
		try {
			URI createURI = URI.createURI(path);
			LazyLinkingResource resourceExterno = (LazyLinkingResource) resourceSet.getResource(createURI, true,false);
			resourceExterno.load(resourceSet.getLoadOptions());
			EList<EObject> contents = resourceExterno.getContents();
			resource.getContents().addAll(contents);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Parses a resource specified by an URI and returns the resulting object
	 * tree root element.
	 * 
	 * @param uri
	 *            URI of resource to be parsed
	 * @return Root model object
	 * @throws IOException 
	 */
	public void addAllResourcesImported(int index,Resource resource, String path ) {
		//path = "jar:file:/C:/Prodemge/maven/.m2/repository/br/ufmg/asml/vaccine-dominio/0.0.2-SNAPSHOT/vaccine-dominio-0.0.2-SNAPSHOT.jar!/vaccine.asml";
		try {
			URI createURI = URI.createURI(path);
			LazyLinkingResource resourceExterno = (LazyLinkingResource) resourceSet.getResource(createURI, true,false);
			resourceExterno.load(resourceSet.getLoadOptions());
			EList<EObject> contents = resourceExterno.getContents();
			resource.getContents().addAll(index,contents);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	/**
	 * Parses a resource specified by an URI and returns the resulting object
	 * tree root element.
	 * 
	 * @param uri
	 *            URI of resource to be parsed
	 * @return Root model object
	 * @throws IOException 
	 */
	public Resource getResource(URI uri) {
		Resource resource = resourceSet.getResource(uri, true);
		return resource;
	}
	
	/**
	 * Parses a resource specified by an URI and returns the resulting object
	 * tree root element.
	 * 
	 * @param uri
	 *            URI of resource to be parsed
	 * @return Root model object
	 * @throws IOException 
	 */
	public Resource getResource(String path) {
		URI uri = URI.createURI(path);
		try {
			Resource resource = resourceSet.getResource(uri, true,false);
			return resource;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}