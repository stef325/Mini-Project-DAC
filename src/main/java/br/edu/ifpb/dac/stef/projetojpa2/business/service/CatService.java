package br.edu.ifpb.dac.stef.projetojpa2.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;

import br.edu.ifpb.dac.stef.projetojpa2.model.dao.CatDAO;
import br.edu.ifpb.dac.stef.projetojpa2.model.entity.Cat;

@Service
public class CatService {
    @Autowired
    private CatDAO CatDAO;

    //create
    public void save(Cat cat){
        CatDAO.save(cat);
    }
    
    //read
    public List<Cat> find(Cat filter){
        Example<Cat> example = Example.of(filter, ExampleMatcher.matching().withIgnoreCase().withStringMatcher(StringMatcher.CONTAINING));
        return CatDAO.findAll(example);
    }

    //update
    public void update(Cat cat){
        CatDAO.save(cat);
        
    }

    //delete
    public void delete(Integer id){
        CatDAO.deleteById(id);
    }
    
    public Cat findByName(String name){
        return CatDAO.findByName(name);
    }

    
}
