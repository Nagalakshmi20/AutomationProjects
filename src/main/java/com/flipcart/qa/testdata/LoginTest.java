package com.flipcart.qa.testdata;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.io.IOException;

import org.testng.annotations.Test;

import com.flipcart.qa.base.TestBase;
import com.flipcart.qa.pages.loginpages;

public class LoginTest extends TestBase {
	
	loginpages loginpage;
	public LoginTest() throws IOException {
		super();
		
	}
	@BeforeMethod
	public void loginInitialization() throws IOException
	{
		initialization();
		loginpage=new loginpages();
	}
	@Test(priority=1,enabled=false)
	public void validatelogin()
	{
		String un=prop.getProperty("userid");
		String pass=prop.getProperty("password");
		System.out.println("username::"+un+"password::"+pass);
		loginpage.validateLogin();
	}
	@Test(priority=1,enabled=false)
	public void validatePagetitleTest() throws IOException
	{
		loginpage.validateLogin();
		String title=loginpage.validatePagetitle();
		System.out.println("title::"+title);
		AssertJUnit.assertEquals("(20) Facebook",title);
		
	}
	@Test(priority=2,enabled=false)
	public void validateprofilenameTest()
	{
		loginpage.validateLogin();
		String profile=loginpage.validateprofile();
		Assert.assertEquals(profile, "Lakshmi");
	}
	
	
	@Test(priority=3)
	public void logout()
	{
		loginpage.validateLogin();
	WebElement logout=driver.findElement(By.xpath("//div[@id='logoutMenu']"));
	logout.click();
	WebDriverWait wait=new WebDriverWait(driver,30);
	wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[@class='_54nh'  and text()='Log Out']")))).click();
	//Actions action=new Actions(driver);
	
	}
	@AfterMethod
	public void tearDown(){
		//driver.findElement(By.xpath(xpathExpression))
		//driver.quit();
	}
}