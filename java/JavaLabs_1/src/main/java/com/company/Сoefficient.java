package com.company;

public class Сoefficient {
        private double A;
        private double B;
        private double C;

    public Сoefficient() {

    }


    public double getA(){
            return A;
        }
        public double getB(){
        return B;
        }
        public double getC(){
        return C;
        }

        public void setA(double a) {
        A = a;
        }
        public void setB(double b) {
        B = b;
        }
        public void setC(double c) {
        C = c;
        }

        public Сoefficient(double a, double b, double c){
            A = a;
            B = b;
            C = c;
        }

        public double getDiscriminant(){
            return (B * B- 4.0 * A * C);
        }

    @Override
        public String toString() {
            return "QuadraticEquation = {" +
                    A + "x^2 + " + B + "x + " + C +
                    '}';
        }


}



