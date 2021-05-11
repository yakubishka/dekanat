package dekanat.utils;

import dekanat.model.db.CSVWriteable;
import javafx.collections.ObservableList;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteFileHelper {

  public static <T extends CSVWriteable> void writeToFile(String fileName, ObservableList<T> list) {
    try (FileWriter fileWriter = new FileWriter( fileName)){
      if (!list.isEmpty()) {
        String header = list.get(0).getHeader();
        fileWriter.append(header);
        for (CSVWriteable item : list)
          fileWriter.append(item.getRow());
        fileWriter.flush();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }

  }

}
