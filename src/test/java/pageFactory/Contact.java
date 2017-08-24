package pageFactory;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import driverFactory.DriverManager;
import wrappers.WrapperMethods;

public class Contact extends WrapperMethods{
	
	@FindBy(name="firstName")
	private WebElement FN;

	@FindBy(name="lastName")
	private WebElement LN;
	
	@FindBy(id="city")
	private WebElement CT;
	
	@FindBy(id="state")
	private WebElement ST;
	
	@FindBy(name="emailAddress")
	private WebElement EM;
	
	@FindBy(id="topics")
	private WebElement TP;
	
	@FindBy(id="contact-us-submit")
	private WebElement SB;
	
	@FindBy(id="message")
	private WebElement Msg;
	
	public  Contact() throws Exception{
		PageFactory.initElements(DriverManager.getDriver(), this);
	}
	
	public Contact Enterfirstname(String firstname) throws IOException, Exception
	{
		entertext(FN, firstname);	
		return this;
	}
	
	public Contact Enterlastname(String lastname) throws IOException, Exception
	{
		entertext(LN, lastname);	
		return this;
	}
	
	public Contact Entercity(String city) throws IOException, Exception
	{
		entertext(CT, city);	
		return this;
	}
	
	public Contact Enterstate(String state) throws IOException, Exception
	{
		entertext(ST, state);	
		return this;
	}
	
	public Contact Enteremail(String email) throws IOException, Exception
	{
		entertext(EM, email);	
		return this;
	}
	
	public Contact Entertopics(String topic) throws IOException, Exception
	{
		entertext(TP, topic);	
		return this;
	}
	
	public Contact EnterMessage(String Message) throws IOException, Exception
	{
		entertext(Msg, Message);	
		return this;
	}
	
	public Contact selectState(String state) throws IOException, Exception
	{
		selectvalue(ST, state);	
		return this;
	}
	
	public Contact selectTopic(String topic) throws IOException, Exception
	{
		selectvalue(TP, topic);	
		return this;
	}
	
    public Contact clicksubmit() throws IOException, Exception
    {
           click(SB);
           return this;
           
    }}



