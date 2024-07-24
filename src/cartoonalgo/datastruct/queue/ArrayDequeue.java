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

}
