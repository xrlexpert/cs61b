# Cs61b  Constructor Behavior

Constructors are **not** inherited. However, the rules of Java say that all constructors must start with a call to one of the super class’s constructors.

> 构造器是不能被继承的，但所有子类构造器都会至少回调父类中的一个构造器（默认调用无参构造器）

* 使用**super** (  )关键字可以显式调用父类构造器

```java
public VengefulSLList() {
   deletedItems = new SLList<Item>();
}

public VengefulSLList() {
   super();
   deletedItems = new SLList<Item>();
}
```

第一个和第二个效果相同，只不过第一个为隐式，第二个显式调用

但下面的两个则不同

```java
public VengefulSLList(Item x) {
   super(x);
   deletedItems = new SLList<Item>();
}

public VengefulSLList(Item x) {
   deletedItems = new SLList<Item>();
}
```

第一个调用父类含参构造器，而第二个调用无参构造器