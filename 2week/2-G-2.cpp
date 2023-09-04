// 백준 2910번: 빈도 정렬
#include<iostream>
#include<map>
#include<algorithm>
#include<vector>

using namespace std;

int n, c;
map<int, int> cnt, seq;
vector<int> v;

bool cmp(int a, int b){
	if(cnt[a] == cnt[b]) return seq[a] < seq[b];
	return cnt[a] > cnt[b];
}

int main(){
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	cin >> n >> c;
	for(int i=0; i<n; i++){
		int tmp;
		cin >> tmp;
		v.push_back(tmp);
		cnt[tmp]++;
		if(cnt[tmp] == 1) seq[tmp] = i;
	}

	stable_sort(v.begin(), v.end(), cmp); // sort 대신 stable_sort 사용

	for(int item : v){
		cout << item << " ";
	}

	return 0;
}
