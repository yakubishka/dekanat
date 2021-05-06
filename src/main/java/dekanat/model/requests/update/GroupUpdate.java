package dekanat.model.requests.update;

import dekanat.model.db.Groups;
import dekanat.model.requests.DeletUpdatable;

public class GroupUpdate implements DeletUpdatable<Groups> {

  @Override
  public String getDeleteByIdRequest(Groups item) {
    return "update \"groups\" set \"name\" = '" + item.getName() + "' where id = " + item.getId();
  }
}
