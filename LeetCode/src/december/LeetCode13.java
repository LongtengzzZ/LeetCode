package december;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 对比上一位和当前为的关系，小于则为减，大于等于则为加
 */
public class LeetCode13 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String s = stringToString(line);
            int ret = new Solution13().romanToInt(s);
            String out = String.valueOf(ret);
            System.out.println(out);
        }
    }

    private static String stringToString(String input) {
        if (input == null) {
            return "null";
        }
        return input;
    }
}

class Solution13 {
    public int romanToInt(String s) {
        int len = s.length();
        // 上一个字符表示的值
        int preNum = getValue(s.charAt(0));
        // 总数
        int sum = preNum;
        for (int i = 1; i < len; i++) {
            char c = s.charAt(i);
            // 当前字符表示的值
            int num = getValue(c);
            // 判断是加还是减
            if (preNum < num) { // 上一位小于本位——减
                sum += num;
                sum -= 2 * preNum; // 因为之前加了，所以要减2次
            } else { // 上一位大于或等于当前位——加
                sum += num;
            }
            preNum = num;
        }
        return sum;
    }

    /**
     * 传入字符，返回值
     * @param c
     * @return
     */
    private int getValue(char c) {
        switch (c) {
            case 'M':return 1000;
            case 'D':return 500;
            case 'C':return 100;
            case 'L':return 50;
            case 'X':return 10;
            case 'V':return 5;
            case 'I':return 1;
            default:return 0;
        }
    }
}
