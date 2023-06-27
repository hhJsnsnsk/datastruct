package data.structures.algorithm.datastructure.linkedlist;

/**
 * 链表初始化类
 * and CRUD method
 *
 * @author starrysky
 */
public class LinkedList {

    /**
     * 头节点
     */
    Node head;

    /**
     * 尾节点
     */
    Node last;
    /**
     * 链表长度
     */
    private int size;

    /**
     * 查找链表元素 Find linked list Element
     * 通过链表的性质来查找，先指定头节点，再遍历头节点的next指针
     * Search through the nature of the linked list,
     * first specify the head NODE,and then traverse the next pointer of the head NODE
     *
     * @param index 查找的索引 index of finding
     * @return 返回查找的索引元素 return index Element of looked up
     */
    public Node getNode(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("数组越界异常");
        }
        // 将头节点赋值给临时节点
        Node temp = head;
        // 遍历链表，因为链表的性质，导致查找元素时需要从头节点开始，遍历到索引元素需要从头节点至索引位置
        // Traversing the linked list,because of the nature of linked list , it's necessary to start from the head NODE when looking for Element,
        // and to traverse the index from the head NODE to the index position
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    /**
     * 在链表插入数据，分为空链表时、插入到头节点、插入到尾节点、插入中间
     * @param index 插入的索引位置
     * @param data 插入数据
     */
    public void insertLinked(int index, int data) {
        // 初始化链表
        Node insertNode = new Node(data);
        // 空链表，插入到头节点
        if (size == 0) {
            // 头节点和尾节点均是第一个插入的节点
            head = insertNode;
            last = insertNode;
        } else if (index == 0) {
            // 插入到头节点
            /*  错误逻辑
            head = insertNode;
            head.next = head;*/
            //先将头节点赋值给插入节点的next指针，此时next指针对应的原头节点内存地址不会丢失
            insertNode.next = head;
            // 头节点重新赋值
            head = insertNode;
        } else if (size == index)/* 当index == size 时，说明需要把插入元素放在最后位置 */ {
            // 插入到尾节点
            // 原尾节点的next指向插入的尾节点
            last.next = insertNode;
            // 尾节点被赋值成新插入的尾节点
            last = insertNode;
        } else {
            // 插入中间
            Node preNode = getNode(index - 1);
            insertNode.next = preNode.next;
            preNode.next = insertNode;
        }
        size++;
    }

    /**
     * 打印链表数据
     * 仍然借助链表的性质，从头节点开始遍历
     * 先创建临时链表对象，将头节点的内存地址写入临时链表节点
     * 再通过temp 不为空（节点有数据）时，打印此时的data
     * 并将next节点赋值到临时链表对象，再次进行循环验证和打印
     */
    public void printLinkedList(){
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    /**
     * Node节点静态内部类
     */
    private static class Node {
        /**
         * 链表数据
         */
        int data;
        /**
         * 下一个指针节点
         */
        Node next;

        /**
         * 节点构造器
         *
         * @param data 节点数据赋值
         */
        Node(int data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", next=" + next +
                    '}';
        }
    }

}
