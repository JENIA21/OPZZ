import java.util.Stack;

public class Calculator implements CalculatorInterf {

    @Override
    public String translate(String Expr) {
        StringBuilder present_time = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        int precedence;

        for (int i = 0; i < Expr.length(); i++) {

                precedence = priority(Expr.charAt(i));

                if (precedence == 0) present_time.append(Expr.charAt(i));
                if (precedence > 1) {
                    present_time.append(' ');

                    while (!stack.empty()) {
                        if (priority(stack.peek()) >= precedence) present_time.append(stack.pop());
                        else break;
                    }
                    stack.push(Expr.charAt(i));
                }

        }
        while (!stack.empty()) present_time.append(stack.pop());
        return present_time.toString();
    }
    @Override
    public double calculator(String rpn) {
        StringBuilder operand = new StringBuilder();
        Stack<Double> stack = new Stack<>();

        for (int i = 0; i < rpn.length(); i++) {

            if (rpn.charAt(i) == ' ') continue;

            if (priority(rpn.charAt(i)) == 0) {
                while (rpn.charAt(i) != ' ' && priority(rpn.charAt(i)) == 0) {
                    operand.append(rpn.charAt(i++));
                    if (i == rpn.length()) break;
                }
                stack.push(Double.parseDouble(operand.toString()));
                operand = new StringBuilder();

            }
            if (priority(rpn.charAt(i)) > 1) {
                double a = stack.pop(), b = stack.pop();

                if (rpn.charAt(i) == '+') stack.push(b + a);
                if (rpn.charAt(i) == '-') stack.push(b - a);
                if (rpn.charAt(i) == '*') stack.push(b * a);
                if (rpn.charAt(i) == '/') stack.push(b / a);
            }
        }
        return stack.pop();

    }

    @Override
    public int priority(char token) {
        if (token == '*' || token == '/') return 3;
        else if (token == '+' || token == '-') return 2;
        else return 0;
    }

    @Override
    public int сheck(String control) {
        StringBuilder present_time = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        int precedence;
        int counting_numbers = 0;
        int sign_count= 0;

        for (int i = 0; i < control.length(); i++) {

            precedence = priority(control.charAt(i));

            if (precedence == 0) counting_numbers += 1;
            if (precedence > 1) sign_count += 1;

        }

        if (counting_numbers == 0 || sign_count == 0 || counting_numbers != sign_count+1 || counting_numbers < sign_count) return 1;
        else return 0;

    }
}

