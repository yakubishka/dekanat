package dekanat.architecture;

import javafx.fxml.FXML;
import javafx.scene.control.TableView;

public abstract class BaseTabViewController<T> {

  @FXML
  protected TableView<T> tableView;

  protected BaseTabViewPresenter<T> presenter;

  @FXML
  protected void initialize() {
    presenter = createPresenter();
    presenter.loadData();
    tableView.setItems(presenter.getList());
  }

  public abstract void onInsertClick();

  public void onDeleteClick() {
    presenter.onDelete(tableView.getSelectionModel().getSelectedIndex());
  }

  public abstract void inEditClick();

  public abstract BaseTabViewPresenter<T> createPresenter();

  public void reloadList() {
    presenter.reloadList();
  }

}
