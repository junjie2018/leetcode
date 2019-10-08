package T0030;

import Common.CommonUtils;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().findSubstring(
//                "barfoothefoobarman",
//                CommonUtils.createString1a("[\"foo\",\"bar\"]")
                "wordgoodgoodgoodbestword",
                CommonUtils.createString1a("[\"word\",\"good\",\"best\",\"good\"]")
        ));
    }
}

// 本來想用LinkedHashMap做，但是LinkedHashMap移除尾部元素的时间复杂度为O(n)
class Solution {
    public List<Integer> findSubstring(String s, String[] words) {

        if (s == null || s.length() == 0 || words == null || words.length == 0) return Collections.emptyList();

        List<Integer> result = new ArrayList<>();

        Map<String, Integer> word2count = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            word2count.put(words[i], word2count.getOrDefault(words[i], 0) + 1);
        }


        int k = words[0].length();
        Tuple[] tuples = new Tuple[k];
        for (int i = 0; i < s.length(); i++) {
            if (i + k > s.length()) break;

            String key = s.substring(i, i + k);
            if (!word2count.containsKey(key)) {
                tuples[i % k] = null;
                continue;
            }

            if (tuples[i % k] == null) tuples[i % k] = new Tuple();

            Tuple tuple = tuples[i % k];
            LinkedList<String> list = tuple.list;
            HashMap<String, Integer> map = tuple.map;

            list.addFirst(key);
            map.put(key, map.getOrDefault(key, 0) + 1);
            if (map.get(key) > word2count.get(key)) {
                String tmpKey = list.removeLast();
                map.put(tmpKey, map.get(tmpKey) - 1);
                while (!key.equals(tmpKey)) {
                    tmpKey = list.removeLast();
                    map.put(tmpKey, map.get(tmpKey) - 1);
                }
            }

            if (list.size() == words.length) result.add(i - k * (words.length - 1));

        }

        return result;
    }

    private static class Tuple {
        HashMap<String, Integer> map = new HashMap<>();
        LinkedList<String> list = new LinkedList<>();
    }
}