// 백준 1159번: 농구 경기
#include <iostream>

using namespace std;

int n, a[26];
string s;
bool predaja = true;

int main(){
	cin >> n;
	memset(a, 0, sizeof(a));
	for(int i = 0; i < n; i++){
		cin >> s;
		a[s[0] - 'a']++;
	}
	for(int i = 0; i < 26; i++){
		if(a[i] >= 5){
			cout << (char)('a'+i);
			predaja = false;
		}
	}
	if(predaja) cout << "PREDAJA";
	cout << "\n";
	return 0;
}
