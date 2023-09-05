//백준 2870번: 수학숙제
#include<iostream>
#include<vector>
#include<algorithm>
#include<cstdlib>

using namespace std;

int n;
vector<int> v;

int main(){
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	cin >> n;
	for(int i=0; i<n; i++){
		string str, tmp;
		cin >> str;
		for(char c : str){
			if(c >= 95){
				if(tmp.length() > 0){
					v.push_back(atoi(tmp.c_str()));
					tmp ="";
				}
			}else{
				tmp += c;
			}
		}
		if(tmp.length() > 0) v.push_back(atoi(tmp.c_str()));
	}
	stable_sort(v.begin(), v.end());
	for(int i : v) cout << i << "\n";

	return 0;
}

