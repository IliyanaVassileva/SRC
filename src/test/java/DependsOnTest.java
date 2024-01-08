import org.testng.annotations.Test;

public class DependsOnTest {
    @Test(dependsOnGroups = "group.dependency")
    public void testDependsOnGroup() {
        System.out.println("This methods depends on group");
    }

    @Test(groups = "group.dependency")
    public void testGroupDependency() {
        System.out.println("This method is part of group.dependency");
    }
}
