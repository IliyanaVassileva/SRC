package Lecture16;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.bouncycastle.cms.PasswordRecipientId;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.io.File;
import java.io.IOException;

public class TestClass {

    private static final String DOWNLOAD_DIR = "src\\main\\resources\\download";
    private static final String SCREENSHOTS_DIR = "src\\main\\resources\\screenshots";
    private WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    @BeforeSuite
    protected final void setupTestSuite() {
        WebDriverManager.chromedriver().setup();
        WebDriverManager.firefoxdriver().setup();
        WebDriverManager.edgedriver().setup();
    }

    @BeforeMethod
    protected final void setupMethods() {
        //this.driver = new ChromeDriver();
        //this.driver = new EdgeDriver();
        this.driver = new ChromeDriver(configChromeOptions());
        this.driver.manage().window().maximize();
        this.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }



    private ChromeOptions configChromeOptions() {
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("download.default_directory", System.getProperty("user.dir").concat("\\").concat(DOWNLOAD_DIR));
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setExperimentalOption("prefs", prefs);
        return chromeOptions;
    }

    private void TakeScreenshots(ITestResult testResult) {
        if (ITestResult.SUCCESS == testResult.getStatus()) {
            try {
                TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
                File screenshot = takesScreenshot.getScreenshotAs(OutputType.FILE);
                String testName = testResult.getTestName();
                FileUtils.copyFile(screenshot, new File(SCREENSHOTS_DIR.concat(testName).concat(".jpg")));
            }catch (IOException e){
                System.out.println("Unable to create screenshot file: " + e.getMessage());
            }

        }

    }



    @AfterMethod
    protected final void setupAftermethods() {
//        TakesScreenshot();
        driver.close();

    }

//    public void waitAndClick(By identifer) {
//        // Waiting 30 seconds for an element to be present on the page, checking
//        // for its presence once every 1 second.
//        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
//                .withTimeout(Duration.ofSeconds(30))
//                .pollingEvery(Duration.ofSeconds(1))
//                .ignoring(NoSuchElementException.class);
//
//        WebElement elem = wait.until(ExpectedConditions.presenceOfElementLocated(identifer));
//        elem.click();
//
//        //Click on WebElement
//        public void waitAndClickElement (WebElement eLement) {
//                // Waiting 30 seconds for an element to be present on the page, checking
//                // for its presence once every 1 second.
//                Wait < WebDriver > wait = new FluentWait<WebDriver>(driver)
//                        .withTimeout(Duration.ofSeconds(30))
//                        .pollingEvery(Duration.ofSeconds(1))
//                        .ignoring(NoSuchElementException.class);
//
//        WebElement elem = wait.until(ExpectedConditions.elementToBeClickable());
//        elem.click();
//    }

//    }

    }


