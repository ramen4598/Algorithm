#include<iostream>
#include<algorithm>
#include<vector>

using namespace std;

const int MAX_N = 100;
int n, m, visited[MAX_N];
vector<int> adj[MAX_N];

void dfs(int node){
	visited[node]++;

	for(int next : adj[node]){
		if(visited[next]) continue;
		dfs(next);
	}

	return;
}

int solve(){
	int cnt = 0;

	for(int i = 0; i < n; i++){
		if(visited[i]) continue;
		dfs(i);
		cnt++;
	}

	return cnt;
}

int main(){
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	int T;
	cin >> T;

	for(int tc = 1; tc <= T; tc++){
		fill(&visited[0], &visited[0] + MAX_N, 0);
		for(vector<int>& vec : adj)
			vec.clear();
		cin >> n >> m;

		int tmp1, tmp2;
		for(int i = 0; i<m; i++){
			cin >> tmp1 >> tmp2;
			adj[tmp1-1].push_back(tmp2-1);
			adj[tmp2-1].push_back(tmp1-1);
		}

		int ret = solve();

		cout << "#" << tc << " " << ret << '\n';
	}
	return 0;
}
