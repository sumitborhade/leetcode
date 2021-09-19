class Solution {
    
    public String addBinary(String a, String b) {
        int m = a.length()-1;
        int n = b.length()-1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        
        while(m >=0 || n>=0 ) {
            char ch1 = '0';
            if(m >= 0) {
                ch1 = a.charAt(m);
            }
            
            int a1= ch1 -'0';
            
            char ch2 = '0';
            if(n >= 0) {
                ch2 = b.charAt(n);
            }
            
            int b1= ch2 -'0';
            
            int sum = a1 + b1 + carry;
            if(sum == 0 || sum == 1) {
                carry = 0;
            } else if (sum == 2) {
                sum = 0;
                carry = 1;
            } else {
                sum = 1;
                carry = 1;
            }
            
            sb.append(sum);
            m--;
            n--;
        }
        
        if(carry == 1) {
            sb.append(carry);
        }
        
        return sb.reverse().toString();
    }
    
}
