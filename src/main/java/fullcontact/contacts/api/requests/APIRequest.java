package fullcontact.contacts.api.requests;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;

public class APIRequest {

    private final ObjectMapper _mapper;

    public APIRequest() {
        this._mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    @JsonInclude(JsonInclude.Include.NON_NULL) @Getter @Setter public String teamId;


    protected String toJSON(Object o) {
        try {
            return this._mapper.writeValueAsString(o);
        } catch(Exception ex) {
            return "Error";
        }
    }

    public String toString() {
        return this.toJSON(this);
    }
}
