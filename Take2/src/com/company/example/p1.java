/*
* Author: Jake Edwards
* Date Started: August 4th, 2017
* Date Finished:
* Class: CSC 241-001
* Professor: Dr. Ivancic
*
* Purpose: A program that when provided a list of integers, delimited by commas, will print out a polynomial created using those numbers
*          as coefficients.  It will then prompt you to either evaluate the expression for a user provided x value, find
*          the derivative of the expression, or quit the program.
* */

package com.company.example;

import java.io.File;
import java.util.Scanner;

public class p1 {

    public static void main(String[] args) throws Exception{

        Polynomial polynomial = new Polynomial(getInput(args[0]));

        // console i/o stuff
        System.out.print("Your polynomial is: ");
        polynomial.print();


        boolean keepRunning = true;
        Scanner userInput = new Scanner(System.in);

        while (keepRunning) {
            // prompt user
            System.out.println("\nEnter Option:\n" +
                    "(E/e) Evaluate the Polynomial for a value of x\n" +
                    "(D/d) Get Derivative of the Polynomial\n" +
                    "(Q/q) Quit");

            // get user input
            String choice = userInput.next();

            // logic for decision making
            if (choice.equalsIgnoreCase("e")) {
                // evaluate
                System.out.print("Enter an x value to evaluate: ");
                double xNum = userInput.nextDouble();

                System.out.println("Evaluated polynomial = " + polynomial.evaluate(xNum));
            }
            else if (choice.equalsIgnoreCase("d")) {
                // derivative
                polynomial.getDerivative();
            }
            else if (choice.equalsIgnoreCase("q")) {
                // quit
                keepRunning = false;
            }
            else {
                // an incorrect choice was made
                System.out.println("Not a valid option.  Please choose one of the commands listed below.");
            }
        }


    }

    // gets input from the file selected and returns an array filled with the coefficient values from the file
    public static int[] getInput(String cmdArg) throws Exception{

        // file and input
        File file = new File("\"/home/courses/cs2411/ProgramFiles/" + cmdArg);
        Scanner fileInput = new Scanner(file);
        Scanner findFileLength = new Scanner(file);

        int sum = 0;
        int temp = 0;
        // determine size needed for array
        while (findFileLength.hasNext()) {
            temp = findFileLength.useDelimiter(",").nextInt();
            sum++;
        }

        // load input to an array that will be passed to the Polynomial constructor
        int[] tempArray = new int[sum];
        int n = 0;
        while (fileInput.hasNext()) {
            tempArray[n] = fileInput.useDelimiter(",").nextInt();
            n++;
        }

        return tempArray;
    } // end getInput()
}
