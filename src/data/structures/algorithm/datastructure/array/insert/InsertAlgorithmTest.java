package data.structures.algorithm.datastructure.array.insert;

/**
 * 中间插入算法 测试
 */
public class InsertAlgorithmTest {

    private int[] array;
    private int size;

    public InsertAlgorithmTest(int capacity) {
        this.array = new int[capacity];
        this.size = 0;
    }

    /**
     *
     * @param index    插入的索引
     * @param element  插入的元素
     *                 判断插入的索引是否符合标准
     *                 再进行挪位和最终插入元素
     */
    public void insert(int index, int element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("the array's size has out of bounds ");
        }
        // from right to left circle ,and make the element move a position one by one
        for (int i = size - 1; i >= index; i--) {
            array[i + 1] = array[i];
        }
        // put the new element to spare location
        array[index] = element;
        size++;
    }

    public void printArray() {
        for (int i = 0; i < size; i++) {
            System.out.println(array[i]);
        }
    }

    public static void main(String[] args) {
        InsertAlgorithmTest test = new InsertAlgorithmTest(10);
        test.insert(0,1);
        test.insert(1,2);
        test.insert(2,3);
        test.insert(1,10);
        test.printArray();
        System.out.println("test size = " + test.size);
    }



}


