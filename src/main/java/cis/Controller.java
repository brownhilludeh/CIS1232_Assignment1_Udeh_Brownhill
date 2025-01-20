package cis;

import cis.util.CisUtility;

import java.util.Scanner;

/**
 * Student Averages
 *
 * @author cis1232
 * @since 20250110
 */
public class Controller {

    public static final int EXIT = 0;
    public static final int INVALID = -1;

    public static final String MENU = "1) Show Student Averages" + System.lineSeparator()
            + "2) Lookup a student" + System.lineSeparator()
            + "3) Show theory grade" + System.lineSeparator()
            + "4) Show theory grade backwards" + System.lineSeparator()
            + "5) Show average of theory grades" + System.lineSeparator()
            + "6) Show highest grades of theory" + System.lineSeparator()
            + "7) Student name with highest theory grade" + System.lineSeparator()
            + EXIT + ") Exit"
            + System.lineSeparator();

    public static final String MESSAGE_ERROR = "Error";
    public static final String MESSAGE_EXIT = "Goodbye";
    public static final String MESSAGE_SUCCESS = "Success";

    private static String[] names = {"Joel", "Logan", "Soroush", "Victor"};
    private static int[] assignmentGrades = {90, 88, 75, 40};
    private static int[] theoryGrades = {98, 60, 80, 90};
    private static int[] practicalGrades = {32, 85, 80, 90};

    public static void main(String[] args) {

        for (String current : names) {
            System.out.println(current);
        }

        int menuOption;

        do {
            menuOption = CisUtility.getInputInt(MENU);

            switch (menuOption) {
                case EXIT:
                    System.out.println(MESSAGE_EXIT);
                    break; //Break out of the loop as we're finished.
                case 1:
                    showStudentAverages();
                    break;
                case 2:
                    String name = CisUtility.getInputString("Enter name to find");
                    double average = lookupAStudent(name);
                    if (average == INVALID) {
                        System.out.println("Invalid name");
                    } else {
                        System.out.println(name + "'s average is " + average);
                    }
                    break;
                case 3:
                    showTheoryGrades();
                    break;
                case 4:
                    showTheoryGradesBackwards();
                    break;
                case 5:
                    showTheoryGradesAverage();
                    break;
                case 6:
                    showTheoryHighestGrades();
                    break;
                case 7:
                    showHighestGradeStudentName();
                    break;
                default:
                    System.out.println(MESSAGE_ERROR);
                    break;
            }
        } while (menuOption != EXIT);
    }

    /**
     * Show Student with Highest Grade
     * Assignment 1
     *
     * @author BrownhillUDEH
     * @since 20250115
     */
    private static void showHighestGradeStudentName() {
        int highestGrade = -1;
        int location = 0;

        for (int i = 0; i < theoryGrades.length; i++) {
            if (theoryGrades[i] > highestGrade) {
                highestGrade = theoryGrades[i];
                location = i;
            }
        }
        System.out.println("The highest theory grades student's name is " + names[location] + " with score of " + highestGrade);
    }

    /**
     * Show Theory Highest Grades
     * Assignment 1
     *
     * @author BrownhillUDEH
     * @since 20250115
     */
    private static void showTheoryHighestGrades() {
        int highestGrade = -1;
//        int max = 0;

        for (int i = 0; i < theoryGrades.length; i++) {
            if (theoryGrades[i] > highestGrade) {
                highestGrade = theoryGrades[i];
//                max = i + 1;
            }
        }
        System.out.println("The highest grade from the values in the theory grades is " + highestGrade);
    }


    /**
     * Show Theory Grades Average
     * Assignment 1
     *
     * @author BrownhillUDEH
     * @since 20250115
     */
    private static void showTheoryGradesAverage() {
        System.out.println("Average Score of theory grades");

        int total = 0;
        for (int current : theoryGrades) {
            System.out.println(current);
            total += current;
        }

//        Average Calculation
        double average = (double) total / theoryGrades.length;
        System.out.println("Theory average is " + average);
    }

    /**
     * Show Theory Grades
     * Assignment 1
     *
     * @author BrownhillUDEH
     * @since 20250115
     */
    private static void showTheoryGrades() {
        System.out.println("Here are the theory grades");
        for (int i = 0; i < names.length; i++) {
            int theoryGrade = theoryGrades[i];
            System.out.println(names[i] + "'s grades is " + theoryGrade);
        }
        System.out.println("");
    }

    /**
     * Show Theory Grades Reversed
     * Assignment 1
     *
     * @author BrownhillUDEH
     * @since 20250115
     */
    private static void showTheoryGradesBackwards() {
        System.out.println("Here are the theory grades backwards");
        for (int theoryGrade : theoryGrades) {
            System.out.print(theoryGrade + " ");
        }
        System.out.println("");

        System.out.println("Showing grades backwards");
        for (int i = theoryGrades.length - 1; i >= 0; i--) {
            System.out.println(names[i] + "'s grades is " + theoryGrades[i]);
        }

        System.out.println(" ");
    }


    /**
     * Show Student Averages
     * Assignment 1
     *
     * @author BJM
     * @since 20230111
     */
    public static void showStudentAverages() {
        System.out.println("Here are the averages");

        for (int counter = 0; counter < names.length; counter++) {

            double average = getAverage(counter);
            System.out.println(names[counter] + "'s average is " + average);

        }

        System.out.println("");

    }

    /**
     * Get average for the given index
     *
     * @author CIS1232AB
     * @since 20230116
     */
    public static double getAverage(int index) {
        double average = (assignmentGrades[index] + theoryGrades[index] + practicalGrades[index]) / 3.0;
        return average;
    }

    /**
     * Lookup a student and give their average
     *
     * @param name Name to find
     * @return The student's average of INVALID if not found
     * @author You Guys
     * @since 20230111
     */
    public static double lookupAStudent(String name) {

        int counter = 0;
        boolean foundName = false;
        for (counter = 0; counter < names.length; counter++) {

            if (names[counter].equalsIgnoreCase(name)) {
                foundName = true;
                break;
            }
        }

        if (counter == names.length) {
            return INVALID;
        } else {
            return getAverage(counter);
        }
    }

    /**
     * Display student details at the given index
     *
     * @param index Index to use
     * @author CIS1232AB
     * @since 20230116
     */
    public static void display(int index) {
        String output = "Student details" + System.lineSeparator()
                + "Name: " + names[index] + System.lineSeparator()
                + "Assignments: " + assignmentGrades[index] + System.lineSeparator()
                + "Theory: " + theoryGrades[index] + System.lineSeparator()
                + "Practical: " + practicalGrades[index] + System.lineSeparator()
                + "Average: " + getAverage(index) + System.lineSeparator();
    }

}
