//백준 1620번: 나는야 포켓몬 마스터 이다솜 
#include <iostream>
#include <map>
#include <string>

using namespace std;

int n, m;
string name, query;
map<string, string> mp, mp2;

int main(){
	cin >> n >> m;
	for(int i=1; i<=n; i++){
		cin >> name;
		//mp.insert(make_pair(to_string(i), name));
		//mp2.insert(make_pair(name, to_string(i)));
		mp[to_string(i)] = name;
		mp2[name] = to_string(i);
	}

	for(int i=0; i<m; i++){
		cin >> query;
		if(atoi(query.c_str())==0){
			//auto it = mp2.find(query);
			//cout << it->second << "\n";
			cout << mp2[query] << "\n";
		}else{
			//auto it = mp.find(query);
			//cout << it->second << "\n";
			cout << mp[query] << "\n";
		}
	}
	return 0;
}
