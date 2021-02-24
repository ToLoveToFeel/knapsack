// Created by WXX on 2021/2/24 14:52
#include <iostream>

using namespace std;

const int N = 1010;

int n, m;
int v[N], w[N];
int f[N][N];

int main() {

    cin >> n >> m;
    for (int i = 1; i <= n; i++) cin >> v[i] >> w[i];

    for (int i = 1; i <= n; i++)  // 先循环物品
        for (int j = 0; j <= m; j++)  // 再循环容量
            for (int k = 0; k * v[i] <= j; k++)  // 最后循环决策
                f[i][j] = max(f[i][j], f[i - 1][j - k * v[i]] + k * w[i]);
    cout << f[n][m] << endl;
    return 0;
}
