package com.flipcart.qa.pages;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.flipcart.qa.base.TestBase;

public class loginpages extends TestBase{
	/*@FindBy(xpath="//input[@class='_2zrpKA _1dBPDZ']")
	WebElement username;
	
	@FindBy(xpath="//input[@class='_2zrpKA _3v41xv _1dBPDZ']")
	WebElement password;
	
	@FindBy(xpath="//button[contains(@class,'_2AkmmA _1LctnI _7UHT_c')]")
	WebElement submit;*/
	
	@FindBy(id="email")
	WebElement username;
	
	@FindBy(id="pass")
	WebElement password;
	
	@FindBy(xpath="//input[@value='Log In']")
	WebElement login;
	@FindBy(xpath="//img[@class='_2qgu _7ql _1m6h img']/following-sibling::span[@class='_1vp5']")
	WebElement profilename;
	
	public loginpages() throws IOException
	{
			
		PageFactory.initElements(driver, this);
	}
	public String validatePagetitle()
	{
		String t=driver.getTitle();
		System.out.println(t);
		return t;
	}
	public void validateLogin()
	{

		String un=prop.getProperty("userid");
		String pass=prop.getProperty("password");
		username.sendKeys(un);
		password.sendKeys(pass);
		login.click();
	}
	public String validateprofile()
	{
		String prof=profilename.getText();
		System.out.println("profilename:"+prof);
		return prof;
	}
	public static void main(String args[]) throws IOException
	{
		loginpages lg=new loginpages();
		//lg.validateLogin();
		
	}
	
}
	
