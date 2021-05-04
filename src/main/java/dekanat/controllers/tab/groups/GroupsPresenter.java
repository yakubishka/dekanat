package dekanat.controllers.tab.groups;

import dekanat.model.db.Groups;
import dekanat.model.requests.select.GroupsSelect;
import dekanat.utils.DBHelper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class GroupsPresenter {

  private final ObservableList<Groups> groups = FXCollections.observableArrayList();

  public GroupsPresenter() {
    groups.addAll(DBHelper.getAllByRequest(new GroupsSelect()));
  }

  public ObservableList<Groups> getGroups() {
    return groups;
  }

}
