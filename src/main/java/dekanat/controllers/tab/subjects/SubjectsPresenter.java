package dekanat.controllers.tab.subjects;

import dekanat.architecture.BaseTabViewPresenter;
import dekanat.controllers.dialogs.AddEditGroupDialogController;
import dekanat.controllers.dialogs.AddEditSubjectDialogController;
import dekanat.model.db.Groups;
import dekanat.model.db.Subjects;
import dekanat.model.requests.delete.SubjectsDelete;
import dekanat.model.requests.SelectInsertable;
import dekanat.model.requests.insert.GroupInsert;
import dekanat.model.requests.insert.SubjectInsert;
import dekanat.model.requests.select.SubjectSelect;
import dekanat.model.requests.update.SubjectUpdate;
import dekanat.utils.DBHelper;

import java.util.List;

public class SubjectsPresenter extends BaseTabViewPresenter<Subjects> {
  @Override
  public SelectInsertable<Subjects> getSelectable() {
    return new SubjectSelect();
  }

  @Override
  public void onDelete(int index) {
    Subjects subjectToDelete = list.get(index);
    if (DBHelper.deleteOrUpdateByRequest(subjectToDelete, new SubjectsDelete()) > 0) {
      list.remove(index);
    }
  }

  @Override
  public void onEdit(int index) {
    if (app != null) {
      Subjects subjects = list.get(index);
      AddEditSubjectDialogController.showAsDialog(app, subjects);
      DBHelper.deleteOrUpdateByRequest(subjects, new SubjectUpdate());
    }
  }

  @Override
  public void onInsert() {
    if (app != null) {
      Subjects newSubjects = new Subjects(-1, "");
      AddEditSubjectDialogController.showAsDialog(app, newSubjects);
      List<Subjects> subjects = DBHelper.getAllByRequest(new SubjectInsert(newSubjects));
      if (!subjects.isEmpty())
        list.add(subjects.get(0));
    }
  }

}
