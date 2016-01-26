/**
 */
package br.ufmg.dcc.asml.aSMLModel.impl;

import br.ufmg.dcc.asml.aSMLModel.ASMLModelPackage;
import br.ufmg.dcc.asml.aSMLModel.AbstractComponent;
import br.ufmg.dcc.asml.aSMLModel.ComponentsBinRestrictionDeclareation;
import br.ufmg.dcc.asml.aSMLModel.WildCard;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Components Bin Restriction Declareation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link br.ufmg.dcc.asml.aSMLModel.impl.ComponentsBinRestrictionDeclareationImpl#getComponentB <em>Component B</em>}</li>
 *   <li>{@link br.ufmg.dcc.asml.aSMLModel.impl.ComponentsBinRestrictionDeclareationImpl#getWildcard <em>Wildcard</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ComponentsBinRestrictionDeclareationImpl extends MinimalEObjectImpl.Container implements ComponentsBinRestrictionDeclareation
{
  /**
   * The cached value of the '{@link #getComponentB() <em>Component B</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getComponentB()
   * @generated
   * @ordered
   */
  protected AbstractComponent componentB;

  /**
   * The default value of the '{@link #getWildcard() <em>Wildcard</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getWildcard()
   * @generated
   * @ordered
   */
  protected static final WildCard WILDCARD_EDEFAULT = WildCard.PACKAGE;

  /**
   * The cached value of the '{@link #getWildcard() <em>Wildcard</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getWildcard()
   * @generated
   * @ordered
   */
  protected WildCard wildcard = WILDCARD_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ComponentsBinRestrictionDeclareationImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return ASMLModelPackage.Literals.COMPONENTS_BIN_RESTRICTION_DECLAREATION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AbstractComponent getComponentB()
  {
    if (componentB != null && componentB.eIsProxy())
    {
      InternalEObject oldComponentB = (InternalEObject)componentB;
      componentB = (AbstractComponent)eResolveProxy(oldComponentB);
      if (componentB != oldComponentB)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ASMLModelPackage.COMPONENTS_BIN_RESTRICTION_DECLAREATION__COMPONENT_B, oldComponentB, componentB));
      }
    }
    return componentB;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AbstractComponent basicGetComponentB()
  {
    return componentB;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setComponentB(AbstractComponent newComponentB)
  {
    AbstractComponent oldComponentB = componentB;
    componentB = newComponentB;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ASMLModelPackage.COMPONENTS_BIN_RESTRICTION_DECLAREATION__COMPONENT_B, oldComponentB, componentB));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public WildCard getWildcard()
  {
    return wildcard;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setWildcard(WildCard newWildcard)
  {
    WildCard oldWildcard = wildcard;
    wildcard = newWildcard == null ? WILDCARD_EDEFAULT : newWildcard;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ASMLModelPackage.COMPONENTS_BIN_RESTRICTION_DECLAREATION__WILDCARD, oldWildcard, wildcard));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case ASMLModelPackage.COMPONENTS_BIN_RESTRICTION_DECLAREATION__COMPONENT_B:
        if (resolve) return getComponentB();
        return basicGetComponentB();
      case ASMLModelPackage.COMPONENTS_BIN_RESTRICTION_DECLAREATION__WILDCARD:
        return getWildcard();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case ASMLModelPackage.COMPONENTS_BIN_RESTRICTION_DECLAREATION__COMPONENT_B:
        setComponentB((AbstractComponent)newValue);
        return;
      case ASMLModelPackage.COMPONENTS_BIN_RESTRICTION_DECLAREATION__WILDCARD:
        setWildcard((WildCard)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case ASMLModelPackage.COMPONENTS_BIN_RESTRICTION_DECLAREATION__COMPONENT_B:
        setComponentB((AbstractComponent)null);
        return;
      case ASMLModelPackage.COMPONENTS_BIN_RESTRICTION_DECLAREATION__WILDCARD:
        setWildcard(WILDCARD_EDEFAULT);
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case ASMLModelPackage.COMPONENTS_BIN_RESTRICTION_DECLAREATION__COMPONENT_B:
        return componentB != null;
      case ASMLModelPackage.COMPONENTS_BIN_RESTRICTION_DECLAREATION__WILDCARD:
        return wildcard != WILDCARD_EDEFAULT;
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (wildcard: ");
    result.append(wildcard);
    result.append(')');
    return result.toString();
  }

} //ComponentsBinRestrictionDeclareationImpl
