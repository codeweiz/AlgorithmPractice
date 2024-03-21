/**
 * 维护 size 的并查集
 *
 * @author zhouwei
 */
public class UnionFindSet2 {
    int n = 100000;
    int N = 100010;

    // p 存储每个点的祖宗节点
    int[] p = new int[N];
    // 只有祖宗节点的 size 有实际意义，表示祖宗节点所在集合中点的数量
    int[] size = new int[N];

    // 返回 x 所在集合的祖宗节点
    int find(int x) {
        if (p[x] != x) {
            p[x] = find(p[x]);
        }
        return p[x];
    }

    // 初始化，每个点的祖宗节点
    void init() {
        for (int i = 1; i <= n; i++) {
            p[i] = i;
            size[i] = 1;
        }
    }

    // 合并 集合a 到 集合b
    // 集合a 的size 也累加到 集合b 上
    void merge(int a, int b) {
        int pa = find(a);
        int pb = find(b);
        if (pa != pb) {
            size[pb] += size[pa];
        }
        p[pa] = pb;
    }

}
