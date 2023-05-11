package deque;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LinkedListDeque<T> implements Deque<T> {
    int size;
    Node <T> start ;
    Node <T> end;

    private class LinkedListDequeIterator implements Iterator<T>
    {

        Node <T> pos =null;
        public LinkedListDequeIterator()
        {
            pos = start.next;

        }
        @Override
        public boolean hasNext() {

            return pos!=end;
        }

        @Override
        public T next() {
            T data = pos.data;
            pos=pos.next;
            return data;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedListDequeIterator() ;
    }

    private static class Node<T>
    {
        T data;
        Node <T> next;
        Node <T> front;
        public Node ()
        {
            data = null;
            next = null;
            front = null;
        }
        public Node(T data,Node <T> next,Node <T> front)
        {
            this.data=data;
            this.next=next;
            this.front=front;
        }


    }
    public  LinkedListDeque()
    {
        size=0;
        start=new Node <>();
        end=new Node <>();
        start.next=end;
        start.front=null;
        end.front=start;
        end.next=null;

    }


    @Override
    public void addFirst(T x) {
        Node <T> tmp=new Node<>(x,null,null);
        tmp.next=start.next;
        start.next.front=tmp;
        tmp.front=start;
        start.next=tmp;
        size++;
    }

    @Override
    public void addLast(T x) {
        Node <T> tmp=new Node<>(x,null,null);
        tmp.next=end;
        tmp.front=end.front;
        end.front.next=tmp;
        end.front=tmp;
        size++;

    }

    @Override
    public List<T> toList() {
        List<T> t =new ArrayList<>();
        Node <T> tmp = start.next;
        while(tmp!=end)
        {
            t.add(tmp.data);
            tmp=tmp.next;
        }
        return t;
    }

    @Override
    public boolean isEmpty() {
        if(size==0) return true;
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T removeFirst() {

        if(size<=0)
        {
            return null;
        }
        else
        {
            Node <T> tmp = start.next;
            start.next=tmp.next;
            tmp.next.front=start;
            size--;
            return tmp.data;
        }

    }

    @Override
    public T removeLast() {
        if(size<=0)
        {
            return null;
        }
        else
        {
            Node <T> tmp = end.front;
            end.front=tmp.front;
            tmp.front.next=end;
            size--;
            return tmp.data;
        }
    }

    @Override
    public T get(int index) {
        if(size==0)
            return null;
        if(index>size) throw new IllegalArgumentException("index is larger than size");
        else
        {
            Node <T>tmp=start;
            for(int i=1;i<=index;i++)
            {
                tmp=tmp.next;
            }
            return tmp.data;
        }
    }

    private T helper(Node <T> tmp,int index)
    {
        if(index==0) return tmp.data;
        else
        {
            return helper(tmp.next,index-1);
        }
    }

    @Override
    public T getRecursive(int index) {
        if(index>size) throw new IllegalArgumentException("index is larger than size");
        return helper(start,index);
    }
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof LinkedListDeque o)
        {
            if(o.size()!=this.size()) return false;
            Node <T> pos1 = this.start.next;
            Node <T> pos2 = o.start.next;
            while(pos1!=this.end)
            {
                if(pos1.data!=pos2.data) return false;
                pos1=pos1.next;
                pos2=pos2.next;
            }
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder("{");
        for(Node <T> pos=start.next;pos!=end;pos=pos.next)
        {
            res.append(pos.data);
            if(pos.next!=end) res.append(",");
        }
        res.append("}");
        return res.toString();
    }
    public static void main(String[] args) {
        Deque<Integer> lld = new LinkedListDeque<>();
        lld.addFirst(2);
        lld.addFirst(13);
        lld.addLast(0);
        lld.removeFirst();
        Deque<Integer> d = new LinkedListDeque<>();
        d.addFirst(2);
        d.addLast(2);
        System.out.println(lld.equals(d));
        System.out.println(lld);
    }



}
