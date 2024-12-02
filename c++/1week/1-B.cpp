// 백준 10808: 알파벳 개수
#include<iostream>
using namespace std;

int a[26];
string S;

int main(){
	cin >> S;
	for(char chr : S){
		a[chr - 'a']++;
	}
	
	for(int i : a){
		cout << i << ' ';
	}
	return 0;
}
