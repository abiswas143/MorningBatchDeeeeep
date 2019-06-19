package generic;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
public class BaseTest implements IAutoConstant{
	public WebDriver driver;
	static{
		System.setProperty(CHROME_KEY, CHROME_VALUE);
		System.setProperty(GECKO_KEY, GECKO_VALUE);
		System.setProperty(IE_KEY, IE_VALUE);
	}
	@BeforeMethod
	public void launchApplication(){
		//launch firefox Browser
		driver = new FirefoxDriver();
		//Enter the url
		driver.get(Lib.getPropertyValue("URL"));
		String timeout = Lib.getPropertyValue("IMPLICIT_TIME");
driver.manage().timeouts().implicitlyWait(Long.parseLong(timeout), TimeUnit.SECONDS);
	}
	@AfterMethod
	public void closeApplication(ITestResult res){
		//call method to take screenshot
		if (ITestResult.FAILURE == res.getStatus()) {
			Lib.captureScreenshot(driver, res.getName());
		}
		driver.close();
	}
}
