//백준 2870번: 수학숙제
#include<iostream>
#include<vector>
#include<algorithm>

using namespace std;

vector<string> v;
int n;

void go(string& tmp){
	while(true){
		if(tmp.size() && tmp.front() == '0') tmp.erase(tmp.begin());
		else break;
	}
	if(!tmp.size()) tmp = "0";
	v.push_back(tmp);
	tmp = "";
}

bool cmp(string a, string b){
	if(a.size() == b.size()) return a < b;
	else return a.size() < b.size();
}

int main(){
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	cin >> n;
	for(int i=0; i<n; i++){
		string str, tmp="";
		cin >> str;
		for(char c : str){
			if(c < 95) tmp += c;
			else if(tmp.size()) go(tmp);
		}
		if(tmp.size()) go(tmp);
	}
	sort(v.begin(), v.end(), cmp);
	for(string s : v) cout << s << "\n";

	return 0;
}
