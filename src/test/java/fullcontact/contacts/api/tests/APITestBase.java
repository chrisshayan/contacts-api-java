package fullcontact.contacts.api.tests;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.asynchttpclient.*;
import fullcontact.contacts.api.responses.APIResponse;
import org.junit.Assert;

import java.io.IOException;
import java.util.HashMap;
import java.util.UUID;

import static org.mockito.Mockito.*;

public class APITestBase {
    protected final AsyncHttpClient client;
    protected final HashMap<String,Object> config;
    private final ObjectMapper mapper;

    public APITestBase() {
        this.config = new HashMap<>();
        this.config.put("apiUrl", this.getApiUrl());
        this.client = mock(AsyncHttpClient.class);
        this.mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    protected String toJSON(Object obj) {
        try {
            return this.mapper.writeValueAsString(obj);
        } catch (Exception ex) {
            return null;
        }
    }

    protected String randomString() {
        return UUID.randomUUID().toString();
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


    protected void verifyRequest(Request req, APIResponse res) throws IOException {
        verify(this.client, times(1)).executeRequest(any(Request.class));
        Assert.assertEquals(res.req.getUrl(), req.getUrl());
        Assert.assertEquals(res.req.getMethod(), req.getMethod());
        Assert.assertEquals(res.req.getStringData(), req.getStringData());
        res.req.getHeaders().entries().forEach(e -> Assert.assertTrue(req.getHeaders().get(e.getKey()).equals(e.getValue())));
    }
}



