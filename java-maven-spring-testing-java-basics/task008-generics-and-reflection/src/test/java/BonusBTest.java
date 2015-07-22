import org.junit.Test;

import java.lang.reflect.Field;

import static org.junit.Assert.assertEquals;

/**
 * @author Henning Gross
 */
public class BonusBTest {

    @Test
    public void testChangeFooBar() throws NoSuchFieldException, IllegalAccessException {

        TestClass testClass = new TestClass();
        assertEquals("test", testClass.getFoobar());

        final Field foobar = TestClass.class.getDeclaredField("foobar");
        foobar.setAccessible(true);
        foobar.set(testClass, "SUCCESS");

        assertEquals("SUCCESS", testClass.getFoobar());
    }
}

class TestClass {

    private String foobar = "test";

    public String getFoobar() {
        return foobar;
    }
}