package cartoonalgo.datastruct;

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

    public LinkedNodeClass(){
        stkPeek = null;
    }

    /**
     * 获取栈长度
     * @return 返回栈长度
     */
    public int size(){
        return stkSize;
    }

    /**
     * 判断栈是否为空
     * @return t o f
     */
    public boolean isEmpty(){
        return size() == 0;
    }

    /**
     * 入栈操作
     * @param num 入栈元素
     */
    public void push(int num){
        // 进栈的新节点 成为栈顶元素
        LinkNode node = new LinkNode(num);
        // 新栈顶的下一个节点为原栈顶
        node.next= stkPeek;
        // 重新赋值新栈顶
        stkPeek = node;
        // 元素个数 +1
        stkSize ++;
    }

}
