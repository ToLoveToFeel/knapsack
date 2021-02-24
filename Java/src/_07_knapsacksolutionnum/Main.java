package _07_knapsacksolutionnum;

import java.util.Arrays;
import java.util.Scanner;

// Created by WXX on 2021/2/24 22:08
public class Main {

    public static final int N = 1010, mod = (int)(1e9 + 7);

    static int n, m;
    // f[i]: 表示体积恰好为j时的最大价值；g[i]: f[i]取最大值时的方案数
    static int[] f = new int[N], g = new int[N];

    public static void main(String[] args) {

        Scanner sn = new Scanner(System.in);
        n = sn.nextInt(); m = sn.nextInt();

        Arrays.fill(f, Integer.MIN_VALUE);
        f[0] = 0;
        g[0] = 1;  // 什么都不选也是一种方案

        for (int i = 0; i < n; i++) {
            int v = sn.nextInt(), w = sn.nextInt();
            for (int j = m; j >= v; j--) {
                int maxv = Math.max(f[j], f[j - v] + w);
                int cnt = 0;
                if (maxv == f[j]) cnt += g[j];
                if (maxv == f[j - v] + w) cnt += g[j - v];
                g[j] = cnt % mod;
                f[j] = maxv;
            }
        }

        int res = 0;  // 最大价值，因为取到最大价值花费的体积不一定恰好等于背包容量
        for (int i = 0; i <= m; i++) res = Math.max(res, f[i]);

        int cnt = 0;  // 取到最大价值的方案数
        for (int i = 0; i <= m; i++)
            if (res == f[i])
                cnt = (cnt + g[i]) % mod;
        System.out.println(cnt);
    }
}
