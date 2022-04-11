package br.edu.ifpb.dac.stef.projetojpa2.presentation.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifpb.dac.stef.projetojpa2.model.entity.Person;
import br.edu.ifpb.dac.stef.projetojpa2.model.service.PersonService;

@RestController
@RequestMapping("/api/person")
public class PersonController {
    
    @Autowired
    private PersonService personService;
    
    //create
    @PostMapping
    public ResponseEntity save(@RequestBody Person person){
        try {
            personService.save(person);
            return new ResponseEntity(person,HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    
    //read
    @GetMapping
    public ResponseEntity find(
        @RequestParam(value = "cpf", required= false) int cpf,
        @RequestParam(value = "name", required= false) String name,
        @RequestParam(value = "age", required= false) int age,
        @RequestParam(value = "id", required= false) Integer id
    )
    {
        try {
            Person filter = new Person();
            filter.setAge(age);
            filter.setCpf(cpf);
            filter.setId(id);
            filter.setName(name);

            List<Person> entities = personService.find(filter);
            return ResponseEntity.ok(entities);

        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
       
    }

    //update
    @PutMapping("{id}")
    public ResponseEntity update(@PathVariable("id") Integer id,@RequestBody Person person){
        try {
            person.setId(id);
            personService.update(person);
            return ResponseEntity.ok(person);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    //delete
    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable("id") Integer id){
        try {
            personService.delete(id);
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
