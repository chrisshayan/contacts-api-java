package fullcontact.contacts.api.models.fields;
import lombok.Getter;
import lombok.Setter;

public class Organization {
    @Getter @Setter public String name;
    @Getter @Setter public String department;
    @Getter @Setter public String title;
    @Getter @Setter public String location;
    @Getter @Setter public String description;
    @Getter @Setter public DateField startDate;
    @Getter @Setter public DateField endDate;
}
