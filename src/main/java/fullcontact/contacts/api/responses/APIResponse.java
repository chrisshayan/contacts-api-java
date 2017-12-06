package fullcontact.contacts.api.responses;

import com.ning.http.client.FluentCaseInsensitiveStringsMap;
import lombok.Getter;
import lombok.Setter;

public class APIResponse<T> {
    @Getter @Setter public Integer status;
    @Getter @Setter public FluentCaseInsensitiveStringsMap headers;
    @Getter @Setter public T body;
}
