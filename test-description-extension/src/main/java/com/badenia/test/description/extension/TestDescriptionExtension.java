package com.badenia.test.description.extension;

import com.badenia.test.description.extension.annotation.TestDescription;
import com.badenia.test.report.generator.extension.ITestReportGeneratorExtension;

public class TestDescriptionExtension implements ITestReportGeneratorExtension<TestDescription> {

	public Object extract(TestDescription annotation) {
		return null;
	}

}
