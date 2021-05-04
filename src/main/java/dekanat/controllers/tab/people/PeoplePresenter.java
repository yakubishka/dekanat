package dekanat.controllers.tab.people;

import dekanat.architecture.BaseTabViewPresenter;
import dekanat.model.db.People;
import dekanat.model.requests.select.PeopleSelect;
import dekanat.model.requests.select.Selectable;

public class PeoplePresenter extends BaseTabViewPresenter<People> {

  @Override
  public Selectable<People> getSelectable() {
    return new PeopleSelect();
  }

}
