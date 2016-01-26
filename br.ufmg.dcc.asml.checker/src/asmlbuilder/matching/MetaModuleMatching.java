package asmlbuilder.matching;

import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.jdt.core.IType;

import asmlbuilder.builder.ASMLContext;
import asmlbuilder.builder.FileInJar;
import br.ufmg.dcc.asml.ComponentInstance;
import br.ufmg.dcc.asml.aSMLModel.ASMLModel;
import br.ufmg.dcc.asml.aSMLModel.AbstractComponent;

public class MetaModuleMatching extends AbstraticMatching implements IMatching {

	public MetaModuleMatching(ASMLContext asmlContext) {
		super(asmlContext);
	}

	@Override
	public boolean matching(ComponentInstance componentInstance, AbstractComponent component) {
		boolean isMatch = false;
		if (componentInstance.getResource() instanceof IFile) {
			isMatch =  isMatchFileStrategy(componentInstance, component);
		} else if (componentInstance.getResource() instanceof FileInJar) {
			isMatch =  isMatchFileStrategy(componentInstance, component);
		} else {
			isMatch =  isMatchFolderStrategy(componentInstance, component);
		}
		return isMatch;
	}

	private boolean isMatchFileStrategy(ComponentInstance componentInstance, AbstractComponent component) {
		boolean isMatch = false;
		if (component.getMatching() == null)
			return false;
		String[] prefixAndSufix = getPrefixAndSufix(component);
		String fileExtension = componentInstance.getResource().getFileExtension();
		if (prefixAndSufix.length > 0) {
			String resourceName = getResourceName(componentInstance);
			if (prefixAndSufix.length == 1) {
				String prefir_Or_sufix = prefixAndSufix[0];
				if (resourceName.endsWith(prefir_Or_sufix)) {
					isMatch = true;
					Set<String> allTokens = asmlContext.getSufixAndPrefixNameConventionConvention();
					for (String token_aux : allTokens) {
						if (token_aux != null && !token_aux.equals(prefir_Or_sufix) && token_aux.endsWith(prefir_Or_sufix) && resourceName.endsWith(token_aux)) {
							isMatch = false;
							break;
						}
					}
				} else if (resourceName.startsWith(prefir_Or_sufix)) {
					isMatch = true;
					Set<String> allTokens = asmlContext.getSufixAndPrefixNameConventionConvention();
					for (String token_aux : allTokens) {
						if (token_aux != null && !token_aux.equals(prefir_Or_sufix) && token_aux.startsWith(prefir_Or_sufix) && resourceName.startsWith(token_aux)) {
							isMatch = false;
							break;
						}
					}
				} else {
					isMatch = false;
				}
			} else if (prefixAndSufix.length == 2) {
				String prefix = prefixAndSufix[0];
				String sufix = prefixAndSufix[1];
				if (!sufix.contains("{")) {
					if (resourceName.endsWith(sufix)) {
						isMatch = true;
						Set<String> allTokens = asmlContext.getSufixAndPrefixNameConventionConvention();
						for (String token_aux : allTokens) {
							if (token_aux != null && !token_aux.equals(sufix) && token_aux.endsWith(sufix) && resourceName.endsWith(token_aux)) {
								isMatch = false;
								break;
							}
						}
						if (!resourceName.startsWith(prefix)) {
							isMatch = false;
						}
					} else {
						isMatch = false;
					}
				}else{
					if (sufix.contains("extension")) {
						isMatch = false;
						String key_extensions[] = sufix.replaceAll("\\}", "").replaceAll("\\{", "").split("=");
						String extensions[] = key_extensions[1].split("\\,");
						for (String extension : extensions) {
							if (extension.equals(fileExtension)) {
								isMatch = true;
								break;
							}
						}
					}
				}
			}

		} else if (component.getMatching().contains(".*") /*&& (componentInstance.getResource() instanceof IFolder || (componentInstance.getType() != null && componentInstance.getType().isBinary()))*/) {
			isMatch = false;
			String parents[] = component.getMatching().split("\\.");
			String segments[] = componentInstance.getResource().getFullPath().segments();
			if (parents.length > 1) {
				String parent = parents[parents.length - 2];
				String segment = segments[segments.length - 2];
				if (parent.equals(segment)) {
					isMatch = true;
				}
			}
			if(isFalsePositive(componentInstance, component))
				isMatch = false;
		} else {
			isMatch = false;
			String parents[] = component.getFullPathComponent().split("\\.");
			String segments[] = componentInstance.getResource().getFullPath().segments();
			String resourceName = (segments[segments.length - 1]+"").replace("."+fileExtension, "");
			if (component.getName().equals(resourceName)) {
				if (parents.length > 1) {
					if (parents[parents.length - 2].equals(segments[segments.length - 2])) {
						isMatch = true;
					}
				} else {
					isMatch = true;
				}
			}
		}
		if(componentInstance.getResource() instanceof FileInJar)
			if(isFalsePositive(componentInstance, component))
				isMatch = false;
		return isMatch;
	}

	private boolean isMatchFolderStrategy(ComponentInstance resource, AbstractComponent component) {
		try {
			
			String path = ModuleMatching.getFullPathComponent(component, true);
			String[] segmentsComponent = path.split("\\.");
			String[] segmentsResource = resource.getResource().getFullPath().segments();
			boolean contains = false;
			for (int i = 0; i < segmentsResource.length; i++) {
				if (segmentsResource[i].equals(segmentsComponent[0])) {
					contains = true;
					break;
				}
			}
			if (!contains)
				return false;
			String[] segmentsNew = new String[segmentsComponent.length];
			int start = segmentsResource.length - segmentsNew.length;
			System.arraycopy(segmentsResource, start, segmentsNew, 0, segmentsNew.length);

			for (int i = 0; i < segmentsNew.length; i++) {
				if (!segmentsComponent[i].equals(segmentsNew[i])) {
					if (segmentsComponent[i].equals("{?}"))
						continue;
					return false;
				}
			}
			return true;
		} catch (IndexOutOfBoundsException e) {
			// controlado
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	private String[] getPrefixAndSufix(AbstractComponent component) {
		String curinga = "\\{\\?\\}";
		String matchingAux = component.getMatching();
		if (matchingAux != null && !matchingAux.contains("?"))
			return new String[] {};
		String[] prefixAndSufix = matchingAux.split(curinga);
		return prefixAndSufix;
	}

	private String getResourceName(ComponentInstance resource) {
		String fileExtension = resource.getResource().getFileExtension();
		String name = resource.getResource().getName();
		if (fileExtension != null)
			name = resource.getResource().getName().replace("." + fileExtension, "");
		return name;
	}
	
	
	private boolean isFalsePositive(ComponentInstance componentInstance, AbstractComponent component) {
		boolean falsePositive = false;
		if (!(componentInstance.getResource() instanceof IFolder)) {
			IType type = componentInstance.getType();
			if (type != null) {
				String[] segments_instance = type.getFullyQualifiedName().split("\\.");
				String fullpath = component.getFullPathComponent();
				String[] segments_component = fullpath.split("\\.");
				for (int i = 0; i < segments_component.length && i < segments_instance.length && i < 5; i++) {
					if (!segments_component[i].equals("{?}") && !segments_component[i].equals(segments_instance[i])) {
						// TODO: Reavaliar se esse código é necessário.
						falsePositive = true;
						break;
					}
				}
			}
		} else if (componentInstance.getResource() instanceof IFolder) {
			String projectName = componentInstance.getResource().getProject().getName();
			String[] split = projectName.split("-");
			ASMLModel model = null;
			if (component.eContainer() instanceof ASMLModel)
				model = (ASMLModel) component.eContainer();
			else
				model = (ASMLModel) component.getRootComponent().eContainer();
			String[] split2 = model.getName().split("-");

			int cont = split.length - 1;
			for (int i = split2.length - 1; i >= 0; i--) {
				if (!split[cont--].equals(split2[i])) {
					falsePositive = true;
				}
			}
		}
		return falsePositive;
	}

}
