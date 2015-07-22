import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

/**
 * @author Henning Gross
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = StringCompressorTest.StringCompressorTestSpringConfig.class)
public class StringCompressorTest {

    @Configuration
    static class StringCompressorTestSpringConfig {

        @Bean
        public StringCompressor stringCompressor() {
            return new StringCompressor();
        }
    }

    @Autowired
    private StringCompressor stringCompressor;

    @Test
    public void testCompressSimple() {

        String uncompressed = "aaa";
        String compressed = stringCompressor.compress(uncompressed);
        assertEquals("a3", compressed);
    }

    @Test
    public void testCompressMoreComplex() {

        String uncompressed = "aabbbbcddddddd";
        String compressed = stringCompressor.compress(uncompressed);
        assertEquals("a2b4cd7", compressed);
    }

    @Test
    public void testCompressWithNonOptimizedResult() {

        String uncompressed = "hello";
        String compressed = stringCompressor.compress(uncompressed);
        assertEquals(uncompressed, compressed);
    }
}

