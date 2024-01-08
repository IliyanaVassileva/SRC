import org.testng.annotations.Test;

import java.io.IOException;

public class ExceptionsTestNG {

    @Test(expectedExceptions = RuntimeException.class)
    public void testException1() {
        System.out.println("Exception test 1");
        throw new RuntimeException("Pass");
    }

    @Test(expectedExceptions = IOException.class)
    public void testException2() {
        System.out.println("Exception test 2");
        throw new RuntimeException("pass");
    }

    @Test(expectedExceptions = {IOException.class, RuntimeException.class})
    public void testException3() {
        System.out.println("Exception test 3");
        throw new RuntimeException("pass");
    }
}
