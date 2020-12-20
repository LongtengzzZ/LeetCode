package december;

public class LeetCode860 {
    public static void main(String[] args) {
        int[] a = {5,5,10,10,5,20,5,10,5,5};
        System.out.println(Solution860.lemonadeChange(a));
    }
}

class Solution860 {
    public static boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;
        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                five ++;
            }else if (bills[i] == 10) {
                if (five <= 0) {
                    return false;
                }
                five --;
                ten ++;
            }else if (bills[i] == 20) {
                if (five >= 1 && ten >= 1) {
                    five --;
                    ten --;
                }else if (five >= 3) {
                    five -= 3;
                }else {
                    return false;
                }
            }
        }
        return true;
    }
}