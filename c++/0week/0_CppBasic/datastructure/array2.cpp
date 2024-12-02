#include<iostream>
using namespace std;

int a[3][4];
int main(){
	for(int i=0; i<3; i++){
		for(int j=0; j<4; j++){
			a[i][j] = (i + j);
		}
	}
	for(int i = 0; i < 3; i++){
		for(int j=0; j<4; j++){
			cout << a[i][j] << " ";
		}
		cout << endl;
	}
}
/*
0 1 2 3 
1 2 3 4 
2 3 4 5 
*/
