package Lecture17;

import Lecture16.TestClass;
import PageModelFactory.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;


public class PageObjectScrFile extends TestClass {
    private WebDriver driver;

    public static void main(String[] args) {

    }


    @DataProvider(name = "UserInformation")
    public Object[][] UserInformation() {
        File postPicture = new File("src\\main\\resources\\upload\\au9i1g9hn-1200x595.jpg");
        String caption = "The image caption content";
        return new Object[][]{
                {"Iliyana", "123456", "iliyana", postPicture, caption}
        };
    }

    @Test(dataProvider = "UserInformation")
    public void testLoginWithWaits(String username, String password, String name, File postpicture, String caption) {
        WebDriverWait wait = new WebDriverWait(super.getDriver(), Duration.ofSeconds(30));

        LoginFactory loginClass = new LoginFactory(super.getDriver());
        loginClass.navigateTo();


        loginClass.isURLLoaded();

        String elemText = loginClass.getSignInText();
        Assert.assertEquals(elemText, "Sign in");

        loginClass.login(username,password);

        HeaderFactory headerPage = new HeaderFactory(super.getDriver());
        headerPage.ClickNewPostLink();

        PostPage postPage = new PostPage(super.getDriver());
        Assert.assertTrue(postPage.isURLLoaded());

        postPage.uploadPicture(postpicture);

        Assert.assertTrue(postPage.IsImageVisible(), "The image is not upload!");

        Assert.assertEquals(postPage.GetImageName(), postpicture.getName());

        postPage.populateCaption(caption);

        postPage.clickCreateButton();









    }

}

