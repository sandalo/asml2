/**
 */
package br.ufmg.dcc.asml.aSMLModel;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Permission Clause</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see br.ufmg.dcc.asml.aSMLModel.ASMLModelPackage#getPermissionClause()
 * @model
 * @generated
 */
public enum PermissionClause implements Enumerator
{
  /**
   * The '<em><b>MUST</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #MUST_VALUE
   * @generated
   * @ordered
   */
  MUST(0, "MUST", "must"),

  /**
   * The '<em><b>CAN</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #CAN_VALUE
   * @generated
   * @ordered
   */
  CAN(1, "CAN", "can"),

  /**
   * The '<em><b>CANNOT</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #CANNOT_VALUE
   * @generated
   * @ordered
   */
  CANNOT(2, "CANNOT", "cannot");

  /**
   * The '<em><b>MUST</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>MUST</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #MUST
   * @model literal="must"
   * @generated
   * @ordered
   */
  public static final int MUST_VALUE = 0;

  /**
   * The '<em><b>CAN</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>CAN</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #CAN
   * @model literal="can"
   * @generated
   * @ordered
   */
  public static final int CAN_VALUE = 1;

  /**
   * The '<em><b>CANNOT</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>CANNOT</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #CANNOT
   * @model literal="cannot"
   * @generated
   * @ordered
   */
  public static final int CANNOT_VALUE = 2;

  /**
   * An array of all the '<em><b>Permission Clause</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static final PermissionClause[] VALUES_ARRAY =
    new PermissionClause[]
    {
      MUST,
      CAN,
      CANNOT,
    };

  /**
   * A public read-only list of all the '<em><b>Permission Clause</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final List<PermissionClause> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

  /**
   * Returns the '<em><b>Permission Clause</b></em>' literal with the specified literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static PermissionClause get(String literal)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      PermissionClause result = VALUES_ARRAY[i];
      if (result.toString().equals(literal))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Permission Clause</b></em>' literal with the specified name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static PermissionClause getByName(String name)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      PermissionClause result = VALUES_ARRAY[i];
      if (result.getName().equals(name))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Permission Clause</b></em>' literal with the specified integer value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static PermissionClause get(int value)
  {
    switch (value)
    {
      case MUST_VALUE: return MUST;
      case CAN_VALUE: return CAN;
      case CANNOT_VALUE: return CANNOT;
    }
    return null;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private final int value;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private final String name;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private final String literal;

  /**
   * Only this class can construct instances.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private PermissionClause(int value, String name, String literal)
  {
    this.value = value;
    this.name = name;
    this.literal = literal;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getValue()
  {
    return value;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getLiteral()
  {
    return literal;
  }

  /**
   * Returns the literal value of the enumerator, which is its string representation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    return literal;
  }
  
} //PermissionClause
