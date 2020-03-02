import java.util.Scanner;
import java.io.*;
public class TestCSVFile {
  public static void main(String[] args) {
  try {
        File file=new File(args[0]);  // exception if no argument
        if (!file.exists())
          System.out.println("File not exist at the local disk...");
        else {
          Scanner input=new Scanner(file);
          System.out.println("<TABLE border=1>");
          while (input.hasNextLine()) {
            String line = input.nextLine();
            String[] lineArr=line.split(",");
            System.out.print("<TR>");
            for (int i=0;i<lineArr.length;i++)
               System.out.print("<TD>" + lineArr[i]);
            System.out.println("");
          }
          input.close();
          System.out.println("</TABLE>\n");
        }
      } catch(FileNotFoundException e) {
       System.out.println("Error! File not found!");
    }
  }
}
