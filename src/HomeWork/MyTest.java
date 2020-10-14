package HomeWork;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

public class MyTest {

    @Test
    public static void test0(){
        System.out.println("test0");
    }

    @Test(priority = 4)
    public static void test3() {
        System.out.println("test3 has priority = 4");
    }

    @Test(priority = 5)
    public static void test4() {
        System.out.println("test4 has priority = 5");
    }

    @AfterSuite
    public static void test1() {
        System.out.println("test1 AfterSuite");
    }

    @BeforeSuite
    public static void test2() {
        System.out.println("test2 BeforeSuite");
    }

    @Test(priority = 2)
    public static void test5() {
        System.out.println("test5 has priority 2");
    }

    @Test
    public static void test6() {
        System.out.println("test6");
    }

    @Test(priority = 1)
    public static void test7() {
        System.out.println("test7 has priority = 1");
    }
}
