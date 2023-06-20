package data.structures.algorithm.datastructure.newstudy.array;

import java.util.Arrays;

/**
 * 数组扩容和增加数据
 *
 * @author starrysky
 */
public class ArrayExtern {

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 3, 545, 7, 78, 7};
        int newNum = 20;
        int[] addArray = new int[]{23,24};
        int[] extern = new ArrayExtern().arrayExtern(array, newNum);
        System.out.println(Arrays.toString(extern));
        System.out.println("======================");
        int[] addedArray = new ArrayExtern().arrayExternArrayByIndex(array, addArray, 3);
        System.out.println(Arrays.toString(addedArray));
    }

    /**
     * 数组扩容算法
     *
     * @param arr    原数组
     * @param newNum 新增数据，增加到最后一个索引
     * @return 返回扩容后的数组
     */
    private int[] arrayExtern(int[] arr, int newNum) {
        int[] newArray = new int[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            newArray[i] = arr[i];
        }
        newArray[arr.length] = newNum;
        return newArray;
    }

    /**
     * 在指定索引上增加多个元素
     *
     * @param arr           原数组
     * @param addArray      增加的数组元素
     * @param addArrayIndex 增加的索引位置
     * @return 返回增加后的索引
     */
    private int[] arrayExternArrayByIndex(int[] arr, int[] addArray, int addArrayIndex) {
        // 数组扩容 原数组的基础上扩增新加进来的元素个数
        int[] newArray = new int[arr.length + addArray.length];
        // 计数器，从 0 到 n 遵循扩容数组的所有索引
        int count = 0;
        // 遍历原数组
        for (int i = 0; i < arr.length; i++) {
            // 检查原数组的索引是否和新增的索引位置相等，相等则遍历新增元素数组，将所有 新增元素 添加到新的扩容数组
            if (i == addArrayIndex) {
                // 遍历新增的数组，将其加入到扩容数组
                for (int j = 0; j < addArray.length; j++) {
                    // 计数器从 0 开始，成功执行后 + 1
                    newArray[count++] = addArray[j];
                }
            }
            // 与索引位置不相同时，正常将原数组添加到扩容数组
            newArray[count++] = arr[i];
        }
        return newArray;
    }
}



