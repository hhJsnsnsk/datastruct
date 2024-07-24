import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * @author starrysky
 */
public class Test {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] array = IntStream.concat(IntStream.of(nums1), IntStream.of(nums2)).toArray();
        Arrays.sort(array);
        int length = array.length;
        int midIndex = length / 2;
        double mid;
        if (length % 2 == 0) {
            mid = (double) (array[midIndex - 1] + array[midIndex]) / 2;
        } else {
            mid = array[midIndex];
        }
        return mid;
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{1, 3};
        int[] arr2 = new int[]{2};
        Test test = new Test();
        System.out.println(test.findMedianSortedArrays(arr1, arr2));
    }
}
