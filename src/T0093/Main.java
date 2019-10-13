package T0093;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        System.out.println(new Solution().restoreIpAddresses("444444"));
        System.out.println(new Solution().restoreIpAddresses("19216811"));
    }
}

// 感觉自己像个sb
class Solution {

    private String input;
    private List<String> result;

    public List<String> restoreIpAddresses(String s) {
        this.input = s;
        this.result = new ArrayList<>();

        switch (s.length()) {
            case 0:
            case 1:
            case 2:
            case 3:
                return Collections.emptyList();
            case 4:
                disposeFour();
                break;
            case 5:
                disposeFive();
                break;
            case 6:
                disposeSix();
                break;
            case 7:
                disposeSeven();
                break;
            case 8:
                disposeEight();
                break;
            case 9:
                disposeNine();
                break;
            case 10:
                disposeTen();
                break;
            case 11:
                disposeEleven();
                break;
            case 12:
                disposeTwelve();
                break;
            default:
                return Collections.emptyList();
        }

//        我知道这种写法不可以，但是idea自动帮我生成了这种代码
//        for (String ipStr : result) {
//            String[] fragments = ipStr.split("\\.");
//            for (String fragment : fragments) {
//                if (Integer.valueOf(fragment) > 225){
//                    result.remove(ipStr);
//                    break;
//                }
//            }
//        }
        Iterator<String> iterator = result.iterator();
        while (iterator.hasNext()) {
            String[] fragments = iterator.next().split("\\.");
            for (String fragment : fragments) {
                if (fragment.startsWith("0") && fragment.length() != 1) {
                    iterator.remove();
                    break;
                }
                if (Integer.valueOf(fragment) > 255) {
                    iterator.remove();
                    break;

                }
            }
        }
        return result;
    }

    private void disposeFour() {
        result.add(input.replaceAll("(.)(.)(.)(.)", "$1.$2.$3.$4"));
    }

    private void disposeFive() {
        result.add(input.replaceAll("(.)(.)(.)(..)", "$1.$2.$3.$4"));
        result.add(input.replaceAll("(.)(.)(..)(.)", "$1.$2.$3.$4"));
        result.add(input.replaceAll("(.)(..)(.)(.)", "$1.$2.$3.$4"));
        result.add(input.replaceAll("(..)(.)(.)(.)", "$1.$2.$3.$4"));
    }

    private void disposeSix() {
        result.add(input.replaceAll("(.)(.)(.)(...)", "$1.$2.$3.$4"));
        result.add(input.replaceAll("(.)(.)(...)(.)", "$1.$2.$3.$4"));
        result.add(input.replaceAll("(.)(...)(.)(.)", "$1.$2.$3.$4"));
        result.add(input.replaceAll("(...)(.)(.)(.)", "$1.$2.$3.$4"));

        result.add(input.replaceAll("(.)(.)(..)(..)", "$1.$2.$3.$4"));
        result.add(input.replaceAll("(.)(..)(.)(..)", "$1.$2.$3.$4"));
        result.add(input.replaceAll("(.)(..)(..)(.)", "$1.$2.$3.$4"));
        result.add(input.replaceAll("(..)(.)(.)(..)", "$1.$2.$3.$4"));
        result.add(input.replaceAll("(..)(.)(..)(.)", "$1.$2.$3.$4"));
        result.add(input.replaceAll("(..)(..)(.)(.)", "$1.$2.$3.$4"));
    }

    private void disposeSeven() {
        result.add(input.replaceAll("(.)(.)(..)(...)", "$1.$2.$3.$4"));
        result.add(input.replaceAll("(.)(.)(...)(..)", "$1.$2.$3.$4"));
        result.add(input.replaceAll("(.)(..)(.)(...)", "$1.$2.$3.$4"));
        result.add(input.replaceAll("(.)(..)(...)(.)", "$1.$2.$3.$4"));
        result.add(input.replaceAll("(.)(...)(..)(.)", "$1.$2.$3.$4"));
        result.add(input.replaceAll("(.)(...)(.)(..)", "$1.$2.$3.$4"));

        result.add(input.replaceAll("(..)(.)(.)(...)", "$1.$2.$3.$4"));
        result.add(input.replaceAll("(..)(.)(...)(.)", "$1.$2.$3.$4"));
        result.add(input.replaceAll("(..)(...)(.)(.)", "$1.$2.$3.$4"));

        result.add(input.replaceAll("(...)(.)(..)(.)", "$1.$2.$3.$4"));
        result.add(input.replaceAll("(...)(.)(.)(..)", "$1.$2.$3.$4"));
        result.add(input.replaceAll("(...)(..)(.)(.)", "$1.$2.$3.$4"));

        result.add(input.replaceAll("(..)(..)(..)(.)", "$1.$2.$3.$4"));
        result.add(input.replaceAll("(..)(..)(.)(..)", "$1.$2.$3.$4"));
        result.add(input.replaceAll("(..)(.)(..)(..)", "$1.$2.$3.$4"));
        result.add(input.replaceAll("(.)(..)(..)(..)", "$1.$2.$3.$4"));
    }

    private void disposeEight() {
        result.add(input.replaceAll("(.)(..)(..)(...)", "$1.$2.$3.$4"));
        result.add(input.replaceAll("(.)(..)(...)(..)", "$1.$2.$3.$4"));
        result.add(input.replaceAll("(.)(...)(..)(..)", "$1.$2.$3.$4"));

        result.add(input.replaceAll("(..)(.)(..)(...)", "$1.$2.$3.$4"));
        result.add(input.replaceAll("(..)(.)(...)(..)", "$1.$2.$3.$4"));
        result.add(input.replaceAll("(..)(..)(.)(...)", "$1.$2.$3.$4"));
        result.add(input.replaceAll("(..)(..)(...)(.)", "$1.$2.$3.$4"));
        result.add(input.replaceAll("(..)(...)(..)(.)", "$1.$2.$3.$4"));
        result.add(input.replaceAll("(..)(...)(.)(..)", "$1.$2.$3.$4"));


        result.add(input.replaceAll("(...)(.)(..)(..)", "$1.$2.$3.$4"));
        result.add(input.replaceAll("(...)(..)(.)(..)", "$1.$2.$3.$4"));
        result.add(input.replaceAll("(...)(..)(..)(.)", "$1.$2.$3.$4"));

        result.add(input.replaceAll("(..)(..)(..)(..)", "$1.$2.$3.$4"));

        result.add(input.replaceAll("(.)(.)(...)(...)", "$1.$2.$3.$4"));
        result.add(input.replaceAll("(.)(...)(.)(...)", "$1.$2.$3.$4"));
        result.add(input.replaceAll("(.)(...)(...)(.)", "$1.$2.$3.$4"));
        result.add(input.replaceAll("(...)(...)(.)(.)", "$1.$2.$3.$4"));
        result.add(input.replaceAll("(...)(.)(.)(...)", "$1.$2.$3.$4"));
        result.add(input.replaceAll("(...)(.)(...)(.)", "$1.$2.$3.$4"));
    }

    private void disposeNine() {
        result.add(input.replaceAll("(.)(..)(...)(...)", "$1.$2.$3.$4"));
        result.add(input.replaceAll("(.)(...)(..)(...)", "$1.$2.$3.$4"));
        result.add(input.replaceAll("(.)(...)(...)(..)", "$1.$2.$3.$4"));

        result.add(input.replaceAll("(..)(.)(...)(...)", "$1.$2.$3.$4"));
        result.add(input.replaceAll("(..)(...)(...)(.)", "$1.$2.$3.$4"));
        result.add(input.replaceAll("(..)(...)(.)(...)", "$1.$2.$3.$4"));

        result.add(input.replaceAll("(...)(.)(..)(...)", "$1.$2.$3.$4"));
        result.add(input.replaceAll("(...)(.)(...)(..)", "$1.$2.$3.$4"));
        result.add(input.replaceAll("(...)(..)(...)(.)", "$1.$2.$3.$4"));
        result.add(input.replaceAll("(...)(..)(.)(...)", "$1.$2.$3.$4"));
        result.add(input.replaceAll("(...)(...)(..)(.)", "$1.$2.$3.$4"));
        result.add(input.replaceAll("(...)(...)(.)(..)", "$1.$2.$3.$4"));

        result.add(input.replaceAll("(..)(..)(..)(...)", "$1.$2.$3.$4"));
        result.add(input.replaceAll("(..)(..)(...)(..)", "$1.$2.$3.$4"));
        result.add(input.replaceAll("(..)(...)(..)(..)", "$1.$2.$3.$4"));
        result.add(input.replaceAll("(...)(..)(..)(..)", "$1.$2.$3.$4"));
    }

    private void disposeTen() {
        result.add(input.replaceAll("(...)(...)(...)(.)", "$1.$2.$3.$4"));
        result.add(input.replaceAll("(...)(...)(.)(...)", "$1.$2.$3.$4"));
        result.add(input.replaceAll("(...)(.)(...)(...)", "$1.$2.$3.$4"));
        result.add(input.replaceAll("(.)(...)(...)(...)", "$1.$2.$3.$4"));

        result.add(input.replaceAll("(...)(...)(..)(..)", "$1.$2.$3.$4"));
        result.add(input.replaceAll("(...)(..)(...)(..)", "$1.$2.$3.$4"));
        result.add(input.replaceAll("(...)(..)(..)(...)", "$1.$2.$3.$4"));
        result.add(input.replaceAll("(..)(...)(...)(..)", "$1.$2.$3.$4"));
        result.add(input.replaceAll("(..)(...)(..)(...)", "$1.$2.$3.$4"));
        result.add(input.replaceAll("(..)(..)(...)(...)", "$1.$2.$3.$4"));
    }

    private void disposeEleven() {
        result.add(input.replaceAll("(...)(...)(...)(..)", "$1.$2.$3.$4"));
        result.add(input.replaceAll("(...)(...)(..)(...)", "$1.$2.$3.$4"));
        result.add(input.replaceAll("(...)(..)(...)(...)", "$1.$2.$3.$4"));
        result.add(input.replaceAll("(..)(...)(...)(...)", "$1.$2.$3.$4"));
    }

    private void disposeTwelve() {
        result.add(input.replaceAll("(...)(...)(...)(...)", "$1.$2.$3.$4"));
    }
}
