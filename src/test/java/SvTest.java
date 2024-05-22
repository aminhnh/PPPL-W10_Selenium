import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class SvTest {
    private WebDriver driver;
    private final String URL = "https://sv.ugm.ac.id/";
    private final String EXPECTED_TITLE = "Sekolah Vokasi UGM – Sekolah Vokasi UGM";
    private final String EXPECTED_XPATH = "/html/body/div[1]/div/div/div/article/div/div[1]/div/div/div/section/div[2]";
    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
    @Test
    public void automationTestChrome() {
        this.driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(URL);

        String title = driver.getTitle();
        String currentURL = driver.getCurrentUrl();
        WebElement expectedElement = driver.findElement(By.xpath(EXPECTED_XPATH));

        assertAll(
                () -> assertEquals(EXPECTED_TITLE, title),
                () -> assertEquals(URL, currentURL),
                () -> assertTrue(expectedElement.isDisplayed())
        );
        driver.quit();
    }
    @Test
    public void automationTestFirefox() {
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get(URL);

        String title = driver.getTitle();
        String currentURL = driver.getCurrentUrl();
        WebElement expectedElement = driver.findElement(By.xpath(EXPECTED_XPATH));

        assertAll(
            () -> assertEquals(EXPECTED_TITLE, title),
            () -> assertEquals(URL, currentURL),
            () -> assertTrue(expectedElement.isDisplayed())
        );
        driver.quit();
    }
}
