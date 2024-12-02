#!/bin/bash

# add follow line at ~/.zshrc
# alias jcr='~/PUT A PATH WHERE THIS FILE IS LOCATED/.javaComplieAndRun.sh'
# And then get permission to excute this file with "chmod a+x ./javaComplieAndRun.sh" command
# put "jcr" to terminal with file name what you want to compile and run.

#Interrupt immediately if an error occurs while the script is running
set -e

# Extract the filename without the extension
filename=$(basename -- "$1")
filenameWithoutExtension="${filename%.*}"

cd $PWD
javac $1 
java $filenameWithoutExtension
