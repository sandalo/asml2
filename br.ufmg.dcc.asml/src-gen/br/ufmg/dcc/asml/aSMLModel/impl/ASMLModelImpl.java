/**
 */
package br.ufmg.dcc.asml.aSMLModel.impl;

import br.ufmg.dcc.asml.aSMLModel.ASMLModel;
import br.ufmg.dcc.asml.aSMLModel.ASMLModelPackage;
import br.ufmg.dcc.asml.aSMLModel.AbstractComponent;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EDataTypeEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>ASML Model</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link br.ufmg.dcc.asml.aSMLModel.impl.ASMLModelImpl#getName <em>Name</em>}</li>
 * <li>{@link br.ufmg.dcc.asml.aSMLModel.impl.ASMLModelImpl#getImportURI <em>Import URI</em>}</li>
 * <li>{@link br.ufmg.dcc.asml.aSMLModel.impl.ASMLModelImpl#getComponents <em>Components</em>}</li>
 * <li>{@link br.ufmg.dcc.asml.aSMLModel.impl.ASMLModelImpl#getIgnore <em>Ignore</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ASMLModelImpl extends MinimalEObjectImpl.Container implements ASMLModel {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getImportURI() <em>Import URI</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getImportURI()
	 * @generated
	 * @ordered
	 */
	protected static final String IMPORT_URI_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getImportURI() <em>Import URI</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getImportURI()
	 * @generated
	 * @ordered
	 */
	protected String importURI = IMPORT_URI_EDEFAULT;

	/**
	 * The cached value of the '{@link #getComponents() <em>Components</em>}' containment reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getComponents()
	 * @generated
	 * @ordered
	 */
	protected EList<AbstractComponent> components;

	/**
	 * The cached value of the '{@link #getIgnore() <em>Ignore</em>}' attribute list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getIgnore()
	 * @generated
	 * @ordered
	 */
	protected EList<String> ignore;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ASMLModelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ASMLModelPackage.Literals.ASML_MODEL;
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
			eNotify(new ENotificationImpl(this, Notification.SET, ASMLModelPackage.ASML_MODEL__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getImportURI() {
		return importURI;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setImportURI(String newImportURI) {
		String oldImportURI = importURI;
		importURI = newImportURI;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ASMLModelPackage.ASML_MODEL__IMPORT_URI, oldImportURI, importURI));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<AbstractComponent> getComponents() {
		if (components == null) {
			components = new EObjectContainmentEList<AbstractComponent>(AbstractComponent.class, this, ASMLModelPackage.ASML_MODEL__COMPONENTS);
		}
		return components;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<String> getIgnore() {
		if (ignore == null) {
			ignore = new EDataTypeEList<String>(String.class, this, ASMLModelPackage.ASML_MODEL__IGNORE);
		}
		return ignore;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case ASMLModelPackage.ASML_MODEL__COMPONENTS:
			return ((InternalEList<?>) getComponents()).basicRemove(otherEnd, msgs);
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
		case ASMLModelPackage.ASML_MODEL__NAME:
			return getName();
		case ASMLModelPackage.ASML_MODEL__IMPORT_URI:
			return getImportURI();
		case ASMLModelPackage.ASML_MODEL__COMPONENTS:
			return getComponents();
		case ASMLModelPackage.ASML_MODEL__IGNORE:
			return getIgnore();
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
		case ASMLModelPackage.ASML_MODEL__NAME:
			setName((String) newValue);
			return;
		case ASMLModelPackage.ASML_MODEL__IMPORT_URI:
			setImportURI((String) newValue);
			return;
		case ASMLModelPackage.ASML_MODEL__COMPONENTS:
			getComponents().clear();
			getComponents().addAll((Collection<? extends AbstractComponent>) newValue);
			return;
		case ASMLModelPackage.ASML_MODEL__IGNORE:
			getIgnore().clear();
			getIgnore().addAll((Collection<? extends String>) newValue);
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
		case ASMLModelPackage.ASML_MODEL__NAME:
			setName(NAME_EDEFAULT);
			return;
		case ASMLModelPackage.ASML_MODEL__IMPORT_URI:
			setImportURI(IMPORT_URI_EDEFAULT);
			return;
		case ASMLModelPackage.ASML_MODEL__COMPONENTS:
			getComponents().clear();
			return;
		case ASMLModelPackage.ASML_MODEL__IGNORE:
			getIgnore().clear();
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
		case ASMLModelPackage.ASML_MODEL__NAME:
			return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
		case ASMLModelPackage.ASML_MODEL__IMPORT_URI:
			return IMPORT_URI_EDEFAULT == null ? importURI != null : !IMPORT_URI_EDEFAULT.equals(importURI);
		case ASMLModelPackage.ASML_MODEL__COMPONENTS:
			return components != null && !components.isEmpty();
		case ASMLModelPackage.ASML_MODEL__IGNORE:
			return ignore != null && !ignore.isEmpty();
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
		result.append(", importURI: ");
		result.append(importURI);
		result.append(", ignore: ");
		result.append(ignore);
		result.append(')');
		return result.toString();
	}

	@Override
	public List<AbstractComponent> getAllComponents() {
		List<AbstractComponent> listAux = new ArrayList<AbstractComponent>();
		EList<AbstractComponent> comps = getComponents();
		for (AbstractComponent abstractComponent : comps) {
			listAux.addAll(abstractComponent.getAllComponents());
		}
		listAux.addAll(comps);
		return listAux;
	}

	private IProject project;
	
	@Override
	public IProject getProject() {
		return this.project;
	}
	
	@Override
	public void setProject(IProject project){
		this.project = project;
	}

} // ASMLModelImpl
