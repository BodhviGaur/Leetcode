class Solution {
    public int vowelConsonantScore(String s) {

        HashSet<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');

        int score = 0, ccount = 0, vcount = 0;

        for (int i=0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if(!vowels.contains(curr) && curr <= 'z' && curr >= 'a') {
                ccount++;
            } else if (vowels.contains(curr)) {
                vcount++;
            }
        }

        if (ccount == 0) {
            return 0;
        }
        
        return (int)Math.floor(vcount/ccount);
        
    }
}