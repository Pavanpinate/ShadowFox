package shadowfox;
import java.util.Scanner;

public class ConsolebasedCalculator {

	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        int choice;

	        do {
	            System.out.println("\nEnhanced Calculator Menu:");
	            System.out.println("1. Basic Arithmetic");
	            System.out.println("2. Scientific Calculations");
	            System.out.println("3. Unit Conversions");
	            System.out.println("4. Exit");
	            System.out.print("Select an option: ");
	            choice = scanner.nextInt();

	            switch (choice) {
	                case 1:
	                    basicArithmetic(scanner);
	                    break;
	                case 2:
	                    scientificCalculations(scanner);
	                    break;
	                case 3:
	                    unitConversions(scanner);
	                    break;
	                case 4:
	                    System.out.println("Exiting the calculator. Goodbye!");
	                    break;
	                default:
	                    System.out.println("Invalid choice. Please try again.");
	            }
	        } while (choice != 4);
	    }

	    private static void basicArithmetic(Scanner scanner) {
	        System.out.print("Enter first number: ");
	        double num1 = scanner.nextDouble();
	        System.out.print("Enter second number: ");
	        double num2 = scanner.nextDouble();

	        System.out.println("Select operation:");
	        System.out.println("1. Addition");
	        System.out.println("2. Subtraction");
	        System.out.println("3. Multiplication");
	        System.out.println("4. Division");

	        int operation = scanner.nextInt();
	        double result = 0;

	        switch (operation) {
	            case 1:
	                result = num1 + num2;
	                break;
	            case 2:
	                result = num1 - num2;
	                break;
	            case 3:
	                result = num1 * num2;
	                break;
	            case 4:
	                if (num2 != 0) {
	                    result = num1 / num2;
	                } else {
	                    System.out.println("Error: Division by zero is undefined.");
	                    return;
	                }
	                break;
	            default:
	                System.out.println("Invalid operation.");
	                return;
	        }
	        System.out.println("Result: " + result);
	    }

	    private static void scientificCalculations(Scanner scanner) {
	        System.out.println("Select scientific operation:");
	        System.out.println("1. Square Root");
	        System.out.println("2. Exponentiation");

	        int operation = scanner.nextInt();
	        double result = 0;

	        switch (operation) {
	            case 1:
	                System.out.print("Enter number: ");
	                double num = scanner.nextDouble();
	                if (num < 0) {
	                    System.out.println("Error: Square root of negative number is undefined.");
	                } else {
	                    result = Math.sqrt(num);
	                    System.out.println("Result: " + result);
	                }
	                break;
	            case 2:
	                System.out.print("Enter base: ");
	                double base = scanner.nextDouble();
	                System.out.print("Enter exponent: ");
	                double exponent = scanner.nextDouble();
	                result = Math.pow(base, exponent);
	                System.out.println("Result: " + result);
	                break;
	            default:
	                System.out.println("Invalid operation.");
	        }
	    }

	    private static void unitConversions(Scanner scanner) {
	        System.out.println("Select conversion type:");
	        System.out.println("1. Temperature (Celsius to Fahrenheit)");
	        System.out.println("2. Currency (USD to EUR)");

	        int conversionType = scanner.nextInt();

	        switch (conversionType) {
	            case 1:
	                System.out.print("Enter temperature in Celsius: ");
	                double celsius = scanner.nextDouble();
	                double fahrenheit = (celsius * 9/5) + 32;
	                System.out.println("Temperature in Fahrenheit: " + fahrenheit);
	                break;
	            case 2:
	                System.out.print("Enter amount in USD: ");
	                double usd = scanner.nextDouble();
	                double eur = usd * 0.85; // Example conversion rate
	                System.out.println("Amount in EUR: " + eur);
	                break;
	            default:
	                System.out.println("Invalid conversion type.");
	        }
	    }
	}

