// 백준 11655번: ROT13
#include <iostream>

using namespace std;

string s, ret;

void ROT13(string s){
	for(int i=0; i<s.size(); i++){
		if('A' <= s[i] && s[i] <= 'Z') ret += (char)('A' + ((s[i]-'A')+13)%26);
		else if('a' <= s[i] && s[i] <= 'z') ret += (char)('a' + ((s[i]-'a')+13)%26);
		else ret += s[i];
	}
}

int main(){
	getline(cin, s);

	ROT13(s);

	cout << ret << "\n";

	return 0;
}
