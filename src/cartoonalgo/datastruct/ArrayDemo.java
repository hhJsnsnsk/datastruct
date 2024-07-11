package cartoonalgo.datastruct;

/**
 * @author starrysky
 */
public class ArrayDemo {
    private int[] array;
    private int size;

    public ArrayDemo(int capacity) {
        this.array = new int[capacity];
        size = 0;
    }

    /**
     * 插入元素到数组
     *
     * @param index
     * @param element
     * @throws Exception
     */
    public void insert(int index, int element) throws Exception {
        // 判断访问下标是否越界
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("超出数组实际元素范围");
        }

        // 数组扩容
        if (size >= array.length) {
            resize();
        }

        // 从右到左循环，将元素逐个向右挪1位
        for (int i = size - 1; i >= index; i--) {
            array[i + 1] = array[i];
        }
        // 腾出的位置放入新元素
        array[index] = element;
        size++;
    }

    /**
     * 数组扩容
     */
    public void resize() {
        int[] arrayNew = new int[array.length * 2];
        // 从旧数组复制到新数组
        System.arraycopy(array, 0, arrayNew, 0, array.length);
        array = arrayNew;
    }

    /**
     * 输出数组
     */
    public void output() {
        for (int i = 0; i < size; i++) {
            System.out.printf(array[i] + ",");
        }
    }

    /**
     * 删除数组元素
     * @param index
     * @return
     */
    public int delete(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("超出数组实际元素范围");
        }
        int deletedElement = array[index];
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        size--;
        return deletedElement;
    }

    public static void main(String[] args) throws Exception {
        ArrayDemo demo = new ArrayDemo(4);
        demo.insert(0, 1);
        demo.insert(1, 1);
        demo.insert(2, 1);
        demo.insert(3, 1);
        demo.insert(2, 4);
        demo.output();
        System.out.println("================");
        demo.delete(2);
        demo.output();
        System.out.println("length=" + demo.array.length);
    }
}
