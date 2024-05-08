package org.example.helloweb.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.example.helloweb.services.HelloWebGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalHelloWebParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'sensor'", "'{'", "'units:'", "','", "'reader:'", "'pins:'", "'out:'", "'}'", "'deviceType'", "'batchRatePolicy:'", "'batchSizePolicy:'", "'heartBeatPolicy:'", "'samplingRate:'", "'('", "')'", "'AND'", "'OR'", "'NOT'", "'.'", "'s'", "'m'", "'h'", "'d'", "'>'", "'<'", "'>='", "'<='", "'='", "'!='"
    };
    public static final int RULE_STRING=6;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__37=37;
    public static final int T__16=16;
    public static final int T__38=38;
    public static final int T__17=17;
    public static final int T__39=39;
    public static final int T__18=18;
    public static final int T__11=11;
    public static final int T__33=33;
    public static final int T__12=12;
    public static final int T__34=34;
    public static final int T__13=13;
    public static final int T__35=35;
    public static final int T__14=14;
    public static final int T__36=36;
    public static final int EOF=-1;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=5;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__20=20;
    public static final int T__21=21;

    // delegates
    // delegators


        public InternalHelloWebParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalHelloWebParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalHelloWebParser.tokenNames; }
    public String getGrammarFileName() { return "InternalHelloWeb.g"; }



     	private HelloWebGrammarAccess grammarAccess;

        public InternalHelloWebParser(TokenStream input, HelloWebGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "SensorConfig";
       	}

       	@Override
       	protected HelloWebGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleSensorConfig"
    // InternalHelloWeb.g:64:1: entryRuleSensorConfig returns [EObject current=null] : iv_ruleSensorConfig= ruleSensorConfig EOF ;
    public final EObject entryRuleSensorConfig() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSensorConfig = null;


        try {
            // InternalHelloWeb.g:64:53: (iv_ruleSensorConfig= ruleSensorConfig EOF )
            // InternalHelloWeb.g:65:2: iv_ruleSensorConfig= ruleSensorConfig EOF
            {
             newCompositeNode(grammarAccess.getSensorConfigRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSensorConfig=ruleSensorConfig();

            state._fsp--;

             current =iv_ruleSensorConfig; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleSensorConfig"


    // $ANTLR start "ruleSensorConfig"
    // InternalHelloWeb.g:71:1: ruleSensorConfig returns [EObject current=null] : ( ( (lv_sensors_0_0= ruleSensor ) ) | ( (lv_deviceTypes_1_0= ruleDeviceType ) ) )* ;
    public final EObject ruleSensorConfig() throws RecognitionException {
        EObject current = null;

        EObject lv_sensors_0_0 = null;

        EObject lv_deviceTypes_1_0 = null;



        	enterRule();

        try {
            // InternalHelloWeb.g:77:2: ( ( ( (lv_sensors_0_0= ruleSensor ) ) | ( (lv_deviceTypes_1_0= ruleDeviceType ) ) )* )
            // InternalHelloWeb.g:78:2: ( ( (lv_sensors_0_0= ruleSensor ) ) | ( (lv_deviceTypes_1_0= ruleDeviceType ) ) )*
            {
            // InternalHelloWeb.g:78:2: ( ( (lv_sensors_0_0= ruleSensor ) ) | ( (lv_deviceTypes_1_0= ruleDeviceType ) ) )*
            loop1:
            do {
                int alt1=3;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==11) ) {
                    alt1=1;
                }
                else if ( (LA1_0==19) ) {
                    alt1=2;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalHelloWeb.g:79:3: ( (lv_sensors_0_0= ruleSensor ) )
            	    {
            	    // InternalHelloWeb.g:79:3: ( (lv_sensors_0_0= ruleSensor ) )
            	    // InternalHelloWeb.g:80:4: (lv_sensors_0_0= ruleSensor )
            	    {
            	    // InternalHelloWeb.g:80:4: (lv_sensors_0_0= ruleSensor )
            	    // InternalHelloWeb.g:81:5: lv_sensors_0_0= ruleSensor
            	    {

            	    					newCompositeNode(grammarAccess.getSensorConfigAccess().getSensorsSensorParserRuleCall_0_0());
            	    				
            	    pushFollow(FOLLOW_3);
            	    lv_sensors_0_0=ruleSensor();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getSensorConfigRule());
            	    					}
            	    					add(
            	    						current,
            	    						"sensors",
            	    						lv_sensors_0_0,
            	    						"org.example.helloweb.HelloWeb.Sensor");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalHelloWeb.g:99:3: ( (lv_deviceTypes_1_0= ruleDeviceType ) )
            	    {
            	    // InternalHelloWeb.g:99:3: ( (lv_deviceTypes_1_0= ruleDeviceType ) )
            	    // InternalHelloWeb.g:100:4: (lv_deviceTypes_1_0= ruleDeviceType )
            	    {
            	    // InternalHelloWeb.g:100:4: (lv_deviceTypes_1_0= ruleDeviceType )
            	    // InternalHelloWeb.g:101:5: lv_deviceTypes_1_0= ruleDeviceType
            	    {

            	    					newCompositeNode(grammarAccess.getSensorConfigAccess().getDeviceTypesDeviceTypeParserRuleCall_1_0());
            	    				
            	    pushFollow(FOLLOW_3);
            	    lv_deviceTypes_1_0=ruleDeviceType();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getSensorConfigRule());
            	    					}
            	    					add(
            	    						current,
            	    						"deviceTypes",
            	    						lv_deviceTypes_1_0,
            	    						"org.example.helloweb.HelloWeb.DeviceType");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


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
    // $ANTLR end "ruleSensorConfig"


    // $ANTLR start "entryRuleSensor"
    // InternalHelloWeb.g:122:1: entryRuleSensor returns [EObject current=null] : iv_ruleSensor= ruleSensor EOF ;
    public final EObject entryRuleSensor() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSensor = null;


        try {
            // InternalHelloWeb.g:122:47: (iv_ruleSensor= ruleSensor EOF )
            // InternalHelloWeb.g:123:2: iv_ruleSensor= ruleSensor EOF
            {
             newCompositeNode(grammarAccess.getSensorRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSensor=ruleSensor();

            state._fsp--;

             current =iv_ruleSensor; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleSensor"


    // $ANTLR start "ruleSensor"
    // InternalHelloWeb.g:129:1: ruleSensor returns [EObject current=null] : (otherlv_0= 'sensor' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'units:' ( (lv_units_4_0= ruleSensorUnit ) ) (otherlv_5= ',' ( (lv_units_6_0= ruleSensorUnit ) ) )* otherlv_7= 'reader:' ( (lv_reader_8_0= RULE_ID ) ) otherlv_9= 'pins:' ( (lv_pins_10_0= rulePin ) ) (otherlv_11= ',' ( (lv_pins_12_0= rulePin ) ) )* otherlv_13= 'out:' ( (lv_out_14_0= ruleOutput ) ) (otherlv_15= ',' ( (lv_out_16_0= ruleOutput ) ) )* otherlv_17= '}' ) ;
    public final EObject ruleSensor() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token lv_reader_8_0=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        Token otherlv_15=null;
        Token otherlv_17=null;
        EObject lv_units_4_0 = null;

        EObject lv_units_6_0 = null;

        EObject lv_pins_10_0 = null;

        EObject lv_pins_12_0 = null;

        EObject lv_out_14_0 = null;

        EObject lv_out_16_0 = null;



        	enterRule();

        try {
            // InternalHelloWeb.g:135:2: ( (otherlv_0= 'sensor' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'units:' ( (lv_units_4_0= ruleSensorUnit ) ) (otherlv_5= ',' ( (lv_units_6_0= ruleSensorUnit ) ) )* otherlv_7= 'reader:' ( (lv_reader_8_0= RULE_ID ) ) otherlv_9= 'pins:' ( (lv_pins_10_0= rulePin ) ) (otherlv_11= ',' ( (lv_pins_12_0= rulePin ) ) )* otherlv_13= 'out:' ( (lv_out_14_0= ruleOutput ) ) (otherlv_15= ',' ( (lv_out_16_0= ruleOutput ) ) )* otherlv_17= '}' ) )
            // InternalHelloWeb.g:136:2: (otherlv_0= 'sensor' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'units:' ( (lv_units_4_0= ruleSensorUnit ) ) (otherlv_5= ',' ( (lv_units_6_0= ruleSensorUnit ) ) )* otherlv_7= 'reader:' ( (lv_reader_8_0= RULE_ID ) ) otherlv_9= 'pins:' ( (lv_pins_10_0= rulePin ) ) (otherlv_11= ',' ( (lv_pins_12_0= rulePin ) ) )* otherlv_13= 'out:' ( (lv_out_14_0= ruleOutput ) ) (otherlv_15= ',' ( (lv_out_16_0= ruleOutput ) ) )* otherlv_17= '}' )
            {
            // InternalHelloWeb.g:136:2: (otherlv_0= 'sensor' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'units:' ( (lv_units_4_0= ruleSensorUnit ) ) (otherlv_5= ',' ( (lv_units_6_0= ruleSensorUnit ) ) )* otherlv_7= 'reader:' ( (lv_reader_8_0= RULE_ID ) ) otherlv_9= 'pins:' ( (lv_pins_10_0= rulePin ) ) (otherlv_11= ',' ( (lv_pins_12_0= rulePin ) ) )* otherlv_13= 'out:' ( (lv_out_14_0= ruleOutput ) ) (otherlv_15= ',' ( (lv_out_16_0= ruleOutput ) ) )* otherlv_17= '}' )
            // InternalHelloWeb.g:137:3: otherlv_0= 'sensor' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'units:' ( (lv_units_4_0= ruleSensorUnit ) ) (otherlv_5= ',' ( (lv_units_6_0= ruleSensorUnit ) ) )* otherlv_7= 'reader:' ( (lv_reader_8_0= RULE_ID ) ) otherlv_9= 'pins:' ( (lv_pins_10_0= rulePin ) ) (otherlv_11= ',' ( (lv_pins_12_0= rulePin ) ) )* otherlv_13= 'out:' ( (lv_out_14_0= ruleOutput ) ) (otherlv_15= ',' ( (lv_out_16_0= ruleOutput ) ) )* otherlv_17= '}'
            {
            otherlv_0=(Token)match(input,11,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getSensorAccess().getSensorKeyword_0());
            		
            // InternalHelloWeb.g:141:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalHelloWeb.g:142:4: (lv_name_1_0= RULE_ID )
            {
            // InternalHelloWeb.g:142:4: (lv_name_1_0= RULE_ID )
            // InternalHelloWeb.g:143:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_5); 

            					newLeafNode(lv_name_1_0, grammarAccess.getSensorAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getSensorRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_6); 

            			newLeafNode(otherlv_2, grammarAccess.getSensorAccess().getLeftCurlyBracketKeyword_2());
            		
            otherlv_3=(Token)match(input,13,FOLLOW_4); 

            			newLeafNode(otherlv_3, grammarAccess.getSensorAccess().getUnitsKeyword_3());
            		
            // InternalHelloWeb.g:167:3: ( (lv_units_4_0= ruleSensorUnit ) )
            // InternalHelloWeb.g:168:4: (lv_units_4_0= ruleSensorUnit )
            {
            // InternalHelloWeb.g:168:4: (lv_units_4_0= ruleSensorUnit )
            // InternalHelloWeb.g:169:5: lv_units_4_0= ruleSensorUnit
            {

            					newCompositeNode(grammarAccess.getSensorAccess().getUnitsSensorUnitParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_7);
            lv_units_4_0=ruleSensorUnit();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getSensorRule());
            					}
            					add(
            						current,
            						"units",
            						lv_units_4_0,
            						"org.example.helloweb.HelloWeb.SensorUnit");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalHelloWeb.g:186:3: (otherlv_5= ',' ( (lv_units_6_0= ruleSensorUnit ) ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==14) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalHelloWeb.g:187:4: otherlv_5= ',' ( (lv_units_6_0= ruleSensorUnit ) )
            	    {
            	    otherlv_5=(Token)match(input,14,FOLLOW_4); 

            	    				newLeafNode(otherlv_5, grammarAccess.getSensorAccess().getCommaKeyword_5_0());
            	    			
            	    // InternalHelloWeb.g:191:4: ( (lv_units_6_0= ruleSensorUnit ) )
            	    // InternalHelloWeb.g:192:5: (lv_units_6_0= ruleSensorUnit )
            	    {
            	    // InternalHelloWeb.g:192:5: (lv_units_6_0= ruleSensorUnit )
            	    // InternalHelloWeb.g:193:6: lv_units_6_0= ruleSensorUnit
            	    {

            	    						newCompositeNode(grammarAccess.getSensorAccess().getUnitsSensorUnitParserRuleCall_5_1_0());
            	    					
            	    pushFollow(FOLLOW_7);
            	    lv_units_6_0=ruleSensorUnit();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getSensorRule());
            	    						}
            	    						add(
            	    							current,
            	    							"units",
            	    							lv_units_6_0,
            	    							"org.example.helloweb.HelloWeb.SensorUnit");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            otherlv_7=(Token)match(input,15,FOLLOW_4); 

            			newLeafNode(otherlv_7, grammarAccess.getSensorAccess().getReaderKeyword_6());
            		
            // InternalHelloWeb.g:215:3: ( (lv_reader_8_0= RULE_ID ) )
            // InternalHelloWeb.g:216:4: (lv_reader_8_0= RULE_ID )
            {
            // InternalHelloWeb.g:216:4: (lv_reader_8_0= RULE_ID )
            // InternalHelloWeb.g:217:5: lv_reader_8_0= RULE_ID
            {
            lv_reader_8_0=(Token)match(input,RULE_ID,FOLLOW_8); 

            					newLeafNode(lv_reader_8_0, grammarAccess.getSensorAccess().getReaderIDTerminalRuleCall_7_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getSensorRule());
            					}
            					setWithLastConsumed(
            						current,
            						"reader",
            						lv_reader_8_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_9=(Token)match(input,16,FOLLOW_4); 

            			newLeafNode(otherlv_9, grammarAccess.getSensorAccess().getPinsKeyword_8());
            		
            // InternalHelloWeb.g:237:3: ( (lv_pins_10_0= rulePin ) )
            // InternalHelloWeb.g:238:4: (lv_pins_10_0= rulePin )
            {
            // InternalHelloWeb.g:238:4: (lv_pins_10_0= rulePin )
            // InternalHelloWeb.g:239:5: lv_pins_10_0= rulePin
            {

            					newCompositeNode(grammarAccess.getSensorAccess().getPinsPinParserRuleCall_9_0());
            				
            pushFollow(FOLLOW_9);
            lv_pins_10_0=rulePin();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getSensorRule());
            					}
            					add(
            						current,
            						"pins",
            						lv_pins_10_0,
            						"org.example.helloweb.HelloWeb.Pin");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalHelloWeb.g:256:3: (otherlv_11= ',' ( (lv_pins_12_0= rulePin ) ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==14) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalHelloWeb.g:257:4: otherlv_11= ',' ( (lv_pins_12_0= rulePin ) )
            	    {
            	    otherlv_11=(Token)match(input,14,FOLLOW_4); 

            	    				newLeafNode(otherlv_11, grammarAccess.getSensorAccess().getCommaKeyword_10_0());
            	    			
            	    // InternalHelloWeb.g:261:4: ( (lv_pins_12_0= rulePin ) )
            	    // InternalHelloWeb.g:262:5: (lv_pins_12_0= rulePin )
            	    {
            	    // InternalHelloWeb.g:262:5: (lv_pins_12_0= rulePin )
            	    // InternalHelloWeb.g:263:6: lv_pins_12_0= rulePin
            	    {

            	    						newCompositeNode(grammarAccess.getSensorAccess().getPinsPinParserRuleCall_10_1_0());
            	    					
            	    pushFollow(FOLLOW_9);
            	    lv_pins_12_0=rulePin();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getSensorRule());
            	    						}
            	    						add(
            	    							current,
            	    							"pins",
            	    							lv_pins_12_0,
            	    							"org.example.helloweb.HelloWeb.Pin");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            otherlv_13=(Token)match(input,17,FOLLOW_4); 

            			newLeafNode(otherlv_13, grammarAccess.getSensorAccess().getOutKeyword_11());
            		
            // InternalHelloWeb.g:285:3: ( (lv_out_14_0= ruleOutput ) )
            // InternalHelloWeb.g:286:4: (lv_out_14_0= ruleOutput )
            {
            // InternalHelloWeb.g:286:4: (lv_out_14_0= ruleOutput )
            // InternalHelloWeb.g:287:5: lv_out_14_0= ruleOutput
            {

            					newCompositeNode(grammarAccess.getSensorAccess().getOutOutputParserRuleCall_12_0());
            				
            pushFollow(FOLLOW_10);
            lv_out_14_0=ruleOutput();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getSensorRule());
            					}
            					add(
            						current,
            						"out",
            						lv_out_14_0,
            						"org.example.helloweb.HelloWeb.Output");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalHelloWeb.g:304:3: (otherlv_15= ',' ( (lv_out_16_0= ruleOutput ) ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==14) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalHelloWeb.g:305:4: otherlv_15= ',' ( (lv_out_16_0= ruleOutput ) )
            	    {
            	    otherlv_15=(Token)match(input,14,FOLLOW_4); 

            	    				newLeafNode(otherlv_15, grammarAccess.getSensorAccess().getCommaKeyword_13_0());
            	    			
            	    // InternalHelloWeb.g:309:4: ( (lv_out_16_0= ruleOutput ) )
            	    // InternalHelloWeb.g:310:5: (lv_out_16_0= ruleOutput )
            	    {
            	    // InternalHelloWeb.g:310:5: (lv_out_16_0= ruleOutput )
            	    // InternalHelloWeb.g:311:6: lv_out_16_0= ruleOutput
            	    {

            	    						newCompositeNode(grammarAccess.getSensorAccess().getOutOutputParserRuleCall_13_1_0());
            	    					
            	    pushFollow(FOLLOW_10);
            	    lv_out_16_0=ruleOutput();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getSensorRule());
            	    						}
            	    						add(
            	    							current,
            	    							"out",
            	    							lv_out_16_0,
            	    							"org.example.helloweb.HelloWeb.Output");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            otherlv_17=(Token)match(input,18,FOLLOW_2); 

            			newLeafNode(otherlv_17, grammarAccess.getSensorAccess().getRightCurlyBracketKeyword_14());
            		

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
    // $ANTLR end "ruleSensor"


    // $ANTLR start "entryRuleDeviceType"
    // InternalHelloWeb.g:337:1: entryRuleDeviceType returns [EObject current=null] : iv_ruleDeviceType= ruleDeviceType EOF ;
    public final EObject entryRuleDeviceType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDeviceType = null;


        try {
            // InternalHelloWeb.g:337:51: (iv_ruleDeviceType= ruleDeviceType EOF )
            // InternalHelloWeb.g:338:2: iv_ruleDeviceType= ruleDeviceType EOF
            {
             newCompositeNode(grammarAccess.getDeviceTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDeviceType=ruleDeviceType();

            state._fsp--;

             current =iv_ruleDeviceType; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleDeviceType"


    // $ANTLR start "ruleDeviceType"
    // InternalHelloWeb.g:344:1: ruleDeviceType returns [EObject current=null] : (otherlv_0= 'deviceType' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_sensorInstantiations_3_0= ruleSensorInstantiation ) )* (otherlv_4= 'batchRatePolicy:' ( (lv_batchRatePolicy_5_0= ruleTimeUnit ) ) )? (otherlv_6= 'batchSizePolicy:' ( (lv_batchSizePolicy_7_0= RULE_INT ) ) )? (otherlv_8= 'heartBeatPolicy:' ( (lv_heartBeatPolicy_9_0= ruleTimeUnit ) ) )? otherlv_10= '}' ) ;
    public final EObject ruleDeviceType() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token lv_batchSizePolicy_7_0=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        EObject lv_sensorInstantiations_3_0 = null;

        AntlrDatatypeRuleToken lv_batchRatePolicy_5_0 = null;

        AntlrDatatypeRuleToken lv_heartBeatPolicy_9_0 = null;



        	enterRule();

        try {
            // InternalHelloWeb.g:350:2: ( (otherlv_0= 'deviceType' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_sensorInstantiations_3_0= ruleSensorInstantiation ) )* (otherlv_4= 'batchRatePolicy:' ( (lv_batchRatePolicy_5_0= ruleTimeUnit ) ) )? (otherlv_6= 'batchSizePolicy:' ( (lv_batchSizePolicy_7_0= RULE_INT ) ) )? (otherlv_8= 'heartBeatPolicy:' ( (lv_heartBeatPolicy_9_0= ruleTimeUnit ) ) )? otherlv_10= '}' ) )
            // InternalHelloWeb.g:351:2: (otherlv_0= 'deviceType' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_sensorInstantiations_3_0= ruleSensorInstantiation ) )* (otherlv_4= 'batchRatePolicy:' ( (lv_batchRatePolicy_5_0= ruleTimeUnit ) ) )? (otherlv_6= 'batchSizePolicy:' ( (lv_batchSizePolicy_7_0= RULE_INT ) ) )? (otherlv_8= 'heartBeatPolicy:' ( (lv_heartBeatPolicy_9_0= ruleTimeUnit ) ) )? otherlv_10= '}' )
            {
            // InternalHelloWeb.g:351:2: (otherlv_0= 'deviceType' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_sensorInstantiations_3_0= ruleSensorInstantiation ) )* (otherlv_4= 'batchRatePolicy:' ( (lv_batchRatePolicy_5_0= ruleTimeUnit ) ) )? (otherlv_6= 'batchSizePolicy:' ( (lv_batchSizePolicy_7_0= RULE_INT ) ) )? (otherlv_8= 'heartBeatPolicy:' ( (lv_heartBeatPolicy_9_0= ruleTimeUnit ) ) )? otherlv_10= '}' )
            // InternalHelloWeb.g:352:3: otherlv_0= 'deviceType' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_sensorInstantiations_3_0= ruleSensorInstantiation ) )* (otherlv_4= 'batchRatePolicy:' ( (lv_batchRatePolicy_5_0= ruleTimeUnit ) ) )? (otherlv_6= 'batchSizePolicy:' ( (lv_batchSizePolicy_7_0= RULE_INT ) ) )? (otherlv_8= 'heartBeatPolicy:' ( (lv_heartBeatPolicy_9_0= ruleTimeUnit ) ) )? otherlv_10= '}'
            {
            otherlv_0=(Token)match(input,19,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getDeviceTypeAccess().getDeviceTypeKeyword_0());
            		
            // InternalHelloWeb.g:356:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalHelloWeb.g:357:4: (lv_name_1_0= RULE_ID )
            {
            // InternalHelloWeb.g:357:4: (lv_name_1_0= RULE_ID )
            // InternalHelloWeb.g:358:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_5); 

            					newLeafNode(lv_name_1_0, grammarAccess.getDeviceTypeAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDeviceTypeRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_11); 

            			newLeafNode(otherlv_2, grammarAccess.getDeviceTypeAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalHelloWeb.g:378:3: ( (lv_sensorInstantiations_3_0= ruleSensorInstantiation ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==RULE_ID) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // InternalHelloWeb.g:379:4: (lv_sensorInstantiations_3_0= ruleSensorInstantiation )
            	    {
            	    // InternalHelloWeb.g:379:4: (lv_sensorInstantiations_3_0= ruleSensorInstantiation )
            	    // InternalHelloWeb.g:380:5: lv_sensorInstantiations_3_0= ruleSensorInstantiation
            	    {

            	    					newCompositeNode(grammarAccess.getDeviceTypeAccess().getSensorInstantiationsSensorInstantiationParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_11);
            	    lv_sensorInstantiations_3_0=ruleSensorInstantiation();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getDeviceTypeRule());
            	    					}
            	    					add(
            	    						current,
            	    						"sensorInstantiations",
            	    						lv_sensorInstantiations_3_0,
            	    						"org.example.helloweb.HelloWeb.SensorInstantiation");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

            // InternalHelloWeb.g:397:3: (otherlv_4= 'batchRatePolicy:' ( (lv_batchRatePolicy_5_0= ruleTimeUnit ) ) )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==20) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // InternalHelloWeb.g:398:4: otherlv_4= 'batchRatePolicy:' ( (lv_batchRatePolicy_5_0= ruleTimeUnit ) )
                    {
                    otherlv_4=(Token)match(input,20,FOLLOW_12); 

                    				newLeafNode(otherlv_4, grammarAccess.getDeviceTypeAccess().getBatchRatePolicyKeyword_4_0());
                    			
                    // InternalHelloWeb.g:402:4: ( (lv_batchRatePolicy_5_0= ruleTimeUnit ) )
                    // InternalHelloWeb.g:403:5: (lv_batchRatePolicy_5_0= ruleTimeUnit )
                    {
                    // InternalHelloWeb.g:403:5: (lv_batchRatePolicy_5_0= ruleTimeUnit )
                    // InternalHelloWeb.g:404:6: lv_batchRatePolicy_5_0= ruleTimeUnit
                    {

                    						newCompositeNode(grammarAccess.getDeviceTypeAccess().getBatchRatePolicyTimeUnitParserRuleCall_4_1_0());
                    					
                    pushFollow(FOLLOW_13);
                    lv_batchRatePolicy_5_0=ruleTimeUnit();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getDeviceTypeRule());
                    						}
                    						set(
                    							current,
                    							"batchRatePolicy",
                    							lv_batchRatePolicy_5_0,
                    							"org.example.helloweb.HelloWeb.TimeUnit");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalHelloWeb.g:422:3: (otherlv_6= 'batchSizePolicy:' ( (lv_batchSizePolicy_7_0= RULE_INT ) ) )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==21) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // InternalHelloWeb.g:423:4: otherlv_6= 'batchSizePolicy:' ( (lv_batchSizePolicy_7_0= RULE_INT ) )
                    {
                    otherlv_6=(Token)match(input,21,FOLLOW_12); 

                    				newLeafNode(otherlv_6, grammarAccess.getDeviceTypeAccess().getBatchSizePolicyKeyword_5_0());
                    			
                    // InternalHelloWeb.g:427:4: ( (lv_batchSizePolicy_7_0= RULE_INT ) )
                    // InternalHelloWeb.g:428:5: (lv_batchSizePolicy_7_0= RULE_INT )
                    {
                    // InternalHelloWeb.g:428:5: (lv_batchSizePolicy_7_0= RULE_INT )
                    // InternalHelloWeb.g:429:6: lv_batchSizePolicy_7_0= RULE_INT
                    {
                    lv_batchSizePolicy_7_0=(Token)match(input,RULE_INT,FOLLOW_14); 

                    						newLeafNode(lv_batchSizePolicy_7_0, grammarAccess.getDeviceTypeAccess().getBatchSizePolicyINTTerminalRuleCall_5_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDeviceTypeRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"batchSizePolicy",
                    							lv_batchSizePolicy_7_0,
                    							"org.eclipse.xtext.common.Terminals.INT");
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalHelloWeb.g:446:3: (otherlv_8= 'heartBeatPolicy:' ( (lv_heartBeatPolicy_9_0= ruleTimeUnit ) ) )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==22) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // InternalHelloWeb.g:447:4: otherlv_8= 'heartBeatPolicy:' ( (lv_heartBeatPolicy_9_0= ruleTimeUnit ) )
                    {
                    otherlv_8=(Token)match(input,22,FOLLOW_12); 

                    				newLeafNode(otherlv_8, grammarAccess.getDeviceTypeAccess().getHeartBeatPolicyKeyword_6_0());
                    			
                    // InternalHelloWeb.g:451:4: ( (lv_heartBeatPolicy_9_0= ruleTimeUnit ) )
                    // InternalHelloWeb.g:452:5: (lv_heartBeatPolicy_9_0= ruleTimeUnit )
                    {
                    // InternalHelloWeb.g:452:5: (lv_heartBeatPolicy_9_0= ruleTimeUnit )
                    // InternalHelloWeb.g:453:6: lv_heartBeatPolicy_9_0= ruleTimeUnit
                    {

                    						newCompositeNode(grammarAccess.getDeviceTypeAccess().getHeartBeatPolicyTimeUnitParserRuleCall_6_1_0());
                    					
                    pushFollow(FOLLOW_15);
                    lv_heartBeatPolicy_9_0=ruleTimeUnit();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getDeviceTypeRule());
                    						}
                    						set(
                    							current,
                    							"heartBeatPolicy",
                    							lv_heartBeatPolicy_9_0,
                    							"org.example.helloweb.HelloWeb.TimeUnit");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_10=(Token)match(input,18,FOLLOW_2); 

            			newLeafNode(otherlv_10, grammarAccess.getDeviceTypeAccess().getRightCurlyBracketKeyword_7());
            		

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
    // $ANTLR end "ruleDeviceType"


    // $ANTLR start "entryRuleSensorInstantiation"
    // InternalHelloWeb.g:479:1: entryRuleSensorInstantiation returns [EObject current=null] : iv_ruleSensorInstantiation= ruleSensorInstantiation EOF ;
    public final EObject entryRuleSensorInstantiation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSensorInstantiation = null;


        try {
            // InternalHelloWeb.g:479:60: (iv_ruleSensorInstantiation= ruleSensorInstantiation EOF )
            // InternalHelloWeb.g:480:2: iv_ruleSensorInstantiation= ruleSensorInstantiation EOF
            {
             newCompositeNode(grammarAccess.getSensorInstantiationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSensorInstantiation=ruleSensorInstantiation();

            state._fsp--;

             current =iv_ruleSensorInstantiation; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleSensorInstantiation"


    // $ANTLR start "ruleSensorInstantiation"
    // InternalHelloWeb.g:486:1: ruleSensorInstantiation returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'pins:' ( (lv_pins_4_0= RULE_INT ) ) (otherlv_5= ',' ( (lv_pins_6_0= RULE_INT ) ) )* (otherlv_7= 'samplingRate:' ( (lv_samplingRate_8_0= ruleTimeUnit ) ) )? ( (lv_constraints_9_0= ruleConstraint ) )* otherlv_10= '}' ) ;
    public final EObject ruleSensorInstantiation() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_pins_4_0=null;
        Token otherlv_5=null;
        Token lv_pins_6_0=null;
        Token otherlv_7=null;
        Token otherlv_10=null;
        AntlrDatatypeRuleToken lv_samplingRate_8_0 = null;

        EObject lv_constraints_9_0 = null;



        	enterRule();

        try {
            // InternalHelloWeb.g:492:2: ( ( ( (otherlv_0= RULE_ID ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'pins:' ( (lv_pins_4_0= RULE_INT ) ) (otherlv_5= ',' ( (lv_pins_6_0= RULE_INT ) ) )* (otherlv_7= 'samplingRate:' ( (lv_samplingRate_8_0= ruleTimeUnit ) ) )? ( (lv_constraints_9_0= ruleConstraint ) )* otherlv_10= '}' ) )
            // InternalHelloWeb.g:493:2: ( ( (otherlv_0= RULE_ID ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'pins:' ( (lv_pins_4_0= RULE_INT ) ) (otherlv_5= ',' ( (lv_pins_6_0= RULE_INT ) ) )* (otherlv_7= 'samplingRate:' ( (lv_samplingRate_8_0= ruleTimeUnit ) ) )? ( (lv_constraints_9_0= ruleConstraint ) )* otherlv_10= '}' )
            {
            // InternalHelloWeb.g:493:2: ( ( (otherlv_0= RULE_ID ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'pins:' ( (lv_pins_4_0= RULE_INT ) ) (otherlv_5= ',' ( (lv_pins_6_0= RULE_INT ) ) )* (otherlv_7= 'samplingRate:' ( (lv_samplingRate_8_0= ruleTimeUnit ) ) )? ( (lv_constraints_9_0= ruleConstraint ) )* otherlv_10= '}' )
            // InternalHelloWeb.g:494:3: ( (otherlv_0= RULE_ID ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'pins:' ( (lv_pins_4_0= RULE_INT ) ) (otherlv_5= ',' ( (lv_pins_6_0= RULE_INT ) ) )* (otherlv_7= 'samplingRate:' ( (lv_samplingRate_8_0= ruleTimeUnit ) ) )? ( (lv_constraints_9_0= ruleConstraint ) )* otherlv_10= '}'
            {
            // InternalHelloWeb.g:494:3: ( (otherlv_0= RULE_ID ) )
            // InternalHelloWeb.g:495:4: (otherlv_0= RULE_ID )
            {
            // InternalHelloWeb.g:495:4: (otherlv_0= RULE_ID )
            // InternalHelloWeb.g:496:5: otherlv_0= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getSensorInstantiationRule());
            					}
            				
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_4); 

            					newLeafNode(otherlv_0, grammarAccess.getSensorInstantiationAccess().getSensorSensorCrossReference_0_0());
            				

            }


            }

            // InternalHelloWeb.g:507:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalHelloWeb.g:508:4: (lv_name_1_0= RULE_ID )
            {
            // InternalHelloWeb.g:508:4: (lv_name_1_0= RULE_ID )
            // InternalHelloWeb.g:509:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_5); 

            					newLeafNode(lv_name_1_0, grammarAccess.getSensorInstantiationAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getSensorInstantiationRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_8); 

            			newLeafNode(otherlv_2, grammarAccess.getSensorInstantiationAccess().getLeftCurlyBracketKeyword_2());
            		
            otherlv_3=(Token)match(input,16,FOLLOW_12); 

            			newLeafNode(otherlv_3, grammarAccess.getSensorInstantiationAccess().getPinsKeyword_3());
            		
            // InternalHelloWeb.g:533:3: ( (lv_pins_4_0= RULE_INT ) )
            // InternalHelloWeb.g:534:4: (lv_pins_4_0= RULE_INT )
            {
            // InternalHelloWeb.g:534:4: (lv_pins_4_0= RULE_INT )
            // InternalHelloWeb.g:535:5: lv_pins_4_0= RULE_INT
            {
            lv_pins_4_0=(Token)match(input,RULE_INT,FOLLOW_16); 

            					newLeafNode(lv_pins_4_0, grammarAccess.getSensorInstantiationAccess().getPinsINTTerminalRuleCall_4_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getSensorInstantiationRule());
            					}
            					addWithLastConsumed(
            						current,
            						"pins",
            						lv_pins_4_0,
            						"org.eclipse.xtext.common.Terminals.INT");
            				

            }


            }

            // InternalHelloWeb.g:551:3: (otherlv_5= ',' ( (lv_pins_6_0= RULE_INT ) ) )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==14) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // InternalHelloWeb.g:552:4: otherlv_5= ',' ( (lv_pins_6_0= RULE_INT ) )
            	    {
            	    otherlv_5=(Token)match(input,14,FOLLOW_12); 

            	    				newLeafNode(otherlv_5, grammarAccess.getSensorInstantiationAccess().getCommaKeyword_5_0());
            	    			
            	    // InternalHelloWeb.g:556:4: ( (lv_pins_6_0= RULE_INT ) )
            	    // InternalHelloWeb.g:557:5: (lv_pins_6_0= RULE_INT )
            	    {
            	    // InternalHelloWeb.g:557:5: (lv_pins_6_0= RULE_INT )
            	    // InternalHelloWeb.g:558:6: lv_pins_6_0= RULE_INT
            	    {
            	    lv_pins_6_0=(Token)match(input,RULE_INT,FOLLOW_16); 

            	    						newLeafNode(lv_pins_6_0, grammarAccess.getSensorInstantiationAccess().getPinsINTTerminalRuleCall_5_1_0());
            	    					

            	    						if (current==null) {
            	    							current = createModelElement(grammarAccess.getSensorInstantiationRule());
            	    						}
            	    						addWithLastConsumed(
            	    							current,
            	    							"pins",
            	    							lv_pins_6_0,
            	    							"org.eclipse.xtext.common.Terminals.INT");
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);

            // InternalHelloWeb.g:575:3: (otherlv_7= 'samplingRate:' ( (lv_samplingRate_8_0= ruleTimeUnit ) ) )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==23) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalHelloWeb.g:576:4: otherlv_7= 'samplingRate:' ( (lv_samplingRate_8_0= ruleTimeUnit ) )
                    {
                    otherlv_7=(Token)match(input,23,FOLLOW_12); 

                    				newLeafNode(otherlv_7, grammarAccess.getSensorInstantiationAccess().getSamplingRateKeyword_6_0());
                    			
                    // InternalHelloWeb.g:580:4: ( (lv_samplingRate_8_0= ruleTimeUnit ) )
                    // InternalHelloWeb.g:581:5: (lv_samplingRate_8_0= ruleTimeUnit )
                    {
                    // InternalHelloWeb.g:581:5: (lv_samplingRate_8_0= ruleTimeUnit )
                    // InternalHelloWeb.g:582:6: lv_samplingRate_8_0= ruleTimeUnit
                    {

                    						newCompositeNode(grammarAccess.getSensorInstantiationAccess().getSamplingRateTimeUnitParserRuleCall_6_1_0());
                    					
                    pushFollow(FOLLOW_17);
                    lv_samplingRate_8_0=ruleTimeUnit();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getSensorInstantiationRule());
                    						}
                    						set(
                    							current,
                    							"samplingRate",
                    							lv_samplingRate_8_0,
                    							"org.example.helloweb.HelloWeb.TimeUnit");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalHelloWeb.g:600:3: ( (lv_constraints_9_0= ruleConstraint ) )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==24) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // InternalHelloWeb.g:601:4: (lv_constraints_9_0= ruleConstraint )
            	    {
            	    // InternalHelloWeb.g:601:4: (lv_constraints_9_0= ruleConstraint )
            	    // InternalHelloWeb.g:602:5: lv_constraints_9_0= ruleConstraint
            	    {

            	    					newCompositeNode(grammarAccess.getSensorInstantiationAccess().getConstraintsConstraintParserRuleCall_7_0());
            	    				
            	    pushFollow(FOLLOW_17);
            	    lv_constraints_9_0=ruleConstraint();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getSensorInstantiationRule());
            	    					}
            	    					add(
            	    						current,
            	    						"constraints",
            	    						lv_constraints_9_0,
            	    						"org.example.helloweb.HelloWeb.Constraint");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);

            otherlv_10=(Token)match(input,18,FOLLOW_2); 

            			newLeafNode(otherlv_10, grammarAccess.getSensorInstantiationAccess().getRightCurlyBracketKeyword_8());
            		

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
    // $ANTLR end "ruleSensorInstantiation"


    // $ANTLR start "entryRuleConstraint"
    // InternalHelloWeb.g:627:1: entryRuleConstraint returns [EObject current=null] : iv_ruleConstraint= ruleConstraint EOF ;
    public final EObject entryRuleConstraint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstraint = null;


        try {
            // InternalHelloWeb.g:627:51: (iv_ruleConstraint= ruleConstraint EOF )
            // InternalHelloWeb.g:628:2: iv_ruleConstraint= ruleConstraint EOF
            {
             newCompositeNode(grammarAccess.getConstraintRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleConstraint=ruleConstraint();

            state._fsp--;

             current =iv_ruleConstraint; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleConstraint"


    // $ANTLR start "ruleConstraint"
    // InternalHelloWeb.g:634:1: ruleConstraint returns [EObject current=null] : (otherlv_0= '(' ( (lv_condition_1_0= ruleCondition ) ) otherlv_2= ')' otherlv_3= '{' (otherlv_4= 'samplingRate:' ( (lv_samplingRate_5_0= ruleTimeUnit ) ) )? otherlv_6= '}' ) ;
    public final EObject ruleConstraint() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_condition_1_0 = null;

        AntlrDatatypeRuleToken lv_samplingRate_5_0 = null;



        	enterRule();

        try {
            // InternalHelloWeb.g:640:2: ( (otherlv_0= '(' ( (lv_condition_1_0= ruleCondition ) ) otherlv_2= ')' otherlv_3= '{' (otherlv_4= 'samplingRate:' ( (lv_samplingRate_5_0= ruleTimeUnit ) ) )? otherlv_6= '}' ) )
            // InternalHelloWeb.g:641:2: (otherlv_0= '(' ( (lv_condition_1_0= ruleCondition ) ) otherlv_2= ')' otherlv_3= '{' (otherlv_4= 'samplingRate:' ( (lv_samplingRate_5_0= ruleTimeUnit ) ) )? otherlv_6= '}' )
            {
            // InternalHelloWeb.g:641:2: (otherlv_0= '(' ( (lv_condition_1_0= ruleCondition ) ) otherlv_2= ')' otherlv_3= '{' (otherlv_4= 'samplingRate:' ( (lv_samplingRate_5_0= ruleTimeUnit ) ) )? otherlv_6= '}' )
            // InternalHelloWeb.g:642:3: otherlv_0= '(' ( (lv_condition_1_0= ruleCondition ) ) otherlv_2= ')' otherlv_3= '{' (otherlv_4= 'samplingRate:' ( (lv_samplingRate_5_0= ruleTimeUnit ) ) )? otherlv_6= '}'
            {
            otherlv_0=(Token)match(input,24,FOLLOW_18); 

            			newLeafNode(otherlv_0, grammarAccess.getConstraintAccess().getLeftParenthesisKeyword_0());
            		
            // InternalHelloWeb.g:646:3: ( (lv_condition_1_0= ruleCondition ) )
            // InternalHelloWeb.g:647:4: (lv_condition_1_0= ruleCondition )
            {
            // InternalHelloWeb.g:647:4: (lv_condition_1_0= ruleCondition )
            // InternalHelloWeb.g:648:5: lv_condition_1_0= ruleCondition
            {

            					newCompositeNode(grammarAccess.getConstraintAccess().getConditionConditionParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_19);
            lv_condition_1_0=ruleCondition();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getConstraintRule());
            					}
            					set(
            						current,
            						"condition",
            						lv_condition_1_0,
            						"org.example.helloweb.HelloWeb.Condition");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,25,FOLLOW_5); 

            			newLeafNode(otherlv_2, grammarAccess.getConstraintAccess().getRightParenthesisKeyword_2());
            		
            otherlv_3=(Token)match(input,12,FOLLOW_20); 

            			newLeafNode(otherlv_3, grammarAccess.getConstraintAccess().getLeftCurlyBracketKeyword_3());
            		
            // InternalHelloWeb.g:673:3: (otherlv_4= 'samplingRate:' ( (lv_samplingRate_5_0= ruleTimeUnit ) ) )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==23) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // InternalHelloWeb.g:674:4: otherlv_4= 'samplingRate:' ( (lv_samplingRate_5_0= ruleTimeUnit ) )
                    {
                    otherlv_4=(Token)match(input,23,FOLLOW_12); 

                    				newLeafNode(otherlv_4, grammarAccess.getConstraintAccess().getSamplingRateKeyword_4_0());
                    			
                    // InternalHelloWeb.g:678:4: ( (lv_samplingRate_5_0= ruleTimeUnit ) )
                    // InternalHelloWeb.g:679:5: (lv_samplingRate_5_0= ruleTimeUnit )
                    {
                    // InternalHelloWeb.g:679:5: (lv_samplingRate_5_0= ruleTimeUnit )
                    // InternalHelloWeb.g:680:6: lv_samplingRate_5_0= ruleTimeUnit
                    {

                    						newCompositeNode(grammarAccess.getConstraintAccess().getSamplingRateTimeUnitParserRuleCall_4_1_0());
                    					
                    pushFollow(FOLLOW_15);
                    lv_samplingRate_5_0=ruleTimeUnit();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getConstraintRule());
                    						}
                    						set(
                    							current,
                    							"samplingRate",
                    							lv_samplingRate_5_0,
                    							"org.example.helloweb.HelloWeb.TimeUnit");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_6=(Token)match(input,18,FOLLOW_2); 

            			newLeafNode(otherlv_6, grammarAccess.getConstraintAccess().getRightCurlyBracketKeyword_5());
            		

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
    // $ANTLR end "ruleConstraint"


    // $ANTLR start "entryRuleCondition"
    // InternalHelloWeb.g:706:1: entryRuleCondition returns [EObject current=null] : iv_ruleCondition= ruleCondition EOF ;
    public final EObject entryRuleCondition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCondition = null;


        try {
            // InternalHelloWeb.g:706:50: (iv_ruleCondition= ruleCondition EOF )
            // InternalHelloWeb.g:707:2: iv_ruleCondition= ruleCondition EOF
            {
             newCompositeNode(grammarAccess.getConditionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleCondition=ruleCondition();

            state._fsp--;

             current =iv_ruleCondition; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleCondition"


    // $ANTLR start "ruleCondition"
    // InternalHelloWeb.g:713:1: ruleCondition returns [EObject current=null] : (this_Comparison_0= ruleComparison | this_NestedLogicalCondition_1= ruleNestedLogicalCondition ) ;
    public final EObject ruleCondition() throws RecognitionException {
        EObject current = null;

        EObject this_Comparison_0 = null;

        EObject this_NestedLogicalCondition_1 = null;



        	enterRule();

        try {
            // InternalHelloWeb.g:719:2: ( (this_Comparison_0= ruleComparison | this_NestedLogicalCondition_1= ruleNestedLogicalCondition ) )
            // InternalHelloWeb.g:720:2: (this_Comparison_0= ruleComparison | this_NestedLogicalCondition_1= ruleNestedLogicalCondition )
            {
            // InternalHelloWeb.g:720:2: (this_Comparison_0= ruleComparison | this_NestedLogicalCondition_1= ruleNestedLogicalCondition )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( ((LA13_0>=RULE_ID && LA13_0<=RULE_INT)) ) {
                alt13=1;
            }
            else if ( (LA13_0==24) ) {
                alt13=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }
            switch (alt13) {
                case 1 :
                    // InternalHelloWeb.g:721:3: this_Comparison_0= ruleComparison
                    {

                    			newCompositeNode(grammarAccess.getConditionAccess().getComparisonParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_Comparison_0=ruleComparison();

                    state._fsp--;


                    			current = this_Comparison_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalHelloWeb.g:730:3: this_NestedLogicalCondition_1= ruleNestedLogicalCondition
                    {

                    			newCompositeNode(grammarAccess.getConditionAccess().getNestedLogicalConditionParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_NestedLogicalCondition_1=ruleNestedLogicalCondition();

                    state._fsp--;


                    			current = this_NestedLogicalCondition_1;
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
    // $ANTLR end "ruleCondition"


    // $ANTLR start "entryRuleNestedLogicalCondition"
    // InternalHelloWeb.g:742:1: entryRuleNestedLogicalCondition returns [EObject current=null] : iv_ruleNestedLogicalCondition= ruleNestedLogicalCondition EOF ;
    public final EObject entryRuleNestedLogicalCondition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNestedLogicalCondition = null;


        try {
            // InternalHelloWeb.g:742:63: (iv_ruleNestedLogicalCondition= ruleNestedLogicalCondition EOF )
            // InternalHelloWeb.g:743:2: iv_ruleNestedLogicalCondition= ruleNestedLogicalCondition EOF
            {
             newCompositeNode(grammarAccess.getNestedLogicalConditionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleNestedLogicalCondition=ruleNestedLogicalCondition();

            state._fsp--;

             current =iv_ruleNestedLogicalCondition; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleNestedLogicalCondition"


    // $ANTLR start "ruleNestedLogicalCondition"
    // InternalHelloWeb.g:749:1: ruleNestedLogicalCondition returns [EObject current=null] : (otherlv_0= '(' ( (lv_left_1_0= ruleCondition ) ) otherlv_2= ')' ( ( (lv_operator_3_1= 'AND' | lv_operator_3_2= 'OR' | lv_operator_3_3= 'NOT' ) ) ) otherlv_4= '(' ( (lv_right_5_0= ruleCondition ) ) otherlv_6= ')' ) ;
    public final EObject ruleNestedLogicalCondition() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token lv_operator_3_1=null;
        Token lv_operator_3_2=null;
        Token lv_operator_3_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_left_1_0 = null;

        EObject lv_right_5_0 = null;



        	enterRule();

        try {
            // InternalHelloWeb.g:755:2: ( (otherlv_0= '(' ( (lv_left_1_0= ruleCondition ) ) otherlv_2= ')' ( ( (lv_operator_3_1= 'AND' | lv_operator_3_2= 'OR' | lv_operator_3_3= 'NOT' ) ) ) otherlv_4= '(' ( (lv_right_5_0= ruleCondition ) ) otherlv_6= ')' ) )
            // InternalHelloWeb.g:756:2: (otherlv_0= '(' ( (lv_left_1_0= ruleCondition ) ) otherlv_2= ')' ( ( (lv_operator_3_1= 'AND' | lv_operator_3_2= 'OR' | lv_operator_3_3= 'NOT' ) ) ) otherlv_4= '(' ( (lv_right_5_0= ruleCondition ) ) otherlv_6= ')' )
            {
            // InternalHelloWeb.g:756:2: (otherlv_0= '(' ( (lv_left_1_0= ruleCondition ) ) otherlv_2= ')' ( ( (lv_operator_3_1= 'AND' | lv_operator_3_2= 'OR' | lv_operator_3_3= 'NOT' ) ) ) otherlv_4= '(' ( (lv_right_5_0= ruleCondition ) ) otherlv_6= ')' )
            // InternalHelloWeb.g:757:3: otherlv_0= '(' ( (lv_left_1_0= ruleCondition ) ) otherlv_2= ')' ( ( (lv_operator_3_1= 'AND' | lv_operator_3_2= 'OR' | lv_operator_3_3= 'NOT' ) ) ) otherlv_4= '(' ( (lv_right_5_0= ruleCondition ) ) otherlv_6= ')'
            {
            otherlv_0=(Token)match(input,24,FOLLOW_18); 

            			newLeafNode(otherlv_0, grammarAccess.getNestedLogicalConditionAccess().getLeftParenthesisKeyword_0());
            		
            // InternalHelloWeb.g:761:3: ( (lv_left_1_0= ruleCondition ) )
            // InternalHelloWeb.g:762:4: (lv_left_1_0= ruleCondition )
            {
            // InternalHelloWeb.g:762:4: (lv_left_1_0= ruleCondition )
            // InternalHelloWeb.g:763:5: lv_left_1_0= ruleCondition
            {

            					newCompositeNode(grammarAccess.getNestedLogicalConditionAccess().getLeftConditionParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_19);
            lv_left_1_0=ruleCondition();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getNestedLogicalConditionRule());
            					}
            					set(
            						current,
            						"left",
            						lv_left_1_0,
            						"org.example.helloweb.HelloWeb.Condition");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,25,FOLLOW_21); 

            			newLeafNode(otherlv_2, grammarAccess.getNestedLogicalConditionAccess().getRightParenthesisKeyword_2());
            		
            // InternalHelloWeb.g:784:3: ( ( (lv_operator_3_1= 'AND' | lv_operator_3_2= 'OR' | lv_operator_3_3= 'NOT' ) ) )
            // InternalHelloWeb.g:785:4: ( (lv_operator_3_1= 'AND' | lv_operator_3_2= 'OR' | lv_operator_3_3= 'NOT' ) )
            {
            // InternalHelloWeb.g:785:4: ( (lv_operator_3_1= 'AND' | lv_operator_3_2= 'OR' | lv_operator_3_3= 'NOT' ) )
            // InternalHelloWeb.g:786:5: (lv_operator_3_1= 'AND' | lv_operator_3_2= 'OR' | lv_operator_3_3= 'NOT' )
            {
            // InternalHelloWeb.g:786:5: (lv_operator_3_1= 'AND' | lv_operator_3_2= 'OR' | lv_operator_3_3= 'NOT' )
            int alt14=3;
            switch ( input.LA(1) ) {
            case 26:
                {
                alt14=1;
                }
                break;
            case 27:
                {
                alt14=2;
                }
                break;
            case 28:
                {
                alt14=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }

            switch (alt14) {
                case 1 :
                    // InternalHelloWeb.g:787:6: lv_operator_3_1= 'AND'
                    {
                    lv_operator_3_1=(Token)match(input,26,FOLLOW_22); 

                    						newLeafNode(lv_operator_3_1, grammarAccess.getNestedLogicalConditionAccess().getOperatorANDKeyword_3_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getNestedLogicalConditionRule());
                    						}
                    						setWithLastConsumed(current, "operator", lv_operator_3_1, null);
                    					

                    }
                    break;
                case 2 :
                    // InternalHelloWeb.g:798:6: lv_operator_3_2= 'OR'
                    {
                    lv_operator_3_2=(Token)match(input,27,FOLLOW_22); 

                    						newLeafNode(lv_operator_3_2, grammarAccess.getNestedLogicalConditionAccess().getOperatorORKeyword_3_0_1());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getNestedLogicalConditionRule());
                    						}
                    						setWithLastConsumed(current, "operator", lv_operator_3_2, null);
                    					

                    }
                    break;
                case 3 :
                    // InternalHelloWeb.g:809:6: lv_operator_3_3= 'NOT'
                    {
                    lv_operator_3_3=(Token)match(input,28,FOLLOW_22); 

                    						newLeafNode(lv_operator_3_3, grammarAccess.getNestedLogicalConditionAccess().getOperatorNOTKeyword_3_0_2());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getNestedLogicalConditionRule());
                    						}
                    						setWithLastConsumed(current, "operator", lv_operator_3_3, null);
                    					

                    }
                    break;

            }


            }


            }

            otherlv_4=(Token)match(input,24,FOLLOW_18); 

            			newLeafNode(otherlv_4, grammarAccess.getNestedLogicalConditionAccess().getLeftParenthesisKeyword_4());
            		
            // InternalHelloWeb.g:826:3: ( (lv_right_5_0= ruleCondition ) )
            // InternalHelloWeb.g:827:4: (lv_right_5_0= ruleCondition )
            {
            // InternalHelloWeb.g:827:4: (lv_right_5_0= ruleCondition )
            // InternalHelloWeb.g:828:5: lv_right_5_0= ruleCondition
            {

            					newCompositeNode(grammarAccess.getNestedLogicalConditionAccess().getRightConditionParserRuleCall_5_0());
            				
            pushFollow(FOLLOW_19);
            lv_right_5_0=ruleCondition();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getNestedLogicalConditionRule());
            					}
            					set(
            						current,
            						"right",
            						lv_right_5_0,
            						"org.example.helloweb.HelloWeb.Condition");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_6=(Token)match(input,25,FOLLOW_2); 

            			newLeafNode(otherlv_6, grammarAccess.getNestedLogicalConditionAccess().getRightParenthesisKeyword_6());
            		

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
    // $ANTLR end "ruleNestedLogicalCondition"


    // $ANTLR start "entryRuleComparison"
    // InternalHelloWeb.g:853:1: entryRuleComparison returns [EObject current=null] : iv_ruleComparison= ruleComparison EOF ;
    public final EObject entryRuleComparison() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComparison = null;


        try {
            // InternalHelloWeb.g:853:51: (iv_ruleComparison= ruleComparison EOF )
            // InternalHelloWeb.g:854:2: iv_ruleComparison= ruleComparison EOF
            {
             newCompositeNode(grammarAccess.getComparisonRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleComparison=ruleComparison();

            state._fsp--;

             current =iv_ruleComparison; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleComparison"


    // $ANTLR start "ruleComparison"
    // InternalHelloWeb.g:860:1: ruleComparison returns [EObject current=null] : ( ( (lv_left_0_0= ruleComparisonValue ) ) ( (lv_operator_1_0= ruleComparisonOperator ) ) ( (lv_right_2_0= ruleComparisonValue ) ) ) ;
    public final EObject ruleComparison() throws RecognitionException {
        EObject current = null;

        EObject lv_left_0_0 = null;

        AntlrDatatypeRuleToken lv_operator_1_0 = null;

        EObject lv_right_2_0 = null;



        	enterRule();

        try {
            // InternalHelloWeb.g:866:2: ( ( ( (lv_left_0_0= ruleComparisonValue ) ) ( (lv_operator_1_0= ruleComparisonOperator ) ) ( (lv_right_2_0= ruleComparisonValue ) ) ) )
            // InternalHelloWeb.g:867:2: ( ( (lv_left_0_0= ruleComparisonValue ) ) ( (lv_operator_1_0= ruleComparisonOperator ) ) ( (lv_right_2_0= ruleComparisonValue ) ) )
            {
            // InternalHelloWeb.g:867:2: ( ( (lv_left_0_0= ruleComparisonValue ) ) ( (lv_operator_1_0= ruleComparisonOperator ) ) ( (lv_right_2_0= ruleComparisonValue ) ) )
            // InternalHelloWeb.g:868:3: ( (lv_left_0_0= ruleComparisonValue ) ) ( (lv_operator_1_0= ruleComparisonOperator ) ) ( (lv_right_2_0= ruleComparisonValue ) )
            {
            // InternalHelloWeb.g:868:3: ( (lv_left_0_0= ruleComparisonValue ) )
            // InternalHelloWeb.g:869:4: (lv_left_0_0= ruleComparisonValue )
            {
            // InternalHelloWeb.g:869:4: (lv_left_0_0= ruleComparisonValue )
            // InternalHelloWeb.g:870:5: lv_left_0_0= ruleComparisonValue
            {

            					newCompositeNode(grammarAccess.getComparisonAccess().getLeftComparisonValueParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_23);
            lv_left_0_0=ruleComparisonValue();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getComparisonRule());
            					}
            					set(
            						current,
            						"left",
            						lv_left_0_0,
            						"org.example.helloweb.HelloWeb.ComparisonValue");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalHelloWeb.g:887:3: ( (lv_operator_1_0= ruleComparisonOperator ) )
            // InternalHelloWeb.g:888:4: (lv_operator_1_0= ruleComparisonOperator )
            {
            // InternalHelloWeb.g:888:4: (lv_operator_1_0= ruleComparisonOperator )
            // InternalHelloWeb.g:889:5: lv_operator_1_0= ruleComparisonOperator
            {

            					newCompositeNode(grammarAccess.getComparisonAccess().getOperatorComparisonOperatorParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_24);
            lv_operator_1_0=ruleComparisonOperator();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getComparisonRule());
            					}
            					set(
            						current,
            						"operator",
            						lv_operator_1_0,
            						"org.example.helloweb.HelloWeb.ComparisonOperator");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalHelloWeb.g:906:3: ( (lv_right_2_0= ruleComparisonValue ) )
            // InternalHelloWeb.g:907:4: (lv_right_2_0= ruleComparisonValue )
            {
            // InternalHelloWeb.g:907:4: (lv_right_2_0= ruleComparisonValue )
            // InternalHelloWeb.g:908:5: lv_right_2_0= ruleComparisonValue
            {

            					newCompositeNode(grammarAccess.getComparisonAccess().getRightComparisonValueParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_2);
            lv_right_2_0=ruleComparisonValue();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getComparisonRule());
            					}
            					set(
            						current,
            						"right",
            						lv_right_2_0,
            						"org.example.helloweb.HelloWeb.ComparisonValue");
            					afterParserOrEnumRuleCall();
            				

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
    // $ANTLR end "ruleComparison"


    // $ANTLR start "entryRuleComparisonValue"
    // InternalHelloWeb.g:929:1: entryRuleComparisonValue returns [EObject current=null] : iv_ruleComparisonValue= ruleComparisonValue EOF ;
    public final EObject entryRuleComparisonValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComparisonValue = null;


        try {
            // InternalHelloWeb.g:929:56: (iv_ruleComparisonValue= ruleComparisonValue EOF )
            // InternalHelloWeb.g:930:2: iv_ruleComparisonValue= ruleComparisonValue EOF
            {
             newCompositeNode(grammarAccess.getComparisonValueRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleComparisonValue=ruleComparisonValue();

            state._fsp--;

             current =iv_ruleComparisonValue; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleComparisonValue"


    // $ANTLR start "ruleComparisonValue"
    // InternalHelloWeb.g:936:1: ruleComparisonValue returns [EObject current=null] : (this_ValueRef_0= ruleValueRef | this_Decimal_1= ruleDecimal | ( () ( (lv_value_3_0= RULE_INT ) ) ) ) ;
    public final EObject ruleComparisonValue() throws RecognitionException {
        EObject current = null;

        Token lv_value_3_0=null;
        EObject this_ValueRef_0 = null;

        EObject this_Decimal_1 = null;



        	enterRule();

        try {
            // InternalHelloWeb.g:942:2: ( (this_ValueRef_0= ruleValueRef | this_Decimal_1= ruleDecimal | ( () ( (lv_value_3_0= RULE_INT ) ) ) ) )
            // InternalHelloWeb.g:943:2: (this_ValueRef_0= ruleValueRef | this_Decimal_1= ruleDecimal | ( () ( (lv_value_3_0= RULE_INT ) ) ) )
            {
            // InternalHelloWeb.g:943:2: (this_ValueRef_0= ruleValueRef | this_Decimal_1= ruleDecimal | ( () ( (lv_value_3_0= RULE_INT ) ) ) )
            int alt15=3;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==RULE_ID) ) {
                alt15=1;
            }
            else if ( (LA15_0==RULE_INT) ) {
                int LA15_2 = input.LA(2);

                if ( (LA15_2==29) ) {
                    alt15=2;
                }
                else if ( (LA15_2==EOF||LA15_2==25||(LA15_2>=34 && LA15_2<=39)) ) {
                    alt15=3;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 15, 2, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }
            switch (alt15) {
                case 1 :
                    // InternalHelloWeb.g:944:3: this_ValueRef_0= ruleValueRef
                    {

                    			newCompositeNode(grammarAccess.getComparisonValueAccess().getValueRefParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_ValueRef_0=ruleValueRef();

                    state._fsp--;


                    			current = this_ValueRef_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalHelloWeb.g:953:3: this_Decimal_1= ruleDecimal
                    {

                    			newCompositeNode(grammarAccess.getComparisonValueAccess().getDecimalParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_Decimal_1=ruleDecimal();

                    state._fsp--;


                    			current = this_Decimal_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalHelloWeb.g:962:3: ( () ( (lv_value_3_0= RULE_INT ) ) )
                    {
                    // InternalHelloWeb.g:962:3: ( () ( (lv_value_3_0= RULE_INT ) ) )
                    // InternalHelloWeb.g:963:4: () ( (lv_value_3_0= RULE_INT ) )
                    {
                    // InternalHelloWeb.g:963:4: ()
                    // InternalHelloWeb.g:964:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getComparisonValueAccess().getComparisonValueAction_2_0(),
                    						current);
                    				

                    }

                    // InternalHelloWeb.g:970:4: ( (lv_value_3_0= RULE_INT ) )
                    // InternalHelloWeb.g:971:5: (lv_value_3_0= RULE_INT )
                    {
                    // InternalHelloWeb.g:971:5: (lv_value_3_0= RULE_INT )
                    // InternalHelloWeb.g:972:6: lv_value_3_0= RULE_INT
                    {
                    lv_value_3_0=(Token)match(input,RULE_INT,FOLLOW_2); 

                    						newLeafNode(lv_value_3_0, grammarAccess.getComparisonValueAccess().getValueINTTerminalRuleCall_2_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getComparisonValueRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"value",
                    							lv_value_3_0,
                    							"org.eclipse.xtext.common.Terminals.INT");
                    					

                    }


                    }


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
    // $ANTLR end "ruleComparisonValue"


    // $ANTLR start "entryRuleValueRef"
    // InternalHelloWeb.g:993:1: entryRuleValueRef returns [EObject current=null] : iv_ruleValueRef= ruleValueRef EOF ;
    public final EObject entryRuleValueRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleValueRef = null;


        try {
            // InternalHelloWeb.g:993:49: (iv_ruleValueRef= ruleValueRef EOF )
            // InternalHelloWeb.g:994:2: iv_ruleValueRef= ruleValueRef EOF
            {
             newCompositeNode(grammarAccess.getValueRefRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleValueRef=ruleValueRef();

            state._fsp--;

             current =iv_ruleValueRef; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleValueRef"


    // $ANTLR start "ruleValueRef"
    // InternalHelloWeb.g:1000:1: ruleValueRef returns [EObject current=null] : ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' )? ( (lv_out_2_0= RULE_ID ) ) ) ;
    public final EObject ruleValueRef() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_out_2_0=null;


        	enterRule();

        try {
            // InternalHelloWeb.g:1006:2: ( ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' )? ( (lv_out_2_0= RULE_ID ) ) ) )
            // InternalHelloWeb.g:1007:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' )? ( (lv_out_2_0= RULE_ID ) ) )
            {
            // InternalHelloWeb.g:1007:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' )? ( (lv_out_2_0= RULE_ID ) ) )
            // InternalHelloWeb.g:1008:3: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' )? ( (lv_out_2_0= RULE_ID ) )
            {
            // InternalHelloWeb.g:1008:3: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==RULE_ID) ) {
                int LA16_1 = input.LA(2);

                if ( (LA16_1==29) ) {
                    alt16=1;
                }
            }
            switch (alt16) {
                case 1 :
                    // InternalHelloWeb.g:1009:4: ( (otherlv_0= RULE_ID ) ) otherlv_1= '.'
                    {
                    // InternalHelloWeb.g:1009:4: ( (otherlv_0= RULE_ID ) )
                    // InternalHelloWeb.g:1010:5: (otherlv_0= RULE_ID )
                    {
                    // InternalHelloWeb.g:1010:5: (otherlv_0= RULE_ID )
                    // InternalHelloWeb.g:1011:6: otherlv_0= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getValueRefRule());
                    						}
                    					
                    otherlv_0=(Token)match(input,RULE_ID,FOLLOW_25); 

                    						newLeafNode(otherlv_0, grammarAccess.getValueRefAccess().getSensorInstantiationSensorInstantiationCrossReference_0_0_0());
                    					

                    }


                    }

                    otherlv_1=(Token)match(input,29,FOLLOW_4); 

                    				newLeafNode(otherlv_1, grammarAccess.getValueRefAccess().getFullStopKeyword_0_1());
                    			

                    }
                    break;

            }

            // InternalHelloWeb.g:1027:3: ( (lv_out_2_0= RULE_ID ) )
            // InternalHelloWeb.g:1028:4: (lv_out_2_0= RULE_ID )
            {
            // InternalHelloWeb.g:1028:4: (lv_out_2_0= RULE_ID )
            // InternalHelloWeb.g:1029:5: lv_out_2_0= RULE_ID
            {
            lv_out_2_0=(Token)match(input,RULE_ID,FOLLOW_2); 

            					newLeafNode(lv_out_2_0, grammarAccess.getValueRefAccess().getOutIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getValueRefRule());
            					}
            					setWithLastConsumed(
            						current,
            						"out",
            						lv_out_2_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

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
    // $ANTLR end "ruleValueRef"


    // $ANTLR start "entryRuleOutput"
    // InternalHelloWeb.g:1049:1: entryRuleOutput returns [EObject current=null] : iv_ruleOutput= ruleOutput EOF ;
    public final EObject entryRuleOutput() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOutput = null;


        try {
            // InternalHelloWeb.g:1049:47: (iv_ruleOutput= ruleOutput EOF )
            // InternalHelloWeb.g:1050:2: iv_ruleOutput= ruleOutput EOF
            {
             newCompositeNode(grammarAccess.getOutputRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleOutput=ruleOutput();

            state._fsp--;

             current =iv_ruleOutput; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleOutput"


    // $ANTLR start "ruleOutput"
    // InternalHelloWeb.g:1056:1: ruleOutput returns [EObject current=null] : ( (lv_name_0_0= RULE_ID ) ) ;
    public final EObject ruleOutput() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;


        	enterRule();

        try {
            // InternalHelloWeb.g:1062:2: ( ( (lv_name_0_0= RULE_ID ) ) )
            // InternalHelloWeb.g:1063:2: ( (lv_name_0_0= RULE_ID ) )
            {
            // InternalHelloWeb.g:1063:2: ( (lv_name_0_0= RULE_ID ) )
            // InternalHelloWeb.g:1064:3: (lv_name_0_0= RULE_ID )
            {
            // InternalHelloWeb.g:1064:3: (lv_name_0_0= RULE_ID )
            // InternalHelloWeb.g:1065:4: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_2); 

            				newLeafNode(lv_name_0_0, grammarAccess.getOutputAccess().getNameIDTerminalRuleCall_0());
            			

            				if (current==null) {
            					current = createModelElement(grammarAccess.getOutputRule());
            				}
            				setWithLastConsumed(
            					current,
            					"name",
            					lv_name_0_0,
            					"org.eclipse.xtext.common.Terminals.ID");
            			

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
    // $ANTLR end "ruleOutput"


    // $ANTLR start "entryRulePin"
    // InternalHelloWeb.g:1084:1: entryRulePin returns [EObject current=null] : iv_rulePin= rulePin EOF ;
    public final EObject entryRulePin() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePin = null;


        try {
            // InternalHelloWeb.g:1084:44: (iv_rulePin= rulePin EOF )
            // InternalHelloWeb.g:1085:2: iv_rulePin= rulePin EOF
            {
             newCompositeNode(grammarAccess.getPinRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePin=rulePin();

            state._fsp--;

             current =iv_rulePin; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRulePin"


    // $ANTLR start "rulePin"
    // InternalHelloWeb.g:1091:1: rulePin returns [EObject current=null] : ( (lv_name_0_0= RULE_ID ) ) ;
    public final EObject rulePin() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;


        	enterRule();

        try {
            // InternalHelloWeb.g:1097:2: ( ( (lv_name_0_0= RULE_ID ) ) )
            // InternalHelloWeb.g:1098:2: ( (lv_name_0_0= RULE_ID ) )
            {
            // InternalHelloWeb.g:1098:2: ( (lv_name_0_0= RULE_ID ) )
            // InternalHelloWeb.g:1099:3: (lv_name_0_0= RULE_ID )
            {
            // InternalHelloWeb.g:1099:3: (lv_name_0_0= RULE_ID )
            // InternalHelloWeb.g:1100:4: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_2); 

            				newLeafNode(lv_name_0_0, grammarAccess.getPinAccess().getNameIDTerminalRuleCall_0());
            			

            				if (current==null) {
            					current = createModelElement(grammarAccess.getPinRule());
            				}
            				setWithLastConsumed(
            					current,
            					"name",
            					lv_name_0_0,
            					"org.eclipse.xtext.common.Terminals.ID");
            			

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
    // $ANTLR end "rulePin"


    // $ANTLR start "entryRuleSensorUnit"
    // InternalHelloWeb.g:1119:1: entryRuleSensorUnit returns [EObject current=null] : iv_ruleSensorUnit= ruleSensorUnit EOF ;
    public final EObject entryRuleSensorUnit() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSensorUnit = null;


        try {
            // InternalHelloWeb.g:1119:51: (iv_ruleSensorUnit= ruleSensorUnit EOF )
            // InternalHelloWeb.g:1120:2: iv_ruleSensorUnit= ruleSensorUnit EOF
            {
             newCompositeNode(grammarAccess.getSensorUnitRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSensorUnit=ruleSensorUnit();

            state._fsp--;

             current =iv_ruleSensorUnit; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleSensorUnit"


    // $ANTLR start "ruleSensorUnit"
    // InternalHelloWeb.g:1126:1: ruleSensorUnit returns [EObject current=null] : ( (lv_value_0_0= RULE_ID ) ) ;
    public final EObject ruleSensorUnit() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;


        	enterRule();

        try {
            // InternalHelloWeb.g:1132:2: ( ( (lv_value_0_0= RULE_ID ) ) )
            // InternalHelloWeb.g:1133:2: ( (lv_value_0_0= RULE_ID ) )
            {
            // InternalHelloWeb.g:1133:2: ( (lv_value_0_0= RULE_ID ) )
            // InternalHelloWeb.g:1134:3: (lv_value_0_0= RULE_ID )
            {
            // InternalHelloWeb.g:1134:3: (lv_value_0_0= RULE_ID )
            // InternalHelloWeb.g:1135:4: lv_value_0_0= RULE_ID
            {
            lv_value_0_0=(Token)match(input,RULE_ID,FOLLOW_2); 

            				newLeafNode(lv_value_0_0, grammarAccess.getSensorUnitAccess().getValueIDTerminalRuleCall_0());
            			

            				if (current==null) {
            					current = createModelElement(grammarAccess.getSensorUnitRule());
            				}
            				setWithLastConsumed(
            					current,
            					"value",
            					lv_value_0_0,
            					"org.eclipse.xtext.common.Terminals.ID");
            			

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
    // $ANTLR end "ruleSensorUnit"


    // $ANTLR start "entryRuleTimeUnit"
    // InternalHelloWeb.g:1154:1: entryRuleTimeUnit returns [String current=null] : iv_ruleTimeUnit= ruleTimeUnit EOF ;
    public final String entryRuleTimeUnit() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleTimeUnit = null;


        try {
            // InternalHelloWeb.g:1154:48: (iv_ruleTimeUnit= ruleTimeUnit EOF )
            // InternalHelloWeb.g:1155:2: iv_ruleTimeUnit= ruleTimeUnit EOF
            {
             newCompositeNode(grammarAccess.getTimeUnitRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTimeUnit=ruleTimeUnit();

            state._fsp--;

             current =iv_ruleTimeUnit.getText(); 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleTimeUnit"


    // $ANTLR start "ruleTimeUnit"
    // InternalHelloWeb.g:1161:1: ruleTimeUnit returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_INT_0= RULE_INT (kw= 's' | kw= 'm' | kw= 'h' | kw= 'd' ) ) ;
    public final AntlrDatatypeRuleToken ruleTimeUnit() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_0=null;
        Token kw=null;


        	enterRule();

        try {
            // InternalHelloWeb.g:1167:2: ( (this_INT_0= RULE_INT (kw= 's' | kw= 'm' | kw= 'h' | kw= 'd' ) ) )
            // InternalHelloWeb.g:1168:2: (this_INT_0= RULE_INT (kw= 's' | kw= 'm' | kw= 'h' | kw= 'd' ) )
            {
            // InternalHelloWeb.g:1168:2: (this_INT_0= RULE_INT (kw= 's' | kw= 'm' | kw= 'h' | kw= 'd' ) )
            // InternalHelloWeb.g:1169:3: this_INT_0= RULE_INT (kw= 's' | kw= 'm' | kw= 'h' | kw= 'd' )
            {
            this_INT_0=(Token)match(input,RULE_INT,FOLLOW_26); 

            			current.merge(this_INT_0);
            		

            			newLeafNode(this_INT_0, grammarAccess.getTimeUnitAccess().getINTTerminalRuleCall_0());
            		
            // InternalHelloWeb.g:1176:3: (kw= 's' | kw= 'm' | kw= 'h' | kw= 'd' )
            int alt17=4;
            switch ( input.LA(1) ) {
            case 30:
                {
                alt17=1;
                }
                break;
            case 31:
                {
                alt17=2;
                }
                break;
            case 32:
                {
                alt17=3;
                }
                break;
            case 33:
                {
                alt17=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }

            switch (alt17) {
                case 1 :
                    // InternalHelloWeb.g:1177:4: kw= 's'
                    {
                    kw=(Token)match(input,30,FOLLOW_2); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getTimeUnitAccess().getSKeyword_1_0());
                    			

                    }
                    break;
                case 2 :
                    // InternalHelloWeb.g:1183:4: kw= 'm'
                    {
                    kw=(Token)match(input,31,FOLLOW_2); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getTimeUnitAccess().getMKeyword_1_1());
                    			

                    }
                    break;
                case 3 :
                    // InternalHelloWeb.g:1189:4: kw= 'h'
                    {
                    kw=(Token)match(input,32,FOLLOW_2); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getTimeUnitAccess().getHKeyword_1_2());
                    			

                    }
                    break;
                case 4 :
                    // InternalHelloWeb.g:1195:4: kw= 'd'
                    {
                    kw=(Token)match(input,33,FOLLOW_2); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getTimeUnitAccess().getDKeyword_1_3());
                    			

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
    // $ANTLR end "ruleTimeUnit"


    // $ANTLR start "entryRuleDecimal"
    // InternalHelloWeb.g:1205:1: entryRuleDecimal returns [EObject current=null] : iv_ruleDecimal= ruleDecimal EOF ;
    public final EObject entryRuleDecimal() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDecimal = null;


        try {
            // InternalHelloWeb.g:1205:48: (iv_ruleDecimal= ruleDecimal EOF )
            // InternalHelloWeb.g:1206:2: iv_ruleDecimal= ruleDecimal EOF
            {
             newCompositeNode(grammarAccess.getDecimalRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDecimal=ruleDecimal();

            state._fsp--;

             current =iv_ruleDecimal; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleDecimal"


    // $ANTLR start "ruleDecimal"
    // InternalHelloWeb.g:1212:1: ruleDecimal returns [EObject current=null] : ( ( (lv_left_0_0= RULE_INT ) ) otherlv_1= '.' ( (lv_right_2_0= RULE_INT ) ) ) ;
    public final EObject ruleDecimal() throws RecognitionException {
        EObject current = null;

        Token lv_left_0_0=null;
        Token otherlv_1=null;
        Token lv_right_2_0=null;


        	enterRule();

        try {
            // InternalHelloWeb.g:1218:2: ( ( ( (lv_left_0_0= RULE_INT ) ) otherlv_1= '.' ( (lv_right_2_0= RULE_INT ) ) ) )
            // InternalHelloWeb.g:1219:2: ( ( (lv_left_0_0= RULE_INT ) ) otherlv_1= '.' ( (lv_right_2_0= RULE_INT ) ) )
            {
            // InternalHelloWeb.g:1219:2: ( ( (lv_left_0_0= RULE_INT ) ) otherlv_1= '.' ( (lv_right_2_0= RULE_INT ) ) )
            // InternalHelloWeb.g:1220:3: ( (lv_left_0_0= RULE_INT ) ) otherlv_1= '.' ( (lv_right_2_0= RULE_INT ) )
            {
            // InternalHelloWeb.g:1220:3: ( (lv_left_0_0= RULE_INT ) )
            // InternalHelloWeb.g:1221:4: (lv_left_0_0= RULE_INT )
            {
            // InternalHelloWeb.g:1221:4: (lv_left_0_0= RULE_INT )
            // InternalHelloWeb.g:1222:5: lv_left_0_0= RULE_INT
            {
            lv_left_0_0=(Token)match(input,RULE_INT,FOLLOW_25); 

            					newLeafNode(lv_left_0_0, grammarAccess.getDecimalAccess().getLeftINTTerminalRuleCall_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDecimalRule());
            					}
            					setWithLastConsumed(
            						current,
            						"left",
            						lv_left_0_0,
            						"org.eclipse.xtext.common.Terminals.INT");
            				

            }


            }

            otherlv_1=(Token)match(input,29,FOLLOW_12); 

            			newLeafNode(otherlv_1, grammarAccess.getDecimalAccess().getFullStopKeyword_1());
            		
            // InternalHelloWeb.g:1242:3: ( (lv_right_2_0= RULE_INT ) )
            // InternalHelloWeb.g:1243:4: (lv_right_2_0= RULE_INT )
            {
            // InternalHelloWeb.g:1243:4: (lv_right_2_0= RULE_INT )
            // InternalHelloWeb.g:1244:5: lv_right_2_0= RULE_INT
            {
            lv_right_2_0=(Token)match(input,RULE_INT,FOLLOW_2); 

            					newLeafNode(lv_right_2_0, grammarAccess.getDecimalAccess().getRightINTTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDecimalRule());
            					}
            					setWithLastConsumed(
            						current,
            						"right",
            						lv_right_2_0,
            						"org.eclipse.xtext.common.Terminals.INT");
            				

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
    // $ANTLR end "ruleDecimal"


    // $ANTLR start "entryRuleComparisonOperator"
    // InternalHelloWeb.g:1264:1: entryRuleComparisonOperator returns [String current=null] : iv_ruleComparisonOperator= ruleComparisonOperator EOF ;
    public final String entryRuleComparisonOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleComparisonOperator = null;


        try {
            // InternalHelloWeb.g:1264:58: (iv_ruleComparisonOperator= ruleComparisonOperator EOF )
            // InternalHelloWeb.g:1265:2: iv_ruleComparisonOperator= ruleComparisonOperator EOF
            {
             newCompositeNode(grammarAccess.getComparisonOperatorRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleComparisonOperator=ruleComparisonOperator();

            state._fsp--;

             current =iv_ruleComparisonOperator.getText(); 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleComparisonOperator"


    // $ANTLR start "ruleComparisonOperator"
    // InternalHelloWeb.g:1271:1: ruleComparisonOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '>' | kw= '<' | kw= '>=' | kw= '<=' | kw= '=' | kw= '!=' ) ;
    public final AntlrDatatypeRuleToken ruleComparisonOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalHelloWeb.g:1277:2: ( (kw= '>' | kw= '<' | kw= '>=' | kw= '<=' | kw= '=' | kw= '!=' ) )
            // InternalHelloWeb.g:1278:2: (kw= '>' | kw= '<' | kw= '>=' | kw= '<=' | kw= '=' | kw= '!=' )
            {
            // InternalHelloWeb.g:1278:2: (kw= '>' | kw= '<' | kw= '>=' | kw= '<=' | kw= '=' | kw= '!=' )
            int alt18=6;
            switch ( input.LA(1) ) {
            case 34:
                {
                alt18=1;
                }
                break;
            case 35:
                {
                alt18=2;
                }
                break;
            case 36:
                {
                alt18=3;
                }
                break;
            case 37:
                {
                alt18=4;
                }
                break;
            case 38:
                {
                alt18=5;
                }
                break;
            case 39:
                {
                alt18=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;
            }

            switch (alt18) {
                case 1 :
                    // InternalHelloWeb.g:1279:3: kw= '>'
                    {
                    kw=(Token)match(input,34,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getComparisonOperatorAccess().getGreaterThanSignKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalHelloWeb.g:1285:3: kw= '<'
                    {
                    kw=(Token)match(input,35,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getComparisonOperatorAccess().getLessThanSignKeyword_1());
                    		

                    }
                    break;
                case 3 :
                    // InternalHelloWeb.g:1291:3: kw= '>='
                    {
                    kw=(Token)match(input,36,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getComparisonOperatorAccess().getGreaterThanSignEqualsSignKeyword_2());
                    		

                    }
                    break;
                case 4 :
                    // InternalHelloWeb.g:1297:3: kw= '<='
                    {
                    kw=(Token)match(input,37,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getComparisonOperatorAccess().getLessThanSignEqualsSignKeyword_3());
                    		

                    }
                    break;
                case 5 :
                    // InternalHelloWeb.g:1303:3: kw= '='
                    {
                    kw=(Token)match(input,38,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getComparisonOperatorAccess().getEqualsSignKeyword_4());
                    		

                    }
                    break;
                case 6 :
                    // InternalHelloWeb.g:1309:3: kw= '!='
                    {
                    kw=(Token)match(input,39,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getComparisonOperatorAccess().getExclamationMarkEqualsSignKeyword_5());
                    		

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
    // $ANTLR end "ruleComparisonOperator"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000080802L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x000000000000C000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000024000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000044000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000740010L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000640000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000440000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000001844000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000001040000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000001000030L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000000840000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x000000001C000000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x000000FC00000000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x00000003C0000000L});

}