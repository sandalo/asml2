package br.ufmg.dcc.asml.serializer;

import br.ufmg.dcc.asml.aSMLModel.ASMLModel;
import br.ufmg.dcc.asml.aSMLModel.ASMLModelPackage;
import br.ufmg.dcc.asml.aSMLModel.Attribute;
import br.ufmg.dcc.asml.aSMLModel.ClassMatching;
import br.ufmg.dcc.asml.aSMLModel.ExpressionMatchingOperator;
import br.ufmg.dcc.asml.aSMLModel.MetaModule;
import br.ufmg.dcc.asml.aSMLModel.ModuleMatching;
import br.ufmg.dcc.asml.aSMLModel.Restriction;
import br.ufmg.dcc.asml.aSMLModel.View;
import br.ufmg.dcc.asml.services.ASMLModelGrammarAccess;
import com.google.inject.Inject;
import com.google.inject.Provider;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.serializer.acceptor.ISemanticSequenceAcceptor;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.diagnostic.ISemanticSequencerDiagnosticProvider;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic.Acceptor;
import org.eclipse.xtext.serializer.sequencer.AbstractDelegatingSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.GenericSequencer;
import org.eclipse.xtext.serializer.sequencer.ISemanticNodeProvider.INodesForEObjectProvider;
import org.eclipse.xtext.serializer.sequencer.ISemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;

@SuppressWarnings("all")
public class ASMLModelSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private ASMLModelGrammarAccess grammarAccess;
	
	public void createSequence(EObject context, EObject semanticObject) {
		if(semanticObject.eClass().getEPackage() == ASMLModelPackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case ASMLModelPackage.ASML_MODEL:
				if(context == grammarAccess.getASMLModelRule()) {
					sequence_ASMLModel(context, (ASMLModel) semanticObject); 
					return; 
				}
				else break;
			case ASMLModelPackage.ATTRIBUTE:
				if(context == grammarAccess.getAttributeRule()) {
					sequence_Attribute(context, (Attribute) semanticObject); 
					return; 
				}
				else break;
			case ASMLModelPackage.CLASS_MATCHING:
				if(context == grammarAccess.getAbstractNameConvetionRule() ||
				   context == grammarAccess.getClassMatchingRule()) {
					sequence_ClassMatching(context, (ClassMatching) semanticObject); 
					return; 
				}
				else break;
			case ASMLModelPackage.EXPRESSION_MATCHING_OPERATOR:
				if(context == grammarAccess.getExpressionMatchingOperatorRule()) {
					sequence_ExpressionMatchingOperator(context, (ExpressionMatchingOperator) semanticObject); 
					return; 
				}
				else break;
			case ASMLModelPackage.META_MODULE:
				if(context == grammarAccess.getAbstractComponentRule() ||
				   context == grammarAccess.getMetaModuleRule()) {
					sequence_MetaModule(context, (MetaModule) semanticObject); 
					return; 
				}
				else break;
			case ASMLModelPackage.MODULE_MATCHING:
				if(context == grammarAccess.getModuleMatchingRule()) {
					sequence_ModuleMatching(context, (ModuleMatching) semanticObject); 
					return; 
				}
				else break;
			case ASMLModelPackage.RESTRICTION:
				if(context == grammarAccess.getRestrictionRule()) {
					sequence_Restriction(context, (Restriction) semanticObject); 
					return; 
				}
				else break;
			case ASMLModelPackage.VIEW:
				if(context == grammarAccess.getAbstractComponentRule() ||
				   context == grammarAccess.getViewRule()) {
					sequence_View(context, (View) semanticObject); 
					return; 
				}
				else break;
			}
		if (errorAcceptor != null) errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Constraint:
	 *     (name=ID_ASML importURI=STRING? components+=AbstractComponent* ignore+=STRING*)
	 */
	protected void sequence_ASMLModel(EObject context, ASMLModel semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=ID_ASML value=STRING)
	 */
	protected void sequence_Attribute(EObject context, Attribute semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ASMLModelPackage.Literals.ATTRIBUTE__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ASMLModelPackage.Literals.ATTRIBUTE__NAME));
			if(transientValues.isValueTransient(semanticObject, ASMLModelPackage.Literals.ATTRIBUTE__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ASMLModelPackage.Literals.ATTRIBUTE__VALUE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getAttributeAccess().getNameID_ASMLTerminalRuleCall_0_0(), semanticObject.getName());
		feeder.accept(grammarAccess.getAttributeAccess().getValueSTRINGTerminalRuleCall_2_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (expressionMatching=ExpressionMatchingClause parameter=STRING)
	 */
	protected void sequence_ClassMatching(EObject context, ClassMatching semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ASMLModelPackage.Literals.CLASS_MATCHING__EXPRESSION_MATCHING) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ASMLModelPackage.Literals.CLASS_MATCHING__EXPRESSION_MATCHING));
			if(transientValues.isValueTransient(semanticObject, ASMLModelPackage.Literals.CLASS_MATCHING__PARAMETER) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ASMLModelPackage.Literals.CLASS_MATCHING__PARAMETER));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getClassMatchingAccess().getExpressionMatchingExpressionMatchingClauseEnumRuleCall_0_0(), semanticObject.getExpressionMatching());
		feeder.accept(grammarAccess.getClassMatchingAccess().getParameterSTRINGTerminalRuleCall_1_0(), semanticObject.getParameter());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (AND='and' | OR='or')
	 */
	protected void sequence_ExpressionMatchingOperator(EObject context, ExpressionMatchingOperator semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         name=ID_ASML 
	 *         attributes+=Attribute* 
	 *         matching=STRING? 
	 *         description=STRING? 
	 *         components+=AbstractComponent* 
	 *         restrictions+=Restriction*
	 *     )
	 */
	protected void sequence_MetaModule(EObject context, MetaModule semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     parameter=ModuleMatchingParamenter
	 */
	protected void sequence_ModuleMatching(EObject context, ModuleMatching semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ASMLModelPackage.Literals.MODULE_MATCHING__PARAMETER) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ASMLModelPackage.Literals.MODULE_MATCHING__PARAMETER));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getModuleMatchingAccess().getParameterModuleMatchingParamenterEnumRuleCall_0(), semanticObject.getParameter());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         groupClause=GroupClause? 
	 *         permissionClause=PermissionClause? 
	 *         relactionType=RelactionType 
	 *         groupClauseB=GroupClause? 
	 *         componentB+=[AbstractComponent|QualifiedName]* 
	 *         message=STRING?
	 *     )
	 */
	protected void sequence_Restriction(EObject context, Restriction semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=ID_ASML attributes+=Attribute* components+=AbstractComponent* restrictions+=Restriction*)
	 */
	protected void sequence_View(EObject context, View semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
}
