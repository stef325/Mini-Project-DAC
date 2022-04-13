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

import br.edu.ifpb.dac.stef.projetojpa2.business.service.ConverterService;
import br.edu.ifpb.dac.stef.projetojpa2.business.service.PersonService;
import br.edu.ifpb.dac.stef.projetojpa2.model.entity.Person;
import br.edu.ifpb.dac.stef.projetojpa2.presentation.dto.PersonDTO;

@RestController
@RequestMapping("/api/person")
public class PersonController {
    @Autowired
    private ConverterService converter;

    @Autowired
    private PersonService personService;
    
    //create
    @PostMapping
    public ResponseEntity save(@RequestBody PersonDTO dto){
        try {
            Person entity = converter.DTOToPerson(dto);
            personService.save(entity);
            dto = converter.PersonToDTO(entity);

            return new ResponseEntity(dto,HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    
    //read
    @GetMapping
    public ResponseEntity find(
        @RequestParam(value = "cpf", required= false) Long cpf,
        @RequestParam(value = "name", required= false) String name,
        @RequestParam(value = "age", required= false) Integer age,
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
            List<PersonDTO> dtos = converter.PersonToDTO(entities);
            return ResponseEntity.ok(dtos);

        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
       
    }

    //update
    @PutMapping("{id}")
    public ResponseEntity update(@PathVariable("id") Integer id,@RequestBody PersonDTO dto){
        try {
            dto.setId(id);
            Person entity = converter.DTOToPerson(dto);
            personService.update(entity);
            dto = converter.PersonToDTO(entity);

            return ResponseEntity.ok(dto);
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
