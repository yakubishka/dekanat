package dekanat.model.holder;

import dekanat.app.MainApp;
import dekanat.model.BaseTabHolder;
import dekanat.model.db.Groups;
import dekanat.resources.LayoutRes;

public class GroupTabHolder extends BaseTabHolder<Groups> {


  public GroupTabHolder(MainApp app) {
    super(app);
  }

  @Override
  public String getLayoutRes() {
    return LayoutRes.GROUPS_LAYOUT;
  }

  @Override
  public TabType getType() {
    return TabType.GROUPS;
  }
}
