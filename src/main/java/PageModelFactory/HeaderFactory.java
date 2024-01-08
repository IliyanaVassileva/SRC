package PageModelFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HeaderFactory {

    public static final  String PAGEURL ="http://training.skillo-bg.com:4200/posts/all";

    private final WebDriver driver;

    public HeaderFactory(WebDriver driver){

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "nav-link-profile")
    private WebElement ProfileLink;

    @FindBy(id = "nav-link-login")
    private  WebElement LoginButton;

    @FindBy(id = "nav-link-new-post")
    private WebElement NewPostLink;

    public void ClickLoginLink(){
        LoginButton.click();

    }

    public void ClickProfileLink(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(ProfileLink));
        ProfileLink.click();
    }

    public void ClickNewPostLink(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(NewPostLink));
        NewPostLink.click();
    }


}
