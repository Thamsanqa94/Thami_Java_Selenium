package Basic;

import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class LoginToAutomationPage extends BaseTest {


    @Test
    public void LoginWithValidInformation() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        // Login button
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[@id='app-root']/nav/div[1]/div[3]/button/span[2]")
        )).click();

        // Enter email
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login-email")))
                .sendKeys("Xoxoshololo@gmail.com");

        // Enter password
        driver.findElement(By.id("login-password"))
                .sendKeys("Agric123@");

        // Submit login
        driver.findElement(By.id("login-submit")).click();

        // Assume you've successfully logged in and reached the post-login state

        // Wait for and click 'Learning Materials' dropdown button
        WebElement dropdownButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("/html/body/div/div/nav/div[1]/div[2]/div[1]/button")));
        dropdownButton.click();

        // Wait for dropdown animation to complete
        Thread.sleep(1500);

        // Find Learning Materials button in the dropdown
        // The dropdown contains buttons with "Learning Materials" text
        WebElement learningMaterialsOption = null;

        try {
            List<WebElement> allWithText = driver.findElements(
                By.xpath("/html/body/div/div/nav/div[1]/div[2]/div[1]/div//*[contains(text(), 'Learning') or contains(., 'Learning')]"));
            if (!allWithText.isEmpty()) {
                learningMaterialsOption = allWithText.get(0);
            }
        } catch (Exception e1) {
            // Fallback: try first clickable item in dropdown
            try {
                List<WebElement> clickableItems = driver.findElements(
                    By.xpath("/html/body/div/div/nav/div[1]/div[2]/div[1]/div//a | /html/body/div/div/nav/div[1]/div[2]/div[1]/div//button"));
                if (!clickableItems.isEmpty()) {
                    learningMaterialsOption = clickableItems.get(0);
                }
            } catch (Exception e2) {
                // If all else fails, continue without selection
            }
        }

        // Click the found element
        if (learningMaterialsOption != null) {
            wait.until(ExpectedConditions.elementToBeClickable(learningMaterialsOption));
            learningMaterialsOption.click();
        }

        driver.findElement(By.xpath("/html/body/div/div/main/section/div[2]/button[2]/span[2]")).click();
        // Wait for the Learning Materials page to load
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("deviceType")));

        // Select "Phone" from deviceType dropdown (this is an actual select element)
        WebElement deviceTypeSelect = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("deviceType")));
        Select deviceTypeDropdown = new Select(deviceTypeSelect);
        deviceTypeDropdown.selectByVisibleText("Phone");

        // Select "Apple" from brand dropdown (this is an actual select element)
        WebElement brandSelect = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("brand")));
        Select brandDropdown = new Select(brandSelect);
        brandDropdown.selectByVisibleText("Apple");

        // Click storage option 128GB
        driver.findElement(By.id("storage-128GB")).click();

        // Select "Blue" from color dropdown (this is an actual select element)
        WebElement colorSelect = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("color")));
        Select colorDropdown = new Select(colorSelect);
        colorDropdown.selectByVisibleText("Blue");

        // Check the checkbox
        driver.findElement(By.xpath("/html/body/div/div/main/section/div[3]/div/form/div/div[6]/div/input")).sendKeys("2");

        // Enter address
        driver.findElement(By.id("address")).sendKeys("Oak Avenue Ferndale");

        // Click next button
        driver.findElement(By.id("inventory-next-btn")).click();
    }

}
