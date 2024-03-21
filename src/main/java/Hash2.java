/**
 * 一般哈希
 * 遇到冲突时，开放寻址法：
 * 即哈希后取到一个下标，如果下标位置存在数据，就移动到下一个地址，直到不存在数据为止
 *
 * @author zhouwei
 */
public class Hash2 {

    int N = 100010;
    int n = 100000;

    int[] h = new int[N];

    // 如果x在哈希表中，返回x的下标
    // 如果x不在哈希表中，返回x可以插入的位置
    int find(int x) {
        int k = (x % N + N) % N;
        while (k < N && h[k] != x) {
            k++;
            if (k == N) {
                k = 0;
            }
        }
        return k;
    }
}
