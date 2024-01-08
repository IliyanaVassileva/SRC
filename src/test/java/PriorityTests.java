import org.testng.annotations.Test;

public class PriorityTests {

    @Test(priority = 1)
    public void testPriority1() {
        System.out.println("I m priority test 1");
    }

    @Test(priority = 0)
    public void testPriority2() {
        System.out.println("I m priority test 2");
    }

    @Test(priority = 2)
    public void testPriority3() {
        System.out.println("I m priority test 2");
    }
}
