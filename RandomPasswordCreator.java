import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import static java.util.Collections.shuffle;

public class RandomPasswordCreator {
    public static Scanner scanner = new Scanner(System.in);
    public static int digitLong;
    public static String answer;
    public static String characters;
    public static String password;
    public static final String lower = "abcdefghijklmnopqrstuvwxyz";
    public static final String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String digits = "0123456789";
    public static final String punctuation = "!@#$%&*()_+-=[]|,./?><";
    public static String returnMenu;


    public static void main(String[]args) {
        System.out.println("\n=====\tRANDOM PASSWORD CREATOR\t=====");
        setCharacters();

        String output = generateRandomString(digitLong);
        System.out.println("\nPassword:\n"+output);

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (java.lang.InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("\nDo you want to return to the main menu? (Y/N)");
        returnMenu = scanner.nextLine();

        if (returnMenu.equalsIgnoreCase("Y")) {
            Main.main(args);
        }
        else if (returnMenu.equalsIgnoreCase("N")) {
            Main.exit();
        }
        else {
            System.out.println(Main.e1);
        }
    }
    public static void setCharacters () {
        System.out.println("\n(Recommended minimum 8)\nHow many character do you need?");
        digitLong = scanner.nextInt();
        scanner.nextLine();

        System.out.println("\n(Recommended)\nDo you want to use UPPERCASE: (Y/N)\t\t"+upper);
        answer=scanner.nextLine();
        if (answer.equalsIgnoreCase("Y")) {
            characters=characters+upper;
        }
        if (answer.equalsIgnoreCase("N")){}

        System.out.println("\n(Recommended)\nDo you want to use LOWERCASE: (Y/N)\t\t"+lower);
        answer=scanner.nextLine();
        if (answer.equalsIgnoreCase("Y")){
            characters=characters+lower;
        }
        if (answer.equalsIgnoreCase("N")){}

        System.out.println("\n(Recommended)\nDo you want to use DIGIT: (Y/N)\t\t\t"+digits);
        answer=scanner.nextLine();
        if (answer.equalsIgnoreCase("Y")) {
            characters=characters+digits;
        }
        if (answer.equalsIgnoreCase("N")){}

        System.out.println("\n(Recommended)\nDo you want to use PUNCTUATION: (Y/N)\t"+ punctuation);
        answer=scanner.nextLine();
        if (answer.equalsIgnoreCase("Y")) {
            characters=characters+punctuation;
        }
        if (answer.equalsIgnoreCase("N")){}

        System.out.println("\n\nYour elements:\n"+characters);


    }
    public static String generateRandomString(int length) {
        String password = characters;
        StringBuilder sb = new StringBuilder();

        Random rand = new Random();
        for (int i = 0; i < length; i++) {
            int randomIndex = rand.nextInt(password.length());
            char randomChar = password.charAt(randomIndex);
            sb.append(randomChar);
        }

        return sb.toString();
    }


}