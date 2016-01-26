/**
 */
package br.ufmg.dcc.asml.aSMLModel;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see br.ufmg.dcc.asml.aSMLModel.ASMLModelFactory
 * @model kind="package"
 * @generated
 */
public interface ASMLModelPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "aSMLModel";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.ufmg.br/dcc/asml/ASMLModel";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "aSMLModel";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  ASMLModelPackage eINSTANCE = br.ufmg.dcc.asml.aSMLModel.impl.ASMLModelPackageImpl.init();

  /**
   * The meta object id for the '{@link br.ufmg.dcc.asml.aSMLModel.impl.ASMLModelImpl <em>ASML Model</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see br.ufmg.dcc.asml.aSMLModel.impl.ASMLModelImpl
   * @see br.ufmg.dcc.asml.aSMLModel.impl.ASMLModelPackageImpl#getASMLModel()
   * @generated
   */
  int ASML_MODEL = 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASML_MODEL__NAME = 0;

  /**
   * The feature id for the '<em><b>Import URI</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASML_MODEL__IMPORT_URI = 1;

  /**
   * The feature id for the '<em><b>Components</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASML_MODEL__COMPONENTS = 2;

  /**
   * The feature id for the '<em><b>Ignore</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASML_MODEL__IGNORE = 3;

  /**
   * The number of structural features of the '<em>ASML Model</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASML_MODEL_FEATURE_COUNT = 4;

  /**
   * The meta object id for the '{@link br.ufmg.dcc.asml.aSMLModel.impl.AbstractComponentImpl <em>Abstract Component</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see br.ufmg.dcc.asml.aSMLModel.impl.AbstractComponentImpl
   * @see br.ufmg.dcc.asml.aSMLModel.impl.ASMLModelPackageImpl#getAbstractComponent()
   * @generated
   */
  int ABSTRACT_COMPONENT = 1;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABSTRACT_COMPONENT__NAME = 0;

  /**
   * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABSTRACT_COMPONENT__ATTRIBUTES = 1;

  /**
   * The feature id for the '<em><b>Components</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABSTRACT_COMPONENT__COMPONENTS = 2;

  /**
   * The feature id for the '<em><b>Restrictions</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABSTRACT_COMPONENT__RESTRICTIONS = 3;

  /**
   * The number of structural features of the '<em>Abstract Component</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABSTRACT_COMPONENT_FEATURE_COUNT = 4;

  /**
   * The meta object id for the '{@link br.ufmg.dcc.asml.aSMLModel.impl.ViewImpl <em>View</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see br.ufmg.dcc.asml.aSMLModel.impl.ViewImpl
   * @see br.ufmg.dcc.asml.aSMLModel.impl.ASMLModelPackageImpl#getView()
   * @generated
   */
  int VIEW = 2;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VIEW__NAME = ABSTRACT_COMPONENT__NAME;

  /**
   * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VIEW__ATTRIBUTES = ABSTRACT_COMPONENT__ATTRIBUTES;

  /**
   * The feature id for the '<em><b>Components</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VIEW__COMPONENTS = ABSTRACT_COMPONENT__COMPONENTS;

  /**
   * The feature id for the '<em><b>Restrictions</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VIEW__RESTRICTIONS = ABSTRACT_COMPONENT__RESTRICTIONS;

  /**
   * The number of structural features of the '<em>View</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VIEW_FEATURE_COUNT = ABSTRACT_COMPONENT_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link br.ufmg.dcc.asml.aSMLModel.impl.AttributeImpl <em>Attribute</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see br.ufmg.dcc.asml.aSMLModel.impl.AttributeImpl
   * @see br.ufmg.dcc.asml.aSMLModel.impl.ASMLModelPackageImpl#getAttribute()
   * @generated
   */
  int ATTRIBUTE = 3;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE__NAME = 0;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE__VALUE = 1;

  /**
   * The number of structural features of the '<em>Attribute</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link br.ufmg.dcc.asml.aSMLModel.impl.AbstractNameConvetionImpl <em>Abstract Name Convetion</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see br.ufmg.dcc.asml.aSMLModel.impl.AbstractNameConvetionImpl
   * @see br.ufmg.dcc.asml.aSMLModel.impl.ASMLModelPackageImpl#getAbstractNameConvetion()
   * @generated
   */
  int ABSTRACT_NAME_CONVETION = 4;

  /**
   * The number of structural features of the '<em>Abstract Name Convetion</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABSTRACT_NAME_CONVETION_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link br.ufmg.dcc.asml.aSMLModel.impl.ExpressionMatchingOperatorImpl <em>Expression Matching Operator</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see br.ufmg.dcc.asml.aSMLModel.impl.ExpressionMatchingOperatorImpl
   * @see br.ufmg.dcc.asml.aSMLModel.impl.ASMLModelPackageImpl#getExpressionMatchingOperator()
   * @generated
   */
  int EXPRESSION_MATCHING_OPERATOR = 5;

  /**
   * The feature id for the '<em><b>AND</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION_MATCHING_OPERATOR__AND = 0;

  /**
   * The feature id for the '<em><b>OR</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION_MATCHING_OPERATOR__OR = 1;

  /**
   * The number of structural features of the '<em>Expression Matching Operator</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION_MATCHING_OPERATOR_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link br.ufmg.dcc.asml.aSMLModel.impl.ModuleMatchingImpl <em>Module Matching</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see br.ufmg.dcc.asml.aSMLModel.impl.ModuleMatchingImpl
   * @see br.ufmg.dcc.asml.aSMLModel.impl.ASMLModelPackageImpl#getModuleMatching()
   * @generated
   */
  int MODULE_MATCHING = 6;

  /**
   * The feature id for the '<em><b>Parameter</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODULE_MATCHING__PARAMETER = 0;

  /**
   * The number of structural features of the '<em>Module Matching</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODULE_MATCHING_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link br.ufmg.dcc.asml.aSMLModel.impl.ClassMatchingImpl <em>Class Matching</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see br.ufmg.dcc.asml.aSMLModel.impl.ClassMatchingImpl
   * @see br.ufmg.dcc.asml.aSMLModel.impl.ASMLModelPackageImpl#getClassMatching()
   * @generated
   */
  int CLASS_MATCHING = 7;

  /**
   * The feature id for the '<em><b>Expression Matching</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASS_MATCHING__EXPRESSION_MATCHING = ABSTRACT_NAME_CONVETION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Parameter</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASS_MATCHING__PARAMETER = ABSTRACT_NAME_CONVETION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Class Matching</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASS_MATCHING_FEATURE_COUNT = ABSTRACT_NAME_CONVETION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link br.ufmg.dcc.asml.aSMLModel.impl.MetaModuleImpl <em>Meta Module</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see br.ufmg.dcc.asml.aSMLModel.impl.MetaModuleImpl
   * @see br.ufmg.dcc.asml.aSMLModel.impl.ASMLModelPackageImpl#getMetaModule()
   * @generated
   */
  int META_MODULE = 8;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int META_MODULE__NAME = ABSTRACT_COMPONENT__NAME;

  /**
   * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int META_MODULE__ATTRIBUTES = ABSTRACT_COMPONENT__ATTRIBUTES;

  /**
   * The feature id for the '<em><b>Components</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int META_MODULE__COMPONENTS = ABSTRACT_COMPONENT__COMPONENTS;

  /**
   * The feature id for the '<em><b>Restrictions</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int META_MODULE__RESTRICTIONS = ABSTRACT_COMPONENT__RESTRICTIONS;

  /**
   * The feature id for the '<em><b>Matching</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int META_MODULE__MATCHING = ABSTRACT_COMPONENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int META_MODULE__DESCRIPTION = ABSTRACT_COMPONENT_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Meta Module</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int META_MODULE_FEATURE_COUNT = ABSTRACT_COMPONENT_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link br.ufmg.dcc.asml.aSMLModel.impl.RestrictionImpl <em>Restriction</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see br.ufmg.dcc.asml.aSMLModel.impl.RestrictionImpl
   * @see br.ufmg.dcc.asml.aSMLModel.impl.ASMLModelPackageImpl#getRestriction()
   * @generated
   */
  int RESTRICTION = 9;

  /**
   * The feature id for the '<em><b>Group Clause</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RESTRICTION__GROUP_CLAUSE = 0;

  /**
   * The feature id for the '<em><b>Permission Clause</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RESTRICTION__PERMISSION_CLAUSE = 1;

  /**
   * The feature id for the '<em><b>Relaction Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RESTRICTION__RELACTION_TYPE = 2;

  /**
   * The feature id for the '<em><b>Group Clause B</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RESTRICTION__GROUP_CLAUSE_B = 3;

  /**
   * The feature id for the '<em><b>Component B</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RESTRICTION__COMPONENT_B = 4;

  /**
   * The feature id for the '<em><b>Message</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RESTRICTION__MESSAGE = 5;

  /**
   * The number of structural features of the '<em>Restriction</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RESTRICTION_FEATURE_COUNT = 6;

  /**
   * The meta object id for the '{@link br.ufmg.dcc.asml.aSMLModel.impl.ComponentsBinRestrictionDeclareationImpl <em>Components Bin Restriction Declareation</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see br.ufmg.dcc.asml.aSMLModel.impl.ComponentsBinRestrictionDeclareationImpl
   * @see br.ufmg.dcc.asml.aSMLModel.impl.ASMLModelPackageImpl#getComponentsBinRestrictionDeclareation()
   * @generated
   */
  int COMPONENTS_BIN_RESTRICTION_DECLAREATION = 10;

  /**
   * The feature id for the '<em><b>Component B</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPONENTS_BIN_RESTRICTION_DECLAREATION__COMPONENT_B = 0;

  /**
   * The feature id for the '<em><b>Wildcard</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPONENTS_BIN_RESTRICTION_DECLAREATION__WILDCARD = 1;

  /**
   * The number of structural features of the '<em>Components Bin Restriction Declareation</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPONENTS_BIN_RESTRICTION_DECLAREATION_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link br.ufmg.dcc.asml.aSMLModel.Cardinality <em>Cardinality</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see br.ufmg.dcc.asml.aSMLModel.Cardinality
   * @see br.ufmg.dcc.asml.aSMLModel.impl.ASMLModelPackageImpl#getCardinality()
   * @generated
   */
  int CARDINALITY = 11;

  /**
   * The meta object id for the '{@link br.ufmg.dcc.asml.aSMLModel.ExpressionMatchingClause <em>Expression Matching Clause</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see br.ufmg.dcc.asml.aSMLModel.ExpressionMatchingClause
   * @see br.ufmg.dcc.asml.aSMLModel.impl.ASMLModelPackageImpl#getExpressionMatchingClause()
   * @generated
   */
  int EXPRESSION_MATCHING_CLAUSE = 12;

  /**
   * The meta object id for the '{@link br.ufmg.dcc.asml.aSMLModel.ModuleMatchingParamenter <em>Module Matching Paramenter</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see br.ufmg.dcc.asml.aSMLModel.ModuleMatchingParamenter
   * @see br.ufmg.dcc.asml.aSMLModel.impl.ASMLModelPackageImpl#getModuleMatchingParamenter()
   * @generated
   */
  int MODULE_MATCHING_PARAMENTER = 13;

  /**
   * The meta object id for the '{@link br.ufmg.dcc.asml.aSMLModel.GroupClause <em>Group Clause</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see br.ufmg.dcc.asml.aSMLModel.GroupClause
   * @see br.ufmg.dcc.asml.aSMLModel.impl.ASMLModelPackageImpl#getGroupClause()
   * @generated
   */
  int GROUP_CLAUSE = 14;

  /**
   * The meta object id for the '{@link br.ufmg.dcc.asml.aSMLModel.PermissionClause <em>Permission Clause</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see br.ufmg.dcc.asml.aSMLModel.PermissionClause
   * @see br.ufmg.dcc.asml.aSMLModel.impl.ASMLModelPackageImpl#getPermissionClause()
   * @generated
   */
  int PERMISSION_CLAUSE = 15;

  /**
   * The meta object id for the '{@link br.ufmg.dcc.asml.aSMLModel.RelactionType <em>Relaction Type</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see br.ufmg.dcc.asml.aSMLModel.RelactionType
   * @see br.ufmg.dcc.asml.aSMLModel.impl.ASMLModelPackageImpl#getRelactionType()
   * @generated
   */
  int RELACTION_TYPE = 16;

  /**
   * The meta object id for the '{@link br.ufmg.dcc.asml.aSMLModel.WildCard <em>Wild Card</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see br.ufmg.dcc.asml.aSMLModel.WildCard
   * @see br.ufmg.dcc.asml.aSMLModel.impl.ASMLModelPackageImpl#getWildCard()
   * @generated
   */
  int WILD_CARD = 17;


  /**
   * Returns the meta object for class '{@link br.ufmg.dcc.asml.aSMLModel.ASMLModel <em>ASML Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>ASML Model</em>'.
   * @see br.ufmg.dcc.asml.aSMLModel.ASMLModel
   * @generated
   */
  EClass getASMLModel();

  /**
   * Returns the meta object for the attribute '{@link br.ufmg.dcc.asml.aSMLModel.ASMLModel#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see br.ufmg.dcc.asml.aSMLModel.ASMLModel#getName()
   * @see #getASMLModel()
   * @generated
   */
  EAttribute getASMLModel_Name();

  /**
   * Returns the meta object for the attribute '{@link br.ufmg.dcc.asml.aSMLModel.ASMLModel#getImportURI <em>Import URI</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Import URI</em>'.
   * @see br.ufmg.dcc.asml.aSMLModel.ASMLModel#getImportURI()
   * @see #getASMLModel()
   * @generated
   */
  EAttribute getASMLModel_ImportURI();

  /**
   * Returns the meta object for the containment reference list '{@link br.ufmg.dcc.asml.aSMLModel.ASMLModel#getComponents <em>Components</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Components</em>'.
   * @see br.ufmg.dcc.asml.aSMLModel.ASMLModel#getComponents()
   * @see #getASMLModel()
   * @generated
   */
  EReference getASMLModel_Components();

  /**
   * Returns the meta object for the attribute list '{@link br.ufmg.dcc.asml.aSMLModel.ASMLModel#getIgnore <em>Ignore</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Ignore</em>'.
   * @see br.ufmg.dcc.asml.aSMLModel.ASMLModel#getIgnore()
   * @see #getASMLModel()
   * @generated
   */
  EAttribute getASMLModel_Ignore();

  /**
   * Returns the meta object for class '{@link br.ufmg.dcc.asml.aSMLModel.AbstractComponent <em>Abstract Component</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Abstract Component</em>'.
   * @see br.ufmg.dcc.asml.aSMLModel.AbstractComponent
   * @generated
   */
  EClass getAbstractComponent();

  /**
   * Returns the meta object for the attribute '{@link br.ufmg.dcc.asml.aSMLModel.AbstractComponent#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see br.ufmg.dcc.asml.aSMLModel.AbstractComponent#getName()
   * @see #getAbstractComponent()
   * @generated
   */
  EAttribute getAbstractComponent_Name();

  /**
   * Returns the meta object for the containment reference list '{@link br.ufmg.dcc.asml.aSMLModel.AbstractComponent#getAttributes <em>Attributes</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Attributes</em>'.
   * @see br.ufmg.dcc.asml.aSMLModel.AbstractComponent#getAttributes()
   * @see #getAbstractComponent()
   * @generated
   */
  EReference getAbstractComponent_Attributes();

  /**
   * Returns the meta object for the containment reference list '{@link br.ufmg.dcc.asml.aSMLModel.AbstractComponent#getComponents <em>Components</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Components</em>'.
   * @see br.ufmg.dcc.asml.aSMLModel.AbstractComponent#getComponents()
   * @see #getAbstractComponent()
   * @generated
   */
  EReference getAbstractComponent_Components();

  /**
   * Returns the meta object for the containment reference list '{@link br.ufmg.dcc.asml.aSMLModel.AbstractComponent#getRestrictions <em>Restrictions</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Restrictions</em>'.
   * @see br.ufmg.dcc.asml.aSMLModel.AbstractComponent#getRestrictions()
   * @see #getAbstractComponent()
   * @generated
   */
  EReference getAbstractComponent_Restrictions();

  /**
   * Returns the meta object for class '{@link br.ufmg.dcc.asml.aSMLModel.View <em>View</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>View</em>'.
   * @see br.ufmg.dcc.asml.aSMLModel.View
   * @generated
   */
  EClass getView();

  /**
   * Returns the meta object for class '{@link br.ufmg.dcc.asml.aSMLModel.Attribute <em>Attribute</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Attribute</em>'.
   * @see br.ufmg.dcc.asml.aSMLModel.Attribute
   * @generated
   */
  EClass getAttribute();

  /**
   * Returns the meta object for the attribute '{@link br.ufmg.dcc.asml.aSMLModel.Attribute#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see br.ufmg.dcc.asml.aSMLModel.Attribute#getName()
   * @see #getAttribute()
   * @generated
   */
  EAttribute getAttribute_Name();

  /**
   * Returns the meta object for the attribute '{@link br.ufmg.dcc.asml.aSMLModel.Attribute#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see br.ufmg.dcc.asml.aSMLModel.Attribute#getValue()
   * @see #getAttribute()
   * @generated
   */
  EAttribute getAttribute_Value();

  /**
   * Returns the meta object for class '{@link br.ufmg.dcc.asml.aSMLModel.AbstractNameConvetion <em>Abstract Name Convetion</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Abstract Name Convetion</em>'.
   * @see br.ufmg.dcc.asml.aSMLModel.AbstractNameConvetion
   * @generated
   */
  EClass getAbstractNameConvetion();

  /**
   * Returns the meta object for class '{@link br.ufmg.dcc.asml.aSMLModel.ExpressionMatchingOperator <em>Expression Matching Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Expression Matching Operator</em>'.
   * @see br.ufmg.dcc.asml.aSMLModel.ExpressionMatchingOperator
   * @generated
   */
  EClass getExpressionMatchingOperator();

  /**
   * Returns the meta object for the attribute '{@link br.ufmg.dcc.asml.aSMLModel.ExpressionMatchingOperator#getAND <em>AND</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>AND</em>'.
   * @see br.ufmg.dcc.asml.aSMLModel.ExpressionMatchingOperator#getAND()
   * @see #getExpressionMatchingOperator()
   * @generated
   */
  EAttribute getExpressionMatchingOperator_AND();

  /**
   * Returns the meta object for the attribute '{@link br.ufmg.dcc.asml.aSMLModel.ExpressionMatchingOperator#getOR <em>OR</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>OR</em>'.
   * @see br.ufmg.dcc.asml.aSMLModel.ExpressionMatchingOperator#getOR()
   * @see #getExpressionMatchingOperator()
   * @generated
   */
  EAttribute getExpressionMatchingOperator_OR();

  /**
   * Returns the meta object for class '{@link br.ufmg.dcc.asml.aSMLModel.ModuleMatching <em>Module Matching</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Module Matching</em>'.
   * @see br.ufmg.dcc.asml.aSMLModel.ModuleMatching
   * @generated
   */
  EClass getModuleMatching();

  /**
   * Returns the meta object for the attribute '{@link br.ufmg.dcc.asml.aSMLModel.ModuleMatching#getParameter <em>Parameter</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Parameter</em>'.
   * @see br.ufmg.dcc.asml.aSMLModel.ModuleMatching#getParameter()
   * @see #getModuleMatching()
   * @generated
   */
  EAttribute getModuleMatching_Parameter();

  /**
   * Returns the meta object for class '{@link br.ufmg.dcc.asml.aSMLModel.ClassMatching <em>Class Matching</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Class Matching</em>'.
   * @see br.ufmg.dcc.asml.aSMLModel.ClassMatching
   * @generated
   */
  EClass getClassMatching();

  /**
   * Returns the meta object for the attribute '{@link br.ufmg.dcc.asml.aSMLModel.ClassMatching#getExpressionMatching <em>Expression Matching</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Expression Matching</em>'.
   * @see br.ufmg.dcc.asml.aSMLModel.ClassMatching#getExpressionMatching()
   * @see #getClassMatching()
   * @generated
   */
  EAttribute getClassMatching_ExpressionMatching();

  /**
   * Returns the meta object for the attribute '{@link br.ufmg.dcc.asml.aSMLModel.ClassMatching#getParameter <em>Parameter</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Parameter</em>'.
   * @see br.ufmg.dcc.asml.aSMLModel.ClassMatching#getParameter()
   * @see #getClassMatching()
   * @generated
   */
  EAttribute getClassMatching_Parameter();

  /**
   * Returns the meta object for class '{@link br.ufmg.dcc.asml.aSMLModel.MetaModule <em>Meta Module</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Meta Module</em>'.
   * @see br.ufmg.dcc.asml.aSMLModel.MetaModule
   * @generated
   */
  EClass getMetaModule();

  /**
   * Returns the meta object for the attribute '{@link br.ufmg.dcc.asml.aSMLModel.MetaModule#getMatching <em>Matching</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Matching</em>'.
   * @see br.ufmg.dcc.asml.aSMLModel.MetaModule#getMatching()
   * @see #getMetaModule()
   * @generated
   */
  EAttribute getMetaModule_Matching();

  /**
   * Returns the meta object for the attribute '{@link br.ufmg.dcc.asml.aSMLModel.MetaModule#getDescription <em>Description</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Description</em>'.
   * @see br.ufmg.dcc.asml.aSMLModel.MetaModule#getDescription()
   * @see #getMetaModule()
   * @generated
   */
  EAttribute getMetaModule_Description();

  /**
   * Returns the meta object for class '{@link br.ufmg.dcc.asml.aSMLModel.Restriction <em>Restriction</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Restriction</em>'.
   * @see br.ufmg.dcc.asml.aSMLModel.Restriction
   * @generated
   */
  EClass getRestriction();

  /**
   * Returns the meta object for the attribute '{@link br.ufmg.dcc.asml.aSMLModel.Restriction#getGroupClause <em>Group Clause</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Group Clause</em>'.
   * @see br.ufmg.dcc.asml.aSMLModel.Restriction#getGroupClause()
   * @see #getRestriction()
   * @generated
   */
  EAttribute getRestriction_GroupClause();

  /**
   * Returns the meta object for the attribute '{@link br.ufmg.dcc.asml.aSMLModel.Restriction#getPermissionClause <em>Permission Clause</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Permission Clause</em>'.
   * @see br.ufmg.dcc.asml.aSMLModel.Restriction#getPermissionClause()
   * @see #getRestriction()
   * @generated
   */
  EAttribute getRestriction_PermissionClause();

  /**
   * Returns the meta object for the attribute '{@link br.ufmg.dcc.asml.aSMLModel.Restriction#getRelactionType <em>Relaction Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Relaction Type</em>'.
   * @see br.ufmg.dcc.asml.aSMLModel.Restriction#getRelactionType()
   * @see #getRestriction()
   * @generated
   */
  EAttribute getRestriction_RelactionType();

  /**
   * Returns the meta object for the attribute '{@link br.ufmg.dcc.asml.aSMLModel.Restriction#getGroupClauseB <em>Group Clause B</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Group Clause B</em>'.
   * @see br.ufmg.dcc.asml.aSMLModel.Restriction#getGroupClauseB()
   * @see #getRestriction()
   * @generated
   */
  EAttribute getRestriction_GroupClauseB();

  /**
   * Returns the meta object for the containment reference list '{@link br.ufmg.dcc.asml.aSMLModel.Restriction#getComponentB <em>Component B</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Component B</em>'.
   * @see br.ufmg.dcc.asml.aSMLModel.Restriction#getComponentB()
   * @see #getRestriction()
   * @generated
   */
  EReference getRestriction_ComponentB();

  /**
   * Returns the meta object for the attribute '{@link br.ufmg.dcc.asml.aSMLModel.Restriction#getMessage <em>Message</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Message</em>'.
   * @see br.ufmg.dcc.asml.aSMLModel.Restriction#getMessage()
   * @see #getRestriction()
   * @generated
   */
  EAttribute getRestriction_Message();

  /**
   * Returns the meta object for class '{@link br.ufmg.dcc.asml.aSMLModel.ComponentsBinRestrictionDeclareation <em>Components Bin Restriction Declareation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Components Bin Restriction Declareation</em>'.
   * @see br.ufmg.dcc.asml.aSMLModel.ComponentsBinRestrictionDeclareation
   * @generated
   */
  EClass getComponentsBinRestrictionDeclareation();

  /**
   * Returns the meta object for the reference '{@link br.ufmg.dcc.asml.aSMLModel.ComponentsBinRestrictionDeclareation#getComponentB <em>Component B</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Component B</em>'.
   * @see br.ufmg.dcc.asml.aSMLModel.ComponentsBinRestrictionDeclareation#getComponentB()
   * @see #getComponentsBinRestrictionDeclareation()
   * @generated
   */
  EReference getComponentsBinRestrictionDeclareation_ComponentB();

  /**
   * Returns the meta object for the attribute '{@link br.ufmg.dcc.asml.aSMLModel.ComponentsBinRestrictionDeclareation#getWildcard <em>Wildcard</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Wildcard</em>'.
   * @see br.ufmg.dcc.asml.aSMLModel.ComponentsBinRestrictionDeclareation#getWildcard()
   * @see #getComponentsBinRestrictionDeclareation()
   * @generated
   */
  EAttribute getComponentsBinRestrictionDeclareation_Wildcard();

  /**
   * Returns the meta object for enum '{@link br.ufmg.dcc.asml.aSMLModel.Cardinality <em>Cardinality</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Cardinality</em>'.
   * @see br.ufmg.dcc.asml.aSMLModel.Cardinality
   * @generated
   */
  EEnum getCardinality();

  /**
   * Returns the meta object for enum '{@link br.ufmg.dcc.asml.aSMLModel.ExpressionMatchingClause <em>Expression Matching Clause</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Expression Matching Clause</em>'.
   * @see br.ufmg.dcc.asml.aSMLModel.ExpressionMatchingClause
   * @generated
   */
  EEnum getExpressionMatchingClause();

  /**
   * Returns the meta object for enum '{@link br.ufmg.dcc.asml.aSMLModel.ModuleMatchingParamenter <em>Module Matching Paramenter</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Module Matching Paramenter</em>'.
   * @see br.ufmg.dcc.asml.aSMLModel.ModuleMatchingParamenter
   * @generated
   */
  EEnum getModuleMatchingParamenter();

  /**
   * Returns the meta object for enum '{@link br.ufmg.dcc.asml.aSMLModel.GroupClause <em>Group Clause</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Group Clause</em>'.
   * @see br.ufmg.dcc.asml.aSMLModel.GroupClause
   * @generated
   */
  EEnum getGroupClause();

  /**
   * Returns the meta object for enum '{@link br.ufmg.dcc.asml.aSMLModel.PermissionClause <em>Permission Clause</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Permission Clause</em>'.
   * @see br.ufmg.dcc.asml.aSMLModel.PermissionClause
   * @generated
   */
  EEnum getPermissionClause();

  /**
   * Returns the meta object for enum '{@link br.ufmg.dcc.asml.aSMLModel.RelactionType <em>Relaction Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Relaction Type</em>'.
   * @see br.ufmg.dcc.asml.aSMLModel.RelactionType
   * @generated
   */
  EEnum getRelactionType();

  /**
   * Returns the meta object for enum '{@link br.ufmg.dcc.asml.aSMLModel.WildCard <em>Wild Card</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Wild Card</em>'.
   * @see br.ufmg.dcc.asml.aSMLModel.WildCard
   * @generated
   */
  EEnum getWildCard();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  ASMLModelFactory getASMLModelFactory();

  /**
   * <!-- begin-user-doc -->
   * Defines literals for the meta objects that represent
   * <ul>
   *   <li>each class,</li>
   *   <li>each feature of each class,</li>
   *   <li>each enum,</li>
   *   <li>and each data type</li>
   * </ul>
   * <!-- end-user-doc -->
   * @generated
   */
  interface Literals
  {
    /**
     * The meta object literal for the '{@link br.ufmg.dcc.asml.aSMLModel.impl.ASMLModelImpl <em>ASML Model</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see br.ufmg.dcc.asml.aSMLModel.impl.ASMLModelImpl
     * @see br.ufmg.dcc.asml.aSMLModel.impl.ASMLModelPackageImpl#getASMLModel()
     * @generated
     */
    EClass ASML_MODEL = eINSTANCE.getASMLModel();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ASML_MODEL__NAME = eINSTANCE.getASMLModel_Name();

    /**
     * The meta object literal for the '<em><b>Import URI</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ASML_MODEL__IMPORT_URI = eINSTANCE.getASMLModel_ImportURI();

    /**
     * The meta object literal for the '<em><b>Components</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ASML_MODEL__COMPONENTS = eINSTANCE.getASMLModel_Components();

    /**
     * The meta object literal for the '<em><b>Ignore</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ASML_MODEL__IGNORE = eINSTANCE.getASMLModel_Ignore();

    /**
     * The meta object literal for the '{@link br.ufmg.dcc.asml.aSMLModel.impl.AbstractComponentImpl <em>Abstract Component</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see br.ufmg.dcc.asml.aSMLModel.impl.AbstractComponentImpl
     * @see br.ufmg.dcc.asml.aSMLModel.impl.ASMLModelPackageImpl#getAbstractComponent()
     * @generated
     */
    EClass ABSTRACT_COMPONENT = eINSTANCE.getAbstractComponent();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ABSTRACT_COMPONENT__NAME = eINSTANCE.getAbstractComponent_Name();

    /**
     * The meta object literal for the '<em><b>Attributes</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ABSTRACT_COMPONENT__ATTRIBUTES = eINSTANCE.getAbstractComponent_Attributes();

    /**
     * The meta object literal for the '<em><b>Components</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ABSTRACT_COMPONENT__COMPONENTS = eINSTANCE.getAbstractComponent_Components();

    /**
     * The meta object literal for the '<em><b>Restrictions</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ABSTRACT_COMPONENT__RESTRICTIONS = eINSTANCE.getAbstractComponent_Restrictions();

    /**
     * The meta object literal for the '{@link br.ufmg.dcc.asml.aSMLModel.impl.ViewImpl <em>View</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see br.ufmg.dcc.asml.aSMLModel.impl.ViewImpl
     * @see br.ufmg.dcc.asml.aSMLModel.impl.ASMLModelPackageImpl#getView()
     * @generated
     */
    EClass VIEW = eINSTANCE.getView();

    /**
     * The meta object literal for the '{@link br.ufmg.dcc.asml.aSMLModel.impl.AttributeImpl <em>Attribute</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see br.ufmg.dcc.asml.aSMLModel.impl.AttributeImpl
     * @see br.ufmg.dcc.asml.aSMLModel.impl.ASMLModelPackageImpl#getAttribute()
     * @generated
     */
    EClass ATTRIBUTE = eINSTANCE.getAttribute();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ATTRIBUTE__NAME = eINSTANCE.getAttribute_Name();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ATTRIBUTE__VALUE = eINSTANCE.getAttribute_Value();

    /**
     * The meta object literal for the '{@link br.ufmg.dcc.asml.aSMLModel.impl.AbstractNameConvetionImpl <em>Abstract Name Convetion</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see br.ufmg.dcc.asml.aSMLModel.impl.AbstractNameConvetionImpl
     * @see br.ufmg.dcc.asml.aSMLModel.impl.ASMLModelPackageImpl#getAbstractNameConvetion()
     * @generated
     */
    EClass ABSTRACT_NAME_CONVETION = eINSTANCE.getAbstractNameConvetion();

    /**
     * The meta object literal for the '{@link br.ufmg.dcc.asml.aSMLModel.impl.ExpressionMatchingOperatorImpl <em>Expression Matching Operator</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see br.ufmg.dcc.asml.aSMLModel.impl.ExpressionMatchingOperatorImpl
     * @see br.ufmg.dcc.asml.aSMLModel.impl.ASMLModelPackageImpl#getExpressionMatchingOperator()
     * @generated
     */
    EClass EXPRESSION_MATCHING_OPERATOR = eINSTANCE.getExpressionMatchingOperator();

    /**
     * The meta object literal for the '<em><b>AND</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute EXPRESSION_MATCHING_OPERATOR__AND = eINSTANCE.getExpressionMatchingOperator_AND();

    /**
     * The meta object literal for the '<em><b>OR</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute EXPRESSION_MATCHING_OPERATOR__OR = eINSTANCE.getExpressionMatchingOperator_OR();

    /**
     * The meta object literal for the '{@link br.ufmg.dcc.asml.aSMLModel.impl.ModuleMatchingImpl <em>Module Matching</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see br.ufmg.dcc.asml.aSMLModel.impl.ModuleMatchingImpl
     * @see br.ufmg.dcc.asml.aSMLModel.impl.ASMLModelPackageImpl#getModuleMatching()
     * @generated
     */
    EClass MODULE_MATCHING = eINSTANCE.getModuleMatching();

    /**
     * The meta object literal for the '<em><b>Parameter</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MODULE_MATCHING__PARAMETER = eINSTANCE.getModuleMatching_Parameter();

    /**
     * The meta object literal for the '{@link br.ufmg.dcc.asml.aSMLModel.impl.ClassMatchingImpl <em>Class Matching</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see br.ufmg.dcc.asml.aSMLModel.impl.ClassMatchingImpl
     * @see br.ufmg.dcc.asml.aSMLModel.impl.ASMLModelPackageImpl#getClassMatching()
     * @generated
     */
    EClass CLASS_MATCHING = eINSTANCE.getClassMatching();

    /**
     * The meta object literal for the '<em><b>Expression Matching</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CLASS_MATCHING__EXPRESSION_MATCHING = eINSTANCE.getClassMatching_ExpressionMatching();

    /**
     * The meta object literal for the '<em><b>Parameter</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CLASS_MATCHING__PARAMETER = eINSTANCE.getClassMatching_Parameter();

    /**
     * The meta object literal for the '{@link br.ufmg.dcc.asml.aSMLModel.impl.MetaModuleImpl <em>Meta Module</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see br.ufmg.dcc.asml.aSMLModel.impl.MetaModuleImpl
     * @see br.ufmg.dcc.asml.aSMLModel.impl.ASMLModelPackageImpl#getMetaModule()
     * @generated
     */
    EClass META_MODULE = eINSTANCE.getMetaModule();

    /**
     * The meta object literal for the '<em><b>Matching</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute META_MODULE__MATCHING = eINSTANCE.getMetaModule_Matching();

    /**
     * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute META_MODULE__DESCRIPTION = eINSTANCE.getMetaModule_Description();

    /**
     * The meta object literal for the '{@link br.ufmg.dcc.asml.aSMLModel.impl.RestrictionImpl <em>Restriction</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see br.ufmg.dcc.asml.aSMLModel.impl.RestrictionImpl
     * @see br.ufmg.dcc.asml.aSMLModel.impl.ASMLModelPackageImpl#getRestriction()
     * @generated
     */
    EClass RESTRICTION = eINSTANCE.getRestriction();

    /**
     * The meta object literal for the '<em><b>Group Clause</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RESTRICTION__GROUP_CLAUSE = eINSTANCE.getRestriction_GroupClause();

    /**
     * The meta object literal for the '<em><b>Permission Clause</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RESTRICTION__PERMISSION_CLAUSE = eINSTANCE.getRestriction_PermissionClause();

    /**
     * The meta object literal for the '<em><b>Relaction Type</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RESTRICTION__RELACTION_TYPE = eINSTANCE.getRestriction_RelactionType();

    /**
     * The meta object literal for the '<em><b>Group Clause B</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RESTRICTION__GROUP_CLAUSE_B = eINSTANCE.getRestriction_GroupClauseB();

    /**
     * The meta object literal for the '<em><b>Component B</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RESTRICTION__COMPONENT_B = eINSTANCE.getRestriction_ComponentB();

    /**
     * The meta object literal for the '<em><b>Message</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RESTRICTION__MESSAGE = eINSTANCE.getRestriction_Message();

    /**
     * The meta object literal for the '{@link br.ufmg.dcc.asml.aSMLModel.impl.ComponentsBinRestrictionDeclareationImpl <em>Components Bin Restriction Declareation</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see br.ufmg.dcc.asml.aSMLModel.impl.ComponentsBinRestrictionDeclareationImpl
     * @see br.ufmg.dcc.asml.aSMLModel.impl.ASMLModelPackageImpl#getComponentsBinRestrictionDeclareation()
     * @generated
     */
    EClass COMPONENTS_BIN_RESTRICTION_DECLAREATION = eINSTANCE.getComponentsBinRestrictionDeclareation();

    /**
     * The meta object literal for the '<em><b>Component B</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference COMPONENTS_BIN_RESTRICTION_DECLAREATION__COMPONENT_B = eINSTANCE.getComponentsBinRestrictionDeclareation_ComponentB();

    /**
     * The meta object literal for the '<em><b>Wildcard</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute COMPONENTS_BIN_RESTRICTION_DECLAREATION__WILDCARD = eINSTANCE.getComponentsBinRestrictionDeclareation_Wildcard();

    /**
     * The meta object literal for the '{@link br.ufmg.dcc.asml.aSMLModel.Cardinality <em>Cardinality</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see br.ufmg.dcc.asml.aSMLModel.Cardinality
     * @see br.ufmg.dcc.asml.aSMLModel.impl.ASMLModelPackageImpl#getCardinality()
     * @generated
     */
    EEnum CARDINALITY = eINSTANCE.getCardinality();

    /**
     * The meta object literal for the '{@link br.ufmg.dcc.asml.aSMLModel.ExpressionMatchingClause <em>Expression Matching Clause</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see br.ufmg.dcc.asml.aSMLModel.ExpressionMatchingClause
     * @see br.ufmg.dcc.asml.aSMLModel.impl.ASMLModelPackageImpl#getExpressionMatchingClause()
     * @generated
     */
    EEnum EXPRESSION_MATCHING_CLAUSE = eINSTANCE.getExpressionMatchingClause();

    /**
     * The meta object literal for the '{@link br.ufmg.dcc.asml.aSMLModel.ModuleMatchingParamenter <em>Module Matching Paramenter</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see br.ufmg.dcc.asml.aSMLModel.ModuleMatchingParamenter
     * @see br.ufmg.dcc.asml.aSMLModel.impl.ASMLModelPackageImpl#getModuleMatchingParamenter()
     * @generated
     */
    EEnum MODULE_MATCHING_PARAMENTER = eINSTANCE.getModuleMatchingParamenter();

    /**
     * The meta object literal for the '{@link br.ufmg.dcc.asml.aSMLModel.GroupClause <em>Group Clause</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see br.ufmg.dcc.asml.aSMLModel.GroupClause
     * @see br.ufmg.dcc.asml.aSMLModel.impl.ASMLModelPackageImpl#getGroupClause()
     * @generated
     */
    EEnum GROUP_CLAUSE = eINSTANCE.getGroupClause();

    /**
     * The meta object literal for the '{@link br.ufmg.dcc.asml.aSMLModel.PermissionClause <em>Permission Clause</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see br.ufmg.dcc.asml.aSMLModel.PermissionClause
     * @see br.ufmg.dcc.asml.aSMLModel.impl.ASMLModelPackageImpl#getPermissionClause()
     * @generated
     */
    EEnum PERMISSION_CLAUSE = eINSTANCE.getPermissionClause();

    /**
     * The meta object literal for the '{@link br.ufmg.dcc.asml.aSMLModel.RelactionType <em>Relaction Type</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see br.ufmg.dcc.asml.aSMLModel.RelactionType
     * @see br.ufmg.dcc.asml.aSMLModel.impl.ASMLModelPackageImpl#getRelactionType()
     * @generated
     */
    EEnum RELACTION_TYPE = eINSTANCE.getRelactionType();

    /**
     * The meta object literal for the '{@link br.ufmg.dcc.asml.aSMLModel.WildCard <em>Wild Card</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see br.ufmg.dcc.asml.aSMLModel.WildCard
     * @see br.ufmg.dcc.asml.aSMLModel.impl.ASMLModelPackageImpl#getWildCard()
     * @generated
     */
    EEnum WILD_CARD = eINSTANCE.getWildCard();

  }

} //ASMLModelPackage
