package fullcontact.contacts.api.tests;
import com.ning.http.client.Request;
import fullcontact.contacts.api.Tags;
import fullcontact.contacts.api.responses.APIResponse;
import org.junit.Assert;
import org.junit.Test;


public class TagsTest extends APITestBase {
    private final Tags api;

    public TagsTest() {
        this.api = new Tags(this.config, this.client);
    }


}
