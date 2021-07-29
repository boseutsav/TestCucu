package extentReportingDemo;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.aventstack.extentreports.utils.FileUtil;
import com.google.common.io.Files;
import com.google.common.util.concurrent.Service.State;



public class NopCommerceTest {
	public WebDriver driver;
	
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest test;
	
	@BeforeTest
	public void setExtent() {
		String dateToday = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"\\test-output\\myReport_"+dateToday+".html");
		htmlReporter.config().setDocumentTitle("AutomationReport");
		htmlReporter.config().setReportName("Functional Report");
		htmlReporter.config().setTheme(Theme.DARK);
		
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Hostname", "LocalHost");
		extent.setSystemInfo("OS", "Windows 7");
		extent.setSystemInfo("Tester Name", "Utsav Bose");
		extent.setSystemInfo("Browser", "Chrome");	
	}
	
	@AfterTest
	public void endReport() {
		extent.flush();
	}
	
	
	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.home")+"\\eclipse-workspace\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://www.nopcommerce.com/en/demo");
		
	}
	
	@Test
	public void nopCommerceTitleTest() {
		test = extent.createTest("nopCommerceTitleTest");
		String title = driver.getTitle();
		System.out.println("Title: "+title);
		String nameofCurrMethod = Thread.currentThread().getStackTrace()[1].getMethodName();
		System.out.println("Name of current method: " + nameofCurrMethod);
		Assert.assertEquals(title, "Store Demo - nopCommerce");
	}
	
	@Test
	public void nopCommerceLogoTest() {
		test = extent.createTest("nopCommerceLogoTest");
		String nameofCurrMethod = Thread.currentThread().getStackTrace()[1].getMethodName();
		System.out.println("Name of current method: " + nameofCurrMethod);
		Assert.assertTrue(driver.findElement(By.xpath(".//img[@alt='nopCommerce']")).isDisplayed());
	}
	
	@Test
	public void nopCommerceLoginTest() {
		test = extent.createTest("nopCommerceLoginTest");
		String nameofCurrMethod = Thread.currentThread().getStackTrace()[1].getMethodName();
		System.out.println("Name of current method: " + nameofCurrMethod);
		Assert.assertTrue(false);
		
	}
	
	@AfterMethod
	public void teardown(ITestResult result) throws IOException {
		
		if (result.getStatus()==ITestResult.FAILURE) {
			test.log(Status.FAIL, "Testcase failed is : "+result.getName());
			test.log(Status.FAIL, "Testcase failure is : "+result.getThrowable());
			
			String screenshotpath = NopCommerceTest.getScreenshot(driver,result.getName());
			test.addScreenCaptureFromPath(screenshotpath);
			
		}
		else if (result.getStatus()==ITestResult.SKIP) {
			test.log(Status.SKIP, "Testcase skipped is : "+result.getName());
		}
		else if (result.getStatus()==ITestResult.SUCCESS) {
			test.log(Status.PASS, "Testcase passed is : "+result.getName());
		}
		driver.quit();
	}

	private static String getScreenshot(WebDriver driver2, String name) throws IOException {
		String dateToday = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		String screenshotPath = System.getProperty("user.dir")+"\\Screenshots\\"+name+"_"+dateToday+".png";
		File outputFile = ((TakesScreenshot)driver2).getScreenshotAs(OutputType.FILE);
		Files.copy(outputFile, new File(screenshotPath));		
		return screenshotPath;
	}
	
	
	
	
	

}
