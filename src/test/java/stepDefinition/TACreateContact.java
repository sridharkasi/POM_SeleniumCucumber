package stepDefinition;

import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import driverFactory.DriverInstance;
import driverFactory.DriverManager;
import pageFactory.Contact;
import pageFactory.Homepage;
import wrappers.WrapperMethods;

public class TACreateContact extends WrapperMethods {
	Homepage hompg;
	Contact cntct;
	
	public TACreateContact(){
	hompg = new Homepage();
	try {
		cntct = new Contact();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

@When("^I Navigate the application \"([^\"]*)\" using browser \"([^\"]*)\"$")
public void i_Navigate_the_application_using_browser(String url, String browser) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	
	test = extn.createTest("TC_CreateContact_Cucumber");
	DriverManager.getDriver().get(url);
}

@Given("^I am in transamerica home page$")
public void i_am_in_transamerica_home_page() throws Throwable {
	
    // Write code here that turns the phrase above into concrete actions
	test.info(DriverManager.getDriver().getTitle());
	
}

@When("^I click the Contact page$")
public void i_click_the_Contact_page() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	hompg.waitforpageload();
	hompg.clickcontact();
}


@When("^enter the contact details \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
public void enter_the_contact_details(String firstname, String lastname, String email, String city, String state, String topic, String Message) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	cntct.Enterfirstname(firstname);
	cntct.Enterlastname(lastname);
	cntct.Enteremail(email);
	cntct.Entercity(city);
	cntct.selectState(state);
	cntct.selectTopic(topic);
	cntct.EnterMessage(Message);
	
}


@Then("^Verify the contact details sumbited$")
public void verify_the_contact_details_sumbited() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	cntct.clicksubmit();
}

}
