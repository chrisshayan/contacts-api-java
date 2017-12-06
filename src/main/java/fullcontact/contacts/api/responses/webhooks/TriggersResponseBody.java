package fullcontact.contacts.api.responses.webhooks;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class TriggersResponseBody {
    @Getter @Setter public List<String> triggers;
}