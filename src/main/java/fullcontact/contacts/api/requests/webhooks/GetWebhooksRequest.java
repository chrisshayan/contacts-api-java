package fullcontact.contacts.api.requests.webhooks;

import fullcontact.contacts.api.requests.APIRequest;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class GetWebhooksRequest extends APIRequest {
    @Getter @Setter public List<String> webhookIds;
    @Getter @Setter public Integer page;
}
