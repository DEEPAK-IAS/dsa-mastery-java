# Sliding Window Pattern Reference Guide

The **Sliding Window Pattern** is an algorithmic technique used to perform operations on a specific subset (window) of elements in a linear data structure—such as an array, list, or string—usually to find sub-arrays or substrings that satisfy a given condition.

Instead of recomputing the window from scratch using nested loops (which would cost $O(n \times k)$ or $O(n^2)$ time), a sliding window **slides** over the data in **$O(n)$ linear time** by maintaining state: adding new elements entering on the right and removing old elements leaving on the left.

---

## 1. Core Window Variations

### Type A: Fixed-Size Window
The size of the window ($k$) remains constant as it slides from the beginning of the array to the end.
* **When to use:** 
  * Find the maximum/minimum sum, average, or other metric of a subarray of a fixed length $k$.
* **Visual Representation:**
  ```text
  [ 1,  12,  -5,  -6,  50,  3 ]  (k = 4)
    ├─── Window 1 ───┤
        ├─── Window 2 ───┤