package Session_008;

import java.util.Arrays;   // for Arrays.toString(), sort(), etc.

/**
 * A comprehensive demonstration of Arrays in Java.
 * Covers: declaration, initialization, default values, traversal,
 * length, multi-dimensional arrays, jagged arrays, common mistakes,
 * and utility methods.
 */
public class _01_Array {

    public static void main(String[] args) {
        System.out.println("===== ARRAY DEMONSTRATION =====");

        // Call each demo method (uncomment to run)
        demoDeclarationAndInitialization();
        demoDefaultValues();
        demoDifferentWaysToCreate();
        demoTraversing();
        demoLengthProperty();
        demoMultidimensionalAndJagged();
        demoCommonMistakes();   // shows errors and how to fix them
        demoUtilityMethods();
    }

    // ==================================================================
    // 1. DECLARATION AND INITIALIZATION
    // ==================================================================
    static void demoDeclarationAndInitialization() {
        System.out.println("\n--- Declaration & Initialization ---");

        // Declaration (no memory allocated)
        int[] ages;          // preferred style
        String[] names;      // array of String references

        // Initialization with 'new' and size
        ages = new int[5];             // 5 integers, default 0
        names = new String[3];         // 3 String references, default null

        // Assign values
        ages[0] = 25;
        ages[1] = 30;
        names[0] = "Alice";
        names[1] = "Bob";

        // Combined declaration + initialization using initializer list
        int[] scores = {85, 90, 78, 92, 88};   // size = 5
        String[] weekdays = {"Mon", "Tue", "Wed", "Thu", "Fri"};

        System.out.println("ages[0] = " + ages[0]);
        System.out.println("names[1] = " + names[1]);
        System.out.println("scores length = " + scores.length);
        System.out.println("weekdays[2] = " + weekdays[2]);
    }

    // ==================================================================
    // 2. DEFAULT VALUES IN ARRAYS
    // ==================================================================
    static void demoDefaultValues() {
        System.out.println("\n--- Default Values ---");

        int[] intArr = new int[3];
        double[] dblArr = new double[2];
        boolean[] boolArr = new boolean[4];
        String[] strArr = new String[5];

        System.out.println("int default: " + intArr[0]);     // 0
        System.out.println("double default: " + dblArr[0]);  // 0.0
        System.out.println("boolean default: " + boolArr[0]);// false
        System.out.println("String default: " + strArr[0]);  // null (reference)
    }

    // ==================================================================
    // 3. DIFFERENT WAYS TO CREATE ARRAYS
    // ==================================================================
    static void demoDifferentWaysToCreate() {
        System.out.println("\n--- Different Creation Ways ---");

        // 1) With 'new' and size
        int[] nums = new int[3];          // [0,0,0]
        nums[0] = 10;
        nums[1] = 20;
        nums[2] = 30;

        // 2) With initializer list (size inferred)
        int[] fibonacci = {0, 1, 1, 2, 3, 5, 8};
        System.out.println("fibonacci length = " + fibonacci.length);

        // 3) Anonymous array (passed directly to a method)
        printArray(new int[]{100, 200, 300});   // no variable needed

        // 4) Using Arrays.fill() to set all elements
        int[] filled = new int[4];
        Arrays.fill(filled, 7);                 // all elements become 7
        System.out.println("filled: " + Arrays.toString(filled));

        // 5) Copying an array (using Arrays.copyOf)
        int[] copied = Arrays.copyOf(fibonacci, 10); // length 10, extra zeros
        System.out.println("copied: " + Arrays.toString(copied));
    }

    // Helper method to print an array
    static void printArray(int[] arr) {
        System.out.print("Anonymous array: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    // ==================================================================
    // 4. TRAVERSING ARRAYS USING LOOPS
    // ==================================================================
    static void demoTraversing() {
        System.out.println("\n--- Traversing Arrays ---");

        int[] scores = {95, 82, 67, 90, 78};

        // a) Classic for loop (with index)
        System.out.print("Classic for: ");
        for (int i = 0; i < scores.length; i++) {
            System.out.print(scores[i] + " ");
        }
        System.out.println();

        // b) Enhanced for‑each (read‑only, no index)
        System.out.print("Enhanced for: ");
        for (int score : scores) {
            System.out.print(score + " ");
        }
        System.out.println();

        // c) While loop
        System.out.print("While loop: ");
        int i = 0;
        while (i < scores.length) {
            System.out.print(scores[i++] + " ");
        }
        System.out.println();

        // d) Using Java 8 Streams (for fun)
        System.out.print("Streams: ");
        Arrays.stream(scores).forEach(s -> System.out.print(s + " "));
        System.out.println();

        // e) Modifying elements during traversal (use index loop)
        for (int j = 0; j < scores.length; j++) {
            scores[j] += 5;   // add bonus points
        }
        System.out.println("After bonus: " + Arrays.toString(scores));
    }

    // ==================================================================
    // 5. ARRAY LENGTH PROPERTY
    // ==================================================================
    static void demoLengthProperty() {
        System.out.println("\n--- Length Property ---");

        int[] arr = {10, 20, 30, 40, 50};
        System.out.println("arr.length = " + arr.length);   // 5

        // For 2D arrays, length gives number of rows
        int[][] matrix = new int[4][6];
        System.out.println("matrix.length (rows) = " + matrix.length);       // 4
        System.out.println("matrix[0].length (cols) = " + matrix[0].length); // 6

        // Note: length is a FIELD (not a method) – no parentheses.
        // String has length() method – different!
    }

    // ==================================================================
    // 6. MULTI‑DIMENSIONAL AND JAGGED ARRAYS
    // ==================================================================
    static void demoMultidimensionalAndJagged() {
        System.out.println("\n--- Multi‑Dimensional & Jagged Arrays ---");

        // Rectangular 2D array: 3 rows, 4 columns
        int[][] matrix = new int[3][4];
        matrix[0][0] = 1;
        matrix[1][2] = 9;
        System.out.println("Rectangular matrix[1][2] = " + matrix[1][2]);

        // Jagged array: rows have different lengths
        int[][] jagged = new int[3][];          // only row count fixed
        jagged[0] = new int[2];                 // row0 length 2
        jagged[1] = new int[4];                 // row1 length 4
        jagged[2] = new int[3];                 // row2 length 3

        // Fill with some values
        jagged[0][0] = 5;
        jagged[0][1] = 6;
        jagged[1][0] = 7;
        jagged[1][1] = 8;
        jagged[1][2] = 9;
        jagged[1][3] = 10;
        jagged[2][0] = 11;
        jagged[2][1] = 12;
        jagged[2][2] = 13;

        // Traverse jagged array
        System.out.println("Jagged array contents:");
        for (int row = 0; row < jagged.length; row++) {
            for (int col = 0; col < jagged[row].length; col++) {
                System.out.print(jagged[row][col] + " ");
            }
            System.out.println();
        }

        // Using enhanced for for rows and columns
        System.out.print("Enhanced for jagged: ");
        for (int[] row : jagged) {
            for (int val : row) {
                System.out.print(val + " ");
            }
        }
        System.out.println();
    }

    // ==================================================================
    // 7. COMMON BEGINNER MISTAKES (with explanations)
    // ==================================================================
    static void demoCommonMistakes() {
        System.out.println("\n--- Common Mistakes (and fixes) ---");

        // Mistake 1: Index out of bounds
        try {
            int[] arr = new int[3];
            arr[3] = 10;   // ERROR: valid indices 0,1,2
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Mistake 1 (index out of bounds): " + e);
            System.out.println("  Fix: Remember last index = length-1");
        }

        // Mistake 2: Using length() instead of length (field)
        // int len = arr.length(); // Compile error – uncomment to see
        System.out.println("Mistake 2: arrays use 'length' (field), not 'length()'.");

        // Mistake 3: Comparing arrays with == (checks references, not content)
        int[] a = {1, 2, 3};
        int[] b = {1, 2, 3};
        System.out.println("a == b ? " + (a == b));   // false
        System.out.println("Arrays.equals(a, b) ? " + Arrays.equals(a, b)); // true
        System.out.println("  Fix: use Arrays.equals() for content comparison.");

        // Mistake 4: For‑each loop cannot modify array elements
        int[] nums = {1, 2, 3};
        for (int num : nums) {
            num = num * 2;   // modifies local copy, not array
        }
        System.out.println("After for‑each modification (no effect): " + Arrays.toString(nums));
        System.out.println("  Fix: use index‑based loop to modify.");

        // Mistake 5: NullPointerException with object arrays
        try {
            String[] names = new String[5];
            names[0].toUpperCase(); // names[0] is null
        } catch (NullPointerException e) {
            System.out.println("Mistake 5 (null element): " + e);
            System.out.println("  Fix: initialize each element before using.");
        }

        // Mistake 6: Forgetting that array size is fixed
        int[] fixed = new int[2];
        // fixed = new int[3]; // This is reassigning, not resizing – it's okay but creates new array
        // To "resize", you need to create a new array and copy.
        int[] bigger = Arrays.copyOf(fixed, 5);
        System.out.println("Resized array length: " + bigger.length);
        System.out.println("  Reminder: arrays are fixed length; use ArrayList for dynamic size.");
    }

    // ==================================================================
    // 8. UTILITY METHODS FROM java.util.Arrays
    // ==================================================================
    static void demoUtilityMethods() {
        System.out.println("\n--- Arrays Utility Methods ---");

        int[] arr = {5, 2, 8, 1, 9, 3};

        // toString() – print array nicely
        System.out.println("Original: " + Arrays.toString(arr));

        // sort() – ascending order
        Arrays.sort(arr);
        System.out.println("Sorted:   " + Arrays.toString(arr));

        // binarySearch() – works on sorted array
        int index = Arrays.binarySearch(arr, 8);
        System.out.println("Index of 8: " + index);

        // fill() – set all elements to a value
        int[] fillArr = new int[4];
        Arrays.fill(fillArr, 42);
        System.out.println("Filled with 42: " + Arrays.toString(fillArr));

        // copyOf() – copy first N elements
        int[] copy = Arrays.copyOf(arr, 4);
        System.out.println("Copy first 4: " + Arrays.toString(copy));

        // copyOfRange() – copy a range
        int[] range = Arrays.copyOfRange(arr, 2, 5); // indices 2,3,4 (5 exclusive)
        System.out.println("Copy range [2,5): " + Arrays.toString(range));

        // equals() – compare contents
        int[] another = {1, 2, 3, 5, 8, 9};
        System.out.println("arr equals another? " + Arrays.equals(arr, another));

        // deepEquals() for multidimensional arrays
        int[][] m1 = {{1,2}, {3,4}};
        int[][] m2 = {{1,2}, {3,4}};
        System.out.println("m1 deepEquals m2? " + Arrays.deepEquals(m1, m2));
        System.out.println("m1 equals m2? " + Arrays.equals(m1, m2)); // false (compares references)
    }
}