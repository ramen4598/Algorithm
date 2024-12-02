#include<iostream>
#include<map>
using namespace std;

map<int, int> mp;
map<string, string> mp2;
int main(){
	cout << "mp[1] : " << mp[1] << endl;
	cout << "mp2[\"aaa\"] : " << mp2["aaa"] << endl;
	for(auto i : mp) cout << i.first << " : " << i.second << endl;
	for(auto i : mp2) cout << i.first << " : " << i.second << endl;
	mp.clear();
	mp2.clear();
	return 0;
}
/*
mp[1] : 0
mp2["aaa"] : 
1 : 0
aaa : 
*/
