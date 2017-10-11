package asmlbuilder.matching;

import br.ufmg.dcc.asml.ComponentInstance;
import br.ufmg.dcc.asml.aSMLModel.AbstractComponent;

public interface IMatching {
	public boolean matching (ComponentInstance resource, AbstractComponent component);	
}
