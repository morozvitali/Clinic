package org.clinic;

import org.clinic.component.Application;
import java.util.Scanner;

public class Main {

    public static Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        Application application = new Application();
        application.run();
    }
}