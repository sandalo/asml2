package asmlbuilder.view.properties;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.LineNumberReader;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.ProgressBar;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbenchPropertyPage;
import org.eclipse.ui.dialogs.PropertyPage;

import asmlbuilder.Activator;
import asmlbuilder.builder.ASMLContext;
import br.ufmg.dcc.asml.aSMLModel.ASMLModel;

public class WorkbenchPropertyASML extends PropertyPage implements IWorkbenchPropertyPage {

	private static final String TITLE = "Informations:";

	/**
	 * Constructor for SamplePropertyPage.
	 */
	public WorkbenchPropertyASML() {
		super();
	}

	private void addFirstSection(Composite parent) {
		Composite composite = createDefaultComposite(parent);

		// Label for path field
		Label pathLabel = new Label(composite, SWT.NONE);
		pathLabel.setText(TITLE);

		// Path text field
		Text pathValueText = new Text(composite, SWT.WRAP | SWT.READ_ONLY);
		pathValueText.setText(((IResource) getElement()).getFullPath().toString());
	}

	private void addSeparator(Composite parent) {
		Label separator = new Label(parent, SWT.SEPARATOR | SWT.HORIZONTAL);
		GridData gridData = new GridData();
		gridData.horizontalAlignment = GridData.FILL;
		gridData.grabExcessHorizontalSpace = true;
		separator.setLayoutData(gridData);
	}

	private void addSecondSection(Composite parent) {
		Composite composite = createDefaultComposite(parent);

		/*
		 * // Label for owner field Label ownerLabel = new Label(composite,
		 * SWT.NONE); ownerLabel.setText(OWNER_TITLE);
		 * 
		 * // Owner text field ownerText = new Text(composite, SWT.SINGLE |
		 * SWT.BORDER); GridData gd = new GridData(); gd.widthHint =
		 * convertWidthInCharsToPixels(TEXT_FIELD_WIDTH);
		 * ownerText.setLayoutData(gd);
		 * 
		 * // Populate owner text field try { String owner = ((IResource)
		 * getElement()).getPersistentProperty( new QualifiedName("",
		 * OWNER_PROPERTY)); ownerText.setText((owner != null) ? owner :
		 * DEFAULT_OWNER); } catch (CoreException e) {
		 * ownerText.setText(DEFAULT_OWNER); }
		 */

		IAdaptable element = getElement();
		if (element instanceof IProject) {
			IProject project = (IProject) element;
			ASMLContext asmlContext = Activator.getAsmlProcessor().getAsmlContext();
			ASMLModel asmlModel = asmlContext.getAsmlModel(project);
			try {
				IResource[] members = project.members();
				EList<String> ignores = asmlModel.getIgnore();

				float allMembers = 0;
				float ignoredMembers = 0;
				float formalizedArtifacts = 0;
				

				
				allMembers = contMembers(members, false);
				ignoredMembers = contIgnoredMembers(members, ignores);
				formalizedArtifacts = allMembers - ignoredMembers;
				float formality = (formalizedArtifacts / allMembers) * 100;
				ProgressBar progressFormalityArtifact = new ProgressBar(composite, SWT.NULL);
				progressFormalityArtifact.setSelection((int) formality);
				progressFormalityArtifact.setBounds(100, 10, 200, 20);
				Label labelFormalityArtifact = new Label(composite, SWT.NULL);
				labelFormalityArtifact.setText("(degree of formality (artifact) = " + ((int) formality) + "%)");
				labelFormalityArtifact.setAlignment(SWT.RIGHT);
				labelFormalityArtifact.setBounds(10, 10, 80, 20);
				
				float allLines = contLines(members, false);
				float ignoredLines = contIgnoredLines(members, ignores);
				float formalizedLines = allLines - ignoredLines;
				formality = (formalizedLines/allLines)*100;
				
				ProgressBar progressLineArtifact = new ProgressBar(composite, SWT.NULL);
				progressLineArtifact.setSelection((int) formality);
				progressLineArtifact.setBounds(100, 10, 200, 20);
				Label labelLineArtifact = new Label(composite, SWT.NULL);
				labelLineArtifact.setText("(degree of formality (lines) = " + ((int) formality) + "%)");
				labelLineArtifact.setAlignment(SWT.RIGHT);
				labelLineArtifact.setBounds(10, 10, 80, 20);

				
				
			} catch (CoreException e) {
				throw new RuntimeException(e);
			}
		}
	}

	private int contIgnoredMembers(IResource[] members, EList<String> ignores) {
		int cont = 0;
		for (IResource member : members) {
			if (member.getName().equals("target"))
				continue;
			boolean containsSimples = ignores.contains(member.getName());
			boolean containsDeep = ignores.contains(member.getName() + "*");
			if (containsSimples || containsDeep) {
				cont++;
				System.out.println(member.getName());
				if (member instanceof IContainer) {
					IResource[] members2;
					try {
						members2 = ((IContainer) member).members();
						if (containsDeep)
							cont = contMembers(members2, true) + cont;
						else
							cont = contIgnoredMembers(members2, ignores) + cont;
					} catch (CoreException e) {
						e.printStackTrace();
					}
				}
			} else {
				if (member instanceof IContainer) {
					IResource[] members2;
					try {
						members2 = ((IContainer) member).members();
						cont = contIgnoredMembers(members2, ignores) + cont;
					} catch (CoreException e) {
						e.printStackTrace();
					}
				}
			}
		}
		return cont;
	}

	private int contMembers(IResource[] members, boolean print) {
		int cont = 0;
		for (IResource member : members) {
			if (member.getName().equals("target"))
				continue;
			cont++;
			if (print) {
				System.out.println(member.getName());
			}
			if (member instanceof IContainer) {
				IResource[] members2;
				try {
					members2 = ((IContainer) member).members();
					cont = contMembers(members2, print) + cont;
				} catch (CoreException e) {
					e.printStackTrace();
				}
			}
		}
		return cont;
	}

	private int contIgnoredLines(IResource[] members, EList<String> ignores) {
		int numLines = 0;
		for (IResource member : members) {
			if (member.getName().equals("target"))
				continue;
			boolean containsSimples = ignores.contains(member.getName());
			boolean containsDeep = ignores.contains(member.getName() + "*");
			if (containsSimples || containsDeep) {
				if (member instanceof IContainer) {
					IResource[] members2;
					try {
						members2 = ((IContainer) member).members();
						if (containsDeep)
							numLines = contLines(members2, true) + numLines;
						else
							numLines = contIgnoredLines(members2, ignores) + numLines;
					} catch (CoreException e) {
						e.printStackTrace();
					}
				} else {
					if (member instanceof IFile) {
						try {
							IFile file = (IFile) member;
							File fileIO = file.getLocation().toFile();
							FileReader fr = null;
							LineNumberReader lnr = null;
							fr = new FileReader(fileIO);
							lnr = new LineNumberReader(fr);
							lnr.skip(Long.MAX_VALUE);
							numLines = numLines + (lnr.getLineNumber() + 1);
							lnr.close();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
			} else {
				if (member instanceof IContainer) {
					IResource[] members2;
					try {
						members2 = ((IContainer) member).members();
						numLines = contIgnoredLines(members2, ignores) + numLines;
					} catch (CoreException e) {
						e.printStackTrace();
					}
				}
			}
		}
		return numLines;
	}

	private int contLines(IResource[] members, boolean print) {
		int numLines = 0;
		for (IResource member : members) {
			if (member.getName().equals("target"))
				continue;
			if (member instanceof IContainer) {
				IResource[] members2;
				try {
					members2 = ((IContainer) member).members();
					numLines = contLines(members2, print) + numLines;
				} catch (CoreException e) {
					e.printStackTrace();
				}
			} else {
				if (member instanceof IFile) {
					try {
						IFile file = (IFile) member;
						File fileIO = file.getLocation().toFile();
						FileReader fr = null;
						LineNumberReader lnr = null;
						fr = new FileReader(fileIO);
						lnr = new LineNumberReader(fr);
						lnr.skip(Long.MAX_VALUE);
						numLines = numLines + (lnr.getLineNumber() + 1);
						lnr.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
		return numLines;
	}

	/**
	 * @see PreferencePage#createContents(Composite)
	 */
	protected Control createContents(Composite parent) {
		Composite composite = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout();
		composite.setLayout(layout);
		GridData data = new GridData(GridData.FILL);
		data.grabExcessHorizontalSpace = true;
		composite.setLayoutData(data);

		addFirstSection(composite);
		addSeparator(composite);
		addSecondSection(composite);
		return composite;
	}

	private Composite createDefaultComposite(Composite parent) {
		Composite composite = new Composite(parent, SWT.NULL);
		GridLayout layout = new GridLayout();
		layout.numColumns = 2;
		composite.setLayout(layout);

		GridData data = new GridData();
		data.verticalAlignment = GridData.FILL;
		data.horizontalAlignment = GridData.FILL;
		composite.setLayoutData(data);

		return composite;
	}

	protected void performDefaults() {
		super.performDefaults();
	}

	public boolean performOk() {
		return true;
	}

}
