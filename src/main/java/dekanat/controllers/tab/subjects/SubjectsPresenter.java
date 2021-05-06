package dekanat.controllers.tab.subjects;

import dekanat.architecture.BaseTabViewPresenter;
import dekanat.model.db.Subjects;
import dekanat.model.requests.delete.SubjectsDelete;
import dekanat.model.requests.SelectInsertable;
import dekanat.model.requests.select.SubjectSelect;
import dekanat.utils.DBHelper;

public class SubjectsPresenter extends BaseTabViewPresenter<Subjects> {
  @Override
  public SelectInsertable<Subjects> getSelectable() {
    return new SubjectSelect();
  }

  @Override
  public void onDelete(int index) {
    Subjects subjectToDelete = list.get(index);
    if (DBHelper.deleteByRequest(subjectToDelete.getId(), new SubjectsDelete()) > 0) {
      list.remove(index);
    }
  }

  @Override
  public void onEdit(int index) {

  }

  @Override
  public void onInsert() {

  }
}
