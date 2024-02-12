package data.structures.algorithm.datastructure.queue;

import java.util.Arrays;

/**
 * 循环队列 队尾指针指向的位置永远空出一位，所以队列最大容量比数组长度小1
 * 隊列的操作 此队列以数组为物理结构
 * 入隊
 * 出隊
 * 输出队列
 *
 * @author starrysky
 */
public class MyQueue {
    /**
     * 初始化数组 在构造器中装载新数组
     */
    private final int[] array;
    /**
     * 队头元素
     */
    private int front;
    /**
     * 队尾元素
     */
    private int rear;

    /**
     * 构造器，用于新建数组
     *
     * @param size 队列数组长度
     */
    public MyQueue(int size) {
        this.array = new int[size];
    }

    /**m
     * 入队操作
     * 先判断队头和队尾元素 指向的 下一个 下标是否相同 相同则队列满 ** 最后一个元素 的 下一个索引 为 队尾 **
     * 成功入队后，队尾元素下标执行 (rear + 1) % array.length 动态变化
     *
     * @param element 入队元素
     * @throws Exception 队列已满异常
     */
    public void enQueue(int element) throws Exception {
        if (front == (rear + 1) % array.length) {
            throw new Exception("队列元素已满!");
        }
        array[rear] = element;
        // 成功入队后，队尾索引变化 移动到原队尾的下一个索引。如果队尾下一个索引等于数组长度，即 +1 再进行求余，根据循环队列，此时得数 = 队头索引 以此来判断是否满队列
        rear = (rear + 1) % array.length;
    }

    /**
     * 出队
     * 先判断队列是否为空 通过 rear == front 判断
     * 队头出队后，将队头索引动态变化 ： front = (front + 1) % array.length
     *
     * @return 返回被移除的队头
     * @throws Exception 队列为空异常
     */
    public int deQueue() throws Exception {
        if (rear == front) {
            throw new Exception("队列已清空！");
        }
        // 被移除的队头
        int deQueueElement = array[front];
        // 队头索引变化 移动到原队头的下一个索引
        front = (front + 1) % array.length;
        return deQueueElement;
    }

    /**
     * 输出循环队列
     * 物理结构为数组，所以遍历数组元素的坐标，得到数组元素
     * 将队头赋值给i，如果i 不等于 队尾坐标，则输出。i 执行循环队列的的求余操作
     */
    public void outQueue() {
        for (int i = front; i != rear; i = (i + 1) % array.length) {
            System.out.println(array[i]);
        }
    }

    @Override
    public String toString() {
        return "MyQueue{" +
                "array=" + Arrays.toString(array) +
                ", front=" + front +
                ", rear=" + rear +
                '}';
    }
}
