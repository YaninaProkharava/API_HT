package org.example.petservicesteps;

import org.example.entities.Pet;
import org.example.service.PetService;

import java.util.List;

import static org.example.service.urltemplate.PetServiceUrl.*;

public class PetServiceSteps {

    private static final PetService PET_SERVICE = PetService.getInstance();

    public static Pet findPetById(long id) {
        return PET_SERVICE.getRequest(PET_BY_ID, id).as(Pet.class);
    }

    public static List<Pet> findPetsByStatus(String status) {
        return PET_SERVICE.getRequest(PET_BY_STATUS, status).jsonPath().getList("", Pet.class);

    }

    public static Pet addPet(Pet pet) {
        return PET_SERVICE.postRequest(ADD_PET, pet).as(Pet.class);
    }

    public static void deletePet(long id) {
        PET_SERVICE.deleteRequest(DELETE_PET, id);
    }
}
