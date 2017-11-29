package fullcontact.contacts.api;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ning.http.client.AsyncHttpClient;
import com.ning.http.client.AsyncHttpClientConfig;
import com.ning.http.client.Response;
import com.ning.http.client.RequestBuilder;

import java.io.IOException;
import java.util.HashMap;

abstract class API {
    private final HashMap<String,Object> _config;
    private final ObjectMapper _mapper;
    private final AsyncHttpClient _client;
    private final String _baseUrl;

    public API(HashMap<String, Object> config) {
        String userAgent = (String) config.get("userAgent");
        this._config = config;
        this._baseUrl = (String) config.get("apiUrl");
        this._mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        this._client = new AsyncHttpClient(new AsyncHttpClientConfig.Builder().setUserAgent(userAgent).build());
    }

    public <T> T request(Class<T> clazz, String accessToken, String method, String uri, Object body, HashMap<String, String> headers) throws Exception {
        String json = this._mapper.writeValueAsString(body);
        return request(clazz, accessToken, method, uri, json.getBytes(), headers);
    }

    public <T> T request(Class<T> clazz, String accessToken, String method, String uri, byte[] body, HashMap<String, String> headers) throws Exception {
        RequestBuilder builder = new RequestBuilder()
                .setMethod(method)
                .setUrl(_baseUrl + uri);

        if(body != null) {
            builder.setBody(body);
        }

        if(headers != null) {
            headers.forEach(builder::addHeader);
        }

        builder.addHeader("Authorization", "Bearer " + accessToken);

        Response response = this._client.executeRequest(builder.build()).get();

        return this._mapper.readValue(response.getResponseBody(), clazz);
    }
}
