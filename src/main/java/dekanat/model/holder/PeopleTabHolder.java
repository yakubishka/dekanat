package dekanat.model.holder;

import dekanat.app.MainApp;
import dekanat.architecture.BaseTabViewController;
import dekanat.model.BaseTabHolder;
import dekanat.model.db.People;

public class PeopleTabHolder extends BaseTabHolder<People> {

  public PeopleTabHolder(MainApp app) {
    super(app);
  }

  @Override
  public BaseTabViewController<People> getController() {
    return null;
  }

  @Override
  public TabType getType() {
    return TabType.PEOPLE;
  }


}
