package asmlbuilder.matching;

import java.util.Set;

import org.eclipse.core.resources.IProject;
import org.eclipse.emf.ecore.EObject;

import asmlbuilder.builder.ASMLContext;
import br.ufmg.dcc.asml.ComponentInstance;
import br.ufmg.dcc.asml.ComponentVisitor;
import br.ufmg.dcc.asml.aSMLModel.ASMLModel;
import br.ufmg.dcc.asml.aSMLModel.AbstractComponent;

public class MatchingVisitor implements ComponentVisitor {

	private ASMLContext asmlContext;
	private boolean internal = true;
	private Set<ComponentInstance> componentInstances = null;
	public Set<ComponentInstance> getComponentInstances() {
		return componentInstances;
	}

	public void setComponentInstances(Set<ComponentInstance> componentInstances) {
		this.componentInstances = componentInstances;
	}

	public MatchingVisitor(ASMLContext asmlContext) {
		this.asmlContext = asmlContext;
	}
	
	@Override
	public void visit(AbstractComponent abstractComponent) {
		matching(abstractComponent);
	}
	

	protected void matching(AbstractComponent component) {
		boolean matching = false;
		Set<ComponentInstance> componentInstances2 = componentInstances;
		if(componentInstances2==null)
			componentInstances2 = asmlContext.getComponentInstances();
		ASMLModel model =  component.getModel();
		IProject project = model.getProject();
		for (ComponentInstance componentInstance : componentInstances2) {
			if(project!=null && !project.equals(componentInstance.getResource().getProject())){//evitar colisão, quando pacotes tem mesmo nome em projetos diferentes
				continue;
			}
			if(internal && componentInstance.isExternal() || (componentInstance.isExternal() && componentInstance.getComponent()!=null ))
				continue;
			IMatching iMatching = asmlContext.getMatching(component);
			if (iMatching == null)
				continue;
			matching = iMatching.matching(componentInstance, component);
			if (matching) {
				component.addComponentInstance(componentInstance);
			}
		}
	}

	public boolean isInternal() {
		return internal;
	}

	public void setInternal(boolean internal) {
		this.internal = internal;
	}//2186
		
}
