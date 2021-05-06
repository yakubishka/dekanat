package dekanat.model.requests.delete;

import dekanat.model.db.Groups;
import dekanat.model.requests.DeletUpdatable;

public class GroupsDelete implements DeletUpdatable<Groups> {
  @Override
  public String getDeleteByIdRequest(Groups item) {
    return "delete from groups where id = " + item.getId();
  }
}
