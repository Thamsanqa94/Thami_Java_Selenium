package Basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginToAutomationPage {

    WebDriver driver;


    @Test
    public void LoginWithValidInformation() {

        driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        driver.get("https://ndosisimplifiedautomation.vercel.app/");
        driver.manage().window().maximize();

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
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("/html/body/div/div/nav/div[1]/div[3]/div/div/button[1]/span[2]")
        )).click();



        // /html/body/div/div/nav/div[1]/div[3]/div/div/button[1]/span[2]
        /* wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("/html/body/div/div/nav/div[1]/div[3]/div/div/button[1]/span[2]")
        )).click();
        // Profile menu
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("/html/body/div/div/nav/div[1]/div[2]/div[1]/button")
        )).click();

        // Settings submenu
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("/html/body/div/div/nav/div[1]/div[2]/div[1]/div/button[2]/span[2]")
        )).click();
          /*
        // PASSWORD TAB  ❗ THIS WAS FAILING
        wait.until(ExpectedConditions.elementToBeClickable(
                By.id("tab-btn-password")
        )).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("name")))
                .sendKeys("Thami");

        driver.findElement(By.id("email"))
                .sendKeys("xoxoshololo@gmail.com");

        driver.findElement(By.id("age"))
                .sendKeys("31");
        //driver.findElement(By.xpath("/html/body/div/div/main/section/div[3]/div/form/div[1]/select[1]")).click();
        WebElement firstDropdown = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("/html/body/div/div/main/section/div[3]/div/form/div[1]/select[1]")));
        Select dropdown1 = new Select(firstDropdown);
        dropdown1.selectByIndex(0);


        driver.findElement(By.xpath("/html/body/div/div/main/section/div[3]/div/form/div[1]/select[2]")).click();

             */


    }
}