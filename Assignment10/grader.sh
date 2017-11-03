#/bin/bash

a='Assignment10'
if [ ! -e $a.java ] ; then
	echo 'restore'	
	for f in .*.java ; do
		mv $f ${f#.}
	done

else
	rm *.class
fi


oldies=`ls -a | grep '\..*\.java'`

if [[ $oldies ]] ; then
	rm $oldies
fi



javac  *.java && (

rm -f report student
touch report student

echo 'test' > student
java $a < 'testScript.txt' >> student
echo 'quitter' >> student
java $a < 'quitter.txt' >> student

diff -y -w control student > report

cat *.java >> report

less report

)


for f in *.java ; do
	
	mv $f .$f
	
done
