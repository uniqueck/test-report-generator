package com.ckr.test.description.extension;

import com.ckr.test.description.extension.annotation.TestDescription;
import com.ckr.test.report.generator.extension.ITestReportGenerator;
import com.ckr.test.report.generator.extension.spi.ExtensionRegistry;

public class TestDescriptionExtensionRegistry implements ExtensionRegistry {

	public void register(ITestReportGenerator testReportGenerator) {
		testReportGenerator.register(TestDescription.class, new TestDescriptionExtension());
	}

}
