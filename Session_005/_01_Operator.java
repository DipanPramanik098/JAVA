public class _01_Operator {

    public static void main(String[] args) {

        // =====================================================
        // 1. ARITHMETIC OPERATORS
        // Used for mathematical calculations
        // =====================================================

        int a = 10;
        int b = 3;

        System.out.println("===== Arithmetic Operators =====");

        System.out.println("Addition (+): " + (a + b));       // 13
        System.out.println("Subtraction (-): " + (a - b));    // 7
        System.out.println("Multiplication (*): " + (a * b)); // 30
        System.out.println("Division (/): " + (a / b));       // 3
        System.out.println("Modulus (%): " + (a % b));        // 1 (remainder)

        // =====================================================
        // 2. UNARY OPERATORS
        // Work on a single operand
        // =====================================================

        System.out.println("\n===== Unary Operators =====");

        int x = 5;

        System.out.println("Original x = " + x);

        // Increment
        x++; // x = x + 1
        System.out.println("After x++ = " + x);

        // Decrement
        x--; // x = x - 1
        System.out.println("After x-- = " + x);

        // Unary Plus
        int positive = +10;
        System.out.println("Unary Plus = " + positive);

        // Unary Minus
        int negative = -10;
        System.out.println("Unary Minus = " + negative);

        // Logical NOT
        boolean flag = true;
        System.out.println("!flag = " + (!flag));

        // =====================================================
        // 3. ASSIGNMENT OPERATORS
        // Used to assign values
        // =====================================================

        System.out.println("\n===== Assignment Operators =====");

        int num = 10;

        num += 5; // num = num + 5
        System.out.println("num += 5 : " + num);

        num -= 3; // num = num - 3
        System.out.println("num -= 3 : " + num);

        num *= 2; // num = num * 2
        System.out.println("num *= 2 : " + num);

        num /= 4; // num = num / 4
        System.out.println("num /= 4 : " + num);

        num %= 2; // num = num % 2
        System.out.println("num %= 2 : " + num);

        // =====================================================
        // 4. RELATIONAL (COMPARISON) OPERATORS
        // Compare two values
        // Result is always true or false
        // =====================================================

        System.out.println("\n===== Relational Operators =====");

        int p = 20;
        int q = 10;

        System.out.println("p == q : " + (p == q));
        System.out.println("p != q : " + (p != q));
        System.out.println("p > q  : " + (p > q));
        System.out.println("p < q  : " + (p < q));
        System.out.println("p >= q : " + (p >= q));
        System.out.println("p <= q : " + (p <= q));

        // =====================================================
        // 5. LOGICAL OPERATORS
        // Used with boolean values
        // =====================================================

        System.out.println("\n===== Logical Operators =====");

        boolean c1 = true;
        boolean c2 = false;

        System.out.println("c1 && c2 : " + (c1 && c2)); // AND
        System.out.println("c1 || c2 : " + (c1 || c2)); // OR
        System.out.println("!c1      : " + (!c1));      // NOT

        // =====================================================
        // 6. BITWISE OPERATORS
        // Operate on binary bits
        // =====================================================

        System.out.println("\n===== Bitwise Operators =====");

        int m = 5;  // Binary: 0101
        int n = 3;  // Binary: 0011

        System.out.println("m & n = " + (m & n)); // AND -> 1
        System.out.println("m | n = " + (m | n)); // OR  -> 7
        System.out.println("m ^ n = " + (m ^ n)); // XOR -> 6
        System.out.println("~m    = " + (~m));    // Complement

        // =====================================================
        // 7. SHIFT OPERATORS
        // Shift bits left or right
        // =====================================================

        System.out.println("\n===== Shift Operators =====");

        int s = 8; // Binary: 1000

        System.out.println("s << 1 = " + (s << 1)); // 16
        System.out.println("s << 2 = " + (s << 2)); // 32

        System.out.println("s >> 1 = " + (s >> 1)); // 4
        System.out.println("s >> 2 = " + (s >> 2)); // 2

        // Unsigned Right Shift
        System.out.println("s >>> 1 = " + (s >>> 1));

        // =====================================================
        // 8. TERNARY OPERATOR
        // Short form of if-else
        // condition ? value1 : value2
        // =====================================================

        System.out.println("\n===== Ternary Operator =====");

        int age = 20;

        String result = (age >= 18)
                ? "Eligible to Vote"
                : "Not Eligible";

        System.out.println(result);

        // =====================================================
        // 9. INSTANCEOF OPERATOR
        // Checks object type
        // =====================================================

        System.out.println("\n===== Instanceof Operator =====");

        String name = "Dipan";

        System.out.println(name instanceof String);

        // =====================================================
        // 10. PRE-INCREMENT VS POST-INCREMENT
        // Very Important for Interviews
        // =====================================================

        System.out.println("\n===== Increment Examples =====");

        int i = 10;

        // First use value, then increment
        System.out.println("i++ = " + (i++));
        System.out.println("After i++ = " + i);

        int j = 10;

        // First increment, then use value
        System.out.println("++j = " + (++j));
        System.out.println("After ++j = " + j);
    }
}