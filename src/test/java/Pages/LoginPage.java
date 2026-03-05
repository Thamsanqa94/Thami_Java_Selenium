package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver driver;

    static final String LOGIN_BUTTON_XPATH = "//*[@id='app-root']/nav/div[1]/div[3]/button/span[2]";

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = LOGIN_BUTTON_XPATH)
    WebElement loginButton;

    @FindBy(id = "login-email")
    WebElement emailField;

    @FindBy(id = "login-password")
    WebElement passwordField;

    @FindBy(id = "login-submit")
    WebElement submitButton;

    public void clickLoginButton() {
        loginButton.click();
    }

    public void enterEmail(String email) {
        emailField.sendKeys(email);
    }

    public void enterPassword(String password) {
        passwordField.sendKeys(password);
    }

    public void clickSubmitButton() {
        submitButton.click();
    }

    /**
     * Performs a full login sequence and returns the HomePage Page Object
     * for further interaction after a successful login.
     */
    public HomePage login(String email, String password) {
        clickLoginButton();
        enterEmail(email);
        enterPassword(password);
        clickSubmitButton();
        return new HomePage(driver);
    }

    /** Exposes the login button locator so callers can use it with WebDriverWait. */
    public By getLoginButtonLocator() {
        return By.xpath(LOGIN_BUTTON_XPATH);
    }







}




