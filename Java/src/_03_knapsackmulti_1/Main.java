package _03_knapsackmulti_1;

import java.util.Scanner;

// Created by WXX on 2021/2/24 16:13
public class Main {

    public static final int N = 110;

    static int n, m;
    static int[] v = new int[N], w = new int[N], s = new int[N];
    static int[][] f = new int[N][N];

    public static void main(String[] args) {

        Scanner sn = new Scanner(System.in);
        n = sn.nextInt(); m = sn.nextInt();
        for (int i = 1; i <= n; i++) {
            v[i] = sn.nextInt(); w[i] = sn.nextInt(); s[i] = sn.nextInt();
        }

        for (int i = 1; i <= n; i++)  // 先循环物品
            for (int j = 0; j <= m; j++)  // 再循环容量
                for (int k = 0; k <= s[i] && k * v[i] <= j; k++)  // 最后循环决策
                    f[i][j] = Math.max(f[i][j], f[i - 1][j - k * v[i]] + k * w[i]);
        System.out.println(f[n][m]);
    }
}
