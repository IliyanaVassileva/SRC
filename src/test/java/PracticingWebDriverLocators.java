import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;
import java.util.List;
import java.util.Random;
import java.util.StringTokenizer;
import java.util.concurrent.TimeUnit;

public class PracticingWebDriverLocators {
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
        this.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    @AfterMethod
    protected final void setupAftermethods() {

        this.driver.close();

    }

//    @Test
//    public void testChekBox() {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//        driver.get("https://demoqa.com/checkbox");
//        wait.until(ExpectedConditions.urlToBe("https://demoqa.com/checkbox"));
//
//        WebElement HomeChek = driver.findElement(By.cssSelector("[for=tree-node-home]"));
//        HomeChek.click();
//        WebElement Chekbox = driver.findElement(By.cssSelector("#tree-node-home"));
//        Assert.assertTrue(Chekbox.isSelected());
//        WebElement result = driver.findElement(By.id("result"));
//        Assert.assertEquals(result.getText(), "You have selected :\n" +
//                "home\n" +
//                "desktop\n" +
//                "notes\n" +
//                "commands\n" +
//                "documents\n" +
//                "workspace\n" +
//                "react\n" +
//                "angular\n" +
//                "veu\n" +
//                "office\n" +
//                "public\n" +
//                "private\n" +
//                "classified\n" +
//                "general\n" +
//                "downloads\n" +
//                "wordFile\n" +
//                "excelFile");
//
//        HomeChek.click();
//        Assert.assertFalse(Chekbox.isSelected());
//
//    }
//
//    @Test
//    public void testChekBoxExpand(){
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//        driver.get("https://demoqa.com/checkbox");
//        wait.until(ExpectedConditions.urlToBe("https://demoqa.com/checkbox"));
//
//        ////*[@for='tree-node-home']/../button - С двете точки прескачаме към перънта, със наклонена черта оказваме тип
//        //*[@for='tree-node-home']/preceding-sibling::button
//        WebElement homeArrow = driver.findElement(By.xpath("//*[@for='tree-node-home']/preceding-sibling::button"));
//        homeArrow.click();
//
//        WebElement Document = driver.findElement(By.xpath("//*[@for='tree-node-documents']"));
//        Document.click();
//
//    }

//    @Test
//    public void testRadioButton(){
//        driver.get("https://demoqa.com/radio-button");
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//        wait.until(ExpectedConditions.urlToBe("https://demoqa.com/radio-button"));
//
//        WebElement YesLabel = driver.findElement(By.cssSelector("[for='yesRadio']"));
//        YesLabel.click();
//        WebElement YesRadioButton = driver.findElement(By.id("yesRadio"));
//        Assert.assertTrue(YesRadioButton.isSelected());
//        WebElement ActualText = driver.findElement(By.className("mt-3"));
//        Assert.assertEquals(ActualText.getText(), "You have selected Yes");
//
//        WebElement Impressive =  driver.findElement(By.cssSelector("[for='impressiveRadio']"));
//        Impressive.click();
//        WebElement ImpressiveButton = driver.findElement(By.id("impressiveRadio"));
//        Assert.assertTrue(ImpressiveButton.isSelected());
//        Assert.assertEquals(ActualText.getText(), "You have selected Impressive");
//
//        //WebElement NoRadio = driver.findElement(By.cssSelector(("[for='noRadio'")));
//
//        WebElement NoRadioButton = driver.findElement(By.id("noRadio"));
//        Assert.assertFalse(NoRadioButton.isEnabled());
//
//        if (NoRadioButton.isEnabled()) {
//            Assert.assertTrue(NoRadioButton.isSelected());
//        }else {
//            System.out.println("The NO radio button is disabled");
//        }


    @Test
    public void testWebTable() {
        driver.get("https://demoqa.com/webtables");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.urlToBe("https://demoqa.com/webtables"));

        WebElement Table = driver.findElement(By.className("rt-table"));


        WebElement TableColumnHeader = Table.findElement(By.className("rt-thead"));
        List<WebElement> columnHeader = TableColumnHeader.findElements(By.cssSelector("[role='columnheader']"));

        int emailIndex = 0;

        for (WebElement column : columnHeader) {
            String columnName=column.getText();
            if (columnName.equalsIgnoreCase("email")){
                emailIndex = columnHeader.indexOf(column);
                System.out.println(emailIndex);

            }
        }

        WebElement TableBody = Table.findElement(By.className("rt-tbody"));
        List<WebElement> TableRows = TableBody.findElements(By.cssSelector("[role='row']"));
        for (WebElement row : TableRows) {
            List <WebElement> cells = row.findElements(By.cssSelector("[role='gridcell']"));
            String cellsText = cells.get(emailIndex).getText();
            if (cellsText.equalsIgnoreCase("alden@example.com")){
                WebElement DeleteButton = row.findElement(By.cssSelector("[id^='delete-record']"));
                DeleteButton.click();
                break;
            }
        }


    }

}



