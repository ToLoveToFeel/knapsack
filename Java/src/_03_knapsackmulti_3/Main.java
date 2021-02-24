package _03_knapsackmulti_3;

import java.util.Scanner;

// Created by WXX on 2021/2/24 19:37
public class Main {

    public static final int N = 20010;
    static int n, m;
    static int[] f = new int[N], g = new int[N], q = new int[N];

    public static void main(String[] args) {

        Scanner sn = new Scanner(System.in);
        n = sn.nextInt(); m = sn.nextInt();
        for (int i = 0; i < n; i++) {  // 这里采取边读入物品，边处理；每个物品都要进行滑窗处理
            int v = sn.nextInt(), w = sn.nextInt(), s = sn.nextInt();
            System.arraycopy(f, 0, g, 0, N);  // 将f中的数据拷贝到g中
            for (int r = 0; r < v; r++) {
                int hh = 0, tt = -1;
                for (int k = r; k <= m; k += v) {
                    if (hh <= tt && q[hh] < k - s * v) hh++;  // 说明队头元素应该 滑出滑窗
                    while (hh <= tt && g[q[tt]] - (q[tt] - r) / v * w <= g[k] - (k - r) / v * w) tt--;
                    q[++tt] = k;  // 将当前考察体积存入滑窗
                    if (hh <= tt) f[k] = Math.max(f[k], g[q[hh]] + (k - q[hh]) / v * w);
                }
            }
        }
        System.out.println(f[m]);
    }
}
