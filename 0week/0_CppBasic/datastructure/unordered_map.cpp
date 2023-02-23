#include<iostream>
#include<unordered_map>
using namespace std;

unordered_map<string, int> umap;
int main(){
	umap["bbb"] = 1;
	umap["aaa"] = 2;
	umap["ccc"] = 3;
	for(auto i : umap){
		cout << i.first << " : " << i.second << '\n';
	}
}
/*
ccc : 3
aaa : 2
bbb : 1
*/
