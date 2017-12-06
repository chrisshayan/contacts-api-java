package fullcontact.contacts.api.requests.webhooks;

import fullcontact.contacts.api.requests.APIRequest;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class SearchWebhooksRequest extends APIRequest {
    @Getter @Setter public String url;
    @Getter @Setter public Integer page;
    @Getter @Setter public List<String> triggerIds;
}
