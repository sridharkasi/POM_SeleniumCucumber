package pageFactory;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import driverFactory.DriverManager;
import wrappers.WrapperMethods;

public class Homepage extends WrapperMethods{
	
	@FindBy(xpath = "//li[normalize-space(text())='Contact']")
	private WebElement Contact;
	
	@FindBy(xpath = "//nav[@id='navMenu']/ul[2]/li[1]")
	private WebElement Products;
	
	

	public Homepage(){
		PageFactory.initElements(DriverManager.getDriver(), this);
	}
	
	public Homepage waitforpageload() throws IOException, Exception
	{
		Pageloadwait(Contact);
		return this;
	}
	
	public Homepage clickcontact() throws IOException, Exception
    {
           click(Contact);
           return this;
    }   
	
}
