package br.ufmg.dcc.asml;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.ITypeHierarchy;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.dom.CompilationUnit;

import br.ufmg.dcc.asml.aSMLModel.AbstractComponent;
import br.ufmg.dcc.asml.aSMLModel.RelactionType;

public class ComponentInstance implements Comparable<ComponentInstance> {
	private IResource resource;
	private boolean external = true;
	private AbstractComponent component;
	private Map<RelactionType, Set<ComponentInstanceReference>> componentInstanceReferences = new HashMap<RelactionType, Set<ComponentInstanceReference>>();
	private Set<ComponentInstance> componentInstancesThatRequireMe = new LinkedHashSet<ComponentInstance>();
	private Map<RelactionType, Set<ComponentInstanceReference>> referencesThatPointToMe = new HashMap<RelactionType, Set<ComponentInstanceReference>>();
	
	private CompilationUnit compilationUnitAST;
	private Object resourceType;
 
	private ComponentInstance() {	}
	
	public static ComponentInstance createInstance(IResource resource, boolean external, CompilationUnit compilationUnitAST){
		ComponentInstance componentInstance = new ComponentInstance();
		componentInstance.setCompilationUnitAST(compilationUnitAST);
		componentInstance.setExternal(external);
		componentInstance.setResource(resource);
		return componentInstance;
	}

	public CompilationUnit getCompilationUnitAST() {
		return compilationUnitAST;
	}

	public void setCompilationUnitAST(CompilationUnit compilationUnit) {
		this.compilationUnitAST = compilationUnit;
	}

	public IResource getResource() {
		return resource;
	}

	public void setResource(IResource resource) {
		if (resource == null)
			return;
		String key = resource.getFullPath().toString();
//		addCache(resource, key);
		this.resource = resource;
	}

	public void setResource(IResource resource, String key) {
//		addCache(resource, key);
		this.resource = resource;
	}


	/*
	 * public Set<AbstractComponent> getComponents() { Collection<AbstractComponent> values = components.values(); Collection<AbstractComponent> valuesSet = new HashSet<AbstractComponent>(values); return Collections.unmodifiableSet((Set<? extends AbstractComponent>) valuesSet); }
	 */
	public AbstractComponent getComponent() {
		return component;
	}

	public void setComponent(AbstractComponent component) {
		if(component==null)
			return;
		component.isChild(this.component);
		if (this.component != null) {
			System.out.println("Tentando configurar " + this.getRawName() + " para o componente " + component.getName());
			System.out.println("Componente " + this.component.getName() + " já esta configurado para esta instancia.");
			return;
		}
		this.component = component;
		/*
		 * this.components.put(view, component); if (this.components.size() > 1) { System.out.println("Mais de um componente por ComponentIntance"); }
		 */}

	/*
	 * public void componentClear() { components.clear(); }
	 * 
	 * public void componentRemove(AbstractComponent component) { components.remove(component); }
	 */
	@Override
	public int compareTo(ComponentInstance o) {
		if (resource != null && o.getResource() != null)
			return resource.getFullPath().toString().compareTo(o.getResource().getFullPath().toString());
		return -1;
	}

	@Override
	public String toString() {
		if (getType() != null)
			return getType().getFullyQualifiedName();
		if (resource != null)
			return resource.toString();
		return "undefined";
	}

	public boolean addDependency(ComponentInstanceReference componentInstanceReference) {
		RelactionType relactionType = componentInstanceReference.getRelactionType();
		boolean add = false;
		Set<ComponentInstanceReference> astNodes = (Set<ComponentInstanceReference>) componentInstanceReferences.get(relactionType);
		if (astNodes == null) {
			astNodes = new HashSet<ComponentInstanceReference>();
			componentInstanceReferences.put(relactionType, astNodes);
		}
		add = astNodes.add(componentInstanceReference);
		componentInstanceReference.setComponentInstance(this);
		return add;
	}
	
	public boolean addReferenceThatPointToMe(ComponentInstanceReference componentInstanceReference) {
		RelactionType relactionType = componentInstanceReference.getRelactionType();
		boolean add = false;
		Set<ComponentInstanceReference> astNodes = (Set<ComponentInstanceReference>) referencesThatPointToMe.get(relactionType);
		if (astNodes == null) {
			astNodes = new HashSet<ComponentInstanceReference>();
			referencesThatPointToMe.put(relactionType, astNodes);
		}
		add = astNodes.add(componentInstanceReference);
		componentInstanceReference.setComponentInstanceReferenced(this);

		return add;
	}

	public Set<ComponentInstanceReference> getDependencies(RelactionType relactionType) {
		Set<ComponentInstanceReference> set = componentInstanceReferences.get(relactionType);
		if (set == null)
			return new HashSet<ComponentInstanceReference>();
		return set;
	}

	public Set<ComponentInstanceReference> getDependencies() {
		HashSet<ComponentInstanceReference> hashSet = new HashSet<ComponentInstanceReference>();
		Collection<Set<ComponentInstanceReference>> values = componentInstanceReferences.values();
		for (Set<ComponentInstanceReference> set : values) {
			for (ComponentInstanceReference componentInstanceReference : set) {
				ComponentInstance componentInstanceOwner = componentInstanceReference.getComponentInstanceDependent();
				AbstractComponent component2 = componentInstanceOwner.getComponent();
				if (componentInstanceOwner != null && component2 != null)
					hashSet.add(componentInstanceReference);
			}
		}
		return Collections.unmodifiableSet(hashSet);
	}
	public void clearDependencies() {
		componentInstanceReferences.clear();
	}	
	public Set<ComponentInstanceReference> getReferencesThatPointToMe() {
		HashSet<ComponentInstanceReference> hashSet = new HashSet<ComponentInstanceReference>();
		Collection<Set<ComponentInstanceReference>> values = referencesThatPointToMe.values();
		for (Set<ComponentInstanceReference> references : values) {
			for (ComponentInstanceReference referenceThatPointToMe : references) {
/*				ComponentInstance componentInstanceOwner = componentInstanceReference.getComponentInstanceDependent();
				AbstractComponent component2 = componentInstanceOwner.getComponent();
				if (componentInstanceOwner != null && component2 != null)
*/					hashSet.add(referenceThatPointToMe);
			}
		}
		return Collections.unmodifiableSet(hashSet);
	}

	public void setType(Object iType) {
		this.resourceType = iType;
	}

	public IType getType() {
		if (this.resourceType instanceof IType)
			return (IType) this.resourceType;
		return null;
	}

	protected String getTypeFullQualifyName() {
		if (getType() != null)
			return getType().getFullyQualifiedName();
		return "";
	}

	public String[] getAllSupertypesNames() {
		IType iType = this.getType();
		ITypeHierarchy typeHierarchy_;
		String[] iTypesNames = new String[0];
		IType[] iTypes = null;
		try {
			typeHierarchy_ = iType.newSupertypeHierarchy(new NullProgressMonitor());
			iTypes = typeHierarchy_.getAllSupertypes(iType);
			iTypesNames = new String[iTypes.length];
			int i = 0;
			for (IType iType2 : iTypes) {
				iTypesNames[i++] = iType2.getFullyQualifiedName();
			}
		} catch (JavaModelException e) {
			e.printStackTrace();
		}
		return iTypesNames;
	}

	public static String[] getResourcesTypesNames(Set<ComponentInstance> componentInstancesB) {
		String[] names = new String[componentInstancesB.size()];
		int i = 0;
		for (ComponentInstance componentInstance : componentInstancesB) {
			IType iTypeB;
			iTypeB = componentInstance.getType();
			names[i] = iTypeB.getFullyQualifiedName();
		}
		return names;
	}

	public boolean extendsAtLeastOneOf(AbstractComponent componentB) {
		boolean extend;
		String[] typeNamesOfA = this.getAllSupertypesNames();
		String[] typeNamesOfB = componentB.getAllTypesNames();
		extend = containsType(typeNamesOfA, typeNamesOfB);
		return extend;
	}

	public static boolean containsType(String[] fullQualifyNames1, String[] fullQualifyNames2) {
		boolean contains = false;
		external: for (String fullQualifyName1 : fullQualifyNames1) {
			for (int i = 0; i < fullQualifyNames2.length; i++) {
				if (fullQualifyName1.equals(fullQualifyNames2[i])) {
					contains = true;
					break external;
				}
			}
		}
		return contains;
	}

	public boolean isInstanceOf(AbstractComponent componentB) {
		boolean extend;
		String[] typeNamesOfA = new String[] { this.getType().getFullyQualifiedName() };
		String[] typeNamesOfB = componentB.getAllTypesNames();
		extend = containsType(typeNamesOfA, typeNamesOfB);
		return extend;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof ComponentInstance) {
			ComponentInstance componentInstance = (ComponentInstance) obj;
			if (resource != null && componentInstance.getResource() != null)
				return resource.getFullPath().toString().equals(componentInstance.getResource().getFullPath().toString());
			return super.equals(obj);
		}
		return false;
	}

	@Override
	public int hashCode() {
		if (resource != null)
			return resource.hashCode();
		return super.hashCode();
	}

	public boolean instanceOf(AbstractComponent abstractComponent) {
		boolean is = false;
		if (component != null && component.getName().equals(abstractComponent.getName()))
			is = true;
		if (is)
			return is;
		return is;
	}

	public String getRawName() {
		if (getComponent() == null)
			return getResource().getName();
		String matching = getComponent().getMatching();

		String name = getResource().getName();
		if (matching != null && matching.equals("{?}")) {
			return getResource().getName();
		}

		if (matching != null && matching.contains("{?}")) {
			try {
				String segments[] = matching.split("\\{\\?\\}");
				for (int i = 0; i < segments.length; i++) {
					String token = segments[i];
					name = name.replace(token, "");
				}
			} catch (Exception e) {
				return getResource().getName();
			}
		}
		if (getResource().getFileExtension() != null)
			name = name.replace("." + getResource().getFileExtension(), "");
		return name;
	}

	public boolean isExternal() {
		return external;
	}

	public void setExternal(boolean external) {
		this.external = external;
	}

	public Set<ComponentInstance> getComponentInstancesThatRequireMe() {
		return Collections.unmodifiableSet(componentInstancesThatRequireMe);
	}

	public void addComponentInstancesThatRequireMe(ComponentInstance componentInstancesThatRequireMe) {
		this.componentInstancesThatRequireMe.add(componentInstancesThatRequireMe);
	}
}
