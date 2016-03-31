package algorithm;

/**
 * 
 * @Title: MaxSubSequence.java
 * @Description: <br>
 * <br>
 *               求最大子序列
 * @Created on 2016年3月14日 下午6:47:41
 * @author yangkai
 * @version 1.0
 */
public class MaxSubSequence {

    /**
     * 解法一：时间复杂度 o(n)
     * 当遍历到第i个元素时，判断在它前面的连续子序列和是否大于0，如果大于0，则以位置i结尾的最大连续子序列和为元素i和前面的连续子序列和相加
     * ；否则，则以位置i结尾的最大连续子序列和为元素i
     * 
     * @param data
     * @return
     */
    public static int getMaxSubSeqSum(int[] data) {
        int result, flag;
        result = flag = data[0]; // 初始化最大值和当前最大子序列和为第一个元素
        for (int i = 1; i < data.length; i++) {
            if (result > 0)
                result += data[i];
            else
                result = data[i];
            flag = result > flag ? result : flag;
        }
        return flag;
    }

    /**
     * 解法二：时间复杂度 o(n^2) 最普通解法，嵌套循环计算
     * 
     * @param arr
     * @param len
     * @return
     */
    public static int getMaxSubSeqSum2(int data[]) {
        int max = data[0]; // 初始化最大值为第一个元素
        for (int i = 0; i < data.length; i++) {
            int sum = 0; // sum必须清零
            for (int j = i; j < data.length; j++) { // 从位置i开始计算从i开始的最大连续子序列和的大小，如果大于max，则更新max。
                sum += data[j];
                if (sum > max)
                    max = sum;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] data = { 3, 6, -4, 2, -9, 5, 7 };
        int reslut = getMaxSubSeqSum(data);
        int reslut2 = getMaxSubSeqSum2(data);
        System.out.println(reslut);
        System.out.println(reslut2);
    }
}
