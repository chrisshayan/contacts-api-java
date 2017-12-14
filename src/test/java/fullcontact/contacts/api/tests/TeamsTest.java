package fullcontact.contacts.api.tests;
import org.asynchttpclient.*;
import fullcontact.contacts.api.Teams;
import fullcontact.contacts.api.responses.APIResponse;
import org.junit.Assert;
import org.junit.Test;


public class TeamsTest extends APITestBase {
    private final Teams api;

    public TeamsTest() {
        this.api = new Teams(this.config, this.client);
    }

    @Test public void test_get() throws Exception {
        String accessToken = this.randomString();
        Request req = this.buildRequest(accessToken, "POST", "/api/v1/teams.get", "{}");
        this.expect(req);
        APIResponse res = this.api.get(accessToken);
        Assert.assertEquals(res.status, (Integer) 200);
        this.verifyRequest(req, res);
    }
}
