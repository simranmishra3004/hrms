package scripts;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class MyFirstTestNGTest {
	WebDriver driver;
  @Test //Test annotation
  public void wikiTest() {
	  //All the test steps will go here
		driver.get("https://www.wikipedia.org/");
		driver.findElement(By.id("js-link-box-en")).click(); 
		driver.findElement(By.id("searchInput")).sendKeys("Selenium");
		driver.findElement(By.id("searchButton")).click();
		String expectedOutput = "Selenium";
		String actualOutput = driver.findElement(By.id("firstHeading")).getText();
		assertEquals(actualOutput,expectedOutput);
/*		if (expectedOutput.equals(actualOutput)) {
			System.out.println("Heading Test Case Passed");
		}
		else {
			System.out.println("Heading Test Case Failed");
		}*/
		
		String expectedPageTitle = "Selenium - Wikipedia1";
		String actualPageTitle = driver.getTitle();
		
	/*	if (expectedPageTitle.equals(actualPageTitle)) {
			System.out.println("Page Title Test Case Passed");
		}
		else {
			System.out.println("Page Title Test Case Failed");
		}*/
	//	assertEquals(actualPageTitle,expectedPageTitle);
		assertEquals(actualPageTitle,expectedPageTitle, "Expected Title does not match with actual on page");
  }
  
 // @Test
  public void googleTest() {
	  driver.get("http://www.google.com");
	  driver.findElement(By.name("q")).sendKeys("Selenium Jobs");
  }
  

 // @Test
  public void yahooTest() {
	  driver.get("http://www.yahoo.com");
	  //driver.findElement(By.tagName("q")).sendKeys("Selenium Jobs");
  }

  
  
  @BeforeMethod  //before method annotation
  public void beforeMethod() {
	  //You should code pre-requisite here
	  //Open the browser
/*		System.setProperty("webdriver.chrome.driver","C:\\temp\\webdrivertraining\\test\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
*/	
	  System.out.println("Inside Before Method");
  }
  
  @BeforeClass
  public void onlyOnceBeforeFirstMethod() {
		System.setProperty("webdriver.chrome.driver","C:\\temp\\webdrivertraining\\test\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
  }

  @AfterMethod //after method annotation
  public void afterMethod() {
	  //test case cleanup will happen here
	  //close the browser
//	  driver.quit();
	  System.out.println("Inside After Method");
  }

  @AfterClass
  public void afterLastTest() {
	  driver.quit();
  }
}
