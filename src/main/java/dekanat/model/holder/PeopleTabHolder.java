package dekanat.model.holder;

import dekanat.app.MainApp;
import dekanat.model.BaseTabHolder;
import dekanat.model.db.People;
import dekanat.resources.LayoutRes;

public class PeopleTabHolder extends BaseTabHolder<People> {

  public PeopleTabHolder(MainApp app) {
    super(app);
  }

  @Override
  public String getLayoutRes() {
    return LayoutRes.PEOPLE_LAYOUT;
  }

  @Override
  public TabType getType() {
    return TabType.PEOPLE;
  }


}
