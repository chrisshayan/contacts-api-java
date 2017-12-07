package fullcontact.contacts.api.tests;

import com.ning.http.client.*;
import fullcontact.contacts.api.responses.APIResponse;
import org.junit.Assert;

import java.util.HashMap;

import static org.mockito.Mockito.*;

public class APITestBase {
    protected final AsyncHttpClient client;
    protected final HashMap<String,Object> config;

    public APITestBase() {
        this.config = new HashMap<>();
        this.config.put("apiUrl", this.getApiUrl());
        this.client = mock(AsyncHttpClient.class);
    }

    protected String getApiUrl() {
        return "https://app.fullcontact.com";
    }

    protected Request buildRequest(String accessToken, String method, String path, String body) {
        return buildRequest(accessToken, method, path, body, "application/json");
    }

    protected Request buildRequest(String accessToken, String method, String path, String body, String contentType) {
        RequestBuilder builder = new RequestBuilder()
                .setMethod(method)
                .setUrl(String.format("%s%s", this.getApiUrl(), path))
                .setBody(body);

        builder.addHeader("Content-Type", contentType);

        if(accessToken != null) {
            builder.addHeader("Authorization", "Bearer " + accessToken);
        }

        return builder.build();
    }

    protected ListenableFuture<Response> getMockResponse() {
        return new MockListenableFutureResponse();
    }

    protected ListenableFuture<Response> getMockResponse(Integer status, String body, HashMap<String, String> headers) {
        return new MockListenableFutureResponse(status, body, headers);
    }

    protected void expect(Request req) throws Exception {
        when(this.client.executeRequest(
                any(Request.class)
        ))
                .thenReturn(this.getMockResponse());
    }

    protected void expect(Request req, Integer status, String body, HashMap<String,String> headers) throws Exception {

        if(body == null) {
            body = "{}";
        }

        when(this.client.executeRequest(
                any(Request.class)
        ))
                .thenReturn(this.getMockResponse(status, body, headers));
    }

    protected void validate() throws Exception {
        validate(1);
    }

    protected void validate(Integer times) throws Exception {
        verify(this.client, times(times)).executeRequest(any(Request.class));
    }

    protected void verifyRequest(Request req, APIResponse res) {
        Assert.assertEquals(res.req.toString(), req.toString());
    }
}



