/*
 * generated by Xtext 2.33.0
 */
grammar InternalHelloWeb;

options {
	superClass=AbstractInternalAntlrParser;
}

@lexer::header {
package org.example.helloweb.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

@parser::header {
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

}

@parser::members {

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

}

@rulecatch {
    catch (RecognitionException re) {
        recover(input,re);
        appendSkippedTokens();
    }
}

// Entry rule entryRuleSensorConfig
entryRuleSensorConfig returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getSensorConfigRule()); }
	iv_ruleSensorConfig=ruleSensorConfig
	{ $current=$iv_ruleSensorConfig.current; }
	EOF;

// Rule SensorConfig
ruleSensorConfig returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				{
					newCompositeNode(grammarAccess.getSensorConfigAccess().getSensorsSensorParserRuleCall_0_0());
				}
				lv_sensors_0_0=ruleSensor
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getSensorConfigRule());
					}
					add(
						$current,
						"sensors",
						lv_sensors_0_0,
						"org.example.helloweb.HelloWeb.Sensor");
					afterParserOrEnumRuleCall();
				}
			)
		)
		    |
		(
			(
				{
					newCompositeNode(grammarAccess.getSensorConfigAccess().getDeviceTypesDeviceTypeParserRuleCall_1_0());
				}
				lv_deviceTypes_1_0=ruleDeviceType
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getSensorConfigRule());
					}
					add(
						$current,
						"deviceTypes",
						lv_deviceTypes_1_0,
						"org.example.helloweb.HelloWeb.DeviceType");
					afterParserOrEnumRuleCall();
				}
			)
		)
	)*
;

// Entry rule entryRuleSensor
entryRuleSensor returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getSensorRule()); }
	iv_ruleSensor=ruleSensor
	{ $current=$iv_ruleSensor.current; }
	EOF;

// Rule Sensor
ruleSensor returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		otherlv_0='sensor'
		{
			newLeafNode(otherlv_0, grammarAccess.getSensorAccess().getSensorKeyword_0());
		}
		(
			(
				lv_name_1_0=RULE_ID
				{
					newLeafNode(lv_name_1_0, grammarAccess.getSensorAccess().getNameIDTerminalRuleCall_1_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getSensorRule());
					}
					setWithLastConsumed(
						$current,
						"name",
						lv_name_1_0,
						"org.eclipse.xtext.common.Terminals.ID");
				}
			)
		)
		otherlv_2='{'
		{
			newLeafNode(otherlv_2, grammarAccess.getSensorAccess().getLeftCurlyBracketKeyword_2());
		}
		otherlv_3='units:'
		{
			newLeafNode(otherlv_3, grammarAccess.getSensorAccess().getUnitsKeyword_3());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getSensorAccess().getUnitsSensorUnitParserRuleCall_4_0());
				}
				lv_units_4_0=ruleSensorUnit
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getSensorRule());
					}
					add(
						$current,
						"units",
						lv_units_4_0,
						"org.example.helloweb.HelloWeb.SensorUnit");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			otherlv_5=','
			{
				newLeafNode(otherlv_5, grammarAccess.getSensorAccess().getCommaKeyword_5_0());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getSensorAccess().getUnitsSensorUnitParserRuleCall_5_1_0());
					}
					lv_units_6_0=ruleSensorUnit
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getSensorRule());
						}
						add(
							$current,
							"units",
							lv_units_6_0,
							"org.example.helloweb.HelloWeb.SensorUnit");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)*
		otherlv_7='reader:'
		{
			newLeafNode(otherlv_7, grammarAccess.getSensorAccess().getReaderKeyword_6());
		}
		(
			(
				lv_reader_8_0=RULE_ID
				{
					newLeafNode(lv_reader_8_0, grammarAccess.getSensorAccess().getReaderIDTerminalRuleCall_7_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getSensorRule());
					}
					setWithLastConsumed(
						$current,
						"reader",
						lv_reader_8_0,
						"org.eclipse.xtext.common.Terminals.ID");
				}
			)
		)
		otherlv_9='pins:'
		{
			newLeafNode(otherlv_9, grammarAccess.getSensorAccess().getPinsKeyword_8());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getSensorAccess().getPinsPinParserRuleCall_9_0());
				}
				lv_pins_10_0=rulePin
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getSensorRule());
					}
					add(
						$current,
						"pins",
						lv_pins_10_0,
						"org.example.helloweb.HelloWeb.Pin");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			otherlv_11=','
			{
				newLeafNode(otherlv_11, grammarAccess.getSensorAccess().getCommaKeyword_10_0());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getSensorAccess().getPinsPinParserRuleCall_10_1_0());
					}
					lv_pins_12_0=rulePin
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getSensorRule());
						}
						add(
							$current,
							"pins",
							lv_pins_12_0,
							"org.example.helloweb.HelloWeb.Pin");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)*
		otherlv_13='out:'
		{
			newLeafNode(otherlv_13, grammarAccess.getSensorAccess().getOutKeyword_11());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getSensorAccess().getOutOutputParserRuleCall_12_0());
				}
				lv_out_14_0=ruleOutput
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getSensorRule());
					}
					add(
						$current,
						"out",
						lv_out_14_0,
						"org.example.helloweb.HelloWeb.Output");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			otherlv_15=','
			{
				newLeafNode(otherlv_15, grammarAccess.getSensorAccess().getCommaKeyword_13_0());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getSensorAccess().getOutOutputParserRuleCall_13_1_0());
					}
					lv_out_16_0=ruleOutput
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getSensorRule());
						}
						add(
							$current,
							"out",
							lv_out_16_0,
							"org.example.helloweb.HelloWeb.Output");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)*
		otherlv_17='}'
		{
			newLeafNode(otherlv_17, grammarAccess.getSensorAccess().getRightCurlyBracketKeyword_14());
		}
	)
;

// Entry rule entryRuleDeviceType
entryRuleDeviceType returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getDeviceTypeRule()); }
	iv_ruleDeviceType=ruleDeviceType
	{ $current=$iv_ruleDeviceType.current; }
	EOF;

// Rule DeviceType
ruleDeviceType returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		otherlv_0='deviceType'
		{
			newLeafNode(otherlv_0, grammarAccess.getDeviceTypeAccess().getDeviceTypeKeyword_0());
		}
		(
			(
				lv_name_1_0=RULE_ID
				{
					newLeafNode(lv_name_1_0, grammarAccess.getDeviceTypeAccess().getNameIDTerminalRuleCall_1_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getDeviceTypeRule());
					}
					setWithLastConsumed(
						$current,
						"name",
						lv_name_1_0,
						"org.eclipse.xtext.common.Terminals.ID");
				}
			)
		)
		otherlv_2='{'
		{
			newLeafNode(otherlv_2, grammarAccess.getDeviceTypeAccess().getLeftCurlyBracketKeyword_2());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getDeviceTypeAccess().getSensorInstantiationsSensorInstantiationParserRuleCall_3_0());
				}
				lv_sensorInstantiations_3_0=ruleSensorInstantiation
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getDeviceTypeRule());
					}
					add(
						$current,
						"sensorInstantiations",
						lv_sensorInstantiations_3_0,
						"org.example.helloweb.HelloWeb.SensorInstantiation");
					afterParserOrEnumRuleCall();
				}
			)
		)*
		(
			otherlv_4='batchRatePolicy:'
			{
				newLeafNode(otherlv_4, grammarAccess.getDeviceTypeAccess().getBatchRatePolicyKeyword_4_0());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getDeviceTypeAccess().getBatchRatePolicyTimeUnitParserRuleCall_4_1_0());
					}
					lv_batchRatePolicy_5_0=ruleTimeUnit
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getDeviceTypeRule());
						}
						set(
							$current,
							"batchRatePolicy",
							lv_batchRatePolicy_5_0,
							"org.example.helloweb.HelloWeb.TimeUnit");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)?
		(
			otherlv_6='batchSizePolicy:'
			{
				newLeafNode(otherlv_6, grammarAccess.getDeviceTypeAccess().getBatchSizePolicyKeyword_5_0());
			}
			(
				(
					lv_batchSizePolicy_7_0=RULE_INT
					{
						newLeafNode(lv_batchSizePolicy_7_0, grammarAccess.getDeviceTypeAccess().getBatchSizePolicyINTTerminalRuleCall_5_1_0());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getDeviceTypeRule());
						}
						setWithLastConsumed(
							$current,
							"batchSizePolicy",
							lv_batchSizePolicy_7_0,
							"org.eclipse.xtext.common.Terminals.INT");
					}
				)
			)
		)?
		(
			otherlv_8='heartBeatPolicy:'
			{
				newLeafNode(otherlv_8, grammarAccess.getDeviceTypeAccess().getHeartBeatPolicyKeyword_6_0());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getDeviceTypeAccess().getHeartBeatPolicyTimeUnitParserRuleCall_6_1_0());
					}
					lv_heartBeatPolicy_9_0=ruleTimeUnit
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getDeviceTypeRule());
						}
						set(
							$current,
							"heartBeatPolicy",
							lv_heartBeatPolicy_9_0,
							"org.example.helloweb.HelloWeb.TimeUnit");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)?
		otherlv_10='}'
		{
			newLeafNode(otherlv_10, grammarAccess.getDeviceTypeAccess().getRightCurlyBracketKeyword_7());
		}
	)
;

// Entry rule entryRuleSensorInstantiation
entryRuleSensorInstantiation returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getSensorInstantiationRule()); }
	iv_ruleSensorInstantiation=ruleSensorInstantiation
	{ $current=$iv_ruleSensorInstantiation.current; }
	EOF;

// Rule SensorInstantiation
ruleSensorInstantiation returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getSensorInstantiationRule());
					}
				}
				otherlv_0=RULE_ID
				{
					newLeafNode(otherlv_0, grammarAccess.getSensorInstantiationAccess().getSensorSensorCrossReference_0_0());
				}
			)
		)
		(
			(
				lv_name_1_0=RULE_ID
				{
					newLeafNode(lv_name_1_0, grammarAccess.getSensorInstantiationAccess().getNameIDTerminalRuleCall_1_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getSensorInstantiationRule());
					}
					setWithLastConsumed(
						$current,
						"name",
						lv_name_1_0,
						"org.eclipse.xtext.common.Terminals.ID");
				}
			)
		)
		otherlv_2='{'
		{
			newLeafNode(otherlv_2, grammarAccess.getSensorInstantiationAccess().getLeftCurlyBracketKeyword_2());
		}
		otherlv_3='pins:'
		{
			newLeafNode(otherlv_3, grammarAccess.getSensorInstantiationAccess().getPinsKeyword_3());
		}
		(
			(
				lv_pins_4_0=RULE_INT
				{
					newLeafNode(lv_pins_4_0, grammarAccess.getSensorInstantiationAccess().getPinsINTTerminalRuleCall_4_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getSensorInstantiationRule());
					}
					addWithLastConsumed(
						$current,
						"pins",
						lv_pins_4_0,
						"org.eclipse.xtext.common.Terminals.INT");
				}
			)
		)
		(
			otherlv_5=','
			{
				newLeafNode(otherlv_5, grammarAccess.getSensorInstantiationAccess().getCommaKeyword_5_0());
			}
			(
				(
					lv_pins_6_0=RULE_INT
					{
						newLeafNode(lv_pins_6_0, grammarAccess.getSensorInstantiationAccess().getPinsINTTerminalRuleCall_5_1_0());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getSensorInstantiationRule());
						}
						addWithLastConsumed(
							$current,
							"pins",
							lv_pins_6_0,
							"org.eclipse.xtext.common.Terminals.INT");
					}
				)
			)
		)*
		(
			otherlv_7='samplingRate:'
			{
				newLeafNode(otherlv_7, grammarAccess.getSensorInstantiationAccess().getSamplingRateKeyword_6_0());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getSensorInstantiationAccess().getSamplingRateTimeUnitParserRuleCall_6_1_0());
					}
					lv_samplingRate_8_0=ruleTimeUnit
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getSensorInstantiationRule());
						}
						set(
							$current,
							"samplingRate",
							lv_samplingRate_8_0,
							"org.example.helloweb.HelloWeb.TimeUnit");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)?
		(
			(
				{
					newCompositeNode(grammarAccess.getSensorInstantiationAccess().getConstraintsConstraintParserRuleCall_7_0());
				}
				lv_constraints_9_0=ruleConstraint
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getSensorInstantiationRule());
					}
					add(
						$current,
						"constraints",
						lv_constraints_9_0,
						"org.example.helloweb.HelloWeb.Constraint");
					afterParserOrEnumRuleCall();
				}
			)
		)*
		otherlv_10='}'
		{
			newLeafNode(otherlv_10, grammarAccess.getSensorInstantiationAccess().getRightCurlyBracketKeyword_8());
		}
	)
;

// Entry rule entryRuleConstraint
entryRuleConstraint returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getConstraintRule()); }
	iv_ruleConstraint=ruleConstraint
	{ $current=$iv_ruleConstraint.current; }
	EOF;

// Rule Constraint
ruleConstraint returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		otherlv_0='('
		{
			newLeafNode(otherlv_0, grammarAccess.getConstraintAccess().getLeftParenthesisKeyword_0());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getConstraintAccess().getConditionConditionParserRuleCall_1_0());
				}
				lv_condition_1_0=ruleCondition
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getConstraintRule());
					}
					set(
						$current,
						"condition",
						lv_condition_1_0,
						"org.example.helloweb.HelloWeb.Condition");
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_2=')'
		{
			newLeafNode(otherlv_2, grammarAccess.getConstraintAccess().getRightParenthesisKeyword_2());
		}
		otherlv_3='{'
		{
			newLeafNode(otherlv_3, grammarAccess.getConstraintAccess().getLeftCurlyBracketKeyword_3());
		}
		(
			otherlv_4='samplingRate:'
			{
				newLeafNode(otherlv_4, grammarAccess.getConstraintAccess().getSamplingRateKeyword_4_0());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getConstraintAccess().getSamplingRateTimeUnitParserRuleCall_4_1_0());
					}
					lv_samplingRate_5_0=ruleTimeUnit
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getConstraintRule());
						}
						set(
							$current,
							"samplingRate",
							lv_samplingRate_5_0,
							"org.example.helloweb.HelloWeb.TimeUnit");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)?
		otherlv_6='}'
		{
			newLeafNode(otherlv_6, grammarAccess.getConstraintAccess().getRightCurlyBracketKeyword_5());
		}
	)
;

// Entry rule entryRuleCondition
entryRuleCondition returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getConditionRule()); }
	iv_ruleCondition=ruleCondition
	{ $current=$iv_ruleCondition.current; }
	EOF;

// Rule Condition
ruleCondition returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			newCompositeNode(grammarAccess.getConditionAccess().getComparisonParserRuleCall_0());
		}
		this_Comparison_0=ruleComparison
		{
			$current = $this_Comparison_0.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getConditionAccess().getNestedLogicalConditionParserRuleCall_1());
		}
		this_NestedLogicalCondition_1=ruleNestedLogicalCondition
		{
			$current = $this_NestedLogicalCondition_1.current;
			afterParserOrEnumRuleCall();
		}
	)
;

// Entry rule entryRuleNestedLogicalCondition
entryRuleNestedLogicalCondition returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getNestedLogicalConditionRule()); }
	iv_ruleNestedLogicalCondition=ruleNestedLogicalCondition
	{ $current=$iv_ruleNestedLogicalCondition.current; }
	EOF;

// Rule NestedLogicalCondition
ruleNestedLogicalCondition returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		otherlv_0='('
		{
			newLeafNode(otherlv_0, grammarAccess.getNestedLogicalConditionAccess().getLeftParenthesisKeyword_0());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getNestedLogicalConditionAccess().getLeftConditionParserRuleCall_1_0());
				}
				lv_left_1_0=ruleCondition
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getNestedLogicalConditionRule());
					}
					set(
						$current,
						"left",
						lv_left_1_0,
						"org.example.helloweb.HelloWeb.Condition");
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_2=')'
		{
			newLeafNode(otherlv_2, grammarAccess.getNestedLogicalConditionAccess().getRightParenthesisKeyword_2());
		}
		(
			(
				(
					lv_operator_3_1='AND'
					{
						newLeafNode(lv_operator_3_1, grammarAccess.getNestedLogicalConditionAccess().getOperatorANDKeyword_3_0_0());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getNestedLogicalConditionRule());
						}
						setWithLastConsumed($current, "operator", lv_operator_3_1, null);
					}
					    |
					lv_operator_3_2='OR'
					{
						newLeafNode(lv_operator_3_2, grammarAccess.getNestedLogicalConditionAccess().getOperatorORKeyword_3_0_1());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getNestedLogicalConditionRule());
						}
						setWithLastConsumed($current, "operator", lv_operator_3_2, null);
					}
					    |
					lv_operator_3_3='NOT'
					{
						newLeafNode(lv_operator_3_3, grammarAccess.getNestedLogicalConditionAccess().getOperatorNOTKeyword_3_0_2());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getNestedLogicalConditionRule());
						}
						setWithLastConsumed($current, "operator", lv_operator_3_3, null);
					}
				)
			)
		)
		otherlv_4='('
		{
			newLeafNode(otherlv_4, grammarAccess.getNestedLogicalConditionAccess().getLeftParenthesisKeyword_4());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getNestedLogicalConditionAccess().getRightConditionParserRuleCall_5_0());
				}
				lv_right_5_0=ruleCondition
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getNestedLogicalConditionRule());
					}
					set(
						$current,
						"right",
						lv_right_5_0,
						"org.example.helloweb.HelloWeb.Condition");
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_6=')'
		{
			newLeafNode(otherlv_6, grammarAccess.getNestedLogicalConditionAccess().getRightParenthesisKeyword_6());
		}
	)
;

// Entry rule entryRuleComparison
entryRuleComparison returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getComparisonRule()); }
	iv_ruleComparison=ruleComparison
	{ $current=$iv_ruleComparison.current; }
	EOF;

// Rule Comparison
ruleComparison returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				{
					newCompositeNode(grammarAccess.getComparisonAccess().getLeftComparisonValueParserRuleCall_0_0());
				}
				lv_left_0_0=ruleComparisonValue
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getComparisonRule());
					}
					set(
						$current,
						"left",
						lv_left_0_0,
						"org.example.helloweb.HelloWeb.ComparisonValue");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getComparisonAccess().getOperatorComparisonOperatorParserRuleCall_1_0());
				}
				lv_operator_1_0=ruleComparisonOperator
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getComparisonRule());
					}
					set(
						$current,
						"operator",
						lv_operator_1_0,
						"org.example.helloweb.HelloWeb.ComparisonOperator");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getComparisonAccess().getRightComparisonValueParserRuleCall_2_0());
				}
				lv_right_2_0=ruleComparisonValue
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getComparisonRule());
					}
					set(
						$current,
						"right",
						lv_right_2_0,
						"org.example.helloweb.HelloWeb.ComparisonValue");
					afterParserOrEnumRuleCall();
				}
			)
		)
	)
;

// Entry rule entryRuleComparisonValue
entryRuleComparisonValue returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getComparisonValueRule()); }
	iv_ruleComparisonValue=ruleComparisonValue
	{ $current=$iv_ruleComparisonValue.current; }
	EOF;

// Rule ComparisonValue
ruleComparisonValue returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			newCompositeNode(grammarAccess.getComparisonValueAccess().getValueRefParserRuleCall_0());
		}
		this_ValueRef_0=ruleValueRef
		{
			$current = $this_ValueRef_0.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getComparisonValueAccess().getDecimalParserRuleCall_1());
		}
		this_Decimal_1=ruleDecimal
		{
			$current = $this_Decimal_1.current;
			afterParserOrEnumRuleCall();
		}
		    |
		(
			(
				{
					$current = forceCreateModelElement(
						grammarAccess.getComparisonValueAccess().getComparisonValueAction_2_0(),
						$current);
				}
			)
			(
				(
					lv_value_3_0=RULE_INT
					{
						newLeafNode(lv_value_3_0, grammarAccess.getComparisonValueAccess().getValueINTTerminalRuleCall_2_1_0());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getComparisonValueRule());
						}
						setWithLastConsumed(
							$current,
							"value",
							lv_value_3_0,
							"org.eclipse.xtext.common.Terminals.INT");
					}
				)
			)
		)
	)
;

// Entry rule entryRuleValueRef
entryRuleValueRef returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getValueRefRule()); }
	iv_ruleValueRef=ruleValueRef
	{ $current=$iv_ruleValueRef.current; }
	EOF;

// Rule ValueRef
ruleValueRef returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				(
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getValueRefRule());
						}
					}
					otherlv_0=RULE_ID
					{
						newLeafNode(otherlv_0, grammarAccess.getValueRefAccess().getSensorInstantiationSensorInstantiationCrossReference_0_0_0());
					}
				)
			)
			otherlv_1='.'
			{
				newLeafNode(otherlv_1, grammarAccess.getValueRefAccess().getFullStopKeyword_0_1());
			}
		)?
		(
			(
				lv_out_2_0=RULE_ID
				{
					newLeafNode(lv_out_2_0, grammarAccess.getValueRefAccess().getOutIDTerminalRuleCall_1_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getValueRefRule());
					}
					setWithLastConsumed(
						$current,
						"out",
						lv_out_2_0,
						"org.eclipse.xtext.common.Terminals.ID");
				}
			)
		)
	)
;

// Entry rule entryRuleOutput
entryRuleOutput returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getOutputRule()); }
	iv_ruleOutput=ruleOutput
	{ $current=$iv_ruleOutput.current; }
	EOF;

// Rule Output
ruleOutput returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			lv_name_0_0=RULE_ID
			{
				newLeafNode(lv_name_0_0, grammarAccess.getOutputAccess().getNameIDTerminalRuleCall_0());
			}
			{
				if ($current==null) {
					$current = createModelElement(grammarAccess.getOutputRule());
				}
				setWithLastConsumed(
					$current,
					"name",
					lv_name_0_0,
					"org.eclipse.xtext.common.Terminals.ID");
			}
		)
	)
;

// Entry rule entryRulePin
entryRulePin returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getPinRule()); }
	iv_rulePin=rulePin
	{ $current=$iv_rulePin.current; }
	EOF;

// Rule Pin
rulePin returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			lv_name_0_0=RULE_ID
			{
				newLeafNode(lv_name_0_0, grammarAccess.getPinAccess().getNameIDTerminalRuleCall_0());
			}
			{
				if ($current==null) {
					$current = createModelElement(grammarAccess.getPinRule());
				}
				setWithLastConsumed(
					$current,
					"name",
					lv_name_0_0,
					"org.eclipse.xtext.common.Terminals.ID");
			}
		)
	)
;

// Entry rule entryRuleSensorUnit
entryRuleSensorUnit returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getSensorUnitRule()); }
	iv_ruleSensorUnit=ruleSensorUnit
	{ $current=$iv_ruleSensorUnit.current; }
	EOF;

// Rule SensorUnit
ruleSensorUnit returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			lv_value_0_0=RULE_ID
			{
				newLeafNode(lv_value_0_0, grammarAccess.getSensorUnitAccess().getValueIDTerminalRuleCall_0());
			}
			{
				if ($current==null) {
					$current = createModelElement(grammarAccess.getSensorUnitRule());
				}
				setWithLastConsumed(
					$current,
					"value",
					lv_value_0_0,
					"org.eclipse.xtext.common.Terminals.ID");
			}
		)
	)
;

// Entry rule entryRuleTimeUnit
entryRuleTimeUnit returns [String current=null]:
	{ newCompositeNode(grammarAccess.getTimeUnitRule()); }
	iv_ruleTimeUnit=ruleTimeUnit
	{ $current=$iv_ruleTimeUnit.current.getText(); }
	EOF;

// Rule TimeUnit
ruleTimeUnit returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		this_INT_0=RULE_INT
		{
			$current.merge(this_INT_0);
		}
		{
			newLeafNode(this_INT_0, grammarAccess.getTimeUnitAccess().getINTTerminalRuleCall_0());
		}
		(
			kw='s'
			{
				$current.merge(kw);
				newLeafNode(kw, grammarAccess.getTimeUnitAccess().getSKeyword_1_0());
			}
			    |
			kw='m'
			{
				$current.merge(kw);
				newLeafNode(kw, grammarAccess.getTimeUnitAccess().getMKeyword_1_1());
			}
			    |
			kw='h'
			{
				$current.merge(kw);
				newLeafNode(kw, grammarAccess.getTimeUnitAccess().getHKeyword_1_2());
			}
			    |
			kw='d'
			{
				$current.merge(kw);
				newLeafNode(kw, grammarAccess.getTimeUnitAccess().getDKeyword_1_3());
			}
		)
	)
;

// Entry rule entryRuleDecimal
entryRuleDecimal returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getDecimalRule()); }
	iv_ruleDecimal=ruleDecimal
	{ $current=$iv_ruleDecimal.current; }
	EOF;

// Rule Decimal
ruleDecimal returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				lv_left_0_0=RULE_INT
				{
					newLeafNode(lv_left_0_0, grammarAccess.getDecimalAccess().getLeftINTTerminalRuleCall_0_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getDecimalRule());
					}
					setWithLastConsumed(
						$current,
						"left",
						lv_left_0_0,
						"org.eclipse.xtext.common.Terminals.INT");
				}
			)
		)
		otherlv_1='.'
		{
			newLeafNode(otherlv_1, grammarAccess.getDecimalAccess().getFullStopKeyword_1());
		}
		(
			(
				lv_right_2_0=RULE_INT
				{
					newLeafNode(lv_right_2_0, grammarAccess.getDecimalAccess().getRightINTTerminalRuleCall_2_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getDecimalRule());
					}
					setWithLastConsumed(
						$current,
						"right",
						lv_right_2_0,
						"org.eclipse.xtext.common.Terminals.INT");
				}
			)
		)
	)
;

// Entry rule entryRuleComparisonOperator
entryRuleComparisonOperator returns [String current=null]:
	{ newCompositeNode(grammarAccess.getComparisonOperatorRule()); }
	iv_ruleComparisonOperator=ruleComparisonOperator
	{ $current=$iv_ruleComparisonOperator.current.getText(); }
	EOF;

// Rule ComparisonOperator
ruleComparisonOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		kw='>'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getComparisonOperatorAccess().getGreaterThanSignKeyword_0());
		}
		    |
		kw='<'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getComparisonOperatorAccess().getLessThanSignKeyword_1());
		}
		    |
		kw='>='
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getComparisonOperatorAccess().getGreaterThanSignEqualsSignKeyword_2());
		}
		    |
		kw='<='
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getComparisonOperatorAccess().getLessThanSignEqualsSignKeyword_3());
		}
		    |
		kw='='
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getComparisonOperatorAccess().getEqualsSignKeyword_4());
		}
		    |
		kw='!='
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getComparisonOperatorAccess().getExclamationMarkEqualsSignKeyword_5());
		}
	)
;

RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

RULE_INT : ('0'..'9')+;

RULE_STRING : ('"' ('\\' .|~(('\\'|'"')))* '"'|'\'' ('\\' .|~(('\\'|'\'')))* '\'');

RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

RULE_WS : (' '|'\t'|'\r'|'\n')+;

RULE_ANY_OTHER : .;
