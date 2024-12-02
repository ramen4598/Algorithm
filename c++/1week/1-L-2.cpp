//백준 1940: 주몽
#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

int n, m, cnt, a[100001];
vector<int> v;

int main(){
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	cin >> n >> m;
	
	for(int i=0; i<n; i++){
		int tmp;
		cin >> tmp;
		a[tmp]++;
		if(m & 1){   // 짝수, 홀수 구분
			if(tmp<=m/2) v.push_back(tmp);   // 홀수
		}else{
			if(tmp<m/2) v.push_back(tmp);   // 짝수
		}
	}
	for(int i : v) 
		if(a[m-i]) 
			cnt++;
	
	cout << cnt << "\n";
	return 0;
}
