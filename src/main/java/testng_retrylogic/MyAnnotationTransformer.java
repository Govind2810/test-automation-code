package testng_retrylogic;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

public class MyAnnotationTransformer implements IAnnotationTransformer {

	@Override
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
        
		annotation.setRetryAnalyzer(RetryAnalyzer.class);
		
		/*
        // Example: Disable tests that contain "Skip" in their method name
        if (testMethod.getName().contains("Skip")) {
            annotation.setEnabled(false);
        }

        // Example: Change invocation count dynamically for methods with specific names
        if (testMethod.getName().equals("testMethodWithRetry")) {
            annotation.setInvocationCount(3); // Run the test 3 times
        }

        // Example: Set custom timeout for long-running test methods
        if (testMethod.getName().equals("longRunningTest")) {
            annotation.setTimeOut(5000); // Timeout set to 5000 ms (5 seconds)
        }
        */
    }
}
