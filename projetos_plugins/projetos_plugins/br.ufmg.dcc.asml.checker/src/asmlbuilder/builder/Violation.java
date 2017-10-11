package asmlbuilder.builder;

import org.eclipse.core.resources.IResource;

import br.ufmg.dcc.asml.ComponentInstanceReference;

public class Violation {
	IResource resource = null;
	String violation_type;
	String message;
	int lineNumber;
	int severity;
	ComponentInstanceReference componentInstanceReference;
	public enum DependecyType {STRUCTURAL, COMPILE} 
	private DependecyType dependecyType;
	public Violation(IResource resource, String message, int lineNumber, int severity, DependecyType dependecyType, String violation_type) {
		this.resource=resource;
		this.message=message;
		this.lineNumber=lineNumber;
		this.severity=severity;
		this.dependecyType = dependecyType;
		this.violation_type = violation_type;
	}
	
	public String getViolation_type() {
		return violation_type;
	}

	public Violation(ComponentInstanceReference componentInstanceReference, IResource resource, String message, int lineNumber, int severity, DependecyType dependecyType, String violation_type) {
		this.resource=resource;
		this.message=message;
		this.lineNumber=lineNumber;
		this.severity=severity;
		this.componentInstanceReference = componentInstanceReference;
		this.dependecyType = dependecyType;
		this.violation_type = violation_type;
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

	public DependecyType getDependecyType() {
		return dependecyType;
	}
}
