package fullcontact.contacts.api.models.fields;
import lombok.Getter;
import lombok.Setter;

public class DateField {
    @Getter @Setter public Integer month;
    @Getter @Setter public Integer day;
    @Getter @Setter public Integer year;
}

