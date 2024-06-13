package org.clinic.service;

import org.clinic.Main;
import org.clinic.model.Client;
import org.clinic.model.Client.Location;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ClientService {
    private static final String EMAIL_PATTERN = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";

    public Client registerNewClient() {
        Client client = null;
        System.out.println("Please provide client details.");
        System.out.print("Email: ");
        String email = Main.SCANNER.nextLine();
        if (isEmailValid(email)) {
            client = buildClient(email);
            System.out.println("New client: " + client.getFirstName() + " "
                    + client.getLastName() + " ("
                    + client.getEmail() + ")");
        } else {
            System.out.println("Provided email is invalid.");
        }
        return client;
    }

    private Client buildClient(String email) {
        Client client = new Client();
        client.setEmail(email);
        System.out.print("First name: ");
        client.setFirstName(Main.SCANNER.nextLine());
        System.out.print("Last name: ");
        client.setLastName(Main.SCANNER.nextLine());

        Location location;
        do {
            System.out.print("Location (KYIV, LVIV, ODESA): ");
            String locationStr = Main.SCANNER.nextLine();
            location = Location.fromString(locationStr);
            if (location == null) {
                System.out.println("Unknown location. Please try again.");
            }
        } while (location == null);

        client.setLocation(location);

        return client;
    }

    private boolean isEmailValid(String email) {
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
