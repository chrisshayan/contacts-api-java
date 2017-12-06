package fullcontact.contacts.api.responses.tags;

import fullcontact.contacts.api.models.Tag;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class TagsResponseBody {
    @Getter @Setter public List<Tag> tags;
    @Getter @Setter public String cursor;
}
