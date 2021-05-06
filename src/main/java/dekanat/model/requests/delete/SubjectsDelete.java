package dekanat.model.requests.delete;

import dekanat.model.requests.DeletUpdatable;

public class SubjectsDelete implements DeletUpdatable {
  @Override
  public String getDeleteByIdRequest(long id) {
    return "delete from subjects where id = " + id;
  }
}
