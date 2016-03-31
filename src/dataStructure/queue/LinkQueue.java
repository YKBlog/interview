package dataStructure.queue;

/**
 * 
 * @Title: LinkQueue.java
 * @Description: <br>
 * <br>
 *               队列链表实现
 * @Created on 2016年3月15日 下午6:40:11
 * @author yangkai
 * @version 1.0
 */
public class LinkQueue<T> implements MyQueue<T> {

    private Node head;  //frist 节点

    private Node current;  //当前节点

    private int size;  //节点数量

    public LinkQueue() {
        head = null;
        current = null;
        size = 0;
    }

    /**
     * 
     * @Description: <br>
     * <br>
     *               内部node节点类
     */
    class Node {
        T data;

        Node next;

        public Node() {
        }

        public Node(T t) {
            this.data = t;
        }
    }

    /*
     * 链表实现无所谓扩容不扩容之说
     */
    @Override
    public void add(T t) {
    }

    @Override
    public void put(T t) {
        if (t == null)
            throw new NullPointerException();
        Node node = new Node(t);
        if (isEmpty())
            head = node;
        else
            current.next = node;
        current = node;
        size++;
    }

    public void isEmptyException() {
        if (isEmpty())
            new RuntimeException("queue is empty");
    }

    @Override
    public void remove() {
        isEmptyException();
        if (null == head.next)
            current = null;
        head = head.next;
        size--;
    }

    /**
     * 移除一个元素并返回队头元素 如果队列为空，返回空
     * 
     * @return
     */
    @Override
    public T poll() {
        T temp;
        if (isEmpty())
            return null;
        if (null == head.next)
            current = null;
        temp = head.data;
        head = head.next;
        size--;
        return temp;
    }

    /**
     * 返回队列头部元素，不删除
     * 
     * @return
     */
    @Override
    public T peek() {
        if (isEmpty())
            return null;
        return head.data;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

}
