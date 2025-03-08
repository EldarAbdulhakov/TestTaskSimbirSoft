package org.example.runner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;

import java.time.Duration;

public abstract class BaseTest {

    private final WebDriver driver = new ChromeDriver();
    private WebDriverWait wait10;

    protected WebDriver getDriver() {
        return driver;
    }

    protected WebDriverWait getWait10() {
        if (wait10 == null) {
            wait10 = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        }
        return wait10;
    }

    @AfterMethod
    protected void closeDriver() {
        driver.quit();
        wait10 = null;
    }
}
