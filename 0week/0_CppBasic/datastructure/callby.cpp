#include<iostream>
using namespace std;

int value(int a){
	a += 10;
	cout << "value : " << a << " ";
	return 0;
}

int ref(int& a){ //참조연산자&
	a += 10;
	cout << "ref : " << a << " ";
	return 0;
}

int main(){
	int a = 1;
	value(a);
	cout << a << '\n';

	ref(a);
	cout << a << '\n';
	return 0;
}
/*
value : 11 1
ref : 11 11
*/
