package executors;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
/**
 * 
 * @Title: FixedThreadExecutorForHashMap.java
 * @Description: <br>
 *               <br>使用两个线程池  展示hashmap非线程安全问题；这里可以使用kill -3 pid  或者jstack pid  来查看具体stack信息
 * @Created on 2016年3月15日 下午4:27:37
 * @author yangkai
 * @version 1.0
 */
public class FixedThreadExecutorForHashMap {

    public static void main(String[] args) {
        final Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        ExecutorService threadPool = Executors.newFixedThreadPool(2);
        Future<Map<Integer,Integer>> future = threadPool.submit(new Callable<Map<Integer,Integer>>() {
            @Override
            public Map<Integer,Integer> call() throws Exception {
                for(int i=0;i<10;i++){
                    map.put(i, i);
                }
                return map;
            }
        });
        ExecutorService threadPool2 = Executors.newFixedThreadPool(2);
        Future<Map<Integer,Integer>> future2 = threadPool2.submit(new Callable<Map<Integer,Integer>>() {
            @Override
            public Map<Integer,Integer> call() throws Exception {
                for(int i=0;i<5;i++){
                    map.remove(i);
                }
                return map;
            }
        });
        try {
            System.out.println(future.get());
            System.out.println(future2.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
