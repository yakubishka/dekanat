package dekanat.architecture;

import dekanat.model.requests.select.Selectable;
import dekanat.utils.DBHelper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public abstract class BaseTabViewPresenter<T> {

  protected ObservableList<T> list = FXCollections.observableArrayList();

  public void loadData() {
    list.addAll(DBHelper.getAllByRequest(getSelectable()));
  }

  public ObservableList<T> getList() {
    return list;
  }

  public abstract Selectable<T> getSelectable();

  public abstract void onDelete(int index);

  public void reloadList() {
    list.clear();
    loadData();
  }

}
