#/bin/bash

if [ ! -e BuildSnowman.java ] ; then
	for f in .*.java ; do
		if [ "$f" != 'StdDraw.java' ] ; then		
			mv $f ${f#.}
		fi
	done
fi

oldies=`ls -a | grep '\..*\.java'`

if [[ $oldies ]] ; then
	rm $oldies
fi



javac -cp .:$PATH:StdDraw.java *.java

java BuildSnowman

for f in *.java ; do
	if [ "$f" != 'StdDraw.java' ] ; then
		less $f
		mv $f .$f
	fi
done
