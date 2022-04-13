package br.edu.ifpb.dac.stef.projetojpa2.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.stereotype.Service;

import br.edu.ifpb.dac.stef.projetojpa2.model.dao.PersonDAO;
import br.edu.ifpb.dac.stef.projetojpa2.model.entity.Person;

@Service
public class PersonService {
    @Autowired
    private PersonDAO personDAO;

    //create
    public void save(Person person){
        personDAO.save(person);
    }

    //read
    public List<Person> find(Person filter){
        Example<Person> example = Example.of(filter, ExampleMatcher.matching().withIgnoreCase().withStringMatcher(StringMatcher.CONTAINING));
        return personDAO.findAll(example);
    }


    //update
    public void update(Person person){
        personDAO.save(person);
    }

    //delete
    public void delete(Integer id){
        personDAO.deleteById(id);
    }
    

    public Person getOne(Long Cpf){
        return personDAO.findByCpf(Cpf);
    }
}
