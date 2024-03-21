import java.util.*;
import java.util.stream.Collectors;

/**
 * @author zhouwei
 */
public class AlgorithmTemplate {

    /**
     * 快速排序模版
     * */
    public void quickSort(int[] q, int l, int r) {
        if (l >= r) {
            return;
        }

        int i = l - 1;
        int j = r + 1;
        int x = q[l + r >> 1];

        while (i < j) {
            do {
                i++;
            } while (q[i] < x);
            do {
                j--;
            } while (q[j] > x);

            if (i < j) {
                int t = q[i];
                q[i] = q[j];
                q[j] = t;
            }
        }

        quickSort(q, l, j);
        quickSort(q, j + 1, r);
    }


    /**
     * 归并排序模版
     * */
    public void mergeSort(int[] q, int l, int r) {
        if (l >= r) {
            return;
        }

        int mid = l + r >> 1;

        mergeSort(q, l, mid);
        mergeSort(q, mid + 1, r);

        int i = l;
        int j = mid + 1;
        int k = 0;
        int[] t = new int[r - l + 1];

        while (i <= mid && j <= r) {
            if (q[i] > q[j]) {
                t[k++] = q[j++];
            } else {
                t[k++] = q[i++];
            }
        }

        while (i <= mid) {
            t[k++] = q[i++];
        }
        while (j <= r) {
            t[k++] = q[j++];
        }

        for (i = l, j = 0; i < r; i++, j++) {
            q[i] = t[j];
        }
    }

    /**
     * 整数二分查找：左分
     * 区间 [l, r] 被划分为 [l, mid] 和 [mid + 1, r]
     * */
    public int binaryFind1(int[] q, int l, int r, int x) {
        while (l < r) {
            int mid = l + r >> 1;
            if (q[mid] >= x) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    /**
     * 整数二分查找：右分
     * 区间 [l, r] 被划分为 [l, mid - 1] 和 [mid, r]
     * */
    public int binaryFind2(int[] q, int l, int r, int x) {
        while (l < r) {
            int mid = l + r + 1 >> 1; // 有加
            if (q[mid] <= x) {
                l = mid;
            } else {
                r = mid - 1;// 必有减
            }
        }
        return l;
    }

    /**
     * 浮点数二分查找
     * */
    public double binaryFind3(double l, double r, double x) {
        while (r - l > 1e-6) {
            double mid = (l + 1) / 2;
            if (mid > x) {
                r = mid;
            } else {
                l = mid;
            }
        }
        return l;
    }

    /**
     * 前缀和
     * l 到 r 的前缀和就是 s[r] - s[l - 1]
     * */
    public void frontSum(int[] a, int l, int r) {
        int[] s = new int[a.length];
        for (int i = 1; i < a.length; i++) {
            s[i] = s[i - 1] + a[i];
        }
//        s[r] - s[l - 1] = a[l] + ··· + a[r];
    }

    public void fontSum2(int[][] q, int x1, int y1, int x2, int y2) {
        // x1 y1 到 x2 y2 的子矩阵的和为：
        // s[x2][y2] - s[x1 - 1][y2] - s[x2][y1 - 1] + s[x1][y1]
    }

    // 一维差分
    public void sub1() {
        // 给区间[l, r] 加上数 c：
        // b[l] += c; b[r + 1] -= c;
    }

    // 二维差分
    public void sub2() {
        // [x1, y1] 到 [x2, y2] 的子矩阵加上数 c：
        /**
         * s[x1][y1] += c;
         * s[x2 + 1][y1] -= c;
         * s[x1][y2 + 1] -= c;
         * s[x2 + 1][y2 + 1] +=c;
         * */
    }

    // 位运算
    public void bit() {
        // 求 n 的第 k 位数字： n >> k & 1
        // 返回 n 的最后一位： lowbit(n) = n & -n
    }

    /**
     * 双指针算法
     *
     * 常见问题分类：
     * 1、对于一个序列，用两个指针维护一段区间
     * 2、对于两个序列，维护某种次序，比如归并排序中合并两个有序序列
     * */
    public void doublePointer(int n) {
        for (int i = 0, j = 0; i < n; i++) {
            while (j < i && check(i, j)) {
                j++;
            }

            // code...
        }
    }

    public boolean check(int i, int j) {
        return true;
    }

    /**
     * 离散化
     * */
    public int discrete(int x) {
        List<Integer> list = new ArrayList<>();
        // 去重、排序
        list = new ArrayList<>(new HashSet<>(list));
        Collections.sort(list);

        // 二分求出 x 对应的离散化的值
        int l = 0, r = list.size() - 1;
        while (l < r) {
            int mid = l + r >> 1;
            if (list.get(mid) >= x) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return r + 1;
    }

    /**
     * 区间合并
     * 将存在交集的区间合并
     * */
    public int mergeInterval(List<Pair> list) {
        List<Pair> res = new ArrayList<>();

        // 按照左端，从小到大排序
        list.sort(Comparator.comparingInt(o -> o.left));
        int l = Integer.MIN_VALUE;
        int r = Integer.MIN_VALUE;
        for (Pair pair : list) {
            if (pair.left > r) {
                // 下一个区间的左端 大于 上一个区间的右端
                // 说明已经找到了新区间
                if (l != Integer.MIN_VALUE) {
                    res.add(new Pair(l, r));
                }
                l = pair.left;
                r = pair.right;
            } else {
                // 没找到新区间
                // 移动老区间的右端
                r = Math.max(r, pair.right);
            }
        }
        // 把最后一个点也放进去
        if (l != Integer.MIN_VALUE) {
            res.add(new Pair(l, r));
        }
        return res.size();
    }

}

class Pair {
    Integer left;
    Integer right;

    Pair(Integer l, Integer r) {
        left = l;
        right = r;
    }
}