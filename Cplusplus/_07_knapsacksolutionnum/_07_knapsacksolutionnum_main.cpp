// Created by WXX on 2021/2/24 21:56
#include <iostream>
#include <cstring>

using namespace std;

const int N = 1010, mod = 1e9 + 7;

int n, m;
// f[i]: 表示体积恰好为j时的最大价值；g[i]: f[i]取最大值时的方案数
int f[N], g[N];

int main() {

    cin >> n >> m;

    memset(f, -0x3f, sizeof f);
    f[0] = 0;
    g[0] = 1;  // 什么都不选也是一种方案

    for (int i = 0; i < n; i++) {
        int v, w;
        cin >> v >> w;
        for (int j = m; j >= v; j--) {
            int maxv = max(f[j], f[j - v] + w);
            int cnt = 0;
            if (maxv == f[j]) cnt += g[j];
            if (maxv == f[j - v] + w) cnt += g[j - v];
            g[j] = cnt % mod;
            f[j] = maxv;
        }
    }

    int res = 0;  // 最大价值，因为取到最大价值花费的体积不一定恰好等于背包容量
    for (int i = 0; i <= m; i++) res = max(res, f[i]);

    int cnt = 0;  // 取到最大价值的方案数
    for (int i = 0; i <= m; i++)
        if (res == f[i])
            cnt = (cnt + g[i]) % mod;
    cout << cnt << endl;
    return 0;
}
