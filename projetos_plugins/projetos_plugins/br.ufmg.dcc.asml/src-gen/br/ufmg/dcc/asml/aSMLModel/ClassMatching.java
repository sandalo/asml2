/**
 */
package br.ufmg.dcc.asml.aSMLModel;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Class Matching</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link br.ufmg.dcc.asml.aSMLModel.ClassMatching#getExpressionMatching <em>Expression Matching</em>}</li>
 *   <li>{@link br.ufmg.dcc.asml.aSMLModel.ClassMatching#getParameter <em>Parameter</em>}</li>
 * </ul>
 * </p>
 *
 * @see br.ufmg.dcc.asml.aSMLModel.ASMLModelPackage#getClassMatching()
 * @model
 * @generated
 */
public interface ClassMatching extends AbstractNameConvetion
{
  /**
   * Returns the value of the '<em><b>Expression Matching</b></em>' attribute.
   * The literals are from the enumeration {@link br.ufmg.dcc.asml.aSMLModel.ExpressionMatchingClause}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Expression Matching</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Expression Matching</em>' attribute.
   * @see br.ufmg.dcc.asml.aSMLModel.ExpressionMatchingClause
   * @see #setExpressionMatching(ExpressionMatchingClause)
   * @see br.ufmg.dcc.asml.aSMLModel.ASMLModelPackage#getClassMatching_ExpressionMatching()
   * @model
   * @generated
   */
  ExpressionMatchingClause getExpressionMatching();

  /**
   * Sets the value of the '{@link br.ufmg.dcc.asml.aSMLModel.ClassMatching#getExpressionMatching <em>Expression Matching</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Expression Matching</em>' attribute.
   * @see br.ufmg.dcc.asml.aSMLModel.ExpressionMatchingClause
   * @see #getExpressionMatching()
   * @generated
   */
  void setExpressionMatching(ExpressionMatchingClause value);

  /**
   * Returns the value of the '<em><b>Parameter</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Parameter</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Parameter</em>' attribute.
   * @see #setParameter(String)
   * @see br.ufmg.dcc.asml.aSMLModel.ASMLModelPackage#getClassMatching_Parameter()
   * @model
   * @generated
   */
  String getParameter();

  /**
   * Sets the value of the '{@link br.ufmg.dcc.asml.aSMLModel.ClassMatching#getParameter <em>Parameter</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Parameter</em>' attribute.
   * @see #getParameter()
   * @generated
   */
  void setParameter(String value);

} // ClassMatching
