/**
 */
package br.ufmg.dcc.asml.aSMLModel;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Expression Matching Clause</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see br.ufmg.dcc.asml.aSMLModel.ASMLModelPackage#getExpressionMatchingClause()
 * @model
 * @generated
 */
public enum ExpressionMatchingClause implements Enumerator
{
  /**
   * The '<em><b>NAME START WITH</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #NAME_START_WITH_VALUE
   * @generated
   * @ordered
   */
  NAME_START_WITH(0, "NAME_START_WITH", "name start with"),

  /**
   * The '<em><b>NAME ENDS WITH</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #NAME_ENDS_WITH_VALUE
   * @generated
   * @ordered
   */
  NAME_ENDS_WITH(1, "NAME_ENDS_WITH", "name ends with"),

  /**
   * The '<em><b>ANNOTATED WITH</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #ANNOTATED_WITH_VALUE
   * @generated
   * @ordered
   */
  ANNOTATED_WITH(2, "ANNOTATED_WITH", "annotated with");

  /**
   * The '<em><b>NAME START WITH</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>NAME START WITH</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #NAME_START_WITH
   * @model literal="name start with"
   * @generated
   * @ordered
   */
  public static final int NAME_START_WITH_VALUE = 0;

  /**
   * The '<em><b>NAME ENDS WITH</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>NAME ENDS WITH</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #NAME_ENDS_WITH
   * @model literal="name ends with"
   * @generated
   * @ordered
   */
  public static final int NAME_ENDS_WITH_VALUE = 1;

  /**
   * The '<em><b>ANNOTATED WITH</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>ANNOTATED WITH</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #ANNOTATED_WITH
   * @model literal="annotated with"
   * @generated
   * @ordered
   */
  public static final int ANNOTATED_WITH_VALUE = 2;

  /**
   * An array of all the '<em><b>Expression Matching Clause</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static final ExpressionMatchingClause[] VALUES_ARRAY =
    new ExpressionMatchingClause[]
    {
      NAME_START_WITH,
      NAME_ENDS_WITH,
      ANNOTATED_WITH,
    };

  /**
   * A public read-only list of all the '<em><b>Expression Matching Clause</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final List<ExpressionMatchingClause> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

  /**
   * Returns the '<em><b>Expression Matching Clause</b></em>' literal with the specified literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static ExpressionMatchingClause get(String literal)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      ExpressionMatchingClause result = VALUES_ARRAY[i];
      if (result.toString().equals(literal))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Expression Matching Clause</b></em>' literal with the specified name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static ExpressionMatchingClause getByName(String name)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      ExpressionMatchingClause result = VALUES_ARRAY[i];
      if (result.getName().equals(name))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Expression Matching Clause</b></em>' literal with the specified integer value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static ExpressionMatchingClause get(int value)
  {
    switch (value)
    {
      case NAME_START_WITH_VALUE: return NAME_START_WITH;
      case NAME_ENDS_WITH_VALUE: return NAME_ENDS_WITH;
      case ANNOTATED_WITH_VALUE: return ANNOTATED_WITH;
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
  private ExpressionMatchingClause(int value, String name, String literal)
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
  
} //ExpressionMatchingClause
