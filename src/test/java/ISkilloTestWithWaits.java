import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;
public class ISkilloTestWithWaits {
    private WebDriver driver;

    public static void main(String[] args) {

    }

    @BeforeSuite
    protected final void setupTestSuite() {
        WebDriverManager.chromedriver().setup();
        WebDriverManager.firefoxdriver().setup();
        WebDriverManager.edgedriver().setup();
    }

    @BeforeMethod
    protected final void setupMethods() {
        this.driver = new ChromeDriver();
        //this.driver = new EdgeDriver();
        this.driver.manage().window().maximize();
    }

    @AfterMethod
    protected final void setupAftermethods() {

        this.driver.close();

    }

    @DataProvider(name = "UserInformation")
    public Object[][] UserInformation() {
        return new Object[][]{
                {"Iliyana", "123456", "iliyana"}
        };
    }

    @Test(dataProvider = "UserInformation")
    public void testLoginWithWaits(String username, String password, String name) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("http://training.skillo-bg.com:4200/posts/all");
        wait.until(ExpectedConditions.urlToBe("http://training.skillo-bg.com:4200/posts/all"));


        String pageTitle = driver.getTitle();
        //With assert we validate page title is matching the expected title
        Assert.assertEquals(pageTitle, "ISkillo");

        WebElement LoginButton = driver.findElement(By.xpath("//*[@id='nav-link-login']"));
        wait.until(ExpectedConditions.visibilityOf(LoginButton));
        LoginButton.click();


        //String loginPageURL = driver.getCurrentUrl();
        //String expectedPageURL = "http://training.skillo-bg.com:4200/users/login";
        wait.until(ExpectedConditions.urlToBe("http://training.skillo-bg.com:4200/users/login"));
        //Assert.assertEquals(loginPageURL, expectedPageURL);


        WebElement signInForm = driver.findElement(By.xpath("//p[text()='Sign in']"));
        wait.until(ExpectedConditions.visibilityOf(signInForm));
        //Assert.assertTrue(signInForm.isDisplayed(), "The 'Sign in' form is not displayed");


        WebElement UserName = driver.findElement(By.id("defaultLoginFormUsername"));
        UserName.sendKeys(username);

        WebElement Password = driver.findElement(By.id("defaultLoginFormPassword"));
        Password.sendKeys(password);

        WebElement Rememberme = driver.findElement((By.xpath("//*[@*='rememberMe']")));
        Rememberme.click();
        System.out.println("RememberMe button is selected: " + Rememberme.isSelected());

        //Assert.assertTrue(Rememberme.isSelected(), "The remember me checkbox")

        //WebElement SignInButton = driver.findElement(By.id("sign-in-button"));
        WebElement SignInButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("sign-in-button")));
        SignInButton.click();


        WebElement ProfileLink = wait.until(ExpectedConditions.elementToBeClickable(By.id("nav-link-profile")));
        ProfileLink.click();

        //String CurrentURLProfile = "http://training.skillo-bg.com:4200/users/5051";
        //String ActualURLProfile = driver.getCurrentUrl();
        //Assert.assertEquals(ActualURLProfile,CurrentURLProfile);
        wait.until(ExpectedConditions.urlContains("http://training.skillo-bg.com:4200/users/"));

        //WebElement UserNameProfilePage = driver.findElement(By.tagName("h2"));
        //String actualUserName = UserNameProfilePage.getText();
        Boolean isElementTextDisplayed = wait.until(ExpectedConditions.textToBe(By.tagName("h2"), name));
        Assert.assertTrue(isElementTextDisplayed);

    }

    @Test
    public void testRegistration() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        driver.get("http://training.skillo-bg.com:4300/posts/all");
        wait.until(ExpectedConditions.urlToBe("http://training.skillo-bg.com:4300/posts/all"));

        //WebElement LoginButton = driver.findElement(By.xpath("//*[@id='nav-link-login']"));
        WebElement LoginButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='nav-link-login']")));
        LoginButton.click();

        //WebElement signInForm = driver.findElement(By.xpath("//p[text()='Sign in']"));
        //wait.until(ExpectedConditions.visibilityOf(signInForm));
        WebElement signInForm = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='Sign in']")));

        ////*[@href='/users/register']
        WebElement RegisterButton = driver.findElement(By.xpath("//*[@href='/users/register']"));
        RegisterButton.click();

        wait.until(ExpectedConditions.urlToBe("http://training.skillo-bg.com:4300/users/register"));

        WebElement SignUpElement = driver.findElement(By.xpath("//*[text()='Sign up']"));
        wait.until((ExpectedConditions.visibilityOf(SignUpElement)));

        WebElement UserNameRegistration = driver.findElement(By.name("username"));
        UserNameRegistration.sendKeys("IVasileva");
        String username = RandomString(5,10);
        //UserNameRegistration.sendKeys(username);
        //System.out.println("Username is " + username);

        WebElement EmailRegistration = driver.findElement(By.xpath("//*[@*='email']"));
        EmailRegistration.sendKeys("Vasileva2@test.bg");
        //String Email = RandomStringEmail(5,8);
        //EmailRegistration.sendKeys(Email);
        //System.out.println("Email is " + Email);

        WebElement BirthDate = driver.findElement(By.xpath("//*[@*='birthDate']"));
        BirthDate.sendKeys("10101990");

        WebElement Password = driver.findElement(By.id("defaultRegisterFormPassword"));
        Password.sendKeys("123456Iv");

        WebElement ConfirmPassword = driver.findElement(By.name("verify-password"));
        ConfirmPassword.sendKeys("123456Iv");

        WebElement PublicInfo = driver.findElement(By.name("pulic-info"));
        PublicInfo.sendKeys("Test");

        WebElement SignInButton = driver.findElement(By.id("sign-in-button"));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("sign-in-button")));
        SignInButton.click();

        wait.until(ExpectedConditions.urlContains("http://training.skillo-bg.com:4300/posts/all"));






    }

    private String RandomString(int minLenghtInclusive, int maxLenghtInclusive) {
        return RandomStringUtils.randomAlphabetic(minLenghtInclusive, maxLenghtInclusive);

    }

    private String RandomStringEmail(int minLenghtInclusive, int maxLenghtInclusive) {
        return RandomStringUtils.randomAlphabetic(minLenghtInclusive, maxLenghtInclusive) + "@gmail.com";

    }



}




