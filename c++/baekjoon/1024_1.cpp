#include<iostream>
#include<algorithm>
#include<vector>

using namespace std;

int n, l;

vector<int> find(){
	vector<int> vec;
	
	int cur = l;
	while(cur <= 100){
		bool flag = false;
		int div = n / cur;
		int left = n % cur;
		if(cur%2==1){
			if(left == 0){
				int d = (cur/2);
				for(int i = 0; i < cur; i++){
					int tmp = div-d+i;
					if(tmp < 0){
						vec.clear();
						cur++;
						flag = true;
						break;
					}
					vec.push_back(tmp);
				}
				if(flag) continue;
				return vec;
			}
		}else{
			if(left != 0 && left == cur/2){
				int d = (cur/2) - 1;
				for(int i = 0; i < cur; i++){
					int tmp = div-d+i;
					if(tmp < 0){
						vec.clear();
						cur++;
						flag = true;
						break;
					}
					vec.push_back(tmp);
				}
				if(flag) continue;
				return vec;
			}
		}
		cur++;
	}
	vec.push_back(-1);
	return vec;
}

int main(){
	cin >> n >> l;
	vector<int> vec = find();
	for(int i : vec)
		cout << i << " ";
	return 0;
}

