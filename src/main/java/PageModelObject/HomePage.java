package PageModelObject;

import org.bouncycastle.pqc.crypto.util.PQCOtherInfoGenerator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {

    public static final  String PAGEURL ="http://training.skillo-bg.com:4200/posts/all";

    private final WebDriver driver;

    public HomePage(WebDriver driver){
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
