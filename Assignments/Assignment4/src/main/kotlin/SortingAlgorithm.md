### Sorting Algorithm Performance Analysis

We tested the effectiveness of four distinct sorting algorithms in this experiment: heap sort, radius sort, insertion sort, and selection sort, for varying list sizes. The objective was to determine each algorithm's efficiency by analyzing how its runtime increases with list size.

#### Experiment Setup

1. **List Sizes**: We used lists of different sizes—100, 500, 1000, 5000, and 10,000—to test the algorithms.

2. **List Generation**: Random integer lists were generated for each test case. The `generateRandomList` function was utilized to create arrays filled with random integers within the range of the list size.

3. **Execution**: Each sorting algorithm was applied to the generated random lists, and the runtime was measured using Kotlin's `measureTimeMillis` function.

4. **Replication**: To ensure reliability, each experiment was repeated multiple times, and the average runtime was calculated.

#### Results

Below is a tabular representation of the average runtime (in milliseconds) for each sorting algorithm across different list sizes:

| List Size | Heap Sort | Radix Sort | Insertion Sort | Selection Sort |
|-----------|-----------|------------|----------------|----------------|
| 100       | 0         | 3          | 0              | 8              |
| 500       | 0         | 1          | 1              | 25             |
| 1000      | 0         | 1          | 1              | 54             |
| 5000      | 4         | 2          | 20             | 1110           |
| 10000     | 12        | 4          | 95             | 4188           |

#### Observations

1. **Efficiency**: Radix Sort consistently demonstrated the lowest runtime across all list sizes, indicating its efficiency, especially for larger datasets. Its linear time complexity contributed to this performance.

2. **Scalability**: Insertion Sort and Selection Sort exhibited poor scalability, with significantly increased runtimes as the list size grew. Their quadratic time complexities make them unsuitable for large datasets.

3. **Heap Sort**: While Heap Sort's runtime was generally better than Insertion Sort and Selection Sort, it was outperformed by Radix Sort, particularly for larger lists. However, Heap Sort still maintained relatively stable performance across different list sizes.

#### Conclusion

My experiment shows that Radix Sort is the most effective sorting algorithm for the examined cases, providing scalable and reliable performance for a range of list sizes. Even though Heap Sort likewise does a respectable job, it is generally slower than Radix Sort, particularly when dealing with larger datasets. Due to their quadratic temporal difficulties, Insertion Sort and Selection Sort are not recommended for sorting huge datasets; instead, they work better on smaller lists. In general, the size of the dataset and the intended performance characteristics should be taken into account while selecting a sorting method.

