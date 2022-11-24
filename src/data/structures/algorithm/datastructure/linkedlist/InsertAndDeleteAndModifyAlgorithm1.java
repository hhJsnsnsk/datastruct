package data.structures.algorithm.datastructure.linkedlist;

/**
 * 单向链表增删改查
 */
public class InsertAndDeleteAndModifyAlgorithm1 {

    // 头结点
    private Node head;
    // 尾结点
    private Node last;
    // 链表大小
    private int size;

    @Override
    public String toString() {
        return "InsertAndDeleteAndModifyAlgorithm1{" +
                "head=" + head +
                ", last=" + last +
                ", size=" + size +
                '}';
    }

    /**
     * 结点
     */
    private static class Node {
        // 插入的结点
        int data;
        // 结点的后置指针
        Node next;

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", next=" + next +
                    '}';
        }

        /**
         * 构造函数的逻辑不能错。
         * this.data指的是类的成员变量要重新赋值为形参的data
         * 而不是形参的data赋值为成员变量的data
         *
         * @param data
         */
        public Node(int data) {
            this.data = data;
        }
    }

    /**
     * 插入数据到链表
     *
     * @param index
     * @param data
     */
    public void insert(int index, int data) throws Exception {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("超出链表结点范围！");
        }
        //注意将其实例化，形参的data参与到Node的构造函数中。否则逻辑不对，并NullPointerException
        Node insertLinkedData = new InsertAndDeleteAndModifyAlgorithm1.Node(data);
        // true 则为空链表(size值为0) 将填充链表的第一个数据
        if (size == 0) {
            // 将插入的数值放入头和尾结点。则表明该链表有一个数据，并且next指向null
            head = insertLinkedData;
            last = insertLinkedData;
        } else if (index == 0) {
            /* true 则表明在头结点为处插入数据,此时将head指向插入的数据，并且insertData的next指向原有的head
             所以就要先利用好原有的数据head，再把head进行修改。否则逻辑容易混乱*/
            insertLinkedData.next = head;
            head = insertLinkedData;
        } else if (index == size) {
            /* 如果为true，则表明数据将插入尾结点，即链表大小size处
            利用原有的数据last，新进来的即将成为尾结点的数据，被原有的last尾结点的next指针所指
            */
            /*
            试想：如果是将插入的数据赋值为last.next，insertLinkedData  = last.next;
            这在逻辑也是可以的，但是根据实际情况，last.next指向的是 NULL
             */
            last.next = insertLinkedData;
            // 此时原有的last(尾结点要换了)将成为新进来的插入的尾结点
            last = insertLinkedData;
        } else {
            /* 在链表中间插入数据
            仍然是利用数据: next这个属性，所以可以获得get(index-1)处的结点(Node)
            */
            //先获得插入的结点的前置结点-----它具有next属性
            Node preNodeData = getNode(index - 1);
            //在没有插入成功之前，preNodeData的next指向的是原有的next，可获得,并将此插入的结点的next指向原有的next
            insertLinkedData.next = preNodeData.next;
            /* 插入的结点的next成功建立联系后，再将原有的结点的next指向插入的结点
            注意：  preNodeData.next必须要重新赋值为新来的结点
            将此过程受影响的结点都要进行正确修改
            */
            preNodeData.next = insertLinkedData;
        }
        // 插入成功，链表大小size增加1
        size++;
    }

    /**
     * 删除索引上的结点
     *
     * @param index
     * @return
     */
    public Node removeData(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("超出链表结点范围！");
        }
        Node removedLinkedNode = null;
        if (index == 0) {
            // 为true时，删除头节点 注意：head必须存在，这是固有属性
            removedLinkedNode = head;
            head = head.next;
        } else if (index == size - 1) {
            /* 为true时，删除尾结点。同理，尾结点last必须仍然存在
            removedLinked = last; 并且利用好next属性 */
            Node newLastNode = getNode(index - 1);
            removedLinkedNode = newLastNode.next;
            // 新的尾结点的next必须指向NULL
            newLastNode.next = null;
            last = newLastNode;
        } else {
            /* 删除中间的结点
            同样是利用好next属性，形参是index，通过形参获得前置结点
            */
            Node preNode = getNode(index - 1);
            removedLinkedNode = preNode.next;
            // next重新建立连接
            preNode.next = preNode.next.next;
        }

        return removedLinkedNode;
    }


    /**
     * 获得链表中的一个数据：通过遍历
     * 利用next属性
     *
     * @param index
     * @return
     */
    public Node getNode(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("超出链表结点范围！");
        }
        // 设置临时获取的结点。因为可能要继续遍历下去。一步步代替临时结点，直到获得所需要的结点。
        Node temp = head;
        // 如果只有一个Node，则根据插入的逻辑。索引index=0，下面的for循环不执行，返回head。
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    /**
     * 打印链表
     */
    public void printLinked() {
        // 和获取单个的Node一样，需要进行遍历，利用链表的next属性
        Node temp = head;
        // temp即head不为null即可。如果temp.next判空，会少一个结点
        while (temp != null) {
            // 因为插入操作插入的是data变量
            System.out.println(temp.data);
            // 遍历next
            temp = temp.next;
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println("======插入测试，并且获取一个结点====");
        InsertAndDeleteAndModifyAlgorithm1 test = new InsertAndDeleteAndModifyAlgorithm1();
        test.insert(0, 1);
        test.insert(1, 2);
        test.insert(2, 3);
        System.out.println(test.size);
        System.out.println(test.getNode(1));
        test.printLinked();
        System.out.println("======插入删除，并且获取一个结点====");
        test.removeData(1);
        System.out.println(test.getNode(1));
        test.printLinked();
    }


}
