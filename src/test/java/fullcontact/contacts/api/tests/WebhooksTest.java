package fullcontact.contacts.api.tests;
import com.fasterxml.jackson.databind.JsonNode;
import com.ning.http.client.Request;
import fullcontact.contacts.api.Webhooks;
import fullcontact.contacts.api.requests.APIRequest;
import fullcontact.contacts.api.requests.webhooks.*;
import fullcontact.contacts.api.responses.APIResponse;
import fullcontact.contacts.api.responses.webhooks.BatchesResponseBody;
import fullcontact.contacts.api.responses.webhooks.TriggersResponseBody;
import fullcontact.contacts.api.responses.webhooks.WebhookResponseBody;
import fullcontact.contacts.api.responses.webhooks.WebhooksResponseBody;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


public class WebhooksTest extends APITestBase {
    private final Webhooks api;

    public WebhooksTest() {
        this.api = new Webhooks(this.config, this.client);
    }

    @Test public void test_get() throws Exception {
        String accessToken = this.randomString();
        GetWebhooksRequest gwr = new GetWebhooksRequest();
        List<String> webhookIds = new ArrayList<>();
        webhookIds.add(this.randomString());
        gwr.webhookIds = webhookIds;
        Request req = this.buildRequest(accessToken, "POST", "/api/v1/webhooks.get", gwr.toString());
        this.expect(req);
        APIResponse<WebhooksResponseBody> res = this.api.get(accessToken, webhookIds, null, null);
        this.verifyRequest(req, res);
    }

    @Test public void test_get_with_page() throws Exception {
        String accessToken = this.randomString();
        Integer page = 10;
        GetWebhooksRequest gwr = new GetWebhooksRequest();
        List<String> webhookIds = new ArrayList<>();
        webhookIds.add(this.randomString());
        gwr.webhookIds = webhookIds;
        gwr.page = page;
        Request req = this.buildRequest(accessToken, "POST", "/api/v1/webhooks.get", gwr.toString());
        this.expect(req);
        APIResponse<WebhooksResponseBody> res = this.api.get(accessToken, webhookIds, page, null);
        this.verifyRequest(req, res);
    }

    @Test public void test_get_team() throws Exception {
        String accessToken = this.randomString();
        String teamId = this.randomString();
        GetWebhooksRequest gwr = new GetWebhooksRequest();
        List<String> webhookIds = new ArrayList<>();
        webhookIds.add(this.randomString());
        gwr.webhookIds = webhookIds;
        gwr.teamId = teamId;
        Request req = this.buildRequest(accessToken, "POST", "/api/v1/webhooks.get", gwr.toString());
        this.expect(req);
        APIResponse<WebhooksResponseBody> res = this.api.get(accessToken, webhookIds, null, teamId);
        this.verifyRequest(req, res);
    }

    @Test public void test_search() throws Exception {
        String accessToken = this.randomString();
        String url = this.randomString();
        SearchWebhooksRequest swr = new SearchWebhooksRequest();
        List<String> triggerIds = new ArrayList<>();
        triggerIds.add(this.randomString());
        swr.triggerIds = triggerIds;
        swr.url = url;
        Request req = this.buildRequest(accessToken, "POST", "/api/v1/webhooks.search", swr.toString());
        this.expect(req);
        APIResponse<WebhooksResponseBody> res = this.api.search(accessToken, url, triggerIds, null, null);
        this.verifyRequest(req, res);
    }

    @Test public void test_search_with_page() throws Exception {
        String accessToken = this.randomString();
        String url = this.randomString();
        Integer page = 7;
        SearchWebhooksRequest swr = new SearchWebhooksRequest();
        List<String> triggerIds = new ArrayList<>();
        triggerIds.add(this.randomString());
        swr.triggerIds = triggerIds;
        swr.url = url;
        swr.page = page;
        Request req = this.buildRequest(accessToken, "POST", "/api/v1/webhooks.search", swr.toString());
        this.expect(req);
        APIResponse<WebhooksResponseBody> res = this.api.search(accessToken, url, triggerIds, page, null);
        this.verifyRequest(req, res);
    }

    @Test public void test_search_team() throws Exception {
        String accessToken = this.randomString();
        String teamId = this.randomString();
        String url = this.randomString();
        SearchWebhooksRequest swr = new SearchWebhooksRequest();
        List<String> triggerIds = new ArrayList<>();
        triggerIds.add(this.randomString());
        swr.triggerIds = triggerIds;
        swr.url = url;
        swr.teamId = teamId;
        Request req = this.buildRequest(accessToken, "POST", "/api/v1/webhooks.search", swr.toString());
        this.expect(req);
        APIResponse<WebhooksResponseBody> res = this.api.search(accessToken, url, triggerIds, null, teamId);
        this.verifyRequest(req, res);
    }

    @Test public void test_create() throws Exception {
        String accessToken = this.randomString();
        String url = this.randomString();
        List<String> triggerIds = new ArrayList<>();
        triggerIds.add(this.randomString());
        CreateWebhookRequest cwr = new CreateWebhookRequest();
        cwr.url = url;
        cwr.triggerIds = triggerIds;
        Request req = this.buildRequest(accessToken, "POST", "/api/v1/webhooks.create", cwr.toString());
        this.expect(req);
        APIResponse<WebhookResponseBody> res = this.api.create(accessToken, url, triggerIds, null);
        this.verifyRequest(req, res);
    }

    @Test public void test_create_team() throws Exception {
        String accessToken = this.randomString();
        String url = this.randomString();
        String teamId = this.randomString();
        List<String> triggerIds = new ArrayList<>();
        triggerIds.add(this.randomString());
        CreateWebhookRequest cwr = new CreateWebhookRequest();
        cwr.url = url;
        cwr.triggerIds = triggerIds;
        cwr.teamId = teamId;
        Request req = this.buildRequest(accessToken, "POST", "/api/v1/webhooks.create", cwr.toString());
        this.expect(req);
        APIResponse<WebhookResponseBody> res = this.api.create(accessToken, url, triggerIds, teamId);
        this.verifyRequest(req, res);
    }

    @Test public void test_delete() throws Exception {
        String accessToken = this.randomString();
        String webhookId = this.randomString();
        DeleteWebhookRequest dwr = new DeleteWebhookRequest();
        dwr.webhookId = webhookId;
        Request req = this.buildRequest(accessToken, "POST", "/api/v1/webhooks.delete", dwr.toString());
        this.expect(req);
        APIResponse<JsonNode> res = this.api.delete(accessToken, webhookId, null);
        this.verifyRequest(req, res);
    }

    @Test public void test_delete_team() throws Exception {
        String accessToken = this.randomString();
        String webhookId = this.randomString();
        String teamId = this.randomString();
        DeleteWebhookRequest dwr = new DeleteWebhookRequest();
        dwr.webhookId = webhookId;
        dwr.teamId = teamId;
        Request req = this.buildRequest(accessToken, "POST", "/api/v1/webhooks.delete", dwr.toString());
        this.expect(req);
        APIResponse<JsonNode> res = this.api.delete(accessToken, webhookId, teamId);
        this.verifyRequest(req, res);
    }

    @Test public void test_getBatches() throws Exception {
        String accessToken = this.randomString();
        String webhookId = this.randomString();
        String batchId = this.randomString();
        GetWebhookBatchesRequest br = new GetWebhookBatchesRequest();
        br.batchId = batchId;
        br.webhookId = webhookId;
        Request req = this.buildRequest(accessToken, "POST", "/api/v1/webhooks.getBatches", br.toString());
        this.expect(req);
        APIResponse<BatchesResponseBody> res = this.api.getBatches(accessToken, webhookId, batchId, null);
        this.verifyRequest(req, res);
    }

    @Test public void test_getBatches_team() throws Exception {
        String accessToken = this.randomString();
        String webhookId = this.randomString();
        String batchId = this.randomString();
        String teamId = this.randomString();
        GetWebhookBatchesRequest br = new GetWebhookBatchesRequest();
        br.batchId = batchId;
        br.webhookId = webhookId;
        br.teamId = teamId;
        Request req = this.buildRequest(accessToken, "POST", "/api/v1/webhooks.getBatches", br.toString());
        this.expect(req);
        APIResponse<BatchesResponseBody> res = this.api.getBatches(accessToken, webhookId, batchId, teamId);
        this.verifyRequest(req, res);
    }

    @Test public void test_getTriggers() throws Exception {
        String accessToken = this.randomString();
        APIRequest r = new APIRequest();
        Request req = this.buildRequest(accessToken, "POST", "/api/v1/webhooks.getTriggers", r.toString());
        this.expect(req);
        APIResponse<TriggersResponseBody> res = this.api.getTriggers(accessToken);
        this.verifyRequest(req, res);
    }
}
