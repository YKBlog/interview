package algorithm;

/**
 * 二分查找
 * 
 * @Title: BinarySearch.java
 * @Description: <br>
 * <br>
 * @Created on 2016年2月17日 下午12:11:06
 * @author yangkai
 * @version 1.0
 */
public class BinarySearch {

    /**
     * int 数组查找 迭代实现
     * 
     * @param array
     * @param n
     * @param key
     * @return
     */
    public static int sbForIterator(int[] array, int formIndex, int toIndex, int target) {
        while (formIndex <= toIndex) {
            int mid = (formIndex + toIndex) / 2; // 等同于(lower+higher)>>1  最好使用位移的方式，防止溢出；当数组的中元素个数很多时候，至少大于INT_MAX/2,当left和right都是接近INT_MAX.二者相加就可能得到一个负数
            if (target < array[mid]) {
                toIndex = mid - 1;
            } else if (target > array[mid]) {
                formIndex = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    /**
     * int 数组查找 递归实现
     * 
     * @param array
     * @param formIndex
     * @param toIndex
     * @param target
     * @return
     */
    public static int sbForRecursion(int[] array, int formIndex, int toIndex, int target) {
        while (formIndex <= toIndex) {
            int mid = (formIndex + toIndex) >> 1;
            if (target < array[mid]) {
                return sbForRecursion(array, formIndex, mid - 1, target);
            } else if (target > array[mid]) {
                return sbForRecursion(array, mid + 1, toIndex, target);
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array = { 1, 3, 5, 7, 9, 11, 13, 15 };
        int formIndex = 1;
        int toIndex = array.length;
        int target = 11;
        //int result = sbForIterator(array, formIndex, toIndex, target);
        int result = sbForRecursion(array, formIndex, toIndex, target);
        System.out.println(result);
    }
}
