package org.example;

import org.example.entities.Category;
import org.example.entities.Pet;
import org.example.entities.Tag;
import org.example.petservicesteps.PetServiceSteps;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Random;

public class PetStoreTest {
    @Test
    public void addNewPetTest(){
        Pet expectedPet = createPet();
        Pet createdPet = PetServiceSteps.addPet(expectedPet);
        Assert.assertEquals(expectedPet.getName(), createdPet.getName(), "Expected pet doesn't have a correct name");
    }

    @Test
    public void getPetsByStatusTest(){
        String expectedStatus = "available";
        var pets = PetServiceSteps.findPetsByStatus(expectedStatus);
        Assert.assertTrue(pets.stream().allMatch(i -> i.getStatus().equals(expectedStatus)),
                "Actual status doesn't match the expected status for some pets");
    }

    @Test
    public void getPetById(){
        int expectedId = 9;
        Pet pet = PetServiceSteps.findPetById(expectedId);
        Assert.assertEquals(expectedId, pet.getId(),
                "Actual id doesn't match the expected id");
    }
    private Category createCategory() {
        Random random = new Random();
        return new Category()
                .setId(random.nextInt())
                .setName("category" + random.nextInt());
    }

    @Test
    public void deletePet(){
        Pet newPet = PetServiceSteps.addPet(createPet());
        PetServiceSteps.deletePet(newPet.getId());
        List<Pet> pets = PetServiceSteps.findPetsByStatus(newPet.getStatus());
        Assert.assertFalse(pets.contains(newPet), "Pet hasn't been deleted!");
    }

    private Pet createPet() {
        Random random = new Random();
        String[]photoUrls = new String[1];
        photoUrls[0] = "photo.com";
        Tag tag = new Tag().setId(0).setName("dogTag");
        Tag[]tags = new Tag[1];
        tags[0] = tag;
        return new Pet()
                .setId(0)
                .setCategory(createCategory())
                .setName("Doggie" + random.nextInt())
                .setPhotoUrls(photoUrls)
                .setTags(tags)
                .setStatus("available");
    }


}
