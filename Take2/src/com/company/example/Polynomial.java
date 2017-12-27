package com.company.example;

public class Polynomial {

    // length of array being passed to create the Polynomial object
    private int length;
    private int[] coefficients = new int[length];

    public Polynomial(int[] array) {
        this.length = array.length;
        coefficients = array;
    }

    public void print() {

        for (int i = length - 1; i >=0 ; i--) {
            if (coefficients[i] == 0) {

                System.out.print("");

                // if coefficient[i] = 0 and the array is at index 0
                if (i == 0) {
                }

                else if (i == 1) {
                    System.out.print(coefficients[i] + "x");

                    if (coefficients[i-1] == 0) {
                    }

                    // if the next coefficient is negative, and if we're not at the beginning of the array
                    else if (coefficients[i-1] < 0 && i - 1 >= 0) {
                        System.out.print("");
                    }

                    // if the next coefficient is positive, and if we're not at the beginning of the array
                    else if (i - 1 >= 0) {
                        System.out.print("+");
                    }
                }

                // if the next coefficient is negative, and if we're not at the beginning or end of the array
                else if (coefficients[i-1] < 0 && i - 1 > 0 && i != coefficients.length - 1) {
                    System.out.print("");
                }

                // if the next coefficient is positive, and if we're not at the beginning or end of the array
                else if (i - 1 > 0 && i != coefficients.length - 1) {
                    System.out.print("+");
                }

                // if the next coefficient is 0 again
                else if (coefficients[i-1] == 0) {
                    System.out.print("");
                }
            }

            // for displaying the final coefficient without an 'x' or '^'
            else if (i == 0) {
                System.out.print(coefficients[i]);
            }

            // for when the exponent is 1 and we don't want to show it
            else if (i == 1) {
                System.out.print(coefficients[i] + "x");

                if (coefficients[i-1] == 0) {
                }

                // if the next coefficient is negative, and if we're not at the beginning of the array
                else if (coefficients[i-1] < 0 && i - 1 >= 0) {
                    System.out.print("");
                }

                // if the next coefficient is positive, and if we're not at the beginning of the array
                else if (i - 1 >= 0) {
                    System.out.print("+");
                }
            }

            // for all other normal coefficients
            else {
                System.out.print(coefficients[i] + "x^" + i);

                // if the next coefficient is positive and we're not at the beginning of the array
                if (coefficients[i-1] > 0 && i - 1 > 0) {
                    System.out.print("+");
                }

                // if the next coefficient is negative and we're not at the beginning of the array
                else if (coefficients[i-1] < 0 && i - 1 > 0) {
                    System.out.print("");
                }
            }

        }
    }

    public double evaluate(double x) {

        double sum = 0;

        // compute the value of the polynomial by adding up all the terms
        for (int i = length - 1; i >= 0 ; i--) {
            sum += coefficients[i] * Math.pow(x,i);
        }

        return sum;
    }

    public void getDerivative() {

        int[] derivative = new int[length-1];

        for (int i = length - 1; i > 0; i--) {
            derivative[i-1] = coefficients[i] * i;
        }

        Polynomial polynomial = new Polynomial(derivative);
        polynomial.print();
    }
}
