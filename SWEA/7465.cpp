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
		if(!visited[next])
			dfs(next);
	}

	return;
}

int solve(){
	int cnt = 0;

	for(int i = 0; i < n; i++){
		if(!visited[i]){
			dfs(i);
			cnt++;
		}
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
		for(vector<int> vec : adj)
			vec.clear();
		cin >> n >> m;

		for(int i : visited) cout << i << " ";
		cout << '\n';
		for(vector<int> vec : adj){
			for(int i : vec){
				cout << i << " ";
			}
			cout << '\n';
		}

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
