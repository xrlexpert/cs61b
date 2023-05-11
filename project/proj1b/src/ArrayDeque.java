import net.sf.saxon.functions.Minimax;

import java.util.ArrayList;
import java.util.List;

public class ArrayDeque<T> implements Deque<T> {
    int size;
    int rear;
    int front;
    int Maxsize;
    Object [] items;

    public ArrayDeque() {
        rear = 1;
        front = 0;
        Maxsize=8;
        items = (T []) new Object[Maxsize] ;
    }

    @Override
    public void addFirst(T x) {
        if((front-1+Maxsize)%Maxsize==rear)
        {
            Maxsize*=2;
            Object a [] =(T[]) new Object[Maxsize];
            if(rear<front)
            {
                for(int i=0;i<rear;i++)
                {
                    a[i]=items[i];
                }
                int i=0,j=0;
                for( i=Maxsize-1, j=Maxsize/2-1;j>front;i--,j--)
                {
                    a[i]=items[j];
                }
                front=i;
            }
            else
            {
                for(int i=0;i<front;i++)
                {
                    a[i]=items[i];
                }
                int i=0,j=0;
                for( i=Maxsize-1, j=Maxsize/2-1;j>rear;i--,j--)
                {
                    a[i]=items[j];
                }
                rear=i;

            }
            items=a;
        }
        items[front]=x;
        front=(front-1+Maxsize)%Maxsize;
        size++;

    }

    @Override
    public void addLast(T x) {
        if((rear+1)%Maxsize==front)
        {
            Maxsize*=2;
            Object a [] =(T[]) new Object[Maxsize];
            if(rear<front)
            {
                for(int i=0;i<rear;i++)
                {
                    a[i]=items[i];
                }
                int i=0,j=0;
                for( i=Maxsize-1, j=Maxsize/2-1;j>front;i--,j--)
                {
                    a[i]=items[j];
                }
                front=i;
            }
            else
            {
                for(int i=0;i<front;i++)
                {
                    a[i]=items[i];
                }
                int i=0,j=0;
                for( i=Maxsize-1, j=Maxsize/2-1;j>rear;i--,j--)
                {
                    a[i]=items[j];
                }
                rear=i;

            }

            items=a;
        }
        items[rear]=x;
        rear=(rear+1)%Maxsize;
        size++;

    }

    @Override
    public List<T> toList() {
        List <T> res =  new ArrayList<>();
        for(int i=1;i<=size;i++)
        {
            res.add((T)items[(front+i+Maxsize)%Maxsize]);
        }
        return res;
    }

    @Override
    public boolean isEmpty() {
        if(size==0) return true;
        return false;
    }

    /* size=(rear-front-1+Maxsize)%Maxsize */
    @Override
    public int size() {
        return (rear-front-1+Maxsize)%Maxsize;
    }

    @Override
    public T removeFirst() {
        T x = (T)items[(front+1+Maxsize)%Maxsize];
        front=(front+1+Maxsize)%Maxsize;
        size--;
        return x;
    }

    @Override
    public T removeLast() {
        T x = (T)items[(rear-1)%Maxsize];
        rear=(rear-1+ Maxsize)%Maxsize;
        size--;
        return x;
    }

    @Override
    public T get(int index) {
        if(index>size) throw new IllegalArgumentException("index is too large");
        return (T)items[(front+index+Maxsize)%Maxsize];
    }




    public static void main(String[] args) {

        Deque<Integer> ad = new ArrayDeque<>();
        ad.addFirst(1);
        ad.addLast(30);
        ad.removeFirst();
        ad.removeFirst();
        System.out.println(ad.isEmpty());
    }
}

