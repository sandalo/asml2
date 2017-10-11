/**
 */
package br.ufmg.dcc.asml.aSMLModel;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Meta Module</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link br.ufmg.dcc.asml.aSMLModel.MetaModule#getMatching <em>Matching</em>}</li>
 *   <li>{@link br.ufmg.dcc.asml.aSMLModel.MetaModule#getDescription <em>Description</em>}</li>
 * </ul>
 * </p>
 *
 * @see br.ufmg.dcc.asml.aSMLModel.ASMLModelPackage#getMetaModule()
 * @model
 * @generated
 */
public interface MetaModule extends AbstractComponent
{
  /**
   * Returns the value of the '<em><b>Matching</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Matching</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Matching</em>' attribute.
   * @see #setMatching(String)
   * @see br.ufmg.dcc.asml.aSMLModel.ASMLModelPackage#getMetaModule_Matching()
   * @model
   * @generated
   */
  String getMatching();

  /**
   * Sets the value of the '{@link br.ufmg.dcc.asml.aSMLModel.MetaModule#getMatching <em>Matching</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Matching</em>' attribute.
   * @see #getMatching()
   * @generated
   */
  void setMatching(String value);

  /**
   * Returns the value of the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Description</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Description</em>' attribute.
   * @see #setDescription(String)
   * @see br.ufmg.dcc.asml.aSMLModel.ASMLModelPackage#getMetaModule_Description()
   * @model
   * @generated
   */
  String getDescription();

  /**
   * Sets the value of the '{@link br.ufmg.dcc.asml.aSMLModel.MetaModule#getDescription <em>Description</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Description</em>' attribute.
   * @see #getDescription()
   * @generated
   */
  void setDescription(String value);

} // MetaModule
