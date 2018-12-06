package com.ibm.seleniumassignments;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FacebookXpath {
	public static void main(String[] args){
		//About the program
		System.out.println("This program will use xpaths for firstname, surname, mobile number, new password, sign up");
		//Set property for chrome driver
		System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
		WebDriver chrdriver=new ChromeDriver();
		//Explicit Wait
		WebDriverWait wait=new WebDriverWait(chrdriver, 60); 
		//To maximize the window
		chrdriver.manage().window().maximize();
		//Implicit Wait
		chrdriver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		//Launch page
		chrdriver.get("https://www.facebook.com/");
		String url=chrdriver.getCurrentUrl();
		System.out.println("Application URL: "+url);
		String title=chrdriver.getTitle();
		System.out.println("Initial Page Title: "+title);
		//To position to the first name
		WebElement fnameEle=chrdriver.findElement(By.xpath("//input[@name='firstname']"));
		//Enter value for first name
		fnameEle.sendKeys("Rathna");
		System.out.println("First name entered");
		
		//To position to the surname
		WebElement surnameEle=chrdriver.findElement(By.xpath("//input[@name='lastname']"));
		//Enter value for surname
		surnameEle.sendKeys("Albert");
		System.out.println("Last name entered");

		//To position to the mobile number or email
		WebElement mobEmailEle=chrdriver.findElement(By.xpath("//input[@name='reg_email__']"));
		//Enter value for mobile number or email
		mobEmailEle.sendKeys("9840820651");
		System.out.println("mobile nummber entered");

		//To position to the new password
		WebElement newPassEle=chrdriver.findElement(By.xpath("//input[@name='reg_passwd__']"));
		//Enter value for new password
		newPassEle.sendKeys("facebook$123");
		System.out.println("Password entered");
		
		//To position to day
		Select day=new Select(chrdriver.findElement(By.xpath("//select[@id='day']")));
		day.selectByVisibleText("8");

		//To position to month
		Select month=new Select(chrdriver.findElement(By.xpath("//select[@id='month']")));
		month.selectByVisibleText("Apr");

		//To position to year
		WebElement yearddEle = chrdriver.findElement(By.xpath("//select[@id='year']"));
		yearddEle.click();
		//To select year from drop down
		WebElement yearEle = chrdriver.findElement(By.xpath("//*[@value='1983']"));
		yearEle.click(); 
		
		//To position and click Female/Male radio button
		WebElement genderEle=chrdriver.findElement(By.xpath("//input[@value='1']"));
		genderEle.click();

		//To position to sign up
		WebElement signupEle=chrdriver.findElement(By.xpath("//button[@name='websubmit']"));
		signupEle.click();
		System.out.println("Sign up button clicked"); 

		System.out.println("This is the end of the program");
				
	}

}
