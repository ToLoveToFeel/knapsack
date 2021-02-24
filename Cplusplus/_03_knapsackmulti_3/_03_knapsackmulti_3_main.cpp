// Created by WXX on 2021/2/24 18:43
#include <iostream>
#include <cstring>

using namespace std;

const int N = 20010;

int n, m;
int f[N], g[N], q[N];  // g存储上一行的值，f存储当前行的值，q是单调队列

int main() {

    cin >> n >> m;
    for (int i = 0; i < n; i++) {  // 这里采取边读入物品，边处理；每个物品都要进行滑窗处理
        int v, w, s;
        cin >> v >> w >> s;
        memcpy(g, f, sizeof f);  // 将f中的数据拷贝到g中
        for (int r = 0; r < v; r++) {
            int hh = 0, tt = -1;
            for (int k = r; k <= m; k += v) {
                if (hh <= tt && q[hh] < k - s * v) hh++;  // 说明队头元素应该 滑出滑窗
                while (hh <= tt && g[q[tt]] - (q[tt] - r) / v * w <= g[k] - (k - r) / v * w) tt--;
                q[++tt] = k;  // 将当前考察体积存入滑窗
                if (hh <= tt) f[k] = max(f[k], g[q[hh]] + (k - q[hh]) / v * w);
            }
        }
    }
    cout << f[m] << endl;
    return 0;
}
