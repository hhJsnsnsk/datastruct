package data.structures.algorithm.datastructure.newstudy.array;

import java.util.Arrays;

/**
 * 数组扩容和增加数据
 * @author starrysky
 */
public class ArrayExtern {

    public static void main(String[] args) {
        int[] array = {1, 2, 3,3,545,7,78,7};
        int newNum = 20;
        int[] extern = new ArrayExtern().arrayExtern(array,newNum);
        System.out.println(Arrays.toString(extern));
    }

    /**
     *
     * 数组扩容算法
     * @param arr 原数组
     * @param newNum 新增数据，增加到最后一个索引
     * @return 返回扩容后的数组
     */
    private int[] arrayExtern(int[] arr,int newNum){
        int[] newArray = new int[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            newArray[i] = arr[i];
        }
        newArray[arr.length] = newNum;
        return newArray;
    }


}
