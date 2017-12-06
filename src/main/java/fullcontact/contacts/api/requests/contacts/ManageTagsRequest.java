package fullcontact.contacts.api.requests.contacts;

import fullcontact.contacts.api.requests.APIRequest;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class ManageTagsRequest extends APIRequest {
    @Getter @Setter public List<String> contactIds;
    @Getter @Setter public List<String> addTagIds;
    @Getter @Setter public List<String> removeTagIds;
}
