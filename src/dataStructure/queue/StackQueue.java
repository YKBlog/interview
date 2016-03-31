package dataStructure.queue;

import java.util.Iterator;
import java.util.Stack;

public class StackQueue<T> implements MyQueue<T> {

    private Stack<T> stackA;

    private Stack<T> stackB;

    private int size;

    public StackQueue() {
        stackA = new Stack<T>();
        stackB = new Stack<T>();
        size = 0;
    }

    @Override
    public void put(T t) {
        stackA.push(t);
    }

    @Override
    public T poll() {
        Iterator<T> iterator = stackA.iterator();
        while (iterator.hasNext())
            stackB.push(stackA.pop());
        return (T) stackB.pop();
    }

    /**
     * 作用和上面的poll一样，使用一个poll完成,一样删除元素
     */
    public T poll2() {
        size = stackA.size();
        T t = stackA.get(size - 1);
        size--;
        return t;
    }

    /**
     * 作用和上面的poll一样，使用一个poll完成 区别：这个返回不删除原来元素，只做返回
     */
    @Override
    public T peek() {
        return (T) stackA.get(stackA.size() - 1);
    }

    @Override
    public void add(T t) {
    }

    @Override
    public void remove() {
    }

    /**
     * 获取队列所有元素
     * 
     * @return
     */
    public Object getAll() {
        for (int i = stackA.size() - 1; i >= 0; i--) {
            stackB.push(stackA.get(i));
        }
        return stackB;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

}
