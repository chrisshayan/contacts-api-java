package fullcontact.contacts.api.models;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

public class Account {
    @Getter @Setter public String accountId;
    @Getter @Setter public Date created;
    @Getter @Setter public Date updated;
    @Getter @Setter public ContactData profileData;
}
