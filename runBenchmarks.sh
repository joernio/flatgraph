#!/bin/bash
echo "compiling"
time sbt benchmarks/Jmh/compile stage
echo "compiled and staged. Benchmarking load speed and memory consumption of odbv1:"
time ./benchmarks/target/universal/stage/bin/benchmarks -Djdk.attach.allowAttachSelf odb > ./odb1Results.txt
echo "odbv1 load+mem benchmarked. Results are in odb1Results.txt. Benchmarking load speed and memory consumption of odbv2:"
time ./benchmarks/target/universal/stage/bin/benchmarks -Djdk.attach.allowAttachSelf odb2 > ./odb2Results.txt
echo "odbv2 load+mem benchmarked. Results are in odb2Results.txt. Running JMH benchmarks (this will take some time...)"
time ./benchmarks/target/universal/stage/bin/benchmarks jmh
echo "Finished JMH benchmarks. Results are in jmhResults.txt"
