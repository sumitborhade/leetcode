class Solution {
    public String minRemoveToMakeValid(String s) {
        //Border case
        if(s == null || s.length() == 0) {
            return s;
        }
        
        Stack<Character> stack = new Stack<>();
        int notMatching = 0;
        
        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            
            //3 conditions are present
            if(ch == '(') {
                stack.push(ch);
                notMatching++;
            } else if(ch == ')') {
                if(notMatching>0) {
                    stack.push(ch);
                    notMatching--;
                }
            } else {
                stack.push(ch);
            }
        }
        
        StringBuilder res = new StringBuilder();

        while(!stack.isEmpty()) {
            char ch = stack.pop();
            if(notMatching != 0 && ch == '(') {
                notMatching--;
            } else {
                res.append(ch);
            }
        }
        
        return res.reverse().toString();
   }
}
