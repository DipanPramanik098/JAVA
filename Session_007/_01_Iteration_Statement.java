public class _01_Iteration_Statement {

    public static void main(String[] args) {

        // =====================================================
        // ITERATION STATEMENTS (LOOPS)
        // =====================================================

        /*
         * Iteration means repeating a block of code multiple times.
         *
         * Why loops exist?
         * Without loops:
         *
         * System.out.println("Hello");
         * System.out.println("Hello");
         * System.out.println("Hello");
         * System.out.println("Hello");
         * System.out.println("Hello");
         *
         * This creates duplicate code.
         *
         * With loops:
         *
         * for(int i = 1; i <= 5; i++) {
         * System.out.println("Hello");
         * }
         *
         * Same work with less code.
         */

        // =====================================================
        // 1. FOR LOOP
        // =====================================================

        /*
         * Syntax:
         *
         * for(initialization; condition; update)
         * {
         * body
         * }
         */

        System.out.println("FOR LOOP");

        for (int i = 1; i <= 5; i++) {

            System.out.println("Value = " + i);

        }

        /*
         * Execution Flow:
         *
         * Step 1: int i = 1
         * Step 2: i <= 5 ? TRUE
         * Step 3: execute body
         * Step 4: i++
         * Step 5: i <= 5 ? TRUE
         * Step 6: execute body
         *
         * Repeats...
         *
         * When i becomes 6:
         * i <= 5 ? FALSE
         * Loop terminates.
         */

        System.out.println();

        // =====================================================
        // 2. WHILE LOOP
        // =====================================================

        /*
         * Used when number of iterations
         * is not known beforehand.
         *
         * Syntax:
         *
         * while(condition)
         * {
         * body
         * }
         */

        System.out.println("WHILE LOOP");

        int x = 1;

        while (x <= 5) {

            System.out.println("x = " + x);

            x++;
        }

        /*
         * Flow:
         *
         * Check condition
         * TRUE -> execute body
         * Update variable
         * Again check condition
         *
         * FALSE -> exit loop
         */

        System.out.println();

        // =====================================================
        // 3. DO-WHILE LOOP
        // =====================================================

        /*
         * Difference:
         *
         * while:
         * Condition checked first
         *
         * do-while:
         * Body executes first
         * Condition checked later
         *
         * Therefore:
         * do-while executes at least once.
         */

        System.out.println("DO-WHILE LOOP");

        int y = 1;

        do {

            System.out.println("y = " + y);

            y++;

        } while (y <= 5);

        System.out.println();

        // =====================================================
        // WHILE vs DO-WHILE
        // =====================================================

        int a = 10;

        while (a < 5) {
            System.out.println("While Executed");
        }

        /*
         * Output:
         * Nothing
         *
         * Condition false initially.
         */

        int b = 10;

        do {
            System.out.println("Do While Executed Once");
        } while (b < 5);

        /*
         * Output:
         * Do While Executed Once
         */

        System.out.println();

        // =====================================================
        // INFINITE LOOP
        // =====================================================

        /*
         * Loop that never stops.
         *
         * Example:
         *
         * while(true){
         * System.out.println("Running");
         * }
         *
         * Condition is always true.
         */

        /*
         * Another Example:
         *
         * int i = 1;
         *
         * while(i <= 5){
         * System.out.println(i);
         * }
         *
         * Forgot i++
         *
         * Infinite loop occurs.
         */

        // =====================================================
        // NESTED LOOP
        // =====================================================

        /*
         * Loop inside another loop.
         */

        System.out.println("NESTED LOOP");

        for (int row = 1; row <= 3; row++) {

            for (int col = 1; col <= 3; col++) {

                System.out.print("* ");
            }

            System.out.println();
        }

        /*
         * Output:
         *
         * * * *
         * * * *
         * * * *
         */

        System.out.println();

        // =====================================================
        // JUMP STATEMENTS
        // =====================================================

        /*
         * Jump Statements:
         *
         * 1. break
         * 2. continue
         * 3. return
         */

        // =====================================================
        // BREAK STATEMENT
        // =====================================================

        /*
         * break immediately terminates
         * the nearest loop or switch.
         */

        System.out.println("BREAK");

        for (int i = 1; i <= 10; i++) {

            if (i == 5) {
                break;
            }

            System.out.println(i);
        }

        /*
         * Output:
         *
         * 1
         * 2
         * 3
         * 4
         *
         * Loop stops at 5.
         */

        System.out.println();

        // =====================================================
        // BREAK INTERNAL FLOW
        // =====================================================

        /*
         * i = 1
         * print 1
         *
         * i = 2
         * print 2
         *
         * i = 3
         * print 3
         *
         * i = 4
         * print 4
         *
         * i = 5
         * break executes
         *
         * JVM exits loop immediately.
         */

        // =====================================================
        // CONTINUE STATEMENT
        // =====================================================

        /*
         * continue skips current iteration
         * and moves to next iteration.
         */

        System.out.println("CONTINUE");

        for (int i = 1; i <= 5; i++) {

            if (i == 3) {
                continue;
            }

            System.out.println(i);
        }

        /*
         * Output:
         *
         * 1
         * 2
         * 4
         * 5
         */

        System.out.println();

        // =====================================================
        // CONTINUE FLOW
        // =====================================================

        /*
         * i = 1 -> print
         * i = 2 -> print
         * i = 3 -> continue
         * skip print
         * i = 4 -> print
         * i = 5 -> print
         */

        // =====================================================
        // REAL EXECUTION FLOW TRACING
        // =====================================================

        System.out.println("TRACE");

        for (int i = 1; i <= 3; i++) {

            System.out.println("Start Iteration " + i);

            if (i == 2) {
                continue;
            }

            System.out.println("End Iteration " + i);
        }

        /*
         * Iteration 1
         *
         * Start Iteration 1
         * End Iteration 1
         *
         *
         * Iteration 2
         *
         * Start Iteration 2
         * continue executes
         * End Iteration 2 skipped
         *
         *
         * Iteration 3
         *
         * Start Iteration 3
         * End Iteration 3
         */

        // =====================================================
        // RETURN STATEMENT
        // =====================================================

        /*
         * return exits the current method.
         *
         * Example:
         *
         * if(true){
         * return;
         * }
         *
         * Any code after return
         * inside the method will not execute.
         */

        outer: for (int i = 1; i <= 3; i++) {

            for (int j = 1; j <= 3; j++) {

                if (i == 2 && j == 2) {
                    break outer;
                }

                System.out.println(i + " " + j);
            }
        }
    }
}