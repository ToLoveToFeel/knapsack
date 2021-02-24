package _01_knapsack01;

import java.util.Scanner;

// Created by WXX on 2021/2/24 14:39
// 优化为：一维数组
public class Main3 {

    public static final int N = 1010;

    static int n, m;
    static int[] v = new int[N], w = new int[N];
    static int[] f = new int[N];

    public static void main(String[] args) {

        Scanner sn = new Scanner(System.in);
        n = sn.nextInt(); m = sn.nextInt();
        for (int i = 1; i <= n; i++) {
            v[i] = sn.nextInt(); w[i] = sn.nextInt();
        }

        for (int i = 1; i <= n; i++)
            for (int j = m; j >= v[i]; j--)
                f[j] = Math.max(f[j], f[j - v[i]] + w[i]);

        System.out.println(f[m]);
    }
}
