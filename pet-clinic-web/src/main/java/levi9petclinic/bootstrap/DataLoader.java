package levi9petclinic.bootstrap;

import java.time.LocalDate;
import levi9petclinic.model.Owner;
import levi9petclinic.model.Pet;
import levi9petclinic.model.PetType;
import levi9petclinic.model.Speciality;
import levi9petclinic.model.Vet;
import levi9petclinic.model.Visit;
import levi9petclinic.services.OwnerService;
import levi9petclinic.services.PetTypeService;
import levi9petclinic.services.SpecialtyService;
import levi9petclinic.services.VetService;
import levi9petclinic.services.VisitService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtyService;
    private final VisitService visitService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService,
        SpecialtyService specialtyService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {
        int size = petTypeService.findAll().size();
        if (size == 0) {
            loadData();
        }
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType dogPetTypeSaved = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType catPetTypeSaved = petTypeService.save(cat);

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadiology = specialtyService.save(radiology);

        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");
        Speciality savedSurgery = specialtyService.save(surgery);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("Dentistry");
        Speciality savedDentistry = specialtyService.save(dentistry);

        Owner owner = new Owner();
        owner.setFirstName("Ivan");
        owner.setLastName("Tarantino");
        owner.setAddress("vul.Svobody");
        owner.setCity("Rivne");
        owner.setTelephone("221188");

        Pet ivanPet = new Pet();
        ivanPet.setName("Barko");
        ivanPet.setOwner(owner);
        ivanPet.setBirthday(LocalDate.now());
        ivanPet.setPetType(dogPetTypeSaved);
        owner.getPets().add(ivanPet);

        ownerService.save(owner);

        Owner owner2 = new Owner();
        owner2.setFirstName("Stepan");
        owner2.setLastName("Buratino");
        owner2.setAddress("vul.Svobody");
        owner2.setCity("Rivne");
        owner2.setTelephone("221188");

        Pet stepanPet = new Pet();
        stepanPet.setName("Murko");
        stepanPet.setOwner(owner2);
        stepanPet.setBirthday(LocalDate.now());
        stepanPet.setPetType(catPetTypeSaved);
        owner2.getPets().add(stepanPet);

        ownerService.save(owner2);

        Visit murkoVisit = new Visit();
        murkoVisit.setPet(stepanPet);
        murkoVisit.setVisitTime(LocalDate.now());
        murkoVisit.setDescription("Diareya");

        visitService.save(murkoVisit);

        System.out.println("Owners loaded");

        Vet vet = new Vet();
        vet.setFirstName("Vesela");
        vet.setLastName("Veselka");
        vet.getSpecialities().add(savedRadiology);
        vetService.save(vet);

        Vet vet2 = new Vet();
        vet2.setFirstName("Sum");
        vet2.setLastName("Sumnyi");
        vet.getSpecialities().add(savedSurgery);
        vetService.save(vet2);

        System.out.println("Vet loaded");
    }
}
