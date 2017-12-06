package fullcontact.contacts.api.responses.teams;

import fullcontact.contacts.api.models.Team;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class TeamsResponseBody {
    @Getter @Setter List<Team> teams;
}
