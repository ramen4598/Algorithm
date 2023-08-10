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

	if(m>=200000){
		cout << 0 << "\n";
		exit(0);
	}

	for(int i=0; i<n; i++){
		int tmp;
		cin >> tmp;
		a[tmp]++;
		if(m & 1){
			if(tmp<=m/2) v.push_back(tmp);
		}else{
			if(tmp<m/2) v.push_back(tmp);
		}
	}
	for(int i : v) 
		if(a[m-i]) 
			cnt++;
	
	cout << cnt << "\n";
	return 0;
}

