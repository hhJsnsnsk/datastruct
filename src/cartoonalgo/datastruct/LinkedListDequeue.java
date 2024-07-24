package cartoonalgo.datastruct;

/**
 * 链表实现双向队列
 *
 * @author starrysky
 */
public class LinkedListDequeue {

    /**
     * 链表节点
     * 存储节点信息：值，前驱节点，后继节点
     */
    class LinkedNode {
        // 节点值
        int val;
        // 后继节点
        LinkedNode next;
        // 前驱节点
        LinkedNode prev;

        /**
         * 构造函数 初始化节点值，前后节点
         *
         * @param num 节点值
         */
        LinkedNode(int num) {
            this.val = num;
            prev = next = null;
        }
    }

    // 头节点
    LinkedNode front;
    // 尾节点
    LinkedNode rear;
    private int dequeSize = 0;

    public LinkedListDequeue() {
        front = rear = null;
    }

    /**
     * 返回队列长度
     *
     * @return num
     */
    public int size() {
        return dequeSize;
    }

    /**
     * 判断是否为空
     *
     * @return boolean
     */
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * 插入队列
     * 队首、队尾，或空队
     * 双向队列，在参数里判断并选择是队首或队尾
     *
     * @param num     插队元素
     * @param isFront 判断插入位置
     */
    public void push(int num, boolean isFront) {
        LinkedNode node = new LinkedNode(num);
        //  若队列为空
        if (isEmpty()) {
            // 如果是空队列
            front = rear = node;
        }
        //  插入队首
        if (isFront) {
            // 原本 front.prev 为空，新赋值
            front.prev = node;
            node.next = front;
            // 更新头节点
            front = node;
        } else {
            // 插入队尾
            node.prev = rear;
            rear.next = node;
            // 更新
            rear = node;
        }
        // 插入成功 +1
        dequeSize++;
    }

    /**
     * 插入队首
     *
     * @param num 元素
     */
    public void pushFirst(int num) {
        push(num, true);
    }

    /**
     * 插入队尾
     *
     * @param num 元素
     */
    public void pushLast(int num) {
        push(num, false);
    }

    /**
     * 出队
     * 先判断头或尾部出队
     * 头部出队情况，若front.next不为空，则队列有多个元素 将front的next赋值为null
     * 新头节点的前驱节点赋值为空
     * ==
     * 尾部出队情况，若rear的前驱节点不为空，则队列有多个元素
     * 将rear的前驱节点的后继节点赋值为空，则可赋值新尾部节点
     * @param isFront
     * @return
     */
    public int pop(boolean isFront) {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException();
        }
        int val;
        //  队首出队
        if (isFront) {
            // 存储原头节点队值
            val = front.val;
            // 存储新的头节点的对象
            LinkedNode fNext = front.next;
            if (fNext != null) {
                // 如果原队列不只一个元素
                // 两步删除原头节点
                fNext.prev = null;
                front.next = null;
            }
            // 赋值新头节点
            front = fNext;
        } else {
            //  队尾出队
            val = rear.val;
            LinkedNode rPrev = rear.prev;
            if (rPrev != null) {
                // 删除尾节点
                rPrev.next = null;
                rear.prev = null;
            }
            // update
            rear = rPrev;
        }
        dequeSize--;
        return val;
    }

    /**
     * delete队首
     */
    public void popFirst() {
        pop(true);
    }

    /**
     * delete队尾
     */
    public void popLast() {
        pop(false);
    }

    /**
     * 获取头部节点
     * @return num
     */
    public int peekFirst(){
        if (isEmpty()) {
            throw new IndexOutOfBoundsException();
        }
        return front.val;
    }

    /**
     * 获取尾部节点
     * @return num
     */
    public int peekLast(){
        if (isEmpty()) {
            throw new IndexOutOfBoundsException();
        }
        return rear.val;
    }

    /**
     * 返回数组打印
     * @return array
     */
    public int[] toArray() {
        int[] array = new int[size()];
        LinkedNode node = front;
        for (int i = 0; i < array.length; i++) {
            array[i] = node.val;
            node = node.next;
        }
        return array;
    }

    public static void main(String[] args) {
        LinkedListDequeue dequeue = new LinkedListDequeue();
        dequeue.push(1,true);
        dequeue.push(2,true);
        dequeue.push(3,true);
        dequeue.push(1,false);
        dequeue.popLast();
        for (int i = 0; i < dequeue.toArray().length; i++) {
            System.out.println(dequeue.toArray()[i]);
        }
    }


}
