package Strings.easy;

public class LargestOddNumberInAString {
    public static String getLargestOddNumberInAString(String str) {
        int len = str.length();
        if (len == 0) return "";

        int fIdx = -1;
        int lIdx = -1;

        for (int i = len - 1; i >= 0; i--) {
            int num = str.charAt(i) - '0';
            if (num % 2 != 0) {
                lIdx = i;
                break;
            }
        }
System.out.println("mainak");
if (lIdx == -1) return ""; 
        for (int i = 0; i <= lIdx; i++) {
            int num = str.charAt(i) - '0';
            if (num != 0) {
                fIdx = i;
                break;
            }
        }
        System.out.println(fIdx);

        // If all digits before lIdx are zero → start from lIdx itself
        // if (fIdx == -1) fIdx = lIdx;
        return str.substring(fIdx, lIdx+1);
    }

    public static void main(String[] args) {
        String input = "00000";

        String result = getLargestOddNumberInAString(input);
        System.out.println("Largest odd number: " + result);
    }
}
