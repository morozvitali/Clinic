package org.clinic.component;

import org.clinic.model.Pet;
import org.clinic.model.Client;
import org.clinic.service.PetService;
import org.clinic.service.ClientService;

public class Application {

    private final ClientService clientService = new ClientService();
    private final PetService petService = new PetService();

    public void run() {
        if (Authenticator.auth()) {
            Client client = clientService. registerNewClient();

            if (client != null) {
                System.out.println("Adding a new Pet");

                Pet pet = petService.registerNewPet();
                if (pet != null){
                    client.setPet(pet);
                    pet.setOwnerName(client.getFirstName() + " " + client.getLastName());
                    System.out.println("Pet has been added.");
                }

                System.out.println(client);
            }
        }
    }
}

