package br.mg.prodemge.prodigio.wizard;

import java.net.URI;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;


public class ThreadProjectCreation extends Job {

	private String templateType;
	private String name;
	private URI location;

	public ThreadProjectCreation(String name, URI location, String templateType) {
		super("Criando projeto proddigio...");
		this.name = name;
		this.location = location;
		this.templateType = templateType;
	}

	@Override
	protected IStatus run(IProgressMonitor monitor) {
	    ProdigioWizardHelper.createProject(name, location, templateType, monitor);
		return Status.OK_STATUS;
	}
}