package dekanat.architecture;

import dekanat.app.MainApp;
import dekanat.model.requests.SelectInsertable;
import dekanat.utils.DBHelper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public abstract class BaseTabViewPresenter<T> {

  protected ObservableList<T> list = FXCollections.observableArrayList();

  protected MainApp app;

  public void setMainApp(MainApp app) {
    this.app = app;
  }

  public void loadData() {
    list.addAll(DBHelper.getAllByRequest(getSelectable()));
  }

  public ObservableList<T> getList() {
    return list;
  }

  public abstract SelectInsertable<T> getSelectable();

  public abstract void onDelete(int index);
  public abstract void onEdit(int index);
  public abstract void onInsert();

  public void reloadList() {
    list.clear();
    loadData();
  }

}
