package br.edu.ifpb.dac.stef.projetojpa2.business.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.edu.ifpb.dac.stef.projetojpa2.model.entity.Cat;
import br.edu.ifpb.dac.stef.projetojpa2.model.entity.Person;
import br.edu.ifpb.dac.stef.projetojpa2.presentation.dto.CatDTO;
import br.edu.ifpb.dac.stef.projetojpa2.presentation.dto.PersonDTO;

@Service
public class ConverterService {
    
    public PersonDTO PersonToDTO(Person person){
        PersonDTO dto = new PersonDTO();
        dto.setAge(person.getAge());
        dto.setId(person.getId());
        dto.setName(person.getName());

        return dto;
    }

    public Person DTOToPerson(PersonDTO dto){
        Person person = new Person();
        person.setAge(dto.getAge());
        person.setId(dto.getId());
        person.setName(dto.getName());
        person.setCpf(dto.getCpf());

        return person;
    }
    
    public List<PersonDTO> PersonToDTO(List<Person> personArr){
        List<PersonDTO> dtos = new ArrayList<>();

        for (Person person : personArr) {
            PersonDTO dto = PersonToDTO(person);
            dtos.add(dto);
        }
        return dtos;

    }

    public List<Person> DTOToPerson(List<PersonDTO> dtos){
        List<Person> personArr = new ArrayList<>();

        for (PersonDTO dto : dtos) {
            Person person = DTOToPerson(dto);
            personArr.add(person);
        }
        return personArr;
    }
    /*-------------------*/

    public CatDTO CatToDTO(Cat cat){
        CatDTO dto = new CatDTO();
        dto.setAge(cat.getAge());
        dto.setId(cat.getId());
        dto.setName(cat.getName());
        dto.setPelagem(cat.getPelagem());
        Person dono = cat.getDono();
        dto.setDono(dono==null? "Sem dono": dono.getName());

        return dto;
    }

    public Cat DTOToCat(CatDTO dto){
        Cat cat = new Cat();
        cat.setId(dto.getId());
        cat.setAge(dto.getAge());
        cat.setName(dto.getName());
        cat.setPelagem(dto.getPelagem());
        return cat;
    }
    
    public List<CatDTO> CatToDTO(List<Cat> catArr){
        List<CatDTO> dtos = new ArrayList<>();

        for (Cat cat : catArr) {
            CatDTO dto = CatToDTO(cat);
            dtos.add(dto);
        }
        return dtos;

    }

    public List<Cat> DTOToCat(List<CatDTO> dtos){
        List<Cat> catArr = new ArrayList<>();

        for (CatDTO dto : dtos) {
            Cat cat = DTOToCat(dto);
            catArr.add(cat);
        }
        return catArr;
    }
}
