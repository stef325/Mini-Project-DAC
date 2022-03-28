package br.edu.ifpb.dac.stef.projetojpa2.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifpb.dac.stef.projetojpa2.model.dao.CatDAO;
import br.edu.ifpb.dac.stef.projetojpa2.model.entity.Cat;

@Service
public class CatService {
    @Autowired
    private CatDAO CatDAO;

    //create
    public void save(String nome, int idade, String pelagem){
        Cat cat = new Cat();
        cat.setAge(idade);
        cat.setName(nome);
        cat.setPelagem(pelagem);

        CatDAO.save(cat);
    }
    
    //read
    public List<Cat> list(){
        return (List<Cat>) CatDAO.findAll();
    }

    //update
    public void update(String nome, String newName, int newAge, String newPelagem){
        CatDAO.setCatInfoById(newName,newAge,newPelagem,nome);
        
    }

    //delete
    public void delete(Integer id){
        CatDAO.deleteById(id);
    }
    
    public Cat findByName(String name){
        return CatDAO.findByName(name);
    }

    
}
