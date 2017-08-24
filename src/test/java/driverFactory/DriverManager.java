package driverFactory;

import org.openqa.selenium.WebDriver;

public class DriverManager {
	
	private static ThreadLocal <WebDriver> Driver = new ThreadLocal <WebDriver>();
	 
	 public static WebDriver getDriver() {
	        return Driver.get();
	    }
	 
	    public static void setWebDriver(WebDriver driver) {
	    	Driver.set(driver);
	    }

}
