package data.structures.algorithm.datastructure.queue;

/**
 * 队列操作
 *
 * @author starrysky
 */
public class QueueOp {
    MyQueue mq = new MyQueue(3);

    public static void main(String[] args) throws Exception {
        MyQueue mq = new MyQueue(5);
        mq.enQueue(1);
        mq.enQueue(2);
        mq.enQueue(3);
        mq.enQueue(4);
        //mq.enQueue(5);
        mq.outQueue();
        mq.deQueue();
        mq.deQueue();
        mq.outQueue();
    }
}
