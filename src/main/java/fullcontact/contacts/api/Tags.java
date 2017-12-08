package fullcontact.contacts.api;

import com.fasterxml.jackson.databind.JsonNode;
import com.ning.http.client.AsyncHttpClient;
import fullcontact.contacts.api.models.Tag;
import fullcontact.contacts.api.requests.tags.*;
import fullcontact.contacts.api.responses.APIResponse;
import fullcontact.contacts.api.responses.tags.TagResponseBody;
import fullcontact.contacts.api.responses.tags.TagsResponseBody;

import java.util.HashMap;
import java.util.List;

public class Tags extends API {

    public Tags(HashMap<String, Object> config) {
        super(config);
    }
    public Tags(HashMap<String, Object> config, AsyncHttpClient client) {
        super(config, client);
    }

    public APIResponse<TagsResponseBody> get(String accessToken, List<String> tagIds, String teamId) throws Exception {
        GetTagsRequest req = new GetTagsRequest();
        req.teamId = teamId;
        req.tagIds = tagIds;
        return this.request(
                TagsResponseBody.class,
                accessToken,
                "POST",
                "/api/v1/tags.get",
                req,
                null
        );
    }

    public APIResponse<TagsResponseBody> scroll(String accessToken, String teamId) throws Exception {
        return scroll(accessToken, null, false, teamId, 100);
    }

    public APIResponse<TagsResponseBody> scroll(String accessToken, String cursor, String teamId) throws Exception {
        return scroll(accessToken, cursor, false, teamId, 100);
    }

    public APIResponse<TagsResponseBody> scroll(String accessToken, String cursor, Boolean includeDeleted, String teamId, Integer size) throws Exception {
        ScrollTagsRequest req = new ScrollTagsRequest();
        req.scrollCursor = cursor;
        req.includeDeletedTags = includeDeleted;
        req.teamId = teamId;
        req.size = size;
        return this.request(
                TagsResponseBody.class,
                accessToken,
                "POST",
                "/api/v1/tags.scroll",
                req,
                null
        );
    }

    public APIResponse<TagResponseBody> create(String accessToken, Tag tag, String teamId) throws Exception {
        CreateTagRequest req = new CreateTagRequest();
        req.tag = tag;
        req.teamId = teamId;
        return this.request(
                TagResponseBody.class,
                accessToken,
                "POST",
                "/api/v1/tags.create",
                req,
                null
        );
    }

    public APIResponse<TagResponseBody> update(String accessToken, Tag tag, String teamId) throws Exception {
        UpdateTagRequest req = new UpdateTagRequest();
        req.tag = tag;
        req.teamId = teamId;
        return this.request(
                TagResponseBody.class,
                accessToken,
                "POST",
                "/api/v1/tags.update",
                req,
                null
        );
    }

    public APIResponse<JsonNode> delete(String accessToken, String tagId, String etag, String teamId) throws Exception {
        DeleteTagRequest req = new DeleteTagRequest();
        req.tagId = tagId;
        req.etag = etag;
        req.teamId = teamId;
        return this.request(
                JsonNode.class,
                accessToken,
                "POST",
                "/api/v1/tags.delete",
                req,
                null
        );
    }
}