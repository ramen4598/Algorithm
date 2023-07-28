#include<iostream>
#include<vector>
using namespace std;

int a[9], sum;
vector<int> v;
pair<int, int> ret;

void solve(){
	for(int i=0; i<9; i++){
		for(int j=0; j<i; j++){
			if(sum - a[i] - a[j] == 100){
				ret = {a[i], a[j]};
				return;
			}
		}
	}
	return;
}

int main(){
	for(int i=0; i<9; i++){
		cin >> a[i];
		sum += a[i];
	}
	solve();
	for(int i : a){
		if(ret.first == i || ret.second == i) continue;
		v.push_back(i);
	}
	sort(v.begin(), v.end());
	for(int i : v)cout << i << '\n';
	return 0;
}
