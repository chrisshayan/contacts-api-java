package fullcontact.contacts.api.models;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

public class Webhook {
    @Getter @Setter public String webhookId;
    @Getter @Setter public String url;
    @Getter @Setter public List<String> triggers;
    @Getter @Setter public Date created;
    @Getter @Setter public String accountId;
}
