package _02_knapsackcomplete;

import java.util.Scanner;

// Created by WXX on 2021/2/24 15:26
public class Main2 {

    public static final int N = 1010;

    static int n, m;
    static int[] v = new int[N], w = new int[N];
    static int[][] f = new int[N][N];

    public static void main(String[] args) {

        Scanner sn = new Scanner(System.in);
        n = sn.nextInt(); m = sn.nextInt();
        for (int i = 1; i <= n; i++) {
            v[i] = sn.nextInt(); w[i] = sn.nextInt();
        }

        for (int i = 1; i <= n; i++)
            for (int j = 0; j <= m; j++) {
                f[i][j] = f[i - 1][j];
                if (j >= v[i]) f[i][j] = Math.max(f[i][j], f[i][j - v[i]] + w[i]);
            }
        System.out.println(f[n][m]);
    }
}
