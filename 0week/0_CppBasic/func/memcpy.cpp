#include<iostream>
using namespace std;

//void * memcpy ( void * destination, const void * source, size_t num );

int a[5], temp[5];
int main(){
	for(int i=0; i<5; i++)a[i] = i;
	memcpy(temp, a, sizeof(a));
	for(int i : temp) cout << i << ' ';
	cout << endl;
	//change a
	a[4] = 9999;
	for(int i : a) cout << i << ' ';
	cout << endl;
	// put a to temp (call by value)
	memcpy(a, temp, sizeof(temp));
	for(int i : a) cout << i << " ";
	return 0;
}
/*
0 1 2 3 4
0 1 2 3 9999
0 1 2 3 4
*/
