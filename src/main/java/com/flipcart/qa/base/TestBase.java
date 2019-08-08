package com.flipcart.qa.base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop=new Properties();
	public TestBase() throws IOException
	{
		try {
		
		FileInputStream fis =new FileInputStream("C:\\Users\\Girish\\FilpcartMaven\\src\\main\\java\\com\\flipcart\\qa\\config\\config.properties");
		prop.load(fis);
				
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void initialization()
	{
	 String broswername=prop.getProperty("browser");
	 System.out.println(broswername);
	 if(broswername.equalsIgnoreCase("chrome"))
	 {		
		System.setProperty("webdriver.chrome.driver","D:\\lakshmi\\library\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
	}
	 else
	 {
		 System.out.println("incorrect browser specification");
	 }
	 String url=prop.getProperty("url");
	 driver.get(url);
	 driver.manage().deleteAllCookies();
	 driver.manage().window().maximize();
	 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	public static void main(String args[]) throws IOException
	{
		TestBase t=new TestBase();
		t.initialization();
		
	}
	
}
