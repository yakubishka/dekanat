package dekanat.model.requests.delete;

public class GroupsDelete implements Deletable{
  @Override
  public String getDeleteByIdRequest(long id) {
    return "delete from groups where id = " + id;
  }
}
