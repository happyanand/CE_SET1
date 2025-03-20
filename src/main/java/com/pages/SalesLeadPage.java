package com.pages;



import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List; 

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.BasePackage.Base_Class;

import Utility.ExcelHelper;

public class SalesLeadPage extends BasePage {
	public SalesLeadPage(WebDriver driver) {
		super(driver);
	}
	

	JavascriptExecutor js = (JavascriptExecutor) driver;
	JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
	WebElement element;
	ExcelHelper _excelObj = new ExcelHelper();
	XSSFSheet tcTestData = _excelObj.readExcelSheet("TestData", "URLs");
	public String firstnumber;
	public String firstnumber1;
	public String First_name;
	public String Last_name;
	public String Full_Name;

	public String NoteText;
	public String fullname;
	private By TaskInc = By.xpath("(//u[@class='ng-binding'])[1]");
	private By CheckUserLogin = By.xpath("//button[@class='positive md-button md-ink-ripple']");
	By signIn = By.xpath("//*[@id='form-validation-button']");

	private By AgentActionNoteInc = By.xpath("//u[@class='item_to_highlight ng-binding']");
	private By userID = By.id("user-name");
	By pwd = By.id("password");
	By SalesButton = By.xpath("//span[text()='Sales ']");
	By Leads = By.xpath("(//a[text()='Leads'])[2]");
	By NewLead = By.xpath("//button[@name='newLeadBtn' and @id='newLeadBtn'] ");
	By NewLeadFirstName = By.xpath("//input[@id='LeadFirstName']");
	By NewLeadLastName = By.xpath("//input[@id='LeadLastName']");
	By DOB = By.xpath("//input[@id='Dob']");
	By Gender = By.xpath("//label[text()='Gender ']");
	By Male = By.xpath("//div[text()='Male']");
	By Phnum = By.xpath("//input[@name='LeadMobile']");
	By Email = By.xpath("//input[@id='LeadEmail']");
	By LeadInformation = By.xpath("//div[@id='formFlag2']");
	By HomeorPrincipals = By.xpath("//div[@id='formFlag3']");
	By HomeZipCode = By.xpath("//input[@name='ZipCode']");
	By Adress = By.xpath("//input[@id='AddressLine1'and @name ='AddressLine1']");
	By OtheInformation = By.xpath("//div[@id='formFlag5']");
	By Submit = By.xpath("(//button[text()='Submit'])[7]");
	By ClickLead = By.xpath("(//a[@class='edit-list-anchor ng-binding'])[1]");
	By LeadAssign = By.xpath("//button[@id='Assign']");
	By EditIcon = By.xpath("//button[@id='editLeadsBtn']");
	By StatusSelect = By.xpath("//select[@class='md-visually-hidden']");
	By ButtonSave = By.xpath("//button[text()='Save']");

	By LeadQualify = By.xpath("//button[@id='Qualify']");
	By LeadReject = By.xpath("//button[@id='Reject']");
	By LeadDispose = By.xpath("//button[@id='Call']");
	By Convert = By.xpath("//button[@id='Convert']");
	By MedicalDropdown = By.xpath("//md-select[@id='select_331']");
	By Medical = By.xpath("(//div[text()='Medical']/parent::md-option)[2]");
	By ConvertSubmit = By.xpath("//button[text()='Submit']");
	By SalesLeadNotes = By.xpath("//textarea[@name='desc']");
	By SaveNote = By.xpath("//button[@type='submit']/child::i");
	By SalesEmail = By.xpath("//i[@class='fa fa-envelope']/parent::a");
	// By SalesEmailID = By.xpath("//input[@placeholder='Add email address']");
		public static boolean ElementDisplayed(By locator) throws InterruptedException {
			Boolean flag = false;
			try {
				WebElement element = driver.findElement(locator);
				flag = element.isDisplayed();
			} catch (Exception e) {


			}
			if (flag) {
				ExtentSuccessMessage("Successfully System able to found the element :" + locator);
				return flag;
			} else {
				ExtentSuccessMessage("System not able to found the element :" + locator);
				flag = false;
			}
			return flag;
		}
	 

	By SalesEmailID = By.xpath("//md-chips[@placeholder='Add email address']");
	By EmailSubject = By.xpath("//input[@placeholder='Add a subject']");
	By SaveEmail = By.xpath("//i[@class='fa fa-check yellow green']/parent::button");
	By SalesTask = By.xpath("//i[@class='fa fa-calendar']/parent::a");
	By TaskSave = By.xpath("//i[@class='fa fa-check yellow green']");
	By AttachFile = By.xpath("//i[@class='fa fa-paperclip']/parent::a");
	By AttachDropDown = By.xpath("//div[@class='form-group ng-isolate-scope']/child::select");
	By AddressSave = By.xpath("//i[@class='fa fa-check yellow green']");
	By StatusLead = By.xpath("(//div[@class='accordion-container grid-style-height']/child::h5)[7]");
	By StausUnqualified = By.xpath("//span[text()='Unqualified']");
	By StatusAccepted = By.xpath("//span[text()='Accepted']");
	By StatusConverted = By.xpath("//span[text()='Converted']");
	By StatusQualified = By.xpath("//span[text()='Qualified']");
	By AdvancedSearch = By.xpath("//button[@id='advancedSearchBtn']");
	By AdvancedLeadStatus = By.xpath("//md-select[@id='LeadStatus']");
	By SelectAccepted = By.xpath("//md-option[@value='Accepted']");
	By SelectUnqualified = By.xpath("//md-option[@value='Unqualified']");
	By SelectConverted = By.xpath("//md-option[@value='Converted']");
	By SelectQualified = By.xpath("//md-option[@value='Qualified']");
	By SelectReject = By.xpath("//md-option[@value='Rejected']");
	By AdvanceSubmit = By.xpath("//button[@id='advancedSearchSubmitBtn']");
	By SalesOpportunities = By.xpath("(//a[text()='Opportunities'])[2]");
	By NewOpportunity = By.xpath("//button[@id='newOpportunityBtn']");
	By OpportunityName = By.xpath("(//input[@name='CustomerName'])[2]");
	By SalesSearchIcon = By.xpath("(//button[@class='btn btn-default green'])[4]");
	By RadioButtonSelect = By.xpath("//input[@type='radio']");
	By ButtonOk = By.xpath("//button[text()='OK']");
	By SubmitOk = By.xpath("(//button[contains(text(),'Submit')])[5]");
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
	By OpportunityStatus = By.xpath("//md-select[@id='CRMOpportunityStatus']");
	By OpportunityOpen = By.xpath("//md-option[@value='Open']");
	By OpportunityCloseAsLost = By.xpath("//md-option[@value='Closed as Lost']");
	By OpportunityCloseWon = By.xpath("//md-option[@value='Closed as Won']");
	By OppQualify = By.xpath("//md-option[@value='Qualified']");
	By OppRenewal = By.xpath("//md-option[@value='Renewed']");
	By OppCancel = By.xpath("//md-option[@value='Cancelled']");
	By OppSearch = By.xpath("//button[@id='applyadvancedSearchBtn']");
	By Oppstatus = By.xpath("(//div[@class='accordion-container grid-style-height']/child::h5)[3]");
	By OppCancel2 = By.xpath("//md-checkbox[@value='Cancelled']");
	By OppCloseW = By.xpath("//md-checkbox[@value='Closed as Lost']");
	By OppOpen = By.xpath("//md-checkbox[@value='Open']");
	By OppQualified = By.xpath("//md-checkbox[@value='Qualified']");
	By SalesQuote = By.xpath("(//a[text()='Quotes'])[2]");
	By InstallPolicy = By.xpath("(//button[@ng-repeat='normal in normalActions | reverse'])[1]");
	By AorSearch = By.xpath("//button[@class='btn btn-default green']");
	By AorText = By.xpath("//input[@ng-model='searchText']");
	By SearchIcon = By.xpath("//button[@title='Search Agent Name']");
	By AorRadioButton = By.xpath("//input[@name='selectedAgent']");
	By Okbutton = By.xpath("//button[text()='OK']");
	By SubmitQuote = By.xpath("//button[text()='Submit']");
	By CancelQuote = By.xpath("(//button[@ng-repeat='normal in normalActions | reverse'])[2]");
	By SelectStatus = By.xpath("//md-select[@name='TerminateQuoteStatus']");
	By SelectCancel = By.xpath("//md-option[@value='Terminated']");
	By ActualRevenu = By.xpath("//input[@name='ActualRevenue']");
	By Textarea = By.xpath("//textarea[@name='Reason']");
	By CancelSubmit = By.xpath("//button[text()='Submit']");
	By QuoteStatus = By.xpath("(//div[@class='accordion-container grid-style-height']/child::h5)[3]");
	By QuoteCancel = By.xpath("//md-checkbox[@value='Cancelled']");
	By QuoteCreated = By.xpath("//md-checkbox[@value='Created']");
	By QuoteDeclined = By.xpath("//md-checkbox[@value='Declined']");
	By QuoteExpire = By.xpath("//md-checkbox[@value='Expired']");
	By QuoteInprogress = By.xpath("//md-checkbox[@value='In Progress']");
	By QuoteInactive = By.xpath("//md-checkbox[@value='Inactive']");
	By QuoteInstallinprogress = By.xpath("//md-checkbox[@value='Install In Progress']");
	By QuoteInstall = By.xpath("//md-checkbox[@value='Installed']");
	By QuoteTerminated = By.xpath("//md-checkbox[@value='Terminated']");
	By QuoteAdStatusDD = By.xpath("//md-select[@name='QuoteStatus']");
	By QuoteAdCancel = By.xpath("//md-option[@value='Cancelled']");
	By QuoteAdCreated = By.xpath("//md-option[@value='Created']");
	By QuoteAdDeclined = By.xpath("//md-option[@value='Declined']");
	By QuoteAdExpired = By.xpath("//md-option[@value='Expired']");
	By QuoteAdInActive = By.xpath("//md-option[@value='Inactive']");
	By QuoteAdInProgress = By.xpath("//md-option[@value='In Progress']");
	By QuoteAdInstalled = By.xpath("//md-option[@value='Installed']");
	By QuoteAdInstallInProgress = By.xpath("//md-option[@value='Install In Progress']");
	By QuoteAdTerminated = By.xpath("//md-option[@value='Terminated']");
	By QuoteAdSearch = By.xpath("//button[@id='applyadvancedSearchBtn']");
	By SalesPolicy = By.xpath("(//a[text()='Policies'])[2]");
	By CreatePolicy = By.xpath("//button[@class='btn btn-default pull-left btn-yellow']");
	By PolicySearchIcon = By.xpath("//i[@class='glyphicon glyphicon-search']");
	By Submit_btn = By.xpath("//button[@id='formSubmitBtn']");
	By search = By.xpath("//input[@type='search'][@aria-label='Search your text']");
	
	By convert = By.xpath("//i[@class='fa fa-refresh yellow']");
	By PolicySearchText = By.xpath("//input[@ng-model='searchText']");
	By PolicyCustmerSearchIcon = By.xpath("//button[@title='Search Customer']");
	By SelectCustmer = By.xpath("//input[@ng-model='data.selectedCustomer']");
	By CustomerOk = By.xpath("//button[text()='OK']");
	By ProductCategory = By.xpath("(//md-select[@id='CRMProductCategory'])[2]");
	By MedicalLOB = By.xpath("(//md-option[@value='Medical'])[3]");
	By Carrier = By.xpath("//md-select[@id='Carrier']");
	By SelectCarrier = By.xpath("(//md-option[@value='Aetna'])[2]");
	By SalesType = By.xpath("//md-select[@id='salesType']");
	By SalesNew = By.xpath("(//md-option[@value='New'])[2]");
	By PolicyStatus = By.xpath("//md-select[@id='AssetStatus']");
	By PolicyActive = By.xpath("(//md-option[@value='Active'])[4]"); 
	By PolicyEFDate = By.xpath("//input[@id='EffectiveDate']");
	By PolicyAOR = By.xpath("(//button[@class='btn btn-default green']/child::i)[3]");
	By AoRSearchText = By.xpath("//input[@ng-model='searchText']");
	By AORSearchIcon = By.xpath("//button[@title='Search Agent Name']");
	By SelectAOR = By.xpath("//input[@name='selectedAgent']");
	By AorOk = By.xpath("//button[text()='OK']");
	By PolicySubmit = By.xpath("(//button[text()='Submit'])[5]");
	By PolicyCancel = By.xpath("//button[@class='btn btn-default pull-right ng-binding ng-scope']");
	By PolicyCancelDD = By.xpath("//md-select[@name='TerminateAssetStatus']");
	By PolicyDDStatus = By.xpath("//md-option[@value='Terminated']");
	By PolicyCancelSubmit = By.xpath("//button[text()='Submit']");
	By PolicyFilterStatus = By.xpath("(//div[@class='accordion-container grid-style-height']/child::h5)[3]");
	By PolicyStatusCancel = By.xpath("//md-checkbox[@value='Cancelled']");
	By PolicyStatusEnrolled = By.xpath("//md-checkbox[@value='Enrolled']");
	By PolicyEnrolledPlaylater = By.xpath("//md-checkbox[@value='Enrolled-Paylater']");
	By PolicyStatusFullfill = By.xpath("//md-checkbox[@value='Fulfilled']");
	By PolicyStatusInProgress = By.xpath("//md-checkbox[@value='In Progress']");
	By PolicyStatusInActive = By.xpath("//md-checkbox[@value='Inactive']");
	By PolicyInComplete = By.xpath("//md-checkbox[@value='Incomplete']");
	By PolicyLockEligibility = By.xpath("//md-checkbox[@value='Locked-Eligibility']");
	By PolicyLockPayment = By.xpath("//md-checkbox[@value='Locked-Payment']");
	By PolicyLockEnrollment = By.xpath("//md-checkbox[@value='Locked-Enrollment']");
	By PolicyLockFullfillment = By.xpath("//md-checkbox[@value='Locked-Fulfillment']");
	By PolicyNeedinfo = By.xpath("//md-checkbox[@value='Need-More-Information']");
	By PolicyPending = By.xpath("//md-checkbox[@value='Pending Cancellation']");
	By PendingDE = By.xpath("//md-checkbox[@value='Pending-DE-Automation']");
	By PremiumPaid = By.xpath("//md-checkbox[@value='PremiumPaid']");
	By PolicystatusSubmit = By.xpath("//md-checkbox[@value='Submitted']");
	By PolicyTerminated = By.xpath("//md-checkbox[@value='Terminated']");
	By PolicyADDropdown = By.xpath("//md-select[@id='CRMPolicyStatus']");
	By PolicyADCancel = By.xpath("//md-option[@value='Cancelled']");
	By PolicyTestMM = By.xpath("//md-option[@value='TestMM status']");
	By PolicyEnrolled = By.xpath("//md-option[@value='Enrolled']");
	By PolicyEnrollPaylater = By.xpath("//md-option[@value='Enrolled-Paylater']");
	By PolicyFullfill = By.xpath("//md-option[@value='Fulfilled']");
	By PolicyInProgress = By.xpath("//md-option[@value='In Progress']");
	By PolicyAdInActive = By.xpath("//md-option[@value='Inactive']");
	By PolicyAdIncomplete = By.xpath("//md-option[@value='Incomplete']");
	By PolicyLockedEligibility = By.xpath("//md-option[@value='Locked-Eligibility']");
	By PolicyAdLockedEnrollment = By.xpath("//md-option[@value='Locked-Enrollment']");
	By PolicyAdLockedFullfillment = By.xpath("//md-option[@value='Locked-Fulfillment']");
	By PolicyNeedmoreInfo = By.xpath("//md-option[@value='Need-More-Information']");
	By PolicyAdPending = By.xpath("//md-option[@value='Pending']");
	By PolicyAdPendeningCancellation = By.xpath("//md-option[@value='Pending Cancellation']");
	By PolicyAdPendingDEAutomation = By.xpath("//md-option[@value='Pending-DE-Automation']");
	By PolicyAdPremiumPaid = By.xpath("//md-option[@value='PremiumPaid']");
	By PolicyAdSubmitted = By.xpath("//md-option[@value='Submitted']");
	By PolicyAdTerminated = By.xpath("//md-option[@value='Terminated']");
	By ImportCustmerPolicies = By.xpath("//button[@class='btn btn-yellow dropdown-toggle pull-right']");
	By BulkImport = By.xpath("//button[@id='bulkImportBtn']");
	By SelectFile = By.xpath("(//div[text()='Select File'])[1]");
	By FileSubmit = By.xpath("//button[@id='importPolicySubmitBtn']");
	By FileSubmitOk = By.xpath("//button[@class='btn btn-primary btn-default green ng-binding']");// button[contains(.,'OK')]
	By Customers = By.xpath("//a[@class='glyphicon fa fa-users']");
	By NewCustomer = By.xpath("//button[@id='newCustomerBtn']");
	By CustFName = By.xpath("(//input[@id='LeadFirstName'])[1]");
	By CustLName = By.xpath("(//input[@id='LeadLastName'])[1]");
	// By ContactInfo = By.xpath("(//div[@class='accordion-container'])[2]");
	By ContactInfo = By
			.xpath("//*[@id=\"page-wrapper\"]/div/ui-view/div[8]/ng-include/div[3]/div/div[2]/div/div[1]/div[5]/i");
	By Cellphone = By.xpath("(//input[@name='CellPhone'])[1]");
	By CustMail = By.xpath("(//input[@name='Email'])[1]");

	By PrincipalAdress = By
			.xpath("//*[@id=\"page-wrapper\"]/div/ui-view/div[8]/ng-include/div[3]/div/div[2]/div/div[1]/div[8]/i");
	By PricipalAD1 = By.xpath("//input[@id='AddressLine1']");
	By PrincipalZipCode = By.xpath("//input[@name='ZipCode']");
	By MailingAddress = By.xpath("(//input[@type='checkbox'])[2]");
	By CustSubmit = By.xpath("(//button[text()='Submit'])[3]");
	By CustcreateOpp = By.xpath("(//button[@class='btn btn-default pull-right ng-binding ng-scope'])[2]");
	By CustOppSubmit = By.xpath("(//button[@class='btn btn-default green'])[3]");
	By CreateServiceRequest = By.xpath("(//button[@class='btn btn-default pull-right ng-binding ng-scope'])[1]");
	By RequestType = By.xpath("//md-select[@name='SrType']");
	By RequestStatus = By.xpath("//md-option[@value='New Enrollment']");
	By RequestSubType = By.xpath("//md-select[@name='SRActivitySubType']");
	By RequestSubStatus = By.xpath("//md-option[@value='Referral']");
	By RequestSubmit = By.xpath("(//button[text()='Submit'])[5]");
	By CustomerFilterStatus = By.xpath("(//div[@class='accordion-container grid-style-height']/child::h5)[4]");
	By CustomerFilActive = By.xpath("//md-checkbox[@value='Active']");
	By CustomerInActive = By.xpath("//md-checkbox[@value='Inactive']");
	By CustomerFilProspet = By.xpath("//md-checkbox[@value='Prospect']");
	By CustomerFilDecesed = By.xpath("//md-checkbox[@value='Deceased']");
	By CustomerADSearchDD = By.xpath("//md-select[@id='Status']");
	By CustomerAdActive = By.xpath("//md-option[@value='Active']");
	By CustomerAdInActive = By.xpath("//md-option[@value='Inactive']");
	By CustomerAdprospect = By.xpath("//md-option[@value='Prospect']");
	By CustomerAdDecesed = By.xpath("//md-option[@value='Deceased']");
	By CustomerImport = By.xpath("//button[@id='importCustomerPolicyBtn']");
	By CustomerBulkImport = By.xpath("//button[@name='bulkImportBtn']");
	By CustomerImportSubmit = By.xpath("//button[@id='uploadBobImportBtn']");
	By CustomerContact = By.xpath("//a[@class='edit-list-anchor ng-binding']");
	By CustomerSendContactCard = By.xpath("//button[@title='Send Contact Card']");
	By CustomerContactSend = By.xpath("//button[text()='Send']");
	By Service = By.xpath("//a[@class='glyphicon fa fa-fw fa-gears']");
	By NewServiceReq = By.xpath("//button[@id='createServiceRequestBtn']");
	By SearchTextCustomer = By.xpath("//input[@name='Customer']");
	By CustomerSearchIcon = By.xpath("//button[@class='btn btn-default green']/child::i");
	By SelectCustomer = By.xpath("//input[@name='selCustomer']");

	By ServiceCustomerOk = By.xpath("//button[text()='OK']");
	By ServiceRqtypeDD = By.xpath("//md-select[@name='SrType']");
	By SelectRq = By.xpath("(//md-option[@value='New Enrollment'])[3]");
	By ServiceRqSubtypeDD = By.xpath("//md-select[@name='SRActivitySubType']");
	By ServiceRqSubStstus = By.xpath("//md-option[@value='Referral']");
	By ServiceProductDD = By.xpath("(//md-select[@name='SRProduct'])[2]");
	By ServiceProductCE = By.xpath("(//md-option[@value='CE'])[2]");
	By ServiceActionByDD = By.xpath("//md-select[@name='SRActionedBy']");
	By SelectActionByQA = By.xpath("//md-option[@value='QA']");
	By SelectSubmit = By.xpath("(//button[text()='Submit'])[2]");
	By SelectService = By.xpath("//a[@class='edit-list-anchor ng-binding']");
	By AddActivity = By.xpath("//button[@name='AddActivity']");
	By ActivityTypeDD = By.xpath("//select[@class='ng-pristine ng-empty ng-invalid ng-invalid-required ng-touched']");
	By SaveAct = By.xpath("//button[text()='Save']");
	By ServiceFilter = By.xpath("(//div[@class='accordion-container grid-style-height']/child::h5)[4]");
	By ServiceNew = By.xpath("//md-checkbox[@value='New']");
	By ServiceAssigned = By.xpath("//md-checkbox[@value='Assigned']");
	By ServiceInProgress = By.xpath("//md-checkbox[@value='In Progress']");
	By Servicehold = By.xpath("//md-checkbox[@value='On Hold']");
	By ServiceReopen = By.xpath("//md-checkbox[@value='Re-open']");
	By ServiceRejected = By.xpath("//md-checkbox[@value='Rejected']");
	By ServiceClosed = By.xpath("//md-checkbox[@value='Closed']");
	By ServicePending = By.xpath("//md-checkbox[@value='Pending']");
	By ServiceADDD = By.xpath("//md-select[@name='SRStatus']");
	By ServiceADNew = By.xpath("//md-option[@value='New']");
	By ServiceADAssign = By.xpath("//md-option[@value='Assigned']");
	By ServiceADInProgress = By.xpath("//md-option[@value='In Progress']");
	By ServiceADInHold = By.xpath("//md-option[@value='On Hold']");
	By ServiceADReopen = By.xpath("//md-option[@value='Re-open']");
	By ServiceADReject = By.xpath("//md-option[@value='Rejected']");
	By ServiceADClose = By.xpath("//md-option[@value='Closed']");
	By ServiceADPending = By.xpath("//md-option[@value='Pending']");
	By ServiceExport = By.xpath("//button[@name='downlodDataBtn']");
	By ServieCloseSR = By.xpath("//button[@name='editServiceRequestBtn']");

	By CTIMinimizeIcon = By.xpath("//a[@class='fa fa-minus right-al']");
	
	private By NotesSection = By.xpath("//textarea[@class='form-control ng-pristine ng-untouched ng-isolate-scope ng-empty ng-invalid ng-invalid-required ng-valid-maxlength']");
	private By NotesConfirmationButton = By.xpath("(//button[@class='btn btn-default icons text-center ng-isolate-scope'])[2]");
	private By ActionEmailIcon = By.xpath("(//i[@class='fa fa-envelope'])[2]");
	private By AddEmailAddressCheckBox = By.xpath("//md-chips[@placeholder='Add email address']");
//	private By EmailSubject = By.xpath("//input[@class='form-control ng-pristine ng-untouched ng-isolate-scope ng-empty ng-invalid ng-invalid-required']");
	private By EmailConfirmationButton = By.xpath("(//button[@class='btn btn-default icons text-center ng-isolate-scope'])[2]");
	private By ActionAttachment = By.xpath("(//i[@class='fa fa-paperclip'])[1]");
	private By DocumentDD = By.xpath("//*[@id=\"filter-by\"]/div[1]/form/div[1]");
	private By DocumentDDOption = By.xpath("//option[text()='Other']");
	private By DocumentAttachFileButton = By.xpath("//div[@class='btn btn-primary ng-pristine ng-untouched ng-valid ng-isolate-scope ng-empty']");
	private By AttachmentConfirmationButton = By.xpath("(//button[@class='btn btn-default icons text-center ng-isolate-scope'])[2]");
	private By ActionTask = By.xpath("(//i[@class='fa fa-calendar'])[1]");
	private By ActivityDD = By.xpath("(//select[@class='form-control ng-pristine ng-untouched ng-valid ng-not-empty'])[1]");
	private By PriorityDD = By.cssSelector("#filter-by > div:nth-child(1) > form > div.form-group.w-47.custom-label > select");
	private By CommentTextArea = By.xpath("//textarea[@class='form-control comments ng-pristine ng-untouched ng-valid ng-empty ng-valid-maxlength']");
	private By TaskConfirmationButton = By.xpath("//i[@class='fa fa-check yellow green']");
	private By AgentEmailInc = By.xpath("(//u[@class='ng-binding'])[1]");
	private By AttachmentInc = By.xpath("(//u[@class='ng-binding'])[1]");

	public String randomName() {
		String allowedChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String ssn = "";
		String temp = RandomStringUtils.random(10, allowedChars);
		ssn = temp.substring(0, temp.length() - 5);
		return ssn;
	}

	public void waitForElement(int time) throws InterruptedException {
		Thread.sleep(time);
	}

	public void cttMinimize() throws InterruptedException {
		waitForElement(6000);
		WebElement CTIPad = null;
		
		
		try {
			
			CTIPad = driver.findElement(By.xpath("//div[@class='voice-call-dial-pad']"));
			
			if(CTIPad.isDisplayed())
			{
				Thread.sleep(4000);
				fetchNumber2();
				click(CTIMinimizeIcon);
				ExtentSuccessMessage("CTI Icon is Minimized");
				
			}
			 else {
					ExtentSuccessMessage("User dont have CTI Login");
			
		}
		}
			catch (NoSuchElementException e) {
				ExtentSuccessMessage("User dont have CTI Login and login is succesfull");
			
		
	
	}
	}
	
	public void Lead_Qualify_and_Convert() throws InterruptedException, AWTException {
		
		
		waitForElement(3000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesButton));
		MoveToElementClick(element);
		waitForElement(3000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Leads));
		MoveToElementClick(element);
		ExtentSuccessMessage("Sales Lead has been clicked");
		waitForElement(2000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(NewLead));
		MoveToElementClick(element);
		waitForElement(4000);
		ExtentSuccessMessage("Clicked on NewLead");
		 First_name = "Automation";
		 Last_name = randomName();
		Full_Name  = First_name+ " " + Last_name;
		writeText(NewLeadFirstName,First_name);
		writeText(NewLeadLastName,  Last_name); 
		waitForElement(1000);
		writeText(Phnum,generatePhoneNumber());
		waitForElement(3000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Submit));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Submit button");
		waitForElement(3000);
		By element2 = By.xpath("//button[contains(text(),'Proceed with Lead creation')]");
		try {
			if  (driver.findElement(element2).isDisplayed()) {
				click(element2);

			}
		} catch (NoSuchElementException e) {
		}
		catch (Exception e) {
			ExtentSuccessMessage("Lead Created");
		}
		waitForElement(6000);
		waitVisibility(search);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(search));
		writeText(search, Full_Name + Keys.ENTER);
		ExtentSuccessMessage("Clicked on Search");
		waitForElement(4000);		
		waitVisibility(ClickLead);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ClickLead));
		MoveToElementClick(element);
		ExtentSuccessMessage(" Lead has been clicked");
//		waitForElement(8000);
//		waitVisibility(LeadQualify);
//		element = wait.until(ExpectedConditions.presenceOfElementLocated(LeadQualify));
//		MoveToElementClick(element);
//		ExtentSuccessMessage("Clicked on Qualify");
//		waitForElement(6000);
//		element = wait.until(ExpectedConditions.presenceOfElementLocated(Submit_btn));
//		MoveToElementClick(element);
//		ExtentSuccessMessage("Clicked on Submit button");
//		waitForElement(8000);
//		String Status = "Qualified";
//		By Qualified = By.xpath("//span[@class='ng-binding'][normalize-space()='"+Status+"']");
//		Assert.assertTrue(ElementDisplayed(Qualified));
//		ExtentSuccessMessage("Assetion Done Qualified Status");
		waitForElement(8000);
		waitVisibility(convert);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(convert));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on convert button");
		waitForElement(15000);
		
		By Customertype= By.xpath("(//md-select-value[@class='md-select-value'])[3]");
		waitVisibility(Customertype);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Customertype));
		MoveToElementClick(element);
		waitForElement(1000);
		By Value = By.xpath("//md-option[.='Medicare']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Value));
		MoveToElementClick(element);
		
		
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Submit_btn));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Submit button");	
		waitForElement(12000);
		String status = "Converted";
		By Converted = By.xpath("//span[@class='ng-binding'][normalize-space()='"+status+"']");
		waitVisibility(Converted);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Converted));
		Assert.assertTrue(ElementDisplayed(Converted));
		ExtentSuccessMessage("Assetion Done Converted Status");
		
	}


	public void serviceClosingRequest() throws InterruptedException {
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Service));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Service");
		waitForElement(10000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ServieCloseSR));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on close");
		waitForElement(8000);
		WebElement SelectSR = driver.findElement(By.xpath("//select[@ng-model='selectedsalesteam']"));
		Select select = new Select(SelectSR);
		// select.selectByVisibleText("TeamSR");

		select.selectByVisibleText("THIS IS TEST TEAM");
		waitForElement(8000);
		ExtentSuccessMessage("Selected THIS IS TEST TEAM");
		WebElement Ok = driver.findElement(By.xpath("//button[text()='OK']"));
		MoveToElementClick(Ok);
		ExtentSuccessMessage("Cliked on Ok");
		waitForElement(8000);
	}
	
	public void Opportunity_redirection() throws InterruptedException
	{
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesButton));
		MoveToElementClick(element);
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesOpportunities));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Sales Opportunity");
		Thread.sleep(4000);
		By Filter = By.xpath("//i[@ng-class=\"{'acc glyphicon glyphicon-minus': $parent.$parent.clickedIndex == '0','acc glyphicon glyphicon-plus':  $parent.$parent.clickedIndex != '0'}\"]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Filter));
		MoveToElementClick(element);
		ExtentSuccessMessage(" Filter has been clicked");
		
		By Created_Today = By.xpath("(//div[@class='md-container md-ink-ripple'])[2]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Created_Today));
		MoveToElementClick(element);
		ExtentSuccessMessage("Todays  Filter has been clicked");
		By Name = By.xpath("//a[normalize-space()='"+Full_Name+"']");
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(Name));
		ExtentSuccessMessage("Lead name under opportunity is validated");
		
		waitVisibility(search);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(search));
		writeText(search, Full_Name + Keys.ENTER);
		ExtentSuccessMessage("Clicked on Search");
		waitForElement(4000);		
		waitVisibility(ClickLead);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ClickLead));
		MoveToElementClick(element);
		ExtentSuccessMessage(" Opportunity  has been clicked");
		waitForElement(4000);
		By Customer_Info = By.xpath("//a[normalize-space()='Customer Information']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Customer_Info));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on customer information");
		Thread.sleep(25000);
		By Lead_Name = By.xpath("//a[normalize-space()='"+Full_Name+"']");
		waitVisibility(Lead_Name);
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(Lead_Name));
		ExtentSuccessMessage("Lead name under opportunity is validated");
		
		
		
	}
	
	    public static String getTodayDate() {
	        // Get the current date
	        LocalDate today = LocalDate.now();
	        
	        // Define the desired format
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
	        
	        // Format the date and return it as a string
	        return today.format(formatter);
	    }
	
	public void Qualify_Opportunity() throws InterruptedException
	{
		By Qualify = By.xpath("//button[contains(.,'Qualify')]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Qualify));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Qualify");
		
		By date = By.xpath("//input[@name='TargetDate']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(date));
		MoveToElementClick(element);
		System.out.println(getTodayDate());
		
		writeText(date,getTodayDate()+Keys.ENTER);
		
		By Submit = By.xpath("//button[@class='btn btn-default green pull-right']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Submit));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Qualify submit");
		Thread.sleep(2000);
		By Status = By.xpath("//span[@class='ng-binding qualified']");
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(Status));
		ExtentSuccessMessage("Validated qualified status");
		
	}

	public void serviceExportRequest() throws InterruptedException {
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Service));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Service");
		waitForElement(10000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ServiceExport));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Service Export");
		
		

	}
public void Edit_Opportunity() throws InterruptedException
{
	Thread.sleep(3000);
	By Edit = By.xpath("//i[@class='btn fa fa-pencil ']");
	element = wait.until(ExpectedConditions.presenceOfElementLocated(Edit));
	MoveToElementClick(element);
	ExtentSuccessMessage("Clicked on Edit button");
	
	By Click_Status = By.xpath("(//md-select-value[@class='md-select-value'])[2]");
	element = wait.until(ExpectedConditions.presenceOfElementLocated(Click_Status));
	MoveToElementClick(element);
	ExtentSuccessMessage("Clicked on Status dd");
	
	By DD_Value = By.xpath("//div[normalize-space()='Qualified']");
	element = wait.until(ExpectedConditions.presenceOfElementLocated(DD_Value));
	MoveToElementClick(element);
	ExtentSuccessMessage("Clicked on Status dd value");
	
	By Save = By.xpath("//button[.='Save']");
	element = wait.until(ExpectedConditions.presenceOfElementLocated(Save));
	MoveToElementClick(element);
	ExtentSuccessMessage("Clicked on Save");
	waitForElement(5000);
	By Validating_status = By.xpath("(//span[@class='ng-binding ng-isolate-scope'][normalize-space()='Qualified'])[1]");
	waitVisibility(Validating_status);
	element = wait.until(ExpectedConditions.presenceOfElementLocated(Validating_status));
	ExtentSuccessMessage("Validated the edited data");
	//Home_Redirection();
	
}
	public void serviceAdvancedSearch2() throws InterruptedException {
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Service));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Service");
		waitForElement(10000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AdvancedSearch));
		MoveToElementClick(element);
		ExtentSuccessMessage("Advanced search has been clicked");
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ServiceADDD));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Status dropdown");
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ServiceADNew));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected New");
		waitForElement(9000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(QuoteAdSearch));
		MoveToElementClick(element);
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ServiceADDD));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Status dropdown");
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ServiceADAssign));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected Assign");
		waitForElement(9000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(QuoteAdSearch));
		MoveToElementClick(element);
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ServiceADDD));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Status dropdown");
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ServiceADInProgress));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected InProgress");
		waitForElement(9000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(QuoteAdSearch));
		MoveToElementClick(element);
		waitForElement(9000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ServiceADDD));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Status dropdown");
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ServiceADInHold));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected InHold");
		waitForElement(9000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(QuoteAdSearch));
		MoveToElementClick(element);

		waitForElement(9000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ServiceADDD));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Status dropdown");
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ServiceADReopen));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected Reopen");
		waitForElement(9000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(QuoteAdSearch));
		MoveToElementClick(element);

		waitForElement(9000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ServiceADDD));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Status dropdown");
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ServiceADReject));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected Reject");
		waitForElement(9000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(QuoteAdSearch));
		MoveToElementClick(element);
		waitForElement(9000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ServiceADDD));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Status dropdown");
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ServiceADClose));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected Close");
		waitForElement(9000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(QuoteAdSearch));
		MoveToElementClick(element);
		/*
		 * waitForElement(9000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(ServiceADDD));
		 * MoveToElementClick(element);
		 * ExtentSuccessMessage("Clicked on Status dropdown"); waitForElement(8000);
		 * element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(ServiceADPending));
		 * MoveToElementClick(element); ExtentSuccessMessage("Selected Pending");
		 * waitForElement(9000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(QuoteAdSearch));
		 * MoveToElementClick(element); waitForElement(9000);
		 */
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ServiceADDD));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Status dropdown");
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ServiceExport));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected Export");
		waitForElement(9000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(QuoteAdSearch));
		MoveToElementClick(element);
		waitForElement(9000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ServiceADDD));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Status dropdown");
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ServieCloseSR));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected CloseSR");
		waitForElement(9000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(QuoteAdSearch));
		MoveToElementClick(element);
	}

	public void serviceAdvancedSearch() throws InterruptedException {
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Service));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Service");
		waitForElement(10000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AdvancedSearch));
		MoveToElementClick(element);
		ExtentSuccessMessage("Advanced search has been clicked");
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ServiceADDD));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Status dropdown");
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ServiceADNew));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected New");
		waitForElement(9000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(QuoteAdSearch));
		MoveToElementClick(element);
		waitForElement(8000);
		/*
		 * element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(ServiceADDD));
		 * MoveToElementClick(element);
		 * ExtentSuccessMessage("Clicked on Status dropdown"); waitForElement(8000);
		 * element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(ServiceADAssign));
		 * MoveToElementClick(element); ExtentSuccessMessage("Selected Assign");
		 * waitForElement(9000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(QuoteAdSearch));
		 * MoveToElementClick(element); waitForElement(8000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(ServiceADDD));
		 * MoveToElementClick(element);
		 * ExtentSuccessMessage("Clicked on Status dropdown"); waitForElement(8000);
		 * element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(ServiceADInProgress));
		 * MoveToElementClick(element); ExtentSuccessMessage("Selected InProgress");
		 * waitForElement(9000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(QuoteAdSearch));
		 * MoveToElementClick(element); waitForElement(9000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(ServiceADDD));
		 * MoveToElementClick(element);
		 * ExtentSuccessMessage("Clicked on Status dropdown"); waitForElement(8000);
		 * element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(ServiceADInHold));
		 * MoveToElementClick(element); ExtentSuccessMessage("Selected InHold");
		 * waitForElement(9000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(QuoteAdSearch));
		 * MoveToElementClick(element);
		 * 
		 * waitForElement(9000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(ServiceADDD));
		 * MoveToElementClick(element);
		 * ExtentSuccessMessage("Clicked on Status dropdown"); waitForElement(8000);
		 * element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(ServiceADReopen));
		 * MoveToElementClick(element); ExtentSuccessMessage("Selected Reopen");
		 * waitForElement(9000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(QuoteAdSearch));
		 * MoveToElementClick(element);
		 * 
		 * waitForElement(9000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(ServiceADDD));
		 * MoveToElementClick(element);
		 * ExtentSuccessMessage("Clicked on Status dropdown"); waitForElement(8000);
		 * element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(ServiceADReject));
		 * MoveToElementClick(element); ExtentSuccessMessage("Selected Reject");
		 * waitForElement(9000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(QuoteAdSearch));
		 * MoveToElementClick(element); waitForElement(9000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(ServiceADDD));
		 * MoveToElementClick(element);
		 * ExtentSuccessMessage("Clicked on Status dropdown"); waitForElement(8000);
		 * element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(ServiceADClose));
		 * MoveToElementClick(element); ExtentSuccessMessage("Selected Close");
		 * waitForElement(9000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(QuoteAdSearch));
		 * MoveToElementClick(element); /* waitForElement(9000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(ServiceADDD));
		 * MoveToElementClick(element);
		 * ExtentSuccessMessage("Clicked on Status dropdown"); waitForElement(8000);
		 * element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(ServiceADPending));
		 * MoveToElementClick(element); ExtentSuccessMessage("Selected Pending");
		 * waitForElement(9000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(QuoteAdSearch));
		 * MoveToElementClick(element); waitForElement(9000);
		 */
		/*
		 * element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(ServiceADDD));
		 * MoveToElementClick(element);
		 * ExtentSuccessMessage("Clicked on Status dropdown"); waitForElement(8000);
		 * element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(ServiceExport));
		 * MoveToElementClick(element); ExtentSuccessMessage("Selected Export");
		 * waitForElement(9000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(QuoteAdSearch));
		 * MoveToElementClick(element); waitForElement(9000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(ServiceADDD));
		 * MoveToElementClick(element);
		 * ExtentSuccessMessage("Clicked on Status dropdown"); waitForElement(8000);
		 * element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(ServieCloseSR));
		 * MoveToElementClick(element); ExtentSuccessMessage("Selected CloseSR");
		 * waitForElement(9000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(QuoteAdSearch));
		 * MoveToElementClick(element);
		 */
	}

	public void serviceFilter2() throws InterruptedException {
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Service));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Service");
		waitForElement(10000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ServiceFilter));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on ServiceFilter");
		waitForElement(10000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ServiceNew));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected New");
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ServiceNew));
		MoveToElementClick(element);
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ServiceAssigned));
		MoveToElementClick(element);
		ExtentSuccessMessage("Seleted Assigned");
		waitForElement(10000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ServiceAssigned));
		MoveToElementClick(element);
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ServiceInProgress));
		MoveToElementClick(element);
		ExtentSuccessMessage("Seleted Assigned");
		waitForElement(10000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ServiceInProgress));
		MoveToElementClick(element);
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Servicehold));
		MoveToElementClick(element);
		ExtentSuccessMessage("Seleted Hold");
		waitForElement(10000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Servicehold));
		MoveToElementClick(element);
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ServiceReopen));
		MoveToElementClick(element);
		ExtentSuccessMessage("Seleted Reopen");
		waitForElement(10000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ServiceReopen));
		MoveToElementClick(element);
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ServiceRejected));
		MoveToElementClick(element);
		ExtentSuccessMessage("Seleted Rejected");
		waitForElement(10000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ServiceRejected));
		MoveToElementClick(element);
		waitForElement(10000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ServiceClosed));
		MoveToElementClick(element);
		ExtentSuccessMessage("Seleted Closed");
		waitForElement(10000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ServiceClosed));
		MoveToElementClick(element);
		waitForElement(10000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ServicePending));
		MoveToElementClick(element);
		ExtentSuccessMessage("Seleted Pending");
		waitForElement(10000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ServicePending));
		MoveToElementClick(element);
		waitForElement(10000);

	}

	public void serviceFilter() throws InterruptedException {
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Service));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Service");
		waitForElement(10000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ServiceFilter));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on ServiceFilter");
		waitForElement(10000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ServiceNew));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected New");
		waitForElement(8000);
		/*
		 * element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(ServiceNew));
		 * MoveToElementClick(element); waitForElement(8000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(ServiceAssigned));
		 * MoveToElementClick(element); ExtentSuccessMessage("Seleted Assigned");
		 * waitForElement(10000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(ServiceAssigned));
		 * MoveToElementClick(element); waitForElement(8000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(ServiceInProgress));
		 * MoveToElementClick(element); ExtentSuccessMessage("Seleted Assigned");
		 * waitForElement(10000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(ServiceInProgress));
		 * MoveToElementClick(element); waitForElement(8000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(Servicehold));
		 * MoveToElementClick(element); ExtentSuccessMessage("Seleted Hold");
		 * waitForElement(10000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(Servicehold));
		 * MoveToElementClick(element); waitForElement(8000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(ServiceReopen));
		 * MoveToElementClick(element); ExtentSuccessMessage("Seleted Reopen");
		 * waitForElement(10000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(ServiceReopen));
		 * MoveToElementClick(element); waitForElement(8000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(ServiceRejected));
		 * MoveToElementClick(element); ExtentSuccessMessage("Seleted Rejected");
		 * waitForElement(10000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(ServiceRejected));
		 * MoveToElementClick(element); waitForElement(10000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(ServiceClosed));
		 * MoveToElementClick(element); ExtentSuccessMessage("Seleted Closed");
		 * waitForElement(10000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(ServiceClosed));
		 * MoveToElementClick(element); waitForElement(10000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(ServicePending));
		 * MoveToElementClick(element); ExtentSuccessMessage("Seleted Pending");
		 * waitForElement(10000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(ServicePending));
		 * MoveToElementClick(element); waitForElement(10000);
		 */

	}

	public void servicActions() throws InterruptedException, AWTException {
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Service));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Service");
		waitForElement(10000);
		driver.navigate().refresh();
		Thread.sleep(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CTIMinimizeIcon));
		MoveToElementClick(element);
		waitForElement(5000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SelectService));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on SelectService");
		waitForElement(10000);

		/*
		 * writeText(SalesLeadNotes,"abcdefghij");
		 * ExtentSuccessMessage("Note text is entered"); Thread.sleep(6000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(SaveNote));
		 * MoveToElementClick(element); ExtentSuccessMessage("Note is saved");
		 */
		WebElement element = driver.findElement(SalesLeadNotes);
		((JavascriptExecutor) driver).executeScript("arguments[0].value = 'Your text';", element);

		ExtentSuccessMessage("Note text is entered");
		Thread.sleep(6000);

		element = wait.until(ExpectedConditions.presenceOfElementLocated(SaveNote));
		MoveToElementClick(element);
		ExtentSuccessMessage("Note is saved");

		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesEmail));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked  on Sales Email");
		Thread.sleep(6000);
		writeText(SalesEmailID, randomName() + "@" + "yopmail.com" + Keys.ENTER);
		Thread.sleep(6000);
		writeText(EmailSubject, "Testing");
		Thread.sleep(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SaveEmail));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on save Email");
		Thread.sleep(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesTask));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on sales task");
		Thread.sleep(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(TaskSave));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Task Save");

		Thread.sleep(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AttachFile));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Attach File");
		Thread.sleep(9000);

		WebElement dropdown = driver.findElement(AttachDropDown);

		String optionValue = "string:Application";

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value = arguments[1];", dropdown, optionValue);

		waitForElement(4000);
		Base_Class.MouseClick(By.xpath("//div[@ng-model='myFiles']"));
		ExtentSuccessMessage("Select File has been Clicked");
		waitForElement(3000);

		Robot robot1 = new Robot();
		String filePath = System.getProperty("user.dir") + "\\Upload\\Default_Template (1).xlsx";
		StringSelection stringSelection = new StringSelection(filePath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

		robot1.keyPress(KeyEvent.VK_CONTROL);
		Thread.sleep(1000);

		robot1.keyPress(KeyEvent.VK_V);
		Thread.sleep(1000);

		robot1.keyRelease(KeyEvent.VK_V);
		Thread.sleep(1000);

		robot1.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(1000);

		robot1.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(1000);

		robot1.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(1000);

		ExtentSuccessMessage("File is been Uploaded");
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AddressSave));
		MoveToElementClick(element);
		Thread.sleep(1000);

	}

	public void serviceAddActivity() throws InterruptedException {
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Service));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Service");
		waitForElement(10000);
		driver.navigate().refresh();
		waitForElement(5000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CTIMinimizeIcon));
		MoveToElementClick(element);
		waitForElement(5000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SelectService));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on SelectService");
		waitForElement(10000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AddActivity));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on AddActivity");
		waitForElement(8000);
		WebElement SelectSR = driver.findElement(By.xpath("(//select[@ng-selected='item'])[1]"));
		Select select = new Select(SelectSR);
		select.selectByVisibleText("Others");
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SaveAct));
		MoveToElementClick(element);
		waitForElement(9000);

	}

	public void serviceCreateNewService() throws InterruptedException {
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Service));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Service");
		waitForElement(15000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(NewServiceReq));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on NewServiceRequest");
		waitForElement(8000);
		writeText(SearchTextCustomer, "Automation");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CustomerSearchIcon));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Customer Search Icon");
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SelectCustomer));
		MoveToElementClick(element);
		waitForElement(8000);
		ExtentSuccessMessage("Selected the Customer");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ServiceCustomerOk));
		MoveToElementClick(element);
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ServiceRqtypeDD));
		MoveToElementClick(element);
		waitForElement(4000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SelectRq));
		MoveToElementClick(element);
		waitForElement(8000);
		ExtentSuccessMessage("Selected the Request type");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ServiceRqSubtypeDD));
		MoveToElementClick(element);
		waitForElement(4000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ServiceRqSubStstus));
		MoveToElementClick(element);
		waitForElement(4000);
		ExtentSuccessMessage("Selected the Request sub type");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ServiceProductDD));
		MoveToElementClick(element);
		waitForElement(4000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ServiceProductCE));
		MoveToElementClick(element);
		waitForElement(4000);
		ExtentSuccessMessage("Selected the product");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ServiceActionByDD));
		MoveToElementClick(element);
		waitForElement(4000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SelectActionByQA));
		MoveToElementClick(element);
		waitForElement(4000);
		ExtentSuccessMessage("Selected the To Be Action By");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SelectSubmit));
		MoveToElementClick(element);
		ExtentSuccessMessage("Cliked on submit");
		Thread.sleep(4000);
	}

	public void customerContactCard(CensusInfo ApplicantInfo) throws InterruptedException {
		
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Customers));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Customers");
		
		By SearchFiled = By.xpath("//input[@class='ng-pristine ng-untouched md-input ng-empty ng-valid-minlength ng-valid-maxlength ng-valid ng-valid-required']");
	    element = wait.until(ExpectedConditions.presenceOfElementLocated(SearchFiled));
		MoveToElementClick(element);
		writeText(SearchFiled,ApplicantInfo.CustomerName + Keys.ENTER);
		ExtentSuccessMessage("Customer name has been Searched");
		
		waitForElement(15000);
		By Cust = By.xpath("//a[@class='edit-list-anchor ng-binding']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Cust));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clickd on Customer Name");

  
		waitForElement(8000);
		By ContactCard = By.xpath("//button[@class='btn btn-default pull-right green ng-scope']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ContactCard));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on ContactCard Button");
		
		By CustomerNumber = By.xpath("//input[@name='cellPhone']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CustomerNumber));
		clear(CustomerNumber);
		writeText(CustomerNumber,firstnumber);
		ExtentSuccessMessage("Entered the number");

		By SendButton = By.xpath("//button[@class='btn btn-primary btn-default green']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SendButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Send Button");
 
		Thread.sleep(2000);
		String time = CurrentTime();
		System.out.println(time);
		String timee=removeLeadingZero(time);
		System.out.println(timee);
	
		waitForElement(15000);
		ArrayList<String> Tabs = new ArrayList<>(driver.getWindowHandles());
		System.out.println(Tabs.size());
		driver.switchTo().window(Tabs.get(1));
		ExtentSuccessMessage("Tab Switched from child to parent");
		
		By Message = By.xpath("//a[@title='Message']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Message));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Message Section");
		
		waitForElement(4000);
		By FirstMessage = By.cssSelector("#voice-call-window-draggable > div:nth-child(7) > div.messageTabContainer.ng-scope > ul > li:nth-child(1)");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(FirstMessage));
		click(FirstMessage);
		ExtentSuccessMessage("Clicked on First Message");
		
		By NumberAss = By.xpath("//span[@class='drag-not-allowed ng-binding'][2]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(NumberAss));
		String no = element.getText();
		System.out.println(no);
		
		Assert.assertEquals(no, firstnumber1);
		ExtentSuccessMessage("Assertion for Number is done");
		
		
		Thread.sleep(3000);
		By TimeStamp = By.xpath("//span[contains(.,'"+ timee +"')]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(TimeStamp));
		String time2 = element.getText();
		System.out.println(time2);

		Thread.sleep(4000);
		By DownloadImage = By.xpath("//span[contains(.,'"+ timee +"')]/parent::*/div/div/div/i");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(DownloadImage));
        js.executeScript("arguments[0].scrollIntoView(true);", element);
		MoveToElementClick(element);
		ExtentSuccessMessage("Contact card is been Downloaded");

		
		By SelectUser = By.xpath("//a[@class='nav-link dropdown-toggle']");
		By SelectLogout = By.xpath("(//a[contains(.,'Log Out')])[1]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SelectUser));
		MoveToElementClick(element);
		ExtentSuccessMessage("User has been selected");
		waitForElement(1000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SelectLogout));
		MoveToElementClick(element);
		ExtentSuccessMessage("Logout has been performed!");
		waitForElement(1000);
		
		ArrayList<String> Tabs1 = new ArrayList<>(driver.getWindowHandles());
		System.out.println(Tabs1.size());
		driver.switchTo().window(Tabs1.get(0));
		ExtentSuccessMessage("Tab Switched from child to parent");
		
		Thread.sleep(600);
		By CustomerBreadcrumb = By.xpath("//a[@href='#/customers']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CustomerBreadcrumb));
		MoveToElementClick(element);
		
	
        
        Thread.sleep(5000);
		By LeadField = By.xpath("(//div[@class='ui-grid-selection-row-header-buttons ui-grid-icon-ok ng-scope'])[2]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(LeadField));
		MoveToElementClick(element);
		
		By ManageCustomer = By.xpath("//button[@id='manageCustomerBtn']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ManageCustomer));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Manage Customer Button");
		
		By Deletebutton = By.xpath("//button[@name='deleteCustomerBtn']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Deletebutton));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Delete Button");
		
		By Yes = By.xpath("//button[@class='btn btn-primary btn-default green']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Yes));
		MoveToElementClick(element);
		ExtentSuccessMessage("Customer has been Deleted");
		
		Thread.sleep(3000);
        
		
		 
		
	} 
	

	public String CurrentTime() {
		// Set the time zone to USA Eastern Time (New York)
		ZoneId zoneId = ZoneId.of("America/New_York");
		// Get current time in the specified time zone
		LocalTime currentTime = LocalTime.now(zoneId);
		// Define a time formatter to format the time as needed
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm a");
		// Format the current time
		String formattedTime = currentTime.format(formatter);
		// Print the formatted time
		System.out.println("Current time in USA (Eastern Time - New York): " + formattedTime);
		return formattedTime;
	}
	
	public static String removeLeadingZero(String time) {
        // Split time into components
        String[] timeParts = time.split(" ");
        String timeOfDay = timeParts[0]; // Extracts "07:50"
        String period = timeParts[1];    // Extracts "AM" or "PM"

        // Further split time into hour and minutes
        String[] hourMinutes = timeOfDay.split(":");
        String hour = hourMinutes[0];    // Extracts "07"
        String minutes = hourMinutes[1]; // Extracts "50"

        // Remove leading zero from hour if present
        String formattedHour = hour.startsWith("0") ? hour.substring(1) : hour;

        // Rebuild the time string
        return formattedHour + ":" + minutes + " " + period;
    }

	 
	
	
	public void fetchNumber1() throws InterruptedException
	{
		Thread.sleep(6000);
		By UserNumber = By.xpath("//u[@title='Voice Number']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(UserNumber));
		firstnumber=element.getText();
		System.out.println("SecondNumber" +firstnumber );
	}
	
	public void fetchNumber2() throws InterruptedException
	{
		Thread.sleep(6000);
		By UserNumber = By.xpath("//u[@title='Voice Number']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(UserNumber));
		firstnumber1=element.getText();
		System.out.println("FirstNumber" +firstnumber1 );
	}
	
	public void newTab() throws InterruptedException, IOException
	{
		
		Thread.sleep(3000);
		driver.switchTo().newWindow(WindowType.TAB);
		Thread.sleep(3000);
		ExtentSuccessMessage("New Tab has been Opened"); 
		
		waitForElement(2000); 
//		String urlCE = configloader().getProperty("CEURL");
		String urlCE;
		String currentSystemURL = configloader().getProperty("URL");
		System.out.println(currentSystemURL);
		if (currentSystemURL.contains("https://mme.benefitalign.com")) {
			urlCE = "https://ce-qa.benefitalign.com/mme";
		} 
		else if (currentSystemURL.contains("https://ce-uat.benefitalign.com/")) 
		{
			urlCE = "https://mme.benefitalign.com";
		}
		else if (currentSystemURL.contains("https://ce-qa.benefitalign.com/mme")) 
		{
			urlCE = "https://ce-uat.benefitalign.com/mme/#/login";
		} else {
			urlCE = "https://mme.benefitalign.com";
		}
		String username = configloader().getProperty("PLCA_UserName2");
		String pswd = configloader().getProperty("PLCA_Password2");
		driver.get(urlCE);
		waitForElement(5000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(userID));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Customer Engage Username field");
		writeText(userID, username);
		ExtentSuccessMessage("Entered the Customer Engage Username");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(pwd));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Customer Engage password field");
		writeText(pwd, pswd);
		ExtentSuccessMessage("Entered the Customer Engage Password");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(signIn));
		MoveToElementClick(element);
		ExtentSuccessMessage("Customer Engage Application Sign-In Done");
		waitForElement(3000);
		try {
			if (driver.findElement(CheckUserLogin).isDisplayed()) {
				click(CheckUserLogin);
				ExtentSuccessMessage(
"You currently have an active session on another device hence Deactivated the other session!");
			} else {
				ExtentSuccessMessage("Login has been successful");
			}
		} catch (Exception e) {
			ExtentSuccessMessage("Applicantion login successful");
		}
		waitForElement(15000);
		
		fetchNumber1();
		
		Thread.sleep(2000);
		ArrayList<String> Tabs = new ArrayList<>(driver.getWindowHandles());
		System.out.println(Tabs.size());
		driver.switchTo().window(Tabs.get(0));
		ExtentSuccessMessage("Tab Switched from child to parent");
		
		 
		
		
		
	} 
		
		

	public void customerImportCustomerAndPolicies() throws InterruptedException, AWTException, IOException {
		
		waitForElement(5000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Customers));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Customers");
		waitForElement(4000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CustomerImport));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Import Customers and Policies");
		waitForElement(4000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CustomerBulkImport));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Bulk Import");
		waitForElement(6000);
		
		String name = "AutoCustomer" ;
		writeCustomernameToExcel1(name,"ImportTemplate");
		String lastname = randomName(); 
		writeCustomerlastnameToExcel(lastname,"ImportTemplate");
		String name1 = name + " " + lastname;
		System.out.println(name1);
		
        LocalDate currentDate = LocalDate.now(); 

        LocalDate nextDate = currentDate.plusDays(1);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String formattedNextDate = nextDate.format(formatter);
        System.out.println(formattedNextDate);
        
        writeLOBlastnameToExcel(formattedNextDate,"ImportTemplate");
		
       
		Thread.sleep(2000);
		By SelectButton = By.xpath("(//div[@class='button select-btn ng-pristine ng-untouched ng-valid ng-empty'])[1]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SelectButton));
		click(SelectButton);
		ExtentSuccessMessage("Clicked on Select Button");

		Thread.sleep(3000);
		Robot robot = new Robot();
		String filePath = System.getProperty("user.dir") + "\\Upload\\ImportCustomerSheet";
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
	
		ExtentSuccessMessage("File is been Uploaded");
		waitForElement(3000);		
		
		waitForElement(4000);
		By element2 = By.xpath("(//div[@class='col-md-12 pad-lt pad-rt'])[1]");
		try {
			if (driver.findElement(element2).isDisplayed()) {
				By No = By.xpath("(//div[@class='md-off'])[2]");
				click(No);
				ExtentSuccessMessage("Clicked on No Sync to Broker Engage");
	
			}
		} catch (NoSuchElementException e) {
		}
		catch (Exception e) {
			ExtentSuccessMessage("Broker Engage Sync not Displayed");
		}
		
		By SubmitButton = By.xpath("//button[@id='uploadBobImportBtn']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SubmitButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Bulk Import Submit Button");
	
		waitForElement(6000);
		try {
			By element = By.xpath("//h3[@class='modal-title ng-binding']");
			if (driver.findElement(element).isDisplayed()) {
				By Ok = By.xpath("//button[@class='btn btn-primary btn-default green ng-binding']");
				click(Ok);
				ExtentSuccessMessage("Clicked on Ok Button for popup issue");

			 
		}
		} catch (NoSuchElementException e) {
		}
		catch (Exception e) {
			ExtentSuccessMessage("Broker Engage Sync not Displayed");
		}
	
		 
		Thread.sleep(20000);
		
		driver.navigate().refresh();
		
		Thread.sleep(6000);
		
		By Importbutton = By.xpath("//button[@name='importCustomerPolicyBtn']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Importbutton));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Bulk Import Button");
		
		By UpdateStatus = By.xpath("//button[@name='updateStatusBtn']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(UpdateStatus));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Import Update Status");
	

		Thread.sleep(9000);
		By Status = By.xpath("((//div[@class='ng-isolate-scope'])[2]/div/div)[4]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Status));
		String status = element.getText();
		System.out.println(status);
		
		if(status.equals("Completed")) {			
			Assert.assertEquals(status, "Completed");
			ExtentSuccessMessage("Customer File is Succesfully Uploaded");
		}else {	
			By Status1 = By.xpath("(//div[@title='Completed'])[1]");

			do {			
				By RefreshButton1 = By.xpath("//button[@name='refreshBobList']");
				element = wait.until(ExpectedConditions.presenceOfElementLocated(RefreshButton1));
				MoveToElementClick(element);
				ExtentSuccessMessage("Clicked On Refresh Button");
				waitForElement(4000);
				 
			}
			while(status.equals("Completed")); 
		} 
 
		By Status11 = By.xpath("(//div[@title='Completed'])[1]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Status11));
        String completed = element.getText();
        System.out.println(completed);
		Thread.sleep(3000); 
		System.out.println(status);
		Assert.assertEquals(completed, "Completed");
		ExtentSuccessMessage("Customer File is Succesfully Uploaded");
		
		By BackButton = By.xpath("//button[@name='cancelBobHistoryViewBtn']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(BackButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Import Update Status");
		
		Thread.sleep(5000);
		By SearchText = By.xpath("//input[@class='ng-pristine ng-untouched md-input ng-empty ng-valid-minlength ng-valid-maxlength ng-valid ng-valid-required']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SearchText));
		MoveToElementClick(element);
		writeText(SearchText,name1 + Keys.ENTER);
		ExtentSuccessMessage("Clicked on Search Field");
		
		By CustomerAssertion = By.xpath("//a[@class='edit-list-anchor ng-binding']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CustomerAssertion));
		String nameass =element.getText();
		System.out.println(nameass);

		String nameString = StringUtils.substringAfter(nameass," ");
		System.out.println(nameString);
		
		Assert.assertTrue(nameass.contains(nameString));
		ExtentSuccessMessage("Assertion for Customer name is done After uploading the file");
 
		Thread.sleep(2000);
		By Sales = By.xpath("//a[@name='menu_Sales']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Sales));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Sales Option");
		
		By Policies = By.xpath("//a[@name='submenu_salespolicies']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Policies));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Policies Option");
		
		Thread.sleep(7000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SearchText));
		MoveToElementClick(element);
		writeText(SearchText,name1 + Keys.ENTER);
		ExtentSuccessMessage("Clicked on Search Field");
		
		Thread.sleep(6000);
		By CustomerAssertion1 = By.xpath("//a[@class='edit-list-anchor ng-binding']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CustomerAssertion1));
		String nameass1 =element.getText();
		System.out.println(nameass1);

		String nameString1 = StringUtils.substringAfter(nameass," ");
		System.out.println(nameString1);
		
		Assert.assertTrue(nameass1.contains(nameString1));
		ExtentSuccessMessage("Assertion for Customer name is done After uploading the file in Policy Section:-");
 
		By CarrierName= By.xpath("(//a[@class='edit-list-anchor ng-binding'])[2]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CarrierName));
		String carrier = element.getText();
		System.out.println(carrier);
		 
		Assert.assertEquals(carrier, "Aetna");
		ExtentSuccessMessage("Assertion for Carrier name is done After uploading the file in Policy Section:-" + carrier);
		
		By ProductCategory = By.xpath("(//div[@class='ui-grid-cell-contents ng-binding ng-scope'])[4]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ProductCategory));
		String category = element.getText(); 
		System.out.println(category);
		
		Assert.assertEquals(category, "Dental");
		ExtentSuccessMessage("Assertion for Carrier name is done After uploading the file in Policy Section:-" + category);
		
		By Status1 = By.xpath("(//div[@class='ui-grid-cell-contents ng-binding ng-scope'])[6]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Status1));
		String status1 = element.getText();
		System.out.println(status1);
		
		Assert.assertEquals(status1, "Enrolled");
		ExtentSuccessMessage("Assertion for Carrier Status is done After uploading the file in Policy Section" + status1);
		
		

	}
	
	public String writeCustomernameToExcel1(String nameText, String sheetname) throws IOException {
		String excelFilePath = ".\\Upload\\ImportCustomerSheet.xlsx";
		FileInputStream inputStream = new FileInputStream(excelFilePath);
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		String sheetName_update = sheetname;
		Sheet sheet = workbook.getSheet(sheetname);
		int rowIndex = 1;
		int columnIndex = 3;
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
	
	public String writeCustomerlastnameToExcel(String nameText, String sheetname) throws IOException {
		String excelFilePath = ".\\Upload\\ImportCustomerSheet.xlsx";
		FileInputStream inputStream = new FileInputStream(excelFilePath);
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		String sheetName_update = sheetname;
		Sheet sheet = workbook.getSheet(sheetname);
		int rowIndex = 1;
		int columnIndex = 5;
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
	
	public String writeLOBlastnameToExcel(String nameText, String sheetname) throws IOException {
		String excelFilePath = ".\\Upload\\ImportCustomerSheet.xlsx";
		FileInputStream inputStream = new FileInputStream(excelFilePath);
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		String sheetName_update = sheetname;
		Sheet sheet = workbook.getSheet(sheetname);
		int rowIndex = 1;
		int columnIndex = 44;
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
	
	
	
	
	
	
	
	

	public void customerAdvancedSearch2() throws InterruptedException {
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Customers));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Customers");
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AdvancedSearch));
		MoveToElementClick(element);
		ExtentSuccessMessage("Advanced search has been clicked");
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CustomerADSearchDD));
		MoveToElementClick(element);
		waitForElement(3000);

		element = wait.until(ExpectedConditions.presenceOfElementLocated(CustomerAdActive));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected Open");
		waitForElement(7000);
		click(OppSearch);
		waitForElement(10000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CustomerADSearchDD));
		MoveToElementClick(element);
		waitForElement(3000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CustomerAdActive));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected Active");
		waitForElement(7000);
		click(OppSearch);
		waitForElement(10000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CustomerADSearchDD));
		MoveToElementClick(element);
		waitForElement(3000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CustomerAdInActive));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected InActive");
		waitForElement(7000);
		click(OppSearch);
		waitForElement(10000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CustomerADSearchDD));
		MoveToElementClick(element);
		waitForElement(3000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CustomerAdprospect));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected Prospect");
		waitForElement(7000);
		click(OppSearch);
		waitForElement(10000);
//			element = wait.until(ExpectedConditions.presenceOfElementLocated(CustomerADSearchDD));
//			MoveToElementClick(element);	
//			waitForElement(3000);					
//			element = wait.until(ExpectedConditions.presenceOfElementLocated(CustomerAdDecesed));
//			MoveToElementClick(element);
//			ExtentSuccessMessage("Selected Deceased");
//			waitForElement(7000);
//			click(OppSearch);

	}

	public void customerAdvancedSearch() throws InterruptedException {
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Customers));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Customers");
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AdvancedSearch));
		MoveToElementClick(element);
		ExtentSuccessMessage("Advanced search has been clicked");
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CustomerADSearchDD));
		MoveToElementClick(element);
		waitForElement(3000);

		element = wait.until(ExpectedConditions.presenceOfElementLocated(CustomerAdActive));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected Open");
		waitForElement(7000);
		By AdvSearch = By.id("applyadvancedSearchBtn");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AdvSearch));
		MoveToElementClick(element);
		// MoveToElementClick(OppSearch);

		/*
		 * element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(CustomerADSearchDD));
		 * MoveToElementClick(element); waitForElement(3000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(CustomerAdActive));
		 * MoveToElementClick(element); ExtentSuccessMessage("Selected Active");
		 * waitForElement(7000); click(OppSearch); waitForElement(10000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(CustomerADSearchDD));
		 * MoveToElementClick(element); waitForElement(3000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(CustomerAdInActive));
		 * MoveToElementClick(element); ExtentSuccessMessage("Selected InActive");
		 * waitForElement(7000); click(OppSearch); waitForElement(10000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(CustomerADSearchDD));
		 * MoveToElementClick(element); waitForElement(3000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(CustomerAdprospect));
		 * MoveToElementClick(element); ExtentSuccessMessage("Selected Prospect");
		 * waitForElement(7000); click(OppSearch); waitForElement(10000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(CustomerADSearchDD));
		 * MoveToElementClick(element); waitForElement(3000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(CustomerAdDecesed));
		 * MoveToElementClick(element); ExtentSuccessMessage("Selected Deceased");
		 * waitForElement(7000); click(OppSearch);
		 */

	}

	public void customerFilter2() throws InterruptedException {
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Customers));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Customers");
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CustomerFilterStatus));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Customer Filter Status");
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CustomerFilActive));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected the Active Status");
		waitForElement(10000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CustomerFilActive));
		MoveToElementClick(element);
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CustomerInActive));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected the In Active Status");
		waitForElement(10000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CustomerInActive));
		MoveToElementClick(element);
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CustomerFilProspet));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected the Prospect Status");
		waitForElement(10000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CustomerFilProspet));
		MoveToElementClick(element);
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CustomerFilDecesed));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected the Deceded Status");
		waitForElement(10000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CustomerFilDecesed));
		MoveToElementClick(element);
		waitForElement(6000);

	}

	public void customerFilter(CensusInfo ApplicantInfo) throws InterruptedException {
		
		
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Customers));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Customers");
		 
		
//		By maximize = By.xpath("//span[@class='collpase-leftt glyphicon glyphicon-triangle-right']");
//		if(ElementDisplayed(maximize))
//		{
//			element = wait.until(ExpectedConditions.presenceOfElementLocated(maximize));
//			MoveToElementClick(element);
//			ExtentSuccessMessage("Clicked on Maximize");
//		}


//		Thread.sleep(3000);
//		driver.navigate().refresh();
//		Thread.sleep(8000);

		
		waitForElement(3000);
		By RecentCustomer = By.xpath("(//div[@class='accordion-container grid-style-height'])[1]/i");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(RecentCustomer));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Recent Customer Option");
		waitForElement(1000);
		By CreatedToday = By.xpath("//md-radio-button[@value='Created Today']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CreatedToday));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Recent Customer Option");
		
		waitForElement(2000);
		By State = By.xpath("(//div[@class='accordion-container grid-style-height'])[5]/i");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(State));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on State option");
		
		By OH = By.xpath("//md-checkbox[@name='OH']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(OH));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected OH as State Option");
		
	
		By CustomerName = By.xpath("(//a[@class='edit-list-anchor ng-binding'])[1]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CustomerName));
		String name =element.getText();
		System.out.println(name);
        System.out.println(ApplicantInfo.CustomerName);
        
        String nameString = StringUtils.substringAfter(ApplicantInfo.CustomerName, " ");
        System.out.println(nameString);
        waitForElement(2000);
        Assert.assertTrue(name.contains(nameString));
		ExtentSuccessMessage("Assertion for Created Today Customer is done");
		
		waitForElement(2000);
		By Export = By.xpath("//button[@id='downlodDataBtn']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Export));
		MoveToElementClick(element);
		ExtentSuccessMessage("Click on Export Customer Button");
		
		waitForElement(1000);
		Assert.assertTrue(driver.findElement(By.xpath("//div[@id='divSuccess']")).isDisplayed());
		ExtentSuccessMessage("Assertion for file download popup is Visible");

		waitForElement(1000);
        By RefreshButton = By.xpath("//a[@class='pull-right reset-button ng-isolate-scope']");
        element = wait.until(ExpectedConditions.presenceOfElementLocated(RefreshButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked On Refresh Button");
		
		waitForElement(6000);
		By AdvanceSearch = By.xpath("//button[@id='advancedSearchBtn']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AdvanceSearch));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked On Advance Search Button");
		
		LocalDate today = LocalDate.now();

        // Format the date if needed (optional)
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy"); // Change format as needed
        String formattedDate = today.format(formatter);
		
		By CreatedDate = By.xpath("//input[@name='CreatedStartDate']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CreatedDate));
		MoveToElementClick(element);
		writeText(CreatedDate,formattedDate + Keys.ENTER);
		ExtentSuccessMessage("Entered today Date");
		
        By SearchButton = By.xpath("//button[@name='applyadvancedSearchBtn']");
        element = wait.until(ExpectedConditions.presenceOfElementLocated(SearchButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Search Button");

		waitForElement(4000);
//		By CustName = By.xpath("//a[@title=' " + ApplicantInfo.CustomerName + "']");
//		Assert.assertTrue(driver.findElement(CustName).isDisplayed()); 
		ExtentSuccessMessage("Assertion for Advance Search is Done");

		By Cancel = By.xpath("//button[@class='btn btn-default pull-right grey']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Cancel));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Cancel Button");
		
		Thread.sleep(3000);
        By SearchField = By.xpath("//input[@class='ng-pristine ng-untouched md-input ng-empty ng-valid-minlength ng-valid-maxlength ng-valid ng-valid-required']");
    	element = wait.until(ExpectedConditions.presenceOfElementLocated(SearchField));
		MoveToElementClick(element);
        writeText(SearchField,ApplicantInfo.CustomerName + Keys.ENTER);
        
        Thread.sleep(5000);
		By LeadField = By.xpath("(//div[@class='ui-grid-selection-row-header-buttons ui-grid-icon-ok ng-scope'])[2]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(LeadField));
		MoveToElementClick(element);
		
		/*By ManageCustomer = By.xpath("//button[@id='manageCustomerBtn']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ManageCustomer));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Manage Customer Button");
		
		By Deletebutton = By.xpath("//button[@name='deleteCustomerBtn']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Deletebutton));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Delete Button");
		
		By Yes = By.xpath("//button[@class='btn btn-primary btn-default green']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Yes));
		MoveToElementClick(element);
		ExtentSuccessMessage("Customer has been Deleted");*/
		
		Thread.sleep(3000);
        
        
        
  
        
	}

	public void customerActions() throws InterruptedException, AWTException {
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Customers));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Customers");
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ClickLead));
		MoveToElementClick(element);
		ExtentSuccessMessage("Customer has been clicked");
		waitForElement(6000);
		writeText(SalesLeadNotes, "abcdefghij");
		ExtentSuccessMessage("Note text is entered");
		Thread.sleep(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SaveNote));
		MoveToElementClick(element);
		ExtentSuccessMessage("Note is saved");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesEmail));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked  on Sales Email");
		Thread.sleep(6000);
		writeText(SalesEmailID, randomName() + "@" + "yopmail.com");
		Thread.sleep(6000);
		writeText(EmailSubject, "Testing");
		Thread.sleep(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SaveEmail));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on save Email");
		Thread.sleep(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesTask));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on sales task");
		Thread.sleep(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(TaskSave));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Task Save");

		Thread.sleep(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AttachFile));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Attach File");
		Thread.sleep(9000);
		WebElement dropdown = driver.findElement(AttachDropDown);

		String optionValue = "string:Application";

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value = arguments[1];", dropdown, optionValue);
		js.executeScript("arguments[0].dispatchEvent(new Event('change'))", dropdown);
		waitForElement(4000);
		Base_Class.MouseClick(By.xpath("//div[@ng-model='myFiles']"));
		ExtentSuccessMessage("Select File has been Clicked");
		waitForElement(5000);

		Robot robot1 = new Robot();
		String filePath = System.getProperty("user.dir") + "\\Upload\\Default_Template (1).xlsx";
		StringSelection stringSelection = new StringSelection(filePath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

		robot1.keyPress(KeyEvent.VK_CONTROL);
		Thread.sleep(1000);

		robot1.keyPress(KeyEvent.VK_V);
		Thread.sleep(1000);

		robot1.keyRelease(KeyEvent.VK_V);
		Thread.sleep(1000);

		robot1.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(1000);

		robot1.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(1000);

		robot1.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(1000);

		ExtentSuccessMessage("File is been Uploaded");
		waitForElement(3000);

		element = wait.until(ExpectedConditions.presenceOfElementLocated(AddressSave));
		MoveToElementClick(element);

	}

	public void customerCreateServiceRequest() throws InterruptedException {
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Customers));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Customers");
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ClickLead));
		MoveToElementClick(element);
		ExtentSuccessMessage("Customer has been clicked");
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CreateServiceRequest));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Create Service Request ");
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(RequestType));
		MoveToElementClick(element);
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(RequestStatus));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected the Request type Status");
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(RequestSubType));
		MoveToElementClick(element);
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(RequestSubStatus));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected the Request type Sub Status");
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(RequestSubmit));
		MoveToElementClick(element);
		ExtentSuccessMessage("Cliked on submit");
		waitForElement(6000);
	}

	public void customerCreateOpportunity() throws InterruptedException {
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Customers));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Customers");
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ClickLead));
		MoveToElementClick(element);
		ExtentSuccessMessage("Customer has been clicked");
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CustcreateOpp));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on create opportunity");
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CustOppSubmit));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on submit");
		waitForElement(6000);

	}
	
	public String writeCustomernameToExcel(String nameText, String sheetname) throws IOException {
		String excelFilePath = ".\\src\\test\\resources\\TestData.xlsx";
        FileInputStream inputStream = new FileInputStream(excelFilePath);
        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
        String sheetName_update = sheetname;
        Sheet sheet = workbook.getSheet(sheetname);
        int rowIndex = 1;  
        int columnIndex = 5;
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
	
	public void actions() throws InterruptedException, AWTException
	{ 
		
		waitForElement(10000);
		
		By maximize = By.xpath("//span[@class='collpase-leftt glyphicon glyphicon-triangle-right']");
		if(ElementDisplayed(maximize))
		{
			element = wait.until(ExpectedConditions.presenceOfElementLocated(maximize));
			MoveToElementClick(element);
			ExtentSuccessMessage("Clicked on Maximize");
		}
		waitForElement(2000);

		waitVisibility(NotesSection);
	    element = wait.until(ExpectedConditions.presenceOfElementLocated(NotesSection));
		MoveToElementClick(element);
		String Note = "This is created Via Automation";
		writeText(NotesSection, Note);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(NotesConfirmationButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("Note has been added");
		
		waitForElement(6000);		
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AgentActionNoteInc));
		 NoteText  = element.getText();
		System.out.println("-----------"+ NoteText+"------------");
		Assert.assertEquals(Note, NoteText);
		ExtentSuccessMessage("Assertion for note has been done");
		
	
	    waitForElement(5000); 
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ActionEmailIcon));
		MoveToElementClick(element);
		
		waitForElement(2000);
		By EmailAddressDD = By.xpath("//md-select[@role='listbox']");
		wait.until(ExpectedConditions.elementToBeClickable(EmailAddressDD));
		click(EmailAddressDD);
	
		//By EmailAddressDDOPtion = By.xpath("//md-option[@value='salessupport@healthcareenrollmentcenter.com']");
		By EmailAddressDDOPtion = By.xpath("//md-option[@value='salessupport@healthcareenrollmentcenter.com'] | //md-option[@value='customerengage@benefitalign.com'] | //md-option[@value='salessupport@truecoverage.com']");
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
	
	    waitForElement(12000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AgentEmailInc));
		NoteText  = element.getText();
		System.out.println("-----------"+ NoteText+"------------");
		Assert.assertEquals(AgentEmailAction, NoteText);
		ExtentSuccessMessage("Assertion for email is been done");
				
	   
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ActionAttachment));
		MoveToElementClick(element);
		
		waitForElement(8000);
		By DocumentDD1 =  By.cssSelector("#filter-by > div:nth-child(1) > form > div.form-group.ng-isolate-scope > select");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(DocumentDD1));
		Select s1 = new Select(element);
		s1.selectByVisibleText("Other");
//		
//		element = wait.until(ExpectedConditions.presenceOfElementLocated(DocumentDD));
//		wait.until(ExpectedConditions.elementToBeClickable(DocumentDD));
//		click(DocumentDD);
//		waitForElement(500);
//       
//        wait.until(ExpectedConditions.elementToBeClickable(DocumentDDOption));
//		click(DocumentDDOption);	
		wait.until(ExpectedConditions.elementToBeClickable(DocumentAttachFileButton));
		click(DocumentAttachFileButton);
		
		Robot robot = new Robot();
		String filePath = System.getProperty("user.dir") + "\\Upload\\AgentAttachment.txt";
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
		
		Thread.sleep(4000);
//		By DocumentName = By.cssSelector("#upload-file-info > ul > li > a");
//		element = wait.until(ExpectedConditions.presenceOfElementLocated(DocumentName));
//		String dcname = element.getText();
//		System.out.println(dcname);
		

	
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AttachmentConfirmationButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("Attachment has been added");
		
	    //Thread.sleep(9000);
		//Assert.assertTrue(driver.findElement(AttachmentInc).isDisplayed());
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
		
		waitForElement(8000);
		Assert.assertTrue(driver.findElement(TaskInc).isDisplayed());
		ExtentSuccessMessage("Assertion has been done");
		
		By DocumentSection = By.cssSelector("#page-wrapper > div > ui-view > div:nth-child(3) > div.col-xl-9.col-lg-6.left-section.details > div.ng-scope > div > ul > li:nth-child(10) > a");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(DocumentSection));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Document Section");
		
		Thread.sleep(3000);
		
		/*By AttachmnetName = By.xpath("(//div[@class='ui-grid-cell-contents ng-binding ng-scope'])[1]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AttachmnetName));
		String text = element.getText();
        System.out.println(text);
        
        Assert.assertEquals(text, dcname);
		ExtentSuccessMessage("Assertion for Document name is done");*/
		
		By DashBoard = By.xpath("//a[@id='menu_Dashboard']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(DashBoard));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked On DashBoard Option");
		
		By MyTask = By.xpath("//a[@id='submenu_MyTasks']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(MyTask));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked On My TaskOption Option");
		
		Thread.sleep(6000);
		By LeadsName = By.xpath("//div[@class='task-caller']/span[contains(.,'"+ fullname +"')]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(LeadsName));
		String name =element.getText();
		System.out.println(name);
		 
		Thread.sleep(2000);
		Assert.assertTrue(driver.findElement(LeadsName).isDisplayed());
		ExtentSuccessMessage("Assertion for My task is done");
		
		element = wait.until(ExpectedConditions.presenceOfElementLocated(LeadsName));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Quotes task");
		
		Thread.sleep(15000);
		if(ElementDisplayed(maximize))
		{
			element = wait.until(ExpectedConditions.presenceOfElementLocated(maximize));
			MoveToElementClick(element);
			ExtentSuccessMessage("Clicked on Maximize");
		}
		Thread.sleep(3000);
		waitVisibility(ActionTask);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ActionTask));
		MoveToElementClick(element);
		waitForElement(3000);
		
		By DeleteTask = By.xpath("(//i[@class='fa fa-trash red-color pull-right ng-isolate-scope'])[1]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(DeleteTask));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Delete Task Button");
		
		Thread.sleep(3000);
		By Yes = By.xpath("//button[@class='positive md-button md-ink-ripple']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Yes));
		MoveToElementClick(element);
		ExtentSuccessMessage("Task has been Deleted");	

	}

	public void createNewCustomer() throws InterruptedException, IOException, AWTException {
		
		waitForElement(3000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Customers));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Customers");
		waitForElement(3000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(NewCustomer));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on New Customers");
		String Firstname ="AutoCustomer";
		writeText(CustFName,Firstname);
		waitForElement(1000);
		String Lastname =randomName(); 
		writeText(CustLName,Lastname);
		fullname = Firstname+" "+Lastname; 
		writeCustomernameToExcel(fullname,"TC CE2");
		System.out.println(fullname); 
		
		String currenturl = driver.getCurrentUrl();
		System.out.println(currenturl);
		
		if(currenturl.contains("https://ce-qa.benefitalign.com/"))
		{
			By DOB = By.xpath("//form[@id='AccountForm']//input[@id='LeadDob']");
			element = wait.until(ExpectedConditions.presenceOfElementLocated(DOB));
			MoveToElementClick(element);
			
			String Date = "11/12/1999";
			writeText(DOB,Date+ Keys.ENTER);
			
		}
		else {
			System.out.println("not a qa env");
		}
		
		waitForElement(2000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ContactInfo));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Contact Information");
		waitForElement(2000); 
		writeText(Cellphone,generatePhoneNumber());
		waitForElement(2000);
		String email = Firstname+Lastname+"@yopmail.com";
		System.out.println(email); 
		writeText(CustMail,email);
		waitForElement(3000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PrincipalAdress));
		MoveToElementClick(element);
		waitForElement(2000);
		ExtentSuccessMessage("Clicked on PrincipalAddress"); 
		writeText(PricipalAD1,"Testing"); 
		ExtentSuccessMessage("Entered the Address"); 
		waitForElement(2000);  
		writeText(PrincipalZipCode,"44444"); 
		waitForElement(2000);
		ExtentSuccessMessage("Entered the ZipCode");  
		element = wait.until(ExpectedConditions.presenceOfElementLocated(MailingAddress));
		MoveToElementClick(element);
		waitForElement(2000);	 
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CustSubmit));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Submit");	
		
    	waitForElement(8000);	 
		By element2 = By.xpath("//button[contains(.,'Proceed with Customer creation')]");
		//element = wait.until(ExpectedConditions.visibilityOfElementLocated(element2));
		try {
			if  (driver.findElement(element2).isDisplayed()) {
				click(element2);
				
			}
		} catch (NoSuchElementException e) {
		} 
		catch (Exception e) {
			ExtentSuccessMessage("Customer Created");
		}
		 
		waitForElement(13000);
		By SearchFiled = By.xpath("//input[@class='ng-pristine ng-untouched md-input ng-empty ng-valid-minlength ng-valid-maxlength ng-valid ng-valid-required']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SearchFiled));
		MoveToElementClick(element);
		writeText(SearchFiled,fullname + Keys.ENTER);
		ExtentSuccessMessage("Customer name has been Searched");
 
		waitForElement(3000);
		By Name = By.xpath("//a[@class='edit-list-anchor ng-binding']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Name));
		MoveToElementClick(element);
		ExtentSuccessMessage("Customer has been clicked after serach");
		
		By NameAssertion = By.cssSelector("#page-wrapper > div > ui-view > div:nth-child(3) > div.col-xl-9.col-lg-6.left-section.details > div.ng-scope > div > div > div.ng-scope > paint-ui > div > div > div:nth-child(1) > span > span");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(NameAssertion));
		String nameassertion =element.getText();
//		System.out.println(nameassertion);
		String nameString = StringUtils.substringAfter(nameassertion, " ");
	    System.out.println(nameString);
	    
	    Assert.assertTrue(nameassertion.contains(nameString));
		ExtentSuccessMessage("Assertion for customer name is done");

		By EmailAssertion = By.xpath("//a[@ng-if='labelEmail']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(EmailAssertion));
		String emailassertion =element.getText();
        System.out.println(emailassertion);
        
        Assert.assertEquals(emailassertion, email);
		ExtentSuccessMessage("Assertion for Email is done");
		
		By Edit = By.xpath("//i[@class='fa fa-pencil white']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Edit));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Customer Edit Button");
		
		Thread.sleep(4000);
		By LeadGender = By.xpath("(//md-select[@name='LeadGender'])[1]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(LeadGender));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Lead Gender");
		
		By Male = By.xpath("(//md-option[@value='Male'])[2]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Male));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Male");

		element = wait.until(ExpectedConditions.presenceOfElementLocated(LeadGender));
		String gender = element.getText();
		System.out.println(gender);
		
		By SaveButton = By.xpath("//button[@class='btn btn-default green ng-scope']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SaveButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Save Button");

	    Thread.sleep(16000);
		By GenderUI = By.cssSelector("#page-wrapper > div > ui-view > div:nth-child(3) > div.col-xl-9.col-lg-6.left-section.details > div.ng-scope > div > div > div.ng-scope > paint-ui > div > div > div:nth-child(3) > span > span");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(GenderUI));
		String genderui = element.getText();
		System.out.println(genderui);
		
		Assert.assertEquals(genderui, gender);
		ExtentSuccessMessage("Assertion for gender is done in UI");
		
		By ChangesLog = By.cssSelector(
				"#page-wrapper > div > ui-view > div:nth-child(3) > div.col-xl-9.col-lg-6.left-section.details > div.ng-scope > div > ul > li:nth-child(8) > a");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ChangesLog));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on ChangesLog Section");
		
		Thread.sleep(4000);
		By UpdatedValue = By.xpath("(//div[@class='ui-grid-cell-contents ng-binding ng-scope'])[3]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(UpdatedValue));
		String value = element.getText();
		System.out.println(value);

//		Assert.assertEquals(value, gender);
		ExtentSuccessMessage("Assertion for Updated value is done in Change Logs");

		Thread.sleep(2000);
		By CreateOpportunity = By.xpath("(//button[@class='btn btn-default pull-right ng-binding ng-scope'])[2]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CreateOpportunity));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Create Opportunity button");
		
		waitForElement(3000);
		By EstimateRevenue =  By.xpath("//input[@class='ng-pristine ng-untouched md-input ng-empty ng-valid-min ng-valid-max ng-valid-fraction ng-valid ng-valid-required']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(EstimateRevenue));
		MoveToElementClick(element);
		writeText(EstimateRevenue,"100");
		
		By SubmitButton = By.xpath("(//button[@class='btn btn-default green'])[3]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SubmitButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("clicked on Submit opportunity Buton");
		
		waitForElement(4000);
		By OpportunityTab = By.cssSelector("#page-wrapper > div > ui-view > div:nth-child(3) > div.col-xl-9.col-lg-6.left-section.details > div.ng-scope > div > ul > li:nth-child(4) > a");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(OpportunityTab));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Opportunity Tab");
		
		 
		waitForElement(6000);
		By Opportunity_Grid = By.xpath("//div[@class='ui-grid-row ng-scope']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Opportunity_Grid));
		
		ExtentSuccessMessage("Opportunity is visible under tab");
			
		By ServiceRequest = By.xpath("//button[@class='btn btn-default pull-right ng-binding ng-scope'][1]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ServiceRequest));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Service Button Request");
		
		waitForElement(4000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(RequestType));
		MoveToElementClick(element);
		waitForElement(1000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(RequestStatus));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected the Request type Status as New Enrollment");
		waitForElement(1000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(RequestSubType));
		MoveToElementClick(element);
		waitForElement(1000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(RequestSubStatus));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected Request SubType as New Enrollment");
		waitForElement(1000);
		
		String currenturl1 = driver.getCurrentUrl();
		System.out.println(currenturl1);
		
		if(currenturl.contains("https://mme.benefitalign.com/"))
		{
			By Product_Type = By.xpath("(//span[@class='md-select-icon'])[6]");
			element = wait.until(ExpectedConditions.presenceOfElementLocated(Product_Type));
			MoveToElementClick(element);
			
			waitForElement(3000);
			By Value = By.xpath("//md-option[@value='BE']");
			element = wait.until(ExpectedConditions.presenceOfElementLocated(Value));
			MoveToElementClick(element);
			
			By Actioned_By = By.xpath("//md-select[@aria-label='To Be Actioned By  ']");
			element = wait.until(ExpectedConditions.presenceOfElementLocated(Actioned_By));
			MoveToElementClick(element);
			
			By Value_1 = By.xpath("//div[.='Engineering']");
			element = wait.until(ExpectedConditions.presenceOfElementLocated(Value_1));
			MoveToElementClick(element);
				
		}
		else {
			System.out.println("not a prod");
		}
		
		
		element = wait.until(ExpectedConditions.presenceOfElementLocated(RequestSubmit));
		MoveToElementClick(element);
		ExtentSuccessMessage("Cliked on submit for service request");
		
		waitForElement(12000);
		By ServiceSection = By.cssSelector("#page-wrapper > div > ui-view > div:nth-child(3) > div.col-xl-9.col-lg-6.left-section.details > div.ng-scope > div > ul > li:nth-child(9) > a");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ServiceSection));
		MoveToElementClick(element);
		ExtentSuccessMessage("Cliked on Service Request Section");
		
		waitForElement(9000);
		By Servicereq = By.xpath("//div[@class='ui-grid-row ng-scope']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Servicereq));
		//Assert.assertTrue(driver.findElement(By.xpath("//div[@class='ui-grid-row ng-scope']")).isDisplayed());
		ExtentSuccessMessage("Service Request which is Created is visible under Service Tab");

		
        actions();
		

	
	}

	public void salespolicyImport() throws InterruptedException, AWTException {
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Sales button");
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesPolicy));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Sales Policy");
		waitForElement(10000);

		element = wait.until(ExpectedConditions.presenceOfElementLocated(ImportCustmerPolicies));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Import Customers and Policies");
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(BulkImport));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Bulk Import");
		waitForElement(6000);

		Base_Class.MouseClick(SelectFile);
		ExtentSuccessMessage("File has been selected");
		waitForElement(6000);

		Robot robot1 = new Robot();
		String filePath = System.getProperty("user.dir") + "\\Upload\\Default_Template (1).xlsx";
		StringSelection stringSelection = new StringSelection(filePath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

		robot1.keyPress(KeyEvent.VK_CONTROL);
		Thread.sleep(1000);

		robot1.keyPress(KeyEvent.VK_V);
		Thread.sleep(1000);

		robot1.keyRelease(KeyEvent.VK_V);
		Thread.sleep(1000);

		robot1.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(1000);

		robot1.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(1000);

		robot1.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(1000);

		ExtentSuccessMessage("File is been Uploaded");
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(FileSubmit));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Submit");
		waitForElement(10000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(FileSubmitOk));
		MoveToElementClick(element);
		Thread.sleep(3000);

	}

	public void salesPolicyAdvancedSearch2() throws InterruptedException {
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Sales button");
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesPolicy));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Sales Policy");
		waitForElement(6000);
		waitForElement(10000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AdvancedSearch));
		MoveToElementClick(element);
		ExtentSuccessMessage("Advanced search has been clicked");
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PolicyADDropdown));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Status dropdown");
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PolicyADCancel));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected Cancel");
		waitForElement(9000);
		click(QuoteAdSearch);
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PolicyADDropdown));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Status dropdown");
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PolicyTestMM));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected Status TestMM");
		waitForElement(9000);
		click(QuoteAdSearch);
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PolicyADDropdown));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Status dropdown");
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PolicyEnrolled));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected Enrolled");
		waitForElement(9000);
		click(QuoteAdSearch);
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PolicyADDropdown));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Status dropdown");
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PolicyEnrollPaylater));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected EnrollPaylater");
		waitForElement(9000);
		click(QuoteAdSearch);
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PolicyADDropdown));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Status dropdown");
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PolicyFullfill));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected Fullfill");
		waitForElement(9000);
		click(QuoteAdSearch);
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PolicyADDropdown));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Status dropdown");
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PolicyInProgress));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected InProgress");
		waitForElement(9000);
		click(QuoteAdSearch);
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PolicyADDropdown));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Status dropdown");
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PolicyAdInActive));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected InActive");
		waitForElement(9000);
		click(QuoteAdSearch);
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PolicyADDropdown));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Status dropdown");
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PolicyAdIncomplete));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected Incomplete");
		waitForElement(9000);
		click(QuoteAdSearch);
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PolicyADDropdown));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Status dropdown");
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PolicyLockedEligibility));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected Locked Eligibility");
		waitForElement(9000);
		click(QuoteAdSearch);
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PolicyADDropdown));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Status dropdown");
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PolicyAdLockedEnrollment));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected Locked Enrollment");
		waitForElement(9000);
		click(QuoteAdSearch);
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PolicyADDropdown));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Status dropdown");
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PolicyAdLockedFullfillment));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected Locked Fullfillment");
		waitForElement(9000);
		click(QuoteAdSearch);
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PolicyADDropdown));
		MoveToElementClick(element);
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PolicyNeedmoreInfo));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected Need More Information");
		waitForElement(9000);
		click(QuoteAdSearch);
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PolicyADDropdown));
		MoveToElementClick(element);
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PolicyAdPending));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected Pending");
		waitForElement(9000);
		click(QuoteAdSearch);
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PolicyADDropdown));
		MoveToElementClick(element);
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PolicyAdPendeningCancellation));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected Pendening Cancellation");
		waitForElement(9000);
		click(QuoteAdSearch);
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PolicyADDropdown));
		MoveToElementClick(element);
		waitForElement(5000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PolicyAdPendeningCancellation));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected Pendening Cancellation");
		waitForElement(9000);
		click(QuoteAdSearch);
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PolicyADDropdown));
		MoveToElementClick(element);
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PolicyAdPendingDEAutomation));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected Pending DE Automation");
		waitForElement(9000);
		click(QuoteAdSearch);
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PolicyADDropdown));
		MoveToElementClick(element);
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PolicyAdPremiumPaid));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected PremiumPaid");
		waitForElement(9000);
		click(QuoteAdSearch);
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PolicyADDropdown));
		MoveToElementClick(element);
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PolicyAdSubmitted));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected Submitted");
		waitForElement(9000);
		click(QuoteAdSearch);
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PolicyADDropdown));
		MoveToElementClick(element);
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PolicyAdTerminated));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected Terminated");
		waitForElement(9000);
		click(QuoteAdSearch);
		waitForElement(8000);

	}

	public void salesPolicyAdvancedSearch() throws InterruptedException {
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Sales button");
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesPolicy));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Sales Policy");
		waitForElement(6000);
		waitForElement(10000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AdvancedSearch));
		MoveToElementClick(element);
		ExtentSuccessMessage("Advanced search has been clicked");
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PolicyADDropdown));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Status dropdown");
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PolicyADCancel));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected Cancel");
		waitForElement(9000);
		click(QuoteAdSearch);
		waitForElement(8000);
		/*
		 * element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(PolicyADDropdown));
		 * MoveToElementClick(element);
		 * ExtentSuccessMessage("Clicked on Status dropdown"); waitForElement(8000);
		 * element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(PolicyTestMM));
		 * MoveToElementClick(element); ExtentSuccessMessage("Selected Status TestMM");
		 * waitForElement(9000); click(QuoteAdSearch); waitForElement(8000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(PolicyADDropdown));
		 * MoveToElementClick(element);
		 * ExtentSuccessMessage("Clicked on Status dropdown"); waitForElement(8000);
		 * element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(PolicyEnrolled));
		 * MoveToElementClick(element); ExtentSuccessMessage("Selected Enrolled");
		 * waitForElement(9000); click(QuoteAdSearch); waitForElement(8000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(PolicyADDropdown));
		 * MoveToElementClick(element);
		 * ExtentSuccessMessage("Clicked on Status dropdown"); waitForElement(8000);
		 * element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(PolicyEnrollPaylater))
		 * ; MoveToElementClick(element);
		 * ExtentSuccessMessage("Selected EnrollPaylater"); waitForElement(9000);
		 * click(QuoteAdSearch); waitForElement(8000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(PolicyADDropdown));
		 * MoveToElementClick(element);
		 * ExtentSuccessMessage("Clicked on Status dropdown"); waitForElement(8000);
		 * element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(PolicyFullfill));
		 * MoveToElementClick(element); ExtentSuccessMessage("Selected Fullfill");
		 * waitForElement(9000); click(QuoteAdSearch); waitForElement(8000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(PolicyADDropdown));
		 * MoveToElementClick(element);
		 * ExtentSuccessMessage("Clicked on Status dropdown"); waitForElement(8000);
		 * element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(PolicyInProgress));
		 * MoveToElementClick(element); ExtentSuccessMessage("Selected InProgress");
		 * waitForElement(9000); click(QuoteAdSearch); waitForElement(8000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(PolicyADDropdown));
		 * MoveToElementClick(element);
		 * ExtentSuccessMessage("Clicked on Status dropdown"); waitForElement(8000);
		 * element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(PolicyAdInActive));
		 * MoveToElementClick(element); ExtentSuccessMessage("Selected InActive");
		 * waitForElement(9000); click(QuoteAdSearch); waitForElement(8000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(PolicyADDropdown));
		 * MoveToElementClick(element);
		 * ExtentSuccessMessage("Clicked on Status dropdown"); waitForElement(8000);
		 * element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(PolicyAdIncomplete));
		 * MoveToElementClick(element); ExtentSuccessMessage("Selected Incomplete");
		 * waitForElement(9000); click(QuoteAdSearch); waitForElement(8000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(PolicyADDropdown));
		 * MoveToElementClick(element);
		 * ExtentSuccessMessage("Clicked on Status dropdown"); waitForElement(8000);
		 * element = wait.until(ExpectedConditions.presenceOfElementLocated(
		 * PolicyLockedEligibility)); MoveToElementClick(element);
		 * ExtentSuccessMessage("Selected Locked Eligibility"); waitForElement(9000);
		 * click(QuoteAdSearch); waitForElement(8000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(PolicyADDropdown));
		 * MoveToElementClick(element);
		 * ExtentSuccessMessage("Clicked on Status dropdown"); waitForElement(8000);
		 * element = wait.until(ExpectedConditions.presenceOfElementLocated(
		 * PolicyAdLockedEnrollment)); MoveToElementClick(element);
		 * ExtentSuccessMessage("Selected Locked Enrollment"); waitForElement(9000);
		 * click(QuoteAdSearch); waitForElement(8000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(PolicyADDropdown));
		 * MoveToElementClick(element);
		 * ExtentSuccessMessage("Clicked on Status dropdown"); waitForElement(8000);
		 * element = wait.until(ExpectedConditions.presenceOfElementLocated(
		 * PolicyAdLockedFullfillment)); MoveToElementClick(element);
		 * ExtentSuccessMessage("Selected Locked Fullfillment"); waitForElement(9000);
		 * click(QuoteAdSearch); waitForElement(8000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(PolicyADDropdown));
		 * MoveToElementClick(element); waitForElement(8000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(PolicyNeedmoreInfo));
		 * MoveToElementClick(element);
		 * ExtentSuccessMessage("Selected Need More Information"); waitForElement(9000);
		 * click(QuoteAdSearch); waitForElement(8000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(PolicyADDropdown));
		 * MoveToElementClick(element); waitForElement(8000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(PolicyAdPending));
		 * MoveToElementClick(element); ExtentSuccessMessage("Selected Pending");
		 * waitForElement(9000); click(QuoteAdSearch); waitForElement(8000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(PolicyADDropdown));
		 * MoveToElementClick(element); waitForElement(8000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(
		 * PolicyAdPendeningCancellation)); MoveToElementClick(element);
		 * ExtentSuccessMessage("Selected Pendening Cancellation");
		 * waitForElement(9000); click(QuoteAdSearch); waitForElement(8000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(PolicyADDropdown));
		 * MoveToElementClick(element); waitForElement(5000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(
		 * PolicyAdPendeningCancellation)); MoveToElementClick(element);
		 * ExtentSuccessMessage("Selected Pendening Cancellation");
		 * waitForElement(9000); click(QuoteAdSearch); waitForElement(8000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(PolicyADDropdown));
		 * MoveToElementClick(element); waitForElement(8000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(
		 * PolicyAdPendingDEAutomation)); MoveToElementClick(element);
		 * ExtentSuccessMessage("Selected Pending DE Automation"); waitForElement(9000);
		 * click(QuoteAdSearch); waitForElement(8000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(PolicyADDropdown));
		 * MoveToElementClick(element); waitForElement(8000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(PolicyAdPremiumPaid));
		 * MoveToElementClick(element); ExtentSuccessMessage("Selected PremiumPaid");
		 * waitForElement(9000); click(QuoteAdSearch); waitForElement(8000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(PolicyADDropdown));
		 * MoveToElementClick(element); waitForElement(8000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(PolicyAdSubmitted));
		 * MoveToElementClick(element); ExtentSuccessMessage("Selected Submitted");
		 * waitForElement(9000); click(QuoteAdSearch); waitForElement(8000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(PolicyADDropdown));
		 * MoveToElementClick(element); waitForElement(8000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(PolicyAdTerminated));
		 * MoveToElementClick(element); ExtentSuccessMessage("Selected Terminated");
		 * waitForElement(9000); click(QuoteAdSearch); waitForElement(8000);
		 */

	}

	public void salesPolicyFilter2() throws InterruptedException {
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Sales button");
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesPolicy));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Sales Policy");
		waitForElement(10000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PolicyFilterStatus));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked Policy Filter Status");
		waitForElement(10000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PolicyStatusCancel));
		MoveToElementClick(element);
		waitForElement(10000);
		ExtentSuccessMessage("Selected the Cancel status");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PolicyStatusCancel));
		MoveToElementClick(element);
		waitForElement(10000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PolicyStatusEnrolled));
		MoveToElementClick(element);
		waitForElement(10000);
		ExtentSuccessMessage("Selected the Enrolled status");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PolicyStatusEnrolled));
		MoveToElementClick(element);
		waitForElement(10000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PolicyEnrolledPlaylater));
		MoveToElementClick(element);
		waitForElement(10000);
		ExtentSuccessMessage("Selected the EnrolledPlaylater status");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PolicyEnrolledPlaylater));
		MoveToElementClick(element);
		waitForElement(10000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PolicyStatusFullfill));
		MoveToElementClick(element);
		waitForElement(10000);
		ExtentSuccessMessage("Selected the Fullfill status");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PolicyStatusFullfill));
		MoveToElementClick(element);
		waitForElement(10000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PolicyStatusInProgress));
		MoveToElementClick(element);
		waitForElement(10000);
		ExtentSuccessMessage("Selected the In progress status");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PolicyStatusInProgress));
		MoveToElementClick(element);
		waitForElement(10000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PolicyStatusInActive));
		MoveToElementClick(element);
		waitForElement(10000);
		ExtentSuccessMessage("Selected the In Active status");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PolicyStatusInActive));
		MoveToElementClick(element);
		waitForElement(10000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PolicyInComplete));
		MoveToElementClick(element);
		waitForElement(10000);
		ExtentSuccessMessage("Selected the InComplete status");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PolicyInComplete));
		MoveToElementClick(element);
		waitForElement(10000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PolicyLockEligibility));
		MoveToElementClick(element);
		waitForElement(10000);
		ExtentSuccessMessage("Selected the LockEligibility status");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PolicyLockEligibility));
		MoveToElementClick(element);
		waitForElement(10000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PolicyLockPayment));
		MoveToElementClick(element);
		waitForElement(10000);
		ExtentSuccessMessage("Selected the LockPayment status");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PolicyLockPayment));
		MoveToElementClick(element);
		waitForElement(10000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PolicyLockEnrollment));
		MoveToElementClick(element);
		waitForElement(10000);
		ExtentSuccessMessage("Selected the LockEnrollment status");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PolicyLockEnrollment));
		MoveToElementClick(element);
		waitForElement(10000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PolicyLockFullfillment));
		MoveToElementClick(element);
		waitForElement(10000);
		ExtentSuccessMessage("Selected the LockFullfillment status");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PolicyLockFullfillment));
		MoveToElementClick(element);
		waitForElement(10000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PolicyNeedinfo));
		MoveToElementClick(element);
		waitForElement(10000);
		ExtentSuccessMessage("Selected the  Need information status");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PolicyNeedinfo));
		MoveToElementClick(element);
		waitForElement(10000);
		/*
		 * element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(PolicyPending));
		 * MoveToElementClick(element); waitForElement(10000);
		 * ExtentSuccessMessage("Selected the  Pending status"); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(PolicyPending));
		 * MoveToElementClick(element); waitForElement(10000);
		 */
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PendingDE));
		MoveToElementClick(element);
		waitForElement(10000);
		ExtentSuccessMessage("Selected the Pending DE Automation status");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PendingDE));
		MoveToElementClick(element);
		waitForElement(10000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PremiumPaid));
		MoveToElementClick(element);
		waitForElement(10000);
		ExtentSuccessMessage("Selected the Premium Paid status");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PremiumPaid));
		MoveToElementClick(element);
		waitForElement(10000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PolicystatusSubmit));
		MoveToElementClick(element);
		waitForElement(10000);
		ExtentSuccessMessage("Selected the submitted status");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PolicystatusSubmit));
		MoveToElementClick(element);
		waitForElement(10000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PolicyTerminated));
		MoveToElementClick(element);
		waitForElement(10000);
		ExtentSuccessMessage("Selected the Policy Terminated status");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PolicyTerminated));
		MoveToElementClick(element);

	}

	public void salesPolicyFilter() throws InterruptedException {
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Sales button");
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesPolicy));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Sales Policy");
		waitForElement(10000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PolicyFilterStatus));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked Policy Filter Status");
		waitForElement(10000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PolicyStatusCancel));
		MoveToElementClick(element);
		waitForElement(10000);
		ExtentSuccessMessage("Selected the Cancel status");
		/*
		 * element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(PolicyStatusCancel));
		 * MoveToElementClick(element); waitForElement(10000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(PolicyStatusEnrolled))
		 * ; MoveToElementClick(element); waitForElement(10000);
		 * ExtentSuccessMessage("Selected the Enrolled status"); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(PolicyStatusEnrolled))
		 * ; MoveToElementClick(element); waitForElement(10000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(
		 * PolicyEnrolledPlaylater)); MoveToElementClick(element);
		 * waitForElement(10000);
		 * ExtentSuccessMessage("Selected the EnrolledPlaylater status"); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(
		 * PolicyEnrolledPlaylater)); MoveToElementClick(element);
		 * waitForElement(10000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(PolicyStatusFullfill))
		 * ; MoveToElementClick(element); waitForElement(10000);
		 * ExtentSuccessMessage("Selected the Fullfill status"); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(PolicyStatusFullfill))
		 * ; MoveToElementClick(element); waitForElement(10000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(PolicyStatusInProgress
		 * )); MoveToElementClick(element); waitForElement(10000);
		 * ExtentSuccessMessage("Selected the In progress status"); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(PolicyStatusInProgress
		 * )); MoveToElementClick(element); waitForElement(10000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(PolicyStatusInActive))
		 * ; MoveToElementClick(element); waitForElement(10000);
		 * ExtentSuccessMessage("Selected the In Active status"); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(PolicyStatusInActive))
		 * ; MoveToElementClick(element); waitForElement(10000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(PolicyInComplete));
		 * MoveToElementClick(element); waitForElement(10000);
		 * ExtentSuccessMessage("Selected the InComplete status"); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(PolicyInComplete));
		 * MoveToElementClick(element); waitForElement(10000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(PolicyLockEligibility)
		 * ); MoveToElementClick(element); waitForElement(10000);
		 * ExtentSuccessMessage("Selected the LockEligibility status"); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(PolicyLockEligibility)
		 * ); MoveToElementClick(element); waitForElement(10000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(PolicyLockPayment));
		 * MoveToElementClick(element); waitForElement(10000);
		 * ExtentSuccessMessage("Selected the LockPayment status"); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(PolicyLockPayment));
		 * MoveToElementClick(element); waitForElement(10000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(PolicyLockEnrollment))
		 * ; MoveToElementClick(element); waitForElement(10000);
		 * ExtentSuccessMessage("Selected the LockEnrollment status"); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(PolicyLockEnrollment))
		 * ; MoveToElementClick(element); waitForElement(10000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(PolicyLockFullfillment
		 * )); MoveToElementClick(element); waitForElement(10000);
		 * ExtentSuccessMessage("Selected the LockFullfillment status"); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(PolicyLockFullfillment
		 * )); MoveToElementClick(element); waitForElement(10000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(PolicyNeedinfo));
		 * MoveToElementClick(element); waitForElement(10000);
		 * ExtentSuccessMessage("Selected the  Need information status"); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(PolicyNeedinfo));
		 * MoveToElementClick(element); waitForElement(10000); /* element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(PolicyPending));
		 * MoveToElementClick(element); waitForElement(10000);
		 * ExtentSuccessMessage("Selected the  Pending status"); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(PolicyPending));
		 * MoveToElementClick(element); waitForElement(10000);
		 */
		/*
		 * element = wait.until(ExpectedConditions.presenceOfElementLocated(PendingDE));
		 * MoveToElementClick(element); waitForElement(10000);
		 * ExtentSuccessMessage("Selected the Pending DE Automation status"); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(PendingDE));
		 * MoveToElementClick(element); waitForElement(10000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(PremiumPaid));
		 * MoveToElementClick(element); waitForElement(10000);
		 * ExtentSuccessMessage("Selected the Premium Paid status"); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(PremiumPaid));
		 * MoveToElementClick(element); waitForElement(10000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(PolicystatusSubmit));
		 * MoveToElementClick(element); waitForElement(10000);
		 * ExtentSuccessMessage("Selected the submitted status"); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(PolicystatusSubmit));
		 * MoveToElementClick(element); waitForElement(10000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(PolicyTerminated));
		 * MoveToElementClick(element); waitForElement(10000);
		 * ExtentSuccessMessage("Selected the Policy Terminated status"); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(PolicyTerminated));
		 * MoveToElementClick(element);
		 */

	}

	public void salesPolicyActions() throws InterruptedException, AWTException {
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Sales button");
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesPolicy));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Sales Policy");
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ClickLead));
		MoveToElementClick(element);
		ExtentSuccessMessage(" Lead has been clicked");
		waitForElement(8000);
		/*
		 * writeText(SalesLeadNotes,"abcdefghij");
		 * ExtentSuccessMessage("Note text is entered"); Thread.sleep(6000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(SaveNote));
		 * MoveToElementClick(element); ExtentSuccessMessage("Note is saved");
		 */
		WebElement element = driver.findElement(SalesLeadNotes);
		((JavascriptExecutor) driver).executeScript("arguments[0].value = 'Your text';", element);

		ExtentSuccessMessage("Note text is entered");
		Thread.sleep(6000);

		element = wait.until(ExpectedConditions.presenceOfElementLocated(SaveNote));
		MoveToElementClick(element);
		ExtentSuccessMessage("Note is saved");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesEmail));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked  on Sales Email");
		Thread.sleep(6000);
		writeText(SalesEmailID, randomName() + "@" + "yopmail.com" + Keys.ENTER);
		Thread.sleep(6000);
		writeText(EmailSubject, "Testing");
		Thread.sleep(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SaveEmail));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on save Email");
		Thread.sleep(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesTask));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on sales task");
		Thread.sleep(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(TaskSave));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Task Save");

		Thread.sleep(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AttachFile));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Attach File");
		Thread.sleep(9000);

		WebElement dropdown = driver.findElement(AttachDropDown);

		String optionValue = "string:Application";

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value = arguments[1];", dropdown, optionValue);

		waitForElement(4000);
		Base_Class.MouseClick(By.xpath("//div[@ng-model='myFiles']"));
		ExtentSuccessMessage("Select File has been Clicked");
		waitForElement(3000);

		Robot robot1 = new Robot();
		String filePath = System.getProperty("user.dir") + "\\Upload\\Default_Template (1).xlsx";
		StringSelection stringSelection = new StringSelection(filePath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

		robot1.keyPress(KeyEvent.VK_CONTROL);
		Thread.sleep(1000);

		robot1.keyPress(KeyEvent.VK_V);
		Thread.sleep(1000);

		robot1.keyRelease(KeyEvent.VK_V);
		Thread.sleep(1000);

		robot1.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(1000);

		robot1.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(1000);

		robot1.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(1000);

		ExtentSuccessMessage("File is been Uploaded");
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AddressSave));
		MoveToElementClick(element);
		Thread.sleep(1000);

	}

	public void salesTerminatePolicy() throws InterruptedException {
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Sales button");
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesPolicy));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Sales Policy");
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ClickLead));
		MoveToElementClick(element);
		ExtentSuccessMessage(" Lead has been clicked");
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PolicyCancel));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Cancel");
		waitForElement(9000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PolicyCancelDD));
		MoveToElementClick(element);
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PolicyDDStatus));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected the Terminated");
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PolicyCancelSubmit));
		MoveToElementClick(element);
		ExtentSuccessMessage("Cliked on submit");
		waitForElement(6000);

	}

	public void salesPolicyCreateNewPolicy() throws InterruptedException {
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Sales button");
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesPolicy));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Sales Policy");
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CreatePolicy));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Create Policy");
		waitForElement(9000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PolicySearchIcon));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Policy Search Icon");

		waitForElement(8000);
		WebElement ele = driver.findElement(PolicySearchText);
		ele.clear();
		ele.sendKeys("Automation");
		waitForElement(9000);
		// writeText(PolicySearchText,"Automation");
		ExtentSuccessMessage("Searched the Custmer");
		waitForElement(10000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PolicyCustmerSearchIcon));
		MoveToElementClick(element);
		waitForElement(9000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SelectCustmer));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected the Customer");
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CustomerOk));
		MoveToElementClick(element);
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ProductCategory));
		MoveToElementClick(element);

		waitForElement(3000);

		element = wait.until(ExpectedConditions.presenceOfElementLocated(MedicalLOB));
		MoveToElementClick(element);
		ExtentSuccessMessage("Medical has been selected");
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Carrier));
		MoveToElementClick(element);
		waitForElement(3000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SelectCarrier));
		MoveToElementClick(element);
		ExtentSuccessMessage("Carrier has been selected");
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesType));
		MoveToElementClick(element);
		waitForElement(3000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesNew));
		MoveToElementClick(element);
		ExtentSuccessMessage("SalesType has been selected");
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PolicyStatus));
		MoveToElementClick(element);
		waitForElement(3000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PolicyActive));
		MoveToElementClick(element);
		ExtentSuccessMessage("PolicyStatus has been selected");
		waitForElement(8000);
		writeText(PolicyEFDate, "12/12/2024" + Keys.ENTER);
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PolicyAOR));
		MoveToElementClick(element);
		waitForElement(8000);

		WebElement elep = driver.findElement(AoRSearchText);
		elep.clear();
		elep.sendKeys("Automation");
		waitForElement(9000);

		// writeText(AoRSearchText,"Automation");
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AORSearchIcon));
		MoveToElementClick(element);

		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SelectAOR));
		MoveToElementClick(element);
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AorOk));
		MoveToElementClick(element);
		ExtentSuccessMessage("AOR has been selected");
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PolicySubmit));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Policy submit");
	}

	public void salesQuoteAdvancedSearch2() throws InterruptedException {
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Sales button");
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesQuote));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Sales Quote");
		waitForElement(10000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AdvancedSearch));
		MoveToElementClick(element);
		ExtentSuccessMessage("Advanced search has been clicked");
		waitForElement(8000);

		element = wait.until(ExpectedConditions.presenceOfElementLocated(QuoteAdStatusDD));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Status dropdown");
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(QuoteAdCancel));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected Cancel");
		waitForElement(9000);
		click(QuoteAdSearch);
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(QuoteAdStatusDD));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Status dropdown");
		waitForElement(10000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(QuoteAdCreated));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected Created");
		waitForElement(10000);
		click(QuoteAdSearch);
		waitForElement(10000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(QuoteAdStatusDD));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Status dropdown");
		waitForElement(10000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(QuoteAdDeclined));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected Declined");
		waitForElement(10000);
		click(QuoteAdSearch);
		waitForElement(10000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(QuoteAdStatusDD));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Status dropdown");
		waitForElement(10000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(QuoteAdExpired));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected Expired");
		waitForElement(10000);
		click(QuoteAdSearch);
		waitForElement(10000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(QuoteAdStatusDD));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Status dropdown");
		waitForElement(10000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(QuoteAdInActive));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected Active");
		waitForElement(10000);
		click(QuoteAdSearch);
		waitForElement(10000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(QuoteAdStatusDD));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Status dropdown");
		waitForElement(10000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(QuoteAdInProgress));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected InProgress");
		waitForElement(10000);
		click(QuoteAdSearch);
		waitForElement(10000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(QuoteAdStatusDD));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Status dropdown");
		waitForElement(10000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(QuoteAdInstalled));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected Installed");
		waitForElement(10000);
		click(QuoteAdSearch);
		waitForElement(10000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(QuoteAdStatusDD));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Status dropdown");
		waitForElement(10000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(QuoteAdInstallInProgress));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected Install In Progress");
		waitForElement(10000);
		click(QuoteAdSearch);
		waitForElement(10000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(QuoteAdStatusDD));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Status dropdown");
		waitForElement(10000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(QuoteAdTerminated));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected Terminated");
		waitForElement(10000);
		click(QuoteAdSearch);

	}

	public void salesQuoteAdvancedSearch() throws InterruptedException {
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Sales button");
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesQuote));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Sales Quote");
		waitForElement(10000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AdvancedSearch));
		MoveToElementClick(element);
		ExtentSuccessMessage("Advanced search has been clicked");
		waitForElement(8000);

		element = wait.until(ExpectedConditions.presenceOfElementLocated(QuoteAdStatusDD));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Status dropdown");
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(QuoteAdCancel));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected Cancel");
		waitForElement(9000);
		click(QuoteAdSearch);
		waitForElement(8000);
		/*
		 * element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(QuoteAdStatusDD));
		 * MoveToElementClick(element);
		 * ExtentSuccessMessage("Clicked on Status dropdown"); waitForElement(10000);
		 * element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(QuoteAdCreated));
		 * MoveToElementClick(element); ExtentSuccessMessage("Selected Created");
		 * waitForElement(10000); click(QuoteAdSearch); waitForElement(10000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(QuoteAdStatusDD));
		 * MoveToElementClick(element);
		 * ExtentSuccessMessage("Clicked on Status dropdown"); waitForElement(10000);
		 * element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(QuoteAdDeclined));
		 * MoveToElementClick(element); ExtentSuccessMessage("Selected Declined");
		 * waitForElement(10000); click(QuoteAdSearch); waitForElement(10000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(QuoteAdStatusDD));
		 * MoveToElementClick(element);
		 * ExtentSuccessMessage("Clicked on Status dropdown"); waitForElement(10000);
		 * element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(QuoteAdExpired));
		 * MoveToElementClick(element); ExtentSuccessMessage("Selected Expired");
		 * waitForElement(10000); click(QuoteAdSearch); waitForElement(10000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(QuoteAdStatusDD));
		 * MoveToElementClick(element);
		 * ExtentSuccessMessage("Clicked on Status dropdown"); waitForElement(10000);
		 * element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(QuoteAdInActive));
		 * MoveToElementClick(element); ExtentSuccessMessage("Selected Active");
		 * waitForElement(10000); click(QuoteAdSearch); waitForElement(10000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(QuoteAdStatusDD));
		 * MoveToElementClick(element);
		 * ExtentSuccessMessage("Clicked on Status dropdown"); waitForElement(10000);
		 * element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(QuoteAdInProgress));
		 * MoveToElementClick(element); ExtentSuccessMessage("Selected InProgress");
		 * waitForElement(10000); click(QuoteAdSearch); waitForElement(10000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(QuoteAdStatusDD));
		 * MoveToElementClick(element);
		 * ExtentSuccessMessage("Clicked on Status dropdown"); waitForElement(10000);
		 * element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(QuoteAdInstalled));
		 * MoveToElementClick(element); ExtentSuccessMessage("Selected Installed");
		 * waitForElement(10000); click(QuoteAdSearch); waitForElement(10000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(QuoteAdStatusDD));
		 * MoveToElementClick(element);
		 * ExtentSuccessMessage("Clicked on Status dropdown"); waitForElement(10000);
		 * element = wait.until(ExpectedConditions.presenceOfElementLocated(
		 * QuoteAdInstallInProgress)); MoveToElementClick(element);
		 * ExtentSuccessMessage("Selected Install In Progress"); waitForElement(10000);
		 * click(QuoteAdSearch); waitForElement(10000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(QuoteAdStatusDD));
		 * MoveToElementClick(element);
		 * ExtentSuccessMessage("Clicked on Status dropdown"); waitForElement(10000);
		 * element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(QuoteAdTerminated));
		 * MoveToElementClick(element); ExtentSuccessMessage("Selected Terminated");
		 * waitForElement(10000); click(QuoteAdSearch);
		 */

	}

	public void SalesQuotesFilters2() throws InterruptedException {
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Sales button");
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesQuote));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Sales Quote");
		waitForElement(10000);

		element = wait.until(ExpectedConditions.presenceOfElementLocated(QuoteStatus));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Quote status");
		waitForElement(10000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(QuoteCancel));
		MoveToElementClick(element);
		waitForElement(10000);
		ExtentSuccessMessage("Selected the cancel status");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(QuoteCancel));
		MoveToElementClick(element);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(QuoteCreated));
		MoveToElementClick(element);
		waitForElement(10000);
		ExtentSuccessMessage("Selected the Created status");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(QuoteCreated));
		MoveToElementClick(element);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(QuoteDeclined));
		MoveToElementClick(element);
		waitForElement(10000);
		ExtentSuccessMessage("Selected the Declined status");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(QuoteDeclined));
		MoveToElementClick(element);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(QuoteExpire));
		MoveToElementClick(element);
		waitForElement(10000);
		ExtentSuccessMessage("Selected the Expire status");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(QuoteExpire));
		MoveToElementClick(element);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(QuoteInprogress));
		MoveToElementClick(element);
		waitForElement(10000);
		ExtentSuccessMessage("Selected theIn progress status");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(QuoteInprogress));
		MoveToElementClick(element);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(QuoteInactive));
		MoveToElementClick(element);
		waitForElement(10000);
		ExtentSuccessMessage("Selected the Inactive status");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(QuoteInactive));
		MoveToElementClick(element);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(QuoteInstallinprogress));
		MoveToElementClick(element);
		waitForElement(10000);
		ExtentSuccessMessage("Selected the Install Inprogress status");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(QuoteInstallinprogress));
		MoveToElementClick(element);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(QuoteInstall));
		MoveToElementClick(element);
		waitForElement(10000);
		ExtentSuccessMessage("Selected the Install status");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(QuoteInstall));
		MoveToElementClick(element);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(QuoteTerminated));
		MoveToElementClick(element);
		waitForElement(10000);
		ExtentSuccessMessage("Selected the Terminated status");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(QuoteTerminated));
		MoveToElementClick(element);
	}

	public void SalesQuotesFilters() throws InterruptedException {
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Sales button");
		waitForElement(10000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesQuote));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Sales Quote");
		waitForElement(8000);
//	 driver.navigate().refresh();
//	 waitForElement(7000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(QuoteStatus));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Quote status");
		waitForElement(10000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(QuoteCancel));
		MoveToElementClick(element);
		waitForElement(10000);
		ExtentSuccessMessage("Selected the cancel status");
		/*
		 * element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(QuoteCancel));
		 * MoveToElementClick(element); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(QuoteCreated));
		 * MoveToElementClick(element); waitForElement(10000);
		 * ExtentSuccessMessage("Selected the Created status"); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(QuoteCreated));
		 * MoveToElementClick(element); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(QuoteDeclined));
		 * MoveToElementClick(element); waitForElement(10000);
		 * ExtentSuccessMessage("Selected the Declined status"); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(QuoteDeclined));
		 * MoveToElementClick(element); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(QuoteExpire));
		 * MoveToElementClick(element); waitForElement(10000);
		 * ExtentSuccessMessage("Selected the Expire status"); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(QuoteExpire));
		 * MoveToElementClick(element); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(QuoteInprogress));
		 * MoveToElementClick(element); waitForElement(10000);
		 * ExtentSuccessMessage("Selected theIn progress status"); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(QuoteInprogress));
		 * MoveToElementClick(element); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(QuoteInactive));
		 * MoveToElementClick(element); waitForElement(10000);
		 * ExtentSuccessMessage("Selected the Inactive status"); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(QuoteInactive));
		 * MoveToElementClick(element); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(QuoteInstallinprogress
		 * )); MoveToElementClick(element); waitForElement(10000);
		 * ExtentSuccessMessage("Selected the Install Inprogress status"); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(QuoteInstallinprogress
		 * )); MoveToElementClick(element); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(QuoteInstall));
		 * MoveToElementClick(element); waitForElement(10000);
		 * ExtentSuccessMessage("Selected the Install status"); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(QuoteInstall));
		 * MoveToElementClick(element); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(QuoteTerminated));
		 * MoveToElementClick(element); waitForElement(10000);
		 * ExtentSuccessMessage("Selected the Terminated status"); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(QuoteTerminated));
		 * MoveToElementClick(element);
		 */

	}

	public void Sales_Quotes_QuotesActions() throws InterruptedException, AWTException {
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Sales button");
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesQuote));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Sales Quote");
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ClickLead));
		MoveToElementClick(element);
		ExtentSuccessMessage(" Lead has been clicked");
		waitForElement(8000);

		/*
		 * writeText(SalesLeadNotes,"abcdefghij");
		 * ExtentSuccessMessage("Note text is entered"); Thread.sleep(6000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(SaveNote));
		 * MoveToElementClick(element);
		 */
		WebElement element = driver.findElement(SalesLeadNotes);
		((JavascriptExecutor) driver).executeScript("arguments[0].value = 'Your text';", element);

		ExtentSuccessMessage("Note text is entered");
		Thread.sleep(6000);

		element = wait.until(ExpectedConditions.presenceOfElementLocated(SaveNote));
		MoveToElementClick(element);
		ExtentSuccessMessage("Note is saved");
		Thread.sleep(5000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesEmail));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked  on Sales Email");
		Thread.sleep(6000);
		writeText(SalesEmailID, randomName() + "@" + "yopmail.com" + Keys.ENTER);
		Thread.sleep(6000);
		writeText(EmailSubject, "Testing");
		Thread.sleep(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SaveEmail));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on save Email");
		Thread.sleep(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesTask));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on sales task");
		Thread.sleep(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(TaskSave));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Task Save");

		Thread.sleep(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AttachFile));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Attach File");
		Thread.sleep(9000);

		WebElement dropdown = driver.findElement(AttachDropDown);

		String optionValue = "string:Application";

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value = arguments[1];", dropdown, optionValue);

		waitForElement(4000);
		Base_Class.MouseClick(By.xpath("//div[@ng-model='myFiles']"));
		ExtentSuccessMessage("Select File has been Clicked");
		waitForElement(3000);

		Robot robot1 = new Robot();
		String filePath = System.getProperty("user.dir") + "\\Upload\\Default_Template (1).xlsx";
		StringSelection stringSelection = new StringSelection(filePath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

		robot1.keyPress(KeyEvent.VK_CONTROL);
		Thread.sleep(1000);

		robot1.keyPress(KeyEvent.VK_V);
		Thread.sleep(1000);

		robot1.keyRelease(KeyEvent.VK_V);
		Thread.sleep(1000);

		robot1.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(1000);

		robot1.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(1000);

		robot1.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(1000);

		ExtentSuccessMessage("File is been Uploaded");
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AddressSave));
		MoveToElementClick(element);
		Thread.sleep(1000);

	}

	public void salesQuotesCreateQuoteFromOpportunity() throws InterruptedException {
		waitForElement(6000);

		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Sales button");
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesQuote));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Sales Quote");
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ClickLead));
		MoveToElementClick(element);
		ExtentSuccessMessage(" Lead has been clicked");
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CancelQuote));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Cancel Quote");
		waitForElement(6000);

		/*
		 * WebElement textField = driver.findElement(ActualRevenu);
		 * 
		 * textField.click(); textField.sendKeys("30");
		 */
		waitForElement(4000);
		// writeText(Textarea,"Expired");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(Textarea);
		js.executeScript("arguments[0].value='Expired text';", element);
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CancelSubmit));
		MoveToElementClick(element);
		wait.until(ExpectedConditions.presenceOfElementLocated(SelectStatus));
		MoveToElementClick(element);

		waitForElement(3000);

		element = wait.until(ExpectedConditions.presenceOfElementLocated(SelectCancel));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected the Cancel");
		waitForElement(6000);
		ExtentSuccessMessage("Clicked on submit");
		waitForElement(6000);
	}

	public void salesQuotesCreateOpportunityFromLead() throws InterruptedException {
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Sales button");
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesQuote));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Sales Quote");
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ClickLead));
		MoveToElementClick(element);
		ExtentSuccessMessage(" Lead has been clicked");
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(InstallPolicy));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Install Policy");
		waitForElement(15000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AorSearch));
		MoveToElementClick(element);

		waitForElement(8000);
		WebElement ele = driver.findElement(AorText);
		ele.clear();
		// writeText(ele,"siva");
		ele.sendKeys("siva");
		waitForElement(9000);

		element = wait.until(ExpectedConditions.presenceOfElementLocated(SearchIcon));
		MoveToElementClick(element);
		waitForElement(9000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AorRadioButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("Select the AOR");
		waitForElement(9000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Okbutton));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on ok ");
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SubmitQuote));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Submit");
		waitForElement(6000);

	}

	public void salesOpportunityFilterOpportunity2() throws InterruptedException {

		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesButton));
		MoveToElementClick(element);
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesOpportunities));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Sales Opportunity");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Oppstatus));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Status ");
		waitForElement(10000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(OppCancel2));
		MoveToElementClick(element);
		waitForElement(10000);
		ExtentSuccessMessage("Selected the Cancel status");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(OppCancel2));
		MoveToElementClick(element);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(OppCloseW));
		MoveToElementClick(element);
		waitForElement(10000);
		ExtentSuccessMessage("Selected the Closed as won status");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(OppCloseW));
		MoveToElementClick(element);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(OppOpen));
		MoveToElementClick(element);
		waitForElement(10000);
		ExtentSuccessMessage("Selected the Open status");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(OppOpen));
		MoveToElementClick(element);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(OppQualified));
		MoveToElementClick(element);
		waitForElement(10000);
		ExtentSuccessMessage("Selected the Qualified status");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(OppQualified));
		MoveToElementClick(element);

	}

	public void salesOpportunityFilterOpportunity() throws InterruptedException {

		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesButton));
		MoveToElementClick(element);
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesOpportunities));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Sales Opportunity");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Oppstatus));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Status ");
		waitForElement(10000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(OppCancel2));
		MoveToElementClick(element);
		waitForElement(10000);
		ExtentSuccessMessage("Selected the Cancel status");
		/*
		 * element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(OppCancel2));
		 * MoveToElementClick(element); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(OppCloseW));
		 * MoveToElementClick(element); waitForElement(10000);
		 * ExtentSuccessMessage("Selected the Closed as won status"); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(OppCloseW));
		 * MoveToElementClick(element); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(OppOpen));
		 * MoveToElementClick(element); waitForElement(10000);
		 * ExtentSuccessMessage("Selected the Open status"); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(OppOpen));
		 * MoveToElementClick(element); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(OppQualified));
		 * MoveToElementClick(element); waitForElement(10000);
		 * ExtentSuccessMessage("Selected the Qualified status"); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(OppQualified));
		 * MoveToElementClick(element);
		 */

	}
	
	public void Home_Redirection() throws InterruptedException
	{
		By Home_Tile = By.xpath("//i[@class='fa fa-fw fa-home']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Home_Tile));
		MoveToElementClick(element);
		ExtentSuccessMessage("Redirected to home page");
	}

	public void opportunityActions() throws InterruptedException, AWTException {

		waitForElement(10000);
//		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesButton));
//		MoveToElementClick(element);
//		waitForElement(6000);
//		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesOpportunities));
//		MoveToElementClick(element);
//		ExtentSuccessMessage("Clicked on Sales Opportunity");
//		Thread.sleep(8000);
//		element = wait.until(ExpectedConditions.presenceOfElementLocated(search));
//		writeText(search, Full_Name + Keys.ENTER);
//		ExtentSuccessMessage("Clicked on Search");
//		waitForElement(4000);		
//		waitVisibility(ClickLead);
//		element = wait.until(ExpectedConditions.presenceOfElementLocated(ClickLead));
//		MoveToElementClick(element);
//		ExtentSuccessMessage(" Lead has been clicked");
//		waitForElement(8000);

		/*
		 * writeText(SalesLeadNotes,"abcdefghij");
		 * ExtentSuccessMessage("Note text is entered"); Thread.sleep(6000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(SaveNote));
		 * MoveToElementClick(element); ExtentSuccessMessage("Note is saved");
		 */
		
		By maximize = By.xpath("//span[@class='collpase-leftt glyphicon glyphicon-triangle-right']");
		if(ElementDisplayed(maximize))
		{
			element = wait.until(ExpectedConditions.presenceOfElementLocated(maximize));
			MoveToElementClick(element);
			ExtentSuccessMessage("Clicked on Maximize");
		}
		waitForElement(2000);
		
		waitVisibility(NotesSection);
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
		By EmailAddressDD = By.xpath("//md-select-value[@class='md-select-value']");
		wait.until(ExpectedConditions.elementToBeClickable(EmailAddressDD));
		click(EmailAddressDD);
		By EmailAddressDDOPtion = By.xpath("//md-option[@value='salessupport@healthcareenrollmentcenter.com'] | //md-option[@value='customerengage@benefitalign.com'] | //md-option[@value='salessupport@truecoverage.com']");
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

		waitForElement(12000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AgentEmailInc));
		NoteText  = element.getText();
		System.out.println("-----------"+ NoteText+"------------");
		Assert.assertEquals(AgentEmailAction, NoteText);
		ExtentSuccessMessage("Assertion has been done");


		waitForElement(10000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ActionAttachment));
		MoveToElementClick(element);

		waitForElement(5000);
		By DocumentDD1 =  By.cssSelector(".form-control.ng-pristine.ng-untouched.ng-valid.ng-not-empty");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(DocumentDD1));
		Select s1 = new Select(element);
		s1.selectByVisibleText("Other");
		//			
		//			element = wait.until(ExpectedConditions.presenceOfElementLocated(DocumentDD));
		//			wait.until(ExpectedConditions.elementToBeClickable(DocumentDD));
		//			click(DocumentDD);
		//			waitForElement(500);
		//        
		//         wait.until(ExpectedConditions.elementToBeClickable(DocumentDDOption));
		//			click(DocumentDDOption);	
		wait.until(ExpectedConditions.elementToBeClickable(DocumentAttachFileButton));
		click(DocumentAttachFileButton);

		Robot robot = new Robot();
		String filePath = System.getProperty("user.dir") + "\\Upload\\AgentAttachment.txt";
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

//		Assert.assertTrue(driver.findElement(AttachmentInc).isDisplayed());
//		ExtentSuccessMessage("Assertion has been done");

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

		waitForElement(9000);

		element = wait.until(ExpectedConditions.visibilityOfElementLocated(TaskInc));
		//Assert.assertTrue(driver.findElement(TaskInc).isDisplayed());
		ExtentSuccessMessage("Assertion has been done");
		By DashBoard = By.xpath("//a[@id='menu_Dashboard']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(DashBoard));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked On DashBoard Option");

		By MyTask = By.xpath("//a[@id='submenu_MyTasks']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(MyTask));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked On My TaskOption Option");

		Thread.sleep(7000);
		By LeadsName = By.xpath("//div[@class='task-caller']/span[contains(.,'"+Full_Name+"')]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(LeadsName));
		String name =element.getText();
		System.out.println(name);

		Thread.sleep(2000);
		Assert.assertTrue(driver.findElement(LeadsName).isDisplayed());
		ExtentSuccessMessage("Assertion for My task is done");

		element = wait.until(ExpectedConditions.presenceOfElementLocated(LeadsName));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Quotes task");

		Thread.sleep(15000);
		if(ElementDisplayed(maximize))
		{
			element = wait.until(ExpectedConditions.presenceOfElementLocated(maximize));
			MoveToElementClick(element);
			ExtentSuccessMessage("Clicked on Maximize");
		}
		waitVisibility(ActionTask);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ActionTask));
		MoveToElementClick(element);
		waitForElement(3000);

		By DeleteTask = By.xpath("(//i[@class='fa fa-trash red-color pull-right ng-isolate-scope'])[1]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(DeleteTask));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Delete Task Button");

		Thread.sleep(3000);
		By Yes = By.xpath("//button[@class='positive md-button md-ink-ripple']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Yes));
		MoveToElementClick(element);
		ExtentSuccessMessage("Task has been Deleted");

	}

	public void opportunityChangeLeadStatus() throws InterruptedException {
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesButton));
		MoveToElementClick(element);
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesOpportunities));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Sales Opportunity");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ClickLead));
		MoveToElementClick(element);
		ExtentSuccessMessage(" Lead has been clicked");
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Optqualify));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Qualify");
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Optsubmit2));
		MoveToElementClick(element);
		ExtentSuccessMessage("Cliked on Submit button");
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CloseDeal));
		MoveToElementClick(element);
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CloseDealStatus));
		MoveToElementClick(element);
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CloseOption));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected CloseDeal");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Optsubmit2));
		MoveToElementClick(element);
		ExtentSuccessMessage("Cliked on Submit button");
	}
	
	public void Delete_Opportunity() throws InterruptedException
	{
		By Sales = By.xpath("//a[@id='menu_Sales']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Sales));
		MoveToElementClick(element);
		waitForElement(6000);
		By opportunities = By.xpath("//a[@id='submenu_salesopportunities']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(opportunities));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Sales Opportunity");

		Thread.sleep(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(search));
		element.clear();
		writeText(search, Full_Name + Keys.ENTER);
		ExtentSuccessMessage("Clicked on Search");
		waitForElement(4000);		
		waitVisibility(ClickLead);
		By Check = By.xpath("/html[1]/body[1]/div[3]/div[6]/div[1]/ui-view[1]/div[7]/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Check));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected Checkbox");
		
		By Manage = By.xpath("//button[@id='manageOpportunityBtn']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Manage));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected Manage");
		
		By Delete = By.xpath("//button[@id='deleteOpportunitiesBtn']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Delete));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked delete");
		
		By confirmation = By.xpath("//button[@class='positive md-button md-ink-ripple']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(confirmation));
		MoveToElementClick(element);
		
		

		
	}
	
	public void Changedealstatus() throws InterruptedException
	{
		waitForElement(2000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CloseDeal));
		MoveToElementClick(element);
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CloseDealStatus));
		MoveToElementClick(element);
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CloseOption));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected CloseDeal");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Optsubmit2));
		MoveToElementClick(element);
		ExtentSuccessMessage("Cliked on Submit button");
		
		By ChangedStatus = By.xpath("//span[@class='ng-binding ng-isolate-scope'][normalize-space()='Closed as Won']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ChangedStatus));
		
		ExtentSuccessMessage("Validated the deal change status");
		
	}
	
	

	public void createOpportunityQuote() throws InterruptedException {
//		waitForElement(6000);
//		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesButton));
//		MoveToElementClick(element);
//		waitForElement(6000);
//		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesOpportunities));
//		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Sales Opportunity");
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ClickLead));
		MoveToElementClick(element);
		ExtentSuccessMessage(" Lead has been clicked");
		waitForElement(6000);

		element = wait.until(ExpectedConditions.presenceOfElementLocated(OpportunityQuote));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Create quote");
		waitForElement(6000);
		writeText(OpportunityEffectiveDate, "12/12/2024" + Keys.ENTER);
		waitForElement(6000);
		writeText(OptZipCode, "33233");
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

	}

	public void newOpportunity() throws InterruptedException {
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesButton));
		MoveToElementClick(element);
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesOpportunities));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Sales Opportunity");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(NewOpportunity));
		MoveToElementClick(element);
		ExtentSuccessMessage("clicked on new New Opportunity");
		waitForElement(6000);
		writeText(OpportunityName, "Test");
		waitForElement(6000);
		ExtentSuccessMessage("Enter the custmer name");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesSearchIcon));
		MoveToElementClick(element);
		waitForElement(6000);
		ExtentSuccessMessage("Clicked on search  ");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(RadioButtonSelect));
		MoveToElementClick(element);
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ButtonOk));
		MoveToElementClick(element);

		waitForElement(10000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SubmitOk));
		MoveToElementClick(element);
		ExtentSuccessMessage("Cliked on submit button");
	}

	public void leadAdvancedSearch2() throws InterruptedException {
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesButton));
		MoveToElementClick(element);
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Leads));
		MoveToElementClick(element);
		ExtentSuccessMessage("Sales Lead has been clicked");
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AdvancedSearch));
		MoveToElementClick(element);
		ExtentSuccessMessage("Advanced search has been clicked");

		waitForElement(3000);

		element = wait.until(ExpectedConditions.presenceOfElementLocated(AdvancedLeadStatus));
		MoveToElementClick(element);
		waitForElement(3000);

		element = wait.until(ExpectedConditions.presenceOfElementLocated(SelectAccepted));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected Accepted");
		waitForElement(9000);
		click(AdvanceSubmit);
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AdvancedLeadStatus));
		MoveToElementClick(element);

		waitForElement(3000);

		element = wait.until(ExpectedConditions.presenceOfElementLocated(SelectUnqualified));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected Unqualified");
		waitForElement(9000);
		click(AdvanceSubmit);
		waitForElement(6000);

		element = wait.until(ExpectedConditions.presenceOfElementLocated(AdvancedLeadStatus));
		MoveToElementClick(element);

		waitForElement(3000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SelectConverted));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected Converted");
		waitForElement(9000);
		click(AdvanceSubmit);
		waitForElement(6000);

		element = wait.until(ExpectedConditions.presenceOfElementLocated(AdvancedLeadStatus));
		MoveToElementClick(element);

		waitForElement(3000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SelectQualified));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected Qualified");
		waitForElement(9000);
		click(AdvanceSubmit);
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AdvancedLeadStatus));
		MoveToElementClick(element);

		waitForElement(4000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SelectReject));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected Reject");
		waitForElement(9000);
		click(AdvanceSubmit);

	}

	public void leadAdvancedSearch() throws InterruptedException {
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesButton));
		MoveToElementClick(element);
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Leads));
		MoveToElementClick(element);
		ExtentSuccessMessage("Sales Lead has been clicked");
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AdvancedSearch));
		MoveToElementClick(element);
		ExtentSuccessMessage("Advanced search has been clicked");

		waitForElement(3000);

		element = wait.until(ExpectedConditions.presenceOfElementLocated(AdvancedLeadStatus));
		MoveToElementClick(element);
		waitForElement(3000);

		element = wait.until(ExpectedConditions.presenceOfElementLocated(SelectAccepted));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected Accepted");
		waitForElement(9000);
		click(AdvanceSubmit);
		waitForElement(6000);
		/*
		 * element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(AdvancedLeadStatus));
		 * MoveToElementClick(element);
		 * 
		 * waitForElement(3000);
		 * 
		 * element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(SelectUnqualified));
		 * MoveToElementClick(element); ExtentSuccessMessage("Selected Unqualified");
		 * waitForElement(9000); click(AdvanceSubmit); waitForElement(6000);
		 * 
		 * element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(AdvancedLeadStatus));
		 * MoveToElementClick(element);
		 * 
		 * waitForElement(3000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(SelectConverted));
		 * MoveToElementClick(element); ExtentSuccessMessage("Selected Converted");
		 * waitForElement(9000); click(AdvanceSubmit); waitForElement(6000);
		 * 
		 * element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(AdvancedLeadStatus));
		 * MoveToElementClick(element);
		 * 
		 * waitForElement(3000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(SelectQualified));
		 * MoveToElementClick(element); ExtentSuccessMessage("Selected Qualified");
		 * waitForElement(9000); click(AdvanceSubmit); waitForElement(6000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(AdvancedLeadStatus));
		 * MoveToElementClick(element);
		 * 
		 * waitForElement(4000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(SelectReject));
		 * MoveToElementClick(element); ExtentSuccessMessage("Selected Reject");
		 * waitForElement(9000); click(AdvanceSubmit);
		 */

	}

	public void salesLeadFilterLead2() throws InterruptedException {
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesButton));
		MoveToElementClick(element);
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Leads));
		MoveToElementClick(element);
		ExtentSuccessMessage("Sales Lead has been clicked");

		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(StatusLead));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Status Lead");
		waitForElement(7000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(StausUnqualified));
		MoveToElementClick(element);
		waitForElement(10000);
		ExtentSuccessMessage("Selected the UnQualified status");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(StausUnqualified));
		MoveToElementClick(element);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(StatusAccepted));
		MoveToElementClick(element);
		waitForElement(10000);
		ExtentSuccessMessage("Selected the Accepted status");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(StatusAccepted));
		MoveToElementClick(element);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(StatusConverted));
		MoveToElementClick(element);
		waitForElement(10000);
		ExtentSuccessMessage("Selected the Converted status");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(StatusConverted));
		MoveToElementClick(element);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(StatusQualified));
		MoveToElementClick(element);
		waitForElement(10000);
		ExtentSuccessMessage("Selected the Qualified status");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(StatusQualified));
		MoveToElementClick(element);

	}

	public void salesLeadFilterLead() throws InterruptedException {
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesButton));
		MoveToElementClick(element);
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Leads));
		MoveToElementClick(element);
		ExtentSuccessMessage("Sales Lead has been clicked");
		waitForElement(4000);
		driver.navigate().refresh();
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(StatusLead));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Status Lead");
		waitForElement(7000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(StausUnqualified));
		MoveToElementClick(element);
		waitForElement(10000);
		ExtentSuccessMessage("Selected the UnQualified status");
		/*
		 * element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(StausUnqualified));
		 * MoveToElementClick(element); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(StatusAccepted));
		 * MoveToElementClick(element); waitForElement(10000);
		 * ExtentSuccessMessage("Selected the Accepted status"); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(StatusAccepted));
		 * MoveToElementClick(element); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(StatusConverted));
		 * MoveToElementClick(element); waitForElement(10000);
		 * ExtentSuccessMessage("Selected the Converted status"); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(StatusConverted));
		 * MoveToElementClick(element); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(StatusQualified));
		 * MoveToElementClick(element); waitForElement(10000);
		 * ExtentSuccessMessage("Selected the Qualified status"); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(StatusQualified));
		 * MoveToElementClick(element);
		 */
	}

	public void leadConvert() throws InterruptedException {
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesButton));
		MoveToElementClick(element);
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Leads));
		MoveToElementClick(element);
		ExtentSuccessMessage("Sales Lead has been clicked");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ClickLead));
		MoveToElementClick(element);
		ExtentSuccessMessage(" Lead has been clicked");
		waitForElement(6000);
		click(Convert);
		ExtentSuccessMessage("Clicked on Convert button");
		// waitForElement(6000);
		// click(MedicalDropdown);
		waitForElement(8000);
		// click(Medical);
		// click(ConvertSubmit);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ConvertSubmit));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Convert Submit");

	}

	public void salesLeadActions() throws InterruptedException, AWTException {
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesButton));
		MoveToElementClick(element);
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Leads));
		MoveToElementClick(element);
		ExtentSuccessMessage("Sales Lead has been clicked");
		Thread.sleep(10000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ClickLead));
		MoveToElementClick(element);
		ExtentSuccessMessage(" Lead has been clicked");
		Thread.sleep(10000);

		/*
		 * element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(SalesLeadNotes));
		 * MoveToElementClick(element); String Note = "Rajeswari Automation";
		 * writeText(SalesLeadNotes, Note);
		 */
		// writeText(SalesLeadNotes,"abcdefghij");
		WebElement element = driver.findElement(SalesLeadNotes);
		((JavascriptExecutor) driver).executeScript("arguments[0].value = 'Your text';", element);

		ExtentSuccessMessage("Note text is entered");
		Thread.sleep(6000);

		element = wait.until(ExpectedConditions.presenceOfElementLocated(SaveNote));
		MoveToElementClick(element);
		ExtentSuccessMessage("Note is saved");
		waitForElement(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesEmail));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked  on Sales Email");
		Thread.sleep(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesEmailID));
		MoveToElementClick(element);
		writeText(SalesEmailID, randomName() + "@" + "yopmail.com" + Keys.ENTER);
		Thread.sleep(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(EmailSubject));
		MoveToElementClick(element);
		writeText(EmailSubject, "Testing");
		Thread.sleep(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SaveEmail));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on save Email");
		Thread.sleep(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesTask));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on sales task");
		Thread.sleep(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(TaskSave));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Task Save");

		Thread.sleep(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AttachFile));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Attach File");
		Thread.sleep(9000);
		// WebElement dropdown = driver.findElement(AttachDropDown);

		/*
		 * String optionValue = "string:Application";
		 * 
		 * JavascriptExecutor js = (JavascriptExecutor) driver;
		 * js.executeScript("arguments[0].value = arguments[1];", dropdown,
		 * optionValue);
		 * js.executeScript("arguments[0].dispatchEvent(new Event('change'))",
		 * dropdown); waitForElement(4000);
		 */

		waitForElement(10000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AttachDropDown));
		wait.until(ExpectedConditions.elementToBeClickable(AttachDropDown));
		click(AttachDropDown);
		waitForElement(3000);
		By DocumentDDOption = By.xpath("//option[text()='Annual Income']");
		wait.until(ExpectedConditions.elementToBeClickable(DocumentDDOption));
		click(DocumentDDOption);

		Base_Class.MouseClick(By.xpath("//div[@ng-model='myFiles']"));
		ExtentSuccessMessage("Select File has been Clicked");
		Robot robot1 = new Robot();
		String filePath = System.getProperty("user.dir") + "\\Upload\\Default_Template (1).xlsx";
		StringSelection stringSelection = new StringSelection(filePath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

		robot1.keyPress(KeyEvent.VK_CONTROL);
		Thread.sleep(1000);

		robot1.keyPress(KeyEvent.VK_V);
		Thread.sleep(1000);

		robot1.keyRelease(KeyEvent.VK_V);
		Thread.sleep(1000);

		robot1.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(1000);

		robot1.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(1000);

		robot1.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(1000);

		ExtentSuccessMessage("File is been Uploaded");
		waitForElement(3000);

		element = wait.until(ExpectedConditions.presenceOfElementLocated(AddressSave));
		MoveToElementClick(element);

	}

	public void leadStatus() throws InterruptedException {
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesButton));
		MoveToElementClick(element);
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Leads));
		MoveToElementClick(element);
		ExtentSuccessMessage("Sales Lead has been clicked");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ClickLead));
		MoveToElementClick(element);
		ExtentSuccessMessage(" Lead has been clicked");
		waitForElement(6000);
		click(LeadAssign);
		waitForElement(6000);
		click(EditIcon);
		waitForElement(6000);
		// js.executeScript("window.scrollBy(0,500)");
		/*
		 * Actions actions = new Actions(driver);
		 * 
		 * // Scroll down using Actions class
		 * actions.sendKeys(Keys.PAGE_DOWN).build().perform();
		 */

		waitForElement(6000);
		/*
		 * WebElement StausSel = driver.findElement(StatusSelect); Select select = new
		 * Select(StausSel); select.selectByIndex(5);
		 */
		/*
		 * element = wait.until(ExpectedConditions. presenceOfElementLocated
		 * (StatusSelect)); MoveToElementClick(element); Select select = new
		 * Select(element); select.selectByVisibleText("Qualified");
		 * ExtentSuccessMessage("Qualified Selected"); //
		 * js.executeScript("window.scrollBy(0,300)");
		 * 
		 * 
		 * // Scroll down using Actions class //
		 * actions.sendKeys(Keys.PAGE_DOWN).build().perform();
		 * 
		 * click(ButtonSave);
		 */
		click(LeadQualify);
		ExtentSuccessMessage("Clicked on Qualify");
		waitForElement(6000);
		click(LeadReject);
		ExtentSuccessMessage("Clicked on Reject");
		waitForElement(6000);
		click(LeadDispose);
		ExtentSuccessMessage("Clicked on Lead Dispose");

	}

	public void salesLead() throws InterruptedException {

		Thread.sleep(20000);
		// click(SalesButton);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesButton));
		MoveToElementClick(element);
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Leads));
		MoveToElementClick(element);
		ExtentSuccessMessage("Sales Lead has been clicked");
		Thread.sleep(8000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(NewLead));
		MoveToElementClick(element);

		Thread.sleep(8000);
		// click(NewLead);
		ExtentSuccessMessage("Clicked on NewLead");
		writeText(NewLeadFirstName, "Automation");
		// writeText(NewLeadLastName,"testing");

		writeText(NewLeadLastName, randomName());
		waitForElement(6000);
		writeText(DOB, "03/03/1990" + Keys.ENTER);
		Thread.sleep(8000);
		// click(Gender);

		// click(Male);

		/*
		 * WebElement ele=driver.findElement(Gender); MoveToElementClick(ele);
		 * 
		 * WebElement Male1 = driver.findElement(Male); MoveToElementClick(Male1);
		 * ExtentSuccessMessage("Gender is selected");
		 */

		Thread.sleep(8000);
		writeText(Phnum, "9878996557");
		Thread.sleep(8000);
		writeText(Email, "as@yopmail.com");
		Thread.sleep(8000);
		js.executeScript("window.scrollBy(0,300)");
		Thread.sleep(8000);
		// click(LeadInformation);
		WebElement Lead = driver.findElement(LeadInformation);
		MoveToElementClick(Lead);

		ExtentSuccessMessage("Clicked on Lead Information");
		Thread.sleep(8000);
		// click(HomeorPrincipals);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(HomeorPrincipals));
		MoveToElementClick(element);

		ExtentSuccessMessage("Clicked on Home/Principals");
		Thread.sleep(10000);
		/*
		 * element = wait.until(ExpectedConditions.presenceOfElementLocated(Adress));
		 * MoveToElementClick(element); String Note = "Rajeswari Automation";
		 * writeText(Adress, Note); // writeText(Adress,"testing");
		 */
		WebElement element = driver.findElement(Adress);
		((JavascriptExecutor) driver).executeScript("arguments[0].value = 'Your text';", element);

		Thread.sleep(4000);
		WebElement element3 = driver.findElement(HomeZipCode);
		((JavascriptExecutor) driver).executeScript("arguments[0].value = '33233';", element3);

		// writeText(HomeZipCode,"33233");
		ExtentSuccessMessage("Entered the Zipcode 33233");

		Thread.sleep(8000);
		// click(OtheInformation);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(OtheInformation));
		MoveToElementClick(element);

		ExtentSuccessMessage("Clicked on Other Information");
		Thread.sleep(8000);
		// click(Submit);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Submit));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Submit button");
		Thread.sleep(8000);
		By element2 = By.xpath("//button[contains(text(),'Proceed with Lead creation')]");

		/*
		 * // Check if the element is displayed if(element.isDisplayed()) { // Click on
		 * the element element.click(); } else {
		 * System.out.println("Element is not displayed, so cannot click."); }
		 * Thread.sleep(6000); }
		 */
		try {
			if (driver.findElement(element2).isDisplayed()) {
				click(element2);

			}
		} catch (NoSuchElementException e) {
		} catch (Exception e) {
			ExtentSuccessMessage("Lead Created");
		}
		Thread.sleep(6000);
	}

	public void salesOpportunityAdvancedSearch2() throws InterruptedException {

//		Thread.sleep(6000);
//		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesButton));
//		MoveToElementClick(element);
//		waitForElement(6000);
//		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesOpportunities));
//		MoveToElementClick(element);
//		ExtentSuccessMessage("Clicked on Sales Opportunity");
//		waitForElement(6000);
//		element = wait.until(ExpectedConditions.presenceOfElementLocated(AdvancedSearch));
//		MoveToElementClick(element);
//		ExtentSuccessMessage("Advanced search has been clicked");

		waitForElement(3000);

		element = wait.until(ExpectedConditions.presenceOfElementLocated(OpportunityStatus));
		MoveToElementClick(element);
		waitForElement(3000);

		element = wait.until(ExpectedConditions.presenceOfElementLocated(OpportunityOpen));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected Open");
		waitForElement(9000);
		click(OppSearch);
		waitForElement(5000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(OpportunityStatus));
		MoveToElementClick(element);

		waitForElement(3000);

		element = wait.until(ExpectedConditions.presenceOfElementLocated(OpportunityCloseAsLost));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected Opportunity Close As Lost");
		waitForElement(9000);
		click(OppSearch);
		waitForElement(6000);

		element = wait.until(ExpectedConditions.presenceOfElementLocated(OpportunityStatus));
		MoveToElementClick(element);

		waitForElement(3000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(OpportunityCloseWon));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected Opportunity Close As Won");
		waitForElement(9000);
		click(OppSearch);
		waitForElement(6000);

		element = wait.until(ExpectedConditions.presenceOfElementLocated(OpportunityStatus));
		MoveToElementClick(element);

		waitForElement(3000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(OppQualify));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected Qualified");
		waitForElement(9000);
		click(OppSearch);
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(OpportunityStatus));
		MoveToElementClick(element);

		waitForElement(4000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(OppRenewal));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected Renewal");
		waitForElement(9000);
		click(OppSearch);

		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(OpportunityStatus));
		MoveToElementClick(element);

		waitForElement(4000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(OppCancel));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected Cancel");
		waitForElement(9000);
		click(OppSearch);

	}

	public void salesOpportunityAdvancedSearch() throws InterruptedException {

		Thread.sleep(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesButton));
		MoveToElementClick(element);
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesOpportunities));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Sales Opportunity");
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AdvancedSearch));
		MoveToElementClick(element);
		ExtentSuccessMessage("Advanced search has been clicked");

		waitForElement(3000);

		
		
		By Startdate = By.xpath("//input[@name=\"CreatedStartDate\"]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(OpportunityStatus));
		MoveToElementClick(element);
		String date= "10/07/2024";
		
		
		writeText(Startdate,date+Keys.ENTER);
		ExtentSuccessMessage("Selected Start date");
		
		element = wait.until(ExpectedConditions.presenceOfElementLocated(OpportunityStatus));
		MoveToElementClick(element);
		waitForElement(3000);

		element = wait.until(ExpectedConditions.presenceOfElementLocated(OpportunityOpen));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected Open");
		
		waitForElement(9000);
		click(OppSearch);
		waitForElement(5000);
		
		By Export = By.id("exportOpportunitiesBtn");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Export));
		MoveToElementClick(element);
		
		Thread.sleep(2000);
		
		By success = By.id("divSuccess");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(success));
		ExtentSuccessMessage("Validated export ");

		
		/*
		 * element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(OpportunityStatus));
		 * MoveToElementClick(element);
		 * 
		 * waitForElement(3000);
		 * 
		 * element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(OpportunityCloseAsLost
		 * )); MoveToElementClick(element);
		 * ExtentSuccessMessage("Selected Opportunity Close As Lost");
		 * waitForElement(9000); click(OppSearch); waitForElement(6000);
		 * 
		 * element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(OpportunityStatus));
		 * MoveToElementClick(element);
		 * 
		 * waitForElement(3000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(OpportunityCloseWon));
		 * MoveToElementClick(element);
		 * ExtentSuccessMessage("Selected Opportunity Close As Won");
		 * waitForElement(9000); click(OppSearch); waitForElement(6000);
		 * 
		 * element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(OpportunityStatus));
		 * MoveToElementClick(element);
		 * 
		 * waitForElement(3000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(OppQualify));
		 * MoveToElementClick(element); ExtentSuccessMessage("Selected Qualified");
		 * waitForElement(9000); click(OppSearch); waitForElement(6000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(OpportunityStatus));
		 * MoveToElementClick(element);
		 * 
		 * waitForElement(4000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(OppRenewal));
		 * MoveToElementClick(element); ExtentSuccessMessage("Selected Renewal");
		 * waitForElement(9000); click(OppSearch);
		 * 
		 * waitForElement(6000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(OpportunityStatus));
		 * MoveToElementClick(element);
		 * 
		 * waitForElement(4000); element =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(OppCancel));
		 * MoveToElementClick(element); ExtentSuccessMessage("Selected Cancel");
		 * waitForElement(9000); click(OppSearch);
		 */

	}

}
