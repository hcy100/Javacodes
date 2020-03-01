public class Test3 {
  public static void main(String[] args) {
     MyFileTable myfiletable;
     float n1,n2;
     if (args.length!=2) {
        System.out.println("<br>Usage: Test3 file1 file2\n");
     }
     else {
        myfiletable=new MyFileTable(args[0],args[1]);
        myfiletable.printInfo();
     }
  }
}
