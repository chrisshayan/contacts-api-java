package fullcontact.contacts.api;

import fullcontact.contacts.api.models.APIResponse;

import java.util.HashMap;

public class Account extends API {
    public Account(HashMap<String, Object> config) {
        super(config);
    }

    public APIResponse<fullcontact.contacts.api.models.Account> get(String accessToken) throws Exception {
        return this.request(
            fullcontact.contacts.api.models.Account.class,
            accessToken,
            "POST",
            "/api/v1/account,get",
            "".getBytes(),
            null
        );
    }
}
