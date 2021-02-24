package _03_knapsackmulti_2;

import java.util.ArrayList;
import java.util.Scanner;

// Created by WXX on 2021/2/24 16:50
public class Main {

    public static final int N = 2010;

    static int n, m;
    static int[] f = new int[N];

    static class Good {
        int v, w;
        public Good(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }

    public static void main(String[] args) {

        ArrayList<Good> goods = new ArrayList<>();
        Scanner sn = new Scanner(System.in);
        n = sn.nextInt(); m = sn.nextInt();
        for (int i = 0; i < n; i++) {
            int v = sn.nextInt(), w = sn.nextInt(), s = sn.nextInt();
            for (int k = 1; k <= s; k *= 2) {
                s -= k;
                goods.add(new Good(k * v, k * w));
            }
            if (s > 0) goods.add(new Good(s * v, s * w));
        }

        for (Good good : goods)
            for (int j = m; j >= good.v; j--)
                f[j] = Math.max(f[j], f[j - good.v] + good.w);
        System.out.println(f[m]);
    }
}
