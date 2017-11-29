package fullcontact.contacts.api.models.fields;
import lombok.Getter;
import lombok.Setter;

public class URLField {
    @Getter @Setter public String type;
    @Getter @Setter public String value;
    @Getter @Setter public String username;
    @Getter @Setter public String userId;
}
