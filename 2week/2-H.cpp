//백준 4659번: 비밀번호 발음하기
#include<iostream>

using namespace std;

string str;

bool case1(string str){
	for(char c : str)
		if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
			return true;
	return false;
}

bool case2(string str){
	int vowel = 0;
	int consonant = 0;

	for(char c : str){
		if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'){
			vowel++;
			consonant = 0;
		}else{
			vowel = 0;
			consonant++;
		}
		if(vowel >= 3 || consonant >= 3) return false;
	}
	return true;
}

bool case3(string str){
	char recent = '1';
	int cnt = 0;

	for(char c : str){
		if(recent == c){
			cnt++;
			if(cnt >= 2 && recent != 'e' && recent != 'o') return false;
		}else{
			recent = c;
			cnt = 1;
		}
	}
	return true;
}


int main(){
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	while(cin >> str){
		if(str == "end") break;
		bool pass = case1(str) && case2(str) && case3(str);
		if(pass) cout << "<" << str << "> is acceptable." << "\n";
		else cout << "<" << str << "> is not acceptable." << "\n";
	}

	return 0;
}
