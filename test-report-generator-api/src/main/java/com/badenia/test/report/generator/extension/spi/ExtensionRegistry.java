package com.badenia.test.report.generator.extension.spi;

import com.badenia.test.report.generator.extension.ITestReportGenerator;

public interface ExtensionRegistry {

	void register(ITestReportGenerator testReportGenerator);
}
