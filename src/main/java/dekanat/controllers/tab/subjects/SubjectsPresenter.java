package dekanat.controllers.tab.subjects;

import dekanat.architecture.BaseTabViewPresenter;
import dekanat.model.db.Subjects;
import dekanat.model.requests.select.Selectable;
import dekanat.model.requests.select.SubjectSelect;

public class SubjectsPresenter extends BaseTabViewPresenter<Subjects> {
  @Override
  public Selectable<Subjects> getSelectable() {
    return new SubjectSelect();
  }
}
