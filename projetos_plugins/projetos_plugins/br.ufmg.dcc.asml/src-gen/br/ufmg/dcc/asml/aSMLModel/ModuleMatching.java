/**
 */
package br.ufmg.dcc.asml.aSMLModel;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Module Matching</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link br.ufmg.dcc.asml.aSMLModel.ModuleMatching#getParameter <em>Parameter</em>}</li>
 * </ul>
 * </p>
 *
 * @see br.ufmg.dcc.asml.aSMLModel.ASMLModelPackage#getModuleMatching()
 * @model
 * @generated
 */
public interface ModuleMatching extends EObject
{
  /**
   * Returns the value of the '<em><b>Parameter</b></em>' attribute.
   * The literals are from the enumeration {@link br.ufmg.dcc.asml.aSMLModel.ModuleMatchingParamenter}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Parameter</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Parameter</em>' attribute.
   * @see br.ufmg.dcc.asml.aSMLModel.ModuleMatchingParamenter
   * @see #setParameter(ModuleMatchingParamenter)
   * @see br.ufmg.dcc.asml.aSMLModel.ASMLModelPackage#getModuleMatching_Parameter()
   * @model
   * @generated
   */
  ModuleMatchingParamenter getParameter();

  /**
   * Sets the value of the '{@link br.ufmg.dcc.asml.aSMLModel.ModuleMatching#getParameter <em>Parameter</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Parameter</em>' attribute.
   * @see br.ufmg.dcc.asml.aSMLModel.ModuleMatchingParamenter
   * @see #getParameter()
   * @generated
   */
  void setParameter(ModuleMatchingParamenter value);

} // ModuleMatching
