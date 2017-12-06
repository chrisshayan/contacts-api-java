package fullcontact.contacts.api.requests.contacts;

import fullcontact.contacts.api.requests.APIRequest;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class SearchContactsRequest extends APIRequest {
    @Getter @Setter public String searchQuery;
    @Getter @Setter public String searchCursor;
    @Getter @Setter public List<String> tagIds;
}
