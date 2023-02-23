#include<iostream>
#include<map>
using namespace std;

map<string, int> mp;
string a[]={"가나다", "마바사", "아자차"};
int main(){
	mp.insert({a[0], 1});
	mp.insert(make_pair("마바사", 2)); //pair의 문법. map과 pair의 관계
	mp[a[2]] = 3;

	for(auto it = mp.begin(); it !=  mp.end(); it++){
		cout << "(*it) " << (*it).first << " : " << (*it).second << endl;
	}
	//해당 값이 없으면 0으로 초기화
	cout << "size of map "<< mp.size() << endl; //size of map
	cout << "카타파는? " << mp["카타파"] << endl;
	cout << "카타파 추가 "<<  mp.size() << endl; //size of map

	auto it = mp.find("카타파"); //map<string, int>::iterator it
	if(it != mp.end()) {
		cout << "(*it) " << (*it).first << " : " << (*it).second << endl; 
	}

	mp.erase("카타파");	
	it = mp.find("카타파");
	if(it == mp.end()) cout << "not found"  << endl;

	//pair으로 순회
	for(pair<string, int> i : mp){
		cout << "(pair) " << (i).first << " : " << (i).second << endl; 
	}
	
	//iterator로 순회
	for(map<string, int>::iterator it = mp.begin(); it != mp.end(); it++){
		cout << "(*it) " << (*it).first << " : " << (*it).second << endl;
	}

	mp.clear();
	return 0;
}

/*
(*it) 가나다 : 1
(*it) 마바사 : 2
(*it) 아자차 : 3
size of map 3
카타파는? 0
카타파 추가 4
(*it) 카타파 : 0
not found
(pair) 가나다 : 1
(pair) 마바사 : 2
(pair) 아자차 : 3
(*it) 가나다 : 1
(*it) 마바사 : 2
(*it) 아자차 : 3
*/
