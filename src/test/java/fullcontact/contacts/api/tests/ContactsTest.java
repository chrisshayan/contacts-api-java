package fullcontact.contacts.api.tests;
import com.ning.http.client.Request;
import fullcontact.contacts.api.Contacts;
import fullcontact.contacts.api.models.Contact;
import fullcontact.contacts.api.requests.contacts.GetContactsRequest;
import fullcontact.contacts.api.responses.*;
import fullcontact.contacts.api.responses.contacts.ContactsResponseBody;
import org.junit.Assert;
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
        String accessToken = "Test-Token";
        GetContactsRequest gcr = new GetContactsRequest();
        List<String> contactIds = new ArrayList<>();
        contactIds.add("contact-id-test-1");
        contactIds.add("contact-id-test-2");
        gcr.contactIds = contactIds;
        Request req = this.buildRequest(accessToken, "POST", "/api/v1/contacts.get", gcr.toString());
        this.expect(req);
        APIResponse<ContactsResponseBody> res = this.api.get(accessToken, contactIds, null);
        this.verifyRequest(req, res);
    }

}
