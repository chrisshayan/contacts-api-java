package fullcontact.contacts.api.requests.webhooks;

import fullcontact.contacts.api.requests.APIRequest;
import lombok.Getter;
import lombok.Setter;

public class GetWebhookBatchesRequest extends APIRequest {
    @Getter @Setter public String webhookId;
    @Getter @Setter public String batchId;
}
