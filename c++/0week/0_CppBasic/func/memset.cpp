#include<iostream>
using namespace std;

const int max_n = 1004;
int a[max_n];
int a2[max_n][max_n];
int main(){
	memset(a, -1, sizeof(a));
	memset(a2, -1, sizeof(a2));
	for(int i=0; i<10; i++) cout <<a[i]<<" ";
	return 0;
}
-1 -1 -1 -1 -1 -1 -1 -1 -1 -1 