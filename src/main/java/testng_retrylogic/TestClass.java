package testng_retrylogic;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestClass {

	@Test
	public void testMethod1() {
		
		System.out.println("This is testMethod1 !!!");
		
		Assert.assertEquals(true, true, "testMethod1 failed !!!");
	}
	
	/*
	 * This is test level retry logic
	 * @Test(retryAnalyzer = RetryAnalyzer.class)
	 * Commented this line as AnnotationTransformer is implemented for Run Time check
	*/
	
	@Test
	public void testMethod2() {
		
		System.out.println("This is testMethod2 !!!");
		
		Assert.assertEquals(true, false, "testMethod2 failed !!!");
	}
	
	@Test
	public void testMethod3() {
		
		System.out.println("This is testMethod3 !!!");
		
		Assert.assertEquals(true, true, "testMethod3 failed !!!");
	}
}
