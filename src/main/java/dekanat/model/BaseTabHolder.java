package dekanat.model;

import dekanat.app.MainApp;
import dekanat.architecture.BaseTabViewController;
import dekanat.resources.StringRes;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

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

  private Pane layout;
  private BaseTabViewController<T> controller;

  public BaseTabHolder(MainApp app) {
    this.app = app;
    FXMLLoader loader = app.createLoader(getLayoutRes());
    layout = app.getPaneFromLoader(loader);
    controller = loader.getController();
  }

  public Pane getLayout() {
    return layout;
  }

  public BaseTabViewController<T> getController() {
    return controller;
  }

  public abstract String getLayoutRes();
  public abstract TabType getType();

}
