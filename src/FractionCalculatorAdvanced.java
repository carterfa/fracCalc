import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class FractionCalculatorAdvanced {
    public static void main(String[] args) {
        System.out.println("\\\\\\Welcome to Fraction Calculator/// \n This program can add, subtract, multiply, and divide fractions. Type Q to quit. \nPlease enter your fractions in the form 'a/b', where a and b are integers.");
        Scanner input = new Scanner(System.in);
        while (true) {
            String[] exp = getExpression(input);

            if (exp[0].equals("q")) {
                break;
            }

            while (true) {
                String o = exp[1];
                String aStr = exp[0];
                String bStr = exp[2];

                if (!validOperation(o) || !validFraction(aStr) || !validFraction(bStr)) {
                    break;
                }

                Fraction a = getFraction(exp[0]);
                Fraction b = getFraction(exp[2]);

                if (o.equals("/") && b.getNumerator() == 0) {
                    System.out.println("You can't divide by zero!");
                    break;
                }

                String result = getResult(a, b, o);

                System.out.println(aStr + " " + o + " " + bStr + " = " + result);
                break;
            }
        }
    }

    public static String[] getExpression(Scanner input) {
        while (true) {
            System.out.print("Please enter an expression in the format: [fraction] [+,-,*,/,=] [fraction] or Q to quit:");
            String expStr = input.nextLine().trim().toLowerCase();

            if (expStr.equals("q")) {
                return new String[]{"q"};
            }

            String[] exp = expStr.split(" ", 5);

            if (exp.length == 3) {
                return exp;
            }

            System.out.println("Not a valid expression");
        }
    }

    public static boolean validOperation(String input) {
        if (input.matches("[+\\-*/=]")) {
            return true;
        }
        System.out.println("Not a valid operation");
        return false;
    }

    public static boolean validFraction(String input) {

        if (input.matches("(([0-9]+)+/+([1-9]+))|((-[0-9]+)+/+([1-9]+))")) {
            return true;
        } else if (input.matches("(^[0-9]{1,})|(^-[0-9]{1,})")) {
            return true;
        }

        System.out.println("Not a valid fraction.");
        return false;
    }

    public static String getResult(Fraction a, Fraction b, String o) {
        String result = "";
        switch (o) {
            case "+" -> {
                Fraction r = a.add(b);
                r.toLowestTerms();
                result = r.toString();
            }
            case "-" -> {
                Fraction r = a.subtract(b);
                r.toLowestTerms();
                result = r.toString();
            }
            case "*" -> {
                Fraction r = a.multiply(b);
                r.toLowestTerms();
                result = r.toString();
            }
            case "/" -> {
                Fraction r = a.divide(b);
                r.toLowestTerms();
                result = r.toString();
            }
            case "=" -> {
                boolean r = a.equals(b);
                result = Boolean.toString(r);
            }
            default -> System.out.println("Operation not recognized.");

        }
        return result;
    }

    public static Fraction getFraction(String str) {

        int idx = str.indexOf("/");

        if (idx > -1) {
            int a = parseInt(str.substring(0, idx));
            int b = parseInt(str.substring(idx + 1));
            return new Fraction(a, b);
        }

        return new Fraction(parseInt(str));

    }
}

