package data.structures.algorithm.analysis;

public class RecursiveAlgorithmDemo1 {

    /**
     *
     * f(3)
     *
     * f函数的参数为1时,值 = 1
     * f函数的参数为2时,值 = 7
     * f(1) + f(2) = 8
     * f函数的参数为3时,值 = 30
     * f(1) + f(2) + f(3) = 38
     *
     * n=3, 3*f(2) + 9
     * n=2, 3*f(1) + 4
     * n=1, 3*f(0) + 1
     * n=0, 0
     *
     * n=1, 3*0 + 1 = 1
     * n=2, 3*1 + 4 = 7
     * n=3, 3*7 + 9 = 30

     * 1.当n=3时，递归进入f(n)，因为f()里的参数进行运算 -1 ，每一步都逐层深入
     * 2.最终指向return为0时，递归结束，函数取得了数值，再将这一数值向上逐层运算，最终返回到n=3时，具体的数值运算
     * 3.最终递归得出f映射值
     *
     * @param n
     * @return
     */
    public static int f(int n) {
        if (n == 0) {
            return 0;
        } else {
            return 3 * f(n - 1) + n * n;
        }
        //简洁写法 : return n == 0 ? 0 : 3 * f(n - 1) + n * n;
    }


    /**
     * 等差数列， 3 5 7 9 11 13 15....... ,差值2 验证递归
     * 结论： 此方法返回数列的第n个通项
     *
     * @param n
     * @return
     */
    public static int f2(int n) {
        return n == 0 ? 0 : 2 * n + 1;
    }


    /**
     * test
     * @param n
     * @return
     */
    public static int f3(int n) {
        return n == 9 ? 0 : f3(2 * (n - 1) + 1);
    }


    public static void main(String[] args) {
        System.out.println("f函数的参数为1时,值 = " + f(1));
        System.out.println("f函数的参数为2时,值 = " + f(2));
        System.out.println("f(1) + f(2) = " + (f(1) + f(2)));
        System.out.println("f函数的参数为3时,值 = " + f(3));
        System.out.println("f(1) + f(2) + f(3) = " + (f(1) + f(2) + f(3)));

        System.out.println("=====================================");
        System.out.println(f2(1));
        System.out.println(f2(2));
        System.out.println(f2(3));
        System.out.println(f2(4));


        System.out.println("=====================================");
        System.out.println("函数f3：n=2时，值 = " + f3(2));
//        System.out.println(f3(2));
//        System.out.println(f3(3));
//        System.out.println(f3(4));

//        System.out.println(f(1));
    }

}
