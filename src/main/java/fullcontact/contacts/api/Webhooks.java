package fullcontact.contacts.api;

import com.fasterxml.jackson.databind.JsonNode;
import com.ning.http.client.AsyncHttpClient;
import fullcontact.contacts.api.requests.APIRequest;
import fullcontact.contacts.api.requests.webhooks.*;
import fullcontact.contacts.api.responses.APIResponse;
import fullcontact.contacts.api.responses.webhooks.BatchesResponseBody;
import fullcontact.contacts.api.responses.webhooks.TriggersResponseBody;
import fullcontact.contacts.api.responses.webhooks.WebhookResponseBody;
import fullcontact.contacts.api.responses.webhooks.WebhooksResponseBody;

import java.util.HashMap;
import java.util.List;

public class Webhooks extends API {

    public Webhooks(HashMap<String, Object> config) {
        super(config);
    }
    public Webhooks(HashMap<String, Object> config, AsyncHttpClient client) {
        super(config, client);
    }

    /***
     * Get a list of webhooks by their ids.
     * @param accessToken
     * @param webhookIds
     * @param page
     * @param teamId
     * @return
     * @throws Exception
     */
    public APIResponse<WebhooksResponseBody> get(String accessToken, List<String> webhookIds, Integer page, String teamId) throws Exception {
        GetWebhooksRequest req = new GetWebhooksRequest();
        req.page = page;
        req.webhookIds = webhookIds;
        req.teamId = teamId;
        return this.request(
                WebhooksResponseBody.class,
                accessToken,
                "POST",
                "/api/v1/webhooks.get",
                req,
                null
        );
    }

    /***
     * Searches existing webhooks.
     * @param accessToken
     * @param url
     * @param triggerIds
     * @param page
     * @param teamId
     * @return
     * @throws Exception
     */
    public APIResponse<WebhooksResponseBody> search(String accessToken, String url, List<String> triggerIds, Integer page, String teamId) throws Exception {
        SearchWebhooksRequest req = new SearchWebhooksRequest();
        req.page = page;
        req.url = url;
        req.triggerIds = triggerIds;
        req.teamId = teamId;
        return this.request(
                WebhooksResponseBody.class,
                accessToken,
                "POST",
                "/api/v1/webhooks.search",
                req,
                null
        );
    }

    /***
     * Creates a new webhook.
     * @param accessToken
     * @param url
     * @param triggers
     * @param teamId
     * @return
     * @throws Exception
     */
    public APIResponse<WebhookResponseBody> create(String accessToken, String url, List<String> triggers, String teamId) throws Exception {
        CreateWebhookRequest req = new CreateWebhookRequest();
        req.url = url;
        req.triggerIds = triggers;
        req.teamId = teamId;
        return this.request(
                WebhookResponseBody.class,
                accessToken,
                "POST",
                "/api/v1/webhooks.create",
                req,
                null
        );
    }

    /***
     * Deletes an existing webhook.
     * @param accessToken
     * @param webhookId
     * @param teamId
     * @return
     * @throws Exception
     */
    public APIResponse<JsonNode> delete(String accessToken, String webhookId, String teamId) throws Exception {
        DeleteWebhookRequest req = new DeleteWebhookRequest();
        req.webhookId = webhookId;
        req.teamId = teamId;
        return this.request(
                JsonNode.class,
                accessToken,
                "POST",
                "/api/v1/webhooks.delete",
                req,
                null
        );
    }

    /***
     * Get a list of webhook responses by batchId.
     * @param accessToken
     * @param webhookId
     * @param batchId
     * @param teamId
     * @return
     * @throws Exception
     */
    public APIResponse<BatchesResponseBody> getBatches(String accessToken, String webhookId, String batchId, String teamId) throws Exception {
        GetWebhookBatchesRequest req = new GetWebhookBatchesRequest();
        req.webhookId = webhookId;
        req.batchId = batchId;
        req.teamId = teamId;
        return this.request(
                BatchesResponseBody.class,
                accessToken,
                "POST",
                "/api/v1/webhooks.getBatches",
                req,
                null
        );
    }

    /***
     * Get a list of triggers that can be used to create a webhook.
     * @param accessToken
     * @return
     * @throws Exception
     */
    public APIResponse<TriggersResponseBody> getTriggers(String accessToken) throws Exception {
        return this.request(
                TriggersResponseBody.class,
                accessToken,
                "POST",
                "/api/v1/webhooks.getTriggers",
                new APIRequest(),
                null
        );
    }
}
