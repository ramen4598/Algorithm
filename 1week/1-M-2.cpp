// 백준 3986번: 좋은 단어
#include <iostream>
#include <vector>

using namespace std;

int n, ret;

bool isOdd(string str){
	return (str.length() & 1);
}

int cntChar(string str, char c){
	int cnt = 0;
	for(char i : str)
		if(i==c) cnt++;
	return cnt;
}
bool check(string& str){
	for(int i=0; i<str.length()-1; i++){
		if(str[i] == str[i+1]){
			str.erase(i, 2);
			return false;
		}
	}
	return true;
}
int main(){
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	cin >> n;
	for(int i=0; i<n; i++){
		string word;
		cin >> word;
		if(isOdd(word)) continue;
		if(cntChar(word, 'A') & 1)continue;
		
		while(true){
			if(check(word)) break;
			if(word.length()==0){
				ret++; break;
			}
		}
	}
	cout << ret << "\n";
	return 0;
}
