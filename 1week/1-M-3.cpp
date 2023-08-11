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

int main(){
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	cin >> n;
	for(int i=0; i<n; i++){
		string word;
		cin >> word;
		if(isOdd(word)) continue;
		if(cntChar(word, 'A') & 1)continue;

		
		bool check = false;
		do{
			for(int j=0; j<word.length()-1; j++){
				if(word[j] == word[j+1]){
					word.erase(j, 2);
					check = true;
					j--;
				}
				if(!word.length()){
					ret++;
					break;
				}
			}
		}while(check && word.length());
	}
	cout << ret << "\n";
	return 0;
}
