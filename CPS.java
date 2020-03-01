public class CPS {
  private String name;
  private int type;
  private String[] animal =
          {"monkey", "tiger", "fish", "bear", "bird"};

  CPS() {   type=(int)(Math.random()*5);   }

  public void setCPS(String n) { name=n; }

  private String getCPS() {return name;}

  public void printInfo() {
    System.out.println( name + " got a " + animal[type] + ".");
  }
}
