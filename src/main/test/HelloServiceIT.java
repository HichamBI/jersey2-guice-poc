import org.assertj.core.api.Assertions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import tomcat.EmbeddedTomcatLauncher;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

/**
 * Created by IntelliJ IDEA.
 * Author: Hicham B.I.
 * Date: 27/09/15
 * Time: 21:44
 */

public class HelloServiceIT {

    private static EmbeddedTomcatLauncher embeddedTomcatLauncher;

    @BeforeClass
    public static void beforeClass() throws Exception {
        embeddedTomcatLauncher = new EmbeddedTomcatLauncher();
        embeddedTomcatLauncher.start();
    }

    @AfterClass
    public static void afterClass() throws Exception {
        embeddedTomcatLauncher.stop();
    }

    @Test
    public void test_nominal() {
        Client client = ClientBuilder.newClient();

        WebTarget path = client.target("http://localhost:8080/")
                .path("resource/hello");
        String entity = path
                .request(MediaType.TEXT_PLAIN_TYPE)
                .get(String.class);

        Assertions.assertThat("Hello, I am a Jersey2 restful service with Guice injection").isEqualTo(entity);
    }
}