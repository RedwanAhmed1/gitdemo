package LearnMaven.MavenJava;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.apache.commons.io.FileUtils;

public class SeleniumTest {

	@Test
	public void Automation() {
		System.out.println("this is aautomation");
	}
	@Test
	public void Automation2() {
		System.out.println("selenium is a great tool");
	}
	@Test
	public void testBStackTakeScreenShot() throws Exception{
		System.setProperty("webdriver.chrome.driver", "/Users/redwanahmed/Downloads/chromedriver 5");
		WebDriver dr = new ChromeDriver();
		dr.get("https://www.express.com/");
		 int x = (int)Math.random( );
		this.takeSnapShot(dr, "co://test"+x+ ".png") ;
		dr.close();
	}
	public static void takeSnapShot(WebDriver dr,String fileWithPath) throws Exception{
		//Convert web driver object to TakeScreenshot
		TakesScreenshot scrShot =((TakesScreenshot)dr);
		//Call getScreenshotAs method to create image file
		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
		//Move image file to new destination
		File DestFile=new File(fileWithPath);
		//Copy file at destination
		FileUtils.copyFile(SrcFile, DestFile);
		}
		}

