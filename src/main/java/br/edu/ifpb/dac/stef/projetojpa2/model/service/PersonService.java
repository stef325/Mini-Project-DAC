package br.edu.ifpb.dac.stef.projetojpa2.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifpb.dac.stef.projetojpa2.model.dao.PersonDAO;
import br.edu.ifpb.dac.stef.projetojpa2.model.entity.Person;

@Service
public class PersonService {
    @Autowired
    private PersonDAO personDAO;

    //create
    public void save(String name,int cpf,int age){
        Person person = new Person();
        person.setAge(age);
        person.setName(name);
        person.setCpf(cpf);

        personDAO.save(person);
    }

    //read
    public List<Person> list(){
        return (List<Person>) personDAO.findAll();
    }

    //update
    public void update(int Cpf, String newName, int newAge){
        personDAO.setPersonInfoById(newName,newAge,Cpf );
    }

    //delete
    public void delete(int cpf){
        personDAO.deleteByCpf(cpf);
    }
    

    public Person getOne(int Cpf){
        return personDAO.findByCpf(Cpf);
    }
}
