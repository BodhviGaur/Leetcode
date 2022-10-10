class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> hm1 = new HashMap<Integer, Integer>();
        HashMap<Integer,Integer> hm2 = new HashMap<Integer, Integer>();
        List<Integer> res = new ArrayList<Integer>();
        int minCount=0;
        System.out.println("1: " + Arrays.toString(nums1));
        System.out.println("2: " + Arrays.toString(nums2));


        for(int num:nums1){
            if(hm1.containsKey(num)){
                hm1.put(num, hm1.get(num)+1);
            }
            else{
                hm1.put(num, 1);
            }
        }
        for(int num:nums2){
            if(hm2.containsKey(num)){
                hm2.put(num, hm2.get(num)+1);
            }
            else{
                hm2.put(num, 1);
            }
        }
        System.out.println("1: " + hm1.keySet());
         System.out.println("2: " + hm2.keySet());

        for(int num:hm1.keySet()){
            if(hm2.containsKey(num)){
                minCount=Math.min(hm2.get(num), hm1.get(num));
                for(int i=0;i<minCount;i++){
                    res.add(num);
                }
            }
        }
        System.out.println(res);
        int[] result = new int[res.size()];
        int i=0;
        for(Integer num: res){
            result[i++]=num;
        }
        return result;
        
    }
}