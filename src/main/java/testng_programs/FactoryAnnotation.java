package testng_programs;

import org.testng.annotations.Factory;

public class FactoryAnnotation {

	public FactoryAnnotation(int i) {}

	/*
		In TestNG, the @Factory annotation is used to create test instances at runtime. 
		It enables you to generate test classes or instances dynamically based on runtime conditions or parameters.

		You can use the @Factory annotation to create multiple instances of the same test class with different data sets 
		or parameters and run them in parallel to improve test execution speed. Here is an example of @factory annotations
	
	*/
	
	@Factory
	  public static Object[] createInstances() {
	    Object[] result = new Object[3];
	    for (int i = 0; i < result.length; i++) {
	      result[i] = new FactoryAnnotation(i);
	    }
	    return result;
	  }
}
