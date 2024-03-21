/**
 * 维护到祖宗节点距离的并查集
 *
 * @author zhouwei
 */
public class UnionFindSet3 {

    int n = 10000;
    int N = 10010;
    int distance = 1;

    // p 存储每个点的祖宗节点
    int[] p = new int[N];

    // d 存储 x 到 p[x] 的距离
    int[] d = new int[N];

    // 返回 x 的祖宗节点
    int find(int x) {
        if (p[x] != x) {
            int u = find(p[x]);
            d[x] += d[p[x]];
            p[x] = u;
        }
        return p[x];
    }

    // 初始化
    void init() {
        for (int i = 1; i < n; i++) {
            p[i] = i;
            d[i] = 0;
        }
    }

    // 合并
    void merge(int a, int b) {
        p[find(a)] = find(b);
        d[find(a)] = distance;
    }
}
