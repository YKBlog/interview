package dataStructure.queue;

/**
 * 
 * @Title: ArrayQueue.java
 * @Description: <br>
 * <br>
 *               队列数组实现
 * @Created on 2016年3月15日 下午5:28:15
 * @author yangkai
 * @version 1.0
 */
public class ArrayQueue<T> implements MyQueue<T> {

    private T[] data; // 存放元素

    private final int length = 3; // 默认队列长度

    private int size; // 元素个数

    private int head; // 队头位置，即队列第一个元素的位置

    private int current; // 队列当前元素的位置

    public ArrayQueue() {
        data = (T[]) new Object[length];
        size = 0;
        head = 0;
        current = 0;
    }

    /**
     * 判断当前队列是否已满
     * 
     * @return
     */
    public boolean isFull() {
        return size == data.length;
    }

    /**
     * 扩容;扩容两倍
     * 
     * @return
     */
    public void resize() {
        T[] temp = (T[]) new Object[data.length * 2];
        System.arraycopy(data, 0, temp, 0, data.length);
        data = temp;
        temp = null; // 引用置空，便于gc
    }

    /**
     * 公共方法：添加元素
     * 
     * @param t
     * @param flag
     *            标识，true 队列满报异常；false队列满扩容
     */
    public void add(T t, boolean flag) {
        if (t == null)
            throw new NullPointerException();
        if (isFull()) {
            if (flag) {
                throw new RuntimeException("queue is full");
            } else {
                resize();
                head = 0;
            }
        }
        current = (head + size) % data.length;
        data[current] = t;
        size++;
    }

    /**
     * 添加一个元素 如果队列已满，则抛出Exception异常
     * 
     * @param t
     */
    @Override
    public void add(T t) {
        add(t, true);
    }

    /**
     * 添加一个元素 如果队列已满，扩容
     * 
     * @param t
     */
    @Override
    public void put(T t) {
        add(t, false);
    }

    /**
     * 公共方法：移除或者返回队列元素
     * 
     * @param state
     *            0 移除元素,队列为空报异常；1 返回第一个元素并移除，队列为空返回空；2只返回第一个元素，队列为空报异常
     * @return
     */
    public T pop(int state) {
        if (isEmpty()) {
            if (state == 1)
                return null;
            else
                throw new RuntimeException("queue is empty");
        }
        T tempData = data[head];
        if (state != 2) {
            data[head] = null;
            head = (head + 1) % data.length;
            size--;
        }
        return tempData;
    }

    @Override
    public void remove() {
        pop(0);
    }

    /**
     * 移除一个元素并返回队头元素 如果队列为空，返回空
     * 
     * @return
     */
    @Override
    public T poll() {
        return pop(1);
    }

    /**
     * 返回队列头部元素，不删除
     * 
     * @return
     */
    @Override
    public T peek() {
        return pop(2);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

}
