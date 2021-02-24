// Created by WXX on 2021/2/24 23:08
#include <iostream>
#include <cstring>

using namespace std;

const int N = 110;

int n, m;
int v[N], w[N];
int h[N], e[N], ne[N], idx;  // 邻接矩阵
int f[N][N];

void add(int a, int b) {
    e[idx] = b, ne[idx] = h[a], h[a] = idx++;
}

void dfs(int u) {

    for (int i = h[u]; ~i; i = ne[i]) {  // 遍历u的子节点，相当于循环物品组
        int son = e[i];
        dfs(son);  // 求解完成子节点后才能求解当前节点

        // 分组背包
        for (int j = m - v[u]; j >= 0; j--)  // 循环体积
            for (int k = 0; k <= j; k++)  // 循环决策
                f[u][j] = max(f[u][j], f[u][j - k] + f[son][k]);
    }

    // 将物品u加进去
    for (int i = m; i >= v[u]; i--) f[u][i] = f[u][i - v[u]] + w[u];
    for (int i = 0; i < v[u]; i++) f[u][i] = 0;  // 不能放入物品u，则整棵子树都不能放入
}

int main() {

    cin >> n >> m;
    memset(h, -1, sizeof h);
    int root = 1;  // 根节点并不一定是1号点
    for (int i = 1; i <= n; i++) {
        int p;
        cin >> v[i] >> w[i] >> p;
        if (p == -1) root = i;
        else add(p, i);  // 添加一条由p指向i的边
    }
    dfs(root);
    cout << f[root][m] << endl;
    return 0;
}
