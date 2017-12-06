package fullcontact.contacts.api.requests.contacts;

import fullcontact.contacts.api.requests.APIRequest;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class GetContactsRequest extends APIRequest {
    @Getter @Setter public List<String> contactIds;
}
