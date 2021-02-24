package _05_knapsackhy2d;

import java.util.Scanner;

// Created by WXX on 2021/2/24 20:34
public class Main {

    public static final int N = 110;

    static int n, V, M;
    static int[][] f = new int[N][N];  // 第一维代表体积，第二维代表质量

    public static void main(String[] args) {

        Scanner sn = new Scanner(System.in);
        n = sn.nextInt(); V = sn.nextInt(); M = sn.nextInt();
        for (int i = 0; i < n; i++) {
            int v = sn.nextInt(), m = sn.nextInt(), w = sn.nextInt();
            for (int j = V; j >= v; j--)
                for (int k = M; k >= m; k--)
                    f[j][k] = Math.max(f[j][k], f[j - v][k - m] + w);
        }
        System.out.println(f[V][M]);
    }
}
