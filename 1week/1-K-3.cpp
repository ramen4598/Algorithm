// 백준 1213번: 팬린드롬
#include <iostream>
#include <algorithm>
#include <map>
#include <string>

using namespace std;

string name, ret, rev, tmp;
int a[26];

int main(){
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	cin >> name;

	for(int i=0; i<name.length(); i++){
		a[name[i] - 'A']++;
	}

	int cnt=0;
	for(int i=0; i<26; i++){
		if(!a[i]) continue;
		if(a[i]%2==1){
			cnt++;
			tmp= (char)(i+'A');
		}
		if(cnt>1){
			cout << "I'm Sorry Hansoo" << "\n";
			exit(0);
		}
		ret.append(a[i]/2, (char)(i+'A'));
	}
	rev = ret;
	reverse(rev.begin(), rev.end());
	ret.append(tmp);
	ret.append(rev);

	cout << ret << "\n";
	return 0;
}
