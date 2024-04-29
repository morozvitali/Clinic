package org.police;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    static String PASSWORD = "default";
    static Scanner SCANNER = new Scanner(System.in);
    static String EMAIL_PATTERN = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
    static String NAME_PATTERN = "^[A-Z][a-z]*$";


    public static void main(String[] args) {
        run();
    }

    static void run() {
        if (auth()) {
            registerNewClient();
        }
    }

    static void registerNewClient() {
        System.out.println("Please provide a clients details:");
        System.out.println("Email: ");
        String email = SCANNER.nextLine();
        if (isEmailValide(email)) {
            Client client = buildClient(email);
        System.out.println("New client: " + client.firstName + " " + client.lastName + " (" + client.email + ")");
        }
    }

    static Client buildClient(String email) {


        while (true){
            System.out.println("First name: ");
            String firstName = SCANNER.nextLine();

            System.out.println("LastName: ");
            String lastName = SCANNER.nextLine();

            if (isNameValide(firstName) && isNameValide(lastName)) {
                Client client = new Client();
                client.email = email;
                client.firstName = firstName;
                client.lastName = lastName;
                return client;
            } else {
                System.out.println("Невірний формат імені, з великої літери без пробілів і тільки літери");
            }


        }



    }

    static boolean auth() {
        boolean accepted = false;
        for (int i = 0; i < 3; i++) {
            System.out.println("Password ");
            String input = SCANNER.nextLine();
            if (PASSWORD.equals(input)) {
                accepted = true;
                break;
            } else {
                System.out.println("Accept denied. Please check your password");
            }
        }
        System.out.println(accepted ? "Welcome to the police" : "Application has been blocked");
        return accepted;
    }

    private static boolean isEmailValide(String email) {
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }


    private static boolean isNameValide(String name) {
        Pattern pattern = Pattern.compile(NAME_PATTERN);
        Matcher matcher = pattern.matcher(name);
        return matcher.matches();
    }
}
