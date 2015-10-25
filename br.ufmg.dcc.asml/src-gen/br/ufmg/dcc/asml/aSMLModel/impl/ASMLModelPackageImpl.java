/**
 */
package br.ufmg.dcc.asml.aSMLModel.impl;

import br.ufmg.dcc.asml.aSMLModel.ASMLModel;
import br.ufmg.dcc.asml.aSMLModel.ASMLModelFactory;
import br.ufmg.dcc.asml.aSMLModel.ASMLModelPackage;
import br.ufmg.dcc.asml.aSMLModel.AbstractComponent;
import br.ufmg.dcc.asml.aSMLModel.AbstractNameConvetion;
import br.ufmg.dcc.asml.aSMLModel.Attribute;
import br.ufmg.dcc.asml.aSMLModel.Cardinality;
import br.ufmg.dcc.asml.aSMLModel.ClassMatching;
import br.ufmg.dcc.asml.aSMLModel.ExpressionMatchingClause;
import br.ufmg.dcc.asml.aSMLModel.ExpressionMatchingOperator;
import br.ufmg.dcc.asml.aSMLModel.GroupClause;
import br.ufmg.dcc.asml.aSMLModel.MetaModule;
import br.ufmg.dcc.asml.aSMLModel.ModuleMatching;
import br.ufmg.dcc.asml.aSMLModel.ModuleMatchingParamenter;
import br.ufmg.dcc.asml.aSMLModel.PermissionClause;
import br.ufmg.dcc.asml.aSMLModel.RelactionType;
import br.ufmg.dcc.asml.aSMLModel.Restriction;
import br.ufmg.dcc.asml.aSMLModel.View;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ASMLModelPackageImpl extends EPackageImpl implements ASMLModelPackage
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass asmlModelEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass abstractComponentEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass viewEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass attributeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass abstractNameConvetionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass expressionMatchingOperatorEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass moduleMatchingEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass classMatchingEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass metaModuleEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass restrictionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum cardinalityEEnum = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum expressionMatchingClauseEEnum = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum moduleMatchingParamenterEEnum = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum groupClauseEEnum = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum permissionClauseEEnum = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum relactionTypeEEnum = null;

  /**
   * Creates an instance of the model <b>Package</b>, registered with
   * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
   * package URI value.
   * <p>Note: the correct way to create the package is via the static
   * factory method {@link #init init()}, which also performs
   * initialization of the package, or returns the registered package,
   * if one already exists.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.ecore.EPackage.Registry
   * @see br.ufmg.dcc.asml.aSMLModel.ASMLModelPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private ASMLModelPackageImpl()
  {
    super(eNS_URI, ASMLModelFactory.eINSTANCE);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static boolean isInited = false;

  /**
   * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
   * 
   * <p>This method is used to initialize {@link ASMLModelPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static ASMLModelPackage init()
  {
    if (isInited) return (ASMLModelPackage)EPackage.Registry.INSTANCE.getEPackage(ASMLModelPackage.eNS_URI);

    // Obtain or create and register package
    ASMLModelPackageImpl theASMLModelPackage = (ASMLModelPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof ASMLModelPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new ASMLModelPackageImpl());

    isInited = true;

    // Create package meta-data objects
    theASMLModelPackage.createPackageContents();

    // Initialize created meta-data
    theASMLModelPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theASMLModelPackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(ASMLModelPackage.eNS_URI, theASMLModelPackage);
    return theASMLModelPackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getASMLModel()
  {
    return asmlModelEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getASMLModel_Name()
  {
    return (EAttribute)asmlModelEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getASMLModel_ImportURI()
  {
    return (EAttribute)asmlModelEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getASMLModel_Components()
  {
    return (EReference)asmlModelEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getASMLModel_Ignore()
  {
    return (EAttribute)asmlModelEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAbstractComponent()
  {
    return abstractComponentEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAbstractComponent_Name()
  {
    return (EAttribute)abstractComponentEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAbstractComponent_Attributes()
  {
    return (EReference)abstractComponentEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAbstractComponent_Components()
  {
    return (EReference)abstractComponentEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAbstractComponent_Restrictions()
  {
    return (EReference)abstractComponentEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getView()
  {
    return viewEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAttribute()
  {
    return attributeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAttribute_Name()
  {
    return (EAttribute)attributeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAttribute_Value()
  {
    return (EAttribute)attributeEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAbstractNameConvetion()
  {
    return abstractNameConvetionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getExpressionMatchingOperator()
  {
    return expressionMatchingOperatorEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getExpressionMatchingOperator_AND()
  {
    return (EAttribute)expressionMatchingOperatorEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getExpressionMatchingOperator_OR()
  {
    return (EAttribute)expressionMatchingOperatorEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getModuleMatching()
  {
    return moduleMatchingEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getModuleMatching_Parameter()
  {
    return (EAttribute)moduleMatchingEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getClassMatching()
  {
    return classMatchingEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getClassMatching_ExpressionMatching()
  {
    return (EAttribute)classMatchingEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getClassMatching_Parameter()
  {
    return (EAttribute)classMatchingEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMetaModule()
  {
    return metaModuleEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMetaModule_Matching()
  {
    return (EAttribute)metaModuleEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMetaModule_Description()
  {
    return (EAttribute)metaModuleEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getRestriction()
  {
    return restrictionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getRestriction_GroupClause()
  {
    return (EAttribute)restrictionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getRestriction_PermissionClause()
  {
    return (EAttribute)restrictionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getRestriction_RelactionType()
  {
    return (EAttribute)restrictionEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getRestriction_GroupClauseB()
  {
    return (EAttribute)restrictionEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRestriction_ComponentB()
  {
    return (EReference)restrictionEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getRestriction_Message()
  {
    return (EAttribute)restrictionEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getCardinality()
  {
    return cardinalityEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getExpressionMatchingClause()
  {
    return expressionMatchingClauseEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getModuleMatchingParamenter()
  {
    return moduleMatchingParamenterEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getGroupClause()
  {
    return groupClauseEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getPermissionClause()
  {
    return permissionClauseEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getRelactionType()
  {
    return relactionTypeEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ASMLModelFactory getASMLModelFactory()
  {
    return (ASMLModelFactory)getEFactoryInstance();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isCreated = false;

  /**
   * Creates the meta-model objects for the package.  This method is
   * guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void createPackageContents()
  {
    if (isCreated) return;
    isCreated = true;

    // Create classes and their features
    asmlModelEClass = createEClass(ASML_MODEL);
    createEAttribute(asmlModelEClass, ASML_MODEL__NAME);
    createEAttribute(asmlModelEClass, ASML_MODEL__IMPORT_URI);
    createEReference(asmlModelEClass, ASML_MODEL__COMPONENTS);
    createEAttribute(asmlModelEClass, ASML_MODEL__IGNORE);

    abstractComponentEClass = createEClass(ABSTRACT_COMPONENT);
    createEAttribute(abstractComponentEClass, ABSTRACT_COMPONENT__NAME);
    createEReference(abstractComponentEClass, ABSTRACT_COMPONENT__ATTRIBUTES);
    createEReference(abstractComponentEClass, ABSTRACT_COMPONENT__COMPONENTS);
    createEReference(abstractComponentEClass, ABSTRACT_COMPONENT__RESTRICTIONS);

    viewEClass = createEClass(VIEW);

    attributeEClass = createEClass(ATTRIBUTE);
    createEAttribute(attributeEClass, ATTRIBUTE__NAME);
    createEAttribute(attributeEClass, ATTRIBUTE__VALUE);

    abstractNameConvetionEClass = createEClass(ABSTRACT_NAME_CONVETION);

    expressionMatchingOperatorEClass = createEClass(EXPRESSION_MATCHING_OPERATOR);
    createEAttribute(expressionMatchingOperatorEClass, EXPRESSION_MATCHING_OPERATOR__AND);
    createEAttribute(expressionMatchingOperatorEClass, EXPRESSION_MATCHING_OPERATOR__OR);

    moduleMatchingEClass = createEClass(MODULE_MATCHING);
    createEAttribute(moduleMatchingEClass, MODULE_MATCHING__PARAMETER);

    classMatchingEClass = createEClass(CLASS_MATCHING);
    createEAttribute(classMatchingEClass, CLASS_MATCHING__EXPRESSION_MATCHING);
    createEAttribute(classMatchingEClass, CLASS_MATCHING__PARAMETER);

    metaModuleEClass = createEClass(META_MODULE);
    createEAttribute(metaModuleEClass, META_MODULE__MATCHING);
    createEAttribute(metaModuleEClass, META_MODULE__DESCRIPTION);

    restrictionEClass = createEClass(RESTRICTION);
    createEAttribute(restrictionEClass, RESTRICTION__GROUP_CLAUSE);
    createEAttribute(restrictionEClass, RESTRICTION__PERMISSION_CLAUSE);
    createEAttribute(restrictionEClass, RESTRICTION__RELACTION_TYPE);
    createEAttribute(restrictionEClass, RESTRICTION__GROUP_CLAUSE_B);
    createEReference(restrictionEClass, RESTRICTION__COMPONENT_B);
    createEAttribute(restrictionEClass, RESTRICTION__MESSAGE);

    // Create enums
    cardinalityEEnum = createEEnum(CARDINALITY);
    expressionMatchingClauseEEnum = createEEnum(EXPRESSION_MATCHING_CLAUSE);
    moduleMatchingParamenterEEnum = createEEnum(MODULE_MATCHING_PARAMENTER);
    groupClauseEEnum = createEEnum(GROUP_CLAUSE);
    permissionClauseEEnum = createEEnum(PERMISSION_CLAUSE);
    relactionTypeEEnum = createEEnum(RELACTION_TYPE);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isInitialized = false;

  /**
   * Complete the initialization of the package and its meta-model.  This
   * method is guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void initializePackageContents()
  {
    if (isInitialized) return;
    isInitialized = true;

    // Initialize package
    setName(eNAME);
    setNsPrefix(eNS_PREFIX);
    setNsURI(eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes
    viewEClass.getESuperTypes().add(this.getAbstractComponent());
    classMatchingEClass.getESuperTypes().add(this.getAbstractNameConvetion());
    metaModuleEClass.getESuperTypes().add(this.getAbstractComponent());

    // Initialize classes and features; add operations and parameters
    initEClass(asmlModelEClass, ASMLModel.class, "ASMLModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getASMLModel_Name(), ecorePackage.getEString(), "name", null, 0, 1, ASMLModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getASMLModel_ImportURI(), ecorePackage.getEString(), "importURI", null, 0, 1, ASMLModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getASMLModel_Components(), this.getAbstractComponent(), null, "components", null, 0, -1, ASMLModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getASMLModel_Ignore(), ecorePackage.getEString(), "ignore", null, 0, -1, ASMLModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(abstractComponentEClass, AbstractComponent.class, "AbstractComponent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getAbstractComponent_Name(), ecorePackage.getEString(), "name", null, 0, 1, AbstractComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAbstractComponent_Attributes(), this.getAttribute(), null, "attributes", null, 0, -1, AbstractComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAbstractComponent_Components(), this.getAbstractComponent(), null, "components", null, 0, -1, AbstractComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAbstractComponent_Restrictions(), this.getRestriction(), null, "restrictions", null, 0, -1, AbstractComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(viewEClass, View.class, "View", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(attributeEClass, Attribute.class, "Attribute", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getAttribute_Name(), ecorePackage.getEString(), "name", null, 0, 1, Attribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getAttribute_Value(), ecorePackage.getEString(), "value", null, 0, 1, Attribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(abstractNameConvetionEClass, AbstractNameConvetion.class, "AbstractNameConvetion", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(expressionMatchingOperatorEClass, ExpressionMatchingOperator.class, "ExpressionMatchingOperator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getExpressionMatchingOperator_AND(), ecorePackage.getEString(), "AND", null, 0, 1, ExpressionMatchingOperator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getExpressionMatchingOperator_OR(), ecorePackage.getEString(), "OR", null, 0, 1, ExpressionMatchingOperator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(moduleMatchingEClass, ModuleMatching.class, "ModuleMatching", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getModuleMatching_Parameter(), this.getModuleMatchingParamenter(), "parameter", null, 0, 1, ModuleMatching.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(classMatchingEClass, ClassMatching.class, "ClassMatching", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getClassMatching_ExpressionMatching(), this.getExpressionMatchingClause(), "expressionMatching", null, 0, 1, ClassMatching.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getClassMatching_Parameter(), ecorePackage.getEString(), "parameter", null, 0, 1, ClassMatching.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(metaModuleEClass, MetaModule.class, "MetaModule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getMetaModule_Matching(), ecorePackage.getEString(), "matching", null, 0, 1, MetaModule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getMetaModule_Description(), ecorePackage.getEString(), "description", null, 0, 1, MetaModule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(restrictionEClass, Restriction.class, "Restriction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getRestriction_GroupClause(), this.getGroupClause(), "groupClause", null, 0, 1, Restriction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getRestriction_PermissionClause(), this.getPermissionClause(), "permissionClause", null, 0, 1, Restriction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getRestriction_RelactionType(), this.getRelactionType(), "relactionType", null, 0, 1, Restriction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getRestriction_GroupClauseB(), this.getGroupClause(), "groupClauseB", null, 0, 1, Restriction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getRestriction_ComponentB(), this.getAbstractComponent(), null, "componentB", null, 0, -1, Restriction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getRestriction_Message(), ecorePackage.getEString(), "message", null, 0, 1, Restriction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Initialize enums and add enum literals
    initEEnum(cardinalityEEnum, Cardinality.class, "Cardinality");
    addEEnumLiteral(cardinalityEEnum, Cardinality.ONE);
    addEEnumLiteral(cardinalityEEnum, Cardinality.ZERO);
    addEEnumLiteral(cardinalityEEnum, Cardinality.ONE_OR_MANY);
    addEEnumLiteral(cardinalityEEnum, Cardinality.ZERO_OR_MANY);

    initEEnum(expressionMatchingClauseEEnum, ExpressionMatchingClause.class, "ExpressionMatchingClause");
    addEEnumLiteral(expressionMatchingClauseEEnum, ExpressionMatchingClause.NAME_START_WITH);
    addEEnumLiteral(expressionMatchingClauseEEnum, ExpressionMatchingClause.NAME_ENDS_WITH);
    addEEnumLiteral(expressionMatchingClauseEEnum, ExpressionMatchingClause.ANNOTATED_WITH);

    initEEnum(moduleMatchingParamenterEEnum, ModuleMatchingParamenter.class, "ModuleMatchingParamenter");
    addEEnumLiteral(moduleMatchingParamenterEEnum, ModuleMatchingParamenter.PAKCAGE);
    addEEnumLiteral(moduleMatchingParamenterEEnum, ModuleMatchingParamenter.FOLDER);
    addEEnumLiteral(moduleMatchingParamenterEEnum, ModuleMatchingParamenter.PAKCAGE_AND_FOLDER);
    addEEnumLiteral(moduleMatchingParamenterEEnum, ModuleMatchingParamenter.EXTERNAL_DEFINITION);

    initEEnum(groupClauseEEnum, GroupClause.class, "GroupClause");
    addEEnumLiteral(groupClauseEEnum, GroupClause.NULL);
    addEEnumLiteral(groupClauseEEnum, GroupClause.ONLY);
    addEEnumLiteral(groupClauseEEnum, GroupClause.ONLY_THIS);

    initEEnum(permissionClauseEEnum, PermissionClause.class, "PermissionClause");
    addEEnumLiteral(permissionClauseEEnum, PermissionClause.MUST);
    addEEnumLiteral(permissionClauseEEnum, PermissionClause.CAN);
    addEEnumLiteral(permissionClauseEEnum, PermissionClause.CANNOT);

    initEEnum(relactionTypeEEnum, RelactionType.class, "RelactionType");
    addEEnumLiteral(relactionTypeEEnum, RelactionType.ACCESS);
    addEEnumLiteral(relactionTypeEEnum, RelactionType.DECLARE);
    addEEnumLiteral(relactionTypeEEnum, RelactionType.HANDLE);
    addEEnumLiteral(relactionTypeEEnum, RelactionType.EXTEND);
    addEEnumLiteral(relactionTypeEEnum, RelactionType.IMPLEMENT);
    addEEnumLiteral(relactionTypeEEnum, RelactionType.CREATE);
    addEEnumLiteral(relactionTypeEEnum, RelactionType.THROW);
    addEEnumLiteral(relactionTypeEEnum, RelactionType.USEANOTATION);
    addEEnumLiteral(relactionTypeEEnum, RelactionType.DEPEND);
    addEEnumLiteral(relactionTypeEEnum, RelactionType.REQUIRES);

    // Create resource
    createResource(eNS_URI);
  }

} //ASMLModelPackageImpl
