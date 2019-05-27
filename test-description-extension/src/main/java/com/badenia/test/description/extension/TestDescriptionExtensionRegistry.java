package com.badenia.test.description.extension;

import com.badenia.test.description.extension.annotation.TestDescription;
import com.badenia.test.report.generator.extension.ITestReportGenerator;
import com.badenia.test.report.generator.extension.spi.ExtensionRegistry;

public class TestDescriptionExtensionRegistry implements ExtensionRegistry {

	public void register(ITestReportGenerator testReportGenerator) {
		testReportGenerator.register(TestDescription.class, new TestDescriptionExtension());
	}

}
