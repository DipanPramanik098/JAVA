public class _01_variable_And_Datatype {
    public static void main(String[] args) {
        // Integers
        byte b = 10;
        short s = 255;
        int i = 10000;
        long l = 776767575665l;

        System.out.println(b);
        System.out.println(s);
        System.out.println(i);
        System.out.println(l);

        // Real Numbers
        float f = 10.77f;
        double d = 1.9897689; // standard way
        // scientific way --
        double dd = 6.023e23;

        System.out.println(f);
        System.out.println(d);
        System.out.println(dd);

        // Character
        char ch = 'a';
        System.out.println(ch);

        // Boolean
        boolean bb = true;
        System.out.println(bb);

        // binary(2), Octal(8), Hexadecimal (16)

        // binary--
        byte _b = 0b101; //5 print in decimal
        System.out.println(_b);

        // octal -- 
        byte o = 05;
        System.out.println(o);

        //Hexadecimal
        byte h = 0x5;
        System.out.println(h);
    }
}
