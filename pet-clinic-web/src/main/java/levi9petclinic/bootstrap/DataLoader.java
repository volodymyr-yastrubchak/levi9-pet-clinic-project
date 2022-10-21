package levi9petclinic.bootstrap;

import levi9petclinic.model.Owner;
import levi9petclinic.model.Vet;
import levi9petclinic.services.OwnerService;
import levi9petclinic.services.PetService;
import levi9petclinic.services.VetService;
import levi9petclinic.services.map.OwnerServiceMap;
import levi9petclinic.services.map.PetServiceMap;
import levi9petclinic.services.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader() {
        ownerService = new OwnerServiceMap();
        vetService = new VetServiceMap();
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner = new Owner();
        owner.setId(1L);
        owner.setFirstName("Ivan");
        owner.setLastName("Tarantino");
        ownerService.save(owner);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Stepan");
        owner2.setLastName("Buratino");
        ownerService.save(owner2);

        System.out.println("Owners loaded");


        Vet vet = new Vet();
        vet.setId(1L);
        vet.setFirstName("Vesela");
        vet.setLastName("Veselka");
        vetService.save(vet);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Sum");
        vet2.setLastName("Sumnyi");
        vetService.save(vet2);

        System.out.println("Vet loaded");
    }
}
