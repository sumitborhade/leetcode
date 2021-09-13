class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        //Storing the order with sequence
        int[] dict = new int[26];
        for(int i=0; i<order.length(); i++) {
            char ch = order.charAt(i);
            dict[ch-'a'] = i;
        }
        
        //Comparing the words
        //Checking the negative scenarios, as final return will be true if exist conditions are not found
        for(int i=0; i<words.length-1; i++) {
            String firstWord = words[i];
            String secondWord = words[i+1];
            
            //If second word is part of first then order is incorrect
            if(firstWord.length() > secondWord.length() 
               && firstWord.startsWith(secondWord)) {
                return false;
            }
            
            for(int j=0; j< Math.min(firstWord.length(), secondWord.length()); j++ ) {
                char ch1 = firstWord.charAt(j);
                char ch2 = secondWord.charAt(j);
                //If char of first word is less than second word then words are sorted correctly
                if(dict[ch1-'a'] < dict[ch2-'a']) {
                    break;
                }
                //If char of first word is greater than second then exit
                if(dict[ch1-'a'] > dict[ch2-'a']) {
                    return false;
                }
            }
        }
        
        return true;
    }
}
