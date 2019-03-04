package com.ckr.test.description.extension;

import com.ckr.test.description.extension.annotation.TestDescription;
import com.ckr.test.report.generator.extension.ITestReportGeneratorExtension;

public class TestDescriptionExtension implements ITestReportGeneratorExtension<TestDescription> {

	public Object extract(TestDescription annotation) {
		return null;
	}

}
