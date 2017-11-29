package fullcontact.contacts.api.models;

import com.ning.http.client.FluentCaseInsensitiveStringsMap;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;

public class APIResponse<T> {
    @Getter @Setter public Integer status;
    @Getter @Setter public FluentCaseInsensitiveStringsMap headers;
    @Getter @Setter public T body;
}
