package listener;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

import driverFactory.DriverInstance;
import driverFactory.DriverManager;


public class WebDriverListener implements  IInvokedMethodListener{
	
	
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
        if (method.isTestMethod()) {
            String browserName = method.getTestMethod().getXmlTest().getLocalParameters().get("browserName");
            WebDriver driver = DriverInstance.createInstance(browserName);
            DriverManager.setWebDriver(driver);
           
        }
    }

    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        if (method.isTestMethod()) {
            WebDriver driver = DriverManager.getDriver();
            if (driver != null) {
                driver.quit();
            }
        }
    }

}
