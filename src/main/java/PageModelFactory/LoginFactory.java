package PageModelFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginFactory {
    public static final  String PAGEURL ="http://training.skillo-bg.com:4200/users/login";

    private final WebDriver driver;

    @FindBy(xpath = "//*[text()='Sign in']" )
    private WebElement signInForm;

    @FindBy(id = "defaultLoginFormUsername")
    private WebElement UserName;

    @FindBy(id = "defaultLoginFormPassword")
    private WebElement Password;

    @FindBy(id = "sign-in-button")
    private  WebElement SignInButton;

    public LoginFactory(WebDriver driver){

        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public void navigateTo(){
        this.driver.get(LoginFactory.PAGEURL);
    }

    public boolean isURLLoaded (){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        return  wait.until(ExpectedConditions.urlToBe(PAGEURL));
    }

    public String getSignInText(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(signInForm));
        return signInForm.getText();
    }

    public void login(String username, String password ){
        populateUsername(username);

        populatePassword(password);

        ClickSignIn();
    }

    public void populateUsername(String username){

        UserName.sendKeys(username);
    }

    public void populatePassword(String password){

        Password.sendKeys(password);
    }

    public void ClickSignIn(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(SignInButton));
        SignInButton.click();
            }




}
