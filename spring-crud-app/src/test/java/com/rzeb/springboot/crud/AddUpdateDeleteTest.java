package com.rzeb.springboot.crud;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import junit.framework.Assert;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AddUpdateDeleteTest {

	private WebDriver driver;
	private String url;
	private String firstName, newFirstName;
	private String lastName, newLastName;
	private String email, newEmail;
	
	@Before
	public void setUp() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\zrafa\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		url = "http://localhost:8080/contacts/list";
		firstName = "Test1";
		lastName = "Test1111";
		email = "Test@test.test";
		newFirstName = "Test2";
		newLastName = "Test222";
		newEmail = "Test2@test2.test2";
	}	
	
	@Test
	public void addContactTest() {
		
		driver.get(url);
		driver.findElement(By.partialLinkText("Add Contact")).click();
		
		WebElement first = driver.findElement(By.name("firstName"));
		WebElement last = driver.findElement(By.name("lastName"));
		WebElement em = driver.findElement(By.name("email"));
		
		first.sendKeys(firstName);
		last.sendKeys(lastName);
		em.sendKeys(email);
		
		driver.findElement(By.id("save")).click();
		//assert contact's added
		Assert.assertTrue(driver.getPageSource().contains(firstName));
		Assert.assertTrue(driver.getPageSource().contains(lastName));
		Assert.assertTrue(driver.getPageSource().contains(email));
	}
	
	@Test
	public void bUpdateContactTest() {
		
		driver.get(url);
		driver.findElement(By.xpath("//td[text()='Test1']/following::td[3]/descendant::a[@id='update']")).click();
		
		WebElement first = driver.findElement(By.id("firstName"));
		first.clear();
		first.sendKeys(newFirstName);
		WebElement last = driver.findElement(By.id("lastName"));
		last.clear();
		last.sendKeys(newLastName);
		WebElement em = driver.findElement(By.id("email"));
		em.clear();
		em.sendKeys(newEmail);
		

		driver.findElement(By.id("save")).click();
		//assert contact's updated
		Assert.assertTrue(driver.getPageSource().contains(newFirstName));
		Assert.assertTrue(driver.getPageSource().contains(newLastName));
		Assert.assertTrue(driver.getPageSource().contains(newEmail));
	}
	
	@Test
	public void cDeleteContactTest() {
		
		driver.get(url);
		driver.findElement(By.xpath("//td[text()='Test2']/following::td[3]/descendant::a[@id='delete']")).click();
		driver.switchTo().alert().accept();
		//assert contact's deleted
		Assert.assertTrue(!driver.getPageSource().contains(newFirstName));
		Assert.assertTrue(!driver.getPageSource().contains(newLastName));
		Assert.assertTrue(!driver.getPageSource().contains(newEmail));
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
	
}
