package dekanat.model.requests.delete;

import dekanat.model.requests.DeletUpdatable;

public class GroupsDelete implements DeletUpdatable {
  @Override
  public String getDeleteByIdRequest(long id) {
    return "delete from groups where id = " + id;
  }
}
