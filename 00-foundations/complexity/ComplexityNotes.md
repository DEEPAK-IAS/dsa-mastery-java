# Time & Space Complexity

> Complexity analysis helps us understand how an algorithm's resource usage grows as the input size increases.

---

## 1. Why Complexity Analysis?

When comparing algorithms, we usually care about:

1. **Time Complexity** - how the running time grows with input size.
2. **Space Complexity** - how the additional memory usage grows with input size.

We usually describe this growth using **Big O notation**.

Example:

```java
public static int findFirst(int[] numbers) {
    return numbers[0];
}
```

Whether the array contains:

```text
10 elements
1,000 elements
1,000,000 elements
```

the algorithm performs one access.

Therefore:

```text
Time: O(1)
Space: O(1)
```

---

# 2. What Is Input Size?

We usually represent the input size using `n`.

For an array:

```java
int[] numbers = new int[n];
```

`n` represents the number of elements.

For two arrays:

```java
int[] a = new int[n];
int[] b = new int[m];
```

we have two independent input sizes:

```text
n = size of array a
m = size of array b
```

Therefore, an algorithm may have:

```text
O(n)
O(m)
O(n + m)
O(nm)
```

Do not automatically replace every variable with `n`.

---

# 3. Big O Notation

Big O describes the upper-bound growth rate of an algorithm.

For interview-style analysis, we normally focus on how the algorithm scales as the input becomes large.

Common complexities:

```text
O(1)
O(log n)
O(n)
O(n log n)
O(n²)
O(n³)
O(2ⁿ)
O(n!)
```

From generally better scalability to worse scalability:

```text
O(1)
   ↓
O(log n)
   ↓
O(n)
   ↓
O(n log n)
   ↓
O(n²)
   ↓
O(n³)
   ↓
O(2ⁿ)
   ↓
O(n!)
```

This ordering is about growth rate, not necessarily the actual runtime for every small input.

---

# 4. O(1) - Constant Time

An algorithm is `O(1)` when its work does not depend on `n`.

Example:

```java
public static int getFirst(int[] numbers) {
    return numbers[0];
}
```

Another example:

```java
public static int add(int a, int b) {
    return a + b;
}
```

The number of operations remains approximately constant.

```text
Time: O(1)
Space: O(1)
```

### Important Pattern

Direct access is commonly `O(1)`:

```java
numbers[0]
numbers[i]
```

For a Java array, accessing an element by index is constant time.

---

# 5. O(n) - Linear Time

The amount of work grows linearly with `n`.

Example:

```java
public static void printAll(int[] numbers) {

    for (int number : numbers) {
        System.out.println(number);
    }
}
```

If:

```text
n = 10
```

the loop runs approximately 10 times.

If:

```text
n = 1,000
```

the loop runs approximately 1,000 times.

Therefore:

```text
Time: O(n)
Space: O(1)
```

---

# 6. O(n) With Multiple Linear Operations

Consider:

```java
for (int i = 0; i < n; i++) {
    // O(n)
}

for (int i = 0; i < n; i++) {
    // O(n)
}
```

Total:

```text
O(n) + O(n)
= O(2n)
```

We drop constants:

```text
O(2n) → O(n)
```

Therefore:

```text
Time: O(n)
```

---

# 7. O(n + m)

When two independent inputs exist:

```java
for (int i = 0; i < n; i++) {
    // work
}

for (int j = 0; j < m; j++) {
    // work
}
```

Complexity:

```text
O(n + m)
```

Do not simplify this to `O(n)` unless you know that `n` and `m` are related.

---

# 8. O(n²) - Quadratic Time

Two nested loops depending on the same input size commonly produce `O(n²)`.

Example:

```java
public static void printPairs(int[] numbers) {

    for (int i = 0; i < numbers.length; i++) {

        for (int j = 0; j < numbers.length; j++) {

            System.out.println(
                numbers[i] + " " + numbers[j]
            );
        }
    }
}
```

The outer loop runs `n` times.

The inner loop runs `n` times for each outer iteration.

Therefore:

```text
n × n = n²
```

Complexity:

```text
Time: O(n²)
Space: O(1)
```

---

# 9. O(n³) - Cubic Time

Three nested loops:

```java
for (int i = 0; i < n; i++) {

    for (int j = 0; j < n; j++) {

        for (int k = 0; k < n; k++) {

            // work
        }
    }
}
```

Complexity:

```text
n × n × n
= n³
```

Therefore:

```text
Time: O(n³)
```

Triple nested loops are often expensive for large inputs.

---

# 10. O(nm)

Consider:

```java
for (int i = 0; i < n; i++) {

    for (int j = 0; j < m; j++) {

        // work
    }
}
```

The outer loop runs `n` times.

The inner loop runs `m` times for every outer iteration.

Therefore:

```text
Time: O(nm)
```

This is different from:

```text
O(n²)
```

unless `n` and `m` are known to be the same size.

---

# 11. O(log n) - Logarithmic Time

An algorithm is commonly `O(log n)` when the problem size is repeatedly reduced by a constant factor.

The classic example is binary search.

Example:

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

The search space becomes approximately:

```text
n
n / 2
n / 4
n / 8
n / 16
...
```

Eventually it reaches 1.

Therefore:

```text
Time: O(log n)
Space: O(1)
```

### Key Recognition Pattern

When an algorithm repeatedly does something like:

```text
n → n/2 → n/4 → n/8
```

think:

```text
O(log n)
```

---

# 12. Why Binary Search Is O(log n)

Suppose:

```text
n = 16
```

Binary search reduces the search space:

```text
16
 ↓
8
 ↓
4
 ↓
2
 ↓
1
```

Number of reductions:

```text
log₂(16) = 4
```

For:

```text
n = 1,000,000
```

the number of iterations is still relatively small.

This is why binary search is extremely efficient.

---

# 13. O(n log n)

`O(n log n)` commonly appears in efficient sorting algorithms.

Examples:

```text
Merge Sort
Heap Sort
Quick Sort - average case
```

Conceptually, Merge Sort:

```text
              n
            /   \
          n/2   n/2
         / \     / \
       ... ...  ... ...
```

There are approximately:

```text
log n
```

levels.

At each level, approximately:

```text
n
```

elements are processed.

Therefore:

```text
n × log n
```

giving:

```text
O(n log n)
```

---

# 14. O(2ⁿ) - Exponential Time

An algorithm can become exponential when each recursive call creates multiple additional calls.

Example:

```java
public static void generate(int n) {

    if (n == 0) {
        return;
    }

    generate(n - 1);
    generate(n - 1);
}
```

Each call creates two more calls.

Conceptually:

```text
                  n
                /   \
             n-1     n-1
            /  \     /  \
          ...  ... ...  ...
```

The number of calls grows exponentially.

Approximate complexity:

```text
Time: O(2ⁿ)
```

This type of complexity appears in some brute-force recursive and backtracking problems.

---

# 15. O(n!) - Factorial Time

Factorial complexity appears when we generate all permutations of `n` elements.

Number of permutations:

```text
n!
```

Examples:

```text
3! = 6
5! = 120
10! = 3,628,800
```

Factorial growth becomes enormous very quickly.

Permutation and brute-force problems can therefore become extremely expensive.

Typical complexity:

```text
O(n!)
```

---

# 16. Space Complexity

Space complexity measures how much memory an algorithm uses as the input grows.

We usually care about **additional/auxiliary space** used by the algorithm.

Example:

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

Additional variables:

```text
max
number
```

The number of additional variables does not grow with `n`.

Therefore:

```text
Time: O(n)
Space: O(1)
```

---

# 17. O(n) Auxiliary Space

Consider:

```java
public static int[] copyArray(int[] numbers) {

    int[] copy = new int[numbers.length];

    for (int i = 0; i < numbers.length; i++) {
        copy[i] = numbers[i];
    }

    return copy;
}
```

The new array grows with `n`.

Therefore:

```text
Time: O(n)
Space: O(n)
```

---

# 18. Input Space vs Auxiliary Space

Suppose:

```java
public static int sum(int[] numbers) {

    int sum = 0;

    for (int number : numbers) {
        sum += number;
    }

    return sum;
}
```

The input array itself requires `O(n)` memory.

However, the algorithm does not create additional memory proportional to `n`.

Therefore:

```text
Input space: O(n)
Auxiliary space: O(1)
```

When discussing algorithm space complexity, interviewers often care about **auxiliary space**.

Be clear about which one you're reporting.

---

# 19. Recursion and Space Complexity

Recursive calls consume stack memory.

Example:

```java
public static void countDown(int n) {

    if (n == 0) {
        return;
    }

    countDown(n - 1);
}
```

There are `n` recursive calls on the call stack.

Therefore:

```text
Time: O(n)
Space: O(n)
```

Even though no array or collection is created, recursion itself consumes stack space.

---

# 20. Recursion With Two Calls

Consider:

```java
public static void example(int n) {

    if (n == 0) {
        return;
    }

    example(n - 1);
    example(n - 1);
}
```

The number of calls is exponential:

```text
Time: O(2ⁿ)
```

But the maximum depth of the recursion is only:

```text
n
```

Therefore, ignoring additional allocations:

```text
Space: O(n)
```

Important:

```text
Time complexity != recursion depth
```

---

# 21. Sequential vs Nested Loops

### Sequential loops

```java
for (int i = 0; i < n; i++) {
    // work
}

for (int i = 0; i < n; i++) {
    // work
}
```

Complexity:

```text
O(n) + O(n)
= O(2n)
= O(n)
```

### Nested loops

```java
for (int i = 0; i < n; i++) {

    for (int j = 0; j < n; j++) {

    }
}
```

Complexity:

```text
O(n × n)
= O(n²)
```

### Rule

Sequential:

```text
ADD
```

Nested:

```text
MULTIPLY
```

---

# 22. Different Growth Rates in One Algorithm

Consider:

```java
for (int i = 0; i < n; i++) {
    // O(n)
}

for (int i = 0; i < n; i++) {

    for (int j = 0; j < n; j++) {
        // O(n²)
    }
}
```

Total:

```text
O(n) + O(n²)
```

Keep the dominant term:

```text
O(n²)
```

Therefore:

```text
Time: O(n²)
```

---

# 23. Dropping Constants

Suppose an algorithm performs:

```text
5n operations
```

We write:

```text
O(5n)
```

but simplify it to:

```text
O(n)
```

Similarly:

```text
O(100n)
→ O(n)
```

The constant does not change the growth category.

---

# 24. Dropping Lower-Order Terms

Suppose:

```text
O(n² + n + 10)
```

For very large `n`, `n²` dominates.

Therefore:

```text
O(n² + n + 10)
→ O(n²)
```

Another example:

```text
O(n³ + n² + n)
→ O(n³)
```

Another:

```text
O(n log n + n)
→ O(n log n)
```

---

# 25. Common Complexity Rules

## Rule 1: Drop Constants

```text
O(2n) → O(n)
O(50n) → O(n)
```

## Rule 2: Keep the Dominant Term

```text
O(n² + n) → O(n²)
```

## Rule 3: Sequential Operations Add

```text
O(n) + O(m)
→ O(n + m)
```

## Rule 4: Nested Operations Multiply

```text
O(n) × O(m)
→ O(nm)
```

## Rule 5: Repeated Halving Is Usually Logarithmic

```text
n → n/2 → n/4 → ...
→ O(log n)
```

## Rule 6: Recursive Branching Can Be Exponential

```text
2 recursive calls per level
→ often O(2ⁿ)
```

## Rule 7: Recursive Depth Uses Stack Space

```text
n recursive levels
→ O(n) stack space
```

---

# 26. Common Loop Patterns

## Pattern 1

```java
for (int i = 0; i < n; i++) {
}
```

```text
O(n)
```

---

## Pattern 2

```java
for (int i = 0; i < n; i++) {

    for (int j = 0; j < n; j++) {
    }
}
```

```text
O(n²)
```

---

## Pattern 3

```java
for (int i = 0; i < n; i++) {

    for (int j = 0; j < m; j++) {
    }
}
```

```text
O(nm)
```

---

## Pattern 4

```java
for (int i = 0; i < n; i += 2) {
}
```

```text
O(n)
```

The constant `2` does not matter.

---

## Pattern 5

```java
for (int i = 1; i < n; i *= 2) {
}
```

Values:

```text
1
2
4
8
16
32
...
```

This is:

```text
O(log n)
```

---

## Pattern 6

```java
for (int i = n; i > 0; i /= 2) {
}
```

Again:

```text
O(log n)
```

---

## Pattern 7

```java
for (int i = 0; i < n; i++) {

    for (int j = 0; j < i; j++) {
    }
}
```

Total work:

```text
0 + 1 + 2 + 3 + ... + n
```

This is approximately:

```text
n² / 2
```

Drop the constant:

```text
O(n²)
```

---

# 27. Best, Average, and Worst Case

An algorithm can have different complexity depending on the input.

Example: Linear Search.

```java
public static int search(int[] numbers, int target) {

    for (int i = 0; i < numbers.length; i++) {

        if (numbers[i] == target) {
            return i;
        }
    }

    return -1;
}
```

### Best Case

Target is the first element:

```text
O(1)
```

### Worst Case

Target is at the end or does not exist:

```text
O(n)
```

### Average Case

Typically:

```text
O(n)
```

Therefore:

```text
Best:    O(1)
Average: O(n)
Worst:   O(n)
```

---

# 28. Big O vs Big Theta vs Big Omega

For most coding interviews, Big O is the most commonly used notation.

### Big O - O

Describes an upper bound on growth.

Example:

```text
O(n)
```

### Big Omega - Ω

Describes a lower bound.

Example:

```text
Ω(1)
```

### Big Theta - Θ

Describes a tight asymptotic bound.

Example:

```text
Θ(n)
```

For practical DSA interview preparation:

```text
Focus heavily on Big O.
Understand the basic meaning of Ω and Θ.
```

---

# 29. Amortized Complexity

Some operations are occasionally expensive but cheap on average over many operations.

A classic example is dynamic arrays such as Java's:

```java
ArrayList<Integer>
```

Appending an element is usually:

```text
O(1)
```

But occasionally the internal array must grow and elements are copied.

That particular resize can take:

```text
O(n)
```

However, over many insertions, the amortized cost of adding an element is:

```text
O(1) amortized
```

This distinction becomes useful when studying:

```text
ArrayList
Stack
Queue
Dynamic arrays
Hash tables
```

---

# 30. Java Collections and Typical Complexity

These are important for DSA in Java.

## Array

```text
Access by index: O(1)
Search:           O(n)
Insertion:        O(n)
Deletion:         O(n)
```

---

## ArrayList

Typical:

```text
get(index):       O(1)
add(end):         O(1) amortized
add(index):       O(n)
remove(index):    O(n)
search:           O(n)
```

---

## LinkedList

Typical:

```text
get(index):       O(n)
search:           O(n)
add/remove ends:  O(1)
```

Important: Java's `LinkedList` is not automatically the best choice just because a problem mentions linked lists.

---

## HashMap

Average/expected:

```text
put:       O(1)
get:       O(1)
remove:    O(1)
contains:  O(1)
```

Worst-case behavior can differ because of collisions and implementation details.

For normal DSA interview analysis, we usually state:

```text
Average: O(1)
```

---

## HashSet

Typical average:

```text
add:       O(1)
contains:  O(1)
remove:    O(1)
```

---

## TreeMap

Based on a balanced tree:

```text
put:       O(log n)
get:       O(log n)
remove:    O(log n)
contains:  O(log n)
```

---

## PriorityQueue

Java's `PriorityQueue` is heap-based.

Typical:

```text
peek:      O(1)
offer:     O(log n)
poll:      O(log n)
```

---

# 31. Common Data Structure Complexity Table

| Data Structure | Access |   Search |                Insert |             Delete |
| -------------- | -----: | -------: | --------------------: | -----------------: |
| Array          |   O(1) |     O(n) |                  O(n) |               O(n) |
| ArrayList      |   O(1) |     O(n) | O(1) amortized at end |               O(n) |
| Linked List    |   O(n) |     O(n) |    O(1) at known node | O(1) at known node |
| HashMap        |    N/A | O(1) avg |              O(1) avg |           O(1) avg |
| HashSet        |    N/A | O(1) avg |              O(1) avg |           O(1) avg |
| TreeMap        |    N/A | O(log n) |              O(log n) |           O(log n) |
| PriorityQueue  |    N/A |     O(n) |              O(log n) |           O(log n) |

> These are typical asymptotic complexities. The exact behavior can depend on implementation and operation details.

---

# 32. Algorithm Complexity Reference

| Algorithm       |               Time |                  Space |
| --------------- | -----------------: | ---------------------: |
| Array traversal |               O(n) |                   O(1) |
| Linear Search   |               O(n) |                   O(1) |
| Binary Search   |           O(log n) |         O(1) iterative |
| Bubble Sort     |              O(n²) |                   O(1) |
| Selection Sort  |              O(n²) |                   O(1) |
| Insertion Sort  |              O(n²) |                   O(1) |
| Merge Sort      |         O(n log n) |                   O(n) |
| Heap Sort       |         O(n log n) |         O(1) auxiliary |
| Quick Sort      | O(n log n) average | O(log n) average stack |
| DFS             |           O(V + E) |                   O(V) |
| BFS             |           O(V + E) |                   O(V) |

---

# 33. Graph Complexity Notation

Graphs commonly use:

```text
V = number of vertices
E = number of edges
```

For an adjacency-list graph:

```text
BFS:
O(V + E)

DFS:
O(V + E)
```

Why?

We may visit:

```text
V vertices
```

and process:

```text
E edges
```

Therefore:

```text
O(V + E)
```

This notation will become very important when we reach Graphs.

---

# 34. Matrix Complexity

For an `n × m` matrix:

```java
for (int i = 0; i < n; i++) {

    for (int j = 0; j < m; j++) {

        // process matrix[i][j]
    }
}
```

Complexity:

```text
Time: O(nm)
```

If the matrix is specifically `n × n`:

```text
O(n²)
```

---

# 35. How to Analyze an Algorithm

Whenever you solve a problem, follow this process.

### Step 1: Identify the input size

Ask:

```text
What does n represent?
Are there multiple inputs?
```

---

### Step 2: Count loops

Ask:

```text
How many times does each loop execute?
```

---

### Step 3: Check nesting

Nested loops often multiply.

```text
O(n) × O(n)
→ O(n²)
```

---

### Step 4: Check sequential operations

Sequential loops usually add.

```text
O(n) + O(n)
→ O(n)
```

---

### Step 5: Look for halving

If the search space repeatedly becomes:

```text
n / 2
```

think:

```text
O(log n)
```

---

### Step 6: Look for sorting

Sorting often contributes:

```text
O(n log n)
```

depending on the sorting algorithm.

---

### Step 7: Check recursion

Ask:

```text
How many recursive calls?
How deep is the recursion?
```

---

### Step 8: Check additional memory

Look for:

```text
Arrays
HashMaps
HashSets
Stacks
Queues
Recursion stack
Temporary objects
```

---

# 36. Worked Example 1

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

Analysis:

```text
One loop
→ O(n)

Only a few variables
→ O(1) auxiliary space
```

Final:

```text
Time: O(n)
Space: O(1)
```

---

# 37. Worked Example 2

```java
public static boolean containsDuplicate(int[] numbers) {

    for (int i = 0; i < numbers.length; i++) {

        for (int j = i + 1; j < numbers.length; j++) {

            if (numbers[i] == numbers[j]) {
                return true;
            }
        }
    }

    return false;
}
```

Nested loops:

```text
O(n²)
```

No additional data structure:

```text
O(1)
```

Final:

```text
Time: O(n²)
Space: O(1)
```

---

# 38. Worked Example 3

Using a HashSet:

```java
public static boolean containsDuplicate(int[] numbers) {

    Set<Integer> seen = new HashSet<>();

    for (int number : numbers) {

        if (!seen.add(number)) {
            return true;
        }
    }

    return false;
}
```

One loop:

```text
O(n)
```

HashSet can contain up to `n` elements:

```text
O(n)
```

Final:

```text
Time: O(n) average
Space: O(n)
```

This is an example of trading space for time.

---

# 39. Time-Space Tradeoff

Sometimes we use additional memory to make an algorithm faster.

Example:

```text
Brute Force
Time: O(n²)
Space: O(1)
```

Using HashMap:

```text
Optimized
Time: O(n)
Space: O(n)
```

This is called a:

```text
Time-Space Tradeoff
```

This concept appears constantly in interview problems.

---

# 40. Complexity Comparison

For large `n`, growth roughly behaves like:

```text
O(1)
     ↓
O(log n)
     ↓
O(n)
     ↓
O(n log n)
     ↓
O(n²)
     ↓
O(n³)
     ↓
O(2ⁿ)
     ↓
O(n!)
```

The exact practical performance depends on constants, hardware, implementation, and input characteristics.

Big O describes growth, not a stopwatch reading.

---

# 41. Common Mistakes

## Mistake 1: Thinking every nested loop is O(n²)

Not necessarily.

```java
for (int i = 0; i < n; i++) {

    for (int j = 0; j < m; j++) {
    }
}
```

is:

```text
O(nm)
```

---

## Mistake 2: Forgetting recursion space

```text
Recursive depth n
→ O(n) stack space
```

---

## Mistake 3: Counting constants

Do not report:

```text
O(2n)
```

when the simplified complexity is:

```text
O(n)
```

---

## Mistake 4: Ignoring auxiliary data structures

If you create:

```java
HashMap<Integer, Integer> map = new HashMap<>();
```

and it grows with `n`, you need to account for:

```text
O(n) space
```

---

## Mistake 5: Assuming sorting is always O(n log n)

Different sorting algorithms have different complexities.

For example:

```text
Bubble Sort:   O(n²)
Selection Sort: O(n²)
Insertion Sort: O(n²) worst case
Merge Sort:    O(n log n)
Heap Sort:     O(n log n)
Quick Sort:    O(n log n) average
```

---

## Mistake 6: Confusing input space with auxiliary space

An input array of size `n` already occupies:

```text
O(n)
```

But an algorithm may still use:

```text
O(1)
```

additional memory.

Always clarify what you are measuring.

---

# 42. Complexity Checklist

When solving a problem, ask:

```text
[ ] What is the input size?
[ ] Are there multiple input sizes?
[ ] How many loops are there?
[ ] Are loops nested?
[ ] Are loops sequential?
[ ] Does the algorithm repeatedly halve the input?
[ ] Is sorting involved?
[ ] Is recursion involved?
[ ] How many recursive branches exist?
[ ] What data structures are created?
[ ] How much additional memory grows with n?
[ ] What is the final time complexity?
[ ] What is the final space complexity?
```

---

# 43. Complexity Practice

Before moving to Arrays, practice analyzing these.

## Problem 1

```java
for (int i = 0; i < n; i++) {
    System.out.println(i);
}
```

Answer:

```text
Time: O(n)
Space: O(1)
```

---

## Problem 2

```java
for (int i = 0; i < n; i++) {

    for (int j = 0; j < n; j++) {
        System.out.println(i + j);
    }
}
```

Answer:

```text
Time: O(n²)
Space: O(1)
```

---

## Problem 3

```java
for (int i = 1; i < n; i *= 2) {
    System.out.println(i);
}
```

Answer:

```text
Time: O(log n)
Space: O(1)
```

---

## Problem 4

```java
int[] result = new int[n];

for (int i = 0; i < n; i++) {
    result[i] = i;
}
```

Answer:

```text
Time: O(n)
Space: O(n)
```

---

## Problem 5

```java
for (int i = 0; i < n; i++) {

    for (int j = 0; j < m; j++) {

        for (int k = 0; k < 10; k++) {

            // work
        }
    }
}
```

Analysis:

```text
O(n × m × 10)
→ O(nm)
```

Answer:

```text
Time: O(nm)
Space: O(1)
```

---

# 44. Mastery Requirements

Before leaving the Complexity section, you should be able to identify:

```text
O(1)       Constant
O(log n)   Logarithmic
O(n)       Linear
O(n log n) Linearithmic
O(n²)      Quadratic
O(n³)      Cubic
O(2ⁿ)      Exponential
O(n!)      Factorial
```

You should also understand:

```text
Best Case
Average Case
Worst Case

Time Complexity
Space Complexity
Auxiliary Space

Sequential Operations
Nested Operations

Recursion
Recursion Stack

Amortized Complexity
Time-Space Tradeoff

n vs m
V vs E
```

---

# 45. Final Mental Model

When you see code, think:

```text
                    CODE
                      │
                      ↓
             Identify input size
                      │
                      ↓
                Count operations
                      │
             ┌────────┴────────┐
             ↓                 ↓
        Sequential          Nested
             │                 │
           ADD              MULTIPLY
             │                 │
             └────────┬────────┘
                      ↓
              Check recursion
                      ↓
              Check halving
                      ↓
             Check data structures
                      ↓
              Analyze extra space
                      ↓
              Simplify the result
                      ↓
            Time + Space Complexity
```

---

# 46. Quick Reference

```text
O(1)
Constant

O(log n)
Repeatedly divide the problem

O(n)
One full pass

O(n log n)
Efficient comparison-based sorting / divide and conquer

O(n²)
Two nested loops over n

O(n³)
Three nested loops over n

O(2ⁿ)
Exponential recursive branching

O(n!)
Generating permutations / factorial growth
```

---

# 47. DSA Complexity Progression

As we progress through DSA, complexity analysis will become more important:

```text
Arrays
    ↓
O(1), O(n), O(n²)

Binary Search
    ↓
O(log n)

Sorting
    ↓
O(n log n)

Hashing
    ↓
O(1) average operations

Trees
    ↓
O(log n), O(n)

Heap
    ↓
O(log n)

Graphs
    ↓
O(V + E)

Dynamic Programming
    ↓
State-dependent complexity
```

The goal is not to memorize these numbers.

The goal is to understand **why** an algorithm has its complexity.

---

# Final Rule

For every DSA problem you solve, finish with:

```text
Approach:
...

Time Complexity:
O(...)

Space Complexity:
O(...)

Why:
...
```

If you can explain the **why**, you understand the algorithm.

If you can only remember the `O(...)`, you have memorized a label.
