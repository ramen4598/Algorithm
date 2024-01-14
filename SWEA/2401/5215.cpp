#include<iostream>
#include<algorithm>

using namespace std;

const int MAXN = 20;
int n, l, ret;
int t[MAXN], k[MAXN];

void solve(int depth, int cal, int score){
	if(depth == n){
		if(cal <= l && score > ret){
			ret = score;
		}
		return;
	}
	if(cal > l) return;
	score += t[depth];
	cal += k[depth];
	solve(depth+1, cal, score);

	score -= t[depth];
	cal -= k[depth];
	solve(depth+1, cal, score);
	return;
}

int main(){
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int T;
	cin >> T;
	for(int tc=1; tc<=T; ++tc){
		ret = 0;
		cin >> n >> l;
		for(int i=0; i<n; ++i){
			cin >> t[i] >> k[i];
		}
		solve(0, 0, 0);
		cout << "#" << tc << " " << ret << '\n';
	}
	return 0;
}
