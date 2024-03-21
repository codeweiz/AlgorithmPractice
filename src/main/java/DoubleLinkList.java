/**
 * @author zhouwei
 */
public class DoubleLinkList {
    int N = 100010;
    int idx;
    int[] e, l, r;

    void init() {
        e = new int[N];
        l = new int[N];
        r = new int[N];

        r[0] = 1;
        l[1] = 0;
        idx = 2;
    }

    // 在 k 的右侧插入
    void addRight(int k, int x) {
        e[idx] = x;
        r[idx] = r[k];
        l[idx] = k;
        l[r[k]] = idx;
        r[k] = idx;
        idx++;
    }

    void remove(int k) {
        r[l[k]] = r[k];
        l[r[k]] = l[k];
    }
}
