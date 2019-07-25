package T0640;

public class Main {
    public static void main(String[] args) {
//        System.out.println(new Solution().solveEquation("x=x+2"));
//        System.out.println(new Solution().solveEquation("x+5-3+x=6+x-2"));
        System.out.println(new Solution().solveEquation("0x=0"));

    }
}

class Solution {
    public String solveEquation(String equation) {
        String[] tmp = equation.split("=");

        Equation leftEquation = getEquation(tmp[0]);
        Equation rightEquation = getEquation(tmp[1]);

        Equation result = new Equation(leftEquation.constant - rightEquation.constant, leftEquation.coefficient - rightEquation.coefficient);

        if (result.coefficient == 0) {
            return result.constant == 0 ? "Infinite solutions" : "No solution";
        } else {
            return "x=" + String.valueOf(-result.constant / result.coefficient);
        }
    }

    private Equation getEquation(String equation) {
        Equation result = new Equation();

        int sum = 0;
        boolean isPositive = true;
        boolean isVariable = false;
        boolean isNeedDispose = false;
        boolean hasCoefficient = false;
        for (int i = 0; i < equation.length(); i++) {
            switch (equation.charAt(i)) {
                case '+':
                    isPositive = true;
                    break;
                case '-':
                    isPositive = false;
                    break;
                case 'x':
                    sum = hasCoefficient ? sum : 1;
                    isVariable = true;
                    isNeedDispose = true;
                    break;
                default:
                    sum = sum * 10 + Integer.parseInt(String.valueOf(equation.charAt(i)));
                    if (i + 1 >= equation.length() || ('0' > equation.charAt(i + 1) || equation.charAt(i + 1) > '9' && equation.charAt(i + 1) != 'x')) {
                        isNeedDispose = true;
                    }
                    hasCoefficient = true;
            }

            if (isNeedDispose) {
                sum = isPositive ? sum : -sum;
                if (isVariable) {
                    result.coefficient += sum;
                } else {
                    result.constant += sum;
                }
                sum = 0;
                isPositive = true;
                isVariable = false;
                isNeedDispose = false;
                hasCoefficient = false;
            }
        }
        return result;
    }

    static class Equation {
        int constant;
        int coefficient;

        public Equation() {
        }

        public Equation(int constant, int coefficient) {
            this.constant = constant;
            this.coefficient = coefficient;
        }
    }
}
