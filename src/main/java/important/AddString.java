package important;

import org.junit.jupiter.api.Test;

public class AddString {
    @Test
    public void testAddString() {
        String num1 = "584";
        String num2 = "18";
        System.out.println(addStrings(num1, num2));
    }

    public String addStrings(String num1, String num2) {
        if (num1.length() <= 0 && num2.length() <= 0) {
            return "0";
        }

        if (num1.length() == 1 && num2.length() == 1 && num1.charAt(0) == '0' && num2.charAt(0) == '0') {
            return "0";
        }
        int n = num1.length();
        int m = num2.length();
        int length = Math.max(n, m) + 1;
        int[] result = new int[length];
        for (int i = length - 1; i >= 1; i--) {
            int i1 = i - (length - n);
            int i2 = i - (length - m);
            int lastNum1 = i1 >= 0 ? num1.charAt(i1) - '0' : 0;
            int lastNum2 = i2 >= 0 ? num2.charAt(i2) - '0' : 0;
            int sum = result[i] + lastNum1 + lastNum2;
            result[i] = sum % 10;
            result[i - 1] = result[i - 1] + sum / 10;
        }
        StringBuilder strbu = new StringBuilder();
        for (int i = 0; i < result.length; i++) {
            if (result[i] > 0 || i > 0) {
                strbu.append(result[i]);
            }
        }

        return strbu.toString();
    }
}
