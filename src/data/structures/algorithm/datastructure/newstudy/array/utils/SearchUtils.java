package data.structures.algorithm.datastructure.newstudy.array.utils;

/**
 * 查询数组元素工具类
 * Tools Class for querying array elements
 * @author starrysky
 */
public class SearchUtils {

    /**
     * 查询某一个数是否在数组里，存在则返回对应的索引
     * Query whether a certain number is in the array,if it exists,return the corresponding index
     * @param number 需要查询的数据 The data to be queried
     * @return 返回索引值 return index value
     */
    public int linerSearchElement(int number,int[] array) {
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

}
