//백준 2979번: 트럭 주차
#include <iostream>
#include <map>

using namespace std;

map<int, int> mp;
int A,B,C;
pair<int, int> truck[3];
int sum;

int main(){
	cin >> A >> B >> C;
	for(int i=0; i<3; i++){
		cin >> truck[i].first >> truck[i].second;
	}
	for(int i=0; i<3; i++){
		for(int j=truck[i].first; j<truck[i].second; j++){
			auto it = mp.find(j);
			if(it == mp.end()){
				mp.insert(make_pair(j,1));
			}else{
				(*it).second += 1;
			}
		}
	}
	for(pair<int, int> i : mp){
		switch(i.second)
		{
			case 1:
				sum += A;
				break;
			case 2:
				sum += 2*B;
				break;
			case 3:
				sum += 3*C;
				break;
		}
		//cout << i.first << ":" << i.second << " : " << sum << "\n";
	}
	/*
	cout << "A,B,C" << A << B << C << "\n";
	for(pair<int, int> i : truck){
		cout << i.first << i.second << "\n";
	}
	for(pair<int, int> i : mp){
		cout << i.first << ':' << i.second << '\n';
	}
	*/
	cout << sum << "\n";
	return 0;

}
