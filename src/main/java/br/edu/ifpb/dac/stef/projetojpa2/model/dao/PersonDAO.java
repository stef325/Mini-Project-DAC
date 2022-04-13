package br.edu.ifpb.dac.stef.projetojpa2.model.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifpb.dac.stef.projetojpa2.model.entity.Person;

@Repository
public interface PersonDAO extends JpaRepository<Person, Integer>{
    Person findByCpf(Long Cpf);
    Person findByName(String Name);



}
