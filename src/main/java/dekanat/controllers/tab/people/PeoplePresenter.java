package dekanat.controllers.tab.people;

import dekanat.architecture.BaseTabViewPresenter;
import dekanat.controllers.dialogs.AddEditPeopleDialogController;
import dekanat.controllers.dialogs.AddEditSubjectDialogController;
import dekanat.model.db.People;
import dekanat.model.db.Subjects;
import dekanat.model.requests.delete.PeopleDelete;
import dekanat.model.requests.insert.PeopleInsert;
import dekanat.model.requests.insert.SubjectInsert;
import dekanat.model.requests.select.PeopleSelect;
import dekanat.model.requests.SelectInsertable;
import dekanat.model.requests.update.PeopleUpdate;
import dekanat.model.requests.update.SubjectUpdate;
import dekanat.utils.DBHelper;

import java.util.List;

public class PeoplePresenter extends BaseTabViewPresenter<People> {

  @Override
  public SelectInsertable<People> getSelectable() {
    return new PeopleSelect();
  }

  @Override
  public void onDelete(int index) {
    People peopleToDelete = list.get(index);
    if (DBHelper.deleteOrUpdateByRequest(peopleToDelete, new PeopleDelete()) > 0) {
      list.remove(index);
    }
  }

  @Override
  public void onEdit(int index) {
    if (app != null) {
      People people = list.get(index);
      AddEditPeopleDialogController.showAsDialog(app, people);
      DBHelper.deleteOrUpdateByRequest(people, new PeopleUpdate());
    }
  }

  @Override
  public void onInsert() {
    if (app != null) {
      People people = new People(-1, "", "", "", -1, "", "");
      AddEditPeopleDialogController.showAsDialog(app, people);
      List<People> peoplesList = DBHelper.getAllByRequest(new PeopleInsert(people));
      if (!peoplesList.isEmpty())
        list.add(peoplesList.get(0));
    }
  }
}
