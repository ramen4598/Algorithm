#include<iostream>
#include<algorithm>
using namespace std;

int a[9], v[7];
int sum;

int main(){
    for(int i = 0; i < 9; i++){
		cin >> a[i];
    }
    sort(a, a+9);
    do{
        sum = 0;
        for(int i = 0; i < 7; i++){
            sum += a[i];
            v[i] = a[i];
        }
        if(sum == 100) break;
    }while(next_permutation(a, a+9));
    sort(v, v+7);
    for(int i : v)cout << i << '\n';
    return 0;
}
