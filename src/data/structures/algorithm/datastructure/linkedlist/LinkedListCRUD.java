package data.structures.algorithm.datastructure.linkedlist;

/**
 *
 * 链表增删改查
 * @author starrysky
 */
public class LinkedListCRUD {

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.insertLinked(0,1);
        linkedList.insertLinked(1,2);
        linkedList.insertLinked(2,3);
        linkedList.insertLinked(3,4545);
        System.out.println(linkedList.getNode(2));
        linkedList.printLinkedList();
        System.out.println("------------=");
        System.out.println(linkedList.removeLinked(1));
    }

}
