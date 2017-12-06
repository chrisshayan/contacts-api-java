package fullcontact.contacts.api.requests.tags;

import fullcontact.contacts.api.models.Tag;
import fullcontact.contacts.api.requests.APIRequest;
import lombok.Getter;
import lombok.Setter;

public class CreateTagRequest extends APIRequest {
    @Getter @Setter public Tag tag;
}
