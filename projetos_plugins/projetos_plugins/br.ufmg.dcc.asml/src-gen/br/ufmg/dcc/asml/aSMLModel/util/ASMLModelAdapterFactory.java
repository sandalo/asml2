/**
 */
package br.ufmg.dcc.asml.aSMLModel.util;

import br.ufmg.dcc.asml.aSMLModel.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see br.ufmg.dcc.asml.aSMLModel.ASMLModelPackage
 * @generated
 */
public class ASMLModelAdapterFactory extends AdapterFactoryImpl
{
  /**
   * The cached model package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static ASMLModelPackage modelPackage;

  /**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ASMLModelAdapterFactory()
  {
    if (modelPackage == null)
    {
      modelPackage = ASMLModelPackage.eINSTANCE;
    }
  }

  /**
   * Returns whether this factory is applicable for the type of the object.
   * <!-- begin-user-doc -->
   * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
   * <!-- end-user-doc -->
   * @return whether this factory is applicable for the type of the object.
   * @generated
   */
  @Override
  public boolean isFactoryForType(Object object)
  {
    if (object == modelPackage)
    {
      return true;
    }
    if (object instanceof EObject)
    {
      return ((EObject)object).eClass().getEPackage() == modelPackage;
    }
    return false;
  }

  /**
   * The switch that delegates to the <code>createXXX</code> methods.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ASMLModelSwitch<Adapter> modelSwitch =
    new ASMLModelSwitch<Adapter>()
    {
      @Override
      public Adapter caseASMLModel(ASMLModel object)
      {
        return createASMLModelAdapter();
      }
      @Override
      public Adapter caseAbstractComponent(AbstractComponent object)
      {
        return createAbstractComponentAdapter();
      }
      @Override
      public Adapter caseView(View object)
      {
        return createViewAdapter();
      }
      @Override
      public Adapter caseAttribute(Attribute object)
      {
        return createAttributeAdapter();
      }
      @Override
      public Adapter caseAbstractNameConvetion(AbstractNameConvetion object)
      {
        return createAbstractNameConvetionAdapter();
      }
      @Override
      public Adapter caseExpressionMatchingOperator(ExpressionMatchingOperator object)
      {
        return createExpressionMatchingOperatorAdapter();
      }
      @Override
      public Adapter caseModuleMatching(ModuleMatching object)
      {
        return createModuleMatchingAdapter();
      }
      @Override
      public Adapter caseClassMatching(ClassMatching object)
      {
        return createClassMatchingAdapter();
      }
      @Override
      public Adapter caseMetaModule(MetaModule object)
      {
        return createMetaModuleAdapter();
      }
      @Override
      public Adapter caseRestriction(Restriction object)
      {
        return createRestrictionAdapter();
      }
      @Override
      public Adapter caseComponentsBinRestrictionDeclareation(ComponentsBinRestrictionDeclareation object)
      {
        return createComponentsBinRestrictionDeclareationAdapter();
      }
      @Override
      public Adapter defaultCase(EObject object)
      {
        return createEObjectAdapter();
      }
    };

  /**
   * Creates an adapter for the <code>target</code>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param target the object to adapt.
   * @return the adapter for the <code>target</code>.
   * @generated
   */
  @Override
  public Adapter createAdapter(Notifier target)
  {
    return modelSwitch.doSwitch((EObject)target);
  }


  /**
   * Creates a new adapter for an object of class '{@link br.ufmg.dcc.asml.aSMLModel.ASMLModel <em>ASML Model</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see br.ufmg.dcc.asml.aSMLModel.ASMLModel
   * @generated
   */
  public Adapter createASMLModelAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link br.ufmg.dcc.asml.aSMLModel.AbstractComponent <em>Abstract Component</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see br.ufmg.dcc.asml.aSMLModel.AbstractComponent
   * @generated
   */
  public Adapter createAbstractComponentAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link br.ufmg.dcc.asml.aSMLModel.View <em>View</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see br.ufmg.dcc.asml.aSMLModel.View
   * @generated
   */
  public Adapter createViewAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link br.ufmg.dcc.asml.aSMLModel.Attribute <em>Attribute</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see br.ufmg.dcc.asml.aSMLModel.Attribute
   * @generated
   */
  public Adapter createAttributeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link br.ufmg.dcc.asml.aSMLModel.AbstractNameConvetion <em>Abstract Name Convetion</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see br.ufmg.dcc.asml.aSMLModel.AbstractNameConvetion
   * @generated
   */
  public Adapter createAbstractNameConvetionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link br.ufmg.dcc.asml.aSMLModel.ExpressionMatchingOperator <em>Expression Matching Operator</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see br.ufmg.dcc.asml.aSMLModel.ExpressionMatchingOperator
   * @generated
   */
  public Adapter createExpressionMatchingOperatorAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link br.ufmg.dcc.asml.aSMLModel.ModuleMatching <em>Module Matching</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see br.ufmg.dcc.asml.aSMLModel.ModuleMatching
   * @generated
   */
  public Adapter createModuleMatchingAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link br.ufmg.dcc.asml.aSMLModel.ClassMatching <em>Class Matching</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see br.ufmg.dcc.asml.aSMLModel.ClassMatching
   * @generated
   */
  public Adapter createClassMatchingAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link br.ufmg.dcc.asml.aSMLModel.MetaModule <em>Meta Module</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see br.ufmg.dcc.asml.aSMLModel.MetaModule
   * @generated
   */
  public Adapter createMetaModuleAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link br.ufmg.dcc.asml.aSMLModel.Restriction <em>Restriction</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see br.ufmg.dcc.asml.aSMLModel.Restriction
   * @generated
   */
  public Adapter createRestrictionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link br.ufmg.dcc.asml.aSMLModel.ComponentsBinRestrictionDeclareation <em>Components Bin Restriction Declareation</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see br.ufmg.dcc.asml.aSMLModel.ComponentsBinRestrictionDeclareation
   * @generated
   */
  public Adapter createComponentsBinRestrictionDeclareationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for the default case.
   * <!-- begin-user-doc -->
   * This default implementation returns null.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @generated
   */
  public Adapter createEObjectAdapter()
  {
    return null;
  }

} //ASMLModelAdapterFactory
