/**
 *
 * 单调队列
 *
 * 常见场景：找到滑动窗口中的最大值/最小值
 *
 * @author zhouwei
 */
public class MonotonicQueue {

    int N = 100010;
    int n = 100000;
    int hh = 0, tt = -1;
    int[] q = new int[N];

    void monotonic() {
        for (int i = 0; i < n; i++) {
            // 判断队头是否滑出窗口
            while (hh <= tt && checkOut(q[hh])) {
                hh++;
            }
            while (hh <= tt && check(q[tt], i)) {
                tt--;
            }
            q[++tt] = i;
        }
    }

    boolean checkOut(int a) {
        return true;
    }

    boolean check(int a, int b) {
        return true;
    }

}
