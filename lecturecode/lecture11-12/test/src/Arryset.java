import java.util.Iterator;

public class Arryset <T>implements Iterable<T>{


    private int size;
    private T [] items;

    public int getSize() {
        return size;
    }
    public Arryset()
    {
        items = (T[])new Object [100];
    }
    private class Arrysetiterator implements Iterator<T>
    {
        private int pos;
        public Arrysetiterator()
        {
            pos=0;
        }

        @Override
        public boolean hasNext() {
            return pos<size;
        }

        @Override
        public T next() {
            T tmp = items[pos];
            pos++;
            return tmp;
        }
    }

    public Iterator<T> iterator()
    {
        return new Arrysetiterator();
    }
    public void add(T x)
    {
        if(x==null)
        throw new IllegalArgumentException();
        if(!contains(x))
        {
            items[size]=x;
            size+=1;
        }
    }
    public boolean contains(T x)
    {
        for(int i=0;i<size;i++)
        {
            if(items[i].equals(x))
            {
                return true;
            }
        }
        return false;

    }
    @Override
    /*在sout(类名)时，会自动调用类的toString()method*/
    public String toString()
    {
        StringBuilder x = new StringBuilder("["); //用StringBuilder比直接用String快得多
        for(int i=0;i<size;i++)
        {
            x.append(items[i].toString());
            if(i!=size-1)x.append(",");
        }
        x.append(']');
        return x.toString();
    }
    @Override
    public boolean equals(Object o)
    {
        if(o instanceof Arryset x)
        {
            if(this.size!=x.size)
                return false;
            for(T i: this)
            {
                if(!x.contains(i))
                    return false;
            }
        }
        return true;
    }



    public static void main(String[] args) {
        Arryset<String>a = new Arryset<>();
        a.add("hah");
        a.add("haf");
        a.add("xiaom");
        Iterator<String> asser = a.iterator();
        while(asser.hasNext())
        {
            String s= asser.next();
            System.out.println(s);
        }
        for(String i: a)
        {
            System.out.println(i);
        }
        System.out.println(a);
    }

}
