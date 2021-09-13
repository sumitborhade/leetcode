class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int[] dict = new int[26];
        for(int i=0; i<order.length(); i++) {
            char ch = order.charAt(i);
            dict[ch-'a'] = i;
        }
        
        for(int i=0; i<words.length-1; i++) {
            String firstWord = words[i];
            String secondWord = words[i+1];
            
            if(firstWord.length() > secondWord.length() 
               && firstWord.startsWith(secondWord)) {
                return false;
            }
            
            for(int j=0; j< Math.min(firstWord.length(), secondWord.length()); j++ ) {
                char ch1 = firstWord.charAt(j);
                char ch2 = secondWord.charAt(j);
                if(dict[ch1-'a'] < dict[ch2-'a']) {
                    break;
                }
                
                if(dict[ch1-'a'] > dict[ch2-'a']) {
                    return false;
                }
            }
        }
        
        return true;
    }
}
