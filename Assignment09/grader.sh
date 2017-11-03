#/bin/bash

a9='Assignment09'
if [ ! -e Assignment09.java ] ; then
	echo 'restore'	
	for f in .*.java ; do
		if [ "$f" != 'StdDraw.java' ] ; then		
			mv $f ${f#.}
		fi
	done

else
	
	rm *.class

fi


oldies=`ls -a | grep '\..*\.java'`

if [[ $oldies ]] ; then
	rm $oldies
fi



javac  *.java && (

rm -f report student/*
touch report 

for f in testFiles/* ; do
	f=${f#testFiles/}	
	echo "$f"
	echo "testFiles/$f" | java $a9 > student/$f

done

diff -y  -w --suppress-common-lines student control > report

cat *.java >> report

less report

)


for f in *.java ; do
	
	mv $f .$f
	
done
