package deque;
import java.util.Comparator;

public class MaxArrayDeque <T> extends ArrayDeque <T>  {
    Comparator<T> c;
    public MaxArrayDeque(Comparator<T> c)
    {
        this.c=c;
    }
    public T max(Comparator<T> c)
    {
        T a =(T)items[(front+1)%Maxsize];
        for(int pos=(front+1)%Maxsize;pos!=rear;pos++)
        {
            if(c.compare((T)items[pos],a)>0) a=(T)items[pos];
        }
        return a;
    }
    public T max()
    {
        T a =(T)items[(front+1)%Maxsize];
        for(int pos=(front+1)%Maxsize;pos!=rear;pos++)
        {
            if(c.compare((T)items[pos],a)>0) a=(T)items[pos];
        }
        return a;
    }




}
