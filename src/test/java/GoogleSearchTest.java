import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GoogleSearchTest {

    WebDriver driver;

    @BeforeClass
    public void setup() {
        // ChromeDriver path is set up
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testGoogleSearch() {
        // Navigate to Google
        driver.get("https://www.google.com");

        // Locate the search box
        WebElement searchBox = driver.findElement(By.name("q"));

        // Enter search query
        searchBox.sendKeys("Selenium WebDriver");
        searchBox.submit();

        // Wait for results to load
        try {
            Thread.sleep(2000); // A more robust solution would be using WebDriverWait
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Assert that results contain the expected text
        Assert.assertTrue(driver.getTitle().contains("Selenium WebDriver"));
    }

    @AfterClass
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
