/**
 */
package br.ufmg.dcc.asml.aSMLModel;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see br.ufmg.dcc.asml.aSMLModel.ASMLModelPackage
 * @generated
 */
public interface ASMLModelFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  ASMLModelFactory eINSTANCE = br.ufmg.dcc.asml.aSMLModel.impl.ASMLModelFactoryImpl.init();

  /**
   * Returns a new object of class '<em>ASML Model</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>ASML Model</em>'.
   * @generated
   */
  ASMLModel createASMLModel();

  /**
   * Returns a new object of class '<em>Abstract Component</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Abstract Component</em>'.
   * @generated
   */
  AbstractComponent createAbstractComponent();

  /**
   * Returns a new object of class '<em>View</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>View</em>'.
   * @generated
   */
  View createView();

  /**
   * Returns a new object of class '<em>Attribute</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Attribute</em>'.
   * @generated
   */
  Attribute createAttribute();

  /**
   * Returns a new object of class '<em>Abstract Name Convetion</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Abstract Name Convetion</em>'.
   * @generated
   */
  AbstractNameConvetion createAbstractNameConvetion();

  /**
   * Returns a new object of class '<em>Expression Matching Operator</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Expression Matching Operator</em>'.
   * @generated
   */
  ExpressionMatchingOperator createExpressionMatchingOperator();

  /**
   * Returns a new object of class '<em>Module Matching</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Module Matching</em>'.
   * @generated
   */
  ModuleMatching createModuleMatching();

  /**
   * Returns a new object of class '<em>Class Matching</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Class Matching</em>'.
   * @generated
   */
  ClassMatching createClassMatching();

  /**
   * Returns a new object of class '<em>Meta Module</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Meta Module</em>'.
   * @generated
   */
  MetaModule createMetaModule();

  /**
   * Returns a new object of class '<em>Restriction</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Restriction</em>'.
   * @generated
   */
  Restriction createRestriction();

  /**
   * Returns a new object of class '<em>Components Bin Restriction Declareation</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Components Bin Restriction Declareation</em>'.
   * @generated
   */
  ComponentsBinRestrictionDeclareation createComponentsBinRestrictionDeclareation();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  ASMLModelPackage getASMLModelPackage();

} //ASMLModelFactory
