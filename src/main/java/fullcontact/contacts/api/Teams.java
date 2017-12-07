package fullcontact.contacts.api;

import com.ning.http.client.AsyncHttpClient;
import fullcontact.contacts.api.requests.APIRequest;
import fullcontact.contacts.api.responses.APIResponse;
import fullcontact.contacts.api.responses.teams.TeamsResponseBody;

import java.util.HashMap;

public class Teams extends API {
    public Teams(HashMap<String, Object> config) {
        super(config);
    }
    public Teams(HashMap<String, Object> config, AsyncHttpClient client) {
        super(config, client);
    }

    public APIResponse<TeamsResponseBody> get(String accessToken) throws Exception {
        return this.request(
                TeamsResponseBody.class,
                accessToken,
                "POST",
                "/api/v1/teams.get",
                new APIRequest(),
                null
        );
    }
}
