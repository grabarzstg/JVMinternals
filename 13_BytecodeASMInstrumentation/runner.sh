#!/bin/bash
# BytecodeASMInstrumentation project runner + random class generator
# Author: Marek Grabowski

#Random class generator
head="public class AutoGenerated"
body=" { }"

for counter in 0 10 
do
out=$head$counter$body
echo $out
#$out >> AutoGenerated$counter.java
done