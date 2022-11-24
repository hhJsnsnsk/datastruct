package data.structures.algorithm.datastructure.array.insert;

/**
 * 非超范围在数组中间插入元素算法
 */
public class InsertAndDeleteAlgorithm1 {

    //定义数组
    private int[] array;

    /*定义数组大小size，每次插入都让size + 1，以便后续统计数组大小。构造函数初始化设置为0
        size即数组随着插入元素的次数随着增加，等同与数组每次插入元素，每次 + 1 ，数组大小 = size
    */
    private int size;

    /**
     * 构造器，构造类对象时，可在内初始化数组大小和 size 的初始值。
     *
     * @param capacity 数组大小
     */
    public InsertAndDeleteAlgorithm1(int capacity) {
        this.array = new int[capacity];
        this.size = 0;
    }

    /**
     * 因为是测试在数组中间插入元素，此算法需要遵循从右向左遍历，将遍历的元素往右移动一个单位。
     * 遍历终止条件在插入的元素索引(@param : index) 小于等于 (数组大小 - 1) : 递减的 i
     * 即从右向左遍历，当插入目标的索引位置(index)遇到遍历逐个递减的索引的下标数值为 【相同】 时，
     * 原有的数组元素(目标index旧的数组元素)仍然要继续向右移动一位，才能让新的元素(element)插入到这个空闲的位置(spare location)
     * 索引 需要的是 ===== index <= (size -1)：即变化中的 (i--)
     * 如果布尔值为 false 就 结束元素右移操作，最终可以将插入操作(element放在index的位置上)完成
     *
     * @param index   插入元素的索引
     * @param element 插入的元素
     */
    public void insertElementToArray(int index, int element) {
        // 先判断索引是否符合插入元素规范 index<0是必须的，index>size，即索引不超过数组的容量值 注意：size一开始赋值为 0
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("超过数组索引范围");
        }
        /* 从右向左遍历，所以需要将 i = 数组大小 - 1，即数组下标最大值。 i-- 即从右遍历。
        因为i赋值为索引最大值，并且进行--操作，所以会一步步的从右往左，最终遇到循环终止条件成立。
        */
        for (int i = size - 1; i >= index; i--) {
            // 右移操作：将左边的元素赋值到右边的索引位置元素
            array[i + 1] = array[i];
        }
        // 此处进行插入操作。如果是第一步，数组元素为空，会直接进行到这一代码，而不是上面的右移逻辑
        array[index] = element;
        size++;
    }

    /**
     * 打印数组
     */
    public void printArray() {
        for (int i = 0; i < size; i++) {
            System.out.println(array[i]);
        }
    }


    /**
     * 数组扩容
     */
    public void reArray() {
        int[] newArray = new int[array.length * 2];
        // 复制旧数组到新数组
        System.arraycopy(array, 0, newArray, 0, array.length);
        array = newArray;
    }

    /**
     * 删除元素操作
     * 将索引及其右边的元素全部遍历，然后左移。
     * 删除即 将 原有元素 进行右边的元素代替。
     * @param index
     * @return
     */
    public int deleteElement(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("数组越界异常");
        }
        int deletedElement = array[index];
        for (int i = index; i < array.length - 1; i++) {
            array[i] = array[i + 1];
        }
        size--;
        return deletedElement;
    }


    public static void main(String[] args) {
        InsertAndDeleteAlgorithm1 algorithm1 = new InsertAndDeleteAlgorithm1(10);
        algorithm1.insertElementToArray(0, 1);
        algorithm1.insertElementToArray(1, 1);
        algorithm1.insertElementToArray(2, 1);
        algorithm1.insertElementToArray(3, 1);
        algorithm1.printArray();
        System.out.println("此处的数组大小size为 ：" + algorithm1.size);
        //中间插入操作
        algorithm1.insertElementToArray(1, 10);
        algorithm1.printArray();
        System.out.println("此处的数组大小size为 ：" + algorithm1.size);

        System.out.println("==========删除操作========");
        algorithm1.deleteElement(0);
        algorithm1.printArray();
        System.out.println("此处的数组大小size为 ：" + algorithm1.size);
    }


}
