/**
 */
package br.ufmg.dcc.asml.aSMLModel;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Wild Card</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see br.ufmg.dcc.asml.aSMLModel.ASMLModelPackage#getWildCard()
 * @model
 * @generated
 */
public enum WildCard implements Enumerator
{
  /**
   * The '<em><b>Package</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #PACKAGE_VALUE
   * @generated
   * @ordered
   */
  PACKAGE(0, "Package", ".*"),

  /**
   * The '<em><b>Package And Sub Package</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #PACKAGE_AND_SUB_PACKAGE_VALUE
   * @generated
   * @ordered
   */
  PACKAGE_AND_SUB_PACKAGE(1, "PackageAndSubPackage", ".**");

  /**
   * The '<em><b>Package</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Package</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #PACKAGE
   * @model name="Package" literal=".*"
   * @generated
   * @ordered
   */
  public static final int PACKAGE_VALUE = 0;

  /**
   * The '<em><b>Package And Sub Package</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Package And Sub Package</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #PACKAGE_AND_SUB_PACKAGE
   * @model name="PackageAndSubPackage" literal=".**"
   * @generated
   * @ordered
   */
  public static final int PACKAGE_AND_SUB_PACKAGE_VALUE = 1;

  /**
   * An array of all the '<em><b>Wild Card</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static final WildCard[] VALUES_ARRAY =
    new WildCard[]
    {
      PACKAGE,
      PACKAGE_AND_SUB_PACKAGE,
    };

  /**
   * A public read-only list of all the '<em><b>Wild Card</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final List<WildCard> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

  /**
   * Returns the '<em><b>Wild Card</b></em>' literal with the specified literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static WildCard get(String literal)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      WildCard result = VALUES_ARRAY[i];
      if (result.toString().equals(literal))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Wild Card</b></em>' literal with the specified name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static WildCard getByName(String name)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      WildCard result = VALUES_ARRAY[i];
      if (result.getName().equals(name))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Wild Card</b></em>' literal with the specified integer value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static WildCard get(int value)
  {
    switch (value)
    {
      case PACKAGE_VALUE: return PACKAGE;
      case PACKAGE_AND_SUB_PACKAGE_VALUE: return PACKAGE_AND_SUB_PACKAGE;
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
  private WildCard(int value, String name, String literal)
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
  
} //WildCard
