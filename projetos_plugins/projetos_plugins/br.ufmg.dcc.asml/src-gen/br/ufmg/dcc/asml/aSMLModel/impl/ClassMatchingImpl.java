/**
 */
package br.ufmg.dcc.asml.aSMLModel.impl;

import br.ufmg.dcc.asml.aSMLModel.ASMLModelPackage;
import br.ufmg.dcc.asml.aSMLModel.ClassMatching;
import br.ufmg.dcc.asml.aSMLModel.ExpressionMatchingClause;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Class Matching</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link br.ufmg.dcc.asml.aSMLModel.impl.ClassMatchingImpl#getExpressionMatching <em>Expression Matching</em>}</li>
 *   <li>{@link br.ufmg.dcc.asml.aSMLModel.impl.ClassMatchingImpl#getParameter <em>Parameter</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ClassMatchingImpl extends AbstractNameConvetionImpl implements ClassMatching
{
  /**
   * The default value of the '{@link #getExpressionMatching() <em>Expression Matching</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExpressionMatching()
   * @generated
   * @ordered
   */
  protected static final ExpressionMatchingClause EXPRESSION_MATCHING_EDEFAULT = ExpressionMatchingClause.NAME_START_WITH;

  /**
   * The cached value of the '{@link #getExpressionMatching() <em>Expression Matching</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExpressionMatching()
   * @generated
   * @ordered
   */
  protected ExpressionMatchingClause expressionMatching = EXPRESSION_MATCHING_EDEFAULT;

  /**
   * The default value of the '{@link #getParameter() <em>Parameter</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getParameter()
   * @generated
   * @ordered
   */
  protected static final String PARAMETER_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getParameter() <em>Parameter</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getParameter()
   * @generated
   * @ordered
   */
  protected String parameter = PARAMETER_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ClassMatchingImpl()
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
    return ASMLModelPackage.Literals.CLASS_MATCHING;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ExpressionMatchingClause getExpressionMatching()
  {
    return expressionMatching;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setExpressionMatching(ExpressionMatchingClause newExpressionMatching)
  {
    ExpressionMatchingClause oldExpressionMatching = expressionMatching;
    expressionMatching = newExpressionMatching == null ? EXPRESSION_MATCHING_EDEFAULT : newExpressionMatching;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ASMLModelPackage.CLASS_MATCHING__EXPRESSION_MATCHING, oldExpressionMatching, expressionMatching));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getParameter()
  {
    return parameter;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setParameter(String newParameter)
  {
    String oldParameter = parameter;
    parameter = newParameter;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ASMLModelPackage.CLASS_MATCHING__PARAMETER, oldParameter, parameter));
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
      case ASMLModelPackage.CLASS_MATCHING__EXPRESSION_MATCHING:
        return getExpressionMatching();
      case ASMLModelPackage.CLASS_MATCHING__PARAMETER:
        return getParameter();
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
      case ASMLModelPackage.CLASS_MATCHING__EXPRESSION_MATCHING:
        setExpressionMatching((ExpressionMatchingClause)newValue);
        return;
      case ASMLModelPackage.CLASS_MATCHING__PARAMETER:
        setParameter((String)newValue);
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
      case ASMLModelPackage.CLASS_MATCHING__EXPRESSION_MATCHING:
        setExpressionMatching(EXPRESSION_MATCHING_EDEFAULT);
        return;
      case ASMLModelPackage.CLASS_MATCHING__PARAMETER:
        setParameter(PARAMETER_EDEFAULT);
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
      case ASMLModelPackage.CLASS_MATCHING__EXPRESSION_MATCHING:
        return expressionMatching != EXPRESSION_MATCHING_EDEFAULT;
      case ASMLModelPackage.CLASS_MATCHING__PARAMETER:
        return PARAMETER_EDEFAULT == null ? parameter != null : !PARAMETER_EDEFAULT.equals(parameter);
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
    result.append(" (expressionMatching: ");
    result.append(expressionMatching);
    result.append(", parameter: ");
    result.append(parameter);
    result.append(')');
    return result.toString();
  }

} //ClassMatchingImpl
