package dekanat.controllers.tab.groups;

import dekanat.architecture.BaseTabViewPresenter;
import dekanat.model.db.Groups;
import dekanat.model.requests.select.GroupsSelect;
import dekanat.model.requests.select.Selectable;

public class GroupsPresenter extends BaseTabViewPresenter<Groups> {
  @Override
  public Selectable<Groups> getSelectable() {
    return new GroupsSelect();
  }
}
