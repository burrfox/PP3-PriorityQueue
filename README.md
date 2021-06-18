# PP3-PriorityQueue


Use Priority Queue (PQ) in Java API to process city data and evaluate performance.
The data source is same as in project 1, i.e. city data via API,

1. Use PriorityQueue class in Java API process city data to print top 10 – 20% cities in terms of
population.

Note:
1) Retrieve city data from API to an array, such as City[ ] cities.
2) Build a heap with this array, and measure the executing time of this step T1. i.e. use a
heap constructor.
3) Print top 10 - 20% cities in terms of population by repeatedly call deleteMin( ) method,
and measure the executing time of this step T2.
4) Do NOT include time of step 1). Many students handled this issue incorrectly in
PP1. (although no point was deducted) The executing of step 1) is largely
depended on your computer I/O and Internet speed. From CSCI 311, 210 or 310,
I/O or network time is much larger than CPU executing time. Time analysis both
in measured actual executing time and in theoretical big-O analysis in this course
is for CPU.
