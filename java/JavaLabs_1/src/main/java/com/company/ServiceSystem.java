package com.company;

import java.util.Arrays;

public class ServiceSystem {
    private Сoefficient equation;

    public ServiceSystem() {

    }

    public void setEquation(Сoefficient equation) {
        this.equation = equation;
    }
    public Сoefficient  getEquation(){
        return equation;
    }
    public ServiceSystem(Сoefficient equation){ this.equation = equation;}




    public double[] getResultofEquation() {
        if (equation.getDiscriminant() < 0) {
            return new double[]{};
        }
        if (equation.getDiscriminant() == 0) {
            return new double[]{
                    getX1()
            };
        }
        if (equation.getA() == 0) {
            return new double[]{-equation.getC() / equation.getB()};
        }

        return new double[]{
                getX1(),
                getX2()
        };
    }

    private double getX1() {
        return (-equation.getB() + Math.sqrt(equation.getDiscriminant()))
                / (2 * equation.getA());
    }

    private double getX2() {
        return (-equation.getB() - Math.sqrt(equation.getDiscriminant()))
                / (2 * equation.getA());
    }


    @Override
    public String toString() {
        return equation +
                "Descriminant = " + equation.getDiscriminant() +
                "\nResult: " + Arrays.toString(getResultofEquation());
    }


}