package com.ibm.seleniumassignments;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FacebookSignIn {
	public static void main(String[] args){
		//About the program
		System.out.println("This program will sing in to face book with existing user credentials");
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
		//To position to Email or Phone
		WebElement emailEle=chrdriver.findElement(By.xpath("//input[@name='email']"));
		//Enter value for Email or Phone
		emailEle.sendKeys("9840820651");
		System.out.println("Email entered");
		
		//To position to the Password
		WebElement PassEle=chrdriver.findElement(By.xpath("//input[@name='pass']"));
		//Enter value for password
		PassEle.sendKeys("facebook$123");
		System.out.println("Password entered");

		//To position to Login
		WebElement loginEle=chrdriver.findElement(By.xpath("//input[@value='Log In']"));
		loginEle.click();
		System.out.println("Sign up button clicked");

		System.out.println("This is the end of the program");
				
	}

}
