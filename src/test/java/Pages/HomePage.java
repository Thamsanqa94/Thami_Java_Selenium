package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    WebDriver driver;

    static final String ACCOUNT_MENU_BUTTON_XPATH = "/html/body/div/div/nav/div[1]/div[3]/div/button";
    static final String HOME_NAV_LINK_XPATH = "//*[@id='app-root']/nav/div[1]/div[1]/a";

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // The dropdown/account menu button shown in the nav bar after a successful login
    @FindBy(xpath = ACCOUNT_MENU_BUTTON_XPATH)
    WebElement accountMenuButton;

    // Navigation link to the home page
    @FindBy(xpath = HOME_NAV_LINK_XPATH)
    WebElement homeNavLink;

    public void clickAccountMenu() {
        accountMenuButton.click();
    }

    public void navigateToHome() {
        homeNavLink.click();
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    /** Exposes the account menu button locator so callers can use it with WebDriverWait. */
    public By getAccountMenuButtonLocator() {
        return By.xpath(ACCOUNT_MENU_BUTTON_XPATH);
    }
}

