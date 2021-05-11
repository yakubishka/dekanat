package dekanat.utils;

import dekanat.model.User;

import java.util.ArrayList;

public class UserUtils {

  private static User user;

  public static ArrayList<OnUserChangeListener> onUserChangeListenerList = new ArrayList<>();

  public interface OnUserChangeListener {
    void onChange(User user);
  }

  public static void setUser(User newUser) {
    user = newUser;
    for (OnUserChangeListener listener : onUserChangeListenerList) {
      listener.onChange(user);
    }
  }

  public static User getUser() {
    return user;
  }

  public static void clearUser() {
    user = null;
    for (OnUserChangeListener listener : onUserChangeListenerList) {
      listener.onChange(user);
    }
  }

}
