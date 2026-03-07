package Test;

import Base.BaseTest;
import Pages.HomePage;
import Pages.LoginPage;
import Utilities.JsonDataReader;
import com.fasterxml.jackson.databind.JsonNode;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

public class NavigationTest extends BaseTest {

    @DataProvider(name = "loginData")
    public Object[][] loginData() {
        return JsonDataReader.getJsonData("testdata/login_data.json");
    }

    /**
     * Logs in with valid credentials and then navigates the post-login home page.
     * This test demonstrates that navigation after login should live in its own
     * Page Object (HomePage) rather than being mixed into the LoginPage.
     */
    @Test(dataProvider = "loginData")
    public void loginAndNavigateToHomePage(JsonNode data) {
        LoginPage loginPage = new LoginPage(driver);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        // Wait for the login button to be clickable before starting the login flow
        wait.until(ExpectedConditions.elementToBeClickable(loginPage.getLoginButtonLocator()));

        // Perform login and receive the HomePage Page Object for further actions
        HomePage homePage = loginPage.login(
                data.get("email").asText(),
                data.get("password").asText()
        );

        // Assert that login was successful by verifying the account menu is now present
        wait.until(ExpectedConditions.elementToBeClickable(homePage.getAccountMenuButtonLocator()));
        Assert.assertTrue(
                homePage.getCurrentUrl().contains("ndosisimplifiedautomation"),
                "Expected to remain on the application after login"
        );

        // Navigate using the post-login home page – a separate Page Object handles this
        homePage.clickAccountMenu();
    }
}
