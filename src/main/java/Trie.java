/**
 * Trie 树
 *
 * @author zhouwei
 */
public class Trie {
    int N = 100010;
    int[][] son = new int[N][26];
    int[] cnt = new int[N];
    int idx = 0;

    // 插入一个字符串
    void insert(char[] str) {
        int p = 0;
        for (int i = 0; i < str.length; i++) {
            int u = str[i] - 'a';
            if (son[p][u] == 0) {
                son[p][u] = idx++;
            }
            p = son[p][u];
        }
        cnt[p]++;
    }

    // 查询字符串出现的次数
    int query(char[] str) {
        int p = 0;
        for (int i = 0; i < str.length; i++) {
            int u = str[i] - 'a';
            if (son[p][u] == 0) {
                return 0;
            }
            p = son[p][u];
        }
        return cnt[p];
    }
}
