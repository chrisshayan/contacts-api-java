package fullcontact.contacts.api;

import fullcontact.contacts.api.responses.APIResponse;
import fullcontact.contacts.api.models.Authorization;

import java.util.HashMap;
import java.util.List;

public class OAuth extends API {
    public OAuth(HashMap<String, Object> config) {
        super(config);
    }

    public String getAuthorizationUrl(List<String> scopes, String redirectUri, String state) {
        return String.format(
                "%s/oauth/authorize?client_id=%s&scopes=%s&redirect_uri=%s&state=%s",
                this._baseUrl,
                this.urlEncode(this._clientId),
                this.urlEncode(String.join(",", scopes)),
                this.urlEncode(redirectUri),
                this.urlEncode(state)
        );
    }

    public APIResponse<Authorization> exchangeAuthCode(String code, String redirectUri) throws Exception {
        HashMap<String,String> params = new HashMap<>();
        params.put("code", code);
        params.put("client_id", this._clientId);
        params.put("client_secret", this._clientSecret);
        params.put("redirect_uri", redirectUri);

        return super.request(
                Authorization.class,
                null,
                "POST",
                "/api/v1/oauth.exchangeAuthCode",
                params,
                null
        );
    }

    public APIResponse<Authorization> refreshAccessToken(String refreshToken) throws Exception {
        HashMap<String,String> params = new HashMap<>();
        params.put("client_id", this._clientId);
        params.put("client_secret", this._clientSecret);
        params.put("refresh_token", refreshToken);

        return super.request(
                Authorization.class,
                null,
                "POST",
                "/api/v1/oauth.refreshToken",
                params,
                null
        );
    }

    public Integer verifyAccessToken(String accessToken) throws Exception {
        HashMap<String,String> params = new HashMap<>();
        params.put("access_token", accessToken);

        APIResponse res = super.request(
                Object.class,
                null,
                "POST",
                "/api/v1/oauth.exchangeAuthCode",
                params,
                null
        );

        return res.status;
    }
}
