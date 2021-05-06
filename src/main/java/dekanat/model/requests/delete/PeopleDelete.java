package dekanat.model.requests.delete;

import dekanat.model.db.People;
import dekanat.model.requests.DeletUpdatable;

public class PeopleDelete implements DeletUpdatable<People> {
  @Override
  public String getDeleteByIdRequest(People item) {
    return "delete from people where id = " + item.getId();
  }
}
