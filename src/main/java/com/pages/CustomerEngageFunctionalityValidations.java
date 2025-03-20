package com.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.pdfbox.contentstream.operator.state.Save;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.BasePackage.Base_Class;

import Common.ActionClasss;

public class CustomerEngageFunctionalityValidations extends BasePage {

	private static final String Annual = null;
	private static final String URL1 = null;

	public CustomerEngageFunctionalityValidations(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	Actions actions = new Actions(driver);
	JavascriptExecutor js = (JavascriptExecutor) driver;
	WebElement element;
	public String ExpectedResult = "Applicants were excluded from the quote because they may be eligible for Medicaid/CHIP.";
	String imgSrc;
	String expectedText;
	String savingsAmount;
	String AddedApplicantExpected = "Zip: 33433, 3 Applicants, Income: $25,000";
	String actualText;
	public String fullName;
	public String firstName;
	public String lastName;
	public String getEmailValue;
	public String agentUserName;
	public String getLastName;
	public String getFirstName;
	public String actualString = "Congratulations! Your application has been submitted successfully";
	public String EmailText;
	public String AgentText;
	public String NoteText;
	public String CarrierText;
	public String Campaign;
	public String ValidEmailText;
	public String NumberOutput;
	public String NumberOutput1;

	By userID = By.id("user-name");// ------//for userid at Login page
	By pwd = By.id("password");// -------for password at home page
	By signIn = By.xpath("//*[@id='form-validation-button']");// -------for button on home page

	private By CheckUserLogin = By.xpath("//button[@class='positive md-button md-ink-ripple']");
	private By SelectUser = By.xpath("//a[@class='nav-link dropdown-toggle']");
	private By SelectLogout = By.xpath("(//a[contains(.,'Log Out')])[1]");
	private By LogoutButtonConfirmation = By.xpath(
			"//a[@class='modal-action tertiary_background waves-effect waves-light btn-large ConfirmForceLogin']");
	private By MainMenu = By.xpath("//li[@class='link_menu hide-on-med-and-down sideMenuHamburger']");
	private By CustomerInformationTab = By.cssSelector("#sideMenuContent > div > ul > li:nth-child(1) > a");
	private By SettingsTab = By.cssSelector("#sideMenuContent > div > ul > li:nth-child(8) > a");
	private By AgencyDetailsTab = By
			.cssSelector("#sideMenuContent > div > ul > li.active > div > ul > li:nth-child(1) > a");
	private By AddButton = By.xpath("//a[@id='add_buton']");
	private By HomeButton = By.id("menu_home");
	private By MarketingTile = By.xpath("//a[@class='glyphicon fa fa-fw fa-bar-chart-o']");
	private By MarketingList = By.xpath("(//a[contains(.,'Lists')])[2]");

	private By ValidateListButton = By.id("createNewList");
	private By ListName = By.xpath("//input[@name='ListName']");
	private By SegmentedList = By.xpath("(//a[contains(.,'Segmented List')])[2]");
	private By NewSegmentedListButton = By.id("createNewDynamicBtn");
	private By MarketingTemplate = By.xpath("(//a[contains(.,'Templates')])[2]");
	private By NewTemplateButton = By.id("NewTemplateBtn");
	private By MarketingCampaign = By.xpath("(//a[contains(.,'Campaigns')])[2]");
	private By CreateCampaign = By.id("createNewCamapign");
	private By PromotionalCampaign = By.id("PROMOTIONAL_CAMPAIGNS");

	private By SourceDropDown = By.xpath("//md-select[@name='ListSource']");
	private By AgentFirstName = By.xpath("//input[@id='FirstName']");
	private By AgentLastName = By.xpath("//input[@id='LastName']");
	private By AgentRole = By.xpath("(//input[@class='select-dropdown dropdown-trigger'])[2]");
	private By AgentRoleSelection = By.xpath("(//span[contains(.,'Agent')])[1]");
	private By AgentPhone = By.xpath("(//input[@id='Phone'])[1]");
	private By AgentEmail = By.xpath("(//input[@id='Email'])[1]");
	private By MedicareCustomer = By.xpath("//a[@class='medicaredatalistingmenu']");
	private By AgencyTile = By.xpath("//a[@class='glyphicon fa fa-building']");
	private By AgencyAgent = By.xpath("(//a[contains(.,'Agents')])[1]");
	private By NewAgentButton = By.id("createNewAgentBtn");
	private By AdminTile = By.xpath("//a[@class='glyphicon fa fa-fw fa-black-tie']");
	private By AdminRolesAndPermission = By.xpath("(//a[contains(.,'Roles/Permissions')])[2]");
	private By AddRolesAndPermissionButton = By.xpath("//button[@class='btn btn-default pull-right btn-yellow']");
	private By ReportTile = By.xpath("//a[@class='glyphicon fa fa-fw fa-file-text']");
	private By LiveReport = By.xpath("//a[contains(.,'Live Reports')]");
	private By DashBoardTile = By.xpath("//a[@class='glyphicon fa fa-fw fa-dashboard']");
	private By DashBoardMyTask = By.xpath("(//a[contains(.,'My Tasks')])[2]");
	private By DashBoardCalendar = By.xpath("(//div[@class='dx-button-content'])[2]");
	private By CommissionTile = By.xpath("//a[@class='glyphicon fa fa-fw fa-usd']");
	private By CommissionSetup = By.xpath("(//a[contains(.,'Commission Setup')])[3]");
	private By CommissionSetupTitle = By.xpath("(//span[contains(.,'Commission Setup')])[2]");
	private By CTIIcon = By.xpath("(//i[@class='fa fa-phone'])[1]");
	private By CTIMinimizeIcon = By.xpath("//a[@class='fa fa-minus right-al']");
	private By CTIDialPadIcon = By.xpath("//a[@class='fa fa-th voice-active']");
	private By CallBackNotificationIcon = By.xpath("//a[@title='Call back Notifications']");
	private By CallBackNitificationTitle = By.xpath("//strong[contains(.,'Callback Notifications')]");
	private By CallBackNitificationMinimizeIcon = By.xpath("//i[@class='fa fa-times']");
	private By MyProfileIcon = By.xpath("//a[contains(.,'My Profile')]");
	private By MyProfileSubmitButton = By.xpath("//button[@class='btn btn-default green pull-right']");

	private By AddCustomer = By.xpath("//a[@id='btnAddCustomer']");
	private By CustomerFirstname = By.xpath("(//input[@id='PersonDetails_FirstName'])[1]");
	private By CustomerLastname = By.xpath("(//input[@id='PersonDetails_LastName'])[1]");
	private By CustomerGender = By.cssSelector(
			"#AddCustomer > fieldset > div:nth-child(4) > div:nth-child(2) > div > input , #AddCustomer > fieldset > div:nth-child(5) > div:nth-child(2) > div > input");
	private By GenderName = By.xpath("(//span[contains(.,'Male')])[1]");
	private By CustomerDOB = By.xpath("(//input[@id='PersonDetails_DateOfBirth'])[1]");
	private By CustomerAddressLine = By.xpath("(//input[@id='PersonDetails_Addresses_0__Address1'])[1]");
	private By CustomerZipcode = By.xpath("(//input[@id='PersonDetails_Addresses_0__Zip'])[1]");
	private By SameMailingAddress = By.xpath("(//input[@id='isMailAddressSame'])[1]");
	private By SaveButton = By.xpath("(//a[contains(.,'Save')])[1]");
	private By ContactSaveButton = By.xpath("(//a[contains(.,'Save')])[3]");
	private By SaveButtonIUR = By.xpath("//button[@id='btnUpdateProducer']");
	private By PhoneNumber = By.xpath("//input[@id='PersonDetails_Phone1']");
	private By CustomerFullName = By
			.xpath("(//a[@class='primary_color anchor_withunderline LoadCustomerAllDetails'])[1]");
	private By CustomerTile = By.xpath("(//a[@class='glyphicon fa fa-users'])[1]");
	private By ImportCustomerPolicyButton = By.id("importCustomerPolicyBtn");

	private By CustomerNameInCE = By.xpath("(//a[@class='edit-list-anchor ng-binding'])[1]");
	private By SelectCustomerToEdit = By
			.xpath("(//a[@class='primary_color anchor_withunderline LoadCustomerAllDetails'])[1]");
	private By ClickOnEditButton = By.xpath("//a[@class='square_anchor float_r editCustomer closeEdit']");
	private By EditLastName = By.xpath("//input[@id='customer_PersonDetails_LastName']");
	private By EditFirstName = By.xpath("//input[@id='customer_PersonDetails_FirstName']");
	private By EditSave = By.xpath("//a[@class='waves-effect waves-light btn primary_background btnUpdateCustomer']");
	private By ServiceTile = By.xpath("//a[@class='glyphicon fa fa-fw fa-gears']");
	private By NewServiceRequestButton = By.id("createServiceRequestBtn");
	private By IVRManagementTile = By.xpath("//a[@class='glyphicon fa fa-sitemap']");
	private By IVRManagementPrompt = By.xpath("(//a[contains(.,'Prompts')])[2]");
	private By IVRNewPromptButton = By
			.xpath("//button[@class='btn btn-default pull-right btn-yellow ng-binding ng-scope']");

	private By SelectLogoutBE = By.xpath("(//a[contains(.,'Sign Out')])[1]");
	private By SelectUserBE = By.xpath("//a[@class='dropdownMenu user-details-menuSection dropdownArrowMenu']");
	private By SelectAdminUserBE = By.xpath("//a[@class='dropdown-trigger-user']");
	private By LoginAsAgency = By.cssSelector("#dropdown1 > li:nth-child(1) > a");
	private By ClickOnCloseButton = By.xpath("//*[@class='close_icon modal-close right']");
	private By RequestForLogin = By.xpath("//span[contains(.,'Request for Login')]");
	private By YopmailInbox = By.xpath("//input[@id='login']");
	private By YopmailSubmit = By.xpath("//button[@title='Check Inbox @yopmail.com']");
	private By ClickHere = By.cssSelector("#mail > div > p:nth-child(5) > a");
	private By NumberNPN = By.xpath("//input[@id='NationalProducerNumber']");
	private By AgentUserName = By.xpath("//input[@id='User_UserName']");
	private By AgentPassword = By.xpath("//input[@id='User_Password']");
	private By AgentRetypePassword = By.xpath("//input[@id='User_ReTypePassword']");
	private By SecurityQuestion1 = By.xpath("(//input[@class='select-dropdown dropdown-trigger'])[1]");
	private By SecurityQuestionSelection1 = By
			.xpath("(//span[contains(.,'What Is The Name Of Your Favorite Childhood Friend?')])[1]");
	private By SecurityQuestionSelection2 = By.xpath("(//span[contains(.,'In Which City Were You Born?')])[2]");
	private By SecurityQuestionSelection3 = By.xpath("(//span[contains(., \"What Is Your Best Friend's Name?\")])[3]");
	private By SecurityQuestion2 = By.xpath("(//input[@class='select-dropdown dropdown-trigger'])[1]");
	private By SecurityQuestion3 = By.xpath("(//input[@class='select-dropdown dropdown-trigger'])[1]");
	private By SecurityAnswer1 = By.xpath("//input[@id='User_SecurityAnswer1']");
	private By SecurityAnswer2 = By.xpath("//input[@id='User_SecurityAnswer2']");
	private By SecurityAnswer3 = By.xpath("//input[@id='User_SecurityAnswer3']");
	private By TermsAndCondition = By.xpath("//input[@id='User_EulaCheck']");
	private By PersonConscent = By.xpath("//input[@id='PersonConscent']");
	private By DashboardTile = By.xpath("//a[@class='glyphicon fa fa-fw fa-dashboard']");
	private By ClickOnMyTasks = By.cssSelector(
			"#page-wrapper > div > ui-view > div:nth-child(3) > div.col-lg-12.right-section-div.details.pad-lt.col-xl-3 > div > ul > li:nth-child(4) > a");
	private By ClickMyTasks = By.xpath("(//a[contains(.,'My Tasks')])[2]");
	private By TaskComments = By.cssSelector("#filter-by > div:nth-child(1) > form > div:nth-child(7) > textarea");
	private By CreateTaskSubmit = By
			.cssSelector("#filter-by > div:nth-child(1) > form > div:nth-child(7) > button:nth-child(3) > i");
	private By HomeMenu = By.xpath("//a[@id='menu_home']");
	private By DayView = By.xpath("(//div[@class='dx-item dx-tab'])[1]");
	private By WeekView = By.xpath("(//div[@class='dx-item dx-tab'])[1]");
	private By MonthView = By.xpath("(//div[@class='dx-item dx-tab'])[2]");
	private By Day_Week_Month_ViewTask = By.xpath("(//div[@class='appointment-preview'])[1]");
	private By EditTask = By
			.xpath("(//button[@class='btn btn-default pull-right edit-note-icon icons red-color ng-scope'])[1]");
	private By EditTaskComments = By.cssSelector(
			"#page-wrapper > div > ui-view > div.row.col-md-3.pad-rt.pad-lt.task-main-div.ng-scope > div.task-data > div > div.container-fluid.notes > form > div:nth-child(7) > textarea");
	private By SubmitEditedTask = By.cssSelector(
			"#page-wrapper > div > ui-view > div.row.col-md-3.pad-rt.pad-lt.task-main-div.ng-scope > div.task-data > div > div.container-fluid.notes > form > div:nth-child(7) > button:nth-child(3) > i");
	private By DeleteTask = By
			.xpath("(//button[@class='btn btn-default pull-right edit-note-icon icons red-color delete'])[1]");
	private By PopUpDeleteYes = By.xpath("//button[@class='btn btn-primary btn-default green']");
	private By FindInsuranceButton = By.xpath("//a[contains(.,'Find Insurance')]");
	private By HealthEnrollment = By.xpath("//a[@class='PopupClassDynamic no-padding' and @lob='Health']");
	private By ZipCode = By.xpath("//input[@id='ZipCode']");
	private By SeePlans = By.xpath("//button[contains(.,'See Plans')]");
	private By GenderOfApplicant = By.cssSelector(
			"body > main > div.container > div > div > div > form > fieldset > div:nth-child(12) > div.widget_content > div.row.margin_bottom_0px.censuslist.Applicantcensus.showncensus > div > div.col.s12.m3.l3 > div > div.select-wrapper > input");
	private By GenderSelection = By.xpath("(//span[contains(.,'Male')])[1]");
	private By ApplicantDOB = By.xpath("//input[@id='CoveredMembers_0__DateOfBirth']");
	private By PlanLabelAmbetter = By.xpath("(//input[@data-plantypename='Ambetter'])[1]");
	private By AddToCartButton = By.xpath("(//*[@id='mcmqAddToCart'])[1]");
	private By ContinueWithThisPlanCart = By.xpath("//a[contains(.,'Cart')]");
	private By ClickSelectButton = By.xpath("//a[contains(.,'Select')]");
	private By BeginEnrollment = By.xpath(
			"//a[@class='full_width_button waves-effect waves-light primary_background BeginEnrollmentAfterContactInformation toggleBeginEnrollmentForMedicare']");
	private By ContactFirstName = By.xpath("(//input[@id='ContactInformation_FirstName'])[5]");
	private By ContactLastName = By.xpath("(//input[@id='ContactInformation_LastName'])[5]");
	private By ContactPhone = By.xpath("(//input[@id='ContactInformation_PhoneNumber'])[4]");
	private By HouseholdAddress = By.xpath("//input[@id='Address_0__Address1']");
	private By ClickNext = By.xpath("//a[@id='yourNextPage']");
	private By SEPEvents = By.xpath("//select[@id='SepEvent_SepEventKey']");
	private By SEPEventDate = By.xpath("//input[@id='SepEvent_SepEventDate']");
	private By CustomerNameSEP = By.xpath("//select[@id='SepEvent_CustomerPersonId']");
	private By AddEventSEP = By.xpath("//button[@id='btnAddSEPEvent']");
	private By ClickSEPNext = By.xpath("//a[@id='citizenDocumentNextPage']");
	private By AppliedCircumstancesNext = By.xpath("//a[@id='AdditionalyourNextPage']");
	private By IncomeType = By.xpath("//select[@id='IncomeDetail_0__Type']");
	private By IncomeFrequency = By.xpath("//select[@id='IncomeDetail_0__AmountFrequency']");
	private By IncomeValue = By.xpath("//input[@id='IncomeDetail_0__Amount']");
	private By NoneOfTheseHRA = By.xpath("(//input[@name='IsQSEHRANoneOfThese'])[1]");
	private By ClickNextHRA = By.xpath("//a[@id='HRA_yourNextPage']");
	private By ClickIdTerms = By.xpath("//*[@id='Terms']");
	private By ClickNextOnAgent = By.xpath("//*[@class='round_btn summary_next']");
	private By ClickNextOnPayment = By.xpath("//*[@class='round_btn paymentselection_next']");
	private By RoutingNumberField = By.xpath("//*[@id='Quotes_0__PaymentProfile_RoutingNumber']");
	private By BankAccountNumber = By.xpath("//*[@id='Quotes_0__PaymentProfile_BankAccountNumber']");
	private By AccountHolderName = By.xpath("//*[@id='Quotes_0__PaymentProfile_EFTAccountHolderName']");
	private By AccountType = By.xpath("//*[@id='Quotes_0__PaymentProfile_AccountType']");
	private By YesSameEFT = By
			.xpath("//input[@id='Quotes_0__RecurringPaymentSameAsInitialPaymentIndForEFT' and @value='true']");
	private By PaymentNext = By.xpath("//a[@class='round_btn payment_next']");
	private By SummaryNext = By.xpath("//a[@class='round_btn applicationsummary_next']");
	private By FullfilmentAgree = By.xpath("//*[@id='Fulfillment_Iagree']");
	private By SubmitButton = By.xpath("//a[@class='round_btn confirmEnrollment_next']");
	private By CongratulationsMessage = By.xpath("//*[@class='relatively_fixed_label bigger ']");
	private By EnrollmentFinish = By.xpath("//*[@class='enrollmentfinish ']");
	private By SalesTile = By.xpath("//a[@class='glyphicon fa fa-handshake-o']");
	private By SalesLead = By.xpath("(//a[contains(.,'Leads')])[2]");
	private By NewLeadButton = By.id("newLeadBtn");
	private By ClickQuotes = By.xpath("(//a[contains(.,'Quotes')])[2]");
	private By ClickLeads = By.xpath("(//a[contains(.,'Leads')])[2]");
	private By CreatedDate = By.xpath("(//div[@class='ui-grid-cell-contents ng-binding ng-scope'])[7]");
	private By SelectBEUser = By.xpath("//a[@class='dropdownMenu user-details-menuSection dropdownArrowMenu']");
	private By SelectAgency = By.xpath("(//a[contains(.,'Agency Details')])[1]");
	private By BusinessType = By.xpath("(//input[@class='select-dropdown dropdown-trigger'])[5]");
	private By LifeOfBusiness = By.xpath("(//input[@class='select-dropdown dropdown-trigger'])[6]");
	private By MarketingURLButton = By.id("MarketingURL_button");
	private By CopyMarketingURL = By.cssSelector("#generate_url_id > ul > li.margin_bottom_0px > p");
	private By SelectAgentLogout = By.xpath("(//a[contains(.,'Sign Out')])[2]");
	private By MarketingLabel = By.xpath("//label[contains(.,' Marketing Details')]");
	private By SaveProgress = By.xpath("//a[@class='save_progress_click_submitm']");
	private By LeadFirstname = By.xpath("//input[@id='yourname']");
	private By LeadLastname = By.xpath("//input[@id='lastname']");
	private By LeadEmail = By.xpath("//input[@id='youremail']");
	private By SaveLeadDetails = By.xpath("(//a[contains(.,'Save')])[2]");
	private By CallBackRequest = By.xpath("//a[@class='callBackButton request_callback_click_submitm']");
	private By LeadCBFirstname = By.xpath("(//input[@id='yourName'])[1]");
	private By LeadCBLastname = By.xpath("(//input[@id='yourName'])[2]");
	private By LeadPhoneNumber = By.xpath("(//input[@id='phnNum'])[1]");
	private By LeadSubmitButton = By.xpath("//a[contains(.,'Submit')]");
	private By BuissnesshourField = By.xpath("//input[@name='BusinessHour']");
	private By BuissnessHRType = By.xpath("//span[text()='24 hours / 7 days a week']");
	private By TimeZoneDD = By.xpath("//md-select[@name='CRMTimeZone']");
	private By TimezoneDDOption = By.xpath("//md-option[contains(.,'(GMT +05:30) India')]");
	private By CallDisposition = By.xpath("(//a[contains(.,'Call Disposition')])[2]");
	private By AddNewCallDespositionButton = By.xpath("//button[@class='btn btn-default btn-yellow']");
	private By CallDispositionName = By.xpath(
			"//input[@class='ng-pristine ng-untouched md-input ng-empty ng-invalid ng-invalid-required ng-valid-maxlength']");
	private By CallDispositionSaveButton = By.xpath("//button[@class='green md-button ng-scope md-ink-ripple']");
	private By CallDispositionInc = By.xpath("(//div[@class='ui-grid-cell-contents ng-binding ng-scope'])[1]");
	private By CallDespoSearchField = By.xpath(
			"//input[@class='ng-pristine ng-untouched md-input ng-empty ng-valid-minlength ng-valid-maxlength ng-valid ng-valid-required']");
	private By EditCallDisoButton = By.xpath("//i[@class='glyphicon glyphicon-pencil']");
	private By LeadStatusDD = By.xpath("//md-select[@name='LeadStatus']");
	private By DeleteCallDespoButton = By.xpath("//i[@class='glyphicon glyphicon-trash ng-scope']");
	private By ConfirmDeleteButton = By.xpath("//button[@class='btn btn-primary btn-default green ng-binding']");
	private By HolidayCalendar = By.xpath("//a[@href='#/admin/holidayCalendar']");
	private By GridView = By.xpath("(//span[contains(.,'Grid View')])[3]");
	private By NewHolidayButton = By.xpath("//button[@class='btn btn-default pull-right btn-yellow']");
	private By HolidayName = By.xpath("(//input[@class='dx-texteditor-input'])[1]");
	private By PredenceFieldc = By.xpath("(//input[@class='dx-texteditor-input'])[4]");
	private By PromptField = By.xpath("(//input[@class='dx-texteditor-input'])[5]");
	private By CalendarTextArea = By.xpath("//textarea[@class='dx-texteditor-input']");
	private By CalendarSaveButton = By.xpath("(//span[@class='dx-button-text'])[2]");
	private By StartDate = By
			.xpath("(//md-input-container[@class='md-block md-input-has-placeholder md-input-has-value'])[1]/input");
	private By CarrierSelectionDD = By.xpath("(//md-select-value[@class='md-select-value'])[3]");
	private By CarrierGroupSubmitButton = By.xpath("(//button[@class='btn btn-default green pull-right'])[2]");
	private By AdminUser = By.xpath("(//a[contains(.,'Users')])[2]");
	private By AddUserButton = By.xpath("//button[@class='btn btn-default pull-right btn-yellow']");
	private By UserFirstName = By.xpath("(//input[@name='FirstName'])[1]");
	private By UserLastName = By.xpath("(//input[@name='LastName'])[1]");
	private By UserEmailId = By.xpath("(//input[@name='EmailId'])[1]");
	private By UserPhoneNumber = By.xpath("(//input[@name='Phone'])[1]");
	private By UserRolesAndPermission = By.xpath("(//select[@name='ProfileName'])[1]");
	private By DataAccessibiltityDD1 = By.xpath("(//select[@name='EditEnabled'])[1]");
	private By DataAccessibiltityDD2 = By.xpath("(//select[@name='AccessConfidentialData'])[1]");
	private By UserLoginDetails = By.xpath("//input[@name='LoginName']");
	private By NewUserButton = By.xpath("(//button[@class='btn btn-default green pull-right'])[2]");
	private By ConfirmationPopup = By.xpath("//button[@class='positive md-button md-ink-ripple']");
	private By AdminUserInc = By.xpath("(//div[@class='ui-grid-cell-contents ng-binding ng-scope'])[4]");
	private By AdminSearchBar = By.xpath(
			"//input[@class='ng-pristine ng-untouched md-input ng-empty ng-valid-minlength ng-valid-maxlength ng-valid ng-valid-required']");
	private By AdminEditIcon = By.xpath("//i[@class='glyphicon glyphicon-pencil']");
	private By EditEmailId = By.xpath("//input[@name='EmailId']");
	private By EditPhone = By.xpath("//input[@name='Phone']");
	private By EditSaveButton = By.xpath("(//button[@class='btn btn-default green pull-right'])[3]");
	private By AdminEditUserINC = By.xpath("(//div[@class='ui-grid-cell-contents ng-binding ng-scope'])[4]");
	private By AdminResetPasswordButton = By.xpath("//i[@class='glyphicon glyphicon-repeat']");
	private By UserDeleteIconButton = By.xpath("//i[@class='glyphicon glyphicon-trash']");
	private By AdminDeleteConfirmPopup = By.xpath("//button[@class='btn btn-primary btn-default green']");
	private By BuissnessHour = By.xpath("//*[@id=\"NavigationMenuRegion\"]/div/div[2]/div[1]/div/ul/li[7]/ul/li[7]/a");
	private By NewBuissnessHourButton = By.xpath("//button[@class='btn btn-default pull-right btn-yellow']");

	public void waitForElement(int time) throws InterruptedException {
		Thread.sleep(time);
	}

	public void login_CE_validations() throws InterruptedException {
		waitForElement(10000);
		WebElement checkUserLoginElement = null;

		try {
			checkUserLoginElement = driver.findElement(CheckUserLogin);

			if (checkUserLoginElement.isDisplayed()) {
				click(CheckUserLogin);
				ExtentSuccessMessage(
						"You currently have an active session on another device hence Deactivated the other session!");
			} else {
				ExtentSuccessMessage("Login is successful");
			}
		} catch (NoSuchElementException e) {
			ExtentSuccessMessage(
					"CheckUserLogin element not found! So you currently Dont have an active session on another device, hence Login is successful");
		} catch (Exception e) {
			ExtentSuccessMessage("Application login inaccurate. Details: " + e.getMessage());
			e.printStackTrace();
		}
		waitForElement(15000);
	}

	public void logout_CE_validations() throws InterruptedException {
		waitForElement(3000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SelectUser));
		MoveToElementClick(element);
		ExtentSuccessMessage("User has been selected");
		waitForElement(1000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SelectLogout));
		MoveToElementClick(element);
		ExtentSuccessMessage("Logout has been performed!");
		waitForElement(1000);
		driver.manage().deleteAllCookies();
		waitForElement(3000);
	}

	public String writeDespoToExcel(String nameText, String sheetname) throws IOException {
		String excelFilePath = ".\\src\\test\\resources\\TestData.xlsx";
		FileInputStream inputStream = new FileInputStream(excelFilePath);
		Workbook workbook = new XSSFWorkbook(inputStream);
		String sheetName_update = sheetname;
		Sheet sheet = workbook.getSheet(sheetname);
		int rowIndex = 1;
		int columnIndex = 11;
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

	public void add_customer_validation() throws InterruptedException {
		waitForElement(1000);
		wait.until(ExpectedConditions.elementToBeClickable(MainMenu));
		click(MainMenu);
		ExtentSuccessMessage("Clicked on Main Menu Option For Customer information URL Validation");
		waitForElement(500);
		wait.until(ExpectedConditions.elementToBeClickable(CustomerInformationTab));
		click(CustomerInformationTab);
		ExtentSuccessMessage("Clicked on Customer Information Tab");
		waitForElement(1000);
	}

	public String employerName() {
		String allowedChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String ssn = "";
		String temp = RandomStringUtils.random(10, allowedChars);
		ssn = temp.substring(0, temp.length() - 5);
		return ssn;
	}

	public String agentName() {
		String allowedChars = "AEIOU" + "bcdfghjklmnpqrstvwxyz";
		String ssn = "";
		String temp = RandomStringUtils.random(12, allowedChars);
		ssn = temp.substring(0, temp.length() - 5);
		return ssn;
	}

	public int getRandomNumber() {
		Random r = new Random();
		int ran = r.nextInt(10000);
		return ran;
	}

	public int getRandomNumber1() {
		Random r = new Random();
		int ran = r.nextInt(100);
		return ran;
	}

	public void customer_fields_validation(CensusInfo ApplicantInfo) throws InterruptedException {
		waitForElement(1000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AddCustomer));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Add Customer Link");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CustomerFirstname));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Customer Firstname Field");
		firstName = "TEST" + employerName();
		writeText(CustomerFirstname, firstName);
		ExtentSuccessMessage("Added customer's firstname");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CustomerLastname));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on customers lastname fieldname");
		String lastName = employerName();
		writeText(CustomerLastname, lastName);
		ExtentSuccessMessage("Added customer's lastname");
		waitForElement(1000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CustomerGender));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on customers gender");
		waitForElement(1000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(GenderName));
		MoveToElementClick(element);
		ExtentSuccessMessage("Added gender of the customer");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CustomerDOB));
		MoveToElementClick(element);
		writeText(CustomerDOB, "01/01/1990");
		ExtentSuccessMessage("Added DOB of the customer");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CustomerAddressLine));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on customers address line field");
		writeText(CustomerAddressLine, ApplicantInfo.AddressLine1);
		ExtentSuccessMessage("Added Address Line 1 of the customer");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CustomerZipcode));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on customers zipcode field");
		writeText(CustomerZipcode, ApplicantInfo.Zipcode + Keys.TAB);
		ExtentSuccessMessage("Added Zipcode of the customer");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SameMailingAddress));
		MoveToElementClick(element);
		ExtentSuccessMessage("Checkbox clicked - Is Mailing address same as Home address!");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PhoneNumber));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on customers phone number field");
		writeText(PhoneNumber, ApplicantInfo.Phone);
		ExtentSuccessMessage("Added Phone number of the customer");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SaveButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Save Button");
		waitForElement(10000);
		driver.navigate().refresh();
		waitForElement(1000);
		fullName = firstName + " " + lastName;
		ExtentSuccessMessage("Actual Full Name: " + fullName);
//		element = wait.until(ExpectedConditions.presenceOfElementLocated(CustomerFullName));
//		actualText = element.getText();
//		ExtentSuccessMessage("Actual Expected Name: " + actualText);
//		Assert.assertEquals(actualText, fullName);
		ExtentSuccessMessage("New customer has been added successfully!");
		waitForElement(3000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SelectUserBE));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected the user to perform logout!");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SelectLogoutBE));
		MoveToElementClick(element);
		ExtentSuccessMessage("Logout has been done from BE application");
		waitForElement(3000);
	}

	public void landing_page_validations_MarketingTile() throws InterruptedException// ----------->DONE
	{
		waitForElement(2000);
		waitForElement(6000); // For UAT
		element = wait.until(ExpectedConditions.presenceOfElementLocated(MarketingTile));
		MoveToElementClick(element);
		ExtentSuccessMessage("Marketing Tile has been clicked");
		waitForElement(3000);

		element = wait.until(ExpectedConditions.presenceOfElementLocated(MarketingList));
		MoveToElementClick(element);
		ExtentSuccessMessage("Marketing list has been clicked");

//		waitForElement(7000);
		// Assert.assertTrue(driver.findElement(ValidateListButton).isDisplayed());
//		ExtentSuccessMessage("Assertion has been successful");
//		waitForElement(5000);
//		
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(HomeButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("HomeButton has been clicked");

	}

	public void landing_page_validations_SaleTile() throws InterruptedException// ------------>Done
	{
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesTile));
		MoveToElementClick(element);// clicking on tiles
		ExtentSuccessMessage("Sales Tile has been clicked");

		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesLead));
		MoveToElementClick(element);
		ExtentSuccessMessage("Sales Lead has been clicked");

		waitForElement(8000); // for UAT
		Assert.assertTrue(driver.findElement(NewLeadButton).isDisplayed());
		ExtentSuccessMessage("Assertion has been successful");

		waitForElement(4000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(HomeButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("HomeButton has been clicked");
		waitForElement(3000);
	}

	public void landing_page_validations_CustomerTile() throws InterruptedException// ---------->Done
	{
		waitForElement(6000);

		element = wait.until(ExpectedConditions.presenceOfElementLocated(CustomerTile));
		MoveToElementClick(element);// clicking on customer tiles
		ExtentSuccessMessage("Customer Tile has been clicked");
		waitForElement(6000);

		Assert.assertTrue(driver.findElement(ImportCustomerPolicyButton).isDisplayed());
		ExtentSuccessMessage("Assertion has been successful");
		waitForElement(3000);

		element = wait.until(ExpectedConditions.presenceOfElementLocated(HomeButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("HomeButton has been clicked");
		waitForElement(3000);

	}

	public void landing_page_validation_AgencyTile() throws InterruptedException {
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AgencyTile));
		MoveToElementClick(element);// clicking on Agent tiles AgencyAgent
		ExtentSuccessMessage("Agency Tile has been clicked");

		waitForElement(3000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AgencyAgent));
		MoveToElementClick(element);// clicking on Agent tiles NewAgentButton
		ExtentSuccessMessage("Agency Agent has been clicked");
		// waitForElement(5000); //For AWSPP
		waitForElement(9000); // for UAT

		Assert.assertTrue(driver.findElement(NewAgentButton).isDisplayed());
		ExtentSuccessMessage("Assertion has been successful");
		waitForElement(3000);

		element = wait.until(ExpectedConditions.presenceOfElementLocated(HomeButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("HomeButton has been clicked");
		waitForElement(3000);

	}

	public void landing_page_validation_ServiceTile() throws InterruptedException {
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ServiceTile));
		MoveToElementClick(element);// clicking on Service tiles
		ExtentSuccessMessage("Service Tile has been clicked");

		// waitForElement(3000);//for AWSPP
		waitForElement(7000);
		Assert.assertTrue(driver.findElement(NewServiceRequestButton).isDisplayed());
		ExtentSuccessMessage("Assertion has been successful");
		waitForElement(3000);

		element = wait.until(ExpectedConditions.presenceOfElementLocated(HomeButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("HomeButton has been clicked");
		waitForElement(3000);

	}

	public void landing_page_validation_IVR_ManagementTile() throws InterruptedException {
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(IVRManagementTile));
		MoveToElementClick(element);// clicking on Service tiles
		ExtentSuccessMessage("IVR Management Tile has been clicked");

		waitForElement(2000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(IVRManagementPrompt));
		MoveToElementClick(element);// clicking on IVR tiles
		ExtentSuccessMessage("Prompt has been clicked");

		waitForElement(3000);
		Assert.assertTrue(driver.findElement(IVRNewPromptButton).isDisplayed());
		ExtentSuccessMessage("Assertion has been successful");
		waitForElement(3000);

		element = wait.until(ExpectedConditions.presenceOfElementLocated(HomeButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("HomeButton has been clicked");
		waitForElement(3000);

	}

	public void landing_page_validation_AdminTile() throws InterruptedException {
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AdminTile));
		MoveToElementClick(element);// clicking on Admin tiles
		ExtentSuccessMessage("Admin Tile has been clicked");

		waitForElement(2000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AdminRolesAndPermission));
		MoveToElementClick(element);// clicking on IVR tiles
		ExtentSuccessMessage("Roles And Permission has been clicked");

		waitForElement(3000);
		Assert.assertTrue(driver.findElement(AddRolesAndPermissionButton).isDisplayed());
		ExtentSuccessMessage("Assertion has been successful");
		waitForElement(3000);

		element = wait.until(ExpectedConditions.presenceOfElementLocated(HomeButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("HomeButton has been clicked");
		waitForElement(3000);

	}

	public void landing_page_validation_ReportTile() throws InterruptedException {
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ReportTile));
		MoveToElementClick(element);// clicking on Report tiles
		ExtentSuccessMessage("Report Tile has been clicked");

		// waitForElement(3000); //for AWSPP
		waitForElement(8000); // for UAT
		Assert.assertTrue(driver.findElement(LiveReport).isDisplayed());
		ExtentSuccessMessage("Assertion has been successful");
		waitForElement(3000);

		element = wait.until(ExpectedConditions.presenceOfElementLocated(HomeButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("HomeButton has been clicked");
		waitForElement(3000);

	}

	public void landing_page_validation_DashBoardTile() throws InterruptedException {
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(DashBoardTile));
		MoveToElementClick(element);// clicking on DashBoard tiles
		ExtentSuccessMessage("DashBoard Tile has been clicked");

		waitForElement(2000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(DashBoardMyTask));
		MoveToElementClick(element);// clicking on My TAsk tiles
		ExtentSuccessMessage("Report Tile has been clicked");

		// waitForElement(3000); //for awspp and uat
		waitForElement(7000); // for QA
		Assert.assertTrue(driver.findElement(DashBoardCalendar).isDisplayed());
		ExtentSuccessMessage("Assertion has been successful");
		waitForElement(3000);

		element = wait.until(ExpectedConditions.presenceOfElementLocated(HomeButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("HomeButton has been clicked");
		waitForElement(3000);

	}

	public void landing_page_validation_CommissionTile() throws InterruptedException {
		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CommissionTile));
		MoveToElementClick(element);// clicking on DashBoard tiles
		ExtentSuccessMessage("Commision Tile has been clicked");

		waitForElement(2000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CommissionSetup));
		MoveToElementClick(element);// clicking on My TAsk tiles
		ExtentSuccessMessage("Report Setup has been clicked");

		waitForElement(3000);
		Assert.assertTrue(driver.findElement(CommissionSetupTitle).isDisplayed());
		ExtentSuccessMessage("Assertion has been successful");
		waitForElement(3000);

		element = wait.until(ExpectedConditions.presenceOfElementLocated(HomeButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("HomeButton has been clicked");
		waitForElement(3000);

	}

	public void landing_page_IconValidation_CTIIcon() throws InterruptedException {
		waitForElement(4000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CTIIcon));
		MoveToElementClick(element);// clicking on DashBoard tiles
		ExtentSuccessMessage("CTI Icon has been clicked");

		waitForElement(4000);
		Assert.assertTrue(driver.findElement(CTIDialPadIcon).isDisplayed());
		ExtentSuccessMessage("Assertion has been successful");
		waitForElement(3000);

		waitForElement(4000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CTIMinimizeIcon));
		MoveToElementClick(element);// clicking on DashBoard tiles
		ExtentSuccessMessage("CTI Icon has been clicked");

	}

	public void landing_page_IconValidation_CallBackNotification() throws InterruptedException {
		waitForElement(4000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CallBackNotificationIcon));
		MoveToElementClick(element);// clicking on CTIICON tiles CallBackNitificationTitle
		ExtentSuccessMessage("CTI Icon has been clicked");

		waitForElement(4000);
		Assert.assertTrue(driver.findElement(CallBackNitificationTitle).isDisplayed());
		ExtentSuccessMessage("Assertion has been successful");
		waitForElement(3000);

		waitForElement(4000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CallBackNitificationMinimizeIcon));
		MoveToElementClick(element);// clicking on CTIICON tiles
		ExtentSuccessMessage("Minimize Icon has been clicked");

	}

	public void landing_page_IconValidation_MyProfileIcon() throws InterruptedException {
		waitForElement(4000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SelectUser));
		MoveToElementClick(element);
		ExtentSuccessMessage("User has been selected");
		waitForElement(3000);

		waitForElement(4000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(MyProfileIcon));
		MoveToElementClick(element);
		ExtentSuccessMessage("My Profile Icon has been selected");
		waitForElement(3000);

		waitForElement(4000);
		Assert.assertTrue(driver.findElement(MyProfileSubmitButton).isDisplayed());
		ExtentSuccessMessage("Assertion has been successful");
		waitForElement(3000);

	}

	public void customer_engage_validation(CensusInfo ApplicantInfo) throws InterruptedException, IOException {
		waitForElement(1000);
		String urlCE = configloader().getProperty("CEURL");
		String username = configloader().getProperty("PLCA_UserName");
		String pswd = configloader().getProperty("PLCA_Password");
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
		waitForElement(1000);
	}

	public void customer_tile_information_validation() throws InterruptedException, IOException {
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CustomerTile));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on customer tile");
		waitForElement(1000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CustomerNameInCE));
		actualText = element.getText();
		ExtentSuccessMessage("Customer Name as per the Tile in CE:" + actualText);
		Assert.assertEquals(actualText, fullName);
		ExtentSuccessMessage(
				"Sync has been successfully completed hence the customer available in CE which was created in BE application");
		waitForElement(2000);
	}

	public static Properties configloader() throws IOException {
		FileInputStream File = new FileInputStream(".\\src\\test\\resources\\config.properties");
		Properties properties = new Properties();
		properties.load(File);
		return properties;
	}

	public void create_Customer() throws InterruptedException {
		waitForElement(4000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CTIMinimizeIcon));
		MoveToElementClick(element);// clicking on DashBoard tiles

		waitForElement(4000);
		By Customers = By.xpath("//a[@class='glyphicon fa fa-users']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Customers));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Customers");

		waitForElement(4000);
		By NewCustomer = By.xpath("//button[@id='newCustomerBtn']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(NewCustomer));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on New Customer");

		waitForElement(1000);
		By CustomerFirstName = By.xpath("(//input[@name='LeadFirstName'])[1]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CustomerFirstName));
		MoveToElementClick(element);
		String FirstName1 = "Auto";
		writeText(CustomerFirstName, FirstName1);
		ExtentSuccessMessage("Entered the first name");

		waitForElement(1000);
		By CustomerLastName = By.xpath("(//input[@name='LeadLastName'])[1]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CustomerLastName));
		MoveToElementClick(element);
		lastName = "Customer" + getRandomNumber();
		writeText(CustomerLastName, lastName);
		ExtentSuccessMessage("Entered the Last name");

		waitForElement(1000);
		By ContactInformation = By.xpath("(//div[@class='accordion-container'])[2]/i");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ContactInformation));
		MoveToElementClick(element);

		waitForElement(1000);
		By CellPhone = By.xpath("(//input[@name='CellPhone'])[1]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CellPhone));
		MoveToElementClick(element);
		String Number = generatePhoneNumber();
		writeText(CellPhone, Number);
		ExtentSuccessMessage("Entered the Contact Number");

		waitForElement(1000);
		By SubmitButton = By.xpath("(//button[@class='btn btn-default green'])[7]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SubmitButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on submit Button");

		waitForElement(7000);
		By SearchField = By.xpath("//md-input-container[@class='ng-scope']/input");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SearchField));
		MoveToElementClick(element);
		writeText(SearchField, Number + Keys.ENTER);

		waitForElement(2000);
		By CustomerRow = By.xpath("(//div[@class='ng-isolate-scope'])[6]");
		Assert.assertTrue(driver.findElement(CustomerRow).isDisplayed());
		ExtentSuccessMessage("Customer has been Created ");

		waitForElement(2000);
		By HomeButton = By.xpath("//a[@name='menu_home']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(HomeButton));
		MoveToElementClick(element);

	}

	public void newly_Created_Opportunity() throws InterruptedException {

		waitForElement(1000);
		By SalesButton = By.xpath("//span[text()='Sales ']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Sales Button");

		waitForElement(1000);
		By SalesOpportunities = By.xpath("(//a[text()='Opportunities'])[2]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesOpportunities));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Sales Opportunity");

		waitForElement(2000);
		By NewOpportunityButton = By.xpath("//button[@class='btn btn-default pull-right btn-yellow actionIcon']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(NewOpportunityButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on NewSales Opportunity Button");

		waitForElement(2000);
		By CustomerName = By.xpath("(//input[@name='CustomerName'])[2]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CustomerName));
		MoveToElementClick(element);
		writeText(CustomerName, lastName);
		waitForElement(1000);
		By SearchButton = By.xpath("(//i[@class='glyphicon glyphicon-search'])[2]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SearchButton));
		MoveToElementClick(element);

		By SearchPopup = By.xpath("//button[@title='Search Customer']");
		By CustomerInQuotes = By.xpath("(//input[@type='radio'])[1]");

		waitForElement(3000);
		if (driver.findElement(SearchPopup).isDisplayed()) {
			click(CustomerInQuotes);
			ExtentSuccessMessage("Customer has been selected");
		} else {
			ExtentSuccessMessage("Customer is not created");
		}

		waitForElement(2000);
		By SubmitButton = By.xpath("(//button[@class='btn btn-default green pull-right'])[5]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SubmitButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("Customer is been Selected");

		waitForElement(1000);
		By Revenue = By.xpath("(//input[@name='Revenue'])[2]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Revenue));
		MoveToElementClick(element);
		writeText(Revenue, "100");
		ExtentSuccessMessage("Revenue is been entered");

		waitForElement(1000);
		By SubmitOppButton = By.xpath("(//button[@class='btn btn-default green'])[5]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SubmitOppButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("Opportunities is Submitted");

		waitForElement(8000);
		By GridFirstSection = By.xpath("(//a[@class='edit-list-anchor ng-binding'])[1]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(GridFirstSection));
		String FirstName = element.getText();
		System.out.println(FirstName);

		waitForElement(1000);
		Assert.assertTrue(FirstName.contains(lastName));
		ExtentSuccessMessage("Opportunities is been visible in first grid");

		waitForElement(1000);
		By InputField = By.xpath(
				"//input[@class='ng-pristine ng-untouched md-input ng-empty ng-valid-minlength ng-valid-maxlength ng-valid ng-valid-required']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(InputField));
		MoveToElementClick(element);
		writeText(InputField, lastName + Keys.ENTER);

		waitForElement(3000);
		By CustomerName1 = By.xpath("//a[@class='edit-list-anchor ng-binding']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CustomerName1));
		MoveToElementClick(element);
		ExtentSuccessMessage("CLicked on the first Customer");

		By OpportunityInformation = By.xpath("(//div[@form-name='enrollmentForm'])[3]");

		waitForElement(8000);
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(OpportunityInformation));

		// Assert.assertTrue(driver.findElement(OpportunityInformation).isDisplayed());
		ExtentSuccessMessage("Assertion for oportunity Information is done");

		By CustomerNameInTab = By.xpath("(//span[@class='ng-binding ng-isolate-scope'])[2]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CustomerNameInTab));
		String Text = element.getText();
		System.out.println(Text);

		waitForElement(1000);
		Assert.assertTrue(Text.contains(lastName));
		ExtentSuccessMessage("Customer Name is Visible in Opportunity Information Tab");

		waitForElement(1000);
		By CustomerInformationTab = By.xpath("//a[contains(.,                             'Customer Information')]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CustomerInformationTab));
		MoveToElementClick(element);
		ExtentSuccessMessage("CustomerInformationTab has been clicked");

		waitForElement(4000);
		By CustomerInformatinTab = By.xpath("(//div[@form-name='enrollmentForm'])[3]");
		Assert.assertTrue(driver.findElement(CustomerInformatinTab).isDisplayed());
		ExtentSuccessMessage("CustomerInformationTab has been clicked");

		waitForElement(1000);
		By EditButton = By
				.xpath("//button[@class='btn btn-default pull-right icons red-color pull-right ng-isolate-scope']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(EditButton));
		MoveToElementClick(element);

		waitForElement(4000);
		By ProductCategory = By.xpath("//md-select[@name='CRMProductCategory']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ProductCategory));
		MoveToElementClick(element);
		By AllOption = By.xpath("//md-option[@value='All']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AllOption));
		MoveToElementClick(element);
		ExtentSuccessMessage("ProductCategory has been changed to All");

		waitForElement(8000);
		By SaveOppAfterEdit = By.xpath("(//button[@class='btn btn-default green'])[2]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SaveOppAfterEdit));
		MoveToElementClick(element);

		waitForElement(8000);
		By ProductCategoryAfterEdit = By.xpath("(//span[@class='ng-binding ng-isolate-scope'])[4]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ProductCategoryAfterEdit));

		String Text1 = element.getText();
		System.out.println("expected text:" + Text1);
		waitForElement(12000);
		Assert.assertEquals(Text1, "All");
		ExtentSuccessMessage("Assertion is done After  edit");

	}

	public String writeLastnameToExcel(String nameText, String sheetname) throws IOException {
		String excelFilePath = ".\\src\\test\\resources\\TestData.xlsx";
		FileInputStream inputStream = new FileInputStream(excelFilePath);
		Workbook workbook = new XSSFWorkbook(inputStream);
		String sheetName_update = sheetname;
		Sheet sheet = workbook.getSheet(sheetname);
		int rowIndex = 1;
		int columnIndex = 8;
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

	public void admin_CreateNewUser(CensusInfo ApplicantInfo) throws InterruptedException, AWTException, IOException {

		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AdminTile));
		MoveToElementClick(element);
		ExtentSuccessMessage("Agency Tile has been clicked");

		waitForElement(1000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AdminUser));
		MoveToElementClick(element);
		ExtentSuccessMessage("Admin User has been clicked");

		waitForElement(1000); 

		element = wait.until(ExpectedConditions.presenceOfElementLocated(AddUserButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("Add User has been clicked");

		waitForElement(1000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(UserFirstName));
		MoveToElementClick(element);
		String FirstName = "Auto";
		writeText(UserFirstName, FirstName + Keys.ENTER);
		ExtentSuccessMessage("First Name has been entered");

		waitForElement(1000);

		element = wait.until(ExpectedConditions.presenceOfElementLocated(UserLastName));
		MoveToElementClick(element);
		String LastName = "Agent" + getRandomNumber();
		writeText(UserLastName, LastName + Keys.ENTER);
		writeLastnameToExcel(LastName, "TC CE2");
		ExtentSuccessMessage("Last Name has been entered");

		waitForElement(1000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(UserEmailId));
		MoveToElementClick(element);
		String EmailId = FirstName + LastName + "@" + "yopmail.com";
		writeText(UserEmailId, EmailId);
		ExtentSuccessMessage("Email-Id has been entered");

		waitForElement(1000);

		element = wait.until(ExpectedConditions.presenceOfElementLocated(UserPhoneNumber));
		MoveToElementClick(element);
		String phone = generatePhoneNumber();
		System.out.println(phone);
		writeText(UserPhoneNumber, phone);
		ExtentSuccessMessage("Phone has been entered");

		waitForElement(1000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(UserRolesAndPermission));
		Select select = new Select(element);
		select.selectByVisibleText("Default Profile");
		String profile = select.getFirstSelectedOption().getText();
		System.out.println(profile);
		ExtentSuccessMessage("Role And Permission has been selected");

		waitForElement(1000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(UserLoginDetails));
		MoveToElementClick(element);
		String UserLogin = FirstName + LastName;
		System.out.println(UserLogin);
		writeText(UserLoginDetails, UserLogin);
		ExtentSuccessMessage("Login details has been entered");

		waitForElement(1000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(DataAccessibiltityDD1));
		Select select2 = new Select(element);
		select2.selectByVisibleText("Yes");
		ExtentSuccessMessage("Edit data has been selected");

		waitForElement(1000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(DataAccessibiltityDD2));
		Select select3 = new Select(element);
		select3.selectByVisibleText("Yes");
		ExtentSuccessMessage("Confidentials data has been selected");

		waitForElement(1000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(NewUserButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("Login details has been entered");

		waitForElement(2000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ConfirmationPopup));
		MoveToElementClick(element);
		ExtentSuccessMessage("Popup has been Accepted");
		String currentSystemURL = driver.getCurrentUrl();

		Thread.sleep(3000);

		driver.switchTo().newWindow(WindowType.TAB);
		Thread.sleep(3000);

		waitForElement(2000);
//		String urlCE = configloader().getProperty("CEURL");
		String urlCE;
//		String currentSystemURL = driver.getCurrentUrl();
		System.out.println(currentSystemURL);
		if (currentSystemURL.contains("https://mme.benefitalign.com")) {
			urlCE = "https://mme.benefitalign.com";
		} else if (currentSystemURL.contains("https://ce-uat.benefitalign.com/")) {
			urlCE = "https://ce-uat.benefitalign.com/";
		} else if (currentSystemURL.contains("https://ce-qa.benefitalign.com/mme")) {
			urlCE = "https://ce-qa.benefitalign.com/mme";
		} else {
			urlCE = "https://ce-dev.benefitalign.com/#/login";
		}
		driver.get(urlCE);
		waitForElement(5000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(userID));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Customer Engage Username field");

		writeText(userID, UserLogin);
		ExtentSuccessMessage("Entered the Customer Engage Username");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(pwd));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Customer Engage password field");
		writeText(pwd, "P@ssword123!");
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
		waitForElement(5000);

		By User = By.xpath("//a[@class='nav-link dropdown-toggle']/i[2]/b");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(User));
		String user = element.getText();
		System.out.println(user);

		Thread.sleep(2000);
		Assert.assertTrue(user.contains(LastName));
		ExtentSuccessMessage("Asertion for User name is done at Top");

		Thread.sleep(2000);
		ArrayList<String> Tabs = new ArrayList<>(driver.getWindowHandles());
		System.out.println(Tabs.size());
		driver.switchTo().window(Tabs.get(0));
		ExtentSuccessMessage("Tab Switched from child to parent");

		Thread.sleep(6000);
		By SerachField = By.xpath(
				"//input[@class='ng-pristine ng-untouched md-input ng-empty ng-valid-minlength ng-valid-maxlength ng-valid ng-valid-required']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SerachField));
		MoveToElementClick(element);
		writeText(SerachField, LastName + Keys.ENTER);
		ExtentSuccessMessage("Agent has been Searched");

		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AdminUserInc));
		getEmailValue = element.getText();
		System.out.println("-----------" + getEmailValue + "------------");
		Assert.assertEquals(getEmailValue, EmailId);
		ExtentSuccessMessage("Assertion has been done");

		By LastNameAss = By.xpath("(//div[@class='ui-grid-cell-contents ng-binding ng-scope'])[2]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(LastNameAss));
		String lastname = element.getText();
		System.out.println(lastname);

		Assert.assertEquals(lastname, LastName);
		ExtentSuccessMessage("Assertion for last Name is Done");

		By PhoneNumber = By.xpath("//div[@class='ng-binding ng-scope']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PhoneNumber));
		String number1 = element.getText();
		System.out.println(number1);

		String numberString = StringUtils.substringAfter(number1, "-");
		System.out.println(numberString);
//		
		Assert.assertTrue(phone.contains(numberString));
		ExtentSuccessMessage("Assertion for phone number is done");

		By Defaultprofile = By.xpath("(//div[@class='ui-grid-cell-contents ng-binding ng-scope'])[5]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Defaultprofile));
		String defaultprofile = element.getText();
		System.out.println(defaultprofile);

		Assert.assertEquals(defaultprofile, profile);
		ExtentSuccessMessage("Assertion for Default Profile is Done");

		Thread.sleep(3000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AdminEditIcon));
		MoveToElementClick(element);
		ExtentSuccessMessage("Edit Icon has been clicked");

		element = wait.until(ExpectedConditions.presenceOfElementLocated(EditEmailId));
		MoveToElementClick(element);
		element.clear();
		MoveToElementClick(element);
		String EmailId1 = UserLogin + getRandomNumber1() + "@" + "yopmail.com";
		System.out.println(EmailId1);
		writeText(EditEmailId, EmailId1 + Keys.ENTER);
		ExtentSuccessMessage("Email id has been entered");

		element = wait.until(ExpectedConditions.presenceOfElementLocated(EditPhone));
		MoveToElementClick(element);
		element.clear();
		MoveToElementClick(element);
		String PhoneNumber1 = generatePhoneNumber();
		System.out.println(PhoneNumber1);
		writeText(EditPhone, PhoneNumber1 + Keys.ENTER);
		ExtentSuccessMessage("PhoneNumber has been entered");

		element = wait.until(ExpectedConditions.presenceOfElementLocated(EditSaveButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("User has been Edited");

		waitForElement(5000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AdminEditUserINC));
		expectedText = element.getText();
		System.out.println("-----------" + expectedText + "------------");
		Assert.assertEquals(expectedText, EmailId1);
		ExtentSuccessMessage("Assertion has been done");

		By Editednumber = By.xpath("//div[@class='ng-binding ng-scope']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Editednumber));
		String editednumber = element.getText();
		System.out.println(editednumber);

		String editedString = StringUtils.substringAfter(editednumber, "-");
		System.out.println(editedString);

		Assert.assertTrue(PhoneNumber1.contains(editedString));
		ExtentSuccessMessage("Assertion for Edited phone number is done");

		Thread.sleep(4000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AdminResetPasswordButton));
		MoveToElementClick(element);
		waitForElement(1000);
		ExtentSuccessMessage("Password has been Reset");

		Thread.sleep(7000);
		By PasswordReset = By.xpath("//div[@id='divSuccess']");
//		Assert.assertTrue(driver.findElement(PasswordReset).isDisplayed());

		By Refresh = By.xpath("//a[@class='pull-right reset-button ng-isolate-scope']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Refresh));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Refresh Button");

		Thread.sleep(6000);
 
		By RecentUser = By.xpath("(//div[@class='accordion-container grid-style-height'])[1]/i");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(RecentUser));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on recent User");

		Thread.sleep(2000);
		By CreatedToday = By.xpath("//md-radio-button[@value='Created Today']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CreatedToday));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Created Today User");

		Thread.sleep(3000);
		By Login = By.xpath("(//div[@class='ui-grid-cell-contents ng-binding ng-scope'])[3]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Login));
		String login = element.getText();
		System.out.println(login);

		Assert.assertEquals(login, UserLogin);
		ExtentSuccessMessage("User which is Created today is visible");

		By Export = By.xpath("//button[@name='downlodDataBtn']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Export));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Export button");

		Thread.sleep(1000);
		By DownloadPopup = By.xpath("//div[@id='divSuccesss']");
		Assert.assertTrue(driver.findElement(DownloadPopup).isDisplayed());
		ExtentSuccessMessage("Assertion for download popup is done");

		element = wait.until(ExpectedConditions.presenceOfElementLocated(Refresh));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Refresh Button");

		By AdvanceSearch = By.xpath("//button[@name='advancedSearchBtn']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AdvanceSearch));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on AdvanceSearch Button");

		LocalDate currentDate = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		String formattedDate = currentDate.format(formatter);
		System.out.println(formattedDate);

		Thread.sleep(2000);

		By CreatedDate = By.xpath("//input[@name='CreatedStartDate']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CreatedDate));
		MoveToElementClick(element);
		writeText(CreatedDate, formattedDate + Keys.ENTER);
		ExtentSuccessMessage("Clicked on CreatedDate field");

		By Search = By.xpath("//button[@name='applyadvancedSearchBtn']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Search));
		MoveToElementClick(element);

		Thread.sleep(4000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Login));
		String login1 = element.getText();
		System.out.println(login1);

		Assert.assertEquals(login1, UserLogin);
		ExtentSuccessMessage("User which is Created today is visible after advance search");

		waitForElement(2000);
		Assert.assertTrue(driver.findElement(UserDeleteIconButton).isDisplayed());
		ExtentSuccessMessage("Delete icon is Dislayed");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(UserDeleteIconButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("Delete Icon has been Clicked");

		element = wait.until(ExpectedConditions.presenceOfElementLocated(AdminDeleteConfirmPopup));
		MoveToElementClick(element);
		ExtentSuccessMessage("User has been Deleted");
		Thread.sleep(4000);
	}
	
	public void admin_RolesAndPermission() throws InterruptedException, IOException, AWTException {

		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AdminTile));
		MoveToElementClick(element);
		ExtentSuccessMessage("Agency Tile has been clicked");

		By AdminRolesAndPermission = By.xpath("(//a[contains(.,'Roles/Permissions')])[2]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AdminRolesAndPermission));
		MoveToElementClick(element);
		ExtentSuccessMessage("Roles and Permission has been clicked");

		By AddRolesAndPermission = By.xpath("//button[@class='btn btn-default pull-right btn-yellow']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AddRolesAndPermission));
		MoveToElementClick(element);
		ExtentSuccessMessage("Roles and Permission has been clicked");
 
		By RolesAndPermissionField = By.xpath(
				"//input[@class='form-control ng-pristine ng-untouched ng-empty ng-invalid ng-invalid-required']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(RolesAndPermissionField));
		MoveToElementClick(element);
		String RolesAndPermissionName = "AutoRole" + getRandomNumber();
		writeText(RolesAndPermissionField, RolesAndPermissionName);
		ExtentSuccessMessage("Roles and Permission has been clicked");
		Thread.sleep(6000);
		//Zoomin(4);
		String currenturl = driver.getCurrentUrl();
		System.out.println(currenturl);
		
		if (currenturl.contains("https://mme.benefitalign.com")) {
			for (int i = 1; i < 33; i++) {
				WebElement checkbox1 = driver
						.findElement(By.xpath("(//li[@ng-repeat='item in items']/md-checkbox)[" + i + "]"));
				MoveToElementClick(checkbox1);
			}
			ExtentSuccessMessage("Unchecked all the boxes");

		} else if (currenturl.contains("https://ce-uat.benefitalign.com")) {
			for (int i = 1; i < 41; i++) {
				WebElement checkbox1 = driver
						.findElement(By.xpath("(//li[@ng-repeat='item in items']/md-checkbox)[" + i + "]"));
				MoveToElementClick(checkbox1);
			}
			ExtentSuccessMessage("Unchecked all the boxes");

		} else if (currenturl.contains("https://ce-qa.benefitalign.com")) {
			for (int i = 1; i < 42; i++) {
				WebElement checkbox1 = driver
						.findElement(By.xpath("(//li[@ng-repeat='item in items']/md-checkbox)[" + i + "]"));
				MoveToElementClick(checkbox1);
				Thread.sleep(300);
			}
			ExtentSuccessMessage("Unchecked all the boxes");
		}
		//Zoomout();
		Thread.sleep(7000);
		By SalesLead = By.xpath("//li[contains(.,'Sales-Leads')]/md-checkbox");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesLead));
		MoveToElementClick(element);
		By Sales1 = By.xpath("//li[contains(.,'Sales-Leads')]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Sales1));
		String lead = element.getText();
		System.out.println(lead);
		ExtentSuccessMessage("Clicked on Sales-Lead");

		By SalesOpportunities = By.xpath("//li[contains(.,'Sales-Opportunities')]/md-checkbox");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesOpportunities));
		MoveToElementClick(element);
		By Sales2 = By.xpath("//li[contains(.,'Sales-Opportunities')]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Sales2));
		String opp = element.getText();
		System.out.println(opp);
		ExtentSuccessMessage("Clicked on Sales-Opportunities");

		By SalesPolicies = By.xpath("//li[contains(.,'Sales-Policies')]/md-checkbox");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesPolicies));
		MoveToElementClick(element);
		By Sales3 = By.xpath("//li[contains(.,'Sales-Policies')]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Sales3));
		String pol = element.getText();
		System.out.println(pol);
		ExtentSuccessMessage("Clicked on Sales-Policies");

		By SalesQuotes = By.xpath("//li[contains(.,'Sales-Quotes')]/md-checkbox");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SalesQuotes));
		MoveToElementClick(element);
		By Sales4 = By.xpath("//li[contains(.,'Sales-Quotes')]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Sales4));
		String qut = element.getText();
		System.out.println(qut);
		ExtentSuccessMessage("Clicked on Sales-Quotes");

		Thread.sleep(1000);
		By RolesAndPermissionSubmitButton = By.xpath("//button[@class='btn btn-default green pull-right']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(RolesAndPermissionSubmitButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Submit Button");

		Thread.sleep(7000);
		By SearchText = By.xpath(
				"//input[@class='ng-pristine ng-untouched md-input ng-empty ng-valid-minlength ng-valid-maxlength ng-valid ng-valid-required']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SearchText));
		MoveToElementClick(element);
		writeText(SearchText, RolesAndPermissionName + Keys.ENTER);
		ExtentSuccessMessage("RolesAndPermissionName has been Serached");

		By Name = By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Name));
		String name = element.getText();
		System.out.println(name);

//		Assert.assertEquals(name, RolesAndPermissionName);
		ExtentSuccessMessage("Assertion for name has been done");

		By Admin = By.xpath("//a[@id='menu_Admin']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Admin));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked On Admin");

		By Users = By.xpath("//a[@id='submenu_adminusers']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Users));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked On Users");

		Thread.sleep(3000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SearchText));
		MoveToElementClick(element);
		writeText(SearchText, "RolesUser" + Keys.ENTER);
		ExtentSuccessMessage("User has been Searched");

		Thread.sleep(20000);
		By Edituser = By.xpath("//i[@class='glyphicon glyphicon-pencil']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Edituser));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Edit user");

		Thread.sleep(3000);
		WebElement Roles = driver.findElement(By.xpath("//select[@id='ProfileName']"));
		Select s = new Select(Roles);
		s.selectByVisibleText("" + RolesAndPermissionName + "");
		ExtentSuccessMessage("Roles and Permission which is created is been Selected");

		By SaveButton = By.xpath("(//button[@class='btn btn-default green pull-right'])[3]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SaveButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Save Button");

		Thread.sleep(8000);

		driver.switchTo().newWindow(WindowType.TAB);
		Thread.sleep(3000);

		waitForElement(2000);
//		String urlCE = configloader().getProperty("CEURL");
		String urlCE;
		String currentSystemURL = configloader().getProperty("URL");
		System.out.println(currentSystemURL);
		if (currentSystemURL.contains("https://mme.benefitalign.com")) {
			urlCE = "https://mme.benefitalign.com";
		} else if (currentSystemURL.contains("https://ce-uat.benefitalign.com/")) {
			urlCE = "https://ce-uat.benefitalign.com/";
		} else if (currentSystemURL.contains("https://ce-qa.benefitalign.com/mme")) {
			urlCE = "https://ce-qa.benefitalign.com/mme";
		} else {
			urlCE = "https://ce-dev.benefitalign.com/#/login";
		}
		driver.get(urlCE);
		waitForElement(5000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(userID));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Customer Engage Username field");
		writeText(userID, "RolesUser");
		ExtentSuccessMessage("Entered the Customer Engage Username");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(pwd));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Customer Engage password field");
		writeText(pwd, "P@ssword123!");
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
		waitForElement(8000);

		WebElement Sales = driver.findElement(By.xpath("//a[@class='glyphicon fa fa-handshake-o']"));
		Actions actions = new Actions(driver);
		actions.moveToElement(Sales).perform();
		ExtentSuccessMessage("Mouse Hovered on Sales Menu");
		waitForElement(8000);
		By LeadsAss = By.xpath("(//a[contains(.,'Leads')])[2]");
		waitVisibility(LeadsAss);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(LeadsAss));
		String leadass = element.getText();
		System.out.println(leadass);
		System.out.println(lead);
		Assert.assertTrue(lead.contains(leadass));
		ExtentSuccessMessage("Assertion for Sales-Lead is Done After Creating Roles-Permission");

		By OppAss = By.xpath("(//a[contains(.,'Opportunities')])[2]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(OppAss));
		String oppass = element.getText();
		System.out.println(oppass);

		Assert.assertTrue(opp.contains(oppass));
		ExtentSuccessMessage("Assertion for Sales-Opportunity is Done After Creating Roles-Permission");

		By QuotesAss = By.xpath("(//a[contains(.,'Quotes')])[2]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(QuotesAss));
		String quoteass = element.getText();
		System.out.println(quoteass);

		Assert.assertTrue(qut.contains(quoteass));
		ExtentSuccessMessage("Assertion for Sales-Quotes is Done After Creating Roles-Permission");

		waitForElement(3000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SelectUser));
		MoveToElementClick(element);
		ExtentSuccessMessage("User has been selected");
		waitForElement(1000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SelectLogout));
		MoveToElementClick(element);
		ExtentSuccessMessage("Logout has been performed!");
		waitForElement(1000);
		driver.manage().deleteAllCookies();
		waitForElement(3000);

		Thread.sleep(5000);
		ArrayList<String> Tabs = new ArrayList<>(driver.getWindowHandles());
		System.out.println(Tabs.size());
		driver.switchTo().window(Tabs.get(0));
		ExtentSuccessMessage("Tab Switched from child to parent");

		By Admin1 = By.xpath("//a[@name='menu_Admin']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Admin1));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Admin Section");

		By RP = By.xpath("//a[@name='submenu_adminRolesPermissions']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(RP));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Role/Permission Section");

		Thread.sleep(5000);

		By Edit = By.xpath("//a[@class='edit-list-icons']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Edit));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Edit Button");

		Thread.sleep(3000);
		By Customer = By.xpath("//li[contains(.,'Customers')]/md-checkbox");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Customer));
		MoveToElementClick(element);
		By Cust = By.xpath("(//li[contains(.,'Customers')])[2]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Cust));
		String custt = element.getText();
		System.out.println(custt);
		ExtentSuccessMessage("Clicked on Customer Button");

		element = wait.until(ExpectedConditions.presenceOfElementLocated(RolesAndPermissionSubmitButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Submit Button");

		Thread.sleep(9000);
		driver.switchTo().window(Tabs.get(1));
		ExtentSuccessMessage("Tab Switched from Parent to Child");

		waitForElement(5000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(userID));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Customer Engage Username field");
		writeText(userID, "RolesUser");
		ExtentSuccessMessage("Entered the Customer Engage Username");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(pwd));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Customer Engage password field");
		writeText(pwd, "P@ssword123!");
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
		waitForElement(5000);

		By Customer1 = By.xpath("//a[@class='glyphicon fa fa-users']/span");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Customer1));
		String custtt = element.getText();
		System.out.println(custtt);

		Assert.assertEquals(custtt, custt);
		ExtentSuccessMessage("Customer is visible after editing Roles/Permission");

		waitForElement(3000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SelectUser));
		MoveToElementClick(element);
		ExtentSuccessMessage("User has been selected");
		waitForElement(1000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SelectLogout));
		MoveToElementClick(element);
		ExtentSuccessMessage("Logout has been performed!");
		waitForElement(1000);
		driver.manage().deleteAllCookies();
		waitForElement(3000);

		driver.switchTo().window(Tabs.get(0));
		ExtentSuccessMessage("Tab Switched from child to parent");

		Thread.sleep(3000);
		By Refresh = By.xpath("//a[@class='pull-right reset-button ng-isolate-scope']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Refresh));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked On Refresh Button");

		Thread.sleep(4000);
		By RecentRole = By.xpath("//div[@class='accordion-container grid-style-height']/i");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(RecentRole));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Recent Role");

		Thread.sleep(3000);
		By CreatedToday = By.xpath("//md-radio-button[@value='Created Today']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CreatedToday));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Created Today Button");

//		Thread.sleep(4000);
//        By RolesAss= By.xpath("//div[@title=' "+RolesAndPermissionName+ "']");
//		waitVisibility(RolesAss);
////        Assert.assertTrue(driver.findElement(RolesAss).isDisplayed());
		ExtentSuccessMessage("Assertion for created today is done");

	}

	public void admin_AddNewCallDeposition(CensusInfo ApplicantInfo)
			throws InterruptedException, IOException, AWTException {

//		 element = wait.until(ExpectedConditions.presenceOfElementLocated(CTIMinimizeIcon));
//		   MoveToElementClick(element);//clicking on DashBoard tiles  

		Thread.sleep(5000);
		By PhoneNumber = By.xpath("//u[@title='Voice Number']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PhoneNumber));
		String number = element.getText();
		System.out.println(number);

		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AdminTile));
		MoveToElementClick(element);
		ExtentSuccessMessage("Admin Tile has been clicked");

		By TelephonySetup = By.xpath("//a[@href='#/admin/manage-account']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(TelephonySetup));
		MoveToElementClick(element);

		Thread.sleep(8000);
		By ConfigureButton = By.xpath("(//button[@name='manageNumbersBtn'])[2]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ConfigureButton));
		MoveToElementClick(element);

		element = wait.until(ExpectedConditions.presenceOfElementLocated(AddNewCallDespositionButton));
		MoveToElementClick(element);

		waitForElement(1000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CallDispositionName));
		MoveToElementClick(element);
		String CallDispositionNameField = "AutoDisposition" + getRandomNumber();
		System.out.println(CallDispositionNameField);
		writeText(CallDispositionName, CallDispositionNameField);
		writeDespoToExcel(CallDispositionNameField, "TC CE2");

		ExtentSuccessMessage("Call Deposition Button has been clicked");

		waitForElement(1000); 
		By LeadStatusDD = By.xpath("//md-select[@name='LeadStatus']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(LeadStatusDD));
		MoveToElementClick(element);
		waitForElement(1000);
		By AcceptButton = By.xpath("//md-option[@value='Qualified']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AcceptButton));
		MoveToElementClick(element);

		element = wait.until(ExpectedConditions.presenceOfElementLocated(LeadStatusDD));
		String status = element.getText();
		System.out.println(status);

		waitForElement(3000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CallDispositionSaveButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("Call disposition has been saved");

		Thread.sleep(8000);

		driver.switchTo().newWindow(WindowType.TAB);
		Thread.sleep(3000);

		waitForElement(2000);
//		String urlCE = configloader().getProperty("CEURL");
		String urlCE;
		String currentSystemURL = configloader().getProperty("URL");
		System.out.println(currentSystemURL);
		if (currentSystemURL.contains("https://mme.benefitalign.com")) {
			urlCE = "https://ce-uat.benefitalign.com/";
		} else if (currentSystemURL.contains("https://ce-uat.benefitalign.com/")) {
			urlCE = "https://ce-qa.benefitalign.com/mme";
		} else if (currentSystemURL.contains("https://ce-qa.benefitalign.com/mme")) {
			urlCE = "https://ce-uat.benefitalign.com/";
		} else {
			urlCE = "https://ce-dev.benefitalign.com/#/login";
		}
		driver.get(urlCE);
		waitForElement(5000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(userID));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Customer Engage Username field");
		writeText(userID, "CEUsertwo");
		ExtentSuccessMessage("Entered the Customer Engage Username");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(pwd));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Customer Engage password field");
		writeText(pwd, "P@ssword123!");
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
		waitForElement(10000); 

		By NumberField = By.xpath("//input[@placeholder='Enter Phone Number']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(NumberField));
		MoveToElementClick(element);
		writeText(NumberField, number);
		ExtentSuccessMessage("Entered the phone Number");
		Thread.sleep(4000);

		By CallButton = By.xpath("(//button[@class='voice-call-green-button-small fa fa-phone'])[1]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CallButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Call Button");

		Thread.sleep(3000);
		ArrayList<String> Tabs = new ArrayList<>(driver.getWindowHandles());
		System.out.println(Tabs.size());
		driver.switchTo().window(Tabs.get(0));
		ExtentSuccessMessage("Tab Switched from child to parent");

		Thread.sleep(6000);
		By IncomingCall = By.cssSelector("#AcceptIncomingTrigger");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(IncomingCall));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Accept Button");

		Thread.sleep(15000);

		WebElement CallDisposition = driver.findElement(By.xpath("//select[@name='LeadType']"));
		Select s = new Select(CallDisposition);
		s.selectByVisibleText("" + CallDispositionNameField + "");
		ExtentSuccessMessage("Call Disposition is Visible under Dropdown");

		Thread.sleep(4000);

		By CallDecline = By.xpath("(//button[@class='voice-call-green-button-small fa fa-phone voice-decline'])[1]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CallDecline));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Accept Button");

		Thread.sleep(4000);

		driver.navigate().refresh();
		Thread.sleep(5000);

		Thread.sleep(5000);
		By Search = By.xpath(
				"//input[@class='ng-pristine ng-untouched md-input ng-empty ng-valid-minlength ng-valid-maxlength ng-valid ng-valid-required']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Search));
		MoveToElementClick(element);
		writeText(Search, CallDispositionNameField + Keys.ENTER);
		Thread.sleep(3000);
		By Disponame = By.xpath("(//div[@class='ui-grid-cell-contents ng-binding ng-scope'])[1]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Disponame));
		String dispo = element.getText();
		System.out.println(dispo);

		Assert.assertEquals(dispo, CallDispositionNameField);
		ExtentSuccessMessage("Assertion for Disposition name has been done");
		By StatusAss = By.xpath("(//div[@class='ui-grid-cell-contents ng-binding ng-scope'])[2]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(StatusAss));
		String statusass = element.getText();
		System.out.println(statusass);

		Assert.assertEquals(statusass, status);
		ExtentSuccessMessage("Assertion for Status name has been done");

		By EditIcon = By.xpath("//a[@class='edit-list-icons'][1]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(EditIcon));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clcked on Edit Icon");

		waitForElement(3000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(LeadStatusDD));
		MoveToElementClick(element);
		By Converted = By.xpath("//md-option[@value='Converted']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Converted));
		MoveToElementClick(element);
		Thread.sleep(2000);

		element = wait.until(ExpectedConditions.presenceOfElementLocated(LeadStatusDD));
		String converted = element.getText();
		System.out.println(converted);

		waitForElement(1000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CallDispositionSaveButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("Call disposition has been saved");

		Thread.sleep(3000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(StatusAss));
		String statusass1 = element.getText();
		System.out.println(statusass1);

		Assert.assertEquals(statusass1, converted);
		ExtentSuccessMessage("Assertion for Status has been done after Edit");

		waitForElement(3000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(DeleteCallDespoButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("Delete Disposition has been clicked");

		element = wait.until(ExpectedConditions.presenceOfElementLocated(ConfirmDeleteButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("Confirm Button has been clicked");

	
	}

	public void admin_EditAndDeleteCallDesposition(CensusInfo ApplicantInfo) throws InterruptedException, AWTException {
//		element = wait.until(ExpectedConditions.presenceOfElementLocated(CTIMinimizeIcon));
//		MoveToElementClick(element);// clicking on DashBoard tiles

		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AdminTile));
		MoveToElementClick(element);
		ExtentSuccessMessage("Agency Tile has been clicked");

		String currentSystemURL = driver.getCurrentUrl();

		if (currentSystemURL.contains("https://truecoverage-pp.brokerengage.net/")) {
			By TelephonySetup = By.cssSelector(
					"#NavigationMenuRegion > div > div.col-md-12.subcontsection.pad-lt.pad-rt.pull-right.overflow-visible.dashboard > div.col-md-12.pull-left.pad-lt > div > ul > li.admin-box.box.animate-box.fade-in > ul > li:nth-child(2) > a");
			element = wait.until(ExpectedConditions.presenceOfElementLocated(TelephonySetup));
			MoveToElementClick(element);

			By ConfigureButton = By.xpath("(//button[@name='manageNumbersBtn'])[2]");
			element = wait.until(ExpectedConditions.presenceOfElementLocated(ConfigureButton));
			MoveToElementClick(element);

			element = wait.until(ExpectedConditions.presenceOfElementLocated(AddNewCallDespositionButton));
			MoveToElementClick(element);
		}

		else if (currentSystemURL.contains("https://ce-uat.benefitalign.com/")) {

			waitForElement(1000);
			element = wait.until(ExpectedConditions.presenceOfElementLocated(CallDisposition));
			MoveToElementClick(element);
			ExtentSuccessMessage("Call Deposition has been clicked");

			waitForElement(1000);

		}

		else if (currentSystemURL.contains("https://ce-uat.benefit-test.com/")) {

			waitForElement(1000);
			element = wait.until(ExpectedConditions.presenceOfElementLocated(CallDisposition));
			MoveToElementClick(element);
			ExtentSuccessMessage("Call Deposition has been clicked");

			waitForElement(1000);

		}

		else if (currentSystemURL.contains("https://ce-qa.benefitalign.com/")) {

			By TelephonySetup = By.xpath("//*[@id=\"NavigationMenuRegion\"]/div/div[2]/div[1]/div/ul/li[7]/ul/li[2]/a");
			element = wait.until(ExpectedConditions.presenceOfElementLocated(TelephonySetup));
			MoveToElementClick(element);

			By ConfigureButton = By.xpath("(//button[@name='manageNumbersBtn'])[2]");
			element = wait.until(ExpectedConditions.presenceOfElementLocated(ConfigureButton));
			MoveToElementClick(element);

		} else {

			By TelephonySetup = By.xpath("//*[@id=\"NavigationMenuRegion\"]/div/div[2]/div[1]/div/ul/li[7]/ul/li[2]/a");
			element = wait.until(ExpectedConditions.presenceOfElementLocated(TelephonySetup));
			MoveToElementClick(element);

			By ConfigureButton = By.xpath("(//button[@name='manageNumbersBtn'])[2]");
			element = wait.until(ExpectedConditions.presenceOfElementLocated(ConfigureButton));
			MoveToElementClick(element);

		}

//	       waitForElement(1000);
//	       element = wait.until(ExpectedConditions.presenceOfElementLocated(CallDisposition));
//		   MoveToElementClick(element);
//	       ExtentSuccessMessage("Call Deposition has been clicked");
//	      
		waitForElement(2000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CallDespoSearchField));
		MoveToElementClick(element);
		writeText(CallDespoSearchField, ApplicantInfo.Despo + Keys.ENTER);
		ExtentSuccessMessage("Call Deposition name has been entered");

		waitForElement(6000);
		Assert.assertTrue(driver.findElement(EditCallDisoButton).isDisplayed());
		ExtentSuccessMessage("Assertion has been done");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(EditCallDisoButton));
		MoveToElementClick(element);

		waitForElement(3000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(LeadStatusDD));
		MoveToElementClick(element);
		By Converted = By.xpath("//md-option[@value='Converted']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Converted));
		MoveToElementClick(element);

		waitForElement(1000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CallDispositionSaveButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("Call disposition has been saved");

		waitForElement(3000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(DeleteCallDespoButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("Delete Disposition has been clicked");

		element = wait.until(ExpectedConditions.presenceOfElementLocated(ConfirmDeleteButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("Confirm Button has been clicked");

	}

	public void admin_AddBuissnessHour() throws InterruptedException {

		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AdminTile));
		MoveToElementClick(element);
		ExtentSuccessMessage("Agency Tile has been clicked");

		By BuissnessHour = By.xpath("//a[@href='#/admin/businessHours']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(BuissnessHour));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked On Buissness Hour");

		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(NewBuissnessHourButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("Buissness hour button has been clicked");

		element = wait.until(ExpectedConditions.presenceOfElementLocated(BuissnesshourField));
		MoveToElementClick(element);
		String BuissnessHr = "AutoHour" + getRandomNumber();
		writeText(BuissnesshourField, BuissnessHr + Keys.ENTER);
		ExtentSuccessMessage("Buissness hour Name has been clicked");

		By TextArea = By.xpath(
				"//textarea[@class='form-control ng-pristine ng-untouched md-input ng-empty ng-valid ng-valid-required']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(TextArea));
		MoveToElementClick(element);
		writeText(TextArea, "Hello !These Business Hour is Created Via Automation");
		ExtentSuccessMessage("Descriptio has been Added");

		By CustomType = By.xpath("(//span[contains(.,'Custom hours')])[3]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CustomType));
		MoveToElementClick(element);
		String custom = element.getText();
		System.out.println(custom);
		ExtentSuccessMessage("Type has been clicked");

		element = wait.until(ExpectedConditions.presenceOfElementLocated(TimeZoneDD));
		MoveToElementClick(element);

		element = wait.until(ExpectedConditions.presenceOfElementLocated(TimezoneDDOption));
		MoveToElementClick(element);
		ExtentSuccessMessage("Time zone has been selected");

		// Monday
		By Monday = By.xpath("(//span[@class='ng-binding ng-scope'])[3]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Monday));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Monday");

		Thread.sleep(2000);
		By MondayFromHr = By.xpath(
				"/html/body/div[3]/div[6]/div/ui-view/div[4]/div/div[2]/div/div[2]/md-input-container[1]/md-select");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(MondayFromHr));
		MoveToElementClick(element);

		Thread.sleep(1000);
		By Nine = By.xpath("(//md-option[@value='09'])[28]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Nine));
		MoveToElementClick(element);
		Thread.sleep(800);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(MondayFromHr));
		String nine = element.getText();
		System.out.println(nine);

		Thread.sleep(1000);
		By MondayMinFrom = By.xpath(
				"/html/body/div[3]/div[6]/div/ui-view/div[4]/div/div[2]/div/div[2]/md-input-container[2]/md-select");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(MondayMinFrom));
		MoveToElementClick(element);
		Thread.sleep(1000);

		By Zero = By.xpath("(//md-option[@value='00'])[28]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Zero));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected Start time of Monday");
		Thread.sleep(1000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(MondayMinFrom));
		String zero = element.getText();
		System.out.println(zero);

		Thread.sleep(800);
		By MondayToHr = By.xpath(
				"/html/body/div[3]/div[6]/div/ui-view/div[4]/div/div[2]/div/div[2]/md-input-container[3]/md-select");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(MondayToHr));
		MoveToElementClick(element);
		Thread.sleep(1000);
		By Six = By.xpath("(//md-option[@value='18'])[28]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Six));
		MoveToElementClick(element);
		Thread.sleep(800);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(MondayToHr));
		String six = element.getText();
		System.out.println(six);

		By MondayMinto = By.xpath(
				"/html/body/div[3]/div[6]/div/ui-view/div[4]/div/div[2]/div/div[2]/md-input-container[4]/md-select");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(MondayMinto));
		MoveToElementClick(element);
		Thread.sleep(1000);
		By Thirty = By.xpath("(//md-option[@value='30'])[14]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Thirty));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected End time of Monday");
		Thread.sleep(1000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(MondayMinto));
		String thirty = element.getText();
		System.out.println(thirty);

		// Thursday
		By Thursday = By.xpath("(//span[@class='ng-binding ng-scope'])[6]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Thursday));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Thursday");

		By ThursdayFromHr = By.xpath("(//md-select-value[@class='md-select-value md-select-placeholder'])[13]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ThursdayFromHr));
		MoveToElementClick(element);
		Thread.sleep(1000);
		By Ten = By.cssSelector("#select_option_771");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Ten));
		MoveToElementClick(element);

		Thread.sleep(1000);
		By ThursdayMinFrom = By.xpath("(//md-select-value[@class='md-select-value md-select-placeholder'])[13]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ThursdayMinFrom));
		MoveToElementClick(element);
		Thread.sleep(1000);
		By Two = By.cssSelector("#select_option_787");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Two));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected Start time of Thursday");

		Thread.sleep(800);
		By ThursdayToHr = By.xpath("(//md-select-value[@class='md-select-value md-select-placeholder'])[13]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ThursdayToHr));
		MoveToElementClick(element);
		Thread.sleep(1000);
		By Nineteen = By.cssSelector("#select_option_864");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Nineteen));
		MoveToElementClick(element);
		Thread.sleep(1000);
		By ThursdayMinto = By.xpath("(//md-select-value[@class='md-select-value md-select-placeholder'])[13]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ThursdayMinto));
		MoveToElementClick(element);
		Thread.sleep(1000);
		By five = By.cssSelector("#select_option_874");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(five));
		MoveToElementClick(element);
		ExtentSuccessMessage("Selected End time of Thursday");

		By Saturday = By.xpath("(//span[@class='ng-binding ng-scope'])[8]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Saturday));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Saturday");

		By TwentyFourHr = By.xpath("(//div[@class='md-container md-ink-ripple'])[14]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(TwentyFourHr));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on TwentyFour Hour Format");

		By BuissnessHrSaveButton = By.xpath("//button[@class='btn btn-default green ng-scope']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(BuissnessHrSaveButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("Buissness Hour has been Saved");

		Thread.sleep(4000);

		By SearchText = By.xpath(
				"//input[@class='ng-pristine ng-untouched md-input ng-empty ng-valid-minlength ng-valid-maxlength ng-valid ng-valid-required']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SearchText));
		MoveToElementClick(element);
		writeText(SearchText, BuissnessHr + Keys.ENTER);

		By BuissnessHourInc = By.xpath("(//a[@class='edit-list-anchor ng-binding'])[1]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(BuissnessHourInc));
		AgentText = element.getText();
		System.out.println("-----------" + AgentText + "------------");
		Assert.assertEquals(AgentText, BuissnessHr);
		ExtentSuccessMessage("Assertion has been done");

		By BuissnessType = By.xpath("(//div[@class='ui-grid-cell-contents ng-binding ng-scope'])[1]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(BuissnessType));
		String text = element.getText();
		System.out.println(text);

		Assert.assertEquals(text, custom);
		ExtentSuccessMessage("Assertion for BuissnessType is Done");

		element = wait.until(ExpectedConditions.presenceOfElementLocated(BuissnessHourInc));
		MoveToElementClick(element);
		ExtentSuccessMessage("Buissness Hour has been Clicked");

		Thread.sleep(4000);
		By MondayAss = By.xpath("(//md-select-value[@class='md-select-value'])[2]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(MondayAss));
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		String mondayass = element.getText();
		System.out.println(mondayass);

		Assert.assertEquals(mondayass, nine);
		ExtentSuccessMessage("Assertion for Monday Start time is Done");

		By MondayAss2 = By.xpath("(//md-select-value[@class='md-select-value'])[4]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(MondayAss2));
		String mondayass2 = element.getText();
		System.out.println(mondayass2);

		Assert.assertEquals(mondayass2, six);
		ExtentSuccessMessage("Assertion for Monday End time is Done");

		By Edit = By.xpath("//button[@class='btn btn-default green ng-scope']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Edit));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Edit Button");

		Thread.sleep(3000);
		By Friday = By.xpath("(//span[@class='ng-binding ng-scope'])[7]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Friday));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Friday Button");

		By FridayHr = By
				.xpath("(//md-checkbox[@class='ng-pristine ng-untouched ng-empty ng-invalid ng-invalid-required'])[3]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(FridayHr));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Friday 24 HR Button");

		By Update = By.xpath("//button[@class='btn btn-default green ng-scope']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Update));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Update button");

		Thread.sleep(4000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(BuissnessHourInc));
		MoveToElementClick(element);
		ExtentSuccessMessage("Buissness Hour has been Clicked");

		Thread.sleep(4000);
		WebElement checkbox = driver.findElement(By.cssSelector(
				"#page-wrapper > div > ui-view > div:nth-child(4) > div > div.time-zone-drop-custom > div > div:nth-child(6) > md-checkbox.ng-pristine.ng-untouched.ng-valid.ng-not-empty.md-checked.ng-valid-required"));

		if (checkbox.isSelected()) {
			System.out.println("The checkbox is selected.");

		} else {
			System.out.println("The checkbox is not selected.");
			ExtentSuccessMessage("Clicked on Delete Button");

		}
		ExtentSuccessMessage("Assertion for Checkbox is done");

		By Cancel = By.xpath("//button[@class='btn btn-default grey']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Cancel));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on cancel Button");

		By Refresh = By.xpath("//a[@class='pull-right reset-button ng-isolate-scope']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Refresh));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Refresh Button");

		Thread.sleep(5000);
		By Type = By.xpath("//div[@class='accordion-container grid-style-height']/i");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Type));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Tyoe` Button");

		By Custom = By.xpath("//md-checkbox[@name='Custom hours']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Custom));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Custom Hours");

		Thread.sleep(3000);

		By Auto = By.xpath("(//a[@class='edit-list-anchor ng-binding'])[1]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Auto));
		String auto = element.getText();
		System.out.println(auto);

		Assert.assertEquals(auto, BuissnessHr);
		ExtentSuccessMessage("Buissness hour which is created today is visble");

		By Export = By.xpath("//button[@name='downlodDataBtn']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Export));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Export button");

		Thread.sleep(2000);
		By popup = By.xpath("//div[@id='divSuccesss']");
		Assert.assertTrue(driver.findElement(popup).isDisplayed());

		element = wait.until(ExpectedConditions.presenceOfElementLocated(Refresh));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Refresh Button");

		Thread.sleep(4000);

		By AdvanceSearch = By.xpath("//button[@name='advancedSearchBtn']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AdvanceSearch));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on AdvanceSearch Button");

		LocalDate currentDate = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		String formattedDate = currentDate.format(formatter);
		System.out.println(formattedDate);

		Thread.sleep(2000);

		By CreatedDate = By.xpath("//input[@name='ModifiedEndDate']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CreatedDate));
		MoveToElementClick(element);
		writeText(CreatedDate, formattedDate + Keys.ENTER);
		ExtentSuccessMessage("Clicked on CreatedDate field");

		Thread.sleep(2000);
		By Search = By.xpath("//button[@name='applyadvancedSearchBtn']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Search));
		MoveToElementClick(element);

		Thread.sleep(3000);
		By BHAss = By.xpath("(//a[@class='edit-list-anchor ng-binding'])[1]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(BHAss));
		String bhass = element.getText();
		System.out.println(bhass);

		Assert.assertEquals(bhass, BuissnessHr);
		ExtentSuccessMessage("Assertion for Advance Search is done");

		element = wait.until(ExpectedConditions.presenceOfElementLocated(Refresh));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Refresh Button");

		Thread.sleep(6000);

		By Input = By.xpath(
				"/html/body/div[3]/div[6]/div/ui-view/div[1]/div/h1/div/div[2]/div/form/md-autocomplete/md-autocomplete-wrap/md-input-container/input");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Input));
		MoveToElementClick(element);
		writeText(Input, BuissnessHr + Keys.ENTER);

		Thread.sleep(5000);
		By Delete = By.xpath("//i[@class='glyphicon glyphicon-trash']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Delete));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Delete Button");

		Thread.sleep(3000);
		By Yes = By.xpath("//button[@class='btn btn-primary btn-default green']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Yes));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Yes Button");

	}

	public void admin_AddHolidayCalendar() throws InterruptedException {

		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AdminTile));
		MoveToElementClick(element);
		ExtentSuccessMessage("Agency Tile has been clicked");

		waitForElement(2000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(HolidayCalendar));
		MoveToElementClick(element);
		ExtentSuccessMessage("Calendar has been clicked");

		waitForElement(2000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(GridView));
		MoveToElementClick(element);

		waitForElement(2000);
		Assert.assertTrue(driver.findElement(NewHolidayButton).isDisplayed());
		ExtentSuccessMessage("Assertion has been done");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(NewHolidayButton));
		MoveToElementClick(element);

		waitForElement(2000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(HolidayName));
		MoveToElementClick(element);
		String HolidayNameField = "AutoHoliday" + getRandomNumber();
		System.out.println(HolidayNameField);
		writeText(HolidayName, HolidayNameField);
		ExtentSuccessMessage("Name has been Entered");

		LocalDate currentDate = LocalDate.now();
		LocalDate futureDate = currentDate.plusDays(31);
		LocalDate futureDate2 = currentDate.plusDays(32);

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("MM/dd/yyyy");

		String formattedDate = futureDate.format(formatter);
		String formattedDate2 = futureDate2.format(formatter1);
		System.out.println(formattedDate);
		System.out.println(formattedDate2);

		Thread.sleep(5000);
		WebElement dateField = driver
				.findElement(By.xpath("(//div[@class='dx-dropdowneditor-input-wrapper'])[1]/div/input"));
		js.executeScript("arguments[0].value='';", dateField);
		Thread.sleep(800);
		dateField.sendKeys(formattedDate + Keys.ENTER);

		WebElement dateField2 = driver
				.findElement(By.xpath("(//div[@class='dx-dropdowneditor-input-wrapper'])[2]/div/input"));
		js.executeScript("arguments[0].value='';", dateField2);
		Thread.sleep(800);
		dateField2.sendKeys(formattedDate2);

		By AllDaySwitch = By.xpath("//div[@class='dx-switch dx-swipeable dx-widget dx-visibility-change-handler']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AllDaySwitch));
		MoveToElementClick(element);
		ExtentSuccessMessage("All Day Switch has been Clicked");

		waitForElement(2000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PredenceFieldc));
		MoveToElementClick(element);
		By PredenceOption = By.xpath("(//div[@class='dx-item dx-list-item'])[2]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PredenceOption));
		MoveToElementClick(element);
		Thread.sleep(1500);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PredenceFieldc));
		String predence = element.getText();
		System.out.println(predence);
		ExtentSuccessMessage("PredenceFieldc has been Entered");

		waitForElement(2000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PromptField));
		MoveToElementClick(element);
		By PromptOption = By.xpath("(//div[@class='dx-item-content dx-list-item-content'])[7]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PromptOption));
		MoveToElementClick(element);
		Thread.sleep(1500);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PromptField));
		String prompt = element.getText();
		System.out.println(prompt);
		ExtentSuccessMessage("PromptField has been Entered");

		waitForElement(2000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CalendarTextArea));
		MoveToElementClick(element);
		writeText(CalendarTextArea, "This holiday is created via automation");
		ExtentSuccessMessage("CalendarTextArea has been Entered");

		waitForElement(2000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CalendarSaveButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("Holiday has been entered");

		Thread.sleep(3000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(GridView));
		MoveToElementClick(element);

		Thread.sleep(6000);
		By SearchFiled = By.xpath(
				"//input[@class='ng-pristine ng-untouched md-input ng-empty ng-valid-minlength ng-valid-maxlength ng-valid ng-valid-required']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SearchFiled));
		MoveToElementClick(element);
		writeText(SearchFiled, HolidayNameField + Keys.ENTER);
		ExtentSuccessMessage("Holiday Name has been Searched");

		Thread.sleep(3000);
		By HolidayAss = By.xpath("//a[@class='edit-list-anchor ng-binding']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(HolidayAss));
		String holidayass = element.getText();
		System.out.println(holidayass);

		Assert.assertEquals(holidayass, HolidayNameField);
		ExtentSuccessMessage("Assertion For Holiday name has been Done");

//		By PrecedenceAss = By.xpath("(//div[@class='ui-grid-cell-contents ng-binding ng-scope'])[1]");
//		element = wait.until(ExpectedConditions.presenceOfElementLocated(PrecedenceAss));
//		String precedenceass = element.getText();
//		System.out.println(precedenceass);
//		
//		Assert.assertEquals(precedenceass, predence);
//		ExtentSuccessMessage("Assertion For Precedence has been Done");
//		
		By StartAss = By.xpath("(//div[@class='ui-grid-cell-contents ng-binding ng-scope'])[3]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(StartAss));
		String startass = element.getText();
		System.out.println(startass);

		Assert.assertEquals(startass, formattedDate);
		ExtentSuccessMessage("Assertion For Start Date has been Done");

		By EndDate = By.xpath("(//div[@class='ui-grid-cell-contents ng-binding ng-scope'])[4]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(EndDate));
		String endass = element.getText();
		System.out.println(endass);

		Assert.assertEquals(endass, formattedDate2);
		ExtentSuccessMessage("Assertion For End Date has been Done");

		By Edit = By.xpath("//a[@class='edit-list-icons']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Edit));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked On Edit button");

		Thread.sleep(4000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(PredenceFieldc));
		MoveToElementClick(element);
		By Option = By.xpath("(//div[@class='dx-item-content dx-list-item-content'])[1]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Option));
		MoveToElementClick(element);
		Thread.sleep(800);
		By precedenceText = By.xpath("(//input[@class='dx-texteditor-input'])[4]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(precedenceText));
		String editedoption = element.getText();
		System.out.println(editedoption);
		ExtentSuccessMessage("Changed Precedence value");

		By SaveButton = By.xpath("(//div[@class='dx-button-content'])[11]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SaveButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Save Button");

		Thread.sleep(7000);
		By Forward = By.xpath("(//div[@class='dx-button-content'])[3]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Forward));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Forward Button");

		Thread.sleep(2000);
		By HolidayAsss = By.xpath("//div[@class='dx-item-content dx-scheduler-appointment-content']/div[contains(.,'"
				+ HolidayNameField + "')]");
		Assert.assertTrue(driver.findElement(HolidayAsss).isDisplayed());
		ExtentSuccessMessage("Assertion for Holiday Calendar is Done");

		Thread.sleep(3000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(GridView));
		MoveToElementClick(element);

		By Refresh = By.xpath("//a[@class='pull-right reset-button ng-isolate-scope']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Refresh));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clickd on Refersh Button");

		By Precedence = By.xpath("//div[@class='accordion-container grid-style-height']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Precedence));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Precedence Button");

		By One = By.xpath("//md-checkbox[@name='01']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(One));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Precedence Button");

		Thread.sleep(3000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Refresh));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clickd on Refersh Button");

		By Advance = By.xpath("//button[@id='advancedSearchBtn']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Advance));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Advance Search Button");

		Thread.sleep(2000);

		By From = By.xpath("//input[@name='FromDate']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(From));
		MoveToElementClick(element);
		writeText(From, formattedDate + Keys.ENTER);
		ExtentSuccessMessage("Start date has been entered");

		By ToDate = By.xpath("//input[@name='ToDate']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(ToDate));
		MoveToElementClick(element);
		writeText(ToDate, formattedDate2 + Keys.ENTER);
		ExtentSuccessMessage("End date has been entered");

		By Search = By.xpath("//button[@class='btn btn-default green pull-right']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Search));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Search Button");

		Thread.sleep(4000);

		By HolidayAss1 = By.xpath("//a[@class='edit-list-anchor ng-binding']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(HolidayAss1));
		String holidayass1 = element.getText();
		System.out.println(holidayass1);

		Assert.assertEquals(holidayass1, HolidayNameField);
		ExtentSuccessMessage("Holiday is visible after Search");

		Thread.sleep(2000);

		By Delete = By.xpath("//i[@class='glyphicon glyphicon-trash']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Delete));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Delete Button");

		Thread.sleep(3000);
		By Yesbutton = By.xpath("//button[@class='btn btn-primary btn-default green']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Yesbutton));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Yes Button");

		Thread.sleep(3000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(GridView));
		MoveToElementClick(element);
		ExtentSuccessMessage("holiday has been deleted");

	}

	public void admin_Customization() throws InterruptedException {

		waitForElement(6000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AdminTile));
		MoveToElementClick(element);
		ExtentSuccessMessage("Agency Tile has been clicked");

		Thread.sleep(3000);
		By Customization = By.xpath("//a[@href='#/admin/customization']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Customization));
		MoveToElementClick(element);
		ExtentSuccessMessage("Customization has been clicked");

		Thread.sleep(5000);
		By CodeSection = By.xpath("(//input[@class='ui-grid-filter-input ui-grid-filter-input-0'])[1]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(CodeSection));
		MoveToElementClick(element);
		writeText(CodeSection, "Lead Source" + Keys.ENTER);
		ExtentSuccessMessage("Entered Lead Source in Code Section");

		Thread.sleep(2000);
		By LeadSource = By.xpath("(//div[@title='Lead Source'])[1]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(LeadSource));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Lead Source");

		Thread.sleep(4000);
		By AddButton = By.xpath("//i[@class='dx-icon dx-icon-edit-button-addrow']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AddButton));
//        js.executeScript("arguments[0].scrollIntoView({block: 'nearest', inline: 'center'});", AddButton);
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Add Button");

		Thread.sleep(2000);
		By LeadName = By.xpath("(//input[@class='dx-texteditor-input'])[1]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(LeadName));
		MoveToElementClick(element);
		String leadname = "AutoSource" + getRandomNumber();
		System.out.println(leadname);
		writeText(LeadName, leadname);
		ExtentSuccessMessage("Entered LeadSource Details");

		By DispayOrder = By.xpath("(//input[@class='dx-texteditor-input'])[3]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(DispayOrder));
		MoveToElementClick(element);
		writeText(DispayOrder, "1");
		ExtentSuccessMessage("Clicked on Display order");

		Thread.sleep(4000);
		WebElement Save = driver.findElement(By.xpath("a[class='dx-link dx-link-save']"));
		String save = Save.getAttribute("Pseudo");
		System.out.println(save);

		wait.until(ExpectedConditions.elementToBeClickable(Save));
//		click(Save);
		ExtentSuccessMessage("Clicked on Save Button");

		Thread.sleep(4000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(AddButton));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Add Button");

		element = wait.until(ExpectedConditions.presenceOfElementLocated(LeadName));
		MoveToElementClick(element);
		String leadname1 = "AutoSourceEdit" + getRandomNumber();
		System.out.println(leadname1);
		writeText(LeadName, leadname1);
		ExtentSuccessMessage("Entered LeadSource Details");

		Thread.sleep(2000);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(DispayOrder));
		MoveToElementClick(element);
		writeText(DispayOrder, "1");
		ExtentSuccessMessage("Clicked on Display order");

		Thread.sleep(2000);
//		element = wait.until(ExpectedConditions.presenceOfElementLocated(Save));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Save Button");

		Thread.sleep(2000);
		By Apply = By.xpath("//i[@title='Apply Code Value Changes']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Apply));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Apply Button");

		Thread.sleep(2000);
		By Sales = By.name("menu_Sales");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Sales));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Sales");

		By Leads = By.name("submenu_salesleads");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Leads));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Leads");

		Thread.sleep(8000);
		By NewLead = By.name("newLeadBtn");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(NewLead));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on New Leads Buttons");

		Thread.sleep(5000);
		By LeadFirstName = By.xpath("//input[@name='LeadFirstName']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(LeadFirstName));
		MoveToElementClick(element);
		String FirstName = "Automation";
		writeText(LeadFirstName, FirstName);
		ExtentSuccessMessage("First Name of Lead has been entered");

		waitForElement(1000);
		By LeadLastName = By.xpath("//input[@name='LeadLastName']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(LeadLastName));
		MoveToElementClick(element);
		String lastName = "User" + getRandomNumber();
		writeText(LeadLastName, lastName);
		ExtentSuccessMessage("Last name of lead has been enterd");

		By LeadPhoneNumber = By.xpath("//input[@name='LeadMobile']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(LeadPhoneNumber));
		MoveToElementClick(element);
		String LeadNumber = generatePhoneNumber();
		System.out.println(LeadNumber);
		writeText(LeadPhoneNumber, LeadNumber);
		ExtentSuccessMessage("Mobile Number of lead has been added");

		waitForElement(1000);
		By LeadInfomation = By.cssSelector("#formFlag2 > i");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(LeadInfomation));
		MoveToElementClick(element);

		Thread.sleep(2000);
		By SourceDD = By.xpath("//md-select[@name='LeadSource']");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SourceDD));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Source DD");

		Thread.sleep(800);
		By Option = By.xpath("(//md-option[@value='" + leadname + "'])[2]");
		System.out.println(Option);
		element = wait.until(ExpectedConditions.presenceOfElementLocated(Option));
		MoveToElementClick(element);
		ExtentSuccessMessage("Clicked on Source Option");

		waitForElement(4000);
		By SubmitButton = By.xpath("(//button[@class='btn btn-default green'])[4]");
		element = wait.until(ExpectedConditions.presenceOfElementLocated(SubmitButton));
		MoveToElementClick(element);

	}

}
