package br.mg.prodemge.prodigio.wizard.curso;

import java.net.URI;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.dialogs.WizardNewProjectCreationPage;

import br.mg.prodemge.prodigio.wizard.ThreadProjectCreation;
import br.mg.prodemge.prodigio.wizard.novoprojeto.ProdigioNovoProjetoPageWizard;


public class ProdigioCursoWizard extends Wizard implements INewWizard {
	
	private static final String FROM_SCRATCH_PROJECT_WIZARD = "Assistente proddígio";
	private static final String FROM_SCRATCH_PROJECT = "Assistente proddígio";
	private static final String CREATE_SOMETHING_FROM_SCRATCH = "Assistente proddígio.";
	private static final String WIZARD_NAME = "Assistente proddígio";
	private WizardNewProjectCreationPage _pageOne;

	public ProdigioCursoWizard() {
	    setWindowTitle(WIZARD_NAME);
	}

	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean performFinish() {
	    String name = _pageOne.getProjectName();
	    URI location = null;
	    if (!_pageOne.useDefaults()) {
	        location = _pageOne.getLocationURI();
	    } // else location == null
		ThreadProjectCreation threadProjectCreation = new ThreadProjectCreation(name, location,"/templates/");
		threadProjectCreation.schedule();
	 
		return true;
	}

	@Override
	public void addPages() {
	    super.addPages();
	 
	    _pageOne = new ProdigioNovoProjetoPageWizard(FROM_SCRATCH_PROJECT_WIZARD);
	    _pageOne.setTitle(FROM_SCRATCH_PROJECT);
	    _pageOne.setDescription(CREATE_SOMETHING_FROM_SCRATCH);
	 
	    addPage(_pageOne);
	}
	
}
