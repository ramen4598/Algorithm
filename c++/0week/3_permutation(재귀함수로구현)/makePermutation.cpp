#include<iostream>
#include<vector>
using namespace std;
vector<int> v;

void printV(vector<int> v){
	for(int i : v) cout << i << " ";
	cout << '\n';
}

// n개 중에 r개를 뽑는다.
void makePermutation(int n, int r, int depth){
	if(r == depth){
		printV(v);
		return;
	}
	for(int i=depth; i < n; i++){
		swap(v[i], v[depth]);
		makePermutation(n, r, depth + 1);
		swap(v[i], v[depth]);
	}
}

int main(){
	for(int i=1; i<4; i++){
		v.push_back(i);
	}
	makePermutation(3,2,0);
	return 0;
}

/*
1 2 3
1 3 2
2 1 3
2 3 1
3 2 1
3 1 2
*/
