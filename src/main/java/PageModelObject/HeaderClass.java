package PageModelObject;
import org.bouncycastle.pqc.crypto.util.PQCOtherInfoGenerator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HeaderClass {
    public static final  String PAGEURL ="http://training.skillo-bg.com:4200/posts/all";

    private final WebDriver driver;

    public HeaderClass(WebDriver driver){
        this.driver = driver;
    }

    public void ClickLoginLink(){
        WebElement LoginButton = driver.findElement(By.xpath("//*[@id='nav-link-login']"));
        LoginButton.click();

    }

    public void ClickProfileLink(){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
        WebElement ProfileLink = wait.until(ExpectedConditions.elementToBeClickable(By.id("nav-link-profile")));
        ProfileLink.click();

    }
}
