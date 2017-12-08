package fullcontact.contacts.api.responses.contacts;

import fullcontact.contacts.api.models.Contact;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class ContactsResponseBody {
    @Getter @Setter public List<Contact> contacts;
    @Getter @Setter public String cursor;
}
