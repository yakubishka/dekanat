package dekanat.controllers.tab.people;

import dekanat.model.db.People;
import dekanat.model.requests.select.PeopleSelect;
import dekanat.utils.DBHelper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class PeoplePresenter {

  private final ObservableList<People> people = FXCollections.observableArrayList();

  public PeoplePresenter() {
    people.addAll(DBHelper.getAllByRequest(new PeopleSelect()));
  }

  public ObservableList<People> getPeople() {
    return people;
  }
}
