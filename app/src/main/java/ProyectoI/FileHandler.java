package ProyectoI;

import java.io.BufferedReader;
import java.io.FileReader;

public class FileHandler {
  public static String readFile(String filePath) {
    StringBuilder text = new StringBuilder();
    try {
      BufferedReader bf = new BufferedReader(new FileReader(filePath));
      String read = bf.readLine();
      while (read != null) {
        text.append(read);
        read = bf.readLine();
      }
      bf.close();
    } catch (Exception e) {
      System.out.println("Error!");
    }
    return text.toString();
  }
}
