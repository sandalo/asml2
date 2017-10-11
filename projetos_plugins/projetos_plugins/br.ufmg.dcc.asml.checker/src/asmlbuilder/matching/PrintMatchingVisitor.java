package asmlbuilder.matching;

import java.util.logging.Logger;

import asmlbuilder.builder.ASMLContext;
import asmlbuilder.view.console.ASMLConsoleFactory;
import br.ufmg.dcc.asml.ComponentInstance;
import br.ufmg.dcc.asml.ComponentVisitor;
import br.ufmg.dcc.asml.aSMLModel.AbstractComponent;

public class PrintMatchingVisitor implements ComponentVisitor {
	private static final Logger log = Logger.getLogger(PrintMatchingVisitor.class.getName());

	public PrintMatchingVisitor(ASMLContext asmlContext) {
	}
	
	@Override
	public void visit(AbstractComponent abstractComponent) {
		ASMLConsoleFactory.print("Componente:   "+abstractComponent.getFullName());
		for (ComponentInstance componentInstance : abstractComponent.getInstances()) {
			ASMLConsoleFactory.print("   Instancia      "+componentInstance.getRawName());
		}
	}
	

}
