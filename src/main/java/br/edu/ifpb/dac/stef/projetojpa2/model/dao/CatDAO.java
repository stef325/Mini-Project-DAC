package br.edu.ifpb.dac.stef.projetojpa2.model.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.edu.ifpb.dac.stef.projetojpa2.model.entity.Cat;
import br.edu.ifpb.dac.stef.projetojpa2.model.entity.Person;

@Repository
public interface CatDAO extends JpaRepository<Cat,Integer>{
    

    Cat findByName(String catName);
    
    @Transactional
    @Modifying
    @Query("update Cat c set c.dono = ?1 where c.name = ?2")
    void setCatDonoById(Person newOwner, String catName);

}
