# Cs61b dynamic method selection

知识：

## compile time:type checking

“=”赋值语句考虑  左边is or not a 右边。如果是，那么就编译成功，否则失败

> 例如 Object x = new Dog();

x的static type 为object，在编译时判断Dog是不是一个Object.答案是，编译成功。x的dynamic type为Dog

## run time:method的选择为变量的dynamic type中的方法来运行

> 例如 Dog x = new ShowDog();
>
> ​	x.bark();

此时x.bark运行的是showdog中的，而不是父类dog中的。因为x的dynamic type为showdog

