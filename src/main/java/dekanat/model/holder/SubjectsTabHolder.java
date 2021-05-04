package dekanat.model.holder;

import dekanat.app.MainApp;
import dekanat.model.BaseTabHolder;
import dekanat.model.db.Subjects;
import dekanat.resources.LayoutRes;

public class SubjectsTabHolder extends BaseTabHolder<Subjects> {

  public SubjectsTabHolder(MainApp app) {
    super(app);
  }

  @Override
  public String getLayoutRes() {
    return LayoutRes.SUBJECTS_LAYOUT;
  }

  @Override
  public TabType getType() {
    return TabType.SUBJECTS;
  }
}
