package fullcontact.contacts.api.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

public class Tag {
    @Getter @Setter public String tagId;
    @Getter @Setter public TagData tagData;
    @Getter @Setter public String etag;
    @Getter @Setter public Date created;
    @Getter @Setter public Date updated;
}
