/**
 */
package br.ufmg.dcc.asml.aSMLModel;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Relaction Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see br.ufmg.dcc.asml.aSMLModel.ASMLModelPackage#getRelactionType()
 * @model
 * @generated
 */
public enum RelactionType implements Enumerator
{
  /**
   * The '<em><b>ACCESS</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #ACCESS_VALUE
   * @generated
   * @ordered
   */
  ACCESS(0, "ACCESS", "access"),

  /**
   * The '<em><b>DECLARE</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #DECLARE_VALUE
   * @generated
   * @ordered
   */
  DECLARE(1, "DECLARE", "declare"),

  /**
   * The '<em><b>HANDLE</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #HANDLE_VALUE
   * @generated
   * @ordered
   */
  HANDLE(2, "HANDLE", "handle"),

  /**
   * The '<em><b>EXTEND</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #EXTEND_VALUE
   * @generated
   * @ordered
   */
  EXTEND(3, "EXTEND", "extend"),

  /**
   * The '<em><b>IMPLEMENT</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #IMPLEMENT_VALUE
   * @generated
   * @ordered
   */
  IMPLEMENT(4, "IMPLEMENT", "implement"),

  /**
   * The '<em><b>CREATE</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #CREATE_VALUE
   * @generated
   * @ordered
   */
  CREATE(5, "CREATE", "create"),

  /**
   * The '<em><b>THROW</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #THROW_VALUE
   * @generated
   * @ordered
   */
  THROW(6, "THROW", "throw"),

  /**
   * The '<em><b>USEANOTATION</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #USEANOTATION_VALUE
   * @generated
   * @ordered
   */
  USEANOTATION(7, "USEANOTATION", "use-annotation"),

  /**
   * The '<em><b>DEPEND</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #DEPEND_VALUE
   * @generated
   * @ordered
   */
  DEPEND(8, "DEPEND", "depend"),

  /**
   * The '<em><b>REQUIRES</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #REQUIRES_VALUE
   * @generated
   * @ordered
   */
  REQUIRES(9, "REQUIRES", "requires");

  /**
   * The '<em><b>ACCESS</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>ACCESS</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #ACCESS
   * @model literal="access"
   * @generated
   * @ordered
   */
  public static final int ACCESS_VALUE = 0;

  /**
   * The '<em><b>DECLARE</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>DECLARE</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #DECLARE
   * @model literal="declare"
   * @generated
   * @ordered
   */
  public static final int DECLARE_VALUE = 1;

  /**
   * The '<em><b>HANDLE</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>HANDLE</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #HANDLE
   * @model literal="handle"
   * @generated
   * @ordered
   */
  public static final int HANDLE_VALUE = 2;

  /**
   * The '<em><b>EXTEND</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>EXTEND</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #EXTEND
   * @model literal="extend"
   * @generated
   * @ordered
   */
  public static final int EXTEND_VALUE = 3;

  /**
   * The '<em><b>IMPLEMENT</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>IMPLEMENT</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #IMPLEMENT
   * @model literal="implement"
   * @generated
   * @ordered
   */
  public static final int IMPLEMENT_VALUE = 4;

  /**
   * The '<em><b>CREATE</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>CREATE</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #CREATE
   * @model literal="create"
   * @generated
   * @ordered
   */
  public static final int CREATE_VALUE = 5;

  /**
   * The '<em><b>THROW</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>THROW</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #THROW
   * @model literal="throw"
   * @generated
   * @ordered
   */
  public static final int THROW_VALUE = 6;

  /**
   * The '<em><b>USEANOTATION</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>USEANOTATION</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #USEANOTATION
   * @model literal="use-annotation"
   * @generated
   * @ordered
   */
  public static final int USEANOTATION_VALUE = 7;

  /**
   * The '<em><b>DEPEND</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>DEPEND</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #DEPEND
   * @model literal="depend"
   * @generated
   * @ordered
   */
  public static final int DEPEND_VALUE = 8;

  /**
   * The '<em><b>REQUIRES</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>REQUIRES</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #REQUIRES
   * @model literal="requires"
   * @generated
   * @ordered
   */
  public static final int REQUIRES_VALUE = 9;

  /**
   * An array of all the '<em><b>Relaction Type</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static final RelactionType[] VALUES_ARRAY =
    new RelactionType[]
    {
      ACCESS,
      DECLARE,
      HANDLE,
      EXTEND,
      IMPLEMENT,
      CREATE,
      THROW,
      USEANOTATION,
      DEPEND,
      REQUIRES,
    };

  /**
   * A public read-only list of all the '<em><b>Relaction Type</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final List<RelactionType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

  /**
   * Returns the '<em><b>Relaction Type</b></em>' literal with the specified literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static RelactionType get(String literal)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      RelactionType result = VALUES_ARRAY[i];
      if (result.toString().equals(literal))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Relaction Type</b></em>' literal with the specified name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static RelactionType getByName(String name)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      RelactionType result = VALUES_ARRAY[i];
      if (result.getName().equals(name))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Relaction Type</b></em>' literal with the specified integer value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static RelactionType get(int value)
  {
    switch (value)
    {
      case ACCESS_VALUE: return ACCESS;
      case DECLARE_VALUE: return DECLARE;
      case HANDLE_VALUE: return HANDLE;
      case EXTEND_VALUE: return EXTEND;
      case IMPLEMENT_VALUE: return IMPLEMENT;
      case CREATE_VALUE: return CREATE;
      case THROW_VALUE: return THROW;
      case USEANOTATION_VALUE: return USEANOTATION;
      case DEPEND_VALUE: return DEPEND;
      case REQUIRES_VALUE: return REQUIRES;
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
  private RelactionType(int value, String name, String literal)
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
  
} //RelactionType
