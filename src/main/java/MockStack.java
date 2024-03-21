/**
 * @author zhouwei
 */
public class MockStack {
    int N = 100010;
    int[] stk;
    int tt;

    void init() {
        tt = -1;
        stk = new int[N];
    }

    // 栈顶插入
    void push(int x) {
        stk[++tt] = x;
    }

    // 栈顶删除
    void pop() {
        tt--;
    }

    // 栈为空
    boolean empty() {
        return tt < 0;
    }

    // 栈顶的值
    int query() {
        return stk[tt];
    }
}
