# Array Time & Space Complexity Reference

## 1. Core Array Operations

| Operation | Time Complexity | Auxiliary Space | Description / Reason |
| :--- | :--- | :--- | :--- |
| **Access by Index** | $O(1)$ | $O(1)$ | Direct memory address calculation via formula: $\text{Base} + i \times \text{size}$. |
| **Update Index** | $O(1)$ | $O(1)$ | Replaces value at a known index in-place. |
| **Linear Search** | $O(n)$ | $O(1)$ | Scans elements sequentially until match is found. |
| **Binary Search** | $O(\log n)$ | $O(1)$ | Requires sorted array; divides search space in half each step. |
| **Traversal** | $O(n)$ | $O(1)$ | Visits all $n$ elements sequentially. |

---

## 2. Modification Operations (Fixed-Size Java Primitive Arrays)

> **Note:** Because standard Java arrays are fixed-size, insertions and deletions require allocating a new array and copying elements, resulting in $O(n)$ auxiliary space.

| Operation | Time Complexity | Auxiliary Space | Reason |
| :--- | :--- | :--- | :--- |
| **Insert at Beginning** | $O(n)$ | $O(n)$ | Must copy all $n$ elements shifted right by 1 index. |
| **Insert at End** | $O(n)$ | $O(n)$ | Must copy all $n$ elements into new array of size $n+1$. |
| **Insert at Index $k$** | $O(n)$ | $O(n)$ | Shifts elements after index $k$ right by 1. |
| **Delete at Beginning** | $O(n)$ | $O(n)$ | Shifts elements from index 1 onward left by 1. |
| **Delete at End** | $O(n)$ | $O(n)$ | Copies $n-1$ elements into a new array. |
| **Delete at Index $k$** | $O(n)$ | $O(n)$ | Shifts elements after index $k$ left by 1. |

---

## 3. Two-Pointer Patterns

| Algorithm | Time Complexity | Auxiliary Space | Technique |
| :--- | :--- | :--- | :--- |
| **Reverse Array** | $O(n)$ | $O(1)$ | Opposite Ends (Converging) pointers swapping in-place. |
| **Remove Duplicates** | $O(n)$ | $O(1)$ | Fast & Slow pointers modifying array in-place. |
| **Two Sum II (Sorted)** | $O(n)$ | $O(1)$ | Opposite Ends pointers moving inward based on comparison. |
| **Rotate Array (3-Step)** | $O(n)$ | $O(1)$ | Reverses entire array, then two sub-arrays in-place. |

---

## Key Terms

* **Time Complexity ($O$):** How the runtime scales relative to the input size $n$.
* **Auxiliary Space:** Extra memory allocated by the algorithm, excluding the original input memory.
* **In-Place Algorithm:** Modifies the input structure directly without allocating additional array structures ($O(1)$ auxiliary space).