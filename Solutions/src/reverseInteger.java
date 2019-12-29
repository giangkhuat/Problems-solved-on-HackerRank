class reverseInteger {
    public int reverse(int x) {
        /*
        123 
        digit = num / % 10 = 3
        num = num / 10 = 12
        newNum = 0 +  digit * 10^0 = 3 * 1 = 3
        
        digit = num % 10 = 12 % 10 = 2
        num = num / 10 = 1
        newNum = newNum * 10^1 + digit = 3 * 10 + 2 = 32
        
        i = 2
        digit = 1 % 10 = 1
        num = 1 / 10 = 0;
        */
        
        boolean negative = false;
        int num = 0;
        
        while (x != 0) {
            int digit = x % 10;
            int newNum = num * 10 + digit;
            if ((newNum - digit) / 10 != num) {
                return 0;
            }
            num = newNum;
            x = x /10;
        }
        return num;
        
    }
}