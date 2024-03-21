/**
 * 朴素并查集
 *
 * @author zhouwei
 */
public class UnionFindSet {

    int N = 100010;
    int n = 10000;
    int [] p = new int[N];

    // 返回 x 的祖宗节点
    int find(int x) {
        if (p[x] != x) {
            p[x] = find(p[x]);
        }
        return p[x];
    }

    // 初始化，每个节点的祖宗节点都是自己
    void init() {
        for (int i = 1; i <= n; i++) {
            p[i] = i;
        }
    }

    // 把 a 集合合并到 b 集合：
    // 就是把 a 的祖宗节点指向 b 的祖宗节点
    void merge(int a, int b) {
        p[find(a)] = find(b);
    }

}
