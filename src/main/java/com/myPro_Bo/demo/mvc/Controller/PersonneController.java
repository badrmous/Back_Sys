package com.myPro_Bo.demo.mvc.Controller;

import com.myPro_Bo.demo.mvc.Model.Personne;
import com.myPro_Bo.demo.mvc.Repository.PersonneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/personne")
public class PersonneController {
    @Autowired
    private PersonneRepository personneRepository;

    @GetMapping("/liste")
    public ResponseEntity<List<Personne>> getAll(){
        try {
            List<Personne> personnes = personneRepository.findAll();
            return new ResponseEntity<>(personnes , HttpStatus.ACCEPTED);
        }
        catch (Exception e){
            System.out.println("Exception in getting liste of personnes : "+e);
            return new ResponseEntity<>(null ,HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/new")
    public ResponseEntity<Personne> create(@RequestBody Personne personne){
        try {
            personneRepository.save(personne);
            return new ResponseEntity<>(personne , HttpStatus.OK);
        }
        catch (Exception e){
            System.out.println("exception in creating personne");
            return new ResponseEntity<>(null , HttpStatus.BAD_REQUEST);
        }
    }
    @PutMapping("/edit")
    public ResponseEntity<Personne> edit(@RequestBody Personne personne){
        try {
            personneRepository.save(personne);
            return new ResponseEntity<>(personne , HttpStatus.OK);
        }
        catch (Exception e){
            System.out.println("exception in editing personne : "+e);
            return new ResponseEntity<>(null , HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        try {
            personneRepository.deleteById(id);
            return new ResponseEntity(HttpStatus.OK);
        }
        catch (Exception e){
            System.out.println("Exception in deleting personne "+ e);
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }
}
