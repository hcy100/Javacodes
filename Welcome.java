class Visitor {
  private String name;
  public String getName() {return name;}
  void setName(String n) {name=n;}
  void printInfo() {
        System.out.println("<br>Name:" + name);
  }
}

public class Welcome {
  public static void main(String[] args) {
    Visitor v1=new Visitor();
    //v1.setName(args[0]);
    v1.setName("Monkey");
  //  System.out.println("Content-type: text/html\r\n");
    System.out.println( "<br>" + v1.getName() + "<br>Welcome to CPS2231");
    v1.printInfo();
  }
}
