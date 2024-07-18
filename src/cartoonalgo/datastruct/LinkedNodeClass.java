package cartoonalgo.datastruct;

import java.util.Arrays;

/**
 * @author starrysky
 */
public class LinkedNodeClass {

    class LinkNode {
        // 节点值
        int val;
        // 前置节点
        LinkNode prev;
        // 后置节点
        LinkNode next;

        LinkNode(int val) {
            this.val = val;
            prev = next = null;
        }
    }

    private LinkNode stkPeek;
    private int stkSize = 0;

    public LinkedNodeClass() {
        stkPeek = null;
    }

    /**
     * 获取栈长度
     *
     * @return 返回栈长度
     */
    public int size() {
        return stkSize;
    }

    /**
     * 判断栈是否为空
     *
     * @return t o f
     */
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * 入栈操作
     *
     * @param num 入栈元素
     */
    public void push(int num) {
        // 进栈的新节点 成为栈顶元素
        LinkNode node = new LinkNode(num);
        // 新栈顶的下一个节点为原栈顶
        node.next = stkPeek;
        // 重新赋值新栈顶
        stkPeek = node;
        // 元素个数 +1
        stkSize++;
    }

    /**
     * 获取栈顶元素
     *
     * @return 返回栈顶
     */
    public int peek() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException();
        }
        return stkPeek.val;
    }

    /**
     * 出栈操作
     * @return 返回出栈值
     */
    public int pop() {
        int po = peek();
        stkPeek = stkPeek.next;
        stkSize--;
        return po;
    }

    /**
     * 将List转为Array并返回
     * @return 返回array
     */
    public int[] toArray(){
        LinkNode node = stkPeek;
        int[] array = new int[size()];
        for (int i = array.length-1; i >= 0; i--) {
            array[i] = node.val;
            node = node.next;
        }
        return array;
    }

    public static void main(String[] args) {
        LinkedNodeClass nodeClass = new LinkedNodeClass();
        nodeClass.push(1);
        nodeClass.push(2);
        nodeClass.push(3);
        nodeClass.push(4);
        nodeClass.push(5);
        System.out.println(Arrays.toString(nodeClass.toArray()));

        // 访问栈顶
        int top = nodeClass.peek();
        System.out.println(top);

        //
        System.out.println(nodeClass.size());
        System.out.println(nodeClass.isEmpty());
    }

}
