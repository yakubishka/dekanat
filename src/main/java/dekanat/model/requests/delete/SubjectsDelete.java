package dekanat.model.requests.delete;

import dekanat.model.db.Subjects;
import dekanat.model.requests.DeletUpdatable;

public class SubjectsDelete implements DeletUpdatable<Subjects> {
  @Override
  public String getDeleteByIdRequest(Subjects item) {
    return "delete from subjects where id = " + item.getId();
  }
}
