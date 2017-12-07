package fullcontact.contacts.api.tests;
import com.ning.http.client.Request;
import fullcontact.contacts.api.OAuth;
import fullcontact.contacts.api.responses.APIResponse;
import org.junit.Assert;
import org.junit.Test;


public class OAuthTest extends APITestBase {
    private final OAuth api;

    public OAuthTest() {
        this.api = new OAuth(this.config, this.client);
    }


}
