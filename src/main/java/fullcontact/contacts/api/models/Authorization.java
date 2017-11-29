package fullcontact.contacts.api.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

public class Authorization {
    @Getter @Setter public String accessToken;
    @Getter @Setter public String refreshToken;
    @Getter @Setter public Date accessTokenExpiration;
    @Getter @Setter public Date refreshTokenExpiration;
    @Getter @Setter public String scope;
}
