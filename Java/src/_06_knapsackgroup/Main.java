package _06_knapsackgroup;

import java.util.Scanner;

// Created by WXX on 2021/2/24 21:01
public class Main {

    public static final int N = 110;

    static int n, m;
    // s[i]: 代表第i组物品的数量；v[i][k],w[i][k]: 第i组中第k个物品的体积和价值
    static int[] s = new int[N];
    static int[][] v = new int[N][N], w = new int[N][N];
    static int[] f = new int[N];

    public static void main(String[] args) {

        Scanner sn = new Scanner(System.in);
        n = sn.nextInt(); m = sn.nextInt();
        for (int i = 1; i <= n; i++) {
            s[i] = sn.nextInt();
            for (int j = 0; j < s[i]; j++) {
                v[i][j] = sn.nextInt(); w[i][j] = sn.nextInt();
            }
        }

        for (int i = 1; i <= n; i++)  // 先循环物品
            for (int j = m; j >= 0; j--)  // 再循环容量。因为某件物品要么选要么不选，所以递减遍历
                for (int k = 0; k < s[i]; k++)  // 最后循环决策
                    if (j >= v[i][k])
                        f[j] = Math.max(f[j], f[j - v[i][k]] + w[i][k]);
        System.out.println(f[m]);
    }
}
