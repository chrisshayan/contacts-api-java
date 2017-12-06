package fullcontact.contacts.api;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ning.http.client.AsyncHttpClient;
import com.ning.http.client.AsyncHttpClientConfig;
import com.ning.http.client.Response;
import com.ning.http.client.RequestBuilder;
import fullcontact.contacts.api.responses.APIResponse;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;

abstract class API {
    private final HashMap<String,Object> _config;
    private final ObjectMapper _mapper;
    private final AsyncHttpClient _client;
    protected final String _baseUrl;
    protected final String _clientId;
    protected final String _clientSecret;

    public API(HashMap<String, Object> config) {
        String userAgent = (String) config.get("userAgent");
        this._config = config;
        this._baseUrl = (String) config.get("apiUrl");
        this._clientId = (String) config.get("clientId");
        this._clientSecret = (String) config.get("clientSecret");
        this._mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        this._client = new AsyncHttpClient(new AsyncHttpClientConfig.Builder().setUserAgent(userAgent).build());
    }

    protected String urlEncode(String v) {
        if(v == null) {
            return null;
        }

        try {
            return URLEncoder.encode(v, "utf8");
        } catch(UnsupportedEncodingException ex) {
            return v;
        }
    }

    protected String toJSON(Object o) throws Exception {
        return this._mapper.writeValueAsString(o);
    }

    public <T> APIResponse<T> request(Class<T> clazz, String accessToken, String method, String uri, HashMap<String,String> form, HashMap<String, String> headers) throws Exception {
        StringBuilder sb = new StringBuilder();

        form.forEach((k,v) -> sb.append(String.format("%s=%s", k, this.urlEncode(v))));

        if(headers == null) {
            headers = new HashMap<>();
        }

        headers.put("Content-Type", "application/x-www-form-urlencoded");
        return request(clazz, accessToken, method, uri, sb.toString().getBytes(), headers);
    }

    public <T> APIResponse<T> request(Class<T> clazz, String accessToken, String method, String uri, Object body, HashMap<String, String> headers) throws Exception {
        String json = this.toJSON(body);

        if(headers == null) {
            headers = new HashMap<>();
        }

        headers.put("Content-Type", "application/json");

        return request(clazz, accessToken, method, uri, json.getBytes(), headers);
    }

    public <T> APIResponse<T> request(Class<T> clazz, String accessToken, String method, String uri, byte[] body, HashMap<String, String> headers) throws Exception {
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

        APIResponse res = new APIResponse();
        res.body = this._mapper.readValue(response.getResponseBody(), clazz);
        res.status = response.getStatusCode();
        res.headers = response.getHeaders();
        return res;
    }
}
