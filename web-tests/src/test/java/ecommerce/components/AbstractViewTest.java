package ecommerce.components;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Before;

import java.io.IOException;

public abstract class AbstractViewTest {

    protected String url;

    @Before
    public void setUp() throws Exception {
        String servername = System.getProperty("test.host.servername");
        String port = System.getProperty("test.host.port");
        String context = System.getProperty("test.host.context");
        url = String.format("http://%s:%s%s", servername, port, context) + getPage();
    }

    protected abstract String getPage();

    protected Document getDocument() throws IOException {
        return Jsoup.connect(url).timeout(10000).get();
    }
}
