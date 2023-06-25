package data.structures.algorithm.datastructure.newstudy.array;

import data.structures.algorithm.datastructure.newstudy.array.utils.ArrayUtils;
import data.structures.algorithm.datastructure.newstudy.array.utils.SearchUtils;

/**
 * 数组测试类
 * @author starrysky
 */
public class ArrayTest {

    private static final int[] ARRAY_TEST = new int[]{99,99,98,97,96,95,94,93,92,91,90,0,0,1,1,2,2,33,44,55,6};

    public static void main(String[] args) {
        ArrayUtils utils = new ArrayUtils();
        SearchUtils su = new SearchUtils();
        utils.addElement(10);
        utils.addElement(10);
        utils.addElement(10);
        utils.addElement(10);
        System.out.println(utils.getSize());
        utils.printArray();
        utils.printArray();
        utils.insertElement(3,88);
        utils.printArray();
        System.out.println(utils.getElement(4));
        System.out.println("======================");
        System.out.println(su.linerSearchElement(99, ARRAY_TEST));
    }
}
