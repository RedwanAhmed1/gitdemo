package LearnMaven.MavenJava;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporter {
	ExtentReports extent;

	@BeforeTest
	public void config() {
		String path = new File("reports//test")+"index.html";
		ExtentSparkReporter reporter  = new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Test Result");
		reporter.config().setDocumentTitle("Extent Practice");
		
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Redwan");
		

	}

	@Test
	public void shopping() {
		ExtentTest test = extent.createTest("Shopping");
		System.setProperty("webdriver.chrome.driver", "/Users/redwanahmed/Downloads/chromedriver 5");
		WebDriver dr = new ChromeDriver();

		dr.get("https://www.target.com/");
		System.out.println(dr.getTitle());
		//test.fail("failed");
		dr.close();
		extent.flush();
	}

}
