import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author Henning Gross
 */
@EnableAutoConfiguration
@ComponentScan
public class CharGrouperApplication {

    public static void main(String[] args) {
        SpringApplication.run(CharGrouperApplication.class, args);
    }
}
