package data.structures.algorithm.analysis;

import java.util.Random;

/**
 * 求模不能对 A B 进行比例简化，否则可能会得出不同的模
 * 模运算：如果 N 整除 A-B ，那么 A 与 B 同 N 求模的值相等
 */
public class ModAlgor {

    /**
     * 验证模运算的定律
     *
     * @param a a>b
     * @param b b<a
     * @param c a+b>c
     * @return
     */
    public static boolean mod(int a, int b, int c) {
        return (a - b) % c == 0 && a % c == b % c;
    }

    public static void main(String[] args) {
//        System.out.println(1 % 10);
//        System.out.println(2 % 10);
//        System.out.println(3 % 10);
//        System.out.println(4 % 10);
//        System.out.println(5 % 10);
//        System.out.println(11 % 10);
//        System.out.println(10 % 10);
//        System.out.println(15 % 10);
//        System.out.println(3 % 2);
        System.out.println(mod(20,10,10));
        ModAlgor modAlgor = new ModAlgor();
        System.out.println(modAlgor.test1());
        System.out.println(modAlgor.test3());

    }

    private int test1() {
        return new Random().nextInt(test2());
    }

    public static int test2() {
        return 10;
    }

    public boolean test3() {
        for (int i = 100;i>100;i--) {
            if (true) {
                i = -1;
                return true;
            }
        }
        return false;
    }

}
