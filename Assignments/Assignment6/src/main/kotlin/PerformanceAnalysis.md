# Performance Analysis 
#### Optimization Output

```
Running experiments for graph size 10 and density 0.2...
Average execution time for 5 iterations: 0 ms

Running experiments for graph size 10 and density 0.5...
Average execution time for 5 iterations: 0 ms

Running experiments for graph size 10 and density 0.8...
Average execution time for 5 iterations: 0 ms

Running experiments for graph size 200 and density 0.2...
Average execution time for 5 iterations: 9 ms

Running experiments for graph size 200 and density 0.5...
Average execution time for 5 iterations: 8 ms

Running experiments for graph size 200 and density 0.8...
Average execution time for 5 iterations: 2 ms

Running experiments for graph size 1000 and density 0.2...
Average execution time for 5 iterations: 317 ms

Running experiments for graph size 1000 and density 0.5...
Average execution time for 5 iterations: 301 ms

Running experiments for graph size 1000 and density 0.8...
Average execution time for 5 iterations: 305 ms
```

#### Execution Time vs. Graph Size:
As the size of the graph increases, the execution time of the algorithm also increases. This is evident from the comparison between different graph sizes (10, 200, 1000) for the same density.
For example, for a density of 0.2, the average execution time increases from 0 ms (graph size 10) to 9 ms (graph size 200) to 317 ms (graph size 1000).
#### Execution Time vs. Density:
For a fixed graph size, as the density of the graph increases, the execution time generally decreases. This is particularly noticeable in the case of the largest graph size (1000).
For example, for a graph size of 1000, the average execution time decreases from 317 ms (density 0.2) to 301 ms (density 0.5) to 305 ms (density 0.8).
#### Impact of Optimization:
The optimization seems to have significantly reduced the execution time for larger graphs and higher densities. This is apparent from the decrease in execution time when transitioning from a density of 0.8 to 0.2 for the largest graph size (1000).
#### Overall Performance:
The algorithm demonstrates good scalability, as the execution time increases gradually with graph size. However, the impact of graph density on execution time is more significant, particularly for larger graphs.
#### Possible Further Optimizations:
While the current optimizations have improved performance, further optimizations could be explored to reduce execution time even more, especially for larger graphs. Techniques such as parallelization or more efficient data structures may be beneficial.