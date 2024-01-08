import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;
public class ISkilloTest {
    //private WebDriver driver;

    public static void main(String[] args) {

    }


@Test
    public void testLogin() {
    WebDriverManager.chromedriver().setup();
    ChromeDriver driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    driver.get("http://training.skillo-bg.com:4200/posts/all");
    String pageTitle = driver.getTitle();
    //With assert we validate page title is matching the expected title
    Assert.assertEquals(pageTitle, "ISkillo");

    WebElement LoginButton = driver.findElement(By.xpath("//*[@id='nav-link-login']"));
    LoginButton.click();


    //String loginPageURL = driver.getCurrentUrl();
    //String expectedPageURL = "http://training.skillo-bg.com:4200/users/login";
    //Assert.assertEquals(loginPageURL, expectedPageURL);


    //WebElement signInForm = driver.findElement(By.cssSelector(".h4"));
    //Assert.assertTrue(signInForm.isDisplayed());
    //signInForm.isDisplayed();

    WebElement UserName = driver.findElement(By.id("defaultLoginFormUsername"));
    UserName.sendKeys("iliyana");

    WebElement Password = driver.findElement(By.id("defaultLoginFormPassword"));
    Password.sendKeys("123456");

    WebElement Rememberme = driver.findElement((By.xpath("//*[@*='rememberMe']")));
    Rememberme.click();
    Rememberme.click();
    System.out.println("RememberMe button is selected: " + Rememberme.isSelected());

    //Assert.assertTrue(Rememberme.isSelected(), "The remember me checkbox")

    WebElement SignInButton = driver.findElement(By.id("sign-in-button"));
    System.out.println( "Sign in button is enabled: " + SignInButton.isEnabled());
    SignInButton.click();

    WebElement ProfileLink = driver.findElement(By.id("nav-link-profile"));
    System.out.println("ProfileLink:" + ProfileLink.isDisplayed());
    Assert.assertTrue(ProfileLink.isDisplayed());
    ProfileLink.click();

    WebElement UserNameProfilePage = driver.findElement(By.tagName("h2"));
    String actualUserName = UserNameProfilePage.getText();
    String expextedUserName = "iliyana";
    Assert.assertEquals(actualUserName, expextedUserName);

    String CurrentURLProfile = "http://training.skillo-bg.com:4200/users/5051";
    String ActualURLProfile = driver.getCurrentUrl();
    Assert.assertEquals(ActualURLProfile,CurrentURLProfile);























}



}