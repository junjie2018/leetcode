package T0736;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
//        System.out.println(new Solution().evaluate("(let x 2 (mult x (let x 3 y 4 (add x y))))"));
        System.out.println(new Solution().evaluate("(let a1 3 b2 (add a1 1) b2)"));
//        new Solution().evaluate("(add 1 2)");
//        System.out.println(new Solution().evaluate("(let x 3 x 2 x)"));
        System.out.println(new Solution().evaluate("(let x 7 -12)"));
    }
}

class Solution {

    private ArrayList<Token> tokens;

    public int evaluate(String expression) {
//        System.out.println(getTokens(expression));
//        for (Token token : getTokens(expression)) {
//            System.out.println(token);
//        }
        this.tokens = getTokens(expression);

        return evaluateCore(new HashMap<>());
    }

    private int evaluateCore(HashMap<String, Integer> map) {
        tokens.remove(0);
        int res = 0;
        switch (getOpt()) {
            case Add:
                res = getValue(map) + getValue(map);
                break;
            case Mult:
                res = getValue(map) * getValue(map);
                break;
            default:
                HashMap<String, Integer> tmp = new HashMap<>(map);
                while (tokens.get(0).type == Type.Variable && tokens.get(1).type != Type.Right) {
                    tmp.put(getVariable(), getValue(tmp));
                }
                res = getValue(tmp);
        }
        tokens.remove(0);
        return res;
    }

    private Type getOpt() {
        return tokens.remove(0).type;
    }

    private String getVariable() {
        return tokens.remove(0).variable;
    }

    private int getValue(HashMap<String, Integer> map) {
        switch (tokens.get(0).type) {
            case Variable:
                return map.get(tokens.remove(0).variable);
            case Value:
                return tokens.remove(0).value;
            default:
                return evaluateCore(map);
        }
    }

    private ArrayList<Token> getTokens(String expression) {
        ArrayList<Token> tokens = new ArrayList<>();

        boolean isOver = false;
        boolean isValue = false, isVariable = false;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < expression.length(); i++) {
            char aChar = expression.charAt(i);
            switch (aChar) {
                case '(':
                    tokens.add(new Token(Type.Left));
                    break;
                case ')':
                    tokens.add(new Token(Type.Right));
                    break;
                case ' ':
                    break;
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                case '-':
                    sb.append(aChar);
                    if (!isVariable) {
                        isValue = true;
                    }
                    if (i + 1 > expression.length() || isEndFlags(expression.charAt(i + 1))) {
                        isOver = true;
                    }
                    break;
                default:
                    sb.append(aChar);
                    isVariable = true;
                    if (i + 1 > expression.length() || isEndFlags(expression.charAt(i + 1))) {
                        isOver = true;
                    }
                    break;
            }
            if (isOver) {
                if (isVariable) {
                    String tmp = sb.toString();
                    switch (sb.toString()) {
                        case "let":
                            tokens.add(new Token(Type.Let, tmp));
                            break;
                        case "add":
                            tokens.add(new Token(Type.Add, tmp));
                            break;
                        case "mult":
                            tokens.add(new Token(Type.Mult, tmp));
                            break;
                        default:
                            tokens.add(new Token(Type.Variable, tmp));
                            break;
                    }

                } else {
                    tokens.add(new Token(Type.Value, Integer.parseInt(sb.toString())));
                }
                isValue = false;
                isVariable = false;
                isOver = false;
                sb.setLength(0);
            }
        }

        return tokens;
    }

    private boolean isEndFlags(char aChar) {
        return aChar == ' ' || aChar == ')';
    }

    private enum Type {
        Left, Right,
        Add, Mult, Let,
        Variable, Value,
    }

    private static class Token {
        Type type;
        String variable;
        int value;

        public Token(Type type) {
            this.type = type;
        }

        public Token(Type type, String variable) {
            this.type = type;
            this.variable = variable;
        }

        public Token(Type type, int value) {
            this.type = type;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Token{" +
                    "type=" + type +
                    ", variable='" + variable + '\'' +
                    ", value=" + value +
                    '}';
        }
    }
}

class Solution3 {

    private String expression;

    public int evaluate(String expression) {
        this.expression = expression;
        return evaluateCore(new HashMap<String, Integer>());
    }

    private int evaluateCore(HashMap<String, Integer> map) {
        getNextToken();
        int res = 0;
        switch (getOpt()) {
            case "add":
                res = getValue(map) + getValue(map);
                break;
            case "mult":
                res = getValue(map) * getValue(map);
                break;
            case "let":
                HashMap<String, Integer> tmp = new HashMap<>(map);
                while (true) {
                    if (!nextIsVariable()) {
                        res = getValue(tmp);
                        break;
                    }
                    String variable = getVariable();
                    if (nextIsEndFlags()) {
                        res = tmp.get(variable);
                        break;
                    }
                    tmp.put(variable, getValue(map));
                }
                break;
        }
        getNextToken();
        return res;
    }

    private boolean nextIsEndFlags() {
        return expression.charAt(curIdx) == ')';
    }

    private boolean nextIsVariable() {
        char aChar = expression.charAt(curIdx);
        if (aChar >= 'a' && aChar <= 'z') {
            return true;
        }
        return false;
    }

    private String getOpt() {
        return getNextToken();
    }

    private String getVariable() {
        return getNextToken();
    }

    private int getValue(HashMap<String, Integer> map) {
        char aChar = expression.charAt(curIdx);
        if ((aChar >= '0' && aChar <= '9') || aChar == '-') {
            return Integer.parseInt(getNextToken());
        }
        if (aChar >= 'a' && aChar <= 'z') {
            return map.get(getNextToken());
        }
        return evaluateCore(map);
    }

    private int curIdx = 0;

    private String getNextToken() {
        boolean isOver = false;
        StringBuilder sb = new StringBuilder();
        while (curIdx < expression.length()) {
            char aChar = expression.charAt(curIdx);

            switch (aChar) {
                case '(':
                case ')':
                    return "";
                case ' ':
                    break;
                default:
                    sb.append(aChar);
                    if (curIdx + 1 > expression.length() || expression.charAt(curIdx + 1) == ' ' || expression.charAt(curIdx + 1) == ')') {
                        isOver = true;
                    }
            }
            curIdx++;
            if (isOver) {
                return sb.toString();
            }
        }
        return "";
    }


}

class Solution2 {

    private int curIdx = 0;
    private String expression;

    public int evaluate(String expression) {
        this.expression = expression;
        return evaluateCore(new HashMap<String, Integer>());
    }

    private int evaluateCore(HashMap<String, Integer> map) {
        curIdx++; // 移位抛弃左括号
        int res = 0;
        switch (getOpt()) {
            case "add":
                res = getValue(map) + getValue(map);
                break;
            case "mult":
                res = getValue(map) * getValue(map);
                break;
            case "let":
                HashMap<String, Integer> tmp = new HashMap<>(map);
                while (true) {
                    if (!nextIsVariable()) {
                        res = getValue(tmp);
                        break;
                    }
                    String variable = getVariable();
                    if (nextIsEndFlags()) {
                        res = tmp.get(variable);
                        break;
                    }
                    tmp.put(variable, getValue(map));
                }
                break;
        }
        curIdx++;// 移位抛弃右括号
        return res;
    }

    private boolean nextIsEndFlags() {
        return expression.charAt(curIdx) == ')';
    }

    private boolean nextIsVariable() {
        char aChar = expression.charAt(curIdx);
        if (aChar >= 'a' && aChar <= 'z') {
            return true;
        }
        return false;
    }

    private String getOpt() {
        return getNextString();
    }

    private String getVariable() {
        return getNextString();
    }

    private int getValue(HashMap<String, Integer> map) {
        char aChar = expression.charAt(curIdx);
        if ((aChar >= '0' && aChar <= '9') || aChar == '-') {
            return Integer.parseInt(getNextString());
        }
        if (aChar >= 'a' && aChar <= 'z') {
            return map.get(getNextString());
        }
        return evaluateCore(map);
    }

    private String getNextString() {
        int tmp = curIdx;
        char aChar = expression.charAt(tmp);
        while (aChar != ' ' && aChar != ')') {
            tmp++;
            aChar = expression.charAt(tmp);
        }
        String res = expression.substring(curIdx, tmp);
        if (aChar == ' ') {
            curIdx = ++tmp;
        }
        return res;
    }


}
