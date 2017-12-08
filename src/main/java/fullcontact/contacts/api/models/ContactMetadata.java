package fullcontact.contacts.api.models;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class ContactMetadata {
    @Getter @Setter public String businessCardTranscriptionStatus;
    @Getter @Setter public Boolean companyContact;
    @Getter @Setter public List<String> tagIds;
}
