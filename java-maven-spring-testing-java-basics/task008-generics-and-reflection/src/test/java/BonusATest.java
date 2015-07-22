import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Henning Gross
 */
public class BonusATest {

    @Test
    public void testGenerics() {

        String s = "1";
        Integer i = 1;

        s = add(s, 1);
        assertEquals("2", s);
        s = add(s, 5);
        assertEquals("7", s);

        i = add(i, 2);
        assertEquals((Integer) 3, i);
        i = add(i, 1);
        assertEquals((Integer) 4, i);
    }

    private <T> T add(T input, int add) {

        Integer value = Integer.parseInt(input.toString());
        Integer result = value + add;
        if (input instanceof String) {
            return (T) result.toString();
        }
        return (T) result;
    }
}
