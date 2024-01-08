import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionsTests {

    @Test
    public void hardAssert() {
        Assert.assertTrue(1>2);
    }

    @Test
    public void softAssert() {
        SoftAssert soft = new SoftAssert();
        Assert.assertTrue(5==5);
        Assert.assertTrue(5==6);
        soft.assertAll();
    }
}
