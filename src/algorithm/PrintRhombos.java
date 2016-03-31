package algorithm;

/**
 * 
 * @Title: PrintRhombos.java
 * @Description: <br>
 * <br>
 *               打印菱形
 * @Created on 2016年3月18日 下午3:24:21
 * @author yangkai
 * @version 1.0
 */
public class PrintRhombos {

    private static void print(int layer, int first, int second) {
        for (int k = 1; k <= second; k++) {
            if (k == first && first != layer) {
                System.out.print("*");
            } else if (k == second) {
                System.out.println("*");
            } else {
                System.out.print("_");
            }
        }
    }

    /**
     * 两个菱形位置
     * 
     * @param layer
     */
    public static void print2(int layer) {

        for (int i = 1; i < layer; i++) {
            int first = 0, second = 0;
            first = layer - i + 1;
            second = layer + i - 1;
            print(layer, first, second);
        }

        for (int i = 1; i < layer; i++) {
            int first = 0, second = 0;
            first = i + 1 - layer;
            second = 3 * layer - i - 1;
            print(layer, first, second);
        }
    }

    /**
     * 两个菱形位置
     * 
     * @param layer
     */
    public static void print1(int layer) {

        int row = 2 * layer;

        for (int i = 1; i < row; i++) {
            int first = 0, second = 0;
            if (i < layer) {
                first = layer - i + 1;
                second = layer + i - 1;
            } else {
                first = i + 1 - layer;
                second = 3 * layer - i - 1;
            }

            print(layer, first, second);

        }
    }

    /**
     * 第一个菱形位置以及第二个到第一个的间距
     * 
     * @param layer
     */
    public static void print3(int layer) {

        int row = 2 * layer;

        for (int i = 1; i < row; i++) {
            int num = 0;
            int index = 0;
            if (i < row / 2) {
                num = (i * 2) - 1;
                index = layer - i + 1;
            } else {
                num = 2 * (row - i) - 1;
                index = layer - (row - i - 1);
            }

            for (int k = 1; k <= index + (num - 1); k++) {
                if (k == index && index != layer) {
                    System.out.print("*");
                } else if (k == index + (num - 1)) {
                    System.out.println("*");
                } else {
                    System.out.print("_");
                }
            }

        }
    }

    public static void main(String[] args) {
        print2(4);
    }
}
