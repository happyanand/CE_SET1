package com.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import Utility.ExcelHelper;

public class Customer_Validations extends BasePage {
	
	public Customer_Validations(WebDriver driver) {
		super(driver);
		}
	
	public String AgentText;
	public String NoteText;
	public String FirstName;
	public String LastName;
	public String Customername;
 
	JavascriptExecutor js = (JavascriptExecutor) driver;
	JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
	WebElement element;
		ExcelHelper _excelObj = new ExcelHelper();
		XSSFSheet tcTestData = _excelObj.readExcelSheet("TestData", "URLs");
		 
		
		
		    By Customers = By.xpath("(//a[@class='glyphicon fa fa-users'])[1]");
		    By AgencyAgent= By.xpath("(//a[contains(.,'Agents')])[1]");
		    By Agencydrop_down = By.xpath("//a[@id='menu_Agency']");
		    By NewAgentButton=By.id("createNewAgentBtn");
	        By NewCustomer = By.xpath("//button[@id='newCustomerBtn']");
	        By CustFName = By.xpath("(//input[@id='LeadFirstName'])[1]");
	        By CustLName = By.xpath("(//input[@id='LeadLastName'])[1]");
	        By AgentPrefix= By.xpath("//md-select[@name='Prefix']");
	    	By AgentPrefixOption = By.xpath("//div[text()='Mr.']");
	    	By NewAgentFirstName = By.name("FirstName");
	    	By NewAgentLastName = By.name("LastName");
	    	By SelectCustmer = By.xpath("//input[@ng-model='data.selectedCustomer']");
			By CustomerOk = By.xpath("//button[text()='OK']");
			By ProductCategory = By.xpath("(//md-select[@id='CRMProductCategory'])[1]");
			By AccidentLOB = By.xpath("(//md-option[@value='Medical'])[2]"); 
			By Carrier = By.xpath("//md-select[@id='Carrier']");
			By SelectCarrier = By.xpath("(//md-option[@value='Aetna'])[2]");
			By SalesType = By.xpath("//md-select[@id='salesType']");
			By SalesNew = By.xpath("(//md-option[@value='New'])[2]");
			By PolicyStatus = By.xpath("//md-select[@id='AssetStatus']");
			By PolicyActive = By.xpath("(//div[@class='md-text'][normalize-space()='Active'])[3]");
			By PolicyEFDate = By.xpath("//input[@id='EffectiveDate']");
			By PolicyAOR = By.xpath("(//button[@class='btn btn-default green']/child::i)[3]");
			By AoRSearchText = By.xpath("//input[@ng-model='searchText']");
			By AORSearchIcon = By.xpath("//button[@title='Search Agent Name']");
			By SelectAOR = By.xpath("//input[@name='selectedAgent']");
			By AorOk = By.xpath("//button[text()='OK']");
			By PolicySubmit = By.xpath("//button[@ng-show=\"accountType !=='Group'\"]");
			 By EmailSubject = By.xpath("//input[@class='form-control ng-pristine ng-untouched ng-isolate-scope ng-empty ng-invalid ng-invalid-required']");
			 By EmailConfirmationButton = By.xpath("(//button[@class='btn btn-default icons text-center ng-isolate-scope'])[2]");
			 By ActionAttachment = By.xpath("//a[@role='tab']//i[@class='fa fa-paperclip']");
			By NotesSection = By.xpath("//textarea[@class='form-control ng-pristine ng-untouched ng-isolate-scope ng-empty ng-invalid ng-invalid-required ng-valid-maxlength']");
			By NotesConfirmationButton = By.xpath("(//button[@class='btn btn-default icons text-center ng-isolate-scope'])[2]");
			By ActionEmailIcon = By.xpath("(//i[@class='fa fa-envelope'])[2]");
			By AddEmailAddressCheckBox = By.xpath("//md-chips[@placeholder='Add email address']");
			 By AgentActionNoteInc = By.xpath("//u[@class='item_to_highlight ng-binding']");
			By AgentEmailInc = By.xpath("(//u[@class='ng-binding'])[1]");
			By DocumentAttachFileButton = By.xpath("//div[@class='btn btn-primary ng-pristine ng-untouched ng-valid ng-isolate-scope ng-empty']");
			 By AttachmentConfirmationButton = By.xpath("(//button[@class='btn btn-default icons text-center ng-isolate-scope'])[2]");
			 By ActionTask = By.xpath("(//i[contains(@class,'fa fa-calendar')])[1]");
			 By ActivityDD = By.xpath("(//select[@class='form-control ng-pristine ng-untouched ng-valid ng-not-empty'])[1]");
			 By PriorityDD = By.xpath("//*[@id=\"filter-by\"]/div[1]/form/div[5]/select");
			 By CommentTextArea = By.xpath("//textarea[@class='form-control comments ng-pristine ng-untouched ng-valid ng-empty ng-valid-maxlength']");
			 By TaskConfirmationButton = By.xpath("//i[@class='fa fa-check yellow green']");
			 By AttachmentInc = By.xpath("(//u[@class='ng-binding'])[1]");
			 By RecentAgentIcon = By.xpath("(//i[@class='acc glyphicon glyphicon-plus'])[1]");
			 By CreatedTodayButton = By.xpath("//md-radio-button[@value='Created Today']");
			 By Options = By.xpath("(//i[@aria-label='Grid Menu'])[2]");
	    	
	    //    By ContactInfo = By.xpath("(//div[@class='accordion-container'])[2]");
	        By ContactInfo = By.xpath("//*[@id=\"page-wrapper\"]/div/ui-view/div[8]/ng-include/div[3]/div/div[2]/div/div[1]/div[5]/i");
	        By Cellphone = By.xpath("(//input[@name='CellPhone'])[1]");
	        By CustMail = By.xpath("(//input[@name='Email'])[1]");
	        By ClickLead = By.xpath("//a[@class='edit-list-anchor ng-binding']");
	        By SalesButton  = By.xpath("//a[@id='menu_Sales']");
	        By SalesQuote = By.xpath("(//a[text()='Quotes'])[2]");
	        By OpportunityQuote = By.xpath("(//button[@class='btn btn-default pull-right ng-binding ng-scope'])[2]");
			By OpportunityEffectiveDate = By.xpath("//input[@name='EffectiveDate']");
			By OptZipCode = By.xpath("//input[@name='Zip']");
			By OPtStatus = By.xpath("//md-select[@name='CRMNewQuoteStatus']");
			By OptSubStaus = By.xpath("//md-option[@value='Created']");
			By Optsubmit = By.xpath("(//button[@class='btn btn-default green'])[3]"); 
			By Optqualify = By.xpath("(//button[@class='btn btn-default pull-right ng-binding ng-scope'])[3]");
			By Optsubmit2 = By.xpath("//button[text()='Submit']");
			By CloseDeal = By.xpath("(//button[@class='btn btn-default pull-right ng-binding ng-scope'])[1]");
			By CloseDealStatus = By.xpath("//md-select[@name='CloseDealStatus']");
			By CloseOption = By.xpath("//md-option[@value='Close as Won']");
			By Policies = By.xpath("//a[@role='tab'][normalize-space()='Policies']");
			By Success_msg = By.xpath("//div[@id='divSuccesss']");
			By TaskInc = By.xpath("(//u[@class='ng-binding'])[1]");
	       
	        By PrincipalAdress = By.xpath("//*[@id=\"page-wrapper\"]/div/ui-view/div[8]/ng-include/div[3]/div/div[2]/div/div[1]/div[8]/i");
	        By PricipalAD1 = By.xpath("//input[@id='AddressLine1']");
	        By PrincipalZipCode = By.xpath("//input[@name='ZipCode']");
	        By MailingAddress = By.xpath("(//input[@type='checkbox'])[2]");
	        By CustSubmit = By.xpath("(//button[text()='Submit'])[3]");
	        By CustcreateOpp = By.xpath("(//button[@class='btn btn-default pull-right ng-binding ng-scope'])[2]");
	        By CustOppSubmit = By.xpath("(//button[@class='btn btn-default green'])[3]");
		    By SalesOpportunities =By.xpath("//a[@id='submenu_salesopportunities']");
		    By Customerdropdown = By.xpath("//a[@id='menu_customers']");
		    By InstallPolicy = By.xpath("(//button[@ng-repeat='normal in normalActions | reverse'])[1]");
		    By AorSearch = By.xpath("//button[@class='btn btn-default green']");
			By AorText = By.xpath("//input[@ng-model='searchText']");
			By SearchIcon = By.xpath("//button[@title='Search Agent Name']");
			By AorRadioButton = By.xpath("//input[@name='selectedAgent']");
			By Okbutton = By.xpath("//button[text()='OK']");
			By SubmitQuote = By.xpath("//button[text()='Submit']");
		
		
		public void waitForElement(int time) throws InterruptedException {
			Thread.sleep(time);
		}
		
		public String employerName() {
			String allowedChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
			String ssn = "";
			String temp = RandomStringUtils.random(10, allowedChars);
			ssn = temp.substring(0, temp.length() - 5);
			return ssn;
		}
       
		public int getRandomNumber()
		{
			Random r = new Random();
			int ran = r.nextInt(1000);
			return ran;
		}
		public String randomName() {
			String allowedChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
			String ssn = "";
			String temp = RandomStringUtils.random(10, allowedChars);
			ssn = temp.substring(0, temp.length() - 5);
			return ssn;
		}
		
		public String writenameToExcel(String nameText, String sheetname) throws IOException {
			String excelFilePath = ".\\src\\test\\resources\\TestData.xlsx";
	        FileInputStream inputStream = new FileInputStream(excelFilePath);
	        Workbook workbook = new XSSFWorkbook(inputStream);
	        String sheetName_update = sheetname;
	        Sheet sheet = workbook.getSheet(sheetname);
	        int rowIndex = 1;  
	        int columnIndex = 6;
	        Row row = sheet.getRow(rowIndex);
	        Cell cell = row.createCell(columnIndex);
	        cell.setCellValue(nameText);  
	        inputStream.close();
			FileOutputStream outputStream = new FileOutputStream(excelFilePath);
	        workbook.write(outputStream);
	        workbook.close();
	        outputStream.close();
			return null;		
		}
		
		public void New_Customer_Creation() throws InterruptedException
		{
			waitForElement(13000);
			element = wait.until(ExpectedConditions.presenceOfElementLocated(Customers));
			//MoveToElementClick(element);
			//js.executeAsyncScript(AgentText, null)
			 js.executeScript("arguments[0].click();", element);
			 ExtentSuccessMessage("Clicked on Customers");
			 waitForElement(8000);
			 element = wait.until(ExpectedConditions.presenceOfElementLocated(NewCustomer));
			MoveToElementClick(element);
			 ExtentSuccessMessage("Clicked on New Customers");
			 Thread.sleep(4000);
			 FirstName = "Rohith";
			 writeText(CustFName,FirstName);
			 //waitForElement(4000);
			 LastName=randomName();
			 Customername=FirstName+" "+LastName;
			 System.out.println("Customers name: "+Customername);
			 writeText(CustLName,LastName);	
			 
//			 waitForElement(3000);
//			 By dob = By.xpath("(//input[@id='LeadDob'])[1]");
//			
//			 writeText(dob,"12/12/2001" +Keys.ENTER);
			 
			 waitForElement(2000);

	      element = wait.until(ExpectedConditions.presenceOfElementLocated(ContactInfo));
	      MoveToElementClick(element);

			
			 ExtentSuccessMessage("Clicked on Contact Information");
			 waitForElement(2000);
			 writeText(Cellphone,generatePhoneNumber());
			 waitForElement(2000);
			 writeText(CustMail,"lohi.11@yopmail.com");
			 waitForElement(6000);
			 element = wait.until(ExpectedConditions.presenceOfElementLocated(PrincipalAdress));
				MoveToElementClick(element);
				waitForElement(2000);
				 ExtentSuccessMessage("Clicked on PrincipalAddress");
				 writeText(PricipalAD1,"Testing");
				ExtentSuccessMessage("Entered the Address"); 
				// waitForElement(6000);
				 writeText(PrincipalZipCode,"33233");
				 //waitForElement(6000);
				 ExtentSuccessMessage("Entered the ZipCode");  
			 element = wait.until(ExpectedConditions.presenceOfElementLocated(MailingAddress));
					MoveToElementClick(element);
					waitForElement(2000);	 
					 element = wait.until(ExpectedConditions.presenceOfElementLocated(CustSubmit));
					MoveToElementClick(element);
					//waitForElement(1000);
			ExtentSuccessMessage("Clicked on Submit");	
			
			waitForElement(4000);
			By prompt = By.xpath("(//h5[normalize-space()='Similar records found!'])[1]");
			 element = wait.until(ExpectedConditions.presenceOfElementLocated(prompt));
			
			WebElement element = driver.findElement(By.xpath("//button[contains(text(),'Proceed with Customer creation')]"));
			
	        // Check if the element is displayed
	        if(element.isDisplayed()) {
	            // Click on the element
	element.click();
	        } else {
	            System.out.println("Element is not displayed, so cannot click.");
	        }
		 
		

			
		}
		
		public void searchcustomer() throws InterruptedException
		{
			By search = By.xpath("//input[@type='search']");
			element = wait.until(ExpectedConditions.presenceOfElementLocated(search));
			MoveToElementClick(element);
			
			

			// Check if the element has any text before clearing
			if (element.getAttribute("value") != null && !element.getAttribute("value").isEmpty()) {
			    element.clear();
			}
			 
			
			writeText(search,Customername + Keys.ENTER);
			ExtentSuccessMessage("Search for the created customer");
			 
			 
			 
			 
			
		}
		public void New_Opportunity_Creation() throws InterruptedException
		{
			 Thread.sleep(8000);
			 searchcustomer();
			 element = wait.until(ExpectedConditions.presenceOfElementLocated(ClickLead));
				MoveToElementClick(element);
				ExtentSuccessMessage("Customer has been clicked");
				waitForElement(8000);
				 element = wait.until(ExpectedConditions.presenceOfElementLocated(CustcreateOpp));
				MoveToElementClick(element);
				ExtentSuccessMessage("Clicked on create opportunity");
				waitForElement(6000);
				 element = wait.until(ExpectedConditions.presenceOfElementLocated(CustOppSubmit));
				MoveToElementClick(element);
				ExtentSuccessMessage("Clicked on submit");
				waitForElement(2000);
				element = wait.until(ExpectedConditions.presenceOfElementLocated(Success_msg));
				ExtentSuccessMessage("New opportunity has been created and validated the success message");
		}
		
		
		public void Customer_Quote_validation() throws InterruptedException
		{
			New_Customer_Creation();
			New_Opportunity_Creation();
					//quote creation
			createOpportunityQuote();
			
			
	   }    
		
		public void createOpportunityQuote() throws InterruptedException {
			waitForElement(6000);
			element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesButton));
			MoveToElementClick(element);
		 waitForElement(6000);
		 element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesOpportunities));
			MoveToElementClick(element);
			ExtentSuccessMessage("Clicked on Sales Opportunity");
			waitForElement(3000);
			searchcustomer();
			Thread.sleep(3000);
			
			element = wait.until(ExpectedConditions.presenceOfElementLocated(ClickLead));
			MoveToElementClick(element);
			ExtentSuccessMessage(" Lead has been clicked");
			waitForElement(6000);
			
			element = wait.until(ExpectedConditions.presenceOfElementLocated(OpportunityQuote));
			MoveToElementClick(element);
			ExtentSuccessMessage("Clicked on Create quote");
			waitForElement(6000);
			writeText(OpportunityEffectiveDate,"12/12/2024" + Keys.ENTER);
			waitForElement(6000);
			writeText(OptZipCode,"33233");
			ExtentSuccessMessage("Entered the Zipcode 33233");
			element = wait.until(ExpectedConditions.presenceOfElementLocated(OPtStatus));
			MoveToElementClick(element);
			waitForElement(7000);
			element = wait.until(ExpectedConditions.presenceOfElementLocated(OptSubStaus));
			MoveToElementClick(element);
			ExtentSuccessMessage("Selected the status");
			waitForElement(8000);
			element = wait.until(ExpectedConditions.presenceOfElementLocated(Optsubmit));
			MoveToElementClick(element);
			ExtentSuccessMessage("Quote has been created");
			
			
			
		}
		
		public void check_quote() throws InterruptedException
		{
			
			waitForElement(4000);
			element = wait.until(ExpectedConditions.presenceOfElementLocated(Customerdropdown));
			MoveToElementClick(element);
			ExtentSuccessMessage("Quote validation started");
			//searchcustomer();
			
			element = wait.until(ExpectedConditions.presenceOfElementLocated(ClickLead));
			MoveToElementClick(element);
			ExtentSuccessMessage(" Lead has been clicked");
			waitForElement(9000);
			By quotes = By.xpath("//a[@role='tab'][.=' Quotes']");
			waitForElement(1000);
			element = wait.until(ExpectedConditions.presenceOfElementLocated(quotes));
			MoveToElementClick(element);
			waitForElement(1000);
			By Status = By.xpath("//div[@title='Created']");
			element = wait.until(ExpectedConditions.presenceOfElementLocated(Status));
			ExtentSuccessMessage("Quote is validated and available");
			
			
			
			
			
		}
		
		public void create_policy() throws InterruptedException
		{
			
			waitForElement(4000);
			element = wait.until(ExpectedConditions.presenceOfElementLocated(Customerdropdown));
			MoveToElementClick(element);
			ExtentSuccessMessage("policy creation statred");
			//searchcustomer();
			
			waitForElement(6000);
			element = wait.until(ExpectedConditions.presenceOfElementLocated(ClickLead));
			MoveToElementClick(element);
			ExtentSuccessMessage(" Lead has been clicked");
			waitForElement(6000);
			element = wait.until(ExpectedConditions.presenceOfElementLocated( Policies));
			MoveToElementClick(element);
		     waitForElement(6000);
			
		     By Create_Policy = By.xpath("//button[normalize-space()='Create Policy']");
			waitForElement(1000);
			element = wait.until(ExpectedConditions.presenceOfElementLocated( Create_Policy));
			MoveToElementClick(element);
			ExtentSuccessMessage(" Create Policy has been clicked");
			waitForElement(6000);
			
			element = wait.until(ExpectedConditions.presenceOfElementLocated(ProductCategory));
			MoveToElementClick(element);
		
			waitForElement(3000);
			
			element = wait.until(ExpectedConditions.presenceOfElementLocated(AccidentLOB));
			MoveToElementClick(element);
			ExtentSuccessMessage("Medical has been selected");
			waitForElement(2000);
			element = wait.until(ExpectedConditions.presenceOfElementLocated(Carrier));
			MoveToElementClick(element);	
			waitForElement(1000);		
			element = wait.until(ExpectedConditions.presenceOfElementLocated(SelectCarrier));
			MoveToElementClick(element);
			ExtentSuccessMessage("Carrier has been selected");
			waitForElement(2000);
			element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesType));
			MoveToElementClick(element);	
			waitForElement(3000);		
			element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesNew));
			MoveToElementClick(element);
			ExtentSuccessMessage("SalesType has been selected");
			waitForElement(2000);
			element = wait.until(ExpectedConditions.presenceOfElementLocated(PolicyStatus));
			MoveToElementClick(element);	
			waitForElement(2000);		
			element = wait.until(ExpectedConditions.presenceOfElementLocated(PolicyActive));
			MoveToElementClick(element);
			ExtentSuccessMessage("PolicyStatus has been selected");
			waitForElement(8000);
		   writeText(PolicyEFDate,"12/12/2024" +Keys.ENTER);
			waitForElement(8000);
			
			
			By AOR_Search = By.xpath("//button[@ng-click=\"$parent.aorSearchLookup('AgentName', 'CreateAssetForm')\"]//i[@class='glyphicon glyphicon-search']");
			element = wait.until(ExpectedConditions.presenceOfElementLocated( AOR_Search));
			MoveToElementClick(element);
			ExtentSuccessMessage("Clicked on AOR search");
			waitForElement(8000);
			By AOR_Text = By.xpath("//input[@class='pull-right ng-pristine ng-untouched ng-valid ng-empty']");
			element = wait.until(ExpectedConditions.presenceOfElementLocated( AOR_Text));
			if (!element.getAttribute("value").isEmpty()) {
			    element.clear();
			    ExtentSuccessMessage("Cleared AOR search");
			}
			
			writeText(AOR_Text,"QA");
			By AOR_Textsearch = By.xpath("(//i[@class='glyphicon glyphicon-search'])[5]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AOR_Textsearch));
			MoveToElementClick(element);
			ExtentSuccessMessage("AOR search is visible");
			waitForElement(8000);
	        By Select_Agent = By.xpath("(//input[@name='selectedAgent'])[1]");
			element = wait.until(ExpectedConditions.presenceOfElementLocated(Select_Agent));
			MoveToElementClick(element);
			waitForElement(1000);
			By click_ok = By.xpath("//button[normalize-space()='OK']");
			element = wait.until(ExpectedConditions.presenceOfElementLocated(click_ok));
			MoveToElementClick(element);
			
			
//			element = wait.until(ExpectedConditions.presenceOfElementLocated(PolicyAOR));
//			MoveToElementClick(element);	
//			waitForElement(8000);
			
//			WebElement elep = driver.findElement(AoRSearchText);
//			elep.clear();
//			elep.sendKeys("QA");
//			waitForElement(9000);
//			
//		    writeText(AoRSearchText,"QA");
//		    waitForElement(8000);
//			element = wait.until(ExpectedConditions.presenceOfElementLocated(AORSearchIcon));
//			MoveToElementClick(element);
////			
//			waitForElement(8000);
//		element = wait.until(ExpectedConditions.presenceOfElementLocated(SelectAOR));
//		MoveToElementClick(element);	
//		waitForElement(8000);		
//			element = wait.until(ExpectedConditions.presenceOfElementLocated(AorOk));
//		MoveToElementClick(element);
		ExtentSuccessMessage("AOR has been selected");			
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PolicySubmit));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Policy submit");
		waitForElement(2000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Success_msg));
		ExtentSuccessMessage("New policy has been created and validated the success message");
			
			
			
			
			
		}
		
		public void policy_validation() throws InterruptedException
		{
			waitForElement(4000);
			element = wait.until(ExpectedConditions.presenceOfElementLocated(Customerdropdown));
			MoveToElementClick(element);
			waitForElement(2000);
			searchcustomer();
			element = wait.until(ExpectedConditions.presenceOfElementLocated(ClickLead));
			MoveToElementClick(element);
			ExtentSuccessMessage(" Lead has been clicked");
			waitForElement(6000);
			By Policies = By.xpath("//a[@role='tab'][normalize-space()='Policies']");
			waitForElement(1000);
			element = wait.until(ExpectedConditions.presenceOfElementLocated(Policies));
			MoveToElementClick(element);
			By State = By.xpath("//div[@title='Active']");
			element = wait.until(ExpectedConditions.presenceOfElementLocated(State));
			ExtentSuccessMessage("Policy is validated and active");
			
		}
		
		public void Collaboration_Validations(CensusInfo ApplicantInfo) throws InterruptedException, AWTException
		{
			waitForElement(4000);
			element = wait.until(ExpectedConditions.presenceOfElementLocated(Customerdropdown));
			MoveToElementClick(element);
			waitForElement(6000);
			element = wait.until(ExpectedConditions.presenceOfElementLocated(ClickLead));
			MoveToElementClick(element);
			waitForElement(10000);
			 
			    element = wait.until(ExpectedConditions.presenceOfElementLocated(NotesSection));
				MoveToElementClick(element);
				String Note = "This is created Via Automation";
				writeText(NotesSection, Note);
				element = wait.until(ExpectedConditions.presenceOfElementLocated(NotesConfirmationButton));
				MoveToElementClick(element);
				ExtentSuccessMessage("Note has been added");
				
				waitForElement(8000);		
				element = wait.until(ExpectedConditions.presenceOfElementLocated(AgentActionNoteInc));
				 NoteText  = element.getText();
				System.out.println("-----------"+ NoteText+"------------");
				Assert.assertEquals(Note, NoteText);
				ExtentSuccessMessage("Assertion has been done");
				
			
			    waitForElement(5000);
				element = wait.until(ExpectedConditions.presenceOfElementLocated(ActionEmailIcon));
				MoveToElementClick(element);
				
				waitForElement(2000);
				By EmailAddressDD = By.xpath("//md-select[@role='listbox']");
				wait.until(ExpectedConditions.elementToBeClickable(EmailAddressDD));
				click(EmailAddressDD);
				By EmailAddressDDOPtion = By.xpath("//md-option[@value='salessupport@healthcareenrollmentcenter.com']");
				element = wait.until(ExpectedConditions.presenceOfElementLocated(EmailAddressDDOPtion));
				MoveToElementClick(element);
				
				element = wait.until(ExpectedConditions.presenceOfElementLocated(AddEmailAddressCheckBox));
				MoveToElementClick(element);
				String AgentEmailAction = "leoagent@yopmail.com";
				writeText(AddEmailAddressCheckBox,AgentEmailAction + Keys.ENTER);
				element = wait.until(ExpectedConditions.presenceOfElementLocated(EmailSubject));
				MoveToElementClick(element);
				String AgentEmailSubject = "This Mail is Via Automation for Healthcare";
				writeText(EmailSubject,  AgentEmailSubject);
				element = wait.until(ExpectedConditions.presenceOfElementLocated(EmailConfirmationButton));
				MoveToElementClick(element);
			    ExtentSuccessMessage("Email has been added");
			
			    waitForElement(10000);
				element = wait.until(ExpectedConditions.presenceOfElementLocated(AgentEmailInc));
				NoteText  = element.getText();
				System.out.println("-----------"+ NoteText+"------------");
				Assert.assertEquals(AgentEmailAction, NoteText);
				ExtentSuccessMessage("Assertion has been done");
						
			   
				waitForElement(8000);
				element = wait.until(ExpectedConditions.presenceOfElementLocated(ActionAttachment));
				MoveToElementClick(element);
				
				waitForElement(5000);
				By DocumentDD1 =  By.cssSelector(".form-control.ng-pristine.ng-untouched.ng-valid.ng-not-empty");
				element = wait.until(ExpectedConditions.presenceOfElementLocated(DocumentDD1));
				Select s1 = new Select(element);
				s1.selectByVisibleText("Other");
//				
//				element = wait.until(ExpectedConditions.presenceOfElementLocated(DocumentDD));
//				wait.until(ExpectedConditions.elementToBeClickable(DocumentDD));
//				click(DocumentDD);
//				waitForElement(500);
//	           
//	            wait.until(ExpectedConditions.elementToBeClickable(DocumentDDOption));
//				click(DocumentDDOption);	
				wait.until(ExpectedConditions.elementToBeClickable(DocumentAttachFileButton));
				click(DocumentAttachFileButton);
				
				Robot robot = new Robot();
				String filePath = System.getProperty("user.home") + "\\eclipse-workspace\\Regression_Set_Customer_Login\\ce_set1_regression_admin_customer_opportunities\\Upload\\AgentAttachment.txt";
				StringSelection stringSelection = new StringSelection(filePath);
				Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
				robot.keyPress(KeyEvent.VK_CONTROL);
				Thread.sleep(1000);
				
				robot.keyPress(KeyEvent.VK_V);
				Thread.sleep(1000);
				
				robot.keyRelease(KeyEvent.VK_V);
				Thread.sleep(1000);
				
				robot.keyRelease(KeyEvent.VK_CONTROL);
				Thread.sleep(1000);
				
				robot.keyPress(KeyEvent.VK_ENTER);
				Thread.sleep(1000);
				
				robot.keyRelease(KeyEvent.VK_ENTER);
				Thread.sleep(1000);
			
				element = wait.until(ExpectedConditions.presenceOfElementLocated(AttachmentConfirmationButton));
				MoveToElementClick(element);
				ExtentSuccessMessage("Attachment has been added");
				
			
				Assert.assertTrue(driver.findElement(AttachmentInc).isDisplayed());
				ExtentSuccessMessage("Assertion has been done");
				
		
				
				waitForElement(4000);
				element = wait.until(ExpectedConditions.presenceOfElementLocated(ActionTask));
				MoveToElementClick(element);
				waitForElement(4000);
				element = wait.until(ExpectedConditions.presenceOfElementLocated(ActivityDD));
				//element.click();
				Thread.sleep(600);
				Select select = new Select(element);
				select.selectByVisibleText("Send Email");
				Thread.sleep(1000);
				
				waitForElement(4000);
				element = wait.until(ExpectedConditions.presenceOfElementLocated(PriorityDD));
				element.click();
				Thread.sleep(500);
				Select s = new Select(element);
				s.selectByVisibleText("Low");
				Thread.sleep(1000);
				
				element = wait.until(ExpectedConditions.presenceOfElementLocated(CommentTextArea));
				MoveToElementClick(element);
				writeText(CommentTextArea, "This Task is created VIA Automation" );
				Thread.sleep(1000);
				
				element = wait.until(ExpectedConditions.presenceOfElementLocated(TaskConfirmationButton));
				MoveToElementClick(element);
				ExtentSuccessMessage("Task has been added");
				
				waitForElement(4000);
				
				Assert.assertTrue(driver.findElement(TaskInc).isDisplayed());
				ExtentSuccessMessage("Assertion has been done");
				
				
			
		
		}
		
		public void Search_Validation() throws InterruptedException
		{
			Thread.sleep(3000);
			element = wait.until(ExpectedConditions.presenceOfElementLocated(Customers));
			MoveToElementClick(element);
			 ExtentSuccessMessage("Clicked on Customers");
			 waitForElement(8000);
			By search = By .xpath("//input[@type='search']");
			element = wait.until(ExpectedConditions.presenceOfElementLocated(search));
			MoveToElementClick(element);
			String SearchSubject = "Rohith";
			writeText(search ,  SearchSubject+ Keys.ENTER);
			waitForElement(14000);
			
			By search_element = By.xpath("(//a[@class='edit-list-anchor ng-binding'])[1]");
			element = wait.until(ExpectedConditions.presenceOfElementLocated(search_element));
			waitForElement(8000);
			MoveToElementClick(element);
			waitForElement(7000);
			By Customername = By.cssSelector("span[ng-bind=\"$parent.BasicInformationFormData['CustomerName']\"]");
			element = wait.until(ExpectedConditions.presenceOfElementLocated(Customername));
			String GetName = element.getText();
			System.out.println(GetName);
			 Assert.assertTrue(GetName.contains("Rohith"));
			
			
			//Assert.assertTrue(driver.findElement(search_element).isDisplayed());
			ExtentSuccessMessage("Assertion has been done");
			
			
		}
		
		public void reset_filter() throws InterruptedException
		{
			
			
			Thread.sleep(3000);
			element = wait.until(ExpectedConditions.presenceOfElementLocated(Customers));
			MoveToElementClick(element);
			 ExtentSuccessMessage("Clicked on Customers");
			
			waitForElement(8000);
			element = wait.until(ExpectedConditions.presenceOfElementLocated(RecentAgentIcon));
			MoveToElementClick(element);
			
			
			waitForElement(7000);
			element = wait.until(ExpectedConditions.presenceOfElementLocated(CreatedTodayButton));
			MoveToElementClick(element);
			waitForElement(13000);
			 By CreatedTodayInc = By.xpath("(//a[@class='edit-list-anchor ng-binding'])[1]");
			waitForElement(3000);
			Assert.assertTrue(driver.findElement(CreatedTodayInc).isDisplayed());
			ExtentSuccessMessage("Assertion has been done");
			//assertFalse(checkBox.isSelected())
			//Assert.assertFalse(element.isSelected())
			waitForElement(13000);
			By Reset  = By.xpath("//a[contains(@class,'pull-right reset-button ng-isolate-scope')]");
			element = wait.until(ExpectedConditions.presenceOfElementLocated(Reset));
			MoveToElementClick(element);
			ExtentSuccessMessage("clicked on reset");
			waitForElement(7000);
			element = wait.until(ExpectedConditions.presenceOfElementLocated(RecentAgentIcon));
			MoveToElementClick(element);
			
			
			waitForElement(3000);
			element = wait.until(ExpectedConditions.presenceOfElementLocated(CreatedTodayButton));
			Assert.assertFalse(element.isSelected());
			ExtentSuccessMessage("Assertion has been donefor reset filters.");
			
			
			
		}
		public void Column_Options() throws InterruptedException
		{
			
			Thread.sleep(10000);
			element = wait.until(ExpectedConditions.presenceOfElementLocated(Customers));
			MoveToElementClick(element);
			 ExtentSuccessMessage("Clicked on Customers");
			 waitForElement(10000);
			 
			 By Option = By.xpath("(//i[@class='ui-grid-icon-menu'])[2]");
			 element = wait.until(ExpectedConditions.presenceOfElementLocated(Option));
			 //js.executeScript("arguments[0].click();", element);
			  MoveToElementClick(element);
		      ExtentSuccessMessage("Clicked on more column options button");
		      
		      //Unchecking name column 
		      waitForElement(8000);
		      By check_Name = By.xpath("(//i[contains(@class,'ui-grid-icon-cancel')])[3]");
		      element = wait.until(ExpectedConditions.presenceOfElementLocated(check_Name));
			  MoveToElementClick(element);
			  ExtentSuccessMessage("checked name column");
			  
			  Thread.sleep(6000);
			  By Name_Column = By.xpath("//span[@class='ui-grid-header-cell-label ng-binding' and text()='First Name']");
			  element = wait.until(ExpectedConditions.presenceOfElementLocated(Name_Column));
			  
			  ExtentSuccessMessage(" name column is  visible");
			  //hide 
			  By Uncheck_Fname = By.xpath("(//i[@class='ui-grid-icon-ok'])[2]");
		      element = wait.until(ExpectedConditions.presenceOfElementLocated(Uncheck_Fname));
			  MoveToElementClick(element);
			  ExtentSuccessMessage("Unchecked name column");
			  Boolean test;
			  Thread.sleep(6000);
			  By fName_Column = By.xpath("//span[@class='ui-grid-header-cell-label ng-binding' and text()='First Name']");
//			  WebElement Fname = driver.findElement(By.xpath("//span[@class='ui-grid-header-cell-label ng-binding' and text()='First Name']"));
//			  boolean isNotVisible = wait.until(ExpectedConditions.invisibilityOf(Fname));
//			  Assert.assertTrue(isNotVisible);
			  test = wait.until(ExpectedConditions.invisibilityOfElementLocated(fName_Column));
			  Assert.assertTrue(test);
			  ExtentSuccessMessage(" name column is  invisible");
			
			      
		      
			 
			
		}
		
    }
		


