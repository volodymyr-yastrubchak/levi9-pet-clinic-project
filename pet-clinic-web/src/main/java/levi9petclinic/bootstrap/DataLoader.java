package levi9petclinic.bootstrap;

import levi9petclinic.model.Owner;
import levi9petclinic.model.Vet;
import levi9petclinic.services.OwnerService;
import levi9petclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner = new Owner();
        owner.setFirstName("Ivan");
        owner.setLastName("Tarantino");
        ownerService.save(owner);

        Owner owner2 = new Owner();
        owner2.setFirstName("Stepan");
        owner2.setLastName("Buratino");
        ownerService.save(owner2);

        System.out.println("Owners loaded");


        Vet vet = new Vet();
        vet.setFirstName("Vesela");
        vet.setLastName("Veselka");
        vetService.save(vet);

        Vet vet2 = new Vet();
        vet2.setFirstName("Sum");
        vet2.setLastName("Sumnyi");
        vetService.save(vet2);

        System.out.println("Vet loaded");
    }
}
