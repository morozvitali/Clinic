package org.clinic.component;

import org.clinic.Main;

public class Authenticator {
    private static final String PASSWORD = "d";

    public static boolean auth() {
        boolean accepted = false;
        for (int i = 0; i < 3; i++) {
            System.out.println("Password ");
            String input = Main.SCANNER.nextLine();
            if (PASSWORD.equals(input)) {
                accepted = true;
                break;
            } else {
                System.out.println("Accept denied. Please check your password");
            }
        }
        System.out.println(accepted ? "Welcome to the clinic" : "Application has been blocked");
        return accepted;
    }
}

