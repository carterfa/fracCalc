import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class FractionCalculatorAdvanced {
    public static void main(String[] args) {
        System.out.println("\\\\\\Welcome to Fraction Calculator/// \n This program can add, subtract, multiply, and divide fractions. Type Q to quit. \nPlease enter your fractions in the form 'a/b', where a and b are integers.");
        Scanner input = new Scanner(System.in);
        while (true){
            String o = getOperation(input);
            if (o.equals("q")){break;}
            Fraction a = getFraction(input);
            Fraction b = getFraction(input);
            if (o.equals("/") && b.getNumerator() == 0){
                System.out.println("You can't divide by zero!");
                b = getFraction(input);
            }
            String aStr = a.toString();
            String bStr = b.toString();
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
            System.out.println(aStr+" "+o+" "+bStr+" = " +result);
        }
    }

        public static String getOperation(Scanner input){
            while (true) {
                System.out.print("Please enter an operation (+,-,*,/,=) or Q to quit:");
                String operation = input.nextLine().trim().toLowerCase();
                if (operation.matches("[+\\-*/=q]")) {
                    return operation;
                }
                System.out.println("Not a valid operation");
            }
        }

        public static void parseEquation(String str){

        }

        public static boolean validFraction(String input){

        if (input.matches("(([0-9]+)+/+([1-9]+))|((-[0-9]+)+/+([1-9]+))")) {
            return true;
        }else if (input.matches("(^[0-9]{1,})|(^-[0-9]{1,})")){
            return true;
        }

        System.out.println("Not a valid fraction.");
        return false;
        }

        public static Fraction getFraction(Scanner input){
        System.out.println("Please enter a fraction (a/b) or integer (a).");
        String str = input.nextLine().trim().toLowerCase();

        while(!validFraction(str)){
            str = input.nextLine().trim().toLowerCase();
        }

        int idx = str.indexOf("/");

        if (idx > -1){
            int a = parseInt(str.substring(0,idx));
            int b = parseInt(str.substring(idx+1));
            return new Fraction(a,b);
        }

        return new Fraction(parseInt(str));
        }

}
