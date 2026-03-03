package Test;

import Base.BaseTest;
import Pages.LoginPage;
import org.testng.annotations.Test;


public class LoginTest extends BaseTest {

    @Test
    public void LoginWithValidInformation() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickLoginButton();
        loginPage.enterEmail("Xoxoshololo@gmail.com");
        loginPage.enterPassword("Agric123@");
        loginPage.clickSubmitButton();
    }
}