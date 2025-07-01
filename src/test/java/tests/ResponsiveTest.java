package tests;

import org.openqa.selenium.Dimension;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificationMethod;

public class ResponsiveTest extends ProjectSpecificationMethod {


		@BeforeTest
		public void setup() {
			
			testName = "Responsive Test";
			testDescription = "Testing the Responsive functionality of the application";
			testAuthor ="Abdul Nazeer";
			testCategory = "Smoke Testing";
		}
		@Test(priority = 1)
		public void testNoHorizontalScrollOnMobile() throws InterruptedException {
			driver.manage().window().setSize(new Dimension(375, 667)); // iPhone X size
			Thread.sleep(1000);

			Long scrollWidth = (Long) ((org.openqa.selenium.JavascriptExecutor) driver)
					.executeScript("return document.documentElement.scrollWidth");
			Long clientWidth = (Long) ((org.openqa.selenium.JavascriptExecutor) driver)
					.executeScript("return document.documentElement.clientWidth");

			Assert.assertTrue(scrollWidth <= clientWidth + 10, "Horizontal scroll detected on mobile view.");
		}

		@Test(priority = 2)
		public void testNoHorizontalScrollOnTablet() throws InterruptedException {
			driver.manage().window().setSize(new Dimension(768, 1024)); // iPad size
			Thread.sleep(1000);

			Long scrollWidth = (Long) ((org.openqa.selenium.JavascriptExecutor) driver)
					.executeScript("return document.documentElement.scrollWidth");
			Long clientWidth = (Long) ((org.openqa.selenium.JavascriptExecutor) driver)
					.executeScript("return document.documentElement.clientWidth");

			Assert.assertTrue(scrollWidth <= clientWidth + 10, "Horizontal scroll detected on tablet view.");
		}

	}

