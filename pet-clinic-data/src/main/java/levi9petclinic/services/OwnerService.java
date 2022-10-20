package levi9petclinic.services;

import java.util.Set;
import levi9petclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);

}
