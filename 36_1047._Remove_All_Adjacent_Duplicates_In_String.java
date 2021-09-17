class Solution {
    public String removeDuplicates(String s) {
        return removeDuplicatesUsingStack(s);
        // return removeDuplicatesUsingStringBuilder(s);
    }
    
    /*public String removeDuplicatesUsingStringBuilder(String s) {
        if(s == null || s.length() == 0) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            if(!sb.toString().equals("") && sb.charAt(sb.length()-1) == ch) {
                sb.deleteCharAt(sb.length()-1);
            } else {
                sb.append(ch);
            }
        }
        
        return sb.toString();
    }*/
    
    
    public String removeDuplicatesUsingStack(String s) {
        if(s == null || s.length() == 0) {
            return s;
        }

        Stack<Character> stack = new Stack<>();
        
        for(int i=0; i< s.length(); i++) {
            char ch = s.charAt(i);
            if(!stack.isEmpty() && stack.peek() == ch) {
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        
        return sb.reverse().toString();
    }
}
