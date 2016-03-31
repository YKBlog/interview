package dataStructure.queue;

/**
 * @Title: MyQueue.java
 * @Description: <br>
 *               队列FIFO接口 <br>
 *               特点：尾部加入，头部移除 先进先出 <br>
 *               实现方式：数组array、链表node、栈stack <br>
 * <br>
 *               jdk queue 添加、删除方法 <br>
 *               element 返回队列头部的元素 如果队列为空，则抛出一个NoSuchElementException异常 <br>
 *               add 增加一个元索  队列已满，则抛出一个IIIegaISlabEepeplian异常 <br>
 *               offer 添加一个元素并返回true 如果队列已满，则返回false <br>
 *               put 添加一个元素 如果队列满，则阻塞 <br>
 *               remove 移除并返回队列头部的元素 如果队列为空，则抛出一个NoSuchElementException异常 <br>
 *               poll 移除并返问队列头部的元素 如果队列为空，则返回null <br>
 *               peek 返回队列头部的元素 如果队列为空，则返回null <br>
 *               take 移除并返回队列头部的元素 如果队列为空，则阻塞
 * @Created on 2016年3月15日 下午4:35:23
 * @author yangkai
 * @version 1.0
 */
public interface MyQueue<T> {

    /**
     * 添加一个元素 如果队列已满，则抛出Exception异常
     * 
     * @param t
     */
    public void add(T t);

    /**
     * 添加一个元素 如果队列已满，扩容
     * 
     * @param t
     */
    public void put(T t);

    /**
     * 移除一个元素 如果队列为空，则抛出Exception异常
     * 
     * @param t
     */
    public void remove();

    /**
     * 移除一个元素并返回队头元素 如果队列为空，返回空
     * 
     * @return
     */
    public T poll();

    /**
     * 返回队列头部元素，不删除
     * 
     * @return
     */
    public T peek();

    /**
     * 返回队列元素个数
     * 
     * @return
     */
    public int size();

    /**
     * 判读队列是否为空
     * 
     * @return
     */
    public boolean isEmpty();

}
