package fullcontact.contacts.api.requests.contacts;

import fullcontact.contacts.api.requests.APIRequest;
import lombok.Getter;
import lombok.Setter;

public class ScrollContactsRequest extends APIRequest {
    @Getter @Setter public Integer size;
    @Getter @Setter public Boolean includeDeletedContacts;
    @Getter @Setter public String scrollCursor;
}
