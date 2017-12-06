package fullcontact.contacts.api.requests.contacts;

import fullcontact.contacts.api.models.Contact;
import fullcontact.contacts.api.requests.APIRequest;
import lombok.Getter;
import lombok.Setter;

public class CreateContactRequest extends APIRequest {
    @Getter @Setter public Contact contact;
}
