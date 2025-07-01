package base;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import utils.Utility;

public class ProjectSpecificationMethod extends Utility{	



	@BeforeSuite
	public void createReport() {

		// To create report in the given location
		ExtentSparkReporter reporter = new ExtentSparkReporter("C:\\Users\\Vaseera\\eclipse-workspace\\MiniProject-1\\src\\test\\resources\\testoutputreport\\ContactList_Test_Report.html");
		reporter.config().setReportName("ContactList Test Report");

		// To attach the data to the reporter 
		extent = new ExtentReports();
		extent.attachReporter(reporter);
	}

	@BeforeClass
	public void testDeatils() {

		test = extent.createTest(testName, testDescription);
		test.assignAuthor(testAuthor);
		test.assignCategory(testCategory);
	}

	@Parameters({"browser","url"})
	@BeforeMethod
	public void browserLaunchAndUrlLoad(String browser, String url) throws InterruptedException {
		
		LaunchBrowserandLoadUrl(browser,url);
	}
	
//	 @AfterMethod
//	 public void CloseBrowser() {
//	 		
//	 		CloseBrowser();
//	 	}


	@DataProvider(name ="readData")
	public String[][] dataRead() throws IOException {

		return readExcel(sheetname);
	}


	@AfterSuite
	public void closeReport() {

		extent.flush();

	}	

}
