# Arrays — Complete DSA Notes

> A teacher-oriented guide to arrays, from fundamentals to common problem-solving patterns.
>
> **Goal:** Understand the concept, explain it clearly, implement it in Java, analyze complexity, and recognize when to use each technique.

---

## 1. What Is an Array?

An **array** is a collection of elements stored under one variable name, where each element is accessed using an index.

Example:

```java
int[] numbers = {10, 20, 30, 40, 50};
```

Conceptually:

```text
Index:    0    1    2    3    4
Value:   10   20   30   40   50
```

Java arrays:

- use zero-based indexing;
- have a fixed length after creation;
- store elements of one declared type;
- provide direct access by index.

### Teaching explanation

A useful analogy is a row of numbered boxes.

```text
Box 0 → 10
Box 1 → 20
Box 2 → 30
Box 3 → 40
Box 4 → 50
```

If you know the box number, you can directly open it.

---

# 2. Why Do We Need Arrays?

Without an array:

```java
int mark1 = 85;
int mark2 = 90;
int mark3 = 78;
int mark4 = 92;
```

With an array:

```java
int[] marks = {85, 90, 78, 92};
```

Arrays allow us to:

- store many related values;
- process values using loops;
- access values by index;
- implement many other data structures and algorithms.

---

# 3. Declaring an Array

### Declaration

```java
int[] numbers;
```

### Creation

```java
numbers = new int[5];
```

### Declaration + creation

```java
int[] numbers = new int[5];
```

### Initialization

```java
int[] numbers = {10, 20, 30, 40, 50};
```

### Other types

```java
double[] prices = {10.5, 20.5, 30.5};

char[] letters = {'A', 'B', 'C'};

String[] names = {"Alice", "Bob", "Charlie"};

boolean[] flags = {true, false, true};
```

---

# 4. Array Indexing

Java arrays start at index `0`.

```java
int[] numbers = {10, 20, 30, 40, 50};
```

```text
Index:    0    1    2    3    4
Value:   10   20   30   40   50
```

```java
numbers[0] // 10
numbers[2] // 30
numbers[4] // 50
```

The last valid index is:

```java
numbers.length - 1
```

Therefore:

```java
numbers[numbers.length - 1]
```

is the last element.

But:

```java
numbers[numbers.length]
```

is invalid.

It causes:

```text
ArrayIndexOutOfBoundsException
```

---

# 5. Array Length

For an array:

```java
numbers.length
```

Example:

```java
int[] numbers = new int[5];

System.out.println(numbers.length); // 5
```

Remember:

```text
Array      → length
String     → length()
ArrayList  → size()
```

---

# 6. Default Values

When an array is created with `new`, Java initializes its elements with default values.

```java
int[] numbers = new int[5];
```

Contents:

```text
0 0 0 0 0
```

Common defaults:

| Type | Default |
|---|---|
| `int` | `0` |
| `long` | `0` |
| `double` | `0.0` |
| `float` | `0.0` |
| `char` | `'\u0000'` |
| `boolean` | `false` |
| reference types | `null` |

---

# 7. Accessing an Element

```java
int[] numbers = {10, 20, 30, 40, 50};

System.out.println(numbers[2]);
```

Output:

```text
30
```

### Complexity

```text
Time: O(1)
Space: O(1) auxiliary space
```

Why?

Because the index directly identifies the required position.

---

# 8. Updating an Element

```java
int[] numbers = {10, 20, 30, 40, 50};

numbers[2] = 100;
```

Before:

```text
10 20 30 40 50
```

After:

```text
10 20 100 40 50
```

Complexity:

```text
Time: O(1)
```

---

# 9. Traversing an Array

Traversal means visiting every element.

### Traditional for loop

```java
for (int i = 0; i < numbers.length; i++) {
    System.out.println(numbers[i]);
}
```

### Enhanced for loop

```java
for (int number : numbers) {
    System.out.println(number);
}
```

### Complexity

```text
Time: O(n)
Auxiliary space: O(1)
```

The loop visits `n` elements.

---

# 10. Searching an Array

## Linear Search

Linear search checks elements one by one.

```java
public static int linearSearch(int[] numbers, int target) {

    for (int i = 0; i < numbers.length; i++) {
        if (numbers[i] == target) {
            return i;
        }
    }

    return -1;
}
```

Example:

```text
numbers = [10, 20, 30, 40]
target = 30
```

Check:

```text
10 → no
20 → no
30 → found
```

Complexity:

```text
Best:    O(1)
Average: O(n)
Worst:   O(n)
Space:   O(1)
```

### Teaching point

An unsorted array provides no information that lets us skip arbitrary elements, so in the worst case we may inspect every element.

---

# 11. Finding Maximum

```java
public static int findMax(int[] numbers) {

    int max = numbers[0];

    for (int number : numbers) {
        if (number > max) {
            max = number;
        }
    }

    return max;
}
```

Complexity:

```text
Time: O(n)
Space: O(1)
```

Why not `O(1)`?

Because we must inspect all elements to be certain that no larger value exists.

---

# 12. Finding Minimum

```java
public static int findMin(int[] numbers) {

    int min = numbers[0];

    for (int number : numbers) {
        if (number < min) {
            min = number;
        }
    }

    return min;
}
```

Complexity:

```text
Time: O(n)
Space: O(1)
```

---

# 13. Sum of Array

```java
public static int sum(int[] numbers) {

    int total = 0;

    for (int number : numbers) {
        total += number;
    }

    return total;
}
```

Complexity:

```text
Time: O(n)
Space: O(1)
```

---

# 14. Average of an Array

```java
public static double average(int[] numbers) {

    int total = 0;

    for (int number : numbers) {
        total += number;
    }

    return (double) total / numbers.length;
}
```

Complexity:

```text
Time: O(n)
Space: O(1)
```

---

# 15. Count Elements Matching a Condition

Example: count even numbers.

```java
public static int countEven(int[] numbers) {

    int count = 0;

    for (int number : numbers) {
        if (number % 2 == 0) {
            count++;
        }
    }

    return count;
}
```

Complexity:

```text
Time: O(n)
Space: O(1)
```

---

# 16. Reverse an Array

A common approach is the two-pointer technique.

```java
public static void reverse(int[] numbers) {

    int left = 0;
    int right = numbers.length - 1;

    while (left < right) {

        int temp = numbers[left];
        numbers[left] = numbers[right];
        numbers[right] = temp;

        left++;
        right--;
    }
}
```

Example:

```text
Before:
[10, 20, 30, 40, 50]

Swap 10 and 50:
[50, 20, 30, 40, 10]

Swap 20 and 40:
[50, 40, 30, 20, 10]
```

Complexity:

```text
Time: O(n)
Space: O(1)
```

### Important teaching point

The algorithm visits about half the array, but:

```text
O(n / 2) = O(n)
```

Constants are ignored in asymptotic complexity.

---

# 17. Copying an Array

### Using a loop

```java
int[] copy = new int[numbers.length];

for (int i = 0; i < numbers.length; i++) {
    copy[i] = numbers[i];
}
```

Complexity:

```text
Time: O(n)
Space: O(n)
```

Why is space `O(n)`?

Because a second array containing `n` elements is created.

---

# 18. `Arrays.copyOf`

Java provides:

```java
import java.util.Arrays;

int[] copy = Arrays.copyOf(numbers, numbers.length);
```

This still requires:

```text
Time: O(n)
Space: O(n)
```

The library method does not change the underlying asymptotic cost.

---

# 19. Inserting into an Array

Java arrays have a fixed size.

Suppose:

```text
[10, 20, 30, 40, 50]
```

We want to insert `25` at index `2`.

We must shift elements:

```text
[10, 20, 25, 30, 40, 50]
```

A normal Java array cannot grow. Usually, we create a new larger array.

Example:

```java
int[] oldArray = {10, 20, 30, 40, 50};

int[] newArray = new int[oldArray.length + 1];

int index = 2;
int value = 25;

for (int i = 0; i < index; i++) {
    newArray[i] = oldArray[i];
}

newArray[index] = value;

for (int i = index; i < oldArray.length; i++) {
    newArray[i + 1] = oldArray[i];
}
```

Typical complexity:

```text
Time: O(n)
Space: O(n)
```

---

# 20. Deleting from an Array

Suppose:

```text
[10, 20, 30, 40, 50]
```

Delete index `2`.

Elements after it must shift left:

```text
[10, 20, 40, 50]
```

Because Java arrays are fixed-size, a new array is normally required when changing the logical size.

Typical complexity:

```text
Time: O(n)
Space: O(n)
```

---

# 21. Static Array vs Dynamic Array

A Java array:

```java
int[] numbers = new int[5];
```

has a fixed length.

If you need a resizable collection, Java provides:

```java
ArrayList<Integer>
```

Example:

```java
ArrayList<Integer> numbers = new ArrayList<>();

numbers.add(10);
numbers.add(20);
numbers.add(30);
```

### Teaching distinction

```text
Array
→ fixed length

ArrayList
→ resizable abstraction backed by an array
```

Do not confuse the two.

---

# 22. Array Complexity Summary

| Operation | Typical Time |
|---|---:|
| Access by index | O(1) |
| Update by index | O(1) |
| Traverse | O(n) |
| Linear search | O(n) |
| Find min/max | O(n) |
| Sum | O(n) |
| Reverse | O(n) |
| Copy | O(n) |
| Insert at beginning | O(n) |
| Insert in middle | O(n) |
| Delete from beginning | O(n) |
| Delete from middle | O(n) |

For fixed-size arrays, insertion/deletion often involves shifting and/or creating another array.

---

# 23. Two-Dimensional Arrays

A 2D array is an array of arrays.

```java
int[][] matrix = {
    {1, 2, 3},
    {4, 5, 6},
    {7, 8, 9}
};
```

Conceptually:

```text
1 2 3
4 5 6
7 8 9
```

Access:

```java
matrix[0][0] // 1
matrix[1][2] // 6
matrix[2][1] // 8
```

Complexity of accessing a known cell:

```text
O(1)
```

---

# 24. Traversing a 2D Array

```java
for (int row = 0; row < matrix.length; row++) {

    for (int col = 0; col < matrix[row].length; col++) {
        System.out.print(matrix[row][col] + " ");
    }

    System.out.println();
}
```

For an `R x C` matrix:

```text
Time: O(R × C)
Space: O(1) auxiliary
```

---

# 25. Jagged Arrays

Java supports rows of different lengths.

```java
int[][] numbers = {
    {1, 2},
    {3, 4, 5},
    {6}
};
```

This is called a jagged array.

You must use:

```java
numbers[row].length
```

rather than assuming every row has the same length.

---

# 26. Prefix Sum

Prefix sum is a fundamental array technique.

Given:

```text
[2, 4, 1, 5, 3]
```

Prefix sums:

```text
[2, 6, 7, 12, 15]
```

Definition:

```text
prefix[i] = sum of elements from index 0 to i
```

Implementation:

```java
public static int[] buildPrefixSum(int[] numbers) {

    int[] prefix = new int[numbers.length];

    prefix[0] = numbers[0];

    for (int i = 1; i < numbers.length; i++) {
        prefix[i] = prefix[i - 1] + numbers[i];
    }

    return prefix;
}
```

Complexity:

```text
Time: O(n)
Space: O(n)
```

---

# 27. Range Sum Using Prefix Sum

For:

```text
numbers = [2, 4, 1, 5, 3]
prefix  = [2, 6, 7, 12, 15]
```

Sum from index `left` to `right`:

```text
if left == 0:
    prefix[right]
else:
    prefix[right] - prefix[left - 1]
```

Example:

Sum from index `1` to `3`:

```text
4 + 1 + 5 = 10
```

Using prefix:

```text
prefix[3] - prefix[0]
= 12 - 2
= 10
```

After preprocessing:

```text
Build prefix: O(n)
Each range query: O(1)
```

This is a major DSA pattern.

---

# 28. Two Pointers

Two pointers means maintaining two positions while processing an array.

Typical forms:

```text
left →       ← right
```

or:

```text
slow →
fast   →
```

Example: reverse an array.

```java
int left = 0;
int right = numbers.length - 1;

while (left < right) {

    int temp = numbers[left];
    numbers[left] = numbers[right];
    numbers[right] = temp;

    left++;
    right--;
}
```

Typical complexity:

```text
Time: O(n)
Space: O(1)
```

---

# 29. Two Pointers on a Sorted Array

A classic problem:

> Find whether two numbers sum to a target.

Given:

```text
[1, 2, 4, 7, 11]
target = 9
```

Use:

```text
left = 0
right = n - 1
```

Check:

```text
1 + 11 = 12
```

Too large → move `right`.

```text
1 + 7 = 8
```

Too small → move `left`.

```text
2 + 7 = 9
```

Found.

Implementation:

```java
public static boolean twoSumSorted(int[] numbers, int target) {

    int left = 0;
    int right = numbers.length - 1;

    while (left < right) {

        int sum = numbers[left] + numbers[right];

        if (sum == target) {
            return true;
        }

        if (sum < target) {
            left++;
        } else {
            right--;
        }
    }

    return false;
}
```

Complexity:

```text
Time: O(n)
Space: O(1)
```

### Important condition

This exact two-pointer strategy relies on the array being sorted.

---

# 30. Sliding Window

Sliding window is used when the problem involves a contiguous subarray or substring.

Example:

> Find the maximum sum of a subarray of size `k`.

```text
numbers = [2, 1, 5, 1, 3, 2]
k = 3
```

First window:

```text
2 + 1 + 5 = 8
```

Slide:

```text
1 + 5 + 1 = 7
```

Slide:

```text
5 + 1 + 3 = 9
```

Slide:

```text
1 + 3 + 2 = 6
```

Answer:

```text
9
```

Implementation:

```java
public static int maxSumOfSizeK(int[] numbers, int k) {

    int windowSum = 0;

    for (int i = 0; i < k; i++) {
        windowSum += numbers[i];
    }

    int maxSum = windowSum;

    for (int right = k; right < numbers.length; right++) {

        windowSum += numbers[right];
        windowSum -= numbers[right - k];

        maxSum = Math.max(maxSum, windowSum);
    }

    return maxSum;
}
```

Complexity:

```text
Time: O(n)
Space: O(1)
```

Without a sliding window, repeatedly calculating each window could lead to `O(nk)` work.

---

# 31. Fixed-Size vs Variable-Size Sliding Window

### Fixed-size

The window always has size `k`.

Examples:

- maximum sum of `k` consecutive elements;
- average of every window of size `k`.

### Variable-size

The window grows and shrinks according to a condition.

Typical structure:

```java
int left = 0;

for (int right = 0; right < numbers.length; right++) {

    // add numbers[right]

    while (/* window is invalid */) {
        // remove numbers[left]
        left++;
    }

    // update answer
}
```

This pattern appears frequently in interview problems.

---

# 32. Binary Search

Binary search works on a sorted search space.

Example:

```text
[10, 20, 30, 40, 50, 60, 70]
```

Target:

```text
60
```

Check middle:

```text
40
```

Target is larger, so discard the left half.

Then continue.

Implementation:

```java
public static int binarySearch(int[] numbers, int target) {

    int left = 0;
    int right = numbers.length - 1;

    while (left <= right) {

        int mid = left + (right - left) / 2;

        if (numbers[mid] == target) {
            return mid;
        }

        if (numbers[mid] < target) {
            left = mid + 1;
        } else {
            right = mid - 1;
        }
    }

    return -1;
}
```

Complexity:

```text
Time: O(log n)
Space: O(1)
```

### Why O(log n)?

The search space is approximately:

```text
n
n/2
n/4
n/8
...
```

Each step removes about half the possibilities.

---

# 33. Sorting and Arrays

Sorting is frequently used before applying an array pattern.

For example:

```text
Unsorted:
[7, 2, 9, 1, 5]

Sorted:
[1, 2, 5, 7, 9]
```

Sorting can enable:

- binary search;
- two pointers;
- duplicate handling;
- interval processing;
- greedy strategies.

Common sorting algorithms:

| Algorithm | Average Time | Worst Time | Extra Space |
|---|---:|---:|---:|
| Bubble Sort | O(n²) | O(n²) | O(1) |
| Selection Sort | O(n²) | O(n²) | O(1) |
| Insertion Sort | O(n²) | O(n²) | O(1) |
| Merge Sort | O(n log n) | O(n log n) | O(n) |
| Quick Sort | O(n log n) | O(n²) | depends on implementation |

Sorting is a separate topic, so learn these algorithms in depth later.

---

# 34. Frequency Counting

A common array problem is counting occurrences.

For a small known value range, an auxiliary frequency array can work.

Example:

```text
numbers = [1, 2, 1, 3, 2, 1]
```

Frequency:

```text
1 → 3
2 → 2
3 → 1
```

Implementation when values are known to be `0..maxValue`:

```java
int[] frequency = new int[maxValue + 1];

for (int number : numbers) {
    frequency[number]++;
}
```

Complexity:

```text
Time: O(n)
Space: O(k)
```

where `k` is the value range.

For arbitrary values, a `HashMap` may be more appropriate.

---

# 35. Kadane's Algorithm

Problem:

> Find the maximum sum of a contiguous subarray.

Example:

```text
[-2, 1, -3, 4, -1, 2, 1, -5, 4]
```

Best subarray:

```text
[4, -1, 2, 1]
```

Sum:

```text
6
```

Core idea:

At each position, decide whether to:

```text
start a new subarray
```

or:

```text
extend the previous subarray
```

Implementation:

```java
public static int maxSubarraySum(int[] numbers) {

    int current = numbers[0];
    int best = numbers[0];

    for (int i = 1; i < numbers.length; i++) {

        current = Math.max(numbers[i], current + numbers[i]);

        best = Math.max(best, current);
    }

    return best;
}
```

Complexity:

```text
Time: O(n)
Space: O(1)
```

This is an important example of converting a brute-force problem into a linear-time solution.

---

# 36. Dutch National Flag / Three-Way Partition

A classic array pattern is sorting an array containing only:

```text
0, 1, 2
```

Use three regions:

```text
[0 region][1 region][unknown region][2 region]
```

Pointers:

```text
low
mid
high
```

Implementation:

```java
public static void sortColors(int[] numbers) {

    int low = 0;
    int mid = 0;
    int high = numbers.length - 1;

    while (mid <= high) {

        if (numbers[mid] == 0) {
            swap(numbers, low, mid);
            low++;
            mid++;

        } else if (numbers[mid] == 1) {
            mid++;

        } else {
            swap(numbers, mid, high);
            high--;
        }
    }
}

private static void swap(int[] numbers, int i, int j) {

    int temp = numbers[i];
    numbers[i] = numbers[j];
    numbers[j] = temp;
}
```

Complexity:

```text
Time: O(n)
Space: O(1)
```

---

# 37. Common Array Problem Patterns

When you see an array problem, ask:

### Pattern 1 — Simple traversal

Question:

> Do I just need to inspect every element?

Think:

```text
for loop
O(n)
```

### Pattern 2 — Search

Question:

> Is the array sorted?

If no:

```text
Linear search
```

If yes:

```text
Binary search may apply
```

### Pattern 3 — Pair / opposite ends

Question:

> Is the array sorted and am I looking for a pair?

Think:

```text
Two pointers
```

### Pattern 4 — Contiguous subarray

Question:

> Is the problem about consecutive elements?

Think:

```text
Sliding window
Prefix sum
Kadane's algorithm
```

### Pattern 5 — Repeated range sums

Think:

```text
Prefix sum
```

### Pattern 6 — Frequencies

Think:

```text
Frequency array
HashMap
```

### Pattern 7 — Need ordering

Ask:

> Would sorting make the problem easier?

Think:

```text
Sorting + Two Pointers
Sorting + Greedy
Sorting + Binary Search
```

---

# 38. Brute Force vs Optimized Thinking

A major DSA skill is not immediately searching for a trick.

First create a correct brute-force solution.

Then ask:

```text
Can I reduce repeated work?
Can I use extra memory?
Can I sort first?
Can I use two pointers?
Can I maintain a window?
Can I precompute something?
Can I use binary search?
Can I use hashing?
```

Example:

### Brute force Two Sum

```java
for (int i = 0; i < n; i++) {
    for (int j = i + 1; j < n; j++) {

        if (numbers[i] + numbers[j] == target) {
            return true;
        }
    }
}
```

Complexity:

```text
O(n²)
```

Possible optimizations:

```text
Hashing → O(n) average
Sorting + Two Pointers → O(n log n)
```

This comparison is an important teaching exercise.

---

# 39. Array Edge Cases

Always ask students about:

### Empty array

```java
int[] numbers = {};
```

Be careful with:

```java
numbers[0]
```

It is invalid.

### One element

```text
[5]
```

### Two elements

```text
[5, 10]
```

### Duplicate values

```text
[2, 2, 2, 2]
```

### Negative values

```text
[-5, -2, -10]
```

### Already sorted

```text
[1, 2, 3, 4, 5]
```

### Reverse sorted

```text
[5, 4, 3, 2, 1]
```

### Very large values

Consider integer overflow when calculating sums.

For example:

```java
long sum = 0;
```

may be safer than:

```java
int sum = 0;
```

depending on constraints.

---

# 40. Common Student Mistakes

## Mistake 1: Off-by-one errors

Wrong:

```java
for (int i = 0; i <= numbers.length; i++)
```

Correct:

```java
for (int i = 0; i < numbers.length; i++)
```

---

## Mistake 2: Wrong last index

Wrong:

```java
numbers[numbers.length]
```

Correct:

```java
numbers[numbers.length - 1]
```

---

## Mistake 3: Confusing value and index

```java
numbers[i]
```

means:

> value stored at index `i`

It does not mean the value is `i`.

---

## Mistake 4: Modifying while iterating

Students often change array positions while simultaneously using those positions for loop control.

Teach them to carefully track:

```text
current index
updated value
next index
```

---

## Mistake 5: Assuming every two-pointer problem works on unsorted data

Many two-pointer strategies depend on sorted order or a special structure.

Always ask why pointer movement is valid.

---

# 41. Array Learning Sequence

Use this sequence when teaching.

```text
Level 1 — Fundamentals
    ↓
What is an array?
Declaration
Initialization
Indexing
Length
Access
Update
Traversal
    ↓
Level 2 — Basic Algorithms
    ↓
Linear Search
Find Min
Find Max
Sum
Average
Count
Reverse
Copy
    ↓
Level 3 — Array Manipulation
    ↓
Insert
Delete
Shift
Rotate
Move Zeroes
Remove Duplicates
    ↓
Level 4 — Patterns
    ↓
Two Pointers
Prefix Sum
Sliding Window
Frequency Counting
    ↓
Level 5 — Searching
    ↓
Binary Search
Binary Search Variants
    ↓
Level 6 — Advanced Array Problems
    ↓
Kadane
Three-Way Partition
Intervals
Matrix Problems
    ↓
Level 7 — Interview Problems
    ↓
Easy → Medium → Hard
```

---

# 42. Recommended Practice Progression

## Beginner

1. Print all elements
2. Find maximum
3. Find minimum
4. Calculate sum
5. Calculate average
6. Count even/odd numbers
7. Linear search
8. Count occurrences
9. Reverse array
10. Check if sorted

## Easy Interview Problems

1. Two Sum
2. Remove Duplicates from Sorted Array
3. Move Zeroes
4. Best Time to Buy and Sell Stock
5. Merge Sorted Array
6. Contains Duplicate
7. Majority Element
8. Missing Number

## Medium

1. 3Sum
2. Product of Array Except Self
3. Maximum Subarray
4. Container With Most Water
5. Subarray Sum Equals K
6. Sort Colors
7. Rotate Array
8. Spiral Matrix
9. Merge Intervals

## Hard / Advanced

1. Trapping Rain Water
2. First Missing Positive
3. Maximum Product Subarray
4. Median of Two Sorted Arrays
5. Sliding Window Maximum

> Problem names are included as a progression guide. Solve them only after learning the relevant pattern.

---

# 43. Teacher's Explanation Template

For every array problem, teach using this sequence:

```text
1. Understand the problem
2. Work through a small example
3. Identify brute force
4. Analyze brute-force complexity
5. Find repeated work
6. Identify a pattern
7. Build the optimized solution
8. Dry run the algorithm
9. Implement in Java
10. Analyze time complexity
11. Analyze space complexity
12. Discuss edge cases
13. Discuss common mistakes
14. Give a variation to students
```

---

# 44. The Most Important Array Questions

Before considering the array fundamentals complete, a student should be able to answer:

1. What is an array?
2. Why does array indexing start at zero in Java?
3. Why is access by index O(1)?
4. Why is searching an unsorted array O(n)?
5. Why is traversal O(n)?
6. Why can't a Java array change its length?
7. What is the difference between an array and ArrayList?
8. How do you reverse an array in-place?
9. What is the two-pointer technique?
10. When can two pointers be used?
11. What is prefix sum?
12. When should prefix sum be used?
13. What is a sliding window?
14. What is the difference between fixed and variable sliding windows?
15. When can binary search be used?
16. Why is binary search O(log n)?
17. What edge cases should be tested?
18. How do you analyze the time and space complexity of an array algorithm?

---

# 45. Final Array Complexity Cheat Sheet

```text
Access by index       O(1)
Update by index       O(1)

Traversal              O(n)
Linear search          O(n)
Find min/max           O(n)
Sum                    O(n)
Reverse                O(n)

Prefix sum build       O(n)
Prefix range query     O(1) after preprocessing

Two pointers           O(n) typical
Sliding window         O(n) typical
Binary search          O(log n) on sorted data

Copy array             O(n)
Extra array            O(n) space

2D matrix traversal    O(R × C)
```

---

# 46. Mastery Checklist

Use this before moving to the next DSA topic.

### Fundamentals

- [ ] I can create an array in Java.
- [ ] I understand zero-based indexing.
- [ ] I can access and update elements.
- [ ] I understand `length`.
- [ ] I understand array bounds.
- [ ] I can traverse an array.

### Basic Algorithms

- [ ] Linear search
- [ ] Find minimum
- [ ] Find maximum
- [ ] Sum
- [ ] Average
- [ ] Count
- [ ] Reverse
- [ ] Check sorted

### Patterns

- [ ] Two pointers
- [ ] Prefix sum
- [ ] Sliding window
- [ ] Frequency counting
- [ ] Binary search

### Problem Solving

- [ ] I can write a brute-force solution.
- [ ] I can calculate its complexity.
- [ ] I can identify repeated work.
- [ ] I can choose an appropriate pattern.
- [ ] I can explain why the optimized solution works.
- [ ] I can dry-run the algorithm.
- [ ] I can identify edge cases.

### Teaching

- [ ] I can explain arrays without code first.
- [ ] I can demonstrate indexing visually.
- [ ] I can explain why access is O(1).
- [ ] I can explain why traversal is O(n).
- [ ] I can demonstrate a brute-force solution before optimization.
- [ ] I can explain the reasoning behind each pattern.
- [ ] I can give students variations instead of only memorized problems.

---

# 47. Suggested Repository Structure

After completing the array module:

```text
01-arrays/
│
├── concepts/
│   ├── ArrayBasics.md
│   ├── ArraySearching.md
│   ├── ArrayManipulation.md
│   └── ArrayPatterns.md
│
├── implementations/
│   ├── ArrayBasics.java
│   ├── LinearSearch.java
│   ├── ReverseArray.java
│   ├── PrefixSum.java
│   ├── TwoPointers.java
│   ├── SlidingWindow.java
│   └── BinarySearch.java
│
├── patterns/
│   ├── TwoPointers.md
│   ├── PrefixSum.md
│   └── SlidingWindow.md
│
├── easy/
├── medium/
└── hard/
```

Keep explanations separate from problem solutions. This makes the repository easier to teach from and easier for students to navigate.

---

# 48. Next Step

Do not try to implement every advanced pattern immediately.

Start with:

```text
ArrayBasics
    ↓
Traversal
    ↓
Linear Search
    ↓
Min / Max / Sum
    ↓
Reverse
    ↓
Basic array manipulation
    ↓
Two Pointers
    ↓
Prefix Sum
    ↓
Sliding Window
    ↓
Binary Search
```

For each topic:

```text
Learn → Explain → Implement → Dry Run → Complexity → Practice → Commit
```

That workflow is the foundation of this DSA teaching repository.
