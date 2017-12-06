package fullcontact.contacts.api.requests.tags;

import fullcontact.contacts.api.requests.APIRequest;
import lombok.Getter;
import lombok.Setter;

public class ScrollTagsRequest extends APIRequest {
    @Getter @Setter public Integer size;
    @Getter @Setter public Boolean includeDeletedTags;
    @Getter @Setter public String scrollCursor;
}
