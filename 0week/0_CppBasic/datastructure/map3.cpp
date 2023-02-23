#include<iostream>
#include<map>
using namespace std;

map<int, int> mp;
int main(){
	if(mp.find(1)==mp.end()){
		mp[1]=2;
	}
	for(auto i : mp) cout << i.first << " : " << i.second << endl;
	mp.clear();
	return 0;
}
