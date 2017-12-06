package fullcontact.contacts.api.requests.tags;

import fullcontact.contacts.api.requests.APIRequest;
import lombok.Getter;
import lombok.Setter;

public class DeleteTagRequest extends APIRequest {
    @Getter @Setter public String tagId;
    @Getter @Setter public String etag;
}
