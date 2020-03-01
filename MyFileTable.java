import java.io.File;
import java.io.FileReader;
import java.util.Scanner;  // Import the Scanner class

class MyFileTable {
  private String fname1="",fname2="";
  private long fsize1=-1,fsize2=-1;
  private long fline1=-1,fline2=-1;
  private String delimiter = ","; //Delimiter
  String[][] CSVArr;
  int rowCount=0;

  public String readDataLineByLine(String fname)
  {
    String out="";
    String[] lineArr;
    int firstRowLength=0;
    try {
        File file = new File(fname);
        Scanner scanner = new Scanner(new File(fname));
        out="<TABLE border=1>\n";
        rowCount=0;
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            lineArr=line.split(delimiter);
            if (rowCount==0)
               firstRowLength=lineArr.length;
            if(lineArr.length != firstRowLength){
                System.out.println("Invalid CSV format\n");
            }
            rowCount++;
            out=out+"<TR>";
            for (int i=0;i<lineArr.length;i++)
                out=out + "<TD>" + lineArr[i];
            out=out + "\n";
        }
        out=out+"</TABLE>\n";
    }
    catch (Exception e) {
        e.printStackTrace();
    }
    return out;
  }

  public long getTotalSize() {
        long totalSize=-1;
        if (fsize1==-1 || fsize2==-1)
                totalSize= -1;
        else
                totalSize= fsize1+fsize2;

        return totalSize;
  }

  public MyFileTable(String n1, String n2) {
        fname1=n1;
        fname2=n2;
        fsize1=getFileSize(fname1);
        fsize2=getFileSize(fname2);
  }

  long getFileSize(String fname) {
        File file = new File(fname);
        if (!file.exists() || !file.isFile()) {
                return -1;
        } else{
                return file.length();
        }

  }

  void printInfo() {
        String msg="";
        System.out.println("<br>File Name 1:" + fname1 + " size: " + getFileSize(fname1));
        System.out.println("<br>File Name 2:" + fname2 + " size: " + getFileSize(fname2));
        System.out.println("<br>Total size: " + getTotalSize());
        msg=readDataLineByLine(fname1);
        System.out.println(msg);
        msg=readDataLineByLine(fname2);
        System.out.println(msg);
  }

}
