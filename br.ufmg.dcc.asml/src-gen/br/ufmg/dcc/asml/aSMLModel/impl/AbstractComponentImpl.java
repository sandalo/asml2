/**
 */
package br.ufmg.dcc.asml.aSMLModel.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.ITypeHierarchy;
import org.eclipse.jdt.core.JavaModelException;

import br.ufmg.dcc.asml.ComponentInstance;
import br.ufmg.dcc.asml.ComponentVisitor;
import br.ufmg.dcc.asml.aSMLModel.ASMLModel;
import br.ufmg.dcc.asml.aSMLModel.ASMLModelPackage;
import br.ufmg.dcc.asml.aSMLModel.AbstractComponent;
import br.ufmg.dcc.asml.aSMLModel.Attribute;
import br.ufmg.dcc.asml.aSMLModel.MetaModule;
import br.ufmg.dcc.asml.aSMLModel.Restriction;
import br.ufmg.dcc.asml.aSMLModel.View;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Abstract Component</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link br.ufmg.dcc.asml.aSMLModel.impl.AbstractComponentImpl#getName <em>
 * Name</em>}</li>
 * <li>
 * {@link br.ufmg.dcc.asml.aSMLModel.impl.AbstractComponentImpl#getAttributes
 * <em>Attributes</em>}</li>
 * <li>
 * {@link br.ufmg.dcc.asml.aSMLModel.impl.AbstractComponentImpl#getComponents
 * <em>Components</em>}</li>
 * <li>
 * {@link br.ufmg.dcc.asml.aSMLModel.impl.AbstractComponentImpl#getRestrictions
 * <em>Restrictions</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AbstractComponentImpl extends MinimalEObjectImpl.Container implements AbstractComponent {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getAttributes() <em>Attributes</em>}'
	 * containment reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getAttributes()
	 * @generated
	 * @ordered
	 */
	protected EList<Attribute> attributes;

	/**
	 * The cached value of the '{@link #getComponents() <em>Components</em>}'
	 * containment reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getComponents()
	 * @generated
	 * @ordered
	 */
	protected EList<AbstractComponent> components;

	/**
	 * The cached value of the '{@link #getRestrictions() <em>Restrictions</em>}
	 * ' containment reference list. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #getRestrictions()
	 * @generated
	 * @ordered
	 */
	protected EList<Restriction> restrictions;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected AbstractComponentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ASMLModelPackage.Literals.ABSTRACT_COMPONENT;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ASMLModelPackage.ABSTRACT_COMPONENT__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<Attribute> getAttributes() {
		if (attributes == null) {
			attributes = new EObjectContainmentEList<Attribute>(Attribute.class, this, ASMLModelPackage.ABSTRACT_COMPONENT__ATTRIBUTES);
		}
		return attributes;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<AbstractComponent> getComponents() {
		if (components == null) {
			components = new EObjectContainmentEList<AbstractComponent>(AbstractComponent.class, this, ASMLModelPackage.ABSTRACT_COMPONENT__COMPONENTS);
		}
		return components;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<Restriction> getRestrictions() {
		if (restrictions == null) {
			restrictions = new EObjectContainmentEList<Restriction>(Restriction.class, this, ASMLModelPackage.ABSTRACT_COMPONENT__RESTRICTIONS);
		}
		return restrictions;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case ASMLModelPackage.ABSTRACT_COMPONENT__ATTRIBUTES:
			return ((InternalEList<?>) getAttributes()).basicRemove(otherEnd, msgs);
		case ASMLModelPackage.ABSTRACT_COMPONENT__COMPONENTS:
			return ((InternalEList<?>) getComponents()).basicRemove(otherEnd, msgs);
		case ASMLModelPackage.ABSTRACT_COMPONENT__RESTRICTIONS:
			return ((InternalEList<?>) getRestrictions()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case ASMLModelPackage.ABSTRACT_COMPONENT__NAME:
			return getName();
		case ASMLModelPackage.ABSTRACT_COMPONENT__ATTRIBUTES:
			return getAttributes();
		case ASMLModelPackage.ABSTRACT_COMPONENT__COMPONENTS:
			return getComponents();
		case ASMLModelPackage.ABSTRACT_COMPONENT__RESTRICTIONS:
			return getRestrictions();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case ASMLModelPackage.ABSTRACT_COMPONENT__NAME:
			setName((String) newValue);
			return;
		case ASMLModelPackage.ABSTRACT_COMPONENT__ATTRIBUTES:
			getAttributes().clear();
			getAttributes().addAll((Collection<? extends Attribute>) newValue);
			return;
		case ASMLModelPackage.ABSTRACT_COMPONENT__COMPONENTS:
			getComponents().clear();
			getComponents().addAll((Collection<? extends AbstractComponent>) newValue);
			return;
		case ASMLModelPackage.ABSTRACT_COMPONENT__RESTRICTIONS:
			getRestrictions().clear();
			getRestrictions().addAll((Collection<? extends Restriction>) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case ASMLModelPackage.ABSTRACT_COMPONENT__NAME:
			setName(NAME_EDEFAULT);
			return;
		case ASMLModelPackage.ABSTRACT_COMPONENT__ATTRIBUTES:
			getAttributes().clear();
			return;
		case ASMLModelPackage.ABSTRACT_COMPONENT__COMPONENTS:
			getComponents().clear();
			return;
		case ASMLModelPackage.ABSTRACT_COMPONENT__RESTRICTIONS:
			getRestrictions().clear();
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case ASMLModelPackage.ABSTRACT_COMPONENT__NAME:
			return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
		case ASMLModelPackage.ABSTRACT_COMPONENT__ATTRIBUTES:
			return attributes != null && !attributes.isEmpty();
		case ASMLModelPackage.ABSTRACT_COMPONENT__COMPONENTS:
			return components != null && !components.isEmpty();
		case ASMLModelPackage.ABSTRACT_COMPONENT__RESTRICTIONS:
			return restrictions != null && !restrictions.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

	/**
	 * <!-- custom code -->
	 * 
	 * 
	 */

	private static View uniqueView = new ViewImpl();

	private final Set<ComponentInstance> componentInstances = new HashSet<ComponentInstance>();

	public Set<ComponentInstance> getInstances() {
		return Collections.unmodifiableSet(componentInstances);
	}

	@Override
	public void removeInstance(ComponentInstance componentInstance) {
		componentInstances.remove(componentInstance);
	}

	public Set<ComponentInstance> getAllComponentInstances() {
		Set<ComponentInstance> resourcesAux = new HashSet<ComponentInstance>();
		EList<AbstractComponent> children = getComponents();
		for (AbstractComponent child : children) {
			Set<ComponentInstance> allComponentInstances = child.getAllComponentInstances();
			resourcesAux.addAll(allComponentInstances);
		}
		resourcesAux.addAll(componentInstances);
		return Collections.unmodifiableSet(resourcesAux);
	}

	@Override
	public void addComponentInstance(ComponentInstance componentInstance) {
		try {
			/*
			 * boolean falsePositive = false; if
			 * (isFalsePositive(componentInstance)) {// Esse teste impede que
			 * recursos com mesmo nome mas de projetos diferentes sejam
			 * reconhecidos como instancas do componente. Este erro ocorre
			 * quando há clisão de nomes entre definições de arquiteturas.
			 * return; }
			 */
			componentInstances.remove(componentInstance);
			componentInstances.add(componentInstance);
			componentInstance.setComponent(this);
		} catch (Exception e) {
			System.out.println();
		}
	}

	private boolean isFalsePositive(ComponentInstance componentInstance) {
		boolean falsePositive = false;
		if (!(componentInstance.getResource() instanceof IFolder)) {
			IType type = componentInstance.getType();
			if (type != null) {
				String[] segments_instance = type.getFullyQualifiedName().split("\\.");
				String fullpath = getFullPathComponent();
				String[] segments_component = fullpath.split("\\.");
				for (int i = 0; i < segments_component.length && i < segments_instance.length && i < 5; i++) {
					if (!segments_component[i].equals("{?}") && !segments_component[i].equals(segments_instance[i])) {
						// TODO: Reavaliar se esse código é necessário.
						falsePositive = true;
					}
				}
			}
		} else if (componentInstance.getResource() instanceof IFolder) {
			String projectName = componentInstance.getResource().getProject().getName();
			String[] split = projectName.split("-");
			ASMLModel model = null;
			if (this.eContainer instanceof ASMLModel)
				model = (ASMLModel) this.eContainer;
			else
				model = (ASMLModel) this.getRootComponent().eContainer();
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

	@Override
	public AbstractComponent getRootComponent() {
		EObject root = this.eContainer();
		if (!(root instanceof AbstractComponent))
			return null;
		while (root != null && root.eContainer() instanceof AbstractComponent) {
			root = root.eContainer();
		}
		return (AbstractComponent) root;
	}

	@Override
	public ASMLModel getModel() {
		EObject root = this.eContainer();
		while (root != null && root instanceof AbstractComponent) {
			root = root.eContainer();
		}
		return (ASMLModel) root;
	}

	@Override
	public void componentInstancesClear() {
		componentInstances.clear();
	}

	@Override
	public void componentInstancesClearAll() {
		List<AbstractComponent> components = getAllComponents();
		for (AbstractComponent abstractComponent : components) {
			abstractComponent.componentInstancesClear();
		}
		componentInstancesClear();
	}

	@Override
	public String[] getAllTypesNames() {
		String iTypesNames[] = null;
		Set<ComponentInstance> componentInstances = this.getAllComponentInstances();
		iTypesNames = new String[componentInstances.size()];
		int i = 0;
		for (ComponentInstance componentInstance : componentInstances) {
			IType iType = componentInstance.getType();
			if (iType == null)
				continue;
			iTypesNames[i] = iType.getFullyQualifiedName();
		}
		return iTypesNames;
	}

	@Override
	public boolean containsType(String fullName) {
		Set<ComponentInstance> instances = null;
		instances = getInstances();
		for (ComponentInstance componentInstance : instances) {
			IType iType = componentInstance.getType();
			if (iType == null)
				continue;
			String fullyQualifiedName = iType.getFullyQualifiedName();
			if (fullyQualifiedName.equals(fullName))
				return true;
		}
		return false;
	}

	@Override
	public boolean fullContainsType(String fullName) {
		Set<ComponentInstance> instances = null;
		instances = getAllComponentInstances();
		for (ComponentInstance componentInstance : instances) {
			IType iType = componentInstance.getType();
			if (iType == null)
				continue;
			String fullyQualifiedName = iType.getFullyQualifiedName();
			if (fullyQualifiedName.equals(fullName))
				return true;
		}
		return false;
	}

	@Override
	public String[] getAllSupertypesNames() {
		Set<ComponentInstance> componentInstances = this.getInstances();
		String[] iTypesNames = null;
		for (ComponentInstance componentInstance : componentInstances) {
			IType iType = componentInstance.getType();
			ITypeHierarchy typeHierarchy_;
			IType[] iTypes = null;
			try {
				typeHierarchy_ = iType.newSupertypeHierarchy(new NullProgressMonitor());
				iTypes = typeHierarchy_.getAllSupertypes(iType);
				int i = 0;
				iTypesNames = new String[iTypes.length];
				for (IType iType2 : iTypes) {
					iTypesNames[i++] = iType2.getFullyQualifiedName();
				}
			} catch (JavaModelException e) {
				e.printStackTrace();
			}
		}
		return iTypesNames;
	}

	@Override
	public void accept(ComponentVisitor compVisitor) {
		EList<AbstractComponent> children = getComponents();
		for (AbstractComponent child : children) {
			child.accept(compVisitor);
		}
		compVisitor.visit(this);
	}

	@Override
	public String getMatching() {
		return null;
	}

	@Override
	public View getView() {
		EObject eContainer = this.eContainer();
		if (eContainer instanceof ASMLModel) {
			return uniqueView;
		}
		AbstractComponent abstractComponent = (AbstractComponent) eContainer;
		while (abstractComponent != null && !(abstractComponent instanceof View)) {
			if (abstractComponent.eContainer() instanceof ASMLModel) {
				return uniqueView;
			}
			abstractComponent = (AbstractComponent) abstractComponent.eContainer();
		}
		if (abstractComponent != null)
			return (View) abstractComponent;
		return uniqueView;
	}

	private String fullName = null;
	
	@Override
	public String getFullName() {
		if(fullName!=null)
			return fullName;
		String aux = this.getName();
		AbstractComponent abstractComponent = this;
		while (abstractComponent != null) {
			if (abstractComponent.eContainer() instanceof AbstractComponent) {
				abstractComponent = (AbstractComponent) abstractComponent.eContainer();
				aux = abstractComponent.getName() + "." + aux;
			} else {
				abstractComponent = null;
			}
		}
		fullName = aux;
		return fullName;
	}

	@Override
	public boolean isChild(AbstractComponent component) {
		EObject container = this.eContainer();
		while (container != null) {
			if (container.equals(component)) {
				return true;
			}
			container = container.eContainer();
		}
		return false;
	}

	@Override
	public List<AbstractComponent> getAllComponents() {
		List<AbstractComponent> listAux = new ArrayList<AbstractComponent>();
		EList<AbstractComponent> components = getComponents();
		for (AbstractComponent child : components) {
			List<AbstractComponent> comps = child.getAllComponents();
			listAux.addAll(comps);
		}
		listAux.addAll(getComponents());
		return Collections.unmodifiableList(listAux);
	}

	public String getFullPathComponent() {
		EObject eObject = this;
		String fisicalPathComponent = "";
		while (eObject != null && (eObject instanceof AbstractComponent)) {
			/**
			 * Este token(MetaModule) será utilizado para que a lógica ignore a
			 * coparações com resources físicos, pois os meta modulos // são /
			 * abstratos
			 */
			if (eObject instanceof MetaModule) {
				String nameSpace = getNameSpace((AbstractComponent) eObject);
				if (!"".equals(nameSpace)) {
					if (!fisicalPathComponent.startsWith(nameSpace)) {
						fisicalPathComponent = nameSpace + "." + fisicalPathComponent;
					}
				}
			}
			eObject = eObject.eContainer();
		}
		return fisicalPathComponent;
	}

	private String getNameSpace(AbstractComponent eObject) {
		String matching = eObject.getMatching();
		if (matching == null) {
			/*
			 * if (eObject.getName() == null) return ""; else return
			 * eObject.getName();
			 */
			return "";
		} else {
			String replace = matching.replace(".*", "");
			return replace;
		}
	}

	@Override
	public int compareTo(AbstractComponent o) {
		if (o != null){
			String fullName = o.getFullName();
			if(fullName != null && !"".equals(fullName))
				return this.getFullName().compareTo(fullName);
		}
		return -1;
	}

} // AbstractComponentImpl
