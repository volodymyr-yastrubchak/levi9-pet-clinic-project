package levi9petclinic.services;

import java.util.Set;
import levi9petclinic.model.Vet;

public interface VetService {

    Vet save(Vet vet);

    Vet findById(Long id);

    Set<Vet> findAll();

}
