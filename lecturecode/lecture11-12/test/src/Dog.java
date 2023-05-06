public class Dog implements ourComparable<Dog>{
    public void setSize(int size) {
        this.size = size;
    }
     Dog(int x,String name)
    {
        this.size=x;
        this.name=name;
    }
    Dog(){};
    public int getSize() {
        return size;
    }

   private int size;

    public String getName() {
        return name;
    }

    private String name;

    @Override
    public int compareto(Dog x) {
        Dog y=(Dog) x;
        if(y.size>=this.size) return 0;
        else return 1;
    }
    private static class NameCompartor implements  Compartor<Dog>
    {
        @Override
        public int compare(Dog x, Dog y) {
            return x.name.compareTo(y.name);
        }
    }
    public static Compartor<Dog> getNameCompartor()
    {
        return new NameCompartor();
    }


}
