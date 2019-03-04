package com.ckr.test.report.generator.rule;

import java.io.File;
import java.lang.annotation.Annotation;

import org.junit.AssumptionViolatedException;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import com.ckr.test.report.generator.extension.ITestReportGenerator;
import com.ckr.test.report.generator.extension.ITestReportGeneratorExtension;
import com.ckr.test.report.generator.extension.internal.ExtensionRegistryExecuter;

import lombok.AccessLevel;
import lombok.Getter;

@Getter(AccessLevel.PROTECTED)
public class TestReportGeneratorRule extends TestWatcher implements ITestReportGenerator {

	private File reportDirectory;
	private Serializer serializer;
	private ExtensionRegistryExecuter extensionRegistryExecuter;

	public static TestReportGeneratorRule reportInFolder(File targetDirectory) {
		return new TestReportGeneratorRule(targetDirectory);
	}

	private TestReportGeneratorRule(File reportDirectory) {
		this.reportDirectory = reportDirectory;
		this.serializer = new Persister();
		this.extensionRegistryExecuter = new ExtensionRegistryExecuter(this);
		this.extensionRegistryExecuter.registerAllExtensions();
	}

	@Override
	protected void succeeded(Description description) {
		super.succeeded(description);
		System.out.println(reportDirectory);
	}

	@Override
	protected void failed(Throwable e, Description description) {
		super.failed(e, description);
	}
	
	@Override
	protected void skipped(AssumptionViolatedException e, Description description) {
		super.skipped(e, description);
	}
	

	@Override
	public <T extends Annotation> void register(Class<T> annotation, ITestReportGeneratorExtension<T> extension) {
		System.out.println(extension);
	}

}
