package testCases;

import org.testng.annotations.Test;

import driverFactory.DriverManager;


public class SampleTest {

	@Test
    public void testMethod1() {
        invokeBrowser("http://www.ndtv.com");
    }
 
   // @Test
    public void testMethod2() {
        invokeBrowser("http://www.facebook.com");
 
    }
 
    private void invokeBrowser(String url) {
        System.out.println("Thread id = " + Thread.currentThread().getId());
        System.out.println("Hashcode of webDriver instance = " + DriverManager.getDriver().hashCode());
        DriverManager.getDriver().get(url);
 
    }
}
