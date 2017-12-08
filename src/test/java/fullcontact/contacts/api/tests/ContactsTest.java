package fullcontact.contacts.api.tests;
import com.fasterxml.jackson.databind.JsonNode;
import com.ning.http.client.Request;
import fullcontact.contacts.api.Contacts;
import fullcontact.contacts.api.models.Contact;
import fullcontact.contacts.api.models.ContactData;
import fullcontact.contacts.api.models.fields.Name;
import fullcontact.contacts.api.requests.contacts.*;
import fullcontact.contacts.api.responses.APIResponse;
import fullcontact.contacts.api.responses.contacts.ContactResponseBody;
import fullcontact.contacts.api.responses.contacts.ContactsResponseBody;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


public class ContactsTest extends APITestBase {
    private final Contacts api;

    public ContactsTest() {
        this.api = new Contacts(this.config, this.client);
    }

    @Test public void test_get() throws Exception {
        String accessToken = this.randomString();
        GetContactsRequest gcr = new GetContactsRequest();
        List<String> contactIds = new ArrayList<>();
        contactIds.add(this.randomString());
        gcr.contactIds = contactIds;
        Request req = this.buildRequest(accessToken, "POST", "/api/v1/contacts.get", gcr.toString());
        this.expect(req);
        APIResponse<ContactsResponseBody> res = this.api.get(accessToken, contactIds, null);
        this.verifyRequest(req, res);
    }

    @Test public void test_get_team() throws Exception {
        String accessToken = this.randomString();
        String teamId = this.randomString();
        GetContactsRequest gcr = new GetContactsRequest();
        List<String> contactIds = new ArrayList<>();
        contactIds.add(this.randomString());
        contactIds.add(this.randomString());
        gcr.contactIds = contactIds;
        gcr.teamId = teamId;
        Request req = this.buildRequest(accessToken, "POST", "/api/v1/contacts.get", gcr.toString());
        this.expect(req);
        APIResponse<ContactsResponseBody> res = this.api.get(accessToken, contactIds, teamId);
        this.verifyRequest(req, res);
    }

    @Test public void test_scroll() throws Exception {
        String accessToken = this.randomString();
        ScrollContactsRequest scr = new ScrollContactsRequest();
        scr.size = 100; //default
        scr.includeDeletedContacts = false; //default
        Request req = this.buildRequest(accessToken, "POST", "/api/v1/contacts.scroll", scr.toString());
        this.expect(req);
        APIResponse<ContactsResponseBody> res = this.api.scroll(accessToken, null);
        this.verifyRequest(req, res);
    }

    @Test public void test_scroll_team() throws Exception {
        String accessToken = this.randomString();
        String teamId = this.randomString();
        ScrollContactsRequest scr = new ScrollContactsRequest();
        scr.size = 100; //default
        scr.includeDeletedContacts = false; //default
        scr.teamId = teamId;
        Request req = this.buildRequest(accessToken, "POST", "/api/v1/contacts.scroll", scr.toString());
        this.expect(req);
        APIResponse<ContactsResponseBody> res = this.api.scroll(accessToken, teamId);
        this.verifyRequest(req, res);
    }

    @Test public void test_scroll_with_team_cursor() throws Exception {
        String accessToken = this.randomString();
        String teamId = this.randomString();
        String scrollCursor = this.randomString();
        ScrollContactsRequest scr = new ScrollContactsRequest();
        scr.size = 100; //default
        scr.includeDeletedContacts = false; //default
        scr.scrollCursor = scrollCursor;
        scr.teamId = teamId;
        Request req = this.buildRequest(accessToken, "POST", "/api/v1/contacts.scroll", scr.toString());
        this.expect(req);
        APIResponse<ContactsResponseBody> res = this.api.scroll(accessToken, scrollCursor, teamId);
        this.verifyRequest(req, res);
    }

    @Test public void test_scroll_with_team_cursor_size() throws Exception {
        Integer size = 10;
        String accessToken = this.randomString();
        String teamId = this.randomString();
        String scrollCursor = this.randomString();
        ScrollContactsRequest scr = new ScrollContactsRequest();
        scr.size = size;
        scr.includeDeletedContacts = true;
        scr.scrollCursor = scrollCursor;
        scr.teamId = teamId;
        Request req = this.buildRequest(accessToken, "POST", "/api/v1/contacts.scroll", scr.toString());
        this.expect(req);
        APIResponse<ContactsResponseBody> res = this.api.scroll(accessToken, scrollCursor, true, teamId, size);
        this.verifyRequest(req, res);
    }

    @Test public void test_search() throws Exception {
        String accessToken = this.randomString();
        String query = this.randomString();
        SearchContactsRequest scr = new SearchContactsRequest();
        scr.searchQuery = query;
        Request req = this.buildRequest(accessToken, "POST", "/api/v1/contacts.search", scr.toString());
        this.expect(req);
        APIResponse<ContactsResponseBody> res = this.api.search(accessToken, query, null);
        this.verifyRequest(req, res);
    }

    @Test public void test_search_team() throws Exception {
        String accessToken = this.randomString();
        String query = this.randomString();
        String teamId = this.randomString();
        SearchContactsRequest scr = new SearchContactsRequest();
        scr.searchQuery = query;
        scr.teamId = teamId;
        Request req = this.buildRequest(accessToken, "POST", "/api/v1/contacts.search", scr.toString());
        this.expect(req);
        APIResponse<ContactsResponseBody> res = this.api.search(accessToken, query, teamId);
        this.verifyRequest(req, res);
    }

    @Test public void test_search_with_cursor() throws Exception {
        String accessToken = this.randomString();
        String query = this.randomString();
        String cursor = this.randomString();
        SearchContactsRequest scr = new SearchContactsRequest();
        scr.searchQuery = query;
        scr.searchCursor = cursor;
        Request req = this.buildRequest(accessToken, "POST", "/api/v1/contacts.search", scr.toString());
        this.expect(req);
        APIResponse<ContactsResponseBody> res = this.api.search(accessToken, query, cursor, null);
        this.verifyRequest(req, res);
    }

    @Test public void test_search_with_tag_ids() throws Exception {
        String accessToken = this.randomString();
        String query = this.randomString();
        String cursor = this.randomString();
        List<String> tagIds = new ArrayList<>();
        tagIds.add(this.randomString());
        SearchContactsRequest scr = new SearchContactsRequest();
        scr.searchQuery = query;
        scr.searchCursor = cursor;
        scr.tagIds = tagIds;
        Request req = this.buildRequest(accessToken, "POST", "/api/v1/contacts.search", scr.toString());
        this.expect(req);
        APIResponse<ContactsResponseBody> res = this.api.search(accessToken, query, cursor, null, tagIds);
        this.verifyRequest(req, res);
    }

    @Test public void test_create() throws Exception {
        String accessToken = this.randomString();
        Contact contact = new Contact();
        CreateContactRequest ccr = new CreateContactRequest();
        contact.contactData = new ContactData();
        contact.contactData.name = new Name();
        contact.contactData.name.familyName = this.randomString();
        contact.contactData.name.givenName = this.randomString();
        ccr.contact = contact;
        Request req = this.buildRequest(accessToken, "POST", "/api/v1/contacts.create", ccr.toString());
        this.expect(req);
        APIResponse<ContactResponseBody> res = this.api.create(accessToken, contact, null);
        this.verifyRequest(req, res);
    }

    @Test public void test_create_team() throws Exception {
        String accessToken = this.randomString();
        String teamId = this.randomString();
        Contact contact = new Contact();
        CreateContactRequest ccr = new CreateContactRequest();
        contact.contactData = new ContactData();
        contact.contactData.name = new Name();
        contact.contactData.name.familyName = this.randomString();
        contact.contactData.name.givenName = this.randomString();
        ccr.contact = contact;
        ccr.teamId = teamId;
        Request req = this.buildRequest(accessToken, "POST", "/api/v1/contacts.create", ccr.toString());
        this.expect(req);
        APIResponse<ContactResponseBody> res = this.api.create(accessToken, contact, teamId);
        this.verifyRequest(req, res);
    }

    @Test public void test_update() throws Exception {
        String accessToken = this.randomString();
        String contactId = this.randomString();
        String etag = this.randomString();
        Contact contact = new Contact();
        CreateContactRequest ccr = new CreateContactRequest();
        contact.contactId = contactId;
        contact.etag = etag;
        contact.contactData = new ContactData();
        contact.contactData.name = new Name();
        contact.contactData.name.familyName = this.randomString();
        contact.contactData.name.givenName = this.randomString();
        ccr.contact = contact;
        Request req = this.buildRequest(accessToken, "POST", "/api/v1/contacts.update", ccr.toString());
        this.expect(req);
        APIResponse<ContactResponseBody> res = this.api.update(accessToken, contact, null);
        this.verifyRequest(req, res);
    }

    @Test public void test_update_team() throws Exception {
        String accessToken = this.randomString();
        String teamId = this.randomString();
        String contactId = this.randomString();
        String etag = this.randomString();
        Contact contact = new Contact();
        CreateContactRequest ccr = new CreateContactRequest();
        contact.contactId = contactId;
        contact.etag = etag;
        contact.contactData = new ContactData();
        contact.contactData.name = new Name();
        contact.contactData.name.familyName = this.randomString();
        contact.contactData.name.givenName = this.randomString();
        ccr.contact = contact;
        ccr.teamId = teamId;
        Request req = this.buildRequest(accessToken, "POST", "/api/v1/contacts.update", ccr.toString());
        this.expect(req);
        APIResponse<ContactResponseBody> res = this.api.update(accessToken, contact, teamId);
        this.verifyRequest(req, res);
    }

    @Test public void test_manageTags() throws Exception {
        String accessToken = this.randomString();
        ManageTagsRequest mtr = new ManageTagsRequest();
        List<String> addTagIds = new ArrayList<>();
        List<String> removeTagIds = new ArrayList<>();
        List<String> contactIds = new ArrayList<>();
        addTagIds.add(this.randomString());
        removeTagIds.add(this.randomString());
        contactIds.add(this.randomString());
        mtr.removeTagIds = removeTagIds;
        mtr.addTagIds = addTagIds;
        mtr.contactIds = contactIds;
        Request req = this.buildRequest(accessToken, "POST", "/api/v1/contacts.manageTags", mtr.toString());
        this.expect(req);
        APIResponse<JsonNode> res = this.api.manageTags(accessToken, contactIds, addTagIds, removeTagIds, null);
        this.verifyRequest(req, res);
    }

    @Test public void test_manageTags_team() throws Exception {
        String accessToken = this.randomString();
        String teamId = this.randomString();
        ManageTagsRequest mtr = new ManageTagsRequest();
        List<String> addTagIds = new ArrayList<>();
        List<String> removeTagIds = new ArrayList<>();
        List<String> contactIds = new ArrayList<>();
        addTagIds.add(this.randomString());
        removeTagIds.add(this.randomString());
        contactIds.add(this.randomString());
        mtr.removeTagIds = removeTagIds;
        mtr.addTagIds = addTagIds;
        mtr.contactIds = contactIds;
        mtr.teamId = teamId;
        Request req = this.buildRequest(accessToken, "POST", "/api/v1/contacts.manageTags", mtr.toString());
        this.expect(req);
        APIResponse<JsonNode> res = this.api.manageTags(accessToken, contactIds, addTagIds, removeTagIds, teamId);
        this.verifyRequest(req, res);
    }

    @Test public void test_delete() throws Exception {
        String accessToken = this.randomString();
        String contactId = this.randomString();
        String etag = this.randomString();
        DeleteContactRequest dcr = new DeleteContactRequest();
        dcr.etag = etag;
        dcr.contactId = contactId;
        Request req = this.buildRequest(accessToken, "POST", "/api/v1/contacts.delete", dcr.toString());
        this.expect(req);
        APIResponse<JsonNode> res = this.api.delete(accessToken, contactId, etag, null);
        this.verifyRequest(req, res);
    }

    @Test public void test_delete_team() throws Exception {
        String accessToken = this.randomString();
        String contactId = this.randomString();
        String etag = this.randomString();
        String teamId = this.randomString();
        DeleteContactRequest dcr = new DeleteContactRequest();
        dcr.etag = etag;
        dcr.contactId = contactId;
        dcr.teamId = teamId;
        Request req = this.buildRequest(accessToken, "POST", "/api/v1/contacts.delete", dcr.toString());
        this.expect(req);
        APIResponse<JsonNode> res = this.api.delete(accessToken, contactId, etag, teamId);
        this.verifyRequest(req, res);
    }
}
