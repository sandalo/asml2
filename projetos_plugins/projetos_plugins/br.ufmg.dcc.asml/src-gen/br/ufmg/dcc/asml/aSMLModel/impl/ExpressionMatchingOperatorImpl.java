/**
 */
package br.ufmg.dcc.asml.aSMLModel.impl;

import br.ufmg.dcc.asml.aSMLModel.ASMLModelPackage;
import br.ufmg.dcc.asml.aSMLModel.ExpressionMatchingOperator;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Expression Matching Operator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link br.ufmg.dcc.asml.aSMLModel.impl.ExpressionMatchingOperatorImpl#getAND <em>AND</em>}</li>
 *   <li>{@link br.ufmg.dcc.asml.aSMLModel.impl.ExpressionMatchingOperatorImpl#getOR <em>OR</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExpressionMatchingOperatorImpl extends MinimalEObjectImpl.Container implements ExpressionMatchingOperator
{
  /**
   * The default value of the '{@link #getAND() <em>AND</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAND()
   * @generated
   * @ordered
   */
  protected static final String AND_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getAND() <em>AND</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAND()
   * @generated
   * @ordered
   */
  protected String and = AND_EDEFAULT;

  /**
   * The default value of the '{@link #getOR() <em>OR</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOR()
   * @generated
   * @ordered
   */
  protected static final String OR_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getOR() <em>OR</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOR()
   * @generated
   * @ordered
   */
  protected String or = OR_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ExpressionMatchingOperatorImpl()
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
    return ASMLModelPackage.Literals.EXPRESSION_MATCHING_OPERATOR;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getAND()
  {
    return and;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAND(String newAND)
  {
    String oldAND = and;
    and = newAND;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ASMLModelPackage.EXPRESSION_MATCHING_OPERATOR__AND, oldAND, and));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getOR()
  {
    return or;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setOR(String newOR)
  {
    String oldOR = or;
    or = newOR;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ASMLModelPackage.EXPRESSION_MATCHING_OPERATOR__OR, oldOR, or));
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
      case ASMLModelPackage.EXPRESSION_MATCHING_OPERATOR__AND:
        return getAND();
      case ASMLModelPackage.EXPRESSION_MATCHING_OPERATOR__OR:
        return getOR();
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
      case ASMLModelPackage.EXPRESSION_MATCHING_OPERATOR__AND:
        setAND((String)newValue);
        return;
      case ASMLModelPackage.EXPRESSION_MATCHING_OPERATOR__OR:
        setOR((String)newValue);
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
      case ASMLModelPackage.EXPRESSION_MATCHING_OPERATOR__AND:
        setAND(AND_EDEFAULT);
        return;
      case ASMLModelPackage.EXPRESSION_MATCHING_OPERATOR__OR:
        setOR(OR_EDEFAULT);
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
      case ASMLModelPackage.EXPRESSION_MATCHING_OPERATOR__AND:
        return AND_EDEFAULT == null ? and != null : !AND_EDEFAULT.equals(and);
      case ASMLModelPackage.EXPRESSION_MATCHING_OPERATOR__OR:
        return OR_EDEFAULT == null ? or != null : !OR_EDEFAULT.equals(or);
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
    result.append(" (AND: ");
    result.append(and);
    result.append(", OR: ");
    result.append(or);
    result.append(')');
    return result.toString();
  }

} //ExpressionMatchingOperatorImpl
