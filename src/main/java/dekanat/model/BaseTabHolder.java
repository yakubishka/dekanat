package dekanat.model;

import dekanat.app.MainApp;
import dekanat.architecture.BaseTabViewController;
import dekanat.resources.StringRes;

public abstract class BaseTabHolder<T> {

  protected MainApp app;

  public enum TabType {
    GROUPS(StringRes.GROUPS_TAB_TITLE),
    MARKS(StringRes.MARKS_TAB_TITLE),
    PEOPLE(StringRes.PEOPLE_TAB_TITLE),
    SUBJECTS(StringRes.SUBJECTS_TAB_TITLE);

    private String title;

    TabType(String title) {
      this.title = title;
    }

    public String getTitle() {
      return title;
    }

    public void setTitle(String title) {
      this.title = title;
    }
  }

  public BaseTabHolder(MainApp app) {
    this.app = app;
  }

  public abstract BaseTabViewController<T> getController();
  public abstract TabType getType();

}
