package hello_algo.array_and_linked;

import java.util.Arrays;

/**
 * @author starrysky
 */
public class ArrayDemo {
    /**
     * insert element to array
     *
     * @param arr
     * @param num
     * @param index
     */
    void insertEm(int[] arr, int num, int index) {
        for (int i = arr.length - 1; i > index; i--) {
            arr[i] = arr[i - 1];
        }
        arr[index] = num;
    }

    void deleteEm(int[] arr, int index) {
        for (int i = index; i < arr.length - 1; i++) {
            arr[i] = arr[i + 1];
        }
    }

    public static void main(String[] args) {
        ArrayDemo demo = new ArrayDemo();
        int[] arr = {1, 2, 35, 6};
        //demo.insertEm(arr, 2, 2);
        //System.out.println(Arrays.toString(Arrays.stream(arr).toArray()));
        System.out.println("================");
        demo.deleteEm(arr,2);
        System.out.println(Arrays.toString(arr));
    }
}
