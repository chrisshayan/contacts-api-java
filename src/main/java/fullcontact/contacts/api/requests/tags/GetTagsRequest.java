package fullcontact.contacts.api.requests.tags;

import fullcontact.contacts.api.requests.APIRequest;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class GetTagsRequest extends APIRequest {
    @Getter @Setter public List<String> tagIds;
}
