package fullcontact.contacts.api;

import org.asynchttpclient.*;
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

    /***
     * Get a list of teams that the user belongs to.
     * @param accessToken
     * @return
     * @throws Exception
     */
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
