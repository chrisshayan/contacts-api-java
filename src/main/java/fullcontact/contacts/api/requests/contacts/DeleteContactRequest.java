package fullcontact.contacts.api.requests.contacts;

import fullcontact.contacts.api.requests.APIRequest;
import lombok.Getter;
import lombok.Setter;

public class DeleteContactRequest extends APIRequest {
    @Getter @Setter public String contactId;
    @Getter @Setter public String etag;
}
