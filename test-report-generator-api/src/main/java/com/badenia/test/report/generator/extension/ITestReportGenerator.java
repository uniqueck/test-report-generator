package com.badenia.test.report.generator.extension;

import java.lang.annotation.Annotation;

public interface ITestReportGenerator {

	<T extends Annotation> void register(Class<T> annotation, ITestReportGeneratorExtension<T> extension);
	
	
}
