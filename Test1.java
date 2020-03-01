public class Test1 {
  public static void main(String[] args) {
     float n1,n2;
     //System.out.println("<br>args#: " + args.length + " n1: " + args[0] + ", n2: " + args[1]+ "\n");
     //System.out.println("<br>args#: " + args.length + " n1: " + args[0]);
     //System.out.println("<br>args#: " + args.length );
     if (args.length!=2) {
       System.out.println("<br>Test1 number1 number2\n");
     }
     else {
       n1=Float.parseFloat(args[0]);
       n2=Float.parseFloat(args[1]);
       System.out.println("<br>" + n1 + " + " + n2 + " = " + (n1+n2));
     }
  }
}
