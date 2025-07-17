class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for(String s : strs) {
            char[] ch = s.toCharArray();
            Arrays.sort(ch);

            String keys = new String(ch);

            if(!map.containsKey(keys)) {
                map.put(keys, new ArrayList<>());
            }

            map.get(keys).add(s);
        }

        return new ArrayList<>(map.values());

    }
}