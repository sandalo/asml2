package asmlbuilder.matching;

import br.ufmg.dcc.asml.ComponentInstance;
import br.ufmg.dcc.asml.aSMLModel.AbstractComponent;
import asmlbuilder.builder.ASMLContext;


public class MetaClassMatching extends AbstraticMatching implements IMatching {
	public MetaClassMatching(ASMLContext asmlContext) {
		super(asmlContext);
	}
/*
	private HashSet<MetaClass> metaClassesFounded = new HashSet<MetaClass>();


	@Override
	public boolean matching(ComponentInstance resource, AbstractComponent component) {
		String fileExtension = resource.getResource().getFileExtension() + "";
		if (component instanceof MetaClass && resource.getResource() instanceof IFile && fileExtension.equals("java")) {
			MetaClass class1 = (MetaClass) component;
			AbstractNameConvetion abstractNameConvetion = class1.getMatching();
			if (abstractNameConvetion instanceof ClassMatching) {
				ClassMatching expressionMatching = (ClassMatching) abstractNameConvetion;
				ExpressionMatchingClause clause = expressionMatching.getExpressionMatching();
				if (clause.equals(ExpressionMatchingClause.NAME_ENDS_WITH)) {
					String parameter = expressionMatching.getParameter() + "";
					String resourceName = FileMatching.extractResourceNameIndexed(resource.getResource());
					Set<String> tokens = asmlContext.getTokensNameConvention();
					if (resourceName.endsWith(parameter)) {
						for (String token : tokens) {
							if (resourceName.endsWith(parameter) && resourceName.endsWith(token)) {
								if (parameter.length() < token.length())
									return false;
							}
						}
						registerInSuperClass(class1);
						return true;
					}
				}
			}
		}
		return false;
	}

	private void registerInSuperClass(MetaClass class1) {
		metaClassesFounded.add(class1);
		
		 * MetaClass key = class1.getExtends(); if(key!=null){ Set<MetaClass>
		 * sublMetaClasses = asmlContext.getSublMetaClasses().get(key);
		 * if(sublMetaClasses==null){ sublMetaClasses = new
		 * HashSet<MetaClass>(); asmlContext.getSublMetaClasses().put(key,
		 * sublMetaClasses); }
		 * asmlContext.getSublMetaClasses().get(key).add(class1); }
		 }*/

	@Override
	public boolean matching(ComponentInstance resource, AbstractComponent component) {
		// TODO Auto-generated method stub
		return false;
	}
}
