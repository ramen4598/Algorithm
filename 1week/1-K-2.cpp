// 백준 1213번: 팬린드롬
#include <iostream>
#include <algorithm>
#include <map>
#include <string>

using namespace std;

string name, ret, rev, tmp;
map<char, int> mp;

int main(){
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	cin >> name;

	for(int i=0; i<name.length(); i++){
		mp[name[i]]++;
	}

	int cnt=0;
	for(pair<char,int> it : mp){
		if(it.second%2==1){
			cnt++;
			tmp=it.first;
		}
		if(cnt>1){
			cout << "I'm Sorry Hansoo" << "\n";
			exit(0);
		}
		ret.append(it.second/2, it.first);
	}
	rev = ret;
	reverse(rev.begin(), rev.end());
	ret.append(tmp);
	ret.append(rev);

	cout << ret << "\n";
	return 0;
}
