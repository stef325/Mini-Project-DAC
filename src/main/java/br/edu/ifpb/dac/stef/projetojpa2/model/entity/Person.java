package br.edu.ifpb.dac.stef.projetojpa2.model.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;

import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class Person implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer pId;

    private int cpf;

    private String name;
    
    private int age;


    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Person)) {
            return false;
        }
        Person person = (Person) o;
        return Objects.equals(pId, person.pId) && cpf == person.cpf && Objects.equals(name, person.name) && age == person.age;
    }

    @Override
    public int hashCode() {
        return Objects.hash(pId, cpf, name, age);
    }
    


    @Override
    public String toString() {
        return "Nome: " + getName() + ", Cpf: " + getCpf() + ", Idade: " + getAge();
    }
}
