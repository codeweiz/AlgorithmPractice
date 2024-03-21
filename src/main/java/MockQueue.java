/**
 * @author zhouwei
 */
public class MockQueue {
    int N = 100010;
    int[] q;
    int hh, tt;

    void init() {
        q = new int[N];
        hh = 0;
        tt = -1;
    }

    // 队列 队尾 添加一个数
    void push(int x) {
        q[++tt] = x;
    }

    // 队列 队头 弹出一个数
    void pop() {
        hh++;
    }

    // 队列是否为空
    boolean empty() {
        return hh > tt;
    }

    // 返回 队尾 的值
    int queryTail() {
        return q[tt];
    }

    // 返回 队头 的值
    int queryHead() {
        return q[hh];
    }

}
