import java.util.Scanner;
import java.io.*;
public class TestFile {
  public static void main(String[] args) {
  try {
        File file=new File("t.txt");
        if (file.exists())
        System.out.println("Open file ...");
        else
        System.out.println("File not exist at the local disk...");
        Scanner input=new Scanner(file);
        String name = input.nextLine();
        input.close();
        System.out.println("Name:" + name);
  }
      catch(FileNotFoundException e) {
      System.out.println("Error! File not found!");
      }
  }
}
