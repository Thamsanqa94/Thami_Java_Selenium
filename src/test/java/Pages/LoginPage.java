package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import java.time.Duration;

import java.util.List;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id='app-root']/nav/div[1]/div[3]/button/span[2]")
    WebElement loginButton;

    @FindBy(id = "login-email")
    WebElement emailField;

    @FindBy(id = "login-password")
    WebElement passwordField;

    @FindBy(id = "login-submit")
    WebElement submitButton;

    @FindBy(xpath = "/html/body/div/div/nav/div[1]/div[3]/div/button")
    WebElement profileButton;

    @FindBy(xpath = "/html/body/div/div/nav/div[1]/div[2]/div[1]/div/a[3]")
    WebElement logoutButton;

    @FindBy(xpath = "/html/body/div/div/nav/div[1]/div[2]/div[1]/button")
    WebElement dropdownButton;

    @FindBy(xpath = "/html/body/div/div/nav/div[1]/div[2]/div[1]/div//*[contains(text(), 'Learning') or contains(., 'Learning')]")
    WebElement learningMaterialsOption;

    @FindBy(xpath = "/html/body/div/div/main/section/div[2]/button[2]/span[2]")
    WebElement learningMaterialsNextButton;

    @FindBy(id = "deviceType")
    WebElement deviceTypeSelect;

    @FindBy(id = "brand")
    WebElement brandSelect;

    @FindBy(id = "storage-128GB")
    WebElement storage128GB;

    @FindBy(id = "color")
    WebElement colorSelect;

    @FindBy(xpath = "/html/body/div/div/main/section/div[3]/div/form/div/div[6]/div/input")
    WebElement quantityInput;

    @FindBy(id = "address")
    WebElement addressField;

    @FindBy(id = "inventory-next-btn")
    WebElement inventoryNextButton;

    @FindBy(id = "shipping-express")
    WebElement shippingExpress;

    @FindBy(id = "warranty-1yr")
    WebElement warranty1yr;

    @FindBy(id = "discount-code")
    WebElement discountCodeField;

    @FindBy(id = "apply-discount-btn")
    WebElement applyDiscountButton;

    @FindBy(id = "purchase-device-btn")
    WebElement purchaseDeviceButton;

    @FindBy(id = "view-history-btn")
    WebElement viewHistoryButton;

    @FindBy(css = "button[id^='view-invoice-INV-']")
    List<WebElement> invoiceButtons;


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

    public void openDropdown() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(dropdownButton)).click();
    }

    public void clickLearningMaterials() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(learningMaterialsOption)).click();
    }

    public void clickNextOnLearningMaterials() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(learningMaterialsNextButton)).click();
    }

    public void selectDeviceType(String type) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(deviceTypeSelect));
        new Select(deviceTypeSelect).selectByVisibleText(type);
    }

    public void selectBrand(String brand) {
        new Select(brandSelect).selectByVisibleText(brand);
    }

    public void chooseStorage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(storage128GB)).click();
    }

    public void selectColor(String color) {
        new Select(colorSelect).selectByVisibleText(color);
    }

    public void enterQuantity(String qty) {
        quantityInput.sendKeys(qty);
    }

    public void enterAddress(String address) {
        addressField.sendKeys(address);
    }

    public void clickNextInventory() {
        inventoryNextButton.click();
    }

    public void chooseShippingExpress() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(shippingExpress)).click();
    }

    public void chooseWarranty() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(warranty1yr)).click();
    }

    public void applyDiscount(String code) {
        discountCodeField.sendKeys(code);
        applyDiscountButton.click();
    }

    public void purchaseDevice() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(purchaseDeviceButton)).click();
    }

    public void viewHistory() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("view-history-btn")));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", viewHistoryButton);
    }

    public void clickFirstInvoice() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        if (!invoiceButtons.isEmpty()) {
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("button[id^='view-invoice-INV-']")));
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();", invoiceButtons.get(0));
        }
    }
}






