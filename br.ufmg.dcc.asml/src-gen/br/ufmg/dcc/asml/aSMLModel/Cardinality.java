/**
 */
package br.ufmg.dcc.asml.aSMLModel;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Cardinality</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see br.ufmg.dcc.asml.aSMLModel.ASMLModelPackage#getCardinality()
 * @model
 * @generated
 */
public enum Cardinality implements Enumerator
{
  /**
   * The '<em><b>One</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #ONE_VALUE
   * @generated
   * @ordered
   */
  ONE(0, "One", "1"),

  /**
   * The '<em><b>Zero</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #ZERO_VALUE
   * @generated
   * @ordered
   */
  ZERO(1, "Zero", "0"),

  /**
   * The '<em><b>One Or Many</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #ONE_OR_MANY_VALUE
   * @generated
   * @ordered
   */
  ONE_OR_MANY(2, "OneOrMany", "1..*"),

  /**
   * The '<em><b>Zero Or Many</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #ZERO_OR_MANY_VALUE
   * @generated
   * @ordered
   */
  ZERO_OR_MANY(3, "ZeroOrMany", "0..*");

  /**
   * The '<em><b>One</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>One</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #ONE
   * @model name="One" literal="1"
   * @generated
   * @ordered
   */
  public static final int ONE_VALUE = 0;

  /**
   * The '<em><b>Zero</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Zero</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #ZERO
   * @model name="Zero" literal="0"
   * @generated
   * @ordered
   */
  public static final int ZERO_VALUE = 1;

  /**
   * The '<em><b>One Or Many</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>One Or Many</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #ONE_OR_MANY
   * @model name="OneOrMany" literal="1..*"
   * @generated
   * @ordered
   */
  public static final int ONE_OR_MANY_VALUE = 2;

  /**
   * The '<em><b>Zero Or Many</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Zero Or Many</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #ZERO_OR_MANY
   * @model name="ZeroOrMany" literal="0..*"
   * @generated
   * @ordered
   */
  public static final int ZERO_OR_MANY_VALUE = 3;

  /**
   * An array of all the '<em><b>Cardinality</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static final Cardinality[] VALUES_ARRAY =
    new Cardinality[]
    {
      ONE,
      ZERO,
      ONE_OR_MANY,
      ZERO_OR_MANY,
    };

  /**
   * A public read-only list of all the '<em><b>Cardinality</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final List<Cardinality> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

  /**
   * Returns the '<em><b>Cardinality</b></em>' literal with the specified literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static Cardinality get(String literal)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      Cardinality result = VALUES_ARRAY[i];
      if (result.toString().equals(literal))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Cardinality</b></em>' literal with the specified name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static Cardinality getByName(String name)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      Cardinality result = VALUES_ARRAY[i];
      if (result.getName().equals(name))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Cardinality</b></em>' literal with the specified integer value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static Cardinality get(int value)
  {
    switch (value)
    {
      case ONE_VALUE: return ONE;
      case ZERO_VALUE: return ZERO;
      case ONE_OR_MANY_VALUE: return ONE_OR_MANY;
      case ZERO_OR_MANY_VALUE: return ZERO_OR_MANY;
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
  private Cardinality(int value, String name, String literal)
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
  
} //Cardinality
