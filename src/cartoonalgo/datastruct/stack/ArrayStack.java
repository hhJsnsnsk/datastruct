package cartoonalgo.datastruct.stack;

import java.util.ArrayList;

/**
 * 使用数组实现栈
 *
 * @author starrysky
 */
public class ArrayStack {
    private ArrayList<Integer> stack;

    public ArrayStack() {
        // 初始化动态数组
        stack = new ArrayList<Integer>();
    }

    /**
     * 返回栈长度
     *
     * @return num
     */
    public int size() {
        return stack.size();
    }

    /**
     * 判断栈是否为空
     *
     * @return boolean
     */
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * 返回栈顶元素
     *
     * @return num
     */
    public int seek() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException();
        }
        return stack.get(size() - 1);
    }

    /**
     * 入栈操作
     *
     * @param num 入栈元素
     */
    public void push(int num) {
        stack.add(num);
    }

    /**
     * 出栈操作
     *
     * @return num
     */
    public int pop() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException();
        }
        return stack.remove(size() - 1);
    }

    /**
     * 转化为数组
     * @return stack to array
     */
    public Object[] toArrays() {
        return stack.toArray();
    }


}
