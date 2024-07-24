package cartoonalgo.datastruct.queue;

/**
 * 链表实现队列
 *
 * @author starrysky
 */
public class LinkedListQueue {

    // 队首，队尾
    private LinkedNode front, rear;
    // 队列长度
    private int queSize = 0;

    /**
     * 对象工具
     */
    class LinkedNode {
        int val;
        LinkedNode next;
        LinkedNode prev;

        public LinkedNode(int val) {
            this.val = val;
            next = prev = null;
        }
    }

    /**
     * 构造函数初始化队首队尾为空
     */
    public LinkedListQueue() {
        front = rear = null;
    }

    /**
     * 访问队首
     *
     * @return num
     */
    public int peek() {
        if (isEmpty()){
            throw new IndexOutOfBoundsException();
        }
        return front.val;
    }

    /**
     * 入队操作
     *
     * @param num 入队元素
     */
    public void push(int num) {
        // 入队是在尾节点后添加
        LinkedNode node = new LinkedNode(num);
        // 如果空队列
        if (front == null) {
            // 队首和队尾均指向新入列到元素
            front = rear = node;
        } else {
            //如果不为空，则添加到队尾
            rear.next = node;
            rear = node;
        }
        // 入队成功，长度+1
        queSize++;
    }

    /**
     * 出队操作
     * @return num
     */
    public int pop() {
        if (isEmpty()){
            throw new IndexOutOfBoundsException();
        }
        int peek = peek();
        // 删除队首
        front = front.next;
        queSize--;
        return peek;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * 返回队列长度
     * @return num
     */
    public int size() {
        return queSize;
    }


}
