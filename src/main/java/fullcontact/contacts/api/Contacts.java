package fullcontact.contacts.api;

import fullcontact.contacts.api.requests.contacts.GetContactsRequest;
import fullcontact.contacts.api.requests.contacts.ScrollContactsRequest;
import fullcontact.contacts.api.requests.contacts.SearchContactsRequest;
import fullcontact.contacts.api.responses.APIResponse;
import fullcontact.contacts.api.models.Contact;
import fullcontact.contacts.api.responses.CursorResponseBody;
import fullcontact.contacts.api.responses.contacts.ContactsResponseBody;

import java.util.HashMap;
import java.util.List;

public class Contacts extends API {

    public Contacts(HashMap<String, Object> config) {
        super(config);
    }

    public APIResponse<ContactsResponseBody> get(String accessToken, List<String> contactIds, String teamId) throws Exception {
        GetContactsRequest req = new GetContactsRequest();
        req.teamId = teamId;
        req.contactIds = contactIds;
        return this.request(
                ContactsResponseBody.class,
                accessToken,
                "POST",
                "/api/v1/contacts.get",
                req.toString(),
                null
        );
    }

    public APIResponse<ContactsResponseBody> scroll(String accessToken, String teamId) throws Exception {
        return scroll(accessToken, null, false, teamId, 100);
    }

    public APIResponse<ContactsResponseBody> scroll(String accessToken, String cursor, String teamId) throws Exception {
        return scroll(accessToken, cursor, false, teamId, 100);
    }

    public APIResponse<ContactsResponseBody> scroll(String accessToken, String cursor, Boolean includeDeleted, String teamId, Integer size) throws Exception {
        ScrollContactsRequest req = new ScrollContactsRequest();
        req.scrollCursor = cursor;
        req.includeDeletedContacts = includeDeleted;
        req.teamId = teamId;
        req.size = size;
        return this.request(
                ContactsResponseBody.class,
                accessToken,
                "POST",
                "/api/v1/contacts.scroll",
                req.toString(),
                null
        );
    }

    public APIResponse<ContactsResponseBody> search(String accessToken, String query, String teamId) throws Exception {
        return search(accessToken, query, teamId, null, null);
    }

    public APIResponse<ContactsResponseBody> search(String accessToken, String query, String cursor, String teamId) throws Exception {
        return search(accessToken, query, cursor, teamId, null);
    }

    public APIResponse<ContactsResponseBody> search(String accessToken, String query, String cursor, String teamId, List<String> tagIds) throws Exception {
        SearchContactsRequest req = new SearchContactsRequest();
        req.searchCursor = cursor;
        req.tagIds = tagIds;
        req.teamId = teamId;
        req.searchQuery = query;
        return this.request(
                ContactsResponseBody.class,
                accessToken,
                "POST",
                "/api/v1/contacts.search",
                req.toString(),
                null
        );
    }
}