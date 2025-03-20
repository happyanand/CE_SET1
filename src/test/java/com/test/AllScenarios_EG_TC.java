

package com.test;

import java.awt.AWTException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.BasePackage.Base_Class;
import com.Utility.Log;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentManager;
import com.extentReports.ExtentTestManager;
import com.listeners.TestListener;
import com.pages.CensusInfo;

import Common.TriggerEmail;



import java.awt.AWTException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.BasePackage.Base_Class;
import com.Utility.Log;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentManager;
import com.extentReports.ExtentTestManager;
import com.listeners.TestListener;
import com.pages.CensusInfo;

import Common.TriggerEmail;

public class AllScenarios_EG_TC extends Base_Class {
	TestListener TestListener;
	Base_Class Base_Class;
//	public static com.pages.HomePage homepage;
	// HomePage homepage;
	Log log;
	com.Utility.ScreenShot screenShot;
	com.Utility.ExcelReader ExcelReader;

	// NavigateNewClaim NewClaim = new NavigateNewClaim();
	@Override
	public WebDriver getDriver() {
//		homepage = new com.pages.HomePage(driver);
		return driver;
	}

	// Batch Reserve Approval
	
	TC_CE_001_Login_Logout_Validation TC_CE_001_Login_Logout_Validation;

	TC_CE_037_038_039_040Customer_Creation_Opportunity_Service_Actions TC_CE_037_038_039_040Customer_Creation_Opportunity_Service_Actions;
	TC_CE_041_042_043_044_Customer_Filter_AdvanceSearch_Import TC_CE_041_042_043_044_Customer_Filter_AdvanceSearch_Import;
	TC_CE_044_Customer_CustomerContactCard TC_CE_044_Customer_CustomerContactCard;
	Customer_ImportCustomerAndPolicies Customer_ImportCustomerAndPolicies;


	CS_TS_001_TC_006_007_Quote_Records_Validation CS_TS_001_TC_006_007_Quote_Records_Validation;
	CS_TS_001_TC_012_Collaboration_Actions_Validation CS_TS_001_TC_012_Collaboration_Actions_Validation;
	CS_TS_CreateOpportunity_Qualify_Changelead_Edit_Actions_Delete_Opportunity CS_TS_CreateOpportunity_Qualify_Changelead_Edit_Actions_Delete_Opportunity;
	CS_TS_003_TC_004_Search_Validation CS_TS_003_TC_004_Search_Validation;
	CS_TS_003_TC_003_Reset_Filter CS_TS_003_TC_003_Reset_Filter;
	
	CS_TS_001_TC_004_View_Customer_Details CS_TS_001_TC_004_View_Customer_Details;
	CS_TS_001_TC_005_View_All_Opportunity_Records CS_TS_001_TC_005_View_All_Opportunity_Records;
	CS_TS_001_TC_011_Edit_Customer_Information CS_TS_001_TC_011_Edit_Customer_Information;
	CS_TS_003_TC_006_More_Column_Options CS_TS_003_TC_006_More_Column_Options;
	TC_CE_20_21_Sales_Opportunity_CreateNewOpportunity_OpportunityQuote TC_CE_20_21_Sales_Opportunity_CreateNewOpportunity_OpportunityQuote;
	TC_CE_24_SearchValidations TC_CE_24_SearchValidations;
	//TC_CE_025_Sales_Opportunity_OpportunityAdvanceSearch TC_CE_025_Sales_Opportunity_OpportunityAdvanceSearch;
	OP_TS_001_TC_002_003_004_005_Newly_Created_Opportunity OP_TS_001_TC_002_003_004_005_Newly_Created_Opportunity;
	TC_CE_066_067_068_069_Admin_CreateNewUser_Edit_Reset_Delete TC_CE_066_067_068_069_Admin_CreateNewUser_Edit_Reset_Delete;
	
	TC_CE_070_Admin_AddRolesAndPermission TC_CE_070_Admin_AddRolesAndPermission;
	TC_CE_071_072_Admin_AddNewCallDeposition_EditDisposition TC_CE_071_072_Admin_AddNewCallDeposition_EditDisposition;
	TC_CE_073_Admin_AddBusinessHours TC_CE_073_Admin_AddBusinessHours;
	TC_CE_074_Admin_AddHolidayCalender TC_CE_074_Admin_AddHolidayCalender;
	
	//TC_CE_001_Login_Logout_Validation TC_CE_001_Login_Logout_Validation;
	TC_CE_002_Landingpage_Validation TC_CE_002_Landingpage_Validation;
	TC_CE_003_HomePage_IconAccess TC_CE_003_HomePage_IconAccess;
	LP_001_002_003_Home_Landingpage_Grid_Validation LP_001_002_003_Home_Landingpage_Grid_Validation;
	LP_004_005_NewLandingPage_Validations LP_004_005_NewLandingPage_Validations;
	LP_09_10_11_sample_edit_existing_Templates LP_09_10_11_sample_edit_existing_Templates;
	LP_13_14_Thumbnail_Select_Preview_Validation LP_13_14_Thumbnail_Select_Preview_Validation;
	LP_20_21_23_Action_Tab_Validation LP_20_21_23_Action_Tab_Validation;
	LP_24_26_SummaryPage_Validation LP_24_26_SummaryPage_Validation;
	LP_28_29_Landing_grid_Leads_Validation LP_28_29_Landing_grid_Leads_Validation;
	
	// private static By L_Logout =
	// By.xpath("//body/div[@id='banner']/div[@id='rightMenu']/ul[1]/li[3]/i[1]");
	By signInButtonClass = By.className("btnSignIn");
	By signout = By.xpath("//a[@class=\"dropdownMenu user-details-menuSection dropdownArrowMenu\"]");
	By signoutbtn = By.xpath("//*[@id='dropdownMenuListSec']//a[contains(text(),'Sign Out')]");
	By signoutInshura = By.xpath("//div[@class=\"signoutsec\"]");

	@BeforeSuite
	public void reference() {
		ExcelReader = new com.Utility.ExcelReader("PLCA");
		log = new Log();
		TestListener = new TestListener();
		screenShot = new com.Utility.ScreenShot(null);
		Base_Class = new Base_Class();
		
		
		TC_CE_001_Login_Logout_Validation = new TC_CE_001_Login_Logout_Validation();

		TC_CE_037_038_039_040Customer_Creation_Opportunity_Service_Actions = new TC_CE_037_038_039_040Customer_Creation_Opportunity_Service_Actions();
		TC_CE_041_042_043_044_Customer_Filter_AdvanceSearch_Import = new TC_CE_041_042_043_044_Customer_Filter_AdvanceSearch_Import();
		TC_CE_044_Customer_CustomerContactCard = new TC_CE_044_Customer_CustomerContactCard();
		Customer_ImportCustomerAndPolicies = new Customer_ImportCustomerAndPolicies();
		CS_TS_001_TC_006_007_Quote_Records_Validation = new CS_TS_001_TC_006_007_Quote_Records_Validation();
		CS_TS_001_TC_012_Collaboration_Actions_Validation = new CS_TS_001_TC_012_Collaboration_Actions_Validation();
		CS_TS_CreateOpportunity_Qualify_Changelead_Edit_Actions_Delete_Opportunity = new CS_TS_CreateOpportunity_Qualify_Changelead_Edit_Actions_Delete_Opportunity();
		CS_TS_003_TC_004_Search_Validation = new CS_TS_003_TC_004_Search_Validation();
		CS_TS_003_TC_003_Reset_Filter = new CS_TS_003_TC_003_Reset_Filter();
		
		CS_TS_001_TC_004_View_Customer_Details = new CS_TS_001_TC_004_View_Customer_Details();
		CS_TS_001_TC_005_View_All_Opportunity_Records = new CS_TS_001_TC_005_View_All_Opportunity_Records();
		CS_TS_001_TC_011_Edit_Customer_Information = new CS_TS_001_TC_011_Edit_Customer_Information();
		CS_TS_003_TC_006_More_Column_Options = new CS_TS_003_TC_006_More_Column_Options();
		
		TC_CE_20_21_Sales_Opportunity_CreateNewOpportunity_OpportunityQuote = new TC_CE_20_21_Sales_Opportunity_CreateNewOpportunity_OpportunityQuote();
		//TC_CE_21_Sales_Opportunity_CreateOpportunityQuote = new TC_CE_21_Sales_Opportunity_CreateOpportunityQuote();
		TC_CE_24_SearchValidations = new TC_CE_24_SearchValidations();
		//TC_CE_23_Sales_Opportunity_OpportunityActions = new TC_CE_23_Sales_Opportunity_OpportunityActions();
		//TC_CE_24_Sales_Opportunity_FilterOpportunity = new TC_CE_24_Sales_Opportunity_FilterOpportunity();
		
		//TC_CE_025_Sales_Opportunity_OpportunityAdvanceSearch2 = new TC_CE_025_Sales_Opportunity_OpportunityAdvanceSearch2();
		OP_TS_001_TC_002_003_004_005_Newly_Created_Opportunity = new OP_TS_001_TC_002_003_004_005_Newly_Created_Opportunity();
		
		TC_CE_066_067_068_069_Admin_CreateNewUser_Edit_Reset_Delete= new TC_CE_066_067_068_069_Admin_CreateNewUser_Edit_Reset_Delete();
		
		TC_CE_070_Admin_AddRolesAndPermission = new TC_CE_070_Admin_AddRolesAndPermission();
		TC_CE_071_072_Admin_AddNewCallDeposition_EditDisposition = new TC_CE_071_072_Admin_AddNewCallDeposition_EditDisposition();
		TC_CE_073_Admin_AddBusinessHours = new TC_CE_073_Admin_AddBusinessHours();
		TC_CE_074_Admin_AddHolidayCalender = new TC_CE_074_Admin_AddHolidayCalender();

		TC_CE_001_Login_Logout_Validation = new TC_CE_001_Login_Logout_Validation();
		//System_Cleaning_Script = new System_Cleaning_Script();
		TC_CE_002_Landingpage_Validation = new TC_CE_002_Landingpage_Validation();
		TC_CE_003_HomePage_IconAccess = new TC_CE_003_HomePage_IconAccess();
		LP_001_002_003_Home_Landingpage_Grid_Validation = new LP_001_002_003_Home_Landingpage_Grid_Validation();
		LP_004_005_NewLandingPage_Validations =new LP_004_005_NewLandingPage_Validations();
		LP_09_10_11_sample_edit_existing_Templates = new LP_09_10_11_sample_edit_existing_Templates();
		LP_13_14_Thumbnail_Select_Preview_Validation = new LP_13_14_Thumbnail_Select_Preview_Validation();
		LP_20_21_23_Action_Tab_Validation = new LP_20_21_23_Action_Tab_Validation();
		LP_24_26_SummaryPage_Validation = new LP_24_26_SummaryPage_Validation();
		LP_28_29_Landing_grid_Leads_Validation = new LP_28_29_Landing_grid_Leads_Validation();

	}

//	public void Login() throws InterruptedException {
//		String ReferenceLogin = "PLCA";
//		try {
//			Base_Class.SetUp(ReferenceLogin);
//			ExtentTestManager.getTest().log(Status.PASS, "Application Login " + Base_Class.Pagetitle);
//			Log.info("Login successful !");
//			// ExtentTestManager.getTest().log(Status.PASS, "Successfully Entered into
//			// Application URL ");
//			
//		} catch (IOException e) {
//			e.printStackTrace();
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//	}
	
	public void LoginCustomerEngage() throws InterruptedException {
		String ReferenceLogin = "PLCA";
		try {
			Base_Class.SetUpRegression(ReferenceLogin);
			ExtentTestManager.getTest().log(Status.PASS, "Application Login " + Base_Class.Pagetitle);
			Log.info("Login successful !");
			// ExtentTestManager.getTest().log(Status.PASS, "Successfully Entered into
			// Application URL ");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	public void SetUpRegressionForCall() throws InterruptedException {
		String ReferenceLogin = "PLCA";
		try {
			Base_Class.SetUpRegressionForCall(ReferenceLogin);
			ExtentTestManager.getTest().log(Status.PASS, "Application Login " + Base_Class.Pagetitle);
			Log.info("Login successful !");
			// ExtentTestManager.getTest().log(Status.PASS, "Successfully Entered into
			// Application URL ");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	 

	public void LoginSanity() throws InterruptedException {
		String ReferenceLogin = "PLCA";
		try {
			Base_Class.SetUpSanity(ReferenceLogin);
			ExtentTestManager.getTest().log(Status.PASS, "Application Login " + Base_Class.Pagetitle);
			Log.info("Login successful !");
			// ExtentTestManager.getTest().log(Status.PASS, "Successfully Entered into
			// Application URL ");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
//	public void LoginBrokerEngage() throws InterruptedException {
//		String ReferenceLogin = "PLCA";
//		try {
//			Base_Class.SetUpP2Regression(ReferenceLogin);
//			ExtentTestManager.getTest().log(Status.PASS, "Application Login " + Base_Class.Pagetitle);
//			Log.info("Login successful !");
//			// ExtentTestManager.getTest().log(Status.PASS, "Successfully Entered into
//			// Application URL ");
//		} catch (IOException e) {
//			e.printStackTrace();
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//	}
	
//	public void AdminAgentLoginBE() throws InterruptedException {
//		String ReferenceLogin = "PLCA";
//		try {
//			Base_Class.LoginAdminAgent(ReferenceLogin);
//			ExtentTestManager.getTest().log(Status.PASS, "Application Login " + Base_Class.Pagetitle);
//			Log.info("Login successful !");
//			// ExtentTestManager.getTest().log(Status.PASS, "Successfully Entered into
//			// Application URL ");
//		} catch (IOException e) {
//			e.printStackTrace();
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//	}
	
	public void Logout() throws InterruptedException, AWTException {

		driver.quit();

	}
	
	public void LoginBrokerEngage() throws InterruptedException {
		String ReferenceLogin = "PLCA";
		try {
			Base_Class.SetUpP2Regression(ReferenceLogin);
			ExtentTestManager.getTest().log(Status.PASS, "Application Login " + Base_Class.Pagetitle);
			Log.info("Login successful !");
			// ExtentTestManager.getTest().log(Status.PASS, "Successfully Entered into
			// Application URL ");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void LoginBrokerEngageSync() throws InterruptedException {
		String ReferenceLogin = "PLCA";
		try {
			Base_Class.SetUpBeCeSync(ReferenceLogin);
			ExtentTestManager.getTest().log(Status.PASS, "Application Login " + Base_Class.Pagetitle);
			Log.info("Login successful !");
			// ExtentTestManager.getTest().log(Status.PASS, "Successfully Entered into
			// Application URL ");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void LoginCEUserTwoSSO() throws InterruptedException {
		String ReferenceLogin = "PLCA";
		try {
			Base_Class.SetUpCEUsertwoSSO(ReferenceLogin);
			ExtentTestManager.getTest().log(Status.PASS, "Application Login " + Base_Class.Pagetitle);
			Log.info("Login successful !");
			// ExtentTestManager.getTest().log(Status.PASS, "Successfully Entered into
			// Application URL ");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void LoginCEUserTwo() throws InterruptedException {
		String ReferenceLogin = "PLCA";
		try {
			Base_Class.SetUpCEUsertwo(ReferenceLogin);
			ExtentTestManager.getTest().log(Status.PASS, "Application Login " + Base_Class.Pagetitle);
			Log.info("Login successful !");
			// ExtentTestManager.getTest().log(Status.PASS, "Successfully Entered into
			// Application URL ");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	public void LoginCEUsersix() throws InterruptedException {
		String ReferenceLogin = "PLCA";
		try {
			Base_Class.SetUpCEUsersix(ReferenceLogin);
			ExtentTestManager.getTest().log(Status.PASS, "Application Login " + Base_Class.Pagetitle);
			Log.info("Login successful !");
			// ExtentTestManager.getTest().log(Status.PASS, "Successfully Entered into
			// Application URL ");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void LoginCEUsersixSSO() throws InterruptedException {
		String ReferenceLogin = "PLCA";
		try {
			Base_Class.SetUpCEUsersixSSO(ReferenceLogin);
			ExtentTestManager.getTest().log(Status.PASS, "Application Login " + Base_Class.Pagetitle);
			Log.info("Login successful !");
			// ExtentTestManager.getTest().log(Status.PASS, "Successfully Entered into
			// Application URL ");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void LoginCEUserfive() throws InterruptedException {
		String ReferenceLogin = "PLCA";
		try {
			Base_Class.SetUpCEUserfive(ReferenceLogin);
			ExtentTestManager.getTest().log(Status.PASS, "Application Login " + Base_Class.Pagetitle);
			Log.info("Login successful !");
			// ExtentTestManager.getTest().log(Status.PASS, "Successfully Entered into
			// Application URL ");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void LoginCEUserOne() throws InterruptedException {
		String ReferenceLogin = "PLCA";
		try {
			Base_Class.SetUpCEUserone(ReferenceLogin);
			ExtentTestManager.getTest().log(Status.PASS, "Application Login " + Base_Class.Pagetitle);
			Log.info("Login successful !");
			// ExtentTestManager.getTest().log(Status.PASS, "Successfully Entered into
			// Application URL ");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void LoginCEUserOneSSO() throws InterruptedException {
		String ReferenceLogin = "PLCA";
		try {
			Base_Class.SetUpCEUseroneSSO(ReferenceLogin);
			ExtentTestManager.getTest().log(Status.PASS, "Application Login " + Base_Class.Pagetitle);
			Log.info("Login successful !");
			// ExtentTestManager.getTest().log(Status.PASS, "Successfully Entered into
			// Application URL ");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}  
	
	public void LoginCEUserOneHeadless() throws InterruptedException {
		String ReferenceLogin = "PLCA";
		try {
			Base_Class.SetUpCEUseroneHeadless(ReferenceLogin);
			ExtentTestManager.getTest().log(Status.PASS, "Application Login " + Base_Class.Pagetitle);
			Log.info("Login successful !");
			// ExtentTestManager.getTest().log(Status.PASS, "Successfully Entered into
			// Application URL ");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	} 
	
	public void LoginCEUser_1() throws InterruptedException {
		String ReferenceLogin = "PLCA";
		try {
			Base_Class.SetUpUser1(ReferenceLogin);
			ExtentTestManager.getTest().log(Status.PASS, "Application Login " + Base_Class.Pagetitle);
			Log.info("Login successful !");
			// ExtentTestManager.getTest().log(Status.PASS, "Successfully Entered into
			// Application URL ");
		} catch (IOException e) { 
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void LoginCEUser_1SSO() throws InterruptedException {
		String ReferenceLogin = "PLCA";
		try {
			Base_Class.SetUpUser1SSO(ReferenceLogin);
			ExtentTestManager.getTest().log(Status.PASS, "Application Login " + Base_Class.Pagetitle);
			Log.info("Login successful !");
			// ExtentTestManager.getTest().log(Status.PASS, "Successfully Entered into
			// Application URL ");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void LoginCEUserFiveCognito() throws InterruptedException {
        String ReferenceLogin = "PLCA";
        try {
               Base_Class.SetUpCEUserfiveCognito(ReferenceLogin);
               ExtentTestManager.getTest().log(Status.PASS, "Application Login " + Base_Class.Pagetitle);
               Log.info("Login successful !");
               // ExtentTestManager.getTest().log(Status.PASS, "Successfully Entered into
               // Application URL ");
        } catch (IOException e) {
               e.printStackTrace();
        } catch (InterruptedException e) {
               e.printStackTrace();
        }
 }
	
	
	public void AdminAgentLoginBE() throws InterruptedException {
		String ReferenceLogin = "PLCA";
		try {
			Base_Class.LoginAdminAgent(ReferenceLogin);
			ExtentTestManager.getTest().log(Status.PASS, "Application Login " + Base_Class.Pagetitle);
			Log.info("Login successful !");
			// ExtentTestManager.getTest().log(Status.PASS, "Successfully Entered into
			// Application URL ");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Test(dataProvider = "TestData")
	public void RUNALL(Map<Object, Object> testdata, ITestContext context) throws Throwable {
		
		CensusInfo ApplicantInfo = new CensusInfo();
		CensusInfo spCensusInfo = new CensusInfo();
		CensusInfo SpouseInfo = new CensusInfo();
		new CensusInfo();
		CensusInfo DependentsInfo = new CensusInfo();
//		ArrayList<CensusInfo> DependentsInfo = new ArrayList<CensusInfo>();
		new CensusInfo();
	
		try {
			testdata.get("TestScenario").toString();

			if (testdata.get("Run").toString().equalsIgnoreCase("Yes")) {
				ExtentTestManager.startTest(testdata.get("TestScenario").toString());
				System.out.println("\n");
				System.out.println(
						"<--------------------------------------- START NEW TESTCASE --------------------------------------------------------->");
				Log.info("*** Running test method " + testdata.get("TestScenario").toString() + "...");

				switch (testdata.get("TestScenario").toString()) {
				
				case "TC_CE_001_Login_Logout_Validation":
					context.setAttribute("fileName", "Login");
					LoginCEUserOneSSO();
					TC_CE_001_Login_Logout_Validation.EG_TC_CE1(ApplicantInfo);
					Logout();
					context.setAttribute("fileName", "Logout");
					break;
					
				case "TC_CE_037_038_039_040Customer_Creation_Opportunity_Service_Actions":
					context.setAttribute("fileName", "Login");
					//LoginCEUserOne();
					LoginCEUserOneSSO();
					TC_CE_037_038_039_040Customer_Creation_Opportunity_Service_Actions.customerCreateNewCustomer();
					Logout();
					context.setAttribute("fileName", "Logout");
						break;	
						
						
				case "TC_CE_041_042_043_044_Customer_Filter_AdvanceSearch_Import":
					context.setAttribute("fileName", "Login");
					//LoginCEUserOne();
					LoginCEUserOneSSO();
					TC_CE_041_042_043_044_Customer_Filter_AdvanceSearch_Import.customerFilter();
					Logout();
					context.setAttribute("fileName", "Logout");
						break;	
								
				case "TC_CE_044_Customer_CustomerContactCard":
					context.setAttribute("fileName", "Login");
					//LoginCEUserOne();
					LoginCEUserOneSSO();
					TC_CE_044_Customer_CustomerContactCard.customerContactCard();
					Logout();
					context.setAttribute("fileName", "Logout");
						break;	
						
						
						
				case "Customer_ImportCustomerAndPolicies":
					context.setAttribute("fileName", "Login");
					//LoginCEUserOne();
					LoginCEUserOneSSO();
					Customer_ImportCustomerAndPolicies.ImportCustomerAndPolicies();
					Logout();
					context.setAttribute("fileName", "Logout");
					break;
						
				
				case "CS_TS_001_TC_004_View_Customer_Details":
					context.setAttribute("fileName", "Login");
					LoginCEUserOneSSO();
					CS_TS_001_TC_004_View_Customer_Details.EG_TC_View_Customer_Details();
					Logout();
					context.setAttribute("fileName", "Logout");
					break;	
				
				case "CS_TS_001_TC_005_View_All_Opportunity_Records":
					context.setAttribute("fileName", "Login");
					LoginCEUserOneSSO();
					CS_TS_001_TC_005_View_All_Opportunity_Records.EG_TC_View_All_Opportunity_Records();
					Logout();
					context.setAttribute("fileName", "Logout");
					break;	
				
				case "CS_TS_001_TC_011_Edit_Customer_Information":
					context.setAttribute("fileName", "Login");
					LoginCEUserOneSSO();
					CS_TS_001_TC_011_Edit_Customer_Information.EG_TC_Edit_Customer_Information();
					Logout();
					context.setAttribute("fileName", "Logout");
					break;		
					
				case "CS_TS_001_TC_006_007_Quote_Records_Validation":
					context.setAttribute("fileName", "Login");
					LoginCEUserOneSSO();
					CS_TS_001_TC_006_007_Quote_Records_Validation.Quote_validation(ApplicantInfo);
					Logout();
					context.setAttribute("fileName", "Logout");
					break;
				//CS_TS_001_TC_013_New_Opportunity	
				case "CS_TS_CreateOpportunity_Qualify_Changelead_Edit_Actions_Delete_Opportunity":
					context.setAttribute("fileName", "Login");
					//LoginCEUser_1();
					LoginCEUserFiveCognito();
					CS_TS_CreateOpportunity_Qualify_Changelead_Edit_Actions_Delete_Opportunity.New_Opportunity__validation(ApplicantInfo);
					Logout();
					context.setAttribute("fileName", "Logout");
					break;	
				//CS_TS_001_TC_012_Collaboration_Actions_Validation
				case "CS_TS_001_TC_012_Collaboration_Actions_Validation":
					context.setAttribute("fileName", "Login");
					LoginCEUserOneSSO();
					CS_TS_001_TC_012_Collaboration_Actions_Validation.Collaboration_Actions__validation(ApplicantInfo);
					Logout();
					context.setAttribute("fileName", "Logout");
					break;	
				//CS_TS_003_TC_004_Search_Validation
				case "CS_TS_003_TC_004_Search_Validation":
					context.setAttribute("fileName", "Login");
					LoginCEUserOneSSO();
					CS_TS_003_TC_004_Search_Validation.Search__validation(ApplicantInfo);
					Logout();
					context.setAttribute("fileName", "Logout");
					break;	
				//CS_TS_003_TC_003_Reset_Filter
				case "CS_TS_003_TC_003_Reset_Filter":
					context.setAttribute("fileName", "Login");
					LoginCEUserOneSSO();
					CS_TS_003_TC_003_Reset_Filter.Resetfilter__validation(ApplicantInfo);
					Logout();
					context.setAttribute("fileName", "Logout");
					break;
			//CS_TS_003_TC_006_More_Column_Options CS_TS_003_TC_006_More_Column_Options;		
				  
				case "CS_TS_003_TC_006_More_Column_Options ":
					context.setAttribute("fileName", "Login");
					LoginCEUserOneSSO();
					CS_TS_003_TC_006_More_Column_Options .Column_Options__validation(ApplicantInfo);
					Logout();
					context.setAttribute("fileName", "Logout");
					break;
				case "TC_CE_20_21_Sales_Opportunity_CreateNewOpportunity_OpportunityQuote":
					context.setAttribute("fileName", "Login");
					LoginCEUserOneSSO();				
					TC_CE_20_21_Sales_Opportunity_CreateNewOpportunity_OpportunityQuote.salesNewOpportunity();
					Logout();
					context.setAttribute("fileName", "Logout");
						break;
							
				
								
				case "TC_CE_24_SearchValidations":
					context.setAttribute("fileName", "Login");
					LoginCEUserOneSSO();
					TC_CE_24_SearchValidations.salesOpportunityChangeLeadStatus();
					Logout();
					context.setAttribute("fileName", "Logout");
						break;			
				
				case "OP_TS_001_TC_002_003_004_005_Newly_Created_Opportunity":
					context.setAttribute("fileName", "Login");
					LoginCEUserOneSSO();
					OP_TS_001_TC_002_003_004_005_Newly_Created_Opportunity.EG_TC_002_Newly_Created_opportunity(DependentsInfo);
					Logout();
					context.setAttribute("fileName", "Logout");
					break;
					
				case "TC_CE_066_067_068_069_Admin_CreateNewUser_Edit_Reset_Delete":
					context.setAttribute("fileName", "Login");
					//LoginCEUserOne();
					LoginCEUserOneSSO();
					TC_CE_066_067_068_069_Admin_CreateNewUser_Edit_Reset_Delete.EG_TC_CE66(ApplicantInfo);
					Logout();
					context.setAttribute("fileName", "Logout");
					break;	
				
	
				case "TC_CE_070_Admin_AddRolesAndPermission":
					context.setAttribute("fileName", "Login");
					//LoginCEUserOne();
					LoginCEUserOneHeadless();
					TC_CE_070_Admin_AddRolesAndPermission.EG_TC_CE70(ApplicantInfo);
					Logout();
					context.setAttribute("fileName", "Logout");
					break;
					
					
				case "TC_CE_071_072_Admin_AddNewCallDeposition_EditDisposition":
					context.setAttribute("fileName", "Login");
					//LoginCEUserOne();
					LoginCEUserOneSSO();
					TC_CE_071_072_Admin_AddNewCallDeposition_EditDisposition.EG_TC_CE71(ApplicantInfo);
					Logout();
					context.setAttribute("fileName", "Logout");
					break;
				
					
				case "TC_CE_073_Admin_AddBusinessHours":
					context.setAttribute("fileName", "Login");
					//LoginCEUserOne();
					LoginCEUserOneSSO();
					TC_CE_073_Admin_AddBusinessHours.EG_TC_CE73(ApplicantInfo);
					Logout();
					context.setAttribute("fileName", "Logout");
					break;
					
					
				case "TC_CE_074_Admin_AddHolidayCalender":
					context.setAttribute("fileName", "Login");
					//LoginCEUserOne();
					LoginCEUserOneSSO();
					TC_CE_074_Admin_AddHolidayCalender.EG_TC_CE74(ApplicantInfo);
					Logout();
					context.setAttribute("fileName", "Logout");
					break;
				case "TC_CE_002_Landingpage_Validation":
					context.setAttribute("fileName", "Login");
					LoginCEUserOneSSO();
					TC_CE_002_Landingpage_Validation.EG_TC_CE2(ApplicantInfo);
					Logout();
					context.setAttribute("fileName", "Logout");
					break;

		
				case "TC_CE_003_HomePage_IconAccess":

					context.setAttribute("fileName", "Login");
					LoginCEUsersixSSO();
					TC_CE_003_HomePage_IconAccess.EG_TC_CE3(ApplicantInfo);
					Logout();
					context.setAttribute("fileName", "Logout");
					break;
					
				case "LP_001_002_003_Home_Landingpage_Grid_Validation":
					context.setAttribute("fileName", "Login");
					LoginCEUserOneSSO();
					LP_001_002_003_Home_Landingpage_Grid_Validation.Landing_Page_Home_Validations();
					Logout();
					context.setAttribute("fileName", "Logout");
					break;
					
				case "LP_004_005_NewLandingPage_Validations":
					context.setAttribute("fileName", "Login");
					LoginCEUserOneSSO();
					LP_004_005_NewLandingPage_Validations.NewLandingpage_Validations();
					Logout();
					context.setAttribute("fileName", "Logout");
					break;
					
					
					
				case "LP_09_10_11_sample_edit_existing_Templates":
					context.setAttribute("fileName", "Login");
					LoginCEUserOneSSO();
					LP_09_10_11_sample_edit_existing_Templates.NewLandingpage_Templates_Validations();
					Logout();
					context.setAttribute("fileName", "Logout");
					break;
					
					
				case "LP_13_14_Thumbnail_Select_Preview_Validation":
					context.setAttribute("fileName", "Login");
					LoginCEUserOneSSO();
					LP_13_14_Thumbnail_Select_Preview_Validation.NewLandingpage_Thumbnail_Validations();
					Logout();
					context.setAttribute("fileName", "Logout");
					break;
					
					
					
				case "LP_20_21_23_Action_Tab_Validation":
					context.setAttribute("fileName", "Login");
					LoginCEUserOneSSO();
					LP_20_21_23_Action_Tab_Validation.Action_Validations();
					Logout();
					context.setAttribute("fileName", "Logout");
					break;
					
					
				case "LP_24_26_SummaryPage_Validation":
					context.setAttribute("fileName", "Login");
					LoginCEUserOneSSO();
					LP_24_26_SummaryPage_Validation.SummaryPage_Validations();
					Logout();
					context.setAttribute("fileName", "Logout");
					break;
					
					
				case "LP_28_29_Landing_grid_Leads_Validation":
					context.setAttribute("fileName", "Login");
					//LoginCEUserOne();
					LoginCEUserOneSSO();
					LP_28_29_Landing_grid_Leads_Validation.Landing_Grid_Validations();
					Logout();
					context.setAttribute("fileName", "Logout");
					break;
				default:
					break;
					
				}

				// EndTest
				System.out.println(("*** Test Suite " + testdata.get("TestScenario").toString() + " ending ***"));
				ExtentTestManager.endTest();
				ExtentManager.getInstance().flush();
				Log.info("*** Test Suite " + testdata.get("TestScenario").toString() + " ending ***");

			}

		} catch (Exception e) {

			System.out.println("<----------------Failed--- Test execution " + testdata.get("TestScenario").toString()
					+ " ---Failed ---------------->");
			Log.error("" + e.getMessage());
			String fileName = (String) context.getAttribute("fileName");

			try {
				File file = new com.Utility.ScreenShot(driver).takeScreenShot(fileName,
						testdata.get("TestScenario").toString());
				ExtentTestManager.getTest().fail(e.getMessage(),
						MediaEntityBuilder.createScreenCaptureFromPath(file.toString()).build());
			} catch (Exception NoSuchWindowException) {
				System.out.println("Catch File not found error");
			}
			ExtentTestManager.getTest().log(Status.FAIL, "Test Failed");

			// EndTest
			System.out.println(("*** Test Suite " + testdata.get("TestScenario").toString() + " ending ***"));
			ExtentTestManager.endTest();
			ExtentManager.getInstance().flush();
			Log.info("*** Test Suite " + testdata.get("TestScenario").toString() + " ending ***");
		} catch (AssertionError e) {
			System.out.println("*** Test execution " + testdata.get("TestScenario").toString() + " failed...");
			Log.error("*** Test execution " + testdata.get("TestScenario").toString() + " failed...");
			Log.error("" + e.getMessage());
			String fileName = (String) context.getAttribute("fileName");

			try {
				File file = new com.Utility.ScreenShot(driver).takeScreenShot(fileName,
						testdata.get("TestScenario").toString());
				ExtentTestManager.getTest().fail(e.getMessage(),
						MediaEntityBuilder.createScreenCaptureFromPath(file.toString()).build());
			} catch (Exception NoSuchWindowException) {
				System.out.println("File not found error");
			}
			ExtentTestManager.getTest().log(Status.FAIL, "Test Failed");

			// EndTest
			ExtentTestManager.endTest();
			ExtentManager.getInstance().flush();
			Log.info("************************ Test Suite " + testdata.get("TestScenario").toString()
					+ " ending ****************************");

		} finally {
			if (driver != null)
				driver.quit();
		}
	}

	@DataProvider(name = "TestData")
	public static Object[][] gettestdate() throws IOException {

		Object[][] objectarry = null;
		java.util.List<Map<String, String>> completedata = com.Utility.ExcelReader.getdata();

		objectarry = new Object[completedata.size()][1];

		for (int i = 0; i < completedata.size(); i++) {
			objectarry[i][0] = completedata.get(i);
		}
		return objectarry;
	}
	@AfterSuite
	public void sharingReport() throws IOException {

		//extent.flush();
		// driver.quit();
	    if(	configloader().getProperty("triggermail").equalsIgnoreCase("Yes")){
			try {
				TriggerEmail.sendReport();
			} catch (Exception e) {
				// TODO Auto-generated catch blockdfghj
				e.printStackTrace();
			}

		}

	}
	public String writenameToExcel(String nameText, String sheetname) throws IOException {
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
	public static String generateUsername() {
        int length = 6; // Set the desired length of the username
        String characters = "abcdefghijklmnopqrstuvwxyz";
        Random random = new Random();
        StringBuilder username = new StringBuilder();
        for (int i = 0; i < length; i++) {
            char randomChar = characters.charAt(random.nextInt(characters.length()));
            username.append(randomChar);
        }
        return username.toString();
    }
	

} 

