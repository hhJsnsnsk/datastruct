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


}
