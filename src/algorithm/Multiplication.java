package algorithm;
/**
 * 
 * @Title: Multiplication.java
 * @Description: <br>
 *               <br>递归输出乘法口诀
 * @Created on 2016年3月12日 下午3:54:11
 * @author yangkai
 * @version 1.0
 */
public class Multiplication {

    /**
     * 递归输出 乘法口诀
     */
    public static void printMulitiplyTable() {
        for (int i = 1; i < 10; i++) {
            for (int j = 1; j < i + 1; j++) {
                System.out.print(i + "*" + j + "=" + i * j + "    ");
            }
            System.out.println("");
        }
    }

}
