## Cs61b Subtype Polymorphism

翻译过来为子类多态

1. Explicit HigherorderFunction Approach

```py
def print_larger(x, y, compare, stringify):
    if compare(x, y):
        return stringify(x)
    return stringify(y)
```

2. Subtype Polymorphism Approach

```python
def print_larger(x, y):
    if x.largerThan(y):
        return x.str()
    return y.str()
```

在java中，不允许将函数作为参数传入另一个函数，所以我们使用子类多态的形式

## call backs

一个函数在另外的函数中被调用，这个函数称为回调函数

## Compartors

对于不同类型的class，我们需要有不同能比较不同类型的compare函数。<br>
然而对于同一种类型的物体，我们可能按照不同的规则来比较。
所以有了接下来的Compartors：定义物体比较的行为（传入Max函数，这样我们只需要写一个max函数就可以了）

* 首先定义一个**generics**的最基本Comparator来定义两个物体的比较行为。

```java
public interface Comparator<T> {
    int compare(T o1, T o2);
}
```



* 然后需要对不同比较方式建立不同的comparator子类如`NameComparator`是按照名字来比较
* 再用一个静态方法获取比较器

```java
import java.util.Comparator;

public class Dog implements Comparable<Dog> {
    ...

    private static class NameComparator implements Comparator<Dog> {
        public int compare(Dog a, Dog b) {
            return a.name.length>b.name.length;
        }
    }
    private static class SizeComparator implements Comparator<Dog> {
        public int compare(Dog a, Dog b) {
            return a.size>b.size;
        }
    }
    
    public static Comparator<Dog> getNameComparator() {
        return new NameComparator();
    }
     public static Comparator<Dog> getSizeComparator() {
        return new SizeComparator();
    }
}
```

