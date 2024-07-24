package cartoonalgo.datastruct.queue;

/**
 * 数组实现双向队列
 *
 * @author starrysky
 */
public class ArrayDequeue {
    // 存储队列的数组
    private int[] queue;
    // 队列长度
    private int queSize;
    // 队首指针索引
    private int front;

    public ArrayDequeue(int capacity) {
        queue = new int[capacity];
        queSize = front = 0;
    }

    /**
     * 返回队列长度
     *
     * @return num
     */
    public int size() {
        return queSize;
    }

    /**
     * 判断队列是否为空
     *
     * @return boolean
     */
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * 返回数组长度
     * @return nums
     */
    public int capacity(){
        return queue.length;
    }

    /**
     * 返回队首索引
     * @param front 输入获取索引
     * @return num
     */
    public int index(int front) {
        return (front + capacity()) % capacity();
    }

    /**
     * 入队首
     * @param num 插入元素
     */
    public void pushFirst(int num) {
        // TODO 满异常处理

        // TODO 空队列处理

        // TODO 入队

        // TODO 长度+
    }

    /**
     * 入队尾
     * @param num 插入元素
     */
    public void pushLast(int num) {
        // TODO 满异常处理

        // TODO 空队列处理

        // TODO 入队

        // TODO 长度+
    }
    public int popFirst() {
        // TODO 满异常处理

        // TODO 空队列处理

        // TODO 入队

        // TODO 长度+

        return 1;
    }
    public int popLast() {
        // TODO 满异常处理

        // TODO 空队列处理

        // TODO 入队

        // TODO 长度+

        return 1;
    }

    /**
     * 返回队首
     * @return num
     */
    public int peekFirst(){

        return 1;
    }

    /**
     * 返回队尾
     * @return num
     */
    public int peekLast() {

        return 1;
    }

    /**
     * 返回数组
     * @return num []
     */
    public int[] toArray() {

        return new int[1];
    }

}
