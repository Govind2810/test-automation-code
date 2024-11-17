package testng_programs;

import org.testng.annotations.Test;

public class TestAnnotationAttributes {

	    // 1. alwaysRun
	    @Test(alwaysRun = true)
	    public void testAlwaysRun() {
	        System.out.println("This method will always run, even if dependencies fail.");
	    }

	    // 2. dataProvider
	    @Test(dataProvider = "dataProviderMethod")
	    public void testDataProvider(String data) {
	        System.out.println("Data: " + data);
	    }

	    @org.testng.annotations.DataProvider
	    public Object[][] dataProviderMethod() {
	        return new Object[][] { { "data1" }, { "data2" } };
	    }

	    // 3. dataProviderClass
	    @Test(dataProvider = "dataProviderMethod", dataProviderClass = ExternalDataProvider.class)
	    public void testDataProviderClass(String data) {
	        System.out.println("External Data: " + data);
	    }

	    // 4. description
	    @Test(description = "This is a test method with a description.")
	    public void testDescription() {
	        System.out.println("Test with description.");
	    }

	    // 5. enabled
	    @Test(enabled = false)
	    public void testDisabled() {
	        System.out.println("This test is disabled and will not run.");
	    }

	    // 6. expectedExceptions
	    @Test(expectedExceptions = ArithmeticException.class)
	    public void testExpectedException() {
//	        int result = 1 / 0; // This will throw ArithmeticException
	    }

	    // 7. expectedExceptionsMessageRegExp
	    @Test(expectedExceptions = ArithmeticException.class, expectedExceptionsMessageRegExp = "/ by zero")
	    public void testExpectedExceptionMessage() {
//	        int result = 1 / 0; // This will throw ArithmeticException with message "/ by zero"
	    }

	    // 8. groups
	    @Test(groups = { "group1", "group2" })
	    public void testGroups() {
	        System.out.println("This test belongs to groups group1 and group2.");
	    }

	    // 9. invocationCount
	    @Test(invocationCount = 3)
	    public void testInvocationCount() {
	        System.out.println("This test will run 3 times.");
	    }

	    // 10. invocationTimeOut
	    @Test(invocationCount = 3, invocationTimeOut = 1000)
	    public void testInvocationTimeout() {
	        System.out.println("This test will run 3 times, but with a total timeout of 1000ms.");
	    }

	    // 11. priority
	    @Test(priority = 1)
	    public void testPriority() {
	        System.out.println("This test has a priority of 1.");
	    }

	    // 12. successPercentage
	    @Test(invocationCount = 5, successPercentage = 80)
	    public void testSuccessPercentage() {
	        System.out.println("This test should pass at least 80% of the time.");
	    }

	    // 13. testName
	    @Test(testName = "CustomTestName")
	    public void testCustomName() {
	        System.out.println("This test has a custom name: CustomTestName.");
	    }

	    // 14. timeOut
	    @Test(timeOut = 1000)
	    public void testTimeout() {
	        System.out.println("This test must finish within 1000ms.");
	    }

	    // 15. dependsOnGroups
	    @Test(dependsOnGroups = { "group1" })
	    public void testDependsOnGroups() {
	        System.out.println("This test depends on group1.");
	    }

	    // 16. dependsOnMethods
	    @Test(dependsOnMethods = { "testAlwaysRun" })
	    public void testDependsOnMethods() {
	        System.out.println("This test depends on testAlwaysRun method.");
	    }

	    // 17. skipFailedInvocations
	    @Test(invocationCount = 3, skipFailedInvocations = true)
	    public void testSkipFailedInvocations() {
	        System.out.println("This test will skip remaining invocations if it fails.");
	    }
}

class ExternalDataProvider {
    @org.testng.annotations.DataProvider
    public static Object[][] dataProviderMethod() {
        return new Object[][] { { "externalData1" }, { "externalData2" } };
    }
}
