package net.rcarz.jiraclient;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Test;

import java.net.URI;
import java.util.Collections;

import static org.junit.Assert.assertEquals;

public class RestClientTest {

    @Test
    public void buildsCorrectUri() throws Exception {
        try (CloseableHttpClient httpClient = HttpClientBuilder.create().build()) {
            RestClient restClient = new RestClient(httpClient, new URI("https://my.jira-instance.co.uk"));

            assertEquals(
                    new URI("https://my.jira-instance.co.uk/rest/api/issue"),
                    restClient.buildURI("/rest/api/issue")
            );
            assertEquals(
                    new URI("https://my.jira-instance.co.uk/rest/api/issue?key1=value1"),
                    restClient.buildURI("/rest/api/issue", Collections.singletonMap("key1", "value1"))
            );
        }
    }
}
