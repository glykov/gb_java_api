import java.util.*;

public class IntegerToRoman {
    public static int convert(String romeNum) {
        Map<Character, Integer> decToRoman = new HashMap<>();
        decToRoman.put('M', 1000);
        decToRoman.put('D', 500);
        decToRoman.put('C', 100);
        decToRoman.put('L', 50);
        decToRoman.put('X', 10);
        decToRoman.put('V', 5);
        decToRoman.put('I', 1);

        int result = 0;
        int previous = Integer.MAX_VALUE;
        int current;
        for (int i = 0; i < romeNum.length(); i++) {
            current = decToRoman.get(romeNum.charAt(i));
            if (previous >= current) {
                result += current;
            } else {
                result += current - previous;
                result -= previous;
            }
            previous = current;
        }

        return result;
    }

    public static String convert(int num) {
        TreeMap<Integer, String> decToRoman = new TreeMap<>();
        decToRoman.put(1000, "M");
        decToRoman.put(900, "CM");
        decToRoman.put(500, "D");
        decToRoman.put(400, "CD");
        decToRoman.put(100, "C");
        decToRoman.put(90, "XC");
        decToRoman.put(50, "L");
        decToRoman.put(40, "XL");
        decToRoman.put(10, "X");
        decToRoman.put(9, "IX");
        decToRoman.put(5, "V");
        decToRoman.put(4, "IV");
        decToRoman.put(1, "I");

        StringBuilder r = new StringBuilder();
        for (var key : decToRoman.descendingKeySet()) {
            while(num >= key){
                r.append(decToRoman.get(key));
                num -= key;
            }
        }

        return r.toString();
    }

    public static void main(String[] args) {
        String r1 = "MMXXII";
        String r2 = "DCCLXXV";
        String r3 = "CMLXXXVII";
        System.out.println(r1 + " = " + convert(r1));
        System.out.println(r2 + " = " + convert(r2));
        System.out.println(r3 + " = " + convert(r3));

        int i1 = 2022;
        int i2 = 775;
        int i3 = 987;
        System.out.println(i1 + " = " + convert(i1));
        System.out.println(i2 + " = " + convert(i2));
        System.out.println(i3 + " = " + convert(i3));
    }
}

