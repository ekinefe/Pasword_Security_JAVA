import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class PasswordCheck {
    private static Scanner scanner = new Scanner(System.in);
    private String password;
    private String returnMenu;
    private int secureScore = 0;
    private boolean hasLowerCase = false;
    private boolean hasUpperCase = false;
    private boolean hasDigit = false;
    private boolean hasSpecialChar = false;

    public static void main(String[] args) {

        System.out.println("\n=====\tPassword check\t=====");
        System.out.println("\nThis program will check how secure your password is.");
        PasswordCheck passwordChecker = new PasswordCheck();
        passwordChecker.run();
    }

    public void run() {
        System.out.print("\nPlease enter your password:\t");
        password = scanner.nextLine();
        System.out.println();

        if (password.length() >= 8) {
            System.out.println("Password length >= 8\t+1P");
            secureScore += 1;
        }

        for (char x : password.toCharArray()) {
            if (Character.isLowerCase(x) && !hasLowerCase) {
                System.out.println("Lowercase letter used\t+1P");
                secureScore += 1;
                hasLowerCase = true;
            } else if (Character.isUpperCase(x) && !hasUpperCase) {
                System.out.println("Uppercase letter used\t+1P");
                secureScore += 1;
                hasUpperCase = true;
            } else if (Character.isDigit(x) && !hasDigit) {
                System.out.println("Number used\t\t\t\t+1P");
                secureScore += 1;
                hasDigit = true;
            } else if (!Character.isLetterOrDigit(x) && !hasSpecialChar) {
                System.out.println("Special character used\t+1P");
                secureScore += 1;
                hasSpecialChar = true;
            }
        }

        System.out.println("Your password secure score "+secureScore+" out of 5"+"\n\t("+secureScore+"/5)");

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("\n\nDo you want to return to the main menu? (Y/N)");
        returnMenu = scanner.nextLine();

        if (returnMenu.equalsIgnoreCase("Y")) {
            Main.main(null);
        } else if (returnMenu.equalsIgnoreCase("N")) {
            Main.exit();
        } else {
            System.out.println(Main.e1);
        }
    }
}
