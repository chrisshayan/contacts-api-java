package fullcontact.contacts.api.models.fields;
import lombok.Getter;
import lombok.Setter;

public class Name {
    @Getter @Setter public String givenName;
    @Getter @Setter public String familyName;
    @Getter @Setter public String middleName;
    @Getter @Setter public String prefix;
    @Getter @Setter public String suffix;
}
