package Base;

import Utilities.BrowserFactory;
import org.openqa.selenium.WebDriver;

public class BaseTest {
    BrowserFactory BrowserFactory = new BrowserFactory();

    public final String url = "https://ndosisimplifiedautomation.vercel.app/"; // URL of the application under test
    public final String browser = "chrome"; // Browser choice (e.g., "chrome", "firefox", "edge", "safari", "internetexplore")

    public final WebDriver driver = BrowserFactory.startBrowser(browser, url); // Initialize the WebDriver using the BrowserFactory

}
