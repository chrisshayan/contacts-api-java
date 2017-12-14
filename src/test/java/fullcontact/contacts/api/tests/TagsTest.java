package fullcontact.contacts.api.tests;
import com.fasterxml.jackson.databind.JsonNode;
import org.asynchttpclient.*;
import fullcontact.contacts.api.Tags;
import fullcontact.contacts.api.models.Tag;
import fullcontact.contacts.api.models.TagData;
import fullcontact.contacts.api.requests.tags.*;
import fullcontact.contacts.api.responses.APIResponse;
import fullcontact.contacts.api.responses.tags.TagResponseBody;
import fullcontact.contacts.api.responses.tags.TagsResponseBody;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


public class TagsTest extends APITestBase {
    private final Tags api;

    public TagsTest() {
        this.api = new Tags(this.config, this.client);
    }

    @Test public void test_get() throws Exception {
        String accessToken = this.randomString();
        GetTagsRequest gtr = new GetTagsRequest();
        List<String> tagIds = new ArrayList<>();
        tagIds.add(this.randomString());
        gtr.tagIds = tagIds;
        Request req = this.buildRequest(accessToken, "POST", "/api/v1/tags.get", gtr.toString());
        this.expect(req);
        APIResponse<TagsResponseBody> res = this.api.get(accessToken, tagIds, null);
        this.verifyRequest(req, res);
    }

    @Test public void test_get_team() throws Exception {
        String accessToken = this.randomString();
        String teamId = this.randomString();
        GetTagsRequest gtr = new GetTagsRequest();
        List<String> tagIds = new ArrayList<>();
        tagIds.add(this.randomString());
        gtr.tagIds = tagIds;
        gtr.teamId = teamId;
        Request req = this.buildRequest(accessToken, "POST", "/api/v1/tags.get", gtr.toString());
        this.expect(req);
        APIResponse<TagsResponseBody> res = this.api.get(accessToken, tagIds, teamId);
        this.verifyRequest(req, res);
    }

    @Test public void test_scroll() throws Exception {
        String accessToken = this.randomString();
        ScrollTagsRequest str = new ScrollTagsRequest();
        str.size = 100; //default
        str.includeDeletedTags = false; //default
        Request req = this.buildRequest(accessToken, "POST", "/api/v1/tags.scroll", str.toString());
        this.expect(req);
        APIResponse<TagsResponseBody> res = this.api.scroll(accessToken, null);
        this.verifyRequest(req, res);
    }

    @Test public void test_scroll_team() throws Exception {
        String accessToken = this.randomString();
        String teamId = this.randomString();
        ScrollTagsRequest str = new ScrollTagsRequest();
        str.size = 100; //default
        str.includeDeletedTags = false; //default
        str.teamId = teamId;
        Request req = this.buildRequest(accessToken, "POST", "/api/v1/tags.scroll", str.toString());
        this.expect(req);
        APIResponse<TagsResponseBody> res = this.api.scroll(accessToken, teamId);
        this.verifyRequest(req, res);
    }

    @Test public void test_scroll_with_team_cursor() throws Exception {
        String accessToken = this.randomString();
        String teamId = this.randomString();
        String scrollCursor = this.randomString();
        ScrollTagsRequest str = new ScrollTagsRequest();
        str.size = 100; //default
        str.includeDeletedTags = false; //default
        str.scrollCursor = scrollCursor;
        str.teamId = teamId;
        Request req = this.buildRequest(accessToken, "POST", "/api/v1/tags.scroll", str.toString());
        this.expect(req);
        APIResponse<TagsResponseBody> res = this.api.scroll(accessToken, scrollCursor, teamId);
        this.verifyRequest(req, res);
    }

    @Test public void test_scroll_with_team_cursor_size() throws Exception {
        Integer size = 10;
        String accessToken = this.randomString();
        String teamId = this.randomString();
        String scrollCursor = this.randomString();
        ScrollTagsRequest str = new ScrollTagsRequest();
        str.size = size;
        str.includeDeletedTags = true;
        str.scrollCursor = scrollCursor;
        str.teamId = teamId;
        Request req = this.buildRequest(accessToken, "POST", "/api/v1/tags.scroll", str.toString());
        this.expect(req);
        APIResponse<TagsResponseBody> res = this.api.scroll(accessToken, scrollCursor, true, teamId, size);
        this.verifyRequest(req, res);
    }

    @Test public void test_create() throws Exception {
        String accessToken = this.randomString();
        Tag tag = new Tag();
        CreateTagRequest ctr = new CreateTagRequest();
        tag.tagData = new TagData();
        tag.tagData.name = this.randomString();
        ctr.tag = tag;
        Request req = this.buildRequest(accessToken, "POST", "/api/v1/tags.create", ctr.toString());
        this.expect(req);
        APIResponse<TagResponseBody> res = this.api.create(accessToken, tag, null);
        this.verifyRequest(req, res);
    }

    @Test public void test_create_team() throws Exception {
        String accessToken = this.randomString();
        String teamId = this.randomString();
        Tag tag = new Tag();
        CreateTagRequest ctr = new CreateTagRequest();
        tag.tagData = new TagData();
        tag.tagData.name = this.randomString();
        ctr.tag = tag;
        ctr.teamId = teamId;
        Request req = this.buildRequest(accessToken, "POST", "/api/v1/tags.create", ctr.toString());
        this.expect(req);
        APIResponse<TagResponseBody> res = this.api.create(accessToken, tag, teamId);
        this.verifyRequest(req, res);
    }

    @Test public void test_udpate() throws Exception {
        String accessToken = this.randomString();
        Tag tag = new Tag();
        UpdateTagRequest utr = new UpdateTagRequest();
        tag.tagData = new TagData();
        tag.tagData.name = this.randomString();
        tag.tagId = this.randomString();
        utr.tag = tag;
        Request req = this.buildRequest(accessToken, "POST", "/api/v1/tags.update", utr.toString());
        this.expect(req);
        APIResponse<TagResponseBody> res = this.api.update(accessToken, tag, null);
        this.verifyRequest(req, res);
    }

    @Test public void test_update_team() throws Exception {
        String accessToken = this.randomString();
        String teamId = this.randomString();
        Tag tag = new Tag();
        UpdateTagRequest utr = new UpdateTagRequest();
        tag.tagId = this.randomString();
        tag.tagData = new TagData();
        tag.tagData.name = this.randomString();
        utr.tag = tag;
        utr.teamId = teamId;
        Request req = this.buildRequest(accessToken, "POST", "/api/v1/tags.update", utr.toString());
        this.expect(req);
        APIResponse<TagResponseBody> res = this.api.update(accessToken, tag, teamId);
        this.verifyRequest(req, res);
    }

    @Test public void test_delete() throws Exception {
        String accessToken = this.randomString();
        String tagId = this.randomString();
        String etag = this.randomString();
        DeleteTagRequest dtr = new DeleteTagRequest();
        dtr.etag = etag;
        dtr.tagId = tagId;
        Request req = this.buildRequest(accessToken, "POST", "/api/v1/tags.delete", dtr.toString());
        this.expect(req);
        APIResponse<JsonNode> res = this.api.delete(accessToken, tagId, etag, null);
        this.verifyRequest(req, res);
    }

    @Test public void test_delete_team() throws Exception {
        String accessToken = this.randomString();
        String tagId = this.randomString();
        String etag = this.randomString();
        String teamId = this.randomString();
        DeleteTagRequest dtr = new DeleteTagRequest();
        dtr.etag = etag;
        dtr.tagId = tagId;
        dtr.teamId = teamId;
        Request req = this.buildRequest(accessToken, "POST", "/api/v1/tags.delete", dtr.toString());
        this.expect(req);
        APIResponse<JsonNode> res = this.api.delete(accessToken, tagId, etag, teamId);
        this.verifyRequest(req, res);
    }
}
