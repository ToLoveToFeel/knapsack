package _09_knapsackdependency;

import java.util.Arrays;
import java.util.Scanner;

// Created by WXX on 2021/2/24 23:24
public class Main {

    public static final int N = 110;

    static int n, m;
    static int[] v = new int[N], w = new int[N];
    // 邻接矩阵
    static int[] h = new int[N], e = new int[N], ne = new int[N];
    static int idx = 0;

    static int[][] f = new int[N][N];

    private static void add(int a, int b) {
        e[idx] = b; ne[idx] = h[a]; h[a] = idx++;
    }

    private static void dfs(int u) {

        for (int i = h[u]; i != -1; i = ne[i]) {  // 遍历u的子节点，相当于循环物品组
            int son = e[i];
            dfs(son);  // 求解完成子节点后才能求解当前节点

            // 分组背包
            for (int j = m - v[u]; j >= 0; j--)  // 循环体积
                for (int k = 0; k <= j; k++)  // 循环决策
                    f[u][j] = Math.max(f[u][j], f[u][j - k] + f[son][k]);
        }

        // 将物品u加进去
        for (int i = m; i >= v[u]; i--) f[u][i] = f[u][i - v[u]] + w[u];
        for (int i = 0; i < v[u]; i++) f[u][i] = 0;  // 不能放入物品u，则整棵子树都不能放入
    }

    public static void main(String[] args) {

        Scanner sn = new Scanner(System.in);
        n = sn.nextInt(); m = sn.nextInt();
        Arrays.fill(h, -1);
        int root = 1;  // 根节点并不一定是1号点
        for (int i = 1; i <= n; i++) {
            v[i] = sn.nextInt(); w[i] = sn.nextInt();
            int p = sn.nextInt();
            if (p == -1) root = i;
            else add(p, i);  // 添加一条由p指向i的边
        }
        dfs(root);
        System.out.println(f[root][m]);
    }
}
