import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Demo {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        //testMyFirstWebDriver();
        //testFindElement();
        //testFindElements();
        //testClick();
        //testSendKeys();
        //testclear();
        //testCommonCommands();
        //testisSelected();
        testDropdown();

    }

    private static void testMyFirstWebDriver(){
        ChromeDriver driver = new ChromeDriver();
        driver.get("http://training.skillo-bg.com:4300/posts/all");
        driver.manage().window().maximize();

    }

    private static void testFindElement(){
        ChromeDriver driver = new ChromeDriver();
        driver.get("http://training.skillo-bg.com:4300/posts/all");
        driver.manage().window().maximize();
        WebElement loginLink = driver.findElement(By.id("nav-link-login"));
        loginLink.click();





    }

    private static void testFindElements(){
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("http://training.skillo-bg.com:4300/posts/all");
        List<WebElement> posts = driver.findElements(By.xpath("//*[@class='post-feed-img']"));
        System.out.println("The numers of elements is " + posts.size());


    }

    private static void testClick(){
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("http://training.skillo-bg.com:4300/posts/all");
        WebElement loginLink = driver.findElement(By.id("nav-link-login"));
        loginLink.click();
        driver.close();


    }

    private static void testSendKeys(){
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("http://training.skillo-bg.com:4300/posts/all");
        WebElement loginLink = driver.findElement(By.id("nav-link-login"));
        loginLink.click();

        WebElement username = driver.findElement(By.xpath("//*[@id='defaultLoginFormUsername']"));
        username.sendKeys("Iliyana");



    }

    private static void testclear(){
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("http://training.skillo-bg.com:4300/posts/all");

        WebElement loginLink = driver.findElement(By.id("nav-link-login"));
        loginLink.click();

        WebElement username = driver.findElement(By.xpath("//*[@id='defaultLoginFormUsername']"));
        username.sendKeys("Iliyana");

        WebElement Password = driver.findElement(By.xpath("//*[@id='defaultLoginFormPassword']"));
        Password.sendKeys("Iliyana");

        username.clear();

    }

    public static void testCommonCommands(){
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("http://training.skillo-bg.com:4300/posts/all");

        String TitleoffPage = driver.getTitle();
        System.out.println("The title off page is " + TitleoffPage);

        driver.close();



    }

    public static void testisSelected(){
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("http://training.skillo-bg.com:4300/posts/all");

        WebElement loginLink = driver.findElement(By.id("nav-link-login"));
        loginLink.click();

        WebElement rememberMe = driver.findElement(By.xpath("//*[@*='rememberMe']"));
        rememberMe.click();
        rememberMe.click();

        rememberMe.isSelected();
        System.out.println("Is the element selected?" + rememberMe.isSelected());

        WebElement buttonSignIn = driver.findElement(By.xpath("//*[@id='sign-in-button']"));
        String buttonText = buttonSignIn.getText();
        System.out.println("The element text is: " + buttonText );

        buttonSignIn.isDisplayed();

        System.out.println("Is the element is displayed? " + buttonSignIn.isDisplayed() );

        WebElement username = driver.findElement(By.xpath("//*[@id='defaultLoginFormUsername']"));
        username.sendKeys("Iliyana");

        WebElement Password = driver.findElement(By.xpath("//*[@id='defaultLoginFormPassword']"));
        Password.sendKeys("Iliyana");

        System.out.println("Is the element is enabled? " + buttonSignIn.isEnabled() );

        driver.close();

    }

    private static void testDropdown(){
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://www.mobile.bg/pcgi/mobile.cgi");

        WebElement TextToSite = driver.findElement(By.xpath("//p[text()='Към сайта']"));
        TextToSite.click();

        Select DropDownMarka = new Select(driver.findElement(By.name("marka")));
        DropDownMarka.selectByVisibleText("Rover");



    }





}

