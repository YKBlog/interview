package algorithm;

/**
 * 
 * @Title: SortAlgorithm.java
 * @Description: <br>快排
 *               <br>
 * @Created on 2016年3月12日 下午3:48:58
 * @author yangkai
 * @version 1.0
 */
public class QuickSort {


    /**
     * 快速排序；分割数组
     * 
     * @param datas
     */
    public static int QuickPartition(int[] datas, int left, int right) {
        int pivot = datas[left];
        while (left < right) {
            while (left < right && datas[right] >= pivot) {
                --right;
            }
            if (left != right) { // 前后指针相同不交换
                datas[left] = datas[right]; // 将比枢轴小的元素移到低端，此时right位相当于空，等待低位比pivot  key大的数补上
                while (left < right && datas[left] <= pivot) {
                    ++left;
                }
                datas[right] = datas[left]; // 将比枢轴大的元素移到高端，此时left位相当于空，等待高位比pivot  key小的数补上
            }
        }
        datas[left] = pivot; // 当left == right，完成一趟快速排序，此时left位相当于空，等待pivot  key补上
        return left;
    }

    /**
     * 快速排序；递归返回数组
     * 
     * @param datas
     */
    public static int[] sortQuick(int[] datas, int left, int right) {
        if (left < right) {
            int data = QuickPartition(datas, left, right);
            sortQuick(datas, left, data - 1);
            sortQuick(datas, data + 1, right);
        }
        return datas;
    }

}
