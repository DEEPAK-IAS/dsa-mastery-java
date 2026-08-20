# Two-Pointer Pattern Reference Guide

The **Two-Pointer Pattern** is an algorithmic technique that uses two array indices (pointers) to traverse a data structure simultaneously. It optimizes brute-force $O(n^2)$ nested loops down to **$O(n)$ linear time** while keeping **$O(1)$ auxiliary space**.

---

## 1. Core Pointer Variations

### Type A: Opposite Ends (Converging)
Pointers start at opposite ends (`left = 0`, `right = n - 1`) and move toward each other until they meet or cross (`left < right`).

* **When to use:** 
  * Array is sorted and you need to find pairs matching a target.
  * In-place swapping or reversing elements.
  * Comparing symmetric elements (e.g., checking palindromes).

* **Visual Representation:**
  ```text
  [ 2,  7, 11, 15 ]
    ↑           ↑
  left        right