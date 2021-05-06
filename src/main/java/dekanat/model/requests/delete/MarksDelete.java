package dekanat.model.requests.delete;

import dekanat.model.requests.DeletUpdatable;

public class MarksDelete implements DeletUpdatable {
  @Override
  public String getDeleteByIdRequest(long id) {
    return "delete from marks where id = " + id;
  }
}
