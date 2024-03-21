/**
 * @author zhouwei
 */
public class SingleLinkList {
    int N = 100010;
    int h, idx;
    int[] e, ne;

    void init() {
        h = -1;
        idx = 0;
        e = new int[N];
        ne = new int[N];
    }

    void addToHead(int x) {
        e[idx] = x;
        ne[idx] = h;
        h = idx++;
    }

    void add(int k, int x) {
        e[idx] = x;
        ne[idx] = ne[k];
        ne[k] = idx++;
    }

    void remove(int k) {
        ne[ne[k]] = ne[k];
    }

    void removeHead() {
        h = ne[h];
    }
}
