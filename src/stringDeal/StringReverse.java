package stringDeal;

/**
 * 
 * @Title: StringReverse.java
 * @Description: <br>
 * 
 *               <pre>
 * 字符串反转
 * 1.反转单词；比如“hello word ！” ，输出 “！word hello”
 * 2.反转字符串；比如“hello word”，输出“drow olleh”
 * 
 *               <pre>
 * @Created on 2016年3月21日 上午11:17:25
 * @author yangkai
 * @version 1.0
 */
public class StringReverse {

    /**
     * 反转单词
     * 
     * @param word
     *            输入单词
     * @param pattern
     *            分割模式
     * @return
     */
    public static String reverseWord(String word, String pattern) {
        StringBuilder result = new StringBuilder();
        String strs[] = word.split(pattern);
        for (int i = strs.length - 1; i >= 0; i--) {
            result.append(strs[i]);
            if (i != 0)
                result.append(pattern);
        }
        return result.toString();
    }

    /**
     * 反转整个字符串 <br>
     * 方法一：stringbuilder的reverse方法
     * 
     * @param word
     *            输入单词
     * @return
     */
    public static String reverseString1(String word) {
        StringBuilder result = new StringBuilder(word).reverse();
        return result.toString();
    }

    /**
     * 反转整个字符串 <br>
     * 方法二：charAt 取出循环倒叙字符串
     * 
     * @param word
     *            输入单词
     * @return
     */
    public static String reverseString2(String word) {
        StringBuilder result = new StringBuilder();
        for (int i = word.length() - 1; i >= 0; i--) {
            result.append(word.charAt(i) + "");
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String word = "hello word !";
        String result = reverseWord(word, " ");
        System.out.println(result);

        String result1 = reverseString1(word);
        System.out.println(result1);
    }
}
