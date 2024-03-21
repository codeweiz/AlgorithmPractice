/**
 * KMP 算法：匹配最长公共子串
 *
 * @author zhouwei
 */
public class KMP {

    int N = 100010;
    int[] ne = new int[N];

    void getNextArray(char[] p) {
        for (int i = 2, j = 0; i <= p.length; i++) {
            while (j != 0 && p[i] != p[j + 1]) {
                j = ne[j];
            }
            if (p[i] == p[j + 1]) {
                j++;
            }
            ne[i] = j;
        }
    }

    void match(char[] s, char[] p) {
        for (int i = 1, j = 0; i <= s.length; i++) {
            while (j != 0 && s[i] != p[j + 1]) {
                j = ne[j];
            }
            if (s[i] == p[j + 1]) {
                j++;
            }
            if (j == p.length) {
                j = ne[j];
                // 匹配成功后的逻辑
            }
        }
    }
}
