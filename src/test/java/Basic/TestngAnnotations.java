package Basic;

import org.testng.annotations.*;

public class TestngAnnotations {

    @Test
    public void test1() {
        System.out.println("This is Test Method 1");

    }
    @BeforeMethod
    public void beforeMethod() {
        System.out.println("This is Before Method");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("This is After Class");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("This is Before Test");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("This is After Test");
    }









}
