package com.test;

import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFSheet;

import com.BasePackage.Base_Class;
import com.pages.CensusInfo;
import com.pages.CustomerEngageFunctionalityValidations;
import com.pages.Customer_Validations;
import com.pages.SalesLeadPage;

import Utility.ExcelHelper;

public class CS_TS_001_TC_012_Collaboration_Actions_Validation extends Base_Class {
	CensusInfo ApplicantInfo = new CensusInfo();
	CensusInfo SpouseInfo = new CensusInfo();
	CensusInfo DomesticPartner = new CensusInfo();
	
	ArrayList<CensusInfo> DependentsInfo = new ArrayList<CensusInfo>();
	 CensusInfo DependentInfo = new CensusInfo();
	public void Collaboration_Actions__validation(CensusInfo ApplicantInfo)
			throws ClassNotFoundException, Exception {
		CustomerEngageFunctionalityValidations consumerpage = new CustomerEngageFunctionalityValidations(driver);
		
		SalesLeadPage SalesLeadPage = new SalesLeadPage(driver);
		Customer_Validations Customer_Validations = new Customer_Validations(driver);
		ExcelHelper _excelObj = new ExcelHelper();
		XSSFSheet tcTestData = _excelObj.readExcelSheet("TestData", "TC CE1");
		int rowCount = tcTestData.getLastRowNum() - tcTestData.getFirstRowNum();

		if (tcTestData != null) {

			ApplicantInfo.Zipcode = tcTestData.getRow(1).getCell(1).getStringCellValue().toString();
	    	ApplicantInfo.Email=tcTestData.getRow(1).getCell(10).getStringCellValue().toString();
	        ApplicantInfo.DOB = tcTestData.getRow(1).getCell(3).getStringCellValue().toString();     

		}

		System.out.println("******* Customers module CS_TS_001_TC_012_Collaboration_Actions_Validation ***************");		  
		consumerpage.login_CE_validations();
		SalesLeadPage.cttMinimize();
		Customer_Validations.New_Customer_Creation();
		Customer_Validations. Collaboration_Validations(ApplicantInfo);
		
		consumerpage.logout_CE_validations();


}
}

