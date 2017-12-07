package fullcontact.contacts.api.tests;
import com.ning.http.client.Request;
import com.ning.http.client.Response;
import fullcontact.contacts.api.Account;
import fullcontact.contacts.api.responses.APIResponse;
import org.junit.Assert;
import org.junit.Test;

import static org.mockito.ArgumentMatchers.any;

public class AccountTest extends APITestBase {
    private final Account api;

    public AccountTest() {
        this.api = new Account(this.config, this.client);
    }

    @Test public void test_get() throws Exception {
        String accessToken = "Test-Token";
        Request req = this.buildRequest(accessToken, "POST", "/api/v1/account.get", "{}");
        this.expect(req);
        APIResponse res = this.api.get(accessToken);
        Assert.assertEquals(res.status, (Integer) 200);
        this.validate().executeRequest(any(Request.class));
    }
}
