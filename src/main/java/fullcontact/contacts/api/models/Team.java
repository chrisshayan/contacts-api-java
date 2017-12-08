package fullcontact.contacts.api.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

public class Team {
    @Getter @Setter public String teamId;
    @Getter @Setter public TeamData teamData;
    @Getter @Setter public List<String> teamMembers;
    @Getter @Setter public Date created;
    @Getter @Setter public Date updated;
}
