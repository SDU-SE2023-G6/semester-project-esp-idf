package org.example.helloweb.ide.contentassist.antlr.internal;

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.DFA;
import org.example.helloweb.services.HelloWebGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalHelloWebParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_INT", "RULE_ID", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'AND'", "'OR'", "'NOT'", "'s'", "'m'", "'h'", "'d'", "'>'", "'<'", "'>='", "'<='", "'='", "'!='", "'sensor'", "'{'", "'units:'", "'reader:'", "'pins:'", "'out:'", "'}'", "','", "'deviceType'", "'batchRatePolicy:'", "'batchSizePolicy:'", "'heartBeatPolicy:'", "'samplingRate:'", "'('", "')'", "'.'"
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
    public static final int RULE_ID=5;
    public static final int RULE_WS=9;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=4;
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

    	public void setGrammarAccess(HelloWebGrammarAccess grammarAccess) {
    		this.grammarAccess = grammarAccess;
    	}

    	@Override
    	protected Grammar getGrammar() {
    		return grammarAccess.getGrammar();
    	}

    	@Override
    	protected String getValueForTokenName(String tokenName) {
    		return tokenName;
    	}



    // $ANTLR start "entryRuleSensorConfig"
    // InternalHelloWeb.g:53:1: entryRuleSensorConfig : ruleSensorConfig EOF ;
    public final void entryRuleSensorConfig() throws RecognitionException {
        try {
            // InternalHelloWeb.g:54:1: ( ruleSensorConfig EOF )
            // InternalHelloWeb.g:55:1: ruleSensorConfig EOF
            {
             before(grammarAccess.getSensorConfigRule()); 
            pushFollow(FOLLOW_1);
            ruleSensorConfig();

            state._fsp--;

             after(grammarAccess.getSensorConfigRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleSensorConfig"


    // $ANTLR start "ruleSensorConfig"
    // InternalHelloWeb.g:62:1: ruleSensorConfig : ( ( rule__SensorConfig__Alternatives )* ) ;
    public final void ruleSensorConfig() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:66:2: ( ( ( rule__SensorConfig__Alternatives )* ) )
            // InternalHelloWeb.g:67:2: ( ( rule__SensorConfig__Alternatives )* )
            {
            // InternalHelloWeb.g:67:2: ( ( rule__SensorConfig__Alternatives )* )
            // InternalHelloWeb.g:68:3: ( rule__SensorConfig__Alternatives )*
            {
             before(grammarAccess.getSensorConfigAccess().getAlternatives()); 
            // InternalHelloWeb.g:69:3: ( rule__SensorConfig__Alternatives )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==24||LA1_0==32) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalHelloWeb.g:69:4: rule__SensorConfig__Alternatives
            	    {
            	    pushFollow(FOLLOW_3);
            	    rule__SensorConfig__Alternatives();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

             after(grammarAccess.getSensorConfigAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleSensorConfig"


    // $ANTLR start "entryRuleSensor"
    // InternalHelloWeb.g:78:1: entryRuleSensor : ruleSensor EOF ;
    public final void entryRuleSensor() throws RecognitionException {
        try {
            // InternalHelloWeb.g:79:1: ( ruleSensor EOF )
            // InternalHelloWeb.g:80:1: ruleSensor EOF
            {
             before(grammarAccess.getSensorRule()); 
            pushFollow(FOLLOW_1);
            ruleSensor();

            state._fsp--;

             after(grammarAccess.getSensorRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleSensor"


    // $ANTLR start "ruleSensor"
    // InternalHelloWeb.g:87:1: ruleSensor : ( ( rule__Sensor__Group__0 ) ) ;
    public final void ruleSensor() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:91:2: ( ( ( rule__Sensor__Group__0 ) ) )
            // InternalHelloWeb.g:92:2: ( ( rule__Sensor__Group__0 ) )
            {
            // InternalHelloWeb.g:92:2: ( ( rule__Sensor__Group__0 ) )
            // InternalHelloWeb.g:93:3: ( rule__Sensor__Group__0 )
            {
             before(grammarAccess.getSensorAccess().getGroup()); 
            // InternalHelloWeb.g:94:3: ( rule__Sensor__Group__0 )
            // InternalHelloWeb.g:94:4: rule__Sensor__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Sensor__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getSensorAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleSensor"


    // $ANTLR start "entryRuleDeviceType"
    // InternalHelloWeb.g:103:1: entryRuleDeviceType : ruleDeviceType EOF ;
    public final void entryRuleDeviceType() throws RecognitionException {
        try {
            // InternalHelloWeb.g:104:1: ( ruleDeviceType EOF )
            // InternalHelloWeb.g:105:1: ruleDeviceType EOF
            {
             before(grammarAccess.getDeviceTypeRule()); 
            pushFollow(FOLLOW_1);
            ruleDeviceType();

            state._fsp--;

             after(grammarAccess.getDeviceTypeRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleDeviceType"


    // $ANTLR start "ruleDeviceType"
    // InternalHelloWeb.g:112:1: ruleDeviceType : ( ( rule__DeviceType__Group__0 ) ) ;
    public final void ruleDeviceType() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:116:2: ( ( ( rule__DeviceType__Group__0 ) ) )
            // InternalHelloWeb.g:117:2: ( ( rule__DeviceType__Group__0 ) )
            {
            // InternalHelloWeb.g:117:2: ( ( rule__DeviceType__Group__0 ) )
            // InternalHelloWeb.g:118:3: ( rule__DeviceType__Group__0 )
            {
             before(grammarAccess.getDeviceTypeAccess().getGroup()); 
            // InternalHelloWeb.g:119:3: ( rule__DeviceType__Group__0 )
            // InternalHelloWeb.g:119:4: rule__DeviceType__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__DeviceType__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getDeviceTypeAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleDeviceType"


    // $ANTLR start "entryRuleSensorInstantiation"
    // InternalHelloWeb.g:128:1: entryRuleSensorInstantiation : ruleSensorInstantiation EOF ;
    public final void entryRuleSensorInstantiation() throws RecognitionException {
        try {
            // InternalHelloWeb.g:129:1: ( ruleSensorInstantiation EOF )
            // InternalHelloWeb.g:130:1: ruleSensorInstantiation EOF
            {
             before(grammarAccess.getSensorInstantiationRule()); 
            pushFollow(FOLLOW_1);
            ruleSensorInstantiation();

            state._fsp--;

             after(grammarAccess.getSensorInstantiationRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleSensorInstantiation"


    // $ANTLR start "ruleSensorInstantiation"
    // InternalHelloWeb.g:137:1: ruleSensorInstantiation : ( ( rule__SensorInstantiation__Group__0 ) ) ;
    public final void ruleSensorInstantiation() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:141:2: ( ( ( rule__SensorInstantiation__Group__0 ) ) )
            // InternalHelloWeb.g:142:2: ( ( rule__SensorInstantiation__Group__0 ) )
            {
            // InternalHelloWeb.g:142:2: ( ( rule__SensorInstantiation__Group__0 ) )
            // InternalHelloWeb.g:143:3: ( rule__SensorInstantiation__Group__0 )
            {
             before(grammarAccess.getSensorInstantiationAccess().getGroup()); 
            // InternalHelloWeb.g:144:3: ( rule__SensorInstantiation__Group__0 )
            // InternalHelloWeb.g:144:4: rule__SensorInstantiation__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__SensorInstantiation__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getSensorInstantiationAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleSensorInstantiation"


    // $ANTLR start "entryRuleConstraint"
    // InternalHelloWeb.g:153:1: entryRuleConstraint : ruleConstraint EOF ;
    public final void entryRuleConstraint() throws RecognitionException {
        try {
            // InternalHelloWeb.g:154:1: ( ruleConstraint EOF )
            // InternalHelloWeb.g:155:1: ruleConstraint EOF
            {
             before(grammarAccess.getConstraintRule()); 
            pushFollow(FOLLOW_1);
            ruleConstraint();

            state._fsp--;

             after(grammarAccess.getConstraintRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleConstraint"


    // $ANTLR start "ruleConstraint"
    // InternalHelloWeb.g:162:1: ruleConstraint : ( ( rule__Constraint__Group__0 ) ) ;
    public final void ruleConstraint() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:166:2: ( ( ( rule__Constraint__Group__0 ) ) )
            // InternalHelloWeb.g:167:2: ( ( rule__Constraint__Group__0 ) )
            {
            // InternalHelloWeb.g:167:2: ( ( rule__Constraint__Group__0 ) )
            // InternalHelloWeb.g:168:3: ( rule__Constraint__Group__0 )
            {
             before(grammarAccess.getConstraintAccess().getGroup()); 
            // InternalHelloWeb.g:169:3: ( rule__Constraint__Group__0 )
            // InternalHelloWeb.g:169:4: rule__Constraint__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Constraint__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getConstraintAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleConstraint"


    // $ANTLR start "entryRuleCondition"
    // InternalHelloWeb.g:178:1: entryRuleCondition : ruleCondition EOF ;
    public final void entryRuleCondition() throws RecognitionException {
        try {
            // InternalHelloWeb.g:179:1: ( ruleCondition EOF )
            // InternalHelloWeb.g:180:1: ruleCondition EOF
            {
             before(grammarAccess.getConditionRule()); 
            pushFollow(FOLLOW_1);
            ruleCondition();

            state._fsp--;

             after(grammarAccess.getConditionRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleCondition"


    // $ANTLR start "ruleCondition"
    // InternalHelloWeb.g:187:1: ruleCondition : ( ( rule__Condition__Alternatives ) ) ;
    public final void ruleCondition() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:191:2: ( ( ( rule__Condition__Alternatives ) ) )
            // InternalHelloWeb.g:192:2: ( ( rule__Condition__Alternatives ) )
            {
            // InternalHelloWeb.g:192:2: ( ( rule__Condition__Alternatives ) )
            // InternalHelloWeb.g:193:3: ( rule__Condition__Alternatives )
            {
             before(grammarAccess.getConditionAccess().getAlternatives()); 
            // InternalHelloWeb.g:194:3: ( rule__Condition__Alternatives )
            // InternalHelloWeb.g:194:4: rule__Condition__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__Condition__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getConditionAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleCondition"


    // $ANTLR start "entryRuleNestedLogicalCondition"
    // InternalHelloWeb.g:203:1: entryRuleNestedLogicalCondition : ruleNestedLogicalCondition EOF ;
    public final void entryRuleNestedLogicalCondition() throws RecognitionException {
        try {
            // InternalHelloWeb.g:204:1: ( ruleNestedLogicalCondition EOF )
            // InternalHelloWeb.g:205:1: ruleNestedLogicalCondition EOF
            {
             before(grammarAccess.getNestedLogicalConditionRule()); 
            pushFollow(FOLLOW_1);
            ruleNestedLogicalCondition();

            state._fsp--;

             after(grammarAccess.getNestedLogicalConditionRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleNestedLogicalCondition"


    // $ANTLR start "ruleNestedLogicalCondition"
    // InternalHelloWeb.g:212:1: ruleNestedLogicalCondition : ( ( rule__NestedLogicalCondition__Group__0 ) ) ;
    public final void ruleNestedLogicalCondition() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:216:2: ( ( ( rule__NestedLogicalCondition__Group__0 ) ) )
            // InternalHelloWeb.g:217:2: ( ( rule__NestedLogicalCondition__Group__0 ) )
            {
            // InternalHelloWeb.g:217:2: ( ( rule__NestedLogicalCondition__Group__0 ) )
            // InternalHelloWeb.g:218:3: ( rule__NestedLogicalCondition__Group__0 )
            {
             before(grammarAccess.getNestedLogicalConditionAccess().getGroup()); 
            // InternalHelloWeb.g:219:3: ( rule__NestedLogicalCondition__Group__0 )
            // InternalHelloWeb.g:219:4: rule__NestedLogicalCondition__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__NestedLogicalCondition__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getNestedLogicalConditionAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleNestedLogicalCondition"


    // $ANTLR start "entryRuleComparison"
    // InternalHelloWeb.g:228:1: entryRuleComparison : ruleComparison EOF ;
    public final void entryRuleComparison() throws RecognitionException {
        try {
            // InternalHelloWeb.g:229:1: ( ruleComparison EOF )
            // InternalHelloWeb.g:230:1: ruleComparison EOF
            {
             before(grammarAccess.getComparisonRule()); 
            pushFollow(FOLLOW_1);
            ruleComparison();

            state._fsp--;

             after(grammarAccess.getComparisonRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleComparison"


    // $ANTLR start "ruleComparison"
    // InternalHelloWeb.g:237:1: ruleComparison : ( ( rule__Comparison__Group__0 ) ) ;
    public final void ruleComparison() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:241:2: ( ( ( rule__Comparison__Group__0 ) ) )
            // InternalHelloWeb.g:242:2: ( ( rule__Comparison__Group__0 ) )
            {
            // InternalHelloWeb.g:242:2: ( ( rule__Comparison__Group__0 ) )
            // InternalHelloWeb.g:243:3: ( rule__Comparison__Group__0 )
            {
             before(grammarAccess.getComparisonAccess().getGroup()); 
            // InternalHelloWeb.g:244:3: ( rule__Comparison__Group__0 )
            // InternalHelloWeb.g:244:4: rule__Comparison__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Comparison__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getComparisonAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleComparison"


    // $ANTLR start "entryRuleComparisonValue"
    // InternalHelloWeb.g:253:1: entryRuleComparisonValue : ruleComparisonValue EOF ;
    public final void entryRuleComparisonValue() throws RecognitionException {
        try {
            // InternalHelloWeb.g:254:1: ( ruleComparisonValue EOF )
            // InternalHelloWeb.g:255:1: ruleComparisonValue EOF
            {
             before(grammarAccess.getComparisonValueRule()); 
            pushFollow(FOLLOW_1);
            ruleComparisonValue();

            state._fsp--;

             after(grammarAccess.getComparisonValueRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleComparisonValue"


    // $ANTLR start "ruleComparisonValue"
    // InternalHelloWeb.g:262:1: ruleComparisonValue : ( ( rule__ComparisonValue__Alternatives ) ) ;
    public final void ruleComparisonValue() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:266:2: ( ( ( rule__ComparisonValue__Alternatives ) ) )
            // InternalHelloWeb.g:267:2: ( ( rule__ComparisonValue__Alternatives ) )
            {
            // InternalHelloWeb.g:267:2: ( ( rule__ComparisonValue__Alternatives ) )
            // InternalHelloWeb.g:268:3: ( rule__ComparisonValue__Alternatives )
            {
             before(grammarAccess.getComparisonValueAccess().getAlternatives()); 
            // InternalHelloWeb.g:269:3: ( rule__ComparisonValue__Alternatives )
            // InternalHelloWeb.g:269:4: rule__ComparisonValue__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__ComparisonValue__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getComparisonValueAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleComparisonValue"


    // $ANTLR start "entryRuleValueRef"
    // InternalHelloWeb.g:278:1: entryRuleValueRef : ruleValueRef EOF ;
    public final void entryRuleValueRef() throws RecognitionException {
        try {
            // InternalHelloWeb.g:279:1: ( ruleValueRef EOF )
            // InternalHelloWeb.g:280:1: ruleValueRef EOF
            {
             before(grammarAccess.getValueRefRule()); 
            pushFollow(FOLLOW_1);
            ruleValueRef();

            state._fsp--;

             after(grammarAccess.getValueRefRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleValueRef"


    // $ANTLR start "ruleValueRef"
    // InternalHelloWeb.g:287:1: ruleValueRef : ( ( rule__ValueRef__Group__0 ) ) ;
    public final void ruleValueRef() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:291:2: ( ( ( rule__ValueRef__Group__0 ) ) )
            // InternalHelloWeb.g:292:2: ( ( rule__ValueRef__Group__0 ) )
            {
            // InternalHelloWeb.g:292:2: ( ( rule__ValueRef__Group__0 ) )
            // InternalHelloWeb.g:293:3: ( rule__ValueRef__Group__0 )
            {
             before(grammarAccess.getValueRefAccess().getGroup()); 
            // InternalHelloWeb.g:294:3: ( rule__ValueRef__Group__0 )
            // InternalHelloWeb.g:294:4: rule__ValueRef__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__ValueRef__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getValueRefAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleValueRef"


    // $ANTLR start "entryRuleOutput"
    // InternalHelloWeb.g:303:1: entryRuleOutput : ruleOutput EOF ;
    public final void entryRuleOutput() throws RecognitionException {
        try {
            // InternalHelloWeb.g:304:1: ( ruleOutput EOF )
            // InternalHelloWeb.g:305:1: ruleOutput EOF
            {
             before(grammarAccess.getOutputRule()); 
            pushFollow(FOLLOW_1);
            ruleOutput();

            state._fsp--;

             after(grammarAccess.getOutputRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleOutput"


    // $ANTLR start "ruleOutput"
    // InternalHelloWeb.g:312:1: ruleOutput : ( ( rule__Output__NameAssignment ) ) ;
    public final void ruleOutput() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:316:2: ( ( ( rule__Output__NameAssignment ) ) )
            // InternalHelloWeb.g:317:2: ( ( rule__Output__NameAssignment ) )
            {
            // InternalHelloWeb.g:317:2: ( ( rule__Output__NameAssignment ) )
            // InternalHelloWeb.g:318:3: ( rule__Output__NameAssignment )
            {
             before(grammarAccess.getOutputAccess().getNameAssignment()); 
            // InternalHelloWeb.g:319:3: ( rule__Output__NameAssignment )
            // InternalHelloWeb.g:319:4: rule__Output__NameAssignment
            {
            pushFollow(FOLLOW_2);
            rule__Output__NameAssignment();

            state._fsp--;


            }

             after(grammarAccess.getOutputAccess().getNameAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleOutput"


    // $ANTLR start "entryRulePin"
    // InternalHelloWeb.g:328:1: entryRulePin : rulePin EOF ;
    public final void entryRulePin() throws RecognitionException {
        try {
            // InternalHelloWeb.g:329:1: ( rulePin EOF )
            // InternalHelloWeb.g:330:1: rulePin EOF
            {
             before(grammarAccess.getPinRule()); 
            pushFollow(FOLLOW_1);
            rulePin();

            state._fsp--;

             after(grammarAccess.getPinRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRulePin"


    // $ANTLR start "rulePin"
    // InternalHelloWeb.g:337:1: rulePin : ( ( rule__Pin__NameAssignment ) ) ;
    public final void rulePin() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:341:2: ( ( ( rule__Pin__NameAssignment ) ) )
            // InternalHelloWeb.g:342:2: ( ( rule__Pin__NameAssignment ) )
            {
            // InternalHelloWeb.g:342:2: ( ( rule__Pin__NameAssignment ) )
            // InternalHelloWeb.g:343:3: ( rule__Pin__NameAssignment )
            {
             before(grammarAccess.getPinAccess().getNameAssignment()); 
            // InternalHelloWeb.g:344:3: ( rule__Pin__NameAssignment )
            // InternalHelloWeb.g:344:4: rule__Pin__NameAssignment
            {
            pushFollow(FOLLOW_2);
            rule__Pin__NameAssignment();

            state._fsp--;


            }

             after(grammarAccess.getPinAccess().getNameAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePin"


    // $ANTLR start "entryRuleSensorUnit"
    // InternalHelloWeb.g:353:1: entryRuleSensorUnit : ruleSensorUnit EOF ;
    public final void entryRuleSensorUnit() throws RecognitionException {
        try {
            // InternalHelloWeb.g:354:1: ( ruleSensorUnit EOF )
            // InternalHelloWeb.g:355:1: ruleSensorUnit EOF
            {
             before(grammarAccess.getSensorUnitRule()); 
            pushFollow(FOLLOW_1);
            ruleSensorUnit();

            state._fsp--;

             after(grammarAccess.getSensorUnitRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleSensorUnit"


    // $ANTLR start "ruleSensorUnit"
    // InternalHelloWeb.g:362:1: ruleSensorUnit : ( ( rule__SensorUnit__ValueAssignment ) ) ;
    public final void ruleSensorUnit() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:366:2: ( ( ( rule__SensorUnit__ValueAssignment ) ) )
            // InternalHelloWeb.g:367:2: ( ( rule__SensorUnit__ValueAssignment ) )
            {
            // InternalHelloWeb.g:367:2: ( ( rule__SensorUnit__ValueAssignment ) )
            // InternalHelloWeb.g:368:3: ( rule__SensorUnit__ValueAssignment )
            {
             before(grammarAccess.getSensorUnitAccess().getValueAssignment()); 
            // InternalHelloWeb.g:369:3: ( rule__SensorUnit__ValueAssignment )
            // InternalHelloWeb.g:369:4: rule__SensorUnit__ValueAssignment
            {
            pushFollow(FOLLOW_2);
            rule__SensorUnit__ValueAssignment();

            state._fsp--;


            }

             after(grammarAccess.getSensorUnitAccess().getValueAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleSensorUnit"


    // $ANTLR start "entryRuleTimeUnit"
    // InternalHelloWeb.g:378:1: entryRuleTimeUnit : ruleTimeUnit EOF ;
    public final void entryRuleTimeUnit() throws RecognitionException {
        try {
            // InternalHelloWeb.g:379:1: ( ruleTimeUnit EOF )
            // InternalHelloWeb.g:380:1: ruleTimeUnit EOF
            {
             before(grammarAccess.getTimeUnitRule()); 
            pushFollow(FOLLOW_1);
            ruleTimeUnit();

            state._fsp--;

             after(grammarAccess.getTimeUnitRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleTimeUnit"


    // $ANTLR start "ruleTimeUnit"
    // InternalHelloWeb.g:387:1: ruleTimeUnit : ( ( rule__TimeUnit__Group__0 ) ) ;
    public final void ruleTimeUnit() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:391:2: ( ( ( rule__TimeUnit__Group__0 ) ) )
            // InternalHelloWeb.g:392:2: ( ( rule__TimeUnit__Group__0 ) )
            {
            // InternalHelloWeb.g:392:2: ( ( rule__TimeUnit__Group__0 ) )
            // InternalHelloWeb.g:393:3: ( rule__TimeUnit__Group__0 )
            {
             before(grammarAccess.getTimeUnitAccess().getGroup()); 
            // InternalHelloWeb.g:394:3: ( rule__TimeUnit__Group__0 )
            // InternalHelloWeb.g:394:4: rule__TimeUnit__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__TimeUnit__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getTimeUnitAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleTimeUnit"


    // $ANTLR start "entryRuleDecimal"
    // InternalHelloWeb.g:403:1: entryRuleDecimal : ruleDecimal EOF ;
    public final void entryRuleDecimal() throws RecognitionException {
        try {
            // InternalHelloWeb.g:404:1: ( ruleDecimal EOF )
            // InternalHelloWeb.g:405:1: ruleDecimal EOF
            {
             before(grammarAccess.getDecimalRule()); 
            pushFollow(FOLLOW_1);
            ruleDecimal();

            state._fsp--;

             after(grammarAccess.getDecimalRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleDecimal"


    // $ANTLR start "ruleDecimal"
    // InternalHelloWeb.g:412:1: ruleDecimal : ( ( rule__Decimal__Group__0 ) ) ;
    public final void ruleDecimal() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:416:2: ( ( ( rule__Decimal__Group__0 ) ) )
            // InternalHelloWeb.g:417:2: ( ( rule__Decimal__Group__0 ) )
            {
            // InternalHelloWeb.g:417:2: ( ( rule__Decimal__Group__0 ) )
            // InternalHelloWeb.g:418:3: ( rule__Decimal__Group__0 )
            {
             before(grammarAccess.getDecimalAccess().getGroup()); 
            // InternalHelloWeb.g:419:3: ( rule__Decimal__Group__0 )
            // InternalHelloWeb.g:419:4: rule__Decimal__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Decimal__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getDecimalAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleDecimal"


    // $ANTLR start "entryRuleComparisonOperator"
    // InternalHelloWeb.g:428:1: entryRuleComparisonOperator : ruleComparisonOperator EOF ;
    public final void entryRuleComparisonOperator() throws RecognitionException {
        try {
            // InternalHelloWeb.g:429:1: ( ruleComparisonOperator EOF )
            // InternalHelloWeb.g:430:1: ruleComparisonOperator EOF
            {
             before(grammarAccess.getComparisonOperatorRule()); 
            pushFollow(FOLLOW_1);
            ruleComparisonOperator();

            state._fsp--;

             after(grammarAccess.getComparisonOperatorRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleComparisonOperator"


    // $ANTLR start "ruleComparisonOperator"
    // InternalHelloWeb.g:437:1: ruleComparisonOperator : ( ( rule__ComparisonOperator__Alternatives ) ) ;
    public final void ruleComparisonOperator() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:441:2: ( ( ( rule__ComparisonOperator__Alternatives ) ) )
            // InternalHelloWeb.g:442:2: ( ( rule__ComparisonOperator__Alternatives ) )
            {
            // InternalHelloWeb.g:442:2: ( ( rule__ComparisonOperator__Alternatives ) )
            // InternalHelloWeb.g:443:3: ( rule__ComparisonOperator__Alternatives )
            {
             before(grammarAccess.getComparisonOperatorAccess().getAlternatives()); 
            // InternalHelloWeb.g:444:3: ( rule__ComparisonOperator__Alternatives )
            // InternalHelloWeb.g:444:4: rule__ComparisonOperator__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__ComparisonOperator__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getComparisonOperatorAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleComparisonOperator"


    // $ANTLR start "rule__SensorConfig__Alternatives"
    // InternalHelloWeb.g:452:1: rule__SensorConfig__Alternatives : ( ( ( rule__SensorConfig__SensorsAssignment_0 ) ) | ( ( rule__SensorConfig__DeviceTypesAssignment_1 ) ) );
    public final void rule__SensorConfig__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:456:1: ( ( ( rule__SensorConfig__SensorsAssignment_0 ) ) | ( ( rule__SensorConfig__DeviceTypesAssignment_1 ) ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==24) ) {
                alt2=1;
            }
            else if ( (LA2_0==32) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // InternalHelloWeb.g:457:2: ( ( rule__SensorConfig__SensorsAssignment_0 ) )
                    {
                    // InternalHelloWeb.g:457:2: ( ( rule__SensorConfig__SensorsAssignment_0 ) )
                    // InternalHelloWeb.g:458:3: ( rule__SensorConfig__SensorsAssignment_0 )
                    {
                     before(grammarAccess.getSensorConfigAccess().getSensorsAssignment_0()); 
                    // InternalHelloWeb.g:459:3: ( rule__SensorConfig__SensorsAssignment_0 )
                    // InternalHelloWeb.g:459:4: rule__SensorConfig__SensorsAssignment_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__SensorConfig__SensorsAssignment_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getSensorConfigAccess().getSensorsAssignment_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalHelloWeb.g:463:2: ( ( rule__SensorConfig__DeviceTypesAssignment_1 ) )
                    {
                    // InternalHelloWeb.g:463:2: ( ( rule__SensorConfig__DeviceTypesAssignment_1 ) )
                    // InternalHelloWeb.g:464:3: ( rule__SensorConfig__DeviceTypesAssignment_1 )
                    {
                     before(grammarAccess.getSensorConfigAccess().getDeviceTypesAssignment_1()); 
                    // InternalHelloWeb.g:465:3: ( rule__SensorConfig__DeviceTypesAssignment_1 )
                    // InternalHelloWeb.g:465:4: rule__SensorConfig__DeviceTypesAssignment_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__SensorConfig__DeviceTypesAssignment_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getSensorConfigAccess().getDeviceTypesAssignment_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SensorConfig__Alternatives"


    // $ANTLR start "rule__Condition__Alternatives"
    // InternalHelloWeb.g:473:1: rule__Condition__Alternatives : ( ( ruleComparison ) | ( ruleNestedLogicalCondition ) );
    public final void rule__Condition__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:477:1: ( ( ruleComparison ) | ( ruleNestedLogicalCondition ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( ((LA3_0>=RULE_INT && LA3_0<=RULE_ID)) ) {
                alt3=1;
            }
            else if ( (LA3_0==37) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // InternalHelloWeb.g:478:2: ( ruleComparison )
                    {
                    // InternalHelloWeb.g:478:2: ( ruleComparison )
                    // InternalHelloWeb.g:479:3: ruleComparison
                    {
                     before(grammarAccess.getConditionAccess().getComparisonParserRuleCall_0()); 
                    pushFollow(FOLLOW_2);
                    ruleComparison();

                    state._fsp--;

                     after(grammarAccess.getConditionAccess().getComparisonParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalHelloWeb.g:484:2: ( ruleNestedLogicalCondition )
                    {
                    // InternalHelloWeb.g:484:2: ( ruleNestedLogicalCondition )
                    // InternalHelloWeb.g:485:3: ruleNestedLogicalCondition
                    {
                     before(grammarAccess.getConditionAccess().getNestedLogicalConditionParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
                    ruleNestedLogicalCondition();

                    state._fsp--;

                     after(grammarAccess.getConditionAccess().getNestedLogicalConditionParserRuleCall_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Condition__Alternatives"


    // $ANTLR start "rule__NestedLogicalCondition__OperatorAlternatives_3_0"
    // InternalHelloWeb.g:494:1: rule__NestedLogicalCondition__OperatorAlternatives_3_0 : ( ( 'AND' ) | ( 'OR' ) | ( 'NOT' ) );
    public final void rule__NestedLogicalCondition__OperatorAlternatives_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:498:1: ( ( 'AND' ) | ( 'OR' ) | ( 'NOT' ) )
            int alt4=3;
            switch ( input.LA(1) ) {
            case 11:
                {
                alt4=1;
                }
                break;
            case 12:
                {
                alt4=2;
                }
                break;
            case 13:
                {
                alt4=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }

            switch (alt4) {
                case 1 :
                    // InternalHelloWeb.g:499:2: ( 'AND' )
                    {
                    // InternalHelloWeb.g:499:2: ( 'AND' )
                    // InternalHelloWeb.g:500:3: 'AND'
                    {
                     before(grammarAccess.getNestedLogicalConditionAccess().getOperatorANDKeyword_3_0_0()); 
                    match(input,11,FOLLOW_2); 
                     after(grammarAccess.getNestedLogicalConditionAccess().getOperatorANDKeyword_3_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalHelloWeb.g:505:2: ( 'OR' )
                    {
                    // InternalHelloWeb.g:505:2: ( 'OR' )
                    // InternalHelloWeb.g:506:3: 'OR'
                    {
                     before(grammarAccess.getNestedLogicalConditionAccess().getOperatorORKeyword_3_0_1()); 
                    match(input,12,FOLLOW_2); 
                     after(grammarAccess.getNestedLogicalConditionAccess().getOperatorORKeyword_3_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalHelloWeb.g:511:2: ( 'NOT' )
                    {
                    // InternalHelloWeb.g:511:2: ( 'NOT' )
                    // InternalHelloWeb.g:512:3: 'NOT'
                    {
                     before(grammarAccess.getNestedLogicalConditionAccess().getOperatorNOTKeyword_3_0_2()); 
                    match(input,13,FOLLOW_2); 
                     after(grammarAccess.getNestedLogicalConditionAccess().getOperatorNOTKeyword_3_0_2()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NestedLogicalCondition__OperatorAlternatives_3_0"


    // $ANTLR start "rule__ComparisonValue__Alternatives"
    // InternalHelloWeb.g:521:1: rule__ComparisonValue__Alternatives : ( ( ruleValueRef ) | ( ruleDecimal ) | ( ( rule__ComparisonValue__Group_2__0 ) ) );
    public final void rule__ComparisonValue__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:525:1: ( ( ruleValueRef ) | ( ruleDecimal ) | ( ( rule__ComparisonValue__Group_2__0 ) ) )
            int alt5=3;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==RULE_ID) ) {
                alt5=1;
            }
            else if ( (LA5_0==RULE_INT) ) {
                int LA5_2 = input.LA(2);

                if ( (LA5_2==39) ) {
                    alt5=2;
                }
                else if ( (LA5_2==EOF||(LA5_2>=18 && LA5_2<=23)||LA5_2==38) ) {
                    alt5=3;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 5, 2, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // InternalHelloWeb.g:526:2: ( ruleValueRef )
                    {
                    // InternalHelloWeb.g:526:2: ( ruleValueRef )
                    // InternalHelloWeb.g:527:3: ruleValueRef
                    {
                     before(grammarAccess.getComparisonValueAccess().getValueRefParserRuleCall_0()); 
                    pushFollow(FOLLOW_2);
                    ruleValueRef();

                    state._fsp--;

                     after(grammarAccess.getComparisonValueAccess().getValueRefParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalHelloWeb.g:532:2: ( ruleDecimal )
                    {
                    // InternalHelloWeb.g:532:2: ( ruleDecimal )
                    // InternalHelloWeb.g:533:3: ruleDecimal
                    {
                     before(grammarAccess.getComparisonValueAccess().getDecimalParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
                    ruleDecimal();

                    state._fsp--;

                     after(grammarAccess.getComparisonValueAccess().getDecimalParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalHelloWeb.g:538:2: ( ( rule__ComparisonValue__Group_2__0 ) )
                    {
                    // InternalHelloWeb.g:538:2: ( ( rule__ComparisonValue__Group_2__0 ) )
                    // InternalHelloWeb.g:539:3: ( rule__ComparisonValue__Group_2__0 )
                    {
                     before(grammarAccess.getComparisonValueAccess().getGroup_2()); 
                    // InternalHelloWeb.g:540:3: ( rule__ComparisonValue__Group_2__0 )
                    // InternalHelloWeb.g:540:4: rule__ComparisonValue__Group_2__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__ComparisonValue__Group_2__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getComparisonValueAccess().getGroup_2()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ComparisonValue__Alternatives"


    // $ANTLR start "rule__TimeUnit__Alternatives_1"
    // InternalHelloWeb.g:548:1: rule__TimeUnit__Alternatives_1 : ( ( 's' ) | ( 'm' ) | ( 'h' ) | ( 'd' ) );
    public final void rule__TimeUnit__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:552:1: ( ( 's' ) | ( 'm' ) | ( 'h' ) | ( 'd' ) )
            int alt6=4;
            switch ( input.LA(1) ) {
            case 14:
                {
                alt6=1;
                }
                break;
            case 15:
                {
                alt6=2;
                }
                break;
            case 16:
                {
                alt6=3;
                }
                break;
            case 17:
                {
                alt6=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }

            switch (alt6) {
                case 1 :
                    // InternalHelloWeb.g:553:2: ( 's' )
                    {
                    // InternalHelloWeb.g:553:2: ( 's' )
                    // InternalHelloWeb.g:554:3: 's'
                    {
                     before(grammarAccess.getTimeUnitAccess().getSKeyword_1_0()); 
                    match(input,14,FOLLOW_2); 
                     after(grammarAccess.getTimeUnitAccess().getSKeyword_1_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalHelloWeb.g:559:2: ( 'm' )
                    {
                    // InternalHelloWeb.g:559:2: ( 'm' )
                    // InternalHelloWeb.g:560:3: 'm'
                    {
                     before(grammarAccess.getTimeUnitAccess().getMKeyword_1_1()); 
                    match(input,15,FOLLOW_2); 
                     after(grammarAccess.getTimeUnitAccess().getMKeyword_1_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalHelloWeb.g:565:2: ( 'h' )
                    {
                    // InternalHelloWeb.g:565:2: ( 'h' )
                    // InternalHelloWeb.g:566:3: 'h'
                    {
                     before(grammarAccess.getTimeUnitAccess().getHKeyword_1_2()); 
                    match(input,16,FOLLOW_2); 
                     after(grammarAccess.getTimeUnitAccess().getHKeyword_1_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalHelloWeb.g:571:2: ( 'd' )
                    {
                    // InternalHelloWeb.g:571:2: ( 'd' )
                    // InternalHelloWeb.g:572:3: 'd'
                    {
                     before(grammarAccess.getTimeUnitAccess().getDKeyword_1_3()); 
                    match(input,17,FOLLOW_2); 
                     after(grammarAccess.getTimeUnitAccess().getDKeyword_1_3()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TimeUnit__Alternatives_1"


    // $ANTLR start "rule__ComparisonOperator__Alternatives"
    // InternalHelloWeb.g:581:1: rule__ComparisonOperator__Alternatives : ( ( '>' ) | ( '<' ) | ( '>=' ) | ( '<=' ) | ( '=' ) | ( '!=' ) );
    public final void rule__ComparisonOperator__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:585:1: ( ( '>' ) | ( '<' ) | ( '>=' ) | ( '<=' ) | ( '=' ) | ( '!=' ) )
            int alt7=6;
            switch ( input.LA(1) ) {
            case 18:
                {
                alt7=1;
                }
                break;
            case 19:
                {
                alt7=2;
                }
                break;
            case 20:
                {
                alt7=3;
                }
                break;
            case 21:
                {
                alt7=4;
                }
                break;
            case 22:
                {
                alt7=5;
                }
                break;
            case 23:
                {
                alt7=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }

            switch (alt7) {
                case 1 :
                    // InternalHelloWeb.g:586:2: ( '>' )
                    {
                    // InternalHelloWeb.g:586:2: ( '>' )
                    // InternalHelloWeb.g:587:3: '>'
                    {
                     before(grammarAccess.getComparisonOperatorAccess().getGreaterThanSignKeyword_0()); 
                    match(input,18,FOLLOW_2); 
                     after(grammarAccess.getComparisonOperatorAccess().getGreaterThanSignKeyword_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalHelloWeb.g:592:2: ( '<' )
                    {
                    // InternalHelloWeb.g:592:2: ( '<' )
                    // InternalHelloWeb.g:593:3: '<'
                    {
                     before(grammarAccess.getComparisonOperatorAccess().getLessThanSignKeyword_1()); 
                    match(input,19,FOLLOW_2); 
                     after(grammarAccess.getComparisonOperatorAccess().getLessThanSignKeyword_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalHelloWeb.g:598:2: ( '>=' )
                    {
                    // InternalHelloWeb.g:598:2: ( '>=' )
                    // InternalHelloWeb.g:599:3: '>='
                    {
                     before(grammarAccess.getComparisonOperatorAccess().getGreaterThanSignEqualsSignKeyword_2()); 
                    match(input,20,FOLLOW_2); 
                     after(grammarAccess.getComparisonOperatorAccess().getGreaterThanSignEqualsSignKeyword_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalHelloWeb.g:604:2: ( '<=' )
                    {
                    // InternalHelloWeb.g:604:2: ( '<=' )
                    // InternalHelloWeb.g:605:3: '<='
                    {
                     before(grammarAccess.getComparisonOperatorAccess().getLessThanSignEqualsSignKeyword_3()); 
                    match(input,21,FOLLOW_2); 
                     after(grammarAccess.getComparisonOperatorAccess().getLessThanSignEqualsSignKeyword_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalHelloWeb.g:610:2: ( '=' )
                    {
                    // InternalHelloWeb.g:610:2: ( '=' )
                    // InternalHelloWeb.g:611:3: '='
                    {
                     before(grammarAccess.getComparisonOperatorAccess().getEqualsSignKeyword_4()); 
                    match(input,22,FOLLOW_2); 
                     after(grammarAccess.getComparisonOperatorAccess().getEqualsSignKeyword_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalHelloWeb.g:616:2: ( '!=' )
                    {
                    // InternalHelloWeb.g:616:2: ( '!=' )
                    // InternalHelloWeb.g:617:3: '!='
                    {
                     before(grammarAccess.getComparisonOperatorAccess().getExclamationMarkEqualsSignKeyword_5()); 
                    match(input,23,FOLLOW_2); 
                     after(grammarAccess.getComparisonOperatorAccess().getExclamationMarkEqualsSignKeyword_5()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ComparisonOperator__Alternatives"


    // $ANTLR start "rule__Sensor__Group__0"
    // InternalHelloWeb.g:626:1: rule__Sensor__Group__0 : rule__Sensor__Group__0__Impl rule__Sensor__Group__1 ;
    public final void rule__Sensor__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:630:1: ( rule__Sensor__Group__0__Impl rule__Sensor__Group__1 )
            // InternalHelloWeb.g:631:2: rule__Sensor__Group__0__Impl rule__Sensor__Group__1
            {
            pushFollow(FOLLOW_4);
            rule__Sensor__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Sensor__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sensor__Group__0"


    // $ANTLR start "rule__Sensor__Group__0__Impl"
    // InternalHelloWeb.g:638:1: rule__Sensor__Group__0__Impl : ( 'sensor' ) ;
    public final void rule__Sensor__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:642:1: ( ( 'sensor' ) )
            // InternalHelloWeb.g:643:1: ( 'sensor' )
            {
            // InternalHelloWeb.g:643:1: ( 'sensor' )
            // InternalHelloWeb.g:644:2: 'sensor'
            {
             before(grammarAccess.getSensorAccess().getSensorKeyword_0()); 
            match(input,24,FOLLOW_2); 
             after(grammarAccess.getSensorAccess().getSensorKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sensor__Group__0__Impl"


    // $ANTLR start "rule__Sensor__Group__1"
    // InternalHelloWeb.g:653:1: rule__Sensor__Group__1 : rule__Sensor__Group__1__Impl rule__Sensor__Group__2 ;
    public final void rule__Sensor__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:657:1: ( rule__Sensor__Group__1__Impl rule__Sensor__Group__2 )
            // InternalHelloWeb.g:658:2: rule__Sensor__Group__1__Impl rule__Sensor__Group__2
            {
            pushFollow(FOLLOW_5);
            rule__Sensor__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Sensor__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sensor__Group__1"


    // $ANTLR start "rule__Sensor__Group__1__Impl"
    // InternalHelloWeb.g:665:1: rule__Sensor__Group__1__Impl : ( ( rule__Sensor__NameAssignment_1 ) ) ;
    public final void rule__Sensor__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:669:1: ( ( ( rule__Sensor__NameAssignment_1 ) ) )
            // InternalHelloWeb.g:670:1: ( ( rule__Sensor__NameAssignment_1 ) )
            {
            // InternalHelloWeb.g:670:1: ( ( rule__Sensor__NameAssignment_1 ) )
            // InternalHelloWeb.g:671:2: ( rule__Sensor__NameAssignment_1 )
            {
             before(grammarAccess.getSensorAccess().getNameAssignment_1()); 
            // InternalHelloWeb.g:672:2: ( rule__Sensor__NameAssignment_1 )
            // InternalHelloWeb.g:672:3: rule__Sensor__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Sensor__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getSensorAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sensor__Group__1__Impl"


    // $ANTLR start "rule__Sensor__Group__2"
    // InternalHelloWeb.g:680:1: rule__Sensor__Group__2 : rule__Sensor__Group__2__Impl rule__Sensor__Group__3 ;
    public final void rule__Sensor__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:684:1: ( rule__Sensor__Group__2__Impl rule__Sensor__Group__3 )
            // InternalHelloWeb.g:685:2: rule__Sensor__Group__2__Impl rule__Sensor__Group__3
            {
            pushFollow(FOLLOW_6);
            rule__Sensor__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Sensor__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sensor__Group__2"


    // $ANTLR start "rule__Sensor__Group__2__Impl"
    // InternalHelloWeb.g:692:1: rule__Sensor__Group__2__Impl : ( '{' ) ;
    public final void rule__Sensor__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:696:1: ( ( '{' ) )
            // InternalHelloWeb.g:697:1: ( '{' )
            {
            // InternalHelloWeb.g:697:1: ( '{' )
            // InternalHelloWeb.g:698:2: '{'
            {
             before(grammarAccess.getSensorAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,25,FOLLOW_2); 
             after(grammarAccess.getSensorAccess().getLeftCurlyBracketKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sensor__Group__2__Impl"


    // $ANTLR start "rule__Sensor__Group__3"
    // InternalHelloWeb.g:707:1: rule__Sensor__Group__3 : rule__Sensor__Group__3__Impl rule__Sensor__Group__4 ;
    public final void rule__Sensor__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:711:1: ( rule__Sensor__Group__3__Impl rule__Sensor__Group__4 )
            // InternalHelloWeb.g:712:2: rule__Sensor__Group__3__Impl rule__Sensor__Group__4
            {
            pushFollow(FOLLOW_4);
            rule__Sensor__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Sensor__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sensor__Group__3"


    // $ANTLR start "rule__Sensor__Group__3__Impl"
    // InternalHelloWeb.g:719:1: rule__Sensor__Group__3__Impl : ( 'units:' ) ;
    public final void rule__Sensor__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:723:1: ( ( 'units:' ) )
            // InternalHelloWeb.g:724:1: ( 'units:' )
            {
            // InternalHelloWeb.g:724:1: ( 'units:' )
            // InternalHelloWeb.g:725:2: 'units:'
            {
             before(grammarAccess.getSensorAccess().getUnitsKeyword_3()); 
            match(input,26,FOLLOW_2); 
             after(grammarAccess.getSensorAccess().getUnitsKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sensor__Group__3__Impl"


    // $ANTLR start "rule__Sensor__Group__4"
    // InternalHelloWeb.g:734:1: rule__Sensor__Group__4 : rule__Sensor__Group__4__Impl rule__Sensor__Group__5 ;
    public final void rule__Sensor__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:738:1: ( rule__Sensor__Group__4__Impl rule__Sensor__Group__5 )
            // InternalHelloWeb.g:739:2: rule__Sensor__Group__4__Impl rule__Sensor__Group__5
            {
            pushFollow(FOLLOW_7);
            rule__Sensor__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Sensor__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sensor__Group__4"


    // $ANTLR start "rule__Sensor__Group__4__Impl"
    // InternalHelloWeb.g:746:1: rule__Sensor__Group__4__Impl : ( ( rule__Sensor__UnitsAssignment_4 ) ) ;
    public final void rule__Sensor__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:750:1: ( ( ( rule__Sensor__UnitsAssignment_4 ) ) )
            // InternalHelloWeb.g:751:1: ( ( rule__Sensor__UnitsAssignment_4 ) )
            {
            // InternalHelloWeb.g:751:1: ( ( rule__Sensor__UnitsAssignment_4 ) )
            // InternalHelloWeb.g:752:2: ( rule__Sensor__UnitsAssignment_4 )
            {
             before(grammarAccess.getSensorAccess().getUnitsAssignment_4()); 
            // InternalHelloWeb.g:753:2: ( rule__Sensor__UnitsAssignment_4 )
            // InternalHelloWeb.g:753:3: rule__Sensor__UnitsAssignment_4
            {
            pushFollow(FOLLOW_2);
            rule__Sensor__UnitsAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getSensorAccess().getUnitsAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sensor__Group__4__Impl"


    // $ANTLR start "rule__Sensor__Group__5"
    // InternalHelloWeb.g:761:1: rule__Sensor__Group__5 : rule__Sensor__Group__5__Impl rule__Sensor__Group__6 ;
    public final void rule__Sensor__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:765:1: ( rule__Sensor__Group__5__Impl rule__Sensor__Group__6 )
            // InternalHelloWeb.g:766:2: rule__Sensor__Group__5__Impl rule__Sensor__Group__6
            {
            pushFollow(FOLLOW_7);
            rule__Sensor__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Sensor__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sensor__Group__5"


    // $ANTLR start "rule__Sensor__Group__5__Impl"
    // InternalHelloWeb.g:773:1: rule__Sensor__Group__5__Impl : ( ( rule__Sensor__Group_5__0 )* ) ;
    public final void rule__Sensor__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:777:1: ( ( ( rule__Sensor__Group_5__0 )* ) )
            // InternalHelloWeb.g:778:1: ( ( rule__Sensor__Group_5__0 )* )
            {
            // InternalHelloWeb.g:778:1: ( ( rule__Sensor__Group_5__0 )* )
            // InternalHelloWeb.g:779:2: ( rule__Sensor__Group_5__0 )*
            {
             before(grammarAccess.getSensorAccess().getGroup_5()); 
            // InternalHelloWeb.g:780:2: ( rule__Sensor__Group_5__0 )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==31) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // InternalHelloWeb.g:780:3: rule__Sensor__Group_5__0
            	    {
            	    pushFollow(FOLLOW_8);
            	    rule__Sensor__Group_5__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

             after(grammarAccess.getSensorAccess().getGroup_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sensor__Group__5__Impl"


    // $ANTLR start "rule__Sensor__Group__6"
    // InternalHelloWeb.g:788:1: rule__Sensor__Group__6 : rule__Sensor__Group__6__Impl rule__Sensor__Group__7 ;
    public final void rule__Sensor__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:792:1: ( rule__Sensor__Group__6__Impl rule__Sensor__Group__7 )
            // InternalHelloWeb.g:793:2: rule__Sensor__Group__6__Impl rule__Sensor__Group__7
            {
            pushFollow(FOLLOW_4);
            rule__Sensor__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Sensor__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sensor__Group__6"


    // $ANTLR start "rule__Sensor__Group__6__Impl"
    // InternalHelloWeb.g:800:1: rule__Sensor__Group__6__Impl : ( 'reader:' ) ;
    public final void rule__Sensor__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:804:1: ( ( 'reader:' ) )
            // InternalHelloWeb.g:805:1: ( 'reader:' )
            {
            // InternalHelloWeb.g:805:1: ( 'reader:' )
            // InternalHelloWeb.g:806:2: 'reader:'
            {
             before(grammarAccess.getSensorAccess().getReaderKeyword_6()); 
            match(input,27,FOLLOW_2); 
             after(grammarAccess.getSensorAccess().getReaderKeyword_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sensor__Group__6__Impl"


    // $ANTLR start "rule__Sensor__Group__7"
    // InternalHelloWeb.g:815:1: rule__Sensor__Group__7 : rule__Sensor__Group__7__Impl rule__Sensor__Group__8 ;
    public final void rule__Sensor__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:819:1: ( rule__Sensor__Group__7__Impl rule__Sensor__Group__8 )
            // InternalHelloWeb.g:820:2: rule__Sensor__Group__7__Impl rule__Sensor__Group__8
            {
            pushFollow(FOLLOW_9);
            rule__Sensor__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Sensor__Group__8();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sensor__Group__7"


    // $ANTLR start "rule__Sensor__Group__7__Impl"
    // InternalHelloWeb.g:827:1: rule__Sensor__Group__7__Impl : ( ( rule__Sensor__ReaderAssignment_7 ) ) ;
    public final void rule__Sensor__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:831:1: ( ( ( rule__Sensor__ReaderAssignment_7 ) ) )
            // InternalHelloWeb.g:832:1: ( ( rule__Sensor__ReaderAssignment_7 ) )
            {
            // InternalHelloWeb.g:832:1: ( ( rule__Sensor__ReaderAssignment_7 ) )
            // InternalHelloWeb.g:833:2: ( rule__Sensor__ReaderAssignment_7 )
            {
             before(grammarAccess.getSensorAccess().getReaderAssignment_7()); 
            // InternalHelloWeb.g:834:2: ( rule__Sensor__ReaderAssignment_7 )
            // InternalHelloWeb.g:834:3: rule__Sensor__ReaderAssignment_7
            {
            pushFollow(FOLLOW_2);
            rule__Sensor__ReaderAssignment_7();

            state._fsp--;


            }

             after(grammarAccess.getSensorAccess().getReaderAssignment_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sensor__Group__7__Impl"


    // $ANTLR start "rule__Sensor__Group__8"
    // InternalHelloWeb.g:842:1: rule__Sensor__Group__8 : rule__Sensor__Group__8__Impl rule__Sensor__Group__9 ;
    public final void rule__Sensor__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:846:1: ( rule__Sensor__Group__8__Impl rule__Sensor__Group__9 )
            // InternalHelloWeb.g:847:2: rule__Sensor__Group__8__Impl rule__Sensor__Group__9
            {
            pushFollow(FOLLOW_4);
            rule__Sensor__Group__8__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Sensor__Group__9();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sensor__Group__8"


    // $ANTLR start "rule__Sensor__Group__8__Impl"
    // InternalHelloWeb.g:854:1: rule__Sensor__Group__8__Impl : ( 'pins:' ) ;
    public final void rule__Sensor__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:858:1: ( ( 'pins:' ) )
            // InternalHelloWeb.g:859:1: ( 'pins:' )
            {
            // InternalHelloWeb.g:859:1: ( 'pins:' )
            // InternalHelloWeb.g:860:2: 'pins:'
            {
             before(grammarAccess.getSensorAccess().getPinsKeyword_8()); 
            match(input,28,FOLLOW_2); 
             after(grammarAccess.getSensorAccess().getPinsKeyword_8()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sensor__Group__8__Impl"


    // $ANTLR start "rule__Sensor__Group__9"
    // InternalHelloWeb.g:869:1: rule__Sensor__Group__9 : rule__Sensor__Group__9__Impl rule__Sensor__Group__10 ;
    public final void rule__Sensor__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:873:1: ( rule__Sensor__Group__9__Impl rule__Sensor__Group__10 )
            // InternalHelloWeb.g:874:2: rule__Sensor__Group__9__Impl rule__Sensor__Group__10
            {
            pushFollow(FOLLOW_10);
            rule__Sensor__Group__9__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Sensor__Group__10();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sensor__Group__9"


    // $ANTLR start "rule__Sensor__Group__9__Impl"
    // InternalHelloWeb.g:881:1: rule__Sensor__Group__9__Impl : ( ( rule__Sensor__PinsAssignment_9 ) ) ;
    public final void rule__Sensor__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:885:1: ( ( ( rule__Sensor__PinsAssignment_9 ) ) )
            // InternalHelloWeb.g:886:1: ( ( rule__Sensor__PinsAssignment_9 ) )
            {
            // InternalHelloWeb.g:886:1: ( ( rule__Sensor__PinsAssignment_9 ) )
            // InternalHelloWeb.g:887:2: ( rule__Sensor__PinsAssignment_9 )
            {
             before(grammarAccess.getSensorAccess().getPinsAssignment_9()); 
            // InternalHelloWeb.g:888:2: ( rule__Sensor__PinsAssignment_9 )
            // InternalHelloWeb.g:888:3: rule__Sensor__PinsAssignment_9
            {
            pushFollow(FOLLOW_2);
            rule__Sensor__PinsAssignment_9();

            state._fsp--;


            }

             after(grammarAccess.getSensorAccess().getPinsAssignment_9()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sensor__Group__9__Impl"


    // $ANTLR start "rule__Sensor__Group__10"
    // InternalHelloWeb.g:896:1: rule__Sensor__Group__10 : rule__Sensor__Group__10__Impl rule__Sensor__Group__11 ;
    public final void rule__Sensor__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:900:1: ( rule__Sensor__Group__10__Impl rule__Sensor__Group__11 )
            // InternalHelloWeb.g:901:2: rule__Sensor__Group__10__Impl rule__Sensor__Group__11
            {
            pushFollow(FOLLOW_10);
            rule__Sensor__Group__10__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Sensor__Group__11();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sensor__Group__10"


    // $ANTLR start "rule__Sensor__Group__10__Impl"
    // InternalHelloWeb.g:908:1: rule__Sensor__Group__10__Impl : ( ( rule__Sensor__Group_10__0 )* ) ;
    public final void rule__Sensor__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:912:1: ( ( ( rule__Sensor__Group_10__0 )* ) )
            // InternalHelloWeb.g:913:1: ( ( rule__Sensor__Group_10__0 )* )
            {
            // InternalHelloWeb.g:913:1: ( ( rule__Sensor__Group_10__0 )* )
            // InternalHelloWeb.g:914:2: ( rule__Sensor__Group_10__0 )*
            {
             before(grammarAccess.getSensorAccess().getGroup_10()); 
            // InternalHelloWeb.g:915:2: ( rule__Sensor__Group_10__0 )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==31) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // InternalHelloWeb.g:915:3: rule__Sensor__Group_10__0
            	    {
            	    pushFollow(FOLLOW_8);
            	    rule__Sensor__Group_10__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);

             after(grammarAccess.getSensorAccess().getGroup_10()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sensor__Group__10__Impl"


    // $ANTLR start "rule__Sensor__Group__11"
    // InternalHelloWeb.g:923:1: rule__Sensor__Group__11 : rule__Sensor__Group__11__Impl rule__Sensor__Group__12 ;
    public final void rule__Sensor__Group__11() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:927:1: ( rule__Sensor__Group__11__Impl rule__Sensor__Group__12 )
            // InternalHelloWeb.g:928:2: rule__Sensor__Group__11__Impl rule__Sensor__Group__12
            {
            pushFollow(FOLLOW_4);
            rule__Sensor__Group__11__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Sensor__Group__12();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sensor__Group__11"


    // $ANTLR start "rule__Sensor__Group__11__Impl"
    // InternalHelloWeb.g:935:1: rule__Sensor__Group__11__Impl : ( 'out:' ) ;
    public final void rule__Sensor__Group__11__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:939:1: ( ( 'out:' ) )
            // InternalHelloWeb.g:940:1: ( 'out:' )
            {
            // InternalHelloWeb.g:940:1: ( 'out:' )
            // InternalHelloWeb.g:941:2: 'out:'
            {
             before(grammarAccess.getSensorAccess().getOutKeyword_11()); 
            match(input,29,FOLLOW_2); 
             after(grammarAccess.getSensorAccess().getOutKeyword_11()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sensor__Group__11__Impl"


    // $ANTLR start "rule__Sensor__Group__12"
    // InternalHelloWeb.g:950:1: rule__Sensor__Group__12 : rule__Sensor__Group__12__Impl rule__Sensor__Group__13 ;
    public final void rule__Sensor__Group__12() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:954:1: ( rule__Sensor__Group__12__Impl rule__Sensor__Group__13 )
            // InternalHelloWeb.g:955:2: rule__Sensor__Group__12__Impl rule__Sensor__Group__13
            {
            pushFollow(FOLLOW_11);
            rule__Sensor__Group__12__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Sensor__Group__13();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sensor__Group__12"


    // $ANTLR start "rule__Sensor__Group__12__Impl"
    // InternalHelloWeb.g:962:1: rule__Sensor__Group__12__Impl : ( ( rule__Sensor__OutAssignment_12 ) ) ;
    public final void rule__Sensor__Group__12__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:966:1: ( ( ( rule__Sensor__OutAssignment_12 ) ) )
            // InternalHelloWeb.g:967:1: ( ( rule__Sensor__OutAssignment_12 ) )
            {
            // InternalHelloWeb.g:967:1: ( ( rule__Sensor__OutAssignment_12 ) )
            // InternalHelloWeb.g:968:2: ( rule__Sensor__OutAssignment_12 )
            {
             before(grammarAccess.getSensorAccess().getOutAssignment_12()); 
            // InternalHelloWeb.g:969:2: ( rule__Sensor__OutAssignment_12 )
            // InternalHelloWeb.g:969:3: rule__Sensor__OutAssignment_12
            {
            pushFollow(FOLLOW_2);
            rule__Sensor__OutAssignment_12();

            state._fsp--;


            }

             after(grammarAccess.getSensorAccess().getOutAssignment_12()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sensor__Group__12__Impl"


    // $ANTLR start "rule__Sensor__Group__13"
    // InternalHelloWeb.g:977:1: rule__Sensor__Group__13 : rule__Sensor__Group__13__Impl rule__Sensor__Group__14 ;
    public final void rule__Sensor__Group__13() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:981:1: ( rule__Sensor__Group__13__Impl rule__Sensor__Group__14 )
            // InternalHelloWeb.g:982:2: rule__Sensor__Group__13__Impl rule__Sensor__Group__14
            {
            pushFollow(FOLLOW_11);
            rule__Sensor__Group__13__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Sensor__Group__14();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sensor__Group__13"


    // $ANTLR start "rule__Sensor__Group__13__Impl"
    // InternalHelloWeb.g:989:1: rule__Sensor__Group__13__Impl : ( ( rule__Sensor__Group_13__0 )* ) ;
    public final void rule__Sensor__Group__13__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:993:1: ( ( ( rule__Sensor__Group_13__0 )* ) )
            // InternalHelloWeb.g:994:1: ( ( rule__Sensor__Group_13__0 )* )
            {
            // InternalHelloWeb.g:994:1: ( ( rule__Sensor__Group_13__0 )* )
            // InternalHelloWeb.g:995:2: ( rule__Sensor__Group_13__0 )*
            {
             before(grammarAccess.getSensorAccess().getGroup_13()); 
            // InternalHelloWeb.g:996:2: ( rule__Sensor__Group_13__0 )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==31) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // InternalHelloWeb.g:996:3: rule__Sensor__Group_13__0
            	    {
            	    pushFollow(FOLLOW_8);
            	    rule__Sensor__Group_13__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);

             after(grammarAccess.getSensorAccess().getGroup_13()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sensor__Group__13__Impl"


    // $ANTLR start "rule__Sensor__Group__14"
    // InternalHelloWeb.g:1004:1: rule__Sensor__Group__14 : rule__Sensor__Group__14__Impl ;
    public final void rule__Sensor__Group__14() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:1008:1: ( rule__Sensor__Group__14__Impl )
            // InternalHelloWeb.g:1009:2: rule__Sensor__Group__14__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Sensor__Group__14__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sensor__Group__14"


    // $ANTLR start "rule__Sensor__Group__14__Impl"
    // InternalHelloWeb.g:1015:1: rule__Sensor__Group__14__Impl : ( '}' ) ;
    public final void rule__Sensor__Group__14__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:1019:1: ( ( '}' ) )
            // InternalHelloWeb.g:1020:1: ( '}' )
            {
            // InternalHelloWeb.g:1020:1: ( '}' )
            // InternalHelloWeb.g:1021:2: '}'
            {
             before(grammarAccess.getSensorAccess().getRightCurlyBracketKeyword_14()); 
            match(input,30,FOLLOW_2); 
             after(grammarAccess.getSensorAccess().getRightCurlyBracketKeyword_14()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sensor__Group__14__Impl"


    // $ANTLR start "rule__Sensor__Group_5__0"
    // InternalHelloWeb.g:1031:1: rule__Sensor__Group_5__0 : rule__Sensor__Group_5__0__Impl rule__Sensor__Group_5__1 ;
    public final void rule__Sensor__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:1035:1: ( rule__Sensor__Group_5__0__Impl rule__Sensor__Group_5__1 )
            // InternalHelloWeb.g:1036:2: rule__Sensor__Group_5__0__Impl rule__Sensor__Group_5__1
            {
            pushFollow(FOLLOW_4);
            rule__Sensor__Group_5__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Sensor__Group_5__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sensor__Group_5__0"


    // $ANTLR start "rule__Sensor__Group_5__0__Impl"
    // InternalHelloWeb.g:1043:1: rule__Sensor__Group_5__0__Impl : ( ',' ) ;
    public final void rule__Sensor__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:1047:1: ( ( ',' ) )
            // InternalHelloWeb.g:1048:1: ( ',' )
            {
            // InternalHelloWeb.g:1048:1: ( ',' )
            // InternalHelloWeb.g:1049:2: ','
            {
             before(grammarAccess.getSensorAccess().getCommaKeyword_5_0()); 
            match(input,31,FOLLOW_2); 
             after(grammarAccess.getSensorAccess().getCommaKeyword_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sensor__Group_5__0__Impl"


    // $ANTLR start "rule__Sensor__Group_5__1"
    // InternalHelloWeb.g:1058:1: rule__Sensor__Group_5__1 : rule__Sensor__Group_5__1__Impl ;
    public final void rule__Sensor__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:1062:1: ( rule__Sensor__Group_5__1__Impl )
            // InternalHelloWeb.g:1063:2: rule__Sensor__Group_5__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Sensor__Group_5__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sensor__Group_5__1"


    // $ANTLR start "rule__Sensor__Group_5__1__Impl"
    // InternalHelloWeb.g:1069:1: rule__Sensor__Group_5__1__Impl : ( ( rule__Sensor__UnitsAssignment_5_1 ) ) ;
    public final void rule__Sensor__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:1073:1: ( ( ( rule__Sensor__UnitsAssignment_5_1 ) ) )
            // InternalHelloWeb.g:1074:1: ( ( rule__Sensor__UnitsAssignment_5_1 ) )
            {
            // InternalHelloWeb.g:1074:1: ( ( rule__Sensor__UnitsAssignment_5_1 ) )
            // InternalHelloWeb.g:1075:2: ( rule__Sensor__UnitsAssignment_5_1 )
            {
             before(grammarAccess.getSensorAccess().getUnitsAssignment_5_1()); 
            // InternalHelloWeb.g:1076:2: ( rule__Sensor__UnitsAssignment_5_1 )
            // InternalHelloWeb.g:1076:3: rule__Sensor__UnitsAssignment_5_1
            {
            pushFollow(FOLLOW_2);
            rule__Sensor__UnitsAssignment_5_1();

            state._fsp--;


            }

             after(grammarAccess.getSensorAccess().getUnitsAssignment_5_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sensor__Group_5__1__Impl"


    // $ANTLR start "rule__Sensor__Group_10__0"
    // InternalHelloWeb.g:1085:1: rule__Sensor__Group_10__0 : rule__Sensor__Group_10__0__Impl rule__Sensor__Group_10__1 ;
    public final void rule__Sensor__Group_10__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:1089:1: ( rule__Sensor__Group_10__0__Impl rule__Sensor__Group_10__1 )
            // InternalHelloWeb.g:1090:2: rule__Sensor__Group_10__0__Impl rule__Sensor__Group_10__1
            {
            pushFollow(FOLLOW_4);
            rule__Sensor__Group_10__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Sensor__Group_10__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sensor__Group_10__0"


    // $ANTLR start "rule__Sensor__Group_10__0__Impl"
    // InternalHelloWeb.g:1097:1: rule__Sensor__Group_10__0__Impl : ( ',' ) ;
    public final void rule__Sensor__Group_10__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:1101:1: ( ( ',' ) )
            // InternalHelloWeb.g:1102:1: ( ',' )
            {
            // InternalHelloWeb.g:1102:1: ( ',' )
            // InternalHelloWeb.g:1103:2: ','
            {
             before(grammarAccess.getSensorAccess().getCommaKeyword_10_0()); 
            match(input,31,FOLLOW_2); 
             after(grammarAccess.getSensorAccess().getCommaKeyword_10_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sensor__Group_10__0__Impl"


    // $ANTLR start "rule__Sensor__Group_10__1"
    // InternalHelloWeb.g:1112:1: rule__Sensor__Group_10__1 : rule__Sensor__Group_10__1__Impl ;
    public final void rule__Sensor__Group_10__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:1116:1: ( rule__Sensor__Group_10__1__Impl )
            // InternalHelloWeb.g:1117:2: rule__Sensor__Group_10__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Sensor__Group_10__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sensor__Group_10__1"


    // $ANTLR start "rule__Sensor__Group_10__1__Impl"
    // InternalHelloWeb.g:1123:1: rule__Sensor__Group_10__1__Impl : ( ( rule__Sensor__PinsAssignment_10_1 ) ) ;
    public final void rule__Sensor__Group_10__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:1127:1: ( ( ( rule__Sensor__PinsAssignment_10_1 ) ) )
            // InternalHelloWeb.g:1128:1: ( ( rule__Sensor__PinsAssignment_10_1 ) )
            {
            // InternalHelloWeb.g:1128:1: ( ( rule__Sensor__PinsAssignment_10_1 ) )
            // InternalHelloWeb.g:1129:2: ( rule__Sensor__PinsAssignment_10_1 )
            {
             before(grammarAccess.getSensorAccess().getPinsAssignment_10_1()); 
            // InternalHelloWeb.g:1130:2: ( rule__Sensor__PinsAssignment_10_1 )
            // InternalHelloWeb.g:1130:3: rule__Sensor__PinsAssignment_10_1
            {
            pushFollow(FOLLOW_2);
            rule__Sensor__PinsAssignment_10_1();

            state._fsp--;


            }

             after(grammarAccess.getSensorAccess().getPinsAssignment_10_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sensor__Group_10__1__Impl"


    // $ANTLR start "rule__Sensor__Group_13__0"
    // InternalHelloWeb.g:1139:1: rule__Sensor__Group_13__0 : rule__Sensor__Group_13__0__Impl rule__Sensor__Group_13__1 ;
    public final void rule__Sensor__Group_13__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:1143:1: ( rule__Sensor__Group_13__0__Impl rule__Sensor__Group_13__1 )
            // InternalHelloWeb.g:1144:2: rule__Sensor__Group_13__0__Impl rule__Sensor__Group_13__1
            {
            pushFollow(FOLLOW_4);
            rule__Sensor__Group_13__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Sensor__Group_13__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sensor__Group_13__0"


    // $ANTLR start "rule__Sensor__Group_13__0__Impl"
    // InternalHelloWeb.g:1151:1: rule__Sensor__Group_13__0__Impl : ( ',' ) ;
    public final void rule__Sensor__Group_13__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:1155:1: ( ( ',' ) )
            // InternalHelloWeb.g:1156:1: ( ',' )
            {
            // InternalHelloWeb.g:1156:1: ( ',' )
            // InternalHelloWeb.g:1157:2: ','
            {
             before(grammarAccess.getSensorAccess().getCommaKeyword_13_0()); 
            match(input,31,FOLLOW_2); 
             after(grammarAccess.getSensorAccess().getCommaKeyword_13_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sensor__Group_13__0__Impl"


    // $ANTLR start "rule__Sensor__Group_13__1"
    // InternalHelloWeb.g:1166:1: rule__Sensor__Group_13__1 : rule__Sensor__Group_13__1__Impl ;
    public final void rule__Sensor__Group_13__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:1170:1: ( rule__Sensor__Group_13__1__Impl )
            // InternalHelloWeb.g:1171:2: rule__Sensor__Group_13__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Sensor__Group_13__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sensor__Group_13__1"


    // $ANTLR start "rule__Sensor__Group_13__1__Impl"
    // InternalHelloWeb.g:1177:1: rule__Sensor__Group_13__1__Impl : ( ( rule__Sensor__OutAssignment_13_1 ) ) ;
    public final void rule__Sensor__Group_13__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:1181:1: ( ( ( rule__Sensor__OutAssignment_13_1 ) ) )
            // InternalHelloWeb.g:1182:1: ( ( rule__Sensor__OutAssignment_13_1 ) )
            {
            // InternalHelloWeb.g:1182:1: ( ( rule__Sensor__OutAssignment_13_1 ) )
            // InternalHelloWeb.g:1183:2: ( rule__Sensor__OutAssignment_13_1 )
            {
             before(grammarAccess.getSensorAccess().getOutAssignment_13_1()); 
            // InternalHelloWeb.g:1184:2: ( rule__Sensor__OutAssignment_13_1 )
            // InternalHelloWeb.g:1184:3: rule__Sensor__OutAssignment_13_1
            {
            pushFollow(FOLLOW_2);
            rule__Sensor__OutAssignment_13_1();

            state._fsp--;


            }

             after(grammarAccess.getSensorAccess().getOutAssignment_13_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sensor__Group_13__1__Impl"


    // $ANTLR start "rule__DeviceType__Group__0"
    // InternalHelloWeb.g:1193:1: rule__DeviceType__Group__0 : rule__DeviceType__Group__0__Impl rule__DeviceType__Group__1 ;
    public final void rule__DeviceType__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:1197:1: ( rule__DeviceType__Group__0__Impl rule__DeviceType__Group__1 )
            // InternalHelloWeb.g:1198:2: rule__DeviceType__Group__0__Impl rule__DeviceType__Group__1
            {
            pushFollow(FOLLOW_4);
            rule__DeviceType__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DeviceType__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DeviceType__Group__0"


    // $ANTLR start "rule__DeviceType__Group__0__Impl"
    // InternalHelloWeb.g:1205:1: rule__DeviceType__Group__0__Impl : ( 'deviceType' ) ;
    public final void rule__DeviceType__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:1209:1: ( ( 'deviceType' ) )
            // InternalHelloWeb.g:1210:1: ( 'deviceType' )
            {
            // InternalHelloWeb.g:1210:1: ( 'deviceType' )
            // InternalHelloWeb.g:1211:2: 'deviceType'
            {
             before(grammarAccess.getDeviceTypeAccess().getDeviceTypeKeyword_0()); 
            match(input,32,FOLLOW_2); 
             after(grammarAccess.getDeviceTypeAccess().getDeviceTypeKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DeviceType__Group__0__Impl"


    // $ANTLR start "rule__DeviceType__Group__1"
    // InternalHelloWeb.g:1220:1: rule__DeviceType__Group__1 : rule__DeviceType__Group__1__Impl rule__DeviceType__Group__2 ;
    public final void rule__DeviceType__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:1224:1: ( rule__DeviceType__Group__1__Impl rule__DeviceType__Group__2 )
            // InternalHelloWeb.g:1225:2: rule__DeviceType__Group__1__Impl rule__DeviceType__Group__2
            {
            pushFollow(FOLLOW_5);
            rule__DeviceType__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DeviceType__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DeviceType__Group__1"


    // $ANTLR start "rule__DeviceType__Group__1__Impl"
    // InternalHelloWeb.g:1232:1: rule__DeviceType__Group__1__Impl : ( ( rule__DeviceType__NameAssignment_1 ) ) ;
    public final void rule__DeviceType__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:1236:1: ( ( ( rule__DeviceType__NameAssignment_1 ) ) )
            // InternalHelloWeb.g:1237:1: ( ( rule__DeviceType__NameAssignment_1 ) )
            {
            // InternalHelloWeb.g:1237:1: ( ( rule__DeviceType__NameAssignment_1 ) )
            // InternalHelloWeb.g:1238:2: ( rule__DeviceType__NameAssignment_1 )
            {
             before(grammarAccess.getDeviceTypeAccess().getNameAssignment_1()); 
            // InternalHelloWeb.g:1239:2: ( rule__DeviceType__NameAssignment_1 )
            // InternalHelloWeb.g:1239:3: rule__DeviceType__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__DeviceType__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getDeviceTypeAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DeviceType__Group__1__Impl"


    // $ANTLR start "rule__DeviceType__Group__2"
    // InternalHelloWeb.g:1247:1: rule__DeviceType__Group__2 : rule__DeviceType__Group__2__Impl rule__DeviceType__Group__3 ;
    public final void rule__DeviceType__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:1251:1: ( rule__DeviceType__Group__2__Impl rule__DeviceType__Group__3 )
            // InternalHelloWeb.g:1252:2: rule__DeviceType__Group__2__Impl rule__DeviceType__Group__3
            {
            pushFollow(FOLLOW_12);
            rule__DeviceType__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DeviceType__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DeviceType__Group__2"


    // $ANTLR start "rule__DeviceType__Group__2__Impl"
    // InternalHelloWeb.g:1259:1: rule__DeviceType__Group__2__Impl : ( '{' ) ;
    public final void rule__DeviceType__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:1263:1: ( ( '{' ) )
            // InternalHelloWeb.g:1264:1: ( '{' )
            {
            // InternalHelloWeb.g:1264:1: ( '{' )
            // InternalHelloWeb.g:1265:2: '{'
            {
             before(grammarAccess.getDeviceTypeAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,25,FOLLOW_2); 
             after(grammarAccess.getDeviceTypeAccess().getLeftCurlyBracketKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DeviceType__Group__2__Impl"


    // $ANTLR start "rule__DeviceType__Group__3"
    // InternalHelloWeb.g:1274:1: rule__DeviceType__Group__3 : rule__DeviceType__Group__3__Impl rule__DeviceType__Group__4 ;
    public final void rule__DeviceType__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:1278:1: ( rule__DeviceType__Group__3__Impl rule__DeviceType__Group__4 )
            // InternalHelloWeb.g:1279:2: rule__DeviceType__Group__3__Impl rule__DeviceType__Group__4
            {
            pushFollow(FOLLOW_12);
            rule__DeviceType__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DeviceType__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DeviceType__Group__3"


    // $ANTLR start "rule__DeviceType__Group__3__Impl"
    // InternalHelloWeb.g:1286:1: rule__DeviceType__Group__3__Impl : ( ( rule__DeviceType__SensorInstantiationsAssignment_3 )* ) ;
    public final void rule__DeviceType__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:1290:1: ( ( ( rule__DeviceType__SensorInstantiationsAssignment_3 )* ) )
            // InternalHelloWeb.g:1291:1: ( ( rule__DeviceType__SensorInstantiationsAssignment_3 )* )
            {
            // InternalHelloWeb.g:1291:1: ( ( rule__DeviceType__SensorInstantiationsAssignment_3 )* )
            // InternalHelloWeb.g:1292:2: ( rule__DeviceType__SensorInstantiationsAssignment_3 )*
            {
             before(grammarAccess.getDeviceTypeAccess().getSensorInstantiationsAssignment_3()); 
            // InternalHelloWeb.g:1293:2: ( rule__DeviceType__SensorInstantiationsAssignment_3 )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==RULE_ID) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // InternalHelloWeb.g:1293:3: rule__DeviceType__SensorInstantiationsAssignment_3
            	    {
            	    pushFollow(FOLLOW_13);
            	    rule__DeviceType__SensorInstantiationsAssignment_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);

             after(grammarAccess.getDeviceTypeAccess().getSensorInstantiationsAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DeviceType__Group__3__Impl"


    // $ANTLR start "rule__DeviceType__Group__4"
    // InternalHelloWeb.g:1301:1: rule__DeviceType__Group__4 : rule__DeviceType__Group__4__Impl rule__DeviceType__Group__5 ;
    public final void rule__DeviceType__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:1305:1: ( rule__DeviceType__Group__4__Impl rule__DeviceType__Group__5 )
            // InternalHelloWeb.g:1306:2: rule__DeviceType__Group__4__Impl rule__DeviceType__Group__5
            {
            pushFollow(FOLLOW_12);
            rule__DeviceType__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DeviceType__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DeviceType__Group__4"


    // $ANTLR start "rule__DeviceType__Group__4__Impl"
    // InternalHelloWeb.g:1313:1: rule__DeviceType__Group__4__Impl : ( ( rule__DeviceType__Group_4__0 )? ) ;
    public final void rule__DeviceType__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:1317:1: ( ( ( rule__DeviceType__Group_4__0 )? ) )
            // InternalHelloWeb.g:1318:1: ( ( rule__DeviceType__Group_4__0 )? )
            {
            // InternalHelloWeb.g:1318:1: ( ( rule__DeviceType__Group_4__0 )? )
            // InternalHelloWeb.g:1319:2: ( rule__DeviceType__Group_4__0 )?
            {
             before(grammarAccess.getDeviceTypeAccess().getGroup_4()); 
            // InternalHelloWeb.g:1320:2: ( rule__DeviceType__Group_4__0 )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==33) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // InternalHelloWeb.g:1320:3: rule__DeviceType__Group_4__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__DeviceType__Group_4__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getDeviceTypeAccess().getGroup_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DeviceType__Group__4__Impl"


    // $ANTLR start "rule__DeviceType__Group__5"
    // InternalHelloWeb.g:1328:1: rule__DeviceType__Group__5 : rule__DeviceType__Group__5__Impl rule__DeviceType__Group__6 ;
    public final void rule__DeviceType__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:1332:1: ( rule__DeviceType__Group__5__Impl rule__DeviceType__Group__6 )
            // InternalHelloWeb.g:1333:2: rule__DeviceType__Group__5__Impl rule__DeviceType__Group__6
            {
            pushFollow(FOLLOW_12);
            rule__DeviceType__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DeviceType__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DeviceType__Group__5"


    // $ANTLR start "rule__DeviceType__Group__5__Impl"
    // InternalHelloWeb.g:1340:1: rule__DeviceType__Group__5__Impl : ( ( rule__DeviceType__Group_5__0 )? ) ;
    public final void rule__DeviceType__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:1344:1: ( ( ( rule__DeviceType__Group_5__0 )? ) )
            // InternalHelloWeb.g:1345:1: ( ( rule__DeviceType__Group_5__0 )? )
            {
            // InternalHelloWeb.g:1345:1: ( ( rule__DeviceType__Group_5__0 )? )
            // InternalHelloWeb.g:1346:2: ( rule__DeviceType__Group_5__0 )?
            {
             before(grammarAccess.getDeviceTypeAccess().getGroup_5()); 
            // InternalHelloWeb.g:1347:2: ( rule__DeviceType__Group_5__0 )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==34) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // InternalHelloWeb.g:1347:3: rule__DeviceType__Group_5__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__DeviceType__Group_5__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getDeviceTypeAccess().getGroup_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DeviceType__Group__5__Impl"


    // $ANTLR start "rule__DeviceType__Group__6"
    // InternalHelloWeb.g:1355:1: rule__DeviceType__Group__6 : rule__DeviceType__Group__6__Impl rule__DeviceType__Group__7 ;
    public final void rule__DeviceType__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:1359:1: ( rule__DeviceType__Group__6__Impl rule__DeviceType__Group__7 )
            // InternalHelloWeb.g:1360:2: rule__DeviceType__Group__6__Impl rule__DeviceType__Group__7
            {
            pushFollow(FOLLOW_12);
            rule__DeviceType__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DeviceType__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DeviceType__Group__6"


    // $ANTLR start "rule__DeviceType__Group__6__Impl"
    // InternalHelloWeb.g:1367:1: rule__DeviceType__Group__6__Impl : ( ( rule__DeviceType__Group_6__0 )? ) ;
    public final void rule__DeviceType__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:1371:1: ( ( ( rule__DeviceType__Group_6__0 )? ) )
            // InternalHelloWeb.g:1372:1: ( ( rule__DeviceType__Group_6__0 )? )
            {
            // InternalHelloWeb.g:1372:1: ( ( rule__DeviceType__Group_6__0 )? )
            // InternalHelloWeb.g:1373:2: ( rule__DeviceType__Group_6__0 )?
            {
             before(grammarAccess.getDeviceTypeAccess().getGroup_6()); 
            // InternalHelloWeb.g:1374:2: ( rule__DeviceType__Group_6__0 )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==35) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // InternalHelloWeb.g:1374:3: rule__DeviceType__Group_6__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__DeviceType__Group_6__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getDeviceTypeAccess().getGroup_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DeviceType__Group__6__Impl"


    // $ANTLR start "rule__DeviceType__Group__7"
    // InternalHelloWeb.g:1382:1: rule__DeviceType__Group__7 : rule__DeviceType__Group__7__Impl ;
    public final void rule__DeviceType__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:1386:1: ( rule__DeviceType__Group__7__Impl )
            // InternalHelloWeb.g:1387:2: rule__DeviceType__Group__7__Impl
            {
            pushFollow(FOLLOW_2);
            rule__DeviceType__Group__7__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DeviceType__Group__7"


    // $ANTLR start "rule__DeviceType__Group__7__Impl"
    // InternalHelloWeb.g:1393:1: rule__DeviceType__Group__7__Impl : ( '}' ) ;
    public final void rule__DeviceType__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:1397:1: ( ( '}' ) )
            // InternalHelloWeb.g:1398:1: ( '}' )
            {
            // InternalHelloWeb.g:1398:1: ( '}' )
            // InternalHelloWeb.g:1399:2: '}'
            {
             before(grammarAccess.getDeviceTypeAccess().getRightCurlyBracketKeyword_7()); 
            match(input,30,FOLLOW_2); 
             after(grammarAccess.getDeviceTypeAccess().getRightCurlyBracketKeyword_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DeviceType__Group__7__Impl"


    // $ANTLR start "rule__DeviceType__Group_4__0"
    // InternalHelloWeb.g:1409:1: rule__DeviceType__Group_4__0 : rule__DeviceType__Group_4__0__Impl rule__DeviceType__Group_4__1 ;
    public final void rule__DeviceType__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:1413:1: ( rule__DeviceType__Group_4__0__Impl rule__DeviceType__Group_4__1 )
            // InternalHelloWeb.g:1414:2: rule__DeviceType__Group_4__0__Impl rule__DeviceType__Group_4__1
            {
            pushFollow(FOLLOW_14);
            rule__DeviceType__Group_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DeviceType__Group_4__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DeviceType__Group_4__0"


    // $ANTLR start "rule__DeviceType__Group_4__0__Impl"
    // InternalHelloWeb.g:1421:1: rule__DeviceType__Group_4__0__Impl : ( 'batchRatePolicy:' ) ;
    public final void rule__DeviceType__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:1425:1: ( ( 'batchRatePolicy:' ) )
            // InternalHelloWeb.g:1426:1: ( 'batchRatePolicy:' )
            {
            // InternalHelloWeb.g:1426:1: ( 'batchRatePolicy:' )
            // InternalHelloWeb.g:1427:2: 'batchRatePolicy:'
            {
             before(grammarAccess.getDeviceTypeAccess().getBatchRatePolicyKeyword_4_0()); 
            match(input,33,FOLLOW_2); 
             after(grammarAccess.getDeviceTypeAccess().getBatchRatePolicyKeyword_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DeviceType__Group_4__0__Impl"


    // $ANTLR start "rule__DeviceType__Group_4__1"
    // InternalHelloWeb.g:1436:1: rule__DeviceType__Group_4__1 : rule__DeviceType__Group_4__1__Impl ;
    public final void rule__DeviceType__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:1440:1: ( rule__DeviceType__Group_4__1__Impl )
            // InternalHelloWeb.g:1441:2: rule__DeviceType__Group_4__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__DeviceType__Group_4__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DeviceType__Group_4__1"


    // $ANTLR start "rule__DeviceType__Group_4__1__Impl"
    // InternalHelloWeb.g:1447:1: rule__DeviceType__Group_4__1__Impl : ( ( rule__DeviceType__BatchRatePolicyAssignment_4_1 ) ) ;
    public final void rule__DeviceType__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:1451:1: ( ( ( rule__DeviceType__BatchRatePolicyAssignment_4_1 ) ) )
            // InternalHelloWeb.g:1452:1: ( ( rule__DeviceType__BatchRatePolicyAssignment_4_1 ) )
            {
            // InternalHelloWeb.g:1452:1: ( ( rule__DeviceType__BatchRatePolicyAssignment_4_1 ) )
            // InternalHelloWeb.g:1453:2: ( rule__DeviceType__BatchRatePolicyAssignment_4_1 )
            {
             before(grammarAccess.getDeviceTypeAccess().getBatchRatePolicyAssignment_4_1()); 
            // InternalHelloWeb.g:1454:2: ( rule__DeviceType__BatchRatePolicyAssignment_4_1 )
            // InternalHelloWeb.g:1454:3: rule__DeviceType__BatchRatePolicyAssignment_4_1
            {
            pushFollow(FOLLOW_2);
            rule__DeviceType__BatchRatePolicyAssignment_4_1();

            state._fsp--;


            }

             after(grammarAccess.getDeviceTypeAccess().getBatchRatePolicyAssignment_4_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DeviceType__Group_4__1__Impl"


    // $ANTLR start "rule__DeviceType__Group_5__0"
    // InternalHelloWeb.g:1463:1: rule__DeviceType__Group_5__0 : rule__DeviceType__Group_5__0__Impl rule__DeviceType__Group_5__1 ;
    public final void rule__DeviceType__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:1467:1: ( rule__DeviceType__Group_5__0__Impl rule__DeviceType__Group_5__1 )
            // InternalHelloWeb.g:1468:2: rule__DeviceType__Group_5__0__Impl rule__DeviceType__Group_5__1
            {
            pushFollow(FOLLOW_14);
            rule__DeviceType__Group_5__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DeviceType__Group_5__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DeviceType__Group_5__0"


    // $ANTLR start "rule__DeviceType__Group_5__0__Impl"
    // InternalHelloWeb.g:1475:1: rule__DeviceType__Group_5__0__Impl : ( 'batchSizePolicy:' ) ;
    public final void rule__DeviceType__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:1479:1: ( ( 'batchSizePolicy:' ) )
            // InternalHelloWeb.g:1480:1: ( 'batchSizePolicy:' )
            {
            // InternalHelloWeb.g:1480:1: ( 'batchSizePolicy:' )
            // InternalHelloWeb.g:1481:2: 'batchSizePolicy:'
            {
             before(grammarAccess.getDeviceTypeAccess().getBatchSizePolicyKeyword_5_0()); 
            match(input,34,FOLLOW_2); 
             after(grammarAccess.getDeviceTypeAccess().getBatchSizePolicyKeyword_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DeviceType__Group_5__0__Impl"


    // $ANTLR start "rule__DeviceType__Group_5__1"
    // InternalHelloWeb.g:1490:1: rule__DeviceType__Group_5__1 : rule__DeviceType__Group_5__1__Impl ;
    public final void rule__DeviceType__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:1494:1: ( rule__DeviceType__Group_5__1__Impl )
            // InternalHelloWeb.g:1495:2: rule__DeviceType__Group_5__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__DeviceType__Group_5__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DeviceType__Group_5__1"


    // $ANTLR start "rule__DeviceType__Group_5__1__Impl"
    // InternalHelloWeb.g:1501:1: rule__DeviceType__Group_5__1__Impl : ( ( rule__DeviceType__BatchSizePolicyAssignment_5_1 ) ) ;
    public final void rule__DeviceType__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:1505:1: ( ( ( rule__DeviceType__BatchSizePolicyAssignment_5_1 ) ) )
            // InternalHelloWeb.g:1506:1: ( ( rule__DeviceType__BatchSizePolicyAssignment_5_1 ) )
            {
            // InternalHelloWeb.g:1506:1: ( ( rule__DeviceType__BatchSizePolicyAssignment_5_1 ) )
            // InternalHelloWeb.g:1507:2: ( rule__DeviceType__BatchSizePolicyAssignment_5_1 )
            {
             before(grammarAccess.getDeviceTypeAccess().getBatchSizePolicyAssignment_5_1()); 
            // InternalHelloWeb.g:1508:2: ( rule__DeviceType__BatchSizePolicyAssignment_5_1 )
            // InternalHelloWeb.g:1508:3: rule__DeviceType__BatchSizePolicyAssignment_5_1
            {
            pushFollow(FOLLOW_2);
            rule__DeviceType__BatchSizePolicyAssignment_5_1();

            state._fsp--;


            }

             after(grammarAccess.getDeviceTypeAccess().getBatchSizePolicyAssignment_5_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DeviceType__Group_5__1__Impl"


    // $ANTLR start "rule__DeviceType__Group_6__0"
    // InternalHelloWeb.g:1517:1: rule__DeviceType__Group_6__0 : rule__DeviceType__Group_6__0__Impl rule__DeviceType__Group_6__1 ;
    public final void rule__DeviceType__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:1521:1: ( rule__DeviceType__Group_6__0__Impl rule__DeviceType__Group_6__1 )
            // InternalHelloWeb.g:1522:2: rule__DeviceType__Group_6__0__Impl rule__DeviceType__Group_6__1
            {
            pushFollow(FOLLOW_14);
            rule__DeviceType__Group_6__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DeviceType__Group_6__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DeviceType__Group_6__0"


    // $ANTLR start "rule__DeviceType__Group_6__0__Impl"
    // InternalHelloWeb.g:1529:1: rule__DeviceType__Group_6__0__Impl : ( 'heartBeatPolicy:' ) ;
    public final void rule__DeviceType__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:1533:1: ( ( 'heartBeatPolicy:' ) )
            // InternalHelloWeb.g:1534:1: ( 'heartBeatPolicy:' )
            {
            // InternalHelloWeb.g:1534:1: ( 'heartBeatPolicy:' )
            // InternalHelloWeb.g:1535:2: 'heartBeatPolicy:'
            {
             before(grammarAccess.getDeviceTypeAccess().getHeartBeatPolicyKeyword_6_0()); 
            match(input,35,FOLLOW_2); 
             after(grammarAccess.getDeviceTypeAccess().getHeartBeatPolicyKeyword_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DeviceType__Group_6__0__Impl"


    // $ANTLR start "rule__DeviceType__Group_6__1"
    // InternalHelloWeb.g:1544:1: rule__DeviceType__Group_6__1 : rule__DeviceType__Group_6__1__Impl ;
    public final void rule__DeviceType__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:1548:1: ( rule__DeviceType__Group_6__1__Impl )
            // InternalHelloWeb.g:1549:2: rule__DeviceType__Group_6__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__DeviceType__Group_6__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DeviceType__Group_6__1"


    // $ANTLR start "rule__DeviceType__Group_6__1__Impl"
    // InternalHelloWeb.g:1555:1: rule__DeviceType__Group_6__1__Impl : ( ( rule__DeviceType__HeartBeatPolicyAssignment_6_1 ) ) ;
    public final void rule__DeviceType__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:1559:1: ( ( ( rule__DeviceType__HeartBeatPolicyAssignment_6_1 ) ) )
            // InternalHelloWeb.g:1560:1: ( ( rule__DeviceType__HeartBeatPolicyAssignment_6_1 ) )
            {
            // InternalHelloWeb.g:1560:1: ( ( rule__DeviceType__HeartBeatPolicyAssignment_6_1 ) )
            // InternalHelloWeb.g:1561:2: ( rule__DeviceType__HeartBeatPolicyAssignment_6_1 )
            {
             before(grammarAccess.getDeviceTypeAccess().getHeartBeatPolicyAssignment_6_1()); 
            // InternalHelloWeb.g:1562:2: ( rule__DeviceType__HeartBeatPolicyAssignment_6_1 )
            // InternalHelloWeb.g:1562:3: rule__DeviceType__HeartBeatPolicyAssignment_6_1
            {
            pushFollow(FOLLOW_2);
            rule__DeviceType__HeartBeatPolicyAssignment_6_1();

            state._fsp--;


            }

             after(grammarAccess.getDeviceTypeAccess().getHeartBeatPolicyAssignment_6_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DeviceType__Group_6__1__Impl"


    // $ANTLR start "rule__SensorInstantiation__Group__0"
    // InternalHelloWeb.g:1571:1: rule__SensorInstantiation__Group__0 : rule__SensorInstantiation__Group__0__Impl rule__SensorInstantiation__Group__1 ;
    public final void rule__SensorInstantiation__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:1575:1: ( rule__SensorInstantiation__Group__0__Impl rule__SensorInstantiation__Group__1 )
            // InternalHelloWeb.g:1576:2: rule__SensorInstantiation__Group__0__Impl rule__SensorInstantiation__Group__1
            {
            pushFollow(FOLLOW_4);
            rule__SensorInstantiation__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__SensorInstantiation__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SensorInstantiation__Group__0"


    // $ANTLR start "rule__SensorInstantiation__Group__0__Impl"
    // InternalHelloWeb.g:1583:1: rule__SensorInstantiation__Group__0__Impl : ( ( rule__SensorInstantiation__SensorAssignment_0 ) ) ;
    public final void rule__SensorInstantiation__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:1587:1: ( ( ( rule__SensorInstantiation__SensorAssignment_0 ) ) )
            // InternalHelloWeb.g:1588:1: ( ( rule__SensorInstantiation__SensorAssignment_0 ) )
            {
            // InternalHelloWeb.g:1588:1: ( ( rule__SensorInstantiation__SensorAssignment_0 ) )
            // InternalHelloWeb.g:1589:2: ( rule__SensorInstantiation__SensorAssignment_0 )
            {
             before(grammarAccess.getSensorInstantiationAccess().getSensorAssignment_0()); 
            // InternalHelloWeb.g:1590:2: ( rule__SensorInstantiation__SensorAssignment_0 )
            // InternalHelloWeb.g:1590:3: rule__SensorInstantiation__SensorAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__SensorInstantiation__SensorAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getSensorInstantiationAccess().getSensorAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SensorInstantiation__Group__0__Impl"


    // $ANTLR start "rule__SensorInstantiation__Group__1"
    // InternalHelloWeb.g:1598:1: rule__SensorInstantiation__Group__1 : rule__SensorInstantiation__Group__1__Impl rule__SensorInstantiation__Group__2 ;
    public final void rule__SensorInstantiation__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:1602:1: ( rule__SensorInstantiation__Group__1__Impl rule__SensorInstantiation__Group__2 )
            // InternalHelloWeb.g:1603:2: rule__SensorInstantiation__Group__1__Impl rule__SensorInstantiation__Group__2
            {
            pushFollow(FOLLOW_5);
            rule__SensorInstantiation__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__SensorInstantiation__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SensorInstantiation__Group__1"


    // $ANTLR start "rule__SensorInstantiation__Group__1__Impl"
    // InternalHelloWeb.g:1610:1: rule__SensorInstantiation__Group__1__Impl : ( ( rule__SensorInstantiation__NameAssignment_1 ) ) ;
    public final void rule__SensorInstantiation__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:1614:1: ( ( ( rule__SensorInstantiation__NameAssignment_1 ) ) )
            // InternalHelloWeb.g:1615:1: ( ( rule__SensorInstantiation__NameAssignment_1 ) )
            {
            // InternalHelloWeb.g:1615:1: ( ( rule__SensorInstantiation__NameAssignment_1 ) )
            // InternalHelloWeb.g:1616:2: ( rule__SensorInstantiation__NameAssignment_1 )
            {
             before(grammarAccess.getSensorInstantiationAccess().getNameAssignment_1()); 
            // InternalHelloWeb.g:1617:2: ( rule__SensorInstantiation__NameAssignment_1 )
            // InternalHelloWeb.g:1617:3: rule__SensorInstantiation__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__SensorInstantiation__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getSensorInstantiationAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SensorInstantiation__Group__1__Impl"


    // $ANTLR start "rule__SensorInstantiation__Group__2"
    // InternalHelloWeb.g:1625:1: rule__SensorInstantiation__Group__2 : rule__SensorInstantiation__Group__2__Impl rule__SensorInstantiation__Group__3 ;
    public final void rule__SensorInstantiation__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:1629:1: ( rule__SensorInstantiation__Group__2__Impl rule__SensorInstantiation__Group__3 )
            // InternalHelloWeb.g:1630:2: rule__SensorInstantiation__Group__2__Impl rule__SensorInstantiation__Group__3
            {
            pushFollow(FOLLOW_9);
            rule__SensorInstantiation__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__SensorInstantiation__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SensorInstantiation__Group__2"


    // $ANTLR start "rule__SensorInstantiation__Group__2__Impl"
    // InternalHelloWeb.g:1637:1: rule__SensorInstantiation__Group__2__Impl : ( '{' ) ;
    public final void rule__SensorInstantiation__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:1641:1: ( ( '{' ) )
            // InternalHelloWeb.g:1642:1: ( '{' )
            {
            // InternalHelloWeb.g:1642:1: ( '{' )
            // InternalHelloWeb.g:1643:2: '{'
            {
             before(grammarAccess.getSensorInstantiationAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,25,FOLLOW_2); 
             after(grammarAccess.getSensorInstantiationAccess().getLeftCurlyBracketKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SensorInstantiation__Group__2__Impl"


    // $ANTLR start "rule__SensorInstantiation__Group__3"
    // InternalHelloWeb.g:1652:1: rule__SensorInstantiation__Group__3 : rule__SensorInstantiation__Group__3__Impl rule__SensorInstantiation__Group__4 ;
    public final void rule__SensorInstantiation__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:1656:1: ( rule__SensorInstantiation__Group__3__Impl rule__SensorInstantiation__Group__4 )
            // InternalHelloWeb.g:1657:2: rule__SensorInstantiation__Group__3__Impl rule__SensorInstantiation__Group__4
            {
            pushFollow(FOLLOW_14);
            rule__SensorInstantiation__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__SensorInstantiation__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SensorInstantiation__Group__3"


    // $ANTLR start "rule__SensorInstantiation__Group__3__Impl"
    // InternalHelloWeb.g:1664:1: rule__SensorInstantiation__Group__3__Impl : ( 'pins:' ) ;
    public final void rule__SensorInstantiation__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:1668:1: ( ( 'pins:' ) )
            // InternalHelloWeb.g:1669:1: ( 'pins:' )
            {
            // InternalHelloWeb.g:1669:1: ( 'pins:' )
            // InternalHelloWeb.g:1670:2: 'pins:'
            {
             before(grammarAccess.getSensorInstantiationAccess().getPinsKeyword_3()); 
            match(input,28,FOLLOW_2); 
             after(grammarAccess.getSensorInstantiationAccess().getPinsKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SensorInstantiation__Group__3__Impl"


    // $ANTLR start "rule__SensorInstantiation__Group__4"
    // InternalHelloWeb.g:1679:1: rule__SensorInstantiation__Group__4 : rule__SensorInstantiation__Group__4__Impl rule__SensorInstantiation__Group__5 ;
    public final void rule__SensorInstantiation__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:1683:1: ( rule__SensorInstantiation__Group__4__Impl rule__SensorInstantiation__Group__5 )
            // InternalHelloWeb.g:1684:2: rule__SensorInstantiation__Group__4__Impl rule__SensorInstantiation__Group__5
            {
            pushFollow(FOLLOW_15);
            rule__SensorInstantiation__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__SensorInstantiation__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SensorInstantiation__Group__4"


    // $ANTLR start "rule__SensorInstantiation__Group__4__Impl"
    // InternalHelloWeb.g:1691:1: rule__SensorInstantiation__Group__4__Impl : ( ( rule__SensorInstantiation__PinsAssignment_4 ) ) ;
    public final void rule__SensorInstantiation__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:1695:1: ( ( ( rule__SensorInstantiation__PinsAssignment_4 ) ) )
            // InternalHelloWeb.g:1696:1: ( ( rule__SensorInstantiation__PinsAssignment_4 ) )
            {
            // InternalHelloWeb.g:1696:1: ( ( rule__SensorInstantiation__PinsAssignment_4 ) )
            // InternalHelloWeb.g:1697:2: ( rule__SensorInstantiation__PinsAssignment_4 )
            {
             before(grammarAccess.getSensorInstantiationAccess().getPinsAssignment_4()); 
            // InternalHelloWeb.g:1698:2: ( rule__SensorInstantiation__PinsAssignment_4 )
            // InternalHelloWeb.g:1698:3: rule__SensorInstantiation__PinsAssignment_4
            {
            pushFollow(FOLLOW_2);
            rule__SensorInstantiation__PinsAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getSensorInstantiationAccess().getPinsAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SensorInstantiation__Group__4__Impl"


    // $ANTLR start "rule__SensorInstantiation__Group__5"
    // InternalHelloWeb.g:1706:1: rule__SensorInstantiation__Group__5 : rule__SensorInstantiation__Group__5__Impl rule__SensorInstantiation__Group__6 ;
    public final void rule__SensorInstantiation__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:1710:1: ( rule__SensorInstantiation__Group__5__Impl rule__SensorInstantiation__Group__6 )
            // InternalHelloWeb.g:1711:2: rule__SensorInstantiation__Group__5__Impl rule__SensorInstantiation__Group__6
            {
            pushFollow(FOLLOW_15);
            rule__SensorInstantiation__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__SensorInstantiation__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SensorInstantiation__Group__5"


    // $ANTLR start "rule__SensorInstantiation__Group__5__Impl"
    // InternalHelloWeb.g:1718:1: rule__SensorInstantiation__Group__5__Impl : ( ( rule__SensorInstantiation__Group_5__0 )* ) ;
    public final void rule__SensorInstantiation__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:1722:1: ( ( ( rule__SensorInstantiation__Group_5__0 )* ) )
            // InternalHelloWeb.g:1723:1: ( ( rule__SensorInstantiation__Group_5__0 )* )
            {
            // InternalHelloWeb.g:1723:1: ( ( rule__SensorInstantiation__Group_5__0 )* )
            // InternalHelloWeb.g:1724:2: ( rule__SensorInstantiation__Group_5__0 )*
            {
             before(grammarAccess.getSensorInstantiationAccess().getGroup_5()); 
            // InternalHelloWeb.g:1725:2: ( rule__SensorInstantiation__Group_5__0 )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==31) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // InternalHelloWeb.g:1725:3: rule__SensorInstantiation__Group_5__0
            	    {
            	    pushFollow(FOLLOW_8);
            	    rule__SensorInstantiation__Group_5__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);

             after(grammarAccess.getSensorInstantiationAccess().getGroup_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SensorInstantiation__Group__5__Impl"


    // $ANTLR start "rule__SensorInstantiation__Group__6"
    // InternalHelloWeb.g:1733:1: rule__SensorInstantiation__Group__6 : rule__SensorInstantiation__Group__6__Impl rule__SensorInstantiation__Group__7 ;
    public final void rule__SensorInstantiation__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:1737:1: ( rule__SensorInstantiation__Group__6__Impl rule__SensorInstantiation__Group__7 )
            // InternalHelloWeb.g:1738:2: rule__SensorInstantiation__Group__6__Impl rule__SensorInstantiation__Group__7
            {
            pushFollow(FOLLOW_15);
            rule__SensorInstantiation__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__SensorInstantiation__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SensorInstantiation__Group__6"


    // $ANTLR start "rule__SensorInstantiation__Group__6__Impl"
    // InternalHelloWeb.g:1745:1: rule__SensorInstantiation__Group__6__Impl : ( ( rule__SensorInstantiation__Group_6__0 )? ) ;
    public final void rule__SensorInstantiation__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:1749:1: ( ( ( rule__SensorInstantiation__Group_6__0 )? ) )
            // InternalHelloWeb.g:1750:1: ( ( rule__SensorInstantiation__Group_6__0 )? )
            {
            // InternalHelloWeb.g:1750:1: ( ( rule__SensorInstantiation__Group_6__0 )? )
            // InternalHelloWeb.g:1751:2: ( rule__SensorInstantiation__Group_6__0 )?
            {
             before(grammarAccess.getSensorInstantiationAccess().getGroup_6()); 
            // InternalHelloWeb.g:1752:2: ( rule__SensorInstantiation__Group_6__0 )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==36) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // InternalHelloWeb.g:1752:3: rule__SensorInstantiation__Group_6__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__SensorInstantiation__Group_6__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getSensorInstantiationAccess().getGroup_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SensorInstantiation__Group__6__Impl"


    // $ANTLR start "rule__SensorInstantiation__Group__7"
    // InternalHelloWeb.g:1760:1: rule__SensorInstantiation__Group__7 : rule__SensorInstantiation__Group__7__Impl rule__SensorInstantiation__Group__8 ;
    public final void rule__SensorInstantiation__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:1764:1: ( rule__SensorInstantiation__Group__7__Impl rule__SensorInstantiation__Group__8 )
            // InternalHelloWeb.g:1765:2: rule__SensorInstantiation__Group__7__Impl rule__SensorInstantiation__Group__8
            {
            pushFollow(FOLLOW_15);
            rule__SensorInstantiation__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__SensorInstantiation__Group__8();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SensorInstantiation__Group__7"


    // $ANTLR start "rule__SensorInstantiation__Group__7__Impl"
    // InternalHelloWeb.g:1772:1: rule__SensorInstantiation__Group__7__Impl : ( ( rule__SensorInstantiation__ConstraintsAssignment_7 )* ) ;
    public final void rule__SensorInstantiation__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:1776:1: ( ( ( rule__SensorInstantiation__ConstraintsAssignment_7 )* ) )
            // InternalHelloWeb.g:1777:1: ( ( rule__SensorInstantiation__ConstraintsAssignment_7 )* )
            {
            // InternalHelloWeb.g:1777:1: ( ( rule__SensorInstantiation__ConstraintsAssignment_7 )* )
            // InternalHelloWeb.g:1778:2: ( rule__SensorInstantiation__ConstraintsAssignment_7 )*
            {
             before(grammarAccess.getSensorInstantiationAccess().getConstraintsAssignment_7()); 
            // InternalHelloWeb.g:1779:2: ( rule__SensorInstantiation__ConstraintsAssignment_7 )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==37) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // InternalHelloWeb.g:1779:3: rule__SensorInstantiation__ConstraintsAssignment_7
            	    {
            	    pushFollow(FOLLOW_16);
            	    rule__SensorInstantiation__ConstraintsAssignment_7();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);

             after(grammarAccess.getSensorInstantiationAccess().getConstraintsAssignment_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SensorInstantiation__Group__7__Impl"


    // $ANTLR start "rule__SensorInstantiation__Group__8"
    // InternalHelloWeb.g:1787:1: rule__SensorInstantiation__Group__8 : rule__SensorInstantiation__Group__8__Impl ;
    public final void rule__SensorInstantiation__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:1791:1: ( rule__SensorInstantiation__Group__8__Impl )
            // InternalHelloWeb.g:1792:2: rule__SensorInstantiation__Group__8__Impl
            {
            pushFollow(FOLLOW_2);
            rule__SensorInstantiation__Group__8__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SensorInstantiation__Group__8"


    // $ANTLR start "rule__SensorInstantiation__Group__8__Impl"
    // InternalHelloWeb.g:1798:1: rule__SensorInstantiation__Group__8__Impl : ( '}' ) ;
    public final void rule__SensorInstantiation__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:1802:1: ( ( '}' ) )
            // InternalHelloWeb.g:1803:1: ( '}' )
            {
            // InternalHelloWeb.g:1803:1: ( '}' )
            // InternalHelloWeb.g:1804:2: '}'
            {
             before(grammarAccess.getSensorInstantiationAccess().getRightCurlyBracketKeyword_8()); 
            match(input,30,FOLLOW_2); 
             after(grammarAccess.getSensorInstantiationAccess().getRightCurlyBracketKeyword_8()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SensorInstantiation__Group__8__Impl"


    // $ANTLR start "rule__SensorInstantiation__Group_5__0"
    // InternalHelloWeb.g:1814:1: rule__SensorInstantiation__Group_5__0 : rule__SensorInstantiation__Group_5__0__Impl rule__SensorInstantiation__Group_5__1 ;
    public final void rule__SensorInstantiation__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:1818:1: ( rule__SensorInstantiation__Group_5__0__Impl rule__SensorInstantiation__Group_5__1 )
            // InternalHelloWeb.g:1819:2: rule__SensorInstantiation__Group_5__0__Impl rule__SensorInstantiation__Group_5__1
            {
            pushFollow(FOLLOW_14);
            rule__SensorInstantiation__Group_5__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__SensorInstantiation__Group_5__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SensorInstantiation__Group_5__0"


    // $ANTLR start "rule__SensorInstantiation__Group_5__0__Impl"
    // InternalHelloWeb.g:1826:1: rule__SensorInstantiation__Group_5__0__Impl : ( ',' ) ;
    public final void rule__SensorInstantiation__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:1830:1: ( ( ',' ) )
            // InternalHelloWeb.g:1831:1: ( ',' )
            {
            // InternalHelloWeb.g:1831:1: ( ',' )
            // InternalHelloWeb.g:1832:2: ','
            {
             before(grammarAccess.getSensorInstantiationAccess().getCommaKeyword_5_0()); 
            match(input,31,FOLLOW_2); 
             after(grammarAccess.getSensorInstantiationAccess().getCommaKeyword_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SensorInstantiation__Group_5__0__Impl"


    // $ANTLR start "rule__SensorInstantiation__Group_5__1"
    // InternalHelloWeb.g:1841:1: rule__SensorInstantiation__Group_5__1 : rule__SensorInstantiation__Group_5__1__Impl ;
    public final void rule__SensorInstantiation__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:1845:1: ( rule__SensorInstantiation__Group_5__1__Impl )
            // InternalHelloWeb.g:1846:2: rule__SensorInstantiation__Group_5__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__SensorInstantiation__Group_5__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SensorInstantiation__Group_5__1"


    // $ANTLR start "rule__SensorInstantiation__Group_5__1__Impl"
    // InternalHelloWeb.g:1852:1: rule__SensorInstantiation__Group_5__1__Impl : ( ( rule__SensorInstantiation__PinsAssignment_5_1 ) ) ;
    public final void rule__SensorInstantiation__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:1856:1: ( ( ( rule__SensorInstantiation__PinsAssignment_5_1 ) ) )
            // InternalHelloWeb.g:1857:1: ( ( rule__SensorInstantiation__PinsAssignment_5_1 ) )
            {
            // InternalHelloWeb.g:1857:1: ( ( rule__SensorInstantiation__PinsAssignment_5_1 ) )
            // InternalHelloWeb.g:1858:2: ( rule__SensorInstantiation__PinsAssignment_5_1 )
            {
             before(grammarAccess.getSensorInstantiationAccess().getPinsAssignment_5_1()); 
            // InternalHelloWeb.g:1859:2: ( rule__SensorInstantiation__PinsAssignment_5_1 )
            // InternalHelloWeb.g:1859:3: rule__SensorInstantiation__PinsAssignment_5_1
            {
            pushFollow(FOLLOW_2);
            rule__SensorInstantiation__PinsAssignment_5_1();

            state._fsp--;


            }

             after(grammarAccess.getSensorInstantiationAccess().getPinsAssignment_5_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SensorInstantiation__Group_5__1__Impl"


    // $ANTLR start "rule__SensorInstantiation__Group_6__0"
    // InternalHelloWeb.g:1868:1: rule__SensorInstantiation__Group_6__0 : rule__SensorInstantiation__Group_6__0__Impl rule__SensorInstantiation__Group_6__1 ;
    public final void rule__SensorInstantiation__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:1872:1: ( rule__SensorInstantiation__Group_6__0__Impl rule__SensorInstantiation__Group_6__1 )
            // InternalHelloWeb.g:1873:2: rule__SensorInstantiation__Group_6__0__Impl rule__SensorInstantiation__Group_6__1
            {
            pushFollow(FOLLOW_14);
            rule__SensorInstantiation__Group_6__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__SensorInstantiation__Group_6__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SensorInstantiation__Group_6__0"


    // $ANTLR start "rule__SensorInstantiation__Group_6__0__Impl"
    // InternalHelloWeb.g:1880:1: rule__SensorInstantiation__Group_6__0__Impl : ( 'samplingRate:' ) ;
    public final void rule__SensorInstantiation__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:1884:1: ( ( 'samplingRate:' ) )
            // InternalHelloWeb.g:1885:1: ( 'samplingRate:' )
            {
            // InternalHelloWeb.g:1885:1: ( 'samplingRate:' )
            // InternalHelloWeb.g:1886:2: 'samplingRate:'
            {
             before(grammarAccess.getSensorInstantiationAccess().getSamplingRateKeyword_6_0()); 
            match(input,36,FOLLOW_2); 
             after(grammarAccess.getSensorInstantiationAccess().getSamplingRateKeyword_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SensorInstantiation__Group_6__0__Impl"


    // $ANTLR start "rule__SensorInstantiation__Group_6__1"
    // InternalHelloWeb.g:1895:1: rule__SensorInstantiation__Group_6__1 : rule__SensorInstantiation__Group_6__1__Impl ;
    public final void rule__SensorInstantiation__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:1899:1: ( rule__SensorInstantiation__Group_6__1__Impl )
            // InternalHelloWeb.g:1900:2: rule__SensorInstantiation__Group_6__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__SensorInstantiation__Group_6__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SensorInstantiation__Group_6__1"


    // $ANTLR start "rule__SensorInstantiation__Group_6__1__Impl"
    // InternalHelloWeb.g:1906:1: rule__SensorInstantiation__Group_6__1__Impl : ( ( rule__SensorInstantiation__SamplingRateAssignment_6_1 ) ) ;
    public final void rule__SensorInstantiation__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:1910:1: ( ( ( rule__SensorInstantiation__SamplingRateAssignment_6_1 ) ) )
            // InternalHelloWeb.g:1911:1: ( ( rule__SensorInstantiation__SamplingRateAssignment_6_1 ) )
            {
            // InternalHelloWeb.g:1911:1: ( ( rule__SensorInstantiation__SamplingRateAssignment_6_1 ) )
            // InternalHelloWeb.g:1912:2: ( rule__SensorInstantiation__SamplingRateAssignment_6_1 )
            {
             before(grammarAccess.getSensorInstantiationAccess().getSamplingRateAssignment_6_1()); 
            // InternalHelloWeb.g:1913:2: ( rule__SensorInstantiation__SamplingRateAssignment_6_1 )
            // InternalHelloWeb.g:1913:3: rule__SensorInstantiation__SamplingRateAssignment_6_1
            {
            pushFollow(FOLLOW_2);
            rule__SensorInstantiation__SamplingRateAssignment_6_1();

            state._fsp--;


            }

             after(grammarAccess.getSensorInstantiationAccess().getSamplingRateAssignment_6_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SensorInstantiation__Group_6__1__Impl"


    // $ANTLR start "rule__Constraint__Group__0"
    // InternalHelloWeb.g:1922:1: rule__Constraint__Group__0 : rule__Constraint__Group__0__Impl rule__Constraint__Group__1 ;
    public final void rule__Constraint__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:1926:1: ( rule__Constraint__Group__0__Impl rule__Constraint__Group__1 )
            // InternalHelloWeb.g:1927:2: rule__Constraint__Group__0__Impl rule__Constraint__Group__1
            {
            pushFollow(FOLLOW_17);
            rule__Constraint__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Constraint__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constraint__Group__0"


    // $ANTLR start "rule__Constraint__Group__0__Impl"
    // InternalHelloWeb.g:1934:1: rule__Constraint__Group__0__Impl : ( '(' ) ;
    public final void rule__Constraint__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:1938:1: ( ( '(' ) )
            // InternalHelloWeb.g:1939:1: ( '(' )
            {
            // InternalHelloWeb.g:1939:1: ( '(' )
            // InternalHelloWeb.g:1940:2: '('
            {
             before(grammarAccess.getConstraintAccess().getLeftParenthesisKeyword_0()); 
            match(input,37,FOLLOW_2); 
             after(grammarAccess.getConstraintAccess().getLeftParenthesisKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constraint__Group__0__Impl"


    // $ANTLR start "rule__Constraint__Group__1"
    // InternalHelloWeb.g:1949:1: rule__Constraint__Group__1 : rule__Constraint__Group__1__Impl rule__Constraint__Group__2 ;
    public final void rule__Constraint__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:1953:1: ( rule__Constraint__Group__1__Impl rule__Constraint__Group__2 )
            // InternalHelloWeb.g:1954:2: rule__Constraint__Group__1__Impl rule__Constraint__Group__2
            {
            pushFollow(FOLLOW_18);
            rule__Constraint__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Constraint__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constraint__Group__1"


    // $ANTLR start "rule__Constraint__Group__1__Impl"
    // InternalHelloWeb.g:1961:1: rule__Constraint__Group__1__Impl : ( ( rule__Constraint__ConditionAssignment_1 ) ) ;
    public final void rule__Constraint__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:1965:1: ( ( ( rule__Constraint__ConditionAssignment_1 ) ) )
            // InternalHelloWeb.g:1966:1: ( ( rule__Constraint__ConditionAssignment_1 ) )
            {
            // InternalHelloWeb.g:1966:1: ( ( rule__Constraint__ConditionAssignment_1 ) )
            // InternalHelloWeb.g:1967:2: ( rule__Constraint__ConditionAssignment_1 )
            {
             before(grammarAccess.getConstraintAccess().getConditionAssignment_1()); 
            // InternalHelloWeb.g:1968:2: ( rule__Constraint__ConditionAssignment_1 )
            // InternalHelloWeb.g:1968:3: rule__Constraint__ConditionAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Constraint__ConditionAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getConstraintAccess().getConditionAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constraint__Group__1__Impl"


    // $ANTLR start "rule__Constraint__Group__2"
    // InternalHelloWeb.g:1976:1: rule__Constraint__Group__2 : rule__Constraint__Group__2__Impl rule__Constraint__Group__3 ;
    public final void rule__Constraint__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:1980:1: ( rule__Constraint__Group__2__Impl rule__Constraint__Group__3 )
            // InternalHelloWeb.g:1981:2: rule__Constraint__Group__2__Impl rule__Constraint__Group__3
            {
            pushFollow(FOLLOW_5);
            rule__Constraint__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Constraint__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constraint__Group__2"


    // $ANTLR start "rule__Constraint__Group__2__Impl"
    // InternalHelloWeb.g:1988:1: rule__Constraint__Group__2__Impl : ( ')' ) ;
    public final void rule__Constraint__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:1992:1: ( ( ')' ) )
            // InternalHelloWeb.g:1993:1: ( ')' )
            {
            // InternalHelloWeb.g:1993:1: ( ')' )
            // InternalHelloWeb.g:1994:2: ')'
            {
             before(grammarAccess.getConstraintAccess().getRightParenthesisKeyword_2()); 
            match(input,38,FOLLOW_2); 
             after(grammarAccess.getConstraintAccess().getRightParenthesisKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constraint__Group__2__Impl"


    // $ANTLR start "rule__Constraint__Group__3"
    // InternalHelloWeb.g:2003:1: rule__Constraint__Group__3 : rule__Constraint__Group__3__Impl rule__Constraint__Group__4 ;
    public final void rule__Constraint__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:2007:1: ( rule__Constraint__Group__3__Impl rule__Constraint__Group__4 )
            // InternalHelloWeb.g:2008:2: rule__Constraint__Group__3__Impl rule__Constraint__Group__4
            {
            pushFollow(FOLLOW_19);
            rule__Constraint__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Constraint__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constraint__Group__3"


    // $ANTLR start "rule__Constraint__Group__3__Impl"
    // InternalHelloWeb.g:2015:1: rule__Constraint__Group__3__Impl : ( '{' ) ;
    public final void rule__Constraint__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:2019:1: ( ( '{' ) )
            // InternalHelloWeb.g:2020:1: ( '{' )
            {
            // InternalHelloWeb.g:2020:1: ( '{' )
            // InternalHelloWeb.g:2021:2: '{'
            {
             before(grammarAccess.getConstraintAccess().getLeftCurlyBracketKeyword_3()); 
            match(input,25,FOLLOW_2); 
             after(grammarAccess.getConstraintAccess().getLeftCurlyBracketKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constraint__Group__3__Impl"


    // $ANTLR start "rule__Constraint__Group__4"
    // InternalHelloWeb.g:2030:1: rule__Constraint__Group__4 : rule__Constraint__Group__4__Impl rule__Constraint__Group__5 ;
    public final void rule__Constraint__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:2034:1: ( rule__Constraint__Group__4__Impl rule__Constraint__Group__5 )
            // InternalHelloWeb.g:2035:2: rule__Constraint__Group__4__Impl rule__Constraint__Group__5
            {
            pushFollow(FOLLOW_19);
            rule__Constraint__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Constraint__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constraint__Group__4"


    // $ANTLR start "rule__Constraint__Group__4__Impl"
    // InternalHelloWeb.g:2042:1: rule__Constraint__Group__4__Impl : ( ( rule__Constraint__Group_4__0 )? ) ;
    public final void rule__Constraint__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:2046:1: ( ( ( rule__Constraint__Group_4__0 )? ) )
            // InternalHelloWeb.g:2047:1: ( ( rule__Constraint__Group_4__0 )? )
            {
            // InternalHelloWeb.g:2047:1: ( ( rule__Constraint__Group_4__0 )? )
            // InternalHelloWeb.g:2048:2: ( rule__Constraint__Group_4__0 )?
            {
             before(grammarAccess.getConstraintAccess().getGroup_4()); 
            // InternalHelloWeb.g:2049:2: ( rule__Constraint__Group_4__0 )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==36) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // InternalHelloWeb.g:2049:3: rule__Constraint__Group_4__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Constraint__Group_4__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getConstraintAccess().getGroup_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constraint__Group__4__Impl"


    // $ANTLR start "rule__Constraint__Group__5"
    // InternalHelloWeb.g:2057:1: rule__Constraint__Group__5 : rule__Constraint__Group__5__Impl ;
    public final void rule__Constraint__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:2061:1: ( rule__Constraint__Group__5__Impl )
            // InternalHelloWeb.g:2062:2: rule__Constraint__Group__5__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Constraint__Group__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constraint__Group__5"


    // $ANTLR start "rule__Constraint__Group__5__Impl"
    // InternalHelloWeb.g:2068:1: rule__Constraint__Group__5__Impl : ( '}' ) ;
    public final void rule__Constraint__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:2072:1: ( ( '}' ) )
            // InternalHelloWeb.g:2073:1: ( '}' )
            {
            // InternalHelloWeb.g:2073:1: ( '}' )
            // InternalHelloWeb.g:2074:2: '}'
            {
             before(grammarAccess.getConstraintAccess().getRightCurlyBracketKeyword_5()); 
            match(input,30,FOLLOW_2); 
             after(grammarAccess.getConstraintAccess().getRightCurlyBracketKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constraint__Group__5__Impl"


    // $ANTLR start "rule__Constraint__Group_4__0"
    // InternalHelloWeb.g:2084:1: rule__Constraint__Group_4__0 : rule__Constraint__Group_4__0__Impl rule__Constraint__Group_4__1 ;
    public final void rule__Constraint__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:2088:1: ( rule__Constraint__Group_4__0__Impl rule__Constraint__Group_4__1 )
            // InternalHelloWeb.g:2089:2: rule__Constraint__Group_4__0__Impl rule__Constraint__Group_4__1
            {
            pushFollow(FOLLOW_14);
            rule__Constraint__Group_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Constraint__Group_4__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constraint__Group_4__0"


    // $ANTLR start "rule__Constraint__Group_4__0__Impl"
    // InternalHelloWeb.g:2096:1: rule__Constraint__Group_4__0__Impl : ( 'samplingRate:' ) ;
    public final void rule__Constraint__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:2100:1: ( ( 'samplingRate:' ) )
            // InternalHelloWeb.g:2101:1: ( 'samplingRate:' )
            {
            // InternalHelloWeb.g:2101:1: ( 'samplingRate:' )
            // InternalHelloWeb.g:2102:2: 'samplingRate:'
            {
             before(grammarAccess.getConstraintAccess().getSamplingRateKeyword_4_0()); 
            match(input,36,FOLLOW_2); 
             after(grammarAccess.getConstraintAccess().getSamplingRateKeyword_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constraint__Group_4__0__Impl"


    // $ANTLR start "rule__Constraint__Group_4__1"
    // InternalHelloWeb.g:2111:1: rule__Constraint__Group_4__1 : rule__Constraint__Group_4__1__Impl ;
    public final void rule__Constraint__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:2115:1: ( rule__Constraint__Group_4__1__Impl )
            // InternalHelloWeb.g:2116:2: rule__Constraint__Group_4__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Constraint__Group_4__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constraint__Group_4__1"


    // $ANTLR start "rule__Constraint__Group_4__1__Impl"
    // InternalHelloWeb.g:2122:1: rule__Constraint__Group_4__1__Impl : ( ( rule__Constraint__SamplingRateAssignment_4_1 ) ) ;
    public final void rule__Constraint__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:2126:1: ( ( ( rule__Constraint__SamplingRateAssignment_4_1 ) ) )
            // InternalHelloWeb.g:2127:1: ( ( rule__Constraint__SamplingRateAssignment_4_1 ) )
            {
            // InternalHelloWeb.g:2127:1: ( ( rule__Constraint__SamplingRateAssignment_4_1 ) )
            // InternalHelloWeb.g:2128:2: ( rule__Constraint__SamplingRateAssignment_4_1 )
            {
             before(grammarAccess.getConstraintAccess().getSamplingRateAssignment_4_1()); 
            // InternalHelloWeb.g:2129:2: ( rule__Constraint__SamplingRateAssignment_4_1 )
            // InternalHelloWeb.g:2129:3: rule__Constraint__SamplingRateAssignment_4_1
            {
            pushFollow(FOLLOW_2);
            rule__Constraint__SamplingRateAssignment_4_1();

            state._fsp--;


            }

             after(grammarAccess.getConstraintAccess().getSamplingRateAssignment_4_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constraint__Group_4__1__Impl"


    // $ANTLR start "rule__NestedLogicalCondition__Group__0"
    // InternalHelloWeb.g:2138:1: rule__NestedLogicalCondition__Group__0 : rule__NestedLogicalCondition__Group__0__Impl rule__NestedLogicalCondition__Group__1 ;
    public final void rule__NestedLogicalCondition__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:2142:1: ( rule__NestedLogicalCondition__Group__0__Impl rule__NestedLogicalCondition__Group__1 )
            // InternalHelloWeb.g:2143:2: rule__NestedLogicalCondition__Group__0__Impl rule__NestedLogicalCondition__Group__1
            {
            pushFollow(FOLLOW_17);
            rule__NestedLogicalCondition__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__NestedLogicalCondition__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NestedLogicalCondition__Group__0"


    // $ANTLR start "rule__NestedLogicalCondition__Group__0__Impl"
    // InternalHelloWeb.g:2150:1: rule__NestedLogicalCondition__Group__0__Impl : ( '(' ) ;
    public final void rule__NestedLogicalCondition__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:2154:1: ( ( '(' ) )
            // InternalHelloWeb.g:2155:1: ( '(' )
            {
            // InternalHelloWeb.g:2155:1: ( '(' )
            // InternalHelloWeb.g:2156:2: '('
            {
             before(grammarAccess.getNestedLogicalConditionAccess().getLeftParenthesisKeyword_0()); 
            match(input,37,FOLLOW_2); 
             after(grammarAccess.getNestedLogicalConditionAccess().getLeftParenthesisKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NestedLogicalCondition__Group__0__Impl"


    // $ANTLR start "rule__NestedLogicalCondition__Group__1"
    // InternalHelloWeb.g:2165:1: rule__NestedLogicalCondition__Group__1 : rule__NestedLogicalCondition__Group__1__Impl rule__NestedLogicalCondition__Group__2 ;
    public final void rule__NestedLogicalCondition__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:2169:1: ( rule__NestedLogicalCondition__Group__1__Impl rule__NestedLogicalCondition__Group__2 )
            // InternalHelloWeb.g:2170:2: rule__NestedLogicalCondition__Group__1__Impl rule__NestedLogicalCondition__Group__2
            {
            pushFollow(FOLLOW_18);
            rule__NestedLogicalCondition__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__NestedLogicalCondition__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NestedLogicalCondition__Group__1"


    // $ANTLR start "rule__NestedLogicalCondition__Group__1__Impl"
    // InternalHelloWeb.g:2177:1: rule__NestedLogicalCondition__Group__1__Impl : ( ( rule__NestedLogicalCondition__LeftAssignment_1 ) ) ;
    public final void rule__NestedLogicalCondition__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:2181:1: ( ( ( rule__NestedLogicalCondition__LeftAssignment_1 ) ) )
            // InternalHelloWeb.g:2182:1: ( ( rule__NestedLogicalCondition__LeftAssignment_1 ) )
            {
            // InternalHelloWeb.g:2182:1: ( ( rule__NestedLogicalCondition__LeftAssignment_1 ) )
            // InternalHelloWeb.g:2183:2: ( rule__NestedLogicalCondition__LeftAssignment_1 )
            {
             before(grammarAccess.getNestedLogicalConditionAccess().getLeftAssignment_1()); 
            // InternalHelloWeb.g:2184:2: ( rule__NestedLogicalCondition__LeftAssignment_1 )
            // InternalHelloWeb.g:2184:3: rule__NestedLogicalCondition__LeftAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__NestedLogicalCondition__LeftAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getNestedLogicalConditionAccess().getLeftAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NestedLogicalCondition__Group__1__Impl"


    // $ANTLR start "rule__NestedLogicalCondition__Group__2"
    // InternalHelloWeb.g:2192:1: rule__NestedLogicalCondition__Group__2 : rule__NestedLogicalCondition__Group__2__Impl rule__NestedLogicalCondition__Group__3 ;
    public final void rule__NestedLogicalCondition__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:2196:1: ( rule__NestedLogicalCondition__Group__2__Impl rule__NestedLogicalCondition__Group__3 )
            // InternalHelloWeb.g:2197:2: rule__NestedLogicalCondition__Group__2__Impl rule__NestedLogicalCondition__Group__3
            {
            pushFollow(FOLLOW_20);
            rule__NestedLogicalCondition__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__NestedLogicalCondition__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NestedLogicalCondition__Group__2"


    // $ANTLR start "rule__NestedLogicalCondition__Group__2__Impl"
    // InternalHelloWeb.g:2204:1: rule__NestedLogicalCondition__Group__2__Impl : ( ')' ) ;
    public final void rule__NestedLogicalCondition__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:2208:1: ( ( ')' ) )
            // InternalHelloWeb.g:2209:1: ( ')' )
            {
            // InternalHelloWeb.g:2209:1: ( ')' )
            // InternalHelloWeb.g:2210:2: ')'
            {
             before(grammarAccess.getNestedLogicalConditionAccess().getRightParenthesisKeyword_2()); 
            match(input,38,FOLLOW_2); 
             after(grammarAccess.getNestedLogicalConditionAccess().getRightParenthesisKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NestedLogicalCondition__Group__2__Impl"


    // $ANTLR start "rule__NestedLogicalCondition__Group__3"
    // InternalHelloWeb.g:2219:1: rule__NestedLogicalCondition__Group__3 : rule__NestedLogicalCondition__Group__3__Impl rule__NestedLogicalCondition__Group__4 ;
    public final void rule__NestedLogicalCondition__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:2223:1: ( rule__NestedLogicalCondition__Group__3__Impl rule__NestedLogicalCondition__Group__4 )
            // InternalHelloWeb.g:2224:2: rule__NestedLogicalCondition__Group__3__Impl rule__NestedLogicalCondition__Group__4
            {
            pushFollow(FOLLOW_21);
            rule__NestedLogicalCondition__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__NestedLogicalCondition__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NestedLogicalCondition__Group__3"


    // $ANTLR start "rule__NestedLogicalCondition__Group__3__Impl"
    // InternalHelloWeb.g:2231:1: rule__NestedLogicalCondition__Group__3__Impl : ( ( rule__NestedLogicalCondition__OperatorAssignment_3 ) ) ;
    public final void rule__NestedLogicalCondition__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:2235:1: ( ( ( rule__NestedLogicalCondition__OperatorAssignment_3 ) ) )
            // InternalHelloWeb.g:2236:1: ( ( rule__NestedLogicalCondition__OperatorAssignment_3 ) )
            {
            // InternalHelloWeb.g:2236:1: ( ( rule__NestedLogicalCondition__OperatorAssignment_3 ) )
            // InternalHelloWeb.g:2237:2: ( rule__NestedLogicalCondition__OperatorAssignment_3 )
            {
             before(grammarAccess.getNestedLogicalConditionAccess().getOperatorAssignment_3()); 
            // InternalHelloWeb.g:2238:2: ( rule__NestedLogicalCondition__OperatorAssignment_3 )
            // InternalHelloWeb.g:2238:3: rule__NestedLogicalCondition__OperatorAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__NestedLogicalCondition__OperatorAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getNestedLogicalConditionAccess().getOperatorAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NestedLogicalCondition__Group__3__Impl"


    // $ANTLR start "rule__NestedLogicalCondition__Group__4"
    // InternalHelloWeb.g:2246:1: rule__NestedLogicalCondition__Group__4 : rule__NestedLogicalCondition__Group__4__Impl rule__NestedLogicalCondition__Group__5 ;
    public final void rule__NestedLogicalCondition__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:2250:1: ( rule__NestedLogicalCondition__Group__4__Impl rule__NestedLogicalCondition__Group__5 )
            // InternalHelloWeb.g:2251:2: rule__NestedLogicalCondition__Group__4__Impl rule__NestedLogicalCondition__Group__5
            {
            pushFollow(FOLLOW_17);
            rule__NestedLogicalCondition__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__NestedLogicalCondition__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NestedLogicalCondition__Group__4"


    // $ANTLR start "rule__NestedLogicalCondition__Group__4__Impl"
    // InternalHelloWeb.g:2258:1: rule__NestedLogicalCondition__Group__4__Impl : ( '(' ) ;
    public final void rule__NestedLogicalCondition__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:2262:1: ( ( '(' ) )
            // InternalHelloWeb.g:2263:1: ( '(' )
            {
            // InternalHelloWeb.g:2263:1: ( '(' )
            // InternalHelloWeb.g:2264:2: '('
            {
             before(grammarAccess.getNestedLogicalConditionAccess().getLeftParenthesisKeyword_4()); 
            match(input,37,FOLLOW_2); 
             after(grammarAccess.getNestedLogicalConditionAccess().getLeftParenthesisKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NestedLogicalCondition__Group__4__Impl"


    // $ANTLR start "rule__NestedLogicalCondition__Group__5"
    // InternalHelloWeb.g:2273:1: rule__NestedLogicalCondition__Group__5 : rule__NestedLogicalCondition__Group__5__Impl rule__NestedLogicalCondition__Group__6 ;
    public final void rule__NestedLogicalCondition__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:2277:1: ( rule__NestedLogicalCondition__Group__5__Impl rule__NestedLogicalCondition__Group__6 )
            // InternalHelloWeb.g:2278:2: rule__NestedLogicalCondition__Group__5__Impl rule__NestedLogicalCondition__Group__6
            {
            pushFollow(FOLLOW_18);
            rule__NestedLogicalCondition__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__NestedLogicalCondition__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NestedLogicalCondition__Group__5"


    // $ANTLR start "rule__NestedLogicalCondition__Group__5__Impl"
    // InternalHelloWeb.g:2285:1: rule__NestedLogicalCondition__Group__5__Impl : ( ( rule__NestedLogicalCondition__RightAssignment_5 ) ) ;
    public final void rule__NestedLogicalCondition__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:2289:1: ( ( ( rule__NestedLogicalCondition__RightAssignment_5 ) ) )
            // InternalHelloWeb.g:2290:1: ( ( rule__NestedLogicalCondition__RightAssignment_5 ) )
            {
            // InternalHelloWeb.g:2290:1: ( ( rule__NestedLogicalCondition__RightAssignment_5 ) )
            // InternalHelloWeb.g:2291:2: ( rule__NestedLogicalCondition__RightAssignment_5 )
            {
             before(grammarAccess.getNestedLogicalConditionAccess().getRightAssignment_5()); 
            // InternalHelloWeb.g:2292:2: ( rule__NestedLogicalCondition__RightAssignment_5 )
            // InternalHelloWeb.g:2292:3: rule__NestedLogicalCondition__RightAssignment_5
            {
            pushFollow(FOLLOW_2);
            rule__NestedLogicalCondition__RightAssignment_5();

            state._fsp--;


            }

             after(grammarAccess.getNestedLogicalConditionAccess().getRightAssignment_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NestedLogicalCondition__Group__5__Impl"


    // $ANTLR start "rule__NestedLogicalCondition__Group__6"
    // InternalHelloWeb.g:2300:1: rule__NestedLogicalCondition__Group__6 : rule__NestedLogicalCondition__Group__6__Impl ;
    public final void rule__NestedLogicalCondition__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:2304:1: ( rule__NestedLogicalCondition__Group__6__Impl )
            // InternalHelloWeb.g:2305:2: rule__NestedLogicalCondition__Group__6__Impl
            {
            pushFollow(FOLLOW_2);
            rule__NestedLogicalCondition__Group__6__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NestedLogicalCondition__Group__6"


    // $ANTLR start "rule__NestedLogicalCondition__Group__6__Impl"
    // InternalHelloWeb.g:2311:1: rule__NestedLogicalCondition__Group__6__Impl : ( ')' ) ;
    public final void rule__NestedLogicalCondition__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:2315:1: ( ( ')' ) )
            // InternalHelloWeb.g:2316:1: ( ')' )
            {
            // InternalHelloWeb.g:2316:1: ( ')' )
            // InternalHelloWeb.g:2317:2: ')'
            {
             before(grammarAccess.getNestedLogicalConditionAccess().getRightParenthesisKeyword_6()); 
            match(input,38,FOLLOW_2); 
             after(grammarAccess.getNestedLogicalConditionAccess().getRightParenthesisKeyword_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NestedLogicalCondition__Group__6__Impl"


    // $ANTLR start "rule__Comparison__Group__0"
    // InternalHelloWeb.g:2327:1: rule__Comparison__Group__0 : rule__Comparison__Group__0__Impl rule__Comparison__Group__1 ;
    public final void rule__Comparison__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:2331:1: ( rule__Comparison__Group__0__Impl rule__Comparison__Group__1 )
            // InternalHelloWeb.g:2332:2: rule__Comparison__Group__0__Impl rule__Comparison__Group__1
            {
            pushFollow(FOLLOW_22);
            rule__Comparison__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Comparison__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Comparison__Group__0"


    // $ANTLR start "rule__Comparison__Group__0__Impl"
    // InternalHelloWeb.g:2339:1: rule__Comparison__Group__0__Impl : ( ( rule__Comparison__LeftAssignment_0 ) ) ;
    public final void rule__Comparison__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:2343:1: ( ( ( rule__Comparison__LeftAssignment_0 ) ) )
            // InternalHelloWeb.g:2344:1: ( ( rule__Comparison__LeftAssignment_0 ) )
            {
            // InternalHelloWeb.g:2344:1: ( ( rule__Comparison__LeftAssignment_0 ) )
            // InternalHelloWeb.g:2345:2: ( rule__Comparison__LeftAssignment_0 )
            {
             before(grammarAccess.getComparisonAccess().getLeftAssignment_0()); 
            // InternalHelloWeb.g:2346:2: ( rule__Comparison__LeftAssignment_0 )
            // InternalHelloWeb.g:2346:3: rule__Comparison__LeftAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__Comparison__LeftAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getComparisonAccess().getLeftAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Comparison__Group__0__Impl"


    // $ANTLR start "rule__Comparison__Group__1"
    // InternalHelloWeb.g:2354:1: rule__Comparison__Group__1 : rule__Comparison__Group__1__Impl rule__Comparison__Group__2 ;
    public final void rule__Comparison__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:2358:1: ( rule__Comparison__Group__1__Impl rule__Comparison__Group__2 )
            // InternalHelloWeb.g:2359:2: rule__Comparison__Group__1__Impl rule__Comparison__Group__2
            {
            pushFollow(FOLLOW_23);
            rule__Comparison__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Comparison__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Comparison__Group__1"


    // $ANTLR start "rule__Comparison__Group__1__Impl"
    // InternalHelloWeb.g:2366:1: rule__Comparison__Group__1__Impl : ( ( rule__Comparison__OperatorAssignment_1 ) ) ;
    public final void rule__Comparison__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:2370:1: ( ( ( rule__Comparison__OperatorAssignment_1 ) ) )
            // InternalHelloWeb.g:2371:1: ( ( rule__Comparison__OperatorAssignment_1 ) )
            {
            // InternalHelloWeb.g:2371:1: ( ( rule__Comparison__OperatorAssignment_1 ) )
            // InternalHelloWeb.g:2372:2: ( rule__Comparison__OperatorAssignment_1 )
            {
             before(grammarAccess.getComparisonAccess().getOperatorAssignment_1()); 
            // InternalHelloWeb.g:2373:2: ( rule__Comparison__OperatorAssignment_1 )
            // InternalHelloWeb.g:2373:3: rule__Comparison__OperatorAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Comparison__OperatorAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getComparisonAccess().getOperatorAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Comparison__Group__1__Impl"


    // $ANTLR start "rule__Comparison__Group__2"
    // InternalHelloWeb.g:2381:1: rule__Comparison__Group__2 : rule__Comparison__Group__2__Impl ;
    public final void rule__Comparison__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:2385:1: ( rule__Comparison__Group__2__Impl )
            // InternalHelloWeb.g:2386:2: rule__Comparison__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Comparison__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Comparison__Group__2"


    // $ANTLR start "rule__Comparison__Group__2__Impl"
    // InternalHelloWeb.g:2392:1: rule__Comparison__Group__2__Impl : ( ( rule__Comparison__RightAssignment_2 ) ) ;
    public final void rule__Comparison__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:2396:1: ( ( ( rule__Comparison__RightAssignment_2 ) ) )
            // InternalHelloWeb.g:2397:1: ( ( rule__Comparison__RightAssignment_2 ) )
            {
            // InternalHelloWeb.g:2397:1: ( ( rule__Comparison__RightAssignment_2 ) )
            // InternalHelloWeb.g:2398:2: ( rule__Comparison__RightAssignment_2 )
            {
             before(grammarAccess.getComparisonAccess().getRightAssignment_2()); 
            // InternalHelloWeb.g:2399:2: ( rule__Comparison__RightAssignment_2 )
            // InternalHelloWeb.g:2399:3: rule__Comparison__RightAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__Comparison__RightAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getComparisonAccess().getRightAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Comparison__Group__2__Impl"


    // $ANTLR start "rule__ComparisonValue__Group_2__0"
    // InternalHelloWeb.g:2408:1: rule__ComparisonValue__Group_2__0 : rule__ComparisonValue__Group_2__0__Impl rule__ComparisonValue__Group_2__1 ;
    public final void rule__ComparisonValue__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:2412:1: ( rule__ComparisonValue__Group_2__0__Impl rule__ComparisonValue__Group_2__1 )
            // InternalHelloWeb.g:2413:2: rule__ComparisonValue__Group_2__0__Impl rule__ComparisonValue__Group_2__1
            {
            pushFollow(FOLLOW_23);
            rule__ComparisonValue__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ComparisonValue__Group_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ComparisonValue__Group_2__0"


    // $ANTLR start "rule__ComparisonValue__Group_2__0__Impl"
    // InternalHelloWeb.g:2420:1: rule__ComparisonValue__Group_2__0__Impl : ( () ) ;
    public final void rule__ComparisonValue__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:2424:1: ( ( () ) )
            // InternalHelloWeb.g:2425:1: ( () )
            {
            // InternalHelloWeb.g:2425:1: ( () )
            // InternalHelloWeb.g:2426:2: ()
            {
             before(grammarAccess.getComparisonValueAccess().getComparisonValueAction_2_0()); 
            // InternalHelloWeb.g:2427:2: ()
            // InternalHelloWeb.g:2427:3: 
            {
            }

             after(grammarAccess.getComparisonValueAccess().getComparisonValueAction_2_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ComparisonValue__Group_2__0__Impl"


    // $ANTLR start "rule__ComparisonValue__Group_2__1"
    // InternalHelloWeb.g:2435:1: rule__ComparisonValue__Group_2__1 : rule__ComparisonValue__Group_2__1__Impl ;
    public final void rule__ComparisonValue__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:2439:1: ( rule__ComparisonValue__Group_2__1__Impl )
            // InternalHelloWeb.g:2440:2: rule__ComparisonValue__Group_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ComparisonValue__Group_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ComparisonValue__Group_2__1"


    // $ANTLR start "rule__ComparisonValue__Group_2__1__Impl"
    // InternalHelloWeb.g:2446:1: rule__ComparisonValue__Group_2__1__Impl : ( ( rule__ComparisonValue__ValueAssignment_2_1 ) ) ;
    public final void rule__ComparisonValue__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:2450:1: ( ( ( rule__ComparisonValue__ValueAssignment_2_1 ) ) )
            // InternalHelloWeb.g:2451:1: ( ( rule__ComparisonValue__ValueAssignment_2_1 ) )
            {
            // InternalHelloWeb.g:2451:1: ( ( rule__ComparisonValue__ValueAssignment_2_1 ) )
            // InternalHelloWeb.g:2452:2: ( rule__ComparisonValue__ValueAssignment_2_1 )
            {
             before(grammarAccess.getComparisonValueAccess().getValueAssignment_2_1()); 
            // InternalHelloWeb.g:2453:2: ( rule__ComparisonValue__ValueAssignment_2_1 )
            // InternalHelloWeb.g:2453:3: rule__ComparisonValue__ValueAssignment_2_1
            {
            pushFollow(FOLLOW_2);
            rule__ComparisonValue__ValueAssignment_2_1();

            state._fsp--;


            }

             after(grammarAccess.getComparisonValueAccess().getValueAssignment_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ComparisonValue__Group_2__1__Impl"


    // $ANTLR start "rule__ValueRef__Group__0"
    // InternalHelloWeb.g:2462:1: rule__ValueRef__Group__0 : rule__ValueRef__Group__0__Impl rule__ValueRef__Group__1 ;
    public final void rule__ValueRef__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:2466:1: ( rule__ValueRef__Group__0__Impl rule__ValueRef__Group__1 )
            // InternalHelloWeb.g:2467:2: rule__ValueRef__Group__0__Impl rule__ValueRef__Group__1
            {
            pushFollow(FOLLOW_4);
            rule__ValueRef__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ValueRef__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ValueRef__Group__0"


    // $ANTLR start "rule__ValueRef__Group__0__Impl"
    // InternalHelloWeb.g:2474:1: rule__ValueRef__Group__0__Impl : ( ( rule__ValueRef__Group_0__0 )? ) ;
    public final void rule__ValueRef__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:2478:1: ( ( ( rule__ValueRef__Group_0__0 )? ) )
            // InternalHelloWeb.g:2479:1: ( ( rule__ValueRef__Group_0__0 )? )
            {
            // InternalHelloWeb.g:2479:1: ( ( rule__ValueRef__Group_0__0 )? )
            // InternalHelloWeb.g:2480:2: ( rule__ValueRef__Group_0__0 )?
            {
             before(grammarAccess.getValueRefAccess().getGroup_0()); 
            // InternalHelloWeb.g:2481:2: ( rule__ValueRef__Group_0__0 )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==RULE_ID) ) {
                int LA19_1 = input.LA(2);

                if ( (LA19_1==39) ) {
                    alt19=1;
                }
            }
            switch (alt19) {
                case 1 :
                    // InternalHelloWeb.g:2481:3: rule__ValueRef__Group_0__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__ValueRef__Group_0__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getValueRefAccess().getGroup_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ValueRef__Group__0__Impl"


    // $ANTLR start "rule__ValueRef__Group__1"
    // InternalHelloWeb.g:2489:1: rule__ValueRef__Group__1 : rule__ValueRef__Group__1__Impl ;
    public final void rule__ValueRef__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:2493:1: ( rule__ValueRef__Group__1__Impl )
            // InternalHelloWeb.g:2494:2: rule__ValueRef__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ValueRef__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ValueRef__Group__1"


    // $ANTLR start "rule__ValueRef__Group__1__Impl"
    // InternalHelloWeb.g:2500:1: rule__ValueRef__Group__1__Impl : ( ( rule__ValueRef__OutAssignment_1 ) ) ;
    public final void rule__ValueRef__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:2504:1: ( ( ( rule__ValueRef__OutAssignment_1 ) ) )
            // InternalHelloWeb.g:2505:1: ( ( rule__ValueRef__OutAssignment_1 ) )
            {
            // InternalHelloWeb.g:2505:1: ( ( rule__ValueRef__OutAssignment_1 ) )
            // InternalHelloWeb.g:2506:2: ( rule__ValueRef__OutAssignment_1 )
            {
             before(grammarAccess.getValueRefAccess().getOutAssignment_1()); 
            // InternalHelloWeb.g:2507:2: ( rule__ValueRef__OutAssignment_1 )
            // InternalHelloWeb.g:2507:3: rule__ValueRef__OutAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__ValueRef__OutAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getValueRefAccess().getOutAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ValueRef__Group__1__Impl"


    // $ANTLR start "rule__ValueRef__Group_0__0"
    // InternalHelloWeb.g:2516:1: rule__ValueRef__Group_0__0 : rule__ValueRef__Group_0__0__Impl rule__ValueRef__Group_0__1 ;
    public final void rule__ValueRef__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:2520:1: ( rule__ValueRef__Group_0__0__Impl rule__ValueRef__Group_0__1 )
            // InternalHelloWeb.g:2521:2: rule__ValueRef__Group_0__0__Impl rule__ValueRef__Group_0__1
            {
            pushFollow(FOLLOW_24);
            rule__ValueRef__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ValueRef__Group_0__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ValueRef__Group_0__0"


    // $ANTLR start "rule__ValueRef__Group_0__0__Impl"
    // InternalHelloWeb.g:2528:1: rule__ValueRef__Group_0__0__Impl : ( ( rule__ValueRef__SensorInstantiationAssignment_0_0 ) ) ;
    public final void rule__ValueRef__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:2532:1: ( ( ( rule__ValueRef__SensorInstantiationAssignment_0_0 ) ) )
            // InternalHelloWeb.g:2533:1: ( ( rule__ValueRef__SensorInstantiationAssignment_0_0 ) )
            {
            // InternalHelloWeb.g:2533:1: ( ( rule__ValueRef__SensorInstantiationAssignment_0_0 ) )
            // InternalHelloWeb.g:2534:2: ( rule__ValueRef__SensorInstantiationAssignment_0_0 )
            {
             before(grammarAccess.getValueRefAccess().getSensorInstantiationAssignment_0_0()); 
            // InternalHelloWeb.g:2535:2: ( rule__ValueRef__SensorInstantiationAssignment_0_0 )
            // InternalHelloWeb.g:2535:3: rule__ValueRef__SensorInstantiationAssignment_0_0
            {
            pushFollow(FOLLOW_2);
            rule__ValueRef__SensorInstantiationAssignment_0_0();

            state._fsp--;


            }

             after(grammarAccess.getValueRefAccess().getSensorInstantiationAssignment_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ValueRef__Group_0__0__Impl"


    // $ANTLR start "rule__ValueRef__Group_0__1"
    // InternalHelloWeb.g:2543:1: rule__ValueRef__Group_0__1 : rule__ValueRef__Group_0__1__Impl ;
    public final void rule__ValueRef__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:2547:1: ( rule__ValueRef__Group_0__1__Impl )
            // InternalHelloWeb.g:2548:2: rule__ValueRef__Group_0__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ValueRef__Group_0__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ValueRef__Group_0__1"


    // $ANTLR start "rule__ValueRef__Group_0__1__Impl"
    // InternalHelloWeb.g:2554:1: rule__ValueRef__Group_0__1__Impl : ( '.' ) ;
    public final void rule__ValueRef__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:2558:1: ( ( '.' ) )
            // InternalHelloWeb.g:2559:1: ( '.' )
            {
            // InternalHelloWeb.g:2559:1: ( '.' )
            // InternalHelloWeb.g:2560:2: '.'
            {
             before(grammarAccess.getValueRefAccess().getFullStopKeyword_0_1()); 
            match(input,39,FOLLOW_2); 
             after(grammarAccess.getValueRefAccess().getFullStopKeyword_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ValueRef__Group_0__1__Impl"


    // $ANTLR start "rule__TimeUnit__Group__0"
    // InternalHelloWeb.g:2570:1: rule__TimeUnit__Group__0 : rule__TimeUnit__Group__0__Impl rule__TimeUnit__Group__1 ;
    public final void rule__TimeUnit__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:2574:1: ( rule__TimeUnit__Group__0__Impl rule__TimeUnit__Group__1 )
            // InternalHelloWeb.g:2575:2: rule__TimeUnit__Group__0__Impl rule__TimeUnit__Group__1
            {
            pushFollow(FOLLOW_25);
            rule__TimeUnit__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TimeUnit__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TimeUnit__Group__0"


    // $ANTLR start "rule__TimeUnit__Group__0__Impl"
    // InternalHelloWeb.g:2582:1: rule__TimeUnit__Group__0__Impl : ( RULE_INT ) ;
    public final void rule__TimeUnit__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:2586:1: ( ( RULE_INT ) )
            // InternalHelloWeb.g:2587:1: ( RULE_INT )
            {
            // InternalHelloWeb.g:2587:1: ( RULE_INT )
            // InternalHelloWeb.g:2588:2: RULE_INT
            {
             before(grammarAccess.getTimeUnitAccess().getINTTerminalRuleCall_0()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getTimeUnitAccess().getINTTerminalRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TimeUnit__Group__0__Impl"


    // $ANTLR start "rule__TimeUnit__Group__1"
    // InternalHelloWeb.g:2597:1: rule__TimeUnit__Group__1 : rule__TimeUnit__Group__1__Impl ;
    public final void rule__TimeUnit__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:2601:1: ( rule__TimeUnit__Group__1__Impl )
            // InternalHelloWeb.g:2602:2: rule__TimeUnit__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__TimeUnit__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TimeUnit__Group__1"


    // $ANTLR start "rule__TimeUnit__Group__1__Impl"
    // InternalHelloWeb.g:2608:1: rule__TimeUnit__Group__1__Impl : ( ( rule__TimeUnit__Alternatives_1 ) ) ;
    public final void rule__TimeUnit__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:2612:1: ( ( ( rule__TimeUnit__Alternatives_1 ) ) )
            // InternalHelloWeb.g:2613:1: ( ( rule__TimeUnit__Alternatives_1 ) )
            {
            // InternalHelloWeb.g:2613:1: ( ( rule__TimeUnit__Alternatives_1 ) )
            // InternalHelloWeb.g:2614:2: ( rule__TimeUnit__Alternatives_1 )
            {
             before(grammarAccess.getTimeUnitAccess().getAlternatives_1()); 
            // InternalHelloWeb.g:2615:2: ( rule__TimeUnit__Alternatives_1 )
            // InternalHelloWeb.g:2615:3: rule__TimeUnit__Alternatives_1
            {
            pushFollow(FOLLOW_2);
            rule__TimeUnit__Alternatives_1();

            state._fsp--;


            }

             after(grammarAccess.getTimeUnitAccess().getAlternatives_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TimeUnit__Group__1__Impl"


    // $ANTLR start "rule__Decimal__Group__0"
    // InternalHelloWeb.g:2624:1: rule__Decimal__Group__0 : rule__Decimal__Group__0__Impl rule__Decimal__Group__1 ;
    public final void rule__Decimal__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:2628:1: ( rule__Decimal__Group__0__Impl rule__Decimal__Group__1 )
            // InternalHelloWeb.g:2629:2: rule__Decimal__Group__0__Impl rule__Decimal__Group__1
            {
            pushFollow(FOLLOW_24);
            rule__Decimal__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Decimal__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Decimal__Group__0"


    // $ANTLR start "rule__Decimal__Group__0__Impl"
    // InternalHelloWeb.g:2636:1: rule__Decimal__Group__0__Impl : ( ( rule__Decimal__LeftAssignment_0 ) ) ;
    public final void rule__Decimal__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:2640:1: ( ( ( rule__Decimal__LeftAssignment_0 ) ) )
            // InternalHelloWeb.g:2641:1: ( ( rule__Decimal__LeftAssignment_0 ) )
            {
            // InternalHelloWeb.g:2641:1: ( ( rule__Decimal__LeftAssignment_0 ) )
            // InternalHelloWeb.g:2642:2: ( rule__Decimal__LeftAssignment_0 )
            {
             before(grammarAccess.getDecimalAccess().getLeftAssignment_0()); 
            // InternalHelloWeb.g:2643:2: ( rule__Decimal__LeftAssignment_0 )
            // InternalHelloWeb.g:2643:3: rule__Decimal__LeftAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__Decimal__LeftAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getDecimalAccess().getLeftAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Decimal__Group__0__Impl"


    // $ANTLR start "rule__Decimal__Group__1"
    // InternalHelloWeb.g:2651:1: rule__Decimal__Group__1 : rule__Decimal__Group__1__Impl rule__Decimal__Group__2 ;
    public final void rule__Decimal__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:2655:1: ( rule__Decimal__Group__1__Impl rule__Decimal__Group__2 )
            // InternalHelloWeb.g:2656:2: rule__Decimal__Group__1__Impl rule__Decimal__Group__2
            {
            pushFollow(FOLLOW_14);
            rule__Decimal__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Decimal__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Decimal__Group__1"


    // $ANTLR start "rule__Decimal__Group__1__Impl"
    // InternalHelloWeb.g:2663:1: rule__Decimal__Group__1__Impl : ( '.' ) ;
    public final void rule__Decimal__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:2667:1: ( ( '.' ) )
            // InternalHelloWeb.g:2668:1: ( '.' )
            {
            // InternalHelloWeb.g:2668:1: ( '.' )
            // InternalHelloWeb.g:2669:2: '.'
            {
             before(grammarAccess.getDecimalAccess().getFullStopKeyword_1()); 
            match(input,39,FOLLOW_2); 
             after(grammarAccess.getDecimalAccess().getFullStopKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Decimal__Group__1__Impl"


    // $ANTLR start "rule__Decimal__Group__2"
    // InternalHelloWeb.g:2678:1: rule__Decimal__Group__2 : rule__Decimal__Group__2__Impl ;
    public final void rule__Decimal__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:2682:1: ( rule__Decimal__Group__2__Impl )
            // InternalHelloWeb.g:2683:2: rule__Decimal__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Decimal__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Decimal__Group__2"


    // $ANTLR start "rule__Decimal__Group__2__Impl"
    // InternalHelloWeb.g:2689:1: rule__Decimal__Group__2__Impl : ( ( rule__Decimal__RightAssignment_2 ) ) ;
    public final void rule__Decimal__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:2693:1: ( ( ( rule__Decimal__RightAssignment_2 ) ) )
            // InternalHelloWeb.g:2694:1: ( ( rule__Decimal__RightAssignment_2 ) )
            {
            // InternalHelloWeb.g:2694:1: ( ( rule__Decimal__RightAssignment_2 ) )
            // InternalHelloWeb.g:2695:2: ( rule__Decimal__RightAssignment_2 )
            {
             before(grammarAccess.getDecimalAccess().getRightAssignment_2()); 
            // InternalHelloWeb.g:2696:2: ( rule__Decimal__RightAssignment_2 )
            // InternalHelloWeb.g:2696:3: rule__Decimal__RightAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__Decimal__RightAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getDecimalAccess().getRightAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Decimal__Group__2__Impl"


    // $ANTLR start "rule__SensorConfig__SensorsAssignment_0"
    // InternalHelloWeb.g:2705:1: rule__SensorConfig__SensorsAssignment_0 : ( ruleSensor ) ;
    public final void rule__SensorConfig__SensorsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:2709:1: ( ( ruleSensor ) )
            // InternalHelloWeb.g:2710:2: ( ruleSensor )
            {
            // InternalHelloWeb.g:2710:2: ( ruleSensor )
            // InternalHelloWeb.g:2711:3: ruleSensor
            {
             before(grammarAccess.getSensorConfigAccess().getSensorsSensorParserRuleCall_0_0()); 
            pushFollow(FOLLOW_2);
            ruleSensor();

            state._fsp--;

             after(grammarAccess.getSensorConfigAccess().getSensorsSensorParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SensorConfig__SensorsAssignment_0"


    // $ANTLR start "rule__SensorConfig__DeviceTypesAssignment_1"
    // InternalHelloWeb.g:2720:1: rule__SensorConfig__DeviceTypesAssignment_1 : ( ruleDeviceType ) ;
    public final void rule__SensorConfig__DeviceTypesAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:2724:1: ( ( ruleDeviceType ) )
            // InternalHelloWeb.g:2725:2: ( ruleDeviceType )
            {
            // InternalHelloWeb.g:2725:2: ( ruleDeviceType )
            // InternalHelloWeb.g:2726:3: ruleDeviceType
            {
             before(grammarAccess.getSensorConfigAccess().getDeviceTypesDeviceTypeParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleDeviceType();

            state._fsp--;

             after(grammarAccess.getSensorConfigAccess().getDeviceTypesDeviceTypeParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SensorConfig__DeviceTypesAssignment_1"


    // $ANTLR start "rule__Sensor__NameAssignment_1"
    // InternalHelloWeb.g:2735:1: rule__Sensor__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Sensor__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:2739:1: ( ( RULE_ID ) )
            // InternalHelloWeb.g:2740:2: ( RULE_ID )
            {
            // InternalHelloWeb.g:2740:2: ( RULE_ID )
            // InternalHelloWeb.g:2741:3: RULE_ID
            {
             before(grammarAccess.getSensorAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getSensorAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sensor__NameAssignment_1"


    // $ANTLR start "rule__Sensor__UnitsAssignment_4"
    // InternalHelloWeb.g:2750:1: rule__Sensor__UnitsAssignment_4 : ( ruleSensorUnit ) ;
    public final void rule__Sensor__UnitsAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:2754:1: ( ( ruleSensorUnit ) )
            // InternalHelloWeb.g:2755:2: ( ruleSensorUnit )
            {
            // InternalHelloWeb.g:2755:2: ( ruleSensorUnit )
            // InternalHelloWeb.g:2756:3: ruleSensorUnit
            {
             before(grammarAccess.getSensorAccess().getUnitsSensorUnitParserRuleCall_4_0()); 
            pushFollow(FOLLOW_2);
            ruleSensorUnit();

            state._fsp--;

             after(grammarAccess.getSensorAccess().getUnitsSensorUnitParserRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sensor__UnitsAssignment_4"


    // $ANTLR start "rule__Sensor__UnitsAssignment_5_1"
    // InternalHelloWeb.g:2765:1: rule__Sensor__UnitsAssignment_5_1 : ( ruleSensorUnit ) ;
    public final void rule__Sensor__UnitsAssignment_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:2769:1: ( ( ruleSensorUnit ) )
            // InternalHelloWeb.g:2770:2: ( ruleSensorUnit )
            {
            // InternalHelloWeb.g:2770:2: ( ruleSensorUnit )
            // InternalHelloWeb.g:2771:3: ruleSensorUnit
            {
             before(grammarAccess.getSensorAccess().getUnitsSensorUnitParserRuleCall_5_1_0()); 
            pushFollow(FOLLOW_2);
            ruleSensorUnit();

            state._fsp--;

             after(grammarAccess.getSensorAccess().getUnitsSensorUnitParserRuleCall_5_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sensor__UnitsAssignment_5_1"


    // $ANTLR start "rule__Sensor__ReaderAssignment_7"
    // InternalHelloWeb.g:2780:1: rule__Sensor__ReaderAssignment_7 : ( RULE_ID ) ;
    public final void rule__Sensor__ReaderAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:2784:1: ( ( RULE_ID ) )
            // InternalHelloWeb.g:2785:2: ( RULE_ID )
            {
            // InternalHelloWeb.g:2785:2: ( RULE_ID )
            // InternalHelloWeb.g:2786:3: RULE_ID
            {
             before(grammarAccess.getSensorAccess().getReaderIDTerminalRuleCall_7_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getSensorAccess().getReaderIDTerminalRuleCall_7_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sensor__ReaderAssignment_7"


    // $ANTLR start "rule__Sensor__PinsAssignment_9"
    // InternalHelloWeb.g:2795:1: rule__Sensor__PinsAssignment_9 : ( rulePin ) ;
    public final void rule__Sensor__PinsAssignment_9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:2799:1: ( ( rulePin ) )
            // InternalHelloWeb.g:2800:2: ( rulePin )
            {
            // InternalHelloWeb.g:2800:2: ( rulePin )
            // InternalHelloWeb.g:2801:3: rulePin
            {
             before(grammarAccess.getSensorAccess().getPinsPinParserRuleCall_9_0()); 
            pushFollow(FOLLOW_2);
            rulePin();

            state._fsp--;

             after(grammarAccess.getSensorAccess().getPinsPinParserRuleCall_9_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sensor__PinsAssignment_9"


    // $ANTLR start "rule__Sensor__PinsAssignment_10_1"
    // InternalHelloWeb.g:2810:1: rule__Sensor__PinsAssignment_10_1 : ( rulePin ) ;
    public final void rule__Sensor__PinsAssignment_10_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:2814:1: ( ( rulePin ) )
            // InternalHelloWeb.g:2815:2: ( rulePin )
            {
            // InternalHelloWeb.g:2815:2: ( rulePin )
            // InternalHelloWeb.g:2816:3: rulePin
            {
             before(grammarAccess.getSensorAccess().getPinsPinParserRuleCall_10_1_0()); 
            pushFollow(FOLLOW_2);
            rulePin();

            state._fsp--;

             after(grammarAccess.getSensorAccess().getPinsPinParserRuleCall_10_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sensor__PinsAssignment_10_1"


    // $ANTLR start "rule__Sensor__OutAssignment_12"
    // InternalHelloWeb.g:2825:1: rule__Sensor__OutAssignment_12 : ( ruleOutput ) ;
    public final void rule__Sensor__OutAssignment_12() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:2829:1: ( ( ruleOutput ) )
            // InternalHelloWeb.g:2830:2: ( ruleOutput )
            {
            // InternalHelloWeb.g:2830:2: ( ruleOutput )
            // InternalHelloWeb.g:2831:3: ruleOutput
            {
             before(grammarAccess.getSensorAccess().getOutOutputParserRuleCall_12_0()); 
            pushFollow(FOLLOW_2);
            ruleOutput();

            state._fsp--;

             after(grammarAccess.getSensorAccess().getOutOutputParserRuleCall_12_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sensor__OutAssignment_12"


    // $ANTLR start "rule__Sensor__OutAssignment_13_1"
    // InternalHelloWeb.g:2840:1: rule__Sensor__OutAssignment_13_1 : ( ruleOutput ) ;
    public final void rule__Sensor__OutAssignment_13_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:2844:1: ( ( ruleOutput ) )
            // InternalHelloWeb.g:2845:2: ( ruleOutput )
            {
            // InternalHelloWeb.g:2845:2: ( ruleOutput )
            // InternalHelloWeb.g:2846:3: ruleOutput
            {
             before(grammarAccess.getSensorAccess().getOutOutputParserRuleCall_13_1_0()); 
            pushFollow(FOLLOW_2);
            ruleOutput();

            state._fsp--;

             after(grammarAccess.getSensorAccess().getOutOutputParserRuleCall_13_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Sensor__OutAssignment_13_1"


    // $ANTLR start "rule__DeviceType__NameAssignment_1"
    // InternalHelloWeb.g:2855:1: rule__DeviceType__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__DeviceType__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:2859:1: ( ( RULE_ID ) )
            // InternalHelloWeb.g:2860:2: ( RULE_ID )
            {
            // InternalHelloWeb.g:2860:2: ( RULE_ID )
            // InternalHelloWeb.g:2861:3: RULE_ID
            {
             before(grammarAccess.getDeviceTypeAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getDeviceTypeAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DeviceType__NameAssignment_1"


    // $ANTLR start "rule__DeviceType__SensorInstantiationsAssignment_3"
    // InternalHelloWeb.g:2870:1: rule__DeviceType__SensorInstantiationsAssignment_3 : ( ruleSensorInstantiation ) ;
    public final void rule__DeviceType__SensorInstantiationsAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:2874:1: ( ( ruleSensorInstantiation ) )
            // InternalHelloWeb.g:2875:2: ( ruleSensorInstantiation )
            {
            // InternalHelloWeb.g:2875:2: ( ruleSensorInstantiation )
            // InternalHelloWeb.g:2876:3: ruleSensorInstantiation
            {
             before(grammarAccess.getDeviceTypeAccess().getSensorInstantiationsSensorInstantiationParserRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
            ruleSensorInstantiation();

            state._fsp--;

             after(grammarAccess.getDeviceTypeAccess().getSensorInstantiationsSensorInstantiationParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DeviceType__SensorInstantiationsAssignment_3"


    // $ANTLR start "rule__DeviceType__BatchRatePolicyAssignment_4_1"
    // InternalHelloWeb.g:2885:1: rule__DeviceType__BatchRatePolicyAssignment_4_1 : ( ruleTimeUnit ) ;
    public final void rule__DeviceType__BatchRatePolicyAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:2889:1: ( ( ruleTimeUnit ) )
            // InternalHelloWeb.g:2890:2: ( ruleTimeUnit )
            {
            // InternalHelloWeb.g:2890:2: ( ruleTimeUnit )
            // InternalHelloWeb.g:2891:3: ruleTimeUnit
            {
             before(grammarAccess.getDeviceTypeAccess().getBatchRatePolicyTimeUnitParserRuleCall_4_1_0()); 
            pushFollow(FOLLOW_2);
            ruleTimeUnit();

            state._fsp--;

             after(grammarAccess.getDeviceTypeAccess().getBatchRatePolicyTimeUnitParserRuleCall_4_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DeviceType__BatchRatePolicyAssignment_4_1"


    // $ANTLR start "rule__DeviceType__BatchSizePolicyAssignment_5_1"
    // InternalHelloWeb.g:2900:1: rule__DeviceType__BatchSizePolicyAssignment_5_1 : ( RULE_INT ) ;
    public final void rule__DeviceType__BatchSizePolicyAssignment_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:2904:1: ( ( RULE_INT ) )
            // InternalHelloWeb.g:2905:2: ( RULE_INT )
            {
            // InternalHelloWeb.g:2905:2: ( RULE_INT )
            // InternalHelloWeb.g:2906:3: RULE_INT
            {
             before(grammarAccess.getDeviceTypeAccess().getBatchSizePolicyINTTerminalRuleCall_5_1_0()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getDeviceTypeAccess().getBatchSizePolicyINTTerminalRuleCall_5_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DeviceType__BatchSizePolicyAssignment_5_1"


    // $ANTLR start "rule__DeviceType__HeartBeatPolicyAssignment_6_1"
    // InternalHelloWeb.g:2915:1: rule__DeviceType__HeartBeatPolicyAssignment_6_1 : ( ruleTimeUnit ) ;
    public final void rule__DeviceType__HeartBeatPolicyAssignment_6_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:2919:1: ( ( ruleTimeUnit ) )
            // InternalHelloWeb.g:2920:2: ( ruleTimeUnit )
            {
            // InternalHelloWeb.g:2920:2: ( ruleTimeUnit )
            // InternalHelloWeb.g:2921:3: ruleTimeUnit
            {
             before(grammarAccess.getDeviceTypeAccess().getHeartBeatPolicyTimeUnitParserRuleCall_6_1_0()); 
            pushFollow(FOLLOW_2);
            ruleTimeUnit();

            state._fsp--;

             after(grammarAccess.getDeviceTypeAccess().getHeartBeatPolicyTimeUnitParserRuleCall_6_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DeviceType__HeartBeatPolicyAssignment_6_1"


    // $ANTLR start "rule__SensorInstantiation__SensorAssignment_0"
    // InternalHelloWeb.g:2930:1: rule__SensorInstantiation__SensorAssignment_0 : ( ( RULE_ID ) ) ;
    public final void rule__SensorInstantiation__SensorAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:2934:1: ( ( ( RULE_ID ) ) )
            // InternalHelloWeb.g:2935:2: ( ( RULE_ID ) )
            {
            // InternalHelloWeb.g:2935:2: ( ( RULE_ID ) )
            // InternalHelloWeb.g:2936:3: ( RULE_ID )
            {
             before(grammarAccess.getSensorInstantiationAccess().getSensorSensorCrossReference_0_0()); 
            // InternalHelloWeb.g:2937:3: ( RULE_ID )
            // InternalHelloWeb.g:2938:4: RULE_ID
            {
             before(grammarAccess.getSensorInstantiationAccess().getSensorSensorIDTerminalRuleCall_0_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getSensorInstantiationAccess().getSensorSensorIDTerminalRuleCall_0_0_1()); 

            }

             after(grammarAccess.getSensorInstantiationAccess().getSensorSensorCrossReference_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SensorInstantiation__SensorAssignment_0"


    // $ANTLR start "rule__SensorInstantiation__NameAssignment_1"
    // InternalHelloWeb.g:2949:1: rule__SensorInstantiation__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__SensorInstantiation__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:2953:1: ( ( RULE_ID ) )
            // InternalHelloWeb.g:2954:2: ( RULE_ID )
            {
            // InternalHelloWeb.g:2954:2: ( RULE_ID )
            // InternalHelloWeb.g:2955:3: RULE_ID
            {
             before(grammarAccess.getSensorInstantiationAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getSensorInstantiationAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SensorInstantiation__NameAssignment_1"


    // $ANTLR start "rule__SensorInstantiation__PinsAssignment_4"
    // InternalHelloWeb.g:2964:1: rule__SensorInstantiation__PinsAssignment_4 : ( RULE_INT ) ;
    public final void rule__SensorInstantiation__PinsAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:2968:1: ( ( RULE_INT ) )
            // InternalHelloWeb.g:2969:2: ( RULE_INT )
            {
            // InternalHelloWeb.g:2969:2: ( RULE_INT )
            // InternalHelloWeb.g:2970:3: RULE_INT
            {
             before(grammarAccess.getSensorInstantiationAccess().getPinsINTTerminalRuleCall_4_0()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getSensorInstantiationAccess().getPinsINTTerminalRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SensorInstantiation__PinsAssignment_4"


    // $ANTLR start "rule__SensorInstantiation__PinsAssignment_5_1"
    // InternalHelloWeb.g:2979:1: rule__SensorInstantiation__PinsAssignment_5_1 : ( RULE_INT ) ;
    public final void rule__SensorInstantiation__PinsAssignment_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:2983:1: ( ( RULE_INT ) )
            // InternalHelloWeb.g:2984:2: ( RULE_INT )
            {
            // InternalHelloWeb.g:2984:2: ( RULE_INT )
            // InternalHelloWeb.g:2985:3: RULE_INT
            {
             before(grammarAccess.getSensorInstantiationAccess().getPinsINTTerminalRuleCall_5_1_0()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getSensorInstantiationAccess().getPinsINTTerminalRuleCall_5_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SensorInstantiation__PinsAssignment_5_1"


    // $ANTLR start "rule__SensorInstantiation__SamplingRateAssignment_6_1"
    // InternalHelloWeb.g:2994:1: rule__SensorInstantiation__SamplingRateAssignment_6_1 : ( ruleTimeUnit ) ;
    public final void rule__SensorInstantiation__SamplingRateAssignment_6_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:2998:1: ( ( ruleTimeUnit ) )
            // InternalHelloWeb.g:2999:2: ( ruleTimeUnit )
            {
            // InternalHelloWeb.g:2999:2: ( ruleTimeUnit )
            // InternalHelloWeb.g:3000:3: ruleTimeUnit
            {
             before(grammarAccess.getSensorInstantiationAccess().getSamplingRateTimeUnitParserRuleCall_6_1_0()); 
            pushFollow(FOLLOW_2);
            ruleTimeUnit();

            state._fsp--;

             after(grammarAccess.getSensorInstantiationAccess().getSamplingRateTimeUnitParserRuleCall_6_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SensorInstantiation__SamplingRateAssignment_6_1"


    // $ANTLR start "rule__SensorInstantiation__ConstraintsAssignment_7"
    // InternalHelloWeb.g:3009:1: rule__SensorInstantiation__ConstraintsAssignment_7 : ( ruleConstraint ) ;
    public final void rule__SensorInstantiation__ConstraintsAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:3013:1: ( ( ruleConstraint ) )
            // InternalHelloWeb.g:3014:2: ( ruleConstraint )
            {
            // InternalHelloWeb.g:3014:2: ( ruleConstraint )
            // InternalHelloWeb.g:3015:3: ruleConstraint
            {
             before(grammarAccess.getSensorInstantiationAccess().getConstraintsConstraintParserRuleCall_7_0()); 
            pushFollow(FOLLOW_2);
            ruleConstraint();

            state._fsp--;

             after(grammarAccess.getSensorInstantiationAccess().getConstraintsConstraintParserRuleCall_7_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SensorInstantiation__ConstraintsAssignment_7"


    // $ANTLR start "rule__Constraint__ConditionAssignment_1"
    // InternalHelloWeb.g:3024:1: rule__Constraint__ConditionAssignment_1 : ( ruleCondition ) ;
    public final void rule__Constraint__ConditionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:3028:1: ( ( ruleCondition ) )
            // InternalHelloWeb.g:3029:2: ( ruleCondition )
            {
            // InternalHelloWeb.g:3029:2: ( ruleCondition )
            // InternalHelloWeb.g:3030:3: ruleCondition
            {
             before(grammarAccess.getConstraintAccess().getConditionConditionParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleCondition();

            state._fsp--;

             after(grammarAccess.getConstraintAccess().getConditionConditionParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constraint__ConditionAssignment_1"


    // $ANTLR start "rule__Constraint__SamplingRateAssignment_4_1"
    // InternalHelloWeb.g:3039:1: rule__Constraint__SamplingRateAssignment_4_1 : ( ruleTimeUnit ) ;
    public final void rule__Constraint__SamplingRateAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:3043:1: ( ( ruleTimeUnit ) )
            // InternalHelloWeb.g:3044:2: ( ruleTimeUnit )
            {
            // InternalHelloWeb.g:3044:2: ( ruleTimeUnit )
            // InternalHelloWeb.g:3045:3: ruleTimeUnit
            {
             before(grammarAccess.getConstraintAccess().getSamplingRateTimeUnitParserRuleCall_4_1_0()); 
            pushFollow(FOLLOW_2);
            ruleTimeUnit();

            state._fsp--;

             after(grammarAccess.getConstraintAccess().getSamplingRateTimeUnitParserRuleCall_4_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constraint__SamplingRateAssignment_4_1"


    // $ANTLR start "rule__NestedLogicalCondition__LeftAssignment_1"
    // InternalHelloWeb.g:3054:1: rule__NestedLogicalCondition__LeftAssignment_1 : ( ruleCondition ) ;
    public final void rule__NestedLogicalCondition__LeftAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:3058:1: ( ( ruleCondition ) )
            // InternalHelloWeb.g:3059:2: ( ruleCondition )
            {
            // InternalHelloWeb.g:3059:2: ( ruleCondition )
            // InternalHelloWeb.g:3060:3: ruleCondition
            {
             before(grammarAccess.getNestedLogicalConditionAccess().getLeftConditionParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleCondition();

            state._fsp--;

             after(grammarAccess.getNestedLogicalConditionAccess().getLeftConditionParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NestedLogicalCondition__LeftAssignment_1"


    // $ANTLR start "rule__NestedLogicalCondition__OperatorAssignment_3"
    // InternalHelloWeb.g:3069:1: rule__NestedLogicalCondition__OperatorAssignment_3 : ( ( rule__NestedLogicalCondition__OperatorAlternatives_3_0 ) ) ;
    public final void rule__NestedLogicalCondition__OperatorAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:3073:1: ( ( ( rule__NestedLogicalCondition__OperatorAlternatives_3_0 ) ) )
            // InternalHelloWeb.g:3074:2: ( ( rule__NestedLogicalCondition__OperatorAlternatives_3_0 ) )
            {
            // InternalHelloWeb.g:3074:2: ( ( rule__NestedLogicalCondition__OperatorAlternatives_3_0 ) )
            // InternalHelloWeb.g:3075:3: ( rule__NestedLogicalCondition__OperatorAlternatives_3_0 )
            {
             before(grammarAccess.getNestedLogicalConditionAccess().getOperatorAlternatives_3_0()); 
            // InternalHelloWeb.g:3076:3: ( rule__NestedLogicalCondition__OperatorAlternatives_3_0 )
            // InternalHelloWeb.g:3076:4: rule__NestedLogicalCondition__OperatorAlternatives_3_0
            {
            pushFollow(FOLLOW_2);
            rule__NestedLogicalCondition__OperatorAlternatives_3_0();

            state._fsp--;


            }

             after(grammarAccess.getNestedLogicalConditionAccess().getOperatorAlternatives_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NestedLogicalCondition__OperatorAssignment_3"


    // $ANTLR start "rule__NestedLogicalCondition__RightAssignment_5"
    // InternalHelloWeb.g:3084:1: rule__NestedLogicalCondition__RightAssignment_5 : ( ruleCondition ) ;
    public final void rule__NestedLogicalCondition__RightAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:3088:1: ( ( ruleCondition ) )
            // InternalHelloWeb.g:3089:2: ( ruleCondition )
            {
            // InternalHelloWeb.g:3089:2: ( ruleCondition )
            // InternalHelloWeb.g:3090:3: ruleCondition
            {
             before(grammarAccess.getNestedLogicalConditionAccess().getRightConditionParserRuleCall_5_0()); 
            pushFollow(FOLLOW_2);
            ruleCondition();

            state._fsp--;

             after(grammarAccess.getNestedLogicalConditionAccess().getRightConditionParserRuleCall_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NestedLogicalCondition__RightAssignment_5"


    // $ANTLR start "rule__Comparison__LeftAssignment_0"
    // InternalHelloWeb.g:3099:1: rule__Comparison__LeftAssignment_0 : ( ruleComparisonValue ) ;
    public final void rule__Comparison__LeftAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:3103:1: ( ( ruleComparisonValue ) )
            // InternalHelloWeb.g:3104:2: ( ruleComparisonValue )
            {
            // InternalHelloWeb.g:3104:2: ( ruleComparisonValue )
            // InternalHelloWeb.g:3105:3: ruleComparisonValue
            {
             before(grammarAccess.getComparisonAccess().getLeftComparisonValueParserRuleCall_0_0()); 
            pushFollow(FOLLOW_2);
            ruleComparisonValue();

            state._fsp--;

             after(grammarAccess.getComparisonAccess().getLeftComparisonValueParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Comparison__LeftAssignment_0"


    // $ANTLR start "rule__Comparison__OperatorAssignment_1"
    // InternalHelloWeb.g:3114:1: rule__Comparison__OperatorAssignment_1 : ( ruleComparisonOperator ) ;
    public final void rule__Comparison__OperatorAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:3118:1: ( ( ruleComparisonOperator ) )
            // InternalHelloWeb.g:3119:2: ( ruleComparisonOperator )
            {
            // InternalHelloWeb.g:3119:2: ( ruleComparisonOperator )
            // InternalHelloWeb.g:3120:3: ruleComparisonOperator
            {
             before(grammarAccess.getComparisonAccess().getOperatorComparisonOperatorParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleComparisonOperator();

            state._fsp--;

             after(grammarAccess.getComparisonAccess().getOperatorComparisonOperatorParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Comparison__OperatorAssignment_1"


    // $ANTLR start "rule__Comparison__RightAssignment_2"
    // InternalHelloWeb.g:3129:1: rule__Comparison__RightAssignment_2 : ( ruleComparisonValue ) ;
    public final void rule__Comparison__RightAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:3133:1: ( ( ruleComparisonValue ) )
            // InternalHelloWeb.g:3134:2: ( ruleComparisonValue )
            {
            // InternalHelloWeb.g:3134:2: ( ruleComparisonValue )
            // InternalHelloWeb.g:3135:3: ruleComparisonValue
            {
             before(grammarAccess.getComparisonAccess().getRightComparisonValueParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleComparisonValue();

            state._fsp--;

             after(grammarAccess.getComparisonAccess().getRightComparisonValueParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Comparison__RightAssignment_2"


    // $ANTLR start "rule__ComparisonValue__ValueAssignment_2_1"
    // InternalHelloWeb.g:3144:1: rule__ComparisonValue__ValueAssignment_2_1 : ( RULE_INT ) ;
    public final void rule__ComparisonValue__ValueAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:3148:1: ( ( RULE_INT ) )
            // InternalHelloWeb.g:3149:2: ( RULE_INT )
            {
            // InternalHelloWeb.g:3149:2: ( RULE_INT )
            // InternalHelloWeb.g:3150:3: RULE_INT
            {
             before(grammarAccess.getComparisonValueAccess().getValueINTTerminalRuleCall_2_1_0()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getComparisonValueAccess().getValueINTTerminalRuleCall_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ComparisonValue__ValueAssignment_2_1"


    // $ANTLR start "rule__ValueRef__SensorInstantiationAssignment_0_0"
    // InternalHelloWeb.g:3159:1: rule__ValueRef__SensorInstantiationAssignment_0_0 : ( ( RULE_ID ) ) ;
    public final void rule__ValueRef__SensorInstantiationAssignment_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:3163:1: ( ( ( RULE_ID ) ) )
            // InternalHelloWeb.g:3164:2: ( ( RULE_ID ) )
            {
            // InternalHelloWeb.g:3164:2: ( ( RULE_ID ) )
            // InternalHelloWeb.g:3165:3: ( RULE_ID )
            {
             before(grammarAccess.getValueRefAccess().getSensorInstantiationSensorInstantiationCrossReference_0_0_0()); 
            // InternalHelloWeb.g:3166:3: ( RULE_ID )
            // InternalHelloWeb.g:3167:4: RULE_ID
            {
             before(grammarAccess.getValueRefAccess().getSensorInstantiationSensorInstantiationIDTerminalRuleCall_0_0_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getValueRefAccess().getSensorInstantiationSensorInstantiationIDTerminalRuleCall_0_0_0_1()); 

            }

             after(grammarAccess.getValueRefAccess().getSensorInstantiationSensorInstantiationCrossReference_0_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ValueRef__SensorInstantiationAssignment_0_0"


    // $ANTLR start "rule__ValueRef__OutAssignment_1"
    // InternalHelloWeb.g:3178:1: rule__ValueRef__OutAssignment_1 : ( RULE_ID ) ;
    public final void rule__ValueRef__OutAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:3182:1: ( ( RULE_ID ) )
            // InternalHelloWeb.g:3183:2: ( RULE_ID )
            {
            // InternalHelloWeb.g:3183:2: ( RULE_ID )
            // InternalHelloWeb.g:3184:3: RULE_ID
            {
             before(grammarAccess.getValueRefAccess().getOutIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getValueRefAccess().getOutIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ValueRef__OutAssignment_1"


    // $ANTLR start "rule__Output__NameAssignment"
    // InternalHelloWeb.g:3193:1: rule__Output__NameAssignment : ( RULE_ID ) ;
    public final void rule__Output__NameAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:3197:1: ( ( RULE_ID ) )
            // InternalHelloWeb.g:3198:2: ( RULE_ID )
            {
            // InternalHelloWeb.g:3198:2: ( RULE_ID )
            // InternalHelloWeb.g:3199:3: RULE_ID
            {
             before(grammarAccess.getOutputAccess().getNameIDTerminalRuleCall_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getOutputAccess().getNameIDTerminalRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Output__NameAssignment"


    // $ANTLR start "rule__Pin__NameAssignment"
    // InternalHelloWeb.g:3208:1: rule__Pin__NameAssignment : ( RULE_ID ) ;
    public final void rule__Pin__NameAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:3212:1: ( ( RULE_ID ) )
            // InternalHelloWeb.g:3213:2: ( RULE_ID )
            {
            // InternalHelloWeb.g:3213:2: ( RULE_ID )
            // InternalHelloWeb.g:3214:3: RULE_ID
            {
             before(grammarAccess.getPinAccess().getNameIDTerminalRuleCall_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getPinAccess().getNameIDTerminalRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Pin__NameAssignment"


    // $ANTLR start "rule__SensorUnit__ValueAssignment"
    // InternalHelloWeb.g:3223:1: rule__SensorUnit__ValueAssignment : ( RULE_ID ) ;
    public final void rule__SensorUnit__ValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:3227:1: ( ( RULE_ID ) )
            // InternalHelloWeb.g:3228:2: ( RULE_ID )
            {
            // InternalHelloWeb.g:3228:2: ( RULE_ID )
            // InternalHelloWeb.g:3229:3: RULE_ID
            {
             before(grammarAccess.getSensorUnitAccess().getValueIDTerminalRuleCall_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getSensorUnitAccess().getValueIDTerminalRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SensorUnit__ValueAssignment"


    // $ANTLR start "rule__Decimal__LeftAssignment_0"
    // InternalHelloWeb.g:3238:1: rule__Decimal__LeftAssignment_0 : ( RULE_INT ) ;
    public final void rule__Decimal__LeftAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:3242:1: ( ( RULE_INT ) )
            // InternalHelloWeb.g:3243:2: ( RULE_INT )
            {
            // InternalHelloWeb.g:3243:2: ( RULE_INT )
            // InternalHelloWeb.g:3244:3: RULE_INT
            {
             before(grammarAccess.getDecimalAccess().getLeftINTTerminalRuleCall_0_0()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getDecimalAccess().getLeftINTTerminalRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Decimal__LeftAssignment_0"


    // $ANTLR start "rule__Decimal__RightAssignment_2"
    // InternalHelloWeb.g:3253:1: rule__Decimal__RightAssignment_2 : ( RULE_INT ) ;
    public final void rule__Decimal__RightAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalHelloWeb.g:3257:1: ( ( RULE_INT ) )
            // InternalHelloWeb.g:3258:2: ( RULE_INT )
            {
            // InternalHelloWeb.g:3258:2: ( RULE_INT )
            // InternalHelloWeb.g:3259:3: RULE_INT
            {
             before(grammarAccess.getDecimalAccess().getRightINTTerminalRuleCall_2_0()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getDecimalAccess().getRightINTTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Decimal__RightAssignment_2"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000101000002L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000088000000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000080000002L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x00000000A0000000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x00000000C0000000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000E40000020L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x00000030C0000000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000002000000030L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000001040000000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000000003800L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000000FC0000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x000000000003C000L});

}