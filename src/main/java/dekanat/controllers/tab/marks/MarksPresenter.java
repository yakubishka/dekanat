package dekanat.controllers.tab.marks;

import dekanat.architecture.BaseTabViewPresenter;
import dekanat.model.db.Marks;
import dekanat.model.requests.delete.MarksDelete;
import dekanat.model.requests.select.MarksSelect;
import dekanat.model.requests.SelectInsertable;
import dekanat.utils.DBHelper;

public class MarksPresenter extends BaseTabViewPresenter<Marks> {

  @Override
  public SelectInsertable<Marks> getSelectable() {
    return new MarksSelect();
  }

  @Override
  public void onDelete(int index) {
    Marks markToDelete = list.get(index);
    if (DBHelper.deleteByRequest(markToDelete.getId(), new MarksDelete()) > 0) {
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
