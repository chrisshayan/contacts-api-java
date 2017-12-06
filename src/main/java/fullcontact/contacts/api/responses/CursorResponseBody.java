package fullcontact.contacts.api.responses;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class CursorResponseBody<T> {
    @Getter @Setter public String cursor;
    @Getter @Setter public List<T> items;
}
