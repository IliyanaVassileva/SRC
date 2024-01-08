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
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class ISkilloHomework {

    private WebDriver driver;

    public static void main(String[] args) {

    }

    @BeforeSuite
    protected final void setupTestSuite() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    protected final void setupMethods() {
        this.driver = new ChromeDriver();
        this.driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @AfterMethod
    protected final void setupAftermethods() {

        this.driver.close();

    }

    @DataProvider(name = "UserInformation")
    public Object[][] UserInformation() {
        return new Object[][]{
                {"Iliyana1", "123456"}
        };
    }

    @Test (dataProvider = "UserInformation")
    public void testHomepage(String username, String password) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        driver.get("http://training.skillo-bg.com:4200/posts/all");
        wait.until(ExpectedConditions.urlToBe("http://training.skillo-bg.com:4200/posts/all"));

        WebElement LoginButton = driver.findElement(By.xpath("//*[@id='nav-link-login']"));
        wait.until(ExpectedConditions.visibilityOf(LoginButton));
        LoginButton.click();
        wait.until(ExpectedConditions.urlToBe("http://training.skillo-bg.com:4200/users/login"));

        WebElement signInForm = driver.findElement(By.xpath("//p[text()='Sign in']"));
        wait.until(ExpectedConditions.visibilityOf(signInForm));

        WebElement UserName = driver.findElement(By.id("defaultLoginFormUsername"));
        UserName.sendKeys(username);

        WebElement Password = driver.findElement(By.id("defaultLoginFormPassword"));
        Password.sendKeys(password);


        WebElement SignInButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("sign-in-button")));
        SignInButton.click();

        wait.until(ExpectedConditions.urlToBe("http://training.skillo-bg.com:4200/posts/all"));

        List<WebElement> postsforlike = driver.findElements(By.xpath("//div[@class='post-feed-img']"));
        WebElement firstPost = postsforlike.get(0);
        WebElement likeButton;
        likeButton = firstPost.findElement(By.cssSelector("));
        likeButton.click();

//        //Validate is the post liked
//        //WebElement likeCountElement = firstPost.findElement(By.xpath("By.xpath(//strong[@_ngcontent-phg-c5='']"));
//        //int likeCountAfterLike = Integer.parseInt(likeCountElement.getText());
//        //Assert.assertTrue(likeCountAfterLike > 0, "The post is not liked.");
//
//        List<WebElement> postsforunlike = driver.findElements(By.xpath("//div[@class='post-feed-img']"));
//        WebElement firstPostUnLike = postsforunlike.get(0);
//        WebElement unlikeButton = firstPostUnLike.findElement(By.xpath("//i[@class='ml-4 far fa-thumbs-down fa-2x']"));
//        unlikeButton.click();
//
//        WebElement userLink = driver.findElement(By.xpath("//a[contains(text(), 'automation_user')]"));
//        userLink.click();
//        WebElement followButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-primary profile-edit-btn ng-star-inserted' and text()='Follow']")));
//        followButton.click();
//
//        WebElement HomeButton = driver.findElement(By.id("nav-link-home"));
//        HomeButton.click();
//
//        WebElement OpenPost = driver.findElement(By.xpath("//img[@src='https://i.imgur.com/zY7dp6C.gif']"));
//        OpenPost.click();
//
//
//


          //Test for follow user from Home page
//        List<WebElement> userLinks = driver.findElements(By.xpath("//a[contains(text(), 'automation_user')]"));
//        if (!userLinks.isEmpty()) {
//            WebElement userLink = userLinks.get(0);
//            WebElement followButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-primary ng-star-inserted' and text()='Follow']")));
//            followButton.click();
//        } else {
//            System.out.println("It is not found.");
//      }

















    }

}