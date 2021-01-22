import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

/**
 * @author lijunfeng
 */
public class HttpTest {

    public static void main(String[] args) throws Exception {
        CloseableHttpClient httpClient = null;
        httpClient = HttpClients.custom().build();
        try (CloseableHttpResponse response = httpClient.execute(new HttpGet("http://localhost:8801"))) {
            System.out.println(response.toString());
        } catch (Exception ex) {
            System.err.println("Httpclient error.");
            ex.printStackTrace();
        } finally {
            httpClient.close();
        }
    }
}
