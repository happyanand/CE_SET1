package com.pages;

import java.util.ArrayList;
import java.util.Random;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import Utility.ExcelHelper;

public class Landing_Page extends BasePage {
	public Landing_Page(WebDriver driver) {
		super(driver);
	}

	JavascriptExecutor js = (JavascriptExecutor) driver;
	JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
	WebElement element;
		ExcelHelper _excelObj = new ExcelHelper();
		XSSFSheet tcTestData = _excelObj.readExcelSheet("TestData", "URLs");
		
	
	
	public String Name;

	public void waitForElement(int time) throws InterruptedException {
		Thread.sleep(time);
	}

	public void Launch_Landing_page() throws InterruptedException {

		By MarketingTile = By.xpath("//a[@class='glyphicon fa fa-fw fa-bar-chart-o']");
		waitForElement(2000); // For UAT
		element = wait.until(ExpectedConditions.presenceOfElementLocated(MarketingTile));
		js.executeScript("arguments[0].click();", element);
		ExtentSuccessMessage("Marketing Tile has been clicked");

		By Landing_Page = By.xpath("(//a[@href='#/marketing/landingPage'])[1]");
		waitForElement(3000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Landing_Page));
		js.executeScript("arguments[0].click();", element);
		ExtentSuccessMessage("Clicked on landing page");

	}

	public void Landing_Page_Grid() {
		By Page_Tittle = By.xpath("//span[normalize-space()='Landing Pages']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Page_Tittle));
		ExtentSuccessMessage("Landing page tittle validated");

		By Search = By.xpath("//input[@type='search']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Search));
		ExtentSuccessMessage("Landing page Search validated");

		By New_Landing_Page = By.xpath("//button[@id='NewLandingPageBtn']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(New_Landing_Page));
		ExtentSuccessMessage("New Landing page button is validated");

		By Edit = By.xpath("(//i[@title='Edit Landing Page'])[1]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Edit));
		ExtentSuccessMessage("edit Landing page button is validated");

		By Publish = By.xpath("(//i[@title='Unpublish Landing Page'])[1]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Publish));
		ExtentSuccessMessage("Publish Landing page button is validated");

		By Delete = By.xpath("(//i[@title='Delete Landing Page'])[1]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Delete));
		ExtentSuccessMessage("Delete Landing page button is validated");

		By Landingpage_Url = By.xpath("(//i[@class='fa fa-link'])[1]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Landingpage_Url));
		ExtentSuccessMessage(" Landing page url button is validated");

		By LandingPage_Name = By.xpath("//a[@class='edit-list-anchor ng-binding']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(LandingPage_Name));
		ExtentSuccessMessage(" Landing page tittle  is validated");

	}

	public void New_landing_Page() throws InterruptedException {
		By New_Landing_Page = By.xpath("//button[@id='NewLandingPageBtn']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(New_Landing_Page));
		MoveToElementClick(element);
		ExtentSuccessMessage("New Landing page button is clicked");

		By Page_Header = By.xpath("//h1[@class='page-header']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Page_Header));

		String Tittle = element.getText();
		System.out.println(Tittle);
		// Assert.assertEquals(Tittle, "New Landing Page");
		Assert.assertTrue(Tittle.contains("New Landing Page"));
		ExtentSuccessMessage(" New Landing page tittle  is validated");
	}

	public static int generateThreeDigitNumber() {
		Random rand = new Random();
		// Generates a random number between 100 and 999 (inclusive)
		return rand.nextInt(900) + 100;
	}

	public void New_Landing_Page_Validations() throws InterruptedException {
		By Landing_PageName = By.xpath("//md-input-container[@class='md-block md-input-has-value']");
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(Landing_PageName));
		ExtentSuccessMessage("New Landing page name  is validated");

		By Sampledesigns = By.xpath("//li[contains(text(),'Use Sample')]");
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(Sampledesigns));
		ExtentSuccessMessage("New Landing page, sample designs are validated");

		By Existingdesigns = By.xpath("//li[contains(text(),'Use Existing')]");
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(Existingdesigns));
		ExtentSuccessMessage("New Landing page, existing designs are validated");

		By Search = By.xpath("//input[@placeholder='Search Landing Page']");
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(Search));
		ExtentSuccessMessage("New Landing page, search option validated");

		By Number_Of_Templates = By.xpath("//div[@class='alert alert-info pull-left small ng-binding']");
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(Number_Of_Templates));
		String Design = element.getText();
		Assert.assertTrue(Design.contains("Showing"));
		ExtentSuccessMessage("New Landing page,Available templates number is validated");

		By Cancel = By.xpath("//input[@value='Cancel']");
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(Cancel));
		ExtentSuccessMessage("New Landing page, cancel option validated");

		By Next = By.xpath("//input[@value='Next']");
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(Next));
		ExtentSuccessMessage("New Landing page, Next option validated");

		By Click_Template = By.xpath("(//span[contains(text(),'Green Webinar')])[1]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Click_Template));

		By Click_Select = By.xpath(
				"/html[1]/body[1]/div[3]/div[6]/div[1]/ui-view[1]/div[4]/div[1]/div[1]/div[2]/div[2]/div[3]/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]/a[1]/div[1]/input[1]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Click_Select));
		MoveToElementClick(element);
		ExtentSuccessMessage("New Landing page, Clicked on a template");

		Thread.sleep(5000);
		By Previous = By.xpath("(//input[contains(@value,'Previous')])[1]");
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(Previous));
		ExtentSuccessMessage("New Landing page, previous option validated");
		Name = "MyText" + generateThreeDigitNumber();
		Edit_Lading_Page_Name(Name);

		Click_Next();
		Thread.sleep(3000);
		// Click_Next();
		Thread.sleep(3000);

		By Click_Next = By.xpath("(//button[@class='btn btn-default green pull-right'][normalize-space()='Next'])[1]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Click_Next));
		MoveToElementClick(element);

		By Click_On_Next = By.xpath("//button[@id='navigateToSummaryBtn']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Click_On_Next));
		MoveToElementClick(element);

		Thread.sleep(2000);

		Click_Publish();

		By Publish_validation = By.xpath("(//h3[normalize-space()='Publish'])[1]");
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(Publish_validation));

		By Click_On_Publish = By.xpath("(//button[@class='btn btn-primary btn-default green ng-binding'])[1]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Click_On_Publish));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on publish dailog ");
		Thread.sleep(4000);

		New_landing_Page();

		By Click_Select1 = By.xpath(
				"/html[1]/body[1]/div[3]/div[6]/div[1]/ui-view[1]/div[4]/div[1]/div[1]/div[2]/div[2]/div[3]/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]/a[1]/div[1]/input[1]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Click_Select1));
		MoveToElementClick(element);
		ExtentSuccessMessage("New Landing page, Clicked on a template");
		Thread.sleep(1000);

		driver.navigate().refresh();
		Edit_Lading_Page_Name(Name);

		Click_Next();
		Thread.sleep(4000);
		By Error = By.id("divError");
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(Error));

	}

	public void Edit_Lading_Page_Name(String name) throws InterruptedException {

		Thread.sleep(8000);
		By GetName = By.xpath(
				"//input[@class='ng-pristine ng-untouched ng-valid md-input ng-not-empty ng-valid-required ng-valid-pattern ng-valid-maxlength']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(GetName));
		js.executeScript("arguments[0].click();", element);

		element.clear();

		By Write = By.xpath("//input[@name='LandingPageName']");
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(Write));

		MoveToElementClick(element);

		writeText(Write, name + Keys.ENTER);
		System.out.println("Landingpagename:" + Name);
		ExtentSuccessMessage("New Landing page, Custom landing page name is validated");
	}

	public void Click_Next() throws InterruptedException {
		By Next_Button = By.xpath("//input[@value='Next']");
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(Next_Button));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on next button");

	}

	public void Click_Publish() throws InterruptedException {
		By Publish = By.xpath("(//button[normalize-space()='Publish'])[1]");
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(Publish));
		MoveToElementClick(element);
	}

	public void Validate_Sample_templates() throws InterruptedException {
		New_landing_Page();
		By Click_Blank_Template = By.xpath("(//span[contains(text(),'Blank')])[1]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Click_Blank_Template));
		MoveToElementClick(element);

		By Click_Select = By.xpath(
				"//div[contains(@class,'col-xl-12 pad-lt pad-rt ng-scope')]//div[4]//div[1]//a[1]//div[1]//input[1]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Click_Select));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected the blank template");
		Thread.sleep(2000);
		By Iframe_content = By.xpath("//iframe[@class='gjs-frame']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Iframe_content));
		Thread.sleep(1000);
		driver.switchTo().frame(element);
		String name = "Testpage" + generateThreeDigitNumber();
		// driver.navigate().refresh();
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		Edit_Lading_Page_Name(name);

		Click_Next();
		Thread.sleep(2000);
		// Click_Next();
		Thread.sleep(2000);

		By Click_Next = By.xpath("(//button[@class='btn btn-default green pull-right'][normalize-space()='Next'])[1]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Click_Next));
		MoveToElementClick(element);

		By Click_On_Next = By.xpath("//button[@id='navigateToSummaryBtn']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Click_On_Next));
		MoveToElementClick(element);

		Thread.sleep(2000);

		Click_Publish();

		By Publish_validation = By.xpath("(//h3[normalize-space()='Publish'])[1]");
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(Publish_validation));

		By Click_On_Publish = By.xpath("(//button[@class='btn btn-primary btn-default green ng-binding'])[1]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Click_On_Publish));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on publish dailog ");
		Thread.sleep(4000);

		By Tittle = By.xpath("//a[normalize-space()='" + name + "']");
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(Tittle));
		ExtentSuccessMessage("Created landing page is validated on homepage");

	}

	public void Thumbnail_Validation() throws InterruptedException {

		By tot = By.xpath("(//div[@class='alert alert-info pull-left small ng-binding'])[1]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(tot));
		Thread.sleep(14000);
		String Number = element.getText();
		System.out.println(Number);

		int i = extractNumber(Number);
		System.out.println(i);
		for (int j = 1; j <= i; j++) {

			By Thub = By.xpath(
					"//*[@id=\"page-wrapper\"]/div/ui-view/div[4]/div/div/div[2]/div[2]/div[3]/div/div/div[2]/div[2]/div["
							+ j + "]/div/a/img");
			element = wait.until(ExpectedConditions.presenceOfElementLocated(Thub));
			System.out.println("Total iterations" + j);
			ExtentSuccessMessage("Validated " + j + " thumbnail");

		}
	}

	public static int extractNumber(String Str) {
		// Regular expression to find digits in the string
		String number = Str.replaceAll("[^0-9]", "");
		return Integer.parseInt(number); // Convert the string to an integer
	}

	public void Select_Preview_Validations() throws InterruptedException {
		By Click_Select = By.xpath(
				"//div[contains(@class,'col-xl-12 pad-lt pad-rt ng-scope')]//div[4]//div[1]//a[1]//div[1]//input[1]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Click_Select));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on select");

		By Frame_Element = By.xpath("//iframe[@class='gjs-frame']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Frame_Element));
		driver.switchTo().frame(element);

		By Designing_Page = By.xpath("(//div[@class='row'])[1]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Designing_Page));
		ExtentSuccessMessage("Select page is validated");

		driver.switchTo().defaultContent();

		By previous = By.xpath("//input[@value='Previous']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(previous));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on previous button");

		By Preview = By.xpath(
				"//div[1]//div[2]//div[2]//div[3]//div[1]//div[1]//div[2]//div[2]//div[1]//div[1]//a[1]//div[1]//input[2]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Preview));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on prevew button");

		By Preview_Page = By.xpath("//h3[@class='modal-title ng-binding']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Preview_Page));

		String Tittle = element.getText();
		Assert.assertTrue(Tittle.contains("Landing Page Preview"));
		ExtentSuccessMessage("Validated preview page");

	}

	public void Action_Tab_Validation() throws InterruptedException {
		By Click_Select = By.xpath(
				"//div[contains(@class,'col-xl-12 pad-lt pad-rt ng-scope')]//div[4]//div[1]//a[1]//div[1]//input[1]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Click_Select));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on select");

		Click_Next();
		Thread.sleep(2000);
		By Thankyou_Text_Box = By.xpath("//textarea[@ng-model='msg1']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Thankyou_Text_Box));
		ExtentSuccessMessage("Thankyou text box is validated");

		Thread.sleep(8000);

		By Redirect_To_Url = By.xpath("//md-radio-button[@aria-label='Redirect to a URL']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Redirect_To_Url));
		ExtentSuccessMessage("Redirect to url is validated");

		By Previous_Button = By.xpath("//button[normalize-space()='Previous']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Previous_Button));
		ExtentSuccessMessage("Previous button is validated");

		By Next_Button = By.xpath("//button[@class='btn btn-default green pull-right'][normalize-space()='Next']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Next_Button));
		ExtentSuccessMessage("Next button is validated");

		By Cancel_Button = By.xpath("//button[contains(@class,'btn btn-default grey pull-right')]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Cancel_Button));
		ExtentSuccessMessage("Cancel button is validated");

	}

	public void Action_Text_Validation() throws InterruptedException {

		By Thankyou_Text_Box = By.xpath("//textarea[@ng-model='msg1']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Thankyou_Text_Box));
		ExtentSuccessMessage("Thankyou text box is validated");
		Thread.sleep(2000);
		element.click();
		element.clear();
		Thread.sleep(2000);
		Characters_Limit_Validation("//textarea[@ng-model='msg1']");

		By Error_Text_Box = By.xpath("//textarea[@ng-model='msg2']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Error_Text_Box));
		ExtentSuccessMessage("Error text box is validated");
		Thread.sleep(2000);
		element.click();
		element.clear();
		Thread.sleep(2000);
		Characters_Limit_Validation("//textarea[@ng-model='msg2']");
		Thread.sleep(2000);
		element.click();
		element.clear();
		By Next_Click = By.xpath("//button[normalize-space()='Next']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Next_Click));
		MoveToElementClick(element);
		ExtentSuccessMessage("Next button is clicked on action page");

		By Error = By.id("divError");
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(Error));
		ExtentSuccessMessage("Clicking next with blank message is validated");

	}

	public void Characters_Limit_Validation(String string) {
		WebElement textBox = driver.findElement(By.xpath(string));//// textarea[@ng-model='msg1']

		String inputText = "A".repeat(310);
		textBox.sendKeys(inputText);

		String enteredText = textBox.getAttribute("value");
		int length = enteredText.length();

		// Check if the entered text exceeds 300 characters
		if (length <= 300) {
			System.out.println("Validation passed: Text length is " + length + " characters.");
			ExtentSuccessMessage("300 character limit of submission message is  validated");

		} else {
			System.out.println("Validation failed: Text length is " + length + " characters.");
		}

	}

	public void Action_buttons() throws InterruptedException {
		By Previous_Button = By.xpath("//button[normalize-space()='Previous']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Previous_Button));
		MoveToElementClick(element);

		By Landing_Page_Header = By.xpath("//h5[@style='margin-bottom: 0;padding-bottom: 0;']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Landing_Page_Header));
		String Get_Header_Text = element.getText();
		Assert.assertTrue(Get_Header_Text.contains("Landing Page Details"));
		ExtentSuccessMessage("Previous button is validated");
		Click_Next();

		By Next_Button = By.xpath("//button[@class='btn btn-default green pull-right'][normalize-space()='Next']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Next_Button));
		MoveToElementClick(element);
		By PageSettings = By.xpath("//h5[normalize-space()='Landing Page URL']");
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(PageSettings));
		ExtentSuccessMessage("Next button is validated");

		By Clickprevious = By.xpath("//button[@id='previousPageBtn']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Clickprevious));
		MoveToElementClick(element);

		By Cancel_Button = By.xpath("//button[contains(@class,'btn btn-default grey pull-right')]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Cancel_Button));
		MoveToElementClick(element);
		By click_Ok = By.xpath("//button[@class='btn btn-primary btn-default green ng-binding']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(click_Ok));
		MoveToElementClick(element);

		By Grid_Page = By.xpath("(//span[normalize-space()='Landing Pages'])[1]");
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(Grid_Page));
		ExtentSuccessMessage("Cancel button is validated");
	}

	public void Summary_Page() throws InterruptedException {

		By Click_Blank_Template = By.xpath("(//span[contains(text(),'Blank')])[1]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Click_Blank_Template));
		MoveToElementClick(element);

		By Click_Select = By.xpath(
				"//div[contains(@class,'col-xl-12 pad-lt pad-rt ng-scope')]//div[4]//div[1]//a[1]//div[1]//input[1]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Click_Select));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected the blank template");

		By Iframe_content = By.xpath("//iframe[@class='gjs-frame']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Iframe_content));

		driver.switchTo().frame(element);
		String name = "Testpage" + generateThreeDigitNumber();
		// driver.navigate().refresh();
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		Edit_Lading_Page_Name(name);

		Click_Next();

		By Thankyou_Text_Box = By.xpath("//textarea[@ng-model='msg1']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Thankyou_Text_Box));
		ExtentSuccessMessage("Thankyou text box is validated");
		Thread.sleep(2000);
		MoveToElementClick(element);
		//element.click();
		element.clear();

		String Message1 = "Test" + generateThreeDigitNumber();
		writeText(Thankyou_Text_Box, Message1);

		By Error_Text_Box = By.xpath("//textarea[@ng-model='msg2']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Error_Text_Box));
		ExtentSuccessMessage("Error text box is validated");
		MoveToElementClick(element);
		//element.click();
		element.clear();
		String Message2 = "Test" + generateThreeDigitNumber();
		writeText(Error_Text_Box, Message2);

		Thread.sleep(2000);
		// Click_Next();
		Thread.sleep(2000);

		By Click_Next = By.xpath("(//button[@class='btn btn-default green pull-right'][normalize-space()='Next'])[1]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Click_Next));
		MoveToElementClick(element);

		By Click_On_Next = By.xpath("//button[@id='navigateToSummaryBtn']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Click_On_Next));
		MoveToElementClick(element);

		// Validations

		By Summary_Landing_Page = By.xpath("//span[normalize-space()='" + name + "']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Summary_Landing_Page));
		ExtentSuccessMessage("Summary landing page detail is validated");

		By Summary_Thanks_Message = By
				.xpath("//span[contains(@class,'ng-binding ng-isolate-scope')][normalize-space()='" + Message1 + "']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Summary_Thanks_Message));
		ExtentSuccessMessage("Summary Action detail 1 is validated");
		Thread.sleep(2000);

		By Summary_Error_Message = By
				.xpath("//span[contains(@class,'ng-binding ng-isolate-scope')][normalize-space()='" + Message2 + "']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Summary_Error_Message));
		ExtentSuccessMessage("Summary Action detail 2 is validated");
		Thread.sleep(2000);

		By Send_Button = By.xpath(
				"//button[contains(@class,'md-primary btn btn-default green pull-right md-button md-ink-ripple')]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Send_Button));
		ExtentSuccessMessage("Summary review send button is validated");

		WebElement iframeElement = driver.findElement(By.xpath("//iframe[@id='summaryFrame']"));
		Assert.assertTrue(iframeElement.isDisplayed(), "Iframe is not present");
		ExtentSuccessMessage("Summary preview section is validated");

		By Publish_validation = By.xpath("//button[normalize-space()='Publish']");
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(Publish_validation));
		ExtentSuccessMessage("Publish button is present and  validated");

		By Cancel_Validation = By.xpath("//button[normalize-space()='Cancel']");
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(Cancel_Validation));
		ExtentSuccessMessage("Cancel button is present and  validated");

		By previous_Validation = By.xpath("//button[normalize-space()='Previous']");
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(previous_Validation));
		ExtentSuccessMessage("Previous button is present and  validated");

	}

	public void Landing_Grid_Lead_Validation() throws InterruptedException {
		By Click_Select = By.xpath(
				"/html[1]/body[1]/div[3]/div[6]/div[1]/ui-view[1]/div[4]/div[1]/div[1]/div[2]/div[2]/div[3]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/a[1]/div[1]/input[1]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Click_Select));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected the blank template");

		By Iframe_content = By.xpath("//iframe[@class='gjs-frame']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Iframe_content));

		driver.switchTo().frame(element);
		String name = "Testpage" + generateThreeDigitNumber();
		System.out.println(name);
		// driver.navigate().refresh();
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		Edit_Lading_Page_Name(name);

		Click_Next();
		Thread.sleep(2000);
		// Click_Next();
		Thread.sleep(2000);

		By Click_Next = By.xpath("(//button[@class='btn btn-default green pull-right'][normalize-space()='Next'])[1]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Click_Next));
		MoveToElementClick(element);

		By Click_On_Next = By.xpath("//button[@id='navigateToSummaryBtn']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Click_On_Next));
		MoveToElementClick(element);

		Thread.sleep(2000);

		Click_Publish();

		By Publish_validation = By.xpath("(//h3[normalize-space()='Publish'])[1]");
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(Publish_validation));

		By Click_On_Publish = By.xpath("(//button[@class='btn btn-primary btn-default green ng-binding'])[1]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Click_On_Publish));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on publish dailog ");
		Thread.sleep(4000);

		By URL = By.xpath("(//i[contains(@class,'fa fa-link')])[1]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(URL));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on grid page url");
		TabSwitchToChild();
		String pageTitle = driver.getTitle();
		System.out.println(pageTitle);
		Assert.assertTrue(pageTitle.contains(name));

		By Form_Name = By.xpath("//input[@placeholder='First Name']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Form_Name));
		MoveToElementClick(element);
		String Name = "TestUser" + generateThreeDigitNumber();
		writeText(Form_Name, Name);
		ExtentSuccessMessage("Entered Name in the landing page Form");

		By Form_Email = By.xpath("//input[@placeholder='Email']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Form_Email));
		MoveToElementClick(element);
		String Email = "TestUser" + generateThreeDigitNumber() + "@yopmail.com";
		writeText(Form_Email, Email);
		ExtentSuccessMessage("Entered Email in the landing page Form");

		By Form_Number = By.xpath("//input[@placeholder='Mobile']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Form_Number));
		MoveToElementClick(element);
		String Number = generatePhoneNumber();
		writeText(Form_Number, Number);
		ExtentSuccessMessage("Entered phone number in the landing page Form");

		By Send_Button = By.xpath("//button[normalize-space()='Send']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Send_Button));
		MoveToElementClick(element);
		Thread.sleep(3000);
		By Success_Prompt = By.xpath("//div[@class='popup-header']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Success_Prompt));
		ExtentSuccessMessage("Submit promopt is validated under the landing page Form");

		By Succes_Message = By.xpath("//div[@class='popup-body']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Succes_Message));
		ExtentSuccessMessage("Submit promoptis valiudated in the landing page Form");
		//String Body = element.getText();
		Thread.sleep(4000);
		//Assert.assertTrue(Body.contains("Thank you"));

		ExtentSuccessMessage("Submitted succesfully");

		By Click_Ok = By.xpath("//button[normalize-space()='OK']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Click_Ok));
		MoveToElementClick(element);
		ExtentSuccessMessage("Submitted an entry in landing page form");

		TabSwitchToParent();

		By Tittle = By.xpath("(//a[normalize-space()='" + name + "'])[1]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Tittle));

		String LandingName = element.getText();

		Assert.assertTrue(LandingName.contains(name));

		Home_Redirection();
		Leads_redirection();

		By Lead_Name = By.xpath("//a[normalize-space()='" + Name + "']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Lead_Name));
		// MoveToElementClick(element);
		ExtentSuccessMessage("Lead created from the landing page is validated");
		By search = By.xpath("//input[@type='search'][@aria-label='Search your text']");
		Home_Redirection();
		Launch_Landing_page();

		waitVisibility(search);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(search));
		writeText(search, name + Keys.ENTER);
		ExtentSuccessMessage("Clicked on Search");
		waitForElement(5000);

		By delete = By.xpath("(//i[@title='Delete Landing Page'])[1]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(delete));
		MoveToElementClick(element);

		By Delete_Popup = By.xpath("//h3[normalize-space()='Delete Landing Page']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Delete_Popup));

		By Yes = By.xpath("//button[normalize-space()='Yes']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Yes));
		MoveToElementClick(element);

		ExtentSuccessMessage("deleted landing page");

	}

	public void Leads_redirection() throws InterruptedException {

		By SalesButton = By.xpath("//span[text()='Sales ']");
		By Leads = By.xpath("(//a[text()='Leads'])[2]");
		waitForElement(22000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesButton));
		MoveToElementClick(element);
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Leads));
		MoveToElementClick(element);
		ExtentSuccessMessage("Sales Lead has been clicked");
	}

	public void Home_Redirection() throws InterruptedException {
		By Home_Icon = By.xpath("//a[@id='menu_home']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Home_Icon));
		MoveToElementClick(element);
		ExtentSuccessMessage("Redirected to Homepage");

	}

	public void TabSwitchToChild() throws InterruptedException {
		ArrayList<String> Tabs = new ArrayList<>(driver.getWindowHandles());
		System.out.println(Tabs.size());
		driver.switchTo().window(Tabs.get(1));
		Thread.sleep(3000);
		ExtentSuccessMessage("Tab Switched from parent to child");
		Thread.sleep(2000);

	}

	public void TabSwitchToParent() throws InterruptedException {
		Thread.sleep(2000);
		ArrayList<String> Tabs = new ArrayList<>(driver.getWindowHandles());
		System.out.println(Tabs.size());
		driver.switchTo().window(Tabs.get(0));
		ExtentSuccessMessage("Tab Switched from child to parent");

		Thread.sleep(5000);
	}

	public static String generatePhoneNumber() {
		Random random = new Random();

		// First digit should not be 0 or 1 for a typical phone number
		int firstDigit = random.nextInt(8) + 2; // Generates a number between 2 and 9

		// The remaining 9 digits can be anything between 0 and 9
		long remainingDigits = random.nextLong(900000000L) + 100000000L; // Generates a number between 100000000 and
																			// 999999999

		// Combine first digit and remaining digits
		return firstDigit + String.valueOf(remainingDigits);
	}

}
