import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class LoginTest {
    private final String SUCCESS_URL = "https://practicetestautomation.com/logged-in-successfully/";
    @Test
    public void loginTest() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://practicetestautomation.com/practice-test-login/");

        WebElement usernameInput = driver.findElement(By.id("username"));
        WebElement passwordInput = driver.findElement(By.id("password"));
        WebElement submitButton = driver.findElement(By.id("submit"));

        usernameInput.sendKeys("student");
        passwordInput.sendKeys("Password123");
        submitButton.click();

        String currentURL = driver.getCurrentUrl();
        WebElement logoutButton = driver.findElement(By.linkText("Log out"));
        String pageSource = driver.getPageSource();

        assertAll(
            () -> assertEquals(SUCCESS_URL, currentURL),
            () -> assertTrue(pageSource.contains("Congratulations")),
            () -> assertTrue(logoutButton.isDisplayed())
        );
        driver.quit();
    }
}
