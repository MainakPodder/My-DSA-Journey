package Strings.easy;

public class LongestCommonPrefix {
    public static String getLongestCommonPrefix(String[] str) {
        int lowWordLength = Integer.MAX_VALUE;
        String result = "";
        for (int i = 0; i < str.length; i++) {
            String val = str[i];
            if (val.length() < lowWordLength) {
                lowWordLength = val.length();
            }
        }
        for (int i = 0; i < str.length; i++) {
            for (int j = 0; j < str.length; j++) {
                
            }
        }
        System.out.println(lowWordLength);
        // for(char c : val.toCharArray()){
        // if (condition) {

        // }
        // }
        return result;
    }

    public static void main(String[] args) {
        String[] str = { "flower", "flow", "flight" };
        String result = getLongestCommonPrefix(str);
    }
}
