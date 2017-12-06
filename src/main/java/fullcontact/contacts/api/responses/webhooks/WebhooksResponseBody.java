package fullcontact.contacts.api.responses.webhooks;

import fullcontact.contacts.api.models.Webhook;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class WebhooksResponseBody {
    @Getter @Setter public List<Webhook> webhooks;
}
