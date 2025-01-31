package GenericUtility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;
import ObjectRepository.WelcomePage;

public class BaseClass {
	public static ExtentReports extReports;
	public static ExtentTest test;
	public static WebDriver driver;
	
	public WelcomePage wp;
	public LoginPage lp;
	public HomePage hp;
	
	public JavaUtility jUtil= new JavaUtility();
	public WebDriverUtility wUtil= new WebDriverUtility();
	public FileUtility fUtil= new FileUtility();
	
	
	@BeforeSuite
	public void configReport() {
		ExtentSparkReporter spark= new ExtentSparkReporter("./HTML_reports/ExtentReports_"+jUtil.getSystemDateTime()+".html");
		extReports= new ExtentReports();
		extReports.attachReporter(spark);
	}
	
	@Parameters("Browser")
	@BeforeClass
		public void openBrowser(@Optional("Chrome") String browserName) throws IOException {
		if(browserName.equalsIgnoreCase("Chrome"))
			driver= new ChromeDriver();
		else if(browserName.equalsIgnoreCase("firefox"))
			driver= new FirefoxDriver();
		else if(browserName.equalsIgnoreCase("edge"))
			driver= new EdgeDriver();
		
		driver.manage().window().maximize();
		wUtil.implicitWait(driver);
		driver.get(fUtil.getDataFromProperty("url"));
	}
	@BeforeMethod
	public void login() throws IOException {
		wp= new WelcomePage(driver);
		wp.getLoginLink().click();
		
		lp= new LoginPage(driver);
		lp.getEmailTextField().sendKeys(fUtil.getDataFromProperty("email"));
		lp.getPasswordTextField().sendKeys(fUtil.getDataFromProperty("password"));
		lp.getLoginButton().click();
	}
	@AfterMethod
	public void logout() {
		hp= new HomePage(driver);
		hp.getLogoutLink();
	}

	@AfterClass
	public void closeBbrowser() {
		driver.quit();
	}
	@AfterSuite
	public void reportBackup() {
		extReports.flush();
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}
}
