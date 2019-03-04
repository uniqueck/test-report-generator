package com.ckr.test.description.extension.annotation;

import java.io.File;

import org.junit.Rule;
import org.junit.Test;

import com.ckr.test.report.generator.rule.TestReportGeneratorRule;

public class TestDescriptionTest {

	@Rule
	public TestReportGeneratorRule testReportGeneratorRule = TestReportGeneratorRule.reportInFolder(new File("./target/"));
	
	@Test
	@TestDescription(testSetup = "setup", testExpectation = "expectation")
	public void testExample() throws Exception {
		
	}
}
