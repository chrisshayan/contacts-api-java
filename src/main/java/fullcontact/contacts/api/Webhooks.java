package fullcontact.contacts.api;

import fullcontact.contacts.api.models.Webhook;
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
                req.toString(),
                null
        );
    }

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
                req.toString(),
                null
        );
    }

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
                req.toString(),
                null
        );
    }
    \
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
                req.toString(),
                null
        );
    }

    public APIResponse<Object> delete(String accessToken, String webhookId, String teamId) throws Exception {
        DeleteWebhookRequest req = new DeleteWebhookRequest();
        req.webhookId = webhookId;
        req.teamId = teamId;
        return this.request(
                Object.class,
                accessToken,
                "POST",
                "/api/v1/webhooks.delete",
                req.toString(),
                null
        );
    }

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
                req.toString(),
                null
        );
    }

    public APIResponse<TriggersResponseBody> getTriggers(String accessToken) throws Exception {
        return this.request(
                TriggersResponseBody.class,
                accessToken,
                "POST",
                "/api/v1/webhooks.getTriggers",
                new APIRequest().toString(),
                null
        );
    }
}
