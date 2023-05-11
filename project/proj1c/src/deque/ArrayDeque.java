package deque;

import org.junit.platform.engine.support.hierarchical.Node;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArrayDeque<T> implements Deque<T> {
    int size;
    int rear;
    int front;
    int Maxsize;
    Object [] items;

    public ArrayDeque(int capacity) {
        rear = 1;
        front = 0;
        Maxsize=capacity;
        items = (T []) new Object[Maxsize] ;
    }
    public ArrayDeque() {
        rear = 1;
        front = 0;
        Maxsize=8;
        items = (T []) new Object[Maxsize] ;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ArrayDeque o)
        {
            if(o.size()!=this.size()) return false;
            int pos = (front+1)%Maxsize;
            while(pos!=rear)
            {
                if(this.items[pos]!=o.items[pos]) return false;
                pos=(pos+1)%Maxsize;
            }
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder("{");
        for(int pos=(front+1)%Maxsize;pos!=rear;pos=(pos+1)%Maxsize)
        {
            res.append(items[pos].toString());
            if(pos!=(rear-1+Maxsize)%Maxsize) res.append(",");
        }
        res.append("}");
        return res.toString();
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

    @Override
    public T getRecursive(int index) {
        return get(index);
    }

    private class ArrayDequeIterator implements Iterator<T>
    {

        int pos =0;
        public ArrayDequeIterator()
        {
            pos=(front+1)%Maxsize;
        }

        @Override
        public boolean hasNext() {
            return pos!=rear;
        }

        @Override
        public T next() {
            T data = (T)items[pos];
            pos=(pos+1)%Maxsize;
            return data;

        }
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayDequeIterator();
    }
    public static void main(String[] args) {
        Deque<Integer> lld = new ArrayDeque<>();
        lld.addFirst(2);
        lld.addFirst(13);
        lld.addLast(0);
        lld.removeFirst();
        Deque<Integer> d = new ArrayDeque<>();
        d.addFirst(2);
        d.addLast(0);
        System.out.println(lld.equals(d));
    }

}
