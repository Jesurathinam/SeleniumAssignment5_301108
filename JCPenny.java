package com.ibm.seleniumassignments;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class JCPenny {
	public static void main(String[] args) throws InterruptedException{
		//About the program
		System.out.println("This program will shop for a shirt");
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
		chrdriver.get("https://www.jcpenney.com/");
		String url=chrdriver.getCurrentUrl();
		System.out.println("Application URL: "+url);
		String title=chrdriver.getTitle();
		System.out.println("Initial Page Title: "+title);
		//To handle the pop up window and to click the continue shopping from the popup window
		boolean windowDisp=chrdriver.findElement(By.xpath("//*[@id='modal']")).isDisplayed();
		if (windowDisp=true)
		{
			System.out.println("Shipping to India popup window is displayed");
			WebElement windowDispClose=chrdriver.findElement(By.xpath("//a[@id='closeButton']"));
			windowDispClose.click();
		}
		else
		{
			System.out.println("Shipping to India popup window is not displayed");
		}		
		Thread.sleep(1000);
		//To position to search box
		WebElement searchEle= chrdriver.findElement(By.xpath("//input[@id='searchTerm']"));
		searchEle.click();
		System.out.println("Search box found");
		//To enter 'Shirt' text in search box
		searchEle.sendKeys("Shirt");
		//To find and click the search icon
		WebElement submitEle= chrdriver.findElement(By.xpath("//button[@title='search']"));
		submitEle.click();
		//To get and click the first link from the search result
		WebElement searchResult=chrdriver.findElement(By.xpath("//ul[@class='productList']/li[1]/div[1]/a/img"));
		searchResult.click();
		System.out.println("First search result clicked");
		//To select size range
		Select sizeRange=new Select(chrdriver.findElement(By.xpath("//select[@id='SIZE_RANGE']")));
		sizeRange.selectByVisibleText("regular");
		System.out.println("Size Range selected");
		//To select size
		Select size=new Select(chrdriver.findElement(By.xpath("//select[@id='SIZE']")));
		size.selectByVisibleText("small");
		System.out.println("Size selected");
		//To select quantity
		Select qty=new Select(chrdriver.findElement(By.xpath("//select[@id='QUANTITY']")));
		qty.selectByVisibleText("1");
		System.out.println("Quantity selected");
		//To select color
		WebElement color=chrdriver.findElement(By.xpath("//ul[@class='pp__sku--list ']/li[1]/img"));
		color.click();
		System.out.println("Color selected");
		//To click add to bag
		WebElement addToBag=chrdriver.findElement(By.xpath("//button[@name='add to bag']"));
		addToBag.click();
		System.out.println("Item added to cart"); 
		Thread.sleep(1000);
		//To handle check out window
/*		boolean checkWindow=chrdriver.findElement(By.xpath("//span[@id='topHeading']")).isDisplayed();
		
		System.out.println(checkWindow);
		if(checkWindow=true)
		{ 
			chrdriver.switchTo().activeElement();
			WebElement proceed=chrdriver.findElement(By.xpath("//input[@id='btncheckout']"));
			proceed.click();
			System.out.println("Checkout button clicked");
		}
		else
			System.out.println("Check out window not displayed");
*/
		System.out.println("This is the end of the program");
				
	}

}
