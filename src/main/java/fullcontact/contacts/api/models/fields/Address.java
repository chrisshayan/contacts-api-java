package fullcontact.contacts.api.models.fields;
import lombok.Getter;
import lombok.Setter;

public class Address {
    @Getter @Setter public String type;
    @Getter @Setter public String street;
    @Getter @Setter public String city;
    @Getter @Setter public String region;
    @Getter @Setter public String postalCode;
    @Getter @Setter public String country;
    @Getter @Setter public String extendedAddress;
}
