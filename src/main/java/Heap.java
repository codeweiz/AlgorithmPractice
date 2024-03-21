/**
 * 堆：小根堆、大根堆，本质是优先队列
 *
 * @author zhouwei
 */
public class Heap {

    int N = 100010;
    int n = 10000;
    // 存储堆中的值，h[1] 是堆顶，x 的左儿子是 2x，x 的右儿子是 2x+1
    int[] h = new int[N];
    // ph 存储第k个插入的点在堆中的位置
    int[] ph = new int[N];
    // hp 存储堆中下标为k的点是第几个插入的
    int[] hp = new int[N];

    // 交换数组两个点的值
    void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    // 交换堆中两个点，及其映射关系
    void heapSwap(int a, int b) {
        swap(ph, hp[a], hp[b]);
        swap(hp, a, b);
        swap(h, a, b);
    }

    // 对于小根堆来说
    // 如果 u 位置的节点比 左右儿子节点的值要大
    // 交换 u 和 2u、2u + 1 位置的值，直到符合小根堆要求
    void down(int u) {
        int t = u;
        if (2*u <= h.length && h[t] > h[2*u]) {
            t = 2*u;
        }
        if (2*u+1 <= h.length && h[t] > h[2*u+1]) {
            t = 2*u+1;
        }
        if (t != u) {
            heapSwap(u, t);
            down(t);
        }
    }

    // 对于小根堆来说
    // 如果 u 位置的节点，比它的根节点 u/2 位置的节点还小
    // 交换 u 和 u/2 位置的值，直到符合
    void up(int u) {
        while (u / 2 > 0 && h[u] < h[u/2]) {
            heapSwap(u, u/2);
            u /= 2;
        }
    }

    // O(n) 建堆：对 第一层 到 倒数第二层 的数，做 down 操作
    void buildHeap() {
        for(int i = n/2; i != 0; i--) {
            down(i);
        }
    }
}
