// Created by WXX on 2021/2/24 13:46
#include <iostream>

using namespace std;

const int N = 1010;  // 多开几个数据，防止数组下标越界

int n, m;  // 物品种类数，背包容积
int v[N], w[N];  // 体积，价值。注意：v[1]存储第一件物品，索引0未使用
int f[N][N];  // dp数组

int main() {
    // 读入数据
    cin >> n >> m;
    for (int i = 1; i <= n; i++) cin >> v[i] >> w[i];

    // 算法过程，因为f[0][0~m]初始就为0，因此初始化可以省略
    for (int i = 1; i <= n; i++) {  // 先循环物品
        for (int j = 0; j <= m; j++) {  // 再循环容量
            // 最后循环决策
            f[i][j] = f[i - 1][j];  // 不选第i件物品
            if (j >= v[i]) f[i][j] = max(f[i][j], f[i - 1][j - v[i]] + w[i]);  // 考虑选第i件物品
        }
    }
    cout << f[n][m] << endl;
    return 0;
}
