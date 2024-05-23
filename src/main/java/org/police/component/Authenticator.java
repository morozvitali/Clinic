package org.police.component;

import org.police.Main;

public class Authenticator {
    private static String PASSWORD = "d";
    //static Scanner SCANNER = new Scanner(System.in);


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
        System.out.println(accepted ? "Welcome to the police" : "Application has been blocked");
        return accepted;
    }
}

