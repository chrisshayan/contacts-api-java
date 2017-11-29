package fullcontact.contacts.api.models;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

public class Contact {
    @Getter @Setter public String contactId;
    @Getter @Setter public String teamId;
    @Getter @Setter public String[] sharedBy;
    @Getter @Setter public String etag;
    @Getter @Setter public Date created;
    @Getter @Setter public Date updated;
    @Getter @Setter public ContactData contactData;
    @Getter @Setter public ContactMetadata contactMetadata;
}
