package data.structures.algorithm.datastructure.newstudy.array.utils;

/**
 * 查询数组元素工具类
 * Tools Class for querying array elements
 *
 * @author starrysky
 */
public class SearchUtils {

    /**
     * 线性查询某一个数是否在数组里，存在则返回对应的索引
     * Liner Query whether a certain number is in the array,if it exists,return the corresponding index
     *
     * @param number 需要查询的数据 The data to be queried
     * @return 返回索引值 return index value
     */
    public int linerSearchElement(int number, int[] array) {
        // 对索引赋值，-1 为不存在
        int index = -1;
        // 遍历原数组，查询是否存在指定数据data，存在则将index赋值为指定的索引值
        for (int i = 0; i < array.length; i++) {
            if (array[i] == number) {
                index = i;
                break;
            }
        }
        return index;
    }


    /**
     * 二分法查找元素
     * Binary Search Element
     * The Target element is smaller than the middle element so the target element is on the left of Array. SET end to mid -1
     * The target element is larger than the middle element, and the target element is on the right. Set begin to mid + 1
     * IF there is no match at all,mid will be reassigned
     *
     * @param number 需要查找的元素 The Element to be Queried
     * @param array  输入数组  ARRAY IS inputted
     * @return index
     */
    public int binarySearchElement(int number, int [] array) {
        // 索引位置 index position
        int index = -1;
        // 开始位置 (基于索引)
        int begin = 0;
        // 结束位置 (基于索引)
        int end = array.length - 1;
        // 中间位置 (基于索引)
        int mid = (begin + end) / 2;
        //
        while (true) {
            if (array[mid] == number) {
                return mid;
            }else if (begin >= end) {
                // 查找不带元素则退出
                return -1;
            } else {
                // 目标元素小于中间元素，目标元素在左方 将 end 设置为 mid -1
                // The Target element is smaller than the middle element so the target element is on the left of Array. SET end to mid -1
                if (array[mid] > number) {
                    end = mid - 1;
                } else {
                    // 目标元素大于中间元素，目标元素在右方 将 begin 设置为 mid + 1
                    // The target element is larger than the middle element, and the target element is on the right. Set begin to mid + 1
                    begin = mid + 1;
                }
                // 全不匹配则重新赋值mid
                // IF there is no match at all,mid will be reassigned
                mid = (begin + end) / 2;
            }

        }
    }
}
