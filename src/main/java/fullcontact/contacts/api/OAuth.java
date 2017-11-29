package fullcontact.contacts.api;

import java.util.HashMap;
import java.util.List;

public class OAuth extends API {
    public OAuth(HashMap<String, Object> config) {
        super(config);
    }

    public String getAuthorizationUrl(String clientId, List<String> scopes, String redirectUri, String state) {
        return String.format(
                "%s/oauth/authorize?client_id=%s&scopes=%s&redirect_uri=%s&state=%s",
                this._baseUrl,
                clientId,
                String.join(",", scopes),
                redirectUri,
                state
        );
    }


}
