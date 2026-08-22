# Prefix Sum Pattern Reference Guide

The **Prefix Sum** pattern is an algorithmic technique used to efficiently answer range sum queries on a static array. 

Instead of iterating through a subarray from index `i` to `j` for every query (which takes $O(n)$ time per query, or $O(n \times m)$ total for $m$ queries), we precompute a **prefix sum array** (running total) in **$O(n)$ time**. Once precomputed, any range sum query can be answered in **$O(1)$ constant time** using simple subtraction.

---

## 1. Core Concept

* **Original Array (`nums`):** `[2, 4, 6, 8, 10]`
* **Prefix Sum Array (`prefixSum`):** `[2, 6, 12, 20, 30]`
  * `prefixSum[0] = nums[0]` (`2`)
  * `prefixSum[1] = prefixSum[0] + nums[1]` (`2 + 4 = 6`)
  * `prefixSum[2] = prefixSum[1] + nums[2]` (`6 + 6 = 12`)
  * And so on...

### The Formula
To find the sum of elements from index `left` to `right` (inclusive):
$$\text{Sum}(left, right) = \text{prefixSum}[right] - \text{prefixSum}[left - 1]$$

* **Edge Case:** If `left == 0`, there is no element before the range, so the sum is simply `prefixSum[right]`.

---

## 2. When to Use Prefix Sum?
* When a problem asks for **repeated range queries** (sum, product, or frequency) on a static array.
* When you need to optimize subarray sum problems from $O(n^2)$ down to $O(n)$ or $O(1)$ per query.
* Subarray sum equals a target ($k$) problems (often combined with a HashMap).

---

## 3. Standard Code Skeleton

```java
public class PrefixSumExample {
    private int[] prefixSum;

    public PrefixSumExample(int[] nums) {
        prefixSum = new int[nums.length];
        prefixSum[0] = nums[0];
        
        // Build running total array
        for (int i = 1; i < nums.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }
    }

    public int query(int left, int right) {
        if (left == 0) {
            return prefixSum[right];
        }
        return prefixSum[right] - prefixSum[left - 1];
    }
}