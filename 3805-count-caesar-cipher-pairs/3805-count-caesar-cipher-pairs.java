class Solution {
    public long countPairs(String[] words) {
        /*
        Approach 1 :
        1. compare diff of characters with the first character
        2. save in hashmap
        3. Compare number of strings with same pattern to find the count of pairs 
        it contributes (note : brute force was comparing them, which is not required now)
         (a * a-1)/2 [pairs for a strings]
        
        **/


       long len = words.length, n = words[0].length(), count=0;
       HashMap<String, Long> hm = new HashMap();

       for (int i = 0; i<len ; i++) {
        StringBuilder diff = new StringBuilder();
        diff.append("");
        for (int k = 1; k<n ; k++) {
            diff = diff.append(String.valueOf((words[i].charAt(k)-words[i].charAt(0) + 26) % 26)+"");
        }
        // System.out.println("word : " + words[i] + ", diff: " + diff);


        String pattern = diff.toString();
        if (hm.keySet().contains(pattern)) {
            hm.put(pattern, hm.get(pattern)+1L);
        } else {
            hm.put(pattern, 1L);
        }
        // count += (hm.get(pattern) - 1);        
       }


    //    for (String key : hm.keySet()) {
    //     Long val = hm.get(key);
    //     System.out.println(" Key : " + key + ", val : " + val);
    //     System.out.println(val * (val - 1L)/2);
    //    }

    
       for (String pattern : hm.keySet()){
            count += ((hm.get(pattern) * (hm.get(pattern)-1))/2);
       }

        return count;
    }
}