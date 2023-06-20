package data.structures.algorithm.datastructure.newstudy.array;

import java.util.Arrays;

/**
 * 删除数组元素
 *
 * @author starrysky
 */
public class ArrayRemove {

    private static final int INDEX = 2;

    public static void main(String[] args) {
        int[] original = new int[]{1, 2, 3, 4, 5, 6};
        int[] newArray = new ArrayRemove().removeArrayIndex(original, INDEX);
        System.out.println(Arrays.toString(newArray));
        System.out.println("======================");
        int[] indexes = new int[]{1, 2};
        int[] newIndexesArray = new ArrayRemove().removeArrayIndexes(original, indexes);
        System.out.println(Arrays.toString(original));
        System.out.println(Arrays.toString(newIndexesArray));
    }

    /**
     * 删除数组某一个元素
     *
     * @param array 原数组
     * @param index 删除的索引
     * @return 返回新数组
     */
    private int[] removeArrayIndex(int[] array, int index) {
        int[] newArray = new int[array.length - 1];
        for (int i = 0; i < newArray.length; i++) {
            if (i < index) {
                newArray[i] = array[i];
            } else {
                newArray[i] = array[i + 1];
            }
        }
        return newArray;
    }

    /**
     * 删除数组的指定索引数据
     * 先遍历原数组，再与需要删除的索引进行对比，如果需要删除的索引与原数组的索引值相等，则不将原数组赋值到新数组
     * @param array 原数组
     * @param index 索引
     * @return 返回新数组
     */
    private int[] removeArrayIndexes(int[] array, int[] index) {
        int[] newArray = new int[array.length - index.length];
        // 计数器，遵守从 0 到 n 不遗漏，以便赋值原数组到新数组
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            // 判断器，判断需要删除到数组索引，如果 true ，则记录在需要删除的布尔值，用于最后的赋值操作
            boolean isRemoveIndex = false;
            for (int j = 0; j < index.length; j++) {
                if (i == j) {
                    isRemoveIndex = true;
                    break;
                }
            }
            // 索引值不重复，则将原数组需要的数据添加到新数组
            if (!isRemoveIndex) {
                newArray[count++] = array[i];
            }
        }
        return newArray;
    }
}
