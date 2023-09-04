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
	if(cnt[a] == cnt[b]) return seq[a] < seq[b]; // 수정
	return cnt[a] > cnt[b];
}

int main(){
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	cin >> n >> c;
	for(int i=0; i<n; i++){
		int tmp;
		cin >> tmp;
		cnt[tmp]++;
		if(cnt[tmp] == 1){
			seq[tmp] = i;
			v.push_back(tmp); // 이동
		}
	}
	sort(v.begin(), v.end(), cmp);

	for(int item : v){
		for(int i=0; i<cnt[item]; i++) // 추가
			cout << item << " ";
	}

	return 0;
}
