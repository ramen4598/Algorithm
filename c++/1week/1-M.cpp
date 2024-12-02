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

vector<string> splitMethod(string input, string delimiter){
	vector<string> splited;
	auto pos = 0;
	string token ="";
	while((pos = input.find(delimiter)) != string::npos){
		token = input.substr(0,pos);
		if(token!="")splited.push_back(token);
		input.erase(0, pos+delimiter.length());
	}
	if(token!="")splited.push_back(token);
	return splited;
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

		string deli = "";
		vector<string> v = splitMethod(word, (deli=word[0]));
		bool check = true;
		for(string str : v){
			if(isOdd(str)){
				check = false;
				break;
			}
		}
		if(check) ret++;
		v.clear();
	}
	cout << ret << "\n";
	return 0;
}
