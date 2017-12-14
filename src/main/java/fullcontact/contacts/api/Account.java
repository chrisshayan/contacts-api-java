package fullcontact.contacts.api;

import com.ning.http.client.AsyncHttpClient;
import fullcontact.contacts.api.requests.APIRequest;
import fullcontact.contacts.api.responses.APIResponse;

import java.util.HashMap;

public class Account extends API {
    public Account(HashMap<String, Object> config) {
        super(config);
    }
    public Account(HashMap<String, Object> config, AsyncHttpClient client) {
        super(config, client);
    }

    /***
     * Gets the user's account info and profile
     * @param accessToken
     * @return
     * @throws Exception
     */
    public APIResponse<fullcontact.contacts.api.models.Account> get(String accessToken) throws Exception {
        return this.request(
            fullcontact.contacts.api.models.Account.class,
            accessToken,
            "POST",
            "/api/v1/account.get",
                new APIRequest(),
            null
        );
    }
}
