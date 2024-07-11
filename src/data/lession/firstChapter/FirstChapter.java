package lession.firstChapter;

import java.util.Arrays;
import java.util.Stack;

/**
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
     * 栈中内容一样，计数器优化 不一样则存放内容
     *
     * @param s input string
     * @return 栈元素是否为空
     */
    boolean isValid(String s) {
        // 当字符串为空时，返回true
        if (s.isEmpty()) {
            return true;
        }
        // 当字符串为奇数个，返回false
        if (s.length() % 2 == 1) {
            return false;
        }
        // 消除法的主要核心逻辑
        Stack t = new Stack();
        for (int i = 0; i < s.length(); i++) {
            // 取出字符串
            char c = s.charAt(i);
            if (c == '(') {
                // 压栈
                t.push(c);
            } else if (c == ')') {
                if (t.empty()) {
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

    /**
     * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
     * An input string is valid if:
     * Open brackets must be closed by the same type of brackets.
     * Open brackets must be closed in the correct order.
     * Every close bracket has a corresponding open bracket of the same type.
     *
     * @param s
     * @return 栈元素是否为空
     */
    boolean isValid2(String s) {
        if (s == null || s.isEmpty()) {
            // 如果字符串为空或字符串的长度为0则返回true
            return true;
        }
        if (s.length() % 2 == 1) {
            // 如果字符串个数为奇数个，返回false
            return false;
        }
        // 定义栈，接受字符串类型
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            // for循环取出字符
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                // 输入为左括号则压栈
                stack.push(c);
            } else if (c == ')') {
                // 输入为‘）’则验证前面是否出现‘（’
                if (stack.isEmpty() || stack.peek() != '(') {
                    return false;
                }
                // 符合上述条件则弹栈，栈元素为0
                stack.pop();
            } else if (c == '}') {
                if (stack.isEmpty() || stack.peek() != '{') {
                    return false;
                }
                stack.pop();
            } else if (c == ']') {
                if (stack.isEmpty() || stack.peek() != '[') {
                    return false;
                }
                stack.pop();
            } else {
                return false;
            }
        }
        return stack.empty();
    }

    /**
     * 例 2：大鱼吃小鱼
     * 【题目】在水中有许多鱼，可以认为这些鱼停放在 x 轴上。再给定两个数组 Size，Dir，Size[i] 表示第 i 条鱼的大小，
     * Dir[i] 表示鱼的方向 （0 表示向左游，1 表示向右游）。这两个数组分别表示鱼的大小和游动的方向，并且两个数组的长度相等。
     * 鱼的行为符合以下几个条件:
     * 所有的鱼都同时开始游动，每次按照鱼的方向，都游动一个单位距离；
     * 当方向相对时，大鱼会吃掉小鱼；
     * 鱼的大小都不一样。
     * 输入：Size = [4, 2, 5, 3, 1], Dir = [1, 1, 0, 0, 0]
     * 输出：3
     * 请完成以下接口来计算还剩下几条鱼？
     * int solution(int[] Size, int[] Dir);
     *
     * @return final fishNumber
     */
    int solution(int[] size, int[] dir) {
        // 鱼的个数
        final int fishNumber = size.length;
        // 向左为0
        final int left = 0;
        // 向右为1
        final int right = 1;
        // 定义栈，存放🐟的索引
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < fishNumber; i++) {
            // 新进的🐟的运动方向
            int currFishDir = dir[i];
            // 新进的🐟的大小
            int currFishSize = size[i];
            // 是否被吃 否
            boolean hasEat = false;
            while (!stack.empty() && dir[stack.peek()] == right && currFishDir == left) {
                // 1.栈中🐟不为空 栈顶🐟的方向向右，新进的🐟向左
                if (currFishSize < size[stack.peek()]) {
                    // 栈中🐟吃掉新来🐟
                    hasEat = true;
                    // 跳出while循环，继续下新来的🐟
                    break;
                }
                // 如果上述条件不满足则栈中🐟被吃掉，弹出栈顶，继续循环判断下一个栈顶🐟是否大于新来🐟 直至栈内🐟全被吃（空栈不进行while循环）或 新进🐟还是被吃掉
                stack.pop();
            }
            if (!hasEat) {
                // 此次for里的while循环结束，或没进入while循环即全新🐟进栈！
                stack.push(i);
            }
        }
        // 返回栈的大小（🐟个数）
        return stack.size();
    }

    public static int[] findRightSmall(int[] A) {
        // 结果数组
        int[] ans = new int[A.length];
        // 注意，栈中的元素记录的是下标
        Stack<Integer> t = new Stack<>();
        // A = 1, 2, 4, 9, 4, 0, 5
        for (int i = 0; i < A.length; i++) {
            final int x = A[i];
            // 每个元素都向左遍历栈中的元素完成消除动作
            while (!t.empty() && A[t.peek()] > x) {
                // 消除的时候，记录一下被谁消除了
                ans[t.peek()] = i;
                // 消除时候，值更大的需要从栈中消失
                t.pop();
            }
            // 剩下的入栈
            t.push(i);
        }
        // 栈中剩下的元素，由于没有人能消除他们，因此，只能将结果设置为-1。
        while (!t.empty()) {
            ans[t.peek()] = -1;
            t.pop();
        }

        return ans;
    }

    public static void main(String[] args) {
        FirstChapter q = new FirstChapter();
        System.out.println("================例一================");
        System.out.println(q.isValid("(()()(()))"));
        System.out.println(q.isValid2("()[]{}"));
        System.out.println(q.isValid2("(]"));
        System.out.println("================例二================");
        System.out.println(q.solution(new int[]{4, 2, 5, 3, 1}, new int[]{1, 1, 0, 0, 0}));
        System.out.println(Arrays.toString(FirstChapter.findRightSmall(new int[]{5, 4})));
        //
        assert (Arrays.equals(new int[]{1, -1}, FirstChapter.findRightSmall(new int[]{5, 4})));
        assert (Arrays.equals(new int[]{5, 5, 5, 4, 5, -1, -1}, FirstChapter.findRightSmall(new int[]{1, 2, 4, 9, 4, 0, 5})));
    }
}
