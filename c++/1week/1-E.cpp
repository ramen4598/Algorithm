//백준 1159번: 농구 경기
#include <iostream>
#include <map>

using namespace std;

int n;
string s;
map<char, int> mp;
bool predaja = true;

int main(){
	cin >> n;
	for(int i=0; i<n; i++){
		cin >> s;
		auto it = mp.find(s[0]);
		if(it != mp.end()) (*it).second++;
		else mp.insert(make_pair(s[0], 1));
	}
	for(pair<char, int> i : mp){
		if(i.second >= 5){
			cout << i.first;
			predaja = false;
		}
	}

	/*
	for(pair<char, int> i : mp){
		cout << i.first << " : " << i.second << "\n";
	}
	cout << predaja << "\n";
	*/

	if(predaja) cout << "PREDAJA" << "\n";
	else cout << "\n";

	mp.clear();
	return 0;
}
