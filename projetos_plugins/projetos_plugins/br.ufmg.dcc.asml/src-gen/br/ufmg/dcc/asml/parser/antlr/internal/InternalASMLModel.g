/*
 * generated by Xtext
 */
grammar InternalASMLModel;

options {
	superClass=AbstractInternalAntlrParser;
	
}

@lexer::header {
package br.ufmg.dcc.asml.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

@parser::header {
package br.ufmg.dcc.asml.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import br.ufmg.dcc.asml.services.ASMLModelGrammarAccess;

}

@parser::members {

 	private ASMLModelGrammarAccess grammarAccess;
 	
    public InternalASMLModelParser(TokenStream input, ASMLModelGrammarAccess grammarAccess) {
        this(input);
        this.grammarAccess = grammarAccess;
        registerRules(grammarAccess.getGrammar());
    }
    
    @Override
    protected String getFirstRuleName() {
    	return "ASMLModel";	
   	}
   	
   	@Override
   	protected ASMLModelGrammarAccess getGrammarAccess() {
   		return grammarAccess;
   	}
}

@rulecatch { 
    catch (RecognitionException re) { 
        recover(input,re); 
        appendSkippedTokens();
    } 
}




// Entry rule entryRuleASMLModel
entryRuleASMLModel returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getASMLModelRule()); }
	 iv_ruleASMLModel=ruleASMLModel 
	 { $current=$iv_ruleASMLModel.current; } 
	 EOF 
;

// Rule ASMLModel
ruleASMLModel returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(	otherlv_0='architecture' 
    {
    	newLeafNode(otherlv_0, grammarAccess.getASMLModelAccess().getArchitectureKeyword_0());
    }
(
(
		lv_name_1_0=RULE_ID_ASML
		{
			newLeafNode(lv_name_1_0, grammarAccess.getASMLModelAccess().getNameID_ASMLTerminalRuleCall_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getASMLModelRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"name",
        		lv_name_1_0, 
        		"ID_ASML");
	    }

)
)	otherlv_2='{' 
    {
    	newLeafNode(otherlv_2, grammarAccess.getASMLModelAccess().getLeftCurlyBracketKeyword_2());
    }
(	otherlv_3='import' 
    {
    	newLeafNode(otherlv_3, grammarAccess.getASMLModelAccess().getImportKeyword_3_0());
    }
(
(
		lv_importURI_4_0=RULE_STRING
		{
			newLeafNode(lv_importURI_4_0, grammarAccess.getASMLModelAccess().getImportURISTRINGTerminalRuleCall_3_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getASMLModelRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"importURI",
        		lv_importURI_4_0, 
        		"STRING");
	    }

)
)	otherlv_5=';' 
    {
    	newLeafNode(otherlv_5, grammarAccess.getASMLModelAccess().getSemicolonKeyword_3_2());
    }
)?(
(
		{ 
	        newCompositeNode(grammarAccess.getASMLModelAccess().getComponentsAbstractComponentParserRuleCall_4_0()); 
	    }
		lv_components_6_0=ruleAbstractComponent		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getASMLModelRule());
	        }
       		add(
       			$current, 
       			"components",
        		lv_components_6_0, 
        		"AbstractComponent");
	        afterParserOrEnumRuleCall();
	    }

)
)*(	otherlv_7='ignore' 
    {
    	newLeafNode(otherlv_7, grammarAccess.getASMLModelAccess().getIgnoreKeyword_5_0());
    }
((
(
		lv_ignore_8_0=RULE_STRING
		{
			newLeafNode(lv_ignore_8_0, grammarAccess.getASMLModelAccess().getIgnoreSTRINGTerminalRuleCall_5_1_0_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getASMLModelRule());
	        }
       		addWithLastConsumed(
       			$current, 
       			"ignore",
        		lv_ignore_8_0, 
        		"STRING");
	    }

)
)(	otherlv_9=',' 
    {
    	newLeafNode(otherlv_9, grammarAccess.getASMLModelAccess().getCommaKeyword_5_1_1());
    }
)?)*	otherlv_10=';' 
    {
    	newLeafNode(otherlv_10, grammarAccess.getASMLModelAccess().getSemicolonKeyword_5_2());
    }
)?	otherlv_11='}' 
    {
    	newLeafNode(otherlv_11, grammarAccess.getASMLModelAccess().getRightCurlyBracketKeyword_6());
    }
)
;





// Entry rule entryRuleAbstractComponent
entryRuleAbstractComponent returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getAbstractComponentRule()); }
	 iv_ruleAbstractComponent=ruleAbstractComponent 
	 { $current=$iv_ruleAbstractComponent.current; } 
	 EOF 
;

// Rule AbstractComponent
ruleAbstractComponent returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(
    { 
        newCompositeNode(grammarAccess.getAbstractComponentAccess().getMetaModuleParserRuleCall_0()); 
    }
    this_MetaModule_0=ruleMetaModule
    { 
        $current = $this_MetaModule_0.current; 
        afterParserOrEnumRuleCall();
    }

    |
    { 
        newCompositeNode(grammarAccess.getAbstractComponentAccess().getViewParserRuleCall_1()); 
    }
    this_View_1=ruleView
    { 
        $current = $this_View_1.current; 
        afterParserOrEnumRuleCall();
    }
)
;





// Entry rule entryRuleView
entryRuleView returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getViewRule()); }
	 iv_ruleView=ruleView 
	 { $current=$iv_ruleView.current; } 
	 EOF 
;

// Rule View
ruleView returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(	otherlv_0='view' 
    {
    	newLeafNode(otherlv_0, grammarAccess.getViewAccess().getViewKeyword_0());
    }
(
(
		lv_name_1_0=RULE_ID_ASML
		{
			newLeafNode(lv_name_1_0, grammarAccess.getViewAccess().getNameID_ASMLTerminalRuleCall_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getViewRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"name",
        		lv_name_1_0, 
        		"ID_ASML");
	    }

)
)	otherlv_2='{' 
    {
    	newLeafNode(otherlv_2, grammarAccess.getViewAccess().getLeftCurlyBracketKeyword_2());
    }
((	otherlv_3='attributes' 
    {
    	newLeafNode(otherlv_3, grammarAccess.getViewAccess().getAttributesKeyword_3_0_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getViewAccess().getAttributesAttributeParserRuleCall_3_0_1_0()); 
	    }
		lv_attributes_4_0=ruleAttribute		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getViewRule());
	        }
       		add(
       			$current, 
       			"attributes",
        		lv_attributes_4_0, 
        		"Attribute");
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_5=',' 
    {
    	newLeafNode(otherlv_5, grammarAccess.getViewAccess().getCommaKeyword_3_0_2());
    }
)?)*	otherlv_6=';' 
    {
    	newLeafNode(otherlv_6, grammarAccess.getViewAccess().getSemicolonKeyword_3_1());
    }
)?(
(
		{ 
	        newCompositeNode(grammarAccess.getViewAccess().getComponentsAbstractComponentParserRuleCall_4_0()); 
	    }
		lv_components_7_0=ruleAbstractComponent		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getViewRule());
	        }
       		add(
       			$current, 
       			"components",
        		lv_components_7_0, 
        		"AbstractComponent");
	        afterParserOrEnumRuleCall();
	    }

)
)*(
(
		{ 
	        newCompositeNode(grammarAccess.getViewAccess().getRestrictionsRestrictionParserRuleCall_5_0()); 
	    }
		lv_restrictions_8_0=ruleRestriction		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getViewRule());
	        }
       		add(
       			$current, 
       			"restrictions",
        		lv_restrictions_8_0, 
        		"Restriction");
	        afterParserOrEnumRuleCall();
	    }

)
)*	otherlv_9='}' 
    {
    	newLeafNode(otherlv_9, grammarAccess.getViewAccess().getRightCurlyBracketKeyword_6());
    }
)
;





// Entry rule entryRuleAttribute
entryRuleAttribute returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getAttributeRule()); }
	 iv_ruleAttribute=ruleAttribute 
	 { $current=$iv_ruleAttribute.current; } 
	 EOF 
;

// Rule Attribute
ruleAttribute returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
(
		lv_name_0_0=RULE_ID_ASML
		{
			newLeafNode(lv_name_0_0, grammarAccess.getAttributeAccess().getNameID_ASMLTerminalRuleCall_0_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getAttributeRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"name",
        		lv_name_0_0, 
        		"ID_ASML");
	    }

)
)	otherlv_1=':' 
    {
    	newLeafNode(otherlv_1, grammarAccess.getAttributeAccess().getColonKeyword_1());
    }
(
(
		lv_value_2_0=RULE_STRING
		{
			newLeafNode(lv_value_2_0, grammarAccess.getAttributeAccess().getValueSTRINGTerminalRuleCall_2_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getAttributeRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"value",
        		lv_value_2_0, 
        		"STRING");
	    }

)
))
;











// Entry rule entryRuleClassMatching
entryRuleClassMatching returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getClassMatchingRule()); }
	 iv_ruleClassMatching=ruleClassMatching 
	 { $current=$iv_ruleClassMatching.current; } 
	 EOF 
;

// Rule ClassMatching
ruleClassMatching returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
(
		{ 
	        newCompositeNode(grammarAccess.getClassMatchingAccess().getExpressionMatchingExpressionMatchingClauseEnumRuleCall_0_0()); 
	    }
		lv_expressionMatching_0_0=ruleExpressionMatchingClause		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getClassMatchingRule());
	        }
       		set(
       			$current, 
       			"expressionMatching",
        		lv_expressionMatching_0_0, 
        		"ExpressionMatchingClause");
	        afterParserOrEnumRuleCall();
	    }

)
)(
(
		lv_parameter_1_0=RULE_STRING
		{
			newLeafNode(lv_parameter_1_0, grammarAccess.getClassMatchingAccess().getParameterSTRINGTerminalRuleCall_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getClassMatchingRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"parameter",
        		lv_parameter_1_0, 
        		"STRING");
	    }

)
))
;





// Entry rule entryRuleMetaModule
entryRuleMetaModule returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getMetaModuleRule()); }
	 iv_ruleMetaModule=ruleMetaModule 
	 { $current=$iv_ruleMetaModule.current; } 
	 EOF 
;

// Rule MetaModule
ruleMetaModule returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
(
		lv_name_0_0=RULE_ID_ASML
		{
			newLeafNode(lv_name_0_0, grammarAccess.getMetaModuleAccess().getNameID_ASMLTerminalRuleCall_0_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getMetaModuleRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"name",
        		lv_name_0_0, 
        		"ID_ASML");
	    }

)
)	otherlv_1='{' 
    {
    	newLeafNode(otherlv_1, grammarAccess.getMetaModuleAccess().getLeftCurlyBracketKeyword_1());
    }
((	otherlv_2='attributes:' 
    {
    	newLeafNode(otherlv_2, grammarAccess.getMetaModuleAccess().getAttributesKeyword_2_0_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getMetaModuleAccess().getAttributesAttributeParserRuleCall_2_0_1_0()); 
	    }
		lv_attributes_3_0=ruleAttribute		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getMetaModuleRule());
	        }
       		add(
       			$current, 
       			"attributes",
        		lv_attributes_3_0, 
        		"Attribute");
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_4=',' 
    {
    	newLeafNode(otherlv_4, grammarAccess.getMetaModuleAccess().getCommaKeyword_2_0_2());
    }
)?)*	otherlv_5=';' 
    {
    	newLeafNode(otherlv_5, grammarAccess.getMetaModuleAccess().getSemicolonKeyword_2_1());
    }
)?(	otherlv_6='matching:' 
    {
    	newLeafNode(otherlv_6, grammarAccess.getMetaModuleAccess().getMatchingKeyword_3_0());
    }
(
(
		lv_matching_7_0=RULE_STRING
		{
			newLeafNode(lv_matching_7_0, grammarAccess.getMetaModuleAccess().getMatchingSTRINGTerminalRuleCall_3_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getMetaModuleRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"matching",
        		lv_matching_7_0, 
        		"STRING");
	    }

)
)	otherlv_8=';' 
    {
    	newLeafNode(otherlv_8, grammarAccess.getMetaModuleAccess().getSemicolonKeyword_3_2());
    }
)?(	otherlv_9='description:' 
    {
    	newLeafNode(otherlv_9, grammarAccess.getMetaModuleAccess().getDescriptionKeyword_4_0());
    }
(
(
		lv_description_10_0=RULE_STRING
		{
			newLeafNode(lv_description_10_0, grammarAccess.getMetaModuleAccess().getDescriptionSTRINGTerminalRuleCall_4_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getMetaModuleRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"description",
        		lv_description_10_0, 
        		"STRING");
	    }

)
)	otherlv_11=';' 
    {
    	newLeafNode(otherlv_11, grammarAccess.getMetaModuleAccess().getSemicolonKeyword_4_2());
    }
)?(
(
		{ 
	        newCompositeNode(grammarAccess.getMetaModuleAccess().getComponentsAbstractComponentParserRuleCall_5_0()); 
	    }
		lv_components_12_0=ruleAbstractComponent		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getMetaModuleRule());
	        }
       		add(
       			$current, 
       			"components",
        		lv_components_12_0, 
        		"AbstractComponent");
	        afterParserOrEnumRuleCall();
	    }

)
)*(	otherlv_13='restrictions' 
    {
    	newLeafNode(otherlv_13, grammarAccess.getMetaModuleAccess().getRestrictionsKeyword_6_0());
    }
	otherlv_14='{' 
    {
    	newLeafNode(otherlv_14, grammarAccess.getMetaModuleAccess().getLeftCurlyBracketKeyword_6_1());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getMetaModuleAccess().getRestrictionsRestrictionParserRuleCall_6_2_0()); 
	    }
		lv_restrictions_15_0=ruleRestriction		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getMetaModuleRule());
	        }
       		add(
       			$current, 
       			"restrictions",
        		lv_restrictions_15_0, 
        		"Restriction");
	        afterParserOrEnumRuleCall();
	    }

)
)*	otherlv_16='}' 
    {
    	newLeafNode(otherlv_16, grammarAccess.getMetaModuleAccess().getRightCurlyBracketKeyword_6_3());
    }
)?	otherlv_17='}' 
    {
    	newLeafNode(otherlv_17, grammarAccess.getMetaModuleAccess().getRightCurlyBracketKeyword_7());
    }
)
;





// Entry rule entryRuleQualifiedName
entryRuleQualifiedName returns [String current=null] 
	:
	{ newCompositeNode(grammarAccess.getQualifiedNameRule()); } 
	 iv_ruleQualifiedName=ruleQualifiedName 
	 { $current=$iv_ruleQualifiedName.current.getText(); }  
	 EOF 
;

// Rule QualifiedName
ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(    this_ID_ASML_0=RULE_ID_ASML    {
		$current.merge(this_ID_ASML_0);
    }

    { 
    newLeafNode(this_ID_ASML_0, grammarAccess.getQualifiedNameAccess().getID_ASMLTerminalRuleCall_0()); 
    }
(
	kw='.' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 
    }
    this_ID_ASML_2=RULE_ID_ASML    {
		$current.merge(this_ID_ASML_2);
    }

    { 
    newLeafNode(this_ID_ASML_2, grammarAccess.getQualifiedNameAccess().getID_ASMLTerminalRuleCall_1_1()); 
    }
)*)
    ;





// Entry rule entryRuleRestriction
entryRuleRestriction returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getRestrictionRule()); }
	 iv_ruleRestriction=ruleRestriction 
	 { $current=$iv_ruleRestriction.current; } 
	 EOF 
;

// Rule Restriction
ruleRestriction returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
(
		{ 
	        newCompositeNode(grammarAccess.getRestrictionAccess().getGroupClauseGroupClauseEnumRuleCall_0_0()); 
	    }
		lv_groupClause_0_0=ruleGroupClause		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getRestrictionRule());
	        }
       		set(
       			$current, 
       			"groupClause",
        		lv_groupClause_0_0, 
        		"GroupClause");
	        afterParserOrEnumRuleCall();
	    }

)
)?(
(
		{ 
	        newCompositeNode(grammarAccess.getRestrictionAccess().getPermissionClausePermissionClauseEnumRuleCall_1_0()); 
	    }
		lv_permissionClause_1_0=rulePermissionClause		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getRestrictionRule());
	        }
       		set(
       			$current, 
       			"permissionClause",
        		lv_permissionClause_1_0, 
        		"PermissionClause");
	        afterParserOrEnumRuleCall();
	    }

)
)?(
(
		{ 
	        newCompositeNode(grammarAccess.getRestrictionAccess().getRelactionTypeRelactionTypeEnumRuleCall_2_0()); 
	    }
		lv_relactionType_2_0=ruleRelactionType		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getRestrictionRule());
	        }
       		set(
       			$current, 
       			"relactionType",
        		lv_relactionType_2_0, 
        		"RelactionType");
	        afterParserOrEnumRuleCall();
	    }

)
)(
(
		{ 
	        newCompositeNode(grammarAccess.getRestrictionAccess().getGroupClauseBGroupClauseEnumRuleCall_3_0()); 
	    }
		lv_groupClauseB_3_0=ruleGroupClause		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getRestrictionRule());
	        }
       		set(
       			$current, 
       			"groupClauseB",
        		lv_groupClauseB_3_0, 
        		"GroupClause");
	        afterParserOrEnumRuleCall();
	    }

)
)?((
(
		{ 
	        newCompositeNode(grammarAccess.getRestrictionAccess().getComponentBComponentsBinRestrictionDeclareationParserRuleCall_4_0_0()); 
	    }
		lv_componentB_4_0=ruleComponentsBinRestrictionDeclareation		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getRestrictionRule());
	        }
       		add(
       			$current, 
       			"componentB",
        		lv_componentB_4_0, 
        		"ComponentsBinRestrictionDeclareation");
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_5=',' 
    {
    	newLeafNode(otherlv_5, grammarAccess.getRestrictionAccess().getCommaKeyword_4_1());
    }
)?)*(	otherlv_6='message' 
    {
    	newLeafNode(otherlv_6, grammarAccess.getRestrictionAccess().getMessageKeyword_5_0());
    }
(
(
		lv_message_7_0=RULE_STRING
		{
			newLeafNode(lv_message_7_0, grammarAccess.getRestrictionAccess().getMessageSTRINGTerminalRuleCall_5_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getRestrictionRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"message",
        		lv_message_7_0, 
        		"STRING");
	    }

)
))?	otherlv_8=';' 
    {
    	newLeafNode(otherlv_8, grammarAccess.getRestrictionAccess().getSemicolonKeyword_6());
    }
)
;





// Entry rule entryRuleComponentsBinRestrictionDeclareation
entryRuleComponentsBinRestrictionDeclareation returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getComponentsBinRestrictionDeclareationRule()); }
	 iv_ruleComponentsBinRestrictionDeclareation=ruleComponentsBinRestrictionDeclareation 
	 { $current=$iv_ruleComponentsBinRestrictionDeclareation.current; } 
	 EOF 
;

// Rule ComponentsBinRestrictionDeclareation
ruleComponentsBinRestrictionDeclareation returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getComponentsBinRestrictionDeclareationRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getComponentsBinRestrictionDeclareationAccess().getComponentBAbstractComponentCrossReference_0_0()); 
	    }
		ruleQualifiedName		{ 
	        afterParserOrEnumRuleCall();
	    }

)
)(
(
		{ 
	        newCompositeNode(grammarAccess.getComponentsBinRestrictionDeclareationAccess().getWildcardWildCardEnumRuleCall_1_0()); 
	    }
		lv_wildcard_1_0=ruleWildCard		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getComponentsBinRestrictionDeclareationRule());
	        }
       		set(
       			$current, 
       			"wildcard",
        		lv_wildcard_1_0, 
        		"WildCard");
	        afterParserOrEnumRuleCall();
	    }

)
)?)
;







// Rule ExpressionMatchingClause
ruleExpressionMatchingClause returns [Enumerator current=null] 
    @init { enterRule(); }
    @after { leaveRule(); }:
((	enumLiteral_0='name start with' 
	{
        $current = grammarAccess.getExpressionMatchingClauseAccess().getNAME_START_WITHEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_0, grammarAccess.getExpressionMatchingClauseAccess().getNAME_START_WITHEnumLiteralDeclaration_0()); 
    }
)
    |(	enumLiteral_1='name ends with' 
	{
        $current = grammarAccess.getExpressionMatchingClauseAccess().getNAME_ENDS_WITHEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_1, grammarAccess.getExpressionMatchingClauseAccess().getNAME_ENDS_WITHEnumLiteralDeclaration_1()); 
    }
)
    |(	enumLiteral_2='annotated with' 
	{
        $current = grammarAccess.getExpressionMatchingClauseAccess().getANNOTATED_WITHEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_2, grammarAccess.getExpressionMatchingClauseAccess().getANNOTATED_WITHEnumLiteralDeclaration_2()); 
    }
));



// Rule ModuleMatchingParamenter
ruleModuleMatchingParamenter returns [Enumerator current=null] 
    @init { enterRule(); }
    @after { leaveRule(); }:
((	enumLiteral_0='by package name' 
	{
        $current = grammarAccess.getModuleMatchingParamenterAccess().getPAKCAGEEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_0, grammarAccess.getModuleMatchingParamenterAccess().getPAKCAGEEnumLiteralDeclaration_0()); 
    }
)
    |(	enumLiteral_1='by folder name' 
	{
        $current = grammarAccess.getModuleMatchingParamenterAccess().getFOLDEREnumLiteralDeclaration_1().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_1, grammarAccess.getModuleMatchingParamenterAccess().getFOLDEREnumLiteralDeclaration_1()); 
    }
)
    |(	enumLiteral_2='by package and folder name' 
	{
        $current = grammarAccess.getModuleMatchingParamenterAccess().getPAKCAGE_AND_FOLDEREnumLiteralDeclaration_2().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_2, grammarAccess.getModuleMatchingParamenterAccess().getPAKCAGE_AND_FOLDEREnumLiteralDeclaration_2()); 
    }
)
    |(	enumLiteral_3='by external implementation' 
	{
        $current = grammarAccess.getModuleMatchingParamenterAccess().getEXTERNAL_DEFINITIONEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_3, grammarAccess.getModuleMatchingParamenterAccess().getEXTERNAL_DEFINITIONEnumLiteralDeclaration_3()); 
    }
));



// Rule GroupClause
ruleGroupClause returns [Enumerator current=null] 
    @init { enterRule(); }
    @after { leaveRule(); }:
((	enumLiteral_0='$null' 
	{
        $current = grammarAccess.getGroupClauseAccess().getNULLEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_0, grammarAccess.getGroupClauseAccess().getNULLEnumLiteralDeclaration_0()); 
    }
)
    |(	enumLiteral_1='only' 
	{
        $current = grammarAccess.getGroupClauseAccess().getONLYEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_1, grammarAccess.getGroupClauseAccess().getONLYEnumLiteralDeclaration_1()); 
    }
)
    |(	enumLiteral_2='only-this' 
	{
        $current = grammarAccess.getGroupClauseAccess().getONLY_THISEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_2, grammarAccess.getGroupClauseAccess().getONLY_THISEnumLiteralDeclaration_2()); 
    }
));



// Rule PermissionClause
rulePermissionClause returns [Enumerator current=null] 
    @init { enterRule(); }
    @after { leaveRule(); }:
((	enumLiteral_0='must' 
	{
        $current = grammarAccess.getPermissionClauseAccess().getMUSTEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_0, grammarAccess.getPermissionClauseAccess().getMUSTEnumLiteralDeclaration_0()); 
    }
)
    |(	enumLiteral_1='can' 
	{
        $current = grammarAccess.getPermissionClauseAccess().getCANEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_1, grammarAccess.getPermissionClauseAccess().getCANEnumLiteralDeclaration_1()); 
    }
)
    |(	enumLiteral_2='cannot' 
	{
        $current = grammarAccess.getPermissionClauseAccess().getCANNOTEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_2, grammarAccess.getPermissionClauseAccess().getCANNOTEnumLiteralDeclaration_2()); 
    }
));



// Rule RelactionType
ruleRelactionType returns [Enumerator current=null] 
    @init { enterRule(); }
    @after { leaveRule(); }:
((	enumLiteral_0='access' 
	{
        $current = grammarAccess.getRelactionTypeAccess().getACCESSEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_0, grammarAccess.getRelactionTypeAccess().getACCESSEnumLiteralDeclaration_0()); 
    }
)
    |(	enumLiteral_1='declare' 
	{
        $current = grammarAccess.getRelactionTypeAccess().getDECLAREEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_1, grammarAccess.getRelactionTypeAccess().getDECLAREEnumLiteralDeclaration_1()); 
    }
)
    |(	enumLiteral_2='handle' 
	{
        $current = grammarAccess.getRelactionTypeAccess().getHANDLEEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_2, grammarAccess.getRelactionTypeAccess().getHANDLEEnumLiteralDeclaration_2()); 
    }
)
    |(	enumLiteral_3='extend' 
	{
        $current = grammarAccess.getRelactionTypeAccess().getEXTENDEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_3, grammarAccess.getRelactionTypeAccess().getEXTENDEnumLiteralDeclaration_3()); 
    }
)
    |(	enumLiteral_4='implement' 
	{
        $current = grammarAccess.getRelactionTypeAccess().getIMPLEMENTEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_4, grammarAccess.getRelactionTypeAccess().getIMPLEMENTEnumLiteralDeclaration_4()); 
    }
)
    |(	enumLiteral_5='create' 
	{
        $current = grammarAccess.getRelactionTypeAccess().getCREATEEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_5, grammarAccess.getRelactionTypeAccess().getCREATEEnumLiteralDeclaration_5()); 
    }
)
    |(	enumLiteral_6='throw' 
	{
        $current = grammarAccess.getRelactionTypeAccess().getTHROWEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_6, grammarAccess.getRelactionTypeAccess().getTHROWEnumLiteralDeclaration_6()); 
    }
)
    |(	enumLiteral_7='use-annotation' 
	{
        $current = grammarAccess.getRelactionTypeAccess().getUSEANOTATIONEnumLiteralDeclaration_7().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_7, grammarAccess.getRelactionTypeAccess().getUSEANOTATIONEnumLiteralDeclaration_7()); 
    }
)
    |(	enumLiteral_8='depend' 
	{
        $current = grammarAccess.getRelactionTypeAccess().getDEPENDEnumLiteralDeclaration_8().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_8, grammarAccess.getRelactionTypeAccess().getDEPENDEnumLiteralDeclaration_8()); 
    }
)
    |(	enumLiteral_9='requires' 
	{
        $current = grammarAccess.getRelactionTypeAccess().getREQUIRESEnumLiteralDeclaration_9().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_9, grammarAccess.getRelactionTypeAccess().getREQUIRESEnumLiteralDeclaration_9()); 
    }
));



// Rule WildCard
ruleWildCard returns [Enumerator current=null] 
    @init { enterRule(); }
    @after { leaveRule(); }:
((	enumLiteral_0='.*' 
	{
        $current = grammarAccess.getWildCardAccess().getPackageEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_0, grammarAccess.getWildCardAccess().getPackageEnumLiteralDeclaration_0()); 
    }
)
    |(	enumLiteral_1='.**' 
	{
        $current = grammarAccess.getWildCardAccess().getPackageAndSubPackageEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_1, grammarAccess.getWildCardAccess().getPackageAndSubPackageEnumLiteralDeclaration_1()); 
    }
));



RULE_ID_ASML : ('a'..'z'|'A'..'Z'|'_'|'.') ('a'..'z'|'A'..'Z'|'_'|'-'|'.'|'0'..'9')*;

RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

RULE_INT : ('0'..'9')+;

RULE_STRING : ('"' ('\\' .|~(('\\'|'"')))* '"'|'\'' ('\\' .|~(('\\'|'\'')))* '\'');

RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

RULE_WS : (' '|'\t'|'\r'|'\n')+;

RULE_ANY_OTHER : .;

