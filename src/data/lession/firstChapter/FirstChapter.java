package lession.firstChapter;

import java.util.Stack;

/**
 *
 * @author starrysky
 */
public class FirstChapter {

    /**
     * 例 1：判断字符串括号是否合法
     * 【题目】字符串中只有字符'('和')'。合法字符串需要括号可以配对。比如：
     * 输入："()"
     * 输出：true
     * 解释：()，()()，(())是合法的。)(，()(，(()是非法的。
     * 请你实现一个函数，来判断给定的字符串是否合法。
     * boolean isValid(String s);
     *
     * @param s input string
     * @return 栈元素是否为空
     */
    boolean isValid(String s){
        // 当字符串为空时，返回true
        if (s.isEmpty()){
            return true;
        }
        // 当字符串为奇数个，返回false
        if (s.length() % 2 == 1){
            return false;
        }
        // 消除法的主要核心逻辑
        Stack t = new Stack();
        for (int i = 0; i < s.length(); i++) {
            // 取出字符串
            char c = s.charAt(i);
            if (c == '(' ){
                // 压栈
                t.push(c);
            }else if (c==')'){
                if (t.empty()){
                    // 在首次出现‘）’，返回false
                    return false;
                }
                // 出栈
                t.pop();
            }
        }
        // 栈元素为空，消除成功
        return t.empty();
    }




    public static void main(String[] args) {
        FirstChapter q = new FirstChapter();
        System.out.println(q.isValid("(()()(()))"));
    }
}
