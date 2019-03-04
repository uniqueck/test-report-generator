package com.ckr.test.report.generator;

import static org.junit.Assert.fail;

import java.io.File;

import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;

import com.ckr.test.report.generator.rule.TestReportGeneratorRule;

public class TestReportGeneratorRuleTest {

	@Rule
	public TestReportGeneratorRule testReportGeneratorRule = TestReportGeneratorRule
			.reportInFolder(new File("./target/testReportGenerator"));

	@Test
	@Ignore
	public void test_ShouldFail_Failed() throws Exception {
		fail();
	}

	@Test
	public void test_ShouldSucceed_Succeed() throws Exception {

	}

}
