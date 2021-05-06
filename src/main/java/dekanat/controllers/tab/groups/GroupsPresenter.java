package dekanat.controllers.tab.groups;

import dekanat.architecture.BaseTabViewPresenter;
import dekanat.model.db.Groups;
import dekanat.model.requests.delete.GroupsDelete;
import dekanat.model.requests.select.GroupsSelect;
import dekanat.model.requests.select.Selectable;
import dekanat.utils.DBHelper;

public class GroupsPresenter extends BaseTabViewPresenter<Groups> {
  @Override
  public Selectable<Groups> getSelectable() {
    return new GroupsSelect();
  }

  @Override
  public void onDelete(int index) {
    Groups groupToDelete = list.get(index);
    if (DBHelper.deleteByRequest(groupToDelete.getId(), new GroupsDelete()) > 0) {
      list.remove(index);
    }
  }
}
