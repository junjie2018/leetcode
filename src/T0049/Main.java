package T0049;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        new Solution().groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
    }

}

class Solution {


    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return null;
        }
        List<List<String>> result = new ArrayList<>();
        List<Tuple> tuples = new ArrayList<>();

        for (int i = 0; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            tuples.add(new Tuple(String.valueOf(chars), strs[i]));
        }

        Map<String, List<String>> groups = new HashMap<>();
        for (Tuple tuple : tuples) {
            if (!groups.containsKey(tuple.sorted)) {
                groups.put(tuple.sorted, new ArrayList<>());
            }
            groups.get(tuple.sorted).add(tuple.value);
        }

        for (List<String> strings : groups.values()) {
            result.add(strings);
        }

        return result;
    }

    static class Tuple {
        String sorted;
        String value;

        public Tuple(String sorted, String value) {
            this.sorted = sorted;
            this.value = value;
        }
    }
}

class Solution2 {


    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return null;
        }
        List<Tuple> tuples = new ArrayList<>();

        Map<String, List<String>> groups = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String sorted = String.valueOf(chars);
            if (!groups.containsKey(sorted)) {
                groups.put(sorted, new ArrayList<>());
            }
            groups.get(sorted).add(strs[i]);
        }

        return new ArrayList<>(groups.values());
    }

    static class Tuple {
        int hashCode;
        String value;

        public Tuple(int hashCode, String value) {
            this.hashCode = hashCode;
            this.value = value;
        }
    }
}

class Solution3 {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<Integer, List<String>> groups = new HashMap<>();

        for (String str : strs) {

            int i = 1, c = 0, d = 1;
            for (char a : str.toCharArray()) {
                c += a;
                d *= a;
            }
            i = i + c + d;

            if(!groups.containsKey(i)){
                groups.put(i,new ArrayList<>());
            }
            groups.get(i).add(str);
        }
        return new ArrayList<>(groups.values());
    }
}

class Solution4 {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<Integer, Integer> hashMap = new HashMap();
        List<List<String>> lists = new ArrayList<>();
        int index = 0;
        for (String str : strs) {
            int i = 1;
            int c = 0;
            int d = 1;
            for (char a : str.toCharArray()) {
                c += a;
                d *= a;
            }
            i = i + c + d;
            if (hashMap.get(i) == null) {
                List<String> list = new ArrayList();
                list.add(str);
                lists.add(list);
                hashMap.put(i, index);
                index++;
            } else {
                lists.get(hashMap.get(i)).add(str);
            }
        }
        return lists;
    }
}
