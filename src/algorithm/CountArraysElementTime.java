package algorithm;


import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

/**
 * 
 * @Title: CountArraysElementTime.java
 * @Description: <br>
 * <br>
 *               题目：给定一个数组，求出每个数据出现的次数并按照次数的由大到小排列出来
 * @Created on 2016年3月5日 下午5:30:38
 * @author yangkai
 * @version 1.0
 */
public class CountArraysElementTime {

    public static void main(String[] args) {
        int[] arrays = {2,3,6,9,2,3,5,6,9,6,2,5,9,2,2,2,5,7,9};
        countAndSort(arrays);
    }
    
    /**
     * 输出统计排序后的结果
     * @param arrays
     */
    public static void countAndSort(int[] arrays) {

        Map<Integer, Integer> map = count(arrays);
        List<Map.Entry<Integer, Integer>> list = sort(map);
        for (Map.Entry<Integer, Integer> entry : list) {
            System.out.println(entry.getKey() + "-" + entry.getValue());
        }
    }

    /**
     * 对map中元素进行排序
     * 
     * @param map
     */
    public static List<Map.Entry<Integer, Integer>> sort(Map<Integer, Integer> map) {
        List<Map.Entry<Integer, Integer>> list = Lists.newArrayList(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {

            @Override
            public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });
        return list;
    }

    /**
     * 统计出数组元素个数，存放在一个map中，key为数组元素，value为数组中出现的个数
     * 
     * @param arrays
     * @return
     */
    public static Map<Integer, Integer> count(int[] arrays) {
        Map<Integer, Integer> map = Maps.newHashMap();
        for (int i : arrays) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i)+1);
            } else {
                map.put(i, 1);
            }
        }
        return map;
    }
}
