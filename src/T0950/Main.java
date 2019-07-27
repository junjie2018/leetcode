package T0950;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution2().deckRevealedIncreasing(new int[]{17, 13, 11, 2, 3, 5, 7})));
    }
}

class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {


        LinkedList<Info> list = new LinkedList<>();
        for (int i = 0; i < deck.length; i++) {
            list.add(new Info(i));
        }

        ArrayList<Info> res = new ArrayList<>();
        while (list.size() > 0) {
            res.add(list.removeFirst());
            if (list.size() > 0)
                list.add(list.removeFirst());
        }

        Arrays.sort(deck);
        for (int i = 0; i < deck.length; i++) {
            res.get(i).value = deck[i];
        }

        res.sort((e1, e2) -> e1 == e2 ? 0 : e1.index > e2.index ? 1 : -1);

        int[] tmp = new int[deck.length];
        for (int i = 0; i < res.size(); i++) {
            tmp[i] = res.get(i).value;
        }
        return tmp;
    }

    private static class Info {
        int index;
        int value;

        public Info(int index) {
            this.index = index;
        }

        public Info(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }
}

class Solution2 {
    public int[] deckRevealedIncreasing(int[] deck) {

        if (deck.length == 1) {
            return deck;
        }

        int len = deck.length;

        Arrays.sort(deck);

        int[] remained = new int[len / 2];
        System.arraycopy(deck, len - len / 2, remained, 0, len / 2);
        remained = deckRevealedIncreasing(remained);

        int index = 0;
        int[] res = new int[len];
        if (len % 2 == 1) {
            for (int i = 0; i < len / 2; i++) {
                res[index++] = deck[i];
                if (i == 0) {
                    res[index++] = remained[len / 2 - 1];
                    continue;
                }
                res[index++] = remained[i - 1];
            }
            res[index] = deck[len / 2];
        } else {
            for (int i = 0; i < len / 2; i++) {
                res[index++] = deck[i];
                res[index++] = remained[i];
            }
        }
        return res;
    }
}