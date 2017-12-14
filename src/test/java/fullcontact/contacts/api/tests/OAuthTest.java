package fullcontact.contacts.api.tests;
import com.fasterxml.jackson.databind.JsonNode;
import fullcontact.contacts.api.OAuth;
import fullcontact.contacts.api.models.Authorization;
import fullcontact.contacts.api.responses.APIResponse;
import org.junit.Assert;
import org.junit.Test;
import org.asynchttpclient.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class OAuthTest extends APITestBase {
    private final OAuth api;
    private final String clientId = this.randomString();
    private final String clientSecret = this.randomString();

    public OAuthTest() {
        this.config.put("clientId", this.clientId);
        this.config.put("clientSecret", this.clientSecret);
        this.api = new OAuth(this.config, this.client);
    }

    @Test public void test_getAuthorizationUrl() throws Exception {
        String scope1 = this.randomString();
        String scope2 = this.randomString();
        String state = this.randomString();
        String redirectUri = this.randomString();
        List<String> scopes = new ArrayList<>();
        scopes.add(scope1);
        scopes.add(scope2);

        String url = this.api.getAuthorizationUrl(scopes, redirectUri, state);
        String expected = String.format(
                "https://app.fullcontact.com/oauth/authorize?client_id=%s&scopes=%s%%2C%s&redirect_uri=%s&state=%s",
                this.clientId,
                scope1,
                scope2,
                redirectUri,
                state
        );
        Assert.assertEquals(expected, url);
    }

    @Test public void test_exchangeAuthCode() throws Exception {
        String code = this.randomString();
        String redirectUri = this.randomString();
        HashMap<String, String> params = new HashMap<>();
        params.put("code", code);
        params.put("client_id", this.clientId);
        params.put("client_secret", this.clientSecret);
        params.put("redirect_uri", redirectUri);
        String body = this.api.toFormData(params);
        Request req = this.buildRequest(null, "POST", "/api/v1/oauth.exchangeAuthCode", body, "application/x-www-form-urlencoded");
        this.expect(req);
        APIResponse<Authorization> res = this.api.exchangeAuthCode(code, redirectUri);
        this.verifyRequest(req, res);
    }

    @Test public void test_refreshAccessToken() throws Exception {
        String refreshToken = this.randomString();
        HashMap<String, String> params = new HashMap<>();
        params.put("client_id", this.clientId);
        params.put("client_secret", this.clientSecret);
        params.put("refresh_token", refreshToken);
        String body = this.api.toFormData(params);
        Request req = this.buildRequest(null, "POST", "/api/v1/oauth.refreshToken", body, "application/x-www-form-urlencoded");
        this.expect(req);
        APIResponse<Authorization> res = this.api.refreshAccessToken(refreshToken);
        this.verifyRequest(req, res);
    }

    @Test public void test_verifyAccessToken() throws Exception {
        String accessToken = this.randomString();
        HashMap<String, String> params = new HashMap<>();
        params.put("access_token", accessToken);
        String body = this.api.toFormData(params);
        Request req = this.buildRequest(null, "POST", "/api/v1/oauth.verifyAccessToken", body, "application/x-www-form-urlencoded");
        this.expect(req);
        APIResponse<JsonNode> res = this.api.verifyAccessToken(accessToken);
        this.verifyRequest(req, res);
    }
}
