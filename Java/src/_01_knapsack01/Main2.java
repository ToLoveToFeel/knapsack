package _01_knapsack01;

import java.util.Scanner;

// Created by WXX on 2021/2/24 14:33
// 滚动数组优化
public class Main2 {

    public static final int N = 1010;

    static int n, m;
    static int[] v = new int[N], w = new int[N];
    static int[][] f = new int[2][N];

    public static void main(String[] args) {

        Scanner sn = new Scanner(System.in);
        n = sn.nextInt(); m = sn.nextInt();
        for (int i = 1; i <= n; i++) {
            v[i] = sn.nextInt(); w[i] = sn.nextInt();
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                f[i & 1][j] = f[(i - 1) & 1][j];
                if (j >= v[i]) f[i & 1][j] = Math.max(f[i & 1][j], f[(i - 1) & 1][j - v[i]] + w[i]);
            }
        }
        System.out.println(f[n & 1][m]);
    }
}
