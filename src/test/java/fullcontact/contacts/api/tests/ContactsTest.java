package fullcontact.contacts.api.tests;
import com.ning.http.client.Request;
import fullcontact.contacts.api.Contacts;
import fullcontact.contacts.api.responses.APIResponse;
import org.junit.Assert;
import org.junit.Test;


public class ContactsTest extends APITestBase {
    private final Contacts api;

    public ContactsTest() {
        this.api = new Contacts(this.config, this.client);
    }


}
