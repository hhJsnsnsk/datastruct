package data.structures.algorithm.datastructure.newstudy.array;

import data.structures.algorithm.datastructure.newstudy.array.utils.ArrayUtils;

/**
 * 数组测试类
 * @author starrysky
 */
public class ArrayTest {
    public static void main(String[] args) {
        ArrayUtils utils = new ArrayUtils();
        utils.addElement(10);
        utils.addElement(10);
        utils.addElement(10);
        utils.addElement(10);
        System.out.println(utils.getSize());
        utils.printArray();
        utils.printArray();
        utils.insertElement(39,88);
        utils.printArray();

    }
}
