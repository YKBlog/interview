package algorithm;

/**
 * 
 * @Title: AlgorithmInterview.java
 * @Copyright: Copyright (c) 2005
 * @Description: <br>
 *               <br>功能概述：打印图形                 
 *               <br>            
 * @Created on 2015年9月9日 下午10:04:27
 * @author yangkai
 */
public class PrintGraph {

    /**
     * 慧聪网面试题：
     * 输入4打印如下图形，输入3打印前三行；程序算出输入n：
     * <br>1
     * <br>2 3
     * <br>4 5 6
     * <br>7 8 9 10
     * 
     * @param n
     */
    public static void printDataTrigon(int n) {
        int temp = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                temp++;
                System.out.print(temp+"   ");
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        printDataTrigon(3);
    }
}
