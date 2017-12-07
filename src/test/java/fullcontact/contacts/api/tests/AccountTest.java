package fullcontact.contacts.api.tests;
import com.ning.http.client.Request;
import fullcontact.contacts.api.Account;
import fullcontact.contacts.api.responses.APIResponse;
import org.junit.Assert;
import org.junit.Test;

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
        this.verifyRequest(req, res);
        this.validate();
    }
}
