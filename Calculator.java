import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Calculator {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean sessionDone = false;

        while (!sessionDone) {
            System.out.println("Choose an operation:\n" +
                    "1: +\n" +
                    "2: -\n" +
                    "3: *\n" +
                    "4: /");

            if (!scanner.hasNextInt()) {
                System.out.println("Please input a valid number.");
                scanner.next();
                continue;
            }

            int inputInt = scanner.nextInt();

            if (inputInt > 4) {
                System.out.println("Please input a valid number.");
                continue;
            }

            int _operation = inputInt;
            System.out.println("Operation: " + _operation);

            System.out.println("Enter the number of terms you want to calculate");

            CheckInt();

            int numOfTerms = scanner.nextInt();

            if (numOfTerms < 1)
                continue;

            System.out.println("Enter the numbers one after the other.");

            List<Double> _numbers = new ArrayList<Double>();

            while (numOfTerms > 0) {
                CheckDouble();
                double numInput = scanner.nextDouble();
                _numbers.add(numInput);
                numOfTerms--;
            }

            double _answer = Calculate(_numbers, _operation);
            System.out.println("The answer is: " + _answer);
        }
    }

    private static double Calculate(List<Double> numbers, int operation) {
        double runningAnswer = numbers.get(0);

        for (int i = 0; i < numbers.size() - 1; i++) {

            switch (operation) {
                case 1:
                    runningAnswer = Add(runningAnswer, numbers.get(i + 1));
                    break;
                case 2:
                    runningAnswer = Subtract(runningAnswer, numbers.get(i + 1));
                    break;
                case 3:
                    runningAnswer = Multiply(runningAnswer, numbers.get(i + 1));
                    break;
                case 4:
                    runningAnswer = Divide(runningAnswer, numbers.get(i + 1));
                    break;
                default:
                    break;
            }
        }
        return runningAnswer;
    }

    private static double Add(double a, double b) {
        return a + b;
    }

    private static double Subtract(double a, double b) {
        return a - b;
    }

    private static double Multiply(double a, double b) {
        return a * b;
    }

    private static double Divide(double a, double b) {
        return a / b;
    }

    private static void CheckDouble() {
        while (true) {
            if (scanner.hasNextDouble())
                break;

            System.out.println("Please input an actual number.");
            scanner.next();
            continue;
        }
    }

    private static void CheckInt() {
        while (true) {
            if (scanner.hasNextInt())
                break;

            System.out.println("Please input a valid number.");
            scanner.next();
            continue;
        }
    }
}