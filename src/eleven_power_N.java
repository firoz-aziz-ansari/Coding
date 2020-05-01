/*
* Count the number of 1's in pow(11,N). N = {0, ...., 1000}
* */

public class eleven_power_N {

    static String additionWithCarry(String a, String b) {

        String result = "";
        int carry = 0;
        int add = 0;

        for (int i = b.length() - 1; i >= 0; i--) {
            add = Integer.parseInt(a.charAt(i + 1) + "") + Integer.parseInt(b.charAt(i) + "") + carry;
            carry = 0;
            if (add > 9) {
                String addString = String.valueOf(add);
                carry = Integer.parseInt(addString.charAt(0) + "");
                add = Integer.parseInt(addString.charAt(1) + "");
            }

            result = add + result;
        }

        result = (Integer.parseInt(a.charAt(0) + "") + carry) + result;

        return result;
    }

    static String elevenToThePower(int N) {
        if (N == 0) return "1";
        if (N == 1) return "11";

        String prev = elevenToThePower(N - 1);
        return additionWithCarry(prev + "0", prev);
    }

    public static void main(String args[]) {
        int N = 10000;

        String numString = elevenToThePower(N);
        int oneCount = 0;
        for (int i = 0; i < numString.length(); i++)
            if (numString.charAt(i) == '1')
                oneCount++;
        System.out.println(oneCount);
    }
}
