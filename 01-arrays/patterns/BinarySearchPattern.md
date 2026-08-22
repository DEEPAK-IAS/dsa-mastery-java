# Binary Search Pattern Reference Guide

The **Binary Search** pattern is an efficient algorithmic technique used to find a target value within a sorted data structure or a defined solution space by repeatedly dividing the search interval in half.

Instead of a linear scan that costs $O(n)$ time, binary search cuts the search space down exponentially, achieving **$O(\log n)$ time complexity**.

---

## 1. Core Mechanics & The "Safe Mid" Formula

When calculating the middle index, always use this formula to prevent integer overflow errors that can happen with very large array sizes in languages like Java:

$$\text{mid} = \text{left} + \frac{\text{right} - \text{left}}{2}$$

### The Three-Step Loop:
1. **Find Mid:** Calculate `mid` between `left` and `right`.
2. **Evaluate:** 
   * If `nums[mid] == target`, you found your element.
   * If `nums[mid] < target`, the target must be in the right half $\rightarrow$ `left = mid + 1`.
   * If `nums[mid] > target`, the target must be in the left half $\rightarrow$ `right = mid - 1`.
3. **Terminate:** If `left > right`, the element is not present in the array.

---

## 2. Advanced Variation: Modified / Rotated Binary Search

Sometimes data isn't cleanly sorted from start to finish, such as an array rotated at an unknown pivot index. 

* **The Key Insight:** Even in a rotated array, when you split it at `mid`, **at least one of the two halves will always be strictly sorted**.
* **Strategy:** 
  1. Determine which half is sorted (`nums[left] <= nums[mid]` or vice versa).
  2. Check if your `target` falls within the boundaries of that sorted half.
  3. Narrow your pointers (`left` or `right`) to the correct side based on that check.

---

## 3. Standard Code Skeletons

### Classic Binary Search Skeleton
```java
public static int binarySearch(int[] nums, int target) {
    int left = 0;
    int right = nums.length - 1;

    while (left <= right) {
        int mid = left + (right - left) / 2;

        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] < target) {
            left = mid + 1;
        } else {
            right = mid - 1;
        }
    }
    return -1; // Not found
}