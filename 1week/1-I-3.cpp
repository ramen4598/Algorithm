//백준 1620번: 나는야 포켓몬 마스터 이다솜 
#include <iostream>
#include <map>
#include <string>

using namespace std;

int n, m;
string name, query;
map<int, string> mp;
map<string, int> mp2;

int main(){
	cin >> n >> m;
	for(int i=1; i<=n; i++){
		cin >> name;
		mp[i] = name;
		mp2[name] = i;
	}

	for(int i=0; i<m; i++){
		cin >> query;
		int j = atoi(query.c_str());
		if(j==0){
			cout << mp2[query] << "\n";
		}else{
			cout << mp[j] << "\n";
		}
	}
	return 0;
}
