/**
 * 一般哈希
 * 遇到哈希碰撞后：拉链法
 *
 * @author zhouwei
 */
public class Hash {

    int N = 100010;
    int n = 100000;

    // h 表示相同哈希值的数
    int[] h = new int[N];
    // e 存储值
    int[] e = new int[N];
    // ne 存储 h 的下标
    int[] ne = new int[N];
    int idx = 0;

    // 哈希表中插入一个数
    void insert(int x) {
        // 计算哈希值
        int k = (x % N + N) % N;
        e[idx] = x;
        ne[idx] = h[k];
        h[k] = idx++;
    }

    // 判断哈希表中是否存在某个数
    boolean find(int x) {
        int k = (x % N + N) % N;
        for (int i = h[k]; i != -1; i = ne[i]) {
            if (e[i] == x) {
                return true;
            }
        }
        return false;
    }

}
