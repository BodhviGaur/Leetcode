class Solution {
    public int residuePrefixes(String s) {
        /*
        Approach 1 :
        1. Defines new HashSet with unique chars
        2. Go through each char of the string from the start (0) and for each prefix 
        (0 to index), check number(unique char) = len(prefix)%3.
        3. Return count.
        4. Edge case : length = 0, object null, return 0;
        **/

        HashSet<Character> set = new HashSet();
        StringBuilder prefix = new StringBuilder();
        int count = 0;

        if (s == null || s.length() == 0) {
            return 0;
        }

        int size = s.length();
        for(int i = 0; i < size; i++) {
            char newChar = s.charAt(i);
            if (!set.contains(newChar)) {
                set.add(newChar);
            }

            prefix = prefix.append(newChar);
            if (prefix.length()%3 == set.size()) {
                count++;
            }
        }
        return count;
    }
}