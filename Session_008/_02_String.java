package Session_008;

import java.util.Arrays;

/**
 * A comprehensive demonstration of Strings in Java.
 * Covers: creation, immutability, String Pool, common methods,
 * comparison, concatenation, StringBuilder, conversions, and pitfalls.
 */
public class _02_String {

    public static void main(String[] args) {
        System.out.println("===== STRING DEMONSTRATION =====");

        // Uncomment each method to run its demo
        demoCreation();
        demoImmutabilityAndPool();
        demoCommonMethods();
        demoComparison();
        demoConcatenationAndPerformance();
        demoStringBuilderAndBuffer();
        demoConversions();
        demoCommonMistakes();
        demoAdvancedMethods();
    }

    // ==================================================================
    // 1. CREATING STRINGS
    // ==================================================================
    static void demoCreation() {
        System.out.println("\n--- Creating Strings ---");

        // a) Using string literal (goes to String Pool)
        String s1 = "Hello";
        String s2 = "World";

        // b) Using 'new' keyword (creates a new object in heap)
        String s3 = new String("Hello");

        // c) From character array
        char[] chars = {'J', 'a', 'v', 'a'};
        String s4 = new String(chars);

        // d) From byte array
        byte[] bytes = {72, 101, 108, 108, 111}; // ASCII codes
        String s5 = new String(bytes);

        // e) Using String.valueOf() (for primitives and objects)
        String s6 = String.valueOf(123);
        String s7 = String.valueOf(45.67);
        String s8 = String.valueOf(true);

        // f) Using String.format() (formatted strings)
        String s9 = String.format("My name is %s and I am %d years old.", "Alice", 25);

        System.out.println("s1 = " + s1);
        System.out.println("s3 = " + s3);
        System.out.println("s4 = " + s4);
        System.out.println("s5 = " + s5);
        System.out.println("s6 = " + s6);
        System.out.println("s7 = " + s7);
        System.out.println("s8 = " + s8);
        System.out.println("s9 = " + s9);
    }

    // ==================================================================
    // 2. IMMUTABILITY AND STRING POOL
    // ==================================================================
    static void demoImmutabilityAndPool() {
        System.out.println("\n--- Immutability & String Pool ---");

        // String Pool demonstration
        String a = "Hello";
        String b = "Hello";
        // Both a and b refer to the same object in the pool
        System.out.println("a == b ? " + (a == b)); // true

        // Using 'new' creates a separate object
        String c = new String("Hello");
        System.out.println("a == c ? " + (a == c)); // false (different objects)

        // .intern() returns the pool reference
        String d = c.intern();
        System.out.println("a == d ? " + (a == d)); // true (now d points to pool)

        // Immutability: any modification creates a new String
        String original = "Java";
        String modified = original.concat(" Programming");
        System.out.println("original = " + original);   // unchanged
        System.out.println("modified = " + modified);   // new string

        // Even a simple concatenation creates a new string
        String s = "Hello";
        s = s + " World"; // new String "Hello World" assigned; old "Hello" becomes eligible for GC
        System.out.println("After s = s + \" World\": " + s);
    }

    // ==================================================================
    // 3. COMMON STRING METHODS
    // ==================================================================
    static void demoCommonMethods() {
        System.out.println("\n--- Common String Methods ---");

        String str = "  Hello, Java World!  ";

        // Length
        System.out.println("length() = " + str.length());

        // Character access
        System.out.println("charAt(0) = " + str.charAt(0));      // space
        System.out.println("charAt(7) = " + str.charAt(7));      // 'J'

        // Substring (start inclusive, end exclusive)
        System.out.println("substring(7, 11) = " + str.substring(7, 11)); // "Java"

        // Index of
        System.out.println("indexOf('J') = " + str.indexOf('J')); // 7
        System.out.println("indexOf(\"Java\") = " + str.indexOf("Java")); // 7
        System.out.println("lastIndexOf('o') = " + str.lastIndexOf('o')); // 14 (in "World")

        // Case conversion
        System.out.println("toUpperCase() = " + str.toUpperCase());
        System.out.println("toLowerCase() = " + str.toLowerCase());

        // Trim (removes leading/trailing whitespace)
        System.out.println("trim() = \"" + str.trim() + "\"");

        // Replace
        System.out.println("replace('o', '0') = " + str.replace('o', '0'));

        // Contains
        System.out.println("contains(\"Java\") = " + str.contains("Java"));
        System.out.println("startsWith(\"  He\") = " + str.startsWith("  He"));
        System.out.println("endsWith(\"!  \") = " + str.endsWith("!  "));

        // Split
        String csv = "apple,banana,grape";
        String[] fruits = csv.split(",");
        System.out.println("split(\",\") = " + Arrays.toString(fruits));

        // Join (static)
        String joined = String.join("-", "2026", "06", "19");
        System.out.println("join(\"-\", ...) = " + joined);

        // isEmpty vs isBlank (Java 11+)
        String empty = "";
        String blank = "   ";
        System.out.println("isEmpty on \"\" : " + empty.isEmpty());    // true
        System.out.println("isBlank on \"   \" : " + blank.isBlank()); // true (Java 11)
    }

    // ==================================================================
    // 4. STRING COMPARISON
    // ==================================================================
    static void demoComparison() {
        System.out.println("\n--- String Comparison ---");

        String s1 = "Java";
        String s2 = "Java";
        String s3 = new String("Java");
        String s4 = "java";

        // == compares references
        System.out.println("s1 == s2 : " + (s1 == s2)); // true (same pool)
        System.out.println("s1 == s3 : " + (s1 == s3)); // false (different objects)
        System.out.println("s1 == s4 : " + (s1 == s4)); // false (different content and references)

        // .equals() compares content (case-sensitive)
        System.out.println("s1.equals(s2) : " + s1.equals(s2)); // true
        System.out.println("s1.equals(s3) : " + s1.equals(s3)); // true
        System.out.println("s1.equals(s4) : " + s1.equals(s4)); // false

        // .equalsIgnoreCase()
        System.out.println("s1.equalsIgnoreCase(s4) : " + s1.equalsIgnoreCase(s4)); // true

        // .compareTo() – lexicographic comparison
        System.out.println("s1.compareTo(s4) : " + s1.compareTo(s4)); // positive ( 'J' > 'j' )
        System.out.println("s4.compareTo(s1) : " + s4.compareTo(s1)); // negative
        System.out.println("s1.compareTo(s2) : " + s1.compareTo(s2)); // 0
    }

    // ==================================================================
    // 5. CONCATENATION AND PERFORMANCE
    // ==================================================================
    static void demoConcatenationAndPerformance() {
        System.out.println("\n--- Concatenation & Performance ---");

        // Using '+' operator – compiler often uses StringBuilder
        String hello = "Hello";
        String world = "World";
        String result = hello + " " + world + "!";
        System.out.println("result = " + result);

        // In loops, '+' creates many intermediate objects – not efficient
        System.out.println("Building string with '+' in loop (slow):");
        long start = System.nanoTime();
        String slow = "";
        for (int i = 0; i < 1000; i++) {
            slow += i; // creates a new String each iteration
        }
        long end = System.nanoTime();
        System.out.println("Time taken (approx): " + (end - start) / 1000000 + " ms");

        // Better: use StringBuilder (mutable, not thread-safe)
        System.out.println("Building with StringBuilder (fast):");
        start = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 1000; i++) {
            sb.append(i);
        }
        String fast = sb.toString();
        end = System.nanoTime();
        System.out.println("Time taken (approx): " + (end - start) / 1000000 + " ms");

        // StringBuffer is thread-safe (synchronized) but slower
        StringBuffer buffer = new StringBuffer();
        buffer.append("Hello");
        buffer.append(" ");
        buffer.append("World");
        System.out.println("StringBuffer result: " + buffer.toString());
    }

    // ==================================================================
    // 6. STRINGBUILDER AND STRINGBUFFER (MUTABLE)
    // ==================================================================
    static void demoStringBuilderAndBuffer() {
        System.out.println("\n--- StringBuilder & StringBuffer ---");

        // StringBuilder – mutable, not thread-safe (preferred)
        StringBuilder sb = new StringBuilder("Hello");
        sb.append(" World");
        sb.insert(5, ",");
        sb.replace(6, 11, "Java");
        sb.delete(11, 12); // remove the last exclamation if any
        sb.reverse();
        System.out.println("After various operations: " + sb.toString());

        // Capacity
        StringBuilder sb2 = new StringBuilder();
        System.out.println("Default capacity = " + sb2.capacity()); // 16
        sb2.ensureCapacity(50);
        System.out.println("After ensureCapacity(50): " + sb2.capacity());

        // StringBuffer – similar but synchronized
        StringBuffer sbf = new StringBuffer("Hello");
        sbf.append(" World");
        System.out.println("StringBuffer: " + sbf);
    }

    // ==================================================================
    // 7. CONVERSIONS: String ↔ other types
    // ==================================================================
    static void demoConversions() {
        System.out.println("\n--- Conversions ---");

        // Primitive to String
        String intStr = String.valueOf(123);
        String doubleStr = String.valueOf(45.67);
        String boolStr = String.valueOf(true);
        System.out.println("intStr = " + intStr);
        System.out.println("doubleStr = " + doubleStr);
        System.out.println("boolStr = " + boolStr);

        // Using wrapper classes
        String intStr2 = Integer.toString(456);
        String doubleStr2 = Double.toString(3.14);

        // String to primitive
        int i = Integer.parseInt("789");
        double d = Double.parseDouble("3.14159");
        boolean b = Boolean.parseBoolean("true");
        System.out.println("i = " + i + ", d = " + d + ", b = " + b);

        // String to char array
        String str = "Java";
        char[] chars = str.toCharArray();
        System.out.println("char array: " + Arrays.toString(chars));

        // Char array to String
        String fromChars = new String(chars);
        System.out.println("from char array: " + fromChars);

        // String to byte array (getBytes)
        byte[] bytes = str.getBytes();
        System.out.println("byte array: " + Arrays.toString(bytes));

        // byte array to String
        String fromBytes = new String(bytes);
        System.out.println("from byte array: " + fromBytes);
    }

    // ==================================================================
    // 8. COMMON BEGINNER MISTAKES (with explanations)
    // ==================================================================
    static void demoCommonMistakes() {
        System.out.println("\n--- Common Mistakes (and fixes) ---");

        // Mistake 1: Using == to compare string content
        String a = "Hello";
        String b = new String("Hello");
        System.out.println("a == b : " + (a == b)); // false – wrong for content
        System.out.println("  Fix: use a.equals(b) -> " + a.equals(b));

        // Mistake 2: Forgetting that strings are immutable
        String s = "Java";
        s.concat(" is fun"); // result is ignored
        System.out.println("After s.concat(...) (ignored): " + s); // still "Java"
        System.out.println("  Fix: assign result -> s = s.concat(\" is fun\")");

        // Mistake 3: Modifying a String in a loop with '+'
        // (performance issue) – already shown in concat demo

        // Mistake 4: NullPointerException when calling methods on null
        try {
            String nullStr = null;
            nullStr.length(); // throws NPE
        } catch (NullPointerException e) {
            System.out.println("NullPointerException caught: " + e);
            System.out.println("  Fix: always check for null before calling methods.");
        }

        // Mistake 5: Confusing length (array) with length() (String)
        int[] arr = {1,2,3};
        String str = "Hello";
        // arr.length (field) vs str.length() (method)
        System.out.println("arr.length = " + arr.length);
        System.out.println("str.length() = " + str.length());

        // Mistake 6: substring index out of bounds
        try {
            str.substring(1, 10); // end > length
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("substring out of bounds: " + e);
            System.out.println("  Fix: ensure indices are within 0..length()");
        }

        // Mistake 7: Forgetting that split uses regex (special characters need escaping)
        String text = "a.b.c";
        String[] parts = text.split("\\."); // need to escape '.' because regex
        System.out.println("split on '.' escaped: " + Arrays.toString(parts));
        // Unescaped would not work as expected: text.split(".") splits on every char.
    }

    // ==================================================================
    // 9. ADVANCED / LESS COMMON METHODS
    // ==================================================================
    static void demoAdvancedMethods() {
        System.out.println("\n--- Advanced Methods ---");

        String str = "   Hello World   ";

        // repeat (Java 11)
        System.out.println("repeat(3): " + str.repeat(3));

        // lines (Java 11) – splits by line terminators
        String multiline = "Line1\nLine2\nLine3";
        multiline.lines().forEach(System.out::println);

        // strip, stripLeading, stripTrailing (Java 11) – Unicode‑aware whitespace
        System.out.println("strip(): \"" + str.strip() + "\"");
        System.out.println("stripLeading(): \"" + str.stripLeading() + "\"");
        System.out.println("stripTrailing(): \"" + str.stripTrailing() + "\"");

        // indent (Java 12) – adds/removes indentation
        String indented = "Hello".indent(4);
        System.out.println("indent(4):\n" + indented);

        // transform (Java 12) – apply a function to the string
        String transformed = str.transform(s -> s.trim().toUpperCase());
        System.out.println("transform(trim+upper): " + transformed);

        // formatted (Java 15) – similar to String.format
        String name = "John";
        int age = 30;
        String formatted = "My name is %s and I'm %d".formatted(name, age);
        System.out.println("formatted: " + formatted);

        // matches (regex)
        System.out.println("\"123\".matches(\"\\\\d+\") = " + "123".matches("\\d+"));
        System.out.println("\"abc\".matches(\"\\\\d+\") = " + "abc".matches("\\d+"));
    }
}