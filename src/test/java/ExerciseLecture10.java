import org.testng.annotations.*;
import org.testng.Assert;
public class ExerciseLecture10 {
    @BeforeSuite
    public void beforeSuite() {
        System.out.println("Before Suite");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("After Suite");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("Before Class");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("After Class");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Before Method");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("After Method");
    }


    @DataProvider(name = "generateNumbers")
    public Object[][] generateNumbers() {
        return new Object[][]{
                {2, 6, 8},
                {1, 7, 8},
                {5, 6, 11},
                {5, 5, 10}
        };
    }

    @Test (dataProvider = "generateNumbers", groups = "Addition")
    public void SumOfNumbers(int a, int b, int expectedResult) {
        int actualResult = a+b;
        Assert.assertEquals(actualResult, expectedResult);
    }

    @DataProvider(name = "generateNumbersWhitSubtraction")
    public Object[][] generateNumbersWhitSubtraction() {
        return new Object[][]{
                {8, 2, 6},
                {8, 7, 1},
                {11, 6, 5},
                {10, 5, 5}
        };
    }

    @Test (dataProvider = "generateNumbersWhitSubtraction", groups = "Subtraction")
    public void SubtractingNumbers(int a, int b, int expectedResult) {
        int actualResult = a-b;
        Assert.assertEquals(actualResult, expectedResult);
    }

    @DataProvider(name = "generateNumbersWhitMultiplication")
    public Object[][] generateNumbersWhitMultiplication() {
        return new Object[][]{
                {2, 4, 8},
                {8, 1, 8},
                {2, 6, 12},
                {2, 5, 10}
        };
    }

    @Test (dataProvider = "generateNumbersWhitMultiplication", groups = "Multiplication")
    public void MultiplicationNumbers(int a, int b, int expectedResult) {
        int actualResult = a*b;
        Assert.assertEquals(actualResult, expectedResult);
    }

    @DataProvider(name = "generateNumbersWhitDivision")
    public Object[][] generateNumbersWhitDivision() {
        return new Object[][]{
                {8, 4, 2},
                {8, 1, 8},
                {12, 6, 2},
                {10, 5, 2}
        };
    }

    @Test (dataProvider = "generateNumbersWhitDivision", groups = "Division")
    public void DivisionNumbers(int a, int b, int expectedResult) {
        int actualResult = a/b;
        Assert.assertEquals(actualResult, expectedResult);
    }

    @DataProvider(name = "generateNumbersWhitModularDivision")
    public Object[][] generateNumbersWhitModularDivision() {
        return new Object[][]{
                {13, 3, 1},
                {6, 4, 2},
                {10, 1, 0},
                {10, 5, 0}
        };
    }

    @Test (dataProvider = "generateNumbersWhitModularDivision", groups = "ModularDivision")
    public void ModularDivision(int a, int b, int expectedResult) {
        int actualResult = a%b;
        Assert.assertEquals(actualResult, expectedResult);
    }
}
