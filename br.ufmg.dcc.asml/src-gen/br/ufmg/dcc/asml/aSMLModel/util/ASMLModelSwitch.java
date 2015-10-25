/**
 */
package br.ufmg.dcc.asml.aSMLModel.util;

import br.ufmg.dcc.asml.aSMLModel.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see br.ufmg.dcc.asml.aSMLModel.ASMLModelPackage
 * @generated
 */
public class ASMLModelSwitch<T> extends Switch<T>
{
  /**
   * The cached model package
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static ASMLModelPackage modelPackage;

  /**
   * Creates an instance of the switch.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ASMLModelSwitch()
  {
    if (modelPackage == null)
    {
      modelPackage = ASMLModelPackage.eINSTANCE;
    }
  }

  /**
   * Checks whether this is a switch for the given package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @parameter ePackage the package in question.
   * @return whether this is a switch for the given package.
   * @generated
   */
  @Override
  protected boolean isSwitchFor(EPackage ePackage)
  {
    return ePackage == modelPackage;
  }

  /**
   * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the first non-null result returned by a <code>caseXXX</code> call.
   * @generated
   */
  @Override
  protected T doSwitch(int classifierID, EObject theEObject)
  {
    switch (classifierID)
    {
      case ASMLModelPackage.ASML_MODEL:
      {
        ASMLModel asmlModel = (ASMLModel)theEObject;
        T result = caseASMLModel(asmlModel);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ASMLModelPackage.ABSTRACT_COMPONENT:
      {
        AbstractComponent abstractComponent = (AbstractComponent)theEObject;
        T result = caseAbstractComponent(abstractComponent);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ASMLModelPackage.VIEW:
      {
        View view = (View)theEObject;
        T result = caseView(view);
        if (result == null) result = caseAbstractComponent(view);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ASMLModelPackage.ATTRIBUTE:
      {
        Attribute attribute = (Attribute)theEObject;
        T result = caseAttribute(attribute);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ASMLModelPackage.ABSTRACT_NAME_CONVETION:
      {
        AbstractNameConvetion abstractNameConvetion = (AbstractNameConvetion)theEObject;
        T result = caseAbstractNameConvetion(abstractNameConvetion);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ASMLModelPackage.EXPRESSION_MATCHING_OPERATOR:
      {
        ExpressionMatchingOperator expressionMatchingOperator = (ExpressionMatchingOperator)theEObject;
        T result = caseExpressionMatchingOperator(expressionMatchingOperator);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ASMLModelPackage.MODULE_MATCHING:
      {
        ModuleMatching moduleMatching = (ModuleMatching)theEObject;
        T result = caseModuleMatching(moduleMatching);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ASMLModelPackage.CLASS_MATCHING:
      {
        ClassMatching classMatching = (ClassMatching)theEObject;
        T result = caseClassMatching(classMatching);
        if (result == null) result = caseAbstractNameConvetion(classMatching);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ASMLModelPackage.META_MODULE:
      {
        MetaModule metaModule = (MetaModule)theEObject;
        T result = caseMetaModule(metaModule);
        if (result == null) result = caseAbstractComponent(metaModule);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ASMLModelPackage.RESTRICTION:
      {
        Restriction restriction = (Restriction)theEObject;
        T result = caseRestriction(restriction);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      default: return defaultCase(theEObject);
    }
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>ASML Model</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>ASML Model</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseASMLModel(ASMLModel object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Abstract Component</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Abstract Component</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAbstractComponent(AbstractComponent object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>View</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>View</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseView(View object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Attribute</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Attribute</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAttribute(Attribute object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Abstract Name Convetion</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Abstract Name Convetion</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAbstractNameConvetion(AbstractNameConvetion object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Expression Matching Operator</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Expression Matching Operator</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseExpressionMatchingOperator(ExpressionMatchingOperator object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Module Matching</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Module Matching</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseModuleMatching(ModuleMatching object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Class Matching</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Class Matching</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseClassMatching(ClassMatching object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Meta Module</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Meta Module</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMetaModule(MetaModule object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Restriction</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Restriction</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRestriction(Restriction object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch, but this is the last case anyway.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject)
   * @generated
   */
  @Override
  public T defaultCase(EObject object)
  {
    return null;
  }

} //ASMLModelSwitch
