public class Fraction {

    private int numerator;
    private int denominator;

    public Fraction(int num, int den) {
        if (den == 0) {
            throw new IllegalArgumentException();
        }

        if (den < 0) {
            this.numerator = num * -1;
            this.denominator = den * -1;
        } else {
            this.numerator = num;
            this.denominator = den;
        }
    }

    public Fraction(int num) {
        this.numerator = num;
        this.denominator = 1;
    }

    public Fraction() {
        this.numerator = 0;
        this.denominator = 1;
    }

    public int getNumerator() {
        return this.numerator;
    }

    public int getDenominator() {
        return this.denominator;
    }

    public String toString() {
        toLowestTerms();
        if (denominator == 1) {
            return Integer.toString(numerator);
        }
        if (numerator == 0) {
            return Integer.toString(numerator);
        }
        return numerator + "/" + denominator;
    }

    public double toDouble() {
        double num = numerator;
        double den = denominator;
        return num / den;
    }

    public Fraction add(Fraction other) {

        int den = denominator;

        this.denominator *= other.denominator;
        this.numerator *= other.denominator;

        other.denominator *= den;
        other.numerator *= den;

        int sum = this.numerator + other.numerator;

        return new Fraction(sum, this.denominator);
    }

    public Fraction subtract(Fraction other) {
        int den = this.denominator;

        this.denominator *= other.denominator;
        this.numerator *= other.denominator;

        other.denominator *= den;
        other.numerator *= den;

        int diff = this.numerator - other.numerator;
        System.out.println(diff);
        return new Fraction(diff, this.denominator);
    }

    public Fraction multiply(Fraction other) {

        int productNum = this.numerator * other.numerator;
        int productDen = this.denominator * other.denominator;

        return new Fraction(productNum, productDen);
    }

    public Fraction divide(Fraction other) {
        int quotientNum = this.numerator * other.denominator;
        int quotientDen = this.denominator * other.numerator;

        if (quotientDen == 0) {
            throw new IllegalArgumentException();
        }

        return new Fraction(quotientNum, quotientDen);
    }

    public boolean equals(Object other) {
        Fraction otherFrac = (Fraction) other;
        this.toLowestTerms();
        otherFrac.toLowestTerms();
        System.out.println(this.numerator+"");
        System.out.println(otherFrac.numerator+"");
        return (this.numerator == otherFrac.numerator && this.denominator == otherFrac.denominator);
    }

    public void toLowestTerms() {
        if (this.numerator != 0) {
            int gcd = gcd(this.numerator, this.denominator);

            if (this.denominator < 0) {
                this.numerator *= -1;
                this.denominator *= -1;
            }

            this.numerator /= gcd;
            this.denominator /= gcd;
        }
    }

    public int gcd(int a, int b) {

        while (a != 0 && b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }

        return a;
    }
}
