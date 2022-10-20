package levi9petclinic.services;

import java.util.Set;
import levi9petclinic.model.Owner;

public interface OwnerService {

    Owner findByLastName(String lastName);

    Owner save(Owner owner);

    Owner findById(Long id);

    Set<Owner> findAll();

}
