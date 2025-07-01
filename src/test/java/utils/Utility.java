package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;


import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class Utility {

	public static WebDriver driver;
	public String sheetname;
	public static Properties prop = new Properties();
	public static FileOutputStream output;

	public static ExtentReports extent;
	public String testName, testDescription, testAuthor, testCategory;
	public static ExtentTest test;

	public void LaunchBrowserandLoadUrl (String browser, String url) throws InterruptedException{
		if(browser.equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("Edge")){
			driver = new EdgeDriver();

		}else {
			driver = new ChromeDriver();
		}

		Thread.sleep(3000);
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));

	}

	public void CloseBrowser() {
		driver.close();
	}

	public static void readAndWritePropFile() throws IOException {

		String filePath="C:\\Users\\Vaseera\\eclipse-workspace\\MiniProject-1\\src\\test\\resources\\data\\testdata.properties";
		FileInputStream file = new FileInputStream(filePath);
		prop.load(file);
		file.close();	
	}

	public static String[][] readExcel(String sheetName) throws IOException {
		FileInputStream fis = new FileInputStream("C:\\Users\\Vaseera\\eclipse-workspace\\MiniProject-1\\src\\test\\resources\\data\\test_datas.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet(sheetName);

		int rowCount = sheet.getLastRowNum();
		int columnCount = sheet.getRow(0).getLastCellNum();

		List<String[]> dataList = new ArrayList<>();

		for (int i = 1; i <= rowCount; i++) {
			XSSFRow row = sheet.getRow(i);
			if (row == null) continue;

			String[] rowData = new String[columnCount];
			for (int j = 0; j < columnCount; j++) {
				XSSFCell cell = row.getCell(j);
				rowData[j] = (cell == null) ? "" : cell.toString().trim();
			}
			dataList.add(rowData);
		}

		workbook.close();
		fis.close();

		return dataList.toArray(new String[0][columnCount]);
	}

	public static  String screenShot(String name) throws IOException {

		String timestamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
		String path="C:\\Users\\Vaseera\\eclipse-workspace\\MiniProject-1\\src\\test\\resources\\testoutputreport\\snaps\\"+name+timestamp+".png";
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest = new File(path);
		FileUtils.copyFile(src, dest);
		return path;
	}

}
