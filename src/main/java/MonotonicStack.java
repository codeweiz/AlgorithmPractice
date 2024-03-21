/**
 * 单调栈
 * 从栈底到栈顶的元素，其大小呈单调递增，或单调递减
 *
 * 常见模型：找出每个数左边离它最近的比她大/小的数
 *
 * @author zhouwei
 */
public class MonotonicStack {

    int N = 100010;
    int n = 100000;
    int tt = -1;
    int[] stk = new int[N];

    void monotonic() {
        for (int i = 1; i <= n; i++) {
            while(tt > 0 && check(stk[tt], i)) {
                tt--;
            }
            stk[++tt] = i;
        }
    }

    boolean check(int a, int i) {
        return a > i;
    }

}
