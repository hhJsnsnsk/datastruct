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
     *
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
     * 删除指定索引的元素
     *
     * @param index 需要删除的数据所在的索引
     * @return 成功返回 1 失败返回 0
     */
    public int deleteElement(int index) {
        // 创建新数组
        int[] newArr = new int[array.length - 1];
        // 遍历新数组，将旧数组需要的元素复制
        for (int i = 0; i < newArr.length; i++) {
            if (i < index) {
                newArr[i] = array[i];
            } else {
                newArr[i] = array[i + 1];
            }
        }
        // 将新数组 替换 到 旧数组
        array = newArr;
        return 1;
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
