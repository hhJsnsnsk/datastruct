package datastruct.array;

/**
 * @author starrysky
 */
public class ArrayTrainDemo {
    private int[] array;
    private int size;

    public ArrayTrainDemo(int capacity) {
        this.array = new int[capacity];
        size = 0;
    }

    public void insert(int index, int element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("数组越界异常");
        }
        // TODO 扩容数组
        if (size >= array.length) {
            resize();
        }

        for (int i = size - 1; i >= index; i--) {
            array[i + 1] = array[i];
        }
        array[index] = element;
        size++;
    }

    public void resize() {
        int[] newArray = new int[array.length * 2];
        System.arraycopy(array, 0, newArray, 0, array.length);
        array = newArray;
    }

    public void output() {
        for (int i = 0; i < size; i++) {
            System.out.printf(array[i] + ",");
        }
    }

    public int delete(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("数组越界异常");
        }
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        size--;
        return array[index];
    }

    public static void main(String[] args) throws Exception {
        ArrayTrainDemo demo = new ArrayTrainDemo(4);
        demo.insert(0, 1);
        demo.insert(1, 1);
        demo.insert(2, 1);
        demo.insert(3, 6);
        demo.insert(2, 4);
        demo.output();
        System.out.println("================");
        demo.delete(4);
        demo.output();
        System.out.println("length=" + demo.array.length);
    }
}
