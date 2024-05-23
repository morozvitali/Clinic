package org.police.service;

import org.police.Main;
import org.police.model.Client;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ClientService {

    private static String EMAIL_PATTERN = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
    private static String NAME_PATTERN = "^[A-Z][a-z]*$";

    public Client registerNewClient() {
        Client client = null;

        System.out.println("Please provide a user details:");
        System.out.println("Email: ");
        String email = Main.SCANNER.nextLine();

        if (isEmailValide(email)) {
            client = buildClient(email);
            System.out.println("New client: "
                    + client.getFirstName() + " "
                    + client.getLastName() + " ("
                    + client.getEmail() + ")");
        } else {
            System.out.println("Provided email is invalid.");
        }
        return client;
    }


    private static Client buildClient(String email) {

        while (true){
            System.out.println("First name: ");
            String firstName = Main.SCANNER.nextLine();

            System.out.println("LastName: ");
            String lastName = Main.SCANNER.nextLine();

            if (isNameValide(firstName) && isNameValide(lastName)) {
                Client detective = new Client();
                detective.setEmail(email);
                detective.setFirstName(firstName);
                detective.setLastName(lastName);
                return detective;
            } else {
                System.out.println("Невірний формат імені, з великої літери без пробілів і тільки літери");
            }
        }
    }

    public static boolean isEmailValide(String email) {
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


