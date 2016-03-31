package algorithm;


/**
 * 算法-判读n是否是2的幂次方；输入的value是n的几次方
 * 
 * @Title: OtherAlgotithm.java
 * @Description: <br>
 * <br>
 * @Created on 2016年2月17日 下午6:20:36
 * @author yangkai
 * @version 1.0
 */
public class Log2 {

    /**
     * 迭代方式 输入的value是n的几次方
     * 
     * @param value
     * @return
     */
    public static int log2ForIterator(int value) {
        int result = 0;
        while (value > 1) {
            value >>= 1; // 相当于value=value>>1;
            result++;
        }
        return result;
    }

    /**
     * 递归方式 判读输入的value是n的几次方
     * 
     * @param value
     * @return
     */
    public static int log2ForRecursion(int value) {
        if (value == 1)
            return 0;
        else
            return 1 + log2ForIterator(value >> 1);
    }

    /**
     * 判读这个数是不是2的幂次方
     * 
     * @param value
     * @return
     */
    public static void judgeLog2(int value) {
        int flag = value & (value - 1);
        if (flag == 0) {
            System.out.println(value + "是2的幂次方");
        } else {
            System.out.println(value + "不是2的幂次方");
        }
    }

    public static void main(String[] args) {
        int reslut = log2ForRecursion(16);
        System.out.println(reslut);
        judgeLog2(20);
    }
}
