package com.isa.section1.chapter2.exercises;

public class Exercise_1_2_16 {

    public static void main(String[] args) {
        Rational rational1 = new Rational(3, 4);
        Rational rational2 = new Rational(3, 5);
        Rational rational3 = new Rational(3, 4);
        System.out.println(rational1.plus(rational2));
        System.out.println(rational1.minus(rational2));
        System.out.println(rational1.times(rational2));
        System.out.println(rational1.divides(rational2));
        System.out.println(rational1.equals(rational2));
        System.out.println(rational1.equals(rational3));
        System.out.println(rational1.equals((Object) rational2));
        System.out.println(rational1.equals((Object) rational3));
    }


    private static class Rational {
        private final long numerator;
        private final long denominator;

        public Rational(long numerator, long denominator) {
            if (denominator == 0) {
                throw new IllegalArgumentException("Denominator cannot be 0");
            }

            long gcd = gcd(numerator, denominator);
            this.numerator = numerator / gcd;
            this.denominator = denominator / gcd;
        }

        public Rational plus(Rational rational) {
            long newNumerator = this.numerator * rational.denominator + rational.numerator * this.denominator;
            long newDenominator = this.denominator * rational.denominator;
            return new Rational(newNumerator, newDenominator);
        }

        public Rational minus(Rational rational) {
            long newNumerator = this.numerator * rational.denominator - rational.numerator * this.denominator;
            long newDenominator = this.denominator * rational.denominator;
            return new Rational(newNumerator, newDenominator);
        }

        public Rational times(Rational rational) {
            long newNumerator = this.numerator * rational.numerator;
            long newDenominator = this.denominator * rational.denominator;
            return new Rational(newNumerator, newDenominator);
        }

        public Rational divides(Rational rational) {
            long newNumerator = this.numerator * rational.denominator;
            long newDenominator = this.denominator * rational.numerator;
            return new Rational(newNumerator, newDenominator);
        }

        public boolean equals(Rational that) {
            if (this == that) {
                return true;
            }

            if (that == null) {
                return false;
            }

            if (this.numerator == that.numerator && this.denominator == that.denominator) {
                return true;
            }

            return false;
        }

        @Override
        public boolean equals(Object that) {
            if (this == that) {
                return true;
            }

            if (that == null) {
                return false;
            }

            if (getClass() != that.getClass()) {
                return false;
            }

            Rational thatRational = (Rational) that;
            if (this.numerator == thatRational.numerator && this.denominator == thatRational.denominator) {
                return true;
            }

            return false;
        }

        @Override
        public String toString() {
            return "Rational{" +
                    "numerator=" + numerator +
                    ", denominator=" + denominator +
                    '}';
        }

        private long gcd(long x, long y) {
            if (y == 0) {
                return x;
            } else {
                return gcd(y, x % y);
            }
        }
    }
}
