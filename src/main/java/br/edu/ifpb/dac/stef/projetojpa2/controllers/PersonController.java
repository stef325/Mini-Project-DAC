package br.edu.ifpb.dac.stef.projetojpa2.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.edu.ifpb.dac.stef.projetojpa2.model.entity.Person;
import br.edu.ifpb.dac.stef.projetojpa2.model.service.PersonService;

@Controller
public class PersonController {
    
    @Autowired
    private PersonService personService;
    
    //create
    public void save(String name,int cpf,int age){
        personService.save(name,cpf,age);
    }
    
    //read
    public List<Person> list(){
       return personService.list();
    }

    //update
    public void update(int Cpf, int novaIdade, String novoNome){
        personService.update(Cpf, novoNome, novaIdade);
    }

    //delete
    public void delete(int cpf){
        personService.delete(cpf);
    }

}
