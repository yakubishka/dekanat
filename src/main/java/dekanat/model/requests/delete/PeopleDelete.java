package dekanat.model.requests.delete;

import dekanat.model.requests.DeletUpdatable;

public class PeopleDelete implements DeletUpdatable {
  @Override
  public String getDeleteByIdRequest(long id) {
    return "delete from people where id = " + id;
  }
}
