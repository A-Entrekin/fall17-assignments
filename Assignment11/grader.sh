#/bin/bash

a='PhoneBook'
b='Searcher'
folder='student'


if [ ! -e $a.java -a ! -e Phonebook.java ] ; then
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


if [ -e 'Phonebook.java' ] ; then
	echo 'Changing File Name'
	sed -i 's/Phonebook/PhoneBook/g' Phonebook.java Searcher.java
	mv Phonebook.java PhoneBook.java
fi 



javac  *.java && (

rm -f report student/*
touch report


java $a 'MOCK_DATA.csv' "$folder/sort1.csv"
java $a 'MOAR_DATA.csv' "$folder/sort2.csv"

java $b "$folder/sort1.csv" 'C' > $folder/CEntries.txt
java $b "$folder/sort2.csv" 'Ent' > $folder/EntEntries.txt

diff -y -r --suppress-common-lines  student control > report

cat *.java >> report

less report

)


for f in *.java ; do
	
	mv $f .$f
	
done
