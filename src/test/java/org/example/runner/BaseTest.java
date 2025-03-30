package org.example.runner;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public abstract class BaseTest {

    private WebDriver driver;
    private WebDriverWait wait10;

    protected WebDriver getDriver() {
        return driver;
    }

    public WebDriver remouteDriver() throws MalformedURLException {
        URL remoteUrl = new URL("http://localhost:4444/wd/hub");

        // Задаем возможности для удаленного браузера (например, Chrome)
        ChromeOptions options = new ChromeOptions(); // или другой браузер

        // Создаем удаленный WebDriver
        return new RemoteWebDriver(remoteUrl, options);
    }

    @BeforeMethod
    public void setUp() throws MalformedURLException {
        remouteDriver();
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1920, 1080));
        getDriver().get("https://practice-automation.com/form-fields/");
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
