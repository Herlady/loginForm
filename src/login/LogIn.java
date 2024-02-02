package login;
import java.util.Scanner;

public class LogIn {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int maxAttempts = 3;

        for (int attempts = 1; attempts <= maxAttempts; attempts++) {
            System.out.print("Enter your username: ");
            String username = scanner.nextLine();

            System.out.print("Enter your password: ");
            String password = scanner.nextLine();
            String maskedPassword = maskPassword(password);

            if (validateLogin(username, password)) {
                System.out.println("Login successful!");
                break;
            } else {
                System.out.println("Invalid username or password. Attempts left: " + (maxAttempts - attempts));
                System.out.println("Masked Password: " + maskedPassword);
                if (attempts < maxAttempts) {
                    System.out.println("Please try again.");
                } else {
                    System.out.println("Maximum login attempts reached. Account locked.");
                }
            }
        }

        scanner.close();
    }

    private static boolean validateLogin(String enteredUsername, String enteredPassword) {
        // Replace this with your actual validation logic
        String validUsername = "Dee";
        String validPassword = "134";

        return enteredUsername.equals(validUsername) && enteredPassword.equals(validPassword);
    }

    private static String maskPassword(String password) {
        char[] passwordChars = password.toCharArray();
        StringBuilder maskedPassword = new StringBuilder();

        for (char c : passwordChars) {
            maskedPassword.append('*');
        }

        return maskedPassword.toString();
    }
}