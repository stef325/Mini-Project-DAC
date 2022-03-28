package br.edu.ifpb.dac.stef.projetojpa2.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.edu.ifpb.dac.stef.projetojpa2.model.entity.Cat;
import br.edu.ifpb.dac.stef.projetojpa2.model.service.AdoptionService;
import br.edu.ifpb.dac.stef.projetojpa2.model.service.CatService;

@Controller
public class CatController {
    
    @Autowired
    private CatService catService;


  
    
    @Autowired
    private AdoptionService adoptionService;

    //create
    public void save(String nome, int idade, String pelagem){
        catService.save(nome,idade,pelagem);
    }

    //read
    public List<Cat> list(){
        return catService.list();
    }

    //update
    public void update(String nomeAtual, String novoNome,int novaIdade, String novaPelagem){
        
        catService.update(nomeAtual,novoNome,novaIdade,novaPelagem);
    }

    public void adopt(String catName, int adopterCpf){
        adoptionService.adopt(catName, adopterCpf);
    }
    

    //delete
    public void delete(Integer id){
        catService.delete(id);
    }

    
    
    
}
