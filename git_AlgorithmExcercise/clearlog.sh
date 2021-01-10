#!/bin/bash

<< "END"
echo "Echo Test"
printf "printf Test\n"
printf "Name of script: %s\n" $0
printf "Name of script: %s\n" $1
printf "%d arguments %s %s\n" $# $1 $2
END

#clear
ls_output=`find ./ -name '*.log'`
#echo $ls_output

for f in $ls_output; 
do
	#echo $f
	`true > $f`
done
