package org.kuali.student.rules.ruleexecution.runtime.ast;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.kuali.student.rules.internal.common.statement.PropositionContainer;
import org.kuali.student.rules.internal.common.statement.propositions.IntersectionProposition;
import org.kuali.student.rules.internal.common.statement.report.PropositionReport;
import org.kuali.student.rules.repository.RuleEngineRepository;
import org.kuali.student.rules.ruleexecution.util.RuleEngineRepositoryMock;
import org.kuali.student.rules.rulesetexecution.RuleSetExecutorInternal;
import org.kuali.student.rules.rulesetexecution.drools.RuleSetExecutorDroolsImpl;
import org.kuali.student.rules.rulesetexecution.runtime.ast.GenerateRuleReport;

public class GenerateRuleReportTest {

	private String functionalRuleString;

	private IntersectionProposition<String> subsetPropA = new IntersectionProposition<String>("A", null, null, null, null );
	private IntersectionProposition<String> subsetPropB = new IntersectionProposition<String>("B", null, null, null, null );
	private IntersectionProposition<String> subsetPropC = new IntersectionProposition<String>("C", null, null, null, null );
	private IntersectionProposition<String> subsetPropD = new IntersectionProposition<String>("D", null, null, null, null );

	private PropositionReport propositionReportA = new PropositionReport();
	private PropositionReport propositionReportB = new PropositionReport();
	private PropositionReport propositionReportC = new PropositionReport();
	private PropositionReport propositionReportD = new PropositionReport();

	private GenerateRuleReport generateRuleReport;

	@Before
	public void setUp() throws Exception {
        // Create repository
        RuleEngineRepository ruleEngineRepository = new RuleEngineRepositoryMock();
        // Create the rule set executor (use Spring IoC)
        RuleSetExecutorInternal executor = new RuleSetExecutorDroolsImpl(ruleEngineRepository);
	    this.generateRuleReport = new GenerateRuleReport(executor);
	}
	
	@Test
	public void testExecuteRuleFailureMessage1()
	{
	    functionalRuleString = "A*B*C*D";
	    
	    PropositionContainer pc = new PropositionContainer();
	    pc.setFunctionalRuleString(functionalRuleString);
	    pc.setRuleResult(false);
	    
	    subsetPropA.setResult(false);
	    subsetPropB.setResult(true);
	    subsetPropC.setResult(true);
	    subsetPropD.setResult(true);
	    
	    propositionReportA.setFailureMessage("Need MATH 200");
	    propositionReportB.setFailureMessage("Need MATH 110");
	    propositionReportC.setFailureMessage("Need 15 credits or more of 1st year science");
	    propositionReportD.setFailureMessage("Need English 6000");
	    
	    subsetPropA.setReport(propositionReportA);
	    subsetPropB.setReport(propositionReportB);
	    subsetPropC.setReport(propositionReportC);
	    subsetPropD.setReport(propositionReportD);
	    
	    pc.addProposition(subsetPropA);
	    pc.addProposition(subsetPropB);
	    pc.addProposition(subsetPropC);
	    pc.addProposition(subsetPropD);
	    
	    String expected = "Need MATH 200";
	    
	    PropositionContainer propContainer = this.generateRuleReport.execute(pc);
	    PropositionReport ruleReport = propContainer.getRuleReport();
	    String actual = ruleReport.getFailureMessage();
	    
        assertEquals(expected, actual);
	    
	}
	
	@Test
	public void testExecuteRuleFailureMessage2()
	{
	    // New code for PropositionContainer starts here
	    functionalRuleString = "A+(B*C)+D";
        
        PropositionContainer pc = new PropositionContainer();
        pc.setFunctionalRuleString(functionalRuleString);
        pc.setRuleResult(false);
        
        // need to set proposition result and failure message for testing.
        subsetPropA.setResult(false);
        subsetPropB.setResult(true);
        subsetPropC.setResult(false);
        subsetPropD.setResult(false);
        
        propositionReportA.setFailureMessage("Need MATH 200");
        propositionReportB.setFailureMessage("Need MATH 110");
        propositionReportC.setFailureMessage("Need 15 credits or more of 1st year science");
        propositionReportD.setFailureMessage("Need English 6000");
        
        subsetPropA.setReport(propositionReportA);
        subsetPropB.setReport(propositionReportB);
        subsetPropC.setReport(propositionReportC);
        subsetPropD.setReport(propositionReportD);
        
        pc.addProposition(subsetPropA);
        pc.addProposition(subsetPropB);
        pc.addProposition(subsetPropC);
        pc.addProposition(subsetPropD);
        
        String expected = "Need MATH 200 OR Need 15 credits or more of 1st year science OR Need English 6000";
        
        PropositionContainer propContainer = this.generateRuleReport.execute(pc);
        PropositionReport ruleReport = propContainer.getRuleReport();
        String actual = ruleReport.getFailureMessage();
        
        assertEquals(expected, actual);
	}
	
	
	
	
	@Test
    public void testExecuteRuleSuccessMessage1()
    {
        functionalRuleString = "A*B*C*D";
        
        PropositionContainer pc = new PropositionContainer();
        pc.setFunctionalRuleString(functionalRuleString);
        pc.setRuleResult(true);
        
        subsetPropA.setResult(true);
        subsetPropB.setResult(true);
        subsetPropC.setResult(true);
        subsetPropD.setResult(true);
        
        propositionReportA.setSuccessMessage("Have MATH 200");
        propositionReportB.setSuccessMessage("Have MATH 110");
        propositionReportC.setSuccessMessage("Have 15 credits or more of 1st year science");
        propositionReportD.setSuccessMessage("Have English 6000");
        
        subsetPropA.setReport(propositionReportA);
        subsetPropB.setReport(propositionReportB);
        subsetPropC.setReport(propositionReportC);
        subsetPropD.setReport(propositionReportD);
        
        pc.addProposition(subsetPropA);
        pc.addProposition(subsetPropB);
        pc.addProposition(subsetPropC);
        pc.addProposition(subsetPropD);
        
        String expected = "Have MATH 200 AND Have MATH 110 AND Have 15 credits or more of 1st year science AND Have English 6000";
        
        PropositionContainer propContainer = this.generateRuleReport.execute(pc);
        PropositionReport ruleReport = propContainer.getRuleReport();
        String actual = ruleReport.getSuccessMessage();
        
        assertEquals(expected, actual);
        
    }
    
    @Test
    public void testExecuteRuleSuccessMessage2()
    {
        // New code for PropositionContainer starts here
        functionalRuleString = "A+(B*C)+D";
        
        PropositionContainer pc = new PropositionContainer();
        pc.setFunctionalRuleString(functionalRuleString);
        pc.setRuleResult(true);
        
        // need to set proposition result and failure message for testing.
        subsetPropA.setResult(true);
        subsetPropB.setResult(true);
        subsetPropC.setResult(false);
        subsetPropD.setResult(true);
        
        propositionReportA.setSuccessMessage("Have MATH 200");
        propositionReportB.setSuccessMessage("Have MATH 110");
        propositionReportC.setSuccessMessage("Have 15 credits or more of 1st year science");
        propositionReportD.setSuccessMessage("Have English 6000");
        
        subsetPropA.setReport(propositionReportA);
        subsetPropB.setReport(propositionReportB);
        subsetPropC.setReport(propositionReportC);
        subsetPropD.setReport(propositionReportD);
        
        pc.addProposition(subsetPropA);
        pc.addProposition(subsetPropB);
        pc.addProposition(subsetPropC);
        pc.addProposition(subsetPropD);
        
        String expected = "Have MATH 200 OR Have English 6000";
        
        PropositionContainer propContainer = this.generateRuleReport.execute(pc);
        PropositionReport ruleReport = propContainer.getRuleReport();
        String actual = ruleReport.getSuccessMessage();
        
        assertEquals(expected, actual);
    }
	
	@After
	public void tearDown() throws Exception {
	}

}
