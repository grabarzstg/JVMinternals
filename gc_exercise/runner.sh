javac ./src/gc_exercise/*.java

ALLOC="25000 100000"
var=0
while  [ "$var" -lt 10 ]
do
var=`expr $var + 1`
for A in $ALLOC
do
export ALLOC="$A"
#ParallelOld
#n threads, fixed object size
java -Xmx128M -Xms128M -XX:+UseParallelOldGC -cp ./src gc_exercise.GCproject false ParallelOld
java -Xmx512M -Xms512M -XX:+UseParallelOldGC -cp ./src gc_exercise.GCproject false ParallelOld
java -Xmx1G -Xms1G     -XX:+UseParallelOldGC -cp ./src gc_exercise.GCproject false ParallelOld

#n threads, random object size

java -Xmx128M -Xms128M -XX:+UseParallelOldGC -cp ./src gc_exercise.GCproject true ParallelOld
java -Xmx512M -Xms512M -XX:+UseParallelOldGC -cp ./src gc_exercise.GCproject true ParallelOld
java -Xmx1G -Xms1G     -XX:+UseParallelOldGC -cp ./src gc_exercise.GCproject true ParallelOld

#CMS
#n threads, fixed object size
java -Xmx128M -Xms128M -XX:+UseConcMarkSweepGC -cp ./src gc_exercise.GCproject false CMS
java -Xmx512M -Xms512M -XX:+UseConcMarkSweepGC -cp ./src gc_exercise.GCproject false CMS
java -Xmx1G -Xms1G     -XX:+UseConcMarkSweepGC -cp ./src gc_exercise.GCproject false CMS

#n threads, random object size

java -Xmx128M -Xms128M -XX:+UseConcMarkSweepGC -cp ./src gc_exercise.GCproject true CMS
java -Xmx512M -Xms512M -XX:+UseConcMarkSweepGC -cp ./src gc_exercise.GCproject true CMS
java -Xmx1G -Xms1G     -XX:+UseConcMarkSweepGC -cp ./src gc_exercise.GCproject true CMS

#G1 (Garbage First)
#n threads, fixed object size
java -Xmx128M -Xms128M -XX:+UseG1GC -cp ./src gc_exercise.GCproject false G1
java -Xmx512M -Xms512M -XX:+UseG1GC -cp ./src gc_exercise.GCproject false G1
java -Xmx1G -Xms1G     -XX:+UseG1GC -cp ./src gc_exercise.GCproject false G1

#n threads, random object size

java -Xmx128M -Xms128M -XX:+UseG1GC -cp ./src gc_exercise.GCproject true G1
java -Xmx512M -Xms512M -XX:+UseG1GC -cp ./src gc_exercise.GCproject true G1
java -Xmx1G -Xms1G     -XX:+UseG1GC -cp ./src gc_exercise.GCproject true G1
done
done



