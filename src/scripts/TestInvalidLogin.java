package scripts;
import org.testng.annotations.Test;

import generic.BaseTest;
import generic.Lib;
import pompages.LoginPage;
public class TestInvalidLogin extends BaseTest{
	@Test
	public void testInvalidLogin(){
		LoginPage login = new LoginPage(driver);
		int rowCount = Lib.getRowCount("logindata", "InvalidLoginData");
		for (int i = 1; i <= rowCount; i++) {
			//enter the username
			String username = Lib.getCellValue("logindata", "InvalidLoginData", i, 0);
			String password = Lib.getCellValue("logindata", "InvalidLoginData", i, 1);
			login.setUsername(username);
			//enterthe password
			login.setPassword(password);
			//click on login button
			login.clickLogin();
		}
	}
}
