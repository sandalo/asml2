/**
 */
package br.ufmg.dcc.asml.aSMLModel;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Restriction</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link br.ufmg.dcc.asml.aSMLModel.Restriction#getGroupClause <em>Group Clause</em>}</li>
 *   <li>{@link br.ufmg.dcc.asml.aSMLModel.Restriction#getPermissionClause <em>Permission Clause</em>}</li>
 *   <li>{@link br.ufmg.dcc.asml.aSMLModel.Restriction#getRelactionType <em>Relaction Type</em>}</li>
 *   <li>{@link br.ufmg.dcc.asml.aSMLModel.Restriction#getGroupClauseB <em>Group Clause B</em>}</li>
 *   <li>{@link br.ufmg.dcc.asml.aSMLModel.Restriction#getComponentB <em>Component B</em>}</li>
 *   <li>{@link br.ufmg.dcc.asml.aSMLModel.Restriction#getMessage <em>Message</em>}</li>
 * </ul>
 * </p>
 *
 * @see br.ufmg.dcc.asml.aSMLModel.ASMLModelPackage#getRestriction()
 * @model
 * @generated
 */
public interface Restriction extends EObject
{
  /**
   * Returns the value of the '<em><b>Group Clause</b></em>' attribute.
   * The literals are from the enumeration {@link br.ufmg.dcc.asml.aSMLModel.GroupClause}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Group Clause</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Group Clause</em>' attribute.
   * @see br.ufmg.dcc.asml.aSMLModel.GroupClause
   * @see #setGroupClause(GroupClause)
   * @see br.ufmg.dcc.asml.aSMLModel.ASMLModelPackage#getRestriction_GroupClause()
   * @model
   * @generated
   */
  GroupClause getGroupClause();

  /**
   * Sets the value of the '{@link br.ufmg.dcc.asml.aSMLModel.Restriction#getGroupClause <em>Group Clause</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Group Clause</em>' attribute.
   * @see br.ufmg.dcc.asml.aSMLModel.GroupClause
   * @see #getGroupClause()
   * @generated
   */
  void setGroupClause(GroupClause value);

  /**
   * Returns the value of the '<em><b>Permission Clause</b></em>' attribute.
   * The literals are from the enumeration {@link br.ufmg.dcc.asml.aSMLModel.PermissionClause}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Permission Clause</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Permission Clause</em>' attribute.
   * @see br.ufmg.dcc.asml.aSMLModel.PermissionClause
   * @see #setPermissionClause(PermissionClause)
   * @see br.ufmg.dcc.asml.aSMLModel.ASMLModelPackage#getRestriction_PermissionClause()
   * @model
   * @generated
   */
  PermissionClause getPermissionClause();

  /**
   * Sets the value of the '{@link br.ufmg.dcc.asml.aSMLModel.Restriction#getPermissionClause <em>Permission Clause</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Permission Clause</em>' attribute.
   * @see br.ufmg.dcc.asml.aSMLModel.PermissionClause
   * @see #getPermissionClause()
   * @generated
   */
  void setPermissionClause(PermissionClause value);

  /**
   * Returns the value of the '<em><b>Relaction Type</b></em>' attribute.
   * The literals are from the enumeration {@link br.ufmg.dcc.asml.aSMLModel.RelactionType}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Relaction Type</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Relaction Type</em>' attribute.
   * @see br.ufmg.dcc.asml.aSMLModel.RelactionType
   * @see #setRelactionType(RelactionType)
   * @see br.ufmg.dcc.asml.aSMLModel.ASMLModelPackage#getRestriction_RelactionType()
   * @model
   * @generated
   */
  RelactionType getRelactionType();

  /**
   * Sets the value of the '{@link br.ufmg.dcc.asml.aSMLModel.Restriction#getRelactionType <em>Relaction Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Relaction Type</em>' attribute.
   * @see br.ufmg.dcc.asml.aSMLModel.RelactionType
   * @see #getRelactionType()
   * @generated
   */
  void setRelactionType(RelactionType value);

  /**
   * Returns the value of the '<em><b>Group Clause B</b></em>' attribute.
   * The literals are from the enumeration {@link br.ufmg.dcc.asml.aSMLModel.GroupClause}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Group Clause B</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Group Clause B</em>' attribute.
   * @see br.ufmg.dcc.asml.aSMLModel.GroupClause
   * @see #setGroupClauseB(GroupClause)
   * @see br.ufmg.dcc.asml.aSMLModel.ASMLModelPackage#getRestriction_GroupClauseB()
   * @model
   * @generated
   */
  GroupClause getGroupClauseB();

  /**
   * Sets the value of the '{@link br.ufmg.dcc.asml.aSMLModel.Restriction#getGroupClauseB <em>Group Clause B</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Group Clause B</em>' attribute.
   * @see br.ufmg.dcc.asml.aSMLModel.GroupClause
   * @see #getGroupClauseB()
   * @generated
   */
  void setGroupClauseB(GroupClause value);

  /**
   * Returns the value of the '<em><b>Component B</b></em>' reference list.
   * The list contents are of type {@link br.ufmg.dcc.asml.aSMLModel.AbstractComponent}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Component B</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Component B</em>' reference list.
   * @see br.ufmg.dcc.asml.aSMLModel.ASMLModelPackage#getRestriction_ComponentB()
   * @model
   * @generated
   */
  EList<AbstractComponent> getComponentB();

  /**
   * Returns the value of the '<em><b>Message</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Message</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Message</em>' attribute.
   * @see #setMessage(String)
   * @see br.ufmg.dcc.asml.aSMLModel.ASMLModelPackage#getRestriction_Message()
   * @model
   * @generated
   */
  String getMessage();

  /**
   * Sets the value of the '{@link br.ufmg.dcc.asml.aSMLModel.Restriction#getMessage <em>Message</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Message</em>' attribute.
   * @see #getMessage()
   * @generated
   */
  void setMessage(String value);

} // Restriction
