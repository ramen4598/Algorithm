// 백준 9996번: 한국이 그리울 땐 서버에 접속하지
#include <iostream>
#include <vector>

using namespace std;

vector<string> ret;
int n;
string pattern, s;

void split(string input, string delimiter){
	auto pos = 0;
	while((pos = input.find(delimiter))!=string::npos){
		string token = input.substr(0, pos);
		ret.push_back(token);
		input.erase(0, pos + delimiter.length());
	}
	ret.push_back(input);
	return;
}

int main(){
	cin >> n >> pattern;
	split(pattern, "*");
	for(int i=0; i<n; i++){
		cin >> s;
		if(s.length() < ret[0].length() + ret[1].length()){
			cout << "NE" << "\n";
		}else{
			if(ret[0] == s.substr(0,ret[0].length()) && ret[1] == s.substr(s.length()-ret[1].length(),ret[1].length())){
				cout << "DA" << "\n";
			}else{
				cout << "NE" << "\n";
			}
		}
	}
	ret.clear();
	return 0;
}
