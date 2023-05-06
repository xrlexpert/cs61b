public class Main {
    public static void main(String[] args) {
      Dog x = new Dog(14,"hah");
      Dog y = new Dog(-10,"a");
      Dog [] dogs={x,y,new Dog(200,"b")};
      Dog z=(Dog)Max.max(dogs);

      Compartor<Dog> nc= Dog.getNameCompartor();
      if(nc.compare(x,y)>0)
      {
          System.out.println(x.getName());
      }
      System.out.println(z.getSize());
    }
}