package data.structures.algorithm.test;

import java.util.Arrays;

/**
 * Printing numbers pages for MI
 * @author Starry Sky T0
 */
public class PrintNum {

    /**
     * 打印的纸张数
     */
    private static final int NUM_PAGES = 20;

    /**
     * 开始页码
     */
    private static final int START_PAGES = 1;

    public static void main(String[] args) {
        int[] array = new int[NUM_PAGES];
        long start = System.currentTimeMillis();
        System.out.println("正面打印页码：" + Arrays.toString(new PrintNum().printOddNumbers(START_PAGES,array)));
        System.out.println("反面打印页码：" + Arrays.toString(new PrintNum().printEvenNumbers(START_PAGES,array)));
        long end = System.currentTimeMillis();
        System.out.println("执行耗时：" + (end - start) + "毫秒");
    }

    /**
     * 正面打印页码
     * @param startNumber 开始页数
     * @param containers 装载纸张数的数组容器
     * @return 返回正面页码数组
     */
    private int[] printOddNumbers(int startNumber, int[] containers) {
        for (int i = 0; i < NUM_PAGES; i++) {
            containers[i] = startNumber;
            startNumber = startNumber + 2;
        }
        return containers;
    }

    /**
     * 反面打印页码
     * @param startNumber 开始页数
     * @param containers 装载纸张数的数组容器
     * @return 返回反面页码数组
     */
    private int[] printEvenNumbers(int startNumber, int[] containers) {
        int startEvenNumber = startNumber + 1;
        for (int i = 0; i < NUM_PAGES; i++) {
            containers[i] = startEvenNumber;
            startEvenNumber = startEvenNumber + 2;
        }
        return containers;
    }
}
