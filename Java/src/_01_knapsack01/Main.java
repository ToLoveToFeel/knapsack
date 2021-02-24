package _01_knapsack01;

import java.util.Scanner;

// Created by WXX on 2021/2/24 14:15
public class Main {

    public static final int N = 1010;  // 多开几个数据，防止数组下标越界

    static int n, m;  // 物品种类数，背包容积
    static int[] v = new int[N], w = new int[N];  // 体积，价值。注意：v[1]存储第一件物品，索引0未使用
    static int[][] f = new int[N][N];   // dp数组

    public static void main(String[] args) {
        // 读入数据
        Scanner sn = new Scanner(System.in);
        n = sn.nextInt(); m = sn.nextInt();
        for (int i = 1; i <= n; i++) {
            v[i] = sn.nextInt(); w[i] = sn.nextInt();
        }

        // 算法过程，因为f[0][0~m]初始就为0，因此初始化可以省略
        for (int i = 1; i <= n; i++) {  // 先循环物品
            for (int j = 0; j <= m; j++) {  // 再循环容量
                // 最后循环决策
                f[i][j] = f[i - 1][j];  // 不选第i件物品
                if (j >= v[i]) f[i][j] = Math.max(f[i][j], f[i - 1][j - v[i]] + w[i]);  // 考虑选第i件物品
            }
        }
        System.out.println(f[n][m]);
    }
}
