package br.edu.ifpb.dac.stef.projetojpa2.model.dao;


import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.edu.ifpb.dac.stef.projetojpa2.model.entity.Person;

@Repository
public interface PersonDAO extends PagingAndSortingRepository<Person, Integer>{
    Person findByCpf(int Cpf);
    Person findByName(String Name);

    @Transactional
    @Modifying
    @Query("update Person p set p.name = ?1, p.age = ?2 where p.cpf = ?3")
    void setPersonInfoById(String name,int age, int cpf);   
    
    @Transactional
    @Modifying
    @Query("delete Person p  where p.cpf = ?1")
    void deleteByCpf(int CPF);

}
