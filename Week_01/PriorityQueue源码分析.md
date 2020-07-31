# PriorityQueue 源码分析

### 官方解释 
An unbounded priority queue based on a priority heap. The elements of the priority queue are ordered according to their natural ordering, or by a Comparator provided at queue construction time, 

基于优先堆实现的无界优先队列，如果提供了Comparator，每个元素怎更具提供Comparator排序，或则根据元素本身提供Comparator 进行对排序

### 继承关系
PriorityQueue 继承自AbstractQueue->Queue()
该文章的侧重分析Queue()接口实现

### 代码分析
```
public class PriorityQueue<E> extends AbstractQueue<E>
    implements java.io.Serializable {
         private static final int DEFAULT_INITIAL_CAPACITY = 11;//默认初始化容量
         transient Object[] queue;//用数组实现的优先堆
         private int size = 0; //队列的个数
         private final Comparator<? super E> comparator;//实现堆排序的比较器如果空则用元素本身实现的比较器
         /* 构造函数*/
         ....
          public PriorityQueue(int initialCapacity,  Comparator<? super E> comparator) {
        // Note: This restriction of at least one is not actually needed,
        // but continues for 1.5 compatibility
        if (initialCapacity < 1)
            throw new IllegalArgumentException();
        this.queue = new Object[initialCapacity];//初始化组数
        this.comparator = comparator;
    }
         
    }
```
### 插入
```
        public boolean offer(E e) {
            if (e == null)
                throw new NullPointerException();
            modCount++;
            int i = size;
            if (i >= queue.length)//判断空间是否足够
                grow(i + 1);//扩容
             size = i + 1;
            if (i == 0)
                queue[0] = e;//空队列，直接赋值
            else
                siftUp(i, e);//根据堆排序插入，核心方法
            return true;
        } 
```
这儿可以insert的代码不多 add(e)=>offer(e)，可以看到offer的逻辑也挺简单
1. 判断空间是否足够,不够则扩容
2. 空队列直接插入到首个，否则根据堆排序插入
```
  private void siftUp(int k, E x) {
        if (comparator != null)//如果有设置比较器则用比较器获取进行堆排序
            siftUpUsingComparator(k, x);
        else //没有，则用元素自身实现Comparable 如果元素没有实现Comparable 则会抛出异常
            siftUpComparable(k, x);
    }
```
两个siftup大致一样只是Comparator获取不一样，我们分析siftUpComparable()
```
   @SuppressWarnings("unchecked")
    private void siftUpComparable(int k, E x) {
        Comparable<? super E> key = (Comparable<? super E>) x;
        while (k > 0) {
            int parent = (k - 1) >>> 1;//查找父节点
            Object e = queue[parent];//获取父节点
            if (key.compareTo((E) e) >= 0)//与父节点比较 >=0
                break;
            queue[k] = e;// >=0 父节点下移到叶子节点
            k = parent;//插入位置上一层
        }
        queue[k] = key;//最终合适的位置，
    }
```
例如 Integer 实现 
```
public int compareTo(Integer anotherInteger) {
  return compare(this.value, anotherInteger.value);
}
 public static int compare(int x, int y) {
        return (x < y) ? -1 : ((x == y) ? 0 : 1);
}
```
这RriorityQueue实现的是个小顶堆
```
priorityQueue.offer(4);
priorityQueue.offer(6);
priorityQueue.offer(8);
priorityQueue.offer(5);
priorityQueue.offer(9);
```

![](https://github.com/ffaa30703/algorithm013/blob/master/Week_01/offer.jpg?raw=true)


### poll
```
 public E poll() {
        if (size == 0)
            return null;
        int s = --size;
        modCount++;
        E result = (E) queue[0];
        E x = (E) queue[s];
        queue[s] = null;
        if (s != 0)
            siftDown(0, x);
        return result;
    }
```
1. size==0 return null
2. result 记录首个元素
3. x 记录最后一个元素
4. s的位置不为0 则拿最后一个元素插入到0位置，进行一次堆排序，之后最合适的那个数就会到堆首位置

```
   private void siftDown(int k, E x) {
        if (comparator != null)
            siftDownUsingComparator(k, x);
        else
            siftDownComparable(k, x);
    }
    
     @SuppressWarnings("unchecked")
    private void siftDownComparable(int k, E x) {
        Comparable<? super E> key = (Comparable<? super E>)x;
        int half = size >>> 1;        // loop while a non-leaf
        while (k < half) {//下沉非叶子节点
            int child = (k << 1) + 1; // assume left child is least
            //左儿子
            Object c = queue[child];
            int right = child + 1;
            if (right < size &&
                ((Comparable<? super E>) c).compareTo((E) queue[right]) > 0)
                c = queue[child = right];
            //左右儿子比较得出最小
            if (key.compareTo((E) c) <= 0)
                break;
            //比插入节点小，插入节点继续下沉
            queue[k] = c;
            k = child;
        }
        queue[k] = key;
    }
```
同样这儿分析siftDownComparable(int k, E x)

再此我们进行poll()操作

![](https://raw.githubusercontent.com/ffaa30703/algorithm013/master/Week_01/poll.jpg)
