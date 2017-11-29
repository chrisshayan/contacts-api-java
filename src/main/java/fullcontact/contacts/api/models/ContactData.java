package fullcontact.contacts.api.models;

import fullcontact.contacts.api.models.fields.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class ContactData {
    @Getter @Setter public List<Address> addresses;
    @Getter @Setter public DateField birthday;
    @Getter @Setter public List<DateFieldWithType> dates;
    @Getter @Setter public List<StandardField> emails;
    @Getter @Setter public Name name;
    @Getter @Setter public List<StandardField> relatedPeople;
    @Getter @Setter public List<Organization> organizations;
    @Getter @Setter public List<URLField> urls;
    @Getter @Setter public String notes;
    @Getter @Setter public List<StandardField> ims;
}
