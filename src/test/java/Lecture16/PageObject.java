package Lecture16;

import Lecture16.TestClass;
import PageModelFactory.HeaderFactory;
import PageModelFactory.HomeFactory;
import PageModelFactory.LoginFactory;
import PageModelFactory.ProfileFacory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PageObject extends TestClass {
    private WebDriver driver;

    public static void main(String[] args) {

    }


    @DataProvider(name = "UserInformation")
    public Object[][] UserInformation() {
        return new Object[][]{
                {"Iliyana", "123456", "iliyana"}
        };
    }

    @Test(dataProvider = "UserInformation")
    public void testLoginWithWaits(String username, String password, String name) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(30));

        HomeFactory homePage = new HomeFactory(getDriver());
        homePage.navigateTo();
        homePage.isURLLoaded();

        HeaderFactory headerMenu = new HeaderFactory(getDriver());
        headerMenu.ClickLoginLink();

        LoginFactory loginClass = new LoginFactory(getDriver());
        loginClass.isURLLoaded();

        String elemText = loginClass.getSignInText();
        Assert.assertEquals(elemText, "Sign in");

        loginClass.populateUsername(username);

        loginClass.populatePassword(password);

        loginClass.ClickSignIn();

        headerMenu.ClickProfileLink();

        ProfileFacory profileClass = new ProfileFacory(getDriver());
        profileClass.isURLLoaded();

        Assert.assertEquals(profileClass.getUsername(), name);

    }

}

