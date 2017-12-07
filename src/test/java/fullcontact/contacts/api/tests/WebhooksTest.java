package fullcontact.contacts.api.tests;
import com.ning.http.client.Request;
import fullcontact.contacts.api.Webhooks;
import fullcontact.contacts.api.responses.APIResponse;
import org.junit.Assert;
import org.junit.Test;


public class WebhooksTest extends APITestBase {
    private final Webhooks api;

    public WebhooksTest() {
        this.api = new Webhooks(this.config, this.client);
    }


}
