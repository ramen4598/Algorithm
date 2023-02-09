// #include <bits/stdc++.h>
#include <iostream> 
#include <vector>
using namespace std;

vector<string> splitMetod (string input, string delimiter){
    vector<string> ret;
    auto pos = 0;
    string token = "";
    while((pos = input.find(delimiter)) != string::npos){
        token = input.substr(0, pos);
        ret.push_back(token);
        input.erase(0, pos + delimiter.length());
    }
    ret.push_back(input);
    return ret;
}

int main(void){
    string str = "hello world go to hell";
    string deli = " ";
    vector<string> splited_str = splitMetod(str,deli);
    for(string word : splited_str ) cout << word << "\n";
    return 0;
}