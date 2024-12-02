#include<iostream>
#include<stack>
using namespace std;

stack<string> stk;
int main(){
	stk.push("엄");
	stk.push("준");
	stk.push("준");
	stk.push("식");
	stk.push("시..");
	while(stk.size()){
		cout << stk.top() << '\n';
		stk.pop();
	}
}
/*
시..
식
준
준
엄
*/
