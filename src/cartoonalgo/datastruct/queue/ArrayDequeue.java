package cartoonalgo.datastruct.queue;

import java.util.Arrays;

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
     *
     * @return nums
     */
    public int capacity() {
        return queue.length;
    }

    /**
     * 返回队首索引
     *
     * @param front 输入获取索引
     * @return num
     */
    public int index(int front) {
        return (front + capacity()) % capacity();
    }

    /**
     * 入队首
     *
     * @param num 插入元素
     */
    public void pushFirst(int num) {
        if (size() == capacity()) {
            throw new IndexOutOfBoundsException("队列已满");
        }
        if (isEmpty()) {
            // 空队列处理
            queue[size()] = num;
        } else {
            // 获取环形数组的索引，经处理数值取为插入的位置
            int index = index(front - 1);
            front = index;
            queue[index] = num;
        }
        queSize++;
    }

    /**
     * 入队尾
     *
     * @param num 插入元素
     */
    public void pushLast(int num) {
        //  满异常处理
        if (size() == capacity()) {
            throw new IndexOutOfBoundsException("队列已满");
        }
        //  空队列处理
        if (isEmpty()) {
            queue[size()] = num;
        } else {
            //  入队
            // 入队尾是需要知道队尾索引！
            int rear = index(front + size());
            // 赋值新队尾元素
            queue[rear] = num;
        }
        //  长度+
        queSize++;
    }

    /**
     * 出队首
     *
     * @return num
     */
    public int popFirst() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException();
        }
        int temp = queue[front];
        // TODO 出队
        front = index(front + 1);
        // TODO 长度--
        queSize--;
        return temp;
    }

    /**
     * 出队尾
     *
     * @return num
     */
    public int popLast() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException();
        }
        int rear = index(front - 1 + size());
        queSize--;
        return queue[rear];
    }

    /**
     * 返回队首
     *
     * @return num
     */
    public int peekFirst() {
        return queue[front];
    }

    /**
     * 返回队尾
     *
     * @return num
     */
    public int peekLast() {
        int rear = index(front - 1 + size());
        return queue[rear];
    }

    /**
     * 返回数组
     *
     * @return num []
     */
    public int[] toArray() {
        int[] array = new int[size()];
        int length = queSize;
        for (int i = 0, j = front; i < length; i++, j = index(j + 1)) {
            array[i] = queue[j];
        }
        return array;
    }

    /**
     * 打印数组
     */
    public void printArray() {
        System.out.println(Arrays.toString(toArray()));
    }

    public static void main(String[] args) {
        ArrayDequeue dequeue = new ArrayDequeue(10);
        dequeue.pushFirst(1);
        dequeue.pushFirst(2);
        dequeue.pushFirst(3);
        dequeue.pushFirst(4);
        dequeue.pushFirst(8);
        dequeue.printArray();
        System.out.println(dequeue.popLast());
        System.out.println(dequeue.peekFirst());
        System.out.println("==========");
        ArrayDequeue dequeue2 = new ArrayDequeue(10);
        dequeue2.pushLast(1);
        dequeue2.pushLast(2);
        dequeue2.pushLast(3);
        dequeue2.pushLast(4);
        dequeue2.pushLast(5);
        dequeue2.printArray();
        System.out.println("==========");
        ArrayDequeue dequeue3 = new ArrayDequeue(10);
        dequeue3.pushLast(1);
        dequeue3.pushLast(2);
        dequeue3.pushLast(3);
        dequeue3.popFirst();
        dequeue3.popFirst();
        dequeue3.printArray();
        System.out.println(dequeue3.popLast());

        System.out.println("==========");
        ArrayDequeue dequeue4 = new ArrayDequeue(10);
        dequeue4.pushLast(1);
        dequeue4.pushLast(2);
        dequeue4.pushLast(3);
        dequeue4.pushLast(4);
        dequeue4.printArray();
        dequeue4.popLast();
        dequeue4.popLast();
        dequeue4.printArray();
        System.out.println(dequeue4.popLast());

    }

}
