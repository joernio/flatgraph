#!/bin/bash
# stop on errors
set -e
set -o pipefail

if [ ! -f cpg.fg ]; then
  echo "please provide a sample cpg.fg (codepropertygraph schema) in the project root - see README.md for full instructions"
  exit 1
fi

echo "compiling"
sbt benchmarks/stage

echo "Benchmarking load speed and memory consumption of flatgraph:"
./benchmarks/target/universal/stage/bin/benchmarks -Djdk.attach.allowAttachSelf flatgraph > ./flatgraphResults.txt
echo "flatgraph load+mem benchmarked. Results are in flatgraphResults.txt."

echo "Running JMH benchmarks (this will take some time...)"
./benchmarks/target/universal/stage/bin/benchmarks jmh

RESULTS_FILE=benchmarks/results-history/$(date +"%Y%m%d")_$(git log -1 --pretty=format:%h)-results.csv
cp benchmarks/target/results.csv $RESULTS_FILE
git add $RESULTS_FILE

echo "benchmark results archived in $RESULTS_FILE - please commit those to collect more data points"
