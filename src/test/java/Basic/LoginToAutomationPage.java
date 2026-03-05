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

public class LoginToAutomationPage extends BaseTest {


    @Test
    public void LoginWithValidInformation() {


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));


        // Login button
       wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[@id='app-root']/nav/div[1]/div[3]/button/span[2]")
        )).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login-email")))
                .sendKeys("Xoxoshololo@gmail.com");

        driver.findElement(By.id("login-password"))
                .sendKeys("Agric123@");


        driver.findElement(By.id("login-submit")).click();
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("/html/body/div/div/nav/div[1]/div[3]/div/button")
        )).click();

    }
}