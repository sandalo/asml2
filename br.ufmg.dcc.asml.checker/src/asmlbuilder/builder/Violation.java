package asmlbuilder.builder;

import org.eclipse.core.resources.IResource;

import br.ufmg.dcc.asml.ComponentInstanceReference;

public class Violation {
	IResource resource = null;
	String message;
	int lineNumber;
	int severity;
	ComponentInstanceReference componentInstanceReference;

	public Violation(IResource resource, String message, int lineNumber, int severity) {
		this.resource=resource;
		this.message=message;
		this.lineNumber=lineNumber;
		this.severity=severity;
	}
	
	public Violation(ComponentInstanceReference componentInstanceReference, IResource resource, String message, int lineNumber, int severity) {
		this.resource=resource;
		this.message=message;
		this.lineNumber=lineNumber;
		this.severity=severity;
		this.componentInstanceReference = componentInstanceReference;
	}


	public ComponentInstanceReference getComponentInstanceReference() {
		return componentInstanceReference;
	}

	public IResource getResource() {
		return resource;
	}

	public String getMessage() {
		return message;
	}

	public int getLineNumber() {
		return lineNumber;
	}

	public int getSeverity() {
		return severity;
	}
}
