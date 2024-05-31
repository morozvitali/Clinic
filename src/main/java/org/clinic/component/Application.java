package org.clinic.component;

public class Application {

    private final EntityRegister register = new EntityRegister();

    public void run() {
        if (Authenticator.auth()) {
            register.registerClients();
        }
    }
}