package com.ckr.test.report.generator.extension.spi;

import com.ckr.test.report.generator.extension.ITestReportGenerator;

public interface ExtensionRegistry {

	void register(ITestReportGenerator testReportGenerator);
}
