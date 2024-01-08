package PageModelFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProfileFacory {
    public static final  String PAGEURL ="http://training.skillo-bg.com:4200/users/";
    private final WebDriver driver;

    @FindBy(tagName = "h2")
    private WebElement loggedInUser;

    public ProfileFacory(WebDriver driver){

        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    public boolean isURLLoaded (){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        return  wait.until(ExpectedConditions.urlContains(PAGEURL));
    }
    public String getUsername(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(loggedInUser));
        return loggedInUser.getText();

    }
}
