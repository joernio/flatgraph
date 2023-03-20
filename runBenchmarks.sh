#!/bin/bash
echo "compiling"
time sbt benchStuff/Jmh/compile stage
echo "compiled and staged. Benchmarking load speed and memory consumption of odbv1:"
time ./benchStuff/target/universal/stage/bin/benchstuff -Djdk.attach.allowAttachSelf odb > ./odb1Results.txt
echo "odbv1 load+mem benchmarked. Results are in odb1Results.txt. Benchmarking load speed and memory consumption of odbv2:"
time ./benchStuff/target/universal/stage/bin/benchstuff -Djdk.attach.allowAttachSelf odb2 > ./odb2Results.txt
echo "odbv2 load+mem benchmarked. Results are in odb2Results.txt. Running JMH benchmarks (this will take some time...)"
time ./benchStuff/target/universal/stage/bin/benchstuff jmh
echo "Finished JMH benchmarks. Results are in jmhResults.txt"
