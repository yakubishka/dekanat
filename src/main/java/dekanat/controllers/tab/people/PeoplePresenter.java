package dekanat.controllers.tab.people;

import dekanat.architecture.BaseTabViewPresenter;
import dekanat.model.db.People;
import dekanat.model.requests.delete.PeopleDelete;
import dekanat.model.requests.select.PeopleSelect;
import dekanat.model.requests.select.Selectable;
import dekanat.utils.DBHelper;

public class PeoplePresenter extends BaseTabViewPresenter<People> {

  @Override
  public Selectable<People> getSelectable() {
    return new PeopleSelect();
  }

  @Override
  public void onDelete(int index) {
    People peopleToDelete = list.get(index);
    if (DBHelper.deleteByRequest(peopleToDelete.getId(), new PeopleDelete()) > 0) {
      list.remove(index);
    }
  }
}
