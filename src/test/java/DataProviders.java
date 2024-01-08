import org.testng.annotations.*;

public class DataProviders {
    @DataProvider(name = "generateValues")
    public Object[][] generateValues()
    { return new Object[][]{{"First-Value"}, {"Second-Value"}, {"Third-Value"}};
    }
    @Test(dataProvider = "generateValues")
    public void testDataProvider(String val) {
        System.out.println("Passed parameter is" +val);
    }
}
