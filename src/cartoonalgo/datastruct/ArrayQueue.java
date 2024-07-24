package cartoonalgo.datastruct;

import java.util.Arrays;

/**
 * 环形数组实现队列
 *
 * @author starrysky
 */
public class ArrayQueue {
    // 存储队列元素
    private int[] nums;
    // 队列长度
    private int queSize;
    // 队首指针索引
    private int front;

    /**
     * 构造方法初始化成员变量
     */
    public ArrayQueue(int capacity) {
        nums = new int[capacity];
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
     * 队列是否空
     *
     * @return boolean
     */
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * 获取数组长度
     * @return length
     */
    public int capacity() {
        return nums.length;
    }

    /**
     * 获取队首元素
     * @return num
     */
    public int peek() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException();
        }
        return nums[front];
    }

    /**
     * 入队操作
     *
     * @param num 入队元素
     */
    public void push(int num) {
        // 判断队列是否已满
        if (size() == capacity()) {
            System.out.println("队列已满！");
            return;
        }
        // 入队，进队尾+1 的索引
        // 通过取余操作将队尾越过数组尾部回到头部
        int rear = (front + queSize) % capacity();
        // 入队
        nums[rear] = num;
        // 队列长度 + 1
        queSize++;
    }

    /**
     * 出队操作
     *
     * @return popNum
     */
    public int pop() {
        int peek = peek();
        // 队首元素向后移动一位 若越过数组则回到头部
        front = (front + 1) % capacity();
        queSize--;
        return peek;
    }

    /**
     * 转换有效数组
     * @return array
     */
    public int[] toArray() {
        // 仅转换有效长度数组
        int[] res = new int[queSize];
        for (int i = 0, j = front; i < queSize; i++, j++) {
            res[i] = nums[j % capacity()];
        }
        return res;
    }

    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(10);
        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.push(4);
        queue.push(5);
        queue.push(6);
        for (int i = 0; i < queue.toArray().length; i++) {
            System.out.println(queue.toArray()[i]);
        }
        System.out.println("==================");
        queue.pop();
        for (int i = 0; i < queue.toArray().length; i++) {
            System.out.println(queue.toArray()[i]);
        }
        System.out.println("==================");
        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.push(4);
        queue.push(5);
        for (int i = 0; i < queue.toArray().length; i++) {
            System.out.println(queue.toArray()[i]);
        }
        System.out.println("==================");
        queue.pop();
        queue.pop();
        queue.pop();
        queue.pop();
        queue.push(3);
        queue.push(4);
        queue.push(5);
        for (int i = 0; i < queue.toArray().length; i++) {
            System.out.println(queue.toArray()[i]);
        }
    }

}
