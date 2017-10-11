package asmlbuilder.builder;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.Enumerator;

import asmlbuilder.matching.AbstraticMatching;
import asmlbuilder.matching.MetaModuleMatching;
import asmlbuilder.matching.ModuleMatching;
import asmlbuilder.restriction.RestricionChecker;
import br.ufmg.dcc.asml.aSMLModel.AbstractComponent;
import br.ufmg.dcc.asml.aSMLModel.Restriction;
import br.ufmg.dcc.asml.aSMLModel.impl.AbstractComponentImpl;
import br.ufmg.dcc.asml.aSMLModel.impl.MetaModuleImpl;

public class ASMLBinder {
	private Map<Class<? extends AbstractComponent>, AbstraticMatching> bindMatching = new HashMap<Class<? extends AbstractComponent>, AbstraticMatching>();
	private Map<AbstractComponent, AbstraticMatching> bindMatchingCustom = new HashMap<AbstractComponent, AbstraticMatching>();

	private Map<String, RestricionChecker> bindRestrictionChecker = new HashMap<String, RestricionChecker>();
	private Map<String, RestricionChecker> bindRestrictionCheckerCustom = new HashMap<String, RestricionChecker>();

	public ASMLBinder(ASMLContext asmlContext){
/*		bindMatching.put(ModuleImpl.class, new ModuleMatching(asmlContext));
		bindMatching.put(ExternalModuleImpl.class, new ExternalModuleMatching(asmlContext));
		bindMatching.put(FileImpl.class, new FileMatching(asmlContext));
		bindMatching.put(MetaClassImpl.class, new MetaClassMatching(asmlContext));
*/		
		bindMatching.put(MetaModuleImpl.class, new MetaModuleMatching(asmlContext));
		bindMatching.put(AbstractComponentImpl.class, new ModuleMatching(asmlContext));
		
/*		bindRestrictionChecker.put(RelactionType.REQUIRES, new MustRequires(asmlContext));
		bindRestrictionChecker.put(RelactionType.EXTEND, new MustExtends(asmlContext));
		bindRestrictionChecker.put(RelactionType.HANDLE, new ComponentAHandleCompontB(asmlContext));
		bindRestrictionChecker.put(RelactionType.CREATE, new OnlyCanCreate(asmlContext));
		bindRestrictionChecker.put(RelactionType.ACCESS, new OnlyCanAccess(asmlContext));
		bindRestrictionChecker.put(RelactionType.DECLARE, new ComponentADeclareCompontB(asmlContext));
		bindRestrictionChecker.put(RelactionType.THROW, new CannotThrow(asmlContext));
		bindRestrictionChecker.put(RelactionType.USEANOTATION, new ComponentAUseAnnotationCompontB(asmlContext));
		bindRestrictionChecker.put(RelactionType.IMPLEMENT, new ComponentAImplementsCompontB(asmlContext));
		bindRestrictionChecker.put(RelactionType.DEPEND, new ComponentADependsCompontB(asmlContext));
*/	}
	public Map<AbstractComponent, AbstraticMatching> getBindMatchingCustom() {
		return bindMatchingCustom;
	}
	public Map<Class<? extends AbstractComponent>, AbstraticMatching> getBindMatching() {
		return bindMatching;
	}
	
	public Map<String, RestricionChecker> getBindRestrictionChecker() {
		return bindRestrictionChecker;
	}
	public Map<String, RestricionChecker> getBindRestrictionCheckerCustom() {
		return bindRestrictionCheckerCustom;
	}

}
