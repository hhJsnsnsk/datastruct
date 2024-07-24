package cartoonalgo.datastruct;

/**
 * 实现链表数据结构
 * @author starrysky
 */
public class NodeDemo {
    private static class Node {
        // 存放数据
        int data;
        // next指针
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    // 头节点
    private Node head;
    // 尾节点
    private Node last;
    // 链表长度
    private int size;

    /**
     * 插入数据到链表
     * 空链表插入（当链表长度size == 0）：头节点和尾节点都赋值为插入
     * 头部插入（当index == 0） ：1️⃣ 插入节点的next指针赋值为原head 2️⃣ 新head赋值为插入的节点
     * 尾部插入（当index == 链表长度size）：1️⃣ 原last的next赋值为插入的节点 2️⃣ 新last赋值为插入的节点
     * 中间插入： 1️⃣ 取得插入节点位置的前置节点，通过从头节点遍历到插入位置-1 2️⃣ 插入节点的next指针指向的原位置（前节点）的next 3️⃣ 前置节点的next赋值为插入节点
     * 记录 链表长度 size ++
     *
     * @param data
     * @param index
     */
    public void insert(int data, int index) {
        // 判断index，index == size 代表插入到尾节点。所以判断条件为 ">"
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("超出链表长度范围");
        }
        Node insertNode = new Node(data);
        if (size == 0) {
            // 空链表 将插入到第一个节点数据赋值给头节点和尾节点
            head = insertNode;
            last = insertNode;
        } else if (index == 0) {
            // 插入头节点
            insertNode.next = head;
            head = insertNode;
        } else if (index == size) {
            // 插入尾节点
            last.next = insertNode;
            last = insertNode;
        } else {
            // 插入中间
            // 取得插入节点位置的前一个节点
            Node preNode = get(index - 1);
            insertNode.next = preNode.next;
            preNode.next = insertNode;
        }
        // 插入后记录链表长度 +1
        size++;
    }

    public Node remove(int index) throws Exception {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("超出链表长度");
        }
        Node removedNode = null;

        if (index == 0) {
            // 删除头节点
            removedNode = head;
            head = head.next;
        } else if (index == size - 1) {
            // 删除尾节点
            Node prevNode = get(index - 1);
            removedNode = prevNode.next;
            // 原尾节点指向null
            prevNode.next = null;
            last = prevNode;
        } else {
            // 删除中间节点
            Node prevNode = get(index - 1);
            Node nextNode = prevNode.next.next;
            removedNode = prevNode.next;
            prevNode.next = nextNode;
        }
        size--;
        return removedNode;
    }

    /**
     * 链表查找元素
     *
     * @param index
     * @return
     */
    private Node get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("超出链表长度范围");
        }
        // 获取头节点
        Node temp = head;
        // 从头节点开始，遍历到index为止，取得目标节点
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    /**
     * 输出链表输出
     * 1️⃣取得头节点，2️⃣使用while循环，打印一个节点后，赋值temp为下一个节点，依此循环。知道节点的next指针指向null
     */
    private void output() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public static void main(String[] args) throws Exception {
        NodeDemo demo = new NodeDemo();
        demo.insert(3,0);
        demo.insert(7,1);
        demo.insert(6,2);
        demo.insert(8,3);
        demo.insert(0,4);
        demo.insert(2,5);
        demo.output();
        demo.remove(0);
        demo.output();
    }
}
