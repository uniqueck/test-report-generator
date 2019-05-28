package com.badenia.test.report.generator.rule;

import java.io.File;
import java.lang.annotation.Annotation;

import lombok.extern.slf4j.Slf4j;
import org.junit.AssumptionViolatedException;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import com.badenia.test.report.generator.extension.ITestReportGenerator;
import com.badenia.test.report.generator.extension.ITestReportGeneratorExtension;
import com.badenia.test.report.generator.extension.internal.ExtensionRegistryExecuter;

import lombok.AccessLevel;
import lombok.Getter;

@Slf4j
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
        logStatusAndTestMethodName(description, "succeeded");
    }

    @Override
    protected void failed(Throwable e, Description description) {
        super.failed(e, description);
        logStatusAndTestMethodName(description, "failed");
    }

    @Override
    protected void skipped(AssumptionViolatedException e, Description description) {
        super.skipped(e, description);
        logStatusAndTestMethodName(description, "skipped");

    }

    private void logStatusAndTestMethodName(Description description, String status) {
        if (log.isTraceEnabled()) {
            log.trace("report status {} for test {} to directory {}", status, description.getDisplayName(), getReportDirectory());
        }
    }


    @Override
    public <T extends Annotation> void register(Class<T> annotation, ITestReportGeneratorExtension<T> extension) {
        if (log.isTraceEnabled()) {
            log.trace(extension.getClass().getSimpleName());
        }
    }

}
