package com.asia.projectForPR.ProjectForPR.Dog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class DogResource {

    @Autowired
    private DogRepository dogRepository;

    @GetMapping("/dogs")
    public List<Dog> getAllDogs() {
        return dogRepository.findAll();
    }

    @GetMapping("/dogs/{id}")
    public Dog getDog(@PathVariable long id) {
        Optional<Dog> dog = dogRepository.findById(id);

        if (!dog.isPresent())
            throw new DogNotFoundException(String.format("Dog with id %d is not found.", id));
        return dog.get();
    }

    @DeleteMapping("/dogs/{id}")
    public void deleteDog(@PathVariable long id) {
        dogRepository.deleteById(id);
    }

    @PostMapping("/students")
    public ResponseEntity<Object> createDog(@RequestBody Dog dog) {
        Dog savedDog = dogRepository.save(dog);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedDog.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

    @PutMapping("/students/{id}")
    public ResponseEntity<Object> updateDog(@RequestBody Dog dog, @PathVariable long id) {

        Optional<Dog> dogOptional = dogRepository.findById(id);

        if (!dogOptional.isPresent())
            return ResponseEntity.notFound().build();

        dog.setId(id);

        dogRepository.save(dog);

        return ResponseEntity.noContent().build();
    }
}
