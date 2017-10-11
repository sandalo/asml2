/**
 */
package br.ufmg.dcc.asml.aSMLModel;

import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>ASML Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link br.ufmg.dcc.asml.aSMLModel.ASMLModel#getName <em>Name</em>}</li>
 *   <li>{@link br.ufmg.dcc.asml.aSMLModel.ASMLModel#getImportURI <em>Import URI</em>}</li>
 *   <li>{@link br.ufmg.dcc.asml.aSMLModel.ASMLModel#getComponents <em>Components</em>}</li>
 *   <li>{@link br.ufmg.dcc.asml.aSMLModel.ASMLModel#getIgnore <em>Ignore</em>}</li>
 * </ul>
 * </p>
 *
 * @see br.ufmg.dcc.asml.aSMLModel.ASMLModelPackage#getASMLModel()
 * @model
 * @generated
 */
public interface ASMLModel extends EObject
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see br.ufmg.dcc.asml.aSMLModel.ASMLModelPackage#getASMLModel_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link br.ufmg.dcc.asml.aSMLModel.ASMLModel#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Import URI</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Import URI</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Import URI</em>' attribute.
   * @see #setImportURI(String)
   * @see br.ufmg.dcc.asml.aSMLModel.ASMLModelPackage#getASMLModel_ImportURI()
   * @model
   * @generated
   */
  String getImportURI();

  /**
   * Sets the value of the '{@link br.ufmg.dcc.asml.aSMLModel.ASMLModel#getImportURI <em>Import URI</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Import URI</em>' attribute.
   * @see #getImportURI()
   * @generated
   */
  void setImportURI(String value);

  /**
   * Returns the value of the '<em><b>Components</b></em>' containment reference list.
   * The list contents are of type {@link br.ufmg.dcc.asml.aSMLModel.AbstractComponent}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Components</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Components</em>' containment reference list.
   * @see br.ufmg.dcc.asml.aSMLModel.ASMLModelPackage#getASMLModel_Components()
   * @model containment="true"
   * @generated
   */
  EList<AbstractComponent> getComponents();

  /**
   * Returns the value of the '<em><b>Ignore</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Ignore</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Ignore</em>' attribute list.
   * @see br.ufmg.dcc.asml.aSMLModel.ASMLModelPackage#getASMLModel_Ignore()
   * @model unique="false"
   * @generated
   */
  EList<String> getIgnore();


  List<AbstractComponent> getAllComponents();
  
  public IProject getProject();

  void setProject(IProject project);
} // ASMLModel
