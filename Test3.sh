#!/usr/bin/sh
javac -cp ./ MyFileTable.java

javac -cp ./ Test3.java

java -cp ./ Test3 test1.csv test2.csv
