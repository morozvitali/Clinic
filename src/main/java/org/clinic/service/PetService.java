package org.clinic.service;

import org.clinic.Main;
import org.clinic.model.Pet;
import org.clinic.model.Dog;

public class PetService {

    private static final String DOG_TYPE = "dog";

    public Pet registerNewPet () {
        Pet pet = new Pet();
        System.out.println("Type (dog / cat / other): ");
        String type = Main.SCANNER.nextLine();
        pet.setType(type);

        if (DOG_TYPE.equals(type)) {
            pet = buildDog();
        } else {
            pet = buildPet(type);
        }
        return pet;
    }

    private Dog buildDog() {
        Pet pet = buildPet(DOG_TYPE);
        Dog dog= petToDog(pet);

        System.out.println("Size ( xS / S / M / L / xxL): ");
        dog.setBank(Main.SCANNER.nextLine());

        return dog;
    }

    private Dog petToDog(Pet pet) {
        Dog dog = new Dog();

        dog.setType(pet.getType());
        dog.setName(pet.getName());
        dog.setAge(pet.getAge());
        dog.setSex(pet.getSex());
        dog.setOwnerName(pet.getOwnerName());

        return dog;
    }


    private Pet buildPet (String type) {
        Pet pet = new Pet();
        pet.setType(type);

        System.out.println("Name: ");
        pet.setName (Main.SCANNER.nextLine());

        System.out.println("Age: ");
        pet.setAge(Main.SCANNER.nextLine());

        System.out.println("Sex: (male / female)");
        pet.setSex(Main.SCANNER.nextLine());

        System.out.println("Owner: (who owner)");
        pet.setOwnerName(Main.SCANNER.nextLine());

        return pet;
    }
}