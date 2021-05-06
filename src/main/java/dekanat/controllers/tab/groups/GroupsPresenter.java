package dekanat.controllers.tab.groups;

import dekanat.architecture.BaseTabViewPresenter;
import dekanat.controllers.dialogs.AddEditGroupDialogController;
import dekanat.model.db.Groups;
import dekanat.model.requests.delete.GroupsDelete;
import dekanat.model.requests.insert.GroupInsert;
import dekanat.model.requests.select.GroupsSelect;
import dekanat.model.requests.SelectInsertable;
import dekanat.model.requests.update.GroupUpdate;
import dekanat.utils.DBHelper;
import java.util.List;

public class GroupsPresenter extends BaseTabViewPresenter<Groups> {
  @Override
  public SelectInsertable<Groups> getSelectable() {
    return new GroupsSelect();
  }

  @Override
  public void onDelete(int index) {
    Groups groupToDelete = list.get(index);
    if (DBHelper.deleteOrUpdateByRequest(groupToDelete, new GroupsDelete()) > 0) {
      list.remove(index);
    }
  }

  @Override
  public void onEdit(int index) {
    if (app != null) {
      Groups groupToChange = list.get(index);
      AddEditGroupDialogController.showAsDialog(app, groupToChange);
      System.out.println(new GroupUpdate().getDeleteByIdRequest(groupToChange));
      DBHelper.deleteOrUpdateByRequest(groupToChange, new GroupUpdate());
    }
  }

  @Override
  public void onInsert() {
    if (app != null) {
      Groups newGroup = new Groups(-1, "");
      AddEditGroupDialogController.showAsDialog(app, newGroup);
      List<Groups> groups = DBHelper.getAllByRequest(new GroupInsert(newGroup));
      if (!groups.isEmpty())
        list.add(groups.get(0));
    }
  }
}
