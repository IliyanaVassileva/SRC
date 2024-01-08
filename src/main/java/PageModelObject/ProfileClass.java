package PageModelObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProfileClass {
    public static final  String PAGEURL ="http://training.skillo-bg.com:4200/users/";
    private final WebDriver driver;

    public ProfileClass(WebDriver driver){
        this.driver = driver;
    }
    public boolean isURLLoaded (){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        return  wait.until(ExpectedConditions.urlContains(PAGEURL));
    }
    public String getUsername(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement loggedInUser = driver.findElement(By.tagName("h2"));
        return loggedInUser.getText();

    }
}
