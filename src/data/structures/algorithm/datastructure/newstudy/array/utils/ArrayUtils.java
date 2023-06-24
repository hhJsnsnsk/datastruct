package data.structures.algorithm.datastructure.newstudy.array.utils;

import java.util.Arrays;

/**
 * 整型数组工具类
 * INT array utils class
 *
 * @author starrysky
 */
public class ArrayUtils {
    /**
     * 定义数组
     */
    private int[] array;

    public ArrayUtils() {
        array = new int[0];
    }

    /**
     * 增加 一个 数组元素
     * @param element 数组元素数据
     */
    public void addElement(int element) {
        // 新建一个数组 长度比原数组 + 1
        int[] newArr = new int[array.length + 1];
        // 复制原数组到新数组 此处遍历 **原数组** 最后一个索引用于新增元素
        for (int i = 0; i < array.length; i++) {
            newArr[i] = array[i];
        }
        // 将新元素增加到新数组
        newArr[getSize()] = element;
        // 将新数组复制到旧数组 完成替换
        array = newArr;
    }

    /**
     * 返回数组长度
     *
     * @return array's length
     */
    public int getSize() {
        return array.length;
    }

    /**
     * 打印数组
     */
    public void printArray() {
        System.out.println(Arrays.toString(array));
    }


}
