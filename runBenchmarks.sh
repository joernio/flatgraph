#!/bin/bash
# stop on errors
set -e
set -o pipefail

if [ ! -f cpg.bin ]; then
  echo "please provide a sample cpg.bin (overflowdbv1 format) in the project root - see README.md for full instructions"
  exit 1
fi

echo "compiling"
time sbt benchmarks/Jmh/compile stage

echo "converting cpg.bin (odbv1 format) into cpg.fg (flatgraph format)"
time ./odb-convert/target/universal/stage/bin/odb-convert ./cpg.bin ./cpg.fg > out.json

echo "compiled and staged. Benchmarking load speed and memory consumption of odbv1:"
time ./benchmarks/target/universal/stage/bin/benchmarks -Djdk.attach.allowAttachSelf odb > ./odb1Results.txt

echo "odbv1 load+mem benchmarked. Results are in odb1Results.txt. Benchmarking load speed and memory consumption of odbv2:"
time ./benchmarks/target/universal/stage/bin/benchmarks -Djdk.attach.allowAttachSelf odb2 > ./odb2Results.txt

echo "odbv2 load+mem benchmarked. Results are in odb2Results.txt. Running JMH benchmarks (this will take some time...)"
time ./benchmarks/target/universal/stage/bin/benchmarks jmh

RESULTS_FILE=benchmarks/results-history/$(date +"%Y%m%d")_$(git log -1 --pretty=format:%h)-results.csv
cp benchmarks/target/results.csv $RESULTS_FILE
git add $RESULTS_FILE

echo "benchmark results archived in $RESULTS_FILE - please commit those to collect more data points"
