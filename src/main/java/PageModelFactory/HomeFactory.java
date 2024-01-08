package PageModelFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomeFactory {

    public static final  String PAGEURL ="http://training.skillo-bg.com:4200/posts/all";

    private final WebDriver driver;

    public HomeFactory(WebDriver driver){
        this.driver = driver;
    }

    public boolean isURLLoaded (){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        return  wait.until(ExpectedConditions.urlToBe(PAGEURL));
    }
    public void navigateTo(){
        this.driver.get(PAGEURL);
    }
}
