package _04_knapsackhybrid;

import java.util.Scanner;

// Created by WXX on 2021/2/24 20:06
public class Main {

    public static final int N = 1010;

    static int n, m;
    static int[] f = new int[N];

    public static void main(String[] args) {

        Scanner sn = new Scanner(System.in);
        n = sn.nextInt(); m = sn.nextInt();
        for (int i = 0; i < n; i++) {
            int v = sn.nextInt(), w = sn.nextInt(), s = sn.nextInt();
            if (s == 0) {  // 完全背包
                for (int j = v; j <= m; j++) f[j] = Math.max(f[j], f[j - v] + w);
            } else {
                if (s == -1) s = 1;  // 全部转为多重背包，然后使用二进制优化
                for (int k = 1; k <= s; k *= 2) {
                    for (int j = m; j >= k * v; j--)
                        f[j] = Math.max(f[j], f[j - k * v] + k * w);
                    s -= k;
                }
                if (s != 0) {
                    for (int j = m; j >= s * v; j--)
                        f[j] = Math.max(f[j], f[j - s * v] + s * w);
                }
            }
        }
        System.out.println(f[m]);
    }
}
