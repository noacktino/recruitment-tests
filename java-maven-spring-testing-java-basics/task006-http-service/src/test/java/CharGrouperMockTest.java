import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * @author Henning Gross
 */
@RunWith(MockitoJUnitRunner.class)
public class CharGrouperMockTest {

    private final static String TEST_STRING = "abcdef";
    private final static int[] TEST_STRING_AS_INT_ARRAY = StringUtils.stringToIntArray(TEST_STRING);
    private final static String EXPECTED_RESULT = "SUCCESS";
    private final static int[] EXPECTED_RESULT_AS_INT_ARRAY = StringUtils.stringToIntArray(EXPECTED_RESULT);

    @Mock
    private ArraySorter arraySorter;

    @Spy
    private StringCompressor stringCompressor;

    @InjectMocks
    private CharGrouper charGrouper;

    @Before
    public void initMocks() {
        when(arraySorter.sort(TEST_STRING_AS_INT_ARRAY)).thenReturn(EXPECTED_RESULT_AS_INT_ARRAY);
    }

    @Test
    public void testWithTestString() {
        assertEquals(EXPECTED_RESULT, charGrouper.group(TEST_STRING));
        verify(stringCompressor, times(1)).compress(anyString());
    }

    @Test
    public void testWithSomeBogusString() {
        assertEquals("", charGrouper.group("foo"));
    }
}
