package fullcontact.contacts.api.requests.webhooks;

import fullcontact.contacts.api.requests.APIRequest;
import lombok.Getter;
import lombok.Setter;

public class DeleteWebhookRequest extends APIRequest {
    @Getter @Setter public String webhookId;
}
