package testCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import driverFactory.DriverManager;
import pageFactory.Contact;
import pageFactory.Homepage;
import wrappers.WrapperMethods;

public class TACreateContact extends WrapperMethods{
	
	
	@BeforeTest
	public void testdescriptions(){
		testCaseName = "createcontact";
		test = extn.createTest(testCaseName);
		dataSheetName = testCaseName;
	}
	
	@Test (dataProvider = "getdata")
	public void createcontact(String firstname, String lastname, String email, String city, String state, String topic, String Message) throws IOException, Exception{
		
		DriverManager.getDriver().get(UrL);		
		new Homepage()
		.waitforpageload()
		.clickcontact();
		
		new Contact()
		.Enterfirstname(firstname)
		.Enterlastname(lastname)
		.Enteremail(email)
		.Entercity(city)
		.selectState(state)
		.selectTopic(topic)
		.EnterMessage(Message)	
		.clicksubmit();
	}

}
