# Cs61b  generics

泛型

## define语法：
**public class\interface name <T>{  }**<br>
Then anywhere you want to use the arbitrary type, you use that placeholder instead.<br>
for example:

```java
public class DLList<Ta> {
    private IntNode sentinel;
    private int size;

    public class IntNode {
        public IntNode prev;
        public Ta item;
        public IntNode next;
        ...
    }
    ...
}
```

## instantiate语法

put the desired type inside of angle brackets during declaration, and also use empty angle brackets during instantiation. 
For example:

```java
DLList<String> d2 = new DLList<>("hello");
d2.addLast("world");
```

