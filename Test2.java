public class Test2 {
  public static void main(String[] args) {
     MyFile myfile;
     float n1,n2;
     if (args.length!=2) {
        System.out.println("<br>Usage: Test2 file1 file2\n");
     }
     else {
        myfile=new MyFile(args[0],args[1]);
        myfile.printInfo();
     }
  }
}
