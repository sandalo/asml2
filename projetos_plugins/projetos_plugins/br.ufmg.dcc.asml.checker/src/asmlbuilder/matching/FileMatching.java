package asmlbuilder.matching;

import org.eclipse.core.resources.IResource;

import asmlbuilder.builder.ASMLContext;
import br.ufmg.dcc.asml.ComponentInstance;
import br.ufmg.dcc.asml.aSMLModel.AbstractComponent;

public class FileMatching extends AbstraticMatching implements IMatching {

	public FileMatching(ASMLContext asmlContext) {
		super(asmlContext);
	}

	@Override
	public boolean matching(ComponentInstance resource, AbstractComponent component) {
/*		String fileExtension = resource.getResource().getFileExtension()+"";
		if (component instanceof File && resource.getResource() instanceof IFile && (fileExtension.equals("xml") || fileExtension.equals("html") || !fileExtension.equals("java"))) {
			br.ufmg.dcc.asml.aSMLModel.File file = (File) component;
			AbstractNameConvetion abstractNameConvetion = file.getMatching();
			String fileExtensioWithPoint = "." + fileExtension;
			if (abstractNameConvetion != null) {
				if (abstractNameConvetion instanceof ClassMatching) {
					ClassMatching expressionMatching = (ClassMatching) abstractNameConvetion;
					ExpressionMatchingClause clause = expressionMatching.getExpressionMatching();
					if (clause.equals(ExpressionMatchingClause.NAME_ENDS_WITH)) {
						String parameter = expressionMatching.getParameter() + "";
						String resourceName = extractResourceNameIndexed(resource.getResource());
						if (resourceName.endsWith(parameter)) {
							return true;
						}
					}
				}
			} else {
				String replaceAll = resource.getResource().getName().replaceAll(fileExtensioWithPoint, "");
				if (replaceAll.equals(component.getName()) || component.getName().equals(fileExtensioWithPoint))
					return true;
			}
		}*/
		return false;
	}

	public static String extractResourceNameIndexed(IResource resource) {
		String fileExtensioWithPoint = "";
		int positionExtension = 0;
		if (resource.getFileExtension() != null) {
			fileExtensioWithPoint = "." + resource.getFileExtension();
			positionExtension = resource.getName().indexOf(fileExtensioWithPoint);
		} else {
			positionExtension = resource.getName().length();
		}
		if (positionExtension == 0) {
			return resource.getName();
		}
		int index = positionExtension - 1;
		if (index != 0) {
			while (Character.isDigit(resource.getName().charAt(index))) {
				index--;
			}
			String resourceName = resource.getName().replaceAll(fileExtensioWithPoint, "");
			resourceName = resourceName.substring(0, index + 1);
			return resourceName;
		}
		return resource.getName();
	}

}
