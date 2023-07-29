//백준 10988번: 팬린드롬인지 확인하기
#include <iostream>

using namespace std;

string s;

int main(){
	cin >> s;
	string rev = s;
	reverse(rev.begin(), rev.end());
	if(s == rev)cout << 1 <<"\n";
	else cout << 0 <<"\n";
	return 0;
}
