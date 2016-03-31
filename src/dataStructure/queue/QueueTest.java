package dataStructure.queue;

import java.util.Iterator;
import java.util.Stack;

import org.junit.Test;

public class QueueTest {

    @Test
    public void testArrayQueue() {
        ArrayQueue<String> arrayQueue = new ArrayQueue<String>();
        arrayQueue.add("a");
        arrayQueue.add("b");
        //arrayQueue.put("d");  //exception: queue is full
        arrayQueue.add("c");
        // arrayQueue.put(null); //exception: nullpointer
        arrayQueue.put("e");
       // arrayQueue.add(null);  //exception: nullpointer
        System.out.println("peek:"+arrayQueue.peek());
        System.out.println(arrayQueue.size());
        while (!arrayQueue.isEmpty()) {
            System.out.println(arrayQueue.poll());
        }
        System.out.println(arrayQueue.size());
        //arrayQueue.remove();  //exception: queue is empty
    }
    
    @Test
    public void testLinkQueue() {
        LinkQueue<String> linkQueue = new LinkQueue<String>();
        linkQueue.put("a");
        linkQueue.put("b");
        linkQueue.put("c");
        linkQueue.put("d");  
        //linkQueue.put(null);  //exception: nullpointer
        System.out.println("peek:"+linkQueue.peek());
        System.out.println(linkQueue.size());
        linkQueue.remove();
        while (!linkQueue.isEmpty()) {
            System.out.println(linkQueue.poll());
        }
        System.out.println(linkQueue.size());
    }
    
    @Test
    public void testStackQueue(){
        StackQueue<String> stackQueue = new StackQueue<String>();
        stackQueue.put("a");
        stackQueue.put("b");
        stackQueue.put("c");
        System.out.println("peek:"+stackQueue.peek());
        System.out.println("poll2:"+stackQueue.poll2());
        System.out.println("poll:"+stackQueue.poll());
    }
}
