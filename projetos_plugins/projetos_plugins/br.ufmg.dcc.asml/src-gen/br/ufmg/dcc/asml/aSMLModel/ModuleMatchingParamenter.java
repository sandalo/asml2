/**
 */
package br.ufmg.dcc.asml.aSMLModel;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Module Matching Paramenter</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see br.ufmg.dcc.asml.aSMLModel.ASMLModelPackage#getModuleMatchingParamenter()
 * @model
 * @generated
 */
public enum ModuleMatchingParamenter implements Enumerator
{
  /**
   * The '<em><b>PAKCAGE</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #PAKCAGE_VALUE
   * @generated
   * @ordered
   */
  PAKCAGE(0, "PAKCAGE", "by package name"),

  /**
   * The '<em><b>FOLDER</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #FOLDER_VALUE
   * @generated
   * @ordered
   */
  FOLDER(1, "FOLDER", "by folder name"),

  /**
   * The '<em><b>PAKCAGE AND FOLDER</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #PAKCAGE_AND_FOLDER_VALUE
   * @generated
   * @ordered
   */
  PAKCAGE_AND_FOLDER(2, "PAKCAGE_AND_FOLDER", "by package and folder name"),

  /**
   * The '<em><b>EXTERNAL DEFINITION</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #EXTERNAL_DEFINITION_VALUE
   * @generated
   * @ordered
   */
  EXTERNAL_DEFINITION(3, "EXTERNAL_DEFINITION", "by external implementation");

  /**
   * The '<em><b>PAKCAGE</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>PAKCAGE</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #PAKCAGE
   * @model literal="by package name"
   * @generated
   * @ordered
   */
  public static final int PAKCAGE_VALUE = 0;

  /**
   * The '<em><b>FOLDER</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>FOLDER</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #FOLDER
   * @model literal="by folder name"
   * @generated
   * @ordered
   */
  public static final int FOLDER_VALUE = 1;

  /**
   * The '<em><b>PAKCAGE AND FOLDER</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>PAKCAGE AND FOLDER</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #PAKCAGE_AND_FOLDER
   * @model literal="by package and folder name"
   * @generated
   * @ordered
   */
  public static final int PAKCAGE_AND_FOLDER_VALUE = 2;

  /**
   * The '<em><b>EXTERNAL DEFINITION</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>EXTERNAL DEFINITION</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #EXTERNAL_DEFINITION
   * @model literal="by external implementation"
   * @generated
   * @ordered
   */
  public static final int EXTERNAL_DEFINITION_VALUE = 3;

  /**
   * An array of all the '<em><b>Module Matching Paramenter</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static final ModuleMatchingParamenter[] VALUES_ARRAY =
    new ModuleMatchingParamenter[]
    {
      PAKCAGE,
      FOLDER,
      PAKCAGE_AND_FOLDER,
      EXTERNAL_DEFINITION,
    };

  /**
   * A public read-only list of all the '<em><b>Module Matching Paramenter</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final List<ModuleMatchingParamenter> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

  /**
   * Returns the '<em><b>Module Matching Paramenter</b></em>' literal with the specified literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static ModuleMatchingParamenter get(String literal)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      ModuleMatchingParamenter result = VALUES_ARRAY[i];
      if (result.toString().equals(literal))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Module Matching Paramenter</b></em>' literal with the specified name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static ModuleMatchingParamenter getByName(String name)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      ModuleMatchingParamenter result = VALUES_ARRAY[i];
      if (result.getName().equals(name))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Module Matching Paramenter</b></em>' literal with the specified integer value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static ModuleMatchingParamenter get(int value)
  {
    switch (value)
    {
      case PAKCAGE_VALUE: return PAKCAGE;
      case FOLDER_VALUE: return FOLDER;
      case PAKCAGE_AND_FOLDER_VALUE: return PAKCAGE_AND_FOLDER;
      case EXTERNAL_DEFINITION_VALUE: return EXTERNAL_DEFINITION;
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
  private ModuleMatchingParamenter(int value, String name, String literal)
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
  
} //ModuleMatchingParamenter
