package fullcontact.contacts.api.responses.contacts;

import fullcontact.contacts.api.models.Contact;
import lombok.Getter;
import lombok.Setter;

public class ContactResponseBody {
    @Getter @Setter public Contact contact;
}
