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



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalASMLModelParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID_ASML", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'architecture'", "'{'", "'import'", "';'", "'ignore'", "','", "'}'", "'view'", "'attributes'", "':'", "'attributes:'", "'matching:'", "'description:'", "'restrictions'", "'.'", "'message'", "'name start with'", "'name ends with'", "'annotated with'", "'by package name'", "'by folder name'", "'by package and folder name'", "'by external implementation'", "'$null'", "'only'", "'only-this'", "'must'", "'can'", "'cannot'", "'access'", "'declare'", "'handle'", "'extend'", "'implement'", "'create'", "'throw'", "'use-annotation'", "'depend'", "'requires'", "'.*'", "'.**'"
    };
    public static final int RULE_ID_ASML=4;
    public static final int RULE_ID=6;
    public static final int T__29=29;
    public static final int T__28=28;
    public static final int T__27=27;
    public static final int T__26=26;
    public static final int T__25=25;
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int RULE_ANY_OTHER=11;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int EOF=-1;
    public static final int T__19=19;
    public static final int T__51=51;
    public static final int T__16=16;
    public static final int T__52=52;
    public static final int T__15=15;
    public static final int T__18=18;
    public static final int T__17=17;
    public static final int T__12=12;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int RULE_INT=7;
    public static final int T__50=50;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int RULE_SL_COMMENT=9;
    public static final int RULE_ML_COMMENT=8;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int RULE_STRING=5;
    public static final int T__32=32;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int RULE_WS=10;

    // delegates
    // delegators


        public InternalASMLModelParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalASMLModelParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalASMLModelParser.tokenNames; }
    public String getGrammarFileName() { return "../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g"; }



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



    // $ANTLR start "entryRuleASMLModel"
    // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:68:1: entryRuleASMLModel returns [EObject current=null] : iv_ruleASMLModel= ruleASMLModel EOF ;
    public final EObject entryRuleASMLModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleASMLModel = null;


        try {
            // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:69:2: (iv_ruleASMLModel= ruleASMLModel EOF )
            // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:70:2: iv_ruleASMLModel= ruleASMLModel EOF
            {
             newCompositeNode(grammarAccess.getASMLModelRule()); 
            pushFollow(FOLLOW_ruleASMLModel_in_entryRuleASMLModel75);
            iv_ruleASMLModel=ruleASMLModel();

            state._fsp--;

             current =iv_ruleASMLModel; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleASMLModel85); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleASMLModel"


    // $ANTLR start "ruleASMLModel"
    // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:77:1: ruleASMLModel returns [EObject current=null] : (otherlv_0= 'architecture' ( (lv_name_1_0= RULE_ID_ASML ) ) otherlv_2= '{' (otherlv_3= 'import' ( (lv_importURI_4_0= RULE_STRING ) ) otherlv_5= ';' )? ( (lv_components_6_0= ruleAbstractComponent ) )* (otherlv_7= 'ignore' ( ( (lv_ignore_8_0= RULE_STRING ) ) (otherlv_9= ',' )? )* otherlv_10= ';' )? otherlv_11= '}' ) ;
    public final EObject ruleASMLModel() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_importURI_4_0=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token lv_ignore_8_0=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        EObject lv_components_6_0 = null;


         enterRule(); 
            
        try {
            // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:80:28: ( (otherlv_0= 'architecture' ( (lv_name_1_0= RULE_ID_ASML ) ) otherlv_2= '{' (otherlv_3= 'import' ( (lv_importURI_4_0= RULE_STRING ) ) otherlv_5= ';' )? ( (lv_components_6_0= ruleAbstractComponent ) )* (otherlv_7= 'ignore' ( ( (lv_ignore_8_0= RULE_STRING ) ) (otherlv_9= ',' )? )* otherlv_10= ';' )? otherlv_11= '}' ) )
            // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:81:1: (otherlv_0= 'architecture' ( (lv_name_1_0= RULE_ID_ASML ) ) otherlv_2= '{' (otherlv_3= 'import' ( (lv_importURI_4_0= RULE_STRING ) ) otherlv_5= ';' )? ( (lv_components_6_0= ruleAbstractComponent ) )* (otherlv_7= 'ignore' ( ( (lv_ignore_8_0= RULE_STRING ) ) (otherlv_9= ',' )? )* otherlv_10= ';' )? otherlv_11= '}' )
            {
            // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:81:1: (otherlv_0= 'architecture' ( (lv_name_1_0= RULE_ID_ASML ) ) otherlv_2= '{' (otherlv_3= 'import' ( (lv_importURI_4_0= RULE_STRING ) ) otherlv_5= ';' )? ( (lv_components_6_0= ruleAbstractComponent ) )* (otherlv_7= 'ignore' ( ( (lv_ignore_8_0= RULE_STRING ) ) (otherlv_9= ',' )? )* otherlv_10= ';' )? otherlv_11= '}' )
            // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:81:3: otherlv_0= 'architecture' ( (lv_name_1_0= RULE_ID_ASML ) ) otherlv_2= '{' (otherlv_3= 'import' ( (lv_importURI_4_0= RULE_STRING ) ) otherlv_5= ';' )? ( (lv_components_6_0= ruleAbstractComponent ) )* (otherlv_7= 'ignore' ( ( (lv_ignore_8_0= RULE_STRING ) ) (otherlv_9= ',' )? )* otherlv_10= ';' )? otherlv_11= '}'
            {
            otherlv_0=(Token)match(input,12,FOLLOW_12_in_ruleASMLModel122); 

                	newLeafNode(otherlv_0, grammarAccess.getASMLModelAccess().getArchitectureKeyword_0());
                
            // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:85:1: ( (lv_name_1_0= RULE_ID_ASML ) )
            // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:86:1: (lv_name_1_0= RULE_ID_ASML )
            {
            // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:86:1: (lv_name_1_0= RULE_ID_ASML )
            // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:87:3: lv_name_1_0= RULE_ID_ASML
            {
            lv_name_1_0=(Token)match(input,RULE_ID_ASML,FOLLOW_RULE_ID_ASML_in_ruleASMLModel139); 

            			newLeafNode(lv_name_1_0, grammarAccess.getASMLModelAccess().getNameID_ASMLTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getASMLModelRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID_ASML");
            	    

            }


            }

            otherlv_2=(Token)match(input,13,FOLLOW_13_in_ruleASMLModel156); 

                	newLeafNode(otherlv_2, grammarAccess.getASMLModelAccess().getLeftCurlyBracketKeyword_2());
                
            // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:107:1: (otherlv_3= 'import' ( (lv_importURI_4_0= RULE_STRING ) ) otherlv_5= ';' )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==14) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:107:3: otherlv_3= 'import' ( (lv_importURI_4_0= RULE_STRING ) ) otherlv_5= ';'
                    {
                    otherlv_3=(Token)match(input,14,FOLLOW_14_in_ruleASMLModel169); 

                        	newLeafNode(otherlv_3, grammarAccess.getASMLModelAccess().getImportKeyword_3_0());
                        
                    // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:111:1: ( (lv_importURI_4_0= RULE_STRING ) )
                    // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:112:1: (lv_importURI_4_0= RULE_STRING )
                    {
                    // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:112:1: (lv_importURI_4_0= RULE_STRING )
                    // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:113:3: lv_importURI_4_0= RULE_STRING
                    {
                    lv_importURI_4_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleASMLModel186); 

                    			newLeafNode(lv_importURI_4_0, grammarAccess.getASMLModelAccess().getImportURISTRINGTerminalRuleCall_3_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getASMLModelRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"importURI",
                            		lv_importURI_4_0, 
                            		"STRING");
                    	    

                    }


                    }

                    otherlv_5=(Token)match(input,15,FOLLOW_15_in_ruleASMLModel203); 

                        	newLeafNode(otherlv_5, grammarAccess.getASMLModelAccess().getSemicolonKeyword_3_2());
                        

                    }
                    break;

            }

            // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:133:3: ( (lv_components_6_0= ruleAbstractComponent ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==RULE_ID_ASML||LA2_0==19) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:134:1: (lv_components_6_0= ruleAbstractComponent )
            	    {
            	    // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:134:1: (lv_components_6_0= ruleAbstractComponent )
            	    // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:135:3: lv_components_6_0= ruleAbstractComponent
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getASMLModelAccess().getComponentsAbstractComponentParserRuleCall_4_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleAbstractComponent_in_ruleASMLModel226);
            	    lv_components_6_0=ruleAbstractComponent();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getASMLModelRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"components",
            	            		lv_components_6_0, 
            	            		"AbstractComponent");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:151:3: (otherlv_7= 'ignore' ( ( (lv_ignore_8_0= RULE_STRING ) ) (otherlv_9= ',' )? )* otherlv_10= ';' )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==16) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:151:5: otherlv_7= 'ignore' ( ( (lv_ignore_8_0= RULE_STRING ) ) (otherlv_9= ',' )? )* otherlv_10= ';'
                    {
                    otherlv_7=(Token)match(input,16,FOLLOW_16_in_ruleASMLModel240); 

                        	newLeafNode(otherlv_7, grammarAccess.getASMLModelAccess().getIgnoreKeyword_5_0());
                        
                    // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:155:1: ( ( (lv_ignore_8_0= RULE_STRING ) ) (otherlv_9= ',' )? )*
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( (LA4_0==RULE_STRING) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:155:2: ( (lv_ignore_8_0= RULE_STRING ) ) (otherlv_9= ',' )?
                    	    {
                    	    // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:155:2: ( (lv_ignore_8_0= RULE_STRING ) )
                    	    // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:156:1: (lv_ignore_8_0= RULE_STRING )
                    	    {
                    	    // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:156:1: (lv_ignore_8_0= RULE_STRING )
                    	    // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:157:3: lv_ignore_8_0= RULE_STRING
                    	    {
                    	    lv_ignore_8_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleASMLModel258); 

                    	    			newLeafNode(lv_ignore_8_0, grammarAccess.getASMLModelAccess().getIgnoreSTRINGTerminalRuleCall_5_1_0_0()); 
                    	    		

                    	    	        if (current==null) {
                    	    	            current = createModelElement(grammarAccess.getASMLModelRule());
                    	    	        }
                    	           		addWithLastConsumed(
                    	           			current, 
                    	           			"ignore",
                    	            		lv_ignore_8_0, 
                    	            		"STRING");
                    	    	    

                    	    }


                    	    }

                    	    // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:173:2: (otherlv_9= ',' )?
                    	    int alt3=2;
                    	    int LA3_0 = input.LA(1);

                    	    if ( (LA3_0==17) ) {
                    	        alt3=1;
                    	    }
                    	    switch (alt3) {
                    	        case 1 :
                    	            // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:173:4: otherlv_9= ','
                    	            {
                    	            otherlv_9=(Token)match(input,17,FOLLOW_17_in_ruleASMLModel276); 

                    	                	newLeafNode(otherlv_9, grammarAccess.getASMLModelAccess().getCommaKeyword_5_1_1());
                    	                

                    	            }
                    	            break;

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop4;
                        }
                    } while (true);

                    otherlv_10=(Token)match(input,15,FOLLOW_15_in_ruleASMLModel292); 

                        	newLeafNode(otherlv_10, grammarAccess.getASMLModelAccess().getSemicolonKeyword_5_2());
                        

                    }
                    break;

            }

            otherlv_11=(Token)match(input,18,FOLLOW_18_in_ruleASMLModel306); 

                	newLeafNode(otherlv_11, grammarAccess.getASMLModelAccess().getRightCurlyBracketKeyword_6());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleASMLModel"


    // $ANTLR start "entryRuleAbstractComponent"
    // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:193:1: entryRuleAbstractComponent returns [EObject current=null] : iv_ruleAbstractComponent= ruleAbstractComponent EOF ;
    public final EObject entryRuleAbstractComponent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstractComponent = null;


        try {
            // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:194:2: (iv_ruleAbstractComponent= ruleAbstractComponent EOF )
            // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:195:2: iv_ruleAbstractComponent= ruleAbstractComponent EOF
            {
             newCompositeNode(grammarAccess.getAbstractComponentRule()); 
            pushFollow(FOLLOW_ruleAbstractComponent_in_entryRuleAbstractComponent342);
            iv_ruleAbstractComponent=ruleAbstractComponent();

            state._fsp--;

             current =iv_ruleAbstractComponent; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAbstractComponent352); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAbstractComponent"


    // $ANTLR start "ruleAbstractComponent"
    // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:202:1: ruleAbstractComponent returns [EObject current=null] : (this_MetaModule_0= ruleMetaModule | this_View_1= ruleView ) ;
    public final EObject ruleAbstractComponent() throws RecognitionException {
        EObject current = null;

        EObject this_MetaModule_0 = null;

        EObject this_View_1 = null;


         enterRule(); 
            
        try {
            // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:205:28: ( (this_MetaModule_0= ruleMetaModule | this_View_1= ruleView ) )
            // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:206:1: (this_MetaModule_0= ruleMetaModule | this_View_1= ruleView )
            {
            // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:206:1: (this_MetaModule_0= ruleMetaModule | this_View_1= ruleView )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==RULE_ID_ASML) ) {
                alt6=1;
            }
            else if ( (LA6_0==19) ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:207:5: this_MetaModule_0= ruleMetaModule
                    {
                     
                            newCompositeNode(grammarAccess.getAbstractComponentAccess().getMetaModuleParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleMetaModule_in_ruleAbstractComponent399);
                    this_MetaModule_0=ruleMetaModule();

                    state._fsp--;

                     
                            current = this_MetaModule_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:217:5: this_View_1= ruleView
                    {
                     
                            newCompositeNode(grammarAccess.getAbstractComponentAccess().getViewParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleView_in_ruleAbstractComponent426);
                    this_View_1=ruleView();

                    state._fsp--;

                     
                            current = this_View_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAbstractComponent"


    // $ANTLR start "entryRuleView"
    // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:233:1: entryRuleView returns [EObject current=null] : iv_ruleView= ruleView EOF ;
    public final EObject entryRuleView() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleView = null;


        try {
            // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:234:2: (iv_ruleView= ruleView EOF )
            // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:235:2: iv_ruleView= ruleView EOF
            {
             newCompositeNode(grammarAccess.getViewRule()); 
            pushFollow(FOLLOW_ruleView_in_entryRuleView461);
            iv_ruleView=ruleView();

            state._fsp--;

             current =iv_ruleView; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleView471); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleView"


    // $ANTLR start "ruleView"
    // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:242:1: ruleView returns [EObject current=null] : (otherlv_0= 'view' ( (lv_name_1_0= RULE_ID_ASML ) ) otherlv_2= '{' ( (otherlv_3= 'attributes' ( (lv_attributes_4_0= ruleAttribute ) ) (otherlv_5= ',' )? )* otherlv_6= ';' )? ( (lv_components_7_0= ruleAbstractComponent ) )* ( (lv_restrictions_8_0= ruleRestriction ) )* otherlv_9= '}' ) ;
    public final EObject ruleView() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_9=null;
        EObject lv_attributes_4_0 = null;

        EObject lv_components_7_0 = null;

        EObject lv_restrictions_8_0 = null;


         enterRule(); 
            
        try {
            // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:245:28: ( (otherlv_0= 'view' ( (lv_name_1_0= RULE_ID_ASML ) ) otherlv_2= '{' ( (otherlv_3= 'attributes' ( (lv_attributes_4_0= ruleAttribute ) ) (otherlv_5= ',' )? )* otherlv_6= ';' )? ( (lv_components_7_0= ruleAbstractComponent ) )* ( (lv_restrictions_8_0= ruleRestriction ) )* otherlv_9= '}' ) )
            // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:246:1: (otherlv_0= 'view' ( (lv_name_1_0= RULE_ID_ASML ) ) otherlv_2= '{' ( (otherlv_3= 'attributes' ( (lv_attributes_4_0= ruleAttribute ) ) (otherlv_5= ',' )? )* otherlv_6= ';' )? ( (lv_components_7_0= ruleAbstractComponent ) )* ( (lv_restrictions_8_0= ruleRestriction ) )* otherlv_9= '}' )
            {
            // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:246:1: (otherlv_0= 'view' ( (lv_name_1_0= RULE_ID_ASML ) ) otherlv_2= '{' ( (otherlv_3= 'attributes' ( (lv_attributes_4_0= ruleAttribute ) ) (otherlv_5= ',' )? )* otherlv_6= ';' )? ( (lv_components_7_0= ruleAbstractComponent ) )* ( (lv_restrictions_8_0= ruleRestriction ) )* otherlv_9= '}' )
            // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:246:3: otherlv_0= 'view' ( (lv_name_1_0= RULE_ID_ASML ) ) otherlv_2= '{' ( (otherlv_3= 'attributes' ( (lv_attributes_4_0= ruleAttribute ) ) (otherlv_5= ',' )? )* otherlv_6= ';' )? ( (lv_components_7_0= ruleAbstractComponent ) )* ( (lv_restrictions_8_0= ruleRestriction ) )* otherlv_9= '}'
            {
            otherlv_0=(Token)match(input,19,FOLLOW_19_in_ruleView508); 

                	newLeafNode(otherlv_0, grammarAccess.getViewAccess().getViewKeyword_0());
                
            // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:250:1: ( (lv_name_1_0= RULE_ID_ASML ) )
            // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:251:1: (lv_name_1_0= RULE_ID_ASML )
            {
            // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:251:1: (lv_name_1_0= RULE_ID_ASML )
            // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:252:3: lv_name_1_0= RULE_ID_ASML
            {
            lv_name_1_0=(Token)match(input,RULE_ID_ASML,FOLLOW_RULE_ID_ASML_in_ruleView525); 

            			newLeafNode(lv_name_1_0, grammarAccess.getViewAccess().getNameID_ASMLTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getViewRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID_ASML");
            	    

            }


            }

            otherlv_2=(Token)match(input,13,FOLLOW_13_in_ruleView542); 

                	newLeafNode(otherlv_2, grammarAccess.getViewAccess().getLeftCurlyBracketKeyword_2());
                
            // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:272:1: ( (otherlv_3= 'attributes' ( (lv_attributes_4_0= ruleAttribute ) ) (otherlv_5= ',' )? )* otherlv_6= ';' )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==15||LA9_0==20) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:272:2: (otherlv_3= 'attributes' ( (lv_attributes_4_0= ruleAttribute ) ) (otherlv_5= ',' )? )* otherlv_6= ';'
                    {
                    // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:272:2: (otherlv_3= 'attributes' ( (lv_attributes_4_0= ruleAttribute ) ) (otherlv_5= ',' )? )*
                    loop8:
                    do {
                        int alt8=2;
                        int LA8_0 = input.LA(1);

                        if ( (LA8_0==20) ) {
                            alt8=1;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:272:4: otherlv_3= 'attributes' ( (lv_attributes_4_0= ruleAttribute ) ) (otherlv_5= ',' )?
                    	    {
                    	    otherlv_3=(Token)match(input,20,FOLLOW_20_in_ruleView556); 

                    	        	newLeafNode(otherlv_3, grammarAccess.getViewAccess().getAttributesKeyword_3_0_0());
                    	        
                    	    // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:276:1: ( (lv_attributes_4_0= ruleAttribute ) )
                    	    // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:277:1: (lv_attributes_4_0= ruleAttribute )
                    	    {
                    	    // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:277:1: (lv_attributes_4_0= ruleAttribute )
                    	    // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:278:3: lv_attributes_4_0= ruleAttribute
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getViewAccess().getAttributesAttributeParserRuleCall_3_0_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleAttribute_in_ruleView577);
                    	    lv_attributes_4_0=ruleAttribute();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getViewRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"attributes",
                    	            		lv_attributes_4_0, 
                    	            		"Attribute");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }

                    	    // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:294:2: (otherlv_5= ',' )?
                    	    int alt7=2;
                    	    int LA7_0 = input.LA(1);

                    	    if ( (LA7_0==17) ) {
                    	        alt7=1;
                    	    }
                    	    switch (alt7) {
                    	        case 1 :
                    	            // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:294:4: otherlv_5= ','
                    	            {
                    	            otherlv_5=(Token)match(input,17,FOLLOW_17_in_ruleView590); 

                    	                	newLeafNode(otherlv_5, grammarAccess.getViewAccess().getCommaKeyword_3_0_2());
                    	                

                    	            }
                    	            break;

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop8;
                        }
                    } while (true);

                    otherlv_6=(Token)match(input,15,FOLLOW_15_in_ruleView606); 

                        	newLeafNode(otherlv_6, grammarAccess.getViewAccess().getSemicolonKeyword_3_1());
                        

                    }
                    break;

            }

            // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:302:3: ( (lv_components_7_0= ruleAbstractComponent ) )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==RULE_ID_ASML||LA10_0==19) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:303:1: (lv_components_7_0= ruleAbstractComponent )
            	    {
            	    // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:303:1: (lv_components_7_0= ruleAbstractComponent )
            	    // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:304:3: lv_components_7_0= ruleAbstractComponent
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getViewAccess().getComponentsAbstractComponentParserRuleCall_4_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleAbstractComponent_in_ruleView629);
            	    lv_components_7_0=ruleAbstractComponent();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getViewRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"components",
            	            		lv_components_7_0, 
            	            		"AbstractComponent");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);

            // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:320:3: ( (lv_restrictions_8_0= ruleRestriction ) )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( ((LA11_0>=35 && LA11_0<=50)) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:321:1: (lv_restrictions_8_0= ruleRestriction )
            	    {
            	    // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:321:1: (lv_restrictions_8_0= ruleRestriction )
            	    // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:322:3: lv_restrictions_8_0= ruleRestriction
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getViewAccess().getRestrictionsRestrictionParserRuleCall_5_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleRestriction_in_ruleView651);
            	    lv_restrictions_8_0=ruleRestriction();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getViewRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"restrictions",
            	            		lv_restrictions_8_0, 
            	            		"Restriction");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);

            otherlv_9=(Token)match(input,18,FOLLOW_18_in_ruleView664); 

                	newLeafNode(otherlv_9, grammarAccess.getViewAccess().getRightCurlyBracketKeyword_6());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleView"


    // $ANTLR start "entryRuleAttribute"
    // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:350:1: entryRuleAttribute returns [EObject current=null] : iv_ruleAttribute= ruleAttribute EOF ;
    public final EObject entryRuleAttribute() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttribute = null;


        try {
            // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:351:2: (iv_ruleAttribute= ruleAttribute EOF )
            // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:352:2: iv_ruleAttribute= ruleAttribute EOF
            {
             newCompositeNode(grammarAccess.getAttributeRule()); 
            pushFollow(FOLLOW_ruleAttribute_in_entryRuleAttribute700);
            iv_ruleAttribute=ruleAttribute();

            state._fsp--;

             current =iv_ruleAttribute; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAttribute710); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAttribute"


    // $ANTLR start "ruleAttribute"
    // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:359:1: ruleAttribute returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID_ASML ) ) otherlv_1= ':' ( (lv_value_2_0= RULE_STRING ) ) ) ;
    public final EObject ruleAttribute() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token lv_value_2_0=null;

         enterRule(); 
            
        try {
            // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:362:28: ( ( ( (lv_name_0_0= RULE_ID_ASML ) ) otherlv_1= ':' ( (lv_value_2_0= RULE_STRING ) ) ) )
            // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:363:1: ( ( (lv_name_0_0= RULE_ID_ASML ) ) otherlv_1= ':' ( (lv_value_2_0= RULE_STRING ) ) )
            {
            // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:363:1: ( ( (lv_name_0_0= RULE_ID_ASML ) ) otherlv_1= ':' ( (lv_value_2_0= RULE_STRING ) ) )
            // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:363:2: ( (lv_name_0_0= RULE_ID_ASML ) ) otherlv_1= ':' ( (lv_value_2_0= RULE_STRING ) )
            {
            // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:363:2: ( (lv_name_0_0= RULE_ID_ASML ) )
            // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:364:1: (lv_name_0_0= RULE_ID_ASML )
            {
            // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:364:1: (lv_name_0_0= RULE_ID_ASML )
            // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:365:3: lv_name_0_0= RULE_ID_ASML
            {
            lv_name_0_0=(Token)match(input,RULE_ID_ASML,FOLLOW_RULE_ID_ASML_in_ruleAttribute752); 

            			newLeafNode(lv_name_0_0, grammarAccess.getAttributeAccess().getNameID_ASMLTerminalRuleCall_0_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getAttributeRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_0_0, 
                    		"ID_ASML");
            	    

            }


            }

            otherlv_1=(Token)match(input,21,FOLLOW_21_in_ruleAttribute769); 

                	newLeafNode(otherlv_1, grammarAccess.getAttributeAccess().getColonKeyword_1());
                
            // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:385:1: ( (lv_value_2_0= RULE_STRING ) )
            // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:386:1: (lv_value_2_0= RULE_STRING )
            {
            // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:386:1: (lv_value_2_0= RULE_STRING )
            // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:387:3: lv_value_2_0= RULE_STRING
            {
            lv_value_2_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleAttribute786); 

            			newLeafNode(lv_value_2_0, grammarAccess.getAttributeAccess().getValueSTRINGTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getAttributeRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"value",
                    		lv_value_2_0, 
                    		"STRING");
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAttribute"


    // $ANTLR start "entryRuleClassMatching"
    // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:417:1: entryRuleClassMatching returns [EObject current=null] : iv_ruleClassMatching= ruleClassMatching EOF ;
    public final EObject entryRuleClassMatching() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleClassMatching = null;


        try {
            // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:418:2: (iv_ruleClassMatching= ruleClassMatching EOF )
            // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:419:2: iv_ruleClassMatching= ruleClassMatching EOF
            {
             newCompositeNode(grammarAccess.getClassMatchingRule()); 
            pushFollow(FOLLOW_ruleClassMatching_in_entryRuleClassMatching833);
            iv_ruleClassMatching=ruleClassMatching();

            state._fsp--;

             current =iv_ruleClassMatching; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleClassMatching843); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleClassMatching"


    // $ANTLR start "ruleClassMatching"
    // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:426:1: ruleClassMatching returns [EObject current=null] : ( ( (lv_expressionMatching_0_0= ruleExpressionMatchingClause ) ) ( (lv_parameter_1_0= RULE_STRING ) ) ) ;
    public final EObject ruleClassMatching() throws RecognitionException {
        EObject current = null;

        Token lv_parameter_1_0=null;
        Enumerator lv_expressionMatching_0_0 = null;


         enterRule(); 
            
        try {
            // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:429:28: ( ( ( (lv_expressionMatching_0_0= ruleExpressionMatchingClause ) ) ( (lv_parameter_1_0= RULE_STRING ) ) ) )
            // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:430:1: ( ( (lv_expressionMatching_0_0= ruleExpressionMatchingClause ) ) ( (lv_parameter_1_0= RULE_STRING ) ) )
            {
            // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:430:1: ( ( (lv_expressionMatching_0_0= ruleExpressionMatchingClause ) ) ( (lv_parameter_1_0= RULE_STRING ) ) )
            // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:430:2: ( (lv_expressionMatching_0_0= ruleExpressionMatchingClause ) ) ( (lv_parameter_1_0= RULE_STRING ) )
            {
            // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:430:2: ( (lv_expressionMatching_0_0= ruleExpressionMatchingClause ) )
            // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:431:1: (lv_expressionMatching_0_0= ruleExpressionMatchingClause )
            {
            // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:431:1: (lv_expressionMatching_0_0= ruleExpressionMatchingClause )
            // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:432:3: lv_expressionMatching_0_0= ruleExpressionMatchingClause
            {
             
            	        newCompositeNode(grammarAccess.getClassMatchingAccess().getExpressionMatchingExpressionMatchingClauseEnumRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleExpressionMatchingClause_in_ruleClassMatching889);
            lv_expressionMatching_0_0=ruleExpressionMatchingClause();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getClassMatchingRule());
            	        }
                   		set(
                   			current, 
                   			"expressionMatching",
                    		lv_expressionMatching_0_0, 
                    		"ExpressionMatchingClause");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:448:2: ( (lv_parameter_1_0= RULE_STRING ) )
            // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:449:1: (lv_parameter_1_0= RULE_STRING )
            {
            // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:449:1: (lv_parameter_1_0= RULE_STRING )
            // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:450:3: lv_parameter_1_0= RULE_STRING
            {
            lv_parameter_1_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleClassMatching906); 

            			newLeafNode(lv_parameter_1_0, grammarAccess.getClassMatchingAccess().getParameterSTRINGTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getClassMatchingRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"parameter",
                    		lv_parameter_1_0, 
                    		"STRING");
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleClassMatching"


    // $ANTLR start "entryRuleMetaModule"
    // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:474:1: entryRuleMetaModule returns [EObject current=null] : iv_ruleMetaModule= ruleMetaModule EOF ;
    public final EObject entryRuleMetaModule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMetaModule = null;


        try {
            // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:475:2: (iv_ruleMetaModule= ruleMetaModule EOF )
            // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:476:2: iv_ruleMetaModule= ruleMetaModule EOF
            {
             newCompositeNode(grammarAccess.getMetaModuleRule()); 
            pushFollow(FOLLOW_ruleMetaModule_in_entryRuleMetaModule947);
            iv_ruleMetaModule=ruleMetaModule();

            state._fsp--;

             current =iv_ruleMetaModule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMetaModule957); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMetaModule"


    // $ANTLR start "ruleMetaModule"
    // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:483:1: ruleMetaModule returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID_ASML ) ) otherlv_1= '{' ( (otherlv_2= 'attributes:' ( (lv_attributes_3_0= ruleAttribute ) ) (otherlv_4= ',' )? )* otherlv_5= ';' )? (otherlv_6= 'matching:' ( (lv_matching_7_0= RULE_STRING ) ) otherlv_8= ';' )? (otherlv_9= 'description:' ( (lv_description_10_0= RULE_STRING ) ) otherlv_11= ';' )? ( (lv_components_12_0= ruleAbstractComponent ) )* (otherlv_13= 'restrictions' otherlv_14= '{' ( (lv_restrictions_15_0= ruleRestriction ) )* otherlv_16= '}' )? otherlv_17= '}' ) ;
    public final EObject ruleMetaModule() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token lv_matching_7_0=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token lv_description_10_0=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        Token otherlv_14=null;
        Token otherlv_16=null;
        Token otherlv_17=null;
        EObject lv_attributes_3_0 = null;

        EObject lv_components_12_0 = null;

        EObject lv_restrictions_15_0 = null;


         enterRule(); 
            
        try {
            // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:486:28: ( ( ( (lv_name_0_0= RULE_ID_ASML ) ) otherlv_1= '{' ( (otherlv_2= 'attributes:' ( (lv_attributes_3_0= ruleAttribute ) ) (otherlv_4= ',' )? )* otherlv_5= ';' )? (otherlv_6= 'matching:' ( (lv_matching_7_0= RULE_STRING ) ) otherlv_8= ';' )? (otherlv_9= 'description:' ( (lv_description_10_0= RULE_STRING ) ) otherlv_11= ';' )? ( (lv_components_12_0= ruleAbstractComponent ) )* (otherlv_13= 'restrictions' otherlv_14= '{' ( (lv_restrictions_15_0= ruleRestriction ) )* otherlv_16= '}' )? otherlv_17= '}' ) )
            // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:487:1: ( ( (lv_name_0_0= RULE_ID_ASML ) ) otherlv_1= '{' ( (otherlv_2= 'attributes:' ( (lv_attributes_3_0= ruleAttribute ) ) (otherlv_4= ',' )? )* otherlv_5= ';' )? (otherlv_6= 'matching:' ( (lv_matching_7_0= RULE_STRING ) ) otherlv_8= ';' )? (otherlv_9= 'description:' ( (lv_description_10_0= RULE_STRING ) ) otherlv_11= ';' )? ( (lv_components_12_0= ruleAbstractComponent ) )* (otherlv_13= 'restrictions' otherlv_14= '{' ( (lv_restrictions_15_0= ruleRestriction ) )* otherlv_16= '}' )? otherlv_17= '}' )
            {
            // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:487:1: ( ( (lv_name_0_0= RULE_ID_ASML ) ) otherlv_1= '{' ( (otherlv_2= 'attributes:' ( (lv_attributes_3_0= ruleAttribute ) ) (otherlv_4= ',' )? )* otherlv_5= ';' )? (otherlv_6= 'matching:' ( (lv_matching_7_0= RULE_STRING ) ) otherlv_8= ';' )? (otherlv_9= 'description:' ( (lv_description_10_0= RULE_STRING ) ) otherlv_11= ';' )? ( (lv_components_12_0= ruleAbstractComponent ) )* (otherlv_13= 'restrictions' otherlv_14= '{' ( (lv_restrictions_15_0= ruleRestriction ) )* otherlv_16= '}' )? otherlv_17= '}' )
            // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:487:2: ( (lv_name_0_0= RULE_ID_ASML ) ) otherlv_1= '{' ( (otherlv_2= 'attributes:' ( (lv_attributes_3_0= ruleAttribute ) ) (otherlv_4= ',' )? )* otherlv_5= ';' )? (otherlv_6= 'matching:' ( (lv_matching_7_0= RULE_STRING ) ) otherlv_8= ';' )? (otherlv_9= 'description:' ( (lv_description_10_0= RULE_STRING ) ) otherlv_11= ';' )? ( (lv_components_12_0= ruleAbstractComponent ) )* (otherlv_13= 'restrictions' otherlv_14= '{' ( (lv_restrictions_15_0= ruleRestriction ) )* otherlv_16= '}' )? otherlv_17= '}'
            {
            // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:487:2: ( (lv_name_0_0= RULE_ID_ASML ) )
            // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:488:1: (lv_name_0_0= RULE_ID_ASML )
            {
            // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:488:1: (lv_name_0_0= RULE_ID_ASML )
            // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:489:3: lv_name_0_0= RULE_ID_ASML
            {
            lv_name_0_0=(Token)match(input,RULE_ID_ASML,FOLLOW_RULE_ID_ASML_in_ruleMetaModule999); 

            			newLeafNode(lv_name_0_0, grammarAccess.getMetaModuleAccess().getNameID_ASMLTerminalRuleCall_0_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getMetaModuleRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_0_0, 
                    		"ID_ASML");
            	    

            }


            }

            otherlv_1=(Token)match(input,13,FOLLOW_13_in_ruleMetaModule1016); 

                	newLeafNode(otherlv_1, grammarAccess.getMetaModuleAccess().getLeftCurlyBracketKeyword_1());
                
            // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:509:1: ( (otherlv_2= 'attributes:' ( (lv_attributes_3_0= ruleAttribute ) ) (otherlv_4= ',' )? )* otherlv_5= ';' )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==15||LA14_0==22) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:509:2: (otherlv_2= 'attributes:' ( (lv_attributes_3_0= ruleAttribute ) ) (otherlv_4= ',' )? )* otherlv_5= ';'
                    {
                    // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:509:2: (otherlv_2= 'attributes:' ( (lv_attributes_3_0= ruleAttribute ) ) (otherlv_4= ',' )? )*
                    loop13:
                    do {
                        int alt13=2;
                        int LA13_0 = input.LA(1);

                        if ( (LA13_0==22) ) {
                            alt13=1;
                        }


                        switch (alt13) {
                    	case 1 :
                    	    // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:509:4: otherlv_2= 'attributes:' ( (lv_attributes_3_0= ruleAttribute ) ) (otherlv_4= ',' )?
                    	    {
                    	    otherlv_2=(Token)match(input,22,FOLLOW_22_in_ruleMetaModule1030); 

                    	        	newLeafNode(otherlv_2, grammarAccess.getMetaModuleAccess().getAttributesKeyword_2_0_0());
                    	        
                    	    // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:513:1: ( (lv_attributes_3_0= ruleAttribute ) )
                    	    // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:514:1: (lv_attributes_3_0= ruleAttribute )
                    	    {
                    	    // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:514:1: (lv_attributes_3_0= ruleAttribute )
                    	    // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:515:3: lv_attributes_3_0= ruleAttribute
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getMetaModuleAccess().getAttributesAttributeParserRuleCall_2_0_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleAttribute_in_ruleMetaModule1051);
                    	    lv_attributes_3_0=ruleAttribute();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getMetaModuleRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"attributes",
                    	            		lv_attributes_3_0, 
                    	            		"Attribute");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }

                    	    // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:531:2: (otherlv_4= ',' )?
                    	    int alt12=2;
                    	    int LA12_0 = input.LA(1);

                    	    if ( (LA12_0==17) ) {
                    	        alt12=1;
                    	    }
                    	    switch (alt12) {
                    	        case 1 :
                    	            // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:531:4: otherlv_4= ','
                    	            {
                    	            otherlv_4=(Token)match(input,17,FOLLOW_17_in_ruleMetaModule1064); 

                    	                	newLeafNode(otherlv_4, grammarAccess.getMetaModuleAccess().getCommaKeyword_2_0_2());
                    	                

                    	            }
                    	            break;

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop13;
                        }
                    } while (true);

                    otherlv_5=(Token)match(input,15,FOLLOW_15_in_ruleMetaModule1080); 

                        	newLeafNode(otherlv_5, grammarAccess.getMetaModuleAccess().getSemicolonKeyword_2_1());
                        

                    }
                    break;

            }

            // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:539:3: (otherlv_6= 'matching:' ( (lv_matching_7_0= RULE_STRING ) ) otherlv_8= ';' )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==23) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:539:5: otherlv_6= 'matching:' ( (lv_matching_7_0= RULE_STRING ) ) otherlv_8= ';'
                    {
                    otherlv_6=(Token)match(input,23,FOLLOW_23_in_ruleMetaModule1095); 

                        	newLeafNode(otherlv_6, grammarAccess.getMetaModuleAccess().getMatchingKeyword_3_0());
                        
                    // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:543:1: ( (lv_matching_7_0= RULE_STRING ) )
                    // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:544:1: (lv_matching_7_0= RULE_STRING )
                    {
                    // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:544:1: (lv_matching_7_0= RULE_STRING )
                    // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:545:3: lv_matching_7_0= RULE_STRING
                    {
                    lv_matching_7_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleMetaModule1112); 

                    			newLeafNode(lv_matching_7_0, grammarAccess.getMetaModuleAccess().getMatchingSTRINGTerminalRuleCall_3_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getMetaModuleRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"matching",
                            		lv_matching_7_0, 
                            		"STRING");
                    	    

                    }


                    }

                    otherlv_8=(Token)match(input,15,FOLLOW_15_in_ruleMetaModule1129); 

                        	newLeafNode(otherlv_8, grammarAccess.getMetaModuleAccess().getSemicolonKeyword_3_2());
                        

                    }
                    break;

            }

            // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:565:3: (otherlv_9= 'description:' ( (lv_description_10_0= RULE_STRING ) ) otherlv_11= ';' )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==24) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:565:5: otherlv_9= 'description:' ( (lv_description_10_0= RULE_STRING ) ) otherlv_11= ';'
                    {
                    otherlv_9=(Token)match(input,24,FOLLOW_24_in_ruleMetaModule1144); 

                        	newLeafNode(otherlv_9, grammarAccess.getMetaModuleAccess().getDescriptionKeyword_4_0());
                        
                    // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:569:1: ( (lv_description_10_0= RULE_STRING ) )
                    // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:570:1: (lv_description_10_0= RULE_STRING )
                    {
                    // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:570:1: (lv_description_10_0= RULE_STRING )
                    // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:571:3: lv_description_10_0= RULE_STRING
                    {
                    lv_description_10_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleMetaModule1161); 

                    			newLeafNode(lv_description_10_0, grammarAccess.getMetaModuleAccess().getDescriptionSTRINGTerminalRuleCall_4_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getMetaModuleRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"description",
                            		lv_description_10_0, 
                            		"STRING");
                    	    

                    }


                    }

                    otherlv_11=(Token)match(input,15,FOLLOW_15_in_ruleMetaModule1178); 

                        	newLeafNode(otherlv_11, grammarAccess.getMetaModuleAccess().getSemicolonKeyword_4_2());
                        

                    }
                    break;

            }

            // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:591:3: ( (lv_components_12_0= ruleAbstractComponent ) )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==RULE_ID_ASML||LA17_0==19) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:592:1: (lv_components_12_0= ruleAbstractComponent )
            	    {
            	    // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:592:1: (lv_components_12_0= ruleAbstractComponent )
            	    // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:593:3: lv_components_12_0= ruleAbstractComponent
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getMetaModuleAccess().getComponentsAbstractComponentParserRuleCall_5_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleAbstractComponent_in_ruleMetaModule1201);
            	    lv_components_12_0=ruleAbstractComponent();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getMetaModuleRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"components",
            	            		lv_components_12_0, 
            	            		"AbstractComponent");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);

            // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:609:3: (otherlv_13= 'restrictions' otherlv_14= '{' ( (lv_restrictions_15_0= ruleRestriction ) )* otherlv_16= '}' )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==25) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:609:5: otherlv_13= 'restrictions' otherlv_14= '{' ( (lv_restrictions_15_0= ruleRestriction ) )* otherlv_16= '}'
                    {
                    otherlv_13=(Token)match(input,25,FOLLOW_25_in_ruleMetaModule1215); 

                        	newLeafNode(otherlv_13, grammarAccess.getMetaModuleAccess().getRestrictionsKeyword_6_0());
                        
                    otherlv_14=(Token)match(input,13,FOLLOW_13_in_ruleMetaModule1227); 

                        	newLeafNode(otherlv_14, grammarAccess.getMetaModuleAccess().getLeftCurlyBracketKeyword_6_1());
                        
                    // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:617:1: ( (lv_restrictions_15_0= ruleRestriction ) )*
                    loop18:
                    do {
                        int alt18=2;
                        int LA18_0 = input.LA(1);

                        if ( ((LA18_0>=35 && LA18_0<=50)) ) {
                            alt18=1;
                        }


                        switch (alt18) {
                    	case 1 :
                    	    // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:618:1: (lv_restrictions_15_0= ruleRestriction )
                    	    {
                    	    // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:618:1: (lv_restrictions_15_0= ruleRestriction )
                    	    // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:619:3: lv_restrictions_15_0= ruleRestriction
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getMetaModuleAccess().getRestrictionsRestrictionParserRuleCall_6_2_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleRestriction_in_ruleMetaModule1248);
                    	    lv_restrictions_15_0=ruleRestriction();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getMetaModuleRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"restrictions",
                    	            		lv_restrictions_15_0, 
                    	            		"Restriction");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop18;
                        }
                    } while (true);

                    otherlv_16=(Token)match(input,18,FOLLOW_18_in_ruleMetaModule1261); 

                        	newLeafNode(otherlv_16, grammarAccess.getMetaModuleAccess().getRightCurlyBracketKeyword_6_3());
                        

                    }
                    break;

            }

            otherlv_17=(Token)match(input,18,FOLLOW_18_in_ruleMetaModule1275); 

                	newLeafNode(otherlv_17, grammarAccess.getMetaModuleAccess().getRightCurlyBracketKeyword_7());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMetaModule"


    // $ANTLR start "entryRuleQualifiedName"
    // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:651:1: entryRuleQualifiedName returns [String current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final String entryRuleQualifiedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedName = null;


        try {
            // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:652:2: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:653:2: iv_ruleQualifiedName= ruleQualifiedName EOF
            {
             newCompositeNode(grammarAccess.getQualifiedNameRule()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName1312);
            iv_ruleQualifiedName=ruleQualifiedName();

            state._fsp--;

             current =iv_ruleQualifiedName.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedName1323); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleQualifiedName"


    // $ANTLR start "ruleQualifiedName"
    // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:660:1: ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_ASML_0= RULE_ID_ASML (kw= '.' this_ID_ASML_2= RULE_ID_ASML )* ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_ASML_0=null;
        Token kw=null;
        Token this_ID_ASML_2=null;

         enterRule(); 
            
        try {
            // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:663:28: ( (this_ID_ASML_0= RULE_ID_ASML (kw= '.' this_ID_ASML_2= RULE_ID_ASML )* ) )
            // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:664:1: (this_ID_ASML_0= RULE_ID_ASML (kw= '.' this_ID_ASML_2= RULE_ID_ASML )* )
            {
            // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:664:1: (this_ID_ASML_0= RULE_ID_ASML (kw= '.' this_ID_ASML_2= RULE_ID_ASML )* )
            // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:664:6: this_ID_ASML_0= RULE_ID_ASML (kw= '.' this_ID_ASML_2= RULE_ID_ASML )*
            {
            this_ID_ASML_0=(Token)match(input,RULE_ID_ASML,FOLLOW_RULE_ID_ASML_in_ruleQualifiedName1363); 

            		current.merge(this_ID_ASML_0);
                
             
                newLeafNode(this_ID_ASML_0, grammarAccess.getQualifiedNameAccess().getID_ASMLTerminalRuleCall_0()); 
                
            // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:671:1: (kw= '.' this_ID_ASML_2= RULE_ID_ASML )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==26) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:672:2: kw= '.' this_ID_ASML_2= RULE_ID_ASML
            	    {
            	    kw=(Token)match(input,26,FOLLOW_26_in_ruleQualifiedName1382); 

            	            current.merge(kw);
            	            newLeafNode(kw, grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 
            	        
            	    this_ID_ASML_2=(Token)match(input,RULE_ID_ASML,FOLLOW_RULE_ID_ASML_in_ruleQualifiedName1397); 

            	    		current.merge(this_ID_ASML_2);
            	        
            	     
            	        newLeafNode(this_ID_ASML_2, grammarAccess.getQualifiedNameAccess().getID_ASMLTerminalRuleCall_1_1()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop20;
                }
            } while (true);


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleQualifiedName"


    // $ANTLR start "entryRuleRestriction"
    // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:692:1: entryRuleRestriction returns [EObject current=null] : iv_ruleRestriction= ruleRestriction EOF ;
    public final EObject entryRuleRestriction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRestriction = null;


        try {
            // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:693:2: (iv_ruleRestriction= ruleRestriction EOF )
            // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:694:2: iv_ruleRestriction= ruleRestriction EOF
            {
             newCompositeNode(grammarAccess.getRestrictionRule()); 
            pushFollow(FOLLOW_ruleRestriction_in_entryRuleRestriction1444);
            iv_ruleRestriction=ruleRestriction();

            state._fsp--;

             current =iv_ruleRestriction; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRestriction1454); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRestriction"


    // $ANTLR start "ruleRestriction"
    // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:701:1: ruleRestriction returns [EObject current=null] : ( ( (lv_groupClause_0_0= ruleGroupClause ) )? ( (lv_permissionClause_1_0= rulePermissionClause ) )? ( (lv_relactionType_2_0= ruleRelactionType ) ) ( (lv_groupClauseB_3_0= ruleGroupClause ) )? ( ( (lv_componentB_4_0= ruleComponentsBinRestrictionDeclareation ) ) (otherlv_5= ',' )? )* (otherlv_6= 'message' ( (lv_message_7_0= RULE_STRING ) ) )? otherlv_8= ';' ) ;
    public final EObject ruleRestriction() throws RecognitionException {
        EObject current = null;

        Token otherlv_5=null;
        Token otherlv_6=null;
        Token lv_message_7_0=null;
        Token otherlv_8=null;
        Enumerator lv_groupClause_0_0 = null;

        Enumerator lv_permissionClause_1_0 = null;

        Enumerator lv_relactionType_2_0 = null;

        Enumerator lv_groupClauseB_3_0 = null;

        EObject lv_componentB_4_0 = null;


         enterRule(); 
            
        try {
            // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:704:28: ( ( ( (lv_groupClause_0_0= ruleGroupClause ) )? ( (lv_permissionClause_1_0= rulePermissionClause ) )? ( (lv_relactionType_2_0= ruleRelactionType ) ) ( (lv_groupClauseB_3_0= ruleGroupClause ) )? ( ( (lv_componentB_4_0= ruleComponentsBinRestrictionDeclareation ) ) (otherlv_5= ',' )? )* (otherlv_6= 'message' ( (lv_message_7_0= RULE_STRING ) ) )? otherlv_8= ';' ) )
            // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:705:1: ( ( (lv_groupClause_0_0= ruleGroupClause ) )? ( (lv_permissionClause_1_0= rulePermissionClause ) )? ( (lv_relactionType_2_0= ruleRelactionType ) ) ( (lv_groupClauseB_3_0= ruleGroupClause ) )? ( ( (lv_componentB_4_0= ruleComponentsBinRestrictionDeclareation ) ) (otherlv_5= ',' )? )* (otherlv_6= 'message' ( (lv_message_7_0= RULE_STRING ) ) )? otherlv_8= ';' )
            {
            // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:705:1: ( ( (lv_groupClause_0_0= ruleGroupClause ) )? ( (lv_permissionClause_1_0= rulePermissionClause ) )? ( (lv_relactionType_2_0= ruleRelactionType ) ) ( (lv_groupClauseB_3_0= ruleGroupClause ) )? ( ( (lv_componentB_4_0= ruleComponentsBinRestrictionDeclareation ) ) (otherlv_5= ',' )? )* (otherlv_6= 'message' ( (lv_message_7_0= RULE_STRING ) ) )? otherlv_8= ';' )
            // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:705:2: ( (lv_groupClause_0_0= ruleGroupClause ) )? ( (lv_permissionClause_1_0= rulePermissionClause ) )? ( (lv_relactionType_2_0= ruleRelactionType ) ) ( (lv_groupClauseB_3_0= ruleGroupClause ) )? ( ( (lv_componentB_4_0= ruleComponentsBinRestrictionDeclareation ) ) (otherlv_5= ',' )? )* (otherlv_6= 'message' ( (lv_message_7_0= RULE_STRING ) ) )? otherlv_8= ';'
            {
            // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:705:2: ( (lv_groupClause_0_0= ruleGroupClause ) )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( ((LA21_0>=35 && LA21_0<=37)) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:706:1: (lv_groupClause_0_0= ruleGroupClause )
                    {
                    // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:706:1: (lv_groupClause_0_0= ruleGroupClause )
                    // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:707:3: lv_groupClause_0_0= ruleGroupClause
                    {
                     
                    	        newCompositeNode(grammarAccess.getRestrictionAccess().getGroupClauseGroupClauseEnumRuleCall_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleGroupClause_in_ruleRestriction1500);
                    lv_groupClause_0_0=ruleGroupClause();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getRestrictionRule());
                    	        }
                           		set(
                           			current, 
                           			"groupClause",
                            		lv_groupClause_0_0, 
                            		"GroupClause");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:723:3: ( (lv_permissionClause_1_0= rulePermissionClause ) )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( ((LA22_0>=38 && LA22_0<=40)) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:724:1: (lv_permissionClause_1_0= rulePermissionClause )
                    {
                    // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:724:1: (lv_permissionClause_1_0= rulePermissionClause )
                    // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:725:3: lv_permissionClause_1_0= rulePermissionClause
                    {
                     
                    	        newCompositeNode(grammarAccess.getRestrictionAccess().getPermissionClausePermissionClauseEnumRuleCall_1_0()); 
                    	    
                    pushFollow(FOLLOW_rulePermissionClause_in_ruleRestriction1522);
                    lv_permissionClause_1_0=rulePermissionClause();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getRestrictionRule());
                    	        }
                           		set(
                           			current, 
                           			"permissionClause",
                            		lv_permissionClause_1_0, 
                            		"PermissionClause");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:741:3: ( (lv_relactionType_2_0= ruleRelactionType ) )
            // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:742:1: (lv_relactionType_2_0= ruleRelactionType )
            {
            // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:742:1: (lv_relactionType_2_0= ruleRelactionType )
            // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:743:3: lv_relactionType_2_0= ruleRelactionType
            {
             
            	        newCompositeNode(grammarAccess.getRestrictionAccess().getRelactionTypeRelactionTypeEnumRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleRelactionType_in_ruleRestriction1544);
            lv_relactionType_2_0=ruleRelactionType();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getRestrictionRule());
            	        }
                   		set(
                   			current, 
                   			"relactionType",
                    		lv_relactionType_2_0, 
                    		"RelactionType");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:759:2: ( (lv_groupClauseB_3_0= ruleGroupClause ) )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( ((LA23_0>=35 && LA23_0<=37)) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:760:1: (lv_groupClauseB_3_0= ruleGroupClause )
                    {
                    // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:760:1: (lv_groupClauseB_3_0= ruleGroupClause )
                    // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:761:3: lv_groupClauseB_3_0= ruleGroupClause
                    {
                     
                    	        newCompositeNode(grammarAccess.getRestrictionAccess().getGroupClauseBGroupClauseEnumRuleCall_3_0()); 
                    	    
                    pushFollow(FOLLOW_ruleGroupClause_in_ruleRestriction1565);
                    lv_groupClauseB_3_0=ruleGroupClause();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getRestrictionRule());
                    	        }
                           		set(
                           			current, 
                           			"groupClauseB",
                            		lv_groupClauseB_3_0, 
                            		"GroupClause");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:777:3: ( ( (lv_componentB_4_0= ruleComponentsBinRestrictionDeclareation ) ) (otherlv_5= ',' )? )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==RULE_ID_ASML) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:777:4: ( (lv_componentB_4_0= ruleComponentsBinRestrictionDeclareation ) ) (otherlv_5= ',' )?
            	    {
            	    // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:777:4: ( (lv_componentB_4_0= ruleComponentsBinRestrictionDeclareation ) )
            	    // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:778:1: (lv_componentB_4_0= ruleComponentsBinRestrictionDeclareation )
            	    {
            	    // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:778:1: (lv_componentB_4_0= ruleComponentsBinRestrictionDeclareation )
            	    // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:779:3: lv_componentB_4_0= ruleComponentsBinRestrictionDeclareation
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getRestrictionAccess().getComponentBComponentsBinRestrictionDeclareationParserRuleCall_4_0_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleComponentsBinRestrictionDeclareation_in_ruleRestriction1588);
            	    lv_componentB_4_0=ruleComponentsBinRestrictionDeclareation();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getRestrictionRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"componentB",
            	            		lv_componentB_4_0, 
            	            		"ComponentsBinRestrictionDeclareation");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }

            	    // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:795:2: (otherlv_5= ',' )?
            	    int alt24=2;
            	    int LA24_0 = input.LA(1);

            	    if ( (LA24_0==17) ) {
            	        alt24=1;
            	    }
            	    switch (alt24) {
            	        case 1 :
            	            // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:795:4: otherlv_5= ','
            	            {
            	            otherlv_5=(Token)match(input,17,FOLLOW_17_in_ruleRestriction1601); 

            	                	newLeafNode(otherlv_5, grammarAccess.getRestrictionAccess().getCommaKeyword_4_1());
            	                

            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    break loop25;
                }
            } while (true);

            // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:799:5: (otherlv_6= 'message' ( (lv_message_7_0= RULE_STRING ) ) )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==27) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:799:7: otherlv_6= 'message' ( (lv_message_7_0= RULE_STRING ) )
                    {
                    otherlv_6=(Token)match(input,27,FOLLOW_27_in_ruleRestriction1618); 

                        	newLeafNode(otherlv_6, grammarAccess.getRestrictionAccess().getMessageKeyword_5_0());
                        
                    // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:803:1: ( (lv_message_7_0= RULE_STRING ) )
                    // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:804:1: (lv_message_7_0= RULE_STRING )
                    {
                    // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:804:1: (lv_message_7_0= RULE_STRING )
                    // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:805:3: lv_message_7_0= RULE_STRING
                    {
                    lv_message_7_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleRestriction1635); 

                    			newLeafNode(lv_message_7_0, grammarAccess.getRestrictionAccess().getMessageSTRINGTerminalRuleCall_5_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getRestrictionRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"message",
                            		lv_message_7_0, 
                            		"STRING");
                    	    

                    }


                    }


                    }
                    break;

            }

            otherlv_8=(Token)match(input,15,FOLLOW_15_in_ruleRestriction1654); 

                	newLeafNode(otherlv_8, grammarAccess.getRestrictionAccess().getSemicolonKeyword_6());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRestriction"


    // $ANTLR start "entryRuleComponentsBinRestrictionDeclareation"
    // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:833:1: entryRuleComponentsBinRestrictionDeclareation returns [EObject current=null] : iv_ruleComponentsBinRestrictionDeclareation= ruleComponentsBinRestrictionDeclareation EOF ;
    public final EObject entryRuleComponentsBinRestrictionDeclareation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComponentsBinRestrictionDeclareation = null;


        try {
            // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:834:2: (iv_ruleComponentsBinRestrictionDeclareation= ruleComponentsBinRestrictionDeclareation EOF )
            // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:835:2: iv_ruleComponentsBinRestrictionDeclareation= ruleComponentsBinRestrictionDeclareation EOF
            {
             newCompositeNode(grammarAccess.getComponentsBinRestrictionDeclareationRule()); 
            pushFollow(FOLLOW_ruleComponentsBinRestrictionDeclareation_in_entryRuleComponentsBinRestrictionDeclareation1690);
            iv_ruleComponentsBinRestrictionDeclareation=ruleComponentsBinRestrictionDeclareation();

            state._fsp--;

             current =iv_ruleComponentsBinRestrictionDeclareation; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleComponentsBinRestrictionDeclareation1700); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleComponentsBinRestrictionDeclareation"


    // $ANTLR start "ruleComponentsBinRestrictionDeclareation"
    // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:842:1: ruleComponentsBinRestrictionDeclareation returns [EObject current=null] : ( ( ( ruleQualifiedName ) ) ( (lv_wildcard_1_0= ruleWildCard ) )? ) ;
    public final EObject ruleComponentsBinRestrictionDeclareation() throws RecognitionException {
        EObject current = null;

        Enumerator lv_wildcard_1_0 = null;


         enterRule(); 
            
        try {
            // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:845:28: ( ( ( ( ruleQualifiedName ) ) ( (lv_wildcard_1_0= ruleWildCard ) )? ) )
            // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:846:1: ( ( ( ruleQualifiedName ) ) ( (lv_wildcard_1_0= ruleWildCard ) )? )
            {
            // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:846:1: ( ( ( ruleQualifiedName ) ) ( (lv_wildcard_1_0= ruleWildCard ) )? )
            // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:846:2: ( ( ruleQualifiedName ) ) ( (lv_wildcard_1_0= ruleWildCard ) )?
            {
            // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:846:2: ( ( ruleQualifiedName ) )
            // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:847:1: ( ruleQualifiedName )
            {
            // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:847:1: ( ruleQualifiedName )
            // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:848:3: ruleQualifiedName
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getComponentsBinRestrictionDeclareationRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getComponentsBinRestrictionDeclareationAccess().getComponentBAbstractComponentCrossReference_0_0()); 
            	    
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleComponentsBinRestrictionDeclareation1748);
            ruleQualifiedName();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:861:2: ( (lv_wildcard_1_0= ruleWildCard ) )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( ((LA27_0>=51 && LA27_0<=52)) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:862:1: (lv_wildcard_1_0= ruleWildCard )
                    {
                    // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:862:1: (lv_wildcard_1_0= ruleWildCard )
                    // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:863:3: lv_wildcard_1_0= ruleWildCard
                    {
                     
                    	        newCompositeNode(grammarAccess.getComponentsBinRestrictionDeclareationAccess().getWildcardWildCardEnumRuleCall_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleWildCard_in_ruleComponentsBinRestrictionDeclareation1769);
                    lv_wildcard_1_0=ruleWildCard();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getComponentsBinRestrictionDeclareationRule());
                    	        }
                           		set(
                           			current, 
                           			"wildcard",
                            		lv_wildcard_1_0, 
                            		"WildCard");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleComponentsBinRestrictionDeclareation"


    // $ANTLR start "ruleExpressionMatchingClause"
    // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:889:1: ruleExpressionMatchingClause returns [Enumerator current=null] : ( (enumLiteral_0= 'name start with' ) | (enumLiteral_1= 'name ends with' ) | (enumLiteral_2= 'annotated with' ) ) ;
    public final Enumerator ruleExpressionMatchingClause() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;

         enterRule(); 
        try {
            // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:891:28: ( ( (enumLiteral_0= 'name start with' ) | (enumLiteral_1= 'name ends with' ) | (enumLiteral_2= 'annotated with' ) ) )
            // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:892:1: ( (enumLiteral_0= 'name start with' ) | (enumLiteral_1= 'name ends with' ) | (enumLiteral_2= 'annotated with' ) )
            {
            // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:892:1: ( (enumLiteral_0= 'name start with' ) | (enumLiteral_1= 'name ends with' ) | (enumLiteral_2= 'annotated with' ) )
            int alt28=3;
            switch ( input.LA(1) ) {
            case 28:
                {
                alt28=1;
                }
                break;
            case 29:
                {
                alt28=2;
                }
                break;
            case 30:
                {
                alt28=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 28, 0, input);

                throw nvae;
            }

            switch (alt28) {
                case 1 :
                    // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:892:2: (enumLiteral_0= 'name start with' )
                    {
                    // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:892:2: (enumLiteral_0= 'name start with' )
                    // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:892:4: enumLiteral_0= 'name start with'
                    {
                    enumLiteral_0=(Token)match(input,28,FOLLOW_28_in_ruleExpressionMatchingClause1822); 

                            current = grammarAccess.getExpressionMatchingClauseAccess().getNAME_START_WITHEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getExpressionMatchingClauseAccess().getNAME_START_WITHEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:898:6: (enumLiteral_1= 'name ends with' )
                    {
                    // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:898:6: (enumLiteral_1= 'name ends with' )
                    // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:898:8: enumLiteral_1= 'name ends with'
                    {
                    enumLiteral_1=(Token)match(input,29,FOLLOW_29_in_ruleExpressionMatchingClause1839); 

                            current = grammarAccess.getExpressionMatchingClauseAccess().getNAME_ENDS_WITHEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_1, grammarAccess.getExpressionMatchingClauseAccess().getNAME_ENDS_WITHEnumLiteralDeclaration_1()); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:904:6: (enumLiteral_2= 'annotated with' )
                    {
                    // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:904:6: (enumLiteral_2= 'annotated with' )
                    // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:904:8: enumLiteral_2= 'annotated with'
                    {
                    enumLiteral_2=(Token)match(input,30,FOLLOW_30_in_ruleExpressionMatchingClause1856); 

                            current = grammarAccess.getExpressionMatchingClauseAccess().getANNOTATED_WITHEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_2, grammarAccess.getExpressionMatchingClauseAccess().getANNOTATED_WITHEnumLiteralDeclaration_2()); 
                        

                    }


                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleExpressionMatchingClause"


    // $ANTLR start "ruleModuleMatchingParamenter"
    // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:914:1: ruleModuleMatchingParamenter returns [Enumerator current=null] : ( (enumLiteral_0= 'by package name' ) | (enumLiteral_1= 'by folder name' ) | (enumLiteral_2= 'by package and folder name' ) | (enumLiteral_3= 'by external implementation' ) ) ;
    public final Enumerator ruleModuleMatchingParamenter() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;

         enterRule(); 
        try {
            // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:916:28: ( ( (enumLiteral_0= 'by package name' ) | (enumLiteral_1= 'by folder name' ) | (enumLiteral_2= 'by package and folder name' ) | (enumLiteral_3= 'by external implementation' ) ) )
            // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:917:1: ( (enumLiteral_0= 'by package name' ) | (enumLiteral_1= 'by folder name' ) | (enumLiteral_2= 'by package and folder name' ) | (enumLiteral_3= 'by external implementation' ) )
            {
            // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:917:1: ( (enumLiteral_0= 'by package name' ) | (enumLiteral_1= 'by folder name' ) | (enumLiteral_2= 'by package and folder name' ) | (enumLiteral_3= 'by external implementation' ) )
            int alt29=4;
            switch ( input.LA(1) ) {
            case 31:
                {
                alt29=1;
                }
                break;
            case 32:
                {
                alt29=2;
                }
                break;
            case 33:
                {
                alt29=3;
                }
                break;
            case 34:
                {
                alt29=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 29, 0, input);

                throw nvae;
            }

            switch (alt29) {
                case 1 :
                    // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:917:2: (enumLiteral_0= 'by package name' )
                    {
                    // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:917:2: (enumLiteral_0= 'by package name' )
                    // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:917:4: enumLiteral_0= 'by package name'
                    {
                    enumLiteral_0=(Token)match(input,31,FOLLOW_31_in_ruleModuleMatchingParamenter1901); 

                            current = grammarAccess.getModuleMatchingParamenterAccess().getPAKCAGEEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getModuleMatchingParamenterAccess().getPAKCAGEEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:923:6: (enumLiteral_1= 'by folder name' )
                    {
                    // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:923:6: (enumLiteral_1= 'by folder name' )
                    // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:923:8: enumLiteral_1= 'by folder name'
                    {
                    enumLiteral_1=(Token)match(input,32,FOLLOW_32_in_ruleModuleMatchingParamenter1918); 

                            current = grammarAccess.getModuleMatchingParamenterAccess().getFOLDEREnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_1, grammarAccess.getModuleMatchingParamenterAccess().getFOLDEREnumLiteralDeclaration_1()); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:929:6: (enumLiteral_2= 'by package and folder name' )
                    {
                    // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:929:6: (enumLiteral_2= 'by package and folder name' )
                    // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:929:8: enumLiteral_2= 'by package and folder name'
                    {
                    enumLiteral_2=(Token)match(input,33,FOLLOW_33_in_ruleModuleMatchingParamenter1935); 

                            current = grammarAccess.getModuleMatchingParamenterAccess().getPAKCAGE_AND_FOLDEREnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_2, grammarAccess.getModuleMatchingParamenterAccess().getPAKCAGE_AND_FOLDEREnumLiteralDeclaration_2()); 
                        

                    }


                    }
                    break;
                case 4 :
                    // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:935:6: (enumLiteral_3= 'by external implementation' )
                    {
                    // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:935:6: (enumLiteral_3= 'by external implementation' )
                    // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:935:8: enumLiteral_3= 'by external implementation'
                    {
                    enumLiteral_3=(Token)match(input,34,FOLLOW_34_in_ruleModuleMatchingParamenter1952); 

                            current = grammarAccess.getModuleMatchingParamenterAccess().getEXTERNAL_DEFINITIONEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_3, grammarAccess.getModuleMatchingParamenterAccess().getEXTERNAL_DEFINITIONEnumLiteralDeclaration_3()); 
                        

                    }


                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleModuleMatchingParamenter"


    // $ANTLR start "ruleGroupClause"
    // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:945:1: ruleGroupClause returns [Enumerator current=null] : ( (enumLiteral_0= '$null' ) | (enumLiteral_1= 'only' ) | (enumLiteral_2= 'only-this' ) ) ;
    public final Enumerator ruleGroupClause() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;

         enterRule(); 
        try {
            // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:947:28: ( ( (enumLiteral_0= '$null' ) | (enumLiteral_1= 'only' ) | (enumLiteral_2= 'only-this' ) ) )
            // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:948:1: ( (enumLiteral_0= '$null' ) | (enumLiteral_1= 'only' ) | (enumLiteral_2= 'only-this' ) )
            {
            // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:948:1: ( (enumLiteral_0= '$null' ) | (enumLiteral_1= 'only' ) | (enumLiteral_2= 'only-this' ) )
            int alt30=3;
            switch ( input.LA(1) ) {
            case 35:
                {
                alt30=1;
                }
                break;
            case 36:
                {
                alt30=2;
                }
                break;
            case 37:
                {
                alt30=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 30, 0, input);

                throw nvae;
            }

            switch (alt30) {
                case 1 :
                    // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:948:2: (enumLiteral_0= '$null' )
                    {
                    // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:948:2: (enumLiteral_0= '$null' )
                    // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:948:4: enumLiteral_0= '$null'
                    {
                    enumLiteral_0=(Token)match(input,35,FOLLOW_35_in_ruleGroupClause1997); 

                            current = grammarAccess.getGroupClauseAccess().getNULLEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getGroupClauseAccess().getNULLEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:954:6: (enumLiteral_1= 'only' )
                    {
                    // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:954:6: (enumLiteral_1= 'only' )
                    // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:954:8: enumLiteral_1= 'only'
                    {
                    enumLiteral_1=(Token)match(input,36,FOLLOW_36_in_ruleGroupClause2014); 

                            current = grammarAccess.getGroupClauseAccess().getONLYEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_1, grammarAccess.getGroupClauseAccess().getONLYEnumLiteralDeclaration_1()); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:960:6: (enumLiteral_2= 'only-this' )
                    {
                    // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:960:6: (enumLiteral_2= 'only-this' )
                    // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:960:8: enumLiteral_2= 'only-this'
                    {
                    enumLiteral_2=(Token)match(input,37,FOLLOW_37_in_ruleGroupClause2031); 

                            current = grammarAccess.getGroupClauseAccess().getONLY_THISEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_2, grammarAccess.getGroupClauseAccess().getONLY_THISEnumLiteralDeclaration_2()); 
                        

                    }


                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleGroupClause"


    // $ANTLR start "rulePermissionClause"
    // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:970:1: rulePermissionClause returns [Enumerator current=null] : ( (enumLiteral_0= 'must' ) | (enumLiteral_1= 'can' ) | (enumLiteral_2= 'cannot' ) ) ;
    public final Enumerator rulePermissionClause() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;

         enterRule(); 
        try {
            // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:972:28: ( ( (enumLiteral_0= 'must' ) | (enumLiteral_1= 'can' ) | (enumLiteral_2= 'cannot' ) ) )
            // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:973:1: ( (enumLiteral_0= 'must' ) | (enumLiteral_1= 'can' ) | (enumLiteral_2= 'cannot' ) )
            {
            // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:973:1: ( (enumLiteral_0= 'must' ) | (enumLiteral_1= 'can' ) | (enumLiteral_2= 'cannot' ) )
            int alt31=3;
            switch ( input.LA(1) ) {
            case 38:
                {
                alt31=1;
                }
                break;
            case 39:
                {
                alt31=2;
                }
                break;
            case 40:
                {
                alt31=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 31, 0, input);

                throw nvae;
            }

            switch (alt31) {
                case 1 :
                    // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:973:2: (enumLiteral_0= 'must' )
                    {
                    // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:973:2: (enumLiteral_0= 'must' )
                    // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:973:4: enumLiteral_0= 'must'
                    {
                    enumLiteral_0=(Token)match(input,38,FOLLOW_38_in_rulePermissionClause2076); 

                            current = grammarAccess.getPermissionClauseAccess().getMUSTEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getPermissionClauseAccess().getMUSTEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:979:6: (enumLiteral_1= 'can' )
                    {
                    // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:979:6: (enumLiteral_1= 'can' )
                    // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:979:8: enumLiteral_1= 'can'
                    {
                    enumLiteral_1=(Token)match(input,39,FOLLOW_39_in_rulePermissionClause2093); 

                            current = grammarAccess.getPermissionClauseAccess().getCANEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_1, grammarAccess.getPermissionClauseAccess().getCANEnumLiteralDeclaration_1()); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:985:6: (enumLiteral_2= 'cannot' )
                    {
                    // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:985:6: (enumLiteral_2= 'cannot' )
                    // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:985:8: enumLiteral_2= 'cannot'
                    {
                    enumLiteral_2=(Token)match(input,40,FOLLOW_40_in_rulePermissionClause2110); 

                            current = grammarAccess.getPermissionClauseAccess().getCANNOTEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_2, grammarAccess.getPermissionClauseAccess().getCANNOTEnumLiteralDeclaration_2()); 
                        

                    }


                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePermissionClause"


    // $ANTLR start "ruleRelactionType"
    // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:995:1: ruleRelactionType returns [Enumerator current=null] : ( (enumLiteral_0= 'access' ) | (enumLiteral_1= 'declare' ) | (enumLiteral_2= 'handle' ) | (enumLiteral_3= 'extend' ) | (enumLiteral_4= 'implement' ) | (enumLiteral_5= 'create' ) | (enumLiteral_6= 'throw' ) | (enumLiteral_7= 'use-annotation' ) | (enumLiteral_8= 'depend' ) | (enumLiteral_9= 'requires' ) ) ;
    public final Enumerator ruleRelactionType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;
        Token enumLiteral_5=null;
        Token enumLiteral_6=null;
        Token enumLiteral_7=null;
        Token enumLiteral_8=null;
        Token enumLiteral_9=null;

         enterRule(); 
        try {
            // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:997:28: ( ( (enumLiteral_0= 'access' ) | (enumLiteral_1= 'declare' ) | (enumLiteral_2= 'handle' ) | (enumLiteral_3= 'extend' ) | (enumLiteral_4= 'implement' ) | (enumLiteral_5= 'create' ) | (enumLiteral_6= 'throw' ) | (enumLiteral_7= 'use-annotation' ) | (enumLiteral_8= 'depend' ) | (enumLiteral_9= 'requires' ) ) )
            // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:998:1: ( (enumLiteral_0= 'access' ) | (enumLiteral_1= 'declare' ) | (enumLiteral_2= 'handle' ) | (enumLiteral_3= 'extend' ) | (enumLiteral_4= 'implement' ) | (enumLiteral_5= 'create' ) | (enumLiteral_6= 'throw' ) | (enumLiteral_7= 'use-annotation' ) | (enumLiteral_8= 'depend' ) | (enumLiteral_9= 'requires' ) )
            {
            // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:998:1: ( (enumLiteral_0= 'access' ) | (enumLiteral_1= 'declare' ) | (enumLiteral_2= 'handle' ) | (enumLiteral_3= 'extend' ) | (enumLiteral_4= 'implement' ) | (enumLiteral_5= 'create' ) | (enumLiteral_6= 'throw' ) | (enumLiteral_7= 'use-annotation' ) | (enumLiteral_8= 'depend' ) | (enumLiteral_9= 'requires' ) )
            int alt32=10;
            switch ( input.LA(1) ) {
            case 41:
                {
                alt32=1;
                }
                break;
            case 42:
                {
                alt32=2;
                }
                break;
            case 43:
                {
                alt32=3;
                }
                break;
            case 44:
                {
                alt32=4;
                }
                break;
            case 45:
                {
                alt32=5;
                }
                break;
            case 46:
                {
                alt32=6;
                }
                break;
            case 47:
                {
                alt32=7;
                }
                break;
            case 48:
                {
                alt32=8;
                }
                break;
            case 49:
                {
                alt32=9;
                }
                break;
            case 50:
                {
                alt32=10;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 32, 0, input);

                throw nvae;
            }

            switch (alt32) {
                case 1 :
                    // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:998:2: (enumLiteral_0= 'access' )
                    {
                    // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:998:2: (enumLiteral_0= 'access' )
                    // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:998:4: enumLiteral_0= 'access'
                    {
                    enumLiteral_0=(Token)match(input,41,FOLLOW_41_in_ruleRelactionType2155); 

                            current = grammarAccess.getRelactionTypeAccess().getACCESSEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getRelactionTypeAccess().getACCESSEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:1004:6: (enumLiteral_1= 'declare' )
                    {
                    // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:1004:6: (enumLiteral_1= 'declare' )
                    // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:1004:8: enumLiteral_1= 'declare'
                    {
                    enumLiteral_1=(Token)match(input,42,FOLLOW_42_in_ruleRelactionType2172); 

                            current = grammarAccess.getRelactionTypeAccess().getDECLAREEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_1, grammarAccess.getRelactionTypeAccess().getDECLAREEnumLiteralDeclaration_1()); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:1010:6: (enumLiteral_2= 'handle' )
                    {
                    // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:1010:6: (enumLiteral_2= 'handle' )
                    // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:1010:8: enumLiteral_2= 'handle'
                    {
                    enumLiteral_2=(Token)match(input,43,FOLLOW_43_in_ruleRelactionType2189); 

                            current = grammarAccess.getRelactionTypeAccess().getHANDLEEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_2, grammarAccess.getRelactionTypeAccess().getHANDLEEnumLiteralDeclaration_2()); 
                        

                    }


                    }
                    break;
                case 4 :
                    // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:1016:6: (enumLiteral_3= 'extend' )
                    {
                    // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:1016:6: (enumLiteral_3= 'extend' )
                    // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:1016:8: enumLiteral_3= 'extend'
                    {
                    enumLiteral_3=(Token)match(input,44,FOLLOW_44_in_ruleRelactionType2206); 

                            current = grammarAccess.getRelactionTypeAccess().getEXTENDEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_3, grammarAccess.getRelactionTypeAccess().getEXTENDEnumLiteralDeclaration_3()); 
                        

                    }


                    }
                    break;
                case 5 :
                    // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:1022:6: (enumLiteral_4= 'implement' )
                    {
                    // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:1022:6: (enumLiteral_4= 'implement' )
                    // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:1022:8: enumLiteral_4= 'implement'
                    {
                    enumLiteral_4=(Token)match(input,45,FOLLOW_45_in_ruleRelactionType2223); 

                            current = grammarAccess.getRelactionTypeAccess().getIMPLEMENTEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_4, grammarAccess.getRelactionTypeAccess().getIMPLEMENTEnumLiteralDeclaration_4()); 
                        

                    }


                    }
                    break;
                case 6 :
                    // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:1028:6: (enumLiteral_5= 'create' )
                    {
                    // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:1028:6: (enumLiteral_5= 'create' )
                    // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:1028:8: enumLiteral_5= 'create'
                    {
                    enumLiteral_5=(Token)match(input,46,FOLLOW_46_in_ruleRelactionType2240); 

                            current = grammarAccess.getRelactionTypeAccess().getCREATEEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_5, grammarAccess.getRelactionTypeAccess().getCREATEEnumLiteralDeclaration_5()); 
                        

                    }


                    }
                    break;
                case 7 :
                    // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:1034:6: (enumLiteral_6= 'throw' )
                    {
                    // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:1034:6: (enumLiteral_6= 'throw' )
                    // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:1034:8: enumLiteral_6= 'throw'
                    {
                    enumLiteral_6=(Token)match(input,47,FOLLOW_47_in_ruleRelactionType2257); 

                            current = grammarAccess.getRelactionTypeAccess().getTHROWEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_6, grammarAccess.getRelactionTypeAccess().getTHROWEnumLiteralDeclaration_6()); 
                        

                    }


                    }
                    break;
                case 8 :
                    // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:1040:6: (enumLiteral_7= 'use-annotation' )
                    {
                    // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:1040:6: (enumLiteral_7= 'use-annotation' )
                    // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:1040:8: enumLiteral_7= 'use-annotation'
                    {
                    enumLiteral_7=(Token)match(input,48,FOLLOW_48_in_ruleRelactionType2274); 

                            current = grammarAccess.getRelactionTypeAccess().getUSEANOTATIONEnumLiteralDeclaration_7().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_7, grammarAccess.getRelactionTypeAccess().getUSEANOTATIONEnumLiteralDeclaration_7()); 
                        

                    }


                    }
                    break;
                case 9 :
                    // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:1046:6: (enumLiteral_8= 'depend' )
                    {
                    // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:1046:6: (enumLiteral_8= 'depend' )
                    // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:1046:8: enumLiteral_8= 'depend'
                    {
                    enumLiteral_8=(Token)match(input,49,FOLLOW_49_in_ruleRelactionType2291); 

                            current = grammarAccess.getRelactionTypeAccess().getDEPENDEnumLiteralDeclaration_8().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_8, grammarAccess.getRelactionTypeAccess().getDEPENDEnumLiteralDeclaration_8()); 
                        

                    }


                    }
                    break;
                case 10 :
                    // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:1052:6: (enumLiteral_9= 'requires' )
                    {
                    // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:1052:6: (enumLiteral_9= 'requires' )
                    // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:1052:8: enumLiteral_9= 'requires'
                    {
                    enumLiteral_9=(Token)match(input,50,FOLLOW_50_in_ruleRelactionType2308); 

                            current = grammarAccess.getRelactionTypeAccess().getREQUIRESEnumLiteralDeclaration_9().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_9, grammarAccess.getRelactionTypeAccess().getREQUIRESEnumLiteralDeclaration_9()); 
                        

                    }


                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRelactionType"


    // $ANTLR start "ruleWildCard"
    // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:1062:1: ruleWildCard returns [Enumerator current=null] : ( (enumLiteral_0= '.*' ) | (enumLiteral_1= '.**' ) ) ;
    public final Enumerator ruleWildCard() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;

         enterRule(); 
        try {
            // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:1064:28: ( ( (enumLiteral_0= '.*' ) | (enumLiteral_1= '.**' ) ) )
            // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:1065:1: ( (enumLiteral_0= '.*' ) | (enumLiteral_1= '.**' ) )
            {
            // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:1065:1: ( (enumLiteral_0= '.*' ) | (enumLiteral_1= '.**' ) )
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==51) ) {
                alt33=1;
            }
            else if ( (LA33_0==52) ) {
                alt33=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 33, 0, input);

                throw nvae;
            }
            switch (alt33) {
                case 1 :
                    // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:1065:2: (enumLiteral_0= '.*' )
                    {
                    // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:1065:2: (enumLiteral_0= '.*' )
                    // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:1065:4: enumLiteral_0= '.*'
                    {
                    enumLiteral_0=(Token)match(input,51,FOLLOW_51_in_ruleWildCard2353); 

                            current = grammarAccess.getWildCardAccess().getPackageEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getWildCardAccess().getPackageEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:1071:6: (enumLiteral_1= '.**' )
                    {
                    // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:1071:6: (enumLiteral_1= '.**' )
                    // ../br.ufmg.dcc.asml/src-gen/br/ufmg/dcc/asml/parser/antlr/internal/InternalASMLModel.g:1071:8: enumLiteral_1= '.**'
                    {
                    enumLiteral_1=(Token)match(input,52,FOLLOW_52_in_ruleWildCard2370); 

                            current = grammarAccess.getWildCardAccess().getPackageAndSubPackageEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_1, grammarAccess.getWildCardAccess().getPackageAndSubPackageEnumLiteralDeclaration_1()); 
                        

                    }


                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleWildCard"

    // Delegated rules


 

    public static final BitSet FOLLOW_ruleASMLModel_in_entryRuleASMLModel75 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleASMLModel85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_ruleASMLModel122 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_ASML_in_ruleASMLModel139 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleASMLModel156 = new BitSet(new long[]{0x00000000000D4010L});
    public static final BitSet FOLLOW_14_in_ruleASMLModel169 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleASMLModel186 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleASMLModel203 = new BitSet(new long[]{0x00000000000D0010L});
    public static final BitSet FOLLOW_ruleAbstractComponent_in_ruleASMLModel226 = new BitSet(new long[]{0x00000000000D0010L});
    public static final BitSet FOLLOW_16_in_ruleASMLModel240 = new BitSet(new long[]{0x0000000000008020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleASMLModel258 = new BitSet(new long[]{0x0000000000028020L});
    public static final BitSet FOLLOW_17_in_ruleASMLModel276 = new BitSet(new long[]{0x0000000000008020L});
    public static final BitSet FOLLOW_15_in_ruleASMLModel292 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleASMLModel306 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAbstractComponent_in_entryRuleAbstractComponent342 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAbstractComponent352 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMetaModule_in_ruleAbstractComponent399 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleView_in_ruleAbstractComponent426 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleView_in_entryRuleView461 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleView471 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_ruleView508 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_ASML_in_ruleView525 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleView542 = new BitSet(new long[]{0x0007FFF8001C8010L});
    public static final BitSet FOLLOW_20_in_ruleView556 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleAttribute_in_ruleView577 = new BitSet(new long[]{0x0000000000128000L});
    public static final BitSet FOLLOW_17_in_ruleView590 = new BitSet(new long[]{0x0000000000108000L});
    public static final BitSet FOLLOW_15_in_ruleView606 = new BitSet(new long[]{0x0007FFF8000C0010L});
    public static final BitSet FOLLOW_ruleAbstractComponent_in_ruleView629 = new BitSet(new long[]{0x0007FFF8000C0010L});
    public static final BitSet FOLLOW_ruleRestriction_in_ruleView651 = new BitSet(new long[]{0x0007FFF800040000L});
    public static final BitSet FOLLOW_18_in_ruleView664 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAttribute_in_entryRuleAttribute700 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAttribute710 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_ASML_in_ruleAttribute752 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_ruleAttribute769 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleAttribute786 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleClassMatching_in_entryRuleClassMatching833 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleClassMatching843 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpressionMatchingClause_in_ruleClassMatching889 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleClassMatching906 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMetaModule_in_entryRuleMetaModule947 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMetaModule957 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_ASML_in_ruleMetaModule999 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleMetaModule1016 = new BitSet(new long[]{0x0000000003CC8010L});
    public static final BitSet FOLLOW_22_in_ruleMetaModule1030 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleAttribute_in_ruleMetaModule1051 = new BitSet(new long[]{0x0000000000428000L});
    public static final BitSet FOLLOW_17_in_ruleMetaModule1064 = new BitSet(new long[]{0x0000000000408000L});
    public static final BitSet FOLLOW_15_in_ruleMetaModule1080 = new BitSet(new long[]{0x00000000038C0010L});
    public static final BitSet FOLLOW_23_in_ruleMetaModule1095 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleMetaModule1112 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleMetaModule1129 = new BitSet(new long[]{0x00000000030C0010L});
    public static final BitSet FOLLOW_24_in_ruleMetaModule1144 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleMetaModule1161 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleMetaModule1178 = new BitSet(new long[]{0x00000000020C0010L});
    public static final BitSet FOLLOW_ruleAbstractComponent_in_ruleMetaModule1201 = new BitSet(new long[]{0x00000000020C0010L});
    public static final BitSet FOLLOW_25_in_ruleMetaModule1215 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleMetaModule1227 = new BitSet(new long[]{0x0007FFF800040000L});
    public static final BitSet FOLLOW_ruleRestriction_in_ruleMetaModule1248 = new BitSet(new long[]{0x0007FFF800040000L});
    public static final BitSet FOLLOW_18_in_ruleMetaModule1261 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleMetaModule1275 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName1312 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedName1323 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_ASML_in_ruleQualifiedName1363 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_26_in_ruleQualifiedName1382 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_ASML_in_ruleQualifiedName1397 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_ruleRestriction_in_entryRuleRestriction1444 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRestriction1454 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGroupClause_in_ruleRestriction1500 = new BitSet(new long[]{0x0007FFF800000000L});
    public static final BitSet FOLLOW_rulePermissionClause_in_ruleRestriction1522 = new BitSet(new long[]{0x0007FFF800000000L});
    public static final BitSet FOLLOW_ruleRelactionType_in_ruleRestriction1544 = new BitSet(new long[]{0x0000003808008010L});
    public static final BitSet FOLLOW_ruleGroupClause_in_ruleRestriction1565 = new BitSet(new long[]{0x0000000008008010L});
    public static final BitSet FOLLOW_ruleComponentsBinRestrictionDeclareation_in_ruleRestriction1588 = new BitSet(new long[]{0x0000000008028010L});
    public static final BitSet FOLLOW_17_in_ruleRestriction1601 = new BitSet(new long[]{0x0000000008008010L});
    public static final BitSet FOLLOW_27_in_ruleRestriction1618 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleRestriction1635 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleRestriction1654 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleComponentsBinRestrictionDeclareation_in_entryRuleComponentsBinRestrictionDeclareation1690 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleComponentsBinRestrictionDeclareation1700 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleComponentsBinRestrictionDeclareation1748 = new BitSet(new long[]{0x0018000000000002L});
    public static final BitSet FOLLOW_ruleWildCard_in_ruleComponentsBinRestrictionDeclareation1769 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_ruleExpressionMatchingClause1822 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_ruleExpressionMatchingClause1839 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_ruleExpressionMatchingClause1856 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_ruleModuleMatchingParamenter1901 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_ruleModuleMatchingParamenter1918 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_ruleModuleMatchingParamenter1935 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_ruleModuleMatchingParamenter1952 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_ruleGroupClause1997 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_ruleGroupClause2014 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_ruleGroupClause2031 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_rulePermissionClause2076 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_rulePermissionClause2093 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_rulePermissionClause2110 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_ruleRelactionType2155 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_ruleRelactionType2172 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_ruleRelactionType2189 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_ruleRelactionType2206 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_ruleRelactionType2223 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_ruleRelactionType2240 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_ruleRelactionType2257 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_ruleRelactionType2274 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_ruleRelactionType2291 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_ruleRelactionType2308 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_ruleWildCard2353 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_ruleWildCard2370 = new BitSet(new long[]{0x0000000000000002L});

}