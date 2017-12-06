package fullcontact.contacts.api.tests;
import fullcontact.contacts.api.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

public class APITest {
    private final API api;
    public APITest() {
        this.api = new Account(new HashMap<>());
    }

    @Test public void test_urlEncode() {
        String input = "Test This";
        String expected = "Test+This";
        String result = this.api.urlEncode(input);
        Assert.assertEquals(result, expected);
    }

    @Test public void test_urlEncode_null() {
        String result = this.api.urlEncode(null);
        Assert.assertNull(result);
    }
}
