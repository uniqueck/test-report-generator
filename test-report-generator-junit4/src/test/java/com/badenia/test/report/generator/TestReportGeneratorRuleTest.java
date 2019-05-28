package com.badenia.test.report.generator;

import static org.junit.Assert.fail;

import java.io.File;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;

import com.badenia.test.report.generator.rule.TestReportGeneratorRule;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

public class TestReportGeneratorRuleTest {

	@Retention(RetentionPolicy.RUNTIME)
	@Target(ElementType.METHOD)
	public static @interface ShouldFail {

	}

	public static class ShouldFailRule implements TestRule {


		@Override
		public Statement apply(Statement base, Description description) {
			return new Statement() {
				@Override
				public void evaluate() throws Throwable {
					if (description.getAnnotation(ShouldFail.class) != null) {
						try {
							base.evaluate();
							fail();
						} catch (Throwable e) {
						}
					} else {
						base.evaluate();
					}
				}
			};
		}
	}

	@Rule
	public ShouldFailRule shouldFail = new ShouldFailRule();

	@Rule
	public TestReportGeneratorRule testReportGeneratorRule = TestReportGeneratorRule
			.reportInFolder(new File("./target/testReportGenerator"));

	@Test
	@ShouldFail
	public void test_ShouldFail_Failed() throws Exception {
		fail();
	}

	@SuppressWarnings("squid:S2699")
	@Test
	public void test_ShouldSucceed_Succeed() throws Exception {

	}

}
