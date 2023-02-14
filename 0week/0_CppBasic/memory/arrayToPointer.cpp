#include<iostream>
using namespace std;

int a[3] = {1, 2,3};
int main(){
	int * b = &a[0];
	int * c = a;
	int * d = (a+1);
	cout << b << endl;
	cout << c << endl;
	cout << d << endl;
	cout << &a[1] << endl;
	return 0;
}

