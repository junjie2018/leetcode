package T0811;

import Common.CommonUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        CommonUtils.show(
                "abcd".split("\\.")
        );
    }
}

class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        List<String> res = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();

        for (String cpdomain : cpdomains) {
            String[] split = cpdomain.split("\\s+");
            int times = Integer.parseInt(split[0]);
            String domain = split[1];

            String[] domainStrs = domain.split("\\.");

            String k1, k2, k3;
            switch (domainStrs.length) {
                case 1:
                    k1 = domainStrs[0];
                    map.put(k1, map.getOrDefault(k1, 0) + times);
                    break;
                case 2:
                    k1 = domainStrs[1];
                    k2 = domainStrs[0] + "." + domainStrs[1];
                    map.put(k1, map.getOrDefault(k1, 0) + times);
                    map.put(k2, map.getOrDefault(k2, 0) + times);
                    break;
                case 3:
                    k1 = domainStrs[2];
                    k2 = domainStrs[1] + "." + domainStrs[2];
                    k3 = domainStrs[0] + "." + domainStrs[1] + "." + domainStrs[2];
                    map.put(k1, map.getOrDefault(k1, 0) + times);
                    map.put(k2, map.getOrDefault(k2, 0) + times);
                    map.put(k3, map.getOrDefault(k3, 0) + times);
            }

        }

        map.forEach((k, v) -> {
            res.add(String.format("%d %s", v, k));
        });

        return res;
    }
}