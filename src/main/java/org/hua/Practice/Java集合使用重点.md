## 集合使用重点
* 集合判空  
判断集合内部的元素是否为空，使用isEmpty方法，不能使用size()==0   
why:可读性好
* 集合转map  
使用java.utils.stream.Collectors 类的 toMap方法转为Map集合时，value不能为null  
NPE
* 集合遍历  
  不要在 foreach 循环里进行元素的 remove/add 操作。remove 元素请使用 Iterator 方式，如果并发操作，需要对 Iterator 对象加锁。
* 集合去重  
  可以利用 Set 元素唯一的特性，可以快速对一个集合进行去重操作，避免使用 List 的 contains() 进行遍历去重或者判断包含操作。

* 集合转数组  
  使用集合转数组的方法，必须使用集合的 toArray(T[] array)，传入的是类型完全一致、长度为 0 的空数组。

* 数组转集合  
  使用工具类 Arrays.asList() 把数组转换成集合时，不能使用其修改集合相关的方法， 它的 add/remove/clear 方法会抛出 UnsupportedOperationException 异常。
