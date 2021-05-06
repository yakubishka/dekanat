package dekanat.model.requests.insert;


import dekanat.model.db.Groups;
import dekanat.model.requests.select.GroupsSelect;;

public class GroupInsert extends GroupsSelect {

  private final Groups group;

  public GroupInsert(Groups group) {
    this.group = group;
  }

  @Override
  public String getSelectRequest() {
    return "insert into \"groups\" (\"name\") values ('" + group.getName() + "') returning *;";
  }
}
