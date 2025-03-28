package com.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.Status;
import com.extentReports.ExtentTestManager;

public class BasePage {
	   private static final By WebElement = null;
		public static WebDriver driver;
	    public  WebDriverWait wait;
	    public static String NewApplicantName;


	// Constructor
	public BasePage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		
	}

	public String writeDynamicLastname() {
		String allowedChars = "abcdefghijklmnopqrstuvwxyz" + "AEIOU";
	    String lastname = "";
	    String lastnameDomain = "";
	    String temp = RandomStringUtils.random(25, allowedChars);
	    lastnameDomain = temp.substring(0, temp.length() - 15);
	    lastname = temp.substring(0, temp.length() - 9);
	    return lastname;		
	}
	
	public String writeDynamicFirstLastname() {
        String allowedChars = "abcdefghijklmnopqrstuvwxyz" + "AEIOU";
        String temp = RandomStringUtils.random(25, allowedChars);

        // Adjust the substring lengths based on your requirements
        String lowercaseLastname = temp.substring(0, temp.length() - 9);

        // Make the first character uppercase
        String capitalizedLastname = Character.toUpperCase(lowercaseLastname.charAt(0)) + lowercaseLastname.substring(1);

        return capitalizedLastname;
    }
	
	// Click Method
	public void click(By element) throws InterruptedException {	
		Thread.sleep(1100);
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofMillis(5000));
		wait.until(ExpectedConditions.elementToBeClickable(element)).click();
		Thread.sleep(1100);
	}

	public void select(By by, String text) throws InterruptedException {
		// waitVisibility(by).click();
		Thread.sleep(1000);
	   	click(By.xpath("//span[text()='"+text+"']"));
	   	Thread.sleep(1000);

	}

	public Select selectVal(By by) throws InterruptedException {
		waitVisibility(by).click();
		// click(By.xpath("//div[@class='row margin_bottom_0px censuslist
		// Applicantcensus showncensus']//span[text()='"+text+"']"));
		return null;

	}

	public void clear(By by) {
		waitVisibility(by).clear();
	}

	public void submit(By by) {
		waitVisibility(by).submit();
	}

	// Write Text
	public void writeText(By by, String text) throws InterruptedException {
//		Thread.sleep(1000);
//        waitVisibility(WebElement).sendKeys(text);
//    	Thread.sleep(1000);
		 Thread.sleep(800);
 	//	WebDriverWait wait2 = new WebDriverWait(driver, 30);
		WebDriverWait wait2=new WebDriverWait(driver, Duration.ofMinutes(1));
 		wait2.until(ExpectedConditions.presenceOfElementLocated(by)).sendKeys(text);
		    Thread.sleep(800);
		
	}

	public String writeDynamicEmail() {
		String allowedChars = "abcdefghijklmnopqrstuvwxyz" + "1234567890";
	    String email = "";
	    String emailDomain = "";
	    String temp = RandomStringUtils.random(25, allowedChars);
	    emailDomain = temp.substring(0, temp.length() - 15);
	    email = temp.substring(0, temp.length() - 9) + "@" + "yopmail.com";
	    return email;		
	}
	
	    public static String generatePhoneNumber() {
	        Random rand = new Random();
	        
	    
	        String phoneNumber = "7"; 
	        for (int i = 0; i < 9; i++)
	        {
	            phoneNumber += rand.nextInt(10); 
	            
	        }
	        
	        return phoneNumber;
	    }
	    
	    public static String generateNumber() {
	        Random rand = new Random();
	        
	    
	        String phoneNumber = "7"; 
	        for (int i = 0; i < 4; i++)
	        {
	            phoneNumber += rand.nextInt(5); 
	            
	        }
	        
	        return phoneNumber;
	    }
	    
	 
	public String writeEmailToExcel(String emailText) throws IOException {
		String excelFilePath = ".\\src\\test\\resources\\TestData.xlsx";
        FileInputStream inputStream = new FileInputStream(excelFilePath);
        Workbook workbook = new XSSFWorkbook(inputStream);
        String sheetName = "TestCase Regression 8";
        Sheet sheet = workbook.getSheet(sheetName);
        int rowIndex = 1;  
        int columnIndex = 9; 
        Row row = sheet.getRow(rowIndex);
        Cell cell = row.createCell(columnIndex);
        cell.setCellValue(emailText);  
        inputStream.close();
		FileOutputStream outputStream = new FileOutputStream(excelFilePath);
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();
		return null;		
	}
	
	public void writetext(WebElement txt, String text) {
		waitVisibility(WebElement).sendKeys(text);
		
	}

	// Read Text
	public String readText(By by) {
		return waitVisibility(by).getText();
	}
 
	// Wait
	public WebElement waitVisibility(By by) {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}

	public static void JavascriptClick(By by, WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", by);
	}
	 public static void ExtentSuccessMessage(String strPassSuccessMessage) {
			ExtentTestManager.getTest().log(Status.PASS, strPassSuccessMessage);
	}

	public static void ExtentErrorMessage(String strPassErrorMessage) {
			ExtentTestManager.getTest().log(Status.FAIL, strPassErrorMessage);
	}
	public void HandleDropDown(WebElement ele, String ele2)
	{
		Select s=new Select(ele);
		s.selectByValue(ele2);
	}
	public void ActionClick(WebElement ele) throws InterruptedException
	{
		Thread.sleep(1000);
		Actions act=new Actions(driver);
		act.click(ele).perform();
		Thread.sleep(1000);

	}
	
	public void MoveToElementClick(WebElement element) throws InterruptedException {    
        Thread.sleep(1000);
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        // Use JavaScript Executor to move to the element
        jsExecutor.executeScript("arguments[0].scrollIntoView({behavior: 'auto', block: 'center', inline: 'center'});", element);
        // Click the element using JavaScript Executor
        jsExecutor.executeScript("arguments[0].click();", element);
    }
	
	public static Properties configloader() throws IOException {
		FileInputStream File = new FileInputStream(".\\src\\test\\resources\\config.properties");
		Properties properties = new Properties();
		properties.load(File);
		return properties;
	}
	
	////Zoom in and zoom out
	// Screen size will be 100%
	public void Zoomout() throws AWTException {
		Robot robot = new Robot(); 
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.delay(1000);
		robot.keyPress(KeyEvent.VK_0);
		robot.delay(1000);
		robot.keyRelease(KeyEvent.VK_0);
		robot.delay(1000);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.delay(1000);         
	}
	// Screen size will minues via value
	public void Zoomin(int value) throws AWTException {
		Robot robot = new Robot();
		for (int i = 0; i < value; i++) {
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.delay(1000);
			robot.keyPress(KeyEvent.VK_SUBTRACT);
			robot.delay(1000);
			robot.keyRelease(KeyEvent.VK_SUBTRACT);
			robot.delay(1000);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.delay(1000);
		}
	}
}

