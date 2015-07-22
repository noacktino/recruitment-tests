import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.SpringApplication;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

/**
 * @author Henning Gross
 */
public class CharGrouperHTTPServiceTest {


    private final static String ENDPOINT_URL = "http://localhost:8080/group";

    private final static String INPUT = "abzuaaissna";

    private final static String EXPECTED_RESULT = "a4bins2uz";

    @Before
    public void startApp() {

        SpringApplication.run(CharGrouperApplication.class);
    }

    @Test
    public void testService() throws IOException {

        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        HttpGet request = new HttpGet(ENDPOINT_URL + "?chars=" + INPUT);

        CloseableHttpResponse httpResponse = httpClient.execute(request);

        assertEquals(HttpStatus.SC_OK, httpResponse.getStatusLine().getStatusCode());

        assertEquals(EXPECTED_RESULT, org.apache.commons.io.IOUtils.toString(httpResponse.getEntity().getContent()));
    }
}
