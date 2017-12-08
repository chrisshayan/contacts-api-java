package fullcontact.contacts.api;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ning.http.client.*;
import fullcontact.contacts.api.responses.APIResponse;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;

public abstract class API {
    private final HashMap<String,Object> _config;
    private final ObjectMapper _mapper;
    private final AsyncHttpClient _client;
    protected final String _baseUrl;
    protected final String _clientId;
    protected final String _clientSecret;

    public API(HashMap<String, Object> config) {
        this(
                config,
                new AsyncHttpClient(
                        new AsyncHttpClientConfig.Builder()
                                .setUserAgent((String) config.get("userAgent"))
                                .build()
                )
        );
    }

    public API(HashMap<String, Object> config, AsyncHttpClient client) {
        this._config = config;
        this._baseUrl = (String) config.get("apiUrl");
        this._clientId = (String) config.get("clientId");
        this._clientSecret = (String) config.get("clientSecret");
        this._mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        this._client = client;
    }

    public String urlEncode(String v) {
        if(v == null) {
            return null;
        }

        try {
            return URLEncoder.encode(v, "utf8");
        } catch(UnsupportedEncodingException ex) {
            return v;
        }
    }

    public String toJSON(Object o) throws Exception {
        return this._mapper.writeValueAsString(o);
    }

    public String toFormData(HashMap<String, String> form) {
        StringBuilder sb = new StringBuilder();
        form.forEach((k,v) -> sb.append(String.format("%s=%s", k, this.urlEncode(v))));
        return sb.toString();
    }

    public <T> APIResponse<T> request(Class<T> clazz, String accessToken, String method, String uri, HashMap<String,String> form, HashMap<String, String> headers) throws Exception {
        if(headers == null) {
            headers = new HashMap<>();
        }

        headers.put("Content-Type", "application/x-www-form-urlencoded");
        return request(clazz, accessToken, method, uri, this.toFormData(form), headers);
    }

    public <T> APIResponse<T> request(Class<T> clazz, String accessToken, String method, String uri, Object body, HashMap<String, String> headers) throws Exception {
        String json = this.toJSON(body);

        if(headers == null) {
            headers = new HashMap<>();
        }

        headers.put("Content-Type", "application/json");

        return request(clazz, accessToken, method, uri, json, headers);
    }

    public <T> APIResponse<T> request(Class<T> clazz, String accessToken, String method, String uri, String body, HashMap<String, String> headers) throws Exception {
        RequestBuilder builder = new RequestBuilder()
                .setMethod(method)
                .setUrl(_baseUrl + uri);

        if(body != null) {
            builder.setBody(body);
        }

        if(headers != null) {
            headers.forEach(builder::addHeader);
        }

        if(accessToken != null) {
            builder.addHeader("Authorization", "Bearer " + accessToken);
        }

        Request req = builder.build();
        Response response = this._client.executeRequest(req).get();

        APIResponse res = new APIResponse();
        res.req = req;
        res.body = this._mapper.readValue(response.getResponseBody(), clazz);
        res.status = response.getStatusCode();
        res.headers = response.getHeaders();
        return res;
    }
}
