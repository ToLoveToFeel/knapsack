// Created by WXX on 2021/2/24 20:52
#include <iostream>

using namespace std;

const int N = 110;

int n, m;
// s[i]: 代表第i组物品的数量；v[i][k],w[i][k]: 第i组中第k个物品的体积和价值
int v[N][N], w[N][N], s[N];
int f[N];

int main() {

    cin >> n >> m;
    for (int i = 1; i <= n; i++) {
        cin >> s[i];
        for (int j = 0; j < s[i]; j++)
            cin >> v[i][j] >> w[i][j];
    }

    for (int i = 1; i <= n; i++)  // 先循环物品
        for (int j = m; j >= 0; j--)  // 再循环容量。因为某件物品要么选要么不选，所以递减遍历
            for (int k = 0; k < s[i]; k++)  // 最后循环决策
                if (j >= v[i][k])
                    f[j] = max(f[j], f[j - v[i][k]] + w[i][k]);
    cout << f[m] << endl;
    return 0;
}
