package org.clinic.service;

import org.clinic.Main;
import org.clinic.model.Pet;
import org.clinic.model.Cat;
import org.clinic.model.Dog;

public class PetService {

    private static final String DOG_TYPE = "dog";
    private static final String CAT_TYPE = "cat";

    public Pet registerNewPet () {
        Pet pet = null;

        System.out.print("Type (dog / cat): ");
        String type = Main.SCANNER.nextLine();
        //pet.setType(type);

        if (DOG_TYPE.equals(type) || CAT_TYPE.equals(type)) {
            pet = buildPet(type);
        } else {
            System.out.println("Unknown pet type: " + type);
        }
        return pet;
    }

    private Pet buildPet(String type) {
        Pet pet = type.equals(CAT_TYPE) ? new Cat() : new Dog();
        pet.setType(type);
        System.out.print("Age: ");
        pet.setAge(Main.SCANNER.nextLine());
        System.out.print("Name: ");
        pet.setName(Main.SCANNER.nextLine());
        System.out.print("Sex (male / female): ");
        pet.setSex(Main.SCANNER.nextLine());

        if (type.equals(DOG_TYPE)) {
            System.out.print("Size (xS / S / M / L / xxL): ");
            ((Dog) pet).setSize(Main.SCANNER.nextLine());
        }

        return pet;
    }
}