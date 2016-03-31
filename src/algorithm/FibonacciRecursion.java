package algorithm;

/**
 * 
 * @Title: AlgorithmJDK.java
 * @Copyright: Copyright (c) 2005
 * @Description: <br>
 * <br>
 *               题目概述：f(0)=1 f(1)=4 f(n+2)=2*f(n+1)+f(n) ；求f(n)<br>
 * @Created on 2015年9月4日 下午6:59:13
 * @author yangkai
 */
public class FibonacciRecursion {

    /**
     * 方法一： <br>
     * 推出f(n)=2*f(n-1)+f(n-2) 
     * @param n
     * @return
     */
    public static int fnRecursion(int n) {
        if (n == 0)
            return 1;
        else if (n == 1)
            return 4;
        else
            return 2 * fnRecursion(n - 1) + fnRecursion(n - 2);
    }
    /**
     * 方法二：<br>
     * 推出f(n)=f(n+2)-2*f(n+1)
     * @param n
     * @return
     */
    public static int fnRecursionCovert(int n) {
        if (n == 20)
            return 1;
        else if (n == 21)
            return 4;
        else
            return fnRecursionCovert(n+2)-2*fnRecursionCovert(n+1);
    }

    
    public static void main(String[] args) {
        System.out.println(fnRecursionCovert(10));
    }
}
