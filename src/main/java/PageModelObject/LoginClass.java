package PageModelObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginClass {
    public static final  String PAGEURL ="http://training.skillo-bg.com:4200/users/login";

    private final WebDriver driver;

    public LoginClass(WebDriver driver){
        this.driver = driver;
    }

    public boolean isURLLoaded (){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        return  wait.until(ExpectedConditions.urlToBe(PAGEURL));
    }

    public String getSignInText(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement signInForm = driver.findElement(By.xpath("//*[text()='Sign in']"));
        wait.until(ExpectedConditions.visibilityOf(signInForm));
        return signInForm.getText();
    }

    public void populateUsername(String username){
        WebElement UserName = driver.findElement(By.id("defaultLoginFormUsername"));
        UserName.sendKeys(username);
    }

    public void populatePassword(String password){
        WebElement Password = driver.findElement(By.id("defaultLoginFormPassword"));
        Password.sendKeys(password);
    }

    public void ClickSignIn(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement SignInButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("sign-in-button")));
        SignInButton.click();
            }




}
