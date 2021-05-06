package dekanat.model.requests.update;

import dekanat.model.db.Subjects;
import dekanat.model.requests.DeletUpdatable;

public class SubjectUpdate implements DeletUpdatable<Subjects> {
  @Override
  public String getDeleteByIdRequest(Subjects item) {
    return "update \"subjects\" set \"name\" = '" + item.getName() + "' where id = " + item.getId();
  }
}
