#!/bin/bash

# add follow line at ~/.zshrc
# alias g14='~/PUT A PATH WHERE THIS FILE IS LOCATED/.g++ComplieAndRun.sh'
# And then get permission to excute this file with "chmod a+x ./g++ComplieAndRun.sh" command
# put "g14" to terminal with file name what you want to compile and run.

cd $PWD
g++ -std=c++14 -Wall $1 -o test.out
./test.out