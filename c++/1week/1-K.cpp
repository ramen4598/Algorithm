// 백준 1213번: 팬린드롬
#include <iostream>
#include <algorithm>
#include <string>

using namespace std;

string name;

int main(){
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	cin >> name;
	sort(name.begin(), name.end());
	do{
		string rev = name;
		reverse(rev.begin(), rev.end());
		if(rev == name){
			cout << name << "\n";
			exit(0);
		}
	}while(next_permutation(name.begin(), name.end()));
	cout << "I'm Sorry Hansoo" << "\n";
	return 0;
}
