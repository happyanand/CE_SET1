package com.test;

import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFSheet;

import com.pages.CensusInfo;
import com.pages.CustomerEngageFunctionalityValidations;
import com.pages.SalesLeadPage;

import Utility.ExcelHelper;

public class TC_CE_044_Customer_CustomerContactCard  extends AllScenarios_EG_TC{
	CensusInfo ApplicantInfo = new CensusInfo();
	CensusInfo SpouseInfo = new CensusInfo();
	CensusInfo DomesticPartner = new CensusInfo();
	
	ArrayList<CensusInfo> DependentsInfo = new ArrayList<CensusInfo>();
	 CensusInfo DependentInfo = new CensusInfo();
	 
	public  void customerContactCard()
			throws ClassNotFoundException, Exception {
		CustomerEngageFunctionalityValidations consumerpage = new CustomerEngageFunctionalityValidations(driver);
	SalesLeadPage SalesLeadPage = new SalesLeadPage(driver);
		ExcelHelper _excelObj = new ExcelHelper();
		XSSFSheet tcTestData = _excelObj.readExcelSheet("TestData", "TC CE2");
		int rowCount = tcTestData.getLastRowNum() - tcTestData.getFirstRowNum();

		if (tcTestData != null) {

			ApplicantInfo.Zipcode = tcTestData.getRow(1).getCell(1).getStringCellValue().toString();
	    	ApplicantInfo.Email=tcTestData.getRow(1).getCell(10).getStringCellValue().toString();
	        ApplicantInfo.DOB = tcTestData.getRow(1).getCell(3).getStringCellValue().toString();     
	        ApplicantInfo.CustomerName = tcTestData.getRow(1).getCell(5).getStringCellValue().toString();     

		} 

		System.out.println("******* TC_CE_044_Customer_CustomerContactCard ***************");		  
		consumerpage.login_CE_validations();
		SalesLeadPage.cttMinimize(); 
		SalesLeadPage.newTab();
		SalesLeadPage.customerContactCard(ApplicantInfo);
		consumerpage.logout_CE_validations(); 

} 
 
}
