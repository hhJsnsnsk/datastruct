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
     * define array
     */
    private int[] array;

    public ArrayUtils() {
        array = new int[0];
    }

    /**
     * 增加 一个 数组元素
     * add an array element
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
     * 插入元素到指定索引
     * Insert element at specified index
     * @param index   插入索引位置
     * @param element 插入的元素数据
     */
    public void insertElement(int index, int element) {
        if (index < 0 || index == array.length) {
            throw new ArrayIndexOutOfBoundsException("数组越界异常");
        }
        // 新建数组
        int[] newArr = new int[array.length + 1];
        // 遍历原数组，将其元素赋值到新数组 除了需要插入的索引位置外
        for (int i = 0; i < array.length; i++) {
            if (i<index) {
                newArr[i] = array[i];
            }else {
                // 插入的索引之后的元素 赋值
                newArr[i + 1] = array[i];
            }
        }
        // 此时index元素为0，可以将其赋值
        newArr[index] = element;
        // 将新数组复制到原数组
        array = newArr;
    }

    /**
     * 删除指定索引的元素
     * Delete the element at the specified position
     * @param index 需要删除的数据所在的索引
     */
    public void deleteElement(int index) {
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


    }

    /**
     * 返回数组长度
     * Returns the length of the array
     * @return array's length
     */
    public int getSize() {
        return array.length;
    }

    /**
     * 取出指定位置的数组元素
     * Get the array element at the specified position
     * @param index 索引位置
     * @return 返回指定索引数据
     */
    public int getElement(int index) {
        return array[index];
    }

    /**
     * Modifies the element at the specified position
     * 修改指定索引的元素
     * @param index 索引
     * @param element 新数组元素
     */
    public void setArrayElement(int index,int element) {
        array[index] = element;
    }

    /**
     * 打印数组
     */
    public void printArray() {
        System.out.println(Arrays.toString(array));
    }
}


