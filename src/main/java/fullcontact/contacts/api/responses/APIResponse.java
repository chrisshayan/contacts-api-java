package fullcontact.contacts.api.responses;

import io.netty.handler.codec.http.HttpHeaders;
import org.asynchttpclient.*;
import lombok.Getter;
import lombok.Setter;

public class APIResponse<T> {
    @Getter @Setter public Request req;
    @Getter @Setter public Integer status;
    @Getter @Setter public HttpHeaders headers;
    @Getter @Setter public T body;
    @Getter @Setter public String rawBody;
}
