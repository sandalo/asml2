package asmlbuilder.matching;

import asmlbuilder.builder.ASMLContext;
import br.ufmg.dcc.asml.ComponentVisitor;
import br.ufmg.dcc.asml.aSMLModel.AbstractComponent;

public class ExternalMatchingVisitor implements ComponentVisitor {

	private ASMLContext asmlContext;

	public ExternalMatchingVisitor(ASMLContext asmlContext) {
		this.asmlContext = asmlContext;
	}
	
	@Override
	public void visit(AbstractComponent abstractComponent) {
		matching(abstractComponent);
	}
	

	protected void matching(AbstractComponent component) {
/*//		component.componentInstancesClear();
		asmlContext.addMatchingCustom(component);
		List<ComponentInstance> componentInstances = new ArrayList<ComponentInstance>(asmlContext.getExternalComponentInstances());
		Collections.reverse(componentInstances);
		boolean matching = false;
		for (ComponentInstance componentInstance : componentInstances) {
			IMatching iMatching = asmlContext.getMatching(component);
			if (iMatching == null)
				continue;
			matching = iMatching.matching(componentInstance, component);
			if (matching) {
				component.addComponentInstance(componentInstance);
				componentInstance.setComponent(component);
			}
		}*/
	}
		
}
