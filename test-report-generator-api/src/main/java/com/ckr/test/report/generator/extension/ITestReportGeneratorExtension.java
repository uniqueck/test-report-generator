package com.ckr.test.report.generator.extension;

import java.lang.annotation.Annotation;

public interface ITestReportGeneratorExtension<T extends Annotation> {

	Object extract(T annotation);
	
}
