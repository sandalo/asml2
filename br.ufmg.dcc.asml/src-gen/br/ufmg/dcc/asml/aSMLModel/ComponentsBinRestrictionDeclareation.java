/**
 */
package br.ufmg.dcc.asml.aSMLModel;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Components Bin Restriction Declareation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link br.ufmg.dcc.asml.aSMLModel.ComponentsBinRestrictionDeclareation#getComponentB <em>Component B</em>}</li>
 *   <li>{@link br.ufmg.dcc.asml.aSMLModel.ComponentsBinRestrictionDeclareation#getWildcard <em>Wildcard</em>}</li>
 * </ul>
 * </p>
 *
 * @see br.ufmg.dcc.asml.aSMLModel.ASMLModelPackage#getComponentsBinRestrictionDeclareation()
 * @model
 * @generated
 */
public interface ComponentsBinRestrictionDeclareation extends EObject
{
  /**
   * Returns the value of the '<em><b>Component B</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Component B</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Component B</em>' reference.
   * @see #setComponentB(AbstractComponent)
   * @see br.ufmg.dcc.asml.aSMLModel.ASMLModelPackage#getComponentsBinRestrictionDeclareation_ComponentB()
   * @model
   * @generated
   */
  AbstractComponent getComponentB();

  /**
   * Sets the value of the '{@link br.ufmg.dcc.asml.aSMLModel.ComponentsBinRestrictionDeclareation#getComponentB <em>Component B</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Component B</em>' reference.
   * @see #getComponentB()
   * @generated
   */
  void setComponentB(AbstractComponent value);

  /**
   * Returns the value of the '<em><b>Wildcard</b></em>' attribute.
   * The literals are from the enumeration {@link br.ufmg.dcc.asml.aSMLModel.WildCard}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Wildcard</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Wildcard</em>' attribute.
   * @see br.ufmg.dcc.asml.aSMLModel.WildCard
   * @see #setWildcard(WildCard)
   * @see br.ufmg.dcc.asml.aSMLModel.ASMLModelPackage#getComponentsBinRestrictionDeclareation_Wildcard()
   * @model
   * @generated
   */
  WildCard getWildcard();

  /**
   * Sets the value of the '{@link br.ufmg.dcc.asml.aSMLModel.ComponentsBinRestrictionDeclareation#getWildcard <em>Wildcard</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Wildcard</em>' attribute.
   * @see br.ufmg.dcc.asml.aSMLModel.WildCard
   * @see #getWildcard()
   * @generated
   */
  void setWildcard(WildCard value);

} // ComponentsBinRestrictionDeclareation
