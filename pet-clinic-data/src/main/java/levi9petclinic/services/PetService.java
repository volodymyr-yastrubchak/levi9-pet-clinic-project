package levi9petclinic.services;

import java.util.Set;
import levi9petclinic.model.Pet;

public interface PetService {

    Pet save(Pet pet);

    Pet findById(Long id);

    Set<Pet> findAll();

}
