package com.ckr.test.report.generator.extension.internal;

import java.util.ServiceLoader;

import com.ckr.test.report.generator.extension.ITestReportGenerator;
import com.ckr.test.report.generator.extension.spi.ExtensionRegistry;

// has to move to a core / base module
public class ExtensionRegistryExecuter {

	private ITestReportGenerator testReportGenerator;

	public ExtensionRegistryExecuter(ITestReportGenerator testReportGenerator) {
		this.testReportGenerator = testReportGenerator;
	}

	public void registerAllExtensions() {
		ServiceLoader<ExtensionRegistry> extensionRegistryServiceLoader = ServiceLoader.load(ExtensionRegistry.class);
		for (ExtensionRegistry eachExtension : extensionRegistryServiceLoader) {
			eachExtension.register(this.testReportGenerator);
		}
	}

}
