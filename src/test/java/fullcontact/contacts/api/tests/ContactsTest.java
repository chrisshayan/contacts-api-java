package fullcontact.contacts.api.tests;
import com.ning.http.client.Request;
import fullcontact.contacts.api.Contacts;
import fullcontact.contacts.api.requests.contacts.GetContactsRequest;
import fullcontact.contacts.api.responses.APIResponse;
import fullcontact.contacts.api.responses.contacts.ContactsResponseBody;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


public class ContactsTest extends APITestBase {
    private final Contacts api;

    public ContactsTest() {
        this.api = new Contacts(this.config, this.client);
    }

    @Test
    public void test_get() throws Exception {
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

    @Test
    public void test_get_with_team() throws Exception {
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
}
