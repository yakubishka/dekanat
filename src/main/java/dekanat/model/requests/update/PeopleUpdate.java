package dekanat.model.requests.update;

import dekanat.model.db.People;
import dekanat.model.requests.DeletUpdatable;

public class PeopleUpdate implements DeletUpdatable<People> {

  @Override
  public String getDeleteByIdRequest(People item) {
    return "update \"people\"  set \"first_name\" = '" + item.getFirstName() + "', " +
        "\"last_name\" = '" + item.getLastName() + "', " +
        "\"father_name\" = '" + item.getFatherName() + "' ," +
        "\"group_id\" = '" + item.getGroupId() + "', " +
        "\"type\" = '" + item.getType() + "' where id = " + item.getId();
  }

}
