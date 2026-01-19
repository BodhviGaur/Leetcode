class Solution {
    public int residuePrefixes(String s) {
        /*
        Approach 1 :
        1. Defines new HashSet with unique chars
        2. Go through each char of the string from the start (0) and for each prefix 
        (0 to index), check number(unique char) = len(prefix)%3.
        3. Return count.
        4. Edge case : length = 0, object null, return 0;


        Approach 2 : Better because space can be O(1) - space of hashset will be 3. 
        Here, as soon as length of hashset is > 2, we can break, 
        simply because the value of x%3 can only be 0,1,2. So 
        no other equality will help contribute to the count.
        So we add the condition that if size of set > 2, we break and return answer.
        **/

        HashSet<Character> set = new HashSet();
        StringBuilder prefix = new StringBuilder();
        int count = 0;

        if (s == null || s.length() == 0) {
            return 0;
        }

        int size = s.length();
        for(int i = 0; i < size; i++) {
            set.add(s.charAt(i));
            prefix = prefix.append(s.charAt(i));
            if (prefix.length()%3 == set.size()) {
                count++;
            }
            if (set.size() > 2) {
                break;
            }
        }
        return count;
    }
}