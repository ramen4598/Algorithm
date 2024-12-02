// 백준 3986번: 좋은 단어
#include <iostream>
#include <stack>

using namespace std;

int n, ret;

/*
bool isOdd(string str){
	return (str.length() & 1);
}

int cntChar(string str, char c){
	int cnt = 0;
	for(char i : str)
		if(i==c) cnt++;
	return cnt;
}
*/

int main(){
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	cin >> n;
	for(int i=0; i<n; i++){
		string word;
		cin >> word;
		//if(isOdd(word)) continue;
		//if(cntChar(word, 'A') & 1)continue;

		stack<char> stk;
		for(char a : word){
			if(stk.size() && stk.top() == a)stk.pop();
			else stk.push(a);
		}
		if(stk.size() == 0)ret++;
	}
	cout << ret << "\n";
	return 0;
}
