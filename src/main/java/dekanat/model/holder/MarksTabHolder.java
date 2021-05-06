package dekanat.model.holder;

import dekanat.app.MainApp;
import dekanat.model.BaseTabHolder;
import dekanat.model.db.Subjects;
import dekanat.resources.LayoutRes;

public class MarksTabHolder extends BaseTabHolder<Subjects> {

  public MarksTabHolder(MainApp app) {
    super(app);
  }

  @Override
  public String getLayoutRes() {
    return LayoutRes.MARKS_LAYOUT;
  }

  @Override
  public TabType getType() {
    return TabType.MARKS;
  }
}
