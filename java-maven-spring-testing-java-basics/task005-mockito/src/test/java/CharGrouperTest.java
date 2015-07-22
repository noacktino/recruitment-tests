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
@ContextConfiguration(classes = CharGrouperTest.CharGrouperTestSpringConfig.class)
public class CharGrouperTest {
    @Configuration
    static class CharGrouperTestSpringConfig {

        @Bean
        public CharGrouper charGrouper() {
            return new CharGrouper();
        }

        @Bean
        public StringCompressor stringCompressor() {
            return new StringCompressor();
        }

        @Bean
        public ArraySorter arraySorter() {
            return new ArraySorter();
        }
    }

    @Autowired
    private CharGrouper charGrouper;

    @Test
    public void testSomething() {
        assertEquals("a4bins2uz", charGrouper.group("abzuaaissna"));
    }
}


