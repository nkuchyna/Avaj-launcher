#!/bin/sh

find ./ -name "*.java" > sources.txt
javac -sourcepath ./ @sources.txt
java -cp . simulator.Simulator scenario.txt
find . -name "*.class" -delete
find . -name "sources.txt" -delete