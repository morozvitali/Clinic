package org.police.component;

import org.police.model.Pet;
import org.police.model.Client;
import org.police.service.PetService;
import org.police.service.ClientService;

public class Application {

    private ClientService clientService = new ClientService();
    private PetService petService = new PetService();
    public void run() {
        if (Authenticator.auth()) {
            Client client = clientService. registerNewClient();

            if (client != null) {
                System.out.println("Adding a new Pet");

                Pet pet = petService.registerNewPet();
                client.setPet(pet);
                pet.setOwnerName(client.getFirstName() + " " + client.getLastName());

                System.out.println("Pet has been added ");
            }
        }
    }
}

