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

import br.edu.ifpb.dac.stef.projetojpa2.model.entity.Cat;
import br.edu.ifpb.dac.stef.projetojpa2.model.service.AdoptionService;
import br.edu.ifpb.dac.stef.projetojpa2.model.service.CatService;

@RestController
@RequestMapping("/api/cat")
public class CatController {
    
    @Autowired
    private CatService catService;
    
    @Autowired
    private AdoptionService adoptionService;

    //create
    @PostMapping
    public ResponseEntity save(@RequestBody Cat cat){
        try {
            catService.save(cat);
            return new ResponseEntity(cat,HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    //read
    @GetMapping
    public ResponseEntity find(
        @RequestParam(value = "age", required= false) int age,
        @RequestParam(value = "pelagem", required= false) String pelagem,
        @RequestParam(value = "name", required= false) String name,
        
        @RequestParam(value = "id", required= false) Integer id
    )
    {
        try {
            Cat filter = new Cat();
            filter.setAge(age);
            filter.setId(id);
            filter.setName(name);
            filter.setPelagem(pelagem);

            List<Cat> entities = catService.find(filter);
            return ResponseEntity.ok(entities);

        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
       
    }

    //update
    @PutMapping("{id}")
    public ResponseEntity update(@PathVariable("id") Integer id, @RequestBody Cat cat){
        try {
            cat.setId(id);
            catService.update(cat);
            return ResponseEntity.ok(cat);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        
        
    }

    
    @PostMapping("/adopt")
    public ResponseEntity adopt(@PathVariable("catName") String catName,@PathVariable("adopterCpf") int adopterCpf){
        try {
            boolean adoptstate = adoptionService.adopt(catName, adopterCpf);

            if (adoptstate = true) {
                return new ResponseEntity("Adopted",HttpStatus.CREATED);
            }
            else{
                return new ResponseEntity("need age >18",HttpStatus.NOT_ACCEPTABLE);
            }

            
            
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        
    }
    

    //delete
    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable("id") Integer id){
        try {
            catService.delete(id);  
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        
    }

    
    
    
}
