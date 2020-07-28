# Queue 源码分析

### 官方解释
A collection designed for holding elements prior to processing. 
一个被设计用来容纳元素的集合。java实现队列的接口

### 继承关系
queue本身是个接口同事它也继承 Collection 和Iterable

### 实现类
1. 直接实现
BlockingDeque<E>, BlockingQueue<E>, Deque<E>, TransferQueue<E>
2. 间接实现
AbstractQueue, ArrayBlockingQueue, ArrayDeque,
ConcurrentLinkedDeque, ConcurrentLinkedQueue,
DelayQueue, LinkedBlockingDeque, LinkedBlockingQueue,
LinkedList, LinkedTransferQueue, PriorityBlockingQueue, 
PriorityQueue, SynchronousQueue
### 重要接口
| |  Throws exception  | Returns special value  |
|---- |  ----  | ----  |
|insert | add(e)   | offer(e) |
|remove | remove() | poll() |
|Examine| element()| peek() |
Queue 除了实现Collection和Iterable接口外，另外提供插入，获取，删除操作分别有两种模式1、操作失败抛出异常，2、操作失败返回特定值
####插入
1. add(e) 插入值到队列中成功返回true 在空间不足的抛出IllegalStateException 异常
2.  offer​(E e)插入值到队列中 成功返回true 插入失败返回false
#### 删除
1. remove() 成功返回true 队列空则抛出异常
2. poll() 成功返回true 队列空返回null
#### 检索
1.element() 返回队列的头值，但不删除，队列空的情况抛出异常
2.peek() 返回队列的头值，但不删除，队列空的情况返回null





