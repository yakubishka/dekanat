package dekanat.model.requests.insert;

import dekanat.model.db.People;
import dekanat.model.requests.select.PeopleSelect;

public class PeopleInsert extends PeopleSelect {

  private final People people;

  public PeopleInsert(People people) {
    this.people = people;
  }

  @Override
  public String getSelectRequest() {
    return "with inserted as (insert into \"people\" (\"first_name\", \"last_name\", \"father_name\", \"group_id\", \"type\") " +
        " values ('" + people.getFirstName() + "', " +
        "'" + people.getLastName() + "', " +
        "'" + people.getFirstName() + "', " +
        "" + people.getGroupId() + ", " +
        "'" + people.getType() + "') returning * ) select inserted.*, groups.name as group_name from inserted" +
        " inner join groups on groups.id = inserted.group_id";
  }

}
