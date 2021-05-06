package dekanat.model.requests.delete;

import dekanat.model.db.Marks;
import dekanat.model.requests.DeletUpdatable;

public class MarksDelete implements DeletUpdatable<Marks> {
  @Override
  public String getDeleteByIdRequest(Marks item) {
    return "delete from marks where id = " + item.getId();
  }
}
