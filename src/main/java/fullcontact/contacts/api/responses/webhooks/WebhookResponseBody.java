package fullcontact.contacts.api.responses.webhooks;

import fullcontact.contacts.api.models.Webhook;
import lombok.Getter;
import lombok.Setter;

public class WebhookResponseBody {
    @Getter @Setter public Webhook webhook;
}
