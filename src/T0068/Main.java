package T0068;

import Common.CommonUtils;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().fullJustify(
                CommonUtils.createString1a(
//                        "[\"This\", \"is\", \"an\", \"example\", \"of\", \"text\", \"justification.\"]"
                        "[\"What\",\"must\",\"be\",\"acknowledgment\",\"shall\",\"be\"]"
                ),
                16
        ));
    }
}

class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {

        List<String> result = new ArrayList<>();

        int startIdx = 0;
        int curLen = 0, curCount = 0;
        for (int i = 0; i < words.length; i++) {
            curLen += words[i].length();
            ++curCount;
            if (i + 1 >= words.length || curLen + curCount + words[i + 1].length() > maxWidth) {
                // 最后一行
                if (i + 1 >= words.length) {
                    StringBuilder sb = new StringBuilder();
                    for (int j = startIdx; j <= i; j++) {
                        sb.append(words[j]).append(' ');
                    }
                    sb.deleteCharAt(sb.length() - 1);
                    repeat(sb, maxWidth - sb.length());
                    result.add(sb.toString());
                }
                // 非最后一行
                else {
                    StringBuilder sb = new StringBuilder();
                    if (curCount == 1) {
                        sb.append(words[startIdx]);
                        repeat(sb, maxWidth - sb.length());
                    } else {
                        int baseSpace = (maxWidth - curLen) / (curCount - 1);
                        int needPlusOne = (maxWidth - curLen) % (curCount - 1);

                        for (int j = startIdx; j <= i; j++) {
                            sb.append(words[j]);
                            if (j != i) {
                                if (j < startIdx + needPlusOne) repeat(sb, baseSpace + 1);
                                else repeat(sb, baseSpace);
                            }
                        }
                    }
                    result.add(sb.toString());
                }
                curLen = 0;
                curCount = 0;
                startIdx = i + 1;
            }
        }
        return result;
    }

    private void repeat(StringBuilder sb, int count) {
        for (int i = 0; i < count; i++) {
            sb.append(' ');
        }
    }
}
