package wrappers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
//import com.github.mkolisnyk.cucumber.runner.BeforeSuite;
import java.lang.reflect.Method; 

import driverFactory.DriverManager;


public class WrapperMethods {
	
	Method method;
	public static String filepath;
	
	public static String dataSheetName;
	public static String testCaseName;
	
	public static ExtentReports extn;
	public static ExtentTest test;
	public static ExtentHtmlReporter htmlreporter;
	//private static String extnReporthtml;
	protected static String browser; 
	protected static String  nodeip;
	public static String workingDirectory = System.getProperty("user.dir");
	public static String scrcaptureFilepath;
	public static String ReportPath;
	public static String UrL;
	
	public WrapperMethods()
	{
	File dir = new File("TestReport");
	dir.mkdir();
	File subdir = new File(dir+"/Screenshot/");
	subdir.mkdir();
	Date now = new Date();
	SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yy");
	String datefile = dateFormat.format(now);
	File datefodler = new File(dir+"/Screenshot/"+datefile);
	datefodler.mkdir();
	scrcaptureFilepath = new File(dir+"/Screenshot/"+datefile).getAbsolutePath();
	ReportPath = (workingDirectory+"\\"+dir+"\\Report.html");
	UrL = "https://www.transamerica.com/";
	}
	
	@BeforeSuite
	public void initreport(){
		extn = new ExtentReports();
		htmlreporter = new ExtentHtmlReporter(ReportPath);
		extn.attachReporter(htmlreporter);
		
	}
	
	@AfterSuite
	public void teardown(){
		extn.flush();
	}

	
	
	
	public void entertext(WebElement Elm, String Serachvalue) throws IOException, Exception{
		try{
			Elm.sendKeys(Serachvalue);
			
			test.pass(Elm.getAttribute("name") + " is Entered with "+ Serachvalue);
		}
		catch (Exception e)
		{
			filepath = Screencapture(DriverManager.getDriver());
			
			test.fail(e + " "+ test.addScreenCaptureFromPath(filepath));
		}
		
	}
	
	public void submit(WebElement Elm) throws Exception{
		try{
			filepath = Screencapture(DriverManager.getDriver());
			test.pass(Elm.getText() +" is Submitted"+test.addScreenCaptureFromPath(filepath));
			Elm.submit();
			
		}
		catch (Exception e)
		{
			filepath = Screencapture(DriverManager.getDriver());
			
			test.fail(e + " "+ test.addScreenCaptureFromPath(filepath));
			}
	}
	
	public void mousehover(WebElement Elm) throws Exception{
		try{
            Actions action = new Actions(DriverManager.getDriver());
            action.moveToElement(Elm).build().perform(); 
            action.click(Elm);
            action.perform();
        }
            catch (Exception e)
            {	
            filepath = Screencapture(DriverManager.getDriver());
			
			test.fail(e + " "+ test.addScreenCaptureFromPath(filepath));
		}}
     		
	public void jsexecutor(WebElement Elm) throws Exception{
		try{
			JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
			js.executeScript("window.scrollBy(0,1700)");
	        //js.executeScript("document.getElementById('Elm').click();");
        }
            catch (Exception e)
            {	
            filepath = Screencapture(DriverManager.getDriver());
			
			test.fail(e + " "+ test.addScreenCaptureFromPath(filepath));
		}}
	
	public void click(WebElement Elm) throws IOException, Exception {
		try{
			filepath = Screencapture(DriverManager.getDriver());
			test.pass(Elm.getText() +" is Submitted"+test.addScreenCaptureFromPath(filepath));
			//Elm.submit();	
			Elm.click();
		test.pass(Elm.getText() + " is Clicked");
		
		} catch (Exception e) {
			filepath = Screencapture(DriverManager.getDriver());
			test.fail(e + " "+ test.addScreenCaptureFromPath(filepath));
		}
		
	}
	
	
	
	public void selectvalue(WebElement Elm, String value) throws IOException, Exception {
		
		try{
			new Select(Elm).selectByVisibleText(value);
			test.pass(Elm.getAttribute("name") + " is Selected with value "+ value);
		
		}
		catch (Exception e) {
			filepath = Screencapture(DriverManager.getDriver());
			test.fail(e + " "+ test.addScreenCaptureFromPath(filepath));
		}
		
	}
	
	public void Pageloadwait(WebElement Elm) throws IOException, Exception {
		
		try{
			WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), 30);
			//wait.until(ExpectedConditions.elementToBeClickable();
			wait.until(ExpectedConditions.visibilityOf(Elm));
			//wait.until(ExpectedConditions.visibilityOf(Elm));
			//wait.until(ExpectedConditions.presenceOfElementLocated((By) Elm));
			Thread.sleep(20000);
			
			test.pass(Elm.getText() +" Available for Click");
			
		}
		catch (Exception e) {
			filepath = Screencapture(DriverManager.getDriver());
			test.fail(e + " "+ test.addScreenCaptureFromPath(filepath));
		}
		
	}
	
	
	public static String Screencapture(WebDriver driver) throws IOException {
		// TODO Auto-generated method stub
		
		Date now = new Date();
		SimpleDateFormat timeformat = new SimpleDateFormat("hhmmss");
		String scrFilename = scrcaptureFilepath+"/ScreenCaptureFile_"+timeformat.format(now)+".png";
		 File src= ((TakesScreenshot)driver). getScreenshotAs(OutputType. FILE);
		
		 FileUtils. copyFile(src, new File(scrFilename));
		 
		 
		return  scrFilename;
	}
	
	@DataProvider
	public Object[][] getdata(){
		
		//return fetchdata (method.getName());
		return fetchdata (dataSheetName);
		
	}
	
	
	public static String[][] fetchdata(String dataSheetName){
		String[][] data = null;

		try {
			FileInputStream fis = new FileInputStream(new File(workingDirectory+"/Data/TestData.xlsx"));
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			//XSSFSheet sheet = workbook.getSheetAt(0);	
			XSSFSheet sheet =workbook.getSheet(dataSheetName);
			// get the number of rows
			int rowCount = sheet.getLastRowNum();

			// get the number of columns
			int columnCount = sheet.getRow(0).getLastCellNum();
			data = new String[rowCount][columnCount];


			// loop through the rows
			for(int i=1; i <rowCount+1; i++){
				try {
					XSSFRow row = sheet.getRow(i);
					for(int j=0; j <columnCount; j++){ // loop through the columns
						try {
							String cellValue = "";
							try{
								cellValue = row.getCell(j).getStringCellValue();
								
							}catch(NullPointerException e){

							}

							data[i-1][j]  = cellValue; // add to the data array
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}				
					}

				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			fis.close();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return data;
		
	}
	
}
	

