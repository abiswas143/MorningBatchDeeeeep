package scripts;
import org.testng.Assert;
import org.testng.annotations.Test;
import generic.BaseTest;
import generic.Lib;
import pompages.LoginPage;
public class TestValidLogin extends BaseTest{
	@Test
	public void testValidLogin(){
		LoginPage login = new LoginPage(driver);
		//enter the username
		String username = Lib.getCellValue("logindata", "ValidLoginData", 1, 0);
		String password = Lib.getCellValue("logindata", "ValidLoginData", 1, 1);
		login.setUsername(username);
		//enterthe password
		login.setPassword(password);
		//click on login button
		login.clickLogin();
		//validate that you have been succesfully navigated to Home page
		Assert.assertEquals(driver.getTitle(), "actiTIME - Enter Time-Track");
		/*if (driver.getTitle().equals("I donot know..")) {
			System.out.println("login successfull..");
		} else {
			System.out.println("login failed..");
		}*/
	}
}
