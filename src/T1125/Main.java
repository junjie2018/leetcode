package T1125;

import Common.CommonUtils;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        CommonUtils.show(new Solution().smallestSufficientTeam(
//                CommonUtils.createString1a("[\"java\",\"nodejs\",\"reactjs\"]"),
//                CommonUtils.createString2l("[[\"java\"],[\"nodejs\"],[\"nodejs\",\"reactjs\"]]")
//                CommonUtils.createString1a("[\"algorithms\",\"math\",\"java\",\"reactjs\",\"csharp\",\"aws\"]"),
//                CommonUtils.createString2l("[[\"algorithms\",\"math\",\"java\"],[\"algorithms\",\"math\",\"reactjs\"],[\"java\",\"csharp\",\"aws\"],[\"reactjs\",\"csharp\"],[\"csharp\",\"math\"],[\"aws\",\"java\"]]")
                CommonUtils.createString1a("[\"hfkbcrslcdjq\",\"jmhobexvmmlyyzk\",\"fjubadocdwaygs\",\"peaqbonzgl\",\"brgjopmm\",\"x\",\"mf\",\"pcfpppaxsxtpixd\",\"ccwfthnjt\",\"xtadkauiqwravo\",\"zezdb\",\"a\",\"rahimgtlopffbwdg\",\"ulqocaijhezwfr\",\"zshbwqdhx\",\"hyxnrujrqykzhizm\"]"),
                CommonUtils.createString2l("[[\"peaqbonzgl\",\"xtadkauiqwravo\"],[\"peaqbonzgl\",\"pcfpppaxsxtpixd\",\"zshbwqdhx\"],[\"x\",\"a\"],[\"a\"],[\"jmhobexvmmlyyzk\",\"fjubadocdwaygs\",\"xtadkauiqwravo\",\"zshbwqdhx\"],[\"fjubadocdwaygs\",\"x\",\"zshbwqdhx\"],[\"x\",\"xtadkauiqwravo\"],[\"x\",\"hyxnrujrqykzhizm\"],[\"peaqbonzgl\",\"x\",\"pcfpppaxsxtpixd\",\"a\"],[\"peaqbonzgl\",\"pcfpppaxsxtpixd\"],[\"a\"],[\"hyxnrujrqykzhizm\"],[\"jmhobexvmmlyyzk\"],[\"hfkbcrslcdjq\",\"xtadkauiqwravo\",\"a\",\"zshbwqdhx\"],[\"peaqbonzgl\",\"mf\",\"a\",\"rahimgtlopffbwdg\",\"zshbwqdhx\"],[\"xtadkauiqwravo\"],[\"fjubadocdwaygs\"],[\"x\",\"a\",\"ulqocaijhezwfr\",\"zshbwqdhx\"],[\"peaqbonzgl\"],[\"pcfpppaxsxtpixd\",\"ulqocaijhezwfr\",\"hyxnrujrqykzhizm\"],[\"a\",\"ulqocaijhezwfr\",\"hyxnrujrqykzhizm\"],[\"a\",\"rahimgtlopffbwdg\"],[\"zshbwqdhx\"],[\"fjubadocdwaygs\",\"peaqbonzgl\",\"brgjopmm\",\"x\"],[\"hyxnrujrqykzhizm\"],[\"jmhobexvmmlyyzk\",\"a\",\"ulqocaijhezwfr\"],[\"peaqbonzgl\",\"x\",\"a\",\"ulqocaijhezwfr\",\"zshbwqdhx\"],[\"mf\",\"pcfpppaxsxtpixd\"],[\"fjubadocdwaygs\",\"ulqocaijhezwfr\"],[\"fjubadocdwaygs\",\"x\",\"a\"],[\"zezdb\",\"hyxnrujrqykzhizm\"],[\"ccwfthnjt\",\"a\"],[\"fjubadocdwaygs\",\"zezdb\",\"a\"],[],[\"peaqbonzgl\",\"ccwfthnjt\",\"hyxnrujrqykzhizm\"],[\"xtadkauiqwravo\",\"hyxnrujrqykzhizm\"],[\"peaqbonzgl\",\"a\"],[\"x\",\"a\",\"hyxnrujrqykzhizm\"],[\"zshbwqdhx\"],[],[\"fjubadocdwaygs\",\"mf\",\"pcfpppaxsxtpixd\",\"zshbwqdhx\"],[\"pcfpppaxsxtpixd\",\"a\",\"zshbwqdhx\"],[\"peaqbonzgl\"],[\"peaqbonzgl\",\"x\",\"ulqocaijhezwfr\"],[\"ulqocaijhezwfr\"],[\"x\"],[\"fjubadocdwaygs\",\"peaqbonzgl\"],[\"fjubadocdwaygs\",\"xtadkauiqwravo\"],[\"pcfpppaxsxtpixd\",\"zshbwqdhx\"],[\"peaqbonzgl\",\"brgjopmm\",\"pcfpppaxsxtpixd\",\"a\"],[\"fjubadocdwaygs\",\"x\",\"mf\",\"ulqocaijhezwfr\"],[\"jmhobexvmmlyyzk\",\"brgjopmm\",\"rahimgtlopffbwdg\",\"hyxnrujrqykzhizm\"],[\"x\",\"ccwfthnjt\",\"hyxnrujrqykzhizm\"],[\"hyxnrujrqykzhizm\"],[\"peaqbonzgl\",\"x\",\"xtadkauiqwravo\",\"ulqocaijhezwfr\",\"hyxnrujrqykzhizm\"],[\"brgjopmm\",\"ulqocaijhezwfr\",\"zshbwqdhx\"],[\"peaqbonzgl\",\"pcfpppaxsxtpixd\"],[\"fjubadocdwaygs\",\"x\",\"a\",\"zshbwqdhx\"],[\"fjubadocdwaygs\",\"peaqbonzgl\",\"x\"],[\"ccwfthnjt\"]]")
//                CommonUtils.createString1a("[\"abc\",\"abc\"，\"abc\"]"),
//                CommonUtils.createString2l("[[\"abc\"],[]]")
        ));
    }
}

@SuppressWarnings("all")
class Solution {

    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {

        int len = people.size();
        int size = 1 << req_skills.length;

        List<Integer>[] path = new List[size];

        for (int i = 0; i < len; i++) {
            HashSet<String> peo_skills = new HashSet<>(people.get(i));

            // 将perple掌握的技能转换成二进制数据表示
            int skills = 0;
            for (int j = 0; j < req_skills.length; j++) {
                if (peo_skills.contains(req_skills[j])) {
                    skills |= (1 << j);
                }
            }

            // 1.将sizes中res位置的值更新为1，将map中res的值更新为一个新的数组
            if (path[skills] == null) path[skills] = new ArrayList<>();
            path[skills].clear();
            path[skills].add(i);

            // 2.更新size中的其他值
            for (int j = 0; j < size; j++) {
                if (path[j] != null) {
                    int cur = j | skills;
                    if (cur == 0 || cur == skills) continue;
                    if (path[cur] != null && path[cur].size() <= path[j].size() + 1) continue;

                    if (path[cur] == null) path[cur] = new ArrayList<>();
                    path[cur].clear();
                    path[cur].addAll(path[j]);
                    path[cur].add(i);
                }
            }
        }

        List<Integer> tmp = path[size - 1];
        int[] result = new int[tmp.size()];
        for (int i = 0; i < tmp.size(); i++) {
            result[i] = tmp.get(i);
        }

        return result;


    }
}
