package fullcontact.contacts.api.models.fields;

import lombok.Getter;
import lombok.Setter;

public class DateFieldWithType extends DateField {
    public DateFieldWithType() {
        super();
    }

    @Getter @Setter public String type;
}
